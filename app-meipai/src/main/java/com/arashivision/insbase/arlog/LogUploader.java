package com.arashivision.insbase.arlog;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class LogUploader {
    public static final int ERR_COLLECT = -1;
    public static final int ERR_UPLOAD = -2;
    public static final String TAG = "LogUploader";

    public static class LogTask {
        public WeakReference<Context> context;
        public HashMap<String, String> fields = new HashMap<>();
        public Handler handler;
        public Listener listener;
        public int maxSize;
        public String url;

        public interface Listener {
            void onComplete(LogTask logTask, int i2);
        }

        public LogTask(Context context2, String str, int i2) {
            this.context = new WeakReference<>(context2);
            this.url = str;
            this.maxSize = i2;
        }

        public void setField(String str, String str2) {
            this.fields.put(str, str2);
        }

        public void setListener(Handler handler2, Listener listener2) {
            this.handler = handler2;
            this.listener = listener2;
        }
    }

    public static void deleteFile(String str) {
        new File(str).delete();
    }

    public static void notifyComplete(final LogTask logTask, final int i2) {
        if (logTask.listener == null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    Context context = (Context) logTask.context.get();
                    if (context == null) {
                        Log.w(LogUploader.TAG, "context destroyed, no log result toast");
                    }
                    int i2 = i2;
                    if (i2 == 0) {
                        Toast.makeText(context, "upload log success", 1).show();
                    } else if (i2 == -1) {
                        Toast.makeText(context, "failed collect log", 1).show();
                    } else {
                        Toast.makeText(context, "failed upload log", 1).show();
                    }
                }
            });
        } else {
            logTask.handler.post(new Runnable() {
                public void run() {
                    LogTask logTask = logTask;
                    logTask.listener.onComplete(logTask, i2);
                }
            });
        }
    }

    public static void postLog(final LogTask logTask) {
        Context context = (Context) logTask.context.get();
        String str = TAG;
        if (context == null) {
            Log.e(str, "context invalid");
            return;
        }
        Log.i(str, "post log");
        final File file = new File(context.getCacheDir(), "log");
        file.mkdir();
        new Thread() {
            public void run() {
                String str = LogUploader.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(Build.MANUFACTURER);
                String str2 = "-";
                sb.append(str2);
                sb.append(Build.MODEL);
                sb.append(str2);
                sb.append(new SimpleDateFormat("MM_dd_HH_mm_ss_SSS").format(new Date()));
                sb.append(".log");
                String absolutePath = new File(file, sb.toString()).getAbsolutePath();
                try {
                    Log.collectLog(absolutePath, logTask.maxSize);
                    MultipartUtility multipartUtility = new MultipartUtility(logTask.url);
                    for (Entry entry : logTask.fields.entrySet()) {
                        multipartUtility.addFormField((String) entry.getKey(), (String) entry.getKey());
                    }
                    try {
                        multipartUtility.addFilePart(SdkConfigOptions.KEY_SO_FILE, absolutePath).commit();
                        LogUploader.notifyComplete(logTask, 0);
                        LogUploader.deleteFile(absolutePath);
                    } catch (IOException e2) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("failed post log file: ");
                        sb2.append(e2);
                        sb2.append(". (");
                        sb2.append(absolutePath);
                        sb2.append(")");
                        Log.e(str, sb2.toString());
                        LogUploader.notifyComplete(logTask, -2);
                    }
                } catch (IOException e3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("failed collect log: ");
                    sb3.append(e3);
                    Log.e(str, sb3.toString());
                    LogUploader.notifyComplete(logTask, -1);
                }
            }
        }.start();
    }
}
