package d.b.o.i;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import d.h.k.m;

/* compiled from: MenuPopupHelper */
public class l {

    /* renamed from: a reason: collision with root package name */
    public final Context f4233a;

    /* renamed from: b reason: collision with root package name */
    public final g f4234b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f4235c;

    /* renamed from: d reason: collision with root package name */
    public final int f4236d;

    /* renamed from: e reason: collision with root package name */
    public final int f4237e;

    /* renamed from: f reason: collision with root package name */
    public View f4238f;

    /* renamed from: g reason: collision with root package name */
    public int f4239g = 8388613;

    /* renamed from: h reason: collision with root package name */
    public boolean f4240h;

    /* renamed from: i reason: collision with root package name */
    public d.b.o.i.m.a f4241i;

    /* renamed from: j reason: collision with root package name */
    public k f4242j;
    public OnDismissListener k;
    public final OnDismissListener l = new a();

    /* compiled from: MenuPopupHelper */
    public class a implements OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            l.this.c();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f4233a = context;
        this.f4234b = gVar;
        this.f4238f = view;
        this.f4235c = z;
        this.f4236d = i2;
        this.f4237e = i3;
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [d.b.o.i.k, d.b.o.i.m] */
    /* JADX WARNING: type inference failed for: r7v0, types: [d.b.o.i.q] */
    /* JADX WARNING: type inference failed for: r1v12, types: [d.b.o.i.d] */
    /* JADX WARNING: type inference failed for: r7v1, types: [d.b.o.i.q] */
    /* JADX WARNING: type inference failed for: r1v13, types: [d.b.o.i.d] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v1, types: [d.b.o.i.q]
  assigns: [d.b.o.i.q, d.b.o.i.d]
  uses: [d.b.o.i.q, d.b.o.i.k, d.b.o.i.m, d.b.o.i.d]
  mth insns count: 50
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d.b.o.i.k a() {
        /*
            r14 = this;
            d.b.o.i.k r0 = r14.f4242j
            if (r0 != 0) goto L_0x0078
            android.content.Context r0 = r14.f4233a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            r0.getRealSize(r1)
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f4233a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = d.b.d.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0032
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 == 0) goto L_0x0046
            d.b.o.i.d r0 = new d.b.o.i.d
            android.content.Context r2 = r14.f4233a
            android.view.View r3 = r14.f4238f
            int r4 = r14.f4236d
            int r5 = r14.f4237e
            boolean r6 = r14.f4235c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0058
        L_0x0046:
            d.b.o.i.q r0 = new d.b.o.i.q
            android.content.Context r8 = r14.f4233a
            d.b.o.i.g r9 = r14.f4234b
            android.view.View r10 = r14.f4238f
            int r11 = r14.f4236d
            int r12 = r14.f4237e
            boolean r13 = r14.f4235c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0058:
            d.b.o.i.g r1 = r14.f4234b
            r0.a(r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.l
            r0.a(r1)
            android.view.View r1 = r14.f4238f
            r0.a(r1)
            d.b.o.i.m$a r1 = r14.f4241i
            r0.a(r1)
            boolean r1 = r14.f4240h
            r0.b(r1)
            int r1 = r14.f4239g
            r0.a(r1)
            r14.f4242j = r0
        L_0x0078:
            d.b.o.i.k r0 = r14.f4242j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.o.i.l.a():d.b.o.i.k");
    }

    public boolean b() {
        k kVar = this.f4242j;
        return kVar != null && kVar.a();
    }

    public void c() {
        this.f4242j = null;
        OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean d() {
        if (b()) {
            return true;
        }
        if (this.f4238f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public final void a(int i2, int i3, boolean z, boolean z2) {
        k a2 = a();
        a2.c(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f4239g, m.m(this.f4238f)) & 7) == 5) {
                i2 -= this.f4238f.getWidth();
            }
            a2.b(i2);
            a2.c(i3);
            int i4 = (int) ((this.f4233a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.f4232a = new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4);
        }
        a2.d();
    }

    public void a(d.b.o.i.m.a aVar) {
        this.f4241i = aVar;
        k kVar = this.f4242j;
        if (kVar != null) {
            kVar.a(aVar);
        }
    }
}
