package e.i.a.h.d;

import android.util.SparseArray;
import e.i.a.c;
import java.util.HashMap;

/* compiled from: KeyToIdMap */
public class h {

    /* renamed from: a reason: collision with root package name */
    public final HashMap<String, Integer> f8724a;

    /* renamed from: b reason: collision with root package name */
    public final SparseArray<String> f8725b;

    public h() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f8724a = hashMap;
        this.f8725b = sparseArray;
    }

    public String a(c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.f8650c);
        sb.append(cVar.f8651d);
        sb.append(cVar.v.f8854a);
        return sb.toString();
    }
}
