package com.baidu.sapi2.callback;

import android.content.Context;
import android.net.Uri;

public abstract class ImageCropCallback {

    public static abstract class ImageCropResult {
        public abstract void onImageResult(String str);
    }

    public abstract void onImageCrop(Context context, Uri uri, int i2, int i3, ImageCropResult imageCropResult);
}
