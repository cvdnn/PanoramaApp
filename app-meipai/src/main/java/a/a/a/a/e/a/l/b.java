package a.a.a.a.e.a.l;

import com.arashivision.arvbmg.previewer.BMGPreviewerSource.ClipTimeScale;

public final class b implements e {
    public double a(Object obj) {
        return ((ClipTimeScale) obj).getScale();
    }

    public Object a(double d2, double d3, double d4, Boolean bool, Double d5) {
        ClipTimeScale clipTimeScale = new ClipTimeScale(d2, d3, d4, 16.0d * d4 <= 1.0d, (double) 30);
        return clipTimeScale;
    }

    public double b(Object obj) {
        return ((ClipTimeScale) obj).getEndTimeInSrc();
    }

    public double c(Object obj) {
        return ((ClipTimeScale) obj).getStartTimeInSrc();
    }

    public double d(Object obj) {
        return ((ClipTimeScale) obj).getRepeatToFps();
    }
}
