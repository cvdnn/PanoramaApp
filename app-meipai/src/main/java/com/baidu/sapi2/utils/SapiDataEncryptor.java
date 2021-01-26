package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import e.c.b.e.Utils;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import org.json.JSONArray;

public class SapiDataEncryptor implements NoProguard {

    /* renamed from: a reason: collision with root package name */
    public static final String f3003a = "0123456789ABCDEF";

    /* renamed from: b reason: collision with root package name */
    public String f3004b = a();

    /* renamed from: c reason: collision with root package name */
    public AES f3005c = new AES();

    public static class a {

        /* renamed from: a reason: collision with root package name */
        public static final int f3006a = 1;

        /* renamed from: b reason: collision with root package name */
        public static final String f3007b = "-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----";
    }

    private byte[] a(Key key, byte[] bArr) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    public static String byteToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = (b2 >> 4) & 15;
            String str = f3003a;
            sb.append(str.charAt(i2));
            sb.append(str.charAt(b2 & 15));
        }
        return sb.toString();
    }

    public static String decryptAccountInfo(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str3 = new String(Utils.a(new AES().decrypt(Utils.a(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2)), "UTF-8").trim();
        } catch (Throwable th) {
            Log.e(Log.TAG, th.toString());
            str3 = "";
        }
        return str3;
    }

    public static String encryptAccountInfo(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str3 = Utils.b(new AES().encrypt(Utils.b(str.getBytes()), new StringBuffer(str2).reverse().toString(), str2));
        } catch (Throwable th) {
            Log.e(Log.TAG, th.toString());
            str3 = "";
        }
        return str3;
    }

    public static byte[] hexToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
        }
        return bArr;
    }

    public String decrypt(String str) throws Exception {
        return new String(this.f3005c.decrypt(Utils.a(str.getBytes()), new StringBuffer(this.f3004b).reverse().toString(), this.f3004b), "UTF-8");
    }

    public String encrypt(String str, String str2) throws CertificateException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        int i2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        PublicKey publicKey = X509Certificate.getInstance(new ByteArrayInputStream(str.getBytes())).getPublicKey();
        JSONArray jSONArray = new JSONArray();
        String str3 = "UTF-8";
        byte[] bytes = str2.getBytes(str3);
        if (bytes.length % 116 == 0) {
            i2 = bytes.length / 116;
        } else {
            i2 = (bytes.length / 116) + 1;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (1 == i2) {
                jSONArray.put(Utils.b(a(publicKey, bytes)));
            } else if (i3 != i2 - 1) {
                byte[] bArr = new byte[116];
                System.arraycopy(bytes, i3 * 116, bArr, 0, 116);
                jSONArray.put(Utils.b(a(publicKey, bArr)));
            } else {
                int i4 = i3 * 116;
                int length = bytes.length - i4;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bytes, i4, bArr2, 0, length);
                jSONArray.put(Utils.b(a(publicKey, bArr2)));
            }
        }
        return Utils.b(jSONArray.toString().getBytes(str3));
    }

    public String getAESKey() {
        return this.f3004b;
    }

    private String a() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 16; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        return sb.toString();
    }
}
