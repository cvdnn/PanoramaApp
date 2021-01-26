package e.c.d.e;

import android.content.Intent;
import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.dialog.AppForceUpdateDialog;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;

/* compiled from: AppForceUpdateDialogBindingImpl */
public class f0 extends e0 implements OnExtClickListener {
    public static final SparseIntArray u;
    public final FrameLayout q;
    public final Button r;
    public final OnClickListener s;
    public long t = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        u = sparseIntArray;
        sparseIntArray.put(R.id.title, 2);
        u.put(R.id.tips, 3);
    }

    public f0(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 4, (c) null, u);
        super(dVar, view, 0, (TextView) a2[3], (TextView) a2[2]);
        FrameLayout frameLayout = (FrameLayout) a2[0];
        this.q = frameLayout;
        frameLayout.setTag(null);
        Button button = (Button) a2[1];
        this.r = button;
        button.setTag(null);
        view.setTag(a.dataBinding, this);
        this.s = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(AppForceUpdateDialog appForceUpdateDialog) {
        this.p = appForceUpdateDialog;
        synchronized (this) {
            this.t |= 1;
        }
        a(2);
        super.g();
    }

    public void b() {
        long j2;
        synchronized (this) {
            j2 = this.t;
            this.t = 0;
        }
        if ((j2 & 2) != 0) {
            this.r.setOnClickListener(this.s);
        }
    }

    public boolean e() {
        synchronized (this) {
            if (this.t != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.t = 2;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        AppForceUpdateDialog appForceUpdateDialog = this.p;
        if (!(appForceUpdateDialog != null)) {
            return;
        }
        if (appForceUpdateDialog != null) {
            StringBuilder a2 = e.a.a.a.a.a("https://baiduvrpublic.cdn.bcebos.com/vr-mkt/appdownload/dl.html?url=");
            a2.append(appForceUpdateDialog.f2020a);
            appForceUpdateDialog.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a2.toString())));
            return;
        }
        throw null;
    }
}
