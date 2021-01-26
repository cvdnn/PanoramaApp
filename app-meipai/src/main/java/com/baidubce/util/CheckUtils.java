package com.baidubce.util;

public class CheckUtils {
    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static String format(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        StringBuilder sb = new StringBuilder((objArr.length * 16) + valueOf.length());
        int i2 = 0;
        int i3 = 0;
        while (i2 < objArr.length) {
            int indexOf = valueOf.indexOf("%s", i3);
            if (indexOf == -1) {
                break;
            }
            sb.append(valueOf.substring(i3, indexOf));
            int i4 = i2 + 1;
            sb.append(objArr[i2]);
            int i5 = i4;
            i3 = indexOf + 2;
            i2 = i5;
        }
        sb.append(valueOf.substring(i3));
        if (i2 < objArr.length) {
            sb.append(" [");
            int i6 = i2 + 1;
            sb.append(objArr[i2]);
            while (i6 < objArr.length) {
                sb.append(", ");
                int i7 = i6 + 1;
                sb.append(objArr[i6]);
                i6 = i7;
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static <T> void isNotNull(T t, String str) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(str));
        }
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(format(str, objArr));
        }
    }

    public static <T> T isNotNull(T t, String str, Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(format(str, objArr));
    }
}
