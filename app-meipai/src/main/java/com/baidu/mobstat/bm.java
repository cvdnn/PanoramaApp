package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.sapi2.utils.h;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class bm {

    public static class a {
        @SuppressLint({"TrulyRandom"})
        public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            Cipher instance = Cipher.getInstance(h.p);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr3);
        }

        public static byte[] b() {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }

        public static String b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            String str = "|";
            try {
                byte[] a2 = a(bArr, bArr2, bs.a(bArr3));
                StringBuilder sb = new StringBuilder();
                sb.append(bp.b(a2));
                sb.append(str);
                sb.append(bv.a(bArr));
                sb.append(str);
                sb.append(bv.a(bArr2));
                return sb.toString();
            } catch (Exception unused) {
                return "";
            }
        }

        public static byte[] a() throws Exception {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128, new SecureRandom());
            return instance.generateKey().getEncoded();
        }

        public static String a(byte[] bArr) {
            try {
                return b(a(), b(), bArr);
            } catch (Exception unused) {
                return "";
            }
        }
    }

    public static class b {
        public static byte[] a(int i2, byte[] bArr) throws Exception {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                String[] strArr = br.f1764a;
                if (strArr.length > i3) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), "AES");
                    Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    instance.init(1, secretKeySpec);
                    return instance.doFinal(bArr);
                }
            }
            return new byte[0];
        }

        public static byte[] b(int i2, byte[] bArr) throws Exception {
            int i3 = i2 - 1;
            if (i3 >= 0) {
                String[] strArr = br.f1764a;
                if (strArr.length > i3) {
                    SecretKeySpec secretKeySpec = new SecretKeySpec(strArr[i3].getBytes(), "AES");
                    Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    instance.init(2, secretKeySpec);
                    return instance.doFinal(bArr);
                }
            }
            return new byte[0];
        }

        public static String c(int i2, byte[] bArr) {
            try {
                return bp.b(a(i2, bArr));
            } catch (Exception unused) {
                return "";
            }
        }

        public static String d(int i2, byte[] bArr) {
            String c2 = c(i2, bArr);
            if (TextUtils.isEmpty(c2)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(c2);
            sb.append("|");
            sb.append(i2);
            return sb.toString();
        }
    }
}
