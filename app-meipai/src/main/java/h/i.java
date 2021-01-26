package h;

import java.io.IOException;

/* compiled from: ForwardingSink */
public abstract class i implements w {

    /* renamed from: a reason: collision with root package name */
    public final w f9654a;

    public i(w wVar) {
        if (wVar != null) {
            this.f9654a = wVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.f9654a.close();
    }

    public void flush() throws IOException {
        this.f9654a.flush();
    }

    public y timeout() {
        return this.f9654a.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f9654a.toString());
        sb.append(")");
        return sb.toString();
    }
}
