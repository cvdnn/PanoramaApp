package h;

import e.a.a.a.a;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio */
public final class p extends c {
    public final /* synthetic */ Socket k;

    public p(Socket socket) {
        this.k = socket;
    }

    public IOException a(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    public void h() {
        String str = "Failed to close timed out socket ";
        try {
            this.k.close();
        } catch (Exception e2) {
            Logger logger = o.f9667a;
            Level level = Level.WARNING;
            StringBuilder a2 = a.a(str);
            a2.append(this.k);
            logger.log(level, a2.toString(), e2);
        } catch (AssertionError e3) {
            if (o.a(e3)) {
                Logger logger2 = o.f9667a;
                Level level2 = Level.WARNING;
                StringBuilder a3 = a.a(str);
                a3.append(this.k);
                logger2.log(level2, a3.toString(), e3);
                return;
            }
            throw e3;
        }
    }
}
