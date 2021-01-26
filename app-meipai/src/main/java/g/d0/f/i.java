package g.d0.f;

import e.a.a.a.a;
import g.v;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: StatusLine */
public final class i {

    /* renamed from: a reason: collision with root package name */
    public final v f9255a;

    /* renamed from: b reason: collision with root package name */
    public final int f9256b;

    /* renamed from: c reason: collision with root package name */
    public final String f9257c;

    public i(v vVar, int i2, String str) {
        this.f9255a = vVar;
        this.f9256b = i2;
        this.f9257c = str;
    }

    public static i a(String str) throws IOException {
        v vVar;
        String str2;
        int i2 = 9;
        String str3 = "Unexpected status line: ";
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException(a.a(str3, str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                vVar = v.HTTP_1_0;
            } else if (charAt == 1) {
                vVar = v.HTTP_1_1;
            } else {
                throw new ProtocolException(a.a(str3, str));
            }
        } else if (str.startsWith("ICY ")) {
            vVar = v.HTTP_1_0;
            i2 = 4;
        } else {
            throw new ProtocolException(a.a(str3, str));
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException(a.a(str3, str));
                }
                return new i(vVar, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(a.a(str3, str));
            }
        } else {
            throw new ProtocolException(a.a(str3, str));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9255a == v.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f9256b);
        if (this.f9257c != null) {
            sb.append(' ');
            sb.append(this.f9257c);
        }
        return sb.toString();
    }
}
