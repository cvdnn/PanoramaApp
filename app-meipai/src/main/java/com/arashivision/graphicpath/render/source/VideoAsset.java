package com.arashivision.graphicpath.render.source;

public class VideoAsset extends Asset {
    public VideoAsset(long j2) {
        super(j2);
    }

    public static native long createNativeWrap(String str, long j2);

    public native double audioBitrate();

    public native int audioChannelCount();

    public native long audioChannelLayout();

    public native String audioCodecName();

    public native double audioDurationS();

    public native int audioSampleRate();

    public native double bitrate();

    public native String getSphereMapping();

    public native String getStereo3d();

    public native boolean hasAudio();

    public native boolean hasSphereMapping();

    public native boolean hasStereo3d();

    public native boolean hasVideo();

    public native double videoBitrate();

    public native String videoCodecName();

    public native double videoDurationS();

    public native double videoFramerate();

    public native int videoHeight();

    public native int videoWidth();

    public VideoAsset(String str) {
        this(createNativeWrap(str, -2147483648L));
    }

    public VideoAsset(String str, long j2) {
        this(createNativeWrap(str, j2));
    }
}
