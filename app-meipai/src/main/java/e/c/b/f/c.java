package e.c.b.f;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public final class c {
    public static String a(String str) {
        byte[] bytes = str.getBytes();
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDcNo7OFl4AMWXHXHQ/Uyr5Qwmi1EJXbxtkWHQPiT3tBxAgCApZyZXI8Sc0L+g2e3csrK+Mi/uD0W7AFmxdqSunmbiCEP4N8o5+X8NyREPRofM8cfFtIY/kHemCWR65V69FLv++/tPp5DlJQaHERWIvWL5aJXNGhUNzqUQMjRzEPwIDAQAB", 0));
        KeyFactory instance = KeyFactory.getInstance("RSA");
        a.c(instance.getProvider().toString());
        PublicKey generatePublic = instance.generatePublic(x509EncodedKeySpec);
        Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance2.init(1, generatePublic);
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = length - i2;
            if (i4 > 0) {
                byte[] doFinal = i4 > 117 ? instance2.doFinal(bytes, i2, 117) : instance2.doFinal(bytes, i2, i4);
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i3++;
                i2 = i3 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }
}
