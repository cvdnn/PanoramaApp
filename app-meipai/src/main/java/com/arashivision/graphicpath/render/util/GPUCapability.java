package com.arashivision.graphicpath.render.util;

public class GPUCapability {

    public static class GPUCapabilityNumber {
        public static final int MAX_TEXTURE_SIZE = 0;
        public static final int OES_EGL_IMAGE_EXTERNAL_CAPABILITY = 65534;
    }

    public static native int queryGPULimit(int i2);
}
