package com.baidu.picapture.ui.spinphoto;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.SpinView;
import com.gyf.immersionbar.ImmersionBar;
import e.c.d.e.s;
import e.c.d.m.a.b;
import e.c.d.m.a.d;
import e.c.d.m.f.a;
import e.c.d.m.f.c;
import java.io.File;

public class SpinPhotoActivity extends b<e.c.d.m.f.b, s> implements c {
    public SpinView.b t = new a(this);

    public /* synthetic */ void a(float f2) {
        if (f2 <= 1.001f) {
            ((s) this.r).o.setVisibility(4);
        } else {
            ((s) this.r).o.setVisibility(0);
        }
    }

    public d.w.a f0() {
        return s.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((e.c.d.m.f.b) this.s).a(getIntent().getStringExtra("task_id"));
        ((s) this.r).a(this);
        SpinView spinView = ((s) this.r).p;
        SpinView.b bVar = this.t;
        if (!spinView.f2008c.contains(bVar)) {
            spinView.f2008c.registerObserver(bVar);
        }
    }

    public d h0() {
        return new e.c.d.m.f.d(this);
    }

    public void onDestroy() {
        super.onDestroy();
        SpinView spinView = ((s) this.r).p;
        SpinView.b bVar = this.t;
        if (spinView.f2008c.contains(bVar)) {
            spinView.f2008c.unregisterObserver(bVar);
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        ((s) this.r).p.f6844a.a(bundle.getFloat("photo_scale"), true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putFloat("photo_scale", ((s) this.r).p.getScale());
    }

    public void a(File[] fileArr) {
        ((s) this.r).p.setImages(fileArr);
    }
}
