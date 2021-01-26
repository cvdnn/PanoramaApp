package a.a.a.a.e.a.l;

import com.arashivision.arvbmg.exporter.ExporterClip.ExporterTimeScale;

public final class c implements e {
    public double a(Object obj) {
        return ((ExporterTimeScale) obj).factor;
    }

    public Object a(double d2, double d3, double d4, Boolean bool, Double d5) {
        ExporterTimeScale exporterTimeScale = new ExporterTimeScale();
        exporterTimeScale.startTimeMs = (long) d2;
        exporterTimeScale.endTimeMs = (long) d3;
        exporterTimeScale.factor = d4;
        double d6 = (bool == null || !bool.booleanValue()) ? d5 != null ? d5.doubleValue() : 0.0d : (double) 30;
        exporterTimeScale.repeatToFps = d6;
        return exporterTimeScale;
    }

    public double b(Object obj) {
        return (double) ((ExporterTimeScale) obj).endTimeMs;
    }

    public double c(Object obj) {
        return (double) ((ExporterTimeScale) obj).startTimeMs;
    }

    public double d(Object obj) {
        return ((ExporterTimeScale) obj).repeatToFps;
    }
}
