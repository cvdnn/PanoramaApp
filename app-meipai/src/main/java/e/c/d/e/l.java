package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.arashivision.sdkmedia.player.image.InstaImagePlayerView;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.panorama.preview.PanoramaPreviewActivity;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;

/* compiled from: ActivityPanoramaPreviewBindingImpl */
public class l extends k implements OnExtClickListener {
    public static final SparseIntArray x;
    public final ConstraintLayout r;
    public final ImageButton s;
    public final OnClickListener t;
    public final OnClickListener u;
    public final OnClickListener v;
    public long w = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.image_player, 4);
    }

    public l(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 5, (c) null, x);
        super(dVar, view, 0, (Button) a2[1], (InstaImagePlayerView) a2[4], (Button) a2[3]);
        this.n.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) a2[0];
        this.r = constraintLayout;
        constraintLayout.setTag(null);
        ImageButton imageButton = (ImageButton) a2[2];
        this.s = imageButton;
        imageButton.setTag(null);
        this.p.setTag(null);
        view.setTag(a.dataBinding, this);
        this.t = new e.c.d.h.a.a(this, 3);
        this.u = new e.c.d.h.a.a(this, 1);
        this.v = new e.c.d.h.a.a(this, 2);
        f();
    }

    public void a(PanoramaPreviewActivity panoramaPreviewActivity) {
        this.q = panoramaPreviewActivity;
        synchronized (this) {
            this.w |= 1;
        }
        a(2);
        super.g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.w;
            this.w = 0;
        }
        if ((j2 & 2) != 0) {
            this.n.setOnClickListener(this.u);
            this.s.setOnClickListener(this.v);
            this.p.setOnClickListener(this.t);
        }
    }

    public boolean e() {
        synchronized (this) {
            if (this.w != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.w = 2;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z = false;
        if (i2 == 1) {
            PanoramaPreviewActivity panoramaPreviewActivity = this.q;
            if (panoramaPreviewActivity != null) {
                z = true;
            }
            if (z) {
                panoramaPreviewActivity.finish();
            }
        } else if (i2 == 2) {
            PanoramaPreviewActivity panoramaPreviewActivity2 = this.q;
            if (panoramaPreviewActivity2 != null) {
                z = true;
            }
            if (z) {
                ((e.c.d.m.d.c.c) panoramaPreviewActivity2.s).b();
            }
        } else if (i2 == 3) {
            PanoramaPreviewActivity panoramaPreviewActivity3 = this.q;
            if (panoramaPreviewActivity3 != null) {
                z = true;
            }
            if (z) {
                ((e.c.d.m.d.c.c) panoramaPreviewActivity3.s).r();
            }
        }
    }
}
