package d.p;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Lifecycle */
public abstract class e {

    /* compiled from: Lifecycle */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* compiled from: Lifecycle */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public e() {
        new AtomicReference();
    }

    public abstract void a(g gVar);
}
