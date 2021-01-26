package e.d.a.n.n;

/* compiled from: CallbackException */
public final class c extends RuntimeException {
    public c(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
