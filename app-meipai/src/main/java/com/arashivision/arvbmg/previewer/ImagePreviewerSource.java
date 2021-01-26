package com.arashivision.arvbmg.previewer;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;

public class ImagePreviewerSource extends BMGNativeObjectRef {
    public ImagePreviewerSource() {
        this(createNativeWrap());
    }

    public static native long createNativeWrap();

    private native void nativeSetUrl(String str);

    public void setUrl(String str) {
        nativeSetUrl(str);
    }

    public ImagePreviewerSource(long j2) {
        super(j2, "ImagePreviewerSource");
    }
}
