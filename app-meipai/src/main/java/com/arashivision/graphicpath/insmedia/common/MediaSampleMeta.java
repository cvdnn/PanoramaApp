package com.arashivision.graphicpath.insmedia.common;

import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class MediaSampleMeta extends NativeObjectRef {
    public static final int kInvalidClipIndex = -1;
    public static final long kInvalidTimestamp = Long.MIN_VALUE;

    static {
        InsMediaLibsLoader.load();
    }

    public MediaSampleMeta(long j2) {
        this(j2, "MediaSampleMeta");
    }

    public native double getClipEndCutscenesDurationMs();

    public native int getClipIndex();

    public native double getClipScaledDurationMs();

    public native double getClipStartCutscenesDurationMs();

    public native double getClipStartMediaTimeMs();

    public native double getForceRenderDurationMs();

    public native double getMediaTimeMs();

    public native int getPartClipIndex();

    public native int getPartCount();

    public native double getRepeatMediaTimeOffsetMs();

    public native double getRotate();

    public native double getSrcProgressTimeMs();

    public native int getSrcSerialId();

    public native double getSrcTsMs();

    public native String getTrackUniqueName();

    public MediaSampleMeta(long j2, String str) {
        super(j2, str);
    }
}
