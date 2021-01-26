package j.a.a.a;

import java.util.Comparator;

public class b implements Comparator<String> {

    /* renamed from: a reason: collision with root package name */
    public int f9913a = 3;

    /* renamed from: a */
    public int compare(String str, String str2) {
        Long[] a2 = a(str);
        Long[] a3 = a(str2);
        for (int i2 = 0; i2 < a2.length; i2++) {
            if (a2[i2].longValue() < a3[i2].longValue()) {
                return -1;
            }
            if (a2[i2].longValue() > a3[i2].longValue()) {
                return 1;
            }
        }
        return 0;
    }

    public final Long[] a(String str) {
        int i2 = this.f9913a;
        Long[] lArr = new Long[i2];
        boolean z = str != null;
        String str2 = "v";
        if (str.contains(str2)) {
            str = str.split(str2)[1];
        }
        String[] split = str.split("\\.");
        if (split.length != i2) {
            z = false;
        }
        int i3 = 0;
        while (i3 < split.length) {
            try {
                lArr[i3] = Long.valueOf(Long.parseLong(split[i3]));
                i3++;
            } catch (Exception e2) {
                e2.printStackTrace();
                z = false;
            }
        }
        if (z) {
            return lArr;
        }
        return new Long[]{Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)};
    }
}
