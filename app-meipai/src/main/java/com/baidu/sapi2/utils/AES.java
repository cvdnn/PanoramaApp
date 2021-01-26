package com.baidu.sapi2.utils;

import com.baidu.sapi2.NoProguard;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static final String f2997a = "UTF-8";

    /* renamed from: b reason: collision with root package name */
    public static final String f2998b = "AES/CBC/NoPadding";

    /* renamed from: c reason: collision with root package name */
    public static final String f2999c = "AES";

    /* renamed from: d reason: collision with root package name */
    public String f3000d;

    /* renamed from: e reason: collision with root package name */
    public String f3001e;

    /* renamed from: f reason: collision with root package name */
    public String f3002f;

    public AES() {
        this("AES", "AES/CBC/NoPadding", "UTF-8");
    }

    public static String a(String str) {
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
        byte[] bArr2 = new byte[0];
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes(this.f3000d));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), this.f3002f);
            Cipher instance = Cipher.getInstance(this.f3001e);
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (Throwable th) {
            Log.e(Log.TAG, th.toString());
            return bArr2;
        }
    }

    public byte[] encrypt(String str, String str2, String str3) throws Exception {
        String str4 = Log.TAG;
        if (str == null || str.length() == 0) {
            throw new Exception("Empty string");
        }
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes(this.f3000d));
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), this.f3002f);
            Cipher instance = Cipher.getInstance(this.f3001e);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(a(str).getBytes());
        } catch (NoSuchAlgorithmException e2) {
            Log.e(str4, e2.toString());
            return null;
        } catch (NoSuchPaddingException e3) {
            Log.e(str4, e3.toString());
            return null;
        }
    }

    public AES(String str, String str2) {
        this(str, str2, "UTF-8");
    }

    public AES(String str, String str2, String str3) {
        this.f3000d = "UTF-8";
        this.f3001e = "AES/CBC/NoPadding";
        this.f3002f = "AES";
        this.f3002f = str;
        this.f3001e = str2;
        this.f3000d = str3;
    }
}
