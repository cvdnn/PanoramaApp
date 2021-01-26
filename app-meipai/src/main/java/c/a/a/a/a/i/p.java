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

public class p extends BaseCameraController {

    /* renamed from: a reason: collision with root package name */
    public static final int[] f1183a = {1, 6, 8, 3, 5, 7, 2, 4, 9, 13};

    /* renamed from: b reason: collision with root package name */
    public static final int[] f1184b = {1, 2};

    public class a implements C0151OooOOo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ boolean[] f1185a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1186b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1187c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1188d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ boolean[] f1189e;

        public a(boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1185a = zArr;
            this.f1186b = zArr2;
            this.f1187c = zArr3;
            this.f1188d = oooOO0o;
            this.f1189e = zArr4;
        }

        public void OooO00o(int i2, Options options) {
            if (i2 == 0) {
                boolean[] zArr = this.f1185a;
                zArr[0] = true;
                if (zArr[0] && this.f1186b[0] && this.f1187c[0]) {
                    C0149OooOO0o oooOO0o = this.f1188d;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1189e;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1188d;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class b implements C0153OooOOoo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1190a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1191b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1192c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1193d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1194e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1195f;

        public b(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1190a = iArr;
            this.f1191b = zArr;
            this.f1192c = zArr2;
            this.f1193d = zArr3;
            this.f1194e = oooOO0o;
            this.f1195f = zArr4;
        }

        public void OooO00o(int i2, PhotoOptions photoOptions) {
            if (i2 == 0) {
                int[] iArr = this.f1190a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = p.f1183a;
                if (i3 < iArr2.length) {
                    p.this.OooO00o(iArr2[iArr[0]], (List<String>) a.a.a.a.b.a.d(), (C0153OooOOoo) this);
                    return;
                }
                boolean[] zArr = this.f1191b;
                zArr[0] = true;
                if (this.f1192c[0] && zArr[0] && this.f1193d[0]) {
                    C0149OooOO0o oooOO0o = this.f1194e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1195f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1194e;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class c implements OooOo00 {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1197a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1198b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1199c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1200d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1201e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1202f;

        public c(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1197a = iArr;
            this.f1198b = zArr;
            this.f1199c = zArr2;
            this.f1200d = zArr3;
            this.f1201e = oooOO0o;
            this.f1202f = zArr4;
        }

        public void OooO00o(int i2, TimelapseOptionsInfo timelapseOptionsInfo) {
            if (i2 == 0) {
                int[] iArr = this.f1197a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = p.f1184b;
                if (i3 < iArr2.length) {
                    p.this.OooO00o(iArr2[iArr[0]], (OooOo00) this);
                    return;
                }
                boolean[] zArr = this.f1198b;
                zArr[0] = true;
                if (this.f1199c[0] && this.f1200d[0] && zArr[0]) {
                    C0149OooOO0o oooOO0o = this.f1201e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1202f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1201e;
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
            int i2 = f1183a[iArr[0]];
            boolean[] zArr5 = zArr;
            b bVar = r0;
            C0149OooOO0o oooOO0o2 = oooOO0o;
            ArrayList d2 = a.a.a.a.b.a.d();
            boolean[] zArr6 = zArr4;
            b bVar2 = new b(iArr, zArr2, zArr5, zArr3, oooOO0o2, zArr6);
            OooO00o(i2, (List<String>) d2, (C0153OooOOoo) bVar);
            int[] iArr2 = {0};
            int i3 = f1184b[iArr2[0]];
            c cVar = new c(iArr2, zArr3, zArr5, zArr2, oooOO0o2, zArr6);
            OooO00o(i3, (OooOo00) cVar);
        }
    }

    public GyroType OooO0o0() {
        return GyroType.Unknown;
    }

    public int[] OooO0oo() {
        return this.OooO0Oo == ConnectType.BLE ? new int[0] : f1183a;
    }

    public int[] OooOO0() {
        return this.OooO0Oo == ConnectType.BLE ? new int[0] : f1184b;
    }

    public boolean OooOo() {
        return false;
    }

    public void OooOooo() {
        if (this.OooO0Oo == ConnectType.BLE) {
            OooO0OO((C0154OooOo0) new j(this));
        } else {
            OooO0Oo((C0154OooOo0) new h(this));
        }
    }

    public final void a() {
        OooO0O0((C0154OooOo0) new f(this));
    }

    public final void b() {
        OooO0Oo((C0154OooOo0) new h(this));
    }
}
