package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidubce.BceConfig;
import d.x.a.b;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

public class bj {
    public static View a(Activity activity) {
        View view = null;
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window != null) {
            view = window.getDecorView();
        }
        return view;
    }

    public static View b(Activity activity) {
        View a2 = a(activity);
        if (a2 != null) {
            return a2.getRootView();
        }
        return null;
    }

    public static int c(Activity activity) {
        if (activity == null) {
            return 0;
        }
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int d(Activity activity) {
        if (activity == null) {
            return 0;
        }
        WindowManager windowManager = activity.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static Rect e(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect();
        if (a(view, rect) && rect.right > rect.left && rect.bottom > rect.top) {
            return rect;
        }
        return null;
    }

    public static String f(View view) {
        String str = null;
        try {
            if (view.getId() != 0) {
                str = view.getResources().getResourceName(view.getId());
            }
        } catch (Exception unused) {
        }
        String str2 = ":id/";
        if (!TextUtils.isEmpty(str) && str.contains(str2)) {
            int lastIndexOf = str.lastIndexOf(str2);
            if (lastIndexOf != -1) {
                int i2 = lastIndexOf + 4;
                if (i2 < str.length()) {
                    str = str.substring(i2);
                }
            }
        }
        return str == null ? "" : str;
    }

    public static Map<String, String> g(View view) {
        Map<String, String> map;
        Object tag = view.getTag(-96000);
        if (tag != null && (tag instanceof Map)) {
            try {
                map = (Map) tag;
            } catch (Exception unused) {
                map = null;
            }
            if (map == null || map.size() == 0) {
                return null;
            }
            return map;
        }
        return null;
    }

    public static String h(View view) {
        String str = null;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                str = text.toString();
            }
        } else if (view instanceof ViewGroup) {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i2 = 0; i2 < childCount && sb.length() < 128; i2++) {
                String h2 = h(viewGroup.getChildAt(i2));
                if (h2 != null && h2.length() > 0) {
                    if (z) {
                        sb.append(", ");
                    }
                    sb.append(h2);
                    z = true;
                }
            }
            if (sb.length() > 128) {
                str = sb.substring(0, 128);
            } else if (z) {
                str = sb.toString();
            }
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @SuppressLint({"NewApi"})
    public static int i(View view) {
        float alpha = view.getAlpha();
        Drawable background = view.getBackground();
        return (int) (alpha * ((float) (background != null ? background.getAlpha() : 0)));
    }

    @SuppressLint({"NewApi"})
    public static float j(View view) {
        return view.getZ();
    }

    public static String k(View view) {
        String str = null;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                str = text.toString();
            }
        } else if (view instanceof ViewGroup) {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i2 = 0; i2 < childCount && sb.length() < 128; i2++) {
                String k = k(viewGroup.getChildAt(i2));
                if (k != null && k.length() > 0) {
                    if (z) {
                        sb.append("| ");
                    }
                    sb.append(k);
                    z = true;
                }
            }
            if (sb.length() > 4096) {
                str = sb.substring(0, 4096);
            } else if (z) {
                str = sb.toString();
            }
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String l(View view) {
        String str = "";
        if (view == null) {
            return str;
        }
        Class cls = view.getClass();
        if (cls == null) {
            return str;
        }
        String d2 = d(cls);
        if (!TextUtils.isEmpty(d2) && cls.isAnonymousClass()) {
            d2 = a.a(d2, "$");
        }
        if (d2 != null) {
            str = d2;
        }
        return str;
    }

    public static boolean m(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if ((view instanceof ListView) || (view instanceof GridView)) {
            return true;
        }
        String a2 = a(view.getClass());
        if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
            Class cls = null;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (Exception unused) {
            }
            if (cls != null && cls.isAssignableFrom(view.getClass())) {
                z = true;
            }
        }
        return z;
    }

    public static View n(View view) {
        View view2 = null;
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof View)) {
            return null;
        }
        View view3 = (View) parent;
        if (view3 != null && m(view3)) {
            view2 = view3;
        }
        return view2;
    }

    public static int o(View view) {
        if (view != null) {
            return view.getWidth();
        }
        return 0;
    }

    public static int p(View view) {
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }

    public static boolean q(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        String a2 = a(view.getClass());
        if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
            Class cls = null;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
            } catch (Exception unused) {
            }
            if (cls != null && cls.isAssignableFrom(view.getClass())) {
                z = true;
            }
        }
        return z;
    }

    public static boolean r(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(-97001);
        if (tag != null && (tag instanceof String)) {
            z = true;
        }
        return z;
    }

    public static String s(View view) {
        String str = "";
        if (view == null) {
            return str;
        }
        Object tag = view.getTag(-97003);
        if (tag != null && (tag instanceof String)) {
            str = (String) tag;
        }
        if (TextUtils.isEmpty(str)) {
            str = u(view);
        }
        return str;
    }

    public static String t(View view) {
        String str = "";
        if (view == null) {
            return str;
        }
        Object tag = view.getTag(-97004);
        if (tag != null && (tag instanceof String)) {
            str = (String) tag;
        }
        return str;
    }

    public static String u(View view) {
        String str = "";
        if (view == null) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(view, linkedHashMap);
        if (linkedHashMap.size() == 0) {
            return str;
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.entrySet());
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) ((Entry) it.next()).getValue()).intValue();
            if (intValue > i2) {
                i2 = intValue;
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Entry entry = (Entry) it2.next();
            if (((Integer) entry.getValue()).intValue() >= i2) {
                View view2 = (View) entry.getKey();
                if (view2 != null && (view2 instanceof TextView)) {
                    CharSequence text = ((TextView) view2).getText();
                    String charSequence = text != null ? text.toString() : str;
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (!TextUtils.isEmpty(sb.toString())) {
                            sb.append("_");
                        }
                        sb.append(charSequence);
                    }
                }
            }
        }
        String sb2 = sb.toString();
        if (sb2.length() > 256) {
            sb2 = sb2.substring(0, 256);
        }
        return sb2;
    }

    public static boolean v(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(-97002);
        if (tag != null && (tag instanceof Boolean)) {
            z = true;
        }
        return z;
    }

    public static Rect w(View view) {
        Rect rect = null;
        if (view == null) {
            return null;
        }
        if (view.getVisibility() == 0) {
            rect = new Rect();
            a(view, rect);
        }
        return rect;
    }

    public static boolean x(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if ("com.android.internal.policy".equals(a(view.getClass()))) {
            if ("DecorView".equals(l(view))) {
                z = true;
            }
        }
        return z;
    }

    @SuppressLint({"NewApi"})
    public static String a(View view) {
        CharSequence charSequence;
        String str = "";
        if (view == null) {
            return str;
        }
        if (view instanceof TextView) {
            if (!(view instanceof EditText)) {
                CharSequence text = ((TextView) view).getText();
                if (text != null) {
                    str = text.toString();
                }
            }
            if (view instanceof Switch) {
                Switch switchR = (Switch) view;
                if (switchR.isChecked()) {
                    charSequence = switchR.getTextOn();
                } else {
                    charSequence = switchR.getTextOff();
                }
                if (charSequence != null) {
                    str = charSequence.toString();
                }
            }
        } else if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            Object selectedItem = spinner.getSelectedItem();
            if (selectedItem == null || !(selectedItem instanceof String)) {
                return a(spinner.getSelectedView());
            }
            str = (String) selectedItem;
        }
        byte[] bytes = str.getBytes();
        if (bytes.length > 4096) {
            str = new String(Arrays.copyOf(bytes, 4096));
        }
        return str;
    }

    public static String b(View view) {
        String str = view instanceof ListView ? ListView.class.getSimpleName() : view instanceof WebView ? WebView.class.getSimpleName() : "";
        if (TextUtils.isEmpty(str)) {
            String a2 = a(view.getClass());
            if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
                Class cls = null;
                try {
                    cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
                } catch (Exception unused) {
                }
                if (cls != null && cls.isAssignableFrom(view.getClass())) {
                    str = RecyclerView.TAG;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = c(view.getClass());
        }
        return TextUtils.isEmpty(str) ? "Object" : str;
    }

    @TargetApi(22)
    public static Uri i(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (!TextUtils.isEmpty(stringExtra)) {
            return Uri.parse(stringExtra);
        }
        return activity.getReferrer();
    }

    public static String c(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        String a2 = a(cls);
        if ("android.widget".equals(a2) || "android.view".equals(a2)) {
            return d(cls);
        }
        return c(cls.getSuperclass());
    }

    public static boolean d(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        return a(view, new Rect());
    }

    public static String e(Activity activity) {
        String str = "";
        if (activity == null || activity.getClass() == null) {
            return str;
        }
        String name = activity.getClass().getName();
        return !TextUtils.isEmpty(name) ? name : str;
    }

    public static String g(Activity activity) {
        String str = "";
        if (activity == null) {
            return str;
        }
        String h2 = h(activity);
        if (!TextUtils.isEmpty(h2)) {
            return h2;
        }
        Uri i2 = i(activity);
        if (i2 != null) {
            String host = i2.getHost();
            if (!TextUtils.isEmpty(host)) {
                str = host;
            }
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String f(android.app.Activity r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x000f
            java.lang.CharSequence r2 = r2.getTitle()
            if (r2 == 0) goto L_0x000f
            java.lang.String r2 = r2.toString()
            goto L_0x0010
        L_0x000f:
            r2 = r0
        L_0x0010:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = r2
        L_0x0018:
            int r2 = r0.length()
            r1 = 256(0x100, float:3.59E-43)
            if (r2 <= r1) goto L_0x0025
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bj.f(android.app.Activity):java.lang.String");
    }

    public static String d(JSONArray jSONArray) {
        String str = "";
        if (jSONArray == null || jSONArray.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                String b2 = b(jSONObject.getString("p"));
                String string = jSONObject.getString("i");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(BceConfig.BOS_DELIMITER);
                sb2.append(b2);
                sb2.append("[");
                sb2.append(string);
                sb2.append("]");
                sb.append(sb2.toString());
                String optString = jSONObject.optString("d");
                if (!TextUtils.isEmpty(optString)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("#");
                    sb3.append(optString);
                    sb.append(sb3.toString());
                }
                i2++;
            } catch (Exception unused) {
                return str;
            }
        }
        return sb.toString();
    }

    public static String c(View view) {
        Class cls;
        String str = "";
        if (view == null) {
            return str;
        }
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            String a2 = a(parent.getClass());
            if (!"android.widget".equals(a2) && !"android.view".equals(a2)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                try {
                    cls = Class.forName("d.x.a.b");
                } catch (ClassNotFoundException unused) {
                    cls = null;
                }
                if (cls == null || !cls.isAssignableFrom(viewGroup.getClass())) {
                    return str;
                }
                try {
                    b bVar = (b) viewGroup;
                    ArrayList arrayList = new ArrayList();
                    int childCount = bVar.getChildCount();
                    int i2 = 0;
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = bVar.getChildAt(i3);
                        arrayList.add(childAt);
                        if (e(childAt) != null) {
                            i2++;
                        }
                    }
                    if (arrayList.size() < 2 || i2 < 2) {
                        str = String.valueOf(bVar.getCurrentItem());
                    } else {
                        try {
                            Collections.sort(arrayList, new Comparator<View>() {
                                /* renamed from: a */
                                public int compare(View view, View view2) {
                                    return view.getLeft() - view2.getLeft();
                                }
                            });
                        } catch (Exception unused2) {
                        }
                        int left = view.getLeft() / Math.abs(((View) arrayList.get(1)).getLeft() - ((View) arrayList.get(0)).getLeft());
                        bVar.getAdapter();
                        throw null;
                    }
                } catch (Throwable unused3) {
                }
            }
        }
        return str;
    }

    public static String b(Bitmap bitmap) {
        byte[] c2 = c(bitmap);
        return c2 != null ? bt.a.a(c2) : "";
    }

    public static boolean b(View view, String str) {
        if ("ListView".equals(str) || RecyclerView.TAG.equals(str) || "GridView".equals(str) || view.isClickable()) {
            return true;
        }
        return false;
    }

    public static String b(JSONArray jSONArray) {
        String str = "";
        if (jSONArray == null || jSONArray.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                String string = jSONObject.getString("p");
                String string2 = jSONObject.getString("i");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(BceConfig.BOS_DELIMITER);
                sb2.append(string);
                sb2.append("[");
                sb2.append(string2);
                sb2.append("]");
                sb.append(sb2.toString());
                String optString = jSONObject.optString("d");
                if (!TextUtils.isEmpty(optString)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("#");
                    sb3.append(optString);
                    sb.append(sb3.toString());
                }
                i2++;
            } catch (Exception unused) {
                return str;
            }
        }
        return sb.toString();
    }

    public static String h(Activity activity) {
        return activity.getCallingPackage();
    }

    public static String d(Class<?> cls) {
        return a(cls, true);
    }

    public static String a(Class<?> cls) {
        String str = "";
        if (cls == null) {
            return str;
        }
        Package packageR = cls.getPackage();
        String name = packageR != null ? packageR.getName() : str;
        if (name != null) {
            str = name;
        }
        return str;
    }

    public static String a(View view, View view2) {
        if (view == null) {
            return String.valueOf(0);
        }
        if (view == view2) {
            return String.valueOf(0);
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return String.valueOf(0);
        }
        Class cls = view.getClass();
        if (cls == null) {
            return String.valueOf(0);
        }
        String b2 = b(cls);
        if (TextUtils.isEmpty(b2)) {
            return String.valueOf(0);
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null) {
                if (childAt == view) {
                    break;
                } else if (childAt.getClass() != null && b2.equals(b(childAt.getClass()))) {
                    i2++;
                }
            }
        }
        return String.valueOf(i2);
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        if (r1 != 0) goto L_0x0014;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
  assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], byte[], ?[OBJECT, ARRAY]]
  uses: [byte[], ?[int, boolean, OBJECT, ARRAY, byte, short, char], java.io.ByteArrayOutputStream]
  mth insns count: 23
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
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A[SYNTHETIC, Splitter:B:13:0x001e] */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] c(android.graphics.Bitmap r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0022, all -> 0x001b }
            r1.<init>()     // Catch:{ Exception -> 0x0022, all -> 0x001b }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0023, all -> 0x0018 }
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch:{ Exception -> 0x0023, all -> 0x0018 }
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x0023, all -> 0x0018 }
        L_0x0014:
            r1.close()     // Catch:{ Exception -> 0x0026 }
            goto L_0x0026
        L_0x0018:
            r4 = move-exception
            r0 = r1
            goto L_0x001c
        L_0x001b:
            r4 = move-exception
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()     // Catch:{ Exception -> 0x0021 }
        L_0x0021:
            throw r4
        L_0x0022:
            r1 = r0
        L_0x0023:
            if (r1 == 0) goto L_0x0026
            goto L_0x0014
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bj.c(android.graphics.Bitmap):byte[]");
    }

    public static String b(String str) {
        String a2 = ay.a().a(str);
        if (TextUtils.isEmpty(a2)) {
            a2 = au.a().a(str, au.a.f1637a);
        }
        return a2 == null ? "" : a2;
    }

    public static String b(Class<?> cls) {
        String str = "";
        if (cls == null) {
            return str;
        }
        String a2 = a(cls, false);
        if (!TextUtils.isEmpty(a2) && cls.isAnonymousClass()) {
            a2 = a.a(a2, "$");
        }
        if (a2 != null) {
            str = a2;
        }
        return str;
    }

    public static String c(JSONArray jSONArray) {
        String str = "";
        if (jSONArray == null || jSONArray.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                String b2 = b(jSONObject.getString("p"));
                String string = jSONObject.getString("i");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(BceConfig.BOS_DELIMITER);
                sb2.append(b2);
                sb2.append("[");
                sb2.append(string);
                sb2.append("]");
                sb.append(sb2.toString());
                i2++;
            } catch (Exception unused) {
                return str;
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.Integer> b(android.app.Activity r4, android.view.View r5) {
        /*
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            if (r5 != 0) goto L_0x0013
            r4.add(r1)
            r4.add(r1)
            return r4
        L_0x0013:
            int r1 = r5.getWidth()
            int r2 = r5.getHeight()
            boolean r3 = r5 instanceof android.webkit.WebView
            if (r3 == 0) goto L_0x0028
            int r3 = r5.getScrollX()
            int r5 = r5.getScrollY()
            goto L_0x006a
        L_0x0028:
            boolean r3 = r5 instanceof android.widget.ScrollView
            if (r3 == 0) goto L_0x003d
            android.widget.ScrollView r5 = (android.widget.ScrollView) r5
            int r3 = r5.getChildCount()
            if (r3 <= 0) goto L_0x0068
            int r3 = r5.getScrollX()
            int r5 = r5.getScrollY()
            goto L_0x006a
        L_0x003d:
            boolean r3 = r5 instanceof android.widget.ListView
            if (r3 == 0) goto L_0x0049
            android.widget.ListView r5 = (android.widget.ListView) r5
            int r5 = b(r5)
        L_0x0047:
            r3 = r0
            goto L_0x006a
        L_0x0049:
            boolean r3 = r5 instanceof android.widget.GridView
            if (r3 == 0) goto L_0x0054
            android.widget.GridView r5 = (android.widget.GridView) r5
            int r5 = b(r5)
            goto L_0x0047
        L_0x0054:
            boolean r3 = q(r5)
            if (r3 == 0) goto L_0x0068
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5     // Catch:{ Exception -> 0x0065 }
            int r3 = r5.computeHorizontalScrollOffset()     // Catch:{ Exception -> 0x0065 }
            int r5 = r5.computeVerticalScrollOffset()     // Catch:{ Exception -> 0x0066 }
            goto L_0x006a
        L_0x0065:
            r3 = r0
        L_0x0066:
            r5 = r0
            goto L_0x006a
        L_0x0068:
            r5 = r0
            r3 = r5
        L_0x006a:
            int r1 = r1 + r3
            int r2 = r2 + r5
            if (r1 <= 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r1 = r0
        L_0x0070:
            if (r2 <= 0) goto L_0x0073
            r0 = r2
        L_0x0073:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r4.add(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r4.add(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.bj.b(android.app.Activity, android.view.View):java.util.ArrayList");
    }

    public static String a(View view, String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || view == null) {
            return str2;
        }
        ViewParent parent = view.getParent();
        if (parent != null && (parent instanceof View)) {
            View view2 = (View) parent;
            if (ListView.class.getSimpleName().equals(str)) {
                try {
                    if ((view2 instanceof ListView) && view.getParent() != null) {
                        str2 = String.valueOf(((ListView) view2).getPositionForView(view));
                    }
                } catch (Throwable unused) {
                }
            } else if (GridView.class.getSimpleName().equals(str)) {
                if ((view2 instanceof GridView) && view.getParent() != null) {
                    str2 = String.valueOf(((GridView) view2).getPositionForView(view));
                }
            } else if (RecyclerView.TAG.equals(str)) {
                str2 = String.valueOf(((RecyclerView) view2).getChildLayoutPosition(view));
            }
        }
        return str2;
    }

    public static String c(View view, String str) {
        String str2;
        if (view != null) {
            Object tag = view.getTag(-97001);
            if (tag != null && (tag instanceof String)) {
                str2 = (String) tag;
                return (str != null || !TextUtils.isEmpty(str2)) ? str2 : str;
            }
        }
        str2 = "";
        if (str != null) {
        }
    }

    public static boolean c(Activity activity, View view) {
        boolean z = false;
        if (!(activity == null || view == null)) {
            View a2 = a(activity);
            if (a2 == null) {
                return false;
            }
            if (x(view) && a2 != view) {
                z = true;
            }
        }
        return z;
    }

    public static String a(Bitmap bitmap) {
        byte[] c2 = c(bitmap);
        if (c2 != null) {
            try {
                return bp.b(c2);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static boolean a(View view, Rect rect) {
        if (view == null || rect == null) {
            return false;
        }
        try {
            return view.getGlobalVisibleRect(rect);
        } catch (Exception unused) {
            return false;
        }
    }

    public static JSONArray a(Activity activity, View view) {
        JSONArray jSONArray = new JSONArray();
        if (activity == null || view == null) {
            return jSONArray;
        }
        View view2 = null;
        try {
            view2 = a(activity);
        } catch (Exception unused) {
        }
        if (view2 == null) {
            return jSONArray;
        }
        while (true) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p", l(view));
                String c2 = c(view);
                if (TextUtils.isEmpty(c2)) {
                    String str = "";
                    ViewParent parent = view.getParent();
                    if (parent != null && (parent instanceof View)) {
                        str = b((View) parent);
                    }
                    c2 = a(view, str);
                    if (TextUtils.isEmpty(c2)) {
                        c2 = a(view, view2);
                    }
                }
                jSONObject.put("i", c2);
                jSONObject.put("t", b(view));
                jSONArray.put(jSONObject);
                ViewParent parent2 = view.getParent();
                if (parent2 == null) {
                    break;
                } else if (view == view2) {
                    break;
                } else if (!(parent2 instanceof View)) {
                    break;
                } else if (x(view)) {
                    break;
                } else if (jSONArray.length() > 1000) {
                    break;
                } else {
                    view = (View) parent2;
                }
            } catch (Exception unused2) {
                jSONArray = new JSONArray();
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                jSONArray2.put(jSONArray.get(length));
            }
        } catch (Exception unused3) {
        }
        return jSONArray2;
    }

    public static int b(ListView listView) {
        int i2 = 0;
        if (listView == null) {
            return 0;
        }
        if (listView.getChildCount() > 0) {
            View childAt = listView.getChildAt(0);
            i2 = (childAt.getHeight() * listView.getFirstVisiblePosition()) + (-childAt.getTop());
        }
        return i2;
    }

    @TargetApi(11)
    public static int b(GridView gridView) {
        int i2 = 0;
        if (gridView == null) {
            return 0;
        }
        if (gridView.getChildCount() > 0) {
            View childAt = gridView.getChildAt(0);
            int i3 = 1;
            int numColumns = gridView.getNumColumns();
            if (numColumns != 0) {
                i3 = gridView.getFirstVisiblePosition() / numColumns;
            }
            i2 = (childAt.getHeight() * i3) + (-childAt.getTop());
        }
        return i2;
    }

    public static String a(JSONArray jSONArray) {
        String str = "";
        if (jSONArray == null || jSONArray.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                String string = jSONObject.getString("p");
                String string2 = jSONObject.getString("i");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(BceConfig.BOS_DELIMITER);
                sb2.append(string);
                sb2.append("[");
                sb2.append(string2);
                sb2.append("]");
                sb.append(sb2.toString());
                i2++;
            } catch (Exception unused) {
                return str;
            }
        }
        return sb.toString();
    }

    public static String a(String str) {
        String a2 = au.a().a(str, au.a.f1638b);
        return a2 == null ? "" : a2;
    }

    public static String a(Class<?> cls, boolean z) {
        if (!cls.isAnonymousClass()) {
            return z ? cls.getSimpleName() : cls.getName();
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            return z ? superclass.getSimpleName() : superclass.getName();
        }
        return "";
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !str.equals(str2);
    }

    public static View a(View view, Activity activity) {
        View view2;
        View view3 = null;
        if (view != null && activity != null) {
            try {
                view2 = a(activity);
            } catch (Exception unused) {
                view2 = null;
            }
            if (view2 != null) {
                while (true) {
                    if (view == null || view == view2 || view.getParent() == null || !(view.getParent() instanceof View)) {
                        break;
                    }
                    View view4 = (View) view.getParent();
                    if (m(view4)) {
                        view3 = view;
                        break;
                    }
                    view = view4;
                }
            } else {
                return null;
            }
        }
        return view3;
    }

    public static int a(ListView listView) {
        int height = listView.getHeight();
        if (listView.getChildCount() <= 0) {
            return height;
        }
        int height2 = listView.getChildAt(0).getHeight();
        int i2 = 1;
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            i2 = adapter.getCount();
        }
        int i3 = height2 * i2;
        if (i3 >= height) {
            height = i3;
        }
        return height;
    }

    @TargetApi(11)
    public static int a(GridView gridView) {
        int height = gridView.getHeight();
        if (gridView.getChildCount() <= 0) {
            return height;
        }
        int height2 = gridView.getChildAt(0).getHeight();
        int i2 = 1;
        ListAdapter adapter = gridView.getAdapter();
        int numColumns = gridView.getNumColumns();
        if (!(adapter == null || numColumns == 0)) {
            i2 = (int) Math.ceil(((double) adapter.getCount()) / ((double) numColumns));
        }
        int i3 = height2 * i2;
        if (i3 >= height) {
            height = i3;
        }
        return height;
    }

    public static void a(View view, LinkedHashMap<View, Integer> linkedHashMap) {
        if (view != null) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (textView.getVisibility() == 0) {
                    linkedHashMap.put(view, Integer.valueOf((int) (textView.getTextSize() * 10.0f)));
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(viewGroup.getChildAt(i2), linkedHashMap);
                }
            }
        }
    }

    public static boolean a(View view, float f2) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width * height <= 0) {
            return false;
        }
        Rect w = w(view);
        if (w != null) {
            if (((float) (w.height() * w.width())) >= f2 * ((float) width) * ((float) height)) {
                z = true;
            }
        }
        return z;
    }

    public static String a(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return str;
        }
        ResolveInfo resolveInfo = null;
        try {
            resolveInfo = packageManager.resolveActivity(intent, 0);
        } catch (Exception unused) {
        }
        if (resolveInfo == null) {
            return str;
        }
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        if (activityInfo == null) {
            return str;
        }
        String str2 = activityInfo.packageName;
        if (SapiDeviceInfo.f3010c.equals(str2)) {
            return str;
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        return str;
    }

    public static boolean a(Context context, String str) {
        boolean z = false;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        List list = null;
        try {
            list = packageManager.queryIntentActivities(intent, 65536);
        } catch (Exception unused) {
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityInfo activityInfo = ((ResolveInfo) it.next()).activityInfo;
                if (activityInfo != null && str.equals(activityInfo.packageName)) {
                    z = true;
                    break;
                }
            }
        }
        return z;
    }
}
