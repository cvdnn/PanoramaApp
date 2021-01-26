package com.deepai.library.support.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.TypedValue;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class BitmapUtil {
    public static Bitmap zoomImage(Bitmap source, double newWidth, double newHeight) {
        Bitmap newBm;
        float width = (float) source.getWidth();
        float height = (float) source.getHeight();
        Bitmap source2 = null;
        if (width > height) {
            source2 = rotateBitmap(source, 90);
        }
        Matrix matrix = new Matrix();
        if (source2 == null) {
            float scaleX = ((float) newWidth) / width;
            float scaleY = ((float) newHeight) / height;
            matrix.postScale(scaleX, scaleY);
            newBm = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
            if (!(scaleX == 1.0f && scaleY == 1.0f)) {
                source.recycle();
            }
        } else {
            float scaleX2 = ((float) newWidth) / height;
            float scaleY2 = ((float) newHeight) / width;
            matrix.postScale(scaleX2, scaleY2);
            newBm = Bitmap.createBitmap(source2, 0, 0, source2.getWidth(), source2.getHeight(), matrix, true);
            if (!(scaleX2 == 1.0f && scaleY2 == 1.0f)) {
                source2.recycle();
            }
        }
        return newBm;
    }

    public static int calculateInSampleSize(Options options) {
        int width = options.outWidth;
        int height = options.outHeight;
        int inSampleSize = 0;
        if (width > 4096 || height > 4096) {
            if (width >= height) {
                inSampleSize = width / 4096;
            } else {
                inSampleSize = height / 4096;
            }
        }
        if (inSampleSize <= 1) {
            return inSampleSize + 1;
        }
        return inSampleSize;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052 A[SYNTHETIC, Splitter:B:20:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A[SYNTHETIC, Splitter:B:26:0x005e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveBitmapToFile(android.graphics.Bitmap r9, java.lang.String r10, java.lang.String r11) {
        /*
            r6 = 0
            r1 = 0
            r3 = 0
            java.io.File r1 = new java.io.File
            r1.<init>(r10)
            boolean r7 = r1.exists()     // Catch:{ FileNotFoundException -> 0x004c }
            if (r7 != 0) goto L_0x0011
            r1.mkdirs()     // Catch:{ FileNotFoundException -> 0x004c }
        L_0x0011:
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x004c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x004c }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x004c }
            java.lang.StringBuilder r7 = r7.append(r10)     // Catch:{ FileNotFoundException -> 0x004c }
            java.lang.String r8 = "/"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ FileNotFoundException -> 0x004c }
            java.lang.StringBuilder r7 = r7.append(r11)     // Catch:{ FileNotFoundException -> 0x004c }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x004c }
            r2.<init>(r7)     // Catch:{ FileNotFoundException -> 0x004c }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x004c }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004c }
            r7.<init>(r2)     // Catch:{ FileNotFoundException -> 0x004c }
            r4.<init>(r7)     // Catch:{ FileNotFoundException -> 0x004c }
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x006a, all -> 0x0067 }
            r8 = 100
            r9.compress(r7, r8, r4)     // Catch:{ FileNotFoundException -> 0x006a, all -> 0x0067 }
            r6 = 1
            if (r4 == 0) goto L_0x0044
            r4.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0044:
            r3 = r4
        L_0x0045:
            return r6
        L_0x0046:
            r5 = move-exception
            r5.printStackTrace()
            r3 = r4
            goto L_0x0045
        L_0x004c:
            r0 = move-exception
        L_0x004d:
            r0.printStackTrace()     // Catch:{ all -> 0x005b }
            if (r3 == 0) goto L_0x0045
            r3.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0045
        L_0x0056:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0045
        L_0x005b:
            r7 = move-exception
        L_0x005c:
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x0062 }
        L_0x0061:
            throw r7
        L_0x0062:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0061
        L_0x0067:
            r7 = move-exception
            r3 = r4
            goto L_0x005c
        L_0x006a:
            r0 = move-exception
            r3 = r4
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepai.library.support.utils.BitmapUtil.saveBitmapToFile(android.graphics.Bitmap, java.lang.String, java.lang.String):boolean");
    }

    public static Bitmap getBitmapFromFile(String filePath) {
        if (!new File(filePath).exists()) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = calculateInSampleSize(options);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    public static Bitmap getHttpBitmap(String url) {
        Bitmap bitmap = null;
        try {
            InputStream in = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return bitmap;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap getImageFromAssetFile(String fileName, Context context) {
        Bitmap bitmap = null;
        try {
            InputStream is = context.getResources().getAssets().open(fileName);
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return bitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return bitmap;
        }
    }

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

    public static Bitmap rotateBitmap(Bitmap bitmap, int degrees) {
        if (degrees == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) degrees);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap decodeRawResource(Resources resources, int id) {
        TypedValue value = new TypedValue();
        resources.openRawResource(id, value);
        Options opts = new Options();
        opts.inTargetDensity = value.density;
        return BitmapFactory.decodeResource(resources, id, opts);
    }
}
