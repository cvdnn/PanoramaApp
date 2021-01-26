package i.b.b.h;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: IdentityScopeObject */
public class c<K, T> implements a<K, T> {

    /* renamed from: a reason: collision with root package name */
    public final HashMap<K, Reference<T>> f9807a = new HashMap<>();

    /* renamed from: b reason: collision with root package name */
    public final ReentrantLock f9808b = new ReentrantLock();

    public T a(K k) {
        Reference reference = (Reference) this.f9807a.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public void a(int i2) {
    }

    public T get(K k) {
        this.f9808b.lock();
        try {
            Reference reference = (Reference) this.f9807a.get(k);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.f9808b.unlock();
        }
    }

    public void lock() {
        this.f9808b.lock();
    }

    public void put(K k, T t) {
        this.f9808b.lock();
        try {
            this.f9807a.put(k, new WeakReference(t));
        } finally {
            this.f9808b.unlock();
        }
    }

    public void remove(K k) {
        this.f9808b.lock();
        try {
            this.f9807a.remove(k);
        } finally {
            this.f9808b.unlock();
        }
    }

    public void unlock() {
        this.f9808b.unlock();
    }

    public void a(K k, T t) {
        this.f9807a.put(k, new WeakReference(t));
    }
}
