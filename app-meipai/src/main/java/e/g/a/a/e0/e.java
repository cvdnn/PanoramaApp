package e.g.a.a.e0;

/* compiled from: CutCornerTreatment */
public class e extends d {

    /* renamed from: a reason: collision with root package name */
    public float f8071a = -1.0f;

    public void a(m mVar, float f2, float f3, float f4) {
        mVar.a(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = (double) f4;
        double d3 = (double) f3;
        mVar.a((float) (Math.sin(Math.toRadians((double) f2)) * d2 * d3), (float) (Math.sin(Math.toRadians((double) (90.0f - f2))) * d2 * d3));
    }
}
