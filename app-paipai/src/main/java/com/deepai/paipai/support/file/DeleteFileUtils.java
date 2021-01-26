package com.deepai.paipai.support.file;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import java.io.File;
import java.util.Date;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.opencv.videoio.Videoio;

public class DeleteFileUtils {
    public static void deleteFiles(String... fileNames) {
        if (fileNames.length > 0) {
            for (String file : fileNames) {
                File file2 = new File(file);
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
    }

    public static boolean deleteFiles(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return false;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/PaiPai360File/PanoFile/" + fileName);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    public static boolean delAllFile(String path) {
        File temp;
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return false;
        }
        String[] tempList = file.list();
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                long lastModeify = temp.lastModified();
                long current = new Date().getTime();
                Log.e("文件创建时间", "current=" + current + "  lastModeify=" + lastModeify);
                if (current - lastModeify > 259200000) {
                    temp.delete();
                }
            }
            if (temp.isDirectory()) {
                delAllFile(path + CookieSpec.PATH_DELIM + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }

    public static boolean isExists(String nativePath) {
        return new File(nativePath).exists();
    }

    public static void openFile(File f, Context context) {
        if (!f.exists()) {
            Toast.makeText(context, "文件尚未下载，无法查看，请您先下载文件！", 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(f), getMIMEType(f));
        context.startActivity(intent);
    }

    private static String getMIMEType(File f) {
        String type;
        String str = "";
        String fName = f.getName();
        String end = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toLowerCase();
        if (end.equals("m4a") || end.equals("mp3") || end.equals("mid") || end.equals("xmf") || end.equals("ogg") || end.equals("wav") || end.equals("wma")) {
            type = "audio";
        } else if (end.equals("3gp") || end.equals("mp4")) {
            type = "video";
        } else if (end.equals("jpg") || end.equals("gif") || end.equals("png") || end.equals("jpeg") || end.equals("bmp")) {
            type = "image";
        } else if (end.equals("apk")) {
            type = "application/vnd.android.package-archive";
        } else {
            type = "*";
        }
        if (end.equals("apk")) {
            return type;
        }
        return type + "/*";
    }
}
