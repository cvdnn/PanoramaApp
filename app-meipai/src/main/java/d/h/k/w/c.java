package d.h.k.w;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat */
public class c {

    /* renamed from: a reason: collision with root package name */
    public final Object f4968a;

    /* compiled from: AccessibilityNodeProviderCompat */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a reason: collision with root package name */
        public final c f4969a;

        public a(c cVar) {
            this.f4969a = cVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            b a2 = this.f4969a.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.f4953a;
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            if (this.f4969a != null) {
                return null;
            }
            throw null;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f4969a.a(i2, i3, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat */
    public static class b extends a {
        public b(c cVar) {
            super(cVar);
        }

        public AccessibilityNodeInfo findFocus(int i2) {
            b b2 = this.f4969a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.f4953a;
        }
    }

    public c() {
        this.f4968a = new b(this);
    }

    public b a(int i2) {
        return null;
    }

    public boolean a(int i2, int i3, Bundle bundle) {
        return false;
    }

    public b b(int i2) {
        return null;
    }

    public c(Object obj) {
        this.f4968a = obj;
    }
}
