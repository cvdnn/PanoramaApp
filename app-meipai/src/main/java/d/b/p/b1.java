package d.b.p;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import d.b.f;
import d.b.g;
import d.b.i;

/* compiled from: TooltipPopup */
public class b1 {

    /* renamed from: a reason: collision with root package name */
    public final Context f4292a;

    /* renamed from: b reason: collision with root package name */
    public final View f4293b;

    /* renamed from: c reason: collision with root package name */
    public final TextView f4294c;

    /* renamed from: d reason: collision with root package name */
    public final LayoutParams f4295d = new LayoutParams();

    /* renamed from: e reason: collision with root package name */
    public final Rect f4296e = new Rect();

    /* renamed from: f reason: collision with root package name */
    public final int[] f4297f = new int[2];

    /* renamed from: g reason: collision with root package name */
    public final int[] f4298g = new int[2];

    public b1(Context context) {
        this.f4292a = context;
        View inflate = LayoutInflater.from(context).inflate(g.abc_tooltip, null);
        this.f4293b = inflate;
        this.f4294c = (TextView) inflate.findViewById(f.message);
        this.f4295d.setTitle(b1.class.getSimpleName());
        this.f4295d.packageName = this.f4292a.getPackageName();
        LayoutParams layoutParams = this.f4295d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a() {
        if (this.f4293b.getParent() != null) {
            ((WindowManager) this.f4292a.getSystemService("window")).removeView(this.f4293b);
        }
    }
}
