package e.c.d.e;

import android.content.Intent;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.panorama.guide.PanoramaGuideActivity;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;

/* compiled from: ActivityPanoramaGuideBindingImpl */
public class j extends i implements OnExtClickListener {
    public static final c v;
    public static final SparseIntArray w;
    public final ConstraintLayout s;
    public final OnClickListener t;
    public long u = -1;

    static {
        c cVar = new c(5);
        v = cVar;
        cVar.a(0, new String[]{"navigation_bar"}, new int[]{2}, new int[]{R.layout.navigation_bar});
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R.id.banner, 3);
        w.put(R.id.indicator, 4);
    }

    public j(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 5, v, w);
        super(dVar, view, 1, (Banner) a2[3], (Button) a2[1], (k0) a2[2], (CircleIndicator) a2[4]);
        this.o.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.s = constraintLayout;
        constraintLayout.setTag(null);
        view.setTag(a.dataBinding, this);
        this.t = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(PanoramaGuideActivity panoramaGuideActivity) {
        this.r = panoramaGuideActivity;
        synchronized (this) {
            this.u |= 2;
        }
        a(2);
        super.g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.u;
            this.u = 0;
        }
        if ((j2 & 4) != 0) {
            this.o.setOnClickListener(this.t);
        }
        this.p.c();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r4.p.e() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.u     // Catch:{ all -> 0x0018 }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            return r1
        L_0x000c:
            monitor-exit(r4)     // Catch:{ all -> 0x0018 }
            e.c.d.e.k0 r0 = r4.p
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
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.e.j.e():boolean");
    }

    public void f() {
        synchronized (this) {
            this.u = 4;
        }
        this.p.f();
        g();
    }

    public final void onExtClick(int i2, View view) {
        PanoramaGuideActivity panoramaGuideActivity = this.r;
        if (!(panoramaGuideActivity != null)) {
            return;
        }
        if (panoramaGuideActivity != null) {
            panoramaGuideActivity.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            return;
        }
        throw null;
    }
}
