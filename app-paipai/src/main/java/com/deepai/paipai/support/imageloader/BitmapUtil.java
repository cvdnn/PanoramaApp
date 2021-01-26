package com.deepai.paipai.support.imageloader;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.IOException;

public class BitmapUtil {
    public static Bitmap reviewPicRotate(Bitmap bitmap, String path) {
        int degree = getPicRotate(path);
        if (degree == 0) {
            return bitmap;
        }
        Matrix m = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        m.setRotate((float) degree);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, m, true);
    }

    public static int getPicRotate(String path) {
        try {
            switch (new ExifInterface(path).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
