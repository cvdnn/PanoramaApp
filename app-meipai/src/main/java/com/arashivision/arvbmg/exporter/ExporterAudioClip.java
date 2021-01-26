package com.arashivision.arvbmg.exporter;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class ExporterAudioClip extends BMGNativeObjectRef {
    public ExporterAudioClip(String str, double d2, boolean z, long j2, long j3, long j4) {
        this(createNativeWrap(str, d2, z, j2, j3, j4), "ExporterAudioClip");
    }

    public static native long createNativeWrap(String str, double d2, boolean z, long j2, long j3, long j4);

    public ExporterAudioClip(long j2, String str) {
        super(j2, str);
    }
}
