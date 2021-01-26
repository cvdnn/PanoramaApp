package d.q.a;

import d.e.i;
import d.p.h;
import d.p.m;
import d.p.n;
import d.p.q;
import d.p.r;
import d.p.s;
import d.p.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManagerImpl */
public class b extends a {

    /* renamed from: a reason: collision with root package name */
    public final h f5294a;

    /* renamed from: b reason: collision with root package name */
    public final c f5295b;

    /* compiled from: LoaderManagerImpl */
    public static class a<D> extends m<D> {

        /* renamed from: j reason: collision with root package name */
        public h f5296j;
        public C0052b<D> k;

        public void a() {
            throw null;
        }

        public void b() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            a.a.a.a.b.a.a((Object) null, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(n<? super D> nVar) {
            super.a(nVar);
            this.f5296j = null;
            this.k = null;
        }

        public void a(D d2) {
            super.a(d2);
        }
    }

    /* renamed from: d.q.a.b$b reason: collision with other inner class name */
    /* compiled from: LoaderManagerImpl */
    public static class C0052b<D> implements n<D> {
    }

    /* compiled from: LoaderManagerImpl */
    public static class c extends q {

        /* renamed from: c reason: collision with root package name */
        public static final r f5297c = new a();

        /* renamed from: b reason: collision with root package name */
        public i<a> f5298b = new i<>(10);

        /* compiled from: LoaderManagerImpl */
        public static class a implements r {
            public <T extends q> T a(Class<T> cls) {
                return new c();
            }
        }

        public void b() {
            if (this.f5298b.b() <= 0) {
                i<a> iVar = this.f5298b;
                int i2 = iVar.f4607d;
                Object[] objArr = iVar.f4606c;
                for (int i3 = 0; i3 < i2; i3++) {
                    objArr[i3] = null;
                }
                iVar.f4607d = 0;
                iVar.f4604a = false;
            } else if (((a) this.f5298b.d(0)) != null) {
                throw null;
            } else {
                throw null;
            }
        }
    }

    public b(h hVar, t tVar) {
        q qVar;
        this.f5294a = hVar;
        r rVar = c.f5297c;
        Class<c> cls = c.class;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            String a2 = e.a.a.a.a.a("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            q qVar2 = (q) tVar.f5293a.get(a2);
            if (!cls.isInstance(qVar2)) {
                if (rVar instanceof s) {
                    qVar = ((s) rVar).a(a2, cls);
                } else {
                    qVar = rVar.a(cls);
                }
                qVar2 = qVar;
                q qVar3 = (q) tVar.f5293a.put(a2, qVar2);
                if (qVar3 != null) {
                    qVar3.b();
                }
            }
            this.f5295b = (c) qVar2;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        c cVar = this.f5295b;
        if (cVar.f5298b.b() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("    ");
            String sb2 = sb.toString();
            if (cVar.f5298b.b() > 0) {
                a aVar = (a) cVar.f5298b.d(0);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(cVar.f5298b.b(0));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                printWriter.print(sb2);
                printWriter.print("mId=");
                printWriter.print(0);
                printWriter.print(" mArgs=");
                printWriter.println(null);
                printWriter.print(sb2);
                printWriter.print("mLoader=");
                printWriter.println(null);
                throw null;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a.a.a.a.b.a.a((Object) this.f5294a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
