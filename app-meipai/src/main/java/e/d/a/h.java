package e.d.a;

import com.bumptech.glide.load.ImageHeaderParser;
import e.d.a.n.o.n;
import e.d.a.n.o.p;
import e.d.a.q.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Registry */
public class h {

    /* renamed from: a reason: collision with root package name */
    public final p f7120a;

    /* renamed from: b reason: collision with root package name */
    public final e.d.a.q.a f7121b;

    /* renamed from: c reason: collision with root package name */
    public final e.d.a.q.e f7122c;

    /* renamed from: d reason: collision with root package name */
    public final f f7123d;

    /* renamed from: e reason: collision with root package name */
    public final e.d.a.n.m.f f7124e;

    /* renamed from: f reason: collision with root package name */
    public final e.d.a.n.p.h.f f7125f;

    /* renamed from: g reason: collision with root package name */
    public final e.d.a.q.b f7126g;

    /* renamed from: h reason: collision with root package name */
    public final e.d.a.q.d f7127h = new e.d.a.q.d();

    /* renamed from: i reason: collision with root package name */
    public final e.d.a.q.c f7128i = new e.d.a.q.c();

    /* renamed from: j reason: collision with root package name */
    public final d.h.j.c<List<Throwable>> f7129j;

    /* compiled from: Registry */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* compiled from: Registry */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* compiled from: Registry */
    public static class c extends a {
        public c(Object obj) {
            StringBuilder a2 = e.a.a.a.a.a("Failed to find any ModelLoaders registered for model class: ");
            a2.append(obj.getClass());
            super(a2.toString());
        }

        public <M> c(M m, List<n<M, ?>> list) {
            StringBuilder sb = new StringBuilder();
            sb.append("Found ModelLoaders for model class: ");
            sb.append(list);
            sb.append(", but none that handle this specific model instance: ");
            sb.append(m);
            super(sb.toString());
        }

        public c(Class<?> cls, Class<?> cls2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any ModelLoaders for model: ");
            sb.append(cls);
            sb.append(" and data: ");
            sb.append(cls2);
            super(sb.toString());
        }
    }

    /* compiled from: Registry */
    public static class d extends a {
        public d(Class<?> cls) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find result encoder for resource class: ");
            sb.append(cls);
            sb.append(", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            super(sb.toString());
        }
    }

    /* compiled from: Registry */
    public static class e extends a {
        public e(Class<?> cls) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find source encoder for data class: ");
            sb.append(cls);
            super(sb.toString());
        }
    }

    public h() {
        d.h.j.c<List<Throwable>> a2 = e.d.a.t.k.a.a();
        this.f7129j = a2;
        this.f7120a = new p(a2);
        this.f7121b = new e.d.a.q.a();
        this.f7122c = new e.d.a.q.e();
        this.f7123d = new f();
        this.f7124e = new e.d.a.n.m.f();
        this.f7125f = new e.d.a.n.p.h.f();
        this.f7126g = new e.d.a.q.b();
        List asList = Arrays.asList(new String[]{"Gif", "Bitmap", "BitmapDrawable"});
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.addAll(asList);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f7122c.a((List<String>) arrayList);
    }

    public <Model> List<n<Model, ?>> a(Model model) {
        p pVar = this.f7120a;
        if (pVar != null) {
            List b2 = pVar.b(model.getClass());
            if (!b2.isEmpty()) {
                int size = b2.size();
                List<n<Model, ?>> emptyList = Collections.emptyList();
                boolean z = true;
                for (int i2 = 0; i2 < size; i2++) {
                    n nVar = (n) b2.get(i2);
                    if (nVar.a(model)) {
                        if (z) {
                            emptyList = new ArrayList<>(size - i2);
                            z = false;
                        }
                        emptyList.add(nVar);
                    }
                }
                if (!emptyList.isEmpty()) {
                    return emptyList;
                }
                throw new c(model, b2);
            }
            throw new c(model);
        }
        throw null;
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.f7126g.a();
        if (!a2.isEmpty()) {
            return a2;
        }
        throw new b();
    }
}
