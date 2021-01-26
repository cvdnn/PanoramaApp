package a.a.a.a.e.a.l;

import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.util.FovDistanceUtils;
import e.a.a.a.a;
import java.util.Arrays;

public class d {

    /* renamed from: a reason: collision with root package name */
    public static final MediaLogger f650a = MediaLogger.getLogger(d.class);

    public static float a(float f2, float f3) {
        while (((double) Math.abs(f3 - f2)) >= 3.141592653589793d) {
            double d2 = (double) f2;
            float f4 = (float) (f3 > f2 ? d2 + 6.283185307179586d : d2 - 6.283185307179586d);
            MediaLogger mediaLogger = f650a;
            StringBuilder sb = new StringBuilder();
            sb.append("format euler from: ");
            sb.append(f2);
            sb.append(" to: ");
            sb.append(f4);
            mediaLogger.d(sb.toString());
            f2 = f4;
        }
        return f2;
    }

    public static Transform a(Transform transform, int i2, FileType fileType, int[] iArr) {
        if (transform == null) {
            f650a.e("rotateTransformIfNeed, but transform is null");
            return null;
        }
        if (fileType == FileType.FISH_EYE) {
            if (i2 == 90 || i2 == 270) {
                transform.setFov((float) Math.toRadians(FovDistanceUtils.convertYFovToXFov(Math.toDegrees((double) transform.getFov()), iArr[0], iArr[1])));
            }
            transform.setRoll(a(transform.getRoll() - ((float) (((double) (i2 / 90)) * 1.5707963267948966d)), 0.0f));
        }
        return transform;
    }

    public static boolean a(boolean z, int i2) {
        boolean z2 = false;
        if (!z) {
            return false;
        }
        if (i2 == 90 || i2 == 270) {
            z2 = true;
        }
        return z2;
    }

    public static int[] a(int[] iArr) {
        int i2;
        if (Arrays.equals(iArr, new int[]{-1, -1})) {
            return iArr;
        }
        int i3 = iArr[0];
        int i4 = iArr[1];
        while (true) {
            int i5 = i4;
            i2 = i3;
            i3 = i5;
            if (i3 == 0) {
                break;
            }
            i4 = i2 % i3;
        }
        int[] iArr2 = {iArr[0] / i2, iArr[1] / i2};
        if (i2 != 1) {
            MediaLogger mediaLogger = f650a;
            StringBuilder a2 = a.a("setScreenRatio, screenRatio is simplified from ");
            a2.append(Arrays.toString(iArr));
            a2.append(" to ");
            a2.append(Arrays.toString(iArr2));
            mediaLogger.d(a2.toString());
        }
        return iArr2;
    }

    public static int[] a(int[] iArr, boolean z) {
        if (z) {
            return new int[]{iArr[1], iArr[0]};
        }
        return new int[]{iArr[0], iArr[1]};
    }
}
