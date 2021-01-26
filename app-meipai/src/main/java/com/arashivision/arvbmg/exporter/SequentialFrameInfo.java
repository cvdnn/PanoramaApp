package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class SequentialFrameInfo extends BMGNativeObjectRef {

    public static class SequentialFrameState {
        public static final int STATE_EOF = 2;
        public static final int STATE_ERROR = 1;
        public static final int STATE_SUCCESS = 0;
    }

    public SequentialFrameInfo(FrameExporterSample frameExporterSample, int i2) {
        this(createNativeWrap(frameExporterSample, i2));
    }

    public static native long createNativeWrap(FrameExporterSample frameExporterSample, int i2);

    public SequentialFrameInfo(long j2) {
        super(j2, "SequentialFrameInfo");
    }
}
