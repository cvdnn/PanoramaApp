package com.baidu.picapture.ui.panorama.preview;

import android.app.Activity;
import com.arashivision.sdkmedia.player.image.ImageParamsBuilder;
import com.arashivision.sdkmedia.player.listener.PlayerViewListener;
import com.arashivision.sdkmedia.work.WorkWrapper;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.widget.dialog.InputDialog;
import com.gyf.immersionbar.ImmersionBar;
import e.c.d.e.k;
import e.c.d.m.a.b;
import e.c.d.m.d.c.c;
import e.c.d.m.d.c.d;
import e.c.d.m.d.c.e;

public class PanoramaPreviewActivity extends b<c, k> implements d {

    public class a implements PlayerViewListener {
        public a() {
        }

        public void onFail(String str) {
        }

        public void onLoadingFinish() {
            ((c) PanoramaPreviewActivity.this.s).o();
        }

        public /* synthetic */ void onLoadingStatusChanged(boolean z) {
            e.b.e.b.c.b.$default$onLoadingStatusChanged(this, z);
        }
    }

    public void J() {
        ((k) this.r).o.switchPerspectiveMode();
        ((k) this.r).p.setBackgroundResource(R.drawable.pano_preview_mode_perspective_selector);
    }

    public void P() {
        ((k) this.r).o.switchFisheyeMode();
        ((k) this.r).o.setConstraint(20.0f, 120.0f, 100.0f, 650.0f, 900.0f, 650.0f);
        ((k) this.r).p.setBackgroundResource(R.drawable.pano_preview_mode_fish_eye_selector);
    }

    public void b(WorkWrapper workWrapper) {
        ImageParamsBuilder imageParamsBuilder = new ImageParamsBuilder();
        imageParamsBuilder.setRenderModelType(10);
        imageParamsBuilder.setScreenRatio(2, 1);
        ((k) this.r).o.prepare(workWrapper, imageParamsBuilder);
        ((k) this.r).o.play();
        ((k) this.r).p.setBackgroundResource(R.drawable.pano_preview_mode_plane_selector);
    }

    public void c(String str) {
        String string = getString(R.string.add_picture_name);
        String string2 = getString(R.string.enter_picture_name);
        String string3 = getString(R.string.yes);
        String string4 = getString(R.string.no);
        InputDialog.b bVar = new InputDialog.b(null);
        bVar.f2037a = string;
        bVar.f2043g = 20;
        bVar.f2042f = false;
        bVar.f2038b = string2;
        bVar.f2039c = str;
        e.c.d.m.d.c.a aVar = e.c.d.m.d.c.a.f6651a;
        bVar.f2040d = string4;
        bVar.f2044h = aVar;
        e.c.d.m.d.c.b bVar2 = new e.c.d.m.d.c.b(this);
        bVar.f2041e = string3;
        bVar.f2045i = bVar2;
        InputDialog inputDialog = new InputDialog(this, null);
        inputDialog.f2027a = bVar;
        inputDialog.f2034h.postDelayed(inputDialog.f2035i, 200);
        inputDialog.show();
    }

    public d.w.a f0() {
        return k.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.black).init();
        ((k) this.r).a(this);
        ((c) this.s).a(getIntent().getStringExtra("task_id"), getIntent().getStringExtra("picture_path"));
    }

    public e.c.d.m.a.d h0() {
        return new e(this);
    }

    public void onBackPressed() {
    }

    public void onDestroy() {
        super.onDestroy();
        ((k) this.r).o.destroy();
    }

    public void p() {
        finish();
    }

    public void a(WorkWrapper workWrapper) {
        ((k) this.r).o.setLifecycle(this.f652b);
        ((k) this.r).o.setPlayerViewListener(new a());
        ((k) this.r).o.prepare(workWrapper, new ImageParamsBuilder());
        ((k) this.r).o.play();
    }

    public /* synthetic */ void a(e.c.d.m.i.i.k kVar, String str) {
        kVar.dismiss();
        ((c) this.s).b(str);
    }

    public void c(WorkWrapper workWrapper) {
        ((k) this.r).o.prepare(workWrapper, new ImageParamsBuilder());
        ((k) this.r).o.play();
    }
}
