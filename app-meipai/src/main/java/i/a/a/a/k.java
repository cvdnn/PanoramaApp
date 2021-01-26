package i.a.a.a;

import e.c.f.n.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Options */
public class k implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public Map f9715a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    public Map f9716b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    public List f9717c = new ArrayList();

    /* renamed from: d reason: collision with root package name */
    public Map f9718d = new HashMap();

    public k a(i iVar) {
        String a2 = iVar.a();
        if (iVar.f9708b != null) {
            this.f9716b.put(iVar.f9708b, iVar);
        }
        this.f9715a.put(a2, iVar);
        return this;
    }

    public boolean b(String str) {
        String d2 = n.d(str);
        return this.f9715a.containsKey(d2) || this.f9716b.containsKey(d2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.f9715a.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.f9716b);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public i a(String str) {
        String d2 = n.d(str);
        if (this.f9715a.containsKey(d2)) {
            return (i) this.f9715a.get(d2);
        }
        return (i) this.f9716b.get(d2);
    }
}
