package com.arashivision.insta360.basemedia.util;

import com.arashivision.insta360.basemedia.log.MediaLogger;
import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static MessageDigest I1I;
    public static final MediaLogger IL1Iii = MediaLogger.getLogger(MD5Util.class);
    public static char[] ILil = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        I1I = null;
        try {
            I1I = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            IL1Iii.d("初始化失败，MessageDigest不支持MD5Util");
            e2.printStackTrace();
        }
    }

    public static String IL1Iii(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer(length * 2);
        int i2 = length + 0;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = bArr[i3];
            char[] cArr = ILil;
            char c2 = cArr[(b2 & 240) >> 4];
            char c3 = cArr[b2 & 15];
            stringBuffer.append(c2);
            stringBuffer.append(c3);
        }
        return stringBuffer.toString();
    }

    public static String ILil(byte[] bArr) {
        String IL1Iii2;
        synchronized (MD5Util.class) {
            I1I.update(bArr);
            IL1Iii2 = IL1Iii(I1I.digest());
        }
        return IL1Iii2;
    }

    public static String getFileMD5String(File file) {
        String IL1Iii2;
        synchronized (MD5Util.class) {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            I1I.update(channel.map(MapMode.READ_ONLY, 0, file.length()));
            channel.close();
            fileInputStream.close();
            IL1Iii2 = IL1Iii(I1I.digest());
        }
        return IL1Iii2;
    }

    public static String getFileMD5String(FileInputStream fileInputStream) {
        String IL1Iii2;
        synchronized (MD5Util.class) {
            I1I.update(fileInputStream.getChannel().map(MapMode.READ_ONLY, 0, (long) fileInputStream.available()));
            IL1Iii2 = IL1Iii(I1I.digest());
        }
        return IL1Iii2;
    }

    public static String getMD5String(String str) {
        return ILil(str.getBytes());
    }
}
