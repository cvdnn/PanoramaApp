package e.l.a.l;

import android.content.Context;
import android.util.Log;
import e.l.a.f;
import e.l.a.g;
import e.l.a.h.a.C0131a;
import e.l.a.i.d;
import e.l.a.i.e;
import e.l.a.i.j;
import e.l.a.m.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: MRequest */
public class a implements c, g, C0131a {

    /* renamed from: g reason: collision with root package name */
    public static final e f8960g = new j();

    /* renamed from: h reason: collision with root package name */
    public static final e f8961h = new d();

    /* renamed from: a reason: collision with root package name */
    public c f8962a;

    /* renamed from: b reason: collision with root package name */
    public String[] f8963b;

    /* renamed from: c reason: collision with root package name */
    public f<List<String>> f8964c = new C0133a(this);

    /* renamed from: d reason: collision with root package name */
    public e.l.a.a<List<String>> f8965d;

    /* renamed from: e reason: collision with root package name */
    public e.l.a.a<List<String>> f8966e;

    /* renamed from: f reason: collision with root package name */
    public String[] f8967f;

    /* renamed from: e.l.a.l.a$a reason: collision with other inner class name */
    /* compiled from: MRequest */
    public class C0133a implements f<List<String>> {
        public C0133a(a aVar) {
        }

        public void a(Context context, Object obj, g gVar) {
            List list = (List) obj;
            ((a) gVar).a();
        }
    }

    /* compiled from: MRequest */
    public class b extends e.l.a.n.a {
        public b(Context context) {
            super(context);
        }

        public void a(List<String> list) {
            if (list.isEmpty()) {
                a aVar = a.this;
                if (aVar.f8965d != null) {
                    List asList = Arrays.asList(aVar.f8963b);
                    try {
                        aVar.f8965d.a(asList);
                    } catch (Exception e2) {
                        Log.e("AndPermission", "Please check the onGranted() method body for bugs.", e2);
                        e.l.a.a<List<String>> aVar2 = aVar.f8966e;
                        if (aVar2 != null) {
                            aVar2.a(asList);
                        }
                    }
                }
            } else {
                e.l.a.a<List<String>> aVar3 = a.this.f8966e;
                if (aVar3 != null) {
                    aVar3.a(list);
                }
            }
        }

        public Object doInBackground(Object[] objArr) {
            Void[] voidArr = (Void[]) objArr;
            e eVar = a.f8961h;
            a aVar = a.this;
            return a.a(eVar, aVar.f8962a, aVar.f8963b);
        }
    }

    public a(c cVar) {
        this.f8962a = cVar;
    }

    public void a() {
        e.l.a.h.a aVar = new e.l.a.h.a(this.f8962a);
        aVar.f8926b = 2;
        aVar.f8928d = this.f8967f;
        aVar.f8927c = this;
        e.l.a.h.e.a().f8937a.execute(new e.l.a.h.d(aVar));
    }

    public void b() {
        new b(this.f8962a.a()).executeOnExecutor(e.l.a.n.a.f8974b, new Void[0]);
    }

    public void c() {
        ArrayList arrayList = (ArrayList) a(f8960g, this.f8962a, this.f8963b);
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this.f8967f = strArr;
        if (strArr.length > 0) {
            c cVar = this.f8962a;
            ArrayList arrayList2 = new ArrayList(1);
            for (String str : strArr) {
                if (cVar.a(str)) {
                    arrayList2.add(str);
                }
            }
            if (arrayList2.size() > 0) {
                this.f8964c.a(this.f8962a.a(), arrayList2, this);
            } else {
                a();
            }
        } else {
            b();
        }
    }

    public static List<String> a(e eVar, c cVar, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!eVar.a(cVar.a(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
