package e.c.f.n;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import android.view.WindowManager;
import com.arashivision.graphicpath.render.source.AutoStitcherLib;
import com.arashivision.insbase.arlog.MultipartUtility;
import com.arashivision.insta360.basecamera.camera.BaseCamera;
import com.arashivision.insta360.basecamera.camera.CameraType;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidubce.services.bos.BosClientConfiguration;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.gyf.immersionbar.NotchUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.tencent.connect.common.Constants;
import d.b.p.x0;
import d.h.k.m;
import e.d.a.n.p.c.w;
import e.g.a.a.e0.i;
import e.g.a.a.t.c.C0111c;
import g.r;
import j.a.a.b.i.a;
import j.a.a.b.i.b;
import j.a.a.b.i.c;
import j.a.a.b.i.d;
import j.a.a.b.i.e;
import j.a.a.b.i.f;
import j.a.a.b.i.g;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* compiled from: TrafficStatsUtils */
public final class n {
    public static float a(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static g a(BaseCamera baseCamera) {
        if (CameraType.ONEX.type.equals(baseCamera.getCameraType())) {
            return new d(baseCamera);
        }
        if (CameraType.ONEX2.type.equals(baseCamera.getCameraType())) {
            return new c(baseCamera);
        }
        if (CameraType.AKIKO.type.equals(baseCamera.getCameraType())) {
            int ResolveLensTypeFromOffset = AutoStitcherLib.ResolveLensTypeFromOffset(baseCamera.getMediaOffset());
            if (ResolveLensTypeFromOffset == 33) {
                return new a(baseCamera);
            }
            if (ResolveLensTypeFromOffset != 35) {
                return new f(baseCamera);
            }
            return new e(baseCamera);
        } else if (CameraType.NANOS.type.equals(baseCamera.getCameraType())) {
            return new b(baseCamera);
        } else {
            if (TextUtils.isEmpty(baseCamera.getCameraType())) {
                return new b(baseCamera);
            }
            return new d(baseCamera);
        }
    }

    public static boolean a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    /* JADX INFO: finally extract failed */
    public static ImageType b(List<ImageHeaderParser> list, InputStream inputStream, e.d.a.n.n.c0.b bVar) throws IOException {
        ImageType imageType;
        if (inputStream == null) {
            return ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new w(inputStream, bVar);
        }
        inputStream.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                imageType = ImageType.UNKNOWN;
                break;
            }
            try {
                imageType = ((ImageHeaderParser) list.get(i2)).a(inputStream);
                inputStream.reset();
                if (imageType != ImageType.UNKNOWN) {
                    break;
                }
                i2++;
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return imageType;
    }

    public static boolean b(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308;
    }

    public static boolean c(String str) {
        return str.equals(Constants.HTTP_POST) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith(MultipartUtility.TWO_HYPHENS)) {
            return str.substring(2, str.length());
        }
        if (str.startsWith("-")) {
            str = str.substring(1, str.length());
        }
        return str;
    }

    public static boolean e(String str) {
        return j.a.a.a.a.a(str, "1.1.0") >= 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0191, code lost:
        if (r5.getType() == 1) goto L_0x0193;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:129:0x0194 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0151 A[Catch:{ JSONException -> 0x0203 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0160 A[Catch:{ JSONException -> 0x0203 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0175 A[Catch:{ Exception -> 0x0194 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x019a A[Catch:{ JSONException -> 0x0203 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01af A[Catch:{ JSONException -> 0x0203 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0130 A[Catch:{ JSONException -> 0x0203 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0145 A[Catch:{ SecurityException -> 0x014a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(android.content.Context r10) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "batterycurrentcapacity"
            java.lang.String r2 = "wifi"
            java.lang.String r3 = "phone"
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0021 }
            r5.<init>()     // Catch:{ Exception -> 0x0021 }
            java.lang.String r6 = "Android "
            r5.append(r6)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x0021 }
            r5.append(r6)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0021 }
            goto L_0x0022
        L_0x0021:
            r5 = r0
        L_0x0022:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0203 }
            if (r6 != 0) goto L_0x002d
            java.lang.String r6 = "os"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0203 }
        L_0x002d:
            java.lang.Object r5 = r10.getSystemService(r3)     // Catch:{ Exception -> 0x0038 }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ Exception -> 0x0038 }
            java.lang.String r5 = r5.getDeviceId()     // Catch:{ Exception -> 0x0038 }
            goto L_0x0039
        L_0x0038:
            r5 = r0
        L_0x0039:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0203 }
            if (r6 != 0) goto L_0x0044
            java.lang.String r6 = "imei"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0203 }
        L_0x0044:
            java.lang.Object r5 = r10.getSystemService(r3)     // Catch:{ Exception -> 0x004f }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r5.getDeviceId()     // Catch:{ Exception -> 0x004f }
            goto L_0x0050
        L_0x004f:
            r5 = r0
        L_0x0050:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0203 }
            if (r6 != 0) goto L_0x005b
            java.lang.String r6 = "meid"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0203 }
        L_0x005b:
            java.lang.Object r5 = r10.getSystemService(r3)     // Catch:{ Exception -> 0x0066 }
            android.telephony.TelephonyManager r5 = (android.telephony.TelephonyManager) r5     // Catch:{ Exception -> 0x0066 }
            java.lang.String r5 = r5.getSubscriberId()     // Catch:{ Exception -> 0x0066 }
            goto L_0x0067
        L_0x0066:
            r5 = r0
        L_0x0067:
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0203 }
            if (r6 != 0) goto L_0x0072
            java.lang.String r6 = "imsi"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0203 }
        L_0x0072:
            java.lang.String r5 = e(r10)     // Catch:{ JSONException -> 0x0203 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0203 }
            if (r6 != 0) goto L_0x0081
            java.lang.String r6 = "mac"
            r4.put(r6, r5)     // Catch:{ JSONException -> 0x0203 }
        L_0x0081:
            java.lang.Object r3 = r10.getSystemService(r3)     // Catch:{ Exception -> 0x008c }
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch:{ Exception -> 0x008c }
            java.lang.String r3 = r3.getSimSerialNumber()     // Catch:{ Exception -> 0x008c }
            goto L_0x008d
        L_0x008c:
            r3 = r0
        L_0x008d:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x0098
            java.lang.String r5 = "iccid"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x0098:
            java.lang.String r3 = b()     // Catch:{ JSONException -> 0x0203 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x00a7
            java.lang.String r5 = "serial"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x00a7:
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r5 = "android_id"
            java.lang.String r3 = android.provider.Settings.Secure.getString(r3, r5)     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00b3
        L_0x00b2:
            r3 = r0
        L_0x00b3:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x00be
            java.lang.String r5 = "androidid"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x00be:
            java.lang.String r3 = android.os.Build.CPU_ABI     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c2
        L_0x00c1:
            r3 = r0
        L_0x00c2:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x00cd
            java.lang.String r5 = "cpu"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x00cd:
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00d1
        L_0x00d0:
            r3 = r0
        L_0x00d1:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x00dc
            java.lang.String r5 = "model"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x00dc:
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x00f9 }
            android.os.StatFs r5 = new android.os.StatFs     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r3 = r3.getPath()     // Catch:{ Exception -> 0x00f9 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x00f9 }
            int r3 = r5.getBlockSize()     // Catch:{ Exception -> 0x00f9 }
            long r6 = (long) r3     // Catch:{ Exception -> 0x00f9 }
            int r3 = r5.getBlockCount()     // Catch:{ Exception -> 0x00f9 }
            long r8 = (long) r3     // Catch:{ Exception -> 0x00f9 }
            long r8 = r8 * r6
            java.lang.String r3 = java.lang.Long.toString(r8)     // Catch:{ Exception -> 0x00f9 }
            goto L_0x00fa
        L_0x00f9:
            r3 = r0
        L_0x00fa:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x0105
            java.lang.String r5 = "sdcard"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x0105:
            java.lang.String r3 = g(r10)     // Catch:{ JSONException -> 0x0203 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x0114
            java.lang.String r5 = "resolution"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x0114:
            android.content.Context r3 = r10.getApplicationContext()     // Catch:{ JSONException -> 0x0203 }
            java.lang.Object r3 = r3.getSystemService(r2)     // Catch:{ JSONException -> 0x0203 }
            android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3     // Catch:{ JSONException -> 0x0203 }
            android.net.wifi.WifiInfo r3 = r3.getConnectionInfo()     // Catch:{ Exception -> 0x0129 }
            if (r3 == 0) goto L_0x0129
            java.lang.String r3 = r3.getSSID()     // Catch:{ Exception -> 0x0129 }
            goto L_0x012a
        L_0x0129:
            r3 = r0
        L_0x012a:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x0135
            java.lang.String r5 = "ssid"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x0135:
            android.content.Context r3 = r10.getApplicationContext()     // Catch:{ JSONException -> 0x0203 }
            java.lang.Object r3 = r3.getSystemService(r2)     // Catch:{ JSONException -> 0x0203 }
            android.net.wifi.WifiManager r3 = (android.net.wifi.WifiManager) r3     // Catch:{ JSONException -> 0x0203 }
            android.net.wifi.WifiInfo r3 = r3.getConnectionInfo()     // Catch:{ SecurityException -> 0x014a }
            if (r3 == 0) goto L_0x014a
            java.lang.String r3 = r3.getBSSID()     // Catch:{ SecurityException -> 0x014a }
            goto L_0x014b
        L_0x014a:
            r3 = r0
        L_0x014b:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x0156
            java.lang.String r5 = "bssid"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x0156:
            java.lang.String r3 = android.os.Build.BRAND     // Catch:{ Exception -> 0x0159 }
            goto L_0x015a
        L_0x0159:
            r3 = r0
        L_0x015a:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r5 != 0) goto L_0x0165
            java.lang.String r5 = "deviceName"
            r4.put(r5, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x0165:
            java.lang.String r3 = "none"
            java.lang.String r5 = "connectivity"
            java.lang.Object r5 = r10.getSystemService(r5)     // Catch:{ Exception -> 0x0194 }
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch:{ Exception -> 0x0194 }
            android.net.NetworkInfo r5 = r5.getActiveNetworkInfo()     // Catch:{ Exception -> 0x0194 }
            if (r5 == 0) goto L_0x0194
            int r6 = r5.getType()     // Catch:{ Exception -> 0x0194 }
            if (r6 != 0) goto L_0x018c
            int r2 = r5.getSubtype()     // Catch:{ Exception -> 0x0194 }
            switch(r2) {
                case 1: goto L_0x0189;
                case 2: goto L_0x0189;
                case 3: goto L_0x0186;
                case 4: goto L_0x0189;
                case 5: goto L_0x0186;
                case 6: goto L_0x0186;
                case 7: goto L_0x0189;
                case 8: goto L_0x0186;
                case 9: goto L_0x0186;
                case 10: goto L_0x0186;
                case 11: goto L_0x0189;
                case 12: goto L_0x0186;
                case 13: goto L_0x0183;
                case 14: goto L_0x0186;
                case 15: goto L_0x0186;
                default: goto L_0x0182;
            }     // Catch:{ Exception -> 0x0194 }
        L_0x0182:
            goto L_0x0194
        L_0x0183:
            java.lang.String r2 = "4G"
            goto L_0x0193
        L_0x0186:
            java.lang.String r2 = "3G"
            goto L_0x0193
        L_0x0189:
            java.lang.String r2 = "2G"
            goto L_0x0193
        L_0x018c:
            int r5 = r5.getType()     // Catch:{ Exception -> 0x0194 }
            r6 = 1
            if (r5 != r6) goto L_0x0194
        L_0x0193:
            r3 = r2
        L_0x0194:
            boolean r2 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0203 }
            if (r2 != 0) goto L_0x019f
            java.lang.String r2 = "connecttype"
            r4.put(r2, r3)     // Catch:{ JSONException -> 0x0203 }
        L_0x019f:
            java.lang.String r2 = c(r10)     // Catch:{ Exception -> 0x01a4 }
            goto L_0x01a9
        L_0x01a4:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ JSONException -> 0x0203 }
            r2 = r0
        L_0x01a9:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0203 }
            if (r3 != 0) goto L_0x01b4
            java.lang.String r3 = "ua"
            r4.put(r3, r2)     // Catch:{ JSONException -> 0x0203 }
        L_0x01b4:
            double r2 = d(r10)     // Catch:{ JSONException -> 0x0203 }
            java.lang.String r5 = "batterymaxcapacity"
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x0203 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0203 }
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x0203 }
            r4.put(r1, r5)     // Catch:{ JSONException -> 0x0203 }
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ JSONException -> 0x0203 }
            java.lang.String r6 = "android.intent.action.BATTERY_CHANGED"
            r5.<init>(r6)     // Catch:{ JSONException -> 0x0203 }
            r6 = 0
            android.content.Intent r10 = r10.registerReceiver(r6, r5)     // Catch:{ JSONException -> 0x0203 }
            java.lang.String r5 = "batterycurrentvoltage"
            java.lang.String r6 = "voltage"
            r7 = 0
            int r6 = r10.getIntExtra(r6, r7)     // Catch:{ JSONException -> 0x0203 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0203 }
            java.lang.String r5 = "batterycurrenttemperature"
            java.lang.String r6 = "temperature"
            int r6 = r10.getIntExtra(r6, r7)     // Catch:{ JSONException -> 0x0203 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0203 }
            java.lang.String r5 = "level"
            int r5 = r10.getIntExtra(r5, r7)     // Catch:{ JSONException -> 0x0203 }
            double r5 = (double) r5     // Catch:{ JSONException -> 0x0203 }
            double r2 = r2 * r5
            java.lang.String r5 = "scale"
            int r10 = r10.getIntExtra(r5, r7)     // Catch:{ JSONException -> 0x0203 }
            double r5 = (double) r10     // Catch:{ JSONException -> 0x0203 }
            double r2 = r2 / r5
            r4.put(r1, r2)     // Catch:{ JSONException -> 0x0203 }
            java.lang.String r10 = r4.toString()     // Catch:{ JSONException -> 0x0203 }
            goto L_0x0204
        L_0x0203:
            r10 = r0
        L_0x0204:
            java.lang.String r1 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0210 }
            byte[] r10 = r10.getBytes()     // Catch:{ UnsupportedEncodingException -> 0x0210 }
            java.lang.String r2 = "UTF-8"
            r1.<init>(r10, r2)     // Catch:{ UnsupportedEncodingException -> 0x0210 }
            r0 = r1
        L_0x0210:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.n.f(android.content.Context):java.lang.String");
    }

    public static String g(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(displayMetrics.widthPixels));
            sb.append("*");
            sb.append(String.valueOf(displayMetrics.heightPixels));
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Calendar e() {
        return b((Calendar) null);
    }

    public static String e(Context context) {
        String str = "";
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return str;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte valueOf : hardwareAddress) {
                        sb.append(String.format("%02X:", new Object[]{Byte.valueOf(valueOf)}));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static Calendar d() {
        return a(Calendar.getInstance());
    }

    public static TimeZone c() {
        return TimeZone.getTimeZone("UTC");
    }

    public static double d(Context context) {
        Object obj;
        String str = "com.android.internal.os.PowerProfile";
        try {
            obj = Class.forName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (Exception unused) {
            obj = null;
        }
        try {
            return ((Double) Class.forName(str).getMethod("getAveragePower", new Class[]{String.class}).invoke(obj, new Object[]{"battery.capacity"})).doubleValue();
        } catch (Exception unused2) {
            return 0.0d;
        }
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = (TextUtils.isEmpty(packageName) || !packageName.contains(WeiboAppManager.WEIBO_PACKAGENAME)) ? "ssosdk" : "weibo";
        sb.append(Build.MANUFACTURER);
        sb.append("-");
        String str2 = "__";
        e.a.a.a.a.a(sb, Build.MODEL, str2, str, str2);
        try {
            sb.append("1.0".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb.append("unknown");
        }
        sb.append(str2);
        sb.append(SapiDeviceInfo.f3010c);
        sb.append("__android");
        sb.append(VERSION.RELEASE);
        return sb.toString();
    }

    public static boolean b(String str) {
        return c(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static <T> Class<? extends T> a(String str, Class<T> cls) {
        try {
            return Class.forName(str).asSubclass(cls);
        } catch (ClassNotFoundException e2) {
            throw new i.d.a.g((Exception) e2);
        } catch (ClassCastException e3) {
            throw new i.d.a.g((Exception) e3);
        }
    }

    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v6, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[Catch:{ all -> 0x004c }] */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.Context r7) {
        /*
            java.lang.String r0 = "rpandid"
            java.lang.String r1 = ""
            java.lang.String r2 = "leroadcfg"
            r3 = 0
            r4 = 4
            android.content.SharedPreferences r5 = r7.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            r5.edit()     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences r2 = r7.getSharedPreferences(r2, r4)     // Catch:{ all -> 0x0026 }
            android.content.SharedPreferences$Editor r3 = r2.edit()     // Catch:{ all -> 0x0021 }
            java.lang.String r5 = "re_po_rt"
            android.content.SharedPreferences r4 = r7.getSharedPreferences(r5, r4)     // Catch:{ all -> 0x0021 }
            r4.edit()     // Catch:{ all -> 0x0021 }
            goto L_0x0031
        L_0x0021:
            r4 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0028
        L_0x0026:
            r4 = move-exception
            r2 = r3
        L_0x0028:
            r4.getMessage()     // Catch:{ all -> 0x004c }
            e.c.f.c.c()     // Catch:{ all -> 0x004c }
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0031:
            java.lang.String r1 = r2.getString(r0, r1)     // Catch:{ all -> 0x004c }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x004f
            java.lang.String r1 = e.c.f.n.c.f(r7)     // Catch:{ all -> 0x004c }
            boolean r7 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x004c }
            if (r7 != 0) goto L_0x004f
            r3.putString(r0, r1)     // Catch:{ all -> 0x004c }
            r3.commit()     // Catch:{ all -> 0x004c }
            goto L_0x004f
        L_0x004c:
            e.c.f.c.d()
        L_0x004f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.n.b(android.content.Context):java.lang.String");
    }

    public static boolean a(Uri uri) {
        if (uri != null) {
            if (Config.LAUNCH_CONTENT.equals(uri.getScheme())) {
                if ("media".equals(uri.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            throw new i.d.a.g((Exception) e2);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable unused) {
            e.c.f.c.d();
        }
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static float a(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    public static void a(Cursor cursor) {
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            int type = cursor.getType(0);
            if (type != 0 && type != 4) {
                cursor.getString(0);
            }
        }
    }

    public static Object a(Method method, Object obj, Object... objArr) throws i.d.a.g {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new i.d.a.g((Exception) e2);
        } catch (InvocationTargetException e3) {
            throw new i.d.a.g((Exception) e3);
        } catch (IllegalArgumentException e4) {
            throw new i.d.a.g((Exception) e4);
        }
    }

    public static Calendar b(Calendar calendar) {
        Calendar instance = Calendar.getInstance(c());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        if (typedArray.hasValue(i2)) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                Drawable b2 = d.b.l.a.a.b(context, resourceId);
                if (b2 != null) {
                    return b2;
                }
            }
        }
        return typedArray.getDrawable(i2);
    }

    public static void a(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = (Animator) list.get(i2);
            j2 = Math.max(j2, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 0});
        ofInt.setDuration(j2);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static String b() {
        Class<String> cls = String.class;
        String str = "";
        if (VERSION.SDK_INT >= 26) {
            try {
                str = Build.getSerial();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str;
        }
        try {
            Class cls2 = Class.forName(NotchUtils.SYSTEM_PROPERTIES);
            str = (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{"ro.serialno", "unknown"});
        } catch (Exception unused) {
        }
        return str;
    }

    public static e.g.a.a.e0.d a(int i2) {
        if (i2 == 0) {
            return new i();
        }
        if (i2 != 1) {
            return new i();
        }
        return new e.g.a.a.e0.e();
    }

    public static Bitmap a(Context context, int i2, int i3, int i4) {
        if (context == null || i2 <= 0 || i3 <= 0 || i4 == 0) {
            return null;
        }
        return a(i2, i3, context.getResources().getDrawable(i4, null));
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: used method not loaded: e.g.b.w.<init>(java.lang.Throwable):null, types can be incorrect */
    /* JADX INFO: used method not loaded: e.g.b.p.<init>(java.lang.Throwable):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new e.g.b.p((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new e.g.b.w((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return e.g.b.q.f8584a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new e.g.b.w((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new e.g.b.w((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: d (r2v4 'e' e.g.b.e0.d A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static e.g.b.o a(e.g.b.e0.a r2) throws e.g.b.s {
        /*
            r2.A()     // Catch:{ EOFException -> 0x0024, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            e.g.b.z<e.g.b.o> r1 = com.google.gson.internal.bind.TypeAdapters.X     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.a(r2)     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            e.g.b.o r2 = (e.g.b.o) r2     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            e.g.b.w r0 = new e.g.b.w
            r0.<init>(r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            e.g.b.p r0 = new e.g.b.p
            r0.<init>(r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            e.g.b.w r0 = new e.g.b.w
            r0.<init>(r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            e.g.b.q r2 = e.g.b.q.f8584a
            return r2
        L_0x002b:
            e.g.b.w r0 = new e.g.b.w
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.n.a(e.g.b.e0.a):e.g.b.o");
    }

    public static TypedValue a(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        if (typedArray.hasValue(i2)) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                ColorStateList a2 = d.b.l.a.a.a(context, resourceId);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return typedArray.getColorStateList(i2);
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.content.SharedPreferences] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r4v6, types: [android.content.SharedPreferences$Editor] */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0067 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d A[Catch:{ all -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0054 A[SYNTHETIC, Splitter:B:17:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0071 A[Catch:{ all -> 0x00a4, all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r11) {
        /*
            java.lang.String r0 = "rpiiem"
            java.lang.String r1 = "rpiiemn"
            java.lang.String r2 = ""
            java.lang.String r3 = "leroadcfg"
            r4 = 0
            r5 = 4
            android.content.SharedPreferences r6 = r11.getSharedPreferences(r3, r5)     // Catch:{ all -> 0x0028 }
            r6.edit()     // Catch:{ all -> 0x0028 }
            android.content.SharedPreferences r3 = r11.getSharedPreferences(r3, r5)     // Catch:{ all -> 0x0028 }
            android.content.SharedPreferences$Editor r4 = r3.edit()     // Catch:{ all -> 0x0023 }
            java.lang.String r6 = "re_po_rt"
            android.content.SharedPreferences r5 = r11.getSharedPreferences(r6, r5)     // Catch:{ all -> 0x0023 }
            r5.edit()     // Catch:{ all -> 0x0023 }
            goto L_0x0033
        L_0x0023:
            r5 = move-exception
            r10 = r4
            r4 = r3
            r3 = r10
            goto L_0x002a
        L_0x0028:
            r5 = move-exception
            r3 = r4
        L_0x002a:
            r5.getMessage()     // Catch:{ all -> 0x00a9 }
            e.c.f.c.c()     // Catch:{ all -> 0x00a9 }
            r10 = r4
            r4 = r3
            r3 = r10
        L_0x0033:
            java.lang.String r5 = r3.getString(r0, r2)     // Catch:{ all -> 0x00a9 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00a9 }
            if (r5 != 0) goto L_0x0043
            r4.putString(r0, r2)     // Catch:{ all -> 0x00a9 }
            r4.commit()     // Catch:{ all -> 0x00a9 }
        L_0x0043:
            java.lang.String r0 = r3.getString(r1, r2)     // Catch:{ all -> 0x00a9 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a9 }
            r5 = 10
            java.lang.String r6 = "MzAyMTIxMDJkaWN1ZGlhYg=="
            java.lang.String r7 = "UTF-8"
            if (r3 == 0) goto L_0x0054
            goto L_0x006a
        L_0x0054:
            java.lang.String r3 = new java.lang.String     // Catch:{ all -> 0x0067 }
            byte[] r8 = r6.getBytes()     // Catch:{ all -> 0x0067 }
            byte[] r0 = android.util.Base64.decode(r0, r5)     // Catch:{ all -> 0x0067 }
            r9 = 1
            byte[] r0 = e.c.d.n.e.a(r8, r0, r9)     // Catch:{ all -> 0x0067 }
            r3.<init>(r0, r7)     // Catch:{ all -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            e.c.f.c.d()     // Catch:{ all -> 0x00a9 }
        L_0x006a:
            r3 = r2
        L_0x006b:
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00ad
            java.lang.String r3 = e.c.f.n.c.e(r11)     // Catch:{ all -> 0x00a8 }
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a8 }
            if (r11 != 0) goto L_0x00ad
            boolean r11 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00a8 }
            if (r11 == 0) goto L_0x0088
            r4.putString(r1, r2)     // Catch:{ all -> 0x00a8 }
            r4.commit()     // Catch:{ all -> 0x00a8 }
            goto L_0x00ad
        L_0x0088:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00a4 }
            byte[] r0 = r6.getBytes()     // Catch:{ all -> 0x00a4 }
            byte[] r2 = r3.getBytes(r7)     // Catch:{ all -> 0x00a4 }
            byte[] r0 = e.c.d.n.e.b(r0, r2)     // Catch:{ all -> 0x00a4 }
            byte[] r0 = android.util.Base64.encode(r0, r5)     // Catch:{ all -> 0x00a4 }
            r11.<init>(r0, r7)     // Catch:{ all -> 0x00a4 }
            r4.putString(r1, r11)     // Catch:{ all -> 0x00a8 }
            r4.commit()     // Catch:{ all -> 0x00a8 }
            goto L_0x00ad
        L_0x00a4:
            e.c.f.c.d()     // Catch:{ all -> 0x00a8 }
            goto L_0x00ad
        L_0x00a8:
            r2 = r3
        L_0x00a9:
            e.c.f.c.d()
            r3 = r2
        L_0x00ad:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.f.n.n.a(android.content.Context):java.lang.String");
    }

    public static Animator a(e.g.a.a.t.c cVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, C0111c.f8309a, e.g.a.a.t.c.b.f8307b, new e.g.a.a.t.c.e[]{new e.g.a.a.t.c.e(f2, f3, f4)});
        e.g.a.a.t.c.e revealInfo = cVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, revealInfo.f8313c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static e.i.a.g a(e.i.a.c cVar) {
        e.i.a.h.d.g gVar = e.i.a.e.a().f8666c;
        e.i.a.h.d.c cVar2 = gVar.get(cVar.f8649b);
        String str = cVar.v.f8854a;
        File file = cVar.x;
        File g2 = cVar.g();
        if (cVar2 != null) {
            if (!cVar2.f8710i && cVar2.d() <= 0) {
                return e.i.a.g.UNKNOWN;
            }
            if (g2 != null && g2.equals(cVar2.c()) && g2.exists() && cVar2.e() == cVar2.d()) {
                return e.i.a.g.COMPLETED;
            }
            if (str == null && cVar2.c() != null && cVar2.c().exists()) {
                return e.i.a.g.IDLE;
            }
            if (g2 != null && g2.equals(cVar2.c()) && g2.exists()) {
                return e.i.a.g.IDLE;
            }
        } else if (gVar.a() || gVar.c(cVar.f8649b)) {
            return e.i.a.g.UNKNOWN;
        } else {
            if (g2 != null && g2.exists()) {
                return e.i.a.g.COMPLETED;
            }
            String a2 = gVar.a(cVar.f8650c);
            if (a2 != null && new File(file, a2).exists()) {
                return e.i.a.g.COMPLETED;
            }
        }
        return e.i.a.g.UNKNOWN;
    }

    public static void a(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof e.g.a.a.e0.g) {
            e.g.a.a.e0.g gVar = (e.g.a.a.e0.g) background;
            e.g.a.a.e0.g.b bVar = gVar.f8072a;
            if (bVar.o != f2) {
                bVar.o = f2;
                gVar.j();
            }
        }
    }

    public static int a(String str) {
        return Log.d("greenDAO", str);
    }

    public static PorterDuffColorFilter a(Drawable drawable, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static Mode a(int i2, Mode mode) {
        if (i2 == 3) {
            return Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return Mode.SRC_IN;
        }
        if (i2 == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    public static Bitmap a(int i2, int i3, Drawable drawable) {
        Bitmap bitmap = null;
        try {
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap2 != null && bitmap2.getHeight() > 0) {
                    Matrix matrix = new Matrix();
                    matrix.postScale((((float) i2) * 1.0f) / ((float) bitmap2.getWidth()), (((float) i3) * 1.0f) / ((float) bitmap2.getHeight()));
                    return Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
                }
            }
            bitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return bitmap;
    }

    public static String a(r rVar) {
        String b2 = rVar.b();
        String d2 = rVar.d();
        if (d2 == null) {
            return b2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(b2);
        sb.append('?');
        sb.append(d2);
        return sb.toString();
    }

    public static int a(Context context, int i2, String str) {
        TypedValue a2 = a(context, i2);
        if (a2 != null) {
            return a2.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{str, context.getResources().getResourceName(i2)}));
    }

    public static int a(Context context, int i2, int i3) {
        TypedValue a2 = a(context, i2);
        return a2 != null ? a2.data : i3;
    }

    public static int a(View view, int i2) {
        return a(view.getContext(), i2, view.getClass().getCanonicalName());
    }

    public static Calendar a(Calendar calendar) {
        Calendar b2 = b(calendar);
        Calendar e2 = e();
        e2.set(b2.get(1), b2.get(2), b2.get(5));
        return e2;
    }

    public static boolean a(Context context, int i2, boolean z) {
        TypedValue a2 = a(context, i2);
        if (a2 == null || a2.type != 18) {
            return z;
        }
        return a2.data != 0;
    }

    public static int a(Context context, float f2) {
        if (context == null || a(0.0f, f2) == 0) {
            return 0;
        }
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(float f2, float f3) {
        int round = Math.round(f2 * 1000000.0f);
        int round2 = Math.round(f3 * 1000000.0f);
        if (round > round2) {
            return 1;
        }
        return round < round2 ? -1 : 0;
    }

    public static int a(int i2, int i3, float f2) {
        return d.h.f.a.a(d.h.f.a.b(i3, Math.round(((float) Color.alpha(i3)) * f2)), i2);
    }

    public static int a(List<ImageHeaderParser> list, InputStream inputStream, e.d.a.n.n.c0.b bVar) throws IOException {
        int i2 = -1;
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new w(inputStream, bVar);
        }
        inputStream.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
        int size = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            try {
                int a2 = ((ImageHeaderParser) list.get(i3)).a(inputStream, bVar);
                if (a2 != -1) {
                    i2 = a2;
                    break;
                }
                i3++;
            } finally {
                inputStream.reset();
            }
        }
        return i2;
    }

    public static Rect a(String str, float f2) {
        Paint paint = new Paint();
        Rect rect = new Rect();
        paint.setTextSize(f2);
        paint.getTextBounds(str, 0, str.length(), rect);
        paint.reset();
        return rect;
    }

    public static boolean a(Bitmap bitmap) {
        return bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0;
    }

    public static i.d.a.j.a a(List<i.d.a.j.d> list) {
        i.d.a.j.a aVar = null;
        for (i.d.a.j.d dVar : list) {
            if (dVar instanceof i.d.a.j.a) {
                aVar = (i.d.a.j.a) dVar;
            }
        }
        return aVar;
    }

    public static ColorStateList a(Context context, x0 x0Var, int i2) {
        if (x0Var.f4485b.hasValue(i2)) {
            int resourceId = x0Var.f4485b.getResourceId(i2, 0);
            if (resourceId != 0) {
                ColorStateList a2 = d.b.l.a.a.a(context, resourceId);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return x0Var.a(i2);
    }

    public static void a(View view, e.g.a.a.e0.g gVar) {
        e.g.a.a.w.a aVar = gVar.f8072a.f8084b;
        if (aVar != null && aVar.f8395a) {
            float f2 = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                f2 += m.h((View) parent);
            }
            e.g.a.a.e0.g.b bVar = gVar.f8072a;
            if (bVar.n != f2) {
                bVar.n = f2;
                gVar.j();
            }
        }
    }
}
