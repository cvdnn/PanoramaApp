package e.c.d.e;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.c;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.hotspot.preview.HotSpotPreviewActivity;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.baidu.picapture.ui.widget.dialog.ModelDialog.b;
import d.k.d;
import d.k.g.a;
import e.c.d.h.a.a.OnExtClickListener;

/* compiled from: ActivitySpotPreviewBindingImpl */
public class c0 extends b0 implements OnExtClickListener {
    public static final SparseIntArray H;
    public final ScrollView A;
    public final OnClickListener B;
    public final OnClickListener C;
    public final OnClickListener D;
    public final OnClickListener E;
    public final OnClickListener F;
    public long G = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R.id.iv_spot_show, 8);
        H.put(R.id.ed_title, 9);
        H.put(R.id.ed_describe, 10);
        H.put(R.id.divider, 11);
    }

    public c0(d dVar, View view) {
        Object[] a2 = ViewDataBinding.a(dVar, view, 12, (c) null, H);
        super(dVar, view, 0, (Button) a2[1], (View) a2[11], (EditText) a2[10], (EditText) a2[9], (RelativeLayout) a2[2], (RelativeLayout) a2[5], (ImageView) a2[8], (TextView) a2[4], (TextView) a2[3], (TextView) a2[6], (TextView) a2[7]);
        this.n.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        ScrollView scrollView = (ScrollView) a2[0];
        this.A = scrollView;
        scrollView.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        view.setTag(a.dataBinding, this);
        this.B = new e.c.d.h.a.a(this, 3);
        this.C = new e.c.d.h.a.a(this, 1);
        this.D = new e.c.d.h.a.a(this, 4);
        this.E = new e.c.d.h.a.a(this, 2);
        this.F = new e.c.d.h.a.a(this, 5);
        f();
    }

    public void a(HotSpotPreviewActivity hotSpotPreviewActivity) {
        this.y = hotSpotPreviewActivity;
        synchronized (this) {
            this.G |= 2;
        }
        a(2);
        super.g();
    }

    public void b(Boolean bool) {
        this.z = bool;
        synchronized (this) {
            this.G |= 1;
        }
        a(4);
        super.g();
    }

    public boolean e() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return false;
        }
    }

    public void f() {
        synchronized (this) {
            this.G = 4;
        }
        g();
    }

    public final void onExtClick(int i2, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i2 == 1) {
            HotSpotPreviewActivity hotSpotPreviewActivity = this.y;
            if (hotSpotPreviewActivity != null) {
                z = true;
            }
            if (!z) {
                return;
            }
            if (hotSpotPreviewActivity.t == 2) {
                ((e.c.d.m.c.b.d) hotSpotPreviewActivity.s).D();
            } else {
                hotSpotPreviewActivity.finish();
            }
        } else if (i2 == 2) {
            HotSpotPreviewActivity hotSpotPreviewActivity2 = this.y;
            if (hotSpotPreviewActivity2 != null) {
                z = true;
            }
            if (z) {
                ((e.c.d.m.c.b.d) hotSpotPreviewActivity2.s).D();
            }
        } else if (i2 == 3) {
            HotSpotPreviewActivity hotSpotPreviewActivity3 = this.y;
            if (hotSpotPreviewActivity3 != null) {
                z = true;
            }
            if (z) {
                hotSpotPreviewActivity3.i0();
            }
        } else if (i2 == 4) {
            HotSpotPreviewActivity hotSpotPreviewActivity4 = this.y;
            if (hotSpotPreviewActivity4 == null) {
                z2 = false;
            }
            if (z2) {
                String string = hotSpotPreviewActivity4.getString(R.string.delete);
                String string2 = hotSpotPreviewActivity4.getString(R.string.sure_delete_hot_spot_picture);
                String string3 = hotSpotPreviewActivity4.getString(R.string.allow);
                String string4 = hotSpotPreviewActivity4.getString(R.string.cancel);
                b bVar = new b(null);
                bVar.f2067a = string;
                bVar.f2073g = false;
                bVar.f2068b = string2;
                bVar.f2072f = R.drawable.red_text_color_selector;
                e.c.d.m.c.b.a aVar = e.c.d.m.c.b.a.f6502a;
                bVar.f2069c = string4;
                bVar.f2074h = aVar;
                e.c.d.m.c.b.b bVar2 = new e.c.d.m.c.b.b(hotSpotPreviewActivity4);
                bVar.f2071e = string3;
                bVar.f2075i = bVar2;
                ModelDialog modelDialog = new ModelDialog(hotSpotPreviewActivity4, null);
                modelDialog.f2060a = bVar;
                modelDialog.show();
            }
        } else if (i2 == 5) {
            HotSpotPreviewActivity hotSpotPreviewActivity5 = this.y;
            if (hotSpotPreviewActivity5 != null) {
                z = true;
            }
            if (z) {
                hotSpotPreviewActivity5.i0();
            }
        }
    }

    public void b() {
        long j2;
        int i2;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.G;
            this.G = 0;
        }
        Boolean bool = this.z;
        int i3 = ((j2 & 5) > 0 ? 1 : ((j2 & 5) == 0 ? 0 : -1));
        int i4 = 0;
        if (i3 != 0) {
            boolean a2 = ViewDataBinding.a(bool);
            if (i3 != 0) {
                if (a2) {
                    j4 = j2 | 16;
                    j3 = 64;
                } else {
                    j4 = j2 | 8;
                    j3 = 32;
                }
                j2 = j4 | j3;
            }
            int i5 = a2 ? 0 : 8;
            if (a2) {
                i4 = 8;
            }
            i2 = i4;
            i4 = i5;
        } else {
            i2 = 0;
        }
        if ((4 & j2) != 0) {
            this.n.setOnClickListener(this.C);
            this.u.setOnClickListener(this.B);
            this.v.setOnClickListener(this.E);
            this.w.setOnClickListener(this.D);
            this.x.setOnClickListener(this.F);
        }
        if ((j2 & 5) != 0) {
            this.r.setVisibility(i4);
            this.s.setVisibility(i2);
        }
    }
}
