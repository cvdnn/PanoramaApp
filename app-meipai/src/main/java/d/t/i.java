package d.t;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import d.e.e;
import d.h.k.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Transition */
public abstract class i implements Cloneable {
    public static final int[] F = {2, 1, 3, 4};
    public static final e G = new a();
    public static ThreadLocal<d.e.a<Animator, b>> H = new ThreadLocal<>();
    public ArrayList<d> A = null;
    public ArrayList<Animator> B = new ArrayList<>();
    public n C;
    public c D;
    public e E = G;

    /* renamed from: a reason: collision with root package name */
    public String f5483a = getClass().getName();

    /* renamed from: b reason: collision with root package name */
    public long f5484b = -1;

    /* renamed from: c reason: collision with root package name */
    public long f5485c = -1;

    /* renamed from: d reason: collision with root package name */
    public TimeInterpolator f5486d = null;

    /* renamed from: e reason: collision with root package name */
    public ArrayList<Integer> f5487e = new ArrayList<>();

    /* renamed from: f reason: collision with root package name */
    public ArrayList<View> f5488f = new ArrayList<>();

    /* renamed from: g reason: collision with root package name */
    public ArrayList<String> f5489g = null;

    /* renamed from: h reason: collision with root package name */
    public ArrayList<Class<?>> f5490h = null;

    /* renamed from: i reason: collision with root package name */
    public ArrayList<Integer> f5491i = null;

    /* renamed from: j reason: collision with root package name */
    public ArrayList<View> f5492j = null;
    public ArrayList<Class<?>> k = null;
    public ArrayList<String> l = null;
    public ArrayList<Integer> m = null;
    public ArrayList<View> n = null;
    public ArrayList<Class<?>> o = null;
    public r p = new r();
    public r q = new r();
    public o r = null;
    public int[] s = F;
    public ArrayList<q> t;
    public ArrayList<q> u;
    public boolean v = false;
    public ArrayList<Animator> w = new ArrayList<>();
    public int x = 0;
    public boolean y = false;
    public boolean z = false;

    /* compiled from: Transition */
    public static class a extends e {
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    }

    /* compiled from: Transition */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public View f5493a;

        /* renamed from: b reason: collision with root package name */
        public String f5494b;

        /* renamed from: c reason: collision with root package name */
        public q f5495c;

        /* renamed from: d reason: collision with root package name */
        public f0 f5496d;

        /* renamed from: e reason: collision with root package name */
        public i f5497e;

        public b(View view, String str, i iVar, f0 f0Var, q qVar) {
            this.f5493a = view;
            this.f5494b = str;
            this.f5495c = qVar;
            this.f5496d = f0Var;
            this.f5497e = iVar;
        }
    }

    /* compiled from: Transition */
    public static abstract class c {
    }

    /* compiled from: Transition */
    public interface d {
        void a(i iVar);

        void b(i iVar);

        void c(i iVar);

        void d(i iVar);

        void e(i iVar);
    }

    public static d.e.a<Animator, b> f() {
        d.e.a<Animator, b> aVar = (d.e.a) H.get();
        if (aVar != null) {
            return aVar;
        }
        d.e.a<Animator, b> aVar2 = new d.e.a<>();
        H.set(aVar2);
        return aVar2;
    }

    public Animator a(ViewGroup viewGroup, q qVar, q qVar2) {
        return null;
    }

    public i a(long j2) {
        this.f5485c = j2;
        return this;
    }

    public abstract void a(q qVar);

    public i b(long j2) {
        this.f5484b = j2;
        return this;
    }

    public void b(q qVar) {
    }

    public String[] b() {
        return null;
    }

    public void c() {
        e();
        d.e.a f2 = f();
        Iterator it = this.B.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (f2.containsKey(animator)) {
                e();
                if (animator != null) {
                    animator.addListener(new j(this, f2));
                    long j2 = this.f5485c;
                    if (j2 >= 0) {
                        animator.setDuration(j2);
                    }
                    long j3 = this.f5484b;
                    if (j3 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.f5486d;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new k(this));
                    animator.start();
                }
            }
        }
        this.B.clear();
        a();
    }

    public abstract void c(q qVar);

    public void cancel() {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            ((Animator) this.w.get(size)).cancel();
        }
        ArrayList<d> arrayList = this.A;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.A.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((d) arrayList2.get(i2)).d(this);
            }
        }
    }

    public i d(View view) {
        this.f5488f.remove(view);
        return this;
    }

    public void e(View view) {
        if (this.y) {
            if (!this.z) {
                d.e.a f2 = f();
                int i2 = f2.f4602c;
                f0 c2 = v.c(view);
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    b bVar = (b) f2.e(i3);
                    if (bVar.f5493a != null && c2.equals(bVar.f5496d)) {
                        ((Animator) f2.c(i3)).resume();
                    }
                }
                ArrayList<d> arrayList = this.A;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.A.clone();
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((d) arrayList2.get(i4)).e(this);
                    }
                }
            }
            this.y = false;
        }
    }

    public String toString() {
        return a("");
    }

    public i a(TimeInterpolator timeInterpolator) {
        this.f5486d = timeInterpolator;
        return this;
    }

    public boolean b(View view) {
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f5491i;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList2 = this.f5492j;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList3 = this.k;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((Class) this.k.get(i2)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.l != null && m.s(view) != null && this.l.contains(view.getTransitionName())) {
            return false;
        }
        if (this.f5487e.size() == 0 && this.f5488f.size() == 0) {
            ArrayList<Class<?>> arrayList4 = this.f5490h;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                ArrayList<String> arrayList5 = this.f5489g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    return true;
                }
            }
        }
        if (this.f5487e.contains(Integer.valueOf(id)) || this.f5488f.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f5489g;
        if (arrayList6 != null && arrayList6.contains(m.s(view))) {
            return true;
        }
        if (this.f5490h != null) {
            for (int i3 = 0; i3 < this.f5490h.size(); i3++) {
                if (((Class) this.f5490h.get(i3)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public i clone() {
        try {
            i iVar = (i) super.clone();
            iVar.B = new ArrayList<>();
            iVar.p = new r();
            iVar.q = new r();
            iVar.t = null;
            iVar.u = null;
            return iVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void a(ViewGroup viewGroup, r rVar, r rVar2, ArrayList<q> arrayList, ArrayList<q> arrayList2) {
        int i2;
        Animator animator;
        q qVar;
        View view;
        q qVar2;
        Animator animator2;
        d.e.a f2 = f();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            q qVar3 = (q) arrayList.get(i3);
            q qVar4 = (q) arrayList2.get(i3);
            if (qVar3 != null && !qVar3.f5513c.contains(this)) {
                qVar3 = null;
            }
            if (qVar4 != null && !qVar4.f5513c.contains(this)) {
                qVar4 = null;
            }
            if (!(qVar3 == null && qVar4 == null)) {
                if (qVar3 == null || qVar4 == null || a(qVar3, qVar4)) {
                    Animator a2 = a(viewGroup, qVar3, qVar4);
                    if (a2 != null) {
                        if (qVar4 != null) {
                            View view2 = qVar4.f5512b;
                            String[] b2 = b();
                            if (b2 != null && b2.length > 0) {
                                qVar2 = new q(view2);
                                q qVar5 = (q) rVar2.f5514a.get(view2);
                                if (qVar5 != null) {
                                    int i4 = 0;
                                    while (i4 < b2.length) {
                                        Animator animator3 = a2;
                                        int i5 = size;
                                        q qVar6 = qVar5;
                                        qVar2.f5511a.put(b2[i4], qVar5.f5511a.get(b2[i4]));
                                        i4++;
                                        a2 = animator3;
                                        size = i5;
                                        qVar5 = qVar6;
                                    }
                                }
                                Animator animator4 = a2;
                                i2 = size;
                                int i6 = f2.f4602c;
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= i6) {
                                        animator2 = animator4;
                                        break;
                                    }
                                    b bVar = (b) f2.get((Animator) f2.c(i7));
                                    if (bVar.f5495c != null && bVar.f5493a == view2 && bVar.f5494b.equals(this.f5483a) && bVar.f5495c.equals(qVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i7++;
                                }
                            } else {
                                r rVar3 = rVar2;
                                i2 = size;
                                animator2 = a2;
                                qVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            qVar = qVar2;
                        } else {
                            r rVar4 = rVar2;
                            Animator animator5 = a2;
                            i2 = size;
                            view = qVar3.f5512b;
                            animator = animator5;
                            qVar = null;
                        }
                        if (animator != null) {
                            b bVar2 = new b(view, this.f5483a, this, v.c(viewGroup), qVar);
                            f2.put(animator, bVar2);
                            this.B.add(animator);
                        }
                        i3++;
                        size = i2;
                    }
                    r rVar5 = rVar2;
                    i2 = size;
                    i3++;
                    size = i2;
                }
            }
            ViewGroup viewGroup2 = viewGroup;
            r rVar52 = rVar2;
            i2 = size;
            i3++;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator6 = (Animator) this.B.get(sparseIntArray.keyAt(i8));
                animator6.setStartDelay(animator6.getStartDelay() + (((long) sparseIntArray.valueAt(i8)) - RecyclerView.FOREVER_NS));
            }
        }
    }

    public void e() {
        if (this.x == 0) {
            ArrayList<d> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).a(this);
                }
            }
            this.z = false;
        }
        this.x++;
    }

    public q c(View view, boolean z2) {
        o oVar = this.r;
        if (oVar != null) {
            return oVar.c(view, z2);
        }
        return (q) (z2 ? this.p : this.q).f5514a.getOrDefault(view, null);
    }

    public q b(View view, boolean z2) {
        o oVar = this.r;
        if (oVar != null) {
            return oVar.b(view, z2);
        }
        ArrayList<q> arrayList = z2 ? this.t : this.u;
        q qVar = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            q qVar2 = (q) arrayList.get(i3);
            if (qVar2 == null) {
                return null;
            }
            if (qVar2.f5512b == view) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (i2 >= 0) {
            qVar = (q) (z2 ? this.u : this.t).get(i2);
        }
        return qVar;
    }

    public void c(View view) {
        if (!this.z) {
            d.e.a f2 = f();
            int i2 = f2.f4602c;
            f0 c2 = v.c(view);
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                b bVar = (b) f2.e(i3);
                if (bVar.f5493a != null && c2.equals(bVar.f5496d)) {
                    ((Animator) f2.c(i3)).pause();
                }
            }
            ArrayList<d> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((d) arrayList2.get(i4)).b(this);
                }
            }
            this.y = true;
        }
    }

    public i b(d dVar) {
        ArrayList<d> arrayList = this.A;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.A.size() == 0) {
            this.A = null;
        }
        return this;
    }

    public i a(View view) {
        this.f5488f.add(view);
        return this;
    }

    public void a(ViewGroup viewGroup, boolean z2) {
        a(z2);
        if (this.f5487e.size() > 0 || this.f5488f.size() > 0) {
            ArrayList<String> arrayList = this.f5489g;
            if (arrayList == null || arrayList.isEmpty()) {
                ArrayList<Class<?>> arrayList2 = this.f5490h;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    for (int i2 = 0; i2 < this.f5487e.size(); i2++) {
                        View findViewById = viewGroup.findViewById(((Integer) this.f5487e.get(i2)).intValue());
                        if (findViewById != null) {
                            q qVar = new q(findViewById);
                            if (z2) {
                                c(qVar);
                            } else {
                                a(qVar);
                            }
                            qVar.f5513c.add(this);
                            b(qVar);
                            if (z2) {
                                a(this.p, findViewById, qVar);
                            } else {
                                a(this.q, findViewById, qVar);
                            }
                        }
                    }
                    for (int i3 = 0; i3 < this.f5488f.size(); i3++) {
                        View view = (View) this.f5488f.get(i3);
                        q qVar2 = new q(view);
                        if (z2) {
                            c(qVar2);
                        } else {
                            a(qVar2);
                        }
                        qVar2.f5513c.add(this);
                        b(qVar2);
                        if (z2) {
                            a(this.p, view, qVar2);
                        } else {
                            a(this.q, view, qVar2);
                        }
                    }
                    return;
                }
            }
        }
        a((View) viewGroup, z2);
    }

    public static void a(r rVar, View view, q qVar) {
        rVar.f5514a.put(view, qVar);
        int id = view.getId();
        if (id >= 0) {
            if (rVar.f5515b.indexOfKey(id) >= 0) {
                rVar.f5515b.put(id, null);
            } else {
                rVar.f5515b.put(id, view);
            }
        }
        String s2 = m.s(view);
        if (s2 != null) {
            if (rVar.f5517d.a((Object) s2) >= 0) {
                rVar.f5517d.put(s2, null);
            } else {
                rVar.f5517d.put(s2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                e<View> eVar = rVar.f5516c;
                if (eVar.f4570a) {
                    eVar.b();
                }
                if (d.e.d.a(eVar.f4571b, eVar.f4573d, itemIdAtPosition) >= 0) {
                    View view2 = (View) rVar.f5516c.b(itemIdAtPosition);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        rVar.f5516c.c(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                rVar.f5516c.c(itemIdAtPosition, view);
            }
        }
    }

    public void a(boolean z2) {
        if (z2) {
            this.p.f5514a.clear();
            this.p.f5515b.clear();
            this.p.f5516c.a();
            return;
        }
        this.q.f5514a.clear();
        this.q.f5515b.clear();
        this.q.f5516c.a();
    }

    public final void a(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.f5491i;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.f5492j;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.k;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!((Class) this.k.get(i2)).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        q qVar = new q(view);
                        if (z2) {
                            c(qVar);
                        } else {
                            a(qVar);
                        }
                        qVar.f5513c.add(this);
                        b(qVar);
                        if (z2) {
                            a(this.p, view, qVar);
                        } else {
                            a(this.q, view, qVar);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.m;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.n;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.o;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!((Class) this.o.get(i3)).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    a(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean a(q qVar, q qVar2) {
        if (qVar == null || qVar2 == null) {
            return false;
        }
        String[] b2 = b();
        if (b2 != null) {
            int length = b2.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(qVar, qVar2, b2[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String a2 : qVar.f5511a.keySet()) {
            if (a(qVar, qVar2, a2)) {
            }
        }
        return false;
        return true;
    }

    public static boolean a(q qVar, q qVar2, String str) {
        Object obj = qVar.f5511a.get(str);
        Object obj2 = qVar2.f5511a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public void a() {
        int i2 = this.x - 1;
        this.x = i2;
        if (i2 == 0) {
            ArrayList<d> arrayList = this.A;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.A.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((d) arrayList2.get(i3)).c(this);
                }
            }
            for (int i4 = 0; i4 < this.p.f5516c.e(); i4++) {
                View view = (View) this.p.f5516c.b(i4);
                if (view != null) {
                    m.b(view, false);
                }
            }
            for (int i5 = 0; i5 < this.q.f5516c.e(); i5++) {
                View view2 = (View) this.q.f5516c.b(i5);
                if (view2 != null) {
                    m.b(view2, false);
                }
            }
            this.z = true;
        }
    }

    public i a(d dVar) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(dVar);
        return this;
    }

    public void a(e eVar) {
        if (eVar == null) {
            this.E = G;
        } else {
            this.E = eVar;
        }
    }

    public void a(c cVar) {
        this.D = cVar;
    }

    public void a(n nVar) {
        this.C = nVar;
    }

    public String a(String str) {
        StringBuilder a2 = e.a.a.a.a.a(str);
        a2.append(getClass().getSimpleName());
        a2.append("@");
        a2.append(Integer.toHexString(hashCode()));
        a2.append(": ");
        String sb = a2.toString();
        String str2 = ") ";
        if (this.f5485c != -1) {
            StringBuilder b2 = e.a.a.a.a.b(sb, "dur(");
            b2.append(this.f5485c);
            b2.append(str2);
            sb = b2.toString();
        }
        if (this.f5484b != -1) {
            StringBuilder b3 = e.a.a.a.a.b(sb, "dly(");
            b3.append(this.f5484b);
            b3.append(str2);
            sb = b3.toString();
        }
        if (this.f5486d != null) {
            StringBuilder b4 = e.a.a.a.a.b(sb, "interp(");
            b4.append(this.f5486d);
            b4.append(str2);
            sb = b4.toString();
        }
        if (this.f5487e.size() <= 0 && this.f5488f.size() <= 0) {
            return sb;
        }
        String a3 = e.a.a.a.a.a(sb, "tgts(");
        String str3 = ", ";
        if (this.f5487e.size() > 0) {
            for (int i2 = 0; i2 < this.f5487e.size(); i2++) {
                if (i2 > 0) {
                    a3 = e.a.a.a.a.a(a3, str3);
                }
                StringBuilder a4 = e.a.a.a.a.a(a3);
                a4.append(this.f5487e.get(i2));
                a3 = a4.toString();
            }
        }
        if (this.f5488f.size() > 0) {
            for (int i3 = 0; i3 < this.f5488f.size(); i3++) {
                if (i3 > 0) {
                    a3 = e.a.a.a.a.a(a3, str3);
                }
                StringBuilder a5 = e.a.a.a.a.a(a3);
                a5.append(this.f5488f.get(i3));
                a3 = a5.toString();
            }
        }
        return e.a.a.a.a.a(a3, ")");
    }
}
