package com.baidu.picapture.ui.spin.capture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.OrientationEventListener;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView.d0;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.device.SpinDeviceActivity;
import com.baidu.picapture.ui.spin.preview.SpinPreviewActivity;
import com.baidu.picapture.ui.webview.WebViewActivity;
import com.baidu.picapture.ui.widget.dialog.CaptureGuideDialog;
import com.baidu.picapture.ui.widget.dialog.Model1Dialog;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import e.c.b.e.Utils;
import e.c.d.e.n;
import e.c.d.i.b.j;
import e.c.d.m.a.b;
import e.c.d.m.e.a.d;
import e.c.d.m.e.a.e;
import e.c.d.m.e.a.f;
import e.c.d.m.e.a.g;
import e.c.d.m.e.a.h;
import e.c.d.m.e.a.i;
import e.c.d.m.e.a.k;
import e.c.d.m.e.a.l;
import e.c.d.m.e.a.m;
import e.c.d.m.e.a.s;
import e.c.d.m.e.a.SpinCaptureContact;
import e.c.d.m.e.a.u;
import e.c.d.m.i.g.c;
import java.util.List;

public class SpinCaptureActivity extends b<s, n> implements SpinCaptureContact {
    public j.b A = new d(this);
    public Handler t = new Handler();
    public j u;
    public OrientationEventListener v;
    public int w = -1;
    public c x;
    public ModelDialog y;
    public ModelDialog z;

    public class a extends OrientationEventListener {
        public a(Context context, int i2) {
            super(context, i2);
        }

        public void onOrientationChanged(int i2) {
            SpinCaptureActivity.this.l0();
        }
    }

    public void D() {
        String string = getString(R.string.finish_picture_taking);
        String string2 = getString(R.string.no_save_picture_taking);
        String string3 = getString(R.string.continue_picture_taking);
        String string4 = getString(R.string.end_picture_taking);
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = string;
        bVar.f2073g = false;
        bVar.f2068b = string2;
        bVar.f2072f = R.drawable.red_text_color_selector;
        i iVar = new i(this);
        bVar.f2069c = string3;
        bVar.f2074h = iVar;
        f fVar = new f(this);
        bVar.f2071e = string4;
        bVar.f2075i = fVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public void G() {
        c cVar = this.x;
        if (cVar != null) {
            cVar.notifyItemChanged(0);
            this.x.notifyItemChanged(1);
        }
    }

    public void I() {
        String string = getString(R.string.exit_picture_taking);
        String string2 = getString(R.string.device_disconnect_tips);
        String string3 = getString(R.string.connect_device);
        Model1Dialog.b bVar = new Model1Dialog.b(null);
        bVar.f2057f = false;
        bVar.f2052a = string2;
        k kVar = new k(this);
        bVar.f2053b = string;
        bVar.f2058g = kVar;
        m mVar = new m(this);
        bVar.f2055d = string3;
        bVar.f2059h = mVar;
        Model1Dialog model1Dialog = new Model1Dialog(this, null);
        model1Dialog.f2046a = bVar;
        model1Dialog.show();
    }

    public void M() {
        ((n) this.r).b(Boolean.valueOf(false));
        i(true);
        ((n) this.r).mCircleProgressBar.a(0, "");
        ((n) this.r).B.setVisibility(4);
        ((n) this.r).tv4.setBackground(getDrawable(R.drawable.white_circle_shape));
    }

    public void S() {
        String string = getString(R.string.exit_picture_taking);
        String string2 = getString(R.string.make_sure_exit_picture_taking);
        String string3 = getString(R.string.cancel);
        String string4 = getString(R.string.exit);
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = string;
        bVar.f2073g = false;
        bVar.f2068b = string2;
        bVar.f2072f = R.drawable.red_text_color_selector;
        e.c.d.m.e.a.a aVar = e.c.d.m.e.a.a.f6661a;
        bVar.f2069c = string3;
        bVar.f2074h = aVar;
        g gVar = new g(this);
        bVar.f2071e = string4;
        bVar.f2075i = gVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public void T() {
        setRequestedOrientation(-1);
    }

    public void a0() {
        CaptureGuideDialog captureGuideDialog = new CaptureGuideDialog(this);
        captureGuideDialog.f2026c = new e.c.d.m.e.a.b(this);
        captureGuideDialog.show();
    }

    public void b(boolean z2) {
        int i2 = z2 ? 0 : 8;
        if (i2 != ((n) this.r).t.getVisibility()) {
            ((n) this.r).t.setVisibility(i2);
        }
    }

    public /* synthetic */ void c(e.c.d.m.i.i.k kVar) {
        ((s) this.s).x();
        kVar.dismiss();
    }

    public void d(boolean z2) {
        ((n) this.r).c(Boolean.valueOf(z2));
        B b2 = this.r;
        ((n) b2).v.setLayoutParams(((n) b2).v.getLayoutParams());
        ((n) this.r).G.setImageResource(z2 ? R.drawable.ic_line_help_on : R.drawable.ic_line_help_off);
    }

    public void e() {
        if (this.z == null) {
            String string = getString(R.string.memory_full);
            String string2 = getString(R.string.free_up_space);
            String string3 = getString(R.string.exit_picture_taking);
            ModelDialog.b bVar = new ModelDialog.b(null);
            bVar.f2067a = string;
            bVar.f2073g = false;
            bVar.f2068b = string2;
            e eVar = new e(this);
            bVar.f2071e = string3;
            bVar.f2075i = eVar;
            ModelDialog modelDialog = new ModelDialog(this, null);
            modelDialog.f2060a = bVar;
            this.z = modelDialog;
        }
        if (!this.z.isShowing()) {
            this.z.show();
        }
    }

    public /* synthetic */ void f(e.c.d.m.i.i.k kVar) {
        ((s) this.s).g();
        kVar.dismiss();
    }

    public d.w.a f0() {
        return n.a(getLayoutInflater());
    }

    @SuppressLint({"DefaultLocale"})
    public void g(boolean z2) {
        ((n) this.r).F.setChecked(z2);
    }

    public void g0() {
        super.g0();
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        ((n) this.r).a(this);
        ((n) this.r).c(Boolean.valueOf(true));
        ((s) this.s).init();
        j a2 = Utils.a(e.c.d.i.b.k.CAMERA1, ((n) this.r).o);
        this.u = a2;
        ((e.c.d.i.b.g) a2).f6162e = this.A;
        ((n) this.r).F.setOnCheckedChangeListener(new l(this));
        this.v = new a(this, 3);
        ((e.c.d.i.b.g) this.u).f6163f = new h(this);
    }

    public e.c.d.m.a.d h0() {
        return new u(this);
    }

    public void i() {
        setRequestedOrientation(14);
        ((n) this.r).b(Boolean.valueOf(true));
        ((n) this.r).B.setVisibility(0);
        ((n) this.r).tv4.setBackground(getDrawable(R.drawable.grey_circle_shape));
    }

    public /* synthetic */ void i0() {
        b(false);
        ((s) this.s).s();
    }

    public void userGuide() {
        String string = getString(R.string.user_guide);
        Bundle bundle = new Bundle();
        bundle.putString("title", string);
        bundle.putString("URL", e.c.d.n.e.e());
        a(WebViewActivity.class, bundle);
    }

    public final void k(boolean z2) {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        androidx.constraintlayout.widget.ConstraintLayout.a aVar = (androidx.constraintlayout.widget.ConstraintLayout.a) ((n) this.r).o.getLayoutParams();
        if (z2) {
            aVar.height = (point.x * 4) / 3;
        } else {
            aVar.width = (point.y * 4) / 3;
        }
        ((n) this.r).o.setLayoutParams(aVar);
    }

    public void k0() {
        i(false);
        b(false);
        ((s) this.s).c();
    }

    public final void l0() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (this.w != rotation) {
            this.w = rotation;
            if (1 == getResources().getConfiguration().orientation) {
                k(true);
            } else {
                k(false);
            }
            this.u.a(rotation);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
        ((s) this.s).C();
    }

    public void onDestroy() {
        super.onDestroy();
        this.t.removeCallbacksAndMessages(null);
        this.t = null;
        this.u.e();
    }

    public void onPause() {
        super.onPause();
        OrientationEventListener orientationEventListener = this.v;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.u.f();
    }

    public void onResume() {
        super.onResume();
        this.u.a(4, 3);
        this.w = -1;
        l0();
        OrientationEventListener orientationEventListener = this.v;
        if (orientationEventListener != null && orientationEventListener.canDetectOrientation()) {
            this.v.enable();
        }
    }

    public /* synthetic */ void a(String str, int i2, String str2) {
        ((s) this.s).a(str, i2, str2);
    }

    public /* synthetic */ void g(e.c.d.m.i.i.k kVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", 7);
        a(SpinDeviceActivity.class, bundle);
        ((s) this.s).g();
        kVar.dismiss();
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        ((s) this.s).a(z2);
    }

    public /* synthetic */ void b(e.c.d.m.i.i.k kVar) {
        ((s) this.s).g();
        kVar.dismiss();
    }

    public void f() {
        if (this.y == null) {
            String string = getString(R.string.camera_no_working);
            String string2 = getString(R.string.try_again_later);
            String string3 = getString(R.string.exit_picture_taking);
            ModelDialog.b bVar = new ModelDialog.b(null);
            bVar.f2067a = string;
            bVar.f2073g = false;
            bVar.f2068b = string2;
            e.c.d.m.e.a.j jVar = new e.c.d.m.e.a.j(this);
            bVar.f2071e = string3;
            bVar.f2075i = jVar;
            ModelDialog modelDialog = new ModelDialog(this, null);
            modelDialog.f2060a = bVar;
            this.y = modelDialog;
        }
        if (!this.y.isShowing()) {
            this.y.show();
        }
    }

    public void a(List<e.c.d.m.i.g.d.a> list, int i2) {
        c cVar = new c(list);
        this.x = cVar;
        ((n) this.r).q.setAdapter(cVar);
        ((n) this.r).q.scrollToPosition(i2);
        ((n) this.r).q.setItemTransitionTimeMillis(150);
        DiscreteScrollView discreteScrollView = ((n) this.r).q;
        discreteScrollView.f3981c.add(new e.c.d.m.e.a.n(this));
    }

    public void d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("task_id", str);
        a(SpinPreviewActivity.class, bundle);
    }

    public void i(boolean z2) {
        ((n) this.r).tv4.setEnabled(z2);
        ((n) this.r).B.setEnabled(z2);
    }

    public /* synthetic */ void d(e.c.d.m.i.i.k kVar) {
        ((s) this.s).g();
        kVar.dismiss();
    }

    public /* synthetic */ void a(d0 d0Var, int i2) {
        P p = this.s;
        if (p != null) {
            ((s) p).f(i2);
        }
    }

    public void a(String str) {
        try {
            this.u.a(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            e2.getMessage();
            f();
        }
    }

    public void a() {
        finish();
        overridePendingTransition(R.anim.activity_silent_anim, R.anim.activity_up_to_bottom_anim);
    }

    public /* synthetic */ void e(e.c.d.m.i.i.k kVar) {
        ((s) this.s).g();
        kVar.dismiss();
    }

    public /* synthetic */ void a(e.c.d.m.i.i.k kVar) {
        ((s) this.s).g();
        kVar.dismiss();
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void setCircleProgressBar(int i2, int i3) {
        String format = String.format("/%d", new Object[]{Integer.valueOf(i3)});
        ((n) this.r).tv1.setText(String.valueOf(i2));
        ((n) this.r).tv2.setText(format);
        ((n) this.r).mCircleProgressBar.a((int) ((((float) i2) * 360.0f) / ((float) i3)), "");
    }

    public void a(boolean z2) {
        ((n) this.r).x.setVisibility(z2 ? 0 : 4);
        if (z2) {
            B b2 = this.r;
            ((n) b2).x.setLayoutParams(((n) b2).x.getLayoutParams());
        }
    }
}
