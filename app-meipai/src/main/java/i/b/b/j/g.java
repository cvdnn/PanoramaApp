package i.b.b.j;

import i.b.b.a;
import i.b.b.d;
import i.b.b.f;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: WhereCollector */
public class g<T> {

    /* renamed from: a reason: collision with root package name */
    public final a<T, ?> f9863a;

    /* renamed from: b reason: collision with root package name */
    public final List<h> f9864b = new ArrayList();

    public g(a<T, ?> aVar, String str) {
        this.f9863a = aVar;
    }

    public void a(f fVar) {
        a<T, ?> aVar = this.f9863a;
        if (aVar != null) {
            f[] fVarArr = aVar.f9787a.f9814c;
            int length = fVarArr.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (fVar == fVarArr[i2]) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                StringBuilder a2 = e.a.a.a.a.a("Property '");
                a2.append(fVar.f9800c);
                a2.append("' is not part of ");
                a2.append(this.f9863a);
                throw new d(a2.toString());
            }
        }
    }

    public void a(StringBuilder sb, String str, List<Object> list) {
        ListIterator listIterator = this.f9864b.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                sb.append(" AND ");
            }
            h hVar = (h) listIterator.next();
            hVar.a(sb, str);
            hVar.a(list);
        }
    }
}
