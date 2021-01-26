package e.a.a.a;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.arashivision.insbase.joml.Math;
import com.arashivision.insbase.joml.Matrix4f;
import com.arashivision.insbase.joml.Quaterniondc;
import com.arashivision.insbase.joml.Quaternionfc;
import com.arashivision.insta360.basecamera.log.CameraLogger;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidubce.auth.NTLMEngineImpl;
import com.tencent.open.utils.k;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: outline */
public class a {
    public static double a(double d2, double d3, double d4, double d5) {
        return d2 + d3 + d4 + d5;
    }

    public static double a(double d2, double d3, double d4, double d5, double d6) {
        return ((d4 - (d2 * d3)) * d5) + d6;
    }

    public static double a(Quaterniondc quaterniondc, double d2) {
        double w = quaterniondc.w() * d2;
        return w + w;
    }

    public static float a(float f2, float f3, float f4, float f5) {
        return f2 + f3 + f4 + f5;
    }

    public static float a(float f2, float f3, float f4, float f5, float f6) {
        return ((f4 - (f2 * f3)) * f5) + f6;
    }

    public static float a(Quaternionfc quaternionfc, float f2) {
        float w = quaternionfc.w() * f2;
        return w + w;
    }

    public static int a(float f2, int i2, int i3) {
        return (Float.floatToIntBits(f2) + i2) * i3;
    }

    public static int a(int i2, int i3, int i4, int i5) {
        return NTLMEngineImpl.rotintlft(i2 + i3 + i4, i5);
    }

    public static String a(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String a(String str, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String a(String str, Uri uri) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(uri);
        return sb.toString();
    }

    public static String a(String str, Fragment fragment, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(fragment);
        sb.append(str2);
        return sb.toString();
    }

    public static String a(String str, File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(file);
        return sb.toString();
    }

    public static String a(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(obj);
        return sb.toString();
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String a(StringBuilder sb, int i2, String str) {
        sb.append(i2);
        sb.append(str);
        return sb.toString();
    }

    public static String a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String a(NumberFormat numberFormat, double d2, StringBuilder sb, String str) {
        sb.append(numberFormat.format(d2));
        sb.append(str);
        return sb.toString();
    }

    public static String a(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder a(String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder a(String str, int i2, String str2, int i3, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder a(String str, long j2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(j2);
        sb.append(str2);
        return sb;
    }

    public static void a(int i2, String str, String str2, IUiListener iUiListener) {
        iUiListener.onError(new UiError(i2, str, str2));
    }

    public static void a(Matrix4f matrix4f, float f2, float f3, float f4, float f5) {
        matrix4f._m10(f2);
        matrix4f._m11(f3);
        matrix4f._m12(f4);
        matrix4f._m13(f5);
    }

    public static void a(String str, int i2, CameraLogger cameraLogger) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        cameraLogger.w(sb.toString());
    }

    public static void a(String str, int i2, StringBuilder sb, StringBuffer stringBuffer) {
        sb.append(Base64.encodeToString(k.i(str), i2));
        stringBuffer.append(sb.toString());
    }

    public static void a(String str, String str2, ArrayList arrayList) {
        arrayList.add(new PassNameValuePair(str, str2));
    }

    public static void a(StringBuilder sb, int i2, String str, HashMap hashMap, String str2) {
        sb.append(i2);
        sb.append(str);
        hashMap.put(str2, sb.toString());
    }

    public static void a(StringBuilder sb, String str, char c2, String str2) {
        sb.append(str);
        sb.append(c2);
        sb.append(str2);
    }

    public static void a(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static boolean a(ArrayList arrayList, String str, int i2, List list) {
        arrayList.add(str);
        return list.contains(Integer.valueOf(i2));
    }

    public static double b(double d2, double d3, double d4, double d5) {
        return ((d2 + d3) - d4) - d5;
    }

    public static double b(Quaterniondc quaterniondc, double d2) {
        double z = quaterniondc.z() * d2;
        return z + z;
    }

    public static float b(float f2, float f3, float f4, float f5) {
        return ((f2 + f3) - f4) - f5;
    }

    public static float b(Quaternionfc quaternionfc, float f2) {
        float z = quaternionfc.z() * f2;
        return z + z;
    }

    public static StringBuilder b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static void b(Matrix4f matrix4f, float f2, float f3, float f4, float f5) {
        matrix4f._m20(f2);
        matrix4f._m21(f3);
        matrix4f._m22(f4);
        matrix4f._m23(f5);
    }

    public static void b(String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        Log.d(str2, sb.toString());
    }

    public static void b(StringBuilder sb, int i2, String str) {
        sb.append(i2);
        Log.e(str, sb.toString());
    }

    public static void b(NumberFormat numberFormat, double d2, StringBuilder sb, String str) {
        sb.append(numberFormat.format(d2));
        sb.append(str);
    }

    public static double c(double d2, double d3, double d4, double d5) {
        return (d4 - (d2 * d3)) * d5;
    }

    public static float c(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) + f4) - f5;
    }

    public static void c(Matrix4f matrix4f, float f2, float f3, float f4, float f5) {
        matrix4f._m30(f2);
        matrix4f._m31(f3);
        matrix4f._m32(f4);
        matrix4f._m33(f5);
    }

    public static void c(String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i2);
        Log.e(str2, sb.toString());
    }

    public static void c(StringBuilder sb, int i2, String str) {
        sb.append(i2);
        Log.i(str, sb.toString());
    }

    public static double d(double d2, double d3, double d4, double d5) {
        return (d2 * d3 * d4) + d5;
    }

    public static float d(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) - f4) + f5;
    }

    public static double e(double d2, double d3, double d4, double d5) {
        return d5 / Math.sqrt((d2 * d3) + d4);
    }

    public static float e(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) * f4) + f5;
    }

    public static double f(double d2, double d3, double d4, double d5) {
        return ((d2 - d3) + d4) - d5;
    }

    public static float f(float f2, float f3, float f4, float f5) {
        return (f2 * f3) + f4 + f5;
    }

    public static double g(double d2, double d3, double d4, double d5) {
        return ((d2 - d3) - d4) + d5;
    }

    public static float g(float f2, float f3, float f4, float f5) {
        return ((f2 * f3) + f4) * f5;
    }

    public static double h(double d2, double d3, double d4, double d5) {
        return ((d2 - d3) * d4) + d5;
    }

    public static float h(float f2, float f3, float f4, float f5) {
        return f5 / ((f2 * f3) + f4);
    }

    public static double i(double d2, double d3, double d4, double d5) {
        return (d2 * d3) + d4 + d5;
    }

    public static float i(float f2, float f3, float f4, float f5) {
        return (f4 - (f2 * f3)) * f5;
    }

    public static double j(double d2, double d3, double d4, double d5) {
        return d5 - ((d2 * d3) + d4);
    }

    public static double k(double d2, double d3, double d4, double d5) {
        return ((d2 * d3) + d4) * d5;
    }

    public static double l(double d2, double d3, double d4, double d5) {
        return d5 / ((d2 * d3) + d4);
    }

    public static double m(double d2, double d3, double d4, double d5) {
        return (d4 - (d2 * d3)) + d5;
    }
}
