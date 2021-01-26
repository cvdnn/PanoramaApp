package a.a.a.a.e.a.i.f;

import android.view.animation.Interpolator;
import com.arashivision.algorithm.SmoothPoints;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class c implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public List<e> f597a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    public transient SmoothPoints f598b;

    /* renamed from: c reason: collision with root package name */
    public Interpolator f599c;

    /* renamed from: d reason: collision with root package name */
    public boolean f600d;

    public abstract e a(double d2);

    public void a(e eVar) {
        this.f597a.add(eVar);
    }

    public int hashCode() {
        String str = new String();
        for (int i2 = 0; i2 < this.f597a.size(); i2++) {
            e eVar = (e) this.f597a.get(i2);
            StringBuilder sb = new StringBuilder();
            sb.append(eVar.f603b + eVar.f602a + eVar.f606e);
            sb.append(Arrays.toString(eVar.f609h));
            sb.append(eVar.f607f);
            sb.append(eVar.f604c);
            sb.append(eVar.f605d);
            str = sb.toString();
        }
        return str.hashCode();
    }
}
