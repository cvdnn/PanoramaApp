package com.deepai.paipai.support.file;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;
import com.deepai.paipai.support.camera.CameraConstants;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.httpclient.cookie.CookieSpec;

public class FileUtils {
    private static String SDPATH;
    public static String fileFangJianBmp = "";
    public static String fileSaveNum = "";
    public static String fileSheBeiBmp = "";
    private boolean mySDOkbool = false;

    public String getSDPATH() {
        return SDPATH;
    }

    public static String getFilePath() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        SDPATH = Environment.getExternalStorageDirectory() + CookieSpec.PATH_DELIM;
        if (!isFileExist("PaiPai360File")) {
            creatSDDir("PaiPai360File");
        }
        return SDPATH + "PaiPai360File";
    }

    public static String getTempFilePath() {
        String temp = getFilePath();
        if (temp == null) {
            return null;
        }
        makeDirExist(temp + "/TempFile");
        return temp + "/TempFile";
    }

    public static String getPanoDir() {
        String temp = getFilePath();
        if (temp == null) {
            return null;
        }
        makeDirExist(temp + "/PanoFile");
        return temp + "/PanoFile";
    }

    public static String getTemplateDir() {
        String temp = getFilePath();
        if (temp == null) {
            return null;
        }
        makeDirExist(temp + "/Template");
        return temp + "/Template";
    }

    public static String getRecordDir() {
        String temp = getFilePath();
        if (temp == null) {
            return null;
        }
        makeDirExist(temp + "/Record");
        return temp + "/Record";
    }

    public static String getImageCacheDir() {
        String temp = getFilePath();
        if (temp == null) {
            return null;
        }
        makeDirExist(temp + "/MineImage");
        return temp + "/MineImage";
    }

    public static void makeDirExist(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void makeFileExist(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUploadPach() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        SDPATH = Environment.getExternalStorageDirectory() + CookieSpec.PATH_DELIM;
        if (!isFileExist("PaiPai360File/TempUploadFile")) {
            creatSDDir("PaiPai360File/TempUploadFile");
        }
        return SDPATH + "PaiPai360File/TempUploadFile";
    }

    public static String getVideoPach() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        SDPATH = Environment.getExternalStorageDirectory() + CookieSpec.PATH_DELIM;
        if (!isFileExist("PaiPai360File/Video")) {
            creatSDDir("PaiPai360File/Video");
        }
        return SDPATH + "PaiPai360File/Video";
    }

    public static File getUploadPictureFile(int thisName) {
        return new File(getUploadPach() + File.separator + thisName + Util.PHOTO_DEFAULT_EXT);
    }

    public static File getUploadFile(int thisName, float scale) {
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        Bitmap thisTemp = getPicture(thisName);
        Bitmap resizeBmp = Bitmap.createBitmap(thisTemp, 0, 0, thisTemp.getWidth(), thisTemp.getHeight(), matrix, true);
        File file = getUploadPictureFile(thisName);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        resizeBmp.compress(CompressFormat.JPEG, 100, baos);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(baos.toByteArray());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            fos.flush();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return file;
    }

    public static String getVideoFileName() {
        return getVideoPach() + File.separator + "video" + ".3gp";
    }

    public static int getVideoNum() {
        List<File> files = getFiles(new File(getVideoPach()), ".3gp", null);
        if (files.size() > 0) {
            return files.size();
        }
        return 0;
    }

    public static boolean getVideoExists() {
        return new File(getVideoFileName()).exists();
    }

    public static String getPictureFileName(int thisName) {
        return getTempFilePath() + File.separator + thisName + Util.PHOTO_DEFAULT_EXT;
    }

    public static Bitmap getPicture(int thisName) {
        String thisFileNameString = getPictureFileName(thisName);
        if (new File(thisFileNameString).exists()) {
            return BitmapFactory.decodeFile(thisFileNameString);
        }
        Log.e("****files", "NULL***");
        return null;
    }

    public static void setPictureFilsSortList(List<File> list, final boolean asc) {
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

    public static List<File> getFiles(File file, final String extension, final String content) {
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
        setPictureFilsSortList(list, false);
        return list;
    }

    public static int getPictureNum() {
        List<File> files = getFiles(new File(getTempFilePath()), Util.PHOTO_DEFAULT_EXT, null);
        if (files.size() > 0) {
            return files.size();
        }
        return 0;
    }

    public static Boolean isVideoModeAndPictureOK() {
        return Boolean.valueOf(getPictureNum() == CameraConstants.videoMode);
    }

    public static void DeleteFile(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] childFile = file.listFiles();
                if (childFile != null && childFile.length != 0) {
                    for (File f : childFile) {
                        DeleteFile(f);
                    }
                }
            }
        }
    }

    public static void delAllPicture() {
        DeleteFile(new File(getTempFilePath()));
    }

    public boolean sdIsOk() {
        return this.mySDOkbool;
    }

    public File creatSDFile(String fileName) throws IOException {
        File file = new File(SDPATH + fileName);
        file.createNewFile();
        return file;
    }

    public static File creatSDDir(String dirName) {
        File dir = new File(SDPATH + dirName);
        dir.mkdirs();
        return dir;
    }

    public static boolean isFileExist(String fileName) {
        return new File(SDPATH + fileName).exists();
    }

    public boolean copyFile(String oldPath, String newPath) {
        int bytesum = 0;
        try {
            if (!new File(oldPath).exists()) {
                return false;
            }
            InputStream inStream = new FileInputStream(oldPath);
            FileOutputStream fs = new FileOutputStream(newPath);
            byte[] buffer = new byte[1024];
            while (true) {
                int byteread = inStream.read(buffer);
                if (byteread != -1) {
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                } else {
                    fs.flush();
                    fs.close();
                    inStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean copyFolder(String oldPath, String newPath) {
        File temp;
        try {
            new File(newPath).mkdirs();
            String[] file = new File(oldPath).list();
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }
                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + CookieSpec.PATH_DELIM + temp.getName().toString());
                    byte[] b = new byte[5120];
                    while (true) {
                        int len = input.read(b);
                        if (len == -1) {
                            break;
                        }
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {
                    copyFolder(oldPath + CookieSpec.PATH_DELIM + file[i], newPath + CookieSpec.PATH_DELIM + file[i]);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public File write2SDFromInput(String path, String fileName, InputStream input) {
        File file = null;
        OutputStream output = null;
        try {
            creatSDDir(path);
            file = creatSDFile(path + fileName);
            OutputStream output2 = new FileOutputStream(file);
            try {
                byte[] buffer = new byte[4096];
                while (input.read(buffer) != -1) {
                    output2.write(buffer);
                }
                output2.flush();
                try {
                    output2.close();
                    OutputStream outputStream = output2;
                } catch (Exception e) {
                    e.printStackTrace();
                    OutputStream outputStream2 = output2;
                }
            } catch (Exception e2) {
                e = e2;
                output = output2;
                try {
                    e.printStackTrace();
                    try {
                        output.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return file;
                } catch (Throwable th) {
                    th = th;
                    try {
                        output.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                output = output2;
                output.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            output.close();
            return file;
        }
        return file;
    }

    public File write2SDFromInput(String fileName, byte[] input) {
        OutputStream output = null;
        try {
            OutputStream output2 = new FileOutputStream(fileName);
            try {
                output2.write(input);
                output2.flush();
                try {
                    output2.close();
                    OutputStream outputStream = output2;
                } catch (Exception e) {
                    e.printStackTrace();
                    OutputStream outputStream2 = output2;
                }
            } catch (Exception e2) {
                e = e2;
                output = output2;
                try {
                    e.printStackTrace();
                    try {
                        output.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        output.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                output = output2;
                output.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            output.close();
            return null;
        }
        return null;
    }
}
