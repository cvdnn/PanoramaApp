package d.t;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import d.h.k.m;
import d.n.a.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* compiled from: FragmentTransitionSupport */
public class d extends a0 {

    /* compiled from: FragmentTransitionSupport */
    public class a extends d.t.i.c {
        public a(d dVar, Rect rect) {
        }
    }

    /* compiled from: FragmentTransitionSupport */
    public class b implements d.t.i.d {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ View f5461a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ ArrayList f5462b;

        public b(d dVar, View view, ArrayList arrayList) {
            this.f5461a = view;
            this.f5462b = arrayList;
        }

        public void a(i iVar) {
        }

        public void b(i iVar) {
        }

        public void c(i iVar) {
            iVar.b((d.t.i.d) this);
            this.f5461a.setVisibility(8);
            int size = this.f5462b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f5462b.get(i2)).setVisibility(0);
            }
        }

        public void d(i iVar) {
        }

        public void e(i iVar) {
        }
    }

    /* compiled from: FragmentTransitionSupport */
    public class c extends l {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Object f5463a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ ArrayList f5464b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ Object f5465c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ ArrayList f5466d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ Object f5467e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ ArrayList f5468f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f5463a = obj;
            this.f5464b = arrayList;
            this.f5465c = obj2;
            this.f5466d = arrayList2;
            this.f5467e = obj3;
            this.f5468f = arrayList3;
        }

        public void a(i iVar) {
            Object obj = this.f5463a;
            if (obj != null) {
                d.this.a(obj, this.f5464b, null);
            }
            Object obj2 = this.f5465c;
            if (obj2 != null) {
                d.this.a(obj2, this.f5466d, null);
            }
            Object obj3 = this.f5467e;
            if (obj3 != null) {
                d.this.a(obj3, this.f5468f, null);
            }
        }

        public void c(i iVar) {
            iVar.b((d.t.i.d) this);
        }
    }

    /* renamed from: d.t.d$d reason: collision with other inner class name */
    /* compiled from: FragmentTransitionSupport */
    public class C0057d extends d.t.i.c {
        public C0057d(d dVar, Rect rect) {
        }
    }

    public boolean a(Object obj) {
        return obj instanceof i;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((i) obj).clone();
        }
        return null;
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        o oVar = new o();
        oVar.a((i) obj);
        return oVar;
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        i iVar = (i) obj;
        if (iVar != null) {
            int i2 = 0;
            if (iVar instanceof o) {
                o oVar = (o) iVar;
                int size = oVar.I.size();
                while (i2 < size) {
                    a((Object) oVar.a(i2), arrayList);
                    i2++;
                }
            } else if (!a(iVar) && a0.a((List) iVar.f5488f)) {
                int size2 = arrayList.size();
                while (i2 < size2) {
                    iVar.a((View) arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public void b(Object obj, View view, ArrayList<View> arrayList) {
        o oVar = (o) obj;
        ArrayList<View> arrayList2 = oVar.f5488f;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a0.a((List<View>) arrayList2, (View) arrayList.get(i2));
        }
        arrayList2.add(view);
        arrayList.add(view);
        a((Object) oVar, arrayList);
    }

    public void c(Object obj, View view) {
        if (view != null) {
            i iVar = (i) obj;
            Rect rect = new Rect();
            a(view, rect);
            iVar.a((d.t.i.c) new a(this, rect));
        }
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        o oVar = new o();
        if (obj != null) {
            oVar.a((i) obj);
        }
        if (obj2 != null) {
            oVar.a((i) obj2);
        }
        if (obj3 != null) {
            oVar.a((i) obj3);
        }
        return oVar;
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((i) obj).a((d.t.i.d) new b(this, view, arrayList));
    }

    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.Object r2, java.lang.Object r3, java.lang.Object r4) {
        /*
            r1 = this;
            d.t.i r2 = (d.t.i) r2
            d.t.i r3 = (d.t.i) r3
            d.t.i r4 = (d.t.i) r4
            if (r2 == 0) goto L_0x001b
            if (r3 == 0) goto L_0x001b
            d.t.o r0 = new d.t.o
            r0.<init>()
            r0.a(r2)
            r0.a(r3)
            r2 = 1
            r0.b(r2)
            r2 = r0
            goto L_0x0023
        L_0x001b:
            if (r2 == 0) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            if (r3 == 0) goto L_0x0022
            r2 = r3
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r4 == 0) goto L_0x0033
            d.t.o r3 = new d.t.o
            r3.<init>()
            if (r2 == 0) goto L_0x002f
            r3.a(r2)
        L_0x002f:
            r3.a(r4)
            return r3
        L_0x0033:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d.t.d.a(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        o oVar = (o) obj;
        if (oVar != null) {
            oVar.f5488f.clear();
            oVar.f5488f.addAll(arrayList2);
            a((Object) oVar, arrayList, arrayList2);
        }
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((i) obj).d(view);
        }
    }

    public void a(ViewGroup viewGroup, Object obj) {
        i iVar = (i) obj;
        if (!m.f5503c.contains(viewGroup) && m.z(viewGroup)) {
            m.f5503c.add(viewGroup);
            if (iVar == null) {
                iVar = m.f5501a;
            }
            i clone = iVar.clone();
            ArrayList arrayList = (ArrayList) m.a().getOrDefault(viewGroup, null);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).c((View) viewGroup);
                }
            }
            if (clone != null) {
                clone.a(viewGroup, true);
            }
            if (((h) viewGroup.getTag(f.transition_current_scene)) == null) {
                viewGroup.setTag(f.transition_current_scene, null);
                if (clone != null) {
                    d.t.m.a aVar = new d.t.m.a(clone, viewGroup);
                    viewGroup.addOnAttachStateChangeListener(aVar);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        i iVar = (i) obj;
        c cVar = new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3);
        iVar.a((d.t.i.d) cVar);
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i2;
        i iVar = (i) obj;
        int i3 = 0;
        if (iVar instanceof o) {
            o oVar = (o) iVar;
            int size = oVar.I.size();
            while (i3 < size) {
                a((Object) oVar.a(i3), arrayList, arrayList2);
                i3++;
            }
        } else if (!a(iVar)) {
            ArrayList<View> arrayList3 = iVar.f5488f;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i2 = 0;
                } else {
                    i2 = arrayList2.size();
                }
                while (i3 < i2) {
                    iVar.a((View) arrayList2.get(i3));
                    i3++;
                }
                int size2 = arrayList.size();
                while (true) {
                    size2--;
                    if (size2 >= 0) {
                        iVar.d((View) arrayList.get(size2));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((i) obj).a(view);
        }
    }

    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((i) obj).a((d.t.i.c) new C0057d(this, rect));
        }
    }

    public static boolean a(i iVar) {
        return !a0.a((List) iVar.f5487e) || !a0.a((List) iVar.f5489g) || !a0.a((List) iVar.f5490h);
    }
}
