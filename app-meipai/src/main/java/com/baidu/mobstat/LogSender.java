package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.bm.a;
import com.baidu.sapi2.views.SmsLoginView.f;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class LogSender {

    /* renamed from: a reason: collision with root package name */
    public static LogSender f1429a = new LogSender();

    /* renamed from: b reason: collision with root package name */
    public boolean f1430b = false;

    /* renamed from: c reason: collision with root package name */
    public int f1431c = 0;

    /* renamed from: d reason: collision with root package name */
    public int f1432d = 1;

    /* renamed from: e reason: collision with root package name */
    public SendStrategyEnum f1433e = SendStrategyEnum.APP_START;

    /* renamed from: f reason: collision with root package name */
    public Timer f1434f;

    /* renamed from: g reason: collision with root package name */
    public Handler f1435g;

    public LogSender() {
        HandlerThread handlerThread = new HandlerThread("LogSenderThread");
        handlerThread.start();
        this.f1435g = new Handler(handlerThread.getLooper());
    }

    private String e(Context context, String str, String str2) throws Exception {
        HttpURLConnection d2 = bo.d(context, str);
        d2.setDoOutput(true);
        d2.setInstanceFollowRedirects(false);
        d2.setUseCaches(false);
        d2.setRequestProperty("Content-Type", DecompressionHelper.GZIP_ENCODING);
        byte[] a2 = a.a();
        byte[] b2 = a.b();
        d2.setRequestProperty("key", bv.a(a2));
        d2.setRequestProperty("iv", bv.a(b2));
        byte[] a3 = a.a(a2, b2, str2.getBytes("utf-8"));
        d2.connect();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(d2.getOutputStream());
            gZIPOutputStream.write(a3);
            gZIPOutputStream.flush();
            gZIPOutputStream.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d2.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d2.getContentLength();
            if (d2.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http code = ");
            sb2.append(d2.getResponseCode());
            sb2.append("; contentResponse = ");
            sb2.append(sb);
            throw new IOException(sb2.toString());
        } finally {
            d2.disconnect();
        }
    }

    public static LogSender instance() {
        return f1429a;
    }

    public void onSend(final Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        if (context != null) {
            this.f1435g.post(new Runnable() {
                public void run() {
                    if (LogSender.this.f1434f != null) {
                        LogSender.this.f1434f.cancel();
                        LogSender.this.f1434f = null;
                    }
                    LogSender.this.f1433e = SendStrategyEnum.values()[bq.a().b(context)];
                    LogSender.this.f1432d = bq.a().c(context);
                    LogSender.this.f1430b = bq.a().d(context);
                    if (LogSender.this.f1433e.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
                        LogSender.this.setSendingLogTimer(context);
                    } else if (LogSender.this.f1433e.equals(SendStrategyEnum.ONCE_A_DAY)) {
                        LogSender.this.setSendingLogTimer(context);
                    }
                    LogSender.this.f1435g.postDelayed(new Runnable() {
                        public void run() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            LogSender.this.a(context);
                        }
                    }, (long) (LogSender.this.f1431c * 1000));
                }
            });
        }
    }

    public void saveLogData(Context context, String str, boolean z) {
        String str2 = Config.PREFIX_SEND_DATA_FULL;
        StringBuilder a2 = e.a.a.a.a.a(z ? str2 : Config.PREFIX_SEND_DATA);
        a2.append(System.currentTimeMillis());
        bo.a(context, a2.toString(), str, false);
        if (z) {
            a(context, (long) Config.FULL_TRACE_LOG_LIMIT, str2);
        }
    }

    public void sendEmptyLogData(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        this.f1435g.post(new Runnable() {
            public void run() {
                String constructLogWithEmptyBody = DataCore.instance().constructLogWithEmptyBody(applicationContext, str);
                if (!TextUtils.isEmpty(constructLogWithEmptyBody)) {
                    LogSender.this.c(applicationContext, constructLogWithEmptyBody);
                }
            }
        });
    }

    public void sendLogData(Context context, final String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            final Context applicationContext = context.getApplicationContext();
            if (z) {
                b(applicationContext, str);
            } else {
                this.f1435g.post(new Runnable() {
                    public void run() {
                        LogSender.this.b(applicationContext, str);
                    }
                });
            }
        }
    }

    public void setLogSenderDelayed(int i2) {
        if (i2 >= 0 && i2 <= 30) {
            this.f1431c = i2;
        }
    }

    public void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        if (!sendStrategyEnum.equals(SendStrategyEnum.SET_TIME_INTERVAL)) {
            this.f1433e = sendStrategyEnum;
            bq.a().a(context, this.f1433e.ordinal());
            if (sendStrategyEnum.equals(SendStrategyEnum.ONCE_A_DAY)) {
                bq.a().b(context, 24);
            }
        } else if (i2 > 0 && i2 <= 24) {
            this.f1432d = i2;
            this.f1433e = SendStrategyEnum.SET_TIME_INTERVAL;
            bq.a().a(context, this.f1433e.ordinal());
            bq.a().b(context, this.f1432d);
        }
        this.f1430b = z;
        bq.a().a(context, this.f1430b);
    }

    public void setSendingLogTimer(Context context) {
        final Context applicationContext = context.getApplicationContext();
        long j2 = (long) (this.f1432d * 3600000);
        try {
            Timer timer = new Timer();
            this.f1434f = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    LogSender.this.a(applicationContext);
                }
            }, j2, j2);
        } catch (Exception unused) {
        }
    }

    private String d(Context context, String str, String str2) throws IOException {
        HttpURLConnection d2 = bo.d(context, str);
        d2.setDoOutput(true);
        d2.setInstanceFollowRedirects(false);
        d2.setUseCaches(false);
        d2.setRequestProperty("Content-Type", DecompressionHelper.GZIP_ENCODING);
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject(Config.HEADER_PART);
            d2.setRequestProperty("mtj_appkey", jSONObject.getString(Config.APP_KEY));
            d2.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d2.setRequestProperty("mtj_os", jSONObject.getString(Config.OS));
            d2.setRequestProperty("mtj_pn", jSONObject.getString(Config.PACKAGE_NAME));
            d2.setRequestProperty("mtj_tg", jSONObject.getString(Config.SDK_TAG));
            d2.setRequestProperty("mtj_ii", jSONObject.getString(Config.CUID_SEC));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d2.connect();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(d2.getOutputStream())));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d2.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            int contentLength = d2.getContentLength();
            if (d2.getResponseCode() == 200 && contentLength == 0) {
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http code = ");
            sb2.append(d2.getResponseCode());
            sb2.append("; contentResponse = ");
            sb2.append(sb);
            throw new IOException(sb2.toString());
        } finally {
            d2.disconnect();
        }
    }

    /* access modifiers changed from: private */
    public void b(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Config.PREFIX_SEND_DATA);
        sb.append(System.currentTimeMillis());
        String sb2 = sb.toString();
        bo.a(context, sb2, str, false);
        if (c(context, str)) {
            bo.b(context, sb2);
        } else {
            b(context, sb2, str);
        }
    }

    /* access modifiers changed from: private */
    public boolean c(Context context, String str) {
        return a(context, str, false);
    }

    private String c(Context context, String str, String str2) throws Exception {
        if (!str.startsWith("https://")) {
            return e(context, str, str2);
        }
        return d(context, str, str2);
    }

    public static void b(Context context, String str, String str2) {
        JSONObject jSONObject;
        String str3 = Config.TRACE_FAILED_CNT;
        try {
            jSONObject = new JSONObject(str2);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = (JSONObject) jSONObject.get(Config.TRACE_PART);
                jSONObject2.put(str3, jSONObject2.getLong(str3) + 1);
            } catch (Exception unused2) {
            }
            bo.a(context, str, jSONObject.toString(), false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r4 == null) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r8, long r9, java.lang.String r11) {
        /*
            r7 = this;
            java.util.ArrayList r11 = r7.a(r8, r11)
            int r0 = r11.size()
            int r0 = r0 + -1
            r1 = 0
            r2 = 0
            r4 = r1
        L_0x000e:
            if (r0 < 0) goto L_0x0036
            java.lang.Object r5 = r11.get(r0)     // Catch:{ Exception -> 0x0028, all -> 0x0021 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0028, all -> 0x0021 }
            java.io.FileInputStream r4 = r8.openFileInput(r5)     // Catch:{ Exception -> 0x0028, all -> 0x0021 }
            int r5 = r4.available()     // Catch:{ Exception -> 0x0028, all -> 0x0021 }
            long r5 = (long) r5
            long r2 = r2 + r5
            goto L_0x002a
        L_0x0021:
            r8 = move-exception
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            throw r8
        L_0x0028:
            if (r4 == 0) goto L_0x002e
        L_0x002a:
            r4.close()     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            r4 = r1
        L_0x002e:
            int r5 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0033
            goto L_0x0036
        L_0x0033:
            int r0 = r0 + -1
            goto L_0x000e
        L_0x0036:
            r9 = 0
        L_0x0037:
            if (r9 > r0) goto L_0x0045
            java.lang.Object r10 = r11.get(r9)
            java.lang.String r10 = (java.lang.String) r10
            com.baidu.mobstat.bo.b(r8, r10)
            int r9 = r9 + 1
            goto L_0x0037
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.LogSender.a(android.content.Context, long, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public ArrayList<String> a(Context context, final String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (context == null) {
            return arrayList;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null && filesDir.exists()) {
            AnonymousClass3 r1 = new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(str);
                }
            };
            String[] strArr = null;
            try {
                strArr = filesDir.list(r1);
            } catch (Exception unused) {
            }
            if (!(strArr == null || strArr.length == 0)) {
                try {
                    Arrays.sort(strArr, new Comparator<String>() {
                        /* renamed from: a */
                        public int compare(String str, String str2) {
                            return str.compareTo(str2);
                        }
                    });
                } catch (Exception unused2) {
                }
                for (String add : strArr) {
                    arrayList.add(add);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(final Context context) {
        if (!this.f1430b || bw.q(context)) {
            this.f1435g.post(new Runnable() {
                public void run() {
                    String str = Config.PREFIX_SEND_DATA_FULL;
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(LogSender.this.a(context, Config.PREFIX_SEND_DATA));
                        arrayList.addAll(LogSender.this.a(context, str));
                        Iterator it = arrayList.iterator();
                        while (true) {
                            int i2 = 0;
                            while (it.hasNext()) {
                                String str2 = (String) it.next();
                                String a2 = bo.a(context, str2);
                                if (TextUtils.isEmpty(a2)) {
                                    bo.b(context, str2);
                                } else {
                                    if (LogSender.this.a(context, a2, str2.contains(str))) {
                                        bo.b(context, str2);
                                    } else {
                                        LogSender.b(context, str2, a2);
                                        i2++;
                                        if (i2 >= 5) {
                                            return;
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public boolean a(Context context, String str, boolean z) {
        if (!z) {
            bc.c().a(e.a.a.a.a.a("Start send log \n", str));
        }
        boolean z2 = false;
        if (!this.f1430b || bw.q(context)) {
            String str2 = Config.LOG_SEND_URL;
            if (z) {
                str2 = Config.LOG_FULL_SEND_URL;
            }
            try {
                c(context, str2, str);
                z2 = true;
            } catch (Exception e2) {
                bc.c().c((Throwable) e2);
            }
            if (!z) {
                bc.c().a(e.a.a.a.a.a("Send log ", z2 ? f.k : "failed"));
            }
            return z2;
        }
        bc.c().a("[WARNING] wifi not available, log will be cached, next time will try to resend");
        return false;
    }
}
