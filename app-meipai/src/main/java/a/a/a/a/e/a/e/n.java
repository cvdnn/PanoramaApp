package a.a.a.a.e.a.e;

import a.a.a.a.e.a.e.k.b;
import a.a.a.a.e.a.e.k.i;
import a.a.a.a.e.a.i.f.d;
import a.a.a.a.e.a.i.f.e;
import a.a.a.a.e.a.i.h;
import a.a.a.a.e.a.l.f;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class n {

    /* renamed from: a reason: collision with root package name */
    public i f536a;

    /* renamed from: b reason: collision with root package name */
    public ArrayList<d> f537b;

    /* renamed from: c reason: collision with root package name */
    public b f538c;

    /* renamed from: d reason: collision with root package name */
    public f f539d = new f();

    public final void a() {
        List list;
        if (this.f536a != null) {
            this.f537b = new ArrayList<>();
            if (b()) {
                for (a.a.a.a.e.a.i.d dVar : this.f536a.getMultiViewClipList()) {
                    d dVar2 = new d();
                    i iVar = this.f536a;
                    if (iVar != null) {
                        List<h> list2 = dVar.f596c;
                        double d2 = dVar.f594a;
                        double d3 = dVar.f595b;
                        double speedFactor = iVar.getSpeedFactor();
                        int[] screenRatio = this.f536a.getScreenRatio();
                        Constraint constraint = new Constraint(0.0f, 3.1415927f, 1.5707964f, 0.0f, 1.0f, 1.0f);
                        list = f.a(list2, d2, d3, speedFactor, screenRatio, constraint, new a(this));
                    } else {
                        list = new ArrayList();
                    }
                    dVar2.a(list);
                    this.f537b.add(dVar2);
                }
            }
        }
    }

    public void b(double d2) {
        e eVar;
        List multiViewClipList = this.f536a.getMultiViewClipList();
        int i2 = 0;
        while (true) {
            if (i2 >= multiViewClipList.size()) {
                eVar = null;
                break;
            }
            a.a.a.a.e.a.i.d dVar = (a.a.a.a.e.a.i.d) multiViewClipList.get(i2);
            if (d2 >= dVar.f594a && d2 <= dVar.f595b) {
                eVar = ((d) this.f537b.get(i2)).b(d2, true);
                break;
            }
            i2++;
        }
        if (eVar == null) {
            this.f536a.getMultiViewConfig().a(this.f536a.getScreenRatio());
            throw null;
        } else {
            this.f536a.getMultiViewConfig().a(this.f536a.getScreenRatio());
            throw null;
        }
    }

    public boolean b() {
        return c() && this.f536a.getMultiViewClipList() != null && !this.f536a.getMultiViewClipList().isEmpty();
    }

    public boolean c() {
        i iVar = this.f536a;
        return (iVar == null || iVar.getFileType() != FileType.VR360 || this.f536a.getMultiViewConfig() == null) ? false : true;
    }

    public void a(i iVar, b bVar) {
        this.f536a = iVar;
        a();
        this.f538c = bVar.clone();
        if (!c()) {
            this.f539d.a(this.f538c);
        } else {
            this.f536a.getMultiViewConfig().a(this.f536a.getScreenRatio());
            throw null;
        }
    }

    public boolean a(double d2) {
        if (!b()) {
            return false;
        }
        for (a.a.a.a.e.a.i.d dVar : this.f536a.getMultiViewClipList()) {
            if (d2 >= dVar.f594a && d2 <= dVar.f595b) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ h a(h hVar, int[] iArr, Constraint constraint) {
        this.f536a.getMultiViewConfig().a(iArr);
        h clone = hVar.clone();
        Iterator it = clone.f617e.iterator();
        if (!it.hasNext()) {
            return clone;
        }
        e eVar = (e) it.next();
        throw null;
    }
}
