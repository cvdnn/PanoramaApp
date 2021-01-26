package e.c.b.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.arashivision.arvbmg.render.camera.HeadTrackerController;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.BceConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import e.c.b.d;
import e.c.b.f.a;
import e.c.d.i.b.h;
import e.c.d.i.b.j;
import e.c.d.i.b.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public final class Utils {

    /* renamed from: a reason: collision with root package name */
    public static TelephonyManager f5908a;

    /* renamed from: b reason: collision with root package name */
    public static ConnectivityManager f5909b;

    /* renamed from: c reason: collision with root package name */
    public static Context f5910c;

    /* renamed from: d reason: collision with root package name */
    public static Context f5911d;

    /* renamed from: e reason: collision with root package name */
    public static PackageManager f5912e;

    /* renamed from: f reason: collision with root package name */
    public static PackageInfo packageInfo;

    /* renamed from: g reason: collision with root package name */
    public static String f5914g;

    /* renamed from: h reason: collision with root package name */
    public static SimpleDateFormat f5915h;

    /* renamed from: i reason: collision with root package name */
    public static PackageManager packageManager;

    /* renamed from: j reason: collision with root package name */
    public static Context context;
    public static SharedPreferences sharedPreferences;

    public static String a() {
        String str = "UNKNOWN";
        try {
            if (f5909b == null) {
                f5909b = (ConnectivityManager) f5910c.getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = f5909b.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            if (!activeNetworkInfo.isConnected()) {
                return "NONE";
            }
            str = activeNetworkInfo.getTypeName().toUpperCase();
            return str;
        } catch (RuntimeException unused) {
        }
    }

    public static String a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("batvn", "7.5.0");
            jSONObject.put(LogBuilder.KEY_APPKEY, d.f5880d);
            String str3 = "appvn";
            if (TextUtils.isEmpty(str2)) {
                str2 = d();
            }
            jSONObject.put(str3, str2);
            jSONObject.put("apiType", str);
            StringBuilder sb = new StringBuilder("agent is ");
            sb.append(jSONObject.toString());
            a.a(sb.toString());
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.DataOutputStream] */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.DataOutputStream] */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v5 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r10v9, types: [java.io.DataOutputStream] */
    /* JADX WARNING: type inference failed for: r11v12 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r11v13 */
    /* JADX WARNING: type inference failed for: r2v29 */
    /* JADX WARNING: type inference failed for: r11v14 */
    /* JADX WARNING: type inference failed for: r2v30 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r11v15 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: type inference failed for: r11v19 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r2v35 */
    /* JADX WARNING: type inference failed for: r11v20 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r2v36 */
    /* JADX WARNING: type inference failed for: r11v21, types: [java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r11v22 */
    /* JADX WARNING: type inference failed for: r11v23, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARNING: type inference failed for: r2v38, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v17 */
    /* JADX WARNING: type inference failed for: r11v24 */
    /* JADX WARNING: type inference failed for: r2v40 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r11v25 */
    /* JADX WARNING: type inference failed for: r11v26 */
    /* JADX WARNING: type inference failed for: r11v27 */
    /* JADX WARNING: type inference failed for: r2v41 */
    /* JADX WARNING: type inference failed for: r11v28 */
    /* JADX WARNING: type inference failed for: r2v42 */
    /* JADX WARNING: type inference failed for: r11v29 */
    /* JADX WARNING: type inference failed for: r11v30 */
    /* JADX WARNING: type inference failed for: r11v31 */
    /* JADX WARNING: type inference failed for: r11v32 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r11v33 */
    /* JADX WARNING: type inference failed for: r11v34 */
    /* JADX WARNING: type inference failed for: r11v35 */
    /* JADX WARNING: type inference failed for: r11v36 */
    /* JADX WARNING: type inference failed for: r11v37 */
    /* JADX WARNING: type inference failed for: r11v38 */
    /* JADX WARNING: type inference failed for: r11v39 */
    /* JADX WARNING: type inference failed for: r2v43 */
    /* JADX WARNING: type inference failed for: r2v44 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v12
  assigns: []
  uses: []
  mth insns count: 217
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01ca A[Catch:{ Exception -> 0x01c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01cf A[Catch:{ Exception -> 0x01c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c8 A[Catch:{ Exception -> 0x018d, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e5 A[Catch:{ Exception -> 0x018d, all -> 0x018a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01a0 A[SYNTHETIC, Splitter:B:80:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a8 A[Catch:{ Exception -> 0x01a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ad A[Catch:{ Exception -> 0x01a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01b2 A[Catch:{ Exception -> 0x01a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01bd A[SYNTHETIC, Splitter:B:94:0x01bd] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c5 A[Catch:{ Exception -> 0x01c1 }] */
    /* JADX WARNING: Unknown variable types count: 26 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r8, byte[] r9, java.lang.String r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "N/A"
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            java.lang.String r3 = "Upload data size is: "
            r2.<init>(r3)     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            int r3 = r9.length     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            int r3 = r3 / 1024
            r2.append(r3)     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            java.lang.String r3 = "KB"
            r2.append(r3)     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            e.c.b.f.a.b(r2)     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            java.net.URLConnection r8 = r2.openConnection()     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x0195, all -> 0x0190 }
            java.lang.String r2 = "POST"
            r8.setRequestMethod(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r2 = 1
            r8.setDoInput(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setDoOutput(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r3 = 0
            r8.setUseCaches(r3)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r3 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r8.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setInstanceFollowRedirects(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r8.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r3 = "*** filename =  ***"
            r2.<init>(r3)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r2.append(r11)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            e.c.b.f.a.b(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r2 = "Block"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = "EncryptData"
            java.lang.String r5 = "RSA-AES"
            java.lang.String r6 = "EncryptType"
            if (r2 == 0) goto L_0x007d
            java.lang.String r2 = "*** apiType == Block ***"
            e.c.b.f.a.b(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setRequestProperty(r6, r5)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setRequestProperty(r4, r11)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r10 = a(r10, r1)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
        L_0x0078:
            r8.setRequestProperty(r3, r10)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            goto L_0x00f4
        L_0x007d:
            java.lang.String r2 = "NDK"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            if (r2 == 0) goto L_0x00a7
            java.lang.String r2 = "*** apiType == NDK ***"
            e.c.b.f.a.b(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setRequestProperty(r6, r5)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setRequestProperty(r4, r11)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r11 = "Content-Length"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r2.<init>()     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            int r4 = r9.length     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r2.append(r4)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setRequestProperty(r11, r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r10 = a(r10, r1)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            goto L_0x0078
        L_0x00a7:
            java.lang.String r2 = "Log"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            if (r2 == 0) goto L_0x00b1
        L_0x00af:
            r2 = r11
            goto L_0x00c0
        L_0x00b1:
            java.lang.String r2 = "Traces"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            if (r2 == 0) goto L_0x00bc
            java.lang.String r10 = "Anr"
            goto L_0x00af
        L_0x00bc:
            java.lang.String r2 = l(r11)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
        L_0x00c0:
            java.lang.String r7 = "NoEncrypt_"
            boolean r7 = r2.startsWith(r7)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            if (r7 == 0) goto L_0x00e5
            java.lang.String r5 = "RSA-AES2"
            r8.setRequestProperty(r6, r5)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r5 = 10
            java.lang.String r2 = r2.substring(r5)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r6 = "real rsaAesKey is: "
            r5.<init>(r6)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r5.append(r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            e.c.b.f.a.b(r5)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            goto L_0x00e8
        L_0x00e5:
            r8.setRequestProperty(r6, r5)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
        L_0x00e8:
            r8.setRequestProperty(r4, r2)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r11 = j(r11)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.lang.String r10 = a(r10, r11)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            goto L_0x0078
        L_0x00f4:
            r10 = 8000(0x1f40, float:1.121E-41)
            r8.setConnectTimeout(r10)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r8.setReadTimeout(r10)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            java.io.OutputStream r11 = r8.getOutputStream()     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r10.<init>(r11)     // Catch:{ Exception -> 0x018d, all -> 0x018a }
            r10.write(r9)     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            r10.flush()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            r10.close()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            r9.<init>()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            java.lang.String r2 = "response code is "
            r11.<init>(r2)     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            int r2 = r8.getResponseCode()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            r11.append(r2)     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            e.c.b.f.a.a(r11)     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            int r11 = r8.getResponseCode()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r11 != r2) goto L_0x0159
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            java.io.InputStream r2 = r8.getInputStream()     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x017d, all -> 0x017a }
            r2.<init>(r11)     // Catch:{ Exception -> 0x017d, all -> 0x017a }
        L_0x013e:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x0157, all -> 0x0155 }
            if (r1 == 0) goto L_0x014d
            r9.append(r1)     // Catch:{ Exception -> 0x0157, all -> 0x0155 }
            java.lang.String r1 = "\n"
            r9.append(r1)     // Catch:{ Exception -> 0x0157, all -> 0x0155 }
            goto L_0x013e
        L_0x014d:
            r11.close()     // Catch:{ Exception -> 0x0157, all -> 0x0155 }
            r2.close()     // Catch:{ Exception -> 0x0157, all -> 0x0155 }
            r1 = r2
            goto L_0x015d
        L_0x0155:
            r9 = move-exception
            goto L_0x0183
        L_0x0157:
            r9 = move-exception
            goto L_0x0188
        L_0x0159:
            r9.append(r0)     // Catch:{ Exception -> 0x0185, all -> 0x0180 }
            r11 = r1
        L_0x015d:
            r8.disconnect()     // Catch:{ Exception -> 0x017d, all -> 0x017a }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x017d, all -> 0x017a }
            r10.close()     // Catch:{ Exception -> 0x0175 }
            r8.disconnect()     // Catch:{ Exception -> 0x0175 }
            if (r1 == 0) goto L_0x016f
            r1.close()     // Catch:{ Exception -> 0x0175 }
        L_0x016f:
            if (r11 == 0) goto L_0x0179
            r11.close()     // Catch:{ Exception -> 0x0175 }
            goto L_0x0179
        L_0x0175:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0179:
            return r9
        L_0x017a:
            r9 = move-exception
            r2 = r1
            goto L_0x0183
        L_0x017d:
            r9 = move-exception
            r2 = r1
            goto L_0x0188
        L_0x0180:
            r9 = move-exception
            r11 = r1
            r2 = r11
        L_0x0183:
            r1 = r10
            goto L_0x01bb
        L_0x0185:
            r9 = move-exception
            r11 = r1
            r2 = r11
        L_0x0188:
            r1 = r10
            goto L_0x0199
        L_0x018a:
            r9 = move-exception
            r11 = r1
            goto L_0x0193
        L_0x018d:
            r9 = move-exception
            r11 = r1
            goto L_0x0198
        L_0x0190:
            r9 = move-exception
            r8 = r1
            r11 = r8
        L_0x0193:
            r2 = r11
            goto L_0x01bb
        L_0x0195:
            r9 = move-exception
            r8 = r1
            r11 = r8
        L_0x0198:
            r2 = r11
        L_0x0199:
            java.lang.String r10 = "Upload Data Error!"
            e.c.b.f.a.a(r10, r9)     // Catch:{ all -> 0x01ba }
            if (r1 == 0) goto L_0x01a6
            r1.close()     // Catch:{ Exception -> 0x01a4 }
            goto L_0x01a6
        L_0x01a4:
            r8 = move-exception
            goto L_0x01b6
        L_0x01a6:
            if (r8 == 0) goto L_0x01ab
            r8.disconnect()     // Catch:{ Exception -> 0x01a4 }
        L_0x01ab:
            if (r2 == 0) goto L_0x01b0
            r2.close()     // Catch:{ Exception -> 0x01a4 }
        L_0x01b0:
            if (r11 == 0) goto L_0x01b9
            r11.close()     // Catch:{ Exception -> 0x01a4 }
            goto L_0x01b9
        L_0x01b6:
            r8.printStackTrace()
        L_0x01b9:
            return r0
        L_0x01ba:
            r9 = move-exception
        L_0x01bb:
            if (r1 == 0) goto L_0x01c3
            r1.close()     // Catch:{ Exception -> 0x01c1 }
            goto L_0x01c3
        L_0x01c1:
            r8 = move-exception
            goto L_0x01d3
        L_0x01c3:
            if (r8 == 0) goto L_0x01c8
            r8.disconnect()     // Catch:{ Exception -> 0x01c1 }
        L_0x01c8:
            if (r2 == 0) goto L_0x01cd
            r2.close()     // Catch:{ Exception -> 0x01c1 }
        L_0x01cd:
            if (r11 == 0) goto L_0x01d6
            r11.close()     // Catch:{ Exception -> 0x01c1 }
            goto L_0x01d6
        L_0x01d3:
            r8.printStackTrace()
        L_0x01d6:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.i.a(java.lang.String, byte[], java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(Throwable th) {
        if (th == null) {
            a.c("getErrorLine thr is null.");
            return "";
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String format(Date date) {
        if (f5915h == null) {
            f5915h = new SimpleDateFormat("MM-dd HH:mm:ss");
        }
        return f5915h.format(date);
    }

    public static synchronized List<String> a(Context context) {
        ArrayList arrayList;
        File[] listFiles;
        String absolutePath;
        synchronized (Utils.class) {
            arrayList = new ArrayList();
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                for (File file : filesDir.listFiles()) {
                    if (file.getName().contains("crab_crash_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("crab_anr_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("crab_catched_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("crab_block_")) {
                        absolutePath = file.getAbsolutePath();
                    } else if (file.getName().contains("native_count")) {
                        absolutePath = file.getAbsolutePath();
                    }
                    arrayList.add(absolutePath);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0111, code lost:
        if (r10 != null) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011e, code lost:
        if (r10 != null) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012e, code lost:
        if (r10 != null) goto L_0x0130;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03bc  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03ff  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0406  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x045c A[Catch:{ RuntimeException -> 0x049c }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0518 A[SYNTHETIC, Splitter:B:181:0x0518] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0558  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0597  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x05fa A[SYNTHETIC, Splitter:B:218:0x05fa] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0602 A[Catch:{ IOException -> 0x05fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010e A[SYNTHETIC, Splitter:B:45:0x010e] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011b A[SYNTHETIC, Splitter:B:53:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0128 A[SYNTHETIC, Splitter:B:61:0x0128] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:58:0x0123=Splitter:B:58:0x0123, B:50:0x0116=Splitter:B:50:0x0116, B:42:0x0109=Splitter:B:42:0x0109} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.Object> a(android.content.Context r14, java.lang.Throwable r15, boolean r16) {
        /*
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r0 = e.c.b.d.f5880d
            java.lang.String r2 = "appKey"
            r1.put(r2, r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            java.lang.String r2 = "phoneTime"
            r1.put(r2, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.app.ActivityManager r0 = a.a.a.a.b.a.l
            java.lang.String r3 = "yes"
            java.lang.String r4 = "no"
            java.lang.String r5 = "\n"
            r6 = 0
            r7 = 1
            if (r0 != 0) goto L_0x002c
            goto L_0x00b8
        L_0x002c:
            android.app.ActivityManager$MemoryInfo r0 = new android.app.ActivityManager$MemoryInfo     // Catch:{ Exception -> 0x00b2 }
            r0.<init>()     // Catch:{ Exception -> 0x00b2 }
            android.app.ActivityManager r8 = a.a.a.a.b.a.l     // Catch:{ Exception -> 0x00b2 }
            r8.getMemoryInfo(r0)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = "isLowMem: "
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            boolean r8 = r0.lowMemory     // Catch:{ Exception -> 0x00b2 }
            if (r8 == 0) goto L_0x0041
            r8 = r3
            goto L_0x0042
        L_0x0041:
            r8 = r4
        L_0x0042:
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = "\navailMem: "
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            long r8 = r0.availMem     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = b(r8)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = "\nthreshold: "
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            long r8 = r0.threshold     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r0 = b(r8)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r0)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r5)     // Catch:{ Exception -> 0x00b2 }
            int[] r0 = new int[r7]     // Catch:{ Exception -> 0x00b2 }
            int r8 = android.os.Process.myPid()     // Catch:{ Exception -> 0x00b2 }
            r0[r6] = r8     // Catch:{ Exception -> 0x00b2 }
            android.app.ActivityManager r8 = a.a.a.a.b.a.l     // Catch:{ Exception -> 0x00b2 }
            android.os.Debug$MemoryInfo[] r0 = r8.getProcessMemoryInfo(r0)     // Catch:{ Exception -> 0x00b2 }
            r0 = r0[r6]     // Catch:{ Exception -> 0x00b2 }
            if (r0 == 0) goto L_0x00b8
            java.lang.String r8 = "totalPrivateDirty: "
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            int r8 = r0.getTotalPrivateDirty()     // Catch:{ Exception -> 0x00b2 }
            long r8 = (long) r8     // Catch:{ Exception -> 0x00b2 }
            r10 = 1024(0x400, double:5.06E-321)
            long r8 = r8 * r10
            java.lang.String r8 = b(r8)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = "\ntotalPss: "
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            int r8 = r0.getTotalPss()     // Catch:{ Exception -> 0x00b2 }
            long r8 = (long) r8     // Catch:{ Exception -> 0x00b2 }
            long r8 = r8 * r10
            java.lang.String r8 = b(r8)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = "\ntotalSharedDirty: "
            r2.append(r8)     // Catch:{ Exception -> 0x00b2 }
            int r0 = r0.getTotalSharedDirty()     // Catch:{ Exception -> 0x00b2 }
            long r8 = (long) r0     // Catch:{ Exception -> 0x00b2 }
            long r8 = r8 * r10
            java.lang.String r0 = b(r8)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r0)     // Catch:{ Exception -> 0x00b2 }
            r2.append(r5)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b8
        L_0x00b2:
            r0 = move-exception
            java.lang.String r8 = "getMemInfo error!!!"
            e.c.b.f.a.a(r8, r0)
        L_0x00b8:
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "memInfo"
            r1.put(r2, r0)
            java.lang.String r2 = "getSysMemInfo fail."
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 0
            java.io.FileReader r10 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x0121, IOException -> 0x0114, Exception -> 0x0107, all -> 0x0102 }
            java.lang.String r0 = "/proc/meminfo"
            r10.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0121, IOException -> 0x0114, Exception -> 0x0107, all -> 0x0102 }
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fe, Exception -> 0x00fc }
            r0 = 8192(0x2000, float:1.14794E-41)
            r11.<init>(r10, r0)     // Catch:{ FileNotFoundException -> 0x0100, IOException -> 0x00fe, Exception -> 0x00fc }
            r0 = r6
        L_0x00d8:
            java.lang.String r9 = r11.readLine()     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00f6, Exception -> 0x00f3, all -> 0x00ef }
            if (r9 == 0) goto L_0x00eb
            int r12 = r0 + 1
            r13 = 5
            if (r0 >= r13) goto L_0x00eb
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00f6, Exception -> 0x00f3, all -> 0x00ef }
            r8.append(r5)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00f6, Exception -> 0x00f3, all -> 0x00ef }
            r0 = r12
            goto L_0x00d8
        L_0x00eb:
            r11.close()     // Catch:{ IOException -> 0x012c }
            goto L_0x0130
        L_0x00ef:
            r0 = move-exception
            r9 = r11
            goto L_0x05f7
        L_0x00f3:
            r0 = move-exception
            r9 = r11
            goto L_0x0109
        L_0x00f6:
            r0 = move-exception
            r9 = r11
            goto L_0x0116
        L_0x00f9:
            r0 = move-exception
            r9 = r11
            goto L_0x0123
        L_0x00fc:
            r0 = move-exception
            goto L_0x0109
        L_0x00fe:
            r0 = move-exception
            goto L_0x0116
        L_0x0100:
            r0 = move-exception
            goto L_0x0123
        L_0x0102:
            r0 = move-exception
            r1 = r0
            r10 = r9
            goto L_0x05f8
        L_0x0107:
            r0 = move-exception
            r10 = r9
        L_0x0109:
            e.c.b.f.a.a(r2, r0)     // Catch:{ all -> 0x05f6 }
            if (r9 == 0) goto L_0x0111
            r9.close()     // Catch:{ IOException -> 0x012c }
        L_0x0111:
            if (r10 == 0) goto L_0x0137
            goto L_0x0130
        L_0x0114:
            r0 = move-exception
            r10 = r9
        L_0x0116:
            e.c.b.f.a.a(r2, r0)     // Catch:{ all -> 0x05f6 }
            if (r9 == 0) goto L_0x011e
            r9.close()     // Catch:{ IOException -> 0x012c }
        L_0x011e:
            if (r10 == 0) goto L_0x0137
            goto L_0x0130
        L_0x0121:
            r0 = move-exception
            r10 = r9
        L_0x0123:
            e.c.b.f.a.a(r2, r0)     // Catch:{ all -> 0x05f6 }
            if (r9 == 0) goto L_0x012e
            r9.close()     // Catch:{ IOException -> 0x012c }
            goto L_0x012e
        L_0x012c:
            r0 = move-exception
            goto L_0x0134
        L_0x012e:
            if (r10 == 0) goto L_0x0137
        L_0x0130:
            r10.close()     // Catch:{ IOException -> 0x012c }
            goto L_0x0137
        L_0x0134:
            r0.printStackTrace()
        L_0x0137:
            java.lang.String r0 = r8.toString()
            java.lang.String r2 = "sysMemInfo"
            r1.put(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            e.c.b.f.b<java.util.List> r2 = e.c.b.e.c.f5895b
            int r2 = r2.size()
            r8 = r6
        L_0x014c:
            r9 = 2
            r10 = 3
            if (r8 >= r2) goto L_0x01b7
            e.c.b.f.b<java.util.List> r11 = e.c.b.e.c.f5895b
            int r12 = r2 - r8
            int r12 = r12 - r7
            java.lang.Object r11 = r11.get(r12)
            java.util.List r11 = (java.util.List) r11
            int r12 = r11.size()
            java.lang.String r13 = " from "
            if (r12 != r10) goto L_0x0190
            java.lang.Object r10 = r11.get(r6)
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r12 = r11.get(r7)
            java.util.Date r12 = (java.util.Date) r12
            java.lang.Object r9 = r11.get(r9)
            java.util.Date r9 = (java.util.Date) r9
            r0.append(r10)
            r0.append(r13)
            java.lang.String r10 = a(r12)
            r0.append(r10)
            java.lang.String r10 = " to "
            r0.append(r10)
            java.lang.String r9 = a(r9)
            r0.append(r9)
            r9 = r5
            goto L_0x01b1
        L_0x0190:
            int r10 = r11.size()
            if (r10 != r9) goto L_0x01b4
            java.lang.Object r9 = r11.get(r6)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r11.get(r7)
            java.util.Date r10 = (java.util.Date) r10
            r0.append(r9)
            r0.append(r13)
            java.lang.String r9 = a(r10)
            r0.append(r9)
            java.lang.String r9 = " to ...\n"
        L_0x01b1:
            r0.append(r9)
        L_0x01b4:
            int r8 = r8 + 1
            goto L_0x014c
        L_0x01b7:
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "pageHistory"
            r1.put(r2, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            e.c.b.f.b<java.util.List> r2 = e.c.b.e.e.f5902a
            int r2 = r2.size()
            r8 = r6
        L_0x01cc:
            if (r8 >= r2) goto L_0x0232
            e.c.b.f.b<java.util.List> r11 = e.c.b.e.e.f5902a
            java.lang.Object r11 = r11.get(r8)
            java.util.List r11 = (java.util.List) r11
            if (r11 == 0) goto L_0x0247
            int r12 = r11.size()
            if (r12 <= 0) goto L_0x0247
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "STEP"
            r12.<init>(r13)
            int r8 = r8 + 1
            r12.append(r8)
            java.lang.String r13 = "\nTime: "
            r12.append(r13)
            java.lang.Object r13 = r11.get(r6)
            r12.append(r13)
            java.lang.String r13 = "; Activity: "
            r12.append(r13)
            r13 = 4
            java.lang.Object r13 = r11.get(r13)
            r12.append(r13)
            java.lang.String r13 = "; Component: "
            r12.append(r13)
            java.lang.Object r13 = r11.get(r7)
            r12.append(r13)
            java.lang.String r13 = "; Operation: "
            r12.append(r13)
            java.lang.Object r13 = r11.get(r9)
            r12.append(r13)
            java.lang.String r13 = "; Location: "
            r12.append(r13)
            java.lang.Object r11 = r11.get(r10)
            r12.append(r11)
            r12.append(r5)
            java.lang.String r11 = r12.toString()
            r0.append(r11)
            goto L_0x01cc
        L_0x0232:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r8 = "Behavior Steps --> "
            r2.<init>(r8)
            java.lang.String r8 = r0.toString()
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            e.c.b.f.a.b(r2)
        L_0x0247:
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "activitySteps"
            r1.put(r2, r0)
            java.lang.String r0 = e.c.b.e.k.a()
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x025c
            r0 = r7
            goto L_0x025d
        L_0x025c:
            r0 = r6
        L_0x025d:
            if (r0 == 0) goto L_0x0268
            java.lang.String r0 = e.c.b.e.k.a()
            java.lang.String r2 = "urlRecord"
            r1.put(r2, r0)
        L_0x0268:
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            android.content.pm.PackageManager r2 = f5916i
            if (r2 != 0) goto L_0x0274
            android.content.pm.PackageManager r2 = r14.getPackageManager()
            f5916i = r2
        L_0x0274:
            android.content.pm.PackageManager r2 = f5916i     // Catch:{ RuntimeException -> 0x0282 }
            java.lang.String r8 = r14.getPackageName()     // Catch:{ RuntimeException -> 0x0282 }
            int r0 = r2.checkPermission(r0, r8)     // Catch:{ RuntimeException -> 0x0282 }
            if (r0 != 0) goto L_0x0282
            r0 = r7
            goto L_0x0283
        L_0x0282:
            r0 = r6
        L_0x0283:
            java.lang.String r2 = "N/A"
            if (r0 == 0) goto L_0x0308
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            android.net.ConnectivityManager r0 = f5909b     // Catch:{ RuntimeException -> 0x02f9 }
            if (r0 != 0) goto L_0x029c
            android.content.Context r0 = f5910c     // Catch:{ RuntimeException -> 0x02f9 }
            java.lang.String r9 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r9)     // Catch:{ RuntimeException -> 0x02f9 }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ RuntimeException -> 0x02f9 }
            f5909b = r0     // Catch:{ RuntimeException -> 0x02f9 }
        L_0x029c:
            android.net.ConnectivityManager r0 = f5909b     // Catch:{ RuntimeException -> 0x02f9 }
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ RuntimeException -> 0x02f9 }
            if (r0 != 0) goto L_0x02a6
            r0 = r2
            goto L_0x0303
        L_0x02a6:
            boolean r9 = r0.isConnected()     // Catch:{ RuntimeException -> 0x02f9 }
            if (r9 != 0) goto L_0x02af
            java.lang.String r5 = "type: none\n"
            goto L_0x02f5
        L_0x02af:
            java.lang.String r9 = "type: "
            r8.append(r9)     // Catch:{ RuntimeException -> 0x02f9 }
            java.lang.String r9 = r0.getTypeName()     // Catch:{ RuntimeException -> 0x02f9 }
            r8.append(r9)     // Catch:{ RuntimeException -> 0x02f9 }
            r8.append(r5)     // Catch:{ RuntimeException -> 0x02f9 }
            int r9 = r0.getType()     // Catch:{ RuntimeException -> 0x02f9 }
            if (r9 != 0) goto L_0x02ff
            java.lang.String r9 = "subType: "
            r8.append(r9)     // Catch:{ RuntimeException -> 0x02f9 }
            java.lang.String r0 = r0.getSubtypeName()     // Catch:{ RuntimeException -> 0x02f9 }
            r8.append(r0)     // Catch:{ RuntimeException -> 0x02f9 }
            r8.append(r5)     // Catch:{ RuntimeException -> 0x02f9 }
            android.telephony.TelephonyManager r0 = f5908a     // Catch:{ RuntimeException -> 0x02f9 }
            if (r0 != 0) goto L_0x02e3
            android.content.Context r0 = f5910c     // Catch:{ RuntimeException -> 0x02f9 }
            java.lang.String r9 = "phone"
            java.lang.Object r0 = r0.getSystemService(r9)     // Catch:{ RuntimeException -> 0x02f9 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ RuntimeException -> 0x02f9 }
            f5908a = r0     // Catch:{ RuntimeException -> 0x02f9 }
        L_0x02e3:
            java.lang.String r0 = "isRoaming: "
            r8.append(r0)     // Catch:{ RuntimeException -> 0x02f9 }
            android.telephony.TelephonyManager r0 = f5908a     // Catch:{ RuntimeException -> 0x02f9 }
            boolean r0 = r0.isNetworkRoaming()     // Catch:{ RuntimeException -> 0x02f9 }
            if (r0 == 0) goto L_0x02f1
            goto L_0x02f2
        L_0x02f1:
            r3 = r4
        L_0x02f2:
            r8.append(r3)     // Catch:{ RuntimeException -> 0x02f9 }
        L_0x02f5:
            r8.append(r5)     // Catch:{ RuntimeException -> 0x02f9 }
            goto L_0x02ff
        L_0x02f9:
            r0 = move-exception
            java.lang.String r3 = "getNetworkInfo"
            e.c.b.f.a.a(r3, r0)
        L_0x02ff:
            java.lang.String r0 = r8.toString()
        L_0x0303:
            java.lang.String r3 = "networkInfo"
            r1.put(r3, r0)
        L_0x0308:
            java.lang.String r0 = a.a.a.a.b.a.a()     // Catch:{ Exception -> 0x0312 }
            java.lang.String r3 = "logcat"
            r1.put(r3, r0)     // Catch:{ Exception -> 0x0312 }
            goto L_0x031a
        L_0x0312:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            e.c.b.f.a.c(r0)
        L_0x031a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            long r3 = java.lang.System.currentTimeMillis()
            r0.append(r3)
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r3 = r3.toString()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "recordId"
            r1.put(r3, r0)
            android.content.SharedPreferences r0 = e.c.b.e.j.f5919b
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0347
            java.lang.String r4 = "userName"
            java.lang.String r0 = r0.getString(r4, r3)
            goto L_0x0348
        L_0x0347:
            r0 = r3
        L_0x0348:
            java.lang.String r4 = "uname"
            r1.put(r4, r0)
            java.lang.String r0 = e.c.b.e.j.a()
            java.lang.String r4 = "uid"
            r1.put(r4, r0)
            java.lang.String r0 = "batVN"
            java.lang.String r4 = "7.5.0"
            r1.put(r0, r4)
            java.lang.String r0 = "nativeVN"
            java.lang.String r4 = "-1"
            r1.put(r0, r4)
            java.lang.String r0 = e.c.b.d.f5877a
            java.lang.String r4 = "developerName"
            r1.put(r4, r0)
            java.io.File r0 = new java.io.File
            java.lang.String r4 = "/system/bin/su"
            r0.<init>(r4)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x037f
            boolean r0 = a(r4)
            if (r0 == 0) goto L_0x037f
            goto L_0x0394
        L_0x037f:
            java.io.File r0 = new java.io.File
            java.lang.String r4 = "/system/xbin/su"
            r0.<init>(r4)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x0393
            boolean r0 = a(r4)
            if (r0 == 0) goto L_0x0393
            goto L_0x0394
        L_0x0393:
            r7 = r6
        L_0x0394:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = "isRoot"
            r1.put(r4, r0)
            java.lang.String r0 = b()
            java.lang.String r4 = "pkgName"
            r1.put(r4, r0)
            java.lang.String r0 = c()
            java.lang.String r4 = "appLabel"
            r1.put(r4, r0)
            java.lang.String r0 = d()
            java.lang.String r4 = "appVN"
            r1.put(r4, r0)
            android.content.pm.PackageInfo r0 = f5913f
            if (r0 != 0) goto L_0x03be
            r0 = r6
            goto L_0x03c0
        L_0x03be:
            int r0 = r0.versionCode
        L_0x03c0:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "appVC"
            r1.put(r4, r0)
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r4 = "model"
            r1.put(r4, r0)
            java.lang.String r0 = android.os.Build.BRAND
            java.lang.String r4 = "brand"
            r1.put(r4, r0)
            java.lang.String r0 = "os"
            java.lang.String r4 = "Android"
            r1.put(r0, r4)
            java.lang.String r0 = android.os.Build.VERSION.RELEASE
            java.lang.String r4 = "osVN"
            r1.put(r4, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "osVC"
            r1.put(r4, r0)
            long r4 = e.c.b.e.c.f5897d
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "startupTime"
            r1.put(r4, r0)
            android.app.Activity r0 = e.c.b.e.c.f5894a
            if (r0 != 0) goto L_0x0406
            java.lang.String r0 = "cur Page info is null!"
            e.c.b.f.a.a(r0)
            r0 = r2
            goto L_0x040e
        L_0x0406:
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
        L_0x040e:
            java.lang.String r4 = "curPage"
            r1.put(r4, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.util.Locale r4 = a.a.a.a.b.a.f401j
            java.lang.String r4 = r4.getLanguage()
            r0.append(r4)
            java.lang.String r4 = "-"
            r0.append(r4)
            java.util.Locale r4 = a.a.a.a.b.a.f401j
            java.lang.String r4 = r4.getCountry()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "locale"
            r1.put(r4, r0)
            java.lang.String r0 = e()
            java.lang.String r4 = "allThreadStacks"
            r1.put(r4, r0)
            java.lang.String r4 = "Failed to inspect device configuration: "
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            android.content.res.Resources r0 = r14.getResources()     // Catch:{ RuntimeException -> 0x049c }
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch:{ RuntimeException -> 0x049c }
            java.lang.Class r0 = r7.getClass()     // Catch:{ RuntimeException -> 0x049c }
            java.lang.reflect.Field[] r8 = r0.getFields()     // Catch:{ RuntimeException -> 0x049c }
            int r9 = r8.length     // Catch:{ RuntimeException -> 0x049c }
            r10 = r6
        L_0x045a:
            if (r10 >= r9) goto L_0x04a2
            r0 = r8[r10]     // Catch:{ RuntimeException -> 0x049c }
            int r11 = r0.getModifiers()     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            boolean r11 = java.lang.reflect.Modifier.isStatic(r11)     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            if (r11 != 0) goto L_0x0499
            java.lang.String r11 = r0.getName()     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            r5.append(r11)     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            java.lang.String r11 = ": "
            r5.append(r11)     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            r5.append(r0)     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            r0 = 10
            r5.append(r0)     // Catch:{ IllegalArgumentException -> 0x048b, IllegalAccessException -> 0x0481 }
            goto L_0x0499
        L_0x0481:
            r0 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x049c }
            r11.<init>(r4)     // Catch:{ RuntimeException -> 0x049c }
        L_0x0487:
            r11.append(r7)     // Catch:{ RuntimeException -> 0x049c }
            goto L_0x0492
        L_0x048b:
            r0 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x049c }
            r11.<init>(r4)     // Catch:{ RuntimeException -> 0x049c }
            goto L_0x0487
        L_0x0492:
            java.lang.String r11 = r11.toString()     // Catch:{ RuntimeException -> 0x049c }
            e.c.b.f.a.a(r11, r0)     // Catch:{ RuntimeException -> 0x049c }
        L_0x0499:
            int r10 = r10 + 1
            goto L_0x045a
        L_0x049c:
            r0 = move-exception
            java.lang.String r4 = "getConfigInfo"
            e.c.b.f.a.a(r4, r0)
        L_0x04a2:
            java.lang.String r0 = r5.toString()
            java.lang.String r4 = "appCurConfig"
            r1.put(r4, r0)
            java.io.File r0 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x0507 }
            android.os.StatFs r4 = new android.os.StatFs     // Catch:{ Exception -> 0x0507 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0507 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0507 }
            int r0 = r4.getBlockSize()     // Catch:{ Exception -> 0x0507 }
            long r7 = (long) r0     // Catch:{ Exception -> 0x0507 }
            int r0 = r4.getBlockCount()     // Catch:{ Exception -> 0x0507 }
            long r4 = (long) r0     // Catch:{ Exception -> 0x0507 }
            long r4 = r4 * r7
            java.io.File r0 = android.os.Environment.getDataDirectory()     // Catch:{ Exception -> 0x0507 }
            android.os.StatFs r7 = new android.os.StatFs     // Catch:{ Exception -> 0x0507 }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x0507 }
            r7.<init>(r0)     // Catch:{ Exception -> 0x0507 }
            int r0 = r7.getBlockSize()     // Catch:{ Exception -> 0x0507 }
            long r8 = (long) r0     // Catch:{ Exception -> 0x0507 }
            int r0 = r7.getAvailableBlocks()     // Catch:{ Exception -> 0x0507 }
            long r10 = (long) r0     // Catch:{ Exception -> 0x0507 }
            long r10 = r10 * r8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0507 }
            java.lang.String r7 = "Total: "
            r0.<init>(r7)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r7 = b(r4)     // Catch:{ Exception -> 0x0507 }
            r0.append(r7)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r7 = " Used: "
            r0.append(r7)     // Catch:{ Exception -> 0x0507 }
            long r4 = r4 - r10
            java.lang.String r4 = b(r4)     // Catch:{ Exception -> 0x0507 }
            r0.append(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r4 = " Free: "
            r0.append(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r4 = b(r10)     // Catch:{ Exception -> 0x0507 }
            r0.append(r4)     // Catch:{ Exception -> 0x0507 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0507 }
            goto L_0x050e
        L_0x0507:
            r0 = move-exception
            java.lang.String r4 = "getInternalStorageInfo error!"
            e.c.b.f.a.a(r4, r0)
            r0 = r2
        L_0x050e:
            java.lang.String r4 = "internalStorageInfo"
            r1.put(r4, r0)
            java.lang.String r0 = e.c.b.e.f.f5903a
            if (r0 == 0) goto L_0x0518
            goto L_0x0535
        L_0x0518:
            android.content.Context r0 = e.c.b.e.f.f5904b     // Catch:{ Exception -> 0x052b }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x052b }
            java.lang.String r4 = "android_id"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r4)     // Catch:{ Exception -> 0x052b }
            java.lang.String r0 = e.c.b.e.f.a(r0)     // Catch:{ Exception -> 0x052b }
            e.c.b.e.f.f5903a = r0     // Catch:{ Exception -> 0x052b }
            goto L_0x0533
        L_0x052b:
            r0 = move-exception
            java.lang.String r4 = "getCUID failed!"
            e.c.b.f.a.a(r4, r0)
            e.c.b.e.f.f5903a = r2
        L_0x0533:
            java.lang.String r0 = e.c.b.e.f.f5903a
        L_0x0535:
            java.lang.String r4 = "CUID"
            r1.put(r4, r0)
            java.lang.String r0 = e.c.b.d.f5878b
            java.lang.String r4 = "channel"
            r1.put(r4, r0)
            java.lang.String r0 = android.os.Build.CPU_ABI
            java.lang.String r4 = "cpuabi"
            r1.put(r4, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0553
            java.lang.String r0 = "usersCustom"
            r1.put(r0, r3)
        L_0x0553:
            android.content.Intent r0 = a.a.a.a.b.a.f400i
            if (r0 != 0) goto L_0x0558
            goto L_0x0587
        L_0x0558:
            java.lang.String r3 = "level"
            int r0 = r0.getIntExtra(r3, r6)     // Catch:{ Exception -> 0x0581 }
            android.content.Intent r3 = a.a.a.a.b.a.f400i     // Catch:{ Exception -> 0x0581 }
            java.lang.String r4 = "scale"
            r5 = 100
            int r3 = r3.getIntExtra(r4, r5)     // Catch:{ Exception -> 0x0581 }
            r4 = 1120403456(0x42c80000, float:100.0)
            float r0 = (float) r0     // Catch:{ Exception -> 0x0581 }
            float r0 = r0 * r4
            float r3 = (float) r3     // Catch:{ Exception -> 0x0581 }
            float r0 = r0 / r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0581 }
            r3.<init>()     // Catch:{ Exception -> 0x0581 }
            int r0 = (int) r0     // Catch:{ Exception -> 0x0581 }
            r3.append(r0)     // Catch:{ Exception -> 0x0581 }
            java.lang.String r0 = "%"
            r3.append(r0)     // Catch:{ Exception -> 0x0581 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0581 }
            goto L_0x0587
        L_0x0581:
            r0 = move-exception
            java.lang.String r3 = "Get Battery Error!"
            e.c.b.f.a.a(r3, r0)
        L_0x0587:
            java.lang.String r0 = "batteryRate"
            r1.put(r0, r2)
            java.lang.String r0 = e.c.b.a.f5876c
            java.lang.String r2 = "procName"
            r1.put(r2, r0)
            boolean r0 = e.c.b.d.o
            if (r0 == 0) goto L_0x05e9
            java.lang.String r0 = "SEND_PRIVACYINFORMATION true"
            e.c.b.f.a.a(r0)
            java.lang.String r0 = "screenshot"
            if (r16 != 0) goto L_0x05cb
            boolean r2 = e.c.b.d.k     // Catch:{ RuntimeException -> 0x05e3 }
            if (r2 == 0) goto L_0x05c5
            byte[] r2 = e.c.b.e.c.a()     // Catch:{ RuntimeException -> 0x05e3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x05e3 }
            java.lang.String r4 = "截图大小："
            r3.<init>(r4)     // Catch:{ RuntimeException -> 0x05e3 }
            int r4 = r2.length     // Catch:{ RuntimeException -> 0x05e3 }
            int r4 = r4 / 1024
            r3.append(r4)     // Catch:{ RuntimeException -> 0x05e3 }
            java.lang.String r4 = "KB"
            r3.append(r4)     // Catch:{ RuntimeException -> 0x05e3 }
            java.lang.String r3 = r3.toString()     // Catch:{ RuntimeException -> 0x05e3 }
            e.c.b.f.a.b(r3)     // Catch:{ RuntimeException -> 0x05e3 }
            r1.put(r0, r2)     // Catch:{ RuntimeException -> 0x05e3 }
            goto L_0x05d0
        L_0x05c5:
            byte[] r2 = new byte[r6]     // Catch:{ RuntimeException -> 0x05e3 }
            r1.put(r0, r2)     // Catch:{ RuntimeException -> 0x05e3 }
            goto L_0x05d0
        L_0x05cb:
            byte[] r2 = new byte[r6]     // Catch:{ RuntimeException -> 0x05e3 }
            r1.put(r0, r2)     // Catch:{ RuntimeException -> 0x05e3 }
        L_0x05d0:
            java.lang.String r0 = a.a.a.a.b.a.e()     // Catch:{ RuntimeException -> 0x05e3 }
            java.lang.String r2 = "myAppCPUStat"
            r1.put(r2, r0)     // Catch:{ RuntimeException -> 0x05e3 }
            java.lang.String r0 = a.a.a.a.b.a.a(r14)     // Catch:{ RuntimeException -> 0x05e3 }
            java.lang.String r2 = "deviceInfo"
            r1.put(r2, r0)     // Catch:{ RuntimeException -> 0x05e3 }
            goto L_0x05e9
        L_0x05e3:
            r0 = move-exception
            java.lang.String r2 = "createRecord fail."
            e.c.b.f.a.a(r2, r0)
        L_0x05e9:
            r2 = r15
            a(r1, r15)     // Catch:{ RuntimeException -> 0x05ee }
            goto L_0x05f5
        L_0x05ee:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "createCrashRecord fail."
            e.c.b.f.a.a(r0, r2)
        L_0x05f5:
            return r1
        L_0x05f6:
            r0 = move-exception
        L_0x05f7:
            r1 = r0
        L_0x05f8:
            if (r9 == 0) goto L_0x0600
            r9.close()     // Catch:{ IOException -> 0x05fe }
            goto L_0x0600
        L_0x05fe:
            r0 = move-exception
            goto L_0x0606
        L_0x0600:
            if (r10 == 0) goto L_0x0609
            r10.close()     // Catch:{ IOException -> 0x05fe }
            goto L_0x0609
        L_0x0606:
            r0.printStackTrace()
        L_0x0609:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.i.a(android.content.Context, java.lang.Throwable, boolean):java.util.Map");
    }

    public static Map<String, Object> a(Map<String, Object> map, Throwable th) {
        if (th == null) {
            return map;
        }
        map.put("errorType", th.getClass().getName());
        String a2 = a(th);
        map.put("errorLine", a2);
        StringBuilder sb = new StringBuilder("errorLine: ");
        sb.append(a2);
        a.a(sb.toString());
        String b2 = b(th);
        map.put("errorOriLine", b2);
        StringBuilder sb2 = new StringBuilder("errorOriLine: ");
        sb2.append(b2);
        a.a(sb2.toString());
        map.put("errorTrace", Log.getStackTraceString(th));
        return map;
    }

    public static void putLong(long j2) {
        SharedPreferences sharedPreferences = Utils.sharedPreferences;
        if (sharedPreferences != null) {
            a(sharedPreferences.edit().putLong("crash_upload_time_nowifi", j2), true);
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (Utils.class) {
            StringBuilder sb = new StringBuilder("crab_anr_");
            sb.append(System.currentTimeMillis());
            a(context, sb.toString(), str);
        }
    }

    public static void a(Editor editor, boolean z) {
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (r0 == null) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0057 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0057 }
            java.lang.String r3 = "ls -l "
            r2.<init>(r3)     // Catch:{ IOException -> 0x0057 }
            r2.append(r4)     // Catch:{ IOException -> 0x0057 }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x0057 }
            java.lang.Process r0 = r1.exec(r4)     // Catch:{ IOException -> 0x0057 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0057 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0057 }
            java.io.InputStream r2 = r0.getInputStream()     // Catch:{ IOException -> 0x0057 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0057 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x0057 }
            java.lang.String r4 = r4.readLine()     // Catch:{ IOException -> 0x0057 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0057 }
            java.lang.String r2 = "isExecutable"
            r1.<init>(r2)     // Catch:{ IOException -> 0x0057 }
            r1.append(r4)     // Catch:{ IOException -> 0x0057 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0057 }
            e.c.b.f.a.a(r1)     // Catch:{ IOException -> 0x0057 }
            if (r4 == 0) goto L_0x005d
            int r1 = r4.length()     // Catch:{ IOException -> 0x0057 }
            r2 = 4
            if (r1 < r2) goto L_0x005d
            r1 = 3
            char r4 = r4.charAt(r1)     // Catch:{ IOException -> 0x0057 }
            r1 = 115(0x73, float:1.61E-43)
            if (r4 == r1) goto L_0x0050
            r1 = 120(0x78, float:1.68E-43)
            if (r4 != r1) goto L_0x005d
        L_0x0050:
            r0.destroy()
            r4 = 1
            return r4
        L_0x0055:
            r4 = move-exception
            goto L_0x0062
        L_0x0057:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0060
        L_0x005d:
            r0.destroy()
        L_0x0060:
            r4 = 0
            return r4
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.destroy()
        L_0x0067:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.i.a(java.lang.String):boolean");
    }

    public static String b() {
        return f5911d.getPackageName();
    }

    public static String b(long j2) {
        StringBuilder sb;
        String str;
        if (j2 / 1000000000 > 0) {
            long j3 = j2 / 100000000;
            sb = new StringBuilder();
            sb.append(((float) j3) / 10.0f);
            str = "G";
        } else if (j2 / 1000000 > 0) {
            long j4 = j2 / 100000;
            sb = new StringBuilder();
            sb.append(((float) j4) / 10.0f);
            str = "M";
        } else if (j2 / 1000 > 0) {
            long j5 = j2 / 100;
            sb = new StringBuilder();
            sb.append(((float) j5) / 10.0f);
            str = "K";
        } else {
            sb = new StringBuilder();
            sb.append(j2);
            str = "B";
        }
        sb.append(str);
        return sb.toString();
    }

    public static String b(Throwable th) {
        if (th == null) {
            a.c("getErrorOriginalLine thr is null.");
            return "";
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        String b2 = b();
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            if (stackTrace[i2].getClassName().contains(b2)) {
                return stackTrace[i2].toString();
            }
        }
        return stackTrace.length > 0 ? stackTrace[0].toString() : "N/A";
    }

    public static String b(Map<String, Object> map) {
        Object obj;
        if (map == null) {
            return "";
        }
        String str = "screenshot";
        if (map.containsKey(str) && map.get(str) != null) {
            map.put(str, Base64.encodeToString((byte[]) map.get(str), 0));
        }
        JSONObject jSONObject = new JSONObject();
        for (String str2 : map.keySet()) {
            try {
                Object obj2 = map.get(str2);
                if (obj2 instanceof String) {
                    obj = (String) obj2;
                } else if (obj2 instanceof Integer) {
                    obj = (Integer) obj2;
                } else if (obj2 instanceof Long) {
                    obj = (Long) obj2;
                } else if (obj2 instanceof Float) {
                    obj = (Float) obj2;
                } else {
                    StringBuilder sb = new StringBuilder("mapRecord2JSON: unexpected key[");
                    sb.append(str2);
                    sb.append("]'s value ");
                    sb.append(obj2);
                    a.d(sb.toString());
                }
                jSONObject.put(str2, obj);
            } catch (JSONException e2) {
                StringBuilder sb2 = new StringBuilder("Could not create JSON object for key ");
                sb2.append(str2);
                a.a(sb2.toString(), e2);
            }
        }
        return jSONObject.toString();
    }

    public static synchronized void b(Context context, String str) {
        synchronized (Utils.class) {
            StringBuilder sb = new StringBuilder("crab_crash_");
            sb.append(System.currentTimeMillis());
            a(context, sb.toString(), str);
        }
    }

    public static void b(String str, String str2) {
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.commit();
        StringBuilder sb = new StringBuilder("Encrypted key is: ");
        sb.append(str2);
        sb.append("; filename is: ");
        sb.append(str);
        a.b(sb.toString());
    }

    public static String c() {
        if (f5914g == null) {
            PackageInfo packageInfo = Utils.packageInfo;
            if (packageInfo == null) {
                return "N/A";
            }
            f5914g = packageInfo.applicationInfo.loadLabel(f5912e).toString();
        }
        return f5914g;
    }

    public static String c(String str, String str2) {
        byte[] bArr;
        try {
            String substring = str2.substring(0, 16);
            String substring2 = str2.substring(str2.length() - 16, str2.length());
            SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = instance.getBlockSize();
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            instance.init(1, secretKeySpec, new IvParameterSpec(substring2.getBytes()));
            bArr = instance.doFinal(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        } catch (Exception e3) {
            e3.printStackTrace();
            bArr = null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    public static boolean c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String d() {
        if (!TextUtils.isEmpty(d.m)) {
            return d.m;
        }
        PackageInfo packageInfo = Utils.packageInfo;
        return packageInfo == null ? "N/A" : packageInfo.versionName;
    }

    public static void write(String str, String str2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            fileOutputStream.write(str2.getBytes());
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String e() {
        StringBuilder sb = new StringBuilder();
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces != null && allStackTraces.size() > 0) {
            for (Entry key : allStackTraces.entrySet()) {
                Thread thread = (Thread) key.getKey();
                StringBuilder sb2 = new StringBuilder();
                String str = "\n";
                if (thread != null) {
                    try {
                        sb2.append("threadId： ");
                        sb2.append(thread.getId());
                        sb2.append(str);
                        if (thread.getName() != null) {
                            sb2.append("name: ");
                            sb2.append(thread.getName());
                            sb2.append(str);
                        }
                        sb2.append("priority: ");
                        sb2.append(thread.getPriority());
                        sb2.append(str);
                        ThreadGroup threadGroup = thread.getThreadGroup();
                        if (threadGroup != null) {
                            String name = threadGroup.getName();
                            if (name != null) {
                                sb2.append("groupName: ");
                                sb2.append(name);
                                sb2.append(str);
                            }
                        }
                        sb2.append("state: ");
                        sb2.append(thread.getState());
                        sb2.append(str);
                        sb2.append("stacktrace: \n");
                        StackTraceElement[] stackTrace = thread.getStackTrace();
                        if (stackTrace != null && stackTrace.length > 0) {
                            for (StackTraceElement stackTraceElement : stackTrace) {
                                String methodName = stackTraceElement.getMethodName();
                                String str2 = "unknown";
                                if (methodName == null) {
                                    methodName = str2;
                                }
                                sb2.append("\tat ");
                                sb2.append(methodName);
                                sb2.append("(");
                                String fileName = stackTraceElement.getFileName();
                                if (fileName != null) {
                                    str2 = fileName;
                                }
                                sb2.append(str2);
                                sb2.append(Config.TRACE_TODAY_VISIT_SPLIT);
                                sb2.append(stackTraceElement.getLineNumber());
                                sb2.append(")\n");
                            }
                        }
                    } catch (Exception e2) {
                        a.a("ThreadInfo Collector Interrupted!!", e2);
                    }
                }
                sb.append(sb2.toString());
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", SapiDeviceInfo.f3010c);
            jSONObject.put("uid", j.a());
            jSONObject.put("appVN", d());
            jSONObject.put("channel", d.f5878b);
            jSONObject.put("pkgName", d.f5880d);
            jSONObject.put("sdkVN", "7.5.0");
            jSONObject.put("ndkVN", LivenessStat.TYPE_STRING_DEFAULT);
            jSONObject.put("appUsedCount", String.valueOf(h.f5906a.getInt("used_count", 0)));
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void g(String str) {
        SharedPreferences sharedPreferences = Utils.sharedPreferences;
        int i2 = 0;
        if (sharedPreferences != null) {
            i2 = sharedPreferences.getInt(str, 0);
        }
        if (!d.y) {
            i2++;
        }
        SharedPreferences sharedPreferences2 = Utils.sharedPreferences;
        if (sharedPreferences2 != null) {
            a(sharedPreferences2.edit().putInt(str, i2), true);
        }
    }

    public static boolean g() {
        SharedPreferences sharedPreferences = Utils.sharedPreferences;
        String str = "CrashSwitch yes";
        if (sharedPreferences != null ? sharedPreferences.getBoolean("crash_switch", true) : true) {
            a.b(str);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences2 = Utils.sharedPreferences;
        long j2 = 0;
        if (sharedPreferences2 != null) {
            j2 = sharedPreferences2.getLong("crash_switch_time", 0);
        }
        if (currentTimeMillis > j2) {
            a.b(str);
            return true;
        }
        a.b("CrashSwitch no");
        return false;
    }

    public static void h() {
        SharedPreferences sharedPreferences = Utils.sharedPreferences;
        if (sharedPreferences != null) {
            a(sharedPreferences.edit().putBoolean("crash_switch", true), true);
        }
    }

    public static void h(String str) {
        SharedPreferences sharedPreferences = Utils.sharedPreferences;
        if (sharedPreferences != null) {
            a(sharedPreferences.edit().remove(str), true);
        }
    }

    public static String i(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bytes);
            return c(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void i() {
        if (d.s != -1) {
            SharedPreferences sharedPreferences = Utils.sharedPreferences;
            if (sharedPreferences != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(j());
                String str = "oneday_anr_count";
                sb.append(str);
                int i2 = sharedPreferences.getInt(sb.toString(), 0) + 1;
                StringBuilder sb2 = new StringBuilder("addAnrUploadCount todayCount: ");
                sb2.append(i2);
                a.c(sb2.toString());
                Editor edit = Utils.sharedPreferences.edit();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(j());
                sb3.append(str);
                a(edit.putInt(sb3.toString(), i2), true);
            }
            d.w++;
        }
    }

    public static String j() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    }

    public static String j(String str) {
        String string = sharedPreferences.getString(str, "");
        StringBuilder sb = new StringBuilder("Get record appVN is: ");
        sb.append(string);
        a.b(sb.toString());
        return string;
    }

    public static void k(String str) {
        try {
            Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.commit();
            StringBuilder sb = new StringBuilder("delete local appVN: ");
            sb.append(str);
            a.b(sb.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            a.c("delete local appVN error!");
        }
    }

    public static String l(String str) {
        SharedPreferences sharedPreferences = Utils.sharedPreferences;
        StringBuilder sb = new StringBuilder("key_");
        sb.append(str);
        String string = sharedPreferences.getString(sb.toString(), "");
        if (TextUtils.isEmpty(string)) {
            StringBuilder sb2 = new StringBuilder("Not found the relative value. Key is: ");
            sb2.append(str);
            a.d(sb2.toString());
            String str2 = d.f5880d;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(str);
            String a2 = f.a(sb3.toString());
            StringBuilder sb4 = new StringBuilder("NoEncrypt_");
            sb4.append(a2);
            string = sb4.toString();
        }
        StringBuilder sb5 = new StringBuilder("Decrypted key is: ");
        sb5.append(string);
        sb5.append("; filename is: ");
        sb5.append(str);
        a.b(sb5.toString());
        return string;
    }

    public static void m(String str) {
        try {
            Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.commit();
            StringBuilder sb = new StringBuilder("delete local key: ");
            sb.append(str);
            a.b(sb.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
            a.c("delete local key error!");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0054 A[SYNTHETIC, Splitter:B:32:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005e A[SYNTHETIC, Splitter:B:37:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0065 A[SYNTHETIC, Splitter:B:42:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006f A[SYNTHETIC, Splitter:B:47:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] n(java.lang.String r6) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            r6.<init>(r1)     // Catch:{ Exception -> 0x004a, all -> 0x0045 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.<init>(r2)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x003b }
        L_0x0014:
            int r3 = r6.read(r2)     // Catch:{ Exception -> 0x003b }
            r4 = -1
            if (r3 == r4) goto L_0x0020
            r4 = 0
            r1.write(r2, r4, r3)     // Catch:{ Exception -> 0x003b }
            goto L_0x0014
        L_0x0020:
            r6.close()     // Catch:{ Exception -> 0x003b }
            r1.close()     // Catch:{ Exception -> 0x003b }
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x003b }
            r6.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0032:
            r1.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x0061
        L_0x0036:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0061
        L_0x003b:
            r2 = move-exception
            goto L_0x004d
        L_0x003d:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0063
        L_0x0042:
            r2 = move-exception
            r1 = r0
            goto L_0x004d
        L_0x0045:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
            goto L_0x0063
        L_0x004a:
            r2 = move-exception
            r6 = r0
            r1 = r6
        L_0x004d:
            java.lang.String r3 = "Get filebytes error!"
            e.c.b.f.a.a(r3, r2)     // Catch:{ all -> 0x0062 }
            if (r6 == 0) goto L_0x005c
            r6.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005c:
            if (r1 == 0) goto L_0x0061
            r1.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0061:
            return r0
        L_0x0062:
            r0 = move-exception
        L_0x0063:
            if (r6 == 0) goto L_0x006d
            r6.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r6 = move-exception
            r6.printStackTrace()
        L_0x006d:
            if (r1 == 0) goto L_0x0077
            r1.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0077:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.i.n(java.lang.String):byte[]");
    }

    public static String o(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            fileInputStream.close();
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int p(String str) {
        int i2;
        try {
            int a2 = new d.m.a.a(str).a("Orientation", 1);
            if (a2 == 6) {
                i2 = 90;
            } else if (a2 == 3) {
                i2 = HeadTrackerController.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (a2 != 8) {
                return 0;
            } else {
                i2 = HeadTrackerController.SCREEN_ORIENTATION_LANDSCAPE;
            }
            return i2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int b(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static long e(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        return file.length();
    }

    public static File[] f(String str) {
        File file = new File(str);
        return file.exists() ? file.listFiles() : new File[0];
    }

    public static String k() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String b(File file) {
        byte[] bArr = new byte[2048];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return c(instance.digest());
                }
            }
        } catch (Exception unused) {
            System.out.println(SapiUtils.f3014b);
            return null;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static e.c.d.d.d.a c(android.content.Context r5, java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -951770676: goto L_0x0034;
                case -393543490: goto L_0x002a;
                case 113011944: goto L_0x0020;
                case 254615876: goto L_0x0016;
                case 1138523277: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "wechatmoments"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r2
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "wechatfriend"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r3
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "weibo"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r1
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "qqfriend"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "qqzone"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r4
            goto L_0x003f
        L_0x003e:
            r6 = -1
        L_0x003f:
            if (r6 == 0) goto L_0x0063
            if (r6 == r4) goto L_0x005d
            if (r6 == r3) goto L_0x0057
            if (r6 == r2) goto L_0x0051
            if (r6 == r1) goto L_0x004b
            r5 = 0
            goto L_0x0069
        L_0x004b:
            e.c.d.d.d.c.f r6 = new e.c.d.d.d.c.f
            r6.<init>(r5)
            goto L_0x0068
        L_0x0051:
            e.c.d.d.d.c.e r6 = new e.c.d.d.d.c.e
            r6.<init>(r5)
            goto L_0x0068
        L_0x0057:
            e.c.d.d.d.c.e r6 = new e.c.d.d.d.c.e
            r6.<init>(r5)
            goto L_0x0068
        L_0x005d:
            e.c.d.d.d.c.d r6 = new e.c.d.d.d.c.d
            r6.<init>(r5)
            goto L_0x0068
        L_0x0063:
            e.c.d.d.d.c.c r6 = new e.c.d.d.d.c.c
            r6.<init>(r5)
        L_0x0068:
            r5 = r6
        L_0x0069:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.i.c(android.content.Context, java.lang.String):e.c.d.d.d.a");
    }

    public static boolean d(String str) {
        return a(new File(str));
    }

    public static String b(byte[] bArr) {
        int i2;
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        int length = bArr.length * 8;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 6;
        do {
            if (i3 > 0 && i7 > 0) {
                int i8 = (bArr[i4] & 255) << i7;
                int i9 = 8 - i7;
                i6 = (byte) (((byte) (i8 | ((bArr[i4 + 1] & 255) >> i9))) & 63);
                int i10 = i9;
                i7 = 6 - i9;
                i3 = i10;
            } else if (i3 == 0) {
                i6 = (byte) ((bArr[i4] & 255) >> (8 - i7));
                i3 = 2;
                i7 = 4;
            } else if (i7 == 0) {
                i6 = (byte) (bArr[i4] & 63);
                i3 = 0;
                i7 = 6;
            }
            sb.append(str.charAt(i6));
            i5 += 6;
            i4 = i5 / 8;
            i2 = length - i5;
        } while (i2 >= 6);
        if (i2 > 0) {
            sb.append(str.charAt((byte) ((bArr[bArr.length - 1] << (6 - i2)) & 63)));
        }
        int i11 = length % 3;
        for (int i12 = 0; i12 < i11; i12++) {
            sb.append("=");
        }
        return sb.toString();
    }

    @SuppressLint({"DefaultLocale"})
    public static String c(long j2) {
        if (j2 >= 1073741824) {
            return String.format("%.1f GB", new Object[]{Float.valueOf(((float) j2) / 1.07374182E9f)});
        } else if (j2 >= 1048576) {
            return String.format("%.1f MB", new Object[]{Float.valueOf(((float) j2) / 1048576.0f)});
        } else if (j2 > AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
            return String.format("%.1f KB", new Object[]{Float.valueOf(((float) j2) / 1024.0f)});
        } else {
            return String.format("%d B", new Object[]{Long.valueOf(j2)});
        }
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(b3));
        }
        return sb.toString();
    }

    public static int c(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        int i2 = 0;
        for (File file2 : listFiles) {
            i2++;
            if (file.isDirectory()) {
                i2 = c(new File(file2.getAbsolutePath())) + i2;
            }
        }
        return i2;
    }

    public static void b(String str) {
        int p = p(str);
        if (p != 0) {
            try {
                a(a(p, BitmapFactory.decodeFile(str)), str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(int i2) {
        SharedPreferences sharedPreferences = Utils.sharedPreferences;
        if (sharedPreferences != null) {
            a(sharedPreferences.edit().putBoolean("crash_switch", false), true);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(5, instance.get(5) + i2);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        SharedPreferences sharedPreferences2 = Utils.sharedPreferences;
        if (sharedPreferences2 != null) {
            a(sharedPreferences2.edit().putLong("crash_switch_time", timeInMillis), true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x012b A[SYNTHETIC, Splitter:B:102:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0135 A[SYNTHETIC, Splitter:B:108:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fd A[SYNTHETIC, Splitter:B:71:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0107 A[SYNTHETIC, Splitter:B:77:0x0107] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0111 A[SYNTHETIC, Splitter:B:83:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0121 A[SYNTHETIC, Splitter:B:96:0x0121] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.Class<e.c.b.e.i> r0 = e.c.b.e.i.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            java.lang.String r2 = "writeFile: "
            r1.<init>(r2)     // Catch:{ all -> 0x013e }
            r1.append(r7)     // Catch:{ all -> 0x013e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x013e }
            e.c.b.f.a.a(r1)     // Catch:{ all -> 0x013e }
            android.content.SharedPreferences r1 = k     // Catch:{ all -> 0x013e }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x013e }
            java.lang.String r2 = d()     // Catch:{ all -> 0x013e }
            r1.putString(r7, r2)     // Catch:{ all -> 0x013e }
            r1.commit()     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            java.lang.String r2 = "FileName when write is: "
            r1.<init>(r2)     // Catch:{ all -> 0x013e }
            r1.append(r7)     // Catch:{ all -> 0x013e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x013e }
            e.c.b.f.a.b(r1)     // Catch:{ all -> 0x013e }
            boolean r1 = e.c.b.d.B     // Catch:{ all -> 0x013e }
            if (r1 == 0) goto L_0x0092
            java.lang.String r1 = e.c.b.d.f5880d     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            r2.<init>()     // Catch:{ all -> 0x013e }
            r2.append(r1)     // Catch:{ all -> 0x013e }
            r2.append(r7)     // Catch:{ all -> 0x013e }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x013e }
            java.lang.String r1 = e.c.b.e.f.a(r1)     // Catch:{ all -> 0x013e }
            java.lang.String r8 = c(r8, r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0059
        L_0x0053:
            r2 = move-exception
            java.lang.String r3 = "crash content AES failed!"
            e.c.b.f.a.a(r3, r2)     // Catch:{ all -> 0x013e }
        L_0x0059:
            java.lang.String r2 = e.c.b.f.c.a(r1)     // Catch:{ Exception -> 0x006f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006f }
            java.lang.String r4 = "key_"
            r3.<init>(r4)     // Catch:{ Exception -> 0x006f }
            r3.append(r7)     // Catch:{ Exception -> 0x006f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x006f }
            b(r3, r2)     // Catch:{ Exception -> 0x006f }
            goto L_0x0092
        L_0x006f:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            java.lang.String r4 = "key_"
            r3.<init>(r4)     // Catch:{ all -> 0x013e }
            r3.append(r7)     // Catch:{ all -> 0x013e }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x013e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013e }
            java.lang.String r5 = "NoEncrypt_"
            r4.<init>(r5)     // Catch:{ all -> 0x013e }
            r4.append(r1)     // Catch:{ all -> 0x013e }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x013e }
            b(r3, r1)     // Catch:{ all -> 0x013e }
            r2.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x0092:
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r6 = r6.openFileOutput(r7, r1)     // Catch:{ Exception -> 0x00f5, all -> 0x00f1 }
            java.lang.String r7 = "UTF-8"
            byte[] r7 = r8.getBytes(r7)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            boolean r8 = e.c.b.d.C     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            if (r8 == 0) goto L_0x00c3
            java.util.zip.Deflater r8 = new java.util.zip.Deflater     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r1 = 9
            r3 = 1
            r8.<init>(r1, r3)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            java.util.zip.DeflaterOutputStream r1 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x00c1 }
            r1.<init>(r6, r8)     // Catch:{ Exception -> 0x00c1 }
            r1.write(r7)     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
            r1.close()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
            r8.end()     // Catch:{ Exception -> 0x00be, all -> 0x00ba }
            r2 = r1
            goto L_0x00ca
        L_0x00ba:
            r7 = move-exception
            r2 = r1
            goto L_0x011f
        L_0x00be:
            r7 = move-exception
            r2 = r1
            goto L_0x00f8
        L_0x00c1:
            r7 = move-exception
            goto L_0x00f8
        L_0x00c3:
            r6.write(r7)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r6.close()     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r8 = r2
        L_0x00ca:
            if (r2 == 0) goto L_0x00d4
            r2.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x00d4:
            if (r6 == 0) goto L_0x00de
            r6.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x00de:
            if (r8 == 0) goto L_0x011c
            r8.end()     // Catch:{ Exception -> 0x00e5 }
            monitor-exit(r0)
            return
        L_0x00e5:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x013e }
            monitor-exit(r0)
            return
        L_0x00eb:
            r7 = move-exception
            r8 = r2
            goto L_0x011f
        L_0x00ee:
            r7 = move-exception
            r8 = r2
            goto L_0x00f8
        L_0x00f1:
            r7 = move-exception
            r6 = r2
            r8 = r6
            goto L_0x011f
        L_0x00f5:
            r7 = move-exception
            r6 = r2
            r8 = r6
        L_0x00f8:
            r7.printStackTrace()     // Catch:{ all -> 0x011e }
            if (r2 == 0) goto L_0x0105
            r2.close()     // Catch:{ IOException -> 0x0101 }
            goto L_0x0105
        L_0x0101:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x0105:
            if (r6 == 0) goto L_0x010f
            r6.close()     // Catch:{ IOException -> 0x010b }
            goto L_0x010f
        L_0x010b:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x010f:
            if (r8 == 0) goto L_0x011c
            r8.end()     // Catch:{ Exception -> 0x0116 }
            monitor-exit(r0)
            return
        L_0x0116:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x013e }
            monitor-exit(r0)
            return
        L_0x011c:
            monitor-exit(r0)
            return
        L_0x011e:
            r7 = move-exception
        L_0x011f:
            if (r2 == 0) goto L_0x0129
            r2.close()     // Catch:{ IOException -> 0x0125 }
            goto L_0x0129
        L_0x0125:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x0129:
            if (r6 == 0) goto L_0x0133
            r6.close()     // Catch:{ IOException -> 0x012f }
            goto L_0x0133
        L_0x012f:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x0133:
            if (r8 == 0) goto L_0x013d
            r8.end()     // Catch:{ Exception -> 0x0139 }
            goto L_0x013d
        L_0x0139:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x013e }
        L_0x013d:
            throw r7     // Catch:{ all -> 0x013e }
        L_0x013e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.i.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void a(Map<String, Object> map) {
        String str;
        if (map != null) {
            map.put("did", map.get("CUID"));
            map.put("language", a.a.a.a.b.a.f401j.getLanguage());
            map.put("country", a.a.a.a.b.a.f401j.getCountry());
            map.put("sdkVN", map.get("batVN"));
            map.put("reportOsVN", VERSION.RELEASE);
            map.put("reportAppVN", d());
            PackageInfo packageInfo = Utils.packageInfo;
            map.put("reportAppVC", Integer.valueOf(packageInfo == null ? 0 : packageInfo.versionCode));
            map.put("reportSdkVN", "7.5.0");
            map.put("appName", c());
            String str2 = "phoneTime";
            map.put("occurrenceTime", d.x.format(map.get(str2) != null ? map.get(str2) : Long.valueOf(System.currentTimeMillis())));
            map.put("cpuInfo", map.get("myAppCPUStat"));
            map.put("diskInfo", map.get("internalStorageInfo"));
            map.put("memoryInfo", map.get("memInfo"));
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long availableBlocks = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                StringBuilder sb = new StringBuilder("Total: ");
                sb.append(b(blockCount));
                sb.append(" Used: ");
                sb.append(b(blockCount - availableBlocks));
                sb.append(" Free: ");
                sb.append(b(availableBlocks));
                str = sb.toString();
            } catch (Exception unused) {
                str = "N/A";
            }
            map.put("SDInfo", str);
            map.put("netType", a());
            map.put("startTime", d.x.format(map.get("startupTime") != null ? map.get(str2) : Long.valueOf(System.currentTimeMillis())));
            map.put("occurrencePage", map.get("curPage"));
            map.put("pagePath", map.get("pageHistory"));
            String str3 = "allThreadStacks";
            map.put("allThreads", map.get(str3));
            map.remove(str3);
            map.put("reason", map.get("errorOriLine"));
        }
    }

    public static void a(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static j a(k kVar, FrameLayout frameLayout) {
        int ordinal = kVar.ordinal();
        if (ordinal == 0) {
            return new e.c.d.i.b.i(frameLayout);
        }
        if (ordinal != 2) {
            return new h(frameLayout);
        }
        return new e.c.d.i.b.i(frameLayout);
    }

    public static void a(String str, int i2) {
        Toast toast = new Toast(App.f1954b);
        toast.setGravity(17, 0, 0);
        View inflate = LayoutInflater.from(App.f1954b).inflate(R.layout.normal_toast, null);
        TextView textView = (TextView) inflate.findViewById(R.id.text);
        if (textView != null) {
            textView.setText(str);
        }
        toast.setView(inflate);
        toast.setDuration(i2);
        toast.show();
    }

    public static String a(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            String str = "";
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.graphics.Bitmap r5, int r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x0036
            if (r6 > 0) goto L_0x0006
            goto L_0x0036
        L_0x0006:
            int r1 = r5.getWidth()
            int r2 = r5.getHeight()
            if (r1 < r6) goto L_0x0035
            if (r2 < r6) goto L_0x0035
            int r3 = java.lang.Math.max(r1, r2)
            int r3 = r3 * r6
            int r4 = java.lang.Math.min(r1, r2)
            int r3 = r3 / r4
            if (r1 <= r2) goto L_0x0020
            r4 = r3
            goto L_0x0021
        L_0x0020:
            r4 = r6
        L_0x0021:
            if (r1 <= r2) goto L_0x0024
            r3 = r6
        L_0x0024:
            r1 = 1
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createScaledBitmap(r5, r4, r3, r1)     // Catch:{ Exception -> 0x0034 }
            int r4 = r4 - r6
            int r4 = r4 / 2
            int r3 = r3 - r6
            int r3 = r3 / 2
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r4, r3, r6, r6)     // Catch:{  }
            goto L_0x0035
        L_0x0034:
            return r0
        L_0x0035:
            return r5
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.b.e.i.a(android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static byte[] a(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    public static List<String> a(String str, String str2, boolean z, boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            Utils.d.a.h.b(new File(str), new File(str2), new a(arrayList, str2, z2, arrayList2));
        } else {
            Utils.d.a.h.b(new File(str), new File(str2), new b(str2, z2, arrayList2));
        }
        if (z2) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                e.c.d.n.d dVar = (e.c.d.n.d) it.next();
                arrayList.addAll(a(dVar.f6874a, dVar.f6875b, z, true, z3));
            }
        }
        if (z3) {
            d(str);
        }
        return arrayList;
    }

    public static /* synthetic */ String a(List list, String str, boolean z, List list2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str3 = BceConfig.BOS_DELIMITER;
        sb.append(str3);
        sb.append(str2);
        list.add(sb.toString());
        if (str2.endsWith(".zip")) {
            String a2 = e.a.a.a.a.a(str, str3, str2);
            String substring = a2.substring(0, a2.length() - 4);
            if (z) {
                list2.add(new e.c.d.n.d(a2, substring));
            }
        }
        return str2;
    }

    public static String a(float f2) {
        if (0.0f == f2) {
            return "0";
        }
        if (0.5d == ((double) f2)) {
            return "1/2";
        }
        if (0.2f == f2) {
            return "1/5";
        }
        if (0.1f == f2) {
            return "1/10";
        }
        if (0.06666f == f2) {
            return "1/15";
        }
        if (0.03333f == f2) {
            return "1/30";
        }
        if (0.02f == f2) {
            return "1/50";
        }
        if (0.01666f == f2) {
            return "1/60";
        }
        if (0.01f == f2) {
            return "1/100";
        }
        if (0.00833f == f2) {
            return "1/120";
        }
        if (0.002f == f2) {
            return "1/500";
        }
        if (0.001f == f2) {
            return "1/1000";
        }
        if (5.0E-4f == f2) {
            return "1/2000";
        }
        if (2.5E-4f == f2) {
            return "1/4000";
        }
        return 1.25E-4f == f2 ? "1/8000" : String.valueOf(f2);
    }

    public static void a(Context context, List<String> list) {
        for (String str : list) {
            try {
                if (!new File(str).isDirectory()) {
                    d.m.a.a aVar = new d.m.a.a(str);
                    String format = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss", Locale.getDefault()).format(new Date());
                    aVar.a("DateTimeOriginal", format);
                    aVar.a("DateTime", format);
                    aVar.a("DateTimeDigitized", format);
                    aVar.d();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        MediaScannerConnection.scanFile(context, (String[]) list.toArray(new String[0]), null, null);
    }

    public static /* synthetic */ String a(String str, boolean z, List list, String str2) {
        if (str2.endsWith(".zip")) {
            String a2 = e.a.a.a.a.a(str, BceConfig.BOS_DELIMITER, str2);
            String substring = str.substring(0, str.length() - 4);
            if (z) {
                list.add(new e.c.d.n.d(a2, substring));
            }
        }
        return str2;
    }

    public static boolean a(Bitmap bitmap, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(CompressFormat.JPEG, 93, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(File file) {
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return file.delete();
        }
        for (File a2 : listFiles) {
            if (!a(a2)) {
                return false;
            }
        }
        return file.delete();
    }

    public static Bitmap a(int i2, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
