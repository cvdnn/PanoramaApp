package g;

import com.baidu.mobstat.Config;
import e.a.a.a.a;
import java.io.IOException;

/* compiled from: Protocol */
public enum v {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(Config.EVENT_NATIVE_VIEW_HIERARCHY);
    

    /* renamed from: a reason: collision with root package name */
    public final String f9586a;

    /* access modifiers changed from: public */
    v(String str) {
        this.f9586a = str;
    }

    public static v a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f9586a)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f9586a)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f9586a)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f9586a)) {
            return SPDY_3;
        }
        throw new IOException(a.a("Unexpected protocol: ", str));
    }

    public String toString() {
        return this.f9586a;
    }
}
