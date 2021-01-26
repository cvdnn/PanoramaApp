package d.t;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import d.t.i.c;
import d.t.i.d;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionSet */
public class o extends i {
    public ArrayList<i> I = new ArrayList<>();
    public boolean J = true;
    public int K;
    public boolean L = false;
    public int M = 0;

    /* compiled from: TransitionSet */
    public class a extends l {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ i f5508a;

        public a(o oVar, i iVar) {
            this.f5508a = iVar;
        }

        public void c(i iVar) {
            this.f5508a.c();
            iVar.b((d) this);
        }
    }

    /* compiled from: TransitionSet */
    public static class b extends l {

        /* renamed from: a reason: collision with root package name */
        public o f5509a;

        public b(o oVar) {
            this.f5509a = oVar;
        }

        public void a(i iVar) {
            o oVar = this.f5509a;
            if (!oVar.L) {
                oVar.e();
                this.f5509a.L = true;
            }
        }

        public void c(i iVar) {
            o oVar = this.f5509a;
            int i2 = oVar.K - 1;
            oVar.K = i2;
            if (i2 == 0) {
                oVar.L = false;
                oVar.a();
            }
            iVar.b((d) this);
        }
    }

    public o a(i iVar) {
        this.I.add(iVar);
        iVar.r = this;
        long j2 = this.f5485c;
        if (j2 >= 0) {
            iVar.a(j2);
        }
        if ((this.M & 1) != 0) {
            iVar.a(this.f5486d);
        }
        if ((this.M & 2) != 0) {
            iVar.a((n) null);
        }
        if ((this.M & 4) != 0) {
            iVar.a(this.E);
        }
        if ((this.M & 8) != 0) {
            iVar.a(this.D);
        }
        return this;
    }

    public o b(int i2) {
        if (i2 == 0) {
            this.J = true;
        } else if (i2 == 1) {
            this.J = false;
        } else {
            throw new AndroidRuntimeException(e.a.a.a.a.a("Invalid parameter for TransitionSet ordering: ", i2));
        }
        return this;
    }

    public void c() {
        if (this.I.isEmpty()) {
            e();
            a();
            return;
        }
        b bVar = new b(this);
        Iterator it = this.I.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a((d) bVar);
        }
        this.K = this.I.size();
        if (!this.J) {
            for (int i2 = 1; i2 < this.I.size(); i2++) {
                ((i) this.I.get(i2 - 1)).a((d) new a(this, (i) this.I.get(i2)));
            }
            i iVar = (i) this.I.get(0);
            if (iVar != null) {
                iVar.c();
            }
        } else {
            Iterator it2 = this.I.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).c();
            }
        }
    }

    public void cancel() {
        super.cancel();
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((i) this.I.get(i2)).cancel();
        }
    }

    public i d(View view) {
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            ((i) this.I.get(i2)).d(view);
        }
        this.f5488f.remove(view);
        return this;
    }

    public void e(View view) {
        super.e(view);
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((i) this.I.get(i2)).e(view);
        }
    }

    public i clone() {
        o oVar = (o) super.clone();
        oVar.I = new ArrayList<>();
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            i clone = ((i) this.I.get(i2)).clone();
            oVar.I.add(clone);
            clone.r = oVar;
        }
        return oVar;
    }

    public i b(long j2) {
        this.f5484b = j2;
        return this;
    }

    public i b(d dVar) {
        super.b(dVar);
        return this;
    }

    public void b(q qVar) {
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((i) this.I.get(i2)).b(qVar);
        }
    }

    public i a(int i2) {
        if (i2 < 0 || i2 >= this.I.size()) {
            return null;
        }
        return (i) this.I.get(i2);
    }

    public void c(q qVar) {
        if (b(qVar.f5512b)) {
            Iterator it = this.I.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.b(qVar.f5512b)) {
                    iVar.c(qVar);
                    qVar.f5513c.add(iVar);
                }
            }
        }
    }

    public i a(TimeInterpolator timeInterpolator) {
        this.M |= 1;
        ArrayList<i> arrayList = this.I;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((i) this.I.get(i2)).a(timeInterpolator);
            }
        }
        this.f5486d = timeInterpolator;
        return this;
    }

    public void c(View view) {
        super.c(view);
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((i) this.I.get(i2)).c(view);
        }
    }

    public i a(View view) {
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            ((i) this.I.get(i2)).a(view);
        }
        this.f5488f.add(view);
        return this;
    }

    public i a(d dVar) {
        super.a(dVar);
        return this;
    }

    public i a(long j2) {
        this.f5485c = j2;
        if (j2 >= 0) {
            ArrayList<i> arrayList = this.I;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((i) this.I.get(i2)).a(j2);
                }
            }
        }
        return this;
    }

    public void a(ViewGroup viewGroup, r rVar, r rVar2, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        long j2 = this.f5484b;
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = (i) this.I.get(i2);
            if (j2 > 0 && (this.J || i2 == 0)) {
                long j3 = iVar.f5484b;
                if (j3 > 0) {
                    iVar.b(j3 + j2);
                } else {
                    iVar.b(j2);
                }
            }
            iVar.a(viewGroup, rVar, rVar2, arrayList, arrayList2);
        }
    }

    public void a(q qVar) {
        if (b(qVar.f5512b)) {
            Iterator it = this.I.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (iVar.b(qVar.f5512b)) {
                    iVar.a(qVar);
                    qVar.f5513c.add(iVar);
                }
            }
        }
    }

    public String a(String str) {
        String a2 = super.a(str);
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            StringBuilder b2 = e.a.a.a.a.b(a2, "\n");
            i iVar = (i) this.I.get(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("  ");
            b2.append(iVar.a(sb.toString()));
            a2 = b2.toString();
        }
        return a2;
    }

    public void a(e eVar) {
        if (eVar == null) {
            this.E = i.G;
        } else {
            this.E = eVar;
        }
        this.M |= 4;
        if (this.I != null) {
            for (int i2 = 0; i2 < this.I.size(); i2++) {
                ((i) this.I.get(i2)).a(eVar);
            }
        }
    }

    public void a(c cVar) {
        this.D = cVar;
        this.M |= 8;
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((i) this.I.get(i2)).a(cVar);
        }
    }

    public void a(n nVar) {
        this.C = nVar;
        this.M |= 2;
        int size = this.I.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((i) this.I.get(i2)).a(nVar);
        }
    }
}
