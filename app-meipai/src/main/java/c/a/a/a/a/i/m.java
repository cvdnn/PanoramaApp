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

public class m extends BaseCameraController {

    /* renamed from: a reason: collision with root package name */
    public static final int[] f1140a = {1, 6, 8, 3, 5, 7, 2, 4, 9, 12, 13};

    /* renamed from: b reason: collision with root package name */
    public static final int[] f1141b = {1, 2};

    public class a implements C0151OooOOo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ boolean[] f1142a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1143b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1144c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1145d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ boolean[] f1146e;

        public a(boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1142a = zArr;
            this.f1143b = zArr2;
            this.f1144c = zArr3;
            this.f1145d = oooOO0o;
            this.f1146e = zArr4;
        }

        public void OooO00o(int i2, Options options) {
            if (i2 == 0) {
                boolean[] zArr = this.f1142a;
                zArr[0] = true;
                if (zArr[0] && this.f1143b[0] && this.f1144c[0]) {
                    C0149OooOO0o oooOO0o = this.f1145d;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1146e;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1145d;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class b implements C0153OooOOoo {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1147a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1148b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1149c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1150d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1151e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1152f;

        public b(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1147a = iArr;
            this.f1148b = zArr;
            this.f1149c = zArr2;
            this.f1150d = zArr3;
            this.f1151e = oooOO0o;
            this.f1152f = zArr4;
        }

        public void OooO00o(int i2, PhotoOptions photoOptions) {
            if (i2 == 0) {
                int[] iArr = this.f1147a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = m.f1140a;
                if (i3 < iArr2.length) {
                    m.this.OooO00o(iArr2[iArr[0]], (List<String>) a.a.a.a.b.a.d(), (C0153OooOOoo) this);
                    return;
                }
                boolean[] zArr = this.f1148b;
                zArr[0] = true;
                if (this.f1149c[0] && zArr[0] && this.f1150d[0]) {
                    C0149OooOO0o oooOO0o = this.f1151e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1152f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1151e;
                if (oooOO0o2 != null) {
                    oooOO0o2.OooO00o(i2);
                }
            }
        }
    }

    public class c implements OooOo00 {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int[] f1154a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ boolean[] f1155b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ boolean[] f1156c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ boolean[] f1157d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ C0149OooOO0o f1158e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ boolean[] f1159f;

        public c(int[] iArr, boolean[] zArr, boolean[] zArr2, boolean[] zArr3, C0149OooOO0o oooOO0o, boolean[] zArr4) {
            this.f1154a = iArr;
            this.f1155b = zArr;
            this.f1156c = zArr2;
            this.f1157d = zArr3;
            this.f1158e = oooOO0o;
            this.f1159f = zArr4;
        }

        public void OooO00o(int i2, TimelapseOptionsInfo timelapseOptionsInfo) {
            if (i2 == 0) {
                int[] iArr = this.f1154a;
                iArr[0] = iArr[0] + 1;
                int i3 = iArr[0];
                int[] iArr2 = m.f1141b;
                if (i3 < iArr2.length) {
                    m.this.OooO00o(iArr2[iArr[0]], (OooOo00) this);
                    return;
                }
                boolean[] zArr = this.f1155b;
                zArr[0] = true;
                if (this.f1156c[0] && this.f1157d[0] && zArr[0]) {
                    C0149OooOO0o oooOO0o = this.f1158e;
                    if (oooOO0o != null) {
                        oooOO0o.OooO00o(0);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean[] zArr2 = this.f1159f;
            if (!zArr2[0]) {
                zArr2[0] = true;
                C0149OooOO0o oooOO0o2 = this.f1158e;
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

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        if (this.OooOOoo) {
            OooO00o(System.currentTimeMillis() / 1000, TimeZone.getDefault());
            OooO00o(OooO0O0.FAKE_READY, 0);
            return;
        }
        OooO0O0((C0154OooOo0) new b(this));
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
            int i2 = f1140a[iArr[0]];
            boolean[] zArr5 = zArr;
            b bVar = r0;
            C0149OooOO0o oooOO0o2 = oooOO0o;
            ArrayList d2 = a.a.a.a.b.a.d();
            boolean[] zArr6 = zArr4;
            b bVar2 = new b(iArr, zArr2, zArr5, zArr3, oooOO0o2, zArr6);
            OooO00o(i2, (List<String>) d2, (C0153OooOOoo) bVar);
            int[] iArr2 = {0};
            int i3 = f1141b[iArr2[0]];
            c cVar = new c(iArr2, zArr3, zArr5, zArr2, oooOO0o2, zArr6);
            OooO00o(i3, (OooOo00) cVar);
        }
    }

    public GyroType OooO0o0() {
        return GyroType.OneR;
    }

    public int[] OooO0oo() {
        return this.OooO0Oo == ConnectType.BLE ? new int[0] : f1140a;
    }

    public int[] OooOO0() {
        return this.OooO0Oo == ConnectType.BLE ? new int[0] : f1141b;
    }

    public boolean OooOo() {
        return true;
    }

    public void OooOooo() {
        if (this.OooO0Oo == ConnectType.BLE) {
            OooO0OO((C0154OooOo0) new a(this));
        } else {
            OooO0Oo((C0154OooOo0) new c(this));
        }
    }

    public final void a() {
        OooO0Oo((C0154OooOo0) new c(this));
    }
}
