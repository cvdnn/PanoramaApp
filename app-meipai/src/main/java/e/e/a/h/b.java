package e.e.a.h;

import e.e.a.c.a;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: BleLruHashMap */
public class b<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: a reason: collision with root package name */
    public final int f8025a;

    public b(int i2) {
        super(((int) Math.ceil(((double) i2) / 0.75d)) + 1, 0.75f, true);
        this.f8025a = i2;
    }

    public boolean removeEldestEntry(Entry entry) {
        if (size() > this.f8025a && (entry.getValue() instanceof a)) {
            ((a) entry.getValue()).c();
        }
        return size() > this.f8025a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : entrySet()) {
            sb.append(String.format("%s:%s ", new Object[]{entry.getKey(), entry.getValue()}));
        }
        return sb.toString();
    }
}
