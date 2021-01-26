package a.a.a.a.e.a.e;

import a.a.a.a.e.a.e.k.c;
import a.a.a.a.e.a.e.k.d;
import a.a.a.a.e.a.i.f.e;
import a.a.a.a.e.a.l.f;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import java.util.ArrayList;
import java.util.List;

public class p {

    /* renamed from: d reason: collision with root package name */
    public static final MediaLogger f561d = MediaLogger.getLogger(p.class);

    /* renamed from: a reason: collision with root package name */
    public c f562a;

    /* renamed from: b reason: collision with root package name */
    public d f563b;

    /* renamed from: c reason: collision with root package name */
    public a.a.a.a.e.a.i.f.d f564c = new a.a.a.a.e.a.i.f.d();

    public static double a(double d2, double d3, double d4) {
        return Math.min(Math.max(d2, d3), d4);
    }

    public Transform a() {
        e b2 = b();
        Transform transform = new Transform(b2.f605d, b2.f606e, b2.f608g, b2.f603b, b2.f602a);
        return a(transform);
    }

    public final Transform a(Transform transform) {
        if (transform == null) {
            f561d.e("rotateTransformIfNeeded, but transform is null");
            return null;
        }
        if (this.f562a.isRotateEnabled()) {
            transform = a.a.a.a.e.a.l.d.a(transform, this.f562a.getRotateDegree(), this.f562a.getFileType(), this.f562a.getConstraintRatio());
        }
        return transform;
    }

    public void a(d dVar) {
        this.f563b = dVar;
        this.f564c.a(c());
    }

    public final e b() {
        e eVar = new e();
        eVar.f602a = this.f562a.getConstraint().getDefaultFov();
        eVar.f603b = this.f562a.getConstraint().getDefaultDistance();
        Vector3f eulerAnglesYXZ = new Quaternionf().getEulerAnglesYXZ(new Vector3f());
        eVar.f605d = eulerAnglesYXZ.y;
        eVar.f607f = eulerAnglesYXZ.z;
        eVar.f606e = eulerAnglesYXZ.x;
        eVar.f608g = 0.0f;
        return eVar;
    }

    public final List<a.a.a.a.e.a.i.f.c> c() {
        d dVar = this.f563b;
        return (dVar == null || !dVar.containsRecordListData()) ? new ArrayList() : f.a(this.f563b.getRecordList(), this.f563b.getTrimStart(), this.f563b.getTrimEnd(), this.f563b.getSpeedFactor(), this.f563b.getScreenRatio(), this.f563b.getConstraint(), this.f563b.getRecordConverter());
    }

    public Transform a(double d2, boolean z) {
        e eVar;
        if (z) {
            eVar = this.f564c.b(d2, true);
            if (eVar == null) {
                eVar = b();
            }
        } else {
            eVar = this.f564c.a(d2, true);
            if (eVar == null) {
                return null;
            }
        }
        Transform transform = new Transform(eVar.f605d, eVar.f606e, eVar.f608g, eVar.f603b, eVar.f602a);
        return a(transform);
    }
}
