package a.a.a.a.e.a.e;

import android.view.animation.Interpolator;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.log.MediaLogger;

public class d {

    /* renamed from: a reason: collision with root package name */
    public long f505a = -1;

    /* renamed from: b reason: collision with root package name */
    public Transform f506b;

    /* renamed from: c reason: collision with root package name */
    public Transform f507c;

    /* renamed from: d reason: collision with root package name */
    public Interpolator f508d;

    static {
        MediaLogger.getLogger(d.class);
    }

    public float a() {
        if (this.f505a == -1) {
            return -1.0f;
        }
        float currentTimeMillis = (((float) (System.currentTimeMillis() - this.f505a)) * 1.0f) / 1000.0f;
        if (currentTimeMillis >= 1.0f) {
            this.f505a = -1;
        }
        return currentTimeMillis;
    }

    public Transform a(float f2) {
        if (f2 < 1.0f) {
            float interpolation = this.f508d.getInterpolation(f2);
            return new Transform(((this.f507c.getYaw() - this.f506b.getYaw()) * interpolation) + this.f506b.getYaw(), ((this.f507c.getPitch() - this.f506b.getPitch()) * interpolation) + this.f506b.getPitch(), ((this.f507c.getDistance() - this.f506b.getDistance()) * interpolation) + this.f506b.getDistance(), ((this.f507c.getFov() - this.f506b.getFov()) * interpolation) + this.f506b.getFov());
        }
        Transform transform = new Transform(this.f507c.getYaw(), this.f507c.getPitch(), this.f507c.getDistance(), this.f507c.getFov());
        this.f505a = -1;
        this.f506b = null;
        this.f507c = null;
        this.f508d = null;
        return transform;
    }
}
