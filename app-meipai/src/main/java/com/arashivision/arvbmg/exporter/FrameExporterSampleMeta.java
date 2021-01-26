package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class FrameExporterSampleMeta extends BMGNativeObjectRef {
    public static final double kInvalidTimestamp = -1.0d;

    public FrameExporterSampleMeta(long j2) {
        this(j2, "FrameExporterSampleMeta");
        setRequireFreeManually();
    }

    public FrameExporterSampleMeta(long j2, String str) {
        super(j2, str);
    }
}
