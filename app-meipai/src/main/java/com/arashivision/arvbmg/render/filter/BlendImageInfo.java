package com.arashivision.arvbmg.render.filter;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import java.nio.ByteBuffer;

public class BlendImageInfo extends BMGNativeObjectRef {
    public ImageInfo mImageInfo;

    public static final class ImageInfo {
        public BlendImageData mBackgroundData;
        public float mBackgroundFactor;
        public BlendImageData mBodyBehindData;
        public BlendImageData mBodyOnData;

        public static final class BlendImageData {
            public int mBufferHeight;
            public int mBufferWidth;
            public ByteBuffer mByteBuffer;
            public float[] rect;
        }
    }

    public BlendImageInfo() {
        super(createNativeWrap(), "BlendImageInfo");
    }

    public static native long createNativeWrap();

    private native void nativeSetBlendImageBackground(ByteBuffer byteBuffer, int i2, int i3, float[] fArr, float f2);

    private native void nativeSetBlendImageBodyBehind(ByteBuffer byteBuffer, int i2, int i3, float[] fArr);

    private native void nativeSetBlendImageBodyOn(ByteBuffer byteBuffer, int i2, int i3, float[] fArr);

    public void setImageInfo(ImageInfo imageInfo) {
        this.mImageInfo = imageInfo;
        String str = BMGConstants.TAG;
        if (imageInfo != null) {
            BlendImageData blendImageData = imageInfo.mBackgroundData;
            if (blendImageData != null) {
                ByteBuffer byteBuffer = blendImageData.mByteBuffer;
                if (byteBuffer != null) {
                    nativeSetBlendImageBackground(byteBuffer, blendImageData.mBufferWidth, blendImageData.mBufferHeight, blendImageData.rect, imageInfo.mBackgroundFactor);
                } else {
                    Log.e(str, " mBackgroundData mByteBuffer null");
                }
            }
            BlendImageData blendImageData2 = imageInfo.mBodyOnData;
            if (blendImageData2 != null) {
                ByteBuffer byteBuffer2 = blendImageData2.mByteBuffer;
                if (byteBuffer2 != null) {
                    nativeSetBlendImageBodyOn(byteBuffer2, blendImageData2.mBufferWidth, blendImageData2.mBufferHeight, blendImageData2.rect);
                } else {
                    Log.e(str, " mBodyOnData mByteBuffer null");
                }
            }
            BlendImageData blendImageData3 = imageInfo.mBodyBehindData;
            if (blendImageData3 != null) {
                ByteBuffer byteBuffer3 = blendImageData3.mByteBuffer;
                if (byteBuffer3 != null) {
                    nativeSetBlendImageBodyBehind(byteBuffer3, blendImageData3.mBufferWidth, blendImageData3.mBufferHeight, blendImageData3.rect);
                } else {
                    Log.e(str, " mBodyBehindData mByteBuffer null");
                }
            }
        } else {
            Log.e(str, "setBlendImageInfo null");
        }
    }
}
