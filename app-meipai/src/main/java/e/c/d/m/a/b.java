package e.c.d.m.a;

import android.os.Bundle;
import d.w.a;
import e.c.d.m.a.d;

/* compiled from: BaseMVPActivity */
public abstract class b<P extends d, B extends a> extends a<B> implements e<P> {
    public P s;

    public void a(Object obj) {
        this.s = (d) obj;
    }

    public void g0() {
        P h0 = h0();
        this.s = h0;
        h0.create();
    }

    public abstract P h0();

    public void onDestroy() {
        super.onDestroy();
        P p = this.s;
        if (p != null) {
            p.e();
            this.s = null;
        }
    }

    public void onPause() {
        super.onPause();
        P p = this.s;
        if (p != null) {
            p.d();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        P p = this.s;
        if (p != null) {
            p.a(bundle);
        }
    }

    public void onResume() {
        super.onResume();
        P p = this.s;
        if (p != null) {
            p.l();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        P p = this.s;
        if (p != null) {
            p.b(bundle);
        }
    }

    public void onStart() {
        super.onStart();
        P p = this.s;
        if (p != null) {
            p.start();
        }
    }

    public void onStop() {
        super.onStop();
        P p = this.s;
        if (p != null) {
            p.stop();
        }
    }
}
