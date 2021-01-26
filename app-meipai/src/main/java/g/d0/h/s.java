package g.d0.h;

import com.arashivision.graphicpath.render.source.AssetInfo.SubMediaType;

/* compiled from: Settings */
public final class s {

    /* renamed from: a reason: collision with root package name */
    public int f9433a;

    /* renamed from: b reason: collision with root package name */
    public final int[] f9434b = new int[10];

    public s a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f9434b;
            if (i2 < iArr.length) {
                this.f9433a = (1 << i2) | this.f9433a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    public int a() {
        return (this.f9433a & 128) != 0 ? this.f9434b[7] : SubMediaType.UNDEFINED;
    }
}
