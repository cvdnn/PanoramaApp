package e.i.a.h.k;

import android.os.SystemClock;
import e.i.a.c;
import e.i.a.e;
import e.i.a.h.g.a;
import e.i.a.h.j.f;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FetchDataInterceptor */
public class b implements d {

    /* renamed from: a reason: collision with root package name */
    public final InputStream f8881a;

    /* renamed from: b reason: collision with root package name */
    public final byte[] f8882b;

    /* renamed from: c reason: collision with root package name */
    public final f f8883c;

    /* renamed from: d reason: collision with root package name */
    public final int f8884d;

    /* renamed from: e reason: collision with root package name */
    public final c f8885e;

    /* renamed from: f reason: collision with root package name */
    public final a f8886f = e.a().f8665b;

    public b(int i2, InputStream inputStream, f fVar, c cVar) {
        this.f8884d = i2;
        this.f8881a = inputStream;
        this.f8882b = new byte[cVar.f8655h];
        this.f8883c = fVar;
        this.f8885e = cVar;
    }

    public long a(e.i.a.h.h.f fVar) throws IOException {
        if (!fVar.f8843d.b()) {
            e.a().f8670g.a(fVar.f8841b);
            int read = this.f8881a.read(this.f8882b);
            if (read == -1) {
                return (long) read;
            }
            this.f8883c.a(this.f8884d, this.f8882b, read);
            long j2 = (long) read;
            fVar.k += j2;
            a aVar = this.f8886f;
            c cVar = this.f8885e;
            if (aVar != null) {
                long j3 = (long) cVar.p;
                if (j3 <= 0 || SystemClock.uptimeMillis() - cVar.t.get() >= j3) {
                    fVar.a();
                }
                return j2;
            }
            throw null;
        }
        throw e.i.a.h.i.c.f8856a;
    }
}
