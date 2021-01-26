package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.detail.SpinDetailActivity;
import com.baidu.picapture.ui.widget.CircleProgressBar;
import com.baidu.picapture.ui.widget.HotGridView;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.e.b.o;

/* compiled from: ActivitySpinTaskDetailBindingImpl */
public class z extends y implements OnExtClickListener {
    public static final c L;
    public static final SparseIntArray M;
    public final ConstraintLayout A;
    public final Button B;
    public final Button C;
    public final ConstraintLayout D;
    public final LottieAnimationView E;
    public final ImageView F;
    public final OnClickListener G;
    public final OnClickListener H;
    public final OnClickListener I;
    public final OnClickListener J;
    public long K = -1;

    static {
        c cVar = new c(14);
        L = cVar;
        cVar.a(0, new String[]{"navigation_bar"}, new int[]{9}, new int[]{R.layout.navigation_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        M = sparseIntArray;
        sparseIntArray.put(R.id.cover_image, 10);
        M.put(R.id.ll_hot_spot_collection, 11);
        M.put(R.id.gv_hot_spot, 12);
        M.put(R.id.create_content_text, 13);
    }

    public z(d dVar, View view) {
        View view2 = view;
        Object[] a2 = ViewDataBinding.a(dVar, view2, 14, L, M);
        super(dVar, view, 1, (Button) a2[2], (ImageView) a2[10], (TextView) a2[13], (HotGridView) a2[12], (k0) a2[9], (LinearLayout) a2[11], (FrameLayout) a2[1], (CircleProgressBar) a2[8]);
        this.n.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.A = constraintLayout;
        constraintLayout.setTag(null);
        Button button = (Button) a2[3];
        this.B = button;
        button.setTag(null);
        Button button2 = (Button) a2[4];
        this.C = button2;
        button2.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a2[5];
        this.D = constraintLayout2;
        constraintLayout2.setTag(null);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a2[6];
        this.E = lottieAnimationView;
        lottieAnimationView.setTag(null);
        ImageView imageView = (ImageView) a2[7];
        this.F = imageView;
        imageView.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        view2.setTag(a.dataBinding, this);
        this.G = new e.c.d.h.a.a(this, 3);
        this.H = new e.c.d.h.a.a(this, 1);
        this.I = new e.c.d.h.a.a(this, 4);
        this.J = new e.c.d.h.a.a(this, 2);
        f();
    }

    public void a(SpinDetailActivity spinDetailActivity) {
        this.v = spinDetailActivity;
        synchronized (this) {
            this.K |= 8;
        }
        a(2);
        super.g();
    }

    public void b(Boolean bool) {
        this.w = bool;
        synchronized (this) {
            this.K |= 2;
        }
        a(7);
        super.g();
    }

    public void c(Boolean bool) {
        this.z = bool;
        synchronized (this) {
            this.K |= 4;
        }
        a(22);
        super.g();
    }

    public void d(Boolean bool) {
        this.y = bool;
        synchronized (this) {
            this.K |= 16;
        }
        a(23);
        super.g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.r.e() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.K     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            e.c.d.e.k0 r0 = r4.r
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0016
            return r1
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.e.z.e():boolean");
    }

    public void f() {
        synchronized (this) {
            this.K = 64;
        }
        this.r.f();
        g();
    }

    public void e(Boolean bool) {
        this.x = bool;
        synchronized (this) {
            this.K |= 32;
        }
        a(24);
        super.g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            SpinDetailActivity spinDetailActivity = this.v;
            if (spinDetailActivity != null) {
                z = true;
            }
            if (z) {
                ((o) spinDetailActivity.s).u();
            }
        } else if (i2 == 2) {
            SpinDetailActivity spinDetailActivity2 = this.v;
            if (spinDetailActivity2 != null) {
                z = true;
            }
            if (z) {
                ((o) spinDetailActivity2.s).u();
            }
        } else if (i2 == 3) {
            SpinDetailActivity spinDetailActivity3 = this.v;
            if (spinDetailActivity3 != null) {
                z = true;
            }
            if (z) {
                ((o) spinDetailActivity3.s).q();
            }
        } else if (i2 == 4) {
            SpinDetailActivity spinDetailActivity4 = this.v;
            if (spinDetailActivity4 != null) {
                z = true;
            }
            if (z) {
                ((o) spinDetailActivity4.s).j();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.K     // Catch:{ all -> 0x00dc }
            r4 = 0
            r1.K = r4     // Catch:{ all -> 0x00dc }
            monitor-exit(r22)     // Catch:{ all -> 0x00dc }
            java.lang.Boolean r0 = r1.w
            java.lang.Boolean r6 = r1.z
            java.lang.Boolean r7 = r1.y
            java.lang.Boolean r8 = r1.x
            r9 = 66
            long r11 = r2 & r9
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            r12 = 0
            if (r11 == 0) goto L_0x002e
            boolean r0 = androidx.databinding.ViewDataBinding.a(r0)
            if (r11 == 0) goto L_0x0029
            if (r0 == 0) goto L_0x0026
            r13 = 16384(0x4000, double:8.0948E-320)
            goto L_0x0028
        L_0x0026:
            r13 = 8192(0x2000, double:4.0474E-320)
        L_0x0028:
            long r2 = r2 | r13
        L_0x0029:
            if (r0 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = r12
        L_0x002f:
            r13 = 68
            long r15 = r2 & r13
            int r11 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            r15 = 8
            if (r11 == 0) goto L_0x004d
            boolean r6 = androidx.databinding.ViewDataBinding.a(r6)
            if (r11 == 0) goto L_0x0048
            if (r6 == 0) goto L_0x0044
            r16 = 256(0x100, double:1.265E-321)
            goto L_0x0046
        L_0x0044:
            r16 = 128(0x80, double:6.32E-322)
        L_0x0046:
            long r2 = r2 | r16
        L_0x0048:
            if (r6 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r6 = r15
            goto L_0x004e
        L_0x004d:
            r6 = r12
        L_0x004e:
            r16 = 80
            long r18 = r2 & r16
            int r11 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x006a
            boolean r7 = androidx.databinding.ViewDataBinding.a(r7)
            if (r11 == 0) goto L_0x0065
            if (r7 == 0) goto L_0x0061
            r18 = 1024(0x400, double:5.06E-321)
            goto L_0x0063
        L_0x0061:
            r18 = 512(0x200, double:2.53E-321)
        L_0x0063:
            long r2 = r2 | r18
        L_0x0065:
            if (r7 == 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r7 = r15
            goto L_0x006b
        L_0x006a:
            r7 = r12
        L_0x006b:
            r18 = 96
            long r20 = r2 & r18
            int r11 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0086
            boolean r8 = androidx.databinding.ViewDataBinding.a(r8)
            if (r11 == 0) goto L_0x0082
            if (r8 == 0) goto L_0x007e
            r20 = 4096(0x1000, double:2.0237E-320)
            goto L_0x0080
        L_0x007e:
            r20 = 2048(0x800, double:1.0118E-320)
        L_0x0080:
            long r2 = r2 | r20
        L_0x0082:
            if (r8 == 0) goto L_0x0085
            goto L_0x0086
        L_0x0085:
            r12 = r15
        L_0x0086:
            r20 = 64
            long r20 = r2 & r20
            int r8 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00aa
            android.widget.Button r8 = r1.n
            android.view.View$OnClickListener r11 = r1.J
            r8.setOnClickListener(r11)
            android.widget.Button r8 = r1.B
            android.view.View$OnClickListener r11 = r1.G
            r8.setOnClickListener(r11)
            android.widget.Button r8 = r1.C
            android.view.View$OnClickListener r11 = r1.I
            r8.setOnClickListener(r11)
            android.widget.FrameLayout r8 = r1.t
            android.view.View$OnClickListener r11 = r1.H
            r8.setOnClickListener(r11)
        L_0x00aa:
            long r8 = r2 & r9
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00b5
            androidx.constraintlayout.widget.ConstraintLayout r8 = r1.D
            r8.setVisibility(r0)
        L_0x00b5:
            long r8 = r2 & r16
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c0
            com.airbnb.lottie.LottieAnimationView r0 = r1.E
            r0.setVisibility(r7)
        L_0x00c0:
            long r7 = r2 & r13
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00cb
            android.widget.ImageView r0 = r1.F
            r0.setVisibility(r6)
        L_0x00cb:
            long r2 = r2 & r18
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d6
            com.baidu.picapture.ui.widget.CircleProgressBar r0 = r1.u
            r0.setVisibility(r12)
        L_0x00d6:
            e.c.d.e.k0 r0 = r1.r
            r0.c()
            return
        L_0x00dc:
            r0 = move-exception
            monitor-exit(r22)     // Catch:{ all -> 0x00dc }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.e.z.b():void");
    }
}
