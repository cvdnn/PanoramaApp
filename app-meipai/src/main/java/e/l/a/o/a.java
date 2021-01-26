package e.l.a.o;

import com.baidu.sapi2.utils.SapiDataEncryptor;

/* compiled from: StringUtils */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final char[] f8976a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        char[] charArray = str.toCharArray();
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            char c2 = charArray[i3];
            String str2 = SapiDataEncryptor.f3003a;
            bArr[i2] = (byte) ((str2.indexOf(charArray[i3 + 1]) + (str2.indexOf(c2) * 16)) & 255);
        }
        return new String(bArr);
    }
}
