package com.baidu.picapture.ui.panorama.simplepreview;

import android.app.Activity;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arashivision.sdkmedia.player.image.ImageParamsBuilder;
import com.arashivision.sdkmedia.player.image.InstaImagePlayerView;
import com.arashivision.sdkmedia.player.listener.PlayerViewListener;
import com.arashivision.sdkmedia.work.WorkWrapper;
import com.baidu.picapture.R;
import com.gyf.immersionbar.ImmersionBar;
import e.c.d.e.k0;
import e.c.d.e.m;
import e.c.d.m.a.b;
import e.c.d.m.a.d;
import e.c.d.m.d.d.c;

public class PanoramaSimplePreviewActivity extends b<e.c.d.m.d.d.b, m> implements c {

    public class a implements PlayerViewListener {
        public a() {
        }

        public void onFail(String str) {
        }

        public void onLoadingFinish() {
        }

        public /* synthetic */ void onLoadingStatusChanged(boolean z) {
            e.b.e.b.c.b.$default$onLoadingStatusChanged(this, z);
        }
    }

    public /* synthetic */ void a(View view) {
        ((e.c.d.m.d.d.b) this.s).a();
    }

    public void c() {
        finish();
    }

    public d.w.a f0() {
        String str;
        View inflate = getLayoutInflater().inflate(R.layout.activity_panorama_simple_preview, null, false);
        View findViewById = inflate.findViewById(R.id.header);
        if (findViewById != null) {
            k0 a2 = k0.a(findViewById);
            InstaImagePlayerView instaImagePlayerView = (InstaImagePlayerView) inflate.findViewById(R.id.image_player);
            if (instaImagePlayerView != null) {
                return new m((ConstraintLayout) inflate, a2, instaImagePlayerView);
            }
            str = "imagePlayer";
        } else {
            str = "header";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((e.c.d.m.d.d.b) this.s).a(getIntent().getStringExtra("task_id"));
        ((m) this.r).f6044b.n.setOnClickListener(new e.c.d.m.d.d.a(this));
    }

    public d h0() {
        return new e.c.d.m.d.d.d(this);
    }

    public void i(String str) {
        ((m) this.r).f6044b.q.setText(str);
    }

    public void onDestroy() {
        super.onDestroy();
        ((m) this.r).f6045c.destroy();
    }

    public void a(WorkWrapper workWrapper) {
        ((m) this.r).f6045c.setLifecycle(this.f652b);
        ((m) this.r).f6045c.setPlayerViewListener(new a());
        ((m) this.r).f6045c.prepare(workWrapper, new ImageParamsBuilder());
        ((m) this.r).f6045c.play();
    }
}
