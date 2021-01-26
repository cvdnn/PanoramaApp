package e.e.a.h;

/* compiled from: HexUtil */
public class c {
    public static String a(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('0');
                sb2.append(hexString);
                hexString = sb2.toString();
            }
            sb.append(hexString);
            if (z) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
