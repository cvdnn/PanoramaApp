package com.deepai.library.support.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

public class FileSizeUtil {
    public static final int SIZETYPE_B = 1;
    public static final int SIZETYPE_GB = 4;
    public static final int SIZETYPE_KB = 2;
    public static final int SIZETYPE_MB = 3;

    public static double getFileOrFilesSize(String filePath, int sizeType) {
        File file = new File(filePath);
        long blockSize = 0;
        try {
            if (file.isDirectory()) {
                blockSize = getFileSizes(file);
            } else {
                blockSize = getFileSize(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("获取文件大小", "获取失败!");
        }
        return FormetFileSize(blockSize, sizeType);
    }

    public static String getAutoFileOrFilesSize(String filePath) {
        File file = new File(filePath);
        long blockSize = 0;
        try {
            if (file.isDirectory()) {
                blockSize = getFileSizes(file);
            } else {
                blockSize = getFileSize(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("获取文件大小", "获取失败!");
        }
        return FormetFileSize(blockSize);
    }

    private static long getFileSize(File file) throws Exception {
        if (file.exists()) {
            return (long) new FileInputStream(file).available();
        }
        file.createNewFile();
        Log.e("获取文件大小", "文件不存在!");
        return 0;
    }

    private static long getFileSizes(File f) throws Exception {
        long fileSize;
        long size = 0;
        File[] flist = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                fileSize = getFileSizes(flist[i]);
            } else {
                fileSize = getFileSize(flist[i]);
            }
            size += fileSize;
        }
        return size;
    }

    private static String FormetFileSize(long fileS) {
        String fileSizeString;
        DecimalFormat df = new DecimalFormat("#.00");
        String str = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format(((double) fileS) / 1024.0d) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format(((double) fileS) / 1048576.0d) + "MB";
        } else {
            fileSizeString = df.format(((double) fileS) / 1.073741824E9d) + "GB";
        }
        return fileSizeString;
    }

    private static double FormetFileSize(long fileS, int sizeType) {
        DecimalFormat df = new DecimalFormat("#.00");
        switch (sizeType) {
            case 1:
                return Double.valueOf(df.format((double) fileS)).doubleValue();
            case 2:
                return Double.valueOf(df.format(((double) fileS) / 1024.0d)).doubleValue();
            case 3:
                return Double.valueOf(df.format(((double) fileS) / 1048576.0d)).doubleValue();
            case 4:
                return Double.valueOf(df.format(((double) fileS) / 1.073741824E9d)).doubleValue();
            default:
                return 0.0d;
        }
    }

    public static void deleteAllFiles(File filePath) {
        File[] files = filePath.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e) {
                    }
                } else if (f.exists()) {
                    deleteAllFiles(f);
                    try {
                        f.delete();
                    } catch (Exception e2) {
                    }
                }
            }
        }
    }

    public static double FormetSize(double cacheSize) {
        return Double.valueOf(new DecimalFormat("#.00").format(cacheSize)).doubleValue();
    }
}
