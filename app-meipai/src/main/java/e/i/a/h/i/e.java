package e.i.a.h.i;

import e.a.a.a.a;
import java.io.IOException;

/* compiled from: PreAllocateException */
public class e extends IOException {
    public e(long j2, long j3) {
        StringBuilder a2 = a.a("There is Free space less than Require space: ", j3, " < ");
        a2.append(j2);
        super(a2.toString());
    }
}
