package e.i.a.h.f;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadConnection */
public interface a {

    /* renamed from: e.i.a.h.f.a$a reason: collision with other inner class name */
    /* compiled from: DownloadConnection */
    public interface C0121a {
        String a();

        String a(String str);

        InputStream b() throws IOException;

        Map<String, List<String>> c();

        int f() throws IOException;
    }

    /* compiled from: DownloadConnection */
    public interface b {
        a a(String str) throws IOException;
    }

    void a(String str, String str2);

    boolean b(String str) throws ProtocolException;

    C0121a d() throws IOException;

    Map<String, List<String>> e();

    void release();
}
