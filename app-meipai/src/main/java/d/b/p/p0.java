package d.b.p;

/* compiled from: RtlSpacingHelper */
public class p0 {

    /* renamed from: a reason: collision with root package name */
    public int f4412a = 0;

    /* renamed from: b reason: collision with root package name */
    public int f4413b = 0;

    /* renamed from: c reason: collision with root package name */
    public int f4414c = Integer.MIN_VALUE;

    /* renamed from: d reason: collision with root package name */
    public int f4415d = Integer.MIN_VALUE;

    /* renamed from: e reason: collision with root package name */
    public int f4416e = 0;

    /* renamed from: f reason: collision with root package name */
    public int f4417f = 0;

    /* renamed from: g reason: collision with root package name */
    public boolean f4418g = false;

    /* renamed from: h reason: collision with root package name */
    public boolean f4419h = false;

    public void a(int i2, int i3) {
        this.f4414c = i2;
        this.f4415d = i3;
        this.f4419h = true;
        if (this.f4418g) {
            if (i3 != Integer.MIN_VALUE) {
                this.f4412a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.f4413b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f4412a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f4413b = i3;
        }
    }
}
