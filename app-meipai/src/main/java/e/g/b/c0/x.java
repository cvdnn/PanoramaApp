package e.g.b.c0;

/* compiled from: UnsafeAllocator */
public final class x extends y {
    public <T> T a(Class<T> cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot allocate ");
        sb.append(cls);
        throw new UnsupportedOperationException(sb.toString());
    }
}
