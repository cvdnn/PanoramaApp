package a.a.a.a.b;

import a.a.a.a.e.a.i.f.e;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode.Callback;
import android.view.InflateException;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a0;
import b.a.a.a.c;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.graphicpath.render.source.AutoStitcherLib;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.graphicpath.render.util.GPUCapability;
import com.arashivision.graphicpath.render.util.GPUCapability.GPUCapabilityNumber;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Quaternionfc;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insta360.basemedia.MediaModule;
import com.arashivision.insta360.basemedia.model.CameraType;
import com.arashivision.onecamera.OneDriverInfo.Options;
import com.arashivision.onecamera.OneDriverInfo.PhotographyOptions;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.sapi2.utils.h;
import com.sina.weibo.sdk.statistic.LogBuilder;
import d.b.p.a1;
import d.b.p.e1;
import d.f.a.h.f;
import d.f.a.h.i;
import d.f.a.h.j;
import d.f.a.h.l;
import d.r.d.t;
import e.c.b.d;
import e.c.b.e.g;
import e.c.b.f.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a {

    /* renamed from: a reason: collision with root package name */
    public static Field f392a;

    /* renamed from: b reason: collision with root package name */
    public static boolean f393b;

    /* renamed from: c reason: collision with root package name */
    public static Class<?> f394c;

    /* renamed from: d reason: collision with root package name */
    public static boolean f395d;

    /* renamed from: e reason: collision with root package name */
    public static Field f396e;

    /* renamed from: f reason: collision with root package name */
    public static boolean f397f;

    /* renamed from: g reason: collision with root package name */
    public static Field f398g;

    /* renamed from: h reason: collision with root package name */
    public static boolean f399h;

    /* renamed from: i reason: collision with root package name */
    public static Intent f400i;

    /* renamed from: j reason: collision with root package name */
    public static Locale f401j;
    public static Context k;
    public static ActivityManager l;

    public static int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, MediaModule.getApplication().getResources().getDisplayMetrics());
    }

    public static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static long a(byte[] bArr, int i2) {
        long j2 = 0;
        if (bArr != null && bArr.length >= i2 + 8) {
            for (int i3 = i2 + 7; i3 >= i2; i3--) {
                j2 = (j2 << 8) | ((long) (bArr[i3] & 255));
            }
        }
        return j2;
    }

    public static Quaternionf a(e eVar) {
        Quaternionf quaternionf = new Quaternionf();
        if (eVar != null) {
            return new Quaternionf().rotateYXZ(eVar.f605d, eVar.f606e, eVar.f607f);
        }
        Log.e("TransformUtils", "buildQuaternion failed! point is null");
        return quaternionf;
    }

    public static String a() {
        String str;
        String str2;
        int myPid = Process.myPid();
        if (!d.f5885i || myPid <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(myPid));
            sb.append("):");
            str = sb.toString();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        ArrayList arrayList2 = new ArrayList();
        String str3 = "-t";
        arrayList2.addAll(Arrays.asList(new String[]{str3, String.valueOf(d.f5884h), "-v", LogBuilder.KEY_TIME}));
        if (arrayList2.indexOf(str3) >= 0) {
            int size = arrayList2.size();
        }
        b bVar = new b(d.f5884h);
        arrayList.addAll(arrayList2);
        try {
            Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
            new Thread(new g(exec)).start();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (str == null || readLine.contains(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(readLine);
                    sb2.append("\n");
                    bVar.add(sb2.toString());
                }
            }
        } catch (IOException e2) {
            e = e2;
            str2 = "collectLogCat failed.";
            e.c.b.f.a.a(str2, e);
            return bVar.toString();
        } catch (Exception e3) {
            e = e3;
            str2 = "collectLogCat failed!";
            e.c.b.f.a.a(str2, e);
            return bVar.toString();
        } catch (OutOfMemoryError e4) {
            e = e4;
            str2 = "collectLogCat oom.";
            e.c.b.f.a.a(str2, e);
            return bVar.toString();
        }
        return bVar.toString();
    }

    public static String a(double d2) {
        if (d2 < 0.0d) {
            d2 = -d2;
        }
        int floor = (int) Math.floor(d2);
        double d3 = (d2 - ((double) floor)) * 60.0d;
        int floor2 = (int) Math.floor(d3);
        int floor3 = (int) Math.floor((d3 - ((double) floor2)) * 60.0d * 100.0d);
        return String.format(Locale.getDefault(), "%d/1 %d/1 %d/100", new Object[]{Integer.valueOf(floor), Integer.valueOf(floor2), Integer.valueOf(floor3)});
    }

    public static String a(Context context) {
        Object[] objArr;
        StringBuilder sb = new StringBuilder();
        try {
            for (Object obj : (Object[]) PackageManager.class.getMethod("getSystemAvailableFeatures", null).invoke(context.getPackageManager(), new Object[0])) {
                String str = (String) obj.getClass().getField("name").get(obj);
                if (str != null) {
                    sb.append(str);
                } else {
                    String str2 = (String) obj.getClass().getMethod("getGlEsVersion", null).invoke(obj, new Object[0]);
                    sb.append("glEsVersion = ");
                    sb.append(str2);
                }
                sb.append("\n");
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0493, code lost:
        r3 = java.lang.Boolean.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x04a1, code lost:
        r3 = java.lang.Long.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x04cd, code lost:
        r2.put(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x04f8, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.HashMap<java.lang.String, java.lang.Object> r2, com.arashivision.onecamera.Options r3, java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            switch(r0) {
                case -2092176292: goto L_0x0341;
                case -2091848231: goto L_0x0336;
                case -2072954563: goto L_0x032b;
                case -1938833037: goto L_0x0320;
                case -1761489042: goto L_0x0315;
                case -1730590935: goto L_0x030a;
                case -1724205841: goto L_0x02ff;
                case -1673464239: goto L_0x02f4;
                case -1603906321: goto L_0x02e9;
                case -1591592244: goto L_0x02dd;
                case -1582368257: goto L_0x02d1;
                case -1543832407: goto L_0x02c6;
                case -1255930417: goto L_0x02ba;
                case -1054290972: goto L_0x02ae;
                case -1047159132: goto L_0x02a3;
                case -997840102: goto L_0x0297;
                case -984674552: goto L_0x028b;
                case -979760788: goto L_0x027f;
                case -882339694: goto L_0x0273;
                case -769125329: goto L_0x0267;
                case -653452450: goto L_0x025b;
                case -638425979: goto L_0x024f;
                case -606940183: goto L_0x0243;
                case -441981411: goto L_0x0237;
                case -412298165: goto L_0x022b;
                case -393023838: goto L_0x021f;
                case -370734298: goto L_0x0213;
                case -287655796: goto L_0x0208;
                case -249474220: goto L_0x01fc;
                case -114235473: goto L_0x01f0;
                case -100836766: goto L_0x01e4;
                case 3363353: goto L_0x01d8;
                case 3601339: goto L_0x01cc;
                case 29164336: goto L_0x01c0;
                case 43583822: goto L_0x01b4;
                case 180321228: goto L_0x01a8;
                case 186581287: goto L_0x019d;
                case 223054113: goto L_0x0191;
                case 258902020: goto L_0x0186;
                case 312410100: goto L_0x017a;
                case 336529046: goto L_0x016e;
                case 372969896: goto L_0x0162;
                case 501649265: goto L_0x0156;
                case 503775429: goto L_0x014a;
                case 506656007: goto L_0x013e;
                case 616747253: goto L_0x0132;
                case 618533766: goto L_0x0126;
                case 733260936: goto L_0x011a;
                case 852038198: goto L_0x010e;
                case 929559955: goto L_0x0103;
                case 948913069: goto L_0x00f7;
                case 1056057830: goto L_0x00ec;
                case 1303713569: goto L_0x00e0;
                case 1325610786: goto L_0x00d4;
                case 1400989837: goto L_0x00c8;
                case 1401172581: goto L_0x00bc;
                case 1402114106: goto L_0x00b0;
                case 1409454753: goto L_0x00a4;
                case 1526814232: goto L_0x0098;
                case 1563035408: goto L_0x008c;
                case 1628657305: goto L_0x0080;
                case 1631451148: goto L_0x0074;
                case 1632925578: goto L_0x0068;
                case 1742765007: goto L_0x005c;
                case 1924434857: goto L_0x0051;
                case 1939860040: goto L_0x0045;
                case 1958647429: goto L_0x0039;
                case 2006708223: goto L_0x002d;
                case 2013510078: goto L_0x0021;
                case 2059187220: goto L_0x0015;
                case 2082647409: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x034c
        L_0x0009:
            java.lang.String r0 = "pressoptions-shutdown_click"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 25
            goto L_0x034d
        L_0x0015:
            java.lang.String r0 = "camera_type"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 61
            goto L_0x034d
        L_0x0021:
            java.lang.String r0 = "log_mode"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 38
            goto L_0x034d
        L_0x002d:
            java.lang.String r0 = "acc_range"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 35
            goto L_0x034d
        L_0x0039:
            java.lang.String r0 = "pressoptions-doubleclick"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 22
            goto L_0x034d
        L_0x0045:
            java.lang.String r0 = "media_time"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 39
            goto L_0x034d
        L_0x0051:
            java.lang.String r0 = "video_bitrate"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 5
            goto L_0x034d
        L_0x005c:
            java.lang.String r0 = "remaining_capture_time"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 11
            goto L_0x034d
        L_0x0068:
            java.lang.String r0 = "sys_adoption"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 41
            goto L_0x034d
        L_0x0074:
            java.lang.String r0 = "second_stream_res"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 55
            goto L_0x034d
        L_0x0080:
            java.lang.String r0 = "activate_time"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 27
            goto L_0x034d
        L_0x008c:
            java.lang.String r0 = "quality_setting"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 64
            goto L_0x034d
        L_0x0098:
            java.lang.String r0 = "pressoptions-tripleclick"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 23
            goto L_0x034d
        L_0x00a4:
            java.lang.String r0 = "authorization_id"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 51
            goto L_0x034d
        L_0x00b0:
            java.lang.String r0 = "time_zone_seconds_from_gmt"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 17
            goto L_0x034d
        L_0x00bc:
            java.lang.String r0 = "wifi_ssid"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 46
            goto L_0x034d
        L_0x00c8:
            java.lang.String r0 = "wifi_mode"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 49
            goto L_0x034d
        L_0x00d4:
            java.lang.String r0 = "media_offset_3d"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 59
            goto L_0x034d
        L_0x00e0:
            java.lang.String r0 = "local_time"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 16
            goto L_0x034d
        L_0x00ec:
            java.lang.String r0 = "photo_size-height"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 4
            goto L_0x034d
        L_0x00f7:
            java.lang.String r0 = "gyro_range"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 36
            goto L_0x034d
        L_0x0103:
            java.lang.String r0 = "audio_samplerate"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 7
            goto L_0x034d
        L_0x010e:
            java.lang.String r0 = "pressoptions-click"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 21
            goto L_0x034d
        L_0x011a:
            java.lang.String r0 = "calibration_offset"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 52
            goto L_0x034d
        L_0x0126:
            java.lang.String r0 = "video_sub_mode"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 54
            goto L_0x034d
        L_0x0132:
            java.lang.String r0 = "pressoptions-longpress"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 24
            goto L_0x034d
        L_0x013e:
            java.lang.String r0 = "sensor_serial_vr180"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 69
            goto L_0x034d
        L_0x014a:
            java.lang.String r0 = "gyro_sample_rate"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 34
            goto L_0x034d
        L_0x0156:
            java.lang.String r0 = "cpu_type"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 42
            goto L_0x034d
        L_0x0162:
            java.lang.String r0 = "calibration_offset_3d"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 60
            goto L_0x034d
        L_0x016e:
            java.lang.String r0 = "firmwarerevision"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 40
            goto L_0x034d
        L_0x017a:
            java.lang.String r0 = "serial_number"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 19
            goto L_0x034d
        L_0x0186:
            java.lang.String r0 = "audio_bitrate"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 6
            goto L_0x034d
        L_0x0191:
            java.lang.String r0 = "internal_flowstate"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 65
            goto L_0x034d
        L_0x019d:
            java.lang.String r0 = "photo_size-width"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 3
            goto L_0x034d
        L_0x01a8:
            java.lang.String r0 = "origin_offset"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 8
            goto L_0x034d
        L_0x01b4:
            java.lang.String r0 = "media_offset"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 32
            goto L_0x034d
        L_0x01c0:
            java.lang.String r0 = "wifi_channel_country"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 50
            goto L_0x034d
        L_0x01cc:
            java.lang.String r0 = "uuid"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 20
            goto L_0x034d
        L_0x01d8:
            java.lang.String r0 = "mute"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 18
            goto L_0x034d
        L_0x01e4:
            java.lang.String r0 = "capture_time_limit"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 9
            goto L_0x034d
        L_0x01f0:
            java.lang.String r0 = "photo_sub_mode"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 53
            goto L_0x034d
        L_0x01fc:
            java.lang.String r0 = "sport_mode_enable"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 45
            goto L_0x034d
        L_0x0208:
            java.lang.String r0 = "video_resolution-fps"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 2
            goto L_0x034d
        L_0x0213:
            java.lang.String r0 = "bt_remote_type"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 63
            goto L_0x034d
        L_0x021f:
            java.lang.String r0 = "storage_state-card_state"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 28
            goto L_0x034d
        L_0x022b:
            java.lang.String r0 = "storage_state-total_space"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 30
            goto L_0x034d
        L_0x0237:
            java.lang.String r0 = "is_selfie"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 70
            goto L_0x034d
        L_0x0243:
            java.lang.String r0 = "pressoptions-shutdown_short_press"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 26
            goto L_0x034d
        L_0x024f:
            java.lang.String r0 = "wifi_password"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 47
            goto L_0x034d
        L_0x025b:
            java.lang.String r0 = "remaining_pictures"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 12
            goto L_0x034d
        L_0x0267:
            java.lang.String r0 = "take_raw_picture"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 37
            goto L_0x034d
        L_0x0273:
            java.lang.String r0 = "self_timer"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 33
            goto L_0x034d
        L_0x027f:
            java.lang.String r0 = "bt_remote_version"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 62
            goto L_0x034d
        L_0x028b:
            java.lang.String r0 = "gyro_filter"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 43
            goto L_0x034d
        L_0x0297:
            java.lang.String r0 = "mctf_enable"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 44
            goto L_0x034d
        L_0x02a3:
            java.lang.String r0 = "video_resolution-height"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 1
            goto L_0x034d
        L_0x02ae:
            java.lang.String r0 = "origin_offset_3d"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 58
            goto L_0x034d
        L_0x02ba:
            java.lang.String r0 = "sensor0_serial_vr360"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 67
            goto L_0x034d
        L_0x02c6:
            java.lang.String r0 = "video_resolution-width"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 0
            goto L_0x034d
        L_0x02d1:
            java.lang.String r0 = "video_encode_type"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 66
            goto L_0x034d
        L_0x02dd:
            java.lang.String r0 = "gps_timeout"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 10
            goto L_0x034d
        L_0x02e9:
            java.lang.String r0 = "evo_status_mode"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 57
            goto L_0x034d
        L_0x02f4:
            java.lang.String r0 = "lens_index"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 31
            goto L_0x034d
        L_0x02ff:
            java.lang.String r0 = "battery_status-battery_scale"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 15
            goto L_0x034d
        L_0x030a:
            java.lang.String r0 = "battery_status-battery_level"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 14
            goto L_0x034d
        L_0x0315:
            java.lang.String r0 = "sensor1_serial_vr360"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 68
            goto L_0x034d
        L_0x0320:
            java.lang.String r0 = "storage_state-free_space"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 29
            goto L_0x034d
        L_0x032b:
            java.lang.String r0 = "battery_status-power_type"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 13
            goto L_0x034d
        L_0x0336:
            java.lang.String r0 = "wifi_channel"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 48
            goto L_0x034d
        L_0x0341:
            java.lang.String r0 = "wifi_status"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x034c
            r0 = 56
            goto L_0x034d
        L_0x034c:
            r0 = -1
        L_0x034d:
            switch(r0) {
                case 0: goto L_0x04f4;
                case 1: goto L_0x04ef;
                case 2: goto L_0x04ea;
                case 3: goto L_0x04e5;
                case 4: goto L_0x04e0;
                case 5: goto L_0x04db;
                case 6: goto L_0x04d6;
                case 7: goto L_0x04d1;
                case 8: goto L_0x04c9;
                case 9: goto L_0x04c4;
                case 10: goto L_0x04bf;
                case 11: goto L_0x04ba;
                case 12: goto L_0x04b5;
                case 13: goto L_0x04b0;
                case 14: goto L_0x04ab;
                case 15: goto L_0x04a6;
                case 16: goto L_0x049d;
                case 17: goto L_0x0498;
                case 18: goto L_0x048f;
                case 19: goto L_0x048a;
                case 20: goto L_0x0485;
                case 21: goto L_0x047f;
                case 22: goto L_0x0479;
                case 23: goto L_0x0473;
                case 24: goto L_0x046d;
                case 25: goto L_0x0467;
                case 26: goto L_0x0461;
                case 27: goto L_0x045c;
                case 28: goto L_0x0456;
                case 29: goto L_0x0451;
                case 30: goto L_0x044c;
                case 31: goto L_0x0446;
                case 32: goto L_0x0440;
                case 33: goto L_0x043a;
                case 34: goto L_0x0434;
                case 35: goto L_0x042e;
                case 36: goto L_0x0428;
                case 37: goto L_0x0422;
                case 38: goto L_0x041c;
                case 39: goto L_0x0416;
                case 40: goto L_0x0410;
                case 41: goto L_0x040a;
                case 42: goto L_0x0404;
                case 43: goto L_0x0350;
                case 44: goto L_0x03fe;
                case 45: goto L_0x03f8;
                case 46: goto L_0x03ee;
                case 47: goto L_0x03e4;
                case 48: goto L_0x03da;
                case 49: goto L_0x03d0;
                case 50: goto L_0x03ca;
                case 51: goto L_0x03c4;
                case 52: goto L_0x03be;
                case 53: goto L_0x03b8;
                case 54: goto L_0x03b2;
                case 55: goto L_0x03ac;
                case 56: goto L_0x03a6;
                case 57: goto L_0x03a0;
                case 58: goto L_0x039a;
                case 59: goto L_0x0394;
                case 60: goto L_0x038e;
                case 61: goto L_0x0388;
                case 62: goto L_0x0382;
                case 63: goto L_0x037c;
                case 64: goto L_0x0376;
                case 65: goto L_0x0370;
                case 66: goto L_0x036a;
                case 67: goto L_0x0364;
                case 68: goto L_0x035e;
                case 69: goto L_0x0358;
                case 70: goto L_0x0352;
                default: goto L_0x0350;
            }
        L_0x0350:
            goto L_0x04fd
        L_0x0352:
            boolean r3 = r3.isSelfie()
            goto L_0x0493
        L_0x0358:
            java.lang.String r3 = r3.getwideLensSerial()
            goto L_0x04cd
        L_0x035e:
            java.lang.String r3 = r3.getSensor1Serial()
            goto L_0x04cd
        L_0x0364:
            java.lang.String r3 = r3.getSensor0Serial()
            goto L_0x04cd
        L_0x036a:
            int r3 = r3.getVideoEncodeType()
            goto L_0x04f8
        L_0x0370:
            boolean r3 = r3.getInternalFlowState()
            goto L_0x0493
        L_0x0376:
            int r3 = r3.getQualitySetting()
            goto L_0x04f8
        L_0x037c:
            int r3 = r3.getRemoteType()
            goto L_0x04f8
        L_0x0382:
            java.lang.String r3 = r3.getRemoteVersion()
            goto L_0x04cd
        L_0x0388:
            java.lang.String r3 = r3.getCameraType()
            goto L_0x04cd
        L_0x038e:
            java.lang.String r3 = r3.getCalibrateOffset3D()
            goto L_0x04cd
        L_0x0394:
            java.lang.String r3 = r3.getMediaOffset3D()
            goto L_0x04cd
        L_0x039a:
            java.lang.String r3 = r3.getOriginOffset3D()
            goto L_0x04cd
        L_0x03a0:
            int r3 = r3.getEVOStatusMode()
            goto L_0x04f8
        L_0x03a6:
            int r3 = r3.getWifiStatus()
            goto L_0x04f8
        L_0x03ac:
            int r3 = r3.getSecodStreamRes()
            goto L_0x04f8
        L_0x03b2:
            int r3 = r3.getSubVideoMode()
            goto L_0x04f8
        L_0x03b8:
            int r3 = r3.getSubPhotoMode()
            goto L_0x04f8
        L_0x03be:
            java.lang.String r3 = r3.getCalibrationOffset()
            goto L_0x04cd
        L_0x03c4:
            java.lang.String r3 = r3.getAuthorizationID()
            goto L_0x04cd
        L_0x03ca:
            java.lang.String r3 = r3.getWifiChannelCounty()
            goto L_0x04cd
        L_0x03d0:
            com.arashivision.onecamera.camerarequest.WifiInfo r3 = r3.getWifiInfo()
            int r3 = r3.getMode()
            goto L_0x04f8
        L_0x03da:
            com.arashivision.onecamera.camerarequest.WifiInfo r3 = r3.getWifiInfo()
            int r3 = r3.getChannel()
            goto L_0x04f8
        L_0x03e4:
            com.arashivision.onecamera.camerarequest.WifiInfo r3 = r3.getWifiInfo()
            java.lang.String r3 = r3.getPwd()
            goto L_0x04cd
        L_0x03ee:
            com.arashivision.onecamera.camerarequest.WifiInfo r3 = r3.getWifiInfo()
            java.lang.String r3 = r3.getSsid()
            goto L_0x04cd
        L_0x03f8:
            boolean r3 = r3.getSportModeEnable()
            goto L_0x0493
        L_0x03fe:
            boolean r3 = r3.getMCTFEnable()
            goto L_0x0493
        L_0x0404:
            java.lang.String r3 = r3.getCPUType()
            goto L_0x04cd
        L_0x040a:
            int r3 = r3.getAdoptionSystem()
            goto L_0x04f8
        L_0x0410:
            java.lang.String r3 = r3.getFWVersion()
            goto L_0x04cd
        L_0x0416:
            long r0 = r3.getMediaTime()
            goto L_0x04a1
        L_0x041c:
            boolean r3 = r3.getLogMode()
            goto L_0x0493
        L_0x0422:
            boolean r3 = r3.getTakeRawPicture()
            goto L_0x0493
        L_0x0428:
            int r3 = r3.getGyroFullRange()
            goto L_0x04f8
        L_0x042e:
            int r3 = r3.getAccFullRange()
            goto L_0x04f8
        L_0x0434:
            int r3 = r3.getGyroSampleRate()
            goto L_0x04f8
        L_0x043a:
            int r3 = r3.getSelfTimer()
            goto L_0x04f8
        L_0x0440:
            java.lang.String r3 = r3.getMediaOffset()
            goto L_0x04cd
        L_0x0446:
            int r3 = r3.getLensIndex()
            goto L_0x04f8
        L_0x044c:
            long r0 = r3.getStorageTotalSpace()
            goto L_0x04a1
        L_0x0451:
            long r0 = r3.getStorageFreeSpace()
            goto L_0x04a1
        L_0x0456:
            int r3 = r3.getStorageCardState()
            goto L_0x04f8
        L_0x045c:
            long r0 = r3.getActiveTime()
            goto L_0x04a1
        L_0x0461:
            int r3 = r3.getShutdownShortPressint()
            goto L_0x04f8
        L_0x0467:
            int r3 = r3.getShutdownClickint()
            goto L_0x04f8
        L_0x046d:
            int r3 = r3.getLongPressint()
            goto L_0x04f8
        L_0x0473:
            int r3 = r3.getTripleClickint()
            goto L_0x04f8
        L_0x0479:
            int r3 = r3.getDoubelClickint()
            goto L_0x04f8
        L_0x047f:
            int r3 = r3.getClickint()
            goto L_0x04f8
        L_0x0485:
            java.lang.String r3 = r3.getUUID()
            goto L_0x04cd
        L_0x048a:
            java.lang.String r3 = r3.getSN()
            goto L_0x04cd
        L_0x048f:
            boolean r3 = r3.getMute()
        L_0x0493:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x04cd
        L_0x0498:
            int r3 = r3.getTimezoneSecodeFromGMT()
            goto L_0x04f8
        L_0x049d:
            long r0 = r3.getLocalTime()
        L_0x04a1:
            java.lang.Long r3 = java.lang.Long.valueOf(r0)
            goto L_0x04cd
        L_0x04a6:
            int r3 = r3.getBatteryStatusBatteryScale()
            goto L_0x04f8
        L_0x04ab:
            int r3 = r3.getBatteryStatusBatteryLevel()
            goto L_0x04f8
        L_0x04b0:
            int r3 = r3.getBatteryStatusPowerType()
            goto L_0x04f8
        L_0x04b5:
            int r3 = r3.getRemainPictures()
            goto L_0x04f8
        L_0x04ba:
            int r3 = r3.getRemainCaptureTime()
            goto L_0x04f8
        L_0x04bf:
            int r3 = r3.getGPSTimeout()
            goto L_0x04f8
        L_0x04c4:
            int r3 = r3.getCaptureLimitTime()
            goto L_0x04f8
        L_0x04c9:
            java.lang.String r3 = r3.getOriginOffset()
        L_0x04cd:
            r2.put(r4, r3)
            goto L_0x04fd
        L_0x04d1:
            int r3 = r3.getAudioSampleRate()
            goto L_0x04f8
        L_0x04d6:
            int r3 = r3.getAudioBitrate()
            goto L_0x04f8
        L_0x04db:
            int r3 = r3.getVideoBitrate()
            goto L_0x04f8
        L_0x04e0:
            int r3 = r3.getPhotoHeight()
            goto L_0x04f8
        L_0x04e5:
            int r3 = r3.getPhotoWidth()
            goto L_0x04f8
        L_0x04ea:
            int r3 = r3.getVideoFPS()
            goto L_0x04f8
        L_0x04ef:
            int r3 = r3.getVideoHeight()
            goto L_0x04f8
        L_0x04f4:
            int r3 = r3.getVideoWidth()
        L_0x04f8:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x04cd
        L_0x04fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(java.util.HashMap, com.arashivision.onecamera.Options, java.lang.String):void");
    }

    public static boolean a(int i2, int i3) {
        int queryGPULimit = GPUCapability.queryGPULimit(0);
        return queryGPULimit >= i2 && queryGPULimit >= i3;
    }

    public static byte[] a(int i2) {
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) ((i2 >> (i3 * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] a(long j2) {
        byte[] bArr = new byte[8];
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = (byte) ((int) ((j2 >> (i2 * 8)) & 255));
        }
        return bArr;
    }

    public static double[] a(double d2, double d3, double d4, boolean z) {
        double[] dArr = new double[2];
        if (!z || d3 < 0.0d || d3 > d2) {
            d3 = 0.0d;
        }
        dArr[0] = d3;
        if (z && d4 >= 0.0d && d4 <= d2) {
            d2 = d4;
        }
        dArr[1] = d2;
        return dArr;
    }

    public static FilterInfo[] a(FilterInfo[] filterInfoArr, FilterInfo filterInfo) {
        if (filterInfo == null) {
            return filterInfoArr;
        }
        FilterInfo[] filterInfoArr2 = (FilterInfo[]) Arrays.copyOf(filterInfoArr, filterInfoArr.length + 1);
        filterInfoArr2[filterInfoArr.length] = filterInfo;
        return filterInfoArr2;
    }

    public static double b(byte[] bArr, int i2) {
        if (bArr == null || bArr.length == 0) {
            return 0.0d;
        }
        return Double.longBitsToDouble(a(bArr, i2));
    }

    public static boolean b() {
        return GPUCapability.queryGPULimit(GPUCapabilityNumber.OES_EGL_IMAGE_EXTERNAL_CAPABILITY) == 1;
    }

    public static byte[] b(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher instance = Cipher.getInstance(h.p);
        instance.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }

    public static int c(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static int c(byte[] bArr, int i2) {
        byte b2 = 0;
        if (bArr != null && bArr.length >= i2 + 4) {
            for (int i3 = i2 + 3; i3 >= i2; i3--) {
                b2 = (b2 << 8) | (bArr[i3] & 255);
            }
        }
        return b2;
    }

    public static ArrayList<String> c() {
        Field[] declaredFields;
        ArrayList<String> arrayList = new ArrayList<>();
        for (Field field : Options.class.getDeclaredFields()) {
            if (field.getType().equals(String.class)) {
                try {
                    arrayList.add((String) field.get(null));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public static boolean c(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static ArrayList<String> d() {
        Field[] declaredFields;
        ArrayList<String> arrayList = new ArrayList<>();
        for (Field field : PhotographyOptions.class.getDeclaredFields()) {
            if (field.getType().equals(String.class)) {
                try {
                    arrayList.add((String) field.get(null));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A[SYNTHETIC, Splitter:B:20:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058 A[Catch:{ IOException -> 0x0054 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0063 A[SYNTHETIC, Splitter:B:32:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A[Catch:{ IOException -> 0x0067 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = android.os.Process.myPid()
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0060, all -> 0x004c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0060, all -> 0x004c }
            java.lang.String r5 = "/proc/"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0060, all -> 0x004c }
            r4.append(r1)     // Catch:{ Exception -> 0x0060, all -> 0x004c }
            java.lang.String r1 = "/stat"
            r4.append(r1)     // Catch:{ Exception -> 0x0060, all -> 0x004c }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0060, all -> 0x004c }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0060, all -> 0x004c }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0061, all -> 0x004a }
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0061, all -> 0x004a }
        L_0x0029:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            if (r2 == 0) goto L_0x0038
            r0.append(r2)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            goto L_0x0029
        L_0x0038:
            r1.close()     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r3.close()     // Catch:{ Exception -> 0x0048, all -> 0x0045 }
            r1.close()     // Catch:{ IOException -> 0x0067 }
            r3.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0072
        L_0x0045:
            r0 = move-exception
            r2 = r1
            goto L_0x004e
        L_0x0048:
            r2 = r1
            goto L_0x0061
        L_0x004a:
            r0 = move-exception
            goto L_0x004e
        L_0x004c:
            r0 = move-exception
            r3 = r2
        L_0x004e:
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0056
        L_0x0054:
            r1 = move-exception
            goto L_0x005c
        L_0x0056:
            if (r3 == 0) goto L_0x005f
            r3.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x005f
        L_0x005c:
            r1.printStackTrace()
        L_0x005f:
            throw r0
        L_0x0060:
            r3 = r2
        L_0x0061:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0069
        L_0x0067:
            r1 = move-exception
            goto L_0x006f
        L_0x0069:
            if (r3 == 0) goto L_0x0072
            r3.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x0072
        L_0x006f:
            r1.printStackTrace()
        L_0x0072:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.e():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01f2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.lang.Object> a(double r18, java.util.List<a.a.a.a.e.a.i.g> r20, double r21, double r23, double r25, boolean r27, a.a.a.a.e.a.l.e r28) {
        /*
            r0 = r20
            r10 = r28
            java.util.Collections.sort(r20)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r12 = 0
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 == 0) goto L_0x0092
            int r1 = r20.size()
            if (r1 != 0) goto L_0x0019
            goto L_0x0092
        L_0x0019:
            r9 = r12
            r2 = 0
        L_0x001c:
            int r1 = r20.size()
            if (r9 >= r1) goto L_0x0086
            java.lang.Object r1 = r0.get(r9)
            a.a.a.a.e.a.i.g r1 = (a.a.a.a.e.a.i.g) r1
            double r4 = r1.f610a
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0048
            java.lang.Object r1 = r0.get(r9)
            a.a.a.a.e.a.i.g r1 = (a.a.a.a.e.a.i.g) r1
            double r4 = r1.f610a
            double r6 = r15 / r21
            r8 = 0
            r17 = 0
            r1 = r28
            r13 = r9
            r9 = r17
            java.lang.Object r1 = r1.a(r2, r4, r6, r8, r9)
            r11.add(r1)
            goto L_0x0049
        L_0x0048:
            r13 = r9
        L_0x0049:
            java.lang.Object r1 = r0.get(r13)
            a.a.a.a.e.a.i.g r1 = (a.a.a.a.e.a.i.g) r1
            double r2 = r1.f610a
            java.lang.Object r1 = r0.get(r13)
            a.a.a.a.e.a.i.g r1 = (a.a.a.a.e.a.i.g) r1
            double r4 = r1.f611b
            java.lang.Object r1 = r0.get(r13)
            a.a.a.a.e.a.i.g r1 = (a.a.a.a.e.a.i.g) r1
            double r6 = r1.f612c
            double r6 = r15 / r6
            java.lang.Object r1 = r0.get(r13)
            a.a.a.a.e.a.i.g r1 = (a.a.a.a.e.a.i.g) r1
            if (r1 == 0) goto L_0x0084
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r12)
            r9 = 0
            r1 = r28
            java.lang.Object r1 = r1.a(r2, r4, r6, r8, r9)
            r11.add(r1)
            java.lang.Object r1 = r0.get(r13)
            a.a.a.a.e.a.i.g r1 = (a.a.a.a.e.a.i.g) r1
            double r2 = r1.f611b
            int r9 = r13 + 1
            goto L_0x001c
        L_0x0084:
            r0 = 0
            throw r0
        L_0x0086:
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a3
            double r5 = r15 / r21
            r7 = 0
            r8 = 0
            r0 = r28
            r1 = r2
            goto L_0x009a
        L_0x0092:
            double r5 = r15 / r21
            r1 = 0
            r7 = 0
            r8 = 0
            r0 = r28
        L_0x009a:
            r3 = r18
            java.lang.Object r0 = r0.a(r1, r3, r5, r7, r8)
            r11.add(r0)
        L_0x00a3:
            r0 = 0
            int r2 = (r23 > r0 ? 1 : (r23 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x00b1
            int r2 = (r23 > r18 ? 1 : (r23 == r18 ? 0 : -1))
            if (r2 <= 0) goto L_0x00ae
            goto L_0x00b1
        L_0x00ae:
            r13 = r23
            goto L_0x00b2
        L_0x00b1:
            r13 = r0
        L_0x00b2:
            int r0 = (r25 > r0 ? 1 : (r25 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x00be
            int r0 = (r25 > r18 ? 1 : (r25 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x00bb
            goto L_0x00be
        L_0x00bb:
            r15 = r25
            goto L_0x00c0
        L_0x00be:
            r15 = r18
        L_0x00c0:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00c5:
            int r0 = r11.size()
            if (r12 >= r0) goto L_0x01f0
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.c(r0)
            int r0 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r0 >= 0) goto L_0x0182
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.b(r0)
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0182
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.c(r0)
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x013b
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.b(r0)
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x013b
            java.lang.Object r0 = r11.get(r12)
            double r1 = r10.c(r0)
            java.lang.Object r0 = r11.get(r12)
            double r5 = r10.a(r0)
            java.lang.Object r0 = r11.get(r12)
            double r3 = r10.d(r0)
            java.lang.Double r8 = java.lang.Double.valueOf(r3)
            r7 = 0
            r0 = r28
            r3 = r13
            java.lang.Object r0 = r0.a(r1, r3, r5, r7, r8)
            r9.add(r0)
            java.lang.Object r0 = r11.get(r12)
            double r5 = r10.a(r0)
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.d(r0)
            java.lang.Double r8 = java.lang.Double.valueOf(r0)
            r0 = r28
            r1 = r13
            goto L_0x01b9
        L_0x013b:
            java.lang.Object r0 = r11.get(r12)
            double r1 = r10.c(r0)
            java.lang.Object r0 = r11.get(r12)
            double r5 = r10.a(r0)
            java.lang.Object r0 = r11.get(r12)
            double r3 = r10.d(r0)
            java.lang.Double r8 = java.lang.Double.valueOf(r3)
            r7 = 0
            r0 = r28
            r3 = r13
            java.lang.Object r0 = r0.a(r1, r3, r5, r7, r8)
            r9.add(r0)
            java.lang.Object r0 = r11.get(r12)
            double r3 = r10.b(r0)
            java.lang.Object r0 = r11.get(r12)
            double r5 = r10.a(r0)
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.d(r0)
            java.lang.Double r8 = java.lang.Double.valueOf(r0)
            r0 = r28
            r1 = r13
            goto L_0x01e0
        L_0x0182:
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.c(r0)
            int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r0 >= 0) goto L_0x01e5
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.b(r0)
            int r0 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x01e5
            java.lang.Object r0 = r11.get(r12)
            double r1 = r10.c(r0)
            java.lang.Object r0 = r11.get(r12)
            double r5 = r10.a(r0)
            java.lang.Object r0 = r11.get(r12)
            double r3 = r10.d(r0)
            java.lang.Double r8 = java.lang.Double.valueOf(r3)
            r7 = 0
            r0 = r28
        L_0x01b9:
            r3 = r15
            java.lang.Object r0 = r0.a(r1, r3, r5, r7, r8)
            r9.add(r0)
            java.lang.Object r0 = r11.get(r12)
            double r3 = r10.b(r0)
            java.lang.Object r0 = r11.get(r12)
            double r5 = r10.a(r0)
            java.lang.Object r0 = r11.get(r12)
            double r0 = r10.d(r0)
            java.lang.Double r8 = java.lang.Double.valueOf(r0)
            r0 = r28
            r1 = r15
        L_0x01e0:
            java.lang.Object r0 = r0.a(r1, r3, r5, r7, r8)
            goto L_0x01e9
        L_0x01e5:
            java.lang.Object r0 = r11.get(r12)
        L_0x01e9:
            r9.add(r0)
            int r12 = r12 + 1
            goto L_0x00c5
        L_0x01f0:
            if (r27 == 0) goto L_0x0214
            java.util.Iterator r0 = r9.iterator()
        L_0x01f6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0214
            java.lang.Object r1 = r0.next()
            double r2 = r10.c(r1)
            int r2 = (r2 > r25 ? 1 : (r2 == r25 ? 0 : -1))
            if (r2 >= 0) goto L_0x0210
            double r1 = r10.b(r1)
            int r1 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r1 > 0) goto L_0x01f6
        L_0x0210:
            r0.remove()
            goto L_0x01f6
        L_0x0214:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(double, java.util.List, double, double, double, boolean, a.a.a.a.e.a.l.e):java.util.List");
    }

    public static File b(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder a2 = e.a.a.a.a.a(".font");
        a2.append(Process.myPid());
        String str = "-";
        a2.append(str);
        a2.append(Process.myTid());
        a2.append(str);
        String sb = a2.toString();
        int i2 = 0;
        while (i2 < 100) {
            File file = new File(cacheDir, e.a.a.a.a.a(sb, i2));
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i2++;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static void c(TextView textView, int i2) {
        b(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static Path b(String str) {
        Path path = new Path();
        d.h.f.b[] a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            d.h.f.b.a(a2, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException(e.a.a.a.a.a("Error in parsing ", str), e2);
        }
    }

    public static int b(a0 a0Var, t tVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return a0Var.a();
        }
        return (int) ((((float) (tVar.a(view2) - tVar.d(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1))) * ((float) a0Var.a()));
    }

    public static b.a.a.a.g a(String str, String str2) {
        if (CameraType.ONEX.type.equals(str)) {
            return new b.a.a.a.h();
        }
        if (CameraType.ONEX2.type.equals(str)) {
            return new b.a.a.a.d();
        }
        if (CameraType.AKIKO.type.equals(str)) {
            int ResolveLensTypeFromOffset = AutoStitcherLib.ResolveLensTypeFromOffset(str2);
            if (ResolveLensTypeFromOffset == 33) {
                return new b.a.a.a.e();
            }
            if (ResolveLensTypeFromOffset != 35) {
                return new c();
            }
            return new b.a.a.a.a();
        } else if (CameraType.NANOS.type.equals(str)) {
            return new b.a.a.a.b();
        } else {
            if (TextUtils.isEmpty(str)) {
                return new b.a.a.a.b();
            }
            return new b.a.a.a.h();
        }
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        if (!a(xmlPullParser, str)) {
            return i3;
        }
        return typedArray.getInt(i2, i3);
    }

    public static int b(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static void b(Object obj) {
        String str = "ResourcesFlusher";
        if (!f395d) {
            try {
                f394c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e(str, "Could not find ThemedResourceCache class", e2);
            }
            f395d = true;
        }
        Class<?> cls = f394c;
        if (cls != null) {
            if (!f397f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f396e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e(str, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f397f = true;
            }
            Field field = f396e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e(str, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    public static e a(List<e> list, double d2, Interpolator interpolator, boolean z) {
        List<e> list2 = list;
        double d3 = d2;
        Interpolator interpolator2 = interpolator;
        if (d3 == ((e) list.get(list.size() - 1)).f604c) {
            return (e) list.get(list.size() - 1);
        }
        int i2 = 0;
        while (i2 < list.size() - 1) {
            e eVar = (e) list.get(i2);
            i2++;
            e eVar2 = (e) list.get(i2);
            if (eVar2 != null) {
                double d4 = eVar.f604c;
                if (d3 >= d4) {
                    double d5 = eVar2.f604c;
                    if (d3 < d5) {
                        float f2 = 1.0f;
                        if (eVar != eVar2) {
                            f2 = (((float) (d3 - d4)) * 1.0f) / ((float) (d5 - d4));
                            if (interpolator2 != null) {
                                f2 = interpolator2.getInterpolation(f2);
                            }
                        }
                        float f3 = eVar.f608g;
                        double e2 = (double) e.a.a.a.a.e(eVar2.f608g, f3, f2, f3);
                        float f4 = eVar.f602a;
                        double e3 = (double) e.a.a.a.a.e(eVar2.f602a, f4, f2, f4);
                        float f5 = eVar.f603b;
                        double e4 = (double) e.a.a.a.a.e(eVar2.f603b, f5, f2, f5);
                        if (z) {
                            return a(a(eVar).slerp((Quaternionfc) a(eVar2), f2, new Quaternionf()), (float) e2, (float) e3, (float) e4, d2, (double[]) null);
                        }
                        float f6 = eVar.f605d;
                        float e5 = e.a.a.a.a.e(eVar2.f605d, f6, f2, f6);
                        float f7 = eVar.f606e;
                        float e6 = e.a.a.a.a.e(eVar2.f606e, f7, f2, f7);
                        float f8 = eVar.f607f;
                        float e7 = e.a.a.a.a.e(eVar2.f607f, f8, f2, f8);
                        float f9 = (float) e2;
                        float f10 = (float) e3;
                        float f11 = (float) e4;
                        e eVar3 = new e();
                        eVar3.f605d = e5;
                        eVar3.f606e = e6;
                        eVar3.f607f = e7;
                        eVar3.f608g = f9;
                        eVar3.f602a = f10;
                        eVar3.f603b = f11;
                        eVar3.f604c = d3;
                        eVar3.f609h = null;
                        return eVar3;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static String b(Context context, ComponentName componentName) throws NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        int i2 = VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, CameraInterface.DEFAULT_PREVIEW_WIDTH);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("android.support.PARENT_ACTIVITY");
        if (string == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(string);
            string = sb.toString();
        }
        return string;
    }

    public static int b(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i4 = rect.left;
            i3 = rect2.right;
        } else if (i2 == 33) {
            i4 = rect.top;
            i3 = rect2.bottom;
        } else if (i2 == 66) {
            i4 = rect2.left;
            i3 = rect.right;
        } else if (i2 == 130) {
            i4 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return Math.max(0, i4 - i3);
    }

    public static void b(TextView textView, int i2) {
        int i3;
        b(i2);
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static e a(Quaternionf quaternionf, float f2, float f3, float f4, double d2, double[] dArr) {
        e eVar = new e();
        eVar.f604c = d2;
        eVar.f602a = f3;
        eVar.f603b = f4;
        eVar.f609h = dArr;
        Vector3f eulerAnglesYXZ = quaternionf.getEulerAnglesYXZ(new Vector3f());
        eVar.f605d = eulerAnglesYXZ.y();
        eVar.f606e = eulerAnglesYXZ.x();
        eVar.f607f = eulerAnglesYXZ.z();
        eVar.f608g = f2;
        return eVar;
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof e1) {
                    editorInfo.hintText = ((e1) parent).a();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return inputConnection;
    }

    public static <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, null, path);
    }

    public static int a(a0 a0Var, t tVar, View view, View view2, LayoutManager layoutManager, boolean z, boolean z2) {
        int i2;
        if (layoutManager.getChildCount() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        int max = Math.max(layoutManager.getPosition(view), layoutManager.getPosition(view2));
        if (z2) {
            i2 = Math.max(0, (a0Var.a() - max) - 1);
        } else {
            i2 = Math.max(0, min);
        }
        if (!z) {
            return i2;
        }
        return Math.round((((float) i2) * (((float) Math.abs(tVar.a(view2) - tVar.d(view))) / ((float) (Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1)))) + ((float) (tVar.f() - tVar.d(view))));
    }

    public static void a(Object obj, StringBuilder sb) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0) {
            simpleName = obj.getClass().getName();
            int lastIndexOf = simpleName.lastIndexOf(46);
            if (lastIndexOf > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        boolean z = true;
        if (charSequence == null || charSequence2 == null) {
            if (charSequence != charSequence2) {
                z = false;
            }
            return z;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            int length = charSequence.length() - charSequence2.length();
            int length2 = charSequence2.length();
            if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
                int length3 = charSequence.length() - length;
                int length4 = charSequence2.length();
                if (length >= 0 && length2 >= 0 && length3 >= length2 && length4 >= length2) {
                    int i2 = 0;
                    while (true) {
                        int i3 = length2 - 1;
                        if (length2 <= 0) {
                            break;
                        }
                        int i4 = length + 1;
                        char charAt = charSequence.charAt(length);
                        int i5 = i2 + 1;
                        char charAt2 = charSequence2.charAt(i2);
                        if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                            break;
                        }
                        length2 = i3;
                        i2 = i5;
                        length = i4;
                    }
                }
                z = false;
            } else {
                z = ((String) charSequence).regionMatches(true, length, (String) charSequence2, 0, length2);
            }
            return z;
        }
    }

    public static void a(String str, double d2, double d3, double d4) {
        ImageAsset imageAsset = new ImageAsset(str);
        imageAsset.parse(256);
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSProcessingMethod", "65 83 67 73 73 0 0 0 72 89 66 82 73 68 45 70 73 88");
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSVersionID", "2 2 0 0");
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSLatitude", a(d2));
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSLatitudeRef", d2 >= 0.0d ? "N" : "S");
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSLongitude", a(d3));
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSLongitudeRef", d3 >= 0.0d ? "E" : "W");
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSAltitude", String.format(Locale.getDefault(), "%d/100", new Object[]{Integer.valueOf((int) Math.round(100.0d * d4))}));
        imageAsset.setExifMetadata("Exif.GPSInfo.GPSAltitudeRef", d4 < 0.0d ? "1" : "0");
        imageAsset.save();
    }

    public static void a(View view, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        a1 a1Var = a1.f4278j;
        if (a1Var != null && a1Var.f4279a == view) {
            a1.a((a1) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            a1 a1Var2 = a1.k;
            if (a1Var2 != null && a1Var2.f4279a == view) {
                a1Var2.b();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new a1(view, charSequence);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0167, code lost:
        if (r12.f0 == 2) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x016b, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01ef, code lost:
        r13 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x044e, code lost:
        r14 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e7, code lost:
        if (r4[r10].f4667d.f4665b == r15) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x014b, code lost:
        if (r12.e0 == 2) goto L_0x0169;
     */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(d.f.a.h.e r27, d.f.a.e r28, int r29) {
        /*
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = 2
            if (r2 != 0) goto L_0x000f
            int r5 = r0.s0
            d.f.a.h.b[] r6 = r0.v0
            r7 = 0
            goto L_0x0014
        L_0x000f:
            int r5 = r0.t0
            d.f.a.h.b[] r6 = r0.u0
            r7 = r3
        L_0x0014:
            r8 = 0
        L_0x0015:
            if (r8 >= r5) goto L_0x046e
            r9 = r6[r8]
            boolean r10 = r9.q
            r11 = 0
            r12 = 8
            r14 = 1
            if (r10 != 0) goto L_0x0119
            int r10 = r9.l
            int r10 = r10 * r3
            d.f.a.h.d r15 = r9.f4654a
            r4 = r15
            r16 = 0
        L_0x0029:
            if (r16 != 0) goto L_0x00f9
            int r13 = r9.f4662i
            int r13 = r13 + r14
            r9.f4662i = r13
            d.f.a.h.d[] r13 = r15.i0
            int r14 = r9.l
            r13[r14] = r11
            d.f.a.h.d[] r13 = r15.h0
            r13[r14] = r11
            int r13 = r15.Y
            if (r13 == r12) goto L_0x00c5
            d.f.a.h.d r13 = r9.f4655b
            if (r13 != 0) goto L_0x0044
            r9.f4655b = r15
        L_0x0044:
            r9.f4657d = r15
            d.f.a.h.d$a[] r13 = r15.C
            int r14 = r9.l
            r13 = r13[r14]
            d.f.a.h.d$a r11 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r13 != r11) goto L_0x00c5
            int[] r11 = r15.f4696g
            r13 = r11[r14]
            r12 = 3
            if (r13 == 0) goto L_0x005f
            r13 = r11[r14]
            if (r13 == r12) goto L_0x005f
            r11 = r11[r14]
            if (r11 != r3) goto L_0x00c5
        L_0x005f:
            int r11 = r9.f4663j
            r13 = 1
            int r11 = r11 + r13
            r9.f4663j = r11
            float[] r11 = r15.g0
            int r13 = r9.l
            r14 = r11[r13]
            r17 = 0
            int r19 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r19 <= 0) goto L_0x0078
            float r3 = r9.k
            r11 = r11[r13]
            float r3 = r3 + r11
            r9.k = r3
        L_0x0078:
            int r3 = r9.l
            int r11 = r15.Y
            r13 = 8
            if (r11 == r13) goto L_0x0094
            d.f.a.h.d$a[] r11 = r15.C
            r11 = r11[r3]
            d.f.a.h.d$a r13 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r11 != r13) goto L_0x0094
            int[] r11 = r15.f4696g
            r13 = r11[r3]
            if (r13 == 0) goto L_0x0092
            r3 = r11[r3]
            if (r3 != r12) goto L_0x0094
        L_0x0092:
            r3 = 1
            goto L_0x0095
        L_0x0094:
            r3 = 0
        L_0x0095:
            if (r3 == 0) goto L_0x00b3
            r3 = 0
            int r11 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x00a0
            r3 = 1
            r9.n = r3
            goto L_0x00a3
        L_0x00a0:
            r3 = 1
            r9.o = r3
        L_0x00a3:
            java.util.ArrayList<d.f.a.h.d> r3 = r9.f4661h
            if (r3 != 0) goto L_0x00ae
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r9.f4661h = r3
        L_0x00ae:
            java.util.ArrayList<d.f.a.h.d> r3 = r9.f4661h
            r3.add(r15)
        L_0x00b3:
            d.f.a.h.d r3 = r9.f4659f
            if (r3 != 0) goto L_0x00b9
            r9.f4659f = r15
        L_0x00b9:
            d.f.a.h.d r3 = r9.f4660g
            if (r3 == 0) goto L_0x00c3
            d.f.a.h.d[] r3 = r3.h0
            int r11 = r9.l
            r3[r11] = r15
        L_0x00c3:
            r9.f4660g = r15
        L_0x00c5:
            if (r4 == r15) goto L_0x00cd
            d.f.a.h.d[] r3 = r4.i0
            int r4 = r9.l
            r3[r4] = r15
        L_0x00cd:
            d.f.a.h.c[] r3 = r15.A
            int r4 = r10 + 1
            r3 = r3[r4]
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x00e9
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.c[] r4 = r3.A
            r11 = r4[r10]
            d.f.a.h.c r11 = r11.f4667d
            if (r11 == 0) goto L_0x00e9
            r4 = r4[r10]
            d.f.a.h.c r4 = r4.f4667d
            d.f.a.h.d r4 = r4.f4665b
            if (r4 == r15) goto L_0x00ea
        L_0x00e9:
            r3 = 0
        L_0x00ea:
            if (r3 == 0) goto L_0x00ed
            goto L_0x00f0
        L_0x00ed:
            r3 = r15
            r16 = 1
        L_0x00f0:
            r4 = r15
            r11 = 0
            r12 = 8
            r14 = 1
            r15 = r3
            r3 = 2
            goto L_0x0029
        L_0x00f9:
            r9.f4656c = r15
            int r3 = r9.l
            if (r3 != 0) goto L_0x0106
            boolean r3 = r9.m
            if (r3 == 0) goto L_0x0106
            r9.f4658e = r15
            goto L_0x010a
        L_0x0106:
            d.f.a.h.d r3 = r9.f4654a
            r9.f4658e = r3
        L_0x010a:
            boolean r3 = r9.o
            if (r3 == 0) goto L_0x0114
            boolean r3 = r9.n
            if (r3 == 0) goto L_0x0114
            r3 = 1
            goto L_0x0115
        L_0x0114:
            r3 = 0
        L_0x0115:
            r9.p = r3
            r3 = 1
            goto L_0x011a
        L_0x0119:
            r3 = r14
        L_0x011a:
            r9.q = r3
            r3 = 4
            boolean r3 = r0.g(r3)
            if (r3 == 0) goto L_0x0459
            d.f.a.h.d r3 = r9.f4654a
            d.f.a.h.d r4 = r9.f4656c
            d.f.a.h.d r10 = r9.f4655b
            d.f.a.h.d r11 = r9.f4657d
            d.f.a.h.d r12 = r9.f4658e
            float r13 = r9.k
            d.f.a.h.d$a[] r14 = r0.C
            r14 = r14[r2]
            d.f.a.h.d$a r14 = d.f.a.h.d.a.WRAP_CONTENT
            if (r2 != 0) goto L_0x014e
            int r14 = r12.e0
            if (r14 != 0) goto L_0x013d
            r14 = 1
            goto L_0x013e
        L_0x013d:
            r14 = 0
        L_0x013e:
            int r15 = r12.e0
            r16 = r5
            r5 = 1
            if (r15 != r5) goto L_0x0147
            r5 = 1
            goto L_0x0148
        L_0x0147:
            r5 = 0
        L_0x0148:
            int r12 = r12.e0
            r15 = 2
            if (r12 != r15) goto L_0x016b
            goto L_0x0169
        L_0x014e:
            r16 = r5
            int r5 = r12.f0
            if (r5 != 0) goto L_0x0156
            r5 = 1
            goto L_0x0157
        L_0x0156:
            r5 = 0
        L_0x0157:
            int r14 = r12.f0
            r15 = 1
            if (r14 != r15) goto L_0x015e
            r14 = 1
            goto L_0x015f
        L_0x015e:
            r14 = 0
        L_0x015f:
            int r12 = r12.f0
            r15 = 2
            r26 = r14
            r14 = r5
            r5 = r26
            if (r12 != r15) goto L_0x016b
        L_0x0169:
            r12 = 1
            goto L_0x016c
        L_0x016b:
            r12 = 0
        L_0x016c:
            r15 = r3
            r22 = r6
            r23 = r8
            r6 = 0
            r8 = 0
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x0179:
            if (r21 != 0) goto L_0x0237
            int r0 = r15.Y
            r24 = r9
            r9 = 8
            if (r0 == r9) goto L_0x01c7
            int r6 = r6 + 1
            if (r2 != 0) goto L_0x018c
            int r0 = r15.h()
            goto L_0x0190
        L_0x018c:
            int r0 = r15.c()
        L_0x0190:
            float r0 = (float) r0
            float r19 = r19 + r0
            if (r15 == r10) goto L_0x01a0
            d.f.a.h.c[] r0 = r15.A
            r0 = r0[r7]
            int r0 = r0.a()
            float r0 = (float) r0
            float r19 = r19 + r0
        L_0x01a0:
            if (r15 == r11) goto L_0x01af
            d.f.a.h.c[] r0 = r15.A
            int r9 = r7 + 1
            r0 = r0[r9]
            int r0 = r0.a()
            float r0 = (float) r0
            float r19 = r19 + r0
        L_0x01af:
            d.f.a.h.c[] r0 = r15.A
            r0 = r0[r7]
            int r0 = r0.a()
            float r0 = (float) r0
            float r20 = r20 + r0
            d.f.a.h.c[] r0 = r15.A
            int r9 = r7 + 1
            r0 = r0[r9]
            int r0 = r0.a()
            float r0 = (float) r0
            float r20 = r20 + r0
        L_0x01c7:
            d.f.a.h.c[] r0 = r15.A
            r0 = r0[r7]
            int r0 = r15.Y
            r9 = 8
            if (r0 == r9) goto L_0x0203
            d.f.a.h.d$a[] r0 = r15.C
            r0 = r0[r2]
            d.f.a.h.d$a r9 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r0 != r9) goto L_0x0203
            int r8 = r8 + 1
            if (r2 != 0) goto L_0x01eb
            int r0 = r15.f4694e
            if (r0 == 0) goto L_0x01e2
        L_0x01e1:
            goto L_0x01ef
        L_0x01e2:
            int r0 = r15.f4697h
            if (r0 != 0) goto L_0x01ef
            int r0 = r15.f4698i
            if (r0 == 0) goto L_0x01fb
            goto L_0x01ef
        L_0x01eb:
            int r0 = r15.f4695f
            if (r0 == 0) goto L_0x01f2
        L_0x01ef:
            r13 = r1
            goto L_0x044e
        L_0x01f2:
            int r0 = r15.k
            if (r0 != 0) goto L_0x01ef
            int r0 = r15.l
            if (r0 == 0) goto L_0x01fb
            goto L_0x0202
        L_0x01fb:
            float r0 = r15.G
            r9 = 0
            int r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x0203
        L_0x0202:
            goto L_0x01e1
        L_0x0203:
            d.f.a.h.c[] r0 = r15.A
            int r9 = r7 + 1
            r0 = r0[r9]
            d.f.a.h.c r0 = r0.f4667d
            if (r0 == 0) goto L_0x0225
            d.f.a.h.d r0 = r0.f4665b
            d.f.a.h.c[] r9 = r0.A
            r25 = r0
            r0 = r9[r7]
            d.f.a.h.c r0 = r0.f4667d
            if (r0 == 0) goto L_0x0225
            r0 = r9[r7]
            d.f.a.h.c r0 = r0.f4667d
            d.f.a.h.d r0 = r0.f4665b
            if (r0 == r15) goto L_0x0222
            goto L_0x0225
        L_0x0222:
            r0 = r25
            goto L_0x0226
        L_0x0225:
            r0 = 0
        L_0x0226:
            if (r0 == 0) goto L_0x022f
            r15 = r0
            r9 = r24
            r0 = r27
            goto L_0x0179
        L_0x022f:
            r21 = 1
            r0 = r27
            r9 = r24
            goto L_0x0179
        L_0x0237:
            r24 = r9
            d.f.a.h.c[] r0 = r3.A
            r0 = r0[r7]
            d.f.a.h.j r0 = r0.f4664a
            d.f.a.h.c[] r9 = r4.A
            int r18 = r7 + 1
            r9 = r9[r18]
            d.f.a.h.j r9 = r9.f4664a
            r21 = r3
            d.f.a.h.j r3 = r0.f4717d
            if (r3 == 0) goto L_0x01ef
            d.f.a.h.j r1 = r9.f4717d
            if (r1 != 0) goto L_0x0252
            goto L_0x0262
        L_0x0252:
            int r3 = r3.f4726b
            r25 = r13
            r13 = 1
            if (r3 != r13) goto L_0x0262
            int r1 = r1.f4726b
            if (r1 == r13) goto L_0x025e
            goto L_0x0262
        L_0x025e:
            if (r8 <= 0) goto L_0x0266
            if (r8 == r6) goto L_0x0266
        L_0x0262:
            r13 = r28
            goto L_0x044e
        L_0x0266:
            if (r12 != 0) goto L_0x026f
            if (r14 != 0) goto L_0x026f
            if (r5 == 0) goto L_0x026d
            goto L_0x026f
        L_0x026d:
            r1 = 0
            goto L_0x0288
        L_0x026f:
            if (r10 == 0) goto L_0x027b
            d.f.a.h.c[] r1 = r10.A
            r1 = r1[r7]
            int r1 = r1.a()
            float r1 = (float) r1
            goto L_0x027c
        L_0x027b:
            r1 = 0
        L_0x027c:
            if (r11 == 0) goto L_0x0288
            d.f.a.h.c[] r3 = r11.A
            r3 = r3[r18]
            int r3 = r3.a()
            float r3 = (float) r3
            float r1 = r1 + r3
        L_0x0288:
            d.f.a.h.j r3 = r0.f4717d
            float r3 = r3.f4720g
            d.f.a.h.j r9 = r9.f4717d
            float r9 = r9.f4720g
            int r11 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r11 >= 0) goto L_0x0296
            float r9 = r9 - r3
            goto L_0x0298
        L_0x0296:
            float r9 = r3 - r9
        L_0x0298:
            float r9 = r9 - r19
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r8 <= 0) goto L_0x0326
            if (r8 != r6) goto L_0x0326
            d.f.a.h.d r1 = r15.D
            if (r1 == 0) goto L_0x02ad
            d.f.a.h.d$a[] r1 = r1.C
            r1 = r1[r2]
            d.f.a.h.d$a r5 = d.f.a.h.d.a.WRAP_CONTENT
            if (r1 != r5) goto L_0x02ad
            goto L_0x0262
        L_0x02ad:
            float r9 = r9 + r19
            float r9 = r9 - r20
            r1 = r3
            r3 = r21
        L_0x02b4:
            if (r3 == 0) goto L_0x0321
            d.f.a.h.d[] r5 = r3.i0
            r5 = r5[r2]
            if (r5 != 0) goto L_0x02c2
            if (r3 != r4) goto L_0x02bf
            goto L_0x02c2
        L_0x02bf:
            r13 = r28
            goto L_0x031f
        L_0x02c2:
            float r6 = (float) r8
            float r6 = r9 / r6
            r10 = 0
            int r12 = (r25 > r10 ? 1 : (r25 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x02d9
            float[] r6 = r3.g0
            r10 = r6[r2]
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x02d4
            r6 = 0
            goto L_0x02d9
        L_0x02d4:
            r6 = r6[r2]
            float r6 = r6 * r9
            float r6 = r6 / r25
        L_0x02d9:
            int r10 = r3.Y
            r12 = 8
            if (r10 != r12) goto L_0x02e0
            r6 = 0
        L_0x02e0:
            d.f.a.h.c[] r10 = r3.A
            r10 = r10[r7]
            int r10 = r10.a()
            float r10 = (float) r10
            float r1 = r1 + r10
            d.f.a.h.c[] r10 = r3.A
            r10 = r10[r7]
            d.f.a.h.j r10 = r10.f4664a
            d.f.a.h.j r12 = r0.f4719f
            r10.a(r12, r1)
            d.f.a.h.c[] r10 = r3.A
            r10 = r10[r18]
            d.f.a.h.j r10 = r10.f4664a
            d.f.a.h.j r12 = r0.f4719f
            float r1 = r1 + r6
            r10.a(r12, r1)
            d.f.a.h.c[] r6 = r3.A
            r6 = r6[r7]
            d.f.a.h.j r6 = r6.f4664a
            r13 = r28
            r6.a(r13)
            d.f.a.h.c[] r6 = r3.A
            r6 = r6[r18]
            d.f.a.h.j r6 = r6.f4664a
            r6.a(r13)
            d.f.a.h.c[] r3 = r3.A
            r3 = r3[r18]
            int r3 = r3.a()
            float r3 = (float) r3
            float r1 = r1 + r3
        L_0x031f:
            r3 = r5
            goto L_0x02b4
        L_0x0321:
            r13 = r28
            r14 = 1
            goto L_0x044f
        L_0x0326:
            r13 = r28
            r8 = 0
            int r8 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0330
            r5 = 0
            r12 = 1
            r14 = 0
        L_0x0330:
            if (r12 == 0) goto L_0x0399
            float r9 = r9 - r1
            if (r2 != 0) goto L_0x033a
            r8 = r21
            float r11 = r8.V
            goto L_0x0341
        L_0x033a:
            r8 = r21
            r1 = 1
            if (r2 != r1) goto L_0x0341
            float r11 = r8.W
        L_0x0341:
            float r9 = r9 * r11
            float r9 = r9 + r3
            r3 = r8
        L_0x0344:
            if (r3 == 0) goto L_0x03a0
            d.f.a.h.d[] r1 = r3.i0
            r1 = r1[r2]
            if (r1 != 0) goto L_0x034e
            if (r3 != r4) goto L_0x0397
        L_0x034e:
            if (r2 != 0) goto L_0x0355
            int r5 = r3.h()
            goto L_0x0359
        L_0x0355:
            int r5 = r3.c()
        L_0x0359:
            float r5 = (float) r5
            d.f.a.h.c[] r6 = r3.A
            r6 = r6[r7]
            int r6 = r6.a()
            float r6 = (float) r6
            float r9 = r9 + r6
            d.f.a.h.c[] r6 = r3.A
            r6 = r6[r7]
            d.f.a.h.j r6 = r6.f4664a
            d.f.a.h.j r8 = r0.f4719f
            r6.a(r8, r9)
            d.f.a.h.c[] r6 = r3.A
            r6 = r6[r18]
            d.f.a.h.j r6 = r6.f4664a
            d.f.a.h.j r8 = r0.f4719f
            float r9 = r9 + r5
            r6.a(r8, r9)
            d.f.a.h.c[] r5 = r3.A
            r5 = r5[r7]
            d.f.a.h.j r5 = r5.f4664a
            r5.a(r13)
            d.f.a.h.c[] r5 = r3.A
            r5 = r5[r18]
            d.f.a.h.j r5 = r5.f4664a
            r5.a(r13)
            d.f.a.h.c[] r3 = r3.A
            r3 = r3[r18]
            int r3 = r3.a()
            float r3 = (float) r3
            float r9 = r9 + r3
        L_0x0397:
            r3 = r1
            goto L_0x0344
        L_0x0399:
            r8 = r21
            if (r14 != 0) goto L_0x03a3
            if (r5 == 0) goto L_0x03a0
            goto L_0x03a3
        L_0x03a0:
            r5 = 1
            goto L_0x044c
        L_0x03a3:
            if (r14 == 0) goto L_0x03a6
            goto L_0x03a8
        L_0x03a6:
            if (r5 == 0) goto L_0x03a9
        L_0x03a8:
            float r9 = r9 - r1
        L_0x03a9:
            int r1 = r6 + 1
            float r1 = (float) r1
            float r1 = r9 / r1
            if (r5 == 0) goto L_0x03bb
            r11 = 1
            if (r6 <= r11) goto L_0x03b7
            int r1 = r6 + -1
            float r1 = (float) r1
            goto L_0x03b9
        L_0x03b7:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x03b9:
            float r1 = r9 / r1
        L_0x03bb:
            int r9 = r8.Y
            r11 = 8
            if (r9 == r11) goto L_0x03c4
            float r9 = r3 + r1
            goto L_0x03c5
        L_0x03c4:
            r9 = r3
        L_0x03c5:
            if (r5 == 0) goto L_0x03d6
            r5 = 1
            if (r6 <= r5) goto L_0x03d7
            d.f.a.h.c[] r6 = r10.A
            r6 = r6[r7]
            int r6 = r6.a()
            float r6 = (float) r6
            float r9 = r6 + r3
            goto L_0x03d7
        L_0x03d6:
            r5 = 1
        L_0x03d7:
            if (r14 == 0) goto L_0x03e5
            if (r10 == 0) goto L_0x03e5
            d.f.a.h.c[] r3 = r10.A
            r3 = r3[r7]
            int r3 = r3.a()
            float r3 = (float) r3
            float r9 = r9 + r3
        L_0x03e5:
            r3 = r8
        L_0x03e6:
            if (r3 == 0) goto L_0x044c
            d.f.a.h.d[] r6 = r3.i0
            r6 = r6[r2]
            if (r6 != 0) goto L_0x03f4
            if (r3 != r4) goto L_0x03f1
            goto L_0x03f4
        L_0x03f1:
            r8 = 8
            goto L_0x044a
        L_0x03f4:
            if (r2 != 0) goto L_0x03fb
            int r8 = r3.h()
            goto L_0x03ff
        L_0x03fb:
            int r8 = r3.c()
        L_0x03ff:
            float r8 = (float) r8
            if (r3 == r10) goto L_0x040c
            d.f.a.h.c[] r11 = r3.A
            r11 = r11[r7]
            int r11 = r11.a()
            float r11 = (float) r11
            float r9 = r9 + r11
        L_0x040c:
            d.f.a.h.c[] r11 = r3.A
            r11 = r11[r7]
            d.f.a.h.j r11 = r11.f4664a
            d.f.a.h.j r12 = r0.f4719f
            r11.a(r12, r9)
            d.f.a.h.c[] r11 = r3.A
            r11 = r11[r18]
            d.f.a.h.j r11 = r11.f4664a
            d.f.a.h.j r12 = r0.f4719f
            float r14 = r9 + r8
            r11.a(r12, r14)
            d.f.a.h.c[] r11 = r3.A
            r11 = r11[r7]
            d.f.a.h.j r11 = r11.f4664a
            r11.a(r13)
            d.f.a.h.c[] r11 = r3.A
            r11 = r11[r18]
            d.f.a.h.j r11 = r11.f4664a
            r11.a(r13)
            d.f.a.h.c[] r3 = r3.A
            r3 = r3[r18]
            int r3 = r3.a()
            float r3 = (float) r3
            float r8 = r8 + r3
            float r9 = r9 + r8
            if (r6 == 0) goto L_0x03f1
            int r3 = r6.Y
            r8 = 8
            if (r3 == r8) goto L_0x044a
            float r9 = r9 + r1
        L_0x044a:
            r3 = r6
            goto L_0x03e6
        L_0x044c:
            r14 = r5
            goto L_0x044f
        L_0x044e:
            r14 = 0
        L_0x044f:
            r0 = r27
            if (r14 != 0) goto L_0x0464
            r1 = r24
            a(r0, r13, r2, r7, r1)
            goto L_0x0464
        L_0x0459:
            r13 = r1
            r16 = r5
            r22 = r6
            r23 = r8
            r1 = r9
            a(r0, r13, r2, r7, r1)
        L_0x0464:
            int r8 = r23 + 1
            r1 = r13
            r5 = r16
            r6 = r22
            r3 = 2
            goto L_0x0015
        L_0x046e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(d.f.a.h.e, d.f.a.e, int):void");
    }

    public static float[] a(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 < 0 || i2 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static boolean a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int a(a0 a0Var, t tVar, View view, View view2, LayoutManager layoutManager, boolean z) {
        if (layoutManager.getChildCount() == 0 || a0Var.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.getPosition(view) - layoutManager.getPosition(view2)) + 1;
        }
        return Math.min(tVar.g(), tVar.a(view2) - tVar.d(view));
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static int a(f fVar, int i2) {
        int i3 = i2 * 2;
        List<d.f.a.h.d> list = null;
        if (fVar != null) {
            if (i2 == 0) {
                list = fVar.f4710f;
            } else if (i2 == 1) {
                list = fVar.f4711g;
            }
            int size = list.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                d.f.a.h.d dVar = (d.f.a.h.d) list.get(i5);
                d.f.a.h.c[] cVarArr = dVar.A;
                int i6 = i3 + 1;
                i4 = Math.max(i4, a(dVar, i2, cVarArr[i6].f4667d == null || !(cVarArr[i3].f4667d == null || cVarArr[i6].f4667d == null), 0));
            }
            fVar.f4709e[i2] = i4;
            return i4;
        }
        throw null;
    }

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
        Cipher instance = Cipher.getInstance(h.p);
        instance.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return instance.doFinal(bArr);
    }

    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, float f2) {
        if (!a(xmlPullParser, str)) {
            return f2;
        }
        return typedArray.getFloat(i2, f2);
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r21v1 */
    /* JADX WARNING: type inference failed for: r4v9, types: [d.f.a.g] */
    /* JADX WARNING: type inference failed for: r21v2 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r4v11, types: [d.f.a.g] */
    /* JADX WARNING: type inference failed for: r4v42 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r2.e0 == 2) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        if (r2.f0 == 2) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x040a  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04d2  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x052c  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x052f  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0535  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0538  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x054b  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x03e5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0169  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(d.f.a.h.e r33, d.f.a.e r34, int r35, int r36, d.f.a.h.b r37) {
        /*
            r0 = r33
            r9 = r34
            r1 = r37
            d.f.a.h.d r10 = r1.f4654a
            d.f.a.h.d r11 = r1.f4656c
            d.f.a.h.d r12 = r1.f4655b
            d.f.a.h.d r13 = r1.f4657d
            d.f.a.h.d r2 = r1.f4658e
            float r3 = r1.k
            d.f.a.h.d$a[] r4 = r0.C
            r4 = r4[r35]
            d.f.a.h.d$a r5 = d.f.a.h.d.a.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x001d
            r4 = r7
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            r5 = 2
            if (r35 != 0) goto L_0x0034
            int r8 = r2.e0
            if (r8 != 0) goto L_0x0027
            r8 = r7
            goto L_0x0028
        L_0x0027:
            r8 = 0
        L_0x0028:
            int r14 = r2.e0
            if (r14 != r7) goto L_0x002e
            r14 = r7
            goto L_0x002f
        L_0x002e:
            r14 = 0
        L_0x002f:
            int r15 = r2.e0
            if (r15 != r5) goto L_0x0048
            goto L_0x0046
        L_0x0034:
            int r8 = r2.f0
            if (r8 != 0) goto L_0x003a
            r8 = r7
            goto L_0x003b
        L_0x003a:
            r8 = 0
        L_0x003b:
            int r14 = r2.f0
            if (r14 != r7) goto L_0x0041
            r14 = r7
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            int r15 = r2.f0
            if (r15 != r5) goto L_0x0048
        L_0x0046:
            r5 = r7
            goto L_0x0049
        L_0x0048:
            r5 = 0
        L_0x0049:
            r7 = r10
            r15 = r14
            r14 = r8
            r8 = 0
        L_0x004d:
            r21 = 0
            if (r8 != 0) goto L_0x0120
            d.f.a.h.c[] r6 = r7.A
            r6 = r6[r36]
            if (r4 != 0) goto L_0x005d
            if (r5 == 0) goto L_0x005a
            goto L_0x005d
        L_0x005a:
            r23 = 4
            goto L_0x005f
        L_0x005d:
            r23 = 1
        L_0x005f:
            int r24 = r6.a()
            r25 = r3
            d.f.a.h.c r3 = r6.f4667d
            if (r3 == 0) goto L_0x0071
            if (r7 == r10) goto L_0x0071
            int r3 = r3.a()
            int r24 = r3 + r24
        L_0x0071:
            r3 = r24
            if (r5 == 0) goto L_0x007f
            if (r7 == r10) goto L_0x007f
            if (r7 == r12) goto L_0x007f
            r24 = r8
            r23 = r15
            r8 = 6
            goto L_0x008f
        L_0x007f:
            if (r14 == 0) goto L_0x0089
            if (r4 == 0) goto L_0x0089
            r24 = r8
            r23 = r15
            r8 = 4
            goto L_0x008f
        L_0x0089:
            r24 = r8
            r8 = r23
            r23 = r15
        L_0x008f:
            d.f.a.h.c r15 = r6.f4667d
            if (r15 == 0) goto L_0x00b8
            if (r7 != r12) goto L_0x00a2
            r26 = r14
            d.f.a.g r14 = r6.f4672i
            d.f.a.g r15 = r15.f4672i
            r27 = r2
            r2 = 5
            r9.b(r14, r15, r3, r2)
            goto L_0x00ae
        L_0x00a2:
            r27 = r2
            r26 = r14
            d.f.a.g r2 = r6.f4672i
            d.f.a.g r14 = r15.f4672i
            r15 = 6
            r9.b(r2, r14, r3, r15)
        L_0x00ae:
            d.f.a.g r2 = r6.f4672i
            d.f.a.h.c r6 = r6.f4667d
            d.f.a.g r6 = r6.f4672i
            r9.a(r2, r6, r3, r8)
            goto L_0x00bc
        L_0x00b8:
            r27 = r2
            r26 = r14
        L_0x00bc:
            if (r4 == 0) goto L_0x00ef
            int r2 = r7.Y
            r3 = 8
            if (r2 == r3) goto L_0x00de
            d.f.a.h.d$a[] r2 = r7.C
            r2 = r2[r35]
            d.f.a.h.d$a r3 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00de
            d.f.a.h.c[] r2 = r7.A
            int r3 = r36 + 1
            r3 = r2[r3]
            d.f.a.g r3 = r3.f4672i
            r2 = r2[r36]
            d.f.a.g r2 = r2.f4672i
            r6 = 5
            r8 = 0
            r9.b(r3, r2, r8, r6)
            goto L_0x00df
        L_0x00de:
            r8 = 0
        L_0x00df:
            d.f.a.h.c[] r2 = r7.A
            r2 = r2[r36]
            d.f.a.g r2 = r2.f4672i
            d.f.a.h.c[] r3 = r0.A
            r3 = r3[r36]
            d.f.a.g r3 = r3.f4672i
            r6 = 6
            r9.b(r2, r3, r8, r6)
        L_0x00ef:
            d.f.a.h.c[] r2 = r7.A
            int r3 = r36 + 1
            r2 = r2[r3]
            d.f.a.h.c r2 = r2.f4667d
            if (r2 == 0) goto L_0x010e
            d.f.a.h.d r2 = r2.f4665b
            d.f.a.h.c[] r3 = r2.A
            r6 = r3[r36]
            d.f.a.h.c r6 = r6.f4667d
            if (r6 == 0) goto L_0x010e
            r3 = r3[r36]
            d.f.a.h.c r3 = r3.f4667d
            d.f.a.h.d r3 = r3.f4665b
            if (r3 == r7) goto L_0x010c
            goto L_0x010e
        L_0x010c:
            r21 = r2
        L_0x010e:
            if (r21 == 0) goto L_0x0115
            r7 = r21
            r8 = r24
            goto L_0x0116
        L_0x0115:
            r8 = 1
        L_0x0116:
            r15 = r23
            r3 = r25
            r14 = r26
            r2 = r27
            goto L_0x004d
        L_0x0120:
            r27 = r2
            r25 = r3
            r26 = r14
            r23 = r15
            if (r13 == 0) goto L_0x014a
            d.f.a.h.c[] r2 = r11.A
            int r3 = r36 + 1
            r6 = r2[r3]
            d.f.a.h.c r6 = r6.f4667d
            if (r6 == 0) goto L_0x014a
            d.f.a.h.c[] r6 = r13.A
            r6 = r6[r3]
            d.f.a.g r7 = r6.f4672i
            r2 = r2[r3]
            d.f.a.h.c r2 = r2.f4667d
            d.f.a.g r2 = r2.f4672i
            int r3 = r6.a()
            int r3 = -r3
            r6 = 5
            r9.c(r7, r2, r3, r6)
            goto L_0x014b
        L_0x014a:
            r6 = 5
        L_0x014b:
            if (r4 == 0) goto L_0x0165
            d.f.a.h.c[] r0 = r0.A
            int r2 = r36 + 1
            r0 = r0[r2]
            d.f.a.g r0 = r0.f4672i
            d.f.a.h.c[] r3 = r11.A
            r4 = r3[r2]
            d.f.a.g r4 = r4.f4672i
            r2 = r3[r2]
            int r2 = r2.a()
            r3 = 6
            r9.b(r0, r4, r2, r3)
        L_0x0165:
            java.util.ArrayList<d.f.a.h.d> r0 = r1.f4661h
            if (r0 == 0) goto L_0x028d
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x028d
            boolean r4 = r1.n
            if (r4 == 0) goto L_0x017c
            boolean r4 = r1.p
            if (r4 != 0) goto L_0x017c
            int r4 = r1.f4663j
            float r4 = (float) r4
            goto L_0x017e
        L_0x017c:
            r4 = r25
        L_0x017e:
            r7 = 0
            r15 = r7
            r14 = r21
            r8 = 0
        L_0x0183:
            if (r8 >= r2) goto L_0x028d
            java.lang.Object r16 = r0.get(r8)
            r3 = r16
            d.f.a.h.d r3 = (d.f.a.h.d) r3
            float[] r6 = r3.g0
            r6 = r6[r35]
            int r24 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r24 >= 0) goto L_0x01b9
            boolean r6 = r1.p
            if (r6 == 0) goto L_0x01b1
            d.f.a.h.c[] r3 = r3.A
            int r6 = r36 + 1
            r6 = r3[r6]
            d.f.a.g r6 = r6.f4672i
            r3 = r3[r36]
            d.f.a.g r3 = r3.f4672i
            r20 = r0
            r0 = 0
            r7 = 4
            r9.a(r6, r3, r0, r7)
            r24 = r7
            r6 = 6
            r7 = r0
            goto L_0x01d3
        L_0x01b1:
            r20 = r0
            r24 = 4
            r0 = 0
            r6 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01be
        L_0x01b9:
            r20 = r0
            r24 = 4
            r0 = 0
        L_0x01be:
            int r25 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r25 != 0) goto L_0x01dd
            d.f.a.h.c[] r0 = r3.A
            int r3 = r36 + 1
            r3 = r0[r3]
            d.f.a.g r3 = r3.f4672i
            r0 = r0[r36]
            d.f.a.g r0 = r0.f4672i
            r6 = 6
            r7 = 0
            r9.a(r3, r0, r7, r6)
        L_0x01d3:
            r29 = r2
            r33 = r4
            r17 = r6
            r30 = 0
            goto L_0x027d
        L_0x01dd:
            r0 = 0
            r17 = 6
            if (r14 == 0) goto L_0x0272
            d.f.a.h.c[] r14 = r14.A
            r0 = r14[r36]
            d.f.a.g r0 = r0.f4672i
            int r28 = r36 + 1
            r14 = r14[r28]
            d.f.a.g r14 = r14.f4672i
            d.f.a.h.c[] r7 = r3.A
            r29 = r2
            r2 = r7[r36]
            d.f.a.g r2 = r2.f4672i
            r7 = r7[r28]
            d.f.a.g r7 = r7.f4672i
            r28 = r3
            d.f.a.b r3 = r34.b()
            r1 = 0
            r3.f4619b = r1
            int r30 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r30 == 0) goto L_0x0253
            int r30 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r30 != 0) goto L_0x020e
            goto L_0x0253
        L_0x020e:
            r30 = 0
            int r31 = (r15 > r30 ? 1 : (r15 == r30 ? 0 : -1))
            if (r31 != 0) goto L_0x0223
            d.f.a.a r2 = r3.f4621d
            r7 = 1065353216(0x3f800000, float:1.0)
            r2.a(r0, r7)
            d.f.a.a r0 = r3.f4621d
            r0.a(r14, r1)
        L_0x0220:
            r33 = r4
            goto L_0x026e
        L_0x0223:
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r25 != 0) goto L_0x0234
            d.f.a.a r0 = r3.f4621d
            r0.a(r2, r1)
            d.f.a.a r0 = r3.f4621d
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0.a(r7, r1)
            goto L_0x0220
        L_0x0234:
            float r15 = r15 / r4
            float r25 = r6 / r4
            float r15 = r15 / r25
            r33 = r4
            d.f.a.a r4 = r3.f4621d
            r4.a(r0, r1)
            d.f.a.a r0 = r3.f4621d
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0.a(r14, r4)
            d.f.a.a r0 = r3.f4621d
            r0.a(r7, r15)
            d.f.a.a r0 = r3.f4621d
            float r1 = -r15
            r0.a(r2, r1)
            goto L_0x026e
        L_0x0253:
            r33 = r4
            r30 = 0
            r4 = r1
            r1 = 1065353216(0x3f800000, float:1.0)
            d.f.a.a r15 = r3.f4621d
            r15.a(r0, r1)
            d.f.a.a r0 = r3.f4621d
            r0.a(r14, r4)
            d.f.a.a r0 = r3.f4621d
            r0.a(r7, r1)
            d.f.a.a r0 = r3.f4621d
            r0.a(r2, r4)
        L_0x026e:
            r9.a(r3)
            goto L_0x027a
        L_0x0272:
            r29 = r2
            r28 = r3
            r33 = r4
            r30 = 0
        L_0x027a:
            r15 = r6
            r14 = r28
        L_0x027d:
            int r8 = r8 + 1
            r4 = r33
            r1 = r37
            r0 = r20
            r2 = r29
            r7 = r30
            r3 = 1
            r6 = 5
            goto L_0x0183
        L_0x028d:
            r17 = 6
            r24 = 4
            if (r12 == 0) goto L_0x02f3
            if (r12 == r13) goto L_0x0297
            if (r5 == 0) goto L_0x02f3
        L_0x0297:
            d.f.a.h.c[] r0 = r10.A
            r1 = r0[r36]
            d.f.a.h.c[] r2 = r11.A
            int r3 = r36 + 1
            r2 = r2[r3]
            r4 = r0[r36]
            d.f.a.h.c r4 = r4.f4667d
            if (r4 == 0) goto L_0x02af
            r0 = r0[r36]
            d.f.a.h.c r0 = r0.f4667d
            d.f.a.g r0 = r0.f4672i
            r4 = r0
            goto L_0x02b1
        L_0x02af:
            r4 = r21
        L_0x02b1:
            d.f.a.h.c[] r0 = r11.A
            r5 = r0[r3]
            d.f.a.h.c r5 = r5.f4667d
            if (r5 == 0) goto L_0x02c1
            r0 = r0[r3]
            d.f.a.h.c r0 = r0.f4667d
            d.f.a.g r0 = r0.f4672i
            r5 = r0
            goto L_0x02c3
        L_0x02c1:
            r5 = r21
        L_0x02c3:
            if (r12 != r13) goto L_0x02cb
            d.f.a.h.c[] r0 = r12.A
            r1 = r0[r36]
            r2 = r0[r3]
        L_0x02cb:
            if (r4 == 0) goto L_0x0518
            if (r5 == 0) goto L_0x0518
            if (r35 != 0) goto L_0x02d6
            r0 = r27
            float r0 = r0.V
            goto L_0x02da
        L_0x02d6:
            r0 = r27
            float r0 = r0.W
        L_0x02da:
            r6 = r0
            int r3 = r1.a()
            int r7 = r2.a()
            d.f.a.g r1 = r1.f4672i
            d.f.a.g r8 = r2.f4672i
            r10 = 5
            r0 = r34
            r2 = r4
            r4 = r6
            r6 = r8
            r8 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0518
        L_0x02f3:
            if (r26 == 0) goto L_0x03ed
            if (r12 == 0) goto L_0x03ed
            r0 = r37
            int r1 = r0.f4663j
            if (r1 <= 0) goto L_0x0304
            int r0 = r0.f4662i
            if (r0 != r1) goto L_0x0304
            r19 = 1
            goto L_0x0306
        L_0x0304:
            r19 = 0
        L_0x0306:
            r14 = r12
            r15 = r14
        L_0x0308:
            if (r14 == 0) goto L_0x0518
            d.f.a.h.d[] r0 = r14.i0
            r0 = r0[r35]
            r8 = r0
        L_0x030f:
            if (r8 == 0) goto L_0x031c
            int r0 = r8.Y
            r6 = 8
            if (r0 != r6) goto L_0x031e
            d.f.a.h.d[] r0 = r8.i0
            r8 = r0[r35]
            goto L_0x030f
        L_0x031c:
            r6 = 8
        L_0x031e:
            if (r8 != 0) goto L_0x032b
            if (r14 != r13) goto L_0x0323
            goto L_0x032b
        L_0x0323:
            r16 = r8
            r18 = r17
            r17 = r24
            goto L_0x03de
        L_0x032b:
            d.f.a.h.c[] r0 = r14.A
            r0 = r0[r36]
            d.f.a.g r1 = r0.f4672i
            d.f.a.h.c r2 = r0.f4667d
            if (r2 == 0) goto L_0x0338
            d.f.a.g r2 = r2.f4672i
            goto L_0x033a
        L_0x0338:
            r2 = r21
        L_0x033a:
            if (r15 == r14) goto L_0x0345
            d.f.a.h.c[] r2 = r15.A
            int r3 = r36 + 1
            r2 = r2[r3]
            d.f.a.g r2 = r2.f4672i
            goto L_0x035a
        L_0x0345:
            if (r14 != r12) goto L_0x035a
            if (r15 != r14) goto L_0x035a
            d.f.a.h.c[] r2 = r10.A
            r3 = r2[r36]
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0358
            r2 = r2[r36]
            d.f.a.h.c r2 = r2.f4667d
            d.f.a.g r2 = r2.f4672i
            goto L_0x035a
        L_0x0358:
            r2 = r21
        L_0x035a:
            int r0 = r0.a()
            d.f.a.h.c[] r3 = r14.A
            int r4 = r36 + 1
            r3 = r3[r4]
            int r3 = r3.a()
            if (r8 == 0) goto L_0x037c
            d.f.a.h.c[] r5 = r8.A
            r5 = r5[r36]
            d.f.a.g r7 = r5.f4672i
            d.f.a.h.c[] r6 = r14.A
            r6 = r6[r4]
            d.f.a.g r6 = r6.f4672i
            r32 = r7
            r7 = r6
            r6 = r32
            goto L_0x038f
        L_0x037c:
            d.f.a.h.c[] r5 = r11.A
            r5 = r5[r4]
            d.f.a.h.c r5 = r5.f4667d
            if (r5 == 0) goto L_0x0387
            d.f.a.g r6 = r5.f4672i
            goto L_0x0389
        L_0x0387:
            r6 = r21
        L_0x0389:
            d.f.a.h.c[] r7 = r14.A
            r7 = r7[r4]
            d.f.a.g r7 = r7.f4672i
        L_0x038f:
            if (r5 == 0) goto L_0x0396
            int r5 = r5.a()
            int r3 = r3 + r5
        L_0x0396:
            if (r15 == 0) goto L_0x03a1
            d.f.a.h.c[] r5 = r15.A
            r5 = r5[r4]
            int r5 = r5.a()
            int r0 = r0 + r5
        L_0x03a1:
            if (r1 == 0) goto L_0x0323
            if (r2 == 0) goto L_0x0323
            if (r6 == 0) goto L_0x0323
            if (r7 == 0) goto L_0x0323
            if (r14 != r12) goto L_0x03b3
            d.f.a.h.c[] r0 = r12.A
            r0 = r0[r36]
            int r0 = r0.a()
        L_0x03b3:
            r5 = r0
            if (r14 != r13) goto L_0x03c1
            d.f.a.h.c[] r0 = r13.A
            r0 = r0[r4]
            int r0 = r0.a()
            r16 = r0
            goto L_0x03c3
        L_0x03c1:
            r16 = r3
        L_0x03c3:
            if (r19 == 0) goto L_0x03c8
            r20 = r17
            goto L_0x03ca
        L_0x03c8:
            r20 = r24
        L_0x03ca:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r34
            r3 = r5
            r5 = r6
            r18 = r17
            r17 = r24
            r6 = r7
            r7 = r16
            r16 = r8
            r8 = r20
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x03de:
            int r0 = r14.Y
            r8 = 8
            if (r0 == r8) goto L_0x03e5
            r15 = r14
        L_0x03e5:
            r14 = r16
            r24 = r17
            r17 = r18
            goto L_0x0308
        L_0x03ed:
            r0 = r37
            r18 = r17
            r17 = r24
            r8 = 8
            if (r23 == 0) goto L_0x0518
            if (r12 == 0) goto L_0x0518
            int r1 = r0.f4663j
            if (r1 <= 0) goto L_0x0404
            int r0 = r0.f4662i
            if (r0 != r1) goto L_0x0404
            r19 = 1
            goto L_0x0406
        L_0x0404:
            r19 = 0
        L_0x0406:
            r14 = r12
            r15 = r14
        L_0x0408:
            if (r14 == 0) goto L_0x04ba
            d.f.a.h.d[] r0 = r14.i0
            r0 = r0[r35]
        L_0x040e:
            if (r0 == 0) goto L_0x0419
            int r1 = r0.Y
            if (r1 != r8) goto L_0x0419
            d.f.a.h.d[] r0 = r0.i0
            r0 = r0[r35]
            goto L_0x040e
        L_0x0419:
            if (r14 == r12) goto L_0x04ab
            if (r14 == r13) goto L_0x04ab
            if (r0 == 0) goto L_0x04ab
            if (r0 != r13) goto L_0x0424
            r7 = r21
            goto L_0x0425
        L_0x0424:
            r7 = r0
        L_0x0425:
            d.f.a.h.c[] r0 = r14.A
            r0 = r0[r36]
            d.f.a.g r1 = r0.f4672i
            d.f.a.h.c r2 = r0.f4667d
            if (r2 == 0) goto L_0x0431
            d.f.a.g r2 = r2.f4672i
        L_0x0431:
            d.f.a.h.c[] r2 = r15.A
            int r3 = r36 + 1
            r2 = r2[r3]
            d.f.a.g r2 = r2.f4672i
            int r0 = r0.a()
            d.f.a.h.c[] r4 = r14.A
            r4 = r4[r3]
            int r4 = r4.a()
            if (r7 == 0) goto L_0x0457
            d.f.a.h.c[] r5 = r7.A
            r5 = r5[r36]
            d.f.a.g r6 = r5.f4672i
            d.f.a.h.c r8 = r5.f4667d
            if (r8 == 0) goto L_0x0454
            d.f.a.g r8 = r8.f4672i
            goto L_0x046a
        L_0x0454:
            r8 = r21
            goto L_0x046a
        L_0x0457:
            d.f.a.h.c[] r5 = r14.A
            r5 = r5[r3]
            d.f.a.h.c r5 = r5.f4667d
            if (r5 == 0) goto L_0x0462
            d.f.a.g r6 = r5.f4672i
            goto L_0x0464
        L_0x0462:
            r6 = r21
        L_0x0464:
            d.f.a.h.c[] r8 = r14.A
            r8 = r8[r3]
            d.f.a.g r8 = r8.f4672i
        L_0x046a:
            if (r5 == 0) goto L_0x0474
            int r5 = r5.a()
            int r5 = r5 + r4
            r20 = r5
            goto L_0x0476
        L_0x0474:
            r20 = r4
        L_0x0476:
            d.f.a.h.c[] r4 = r15.A
            r3 = r4[r3]
            int r3 = r3.a()
            int r3 = r3 + r0
            if (r19 == 0) goto L_0x0484
            r22 = r18
            goto L_0x0486
        L_0x0484:
            r22 = r17
        L_0x0486:
            if (r1 == 0) goto L_0x04a2
            if (r2 == 0) goto L_0x04a2
            if (r6 == 0) goto L_0x04a2
            if (r8 == 0) goto L_0x04a2
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r34
            r5 = r6
            r6 = r8
            r16 = r7
            r7 = r20
            r20 = r15
            r15 = 8
            r8 = r22
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04a8
        L_0x04a2:
            r16 = r7
            r20 = r15
            r15 = 8
        L_0x04a8:
            r0 = r16
            goto L_0x04ae
        L_0x04ab:
            r20 = r15
            r15 = r8
        L_0x04ae:
            int r1 = r14.Y
            if (r1 == r15) goto L_0x04b3
            goto L_0x04b5
        L_0x04b3:
            r14 = r20
        L_0x04b5:
            r8 = r15
            r15 = r14
            r14 = r0
            goto L_0x0408
        L_0x04ba:
            d.f.a.h.c[] r0 = r12.A
            r0 = r0[r36]
            d.f.a.h.c[] r1 = r10.A
            r1 = r1[r36]
            d.f.a.h.c r1 = r1.f4667d
            d.f.a.h.c[] r2 = r13.A
            int r3 = r36 + 1
            r10 = r2[r3]
            d.f.a.h.c[] r2 = r11.A
            r2 = r2[r3]
            d.f.a.h.c r14 = r2.f4667d
            if (r1 == 0) goto L_0x0507
            if (r12 == r13) goto L_0x04e1
            d.f.a.g r2 = r0.f4672i
            d.f.a.g r1 = r1.f4672i
            int r0 = r0.a()
            r15 = 5
            r9.a(r2, r1, r0, r15)
            goto L_0x0508
        L_0x04e1:
            r15 = 5
            if (r14 == 0) goto L_0x0508
            d.f.a.g r2 = r0.f4672i
            d.f.a.g r3 = r1.f4672i
            int r4 = r0.a()
            r5 = 1056964608(0x3f000000, float:0.5)
            d.f.a.g r6 = r10.f4672i
            d.f.a.g r7 = r14.f4672i
            int r8 = r10.a()
            r16 = 5
            r0 = r34
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r16
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0508
        L_0x0507:
            r15 = 5
        L_0x0508:
            if (r14 == 0) goto L_0x0518
            if (r12 == r13) goto L_0x0518
            d.f.a.g r0 = r10.f4672i
            d.f.a.g r1 = r14.f4672i
            int r2 = r10.a()
            int r2 = -r2
            r9.a(r0, r1, r2, r15)
        L_0x0518:
            if (r26 != 0) goto L_0x051c
            if (r23 == 0) goto L_0x057a
        L_0x051c:
            if (r12 == 0) goto L_0x057a
            d.f.a.h.c[] r0 = r12.A
            r0 = r0[r36]
            d.f.a.h.c[] r1 = r13.A
            int r2 = r36 + 1
            r1 = r1[r2]
            d.f.a.h.c r3 = r0.f4667d
            if (r3 == 0) goto L_0x052f
            d.f.a.g r3 = r3.f4672i
            goto L_0x0531
        L_0x052f:
            r3 = r21
        L_0x0531:
            d.f.a.h.c r4 = r1.f4667d
            if (r4 == 0) goto L_0x0538
            d.f.a.g r4 = r4.f4672i
            goto L_0x053a
        L_0x0538:
            r4 = r21
        L_0x053a:
            if (r11 == r13) goto L_0x054b
            d.f.a.h.c[] r4 = r11.A
            r4 = r4[r2]
            d.f.a.h.c r4 = r4.f4667d
            if (r4 == 0) goto L_0x0548
            d.f.a.g r4 = r4.f4672i
            r21 = r4
        L_0x0548:
            r5 = r21
            goto L_0x054c
        L_0x054b:
            r5 = r4
        L_0x054c:
            if (r12 != r13) goto L_0x0559
            d.f.a.h.c[] r0 = r12.A
            r1 = r0[r36]
            r0 = r0[r2]
            r32 = r1
            r1 = r0
            r0 = r32
        L_0x0559:
            if (r3 == 0) goto L_0x057a
            if (r5 == 0) goto L_0x057a
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.a()
            d.f.a.h.c[] r7 = r13.A
            r2 = r7[r2]
            int r7 = r2.a()
            d.f.a.g r2 = r0.f4672i
            d.f.a.g r8 = r1.f4672i
            r10 = 5
            r0 = r34
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x057a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(d.f.a.h.e, d.f.a.e, int, int, d.f.a.h.b):void");
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return a(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008a, code lost:
        if (r13 == 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008c, code lost:
        r11 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0097 A[Catch:{ NumberFormatException -> 0x00bc }, LOOP:3: B:26:0x006c->B:46:0x0097, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0096 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static d.h.f.b[] a(java.lang.String r17) {
        /*
            r0 = r17
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 1
            r4 = r3
            r3 = r2
        L_0x000f:
            int r5 = r17.length()
            if (r4 >= r5) goto L_0x00e3
        L_0x0015:
            int r5 = r17.length()
            r6 = 69
            r7 = 101(0x65, float:1.42E-43)
            if (r4 >= r5) goto L_0x0039
            char r5 = r0.charAt(r4)
            int r8 = r5 + -65
            int r9 = r5 + -90
            int r9 = r9 * r8
            if (r9 <= 0) goto L_0x0031
            int r8 = r5 + -97
            int r9 = r5 + -122
            int r9 = r9 * r8
            if (r9 > 0) goto L_0x0036
        L_0x0031:
            if (r5 == r7) goto L_0x0036
            if (r5 == r6) goto L_0x0036
            goto L_0x0039
        L_0x0036:
            int r4 = r4 + 1
            goto L_0x0015
        L_0x0039:
            java.lang.String r2 = r0.substring(r2, r4)
            java.lang.String r2 = r2.trim()
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x00d9
            char r5 = r2.charAt(r3)
            r8 = 122(0x7a, float:1.71E-43)
            if (r5 == r8) goto L_0x00cb
            char r5 = r2.charAt(r3)
            r8 = 90
            if (r5 != r8) goto L_0x0059
            goto L_0x00cb
        L_0x0059:
            int r5 = r2.length()     // Catch:{ NumberFormatException -> 0x00bc }
            float[] r5 = new float[r5]     // Catch:{ NumberFormatException -> 0x00bc }
            int r8 = r2.length()     // Catch:{ NumberFormatException -> 0x00bc }
            r9 = 1
            r10 = r9
            r9 = r3
        L_0x0066:
            if (r10 >= r8) goto L_0x00b1
            r11 = r3
            r12 = r11
            r13 = r12
            r14 = r10
        L_0x006c:
            int r15 = r2.length()     // Catch:{ NumberFormatException -> 0x00bc }
            if (r14 >= r15) goto L_0x009a
            char r15 = r2.charAt(r14)     // Catch:{ NumberFormatException -> 0x00bc }
            r7 = 32
            if (r15 == r7) goto L_0x0090
            r7 = 101(0x65, float:1.42E-43)
            if (r15 == r6) goto L_0x008e
            if (r15 == r7) goto L_0x008e
            switch(r15) {
                case 44: goto L_0x0092;
                case 45: goto L_0x0088;
                case 46: goto L_0x0084;
                default: goto L_0x0083;
            }     // Catch:{ NumberFormatException -> 0x00bc }
        L_0x0083:
            goto L_0x0093
        L_0x0084:
            if (r12 != 0) goto L_0x008c
            r12 = 1
            goto L_0x0093
        L_0x0088:
            if (r14 == r10) goto L_0x0093
            if (r13 != 0) goto L_0x0093
        L_0x008c:
            r11 = 1
            goto L_0x0092
        L_0x008e:
            r13 = 1
            goto L_0x0094
        L_0x0090:
            r7 = 101(0x65, float:1.42E-43)
        L_0x0092:
            r3 = 1
        L_0x0093:
            r13 = 0
        L_0x0094:
            if (r3 == 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            int r14 = r14 + 1
            goto L_0x006c
        L_0x009a:
            if (r10 >= r14) goto L_0x00a9
            int r3 = r9 + 1
            java.lang.String r10 = r2.substring(r10, r14)     // Catch:{ NumberFormatException -> 0x00bc }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ NumberFormatException -> 0x00bc }
            r5[r9] = r10     // Catch:{ NumberFormatException -> 0x00bc }
            r9 = r3
        L_0x00a9:
            if (r11 == 0) goto L_0x00ac
            goto L_0x00ae
        L_0x00ac:
            int r14 = r14 + 1
        L_0x00ae:
            r10 = r14
            r3 = 0
            goto L_0x0066
        L_0x00b1:
            float[] r3 = a(r5, r3, r9)     // Catch:{ NumberFormatException -> 0x00bc }
            r5 = 0
            r16 = r5
            r5 = r3
            r3 = r16
            goto L_0x00cd
        L_0x00bc:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r3 = "error in parsing \""
            java.lang.String r4 = "\""
            java.lang.String r2 = e.a.a.a.a.a(r3, r2, r4)
            r1.<init>(r2, r0)
            throw r1
        L_0x00cb:
            float[] r5 = new float[r3]
        L_0x00cd:
            char r2 = r2.charAt(r3)
            d.h.f.b r3 = new d.h.f.b
            r3.<init>(r2, r5)
            r1.add(r3)
        L_0x00d9:
            int r2 = r4 + 1
            r3 = 0
            r16 = r4
            r4 = r2
            r2 = r16
            goto L_0x000f
        L_0x00e3:
            int r4 = r4 - r2
            r3 = 1
            if (r4 != r3) goto L_0x00fc
            int r3 = r17.length()
            if (r2 >= r3) goto L_0x00fc
            char r0 = r0.charAt(r2)
            r2 = 0
            float[] r2 = new float[r2]
            d.h.f.b r3 = new d.h.f.b
            r3.<init>(r0, r2)
            r1.add(r3)
        L_0x00fc:
            int r0 = r1.size()
            d.h.f.b[] r0 = new d.h.f.b[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            d.h.f.b[] r0 = (d.h.f.b[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(java.lang.String):d.h.f.b[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r9.addSuppressed(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004a, code lost:
        throw r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.ByteBuffer a(android.content.Context r7, android.os.CancellationSignal r8, android.net.Uri r9) {
        /*
            android.content.ContentResolver r7 = r7.getContentResolver()
            r0 = 0
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r7 = r7.openFileDescriptor(r9, r1, r8)     // Catch:{ IOException -> 0x004b }
            if (r7 != 0) goto L_0x0013
            if (r7 == 0) goto L_0x0012
            r7.close()     // Catch:{ IOException -> 0x004b }
        L_0x0012:
            return r0
        L_0x0013:
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ all -> 0x003f }
            java.io.FileDescriptor r9 = r7.getFileDescriptor()     // Catch:{ all -> 0x003f }
            r8.<init>(r9)     // Catch:{ all -> 0x003f }
            java.nio.channels.FileChannel r1 = r8.getChannel()     // Catch:{ all -> 0x0033 }
            long r5 = r1.size()     // Catch:{ all -> 0x0033 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0033 }
            r3 = 0
            java.nio.MappedByteBuffer r9 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x0033 }
            r8.close()     // Catch:{ all -> 0x003f }
            r7.close()     // Catch:{ IOException -> 0x004b }
            return r9
        L_0x0033:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r1 = move-exception
            r8.close()     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r8 = move-exception
            r9.addSuppressed(r8)     // Catch:{ all -> 0x003f }
        L_0x003e:
            throw r1     // Catch:{ all -> 0x003f }
        L_0x003f:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r9 = move-exception
            r7.close()     // Catch:{ all -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch:{ IOException -> 0x004b }
        L_0x004a:
            throw r9     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(android.content.Context, android.os.CancellationSignal, android.net.Uri):java.nio.ByteBuffer");
    }

    /* JADX WARNING: type inference failed for: r8v16, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r19
            r1 = r20
            java.lang.String r2 = r18.getName()
            java.lang.String r3 = "selector"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0109
            int r2 = r18.getDepth()
            r3 = 1
            int r2 = r2 + r3
            r4 = 20
            int[][] r5 = new int[r4][]
            int[] r4 = new int[r4]
            r6 = 0
            r7 = r6
        L_0x001e:
            int r8 = r18.next()
            if (r8 == r3) goto L_0x00f9
            int r9 = r18.getDepth()
            if (r9 >= r2) goto L_0x002d
            r10 = 3
            if (r8 == r10) goto L_0x00f9
        L_0x002d:
            r10 = 2
            if (r8 != r10) goto L_0x00f4
            if (r9 > r2) goto L_0x00f4
            java.lang.String r8 = r18.getName()
            java.lang.String r9 = "item"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0040
            goto L_0x00f4
        L_0x0040:
            int[] r8 = d.h.c.ColorStateListItem
            if (r1 != 0) goto L_0x004b
            r9 = r17
            android.content.res.TypedArray r8 = r9.obtainAttributes(r0, r8)
            goto L_0x0051
        L_0x004b:
            r9 = r17
            android.content.res.TypedArray r8 = r1.obtainStyledAttributes(r0, r8, r6, r6)
        L_0x0051:
            int r10 = d.h.c.ColorStateListItem_android_color
            r11 = -65281(0xffffffffffff00ff, float:NaN)
            int r10 = r8.getColor(r10, r11)
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = d.h.c.ColorStateListItem_android_alpha
            boolean r12 = r8.hasValue(r12)
            if (r12 == 0) goto L_0x006b
            int r12 = d.h.c.ColorStateListItem_android_alpha
            float r11 = r8.getFloat(r12, r11)
            goto L_0x0079
        L_0x006b:
            int r12 = d.h.c.ColorStateListItem_alpha
            boolean r12 = r8.hasValue(r12)
            if (r12 == 0) goto L_0x0079
            int r12 = d.h.c.ColorStateListItem_alpha
            float r11 = r8.getFloat(r12, r11)
        L_0x0079:
            r8.recycle()
            int r8 = r19.getAttributeCount()
            int[] r12 = new int[r8]
            r13 = r6
            r14 = r13
        L_0x0084:
            if (r13 >= r8) goto L_0x00a9
            int r15 = r0.getAttributeNameResource(r13)
            r3 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r3) goto L_0x00a5
            r3 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r3) goto L_0x00a5
            int r3 = d.h.a.alpha
            if (r15 == r3) goto L_0x00a5
            int r3 = r14 + 1
            boolean r16 = r0.getAttributeBooleanValue(r13, r6)
            if (r16 == 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            int r15 = -r15
        L_0x00a2:
            r12[r14] = r15
            r14 = r3
        L_0x00a5:
            int r13 = r13 + 1
            r3 = 1
            goto L_0x0084
        L_0x00a9:
            int[] r3 = android.util.StateSet.trimStateSet(r12, r14)
            int r8 = android.graphics.Color.alpha(r10)
            float r8 = (float) r8
            float r8 = r8 * r11
            int r8 = java.lang.Math.round(r8)
            r11 = 16777215(0xffffff, float:2.3509886E-38)
            r10 = r10 & r11
            int r8 = r8 << 24
            r8 = r8 | r10
            int r10 = r7 + 1
            int r11 = r4.length
            r12 = 8
            r13 = 4
            if (r10 <= r11) goto L_0x00d2
            if (r7 > r13) goto L_0x00ca
            r11 = r12
            goto L_0x00cc
        L_0x00ca:
            int r11 = r7 * 2
        L_0x00cc:
            int[] r11 = new int[r11]
            java.lang.System.arraycopy(r4, r6, r11, r6, r7)
            r4 = r11
        L_0x00d2:
            r4[r7] = r8
            int r8 = r5.length
            if (r10 <= r8) goto L_0x00ee
            java.lang.Class r8 = r5.getClass()
            java.lang.Class r8 = r8.getComponentType()
            if (r7 > r13) goto L_0x00e2
            goto L_0x00e4
        L_0x00e2:
            int r12 = r7 * 2
        L_0x00e4:
            java.lang.Object r8 = java.lang.reflect.Array.newInstance(r8, r12)
            java.lang.Object[] r8 = (java.lang.Object[]) r8
            java.lang.System.arraycopy(r5, r6, r8, r6, r7)
            r5 = r8
        L_0x00ee:
            r5[r7] = r3
            int[][] r5 = (int[][]) r5
            r7 = r10
            goto L_0x00f6
        L_0x00f4:
            r9 = r17
        L_0x00f6:
            r3 = 1
            goto L_0x001e
        L_0x00f9:
            int[] r0 = new int[r7]
            int[][] r1 = new int[r7][]
            java.lang.System.arraycopy(r4, r6, r0, r6, r7)
            java.lang.System.arraycopy(r5, r6, r1, r6, r7)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        L_0x0109:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r18.getPositionDescription()
            r1.append(r3)
            java.lang.String r3 = ": invalid color state list tag "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static void a(d.f.a.h.e eVar) {
        if ((eVar.C0 & 32) != 32) {
            eVar.w0.clear();
            eVar.w0.add(0, new f(eVar.k0));
            return;
        }
        eVar.D0 = true;
        eVar.x0 = false;
        eVar.y0 = false;
        eVar.z0 = false;
        ArrayList<d.f.a.h.d> arrayList = eVar.k0;
        List<f> list = eVar.w0;
        boolean z = eVar.d() == d.f.a.h.d.a.WRAP_CONTENT;
        boolean z2 = eVar.g() == d.f.a.h.d.a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (d.f.a.h.d dVar : arrayList) {
            dVar.p = null;
            dVar.d0 = false;
            dVar.k();
        }
        for (d.f.a.h.d dVar2 : arrayList) {
            if (dVar2.p == null) {
                f fVar = new f(new ArrayList(), true);
                list.add(fVar);
                if (!a(dVar2, fVar, list, z3)) {
                    eVar.w0.clear();
                    eVar.w0.add(0, new f(eVar.k0));
                    eVar.D0 = false;
                    return;
                }
            }
        }
        int i2 = 0;
        int i3 = 0;
        for (f fVar2 : list) {
            i2 = Math.max(i2, a(fVar2, 0));
            i3 = Math.max(i3, a(fVar2, 1));
        }
        if (z) {
            eVar.a(d.f.a.h.d.a.FIXED);
            eVar.f(i2);
            eVar.x0 = true;
            eVar.y0 = true;
            eVar.A0 = i2;
        }
        if (z2) {
            eVar.b(d.f.a.h.d.a.FIXED);
            eVar.e(i3);
            eVar.x0 = true;
            eVar.z0 = true;
            eVar.B0 = i3;
        }
        a(list, 0, eVar.h());
        a(list, 1, eVar.c());
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2, int i3) {
        if (!a(xmlPullParser, str)) {
            return i3;
        }
        return typedArray.getColor(i2, i3);
    }

    public static d.h.f.b[] a(d.h.f.b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        d.h.f.b[] bVarArr2 = new d.h.f.b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = new d.h.f.b(bVarArr[i2]);
        }
        return bVarArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0185, code lost:
        if (r3.f4665b == r4) goto L_0x0187;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x012c, code lost:
        if (r3.f4665b == r4) goto L_0x012e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x01c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(d.f.a.h.d r9, d.f.a.h.f r10, java.util.List<d.f.a.h.f> r11, boolean r12) {
        /*
            r0 = 1
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            r9.c0 = r1
            d.f.a.h.d r2 = r9.D
            d.f.a.h.e r2 = (d.f.a.h.e) r2
            d.f.a.h.f r3 = r9.p
            if (r3 != 0) goto L_0x0204
            r9.b0 = r0
            java.util.List<d.f.a.h.d> r3 = r10.f4705a
            r3.add(r9)
            r9.p = r10
            d.f.a.h.c r3 = r9.s
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x0045
            d.f.a.h.c r3 = r9.u
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x0045
            d.f.a.h.c r3 = r9.t
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x0045
            d.f.a.h.c r3 = r9.v
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x0045
            d.f.a.h.c r3 = r9.w
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x0045
            d.f.a.h.c r3 = r9.z
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x0045
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
            if (r12 == 0) goto L_0x0045
            return r1
        L_0x0045:
            d.f.a.h.c r3 = r9.t
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0078
            d.f.a.h.c r3 = r9.v
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0078
            d.f.a.h.d$a r3 = r2.g()
            d.f.a.h.d$a r4 = d.f.a.h.d.a.WRAP_CONTENT
            if (r12 == 0) goto L_0x0060
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
            return r1
        L_0x0060:
            d.f.a.h.c r3 = r9.t
            d.f.a.h.c r3 = r3.f4667d
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x0072
            d.f.a.h.c r3 = r9.v
            d.f.a.h.c r3 = r3.f4667d
            d.f.a.h.d r3 = r3.f4665b
            if (r3 == r4) goto L_0x0078
        L_0x0072:
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
        L_0x0078:
            d.f.a.h.c r3 = r9.s
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x00ab
            d.f.a.h.c r3 = r9.u
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x00ab
            d.f.a.h.d$a r3 = r2.d()
            d.f.a.h.d$a r4 = d.f.a.h.d.a.WRAP_CONTENT
            if (r12 == 0) goto L_0x0093
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
            return r1
        L_0x0093:
            d.f.a.h.c r3 = r9.s
            d.f.a.h.c r3 = r3.f4667d
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x00a5
            d.f.a.h.c r3 = r9.u
            d.f.a.h.c r3 = r3.f4667d
            d.f.a.h.d r3 = r3.f4665b
            if (r3 == r4) goto L_0x00ab
        L_0x00a5:
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
        L_0x00ab:
            d.f.a.h.d$a r3 = r9.d()
            d.f.a.h.d$a r4 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x00b5
            r3 = r0
            goto L_0x00b6
        L_0x00b5:
            r3 = r1
        L_0x00b6:
            d.f.a.h.d$a r4 = r9.g()
            d.f.a.h.d$a r5 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x00c0
            r4 = r0
            goto L_0x00c1
        L_0x00c0:
            r4 = r1
        L_0x00c1:
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x00cf
            float r3 = r9.G
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x00cf
            a(r9)
            goto L_0x00e8
        L_0x00cf:
            d.f.a.h.d$a r3 = r9.d()
            d.f.a.h.d$a r4 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x00df
            d.f.a.h.d$a r3 = r9.g()
            d.f.a.h.d$a r4 = d.f.a.h.d.a.MATCH_CONSTRAINT
            if (r3 != r4) goto L_0x00e8
        L_0x00df:
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
            if (r12 == 0) goto L_0x00e8
            return r1
        L_0x00e8:
            d.f.a.h.c r3 = r9.s
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x00f4
            d.f.a.h.c r3 = r9.u
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x012e
        L_0x00f4:
            d.f.a.h.c r3 = r9.s
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0106
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x0106
            d.f.a.h.c r3 = r9.u
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x012e
        L_0x0106:
            d.f.a.h.c r3 = r9.u
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0118
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x0118
            d.f.a.h.c r3 = r9.s
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x012e
        L_0x0118:
            d.f.a.h.c r3 = r9.s
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0141
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x0141
            d.f.a.h.c r3 = r9.u
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0141
            d.f.a.h.d r3 = r3.f4665b
            if (r3 != r4) goto L_0x0141
        L_0x012e:
            d.f.a.h.c r3 = r9.z
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x0141
            boolean r3 = r9 instanceof d.f.a.h.g
            if (r3 != 0) goto L_0x0141
            boolean r3 = r9 instanceof d.f.a.h.h
            if (r3 != 0) goto L_0x0141
            java.util.List<d.f.a.h.d> r3 = r10.f4710f
            r3.add(r9)
        L_0x0141:
            d.f.a.h.c r3 = r9.t
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x014d
            d.f.a.h.c r3 = r9.v
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0187
        L_0x014d:
            d.f.a.h.c r3 = r9.t
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x015f
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x015f
            d.f.a.h.c r3 = r9.v
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0187
        L_0x015f:
            d.f.a.h.c r3 = r9.v
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0171
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x0171
            d.f.a.h.c r3 = r9.t
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x0187
        L_0x0171:
            d.f.a.h.c r3 = r9.t
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x01a0
            d.f.a.h.d r3 = r3.f4665b
            d.f.a.h.d r4 = r9.D
            if (r3 != r4) goto L_0x01a0
            d.f.a.h.c r3 = r9.v
            d.f.a.h.c r3 = r3.f4667d
            if (r3 == 0) goto L_0x01a0
            d.f.a.h.d r3 = r3.f4665b
            if (r3 != r4) goto L_0x01a0
        L_0x0187:
            d.f.a.h.c r3 = r9.z
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x01a0
            d.f.a.h.c r3 = r9.w
            d.f.a.h.c r3 = r3.f4667d
            if (r3 != 0) goto L_0x01a0
            boolean r3 = r9 instanceof d.f.a.h.g
            if (r3 != 0) goto L_0x01a0
            boolean r3 = r9 instanceof d.f.a.h.h
            if (r3 != 0) goto L_0x01a0
            java.util.List<d.f.a.h.d> r3 = r10.f4711g
            r3.add(r9)
        L_0x01a0:
            boolean r3 = r9 instanceof d.f.a.h.h
            if (r3 == 0) goto L_0x01c3
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
            if (r12 == 0) goto L_0x01ad
            return r1
        L_0x01ad:
            r3 = r9
            d.f.a.h.h r3 = (d.f.a.h.h) r3
            r4 = r1
        L_0x01b1:
            int r5 = r3.l0
            if (r4 >= r5) goto L_0x01c3
            d.f.a.h.d[] r5 = r3.k0
            r5 = r5[r4]
            boolean r5 = a(r5, r10, r11, r12)
            if (r5 != 0) goto L_0x01c0
            return r1
        L_0x01c0:
            int r4 = r4 + 1
            goto L_0x01b1
        L_0x01c3:
            d.f.a.h.c[] r3 = r9.A
            int r3 = r3.length
            r4 = r1
        L_0x01c7:
            if (r4 >= r3) goto L_0x0203
            d.f.a.h.c[] r5 = r9.A
            r5 = r5[r4]
            d.f.a.h.c r6 = r5.f4667d
            if (r6 == 0) goto L_0x0200
            d.f.a.h.d r7 = r6.f4665b
            d.f.a.h.d r8 = r9.D
            if (r7 == r8) goto L_0x0200
            d.f.a.h.c$c r7 = r5.f4666c
            d.f.a.h.c$c r8 = d.f.a.h.c.C0033c.CENTER
            if (r7 != r8) goto L_0x01e6
            r10.f4708d = r1
            r2.D0 = r1
            r9.b0 = r1
            if (r12 == 0) goto L_0x01f5
            return r1
        L_0x01e6:
            d.f.a.h.j r7 = r5.f4664a
            if (r6 == 0) goto L_0x01f5
            d.f.a.h.c r8 = r6.f4667d
            if (r8 == r5) goto L_0x01f5
            d.f.a.h.j r6 = r6.f4664a
            java.util.HashSet<d.f.a.h.l> r6 = r6.f4725a
            r6.add(r7)
        L_0x01f5:
            d.f.a.h.c r5 = r5.f4667d
            d.f.a.h.d r5 = r5.f4665b
            boolean r5 = a(r5, r10, r11, r12)
            if (r5 != 0) goto L_0x0200
            return r1
        L_0x0200:
            int r4 = r4 + 1
            goto L_0x01c7
        L_0x0203:
            return r0
        L_0x0204:
            if (r3 == r10) goto L_0x0243
            java.util.List<d.f.a.h.d> r12 = r10.f4705a
            java.util.List<d.f.a.h.d> r2 = r3.f4705a
            r12.addAll(r2)
            java.util.List<d.f.a.h.d> r12 = r10.f4710f
            d.f.a.h.f r2 = r9.p
            java.util.List<d.f.a.h.d> r2 = r2.f4710f
            r12.addAll(r2)
            java.util.List<d.f.a.h.d> r12 = r10.f4711g
            d.f.a.h.f r2 = r9.p
            java.util.List<d.f.a.h.d> r2 = r2.f4711g
            r12.addAll(r2)
            d.f.a.h.f r12 = r9.p
            boolean r12 = r12.f4708d
            if (r12 != 0) goto L_0x0227
            r10.f4708d = r1
        L_0x0227:
            d.f.a.h.f r12 = r9.p
            r11.remove(r12)
            d.f.a.h.f r9 = r9.p
            java.util.List<d.f.a.h.d> r9 = r9.f4705a
            java.util.Iterator r9 = r9.iterator()
        L_0x0234:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0243
            java.lang.Object r11 = r9.next()
            d.f.a.h.d r11 = (d.f.a.h.d) r11
            r11.p = r10
            goto L_0x0234
        L_0x0243:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(d.f.a.h.d, d.f.a.h.f, java.util.List, boolean):boolean");
    }

    public static Intent a(Activity activity) {
        Intent intent;
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String b2 = b((Context) activity, activity.getComponentName());
            if (b2 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b2);
            try {
                if (b((Context) activity, componentName) == null) {
                    intent = Intent.makeMainActivity(componentName);
                } else {
                    intent = new Intent().setComponent(componentName);
                }
                return intent;
            } catch (NameNotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("getParentActivityIntent: bad parentActivityName '");
                sb.append(b2);
                sb.append("' in manifest");
                Log.e("NavUtils", sb.toString());
                return null;
            }
        } catch (NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int a(Context context, String str) {
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManager.permissionToOp(str);
        if (permissionToOp != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName) != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static void a(Drawable drawable, int i2) {
        drawable.setTint(i2);
    }

    public static d.h.e.b.a a(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme, String str, int i2, int i3) {
        d.h.e.b.a aVar;
        if (a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return new d.h.e.b.a(null, null, typedValue.data);
            }
            try {
                aVar = d.h.e.b.a.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            } catch (Exception e2) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
                aVar = null;
            }
            if (aVar != null) {
                return aVar;
            }
        }
        return new d.h.e.b.a(null, null, i3);
    }

    public static boolean a(d.h.f.b[] bVarArr, d.h.f.b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            if (bVarArr[i2].f4808a != bVarArr2[i2].f4808a || bVarArr[i2].f4809b.length != bVarArr2[i2].f4809b.length) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047 A[SYNTHETIC, Splitter:B:25:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0050 A[SYNTHETIC, Splitter:B:31:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r5, java.io.InputStream r6) {
        /*
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskWrites()
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002a }
            r3.<init>(r5, r1)     // Catch:{ IOException -> 0x002a }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
        L_0x000f:
            int r2 = r6.read(r5)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            r4 = -1
            if (r2 == r4) goto L_0x001a
            r3.write(r5, r1, r2)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            goto L_0x000f
        L_0x001a:
            r5 = 1
            r3.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            android.os.StrictMode.setThreadPolicy(r0)
            return r5
        L_0x0022:
            r5 = move-exception
            r2 = r3
            goto L_0x004e
        L_0x0025:
            r5 = move-exception
            r2 = r3
            goto L_0x002b
        L_0x0028:
            r5 = move-exception
            goto L_0x004e
        L_0x002a:
            r5 = move-exception
        L_0x002b:
            java.lang.String r6 = "TypefaceCompatUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r3.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "Error copying resource contents to temp file: "
            r3.append(r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x0028 }
            r3.append(r5)     // Catch:{ all -> 0x0028 }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x0028 }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x004a
            r2.close()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x004e:
            if (r2 == 0) goto L_0x0053
            r2.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(java.io.File, java.io.InputStream):boolean");
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r0, android.content.res.Resources r1, int r2) {
        /*
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch:{ all -> 0x0010 }
            boolean r0 = a(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()     // Catch:{ IOException -> 0x000d }
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x0017 }
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(java.io.File, android.content.res.Resources, int):boolean");
    }

    public static d.h.e.b.b a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        Resources resources2 = resources;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String str = "font-family";
            xmlPullParser.require(2, null, str);
            if (xmlPullParser.getName().equals(str)) {
                TypedArray obtainAttributes = resources2.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d.h.c.FontFamily);
                String string = obtainAttributes.getString(d.h.c.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(d.h.c.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(d.h.c.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(d.h.c.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(d.h.c.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(d.h.c.FontFamily_fontProviderFetchTimeout, 500);
                obtainAttributes.recycle();
                if (string == null || string2 == null || string3 == null) {
                    ArrayList arrayList = new ArrayList();
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources2.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d.h.c.FontFamilyFont);
                                int i2 = obtainAttributes2.getInt(obtainAttributes2.hasValue(d.h.c.FontFamilyFont_fontWeight) ? d.h.c.FontFamilyFont_fontWeight : d.h.c.FontFamilyFont_android_fontWeight, 400);
                                boolean z = 1 == obtainAttributes2.getInt(obtainAttributes2.hasValue(d.h.c.FontFamilyFont_fontStyle) ? d.h.c.FontFamilyFont_fontStyle : d.h.c.FontFamilyFont_android_fontStyle, 0);
                                int i3 = obtainAttributes2.hasValue(d.h.c.FontFamilyFont_ttcIndex) ? d.h.c.FontFamilyFont_ttcIndex : d.h.c.FontFamilyFont_android_ttcIndex;
                                String string4 = obtainAttributes2.getString(obtainAttributes2.hasValue(d.h.c.FontFamilyFont_fontVariationSettings) ? d.h.c.FontFamilyFont_fontVariationSettings : d.h.c.FontFamilyFont_android_fontVariationSettings);
                                int i4 = obtainAttributes2.getInt(i3, 0);
                                int i5 = obtainAttributes2.hasValue(d.h.c.FontFamilyFont_font) ? d.h.c.FontFamilyFont_font : d.h.c.FontFamilyFont_android_font;
                                int resourceId2 = obtainAttributes2.getResourceId(i5, 0);
                                String string5 = obtainAttributes2.getString(i5);
                                obtainAttributes2.recycle();
                                while (xmlPullParser.next() != 3) {
                                    a(xmlPullParser);
                                }
                                d.h.e.b.d dVar = new d.h.e.b.d(string5, i2, z, string4, i4, resourceId2);
                                arrayList.add(dVar);
                            } else {
                                a(xmlPullParser);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return new d.h.e.b.c((d.h.e.b.d[]) arrayList.toArray(new d.h.e.b.d[arrayList.size()]));
                }
                while (xmlPullParser.next() != 3) {
                    a(xmlPullParser);
                }
                return new d.h.e.b.e(new d.h.h.a(string, string2, string3, a(resources2, resourceId)), integer, integer2);
            }
            a(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static Intent a(Context context, ComponentName componentName) throws NameNotFoundException {
        Intent intent;
        String b2 = b(context, componentName);
        if (b2 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b2);
        if (b(context, componentName2) == null) {
            intent = Intent.makeMainActivity(componentName2);
        } else {
            intent = new Intent().setComponent(componentName2);
        }
        return intent;
    }

    public static PropertyValuesHolder a(TypedArray typedArray, int i2, int i3, int i4, String str) {
        PropertyValuesHolder propertyValuesHolder;
        int i5;
        int i6;
        int i7;
        float f2;
        float f3;
        float f4;
        PropertyValuesHolder propertyValuesHolder2;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z = peekValue != null;
        int i8 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i4);
        boolean z2 = peekValue2 != null;
        int i9 = z2 ? peekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((!z || !c(i8)) && (!z2 || !c(i9))) ? 0 : 3;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolder3 = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            d.h.f.b[] a2 = a(string);
            d.h.f.b[] a3 = a(string2);
            if (a2 == null && a3 == null) {
                return null;
            }
            if (a2 != null) {
                d.u.a.a.d dVar = new d.u.a.a.d();
                if (a3 == null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, dVar, new Object[]{a2});
                } else if (a(a2, a3)) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofObject(str, dVar, new Object[]{a2, a3});
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" Can't morph from ");
                    sb.append(string);
                    sb.append(" to ");
                    sb.append(string2);
                    throw new InflateException(sb.toString());
                }
                return propertyValuesHolder2;
            } else if (a3 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new d.u.a.a.d(), new Object[]{a3});
            }
        } else {
            TypeEvaluator typeEvaluator = i2 == 3 ? d.u.a.a.e.f5549a : null;
            if (z3) {
                if (z) {
                    if (i8 == 5) {
                        f3 = typedArray.getDimension(i3, 0.0f);
                    } else {
                        f3 = typedArray.getFloat(i3, 0.0f);
                    }
                    if (z2) {
                        if (i9 == 5) {
                            f4 = typedArray.getDimension(i4, 0.0f);
                        } else {
                            f4 = typedArray.getFloat(i4, 0.0f);
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{f3, f4});
                    } else {
                        propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{f3});
                    }
                } else {
                    if (i9 == 5) {
                        f2 = typedArray.getDimension(i4, 0.0f);
                    } else {
                        f2 = typedArray.getFloat(i4, 0.0f);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(str, new float[]{f2});
                }
            } else if (z) {
                if (i8 == 5) {
                    i6 = (int) typedArray.getDimension(i3, 0.0f);
                } else if (c(i8)) {
                    i6 = typedArray.getColor(i3, 0);
                } else {
                    i6 = typedArray.getInt(i3, 0);
                }
                if (z2) {
                    if (i9 == 5) {
                        i7 = (int) typedArray.getDimension(i4, 0.0f);
                    } else if (c(i9)) {
                        i7 = typedArray.getColor(i4, 0);
                    } else {
                        i7 = typedArray.getInt(i4, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i6, i7});
                } else {
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i6});
                }
            } else {
                if (z2) {
                    if (i9 == 5) {
                        i5 = (int) typedArray.getDimension(i4, 0.0f);
                    } else if (c(i9)) {
                        i5 = typedArray.getColor(i4, 0);
                    } else {
                        i5 = typedArray.getInt(i4, 0);
                    }
                    propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i5});
                }
                if (propertyValuesHolder3 == null && typeEvaluator != null) {
                    propertyValuesHolder3.setEvaluator(typeEvaluator);
                    return propertyValuesHolder3;
                }
            }
            propertyValuesHolder3 = propertyValuesHolder;
            return propertyValuesHolder3 == null ? propertyValuesHolder3 : propertyValuesHolder3;
        }
    }

    public static String a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (r10.right <= r12.left) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r10.top >= r12.bottom) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r10.left >= r12.right) goto L_0x0028;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r10.bottom <= r12.top) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = a(r9, r10, r11)
            boolean r1 = a(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L_0x007e
            if (r0 != 0) goto L_0x000f
            goto L_0x007e
        L_0x000f:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L_0x0040
            if (r9 == r3) goto L_0x0039
            if (r9 == r4) goto L_0x0032
            if (r9 != r1) goto L_0x002c
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L_0x002a
        L_0x0028:
            r7 = r6
            goto L_0x0047
        L_0x002a:
            r7 = r2
            goto L_0x0047
        L_0x002c:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L_0x0032:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L_0x002a
            goto L_0x0028
        L_0x0039:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L_0x002a
            goto L_0x0028
        L_0x0040:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L_0x002a
            goto L_0x0028
        L_0x0047:
            if (r7 != 0) goto L_0x004a
            return r6
        L_0x004a:
            if (r9 == r5) goto L_0x007d
            if (r9 != r4) goto L_0x004f
            goto L_0x007d
        L_0x004f:
            int r11 = b(r9, r10, r11)
            if (r9 == r5) goto L_0x0070
            if (r9 == r3) goto L_0x006b
            if (r9 == r4) goto L_0x0066
            if (r9 != r1) goto L_0x0060
            int r9 = r12.bottom
            int r10 = r10.bottom
            goto L_0x0074
        L_0x0060:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L_0x0066:
            int r9 = r12.right
            int r10 = r10.right
            goto L_0x0074
        L_0x006b:
            int r9 = r10.top
            int r10 = r12.top
            goto L_0x0074
        L_0x0070:
            int r9 = r10.left
            int r10 = r12.left
        L_0x0074:
            int r9 = r9 - r10
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L_0x007c
            r2 = r6
        L_0x007c:
            return r2
        L_0x007d:
            return r6
        L_0x007e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static List<List<byte[]>> a(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (obtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    public static int a(d.f.a.h.d dVar, int i2, boolean z, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int h2;
        int i9;
        int i10;
        int i11;
        d.f.a.h.d dVar2 = dVar;
        int i12 = i2;
        boolean z2 = z;
        int i13 = 0;
        if (!dVar2.b0) {
            return 0;
        }
        boolean z3 = dVar2.w.f4667d != null && i12 == 1;
        if (z2) {
            i7 = dVar2.Q;
            i6 = dVar.c() - dVar2.Q;
            i5 = i12 * 2;
            i4 = i5 + 1;
        } else {
            int c2 = dVar.c();
            i6 = dVar2.Q;
            i7 = c2 - i6;
            i4 = i12 * 2;
            i5 = i4 + 1;
        }
        d.f.a.h.c[] cVarArr = dVar2.A;
        if (cVarArr[i4].f4667d == null || cVarArr[i5].f4667d != null) {
            i8 = 1;
        } else {
            i8 = -1;
            int i14 = i4;
            i4 = i5;
            i5 = i14;
        }
        int a2 = a(dVar, i2) + (dVar2.A[i5].a() * i8);
        int i15 = (z3 ? i3 - i7 : i3) + a2;
        int h3 = (i12 == 0 ? dVar.h() : dVar.c()) * i8;
        Iterator it = dVar2.A[i5].f4664a.f4725a.iterator();
        while (it.hasNext()) {
            i13 = Math.max(i13, a(((j) ((l) it.next())).f4716c.f4665b, i12, z2, i15));
        }
        Iterator it2 = dVar2.A[i4].f4664a.f4725a.iterator();
        int i16 = 0;
        while (it2.hasNext()) {
            Iterator it3 = it2;
            i16 = Math.max(i16, a(((j) ((l) it2.next())).f4716c.f4665b, i12, z2, h3 + i15));
            it2 = it3;
        }
        if (z3) {
            i13 -= i7;
            h2 = i16 + i6;
        } else {
            h2 = i16 + ((i12 == 0 ? dVar.h() : dVar.c()) * i8);
        }
        if (i12 == 1) {
            Iterator it4 = dVar2.w.f4664a.f4725a.iterator();
            int i17 = 0;
            while (it4.hasNext()) {
                Iterator it5 = it4;
                j jVar = (j) ((l) it4.next());
                int i18 = i4;
                if (i8 == 1) {
                    i11 = Math.max(i17, a(jVar.f4716c.f4665b, i12, z2, i7 + i15));
                } else {
                    i11 = Math.max(i17, a(jVar.f4716c.f4665b, i12, z2, (i6 * i8) + i15));
                }
                i17 = i11;
                it4 = it5;
                i4 = i18;
            }
            i9 = i4;
            i10 = (dVar2.w.f4664a.f4725a.size() <= 0 || z3) ? i17 : i8 == 1 ? i17 + i7 : i17 - i6;
        } else {
            i9 = i4;
            i10 = 0;
        }
        int max = Math.max(i13, Math.max(h2, i10)) + a2;
        int i19 = h3 + i15;
        if (i8 == -1) {
            int i20 = i19;
            i19 = i15;
            i15 = i20;
        }
        if (z2) {
            i.a(dVar2, i12, i15);
            dVar2.a(i15, i19, i12);
        } else {
            dVar2.p.a(dVar2, i12);
            if (i12 == 0) {
                dVar2.K = i15;
            } else if (i12 == 1) {
                dVar2.L = i15;
            }
        }
        if (dVar.b(i2) == d.f.a.h.d.a.MATCH_CONSTRAINT && dVar2.G != 0.0f) {
            dVar2.p.a(dVar2, i12);
        }
        d.f.a.h.c[] cVarArr2 = dVar2.A;
        if (!(cVarArr2[i5].f4667d == null || cVarArr2[i9].f4667d == null)) {
            d.f.a.h.d dVar3 = dVar2.D;
            if (cVarArr2[i5].f4667d.f4665b == dVar3 && cVarArr2[i9].f4667d.f4665b == dVar3) {
                dVar2.p.a(dVar2, i12);
            }
        }
        return max;
    }

    public static boolean a(Rect rect, Rect rect2, int i2) {
        boolean z = true;
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            if ((i3 <= i4 && rect.left < i4) || rect.left <= rect2.left) {
                z = false;
            }
            return z;
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if ((i5 <= i6 && rect.top < i6) || rect.top <= rect2.top) {
                z = false;
            }
            return z;
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            if ((i7 >= i8 && rect.right > i8) || rect.right >= rect2.right) {
                z = false;
            }
            return z;
        } else if (i2 == 130) {
            int i9 = rect.top;
            int i10 = rect2.top;
            if ((i9 >= i10 && rect.bottom > i10) || rect.bottom >= rect2.bottom) {
                z = false;
            }
            return z;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static boolean a(int i2, Rect rect, Rect rect2) {
        boolean z = true;
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                z = false;
            }
            return z;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            z = false;
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, d.h.e.b.g r20, android.os.Handler r21, boolean r22) {
        /*
            r9 = r17
            r0 = r18
            r5 = r19
            r10 = r20
            r11 = r21
            android.content.res.Resources r3 = r16.getResources()
            r1 = 1
            r3.getValue(r9, r0, r1)
            java.lang.String r12 = "ResourcesCompat"
            java.lang.CharSequence r1 = r0.string
            if (r1 == 0) goto L_0x00d9
            java.lang.String r13 = r1.toString()
            java.lang.String r0 = "res/"
            boolean r0 = r13.startsWith(r0)
            r14 = 0
            r15 = -3
            if (r0 != 0) goto L_0x002d
            if (r10 == 0) goto L_0x00b7
            r10.a(r15, r11)
            goto L_0x00b7
        L_0x002d:
            d.e.f<java.lang.String, android.graphics.Typeface> r0 = d.h.f.c.f4811b
            java.lang.String r1 = d.h.f.c.a(r3, r9, r5)
            java.lang.Object r0 = r0.a(r1)
            android.graphics.Typeface r0 = (android.graphics.Typeface) r0
            if (r0 == 0) goto L_0x0043
            if (r10 == 0) goto L_0x0040
            r10.a(r0, r11)
        L_0x0040:
            r14 = r0
            goto L_0x00b7
        L_0x0043:
            java.lang.String r0 = r13.toLowerCase()     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            java.lang.String r1 = ".xml"
            boolean r0 = r0.endsWith(r1)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            if (r0 == 0) goto L_0x0075
            android.content.res.XmlResourceParser r0 = r3.getXml(r9)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            d.h.e.b.b r2 = a(r0, r3)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            if (r2 != 0) goto L_0x0064
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r12, r0)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            if (r10 == 0) goto L_0x00b7
            r10.a(r15, r11)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            goto L_0x00b7
        L_0x0064:
            r1 = r16
            r4 = r17
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r14 = d.h.f.c.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            goto L_0x00b7
        L_0x0075:
            r0 = r16
            android.graphics.Typeface r0 = d.h.f.c.a(r0, r3, r9, r13, r5)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            if (r10 == 0) goto L_0x0040
            if (r0 == 0) goto L_0x0083
            r10.a(r0, r11)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            goto L_0x0040
        L_0x0083:
            r10.a(r15, r11)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0087 }
            goto L_0x0040
        L_0x0087:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r12, r1, r0)
            goto L_0x00b2
        L_0x009d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r12, r1, r0)
        L_0x00b2:
            if (r10 == 0) goto L_0x00b7
            r10.a(r15, r11)
        L_0x00b7:
            if (r14 != 0) goto L_0x00d8
            if (r10 == 0) goto L_0x00bc
            goto L_0x00d8
        L_0x00bc:
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException
            java.lang.String r1 = "Font resource ID #0x"
            java.lang.StringBuilder r1 = e.a.a.a.a.a(r1)
            java.lang.String r2 = java.lang.Integer.toHexString(r17)
            r1.append(r2)
            java.lang.String r2 = " could not be retrieved."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00d8:
            return r14
        L_0x00d9:
            android.content.res.Resources$NotFoundException r1 = new android.content.res.Resources$NotFoundException
            java.lang.String r2 = "Resource \""
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            java.lang.String r3 = r3.getResourceName(r9)
            r2.append(r3)
            java.lang.String r3 = "\" ("
            r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r17)
            r2.append(r3)
            java.lang.String r3 = ") is not a Font: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(android.content.Context, int, android.util.TypedValue, int, d.h.e.b.g, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static void a(List<f> list, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            f fVar = (f) list.get(i4);
            HashSet<d.f.a.h.d> hashSet = null;
            if (fVar != null) {
                if (i2 == 0) {
                    hashSet = fVar.f4712h;
                } else if (i2 == 1) {
                    hashSet = fVar.f4713i;
                }
                for (d.f.a.h.d dVar : hashSet) {
                    if (dVar.b0) {
                        int i5 = i2 * 2;
                        d.f.a.h.c[] cVarArr = dVar.A;
                        d.f.a.h.c cVar = cVarArr[i5];
                        d.f.a.h.c cVar2 = cVarArr[i5 + 1];
                        if ((cVar.f4667d == null || cVar2.f4667d == null) ? false : true) {
                            i.a(dVar, i2, cVar.a() + a(dVar, i2));
                        } else if (dVar.G == 0.0f || dVar.b(i2) != d.f.a.h.d.a.MATCH_CONSTRAINT) {
                            int i6 = i2 == 0 ? dVar.K : i2 == 1 ? dVar.L : 0;
                            int i7 = i3 - i6;
                            int c2 = i7 - dVar.c(i2);
                            dVar.a(c2, i7, i2);
                            i.a(dVar, i2, c2);
                        } else {
                            int a2 = a(dVar);
                            int i8 = (int) dVar.A[i5].f4664a.f4720g;
                            int i9 = i8 + a2;
                            j jVar = cVar2.f4664a;
                            jVar.f4719f = cVar.f4664a;
                            jVar.f4720g = (float) a2;
                            jVar.f4726b = 1;
                            dVar.a(i8, i9, i2);
                        }
                    }
                }
                i4++;
            } else {
                throw null;
            }
        }
    }

    public static int a(d.f.a.h.d dVar, int i2) {
        int i3 = i2 * 2;
        d.f.a.h.c[] cVarArr = dVar.A;
        d.f.a.h.c cVar = cVarArr[i3];
        d.f.a.h.c cVar2 = cVarArr[i3 + 1];
        d.f.a.h.c cVar3 = cVar.f4667d;
        if (cVar3 != null) {
            d.f.a.h.d dVar2 = cVar3.f4665b;
            d.f.a.h.d dVar3 = dVar.D;
            if (dVar2 == dVar3) {
                d.f.a.h.c cVar4 = cVar2.f4667d;
                if (cVar4 != null && cVar4.f4665b == dVar3) {
                    return (int) (((float) (((dVar3.c(i2) - cVar.a()) - cVar2.a()) - dVar.c(i2))) * (i2 == 0 ? dVar.V : dVar.W));
                }
            }
        }
        return 0;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r15v16, types: [android.animation.AnimatorSet] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b6  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x030d  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.animation.Animator a(android.content.Context r22, android.content.res.Resources r23, android.content.res.Resources.Theme r24, org.xmlpull.v1.XmlPullParser r25, android.util.AttributeSet r26, android.animation.AnimatorSet r27, int r28, float r29) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r8 = r23
            r9 = r24
            r10 = r25
            r11 = r27
            int r12 = r25.getDepth()
            r0 = 0
            r1 = 0
            r13 = r1
        L_0x000f:
            int r1 = r25.next()
            r2 = 3
            r14 = 0
            if (r1 != r2) goto L_0x001d
            int r3 = r25.getDepth()
            if (r3 <= r12) goto L_0x0334
        L_0x001d:
            r3 = 1
            if (r1 == r3) goto L_0x0334
            r4 = 2
            if (r1 == r4) goto L_0x0024
            goto L_0x000f
        L_0x0024:
            java.lang.String r1 = r25.getName()
            java.lang.String r5 = "objectAnimator"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0046
            android.animation.ObjectAnimator r7 = new android.animation.ObjectAnimator
            r7.<init>()
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r26
            r4 = r7
            r5 = r29
            r6 = r25
            a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x005f
        L_0x0046:
            java.lang.String r5 = "animator"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0064
            r4 = 0
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r26
            r5 = r29
            r6 = r25
            android.animation.ValueAnimator r7 = a(r0, r1, r2, r3, r4, r5, r6)
        L_0x005f:
            r0 = r7
            r19 = r12
            goto L_0x0307
        L_0x0064:
            java.lang.String r5 = "set"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x009b
            android.animation.AnimatorSet r15 = new android.animation.AnimatorSet
            r15.<init>()
            int[] r0 = d.u.a.a.a.f5534h
            r7 = r26
            android.content.res.TypedArray r6 = a(r8, r9, r7, r0)
            java.lang.String r0 = "ordering"
            int r16 = b(r6, r10, r0, r14, r14)
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r15
            r17 = r6
            r6 = r16
            r7 = r29
            a(r0, r1, r2, r3, r4, r5, r6, r7)
            r17.recycle()
            r19 = r12
            r0 = r15
            goto L_0x0307
        L_0x009b:
            java.lang.String r5 = "propertyValuesHolder"
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x031d
            android.util.AttributeSet r1 = android.util.Xml.asAttributeSet(r25)
            r6 = 0
            r21 = r14
            r14 = r3
            r3 = r21
        L_0x00ad:
            int r7 = r25.getEventType()
            if (r7 == r2) goto L_0x02e3
            if (r7 == r14) goto L_0x02e3
            if (r7 == r4) goto L_0x00bb
            r25.next()
            goto L_0x00ad
        L_0x00bb:
            java.lang.String r7 = r25.getName()
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x02ce
            int[] r3 = d.u.a.a.a.f5535i
            android.content.res.TypedArray r3 = a(r8, r9, r1, r3)
            java.lang.String r7 = "propertyName"
            java.lang.String r7 = a(r3, r10, r7, r2)
            r14 = 4
            java.lang.String r15 = "valueType"
            int r4 = b(r3, r10, r15, r4, r14)
            r14 = 0
            r16 = r1
            r15 = r4
        L_0x00dc:
            int r1 = r25.next()
            if (r1 == r2) goto L_0x01d0
            r17 = r2
            r2 = 1
            if (r1 == r2) goto L_0x01d0
            java.lang.String r1 = r25.getName()
            java.lang.String r2 = "keyframe"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x01c6
            java.lang.String r1 = "value"
            r2 = 4
            if (r15 != r2) goto L_0x0127
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r25)
            int[] r15 = d.u.a.a.a.f5536j
            android.content.res.TypedArray r2 = a(r8, r9, r2, r15)
            boolean r15 = a(r10, r1)
            if (r15 != 0) goto L_0x010a
            r15 = 0
            goto L_0x010f
        L_0x010a:
            r15 = 0
            android.util.TypedValue r15 = r2.peekValue(r15)
        L_0x010f:
            if (r15 == 0) goto L_0x0114
            r18 = 1
            goto L_0x0116
        L_0x0114:
            r18 = 0
        L_0x0116:
            if (r18 == 0) goto L_0x0123
            int r15 = r15.type
            boolean r15 = c(r15)
            if (r15 == 0) goto L_0x0123
            r15 = r17
            goto L_0x0124
        L_0x0123:
            r15 = 0
        L_0x0124:
            r2.recycle()
        L_0x0127:
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r25)
            r18 = r5
            int[] r5 = d.u.a.a.a.f5536j
            android.content.res.TypedArray r2 = a(r8, r9, r2, r5)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.lang.String r8 = "fraction"
            r9 = 3
            float r5 = a(r2, r10, r8, r9, r5)
            boolean r8 = a(r10, r1)
            if (r8 != 0) goto L_0x0144
            r8 = 0
            goto L_0x0149
        L_0x0144:
            r8 = 0
            android.util.TypedValue r8 = r2.peekValue(r8)
        L_0x0149:
            if (r8 == 0) goto L_0x014d
            r9 = 1
            goto L_0x014e
        L_0x014d:
            r9 = 0
        L_0x014e:
            r19 = r12
            r12 = 4
            if (r15 != r12) goto L_0x0161
            if (r9 == 0) goto L_0x015f
            int r8 = r8.type
            boolean r8 = c(r8)
            if (r8 == 0) goto L_0x015f
            r8 = 3
            goto L_0x0162
        L_0x015f:
            r8 = 0
            goto L_0x0162
        L_0x0161:
            r8 = r15
        L_0x0162:
            if (r9 == 0) goto L_0x0183
            if (r8 == 0) goto L_0x0178
            r9 = 1
            if (r8 == r9) goto L_0x016e
            r9 = 3
            if (r8 == r9) goto L_0x016e
            r1 = 0
            goto L_0x018e
        L_0x016e:
            r8 = 0
            int r1 = b(r2, r10, r1, r8, r8)
            android.animation.Keyframe r1 = android.animation.Keyframe.ofInt(r5, r1)
            goto L_0x018e
        L_0x0178:
            r8 = 0
            r9 = 0
            float r1 = a(r2, r10, r1, r8, r9)
            android.animation.Keyframe r1 = android.animation.Keyframe.ofFloat(r5, r1)
            goto L_0x018e
        L_0x0183:
            if (r8 != 0) goto L_0x018a
            android.animation.Keyframe r1 = android.animation.Keyframe.ofFloat(r5)
            goto L_0x018e
        L_0x018a:
            android.animation.Keyframe r1 = android.animation.Keyframe.ofInt(r5)
        L_0x018e:
            java.lang.String r5 = "interpolator"
            boolean r5 = a(r10, r5)
            if (r5 != 0) goto L_0x0198
            r5 = 0
            goto L_0x019e
        L_0x0198:
            r5 = 0
            r8 = 1
            int r5 = r2.getResourceId(r8, r5)
        L_0x019e:
            r8 = r22
            if (r5 <= 0) goto L_0x01a9
            android.view.animation.Interpolator r5 = android.view.animation.AnimationUtils.loadInterpolator(r8, r5)
            r1.setInterpolator(r5)
        L_0x01a9:
            r2.recycle()
            if (r1 == 0) goto L_0x01b8
            if (r14 != 0) goto L_0x01b5
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x01b5:
            r14.add(r1)
        L_0x01b8:
            r25.next()
            r2 = 3
            r8 = r23
            r9 = r24
            r5 = r18
            r12 = r19
            goto L_0x00dc
        L_0x01c6:
            r8 = r22
            r8 = r23
            r9 = r24
            r2 = r17
            goto L_0x00dc
        L_0x01d0:
            r8 = r22
            r18 = r5
            r19 = r12
            if (r14 == 0) goto L_0x02af
            int r1 = r14.size()
            if (r1 <= 0) goto L_0x02af
            r2 = 0
            java.lang.Object r2 = r14.get(r2)
            android.animation.Keyframe r2 = (android.animation.Keyframe) r2
            int r5 = r1 + -1
            java.lang.Object r5 = r14.get(r5)
            android.animation.Keyframe r5 = (android.animation.Keyframe) r5
            float r9 = r5.getFraction()
            r12 = 1065353216(0x3f800000, float:1.0)
            int r17 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r17 >= 0) goto L_0x020e
            r17 = 0
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r9 >= 0) goto L_0x0201
            r5.setFraction(r12)
            goto L_0x020e
        L_0x0201:
            int r9 = r14.size()
            android.animation.Keyframe r5 = a(r5, r12)
            r14.add(r9, r5)
            int r1 = r1 + 1
        L_0x020e:
            float r5 = r2.getFraction()
            r9 = 0
            int r12 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r12 == 0) goto L_0x0229
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 >= 0) goto L_0x021f
            r2.setFraction(r9)
            goto L_0x0229
        L_0x021f:
            android.animation.Keyframe r2 = a(r2, r9)
            r5 = 0
            r14.add(r5, r2)
            int r1 = r1 + 1
        L_0x0229:
            android.animation.Keyframe[] r2 = new android.animation.Keyframe[r1]
            r14.toArray(r2)
            r5 = 0
        L_0x022f:
            if (r5 >= r1) goto L_0x02a1
            r9 = r2[r5]
            float r12 = r9.getFraction()
            r14 = 0
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L_0x024b
            if (r5 != 0) goto L_0x0242
            r9.setFraction(r14)
            goto L_0x024b
        L_0x0242:
            int r12 = r1 + -1
            if (r5 != r12) goto L_0x024e
            r12 = 1065353216(0x3f800000, float:1.0)
            r9.setFraction(r12)
        L_0x024b:
            r17 = r1
            goto L_0x029a
        L_0x024e:
            int r9 = r5 + 1
            r14 = r5
        L_0x0251:
            if (r9 >= r12) goto L_0x0268
            r17 = r2[r9]
            float r17 = r17.getFraction()
            r20 = 0
            int r17 = (r17 > r20 ? 1 : (r17 == r20 ? 0 : -1))
            if (r17 < 0) goto L_0x0260
            goto L_0x0268
        L_0x0260:
            int r14 = r9 + 1
            r21 = r14
            r14 = r9
            r9 = r21
            goto L_0x0251
        L_0x0268:
            int r9 = r14 + 1
            r9 = r2[r9]
            float r9 = r9.getFraction()
            int r12 = r5 + -1
            r12 = r2[r12]
            float r12 = r12.getFraction()
            float r9 = r9 - r12
            int r12 = r14 - r5
            int r12 = r12 + 2
            float r12 = (float) r12
            float r9 = r9 / r12
            r12 = r5
        L_0x0280:
            if (r12 > r14) goto L_0x024b
            r17 = r1
            r1 = r2[r12]
            int r20 = r12 + -1
            r20 = r2[r20]
            float r20 = r20.getFraction()
            float r8 = r20 + r9
            r1.setFraction(r8)
            int r12 = r12 + 1
            r8 = r22
            r1 = r17
            goto L_0x0280
        L_0x029a:
            int r5 = r5 + 1
            r8 = r22
            r1 = r17
            goto L_0x022f
        L_0x02a1:
            r1 = 2
            android.animation.PropertyValuesHolder r2 = android.animation.PropertyValuesHolder.ofKeyframe(r7, r2)
            r5 = 3
            if (r15 != r5) goto L_0x02b2
            d.u.a.a.e r8 = d.u.a.a.e.f5549a
            r2.setEvaluator(r8)
            goto L_0x02b2
        L_0x02af:
            r5 = 3
            r1 = 2
            r2 = 0
        L_0x02b2:
            r8 = 0
            r14 = 1
            if (r2 != 0) goto L_0x02ba
            android.animation.PropertyValuesHolder r2 = a(r3, r4, r8, r14, r7)
        L_0x02ba:
            if (r2 == 0) goto L_0x02c7
            if (r6 != 0) goto L_0x02c4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r6 = r4
        L_0x02c4:
            r6.add(r2)
        L_0x02c7:
            r3.recycle()
            r4 = r1
            r2 = r5
            r3 = r8
            goto L_0x02d4
        L_0x02ce:
            r16 = r1
            r18 = r5
            r19 = r12
        L_0x02d4:
            r25.next()
            r8 = r23
            r9 = r24
            r1 = r16
            r5 = r18
            r12 = r19
            goto L_0x00ad
        L_0x02e3:
            r19 = r12
            if (r6 == 0) goto L_0x02fa
            int r1 = r6.size()
            android.animation.PropertyValuesHolder[] r2 = new android.animation.PropertyValuesHolder[r1]
        L_0x02ed:
            if (r3 >= r1) goto L_0x02fb
            java.lang.Object r4 = r6.get(r3)
            android.animation.PropertyValuesHolder r4 = (android.animation.PropertyValuesHolder) r4
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x02ed
        L_0x02fa:
            r2 = 0
        L_0x02fb:
            if (r2 == 0) goto L_0x0307
            boolean r1 = r0 instanceof android.animation.ValueAnimator
            if (r1 == 0) goto L_0x0307
            r1 = r0
            android.animation.ValueAnimator r1 = (android.animation.ValueAnimator) r1
            r1.setValues(r2)
        L_0x0307:
            if (r11 == 0) goto L_0x0315
            if (r14 != 0) goto L_0x0315
            if (r13 != 0) goto L_0x0312
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L_0x0312:
            r13.add(r0)
        L_0x0315:
            r8 = r23
            r9 = r24
            r12 = r19
            goto L_0x000f
        L_0x031d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Unknown animator name: "
            java.lang.StringBuilder r1 = e.a.a.a.a.a(r1)
            java.lang.String r2 = r25.getName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0334:
            if (r11 == 0) goto L_0x035d
            if (r13 == 0) goto L_0x035d
            int r1 = r13.size()
            android.animation.Animator[] r1 = new android.animation.Animator[r1]
            java.util.Iterator r2 = r13.iterator()
        L_0x0342:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0354
            java.lang.Object r3 = r2.next()
            android.animation.Animator r3 = (android.animation.Animator) r3
            int r4 = r14 + 1
            r1[r14] = r3
            r14 = r4
            goto L_0x0342
        L_0x0354:
            if (r28 != 0) goto L_0x035a
            r11.playTogether(r1)
            goto L_0x035d
        L_0x035a:
            r11.playSequentially(r1)
        L_0x035d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.b.a.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Callback a(TextView textView, Callback callback) {
        int i2 = VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof d.h.l.e)) ? callback : new d.h.l.e(callback, textView);
    }

    public static int a(d.f.a.h.d dVar) {
        float f2;
        float f3;
        if (dVar.d() == d.f.a.h.d.a.MATCH_CONSTRAINT) {
            if (dVar.H == 0) {
                f3 = ((float) dVar.c()) * dVar.G;
            } else {
                f3 = ((float) dVar.c()) / dVar.G;
            }
            int i2 = (int) f3;
            dVar.f(i2);
            return i2;
        } else if (dVar.g() != d.f.a.h.d.a.MATCH_CONSTRAINT) {
            return -1;
        } else {
            if (dVar.H == 1) {
                f2 = ((float) dVar.h()) * dVar.G;
            } else {
                f2 = ((float) dVar.h()) / dVar.G;
            }
            int i3 = (int) f2;
            dVar.e(i3);
            return i3;
        }
    }

    public static void a(TextView textView, int i2) {
        int i3;
        b(i2);
        if (VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 - (-i3), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static Keyframe a(Keyframe keyframe, float f2) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f2);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f2);
        }
        return Keyframe.ofObject(f2);
    }

    public static d.h.i.b.a a(TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        if (VERSION.SDK_INT >= 28) {
            return new d.h.i.b.a(textView.getTextMetricsParams());
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = textView.getBreakStrategy();
        int hyphenationFrequency = textView.getHyphenationFrequency();
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            boolean z = false;
            if (VERSION.SDK_INT < 28 || (textView.getInputType() & 15) != 3) {
                if (textView.getLayoutDirection() == 1) {
                    z = true;
                }
                switch (textView.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (!z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        } else {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                }
            } else {
                byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                if (directionality == 1 || directionality == 2) {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                }
            }
        }
        return new d.h.i.b.a(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static ValueAnimator a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f2, XmlPullParser xmlPullParser) throws NotFoundException {
        TypedArray typedArray;
        ValueAnimator valueAnimator2;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        Resources resources2 = resources;
        Theme theme2 = theme;
        AttributeSet attributeSet2 = attributeSet;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        TypedArray a2 = a(resources2, theme2, attributeSet2, d.u.a.a.a.f5533g);
        TypedArray a3 = a(resources2, theme2, attributeSet2, d.u.a.a.a.k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        long b2 = (long) b(a2, xmlPullParser2, LogBuilder.KEY_DURATION, 1, 300);
        int i2 = 0;
        long b3 = (long) b(a2, xmlPullParser2, "startOffset", 2, 0);
        int b4 = b(a2, xmlPullParser2, "valueType", 7, 4);
        if (a(xmlPullParser2, "valueFrom") && a(xmlPullParser2, "valueTo")) {
            if (b4 == 4) {
                TypedValue peekValue = a2.peekValue(5);
                boolean z = peekValue != null;
                int i3 = z ? peekValue.type : 0;
                TypedValue peekValue2 = a2.peekValue(6);
                boolean z2 = peekValue2 != null;
                b4 = ((!z || !c(i3)) && (!z2 || !c(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder a4 = a(a2, b4, 5, 6, "");
            if (a4 != null) {
                valueAnimator4.setValues(new PropertyValuesHolder[]{a4});
            }
        }
        valueAnimator4.setDuration(b2);
        valueAnimator4.setStartDelay(b3);
        valueAnimator4.setRepeatCount(b(a2, xmlPullParser2, "repeatCount", 3, 0));
        valueAnimator4.setRepeatMode(b(a2, xmlPullParser2, "repeatMode", 4, 1));
        if (a3 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String a5 = a(a3, xmlPullParser2, "pathData", 1);
            if (a5 != null) {
                String a6 = a(a3, xmlPullParser2, "propertyXName", 2);
                String a7 = a(a3, xmlPullParser2, "propertyYName", 3);
                if (a6 == null && a7 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a3.getPositionDescription());
                    sb.append(" propertyXName or propertyYName is needed for PathData");
                    throw new InflateException(sb.toString());
                }
                Path b5 = b(a5);
                float f3 = 0.5f * f2;
                PathMeasure pathMeasure = new PathMeasure(b5, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f4 = 0.0f;
                while (true) {
                    f4 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f4));
                    if (!pathMeasure.nextContour()) {
                        break;
                    }
                }
                PathMeasure pathMeasure2 = new PathMeasure(b5, false);
                int min = Math.min(100, ((int) (f4 / f3)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f5 = f4 / ((float) (min - 1));
                valueAnimator2 = valueAnimator4;
                typedArray = a2;
                int i4 = 0;
                float f6 = 0.0f;
                while (true) {
                    propertyValuesHolder = null;
                    if (i2 >= min) {
                        break;
                    }
                    int i5 = min;
                    pathMeasure2.getPosTan(f6 - ((Float) arrayList.get(i4)).floatValue(), fArr3, null);
                    fArr[i2] = fArr3[0];
                    fArr2[i2] = fArr3[1];
                    f6 += f5;
                    int i6 = i4 + 1;
                    if (i6 < arrayList.size() && f6 > ((Float) arrayList.get(i6)).floatValue()) {
                        pathMeasure2.nextContour();
                        i4 = i6;
                    }
                    i2++;
                    min = i5;
                }
                PropertyValuesHolder ofFloat = a6 != null ? PropertyValuesHolder.ofFloat(a6, fArr) : null;
                if (a7 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(a7, fArr2);
                }
                if (ofFloat == null) {
                    i2 = 0;
                    objectAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
                } else {
                    i2 = 0;
                    if (propertyValuesHolder == null) {
                        objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat});
                    } else {
                        objectAnimator.setValues(new PropertyValuesHolder[]{ofFloat, propertyValuesHolder});
                    }
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = a2;
                objectAnimator.setPropertyName(a(a3, xmlPullParser2, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = a2;
        }
        if (!a(xmlPullParser2, "interpolator")) {
            typedArray2 = typedArray;
        } else {
            typedArray2 = typedArray;
            i2 = typedArray2.getResourceId(i2, i2);
        }
        if (i2 > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtils.loadInterpolator(context, i2));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (a3 != null) {
            a3.recycle();
        }
        return valueAnimator3;
    }
}
