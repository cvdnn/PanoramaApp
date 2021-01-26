package e.i.a.h.i;

import java.io.IOException;

/* compiled from: ServerCanceledException */
public class i extends IOException {
    public i(int i2, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Response code can't handled on internal ");
        sb.append(i2);
        sb.append(" with current offset ");
        sb.append(j2);
        super(sb.toString());
    }
}
