package e.d.a.r.h;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import e.c.f.n.n;
import e.d.a.g;
import e.d.a.r.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* compiled from: ViewTarget */
public abstract class i<T extends View, Z> extends a<Z> {

    /* renamed from: c reason: collision with root package name */
    public static int f7886c = g.glide_custom_view_target_tag;

    /* renamed from: a reason: collision with root package name */
    public final T f7887a;

    /* renamed from: b reason: collision with root package name */
    public final a f7888b;

    /* compiled from: ViewTarget */
    public static final class a {

        /* renamed from: d reason: collision with root package name */
        public static Integer f7889d;

        /* renamed from: a reason: collision with root package name */
        public final View f7890a;

        /* renamed from: b reason: collision with root package name */
        public final List<g> f7891b = new ArrayList();

        /* renamed from: c reason: collision with root package name */
        public C0098a f7892c;

        /* renamed from: e.d.a.r.h.i$a$a reason: collision with other inner class name */
        /* compiled from: ViewTarget */
        public static final class C0098a implements OnPreDrawListener {

            /* renamed from: a reason: collision with root package name */
            public final WeakReference<a> f7893a;

            public C0098a(a aVar) {
                this.f7893a = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                String str = "ViewTarget";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("OnGlobalLayoutListener called attachStateListener=");
                    sb.append(this);
                    Log.v(str, sb.toString());
                }
                a aVar = (a) this.f7893a.get();
                if (aVar != null && !aVar.f7891b.isEmpty()) {
                    int c2 = aVar.c();
                    int b2 = aVar.b();
                    if (aVar.a(c2, b2)) {
                        Iterator it = new ArrayList(aVar.f7891b).iterator();
                        while (it.hasNext()) {
                            ((g) it.next()).a(c2, b2);
                        }
                        aVar.a();
                    }
                }
                return true;
            }
        }

        public a(View view) {
            this.f7890a = view;
        }

        public void a() {
            ViewTreeObserver viewTreeObserver = this.f7890a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f7892c);
            }
            this.f7892c = null;
            this.f7891b.clear();
        }

        public final boolean a(int i2, int i3) {
            if (!(i2 > 0 || i2 == Integer.MIN_VALUE)) {
                return false;
            }
            return i3 > 0 || i3 == Integer.MIN_VALUE;
        }

        public final int b() {
            int paddingBottom = this.f7890a.getPaddingBottom() + this.f7890a.getPaddingTop();
            LayoutParams layoutParams = this.f7890a.getLayoutParams();
            return a(this.f7890a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int c() {
            int paddingRight = this.f7890a.getPaddingRight() + this.f7890a.getPaddingLeft();
            LayoutParams layoutParams = this.f7890a.getLayoutParams();
            return a(this.f7890a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        public final int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f7890a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            String str = "ViewTarget";
            if (Log.isLoggable(str, 4)) {
                Log.i(str, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = this.f7890a.getContext();
            if (f7889d == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                n.a(windowManager, "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f7889d = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f7889d.intValue();
        }
    }

    public i(T t) {
        n.a(t, "Argument must not be null");
        this.f7887a = t;
        this.f7888b = new a(t);
    }

    public void a(g gVar) {
        this.f7888b.f7891b.remove(gVar);
    }

    public void b(g gVar) {
        a aVar = this.f7888b;
        int c2 = aVar.c();
        int b2 = aVar.b();
        if (aVar.a(c2, b2)) {
            gVar.a(c2, b2);
            return;
        }
        if (!aVar.f7891b.contains(gVar)) {
            aVar.f7891b.add(gVar);
        }
        if (aVar.f7892c == null) {
            ViewTreeObserver viewTreeObserver = aVar.f7890a.getViewTreeObserver();
            C0098a aVar2 = new C0098a(aVar);
            aVar.f7892c = aVar2;
            viewTreeObserver.addOnPreDrawListener(aVar2);
        }
    }

    public b c() {
        Object tag = this.f7887a.getTag(f7886c);
        if (tag == null) {
            return null;
        }
        if (tag instanceof b) {
            return (b) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        StringBuilder a2 = e.a.a.a.a.a("Target for: ");
        a2.append(this.f7887a);
        return a2.toString();
    }

    public void a(b bVar) {
        this.f7887a.setTag(f7886c, bVar);
    }
}
