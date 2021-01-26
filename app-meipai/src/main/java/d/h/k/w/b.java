package d.h.k.w;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import com.baidubce.auth.NTLMEngineImpl;
import com.sina.weibo.sdk.api.ImageObject;
import d.h.k.w.d.C0042d;
import d.h.k.w.d.e;
import d.h.k.w.d.f;
import d.h.k.w.d.g;
import d.h.k.w.d.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityNodeInfoCompat */
public class b {

    /* renamed from: d reason: collision with root package name */
    public static int f4952d;

    /* renamed from: a reason: collision with root package name */
    public final AccessibilityNodeInfo f4953a;

    /* renamed from: b reason: collision with root package name */
    public int f4954b = -1;

    /* renamed from: c reason: collision with root package name */
    public int f4955c = -1;

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class a {

        /* renamed from: e reason: collision with root package name */
        public static final a f4956e = new a(16, null);

        /* renamed from: f reason: collision with root package name */
        public static final a f4957f = new a(4096, null);

        /* renamed from: g reason: collision with root package name */
        public static final a f4958g = new a(8192, null);

        /* renamed from: h reason: collision with root package name */
        public static final a f4959h = new a(262144, null);

        /* renamed from: i reason: collision with root package name */
        public static final a f4960i = new a(NTLMEngineImpl.FLAG_REQUEST_NTLM2_SESSION, null);

        /* renamed from: j reason: collision with root package name */
        public static final a f4961j = new a(1048576, null);

        /* renamed from: a reason: collision with root package name */
        public final Object f4962a;

        /* renamed from: b reason: collision with root package name */
        public final int f4963b;

        /* renamed from: c reason: collision with root package name */
        public final Class<? extends d.h.k.w.d.a> f4964c;

        /* renamed from: d reason: collision with root package name */
        public final d f4965d;

        static {
            Class<d.h.k.w.d.c> cls = d.h.k.w.d.c.class;
            Class<d.h.k.w.d.b> cls2 = d.h.k.w.d.b.class;
            AccessibilityAction accessibilityAction = null;
            new a(1, null);
            new a(2, null);
            new a(4, null);
            new a(8, null);
            new a(32, null);
            new a(64, null);
            new a(128, null);
            new a(256, null, cls2);
            new a(512, null, cls2);
            new a(1024, null, cls);
            new a(2048, null, cls);
            new a(16384, null);
            new a(32768, null);
            new a(65536, null);
            new a(131072, null, g.class);
            new a(ImageObject.DATA_SIZE, null, h.class);
            new a(AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
            new a(AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, e.class);
            new a(AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);
            new a(AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
            new a(AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);
            new a(AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
            new a(AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
            new a(VERSION.SDK_INT >= 24 ? AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, f.class);
            new a(VERSION.SDK_INT >= 26 ? AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, C0042d.class);
            new a(VERSION.SDK_INT >= 28 ? AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            if (VERSION.SDK_INT >= 28) {
                accessibilityAction = AccessibilityAction.ACTION_HIDE_TOOLTIP;
            }
            new a(accessibilityAction, 16908357, null, null, null);
        }

        public a(int i2, CharSequence charSequence) {
            this(null, i2, charSequence, null, null);
        }

        public int a() {
            return ((AccessibilityAction) this.f4962a).getId();
        }

        public a(int i2, CharSequence charSequence, Class<? extends d.h.k.w.d.a> cls) {
            this(null, i2, charSequence, null, cls);
        }

        public a(Object obj, int i2, CharSequence charSequence, d dVar, Class<? extends d.h.k.w.d.a> cls) {
            this.f4963b = i2;
            this.f4965d = dVar;
            if (obj == null) {
                this.f4962a = new AccessibilityAction(i2, charSequence);
            } else {
                this.f4962a = obj;
            }
            this.f4964c = cls;
        }
    }

    /* renamed from: d.h.k.w.b$b reason: collision with other inner class name */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0041b {

        /* renamed from: a reason: collision with root package name */
        public final Object f4966a;

        public C0041b(Object obj) {
            this.f4966a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        public final Object f4967a;

        public c(Object obj) {
            this.f4967a = obj;
        }

        public static c a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            return new c(CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
        }
    }

    public b(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4953a = accessibilityNodeInfo;
    }

    public static b o() {
        return new b(AccessibilityNodeInfo.obtain());
    }

    public final List<Integer> a(String str) {
        ArrayList integerArrayList = this.f4953a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.f4953a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public int b() {
        return this.f4953a.getActions();
    }

    public int c() {
        return this.f4953a.getChildCount();
    }

    public CharSequence d() {
        return this.f4953a.getClassName();
    }

    public CharSequence e() {
        return this.f4953a.getContentDescription();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4953a;
        if (accessibilityNodeInfo == null) {
            if (bVar.f4953a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(bVar.f4953a)) {
            return false;
        }
        return this.f4955c == bVar.f4955c && this.f4954b == bVar.f4954b;
    }

    public Bundle f() {
        return this.f4953a.getExtras();
    }

    public CharSequence g() {
        String str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
        if (!(!a(str).isEmpty())) {
            return this.f4953a.getText();
        }
        List a2 = a(str);
        List a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f4953a.getText(), 0, this.f4953a.getText().length()));
        for (int i2 = 0; i2 < a2.size(); i2++) {
            spannableString.setSpan(new a(((Integer) a5.get(i2)).intValue(), this, f().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) a2.get(i2)).intValue(), ((Integer) a3.get(i2)).intValue(), ((Integer) a4.get(i2)).intValue());
        }
        return spannableString;
    }

    public boolean h() {
        return this.f4953a.isCheckable();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4953a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean i() {
        return this.f4953a.isClickable();
    }

    public boolean j() {
        return this.f4953a.isEnabled();
    }

    public boolean k() {
        return this.f4953a.isFocusable();
    }

    public boolean l() {
        return this.f4953a.isLongClickable();
    }

    public boolean m() {
        return this.f4953a.isScrollable();
    }

    public boolean n() {
        return this.f4953a.isVisibleToUser();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        this.f4953a.getBoundsInParent(rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("; boundsInParent: ");
        sb2.append(rect);
        sb.append(sb2.toString());
        this.f4953a.getBoundsInScreen(rect);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("; boundsInScreen: ");
        sb3.append(rect);
        sb.append(sb3.toString());
        sb.append("; packageName: ");
        sb.append(this.f4953a.getPackageName());
        sb.append("; className: ");
        sb.append(d());
        sb.append("; text: ");
        sb.append(g());
        sb.append("; contentDescription: ");
        sb.append(e());
        sb.append("; viewId: ");
        sb.append(this.f4953a.getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(h());
        sb.append("; checked: ");
        sb.append(this.f4953a.isChecked());
        sb.append("; focusable: ");
        sb.append(k());
        sb.append("; focused: ");
        sb.append(this.f4953a.isFocused());
        sb.append("; selected: ");
        sb.append(this.f4953a.isSelected());
        sb.append("; clickable: ");
        sb.append(i());
        sb.append("; longClickable: ");
        sb.append(l());
        sb.append("; enabled: ");
        sb.append(j());
        sb.append("; password: ");
        sb.append(this.f4953a.isPassword());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("; scrollable: ");
        sb4.append(m());
        sb.append(sb4.toString());
        sb.append("; [");
        int b2 = b();
        while (b2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(b2);
            b2 &= ~numberOfTrailingZeros;
            if (numberOfTrailingZeros == 1) {
                str = "ACTION_FOCUS";
            } else if (numberOfTrailingZeros != 2) {
                switch (numberOfTrailingZeros) {
                    case 4:
                        str = "ACTION_SELECT";
                        break;
                    case 8:
                        str = "ACTION_CLEAR_SELECTION";
                        break;
                    case 16:
                        str = "ACTION_CLICK";
                        break;
                    case 32:
                        str = "ACTION_LONG_CLICK";
                        break;
                    case 64:
                        str = "ACTION_ACCESSIBILITY_FOCUS";
                        break;
                    case 128:
                        str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                        break;
                    case 256:
                        str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                        break;
                    case 512:
                        str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                        break;
                    case 1024:
                        str = "ACTION_NEXT_HTML_ELEMENT";
                        break;
                    case 2048:
                        str = "ACTION_PREVIOUS_HTML_ELEMENT";
                        break;
                    case 4096:
                        str = "ACTION_SCROLL_FORWARD";
                        break;
                    case 8192:
                        str = "ACTION_SCROLL_BACKWARD";
                        break;
                    case 16384:
                        str = "ACTION_COPY";
                        break;
                    case 32768:
                        str = "ACTION_PASTE";
                        break;
                    case 65536:
                        str = "ACTION_CUT";
                        break;
                    case 131072:
                        str = "ACTION_SET_SELECTION";
                        break;
                    default:
                        str = "ACTION_UNKNOWN";
                        break;
                }
            } else {
                str = "ACTION_CLEAR_FOCUS";
            }
            sb.append(str);
            if (b2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static ClickableSpan[] b(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public void a(Object obj) {
        this.f4953a.setCollectionInfo(obj == null ? null : (CollectionInfo) ((C0041b) obj).f4966a);
    }

    public void b(Object obj) {
        this.f4953a.setCollectionItemInfo(obj == null ? null : (CollectionItemInfo) ((c) obj).f4967a);
    }

    public List<a> a() {
        List actionList = this.f4953a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = new a(actionList.get(i2), 0, null, null, null);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public void a(CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            this.f4953a.setHintText(charSequence);
        } else {
            this.f4953a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public final void a(int i2, boolean z) {
        Bundle f2 = f();
        if (f2 != null) {
            String str = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
            int i3 = f2.getInt(str, 0) & (~i2);
            if (!z) {
                i2 = 0;
            }
            f2.putInt(str, i2 | i3);
        }
    }
}
