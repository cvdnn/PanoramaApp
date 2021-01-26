package e.c.d.d.f;

import android.database.Observable;
import java.util.Iterator;

import e.c.d.d.e.ThreadPoolService;

/* compiled from: Notifier */
public class b<T> extends Observable<T> {

    /* compiled from: Notifier */
    public interface Notifier<T> {
        void a(T t);
    }

    public boolean contains(T t) {
        return this.mObservers.contains(t);
    }

    /* renamed from: b */
    public void observable(Notifier<T> notifierVar) {
        synchronized (this.mObservers) {
            Iterator it = this.mObservers.iterator();
            while (it.hasNext()) {
                notifierVar.a(it.next());
            }
        }
    }

    public void c(Notifier<T> notifierVar) {
        ThreadPoolService.post(new Notifier(this, notifierVar));
    }
}
