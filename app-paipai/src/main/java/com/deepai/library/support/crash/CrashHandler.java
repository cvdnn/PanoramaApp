package com.deepai.library.support.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public class CrashHandler implements UncaughtExceptionHandler {
    private static CrashHandler INSTANCE = new CrashHandler();
    public static final String TAG = "CrashHandler";
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault());
    private Map<String, String> infos = new HashMap();
    /* access modifiers changed from: private */
    public Context mContext;
    private UncaughtExceptionHandler mDefaultHandler;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context context) {
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable ex) {
        if (handleException(ex) || this.mDefaultHandler == null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Log.e(TAG, "error : ", e);
            }
            Process.killProcess(Process.myPid());
            System.exit(1);
            return;
        }
        this.mDefaultHandler.uncaughtException(thread, ex);
    }

    private boolean handleException(Throwable ex) {
        if (ex == null) {
            return false;
        }
        new Thread() {
            public void run() {
                Looper.prepare();
                Toast.makeText(CrashHandler.this.mContext, "很抱歉,程序出现异常,即将退出", 1).show();
                Looper.loop();
            }
        }.start();
        collectDeviceInfo(this.mContext);
        saveCrashInfo2File(ex);
        return true;
    }

    public void collectDeviceInfo(Context ctx) {
        Field[] fields;
        try {
            PackageInfo pi = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 1);
            if (pi != null) {
                String versionCode = pi.versionCode + "";
                this.infos.put("versionName", pi.versionName == null ? "null" : pi.versionName);
                this.infos.put("versionCode", versionCode);
            }
        } catch (NameNotFoundException e) {
            Log.e(TAG, "an error occured when collect package info", e);
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.infos.put(field.getName(), field.get(null).toString());
                Log.d(TAG, field.getName() + " : " + field.get(null));
            } catch (Exception e2) {
                Log.e(TAG, "an error occured when collect crash info", e2);
            }
        }
    }

    private String saveCrashInfo2File(Throwable ex) {
        StringBuffer sb = new StringBuffer();
        for (Entry<String, String> entry : this.infos.entrySet()) {
            String value = (String) entry.getValue();
            sb.append(((String) entry.getKey()) + "=" + value + "\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        ex.printStackTrace(printWriter);
        for (Throwable cause = ex.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        sb.append(stringWriter.toString());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String fileName = "paipai-crash-" + this.formatter.format(new Date()) + ".log";
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return fileName;
            }
            String path = Environment.getExternalStorageDirectory().getPath() + "/deepaiCrash/";
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(path + fileName);
            fos.write(sb.toString().getBytes());
            fos.close();
            return fileName;
        } catch (Exception e) {
            Log.e(TAG, "an error occured while writing file...", e);
            return null;
        }
    }
}
