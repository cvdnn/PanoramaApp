package g.d0.h;

import java.io.IOException;

/* compiled from: StreamResetException */
public final class t extends IOException {

    /* renamed from: a reason: collision with root package name */
    public final b f9435a;

    public t(b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("stream was reset: ");
        sb.append(bVar);
        super(sb.toString());
        this.f9435a = bVar;
    }
}
