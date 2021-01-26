package g;

import g.d0.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: Headers */
public final class q {

    /* renamed from: a reason: collision with root package name */
    public final String[] f9532a;

    /* compiled from: Headers */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public final List<String> f9533a = new ArrayList(20);

        public a a(String str, String str2) {
            this.f9533a.add(str);
            this.f9533a.add(str2.trim());
            return this;
        }

        public final void b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (!str.isEmpty()) {
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    int i3 = 0;
                    while (i3 < length2) {
                        char charAt2 = str2.charAt(i3);
                        if ((charAt2 > 31 || charAt2 == 9) && charAt2 < 127) {
                            i3++;
                        } else {
                            throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                        }
                    }
                    return;
                }
                throw new NullPointerException(e.a.a.a.a.a("value for name ", str, " == null"));
            } else {
                throw new IllegalArgumentException("name is empty");
            }
        }

        public a a(String str) {
            int i2 = 0;
            while (i2 < this.f9533a.size()) {
                if (str.equalsIgnoreCase((String) this.f9533a.get(i2))) {
                    this.f9533a.remove(i2);
                    this.f9533a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }
    }

    public q(a aVar) {
        List<String> list = aVar.f9533a;
        this.f9532a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(String str) {
        String[] strArr = this.f9532a;
        int length = strArr.length;
        do {
            length -= 2;
            if (length < 0) {
                return null;
            }
        } while (!str.equalsIgnoreCase(strArr[length]));
        return strArr[length + 1];
    }

    public int b() {
        return this.f9532a.length / 2;
    }

    public Map<String, List<String>> c() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            String lowerCase = a(i2).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(b(i2));
        }
        return treeMap;
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && Arrays.equals(((q) obj).f9532a, this.f9532a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f9532a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String b(int i2) {
        return this.f9532a[(i2 * 2) + 1];
    }

    public List<String> b(String str) {
        int b2 = b();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < b2; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String a(int i2) {
        return this.f9532a[i2 * 2];
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f9533a, this.f9532a);
        return aVar;
    }
}
