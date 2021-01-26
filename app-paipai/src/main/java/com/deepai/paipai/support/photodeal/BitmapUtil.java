package com.deepai.paipai.support.photodeal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import com.deepai.library.support.utils.ToastFactory;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.apache.http.client.methods.HttpGet;

public class BitmapUtil {
    private static final String PAIPAI = "savePaiPai";

    public static boolean getSdcardState() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0086 A[SYNTHETIC, Splitter:B:22:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092 A[SYNTHETIC, Splitter:B:28:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveBitmapToFile(android.graphics.Bitmap r10, java.lang.String r11, android.content.Context r12) throws java.io.IOException {
        /*
            r6 = 0
            r1 = 0
            r3 = 0
            boolean r8 = getSdcardState()
            if (r8 == 0) goto L_0x009b
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.io.File r9 = android.os.Environment.getExternalStorageDirectory()
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = java.io.File.separator
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r9 = "savePaiPai"
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            r1.<init>(r8)
            boolean r8 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0080 }
            if (r8 != 0) goto L_0x0034
            r1.mkdirs()     // Catch:{ FileNotFoundException -> 0x0080 }
        L_0x0034:
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0080 }
            r8.<init>()     // Catch:{ FileNotFoundException -> 0x0080 }
            java.io.File r9 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.String r9 = "savePaiPai"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.StringBuilder r8 = r8.append(r11)     // Catch:{ FileNotFoundException -> 0x0080 }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0080 }
            r2.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0080 }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0080 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0080 }
            r8.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0080 }
            r4.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0080 }
            android.graphics.Bitmap$CompressFormat r8 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x00a9, all -> 0x00a6 }
            r9 = 100
            r10.compress(r8, r9, r4)     // Catch:{ FileNotFoundException -> 0x00a9, all -> 0x00a6 }
            r6 = 1
            if (r4 == 0) goto L_0x0077
            r4.close()     // Catch:{ IOException -> 0x007a }
        L_0x0077:
            r3 = r4
        L_0x0078:
            r7 = r6
        L_0x0079:
            return r7
        L_0x007a:
            r5 = move-exception
            r5.printStackTrace()
            r3 = r4
            goto L_0x0078
        L_0x0080:
            r0 = move-exception
        L_0x0081:
            r0.printStackTrace()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x0078
        L_0x008a:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0078
        L_0x008f:
            r8 = move-exception
        L_0x0090:
            if (r3 == 0) goto L_0x0095
            r3.close()     // Catch:{ IOException -> 0x0096 }
        L_0x0095:
            throw r8
        L_0x0096:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0095
        L_0x009b:
            java.lang.String r8 = "请检查是否装有sd卡"
            android.widget.Toast r8 = com.deepai.library.support.utils.ToastFactory.getToast(r12, r8)
            r8.show()
            r7 = r6
            goto L_0x0079
        L_0x00a6:
            r8 = move-exception
            r3 = r4
            goto L_0x0090
        L_0x00a9:
            r0 = move-exception
            r3 = r4
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deepai.paipai.support.photodeal.BitmapUtil.saveBitmapToFile(android.graphics.Bitmap, java.lang.String, android.content.Context):boolean");
    }

    public static Bitmap getSaveBitmapFromFile(String fileName, Context context) {
        if (getSdcardState()) {
            String strFile = Environment.getExternalStorageDirectory() + File.separator + PAIPAI + File.separator + fileName;
            File file = new File(strFile);
            if (fileName == null || !file.exists()) {
                return null;
            }
            return BitmapFactory.decodeFile(strFile, new Options());
        }
        ToastFactory.getToast(context, "请检查是否装有sd卡").show();
        return null;
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

    public static Bitmap getBitmapFromFile(String fileName, Context context) {
        if (!getSdcardState() || fileName == null) {
            ToastFactory.getToast(context, "请检查是否装有sd卡").show();
            return null;
        } else if (!new File(fileName).exists()) {
            return null;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(fileName, options);
            options.inSampleSize = com.deepai.library.support.utils.BitmapUtil.calculateInSampleSize(options);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Config.RGB_565;
            return BitmapFactory.decodeFile(fileName, options);
        }
    }

    public static Bitmap getImageFromAssetsFile(String fileName, Context context) {
        Bitmap image = null;
        try {
            InputStream is = context.getResources().getAssets().open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return image;
        }
    }

    public static boolean getNetImage(String path, String fileName) {
        boolean flag = false;
        File file = new File(fileName + path.substring(path.lastIndexOf(".")));
        try {
            URL url = new URL(path);
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_CONNECT_TIMEOUT);
                conn.setRequestMethod(HttpGet.METHOD_NAME);
                conn.setDoInput(true);
                if (conn.getResponseCode() == 200) {
                    InputStream is = conn.getInputStream();
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int len = is.read(buffer);
                        if (len == -1) {
                            break;
                        }
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    flag = true;
                    is.close();
                    fos.close();
                }
                URL url2 = url;
            } catch (MalformedURLException e) {
                e = e;
                URL url3 = url;
                e.printStackTrace();
                return flag;
            } catch (ProtocolException e2) {
                e = e2;
                URL url4 = url;
                e.printStackTrace();
                return flag;
            } catch (FileNotFoundException e3) {
                e = e3;
                URL url5 = url;
                e.printStackTrace();
                return flag;
            } catch (IOException e4) {
                e = e4;
                URL url6 = url;
                e.printStackTrace();
                return flag;
            }
        } catch (MalformedURLException e5) {
            e = e5;
            e.printStackTrace();
            return flag;
        } catch (ProtocolException e6) {
            e = e6;
            e.printStackTrace();
            return flag;
        } catch (FileNotFoundException e7) {
            e = e7;
            e.printStackTrace();
            return flag;
        } catch (IOException e8) {
            e = e8;
            e.printStackTrace();
            return flag;
        }
        return flag;
    }
}
