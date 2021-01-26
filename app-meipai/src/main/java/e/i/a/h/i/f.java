package e.i.a.h.i;

import e.i.a.h.e.b;
import java.io.IOException;

/* compiled from: ResumeFailedException */
public class f extends IOException {
    public f(b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Resume failed because of ");
        sb.append(bVar);
        super(sb.toString());
    }
}
