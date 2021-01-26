package e.g.b;

import e.g.b.e0.a;
import e.g.b.e0.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: Gson */
public final class i extends z<AtomicLongArray> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ z f8571a;

    public i(z zVar) {
        this.f8571a = zVar;
    }

    public void a(c cVar, Object obj) throws IOException {
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        cVar.b();
        int length = atomicLongArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            this.f8571a.a(cVar, Long.valueOf(atomicLongArray.get(i2)));
        }
        cVar.e();
    }

    public Object a(a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.q()) {
            arrayList.add(Long.valueOf(((Number) this.f8571a.a(aVar)).longValue()));
        }
        aVar.i();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
        }
        return atomicLongArray;
    }
}
