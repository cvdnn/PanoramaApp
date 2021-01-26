package com.deepai.paipai.wechattakephoto.manager;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public enum ImageTaker {
    INSTANCE;

    public void initTemp() {
        TempManager.INSTANCE.init(null, null, null);
    }

    public void initTemp(String tempFileDir) {
        TempManager.INSTANCE.init(tempFileDir, null, null);
    }

    public void initTemp(String tempFileDir, String tempFileName, String tempFileExtension) {
        TempManager.INSTANCE.init(tempFileDir, tempFileName, tempFileExtension);
    }

    public void clearTemp() {
        TempManager.INSTANCE.clearTemp();
    }

    public String compressImageFile(String imgPath) {
        Bitmap bitmap = compressImageFromFile(imgPath);
        File file = TempManager.INSTANCE.obtainFile();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.exists()) {
            compressBmpToFile(bitmap, file);
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return file.getAbsolutePath();
    }

    private Bitmap compressImageFromFile(String srcPath) {
        Options newOpts = new Options();
        newOpts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(srcPath, newOpts);
        int w = newOpts.outWidth;
        int h = newOpts.outHeight;
        int be = 1;
        if (w > h && ((float) w) > 480.0f) {
            be = (int) (((float) newOpts.outWidth) / 480.0f);
        } else if (w < h && ((float) h) > 800.0f) {
            be = (int) (((float) newOpts.outHeight) / 800.0f);
        }
        if (be <= 0) {
            be = 1;
        }
        newOpts.inSampleSize = be;
        newOpts.inPreferredConfig = Config.ARGB_8888;
        newOpts.inPurgeable = true;
        newOpts.inInputShareable = true;
        newOpts.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(srcPath, newOpts);
    }

    private void compressBmpToFile(Bitmap bmp, File file) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options = 80;
        bmp.compress(CompressFormat.JPEG, 80, baos);
        while (baos.toByteArray().length / 1024 > 100) {
            baos.reset();
            options -= 10;
            bmp.compress(CompressFormat.JPEG, options, baos);
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
