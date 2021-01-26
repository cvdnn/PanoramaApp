package a.a.a.a.e.a.k;

import android.view.MotionEvent;
import java.util.ArrayList;

public class e {

    /* renamed from: a reason: collision with root package name */
    public a f642a;

    /* renamed from: b reason: collision with root package name */
    public ArrayList<Integer> f643b = new ArrayList<>();

    /* renamed from: c reason: collision with root package name */
    public float[] f644c = new float[2];

    /* renamed from: d reason: collision with root package name */
    public boolean f645d = false;

    /* renamed from: e reason: collision with root package name */
    public float[] f646e = new float[2];

    /* renamed from: f reason: collision with root package name */
    public boolean f647f = false;

    /* renamed from: g reason: collision with root package name */
    public long f648g = -1;

    /* renamed from: h reason: collision with root package name */
    public boolean f649h = false;

    public interface a {
    }

    public e(a aVar) {
        this.f642a = aVar;
    }

    public final void a(MotionEvent motionEvent) {
        if (this.f643b.size() == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(((Integer) this.f643b.get(0)).intValue());
            this.f644c[0] = motionEvent.getX(findPointerIndex);
            this.f644c[1] = motionEvent.getY(findPointerIndex);
            this.f645d = false;
        } else if (this.f643b.size() == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(((Integer) this.f643b.get(0)).intValue());
            int findPointerIndex3 = motionEvent.findPointerIndex(((Integer) this.f643b.get(1)).intValue());
            this.f646e[0] = Math.abs(motionEvent.getX(findPointerIndex2) - motionEvent.getX(findPointerIndex3));
            this.f646e[1] = Math.abs(motionEvent.getY(findPointerIndex2) - motionEvent.getY(findPointerIndex3));
            this.f647f = false;
        }
    }
}
