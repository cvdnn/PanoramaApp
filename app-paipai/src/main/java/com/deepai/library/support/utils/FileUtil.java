package com.deepai.library.support.utils;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class FileUtil {
    public static void asset2File(String dirPath, String fileName, InputStream is) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File dir = new File(dirPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try {
                FileOutputStream fos = new FileOutputStream(new File(dirPath + CookieSpec.PATH_DELIM + fileName));
                byte[] buffer = new byte[2048];
                while (true) {
                    int count = is.read(buffer);
                    if (count > 0) {
                        fos.write(buffer, 0, count);
                    } else {
                        fos.flush();
                        fos.close();
                        try {
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            } catch (Exception e2) {
                try {
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
