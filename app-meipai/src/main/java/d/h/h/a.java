package d.h.h;

import android.util.Base64;
import java.util.List;

/* compiled from: FontRequest */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public final String f4826a;

    /* renamed from: b reason: collision with root package name */
    public final String f4827b;

    /* renamed from: c reason: collision with root package name */
    public final String f4828c;

    /* renamed from: d reason: collision with root package name */
    public final List<List<byte[]>> f4829d;

    /* renamed from: e reason: collision with root package name */
    public final int f4830e;

    /* renamed from: f reason: collision with root package name */
    public final String f4831f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        if (str != null) {
            this.f4826a = str;
            if (str2 != null) {
                this.f4827b = str2;
                if (str3 != null) {
                    this.f4828c = str3;
                    if (list != null) {
                        this.f4829d = list;
                        this.f4830e = 0;
                        StringBuilder sb = new StringBuilder(str);
                        String str4 = "-";
                        sb.append(str4);
                        sb.append(this.f4827b);
                        sb.append(str4);
                        sb.append(this.f4828c);
                        this.f4831f = sb.toString();
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder a2 = e.a.a.a.a.a("FontRequest {mProviderAuthority: ");
        a2.append(this.f4826a);
        a2.append(", mProviderPackage: ");
        a2.append(this.f4827b);
        a2.append(", mQuery: ");
        a2.append(this.f4828c);
        a2.append(", mCertificates:");
        sb.append(a2.toString());
        for (int i2 = 0; i2 < this.f4829d.size(); i2++) {
            sb.append(" [");
            List list = (List) this.f4829d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("mCertificatesArray: ");
        sb2.append(this.f4830e);
        sb.append(sb2.toString());
        return sb.toString();
    }
}
