package com.deepai.paipai.support.file;

import android.content.Context;
import com.deepai.paipai.R;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class FileOperateUtil {
    public static final int ROOT = 0;
    public static final String TAG = "FileOperateUtil";
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_THUMBNAIL = 2;
    public static final int TYPE_VIDEO = 3;

    public static String getFolderPath(Context context, int type, String rootPath) {
        StringBuilder pathBuilder = new StringBuilder();
        pathBuilder.append(context.getExternalFilesDir(null).getAbsolutePath());
        pathBuilder.append(File.separator);
        pathBuilder.append(context.getString(R.string.Files));
        pathBuilder.append(File.separator);
        pathBuilder.append(rootPath);
        pathBuilder.append(File.separator);
        switch (type) {
            case 1:
                pathBuilder.append(context.getString(R.string.Image));
                break;
            case 2:
                pathBuilder.append(context.getString(R.string.Thumbnail));
                break;
            case 3:
                pathBuilder.append(context.getString(R.string.Video));
                break;
        }
        return pathBuilder.toString();
    }

    public static List<File> listFiles(String file, String format, String content) {
        return listFiles(new File(file), format, content);
    }

    public static List<File> listFiles(String file, String format) {
        return listFiles(new File(file), format, (String) null);
    }

    public static List<File> listFiles(File file, final String extension, final String content) {
        if (file == null || !file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] files = file.listFiles(new FilenameFilter() {
            public boolean accept(File arg0, String arg1) {
                if (content == null || content.equals("")) {
                    return arg1.endsWith(extension);
                }
                return arg1.contains(content) && arg1.endsWith(extension);
            }
        });
        if (files == null) {
            return null;
        }
        List<File> list = new ArrayList<>(Arrays.asList(files));
        sortList(list, false);
        return list;
    }

    public static void sortList(List<File> list, final boolean asc) {
        Collections.sort(list, new Comparator<File>() {
            public int compare(File file, File newFile) {
                if (file.lastModified() > newFile.lastModified()) {
                    if (asc) {
                        return 1;
                    }
                    return -1;
                } else if (file.lastModified() == newFile.lastModified()) {
                    return 0;
                } else {
                    if (asc) {
                        return -1;
                    }
                    return 1;
                }
            }
        });
    }

    public static String createFileNmae(String extension) {
        new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        String formatDate = "MyFileName";
        if (!extension.startsWith(".")) {
            extension = "." + extension;
        }
        return formatDate + extension;
    }

    public static boolean deleteThumbFile(String thumbPath, Context context) {
        File file = new File(thumbPath);
        if (!file.exists()) {
            return false;
        }
        boolean flag = file.delete();
        File file2 = new File(thumbPath.replace(context.getString(R.string.Thumbnail), context.getString(R.string.Image)));
        if (!file2.exists()) {
            return flag;
        }
        return file2.delete();
    }

    public static boolean deleteSourceFile(String sourcePath, Context context) {
        File file = new File(sourcePath);
        if (!file.exists()) {
            return false;
        }
        boolean flag = file.delete();
        File file2 = new File(sourcePath.replace(context.getString(R.string.Image), context.getString(R.string.Thumbnail)));
        if (!file2.exists()) {
            return flag;
        }
        return file2.delete();
    }
}
