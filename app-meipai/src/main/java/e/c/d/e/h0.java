package e.c.d.e;

import android.content.Intent;
import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.dialog.AppUpdateDialog;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;

/* compiled from: AppUpdateDialogBindingImpl */
public class h0 extends g0 implements OnExtClickListener {
    public static final SparseIntArray x;
    public final FrameLayout r;
    public final Button s;
    public final Button t;
    public final OnClickListener u;
    public final OnClickListener v;
    public long w = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x = sparseIntArray;
        sparseIntArray.put(R.id.update_icon, 3);
        x.put(R.id.update_title, 4);
        x.put(R.id.update_description, 5);
    }

    public h0(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 6, (c) null, x);
        super(dVar, view, 0, (TextView) a2[5], (ImageView) a2[3], (TextView) a2[4]);
        FrameLayout frameLayout = (FrameLayout) a2[0];
        this.r = frameLayout;
        frameLayout.setTag(null);
        Button button = (Button) a2[1];
        this.s = button;
        button.setTag(null);
        Button button2 = (Button) a2[2];
        this.t = button2;
        button2.setTag(null);
        view.setTag(a.dataBinding, this);
        this.u = new e.c.d.h.a.a(this, 2);
        this.v = new e.c.d.h.a.a(this, 1);
        f();
    }

    public void a(AppUpdateDialog appUpdateDialog) {
        this.q = appUpdateDialog;
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
            this.s.setOnClickListener(this.v);
            this.t.setOnClickListener(this.u);
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
            AppUpdateDialog appUpdateDialog = this.q;
            if (appUpdateDialog != null) {
                z = true;
            }
            if (z) {
                appUpdateDialog.dismiss();
            }
        } else if (i2 == 2) {
            AppUpdateDialog appUpdateDialog2 = this.q;
            if (appUpdateDialog2 != null) {
                z = true;
            }
            if (!z) {
                return;
            }
            if (appUpdateDialog2 != null) {
                StringBuilder a2 = e.a.a.a.a.a("https://baiduvrpublic.cdn.bcebos.com/vr-mkt/appdownload/dl.html?url=");
                a2.append(appUpdateDialog2.f2022b);
                appUpdateDialog2.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(a2.toString())));
                appUpdateDialog2.dismiss();
                return;
            }
            throw null;
        }
    }
}
