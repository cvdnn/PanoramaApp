package e.c.b.e;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class f {

    /* renamed from: a reason: collision with root package name */
    public static String f5903a;

    /* renamed from: b reason: collision with root package name */
    public static Context f5904b;

    public static String a(String str) {
        byte b2;
        if (TextUtils.isEmpty(str)) {
            return "N/A";
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (messageDigest == null) {
            return str;
        }
        try {
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < digest.length; i2++) {
                if (Integer.toHexString(digest[i2] & 255).length() == 1) {
                    stringBuffer.append("0");
                    b2 = digest[i2];
                } else {
                    b2 = digest[i2];
                }
                stringBuffer.append(Integer.toHexString(b2 & 255));
            }
            str = stringBuffer.toString();
        } catch (Exception unused) {
        }
        return str;
    }
}
