package d.h.d;

import android.util.Log;

/* compiled from: ActivityRecreator */
public final class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Object f4785a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ Object f4786b;

    public c(Object obj, Object obj2) {
        this.f4785a = obj;
        this.f4786b = obj2;
    }

    public void run() {
        try {
            if (b.f4772d != null) {
                b.f4772d.invoke(this.f4785a, new Object[]{this.f4786b, Boolean.valueOf(false), "AppCompat recreation"});
                return;
            }
            b.f4773e.invoke(this.f4785a, new Object[]{this.f4786b, Boolean.valueOf(false)});
        } catch (RuntimeException e2) {
            if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                throw e2;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
