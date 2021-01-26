package e.c.b.e;

import e.c.b.f.a;
import java.io.IOException;

public final class g implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Process f5905a;

    public g(Process process) {
        this.f5905a = process;
    }

    public final void run() {
        try {
            do {
            } while (this.f5905a.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e2) {
            a.a("dummy", e2);
        }
    }
}
