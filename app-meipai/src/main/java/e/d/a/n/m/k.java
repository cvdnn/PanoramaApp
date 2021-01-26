package e.d.a.n.m;

import com.baidubce.services.bos.BosClientConfiguration;
import e.d.a.n.n.c0.b;
import e.d.a.n.p.c.w;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: InputStreamRewinder */
public final class k implements e<InputStream> {

    /* renamed from: a reason: collision with root package name */
    public final w f7257a;

    /* compiled from: InputStreamRewinder */
    public static final class a implements e.d.a.n.m.e.a<InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final b f7258a;

        public a(b bVar) {
            this.f7258a = bVar;
        }

        public e a(Object obj) {
            return new k((InputStream) obj, this.f7258a);
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, b bVar) {
        w wVar = new w(inputStream, bVar);
        this.f7257a = wVar;
        wVar.mark(BosClientConfiguration.DEFAULT_STREAM_BUFFER_SIZE);
    }

    public void b() {
        this.f7257a.b();
    }

    public InputStream a() throws IOException {
        this.f7257a.reset();
        return this.f7257a;
    }
}
