package e.i.a.h.i;

import java.io.IOException;

/* compiled from: InterruptException */
public class c extends IOException {

    /* renamed from: a reason: collision with root package name */
    public static final c f8856a = new a();

    /* compiled from: InterruptException */
    public static class a extends c {
        public a() {
            super(null);
        }

        public void printStackTrace() {
            throw new IllegalAccessError("Stack is ignored for signal");
        }
    }

    public /* synthetic */ c(a aVar) {
        super("Interrupted");
    }
}
