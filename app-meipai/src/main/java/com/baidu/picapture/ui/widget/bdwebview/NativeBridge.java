package com.baidu.picapture.ui.widget.bdwebview;

import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.baidu.picapture.ui.widget.bdwebview.bean.JsCall;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import e.c.d.m.i.h.b;
import e.c.d.m.i.h.c;
import e.c.d.m.i.h.d;
import e.c.d.m.i.h.e;
import e.g.b.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeBridge {

    /* renamed from: a reason: collision with root package name */
    public WebView f2016a;

    /* renamed from: b reason: collision with root package name */
    public Map<String, Object> f2017b = new HashMap();

    /* renamed from: c reason: collision with root package name */
    public int f2018c = 0;

    /* renamed from: d reason: collision with root package name */
    public SparseArray<a> f2019d = new SparseArray<>();

    public interface a {
        void a(String str);
    }

    public NativeBridge(WebView webView) {
        this.f2016a = webView;
    }

    public void a(Object obj) {
        String name = obj.getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0 && lastIndexOf != name.length() - 1) {
            String substring = name.substring(lastIndexOf + 1);
            if (!this.f2017b.containsKey(substring)) {
                this.f2017b.put(substring, obj);
            }
        }
    }

    /* renamed from: c */
    public final void b(String str, String str2, a aVar) {
        int i2;
        if (aVar != null) {
            int i3 = this.f2018c + 1;
            this.f2018c = i3;
            this.f2019d.put(i3, aVar);
            i2 = this.f2018c;
        } else {
            i2 = -1;
        }
        String format = String.format("window.JSBridge.handleCallFromNative(%s)", new Object[]{new j().a((Object) new JsCall(str, str2, Integer.valueOf(i2)))});
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f2016a.evaluateJavascript(format, null);
        } else {
            this.f2016a.post(new e(this, format));
        }
    }

    @JavascriptInterface
    @Keep
    public String handleCallFromJs(String str, String str2) {
        Object invoke;
        Class<a> cls = a.class;
        Class<String> cls2 = String.class;
        String str3 = WBConstants.SHARE_CALLBACK_ID;
        String str4 = WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA;
        int indexOf = str.indexOf(46);
        String str5 = "";
        if (indexOf >= 0 && indexOf != str.length() - 1) {
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            Object obj = this.f2017b.get(substring);
            if (obj == null) {
                return str5;
            }
            Class cls3 = obj.getClass();
            int i2 = -1;
            Object obj2 = null;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Object string = jSONObject.has(str4) ? jSONObject.getString(str4) : null;
                if (jSONObject.has(str3)) {
                    i2 = jSONObject.getInt(str3);
                }
                if (string == null && i2 < 0) {
                    Method method = cls3.getMethod(substring2, new Class[0]);
                    if (!a(method)) {
                        return str5;
                    }
                    invoke = method.invoke(obj, new Object[0]);
                } else if (string != null && i2 < 0) {
                    Method method2 = cls3.getMethod(substring2, new Class[]{cls2});
                    if (!a(method2)) {
                        return str5;
                    }
                    invoke = method2.invoke(obj, new Object[]{string});
                } else if (string == null) {
                    Method method3 = cls3.getMethod(substring2, new Class[]{cls});
                    if (!a(method3)) {
                        return str5;
                    }
                    invoke = method3.invoke(obj, new Object[]{new d(this, i2)});
                } else {
                    Method method4 = cls3.getMethod(substring2, new Class[]{cls2, cls});
                    if (!a(method4)) {
                        return str5;
                    }
                    invoke = method4.invoke(obj, new Object[]{string, new b(this, i2)});
                }
                obj2 = invoke;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | JSONException e2) {
                e2.printStackTrace();
            }
            if (obj2 instanceof String) {
                return (String) obj2;
            }
        }
        return str5;
    }

    @JavascriptInterface
    @Keep
    public void handleReturnCallFromJs(String str) {
        String str2 = WBConstants.SHARE_CALLBACK_ID;
        String str3 = WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA;
        String str4 = null;
        int i2 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str3)) {
                str4 = jSONObject.getString(str3);
            }
            if (jSONObject.has(str2)) {
                i2 = jSONObject.getInt(str2);
            }
            a aVar = (a) this.f2019d.get(i2);
            if (aVar != null) {
                aVar.a(str4);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void b(String str) {
        this.f2016a.evaluateJavascript(str, null);
    }

    public /* synthetic */ void b(int i2, String str) {
        a(new JsCall(null, str, Integer.valueOf(i2)));
    }

    public void a(String str, String str2, a aVar) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                new JSONObject(str2);
            } catch (JSONException unused) {
            }
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b(str, str2, aVar);
        } else {
            this.f2016a.post(new e.c.d.m.i.h.a(this, str, str2, aVar));
        }
    }

    public /* synthetic */ void a(String str) {
        this.f2016a.evaluateJavascript(str, null);
    }

    public final void a(JsCall jsCall) {
        String format = String.format("window.JSBridge.handleReturnCallFromNative(%s)", new Object[]{new j().a((Object) jsCall)});
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f2016a.evaluateJavascript(format, null);
        } else {
            this.f2016a.post(new c(this, format));
        }
    }

    public /* synthetic */ void a(int i2, String str) {
        a(new JsCall(null, str, Integer.valueOf(i2)));
    }

    public final boolean a(Method method) {
        if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) != null) {
            return true;
        }
        method.getName();
        return false;
    }
}
