package com.baidu.pass.biometrics.base.utils;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    public static final String DEFAULT_ALGORITHM = "AES";
    public static final String DEFAULT_ALGORITHM_MODE = "AES/CBC/NoPadding";
    public static final String DEFAULT_ENCODING = "UTF-8";
    public String algorithm;
    public String algorithmMode;
    public String encoding;

    public AES() {
        this("AES", "AES/CBC/NoPadding", "UTF-8");
    }

    public static String padString(String str) {
        int length = 16 - (str.getBytes().length % 16);
        for (int i2 = 0; i2 < length; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(' ');
            str = sb.toString();
        }
        return str;
    }

    public byte[] decrypt(byte[] bArr, String str, String str2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.encoding));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.algorithm);
            Cipher instance = Cipher.getInstance(this.algorithmMode);
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public byte[] encrypt(String str, String str2, String str3) throws Exception {
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.encoding));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.algorithm);
            Cipher instance = Cipher.getInstance(this.algorithmMode);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(padString(str).getBytes());
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.encoding = "UTF-8";
        this.algorithmMode = "AES/CBC/NoPadding";
        this.algorithm = "AES";
        this.algorithm = str;
        this.algorithmMode = str2;
        this.encoding = str3;
    }
}
