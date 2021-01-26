package i.b.b.i;

import com.baidu.sapi2.utils.SapiDataEncryptor;
import i.b.b.f;

/* compiled from: SqlUtils */
public class d {
    static {
        SapiDataEncryptor.f3003a.toCharArray();
    }

    public static StringBuilder a(StringBuilder sb, String str, f fVar) {
        if (str != null) {
            sb.append(str);
            sb.append('.');
        }
        sb.append('\"');
        sb.append(fVar.f9802e);
        sb.append('\"');
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str2 = strArr[i2];
            sb.append(str);
            sb.append(".\"");
            sb.append(str2);
            sb.append('\"');
            sb.append("=?");
            if (i2 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String a(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append('\"');
        sb.append(str2);
        sb.append('\"');
        sb.append(" (");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append('\"');
            sb.append(strArr[i2]);
            sb.append('\"');
            if (i2 < length - 1) {
                sb.append(',');
            }
        }
        sb.append(") VALUES (");
        int length2 = strArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (i3 < length2 - 1) {
                sb.append("?,");
            } else {
                sb.append('?');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static String a(String str, String str2, String[] strArr, boolean z) {
        if (str2 == null || str2.length() < 0) {
            throw new i.b.b.d("Table alias required");
        }
        StringBuilder sb = new StringBuilder(z ? "SELECT DISTINCT " : "SELECT ");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str3 = strArr[i2];
            sb.append(str2);
            sb.append(".\"");
            sb.append(str3);
            sb.append('\"');
            if (i2 < length - 1) {
                sb.append(',');
            }
        }
        sb.append(" FROM ");
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        sb.append(' ');
        sb.append(str2);
        sb.append(' ');
        return sb.toString();
    }

    public static String a(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("DELETE FROM ");
        sb3.append(sb2);
        if (strArr != null && strArr.length > 0) {
            sb3.append(" WHERE ");
            a(sb3, sb2, strArr);
        }
        return sb3.toString();
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder("UPDATE ");
        sb3.append(sb2);
        sb3.append(" SET ");
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str2 = strArr[i2];
            sb3.append('\"');
            sb3.append(str2);
            sb3.append('\"');
            sb3.append("=?");
            if (i2 < strArr.length - 1) {
                sb3.append(',');
            }
        }
        sb3.append(" WHERE ");
        a(sb3, sb2, strArr2);
        return sb3.toString();
    }
}
