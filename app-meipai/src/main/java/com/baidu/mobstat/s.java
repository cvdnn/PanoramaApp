package com.baidu.mobstat;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidubce.http.Headers;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import e.a.a.a.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class s {

    /* renamed from: a reason: collision with root package name */
    public static String f1890a = "https://openrcv.baidu.com/1010/bplus.gif";

    /* renamed from: b reason: collision with root package name */
    public static s f1891b;

    /* renamed from: c reason: collision with root package name */
    public Handler f1892c;

    public s() {
        HandlerThread handlerThread = new HandlerThread("LogSender");
        handlerThread.start();
        this.f1892c = new Handler(handlerThread.getLooper());
    }

    private boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!bw.c().booleanValue()) {
                return true;
            }
            try {
                a(context, f1890a, str);
                return true;
            } catch (Exception e2) {
                bb.c().c((Throwable) e2);
            }
        }
        return false;
    }

    public static s a() {
        if (f1891b == null) {
            synchronized (s.class) {
                if (f1891b == null) {
                    f1891b = new s();
                }
            }
        }
        return f1891b;
    }

    public void a(final Context context, final String str) {
        bb c2 = bb.c();
        StringBuilder sb = new StringBuilder();
        sb.append("data = ");
        sb.append(str);
        c2.a(sb.toString());
        if (str != null && !"".equals(str)) {
            this.f1892c.post(new Runnable() {
                public void run() {
                    try {
                        s.this.a(str);
                        if (context != null) {
                            s.this.a(context.getApplicationContext());
                        }
                    } catch (Throwable th) {
                        bb.c().b(th);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        StringBuilder a2 = a.a("backups/system");
        a2.append(File.separator);
        a2.append("__send_log_data_");
        a2.append(System.currentTimeMillis());
        bo.a(a2.toString(), str, false);
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        if ("mounted".equals(bo.a())) {
            String str = "backups/system";
            File file = new File(Environment.getExternalStorageDirectory(), str);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    try {
                        Arrays.sort(listFiles, new Comparator<File>() {
                            /* renamed from: a */
                            public int compare(File file, File file2) {
                                return (int) (file2.lastModified() - file.lastModified());
                            }
                        });
                    } catch (Exception e2) {
                        bb.c().b((Throwable) e2);
                    }
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            String name = file2.getName();
                            if (!TextUtils.isEmpty(name) && name.startsWith("__send_log_data_")) {
                                String a2 = a.a(a.a(str), File.separator, name);
                                String b2 = bo.b(a2);
                                if (b(context, b2)) {
                                    bo.c(a2);
                                    i2 = 0;
                                } else {
                                    a(b2, a2);
                                    i2++;
                                    if (i2 >= 5) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
            }
            JSONObject a2 = h.a(jSONObject);
            if (a2 != null) {
                h.b(a2);
                bo.a(str2, jSONObject.toString(), false);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private String a(Context context, String str, String str2) throws IOException {
        byte[] bArr;
        String str3 = str2;
        boolean z = !str.startsWith("https:");
        HttpURLConnection d2 = bo.d(context, str);
        d2.setDoOutput(true);
        d2.setInstanceFollowRedirects(false);
        d2.setUseCaches(false);
        String str4 = DecompressionHelper.GZIP_ENCODING;
        d2.setRequestProperty(Headers.CONTENT_ENCODING, str4);
        try {
            JSONObject jSONObject = new JSONObject(str3).getJSONArray("payload").getJSONObject(0).getJSONObject(Config.HEADER_PART);
            d2.setRequestProperty("Content-Type", str4);
            d2.setRequestProperty("mtj_appversion", jSONObject.getString("n"));
            d2.setRequestProperty("mtj_os", "Android");
            d2.setRequestProperty("mtj_pn", jSONObject.getString(Config.PACKAGE_NAME));
            d2.setRequestProperty("mtj_tg", "1");
            d2.setRequestProperty("mtj_ii", jSONObject.getString(Config.CUID_SEC));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d2.connect();
        try {
            OutputStream outputStream = d2.getOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            gZIPOutputStream.write(new byte[]{72, 77, 48, Framer.STDOUT_FRAME_PREFIX});
            gZIPOutputStream.write(new byte[]{0, 0, 0, 1});
            gZIPOutputStream.write(new byte[]{0, 0, 3, -14});
            gZIPOutputStream.write(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
            gZIPOutputStream.write(new byte[]{0, 2});
            if (z) {
                gZIPOutputStream.write(new byte[]{0, 1});
            } else {
                gZIPOutputStream.write(new byte[]{0, 0});
            }
            gZIPOutputStream.write(new byte[]{72, 77, 48, Framer.STDOUT_FRAME_PREFIX});
            String str5 = "utf-8";
            if (z) {
                byte[] a2 = bm.a.a();
                byte[] a3 = bv.a(false, br.a(), a2);
                String str6 = str5;
                gZIPOutputStream.write(a((long) a3.length, 4));
                gZIPOutputStream.write(a3);
                bArr = bm.a.a(a2, new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, str3.getBytes(str6));
                gZIPOutputStream.write(a((long) bArr.length, 2));
            } else {
                bArr = str3.getBytes(str5);
            }
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            outputStream.close();
            int responseCode = d2.getResponseCode();
            int contentLength = d2.getContentLength();
            bb c2 = bb.c();
            StringBuilder sb = new StringBuilder();
            sb.append("code: ");
            sb.append(responseCode);
            sb.append("; len: ");
            sb.append(contentLength);
            c2.c(sb.toString());
            if (responseCode == 200 && contentLength == 0) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(d2.getInputStream()));
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String sb3 = sb2.toString();
                        d2.disconnect();
                        return sb3;
                    }
                    sb2.append(readLine);
                }
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Response code = ");
                sb4.append(d2.getResponseCode());
                throw new IOException(sb4.toString());
            }
        } catch (Exception e3) {
            bb.c().b((Throwable) e3);
            d2.disconnect();
            return "";
        } catch (Throwable th) {
            d2.disconnect();
            throw th;
        }
    }

    public static byte[] a(long j2, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[(i2 - i3) - 1] = (byte) ((int) (255 & j2));
            j2 >>= 8;
        }
        return bArr;
    }
}
