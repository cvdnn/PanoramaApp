package i.a.a.a;

import e.c.f.n.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: CommandLine */
public class b implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public List f9695a = new LinkedList();

    /* renamed from: b reason: collision with root package name */
    public List f9696b = new ArrayList();

    public boolean a(String str) {
        i iVar;
        List list = this.f9696b;
        String d2 = n.d(str);
        Iterator it = this.f9696b.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            iVar = (i) it.next();
            if (!d2.equals(iVar.f9707a)) {
                if (d2.equals(iVar.f9708b)) {
                    break;
                }
            } else {
                break;
            }
        }
        return list.contains(iVar);
    }
}
