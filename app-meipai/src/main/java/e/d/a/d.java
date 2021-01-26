package e.d.a;

import android.content.Context;
import android.content.ContextWrapper;
import e.d.a.b.a;
import e.d.a.n.n.c0.b;
import e.d.a.n.n.l;
import e.d.a.r.e;
import e.d.a.r.h.f;
import java.util.List;
import java.util.Map;

/* compiled from: GlideContext */
public class d extends ContextWrapper {
    public static final k<?, ?> k = new a();

    /* renamed from: a reason: collision with root package name */
    public final b f7101a;

    /* renamed from: b reason: collision with root package name */
    public final h f7102b;

    /* renamed from: c reason: collision with root package name */
    public final f f7103c;

    /* renamed from: d reason: collision with root package name */
    public final a f7104d;

    /* renamed from: e reason: collision with root package name */
    public final List<e.d.a.r.d<Object>> f7105e;

    /* renamed from: f reason: collision with root package name */
    public final Map<Class<?>, k<?, ?>> f7106f;

    /* renamed from: g reason: collision with root package name */
    public final l f7107g;

    /* renamed from: h reason: collision with root package name */
    public final boolean f7108h;

    /* renamed from: i reason: collision with root package name */
    public final int f7109i;

    /* renamed from: j reason: collision with root package name */
    public e f7110j;

    public d(Context context, b bVar, h hVar, f fVar, a aVar, Map<Class<?>, k<?, ?>> map, List<e.d.a.r.d<Object>> list, l lVar, boolean z, int i2) {
        super(context.getApplicationContext());
        this.f7101a = bVar;
        this.f7102b = hVar;
        this.f7103c = fVar;
        this.f7104d = aVar;
        this.f7105e = list;
        this.f7106f = map;
        this.f7107g = lVar;
        this.f7108h = z;
        this.f7109i = i2;
    }

    public synchronized e a() {
        if (this.f7110j == null) {
            if (((c.a) this.f7104d) != null) {
                e eVar = new e();
                eVar.t = true;
                this.f7110j = eVar;
            } else {
                throw null;
            }
        }
        return this.f7110j;
    }
}
