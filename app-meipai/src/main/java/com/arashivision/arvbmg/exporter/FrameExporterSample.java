package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import e.a.a.a.a;

public class FrameExporterSample extends BMGNativeObjectRef {
    public FrameExporterSample(long j2) {
        super(j2, "FrameExporterSample");
        setRequireFreeManually();
    }

    public String desc() {
        StringBuilder a2 = a.a(" FrameExporterSample meta srcTime ");
        a2.append(getSrcTsMs());
        a2.append(" mediaTime ");
        a2.append(getMediaTimeMs());
        a2.append(" rotate ");
        a2.append(getRotate());
        a2.append(" keyFrame ");
        a2.append(isKeyFrame());
        return a2.toString();
    }

    public native double getMediaTimeMs();

    public native double getRotate();

    public native double getSrcTsMs();

    public native boolean isKeyFrame();
}
