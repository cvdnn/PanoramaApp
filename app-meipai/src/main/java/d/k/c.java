package d.k;

import android.util.Log;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import e.c.d.b;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DataBinderMapperImpl */
public class c extends b {

    /* renamed from: a reason: collision with root package name */
    public Set<Class<? extends b>> f5036a = new HashSet();

    /* renamed from: b reason: collision with root package name */
    public List<b> f5037b = new CopyOnWriteArrayList();

    /* renamed from: c reason: collision with root package name */
    public List<String> f5038c = new CopyOnWriteArrayList();

    public c() {
        a(new b());
    }

    public void a(b bVar) {
        if (this.f5036a.add(bVar.getClass())) {
            this.f5037b.add(bVar);
            for (b a2 : bVar.a()) {
                a(a2);
            }
        }
    }

    public final boolean b() {
        String str = "unable to add feature mapper for ";
        String str2 = "MergedDataBinderMapper";
        boolean z = false;
        for (String str3 : this.f5038c) {
            try {
                Class cls = Class.forName(str3);
                if (b.class.isAssignableFrom(cls)) {
                    a((b) cls.newInstance());
                    this.f5038c.remove(str3);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str3);
                Log.e(str2, sb.toString(), e2);
            } catch (InstantiationException e3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str3);
                Log.e(str2, sb2.toString(), e3);
            }
        }
        return z;
    }

    public ViewDataBinding a(d dVar, View view, int i2) {
        for (b a2 : this.f5037b) {
            ViewDataBinding a3 = a2.a(dVar, view, i2);
            if (a3 != null) {
                return a3;
            }
        }
        if (b()) {
            return a(dVar, view, i2);
        }
        return null;
    }

    public ViewDataBinding a(d dVar, View[] viewArr, int i2) {
        for (b a2 : this.f5037b) {
            ViewDataBinding a3 = a2.a(dVar, viewArr, i2);
            if (a3 != null) {
                return a3;
            }
        }
        if (b()) {
            return a(dVar, viewArr, i2);
        }
        return null;
    }
}
