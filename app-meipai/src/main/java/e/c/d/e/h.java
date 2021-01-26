package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.arashivision.sdkmedia.player.capture.InstaCapturePlayerView;
import com.baidu.picapture.ui.panorama.capture.PanoramaCaptureActivity;
import com.jaygoo.widget.RangeSeekBar;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.d.a.p0;
import e.c.d.m.d.a.t0.j.b;

/* compiled from: ActivityPanoramaCaptureBindingImpl */
public class h extends g implements OnExtClickListener {
    public static final SparseIntArray v0;
    public final ConstraintLayout d0;
    public final TextView e0;
    public final LottieAnimationView f0;
    public final TextView g0;
    public final LinearLayout h0;
    public final LottieAnimationView i0;
    public final OnClickListener j0;
    public final OnClickListener k0;
    public final OnClickListener l0;
    public final OnClickListener m0;
    public final OnClickListener n0;
    public final OnClickListener o0;
    public final OnClickListener p0;
    public final OnClickListener q0;
    public final OnClickListener r0;
    public final OnClickListener s0;
    public long t0 = -1;
    public long u0 = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v0 = sparseIntArray;
        sparseIntArray.put(R.id.preview_player, 27);
        v0.put(R.id.delay_capture_value_list, 28);
        v0.put(R.id.exposure_mode_list, 29);
        v0.put(R.id.exposure_value_seek_bar, 30);
        v0.put(R.id.white_balance_list, 31);
        v0.put(R.id.iso_list, 32);
        v0.put(R.id.shutter_speed_list, 33);
    }

    public h(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 34, (c) null, v0);
        super(dVar, view, 0, (Button) a2[3], (View) a2[5], (ImageView) a2[4], (TextView) a2[8], (LinearLayout) a2[9], (ImageView) a2[10], (RecyclerView) a2[28], (LinearLayout) a2[11], (ImageView) a2[12], (RecyclerView) a2[29], (ConstraintLayout) a2[13], (ImageView) a2[14], (TextView) a2[15], (RangeSeekBar) a2[30], (LinearLayout) a2[18], (ImageView) a2[19], (RecyclerView) a2[32], (RecyclerView) a2[22], (InstaCapturePlayerView) a2[27], (ImageView) a2[23], (View) a2[2], (LinearLayout) a2[20], (ImageView) a2[21], (RecyclerView) a2[33], (Button) a2[24], (LinearLayout) a2[16], (ImageView) a2[17], (RecyclerView) a2[31]);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.E.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.d0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) a2[1];
        this.e0 = textView;
        textView.setTag(null);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a2[25];
        this.f0 = lottieAnimationView;
        lottieAnimationView.setTag(null);
        TextView textView2 = (TextView) a2[26];
        this.g0 = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) a2[6];
        this.h0 = linearLayout;
        linearLayout.setTag(null);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) a2[7];
        this.i0 = lottieAnimationView2;
        lottieAnimationView2.setTag(null);
        this.G.setTag(null);
        this.H.setTag(null);
        this.I.setTag(null);
        this.J.setTag(null);
        this.L.setTag(null);
        this.M.setTag(null);
        this.N.setTag(null);
        view.setTag(a.dataBinding, this);
        this.j0 = new e.c.d.h.a.a(this, 5);
        this.k0 = new e.c.d.h.a.a(this, 9);
        this.l0 = new e.c.d.h.a.a(this, 4);
        this.m0 = new e.c.d.h.a.a(this, 10);
        this.n0 = new e.c.d.h.a.a(this, 3);
        this.o0 = new e.c.d.h.a.a(this, 7);
        this.p0 = new e.c.d.h.a.a(this, 2);
        this.q0 = new e.c.d.h.a.a(this, 8);
        this.r0 = new e.c.d.h.a.a(this, 1);
        this.s0 = new e.c.d.h.a.a(this, 6);
        f();
    }

    public void a(PanoramaCaptureActivity panoramaCaptureActivity) {
        this.P = panoramaCaptureActivity;
        synchronized (this) {
            this.t0 |= 128;
        }
        a(2);
        super.g();
    }

    public void b(Boolean bool) {
        this.Q = bool;
        synchronized (this) {
            this.t0 |= 2;
        }
        a(5);
        super.g();
    }

    public void c(Boolean bool) {
        this.a0 = bool;
        synchronized (this) {
            this.t0 |= 8;
        }
        a(8);
        super.g();
    }

    public void d(Boolean bool) {
        this.X = bool;
        synchronized (this) {
            this.t0 |= 512;
        }
        a(9);
        super.g();
    }

    public boolean e() {
        synchronized (this) {
            if (this.t0 == 0) {
                if (this.u0 == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public void f() {
        synchronized (this) {
            this.t0 = 32768;
            this.u0 = 0;
        }
        g();
    }

    public void g(Boolean bool) {
        this.Y = bool;
        synchronized (this) {
            this.t0 |= AppSupportContentFlag.MMAPP_SUPPORT_XLSX;
        }
        a(13);
        super.g();
    }

    public void h(Boolean bool) {
        this.T = bool;
        synchronized (this) {
            this.t0 |= 16384;
        }
        a(15);
        super.g();
    }

    public void i(Boolean bool) {
        this.c0 = bool;
        synchronized (this) {
            this.t0 |= AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        }
        a(16);
        super.g();
    }

    public void j(Boolean bool) {
        this.R = bool;
        synchronized (this) {
            this.t0 |= 32;
        }
        a(17);
        super.g();
    }

    public void k(Boolean bool) {
        this.S = bool;
        synchronized (this) {
            this.t0 |= 1;
        }
        a(18);
        super.g();
    }

    public void l(Boolean bool) {
        this.Z = bool;
        synchronized (this) {
            this.t0 |= 256;
        }
        a(19);
        super.g();
    }

    public void m(Boolean bool) {
        this.V = bool;
        synchronized (this) {
            this.t0 |= 16;
        }
        a(20);
        super.g();
    }

    public void n(Boolean bool) {
        this.b0 = bool;
        synchronized (this) {
            this.t0 |= 64;
        }
        a(21);
        super.g();
    }

    public void e(Boolean bool) {
        this.U = bool;
        synchronized (this) {
            this.t0 |= 4;
        }
        a(10);
        super.g();
    }

    public void f(Boolean bool) {
        this.W = bool;
        synchronized (this) {
            this.t0 |= AppSupportContentFlag.MMAPP_SUPPORT_PDF;
        }
        a(11);
        super.g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        Boolean valueOf = Boolean.valueOf(true);
        switch (i2) {
            case 1:
                PanoramaCaptureActivity panoramaCaptureActivity = this.P;
                if (panoramaCaptureActivity != null) {
                    z = true;
                }
                if (z) {
                    panoramaCaptureActivity.p();
                    return;
                }
                return;
            case 2:
                PanoramaCaptureActivity panoramaCaptureActivity2 = this.P;
                if (panoramaCaptureActivity2 != null) {
                    z = true;
                }
                if (z) {
                    panoramaCaptureActivity2.a(b.DELAY_CAPTURE);
                    return;
                }
                return;
            case 3:
                PanoramaCaptureActivity panoramaCaptureActivity3 = this.P;
                if (panoramaCaptureActivity3 != null) {
                    z = true;
                }
                if (z) {
                    panoramaCaptureActivity3.a(b.EXPOSURE_PROGRAM);
                    return;
                }
                return;
            case 4:
                PanoramaCaptureActivity panoramaCaptureActivity4 = this.P;
                if (panoramaCaptureActivity4 != null) {
                    z = true;
                }
                if (z) {
                    panoramaCaptureActivity4.a(b.EXPOSURE_VALUE);
                    return;
                }
                return;
            case 5:
                PanoramaCaptureActivity panoramaCaptureActivity5 = this.P;
                if (panoramaCaptureActivity5 != null) {
                    z = true;
                }
                if (z) {
                    ((g) panoramaCaptureActivity5.r).A.setProgress(0.0f);
                    return;
                }
                return;
            case 6:
                PanoramaCaptureActivity panoramaCaptureActivity6 = this.P;
                if (panoramaCaptureActivity6 != null) {
                    z = true;
                }
                if (z) {
                    panoramaCaptureActivity6.a(b.WHITE_BALANCE);
                    return;
                }
                return;
            case 7:
                PanoramaCaptureActivity panoramaCaptureActivity7 = this.P;
                if (panoramaCaptureActivity7 != null) {
                    z = true;
                }
                if (z) {
                    panoramaCaptureActivity7.a(b.ISO);
                    return;
                }
                return;
            case 8:
                PanoramaCaptureActivity panoramaCaptureActivity8 = this.P;
                if (panoramaCaptureActivity8 != null) {
                    z = true;
                }
                if (z) {
                    panoramaCaptureActivity8.a(b.SHUTTER_SPEED);
                    return;
                }
                return;
            case 9:
                PanoramaCaptureActivity panoramaCaptureActivity9 = this.P;
                if (panoramaCaptureActivity9 != null) {
                    z = true;
                }
                if (z) {
                    g gVar = (g) panoramaCaptureActivity9.r;
                    gVar.j(Boolean.valueOf(true ^ gVar.R.booleanValue()));
                    View view2 = ((g) panoramaCaptureActivity9.r).H;
                    view2.setLayoutParams(view2.getLayoutParams());
                    if (((g) panoramaCaptureActivity9.r).R.booleanValue()) {
                        panoramaCaptureActivity9.i0();
                        ((g) panoramaCaptureActivity9.r).h(valueOf);
                        return;
                    }
                    return;
                }
                return;
            case 10:
                PanoramaCaptureActivity panoramaCaptureActivity10 = this.P;
                if (panoramaCaptureActivity10 == null) {
                    z2 = false;
                }
                if (z2) {
                    ((p0) panoramaCaptureActivity10.s).A();
                    panoramaCaptureActivity10.c(false);
                    ((g) panoramaCaptureActivity10.r).n(valueOf);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0267  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0489  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x04aa  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x04bc  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x04d6  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x04e1  */
    /* JADX WARNING: Removed duplicated region for block: B:320:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r65 = this;
            r1 = r65
            monitor-enter(r65)
            long r2 = r1.t0     // Catch:{ all -> 0x04e7 }
            r4 = 0
            r1.t0 = r4     // Catch:{ all -> 0x04e7 }
            r1.u0 = r4     // Catch:{ all -> 0x04e7 }
            monitor-exit(r65)     // Catch:{ all -> 0x04e7 }
            java.lang.Boolean r0 = r1.S
            java.lang.Boolean r6 = r1.Q
            java.lang.Boolean r7 = r1.U
            java.lang.Boolean r8 = r1.a0
            java.lang.Boolean r9 = r1.V
            java.lang.Boolean r10 = r1.R
            java.lang.Boolean r11 = r1.b0
            java.lang.Boolean r12 = r1.Z
            java.lang.Boolean r13 = r1.X
            java.lang.Boolean r14 = r1.c0
            java.lang.Boolean r15 = r1.Y
            java.lang.Boolean r4 = r1.W
            java.lang.Boolean r5 = r1.T
            r18 = 32769(0x8001, double:1.619E-319)
            long r20 = r2 & r18
            r16 = 0
            int r20 = (r20 > r16 ? 1 : (r20 == r16 ? 0 : -1))
            r21 = 4
            r22 = 0
            if (r20 == 0) goto L_0x0050
            boolean r0 = androidx.databinding.ViewDataBinding.a(r0)
            if (r20 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x0043
            r23 = 8796093022208(0x80000000000, double:4.345847379897E-311)
            goto L_0x0048
        L_0x0043:
            r23 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
        L_0x0048:
            long r2 = r2 | r23
        L_0x004a:
            if (r0 == 0) goto L_0x004d
            goto L_0x0050
        L_0x004d:
            r0 = r21
            goto L_0x0052
        L_0x0050:
            r0 = r22
        L_0x0052:
            r23 = 32834(0x8042, double:1.6222E-319)
            long r25 = r2 & r23
            r16 = 0
            int r20 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            r25 = 549755813888(0x8000000000, double:2.716154612436E-312)
            r27 = 32770(0x8002, double:1.61905E-319)
            if (r20 == 0) goto L_0x00b1
            boolean r29 = androidx.databinding.ViewDataBinding.a(r6)
            if (r20 == 0) goto L_0x0081
            if (r29 == 0) goto L_0x0075
            r30 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r30
            long r2 = r2 | r25
            goto L_0x0081
        L_0x0075:
            r30 = 262144(0x40000, double:1.295163E-318)
            long r2 = r2 | r30
            r30 = 274877906944(0x4000000000, double:1.358077306218E-312)
            long r2 = r2 | r30
        L_0x0081:
            long r30 = r2 & r27
            r16 = 0
            int r20 = (r30 > r16 ? 1 : (r30 == r16 ? 0 : -1))
            if (r20 == 0) goto L_0x0098
            if (r29 == 0) goto L_0x0091
            r30 = 2199023255552(0x20000000000, double:1.0864618449742E-311)
            goto L_0x0096
        L_0x0091:
            r30 = 1099511627776(0x10000000000, double:5.43230922487E-312)
        L_0x0096:
            long r2 = r2 | r30
        L_0x0098:
            long r30 = r2 & r27
            int r20 = (r30 > r16 ? 1 : (r30 == r16 ? 0 : -1))
            if (r20 == 0) goto L_0x00ac
            if (r29 == 0) goto L_0x00a3
            r20 = r22
            goto L_0x00a5
        L_0x00a3:
            r20 = r21
        L_0x00a5:
            r64 = r20
            r20 = r0
            r0 = r64
            goto L_0x00b9
        L_0x00ac:
            r20 = r0
            r0 = r22
            goto L_0x00b9
        L_0x00b1:
            r16 = 0
            r20 = r0
            r0 = r22
            r29 = r0
        L_0x00b9:
            r30 = 32778(0x800a, double:1.61945E-319)
            long r32 = r2 & r30
            int r32 = (r32 > r16 ? 1 : (r32 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x00d2
            boolean r8 = androidx.databinding.ViewDataBinding.a(r8)
            if (r32 == 0) goto L_0x00d4
            if (r8 == 0) goto L_0x00cd
            r32 = 576460752303423488(0x800000000000000, double:3.785766995733679E-270)
            goto L_0x00cf
        L_0x00cd:
            r32 = 288230376151711744(0x400000000000000, double:2.0522684006491881E-289)
        L_0x00cf:
            long r2 = r2 | r32
            goto L_0x00d4
        L_0x00d2:
            r8 = r22
        L_0x00d4:
            r32 = 56116(0xdb34, double:2.7725E-319)
            long r32 = r2 & r32
            r16 = 0
            int r32 = (r32 > r16 ? 1 : (r32 == r16 ? 0 : -1))
            r33 = 32800(0x8020, double:1.62054E-319)
            r35 = 33056(0x8120, double:1.6332E-319)
            r37 = 32816(0x8030, double:1.62133E-319)
            r39 = 32804(0x8024, double:1.62073E-319)
            r41 = 36896(0x9020, double:1.8229E-319)
            r43 = 49184(0xc020, double:2.43E-319)
            r45 = 33312(0x8220, double:1.64583E-319)
            r47 = 34848(0x8820, double:1.7217E-319)
            if (r32 == 0) goto L_0x01a0
            boolean r10 = androidx.databinding.ViewDataBinding.a(r10)
            long r49 = r2 & r47
            r16 = 0
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x010e
            if (r10 == 0) goto L_0x0109
            r49 = 131072(0x20000, double:6.47582E-319)
            goto L_0x010c
        L_0x0109:
            r49 = 65536(0x10000, double:3.2379E-319)
        L_0x010c:
            long r2 = r2 | r49
        L_0x010e:
            long r49 = r2 & r45
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x011f
            if (r10 == 0) goto L_0x011a
            r49 = 2097152(0x200000, double:1.0361308E-317)
            goto L_0x011d
        L_0x011a:
            r49 = 1048576(0x100000, double:5.180654E-318)
        L_0x011d:
            long r2 = r2 | r49
        L_0x011f:
            long r49 = r2 & r43
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x0130
            if (r10 == 0) goto L_0x012b
            r49 = 134217728(0x8000000, double:6.63123685E-316)
            goto L_0x012e
        L_0x012b:
            r49 = 67108864(0x4000000, double:3.31561842E-316)
        L_0x012e:
            long r2 = r2 | r49
        L_0x0130:
            long r49 = r2 & r41
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x0145
            if (r10 == 0) goto L_0x013e
            r49 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x0143
        L_0x013e:
            r49 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x0143:
            long r2 = r2 | r49
        L_0x0145:
            long r49 = r2 & r39
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x015a
            if (r10 == 0) goto L_0x0153
            r49 = 35184372088832(0x200000000000, double:1.73833895195875E-310)
            goto L_0x0158
        L_0x0153:
            r49 = 17592186044416(0x100000000000, double:8.6916947597938E-311)
        L_0x0158:
            long r2 = r2 | r49
        L_0x015a:
            long r49 = r2 & r37
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x016f
            if (r10 == 0) goto L_0x0168
            r49 = 140737488355328(0x800000000000, double:6.953355807835E-310)
            goto L_0x016d
        L_0x0168:
            r49 = 70368744177664(0x400000000000, double:3.4766779039175E-310)
        L_0x016d:
            long r2 = r2 | r49
        L_0x016f:
            long r49 = r2 & r35
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x017e
            if (r10 == 0) goto L_0x017a
            r49 = 2251799813685248(0x8000000000000, double:1.1125369292536007E-308)
            goto L_0x017c
        L_0x017a:
            r49 = 1125899906842624(0x4000000000000, double:5.562684646268003E-309)
        L_0x017c:
            long r2 = r2 | r49
        L_0x017e:
            long r49 = r2 & r33
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x018d
            if (r10 == 0) goto L_0x0189
            r49 = -9223372036854775808
            goto L_0x018b
        L_0x0189:
            r49 = 4611686018427387904(0x4000000000000000, double:2.0)
        L_0x018b:
            long r2 = r2 | r49
        L_0x018d:
            long r49 = r2 & r33
            int r32 = (r49 > r16 ? 1 : (r49 == r16 ? 0 : -1))
            if (r32 == 0) goto L_0x019d
            if (r10 == 0) goto L_0x0198
            r32 = r22
            goto L_0x019a
        L_0x0198:
            r32 = r21
        L_0x019a:
            r51 = r32
            goto L_0x01a6
        L_0x019d:
            r51 = r22
            goto L_0x01a6
        L_0x01a0:
            r16 = 0
            r10 = r22
            r51 = r10
        L_0x01a6:
            r49 = 32832(0x8040, double:1.6221E-319)
            long r52 = r2 & r49
            int r32 = (r52 > r16 ? 1 : (r52 == r16 ? 0 : -1))
            r52 = 144115188075855872(0x200000000000000, double:4.7783097267364807E-299)
            r54 = 72057594037927936(0x100000000000000, double:7.2911220195563975E-304)
            if (r32 == 0) goto L_0x01da
            boolean r56 = androidx.databinding.ViewDataBinding.a(r11)
            if (r32 == 0) goto L_0x01c0
            if (r56 == 0) goto L_0x01be
            long r2 = r2 | r52
            goto L_0x01c0
        L_0x01be:
            long r2 = r2 | r54
        L_0x01c0:
            r32 = r56 ^ 1
            if (r56 == 0) goto L_0x01c7
            r57 = r22
            goto L_0x01c9
        L_0x01c7:
            r57 = r21
        L_0x01c9:
            java.lang.Boolean r58 = java.lang.Boolean.valueOf(r32)
            boolean r58 = androidx.databinding.ViewDataBinding.a(r58)
            r64 = r57
            r57 = r0
            r0 = r58
            r58 = r64
            goto L_0x01e4
        L_0x01da:
            r57 = r0
            r0 = r22
            r32 = r0
            r56 = r32
            r58 = r56
        L_0x01e4:
            r59 = 33792(0x8400, double:1.66955E-319)
            long r61 = r2 & r59
            r16 = 0
            int r61 = (r61 > r16 ? 1 : (r61 == r16 ? 0 : -1))
            if (r61 == 0) goto L_0x0206
            boolean r14 = androidx.databinding.ViewDataBinding.a(r14)
            if (r61 == 0) goto L_0x0204
            if (r14 == 0) goto L_0x01fd
            r61 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x0202
        L_0x01fd:
            r61 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x0202:
            long r2 = r2 | r61
        L_0x0204:
            if (r14 == 0) goto L_0x0209
        L_0x0206:
            r14 = r22
            goto L_0x020b
        L_0x0209:
            r14 = r21
        L_0x020b:
            r61 = 549756076032(0x8000040000, double:2.7161559076E-312)
            long r61 = r2 & r61
            r16 = 0
            int r61 = (r61 > r16 ? 1 : (r61 == r16 ? 0 : -1))
            if (r61 == 0) goto L_0x0231
            boolean r56 = androidx.databinding.ViewDataBinding.a(r11)
            long r61 = r2 & r49
            int r11 = (r61 > r16 ? 1 : (r61 == r16 ? 0 : -1))
            if (r11 == 0) goto L_0x0229
            if (r56 == 0) goto L_0x0227
            long r2 = r2 | r52
            goto L_0x0229
        L_0x0227:
            long r2 = r2 | r54
        L_0x0229:
            long r25 = r2 & r25
            int r11 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r11 == 0) goto L_0x0231
            r32 = r56 ^ 1
        L_0x0231:
            long r25 = r2 & r47
            r16 = 0
            int r11 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r11 == 0) goto L_0x025d
            if (r10 == 0) goto L_0x0240
            boolean r15 = r15.booleanValue()
            goto L_0x0242
        L_0x0240:
            r15 = r22
        L_0x0242:
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r15)
            boolean r15 = androidx.databinding.ViewDataBinding.a(r15)
            if (r11 == 0) goto L_0x0257
            if (r15 == 0) goto L_0x0252
            r25 = 8388608(0x800000, double:4.144523E-317)
            goto L_0x0255
        L_0x0252:
            r25 = 4194304(0x400000, double:2.0722615E-317)
        L_0x0255:
            long r2 = r2 | r25
        L_0x0257:
            if (r15 == 0) goto L_0x025a
            goto L_0x025d
        L_0x025a:
            r11 = r21
            goto L_0x025f
        L_0x025d:
            r11 = r22
        L_0x025f:
            long r25 = r2 & r23
            r15 = 0
            int r25 = (r25 > r15 ? 1 : (r25 == r15 ? 0 : -1))
            if (r25 == 0) goto L_0x028d
            if (r29 == 0) goto L_0x026b
            r56 = 1
        L_0x026b:
            if (r29 == 0) goto L_0x026e
            goto L_0x0270
        L_0x026e:
            r32 = r22
        L_0x0270:
            if (r25 == 0) goto L_0x027b
            if (r56 == 0) goto L_0x0277
            r25 = 36028797018963968(0x80000000000000, double:2.8480945388892178E-306)
            goto L_0x0279
        L_0x0277:
            r25 = 18014398509481984(0x40000000000000, double:1.7800590868057611E-307)
        L_0x0279:
            long r2 = r2 | r25
        L_0x027b:
            if (r56 == 0) goto L_0x0280
            r15 = r21
            goto L_0x0282
        L_0x0280:
            r15 = r22
        L_0x0282:
            java.lang.Boolean r25 = java.lang.Boolean.valueOf(r32)
            boolean r25 = androidx.databinding.ViewDataBinding.a(r25)
            r63 = r25
            goto L_0x0291
        L_0x028d:
            r15 = r22
            r63 = r15
        L_0x0291:
            long r25 = r2 & r45
            r16 = 0
            int r25 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r25 == 0) goto L_0x02bb
            if (r10 == 0) goto L_0x02a0
            boolean r13 = r13.booleanValue()
            goto L_0x02a2
        L_0x02a0:
            r13 = r22
        L_0x02a2:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            boolean r13 = androidx.databinding.ViewDataBinding.a(r13)
            if (r25 == 0) goto L_0x02b5
            if (r13 == 0) goto L_0x02b1
            r25 = 9007199254740992(0x20000000000000, double:4.450147717014403E-308)
            goto L_0x02b3
        L_0x02b1:
            r25 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
        L_0x02b3:
            long r2 = r2 | r25
        L_0x02b5:
            if (r13 == 0) goto L_0x02b8
            goto L_0x02bb
        L_0x02b8:
            r13 = r21
            goto L_0x02bd
        L_0x02bb:
            r13 = r22
        L_0x02bd:
            long r25 = r2 & r43
            r16 = 0
            int r25 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r25 == 0) goto L_0x02e9
            if (r10 == 0) goto L_0x02cc
            boolean r5 = r5.booleanValue()
            goto L_0x02ce
        L_0x02cc:
            r5 = r22
        L_0x02ce:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            boolean r5 = androidx.databinding.ViewDataBinding.a(r5)
            if (r25 == 0) goto L_0x02e3
            if (r5 == 0) goto L_0x02de
            r25 = 536870912(0x20000000, double:2.652494739E-315)
            goto L_0x02e1
        L_0x02de:
            r25 = 268435456(0x10000000, double:1.32624737E-315)
        L_0x02e1:
            long r2 = r2 | r25
        L_0x02e3:
            if (r5 == 0) goto L_0x02e6
            goto L_0x02e9
        L_0x02e6:
            r5 = r21
            goto L_0x02eb
        L_0x02e9:
            r5 = r22
        L_0x02eb:
            long r25 = r2 & r41
            r16 = 0
            int r25 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r25 == 0) goto L_0x0315
            if (r10 == 0) goto L_0x02fa
            boolean r4 = r4.booleanValue()
            goto L_0x02fc
        L_0x02fa:
            r4 = r22
        L_0x02fc:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r4 = androidx.databinding.ViewDataBinding.a(r4)
            if (r25 == 0) goto L_0x030f
            if (r4 == 0) goto L_0x030b
            r25 = 562949953421312(0x2000000000000, double:2.781342323134002E-309)
            goto L_0x030d
        L_0x030b:
            r25 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
        L_0x030d:
            long r2 = r2 | r25
        L_0x030f:
            if (r4 == 0) goto L_0x0312
            goto L_0x0315
        L_0x0312:
            r4 = r21
            goto L_0x0317
        L_0x0315:
            r4 = r22
        L_0x0317:
            long r25 = r2 & r39
            r16 = 0
            int r25 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r25 == 0) goto L_0x0347
            if (r10 == 0) goto L_0x0326
            boolean r7 = r7.booleanValue()
            goto L_0x0328
        L_0x0326:
            r7 = r22
        L_0x0328:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            boolean r7 = androidx.databinding.ViewDataBinding.a(r7)
            if (r25 == 0) goto L_0x0341
            if (r7 == 0) goto L_0x033a
            r25 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x033f
        L_0x033a:
            r25 = 4294967296(0x100000000, double:2.121995791E-314)
        L_0x033f:
            long r2 = r2 | r25
        L_0x0341:
            if (r7 == 0) goto L_0x0344
            goto L_0x0347
        L_0x0344:
            r7 = r21
            goto L_0x0349
        L_0x0347:
            r7 = r22
        L_0x0349:
            long r25 = r2 & r37
            r16 = 0
            int r25 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r25 == 0) goto L_0x0373
            if (r10 == 0) goto L_0x0358
            boolean r9 = r9.booleanValue()
            goto L_0x035a
        L_0x0358:
            r9 = r22
        L_0x035a:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            boolean r9 = androidx.databinding.ViewDataBinding.a(r9)
            if (r25 == 0) goto L_0x036d
            if (r9 == 0) goto L_0x0369
            r25 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            goto L_0x036b
        L_0x0369:
            r25 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
        L_0x036b:
            long r2 = r2 | r25
        L_0x036d:
            if (r9 == 0) goto L_0x0370
            goto L_0x0373
        L_0x0370:
            r9 = r21
            goto L_0x0375
        L_0x0373:
            r9 = r22
        L_0x0375:
            long r25 = r2 & r35
            r16 = 0
            int r25 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r25 == 0) goto L_0x03a1
            if (r10 == 0) goto L_0x0384
            boolean r10 = r12.booleanValue()
            goto L_0x0386
        L_0x0384:
            r10 = r22
        L_0x0386:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            boolean r10 = androidx.databinding.ViewDataBinding.a(r10)
            if (r25 == 0) goto L_0x039b
            if (r10 == 0) goto L_0x0396
            r25 = 33554432(0x2000000, double:1.6578092E-316)
            goto L_0x0399
        L_0x0396:
            r25 = 16777216(0x1000000, double:8.289046E-317)
        L_0x0399:
            long r2 = r2 | r25
        L_0x039b:
            if (r10 == 0) goto L_0x039e
            goto L_0x03a1
        L_0x039e:
            r10 = r21
            goto L_0x03a3
        L_0x03a1:
            r10 = r22
        L_0x03a3:
            long r25 = r2 & r30
            r16 = 0
            int r12 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x03d2
            if (r8 == 0) goto L_0x03b2
            boolean r6 = r6.booleanValue()
            goto L_0x03b4
        L_0x03b2:
            r6 = r22
        L_0x03b4:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            boolean r6 = androidx.databinding.ViewDataBinding.a(r6)
            if (r12 == 0) goto L_0x03cb
            if (r6 == 0) goto L_0x03c6
            r25 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x03c9
        L_0x03c6:
            r25 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x03c9:
            long r2 = r2 | r25
        L_0x03cb:
            if (r6 == 0) goto L_0x03cf
            r21 = r22
        L_0x03cf:
            r6 = r21
            goto L_0x03d4
        L_0x03d2:
            r6 = r22
        L_0x03d4:
            long r21 = r2 & r49
            r16 = 0
            int r8 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r8 == 0) goto L_0x03ed
            android.widget.Button r8 = r1.n
            r8.setEnabled(r0)
            com.airbnb.lottie.LottieAnimationView r0 = r1.f0
            r8 = r58
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.g0
            r0.setVisibility(r8)
        L_0x03ed:
            r21 = 32768(0x8000, double:1.61895E-319)
            long r21 = r2 & r21
            r16 = 0
            int r0 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x043e
            android.widget.Button r0 = r1.n
            android.view.View$OnClickListener r8 = r1.r0
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r1.s
            android.view.View$OnClickListener r8 = r1.p0
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r1.v
            android.view.View$OnClickListener r8 = r1.n0
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r1.y
            android.view.View$OnClickListener r8 = r1.l0
            r0.setOnClickListener(r8)
            android.widget.TextView r0 = r1.z
            android.view.View$OnClickListener r8 = r1.j0
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r1.C
            android.view.View$OnClickListener r8 = r1.o0
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r1.G
            android.view.View$OnClickListener r8 = r1.k0
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r1.J
            android.view.View$OnClickListener r8 = r1.q0
            r0.setOnClickListener(r8)
            android.widget.Button r0 = r1.L
            android.view.View$OnClickListener r8 = r1.m0
            r0.setOnClickListener(r8)
            android.widget.ImageView r0 = r1.N
            android.view.View$OnClickListener r8 = r1.s0
            r0.setOnClickListener(r8)
        L_0x043e:
            long r21 = r2 & r27
            r16 = 0
            int r0 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0457
            android.view.View r0 = r1.o
            r8 = r57
            r0.setVisibility(r8)
            android.widget.ImageView r0 = r1.p
            r0.setVisibility(r8)
            android.widget.TextView r0 = r1.e0
            r0.setVisibility(r8)
        L_0x0457:
            long r21 = r2 & r30
            int r0 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0462
            android.widget.TextView r0 = r1.q
            r0.setVisibility(r6)
        L_0x0462:
            long r21 = r2 & r45
            int r0 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x046d
            android.widget.LinearLayout r0 = r1.r
            r0.setVisibility(r13)
        L_0x046d:
            long r12 = r2 & r41
            int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0478
            android.widget.LinearLayout r0 = r1.u
            r0.setVisibility(r4)
        L_0x0478:
            long r12 = r2 & r39
            int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0483
            androidx.constraintlayout.widget.ConstraintLayout r0 = r1.x
            r0.setVisibility(r7)
        L_0x0483:
            long r6 = r2 & r47
            int r0 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x048e
            android.widget.LinearLayout r0 = r1.B
            r0.setVisibility(r11)
        L_0x048e:
            long r6 = r2 & r43
            int r0 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0499
            androidx.recyclerview.widget.RecyclerView r0 = r1.E
            r0.setVisibility(r5)
        L_0x0499:
            long r4 = r2 & r59
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04a4
            android.widget.LinearLayout r0 = r1.h0
            r0.setVisibility(r14)
        L_0x04a4:
            long r4 = r2 & r23
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04b6
            com.airbnb.lottie.LottieAnimationView r0 = r1.i0
            r0.setVisibility(r15)
            android.widget.Button r0 = r1.L
            r4 = r63
            r0.setEnabled(r4)
        L_0x04b6:
            long r4 = r2 & r18
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04c3
            android.widget.ImageView r0 = r1.G
            r4 = r20
            r0.setVisibility(r4)
        L_0x04c3:
            long r4 = r2 & r33
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04d0
            android.view.View r0 = r1.H
            r4 = r51
            r0.setVisibility(r4)
        L_0x04d0:
            long r4 = r2 & r35
            int r0 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04db
            android.widget.LinearLayout r0 = r1.I
            r0.setVisibility(r10)
        L_0x04db:
            long r2 = r2 & r37
            int r0 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x04e6
            android.widget.LinearLayout r0 = r1.M
            r0.setVisibility(r9)
        L_0x04e6:
            return
        L_0x04e7:
            r0 = move-exception
            monitor-exit(r65)     // Catch:{ all -> 0x04e7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.e.h.b():void");
    }
}
