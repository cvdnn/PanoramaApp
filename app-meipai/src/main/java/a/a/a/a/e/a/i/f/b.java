package a.a.a.a.e.a.i.f;

import android.content.Context;
import android.view.animation.Interpolator;
import com.arashivision.algorithm.SmoothPoints;
import com.arashivision.algorithm.SmoothPoints.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class b extends c {

    public class a implements Comparator<e> {
        public int compare(Object obj, Object obj2) {
            return (int) (((e) obj).f604c - ((e) obj2).f604c);
        }
    }

    public void a(e eVar) {
        this.f597a.add(eVar);
        Collections.sort(this.f597a, new a());
    }

    public e a(double d2) {
        e eVar = null;
        if (this.f597a.size() != 1) {
            if (this.f598b == null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f597a.size(); i2++) {
                    Point point = new Point();
                    point.setFov(((e) this.f597a.get(i2)).f602a);
                    point.setDistance(((e) this.f597a.get(i2)).f603b);
                    point.setTime(((e) this.f597a.get(i2)).f604c);
                    point.setRoll(((e) this.f597a.get(i2)).f607f);
                    point.setPitch(((e) this.f597a.get(i2)).f606e);
                    point.setYaw(((e) this.f597a.get(i2)).f605d);
                    point.setPreRoll(((e) this.f597a.get(i2)).f608g);
                    arrayList.add(point);
                }
                SmoothPoints smoothPoints = new SmoothPoints((Context) null, (List<Point>) arrayList);
                this.f598b = smoothPoints;
                smoothPoints.prepare();
            }
            double d3 = ((e) this.f597a.get(0)).f604c;
            List<e> list = this.f597a;
            double d4 = ((e) list.get(list.size() - 1)).f604c;
            if (this.f597a.size() > 1 && d2 >= d3 && d2 <= d4) {
                double d5 = d4 - d3;
                float f2 = (float) (((d2 - d3) * 1.0d) / d5);
                Interpolator interpolator = this.f599c;
                if (interpolator != null) {
                    f2 = interpolator.getInterpolation(f2);
                }
                Point point2 = this.f598b.getPoint((((double) f2) * d5) + d3);
                eVar = new e();
                eVar.f603b = point2.getDistance();
                eVar.f604c = d2;
                eVar.f602a = point2.getFov();
                eVar.f605d = point2.getYaw();
                eVar.f606e = point2.getPitch();
                eVar.f607f = 0.0f;
                eVar.f608g = point2.getPreRoll();
            }
            return eVar;
        } else if (((e) this.f597a.get(0)).f604c == d2) {
            return (e) this.f597a.get(0);
        } else {
            return null;
        }
    }
}
