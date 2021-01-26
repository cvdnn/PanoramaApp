package com.baidu.picapture.ui.panorama.capture;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.y;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkmedia.player.capture.CaptureParamsBuilder;
import com.arashivision.sdkmedia.player.capture.InstaCapturePlayerView;
import com.arashivision.sdkmedia.player.listener.PlayerViewListener;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.panorama.guide.PanoramaGuideActivity;
import com.baidu.picapture.ui.panorama.preview.PanoramaPreviewActivity;
import com.baidu.picapture.ui.widget.dialog.Model1Dialog;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.gyf.immersionbar.ImmersionBar;
import com.jaygoo.widget.RangeSeekBar;

import e.c.b.e.Utils;
import e.c.d.e.g;
import e.c.d.m.a.d;
import e.c.d.m.d.a.e;
import e.c.d.m.d.a.f;
import e.c.d.m.d.a.p0;
import e.c.d.m.d.a.q0;
import e.c.d.m.d.a.r0;
import e.c.d.m.d.a.t0.h;
import e.c.d.m.d.a.t0.i;
import e.c.d.m.d.a.t0.j;
import e.c.d.m.d.a.t0.k;
import e.c.d.m.d.a.t0.l;
import java.util.List;

public class PanoramaCaptureActivity extends e.c.d.m.a.b<p0, g> implements q0 {
    public ModelDialog A;
    public Model1Dialog B;
    public j t;
    public e.c.d.m.d.a.t0.g u;
    public h v;
    public l w;
    public i x;
    public k y;
    public ModelDialog z;

    public class a implements e.h.a.a {
        public a() {
        }

        public void a(RangeSeekBar rangeSeekBar, float f2, float f3, boolean z) {
            int i2 = (int) f2;
            ((p0) PanoramaCaptureActivity.this.s).a(i2);
            rangeSeekBar.setIndicatorText(String.valueOf(i2));
        }
    }

    public class b implements OnTouchListener {
        public b() {
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public class c implements PlayerViewListener {
        public c() {
        }

        public void onFail(String str) {
            PanoramaCaptureActivity.this.F();
        }

        public void onLoadingFinish() {
            PanoramaCaptureActivity.this.c(true);
            PanoramaCaptureActivity panoramaCaptureActivity = PanoramaCaptureActivity.this;
            ((p0) panoramaCaptureActivity.s).a(((g) panoramaCaptureActivity.r).F.getPipeline());
        }

        public /* synthetic */ void onLoadingStatusChanged(boolean z) {
            e.b.e.b.c.b.$default$onLoadingStatusChanged(this, z);
        }
    }

    public void A() {
        ((g) this.r).h(Boolean.valueOf(false));
        ((g) this.r).e(Boolean.valueOf(true));
    }

    public void B() {
        ((g) this.r).h(Boolean.valueOf(false));
        ((g) this.r).f(Boolean.valueOf(true));
    }

    public void F() {
        c(false);
        ModelDialog modelDialog = this.A;
        if (modelDialog != null && modelDialog.isShowing()) {
            this.A.dismiss();
        }
        String string = getString(R.string.exit_picture_taking);
        String string2 = getString(R.string.device_disconnect_tips);
        String string3 = getString(R.string.connect_camera);
        com.baidu.picapture.ui.widget.dialog.Model1Dialog.b bVar = new com.baidu.picapture.ui.widget.dialog.Model1Dialog.b(null);
        bVar.f2057f = false;
        bVar.f2052a = string2;
        e.c.d.m.d.a.c cVar = new e.c.d.m.d.a.c(this);
        bVar.f2053b = string;
        bVar.f2058g = cVar;
        f fVar = new f(this);
        bVar.f2055d = string3;
        bVar.f2059h = fVar;
        Model1Dialog model1Dialog = new Model1Dialog(this, null);
        model1Dialog.f2046a = bVar;
        model1Dialog.show();
        this.B = model1Dialog;
    }

    public void K() {
        e.c.d.m.d.a.t0.g gVar = this.u;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    public void O() {
        l lVar = this.w;
        if (lVar != null) {
            lVar.notifyDataSetChanged();
        }
    }

    public void Q() {
        ((g) this.r).h(Boolean.valueOf(false));
        ((g) this.r).g(Boolean.valueOf(true));
    }

    public void R() {
        k kVar = this.y;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    public void U() {
        i iVar = this.x;
        if (iVar != null) {
            iVar.notifyDataSetChanged();
        }
    }

    public void X() {
        String string = getString(R.string.sd_card_is_full);
        String string2 = getString(R.string.replace_sd_card);
        String string3 = getString(R.string.i_know);
        com.baidu.picapture.ui.widget.dialog.ModelDialog.b bVar = new com.baidu.picapture.ui.widget.dialog.ModelDialog.b(null);
        bVar.f2067a = string;
        bVar.f2073g = false;
        bVar.f2068b = string2;
        e.c.d.m.d.a.a aVar = e.c.d.m.d.a.a.f6512a;
        bVar.f2071e = string3;
        bVar.f2075i = aVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
        c(true);
        ((g) this.r).n(Boolean.valueOf(false));
    }

    public void Z() {
        ((g) this.r).h(Boolean.valueOf(false));
        ((g) this.r).d(Boolean.valueOf(true));
    }

    public /* synthetic */ void b(e.c.d.m.i.i.k kVar) {
        a(PanoramaGuideActivity.class, null);
        finish();
        p();
        kVar.dismiss();
    }

    public void c(List<e.c.d.m.d.a.t0.i.a> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        ((g) this.r).D.setLayoutManager(linearLayoutManager);
        i iVar = new i(list);
        this.x = iVar;
        ((g) this.r).D.setAdapter(iVar);
        ((g) this.r).D.addOnItemTouchListener(new y());
        this.x.f6600b = new e.c.d.m.d.a.g(this);
    }

    public void d(List<e.c.d.m.d.a.t0.j.a> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        ((g) this.r).E.setLayoutManager(linearLayoutManager);
        j jVar = new j(list);
        this.t = jVar;
        ((g) this.r).E.setAdapter(jVar);
        ((g) this.r).E.addOnItemTouchListener(new y());
        this.t.f6605b = new e(this);
    }

    public void e(List<e.c.d.m.d.a.t0.l.a> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        ((g) this.r).O.setLayoutManager(linearLayoutManager);
        l lVar = new l(list);
        this.w = lVar;
        ((g) this.r).O.setAdapter(lVar);
        ((g) this.r).O.addOnItemTouchListener(new y());
        this.w.f6624b = new e.c.d.m.d.a.i(this);
    }

    public void f(List<e.c.d.m.d.a.t0.k.a> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        ((g) this.r).K.setLayoutManager(linearLayoutManager);
        k kVar = new k(list);
        this.y = kVar;
        ((g) this.r).K.setAdapter(kVar);
        ((g) this.r).K.addOnItemTouchListener(new y());
        this.y.f6619b = new e.c.d.m.d.a.j(this);
    }

    public d.w.a f0() {
        return g.a(getLayoutInflater());
    }

    public void g(List<e.c.d.m.d.a.t0.g.a> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        ((g) this.r).t.setLayoutManager(linearLayoutManager);
        e.c.d.m.d.a.t0.g gVar = new e.c.d.m.d.a.t0.g(list);
        this.u = gVar;
        ((g) this.r).t.setAdapter(gVar);
        ((g) this.r).t.addOnItemTouchListener(new y());
        this.u.f6588b = new e.c.d.m.d.a.h(this);
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.black).init();
        getWindow().addFlags(128);
        ((g) this.r).a(this);
        g gVar = (g) this.r;
        Boolean valueOf = Boolean.valueOf(false);
        gVar.n(valueOf);
        ((g) this.r).i(valueOf);
        c(false);
        ((g) this.r).F.setLifecycle(this.f652b);
        ((g) this.r).A.setIndicatorTextDecimalFormat("0");
        ((g) this.r).A.setProgress(8.0f);
        ((g) this.r).A.setOnRangeChangedListener(new a());
        String string = getString(R.string.sd_card_error);
        String string2 = getString(R.string.check_sd_card);
        String string3 = getString(R.string.i_know);
        com.baidu.picapture.ui.widget.dialog.ModelDialog.b bVar = new com.baidu.picapture.ui.widget.dialog.ModelDialog.b(null);
        bVar.f2067a = string;
        bVar.f2073g = false;
        bVar.f2068b = string2;
        e.c.d.m.d.a.a aVar = e.c.d.m.d.a.a.f6512a;
        bVar.f2071e = string3;
        bVar.f2075i = aVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        this.z = modelDialog;
        ((g) this.r).H.setOnTouchListener(new b());
    }

    public void h(int i2) {
        ((g) this.r).c(Boolean.valueOf(true));
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pano_capture_count_down_anim);
        ((g) this.r).q.setText(String.valueOf(i2));
        ((g) this.r).q.startAnimation(loadAnimation);
    }

    public d h0() {
        return new r0(this);
    }

    public void i(int i2) {
        ((g) this.r).K.scrollToPosition(i2);
    }

    public final void i0() {
        g gVar = (g) this.r;
        Boolean valueOf = Boolean.valueOf(false);
        gVar.d(valueOf);
        ((g) this.r).f(valueOf);
        ((g) this.r).e(valueOf);
        ((g) this.r).m(valueOf);
        ((g) this.r).g(valueOf);
        ((g) this.r).l(valueOf);
    }

    public void j(int i2) {
        j jVar = this.t;
        if (jVar != null) {
            jVar.notifyItemChanged(i2);
        }
    }

    public void k() {
        ((g) this.r).n(Boolean.valueOf(false));
        Model1Dialog model1Dialog = this.B;
        if (model1Dialog == null || !model1Dialog.isShowing()) {
            String string = getString(R.string.taking_error);
            String string2 = getString(R.string.please_taking_again);
            String string3 = getString(R.string.i_know);
            com.baidu.picapture.ui.widget.dialog.ModelDialog.b bVar = new com.baidu.picapture.ui.widget.dialog.ModelDialog.b(null);
            bVar.f2067a = string;
            bVar.f2073g = false;
            bVar.f2068b = string2;
            e.c.d.m.d.a.k kVar = new e.c.d.m.d.a.k(this);
            bVar.f2071e = string3;
            bVar.f2075i = kVar;
            ModelDialog modelDialog = new ModelDialog(this, null);
            modelDialog.f2060a = bVar;
            modelDialog.show();
            this.A = modelDialog;
        }
    }

    public /* synthetic */ void m(int i2) {
        ((p0) this.s).g(i2);
    }

    public /* synthetic */ void n(int i2) {
        ((p0) this.s).h(i2);
    }

    public /* synthetic */ void o(int i2) {
        ((p0) this.s).e(i2);
    }

    public void onBackPressed() {
    }

    public void onDestroy() {
        super.onDestroy();
        ((g) this.r).F.destroy();
    }

    public /* synthetic */ void p(int i2) {
        ((p0) this.s).i(i2);
    }

    public /* synthetic */ void q(int i2) {
        ((p0) this.s).b(i2);
    }

    public /* synthetic */ void r(int i2) {
        ((p0) this.s).j(i2);
    }

    public void s() {
        ((g) this.r).c(Boolean.valueOf(false));
    }

    public void u() {
        ModelDialog modelDialog = this.z;
        if (modelDialog != null && !modelDialog.isShowing()) {
            this.z.show();
        }
        c(true);
        ((g) this.r).n(Boolean.valueOf(false));
    }

    public void w() {
        h hVar = this.v;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    public void x() {
        j jVar = this.t;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    public void y() {
        ((g) this.r).h(Boolean.valueOf(false));
        ((g) this.r).m(Boolean.valueOf(true));
    }

    public void a(List<e.c.d.m.d.a.t0.h.a> list) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(0);
        ((g) this.r).w.setLayoutManager(linearLayoutManager);
        h hVar = new h(list);
        this.v = hVar;
        ((g) this.r).w.setAdapter(hVar);
        ((g) this.r).w.addOnItemTouchListener(new y());
        this.v.f6594b = new e.c.d.m.d.a.d(this);
    }

    public void n() {
        ((g) this.r).F.setPlayerViewListener(new c());
        InstaCapturePlayerView instaCapturePlayerView = ((g) this.r).F;
        CaptureParamsBuilder mediaOffset = new CaptureParamsBuilder().setCameraType(InstaCameraManager.getInstance().getCameraType()).setMediaOffset(InstaCameraManager.getInstance().getMediaOffset());
        mediaOffset.setRenderModelType(0);
        instaCapturePlayerView.prepare(mediaOffset);
        ((g) this.r).F.play();
    }

    public void o() {
        ((g) this.r).h(Boolean.valueOf(false));
        ((g) this.r).l(Boolean.valueOf(true));
    }

    public void p() {
        ((p0) this.s).a();
    }

    public void c(boolean z2) {
        ((g) this.r).b(Boolean.valueOf(z2));
        if (z2) {
            ((g) this.r).k(Boolean.valueOf(true));
            ((g) this.r).h(Boolean.valueOf(true));
            return;
        }
        g gVar = (g) this.r;
        Boolean valueOf = Boolean.valueOf(false);
        gVar.j(valueOf);
        ((g) this.r).k(valueOf);
        ((g) this.r).h(valueOf);
        i0();
    }

    public void d(int i2) {
        String string = getString(R.string.battery_is_poor);
        String string2 = getString(R.string.battery_only);
        String string3 = getString(R.string.battery_percent);
        String string4 = getString(R.string.i_know);
        com.baidu.picapture.ui.widget.dialog.Model1Dialog.b bVar = new com.baidu.picapture.ui.widget.dialog.Model1Dialog.b(null);
        bVar.f2057f = false;
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(string2);
        sb.append(i2);
        sb.append(string3);
        bVar.f2052a = sb.toString();
        e.c.d.m.d.a.a aVar = e.c.d.m.d.a.a.f6512a;
        bVar.f2055d = string4;
        bVar.f2059h = aVar;
        Model1Dialog model1Dialog = new Model1Dialog(this, null);
        model1Dialog.f2046a = bVar;
        model1Dialog.show();
    }

    public void e(int i2) {
        ((g) this.r).D.scrollToPosition(i2);
    }

    public void a() {
        finish();
    }

    public void a(e.c.d.m.d.a.t0.j.b bVar) {
        int ordinal = bVar.ordinal();
        Boolean valueOf = Boolean.valueOf(false);
        switch (ordinal) {
            case 1:
                ((g) this.r).d(valueOf);
                break;
            case 2:
                ((g) this.r).f(valueOf);
                break;
            case 3:
                ((g) this.r).e(valueOf);
                break;
            case 4:
                ((g) this.r).m(valueOf);
                break;
            case 5:
                ((g) this.r).g(valueOf);
                break;
            case 6:
                ((g) this.r).l(valueOf);
                break;
        }
        ((g) this.r).h(Boolean.valueOf(true));
    }

    public void c(int i2) {
        LayoutParams layoutParams = ((g) this.r).o.getLayoutParams();
        layoutParams.width = Utils.b((((float) i2) * 19.0f) / 100.0f);
        if (i2 <= 20) {
            ((g) this.r).p.setBackground(getDrawable(R.drawable.ic_pano_battery_frame_red));
            ((g) this.r).o.setBackground(getDrawable(R.drawable.pano_battery_red_shape));
        } else {
            ((g) this.r).p.setBackground(getDrawable(R.drawable.ic_pano_battery_frame_white));
            ((g) this.r).o.setBackground(getDrawable(R.drawable.pano_battery_white_shape));
        }
        ((g) this.r).o.setLayoutParams(layoutParams);
    }

    public /* synthetic */ void a(e.c.d.m.i.i.k kVar) {
        p();
        kVar.dismiss();
    }

    public void a(int i2) {
        ((g) this.r).A.setProgress((float) i2);
    }

    public void c(String str, String str2) {
        ((g) this.r).n(Boolean.valueOf(false));
        Bundle bundle = new Bundle();
        bundle.putString("task_id", str);
        bundle.putString("picture_path", str2);
        a(PanoramaPreviewActivity.class, bundle);
    }

    public /* synthetic */ void c(e.c.d.m.i.i.k kVar) {
        ((p0) this.s).k();
        kVar.dismiss();
    }
}
