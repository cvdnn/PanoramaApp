package d.r.d;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.d0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DefaultItemAnimator */
public class k extends w {
    public static TimeInterpolator s;

    /* renamed from: h reason: collision with root package name */
    public ArrayList<d0> f5343h = new ArrayList<>();

    /* renamed from: i reason: collision with root package name */
    public ArrayList<d0> f5344i = new ArrayList<>();

    /* renamed from: j reason: collision with root package name */
    public ArrayList<b> f5345j = new ArrayList<>();
    public ArrayList<a> k = new ArrayList<>();
    public ArrayList<ArrayList<d0>> l = new ArrayList<>();
    public ArrayList<ArrayList<b>> m = new ArrayList<>();
    public ArrayList<ArrayList<a>> n = new ArrayList<>();
    public ArrayList<d0> o = new ArrayList<>();
    public ArrayList<d0> p = new ArrayList<>();
    public ArrayList<d0> q = new ArrayList<>();
    public ArrayList<d0> r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public d0 f5346a;

        /* renamed from: b reason: collision with root package name */
        public d0 f5347b;

        /* renamed from: c reason: collision with root package name */
        public int f5348c;

        /* renamed from: d reason: collision with root package name */
        public int f5349d;

        /* renamed from: e reason: collision with root package name */
        public int f5350e;

        /* renamed from: f reason: collision with root package name */
        public int f5351f;

        public a(d0 d0Var, d0 d0Var2, int i2, int i3, int i4, int i5) {
            this.f5346a = d0Var;
            this.f5347b = d0Var2;
            this.f5348c = i2;
            this.f5349d = i3;
            this.f5350e = i4;
            this.f5351f = i5;
        }

        public String toString() {
            StringBuilder a2 = e.a.a.a.a.a("ChangeInfo{oldHolder=");
            a2.append(this.f5346a);
            a2.append(", newHolder=");
            a2.append(this.f5347b);
            a2.append(", fromX=");
            a2.append(this.f5348c);
            a2.append(", fromY=");
            a2.append(this.f5349d);
            a2.append(", toX=");
            a2.append(this.f5350e);
            a2.append(", toY=");
            a2.append(this.f5351f);
            a2.append('}');
            return a2.toString();
        }
    }

    /* compiled from: DefaultItemAnimator */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public d0 f5352a;

        /* renamed from: b reason: collision with root package name */
        public int f5353b;

        /* renamed from: c reason: collision with root package name */
        public int f5354c;

        /* renamed from: d reason: collision with root package name */
        public int f5355d;

        /* renamed from: e reason: collision with root package name */
        public int f5356e;

        public b(d0 d0Var, int i2, int i3, int i4, int i5) {
            this.f5352a = d0Var;
            this.f5353b = i2;
            this.f5354c = i3;
            this.f5355d = i4;
            this.f5356e = i5;
        }
    }

    public boolean a(d0 d0Var, int i2, int i3, int i4, int i5) {
        View view = d0Var.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) d0Var.itemView.getTranslationY());
        e(d0Var);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            a(d0Var);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        ArrayList<b> arrayList = this.f5345j;
        b bVar = new b(d0Var, translationX, translationY, i4, i5);
        arrayList.add(bVar);
        return true;
    }

    public void b(d0 d0Var) {
        View view = d0Var.itemView;
        view.animate().cancel();
        int size = this.f5345j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (((b) this.f5345j.get(size)).f5352a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                a(d0Var);
                this.f5345j.remove(size);
            }
        }
        a((List<a>) this.k, d0Var);
        if (this.f5343h.remove(d0Var)) {
            view.setAlpha(1.0f);
            a(d0Var);
        }
        if (this.f5344i.remove(d0Var)) {
            view.setAlpha(1.0f);
            a(d0Var);
        }
        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.n.get(size2);
            a((List<a>) arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        for (int size3 = this.m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f5352a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    a(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                a(d0Var);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
        this.q.remove(d0Var);
        this.o.remove(d0Var);
        this.r.remove(d0Var);
        this.p.remove(d0Var);
        d();
    }

    public boolean c() {
        return !this.f5344i.isEmpty() || !this.k.isEmpty() || !this.f5345j.isEmpty() || !this.f5343h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    public void d() {
        if (!c()) {
            a();
        }
    }

    public final void e(d0 d0Var) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        d0Var.itemView.animate().setInterpolator(s);
        b(d0Var);
    }

    public final void a(List<a> list, d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, d0Var) && aVar.f5346a == null && aVar.f5347b == null) {
                list.remove(aVar);
            }
        }
    }

    public final boolean a(a aVar, d0 d0Var) {
        if (aVar.f5347b == d0Var) {
            aVar.f5347b = null;
        } else if (aVar.f5346a != d0Var) {
            return false;
        } else {
            aVar.f5346a = null;
        }
        d0Var.itemView.setAlpha(1.0f);
        d0Var.itemView.setTranslationX(0.0f);
        d0Var.itemView.setTranslationY(0.0f);
        a(d0Var);
        return true;
    }

    public void a(List<d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((d0) list.get(size)).itemView.animate().cancel();
        }
    }

    public boolean a(d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.a(d0Var, list);
    }

    public void b() {
        int size = this.f5345j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = (b) this.f5345j.get(size);
            View view = bVar.f5352a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            a(bVar.f5352a);
            this.f5345j.remove(size);
        }
        int size2 = this.f5343h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            a((d0) this.f5343h.get(size2));
            this.f5343h.remove(size2);
        }
        int size3 = this.f5344i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            d0 d0Var = (d0) this.f5344i.get(size3);
            d0Var.itemView.setAlpha(1.0f);
            a(d0Var);
            this.f5344i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            a aVar = (a) this.k.get(size4);
            d0 d0Var2 = aVar.f5346a;
            if (d0Var2 != null) {
                a(aVar, d0Var2);
            }
            d0 d0Var3 = aVar.f5347b;
            if (d0Var3 != null) {
                a(aVar, d0Var3);
            }
        }
        this.k.clear();
        if (c()) {
            int size5 = this.m.size();
            while (true) {
                size5--;
                if (size5 < 0) {
                    break;
                }
                ArrayList arrayList = (ArrayList) this.m.get(size5);
                int size6 = arrayList.size();
                while (true) {
                    size6--;
                    if (size6 >= 0) {
                        b bVar2 = (b) arrayList.get(size6);
                        View view2 = bVar2.f5352a.itemView;
                        view2.setTranslationY(0.0f);
                        view2.setTranslationX(0.0f);
                        a(bVar2.f5352a);
                        arrayList.remove(size6);
                        if (arrayList.isEmpty()) {
                            this.m.remove(arrayList);
                        }
                    }
                }
            }
            int size7 = this.l.size();
            while (true) {
                size7--;
                if (size7 < 0) {
                    break;
                }
                ArrayList arrayList2 = (ArrayList) this.l.get(size7);
                int size8 = arrayList2.size();
                while (true) {
                    size8--;
                    if (size8 >= 0) {
                        d0 d0Var4 = (d0) arrayList2.get(size8);
                        d0Var4.itemView.setAlpha(1.0f);
                        a(d0Var4);
                        arrayList2.remove(size8);
                        if (arrayList2.isEmpty()) {
                            this.l.remove(arrayList2);
                        }
                    }
                }
            }
            int size9 = this.n.size();
            while (true) {
                size9--;
                if (size9 >= 0) {
                    ArrayList arrayList3 = (ArrayList) this.n.get(size9);
                    int size10 = arrayList3.size();
                    while (true) {
                        size10--;
                        if (size10 >= 0) {
                            a aVar2 = (a) arrayList3.get(size10);
                            d0 d0Var5 = aVar2.f5346a;
                            if (d0Var5 != null) {
                                a(aVar2, d0Var5);
                            }
                            d0 d0Var6 = aVar2.f5347b;
                            if (d0Var6 != null) {
                                a(aVar2, d0Var6);
                            }
                            if (arrayList3.isEmpty()) {
                                this.n.remove(arrayList3);
                            }
                        }
                    }
                } else {
                    a(this.q);
                    a(this.p);
                    a(this.o);
                    a(this.r);
                    a();
                    return;
                }
            }
        }
    }
}
