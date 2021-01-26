package d.p;

/* compiled from: ViewModelProvider */
public abstract class s implements r {
    public <T extends q> T a(Class<T> cls) {
        throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }

    public abstract <T extends q> T a(String str, Class<T> cls);
}
