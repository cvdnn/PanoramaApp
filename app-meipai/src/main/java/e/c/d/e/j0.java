package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.dialog.CaptureGuideDialog;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;
import e.c.d.n.e;

/* compiled from: CaptureGuideDialogBindingImpl */
public class j0 extends i0 implements OnExtClickListener {
    public static final SparseIntArray t;
    public final FrameLayout q;
    public final OnClickListener r;
    public long s = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t = sparseIntArray;
        sparseIntArray.put(R.id.checkbox, 2);
    }

    public j0(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 3, (c) null, t);
        super(dVar, view, 0, (Button) a2[1], (CheckBox) a2[2]);
        this.n.setTag(null);
        FrameLayout frameLayout = (FrameLayout) a2[0];
        this.q = frameLayout;
        frameLayout.setTag(null);
        view.setTag(a.dataBinding, this);
        this.r = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(CaptureGuideDialog captureGuideDialog) {
        this.p = captureGuideDialog;
        synchronized (this) {
            this.s |= 1;
        }
        a(2);
        super.g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.s;
            this.s = 0;
        }
        if ((j2 & 2) != 0) {
            this.n.setOnClickListener(this.r);
        }
    }

    public boolean e() {
        synchronized (this) {
            if (this.s != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.s = 2;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        CaptureGuideDialog captureGuideDialog = this.p;
        if (captureGuideDialog != null) {
            e.b("ignore_capture_guide", captureGuideDialog.f2025b, true);
            CaptureGuideDialog.a aVar = captureGuideDialog.f2026c;
            if (aVar != null) {
                aVar.a();
            }
            captureGuideDialog.dismiss();
        }
    }
}
