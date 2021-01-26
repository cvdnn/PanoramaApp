package e.d.a.n.o;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: LazyHeaders */
public final class j implements h {

    /* renamed from: b reason: collision with root package name */
    public final Map<String, List<i>> f7562b;

    /* renamed from: c reason: collision with root package name */
    public volatile Map<String, String> f7563c;

    /* compiled from: LazyHeaders */
    public static final class a {

        /* renamed from: b reason: collision with root package name */
        public static final String f7564b;

        /* renamed from: c reason: collision with root package name */
        public static final Map<String, List<i>> f7565c;

        /* renamed from: a reason: collision with root package name */
        public Map<String, List<i>> f7566a = f7565c;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = property.charAt(i2);
                    if ((charAt > 31 || charAt == 9) && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            f7564b = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f7564b)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f7564b)));
            }
            f7565c = Collections.unmodifiableMap(hashMap);
        }
    }

    /* compiled from: LazyHeaders */
    public static final class b implements i {

        /* renamed from: a reason: collision with root package name */
        public final String f7567a;

        public b(String str) {
            this.f7567a = str;
        }

        public String a() {
            return this.f7567a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return this.f7567a.equals(((b) obj).f7567a);
        }

        public int hashCode() {
            return this.f7567a.hashCode();
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("StringHeaderFactory{value='");
            a2.append(this.f7567a);
            a2.append('\'');
            a2.append('}');
            return a2.toString();
        }
    }

    public j(Map<String, List<i>> map) {
        this.f7562b = Collections.unmodifiableMap(map);
    }

    public Map<String, String> a() {
        if (this.f7563c == null) {
            synchronized (this) {
                if (this.f7563c == null) {
                    this.f7563c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f7563c;
    }

    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Entry entry : this.f7562b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String a2 = ((i) list.get(i2)).a();
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2);
                    if (i2 != list.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        return this.f7562b.equals(((j) obj).f7562b);
    }

    public int hashCode() {
        return this.f7562b.hashCode();
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("LazyHeaders{headers=");
        a2.append(this.f7562b);
        a2.append('}');
        return a2.toString();
    }
}
