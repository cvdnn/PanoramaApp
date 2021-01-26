package com.cvdnn.camera;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.io.Stream;
import android.log.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static android.graphics.Bitmap.CompressFormat.JPEG;

public class ImageUtils {

    public static Bitmap getRotatedBitmap(Bitmap bitmap, int rotation) {
        Matrix matrix = new Matrix();
        matrix.postRotate(rotation);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
    }

    public static boolean write(Bitmap bitmap, File picFile) {
        boolean result = false;
        if (bitmap != null && !bitmap.isRecycled() && picFile != null) {
            OutputStream bos = null;

            try {
                bos = new BufferedOutputStream(new FileOutputStream(picFile));
                bitmap.compress(JPEG, 100, bos);
                bos.flush();

                result = true;
            } catch (Exception e) {
                Log.e(e);
            } finally {
                Stream.close(bos);
            }
        }

        return result;
    }

    public static Bitmap recycle(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                bitmap.recycle();
            } catch (Exception e) {
            }
        }

        return null;
    }
}
