package h;

import java.io.IOException;

/* compiled from: ForwardingSource */
public abstract class j implements x {
    public final x delegate;

    public j(x xVar) {
        if (xVar != null) {
            this.delegate = xVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final x delegate() {
        return this.delegate;
    }

    public long read(e eVar, long j2) throws IOException {
        return this.delegate.read(eVar, j2);
    }

    public y timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.delegate.toString());
        sb.append(")");
        return sb.toString();
    }
}
