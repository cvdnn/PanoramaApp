package e.k.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;

/* compiled from: WeiboSsoSdkConfig */
public class c implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    public Context f8915a;

    /* renamed from: b reason: collision with root package name */
    public String f8916b;

    /* renamed from: c reason: collision with root package name */
    public String f8917c;

    /* renamed from: d reason: collision with root package name */
    public String f8918d;

    /* renamed from: e reason: collision with root package name */
    public String f8919e;

    /* renamed from: f reason: collision with root package name */
    public String f8920f;

    /* renamed from: g reason: collision with root package name */
    public String f8921g;

    /* renamed from: h reason: collision with root package name */
    public HashMap<String, String> f8922h = new HashMap<>();

    public c() {
        String str = "";
        this.f8916b = str;
        this.f8917c = str;
        this.f8918d = str;
        this.f8919e = str;
        this.f8920f = str;
        this.f8921g = str;
    }

    public final String a(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public Object clone() {
        try {
            c cVar = (c) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Entry entry : cVar.f8922h.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            cVar.f8922h = hashMap;
            return cVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean a() {
        return this.f8915a != null && !TextUtils.isEmpty(this.f8916b) && !TextUtils.isEmpty(this.f8918d) && !TextUtils.isEmpty(this.f8919e);
    }
}
