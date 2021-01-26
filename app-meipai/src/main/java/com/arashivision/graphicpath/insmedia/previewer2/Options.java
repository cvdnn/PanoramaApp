package com.arashivision.graphicpath.insmedia.previewer2;

import com.arashivision.graphicpath.insmedia.InsMediaLibsLoader;
import com.arashivision.insbase.nativeref.NativeObjectRef;

public class Options extends NativeObjectRef {

    public static class OptionKey {
        public static final int kAndroidPreferSurfaceHwBuffer = 24;
        public static final int kCopyVideoHwaccel = 2;
        public static final int kDecodeThreads = 3;
        public static final int kDisableImageAutoScale = 9;
        public static final int kDisalbeLeftChannel = 4;
        public static final int kDisalbeRightChannel = 5;
        public static final int kEnableBuffering = 7;
        public static final int kEnableBufferingProgress = 8;
        public static final int kEnableVideoHwaccel = 1;
        public static final int kGlVersion = 21;
        public static final int kNetworkId = 10;
        public static final int kSharedEglContext = 20;
        public static final int kSmoothSwitchCachingDurationMs = 6;
    }

    static {
        InsMediaLibsLoader.load();
    }

    public Options() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    public native void setAVRational(int i2, int i3, int i4);

    public native void setBool(int i2, boolean z);

    public native void setDouble(int i2, double d2);

    public native void setInt(int i2, int i3);

    public native void setInt64(int i2, long j2);

    public native void setString(int i2, String str);

    public native void setVoidPtr(int i2, long j2);

    public Options(long j2) {
        super(j2, com.arashivision.onecamera.Options.TAG);
    }
}
