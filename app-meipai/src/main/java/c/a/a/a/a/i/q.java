package c.a.a.a.a.i;

import com.arashivision.insta360.basecamera.camera.BaseCamera.ConnectType;
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

public class q extends BaseCameraController {

    /* renamed from: a reason: collision with root package name */
    public static final int[] f1204a = {1, 6, 8, 3, 7, 2, 4, 9};

    /* renamed from: b reason: collision with root package name */
    public static final int[] f1205b = {1, 2};

    public class a implements C0151OooOOo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ boolean[] f1206a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1207b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1208c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1209d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ boolean[] f1210e;

        public a(boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1206a = zArr;
            this.f1207b = zArr2;
            this.f1208c = zArr3;
            this.f1209d = oooOO0o;
            this.f1210e = zArr4;
        }

        public void OooO00o(int i2, Options options) {
            if (i2 == 0) {
                boolean[] zArr = this.f1206a;
                zArr[0] = true;
                if (zArr[0] && this.f1207b[0] && this.f1208c[0]) {
                    C0149OooOO0o oooOO0o = this.f1209d;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1210e;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1209d;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class b implements C0153OooOOoo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1211a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1212b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1213c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1214d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1215e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1216f;

        public b(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1211a = iArr;
            this.f1212b = zArr;
            this.f1213c = zArr2;
            this.f1214d = zArr3;
            this.f1215e = oooOO0o;
            this.f1216f = zArr4;
        }

        public void OooO00o(int i2, PhotoOptions photoOptions) {
            if (i2 == 0) {
                int[] iArr = this.f1211a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = q.f1204a;
                if (i3 < iArr2.length) {
                    q.this.OooO00o(iArr2[iArr[0]], (List<String>) a.a.a.a.b.a.d(), (C0153OooOOoo) this);
                    return;
                }
                boolean[] zArr = this.f1212b;
                zArr[0] = true;
                if (this.f1213c[0] && zArr[0] && this.f1214d[0]) {
                    C0149OooOO0o oooOO0o = this.f1215e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1216f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1215e;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class c implements OooOo00 {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1218a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1219b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1220c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1221d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1222e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1223f;

        public c(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1218a = iArr;
            this.f1219b = zArr;
            this.f1220c = zArr2;
            this.f1221d = zArr3;
            this.f1222e = oooOO0o;
            this.f1223f = zArr4;
        }

        public void OooO00o(int i2, TimelapseOptionsInfo timelapseOptionsInfo) {
            if (i2 == 0) {
                int[] iArr = this.f1218a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = q.f1205b;
                if (i3 < iArr2.length) {
                    q.this.OooO00o(iArr2[iArr[0]], (OooOo00) this);
                    return;
                }
                boolean[] zArr = this.f1219b;
                zArr[0] = true;
                if (this.f1220c[0] && this.f1221d[0] && zArr[0]) {
                    C0149OooOO0o oooOO0o = this.f1222e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1223f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1222e;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        OooO00o(System.currentTimeMillis() / 1000, TimeZone.getDefault());
        OooO00o(OooO0O0.READY, 0);
    }

    public List<String> OooO() {
        return a.a.a.a.b.a.c();
    }

    public void OooO00o(C0149OooOO0o oooOO0o) {
        if (this.OooO0Oo != ConnectType.BLE) {
            boolean[] zArr = {false};
            boolean[] zArr2 = {false};
            boolean[] zArr3 = {false};
            boolean[] zArr4 = {false};
            ArrayList c2 = a.a.a.a.b.a.c();
            a aVar = new a(zArr, zArr2, zArr3, oooOO0o, zArr4);
            OooO00o((List<String>) c2, (C0151OooOOo) aVar);
            int[] iArr = {0};
            int i2 = f1204a[iArr[0]];
            boolean[] zArr5 = zArr;
            b bVar = r0;
            C0149OooOO0o oooOO0o2 = oooOO0o;
            ArrayList d2 = a.a.a.a.b.a.d();
            boolean[] zArr6 = zArr4;
            b bVar2 = new b(iArr, zArr2, zArr5, zArr3, oooOO0o2, zArr6);
            OooO00o(i2, (List<String>) d2, (C0153OooOOoo) bVar);
            int[] iArr2 = {0};
            int i3 = f1205b[iArr2[0]];
            c cVar = new c(iArr2, zArr3, zArr5, zArr2, oooOO0o2, zArr6);
            OooO00o(i3, (OooOo00) cVar);
        }
    }

    public GyroType OooO0o0() {
        return GyroType.One2;
    }

    public int[] OooO0oo() {
        return this.OooO0Oo == ConnectType.BLE ? new int[0] : f1204a;
    }

    public int[] OooOO0() {
        return this.OooO0Oo == ConnectType.BLE ? new int[0] : f1205b;
    }

    public boolean OooOo() {
        return false;
    }

    public void OooOooo() {
        if (this.OooO0Oo == ConnectType.BLE) {
            OooO0OO((C0154OooOo0) new i(this));
        } else {
            OooO0Oo((C0154OooOo0) new k(this));
        }
    }

    public final void a() {
        OooO0O0((C0154OooOo0) new g(this));
    }

    public final void b() {
        OooO0Oo((C0154OooOo0) new k(this));
    }
}
