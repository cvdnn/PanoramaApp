package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.device.SpinDeviceActivity;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.m.e.c.p;

/* compiled from: ActivitySpinDeviceBindingImpl */
public class r extends q implements OnExtClickListener {
    public static final c G;
    public static final SparseIntArray H;
    public final ConstraintLayout B;
    public final OnClickListener C;
    public final OnClickListener D;
    public final OnClickListener E;
    public long F = -1;

    static {
        c cVar = new c(14);
        G = cVar;
        cVar.a(0, new String[]{"navigation_bar"}, new int[]{4}, new int[]{R.layout.navigation_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R.id.content, 5);
        H.put(R.id.device_searching, 6);
        H.put(R.id.scan_result, 7);
        H.put(R.id.choose_device_title, 8);
        H.put(R.id.device_list, 9);
        H.put(R.id.device_list_searching, 10);
        H.put(R.id.scan_no_result, 11);
        H.put(R.id.tips_image, 12);
        H.put(R.id.footer, 13);
    }

    public r(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 14, G, H);
        super(dVar, view, 1, (TextView) a2[8], (LinearLayout) a2[5], (ListView) a2[9], (LinearLayout) a2[10], (LinearLayout) a2[6], (LinearLayout) a2[13], (k0) a2[4], (TextView) a2[2], (Button) a2[1], (LinearLayout) a2[11], (ConstraintLayout) a2[7], (ImageView) a2[12], (TextView) a2[3]);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.B = constraintLayout;
        constraintLayout.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.z.setTag(null);
        view.setTag(a.dataBinding, this);
        this.C = new e.c.d.h.a.a(this, 2);
        this.D = new e.c.d.h.a.a(this, 3);
        this.E = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(SpinDeviceActivity spinDeviceActivity) {
        this.A = spinDeviceActivity;
        synchronized (this) {
            this.F |= 2;
        }
        a(2);
        super.g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.F;
            this.F = 0;
        }
        if ((j2 & 4) != 0) {
            this.u.setOnClickListener(this.C);
            this.v.setOnClickListener(this.E);
            this.z.setOnClickListener(this.D);
        }
        this.t.c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.t.e() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.F     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            e.c.d.e.k0 r0 = r4.t
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
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.e.r.e():boolean");
    }

    public void f() {
        synchronized (this) {
            this.F = 4;
        }
        this.t.f();
        g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            SpinDeviceActivity spinDeviceActivity = this.A;
            if (spinDeviceActivity != null) {
                z = true;
            }
            if (z) {
                ((p) spinDeviceActivity.s).z();
            }
        } else if (i2 == 2) {
            SpinDeviceActivity spinDeviceActivity2 = this.A;
            if (spinDeviceActivity2 != null) {
                z = true;
            }
            if (z) {
                ((p) spinDeviceActivity2.s).z();
            }
        } else if (i2 == 3) {
            SpinDeviceActivity spinDeviceActivity3 = this.A;
            if (spinDeviceActivity3 != null) {
                z = true;
            }
            if (z) {
                ((p) spinDeviceActivity3.s).v();
            }
        }
    }
}
