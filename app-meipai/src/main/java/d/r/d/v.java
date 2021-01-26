package d.r.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import d.h.k.w.b;
import d.h.k.w.c;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate */
public class v extends d.h.k.a {

    /* renamed from: d reason: collision with root package name */
    public final RecyclerView f5403d;

    /* renamed from: e reason: collision with root package name */
    public final a f5404e;

    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class a extends d.h.k.a {

        /* renamed from: d reason: collision with root package name */
        public final v f5405d;

        /* renamed from: e reason: collision with root package name */
        public Map<View, d.h.k.a> f5406e = new WeakHashMap();

        public a(v vVar) {
            this.f5405d = vVar;
        }

        public void a(View view, b bVar) {
            if (this.f5405d.a() || this.f5405d.f5403d.getLayoutManager() == null) {
                this.f4909a.onInitializeAccessibilityNodeInfo(view, bVar.f4953a);
                return;
            }
            this.f5405d.f5403d.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, bVar);
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                aVar.a(view, bVar);
            } else {
                this.f4909a.onInitializeAccessibilityNodeInfo(view, bVar.f4953a);
            }
        }

        public void b(View view, AccessibilityEvent accessibilityEvent) {
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                aVar.b(view, accessibilityEvent);
            } else {
                this.f4909a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public void c(View view, AccessibilityEvent accessibilityEvent) {
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                this.f4909a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public void d(View view, AccessibilityEvent accessibilityEvent) {
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                aVar.d(view, accessibilityEvent);
            } else {
                this.f4909a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        public boolean a(View view, int i2, Bundle bundle) {
            if (this.f5405d.a() || this.f5405d.f5403d.getLayoutManager() == null) {
                return super.a(view, i2, bundle);
            }
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                if (aVar.a(view, i2, bundle)) {
                    return true;
                }
            } else if (super.a(view, i2, bundle)) {
                return true;
            }
            return this.f5405d.f5403d.getLayoutManager().performAccessibilityActionForItem(view, i2, bundle);
        }

        public void a(View view, int i2) {
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                aVar.a(view, i2);
            } else {
                this.f4909a.sendAccessibilityEvent(view, i2);
            }
        }

        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                return aVar.a(view, accessibilityEvent);
            }
            return this.f4909a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(viewGroup);
            if (aVar != null) {
                return aVar.a(viewGroup, view, accessibilityEvent);
            }
            return this.f4909a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public c a(View view) {
            d.h.k.a aVar = (d.h.k.a) this.f5406e.get(view);
            if (aVar != null) {
                return aVar.a(view);
            }
            return super.a(view);
        }
    }

    public v(RecyclerView recyclerView) {
        this.f5403d = recyclerView;
        a aVar = this.f5404e;
        if (aVar != null) {
            this.f5404e = aVar;
        } else {
            this.f5404e = new a(this);
        }
    }

    public boolean a() {
        return this.f5403d.hasPendingAdapterUpdates();
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.f4909a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !a()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public boolean a(View view, int i2, Bundle bundle) {
        if (super.a(view, i2, bundle)) {
            return true;
        }
        if (a() || this.f5403d.getLayoutManager() == null) {
            return false;
        }
        return this.f5403d.getLayoutManager().performAccessibilityAction(i2, bundle);
    }

    public void a(View view, b bVar) {
        this.f4909a.onInitializeAccessibilityNodeInfo(view, bVar.f4953a);
        if (!a() && this.f5403d.getLayoutManager() != null) {
            this.f5403d.getLayoutManager().onInitializeAccessibilityNodeInfo(bVar);
        }
    }
}
