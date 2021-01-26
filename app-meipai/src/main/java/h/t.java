package h;

/* compiled from: Segment */
public final class t {

    /* renamed from: a reason: collision with root package name */
    public final byte[] f9679a;

    /* renamed from: b reason: collision with root package name */
    public int f9680b;

    /* renamed from: c reason: collision with root package name */
    public int f9681c;

    /* renamed from: d reason: collision with root package name */
    public boolean f9682d;

    /* renamed from: e reason: collision with root package name */
    public boolean f9683e;

    /* renamed from: f reason: collision with root package name */
    public t f9684f;

    /* renamed from: g reason: collision with root package name */
    public t f9685g;

    public t() {
        this.f9679a = new byte[8192];
        this.f9683e = true;
        this.f9682d = false;
    }

    public final t a() {
        t tVar = this.f9684f;
        if (tVar == this) {
            tVar = null;
        }
        t tVar2 = this.f9685g;
        tVar2.f9684f = this.f9684f;
        this.f9684f.f9685g = tVar2;
        this.f9684f = null;
        this.f9685g = null;
        return tVar;
    }

    public final t b() {
        this.f9682d = true;
        t tVar = new t(this.f9679a, this.f9680b, this.f9681c, true, false);
        return tVar;
    }

    public t(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f9679a = bArr;
        this.f9680b = i2;
        this.f9681c = i3;
        this.f9682d = z;
        this.f9683e = z2;
    }

    public final t a(t tVar) {
        tVar.f9685g = this;
        tVar.f9684f = this.f9684f;
        this.f9684f.f9685g = tVar;
        this.f9684f = tVar;
        return tVar;
    }

    public final void a(t tVar, int i2) {
        if (tVar.f9683e) {
            int i3 = tVar.f9681c;
            if (i3 + i2 > 8192) {
                if (!tVar.f9682d) {
                    int i4 = i3 + i2;
                    int i5 = tVar.f9680b;
                    if (i4 - i5 <= 8192) {
                        byte[] bArr = tVar.f9679a;
                        System.arraycopy(bArr, i5, bArr, 0, i3 - i5);
                        tVar.f9681c -= tVar.f9680b;
                        tVar.f9680b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f9679a, this.f9680b, tVar.f9679a, tVar.f9681c, i2);
            tVar.f9681c += i2;
            this.f9680b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
