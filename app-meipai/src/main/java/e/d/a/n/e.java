package e.d.a.n;

import e.a.a.a.a;
import java.io.IOException;

/* compiled from: HttpException */
public final class e extends IOException {
    public e(int i2) {
        super(a.a("Http request failed with status code: ", i2), null);
    }

    public e(String str) {
        super(str, null);
    }

    public e(String str, int i2) {
        super(str, null);
    }
}
