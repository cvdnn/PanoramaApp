package e.d.a.n.p.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.Log;
import com.baidu.mobstat.Config;
import e.d.a.n.n.c0.d;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TransformationUtils */
public final class z {

    /* renamed from: a reason: collision with root package name */
    public static final Paint f7738a = new Paint(6);

    /* renamed from: b reason: collision with root package name */
    public static final Paint f7739b;

    /* renamed from: c reason: collision with root package name */
    public static final Set<String> f7740c;

    /* renamed from: d reason: collision with root package name */
    public static final Lock f7741d;

    /* compiled from: TransformationUtils */
    public static final class a implements Lock {
        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        new Paint(7);
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"}));
        f7740c = hashSet;
        f7741d = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new a();
        Paint paint = new Paint(7);
        f7739b = paint;
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    }

    public static Bitmap a(d dVar, Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f4 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            f3 = ((float) i3) / ((float) bitmap.getHeight());
            f4 = e.a.a.a.a.i((float) bitmap.getWidth(), f3, (float) i2, 0.5f);
            f2 = 0.0f;
        } else {
            f3 = ((float) i2) / ((float) bitmap.getWidth());
            f2 = e.a.a.a.a.i((float) bitmap.getHeight(), f3, (float) i3, 0.5f);
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((float) ((int) (f4 + 0.5f)), (float) ((int) (f2 + 0.5f)));
        Bitmap a2 = dVar.a(i2, i3, a(bitmap));
        a2.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, a2, matrix);
        return a2;
    }

    public static Bitmap b(d dVar, Bitmap bitmap, int i2, int i3) {
        String str = "TransformationUtils";
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "requested target size too big for input, fit centering instead");
            }
            return c(dVar, bitmap, i2, i3);
        }
        if (Log.isLoggable(str, 2)) {
            Log.v(str, "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static Bitmap c(d dVar, Bitmap bitmap, int i2, int i3) {
        String str = "TransformationUtils";
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i2) / ((float) bitmap.getWidth()), ((float) i3) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap a2 = dVar.a((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), a(bitmap));
        a2.setHasAlpha(bitmap.hasAlpha());
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("request: ");
            sb.append(i2);
            String str2 = Config.EVENT_HEAT_X;
            sb.append(str2);
            sb.append(i3);
            Log.v(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append(str2);
            sb2.append(bitmap.getHeight());
            Log.v(str, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toReuse: ");
            sb3.append(a2.getWidth());
            sb3.append(str2);
            sb3.append(a2.getHeight());
            Log.v(str, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("minPct:   ");
            sb4.append(min);
            Log.v(str, sb4.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, a2, matrix);
        return a2;
    }

    public static Bitmap.Config a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        f7741d.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f7738a);
            canvas.setBitmap(null);
        } finally {
            f7741d.unlock();
        }
    }
}
