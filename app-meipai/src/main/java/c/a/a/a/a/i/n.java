package c.a.a.a.a.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera.OooO0O0;
import com.arashivision.insta360.basecamera.camera.BaseCameraController;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0149OooOO0o;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0151OooOOo;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0153OooOOoo;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.C0154OooOo0;
import com.arashivision.insta360.basecamera.camera.BaseCameraController.OooOo00;
import com.arashivision.onecamera.Options;
import com.arashivision.onecamera.PhotoOptions;
import com.arashivision.onecamera.camerarequest.TimelapseOptionsInfo;
import com.arashivision.onestream.Gyro.GyroType;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class n extends BaseCameraController {

    /* renamed from: a reason: collision with root package name */
    public static final int[] f1161a = {6, 8, 3, 7, 10, 4, 2, 11, 0};

    /* renamed from: b reason: collision with root package name */
    public static final int[] f1162b = {1, 2, 3, 4};

    public class a implements C0151OooOOo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ boolean[] f1163a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1164b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1165c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1166d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ boolean[] f1167e;

        public a(boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1163a = zArr;
            this.f1164b = zArr2;
            this.f1165c = zArr3;
            this.f1166d = oooOO0o;
            this.f1167e = zArr4;
        }

        public void OooO00o(int i2, Options options) {
            if (i2 == 0) {
                boolean[] zArr = this.f1163a;
                zArr[0] = true;
                if (zArr[0] && this.f1164b[0] && this.f1165c[0]) {
                    C0149OooOO0o oooOO0o = this.f1166d;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1167e;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1166d;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class b implements C0153OooOOoo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1168a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1169b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1170c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1171d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1172e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1173f;

        public b(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1168a = iArr;
            this.f1169b = zArr;
            this.f1170c = zArr2;
            this.f1171d = zArr3;
            this.f1172e = oooOO0o;
            this.f1173f = zArr4;
        }

        public void OooO00o(int i2, PhotoOptions photoOptions) {
            if (i2 == 0) {
                int[] iArr = this.f1168a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = n.f1161a;
                if (i3 < iArr2.length) {
                    n.this.OooO00o(iArr2[iArr[0]], (List<String>) a.a.a.a.b.a.d(), (C0153OooOOoo) this);
                    return;
                }
                boolean[] zArr = this.f1169b;
                zArr[0] = true;
                if (this.f1170c[0] && zArr[0] && this.f1171d[0]) {
                    C0149OooOO0o oooOO0o = this.f1172e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1173f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1172e;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class c implements OooOo00 {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1175a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1176b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1177c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1178d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1179e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1180f;

        public c(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1175a = iArr;
            this.f1176b = zArr;
            this.f1177c = zArr2;
            this.f1178d = zArr3;
            this.f1179e = oooOO0o;
            this.f1180f = zArr4;
        }

        public void OooO00o(int i2, TimelapseOptionsInfo timelapseOptionsInfo) {
            if (i2 == 0) {
                int[] iArr = this.f1175a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = n.f1162b;
                if (i3 < iArr2.length) {
                    n.this.OooO00o(iArr2[iArr[0]], (OooOo00) this);
                    return;
                }
                boolean[] zArr = this.f1176b;
                zArr[0] = true;
                if (this.f1177c[0] && this.f1178d[0] && zArr[0]) {
                    C0149OooOO0o oooOO0o = this.f1179e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1180f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1179e;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        OooO00o(System.currentTimeMillis() / 1000, TimeZone.getDefault());
        OooO00o(OooO0O0.READY, 0);
    }

    public List<String> OooO() {
        return a.a.a.a.b.a.c();
    }

    public void OooO00o(C0149OooOO0o oooOO0o) {
        boolean[] zArr = {false};
        boolean[] zArr2 = {false};
        boolean[] zArr3 = {false};
        boolean[] zArr4 = {false};
        ArrayList c2 = a.a.a.a.b.a.c();
        a aVar = new a(zArr, zArr2, zArr3, oooOO0o, zArr4);
        OooO00o((List<String>) c2, (C0151OooOOo) aVar);
        int[] iArr = {0};
        int i2 = f1161a[iArr[0]];
        boolean[] zArr5 = zArr;
        b bVar = r0;
        C0149OooOO0o oooOO0o2 = oooOO0o;
        ArrayList d2 = a.a.a.a.b.a.d();
        boolean[] zArr6 = zArr4;
        b bVar2 = new b(iArr, zArr2, zArr5, zArr3, oooOO0o2, zArr6);
        OooO00o(i2, (List<String>) d2, (C0153OooOOoo) bVar);
        int[] iArr2 = {0};
        int i3 = f1162b[iArr2[0]];
        c cVar = new c(iArr2, zArr3, zArr5, zArr2, oooOO0o2, zArr6);
        OooO00o(i3, (OooOo00) cVar);
    }

    public GyroType OooO0o0() {
        return GyroType.Unknown;
    }

    public int[] OooO0oo() {
        return f1161a;
    }

    public int[] OooOO0() {
        return f1162b;
    }

    public boolean OooOo() {
        return false;
    }

    public void OooOooo() {
        OooO0Oo((C0154OooOo0) new l(this));
    }

    public final void a() {
        OooO0O0((C0154OooOo0) new d(this));
    }
}
