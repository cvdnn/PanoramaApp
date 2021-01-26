package a.a.a.a.b;

public enum b {
    WaterProof(0),
    DivingWater(1),
    DivingAir(2),
    StitchOptimization(3);
    

    /* renamed from: a reason: collision with root package name */
    public final int f407a;

    /* access modifiers changed from: public */
    b(int i2) {
        this.f407a = i2;
    }

    public static b a(int i2) {
        if (i2 == 0) {
            return WaterProof;
        }
        if (i2 == 1) {
            return DivingWater;
        }
        if (i2 == 2) {
            return DivingAir;
        }
        if (i2 != 3) {
            return null;
        }
        return StitchOptimization;
    }
}
