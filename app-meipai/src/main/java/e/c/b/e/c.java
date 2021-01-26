package e.c.b.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.view.View;
import e.c.b.d;
import e.c.b.f.a;
import e.c.b.f.b;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class c {

    /* renamed from: a reason: collision with root package name */
    public static Activity f5894a;

    /* renamed from: b reason: collision with root package name */
    public static b<List> f5895b = new b<>(d.f5881e);

    /* renamed from: c reason: collision with root package name */
    public static boolean f5896c = true;

    /* renamed from: d reason: collision with root package name */
    public static long f5897d;

    /* renamed from: e reason: collision with root package name */
    public static int f5898e = 0;

    /* renamed from: f reason: collision with root package name */
    public static int f5899f = 0;

    /* renamed from: g reason: collision with root package name */
    public static int f5900g = 0;

    /* renamed from: h reason: collision with root package name */
    public static boolean f5901h = false;

    public static byte[] a() {
        String str = "getScreenshot failed, curActivity ";
        if (f5894a == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            View decorView = f5894a.getWindow().getDecorView();
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            if (drawingCache != null) {
                drawingCache.compress(CompressFormat.JPEG, 30, byteArrayOutputStream);
            } else {
                StringBuilder sb = new StringBuilder(str);
                sb.append(f5894a.getClass().getName());
                a.a(sb.toString());
            }
            decorView.setDrawingCacheEnabled(false);
        } catch (RuntimeException e2) {
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(f5894a.getClass().getName());
            a.a(sb2.toString(), e2);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
