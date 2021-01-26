package g.d0.h;

/* compiled from: ErrorCode */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: a reason: collision with root package name */
    public final int f9287a;

    /* access modifiers changed from: public */
    b(int i2) {
        this.f9287a = i2;
    }

    public static b a(int i2) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.f9287a == i2) {
                return bVar;
            }
        }
        return null;
    }
}
