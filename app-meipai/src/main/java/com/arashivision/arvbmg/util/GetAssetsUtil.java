package com.arashivision.arvbmg.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class GetAssetsUtil {
    public static String getAssetsCacheFile(Context context, String str, int i2) {
        FileOutputStream fileOutputStream;
        File file = new File(context.getCacheDir(), str);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        try {
            AssetManager assets = context.getAssets();
            StringBuilder sb = new StringBuilder();
            sb.append("model/");
            sb.append(str);
            InputStream open = assets.open(sb.toString());
            try {
                fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[i2];
                while (true) {
                    int read = open.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                open.close();
            } catch (Throwable th) {
                open.close();
                throw th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return file.getAbsolutePath();
    }
}
