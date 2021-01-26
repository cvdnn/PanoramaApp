package com.baidu.picapture.ui.spin.preview;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.spin.detail.SpinDetailActivity;
import com.baidu.picapture.ui.widget.SpinView;
import com.baidu.picapture.ui.widget.SpinView.a;
import com.baidu.picapture.ui.widget.dialog.InputDialog;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.gyf.immersionbar.ImmersionBar;
import e.c.d.e.v;
import e.c.d.m.a.b;
import e.c.d.m.e.d.c;
import e.c.d.m.e.d.d;
import e.c.d.m.e.d.e;
import e.c.d.m.e.d.f;
import e.c.d.m.e.d.g;
import e.c.d.m.e.d.h;
import e.c.d.m.e.d.i;
import e.c.d.m.i.i.k;
import java.io.File;

public class SpinPreviewActivity extends b<g, v> implements h {
    public InputDialog t;
    public boolean u = false;
    public String v = "";
    public ModelDialog w;
    public boolean x = false;
    public SpinView.b y = new e(this);
    public a z = new c(this);

    public /* synthetic */ void a(float f2) {
        if (f2 <= 1.001f) {
            ((v) this.r).s.setVisibility(4);
        } else {
            ((v) this.r).s.setVisibility(0);
        }
        if (Math.abs(f2 - 1.0f) >= 0.1f) {
            i0();
        }
    }

    public /* synthetic */ void b(k kVar) {
        this.x = false;
        kVar.dismiss();
        finish();
    }

    public /* synthetic */ void c(k kVar) {
        this.u = false;
        kVar.dismiss();
    }

    public d.w.a f0() {
        return v.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((g) this.s).a(getIntent().getStringExtra("task_id"));
        SpinView spinView = ((v) this.r).t;
        SpinView.b bVar = this.y;
        if (!spinView.f2008c.contains(bVar)) {
            spinView.f2008c.registerObserver(bVar);
        }
        SpinView spinView2 = ((v) this.r).t;
        a aVar = this.z;
        if (!spinView2.f2009d.contains(aVar)) {
            spinView2.f2009d.registerObserver(aVar);
        }
        String string = getString(R.string.add_picture_name);
        String string2 = getString(R.string.enter_picture_name);
        String string3 = getString(R.string.yes);
        String string4 = getString(R.string.no);
        InputDialog.b bVar2 = new InputDialog.b(null);
        bVar2.f2037a = string;
        bVar2.f2043g = 20;
        bVar2.f2042f = false;
        bVar2.f2038b = string2;
        e.c.d.m.e.d.b bVar3 = new e.c.d.m.e.d.b(this);
        bVar2.f2040d = string4;
        bVar2.f2044h = bVar3;
        d dVar = new d(this);
        bVar2.f2041e = string3;
        bVar2.f2045i = dVar;
        InputDialog inputDialog = new InputDialog(this, null);
        inputDialog.f2027a = bVar2;
        this.t = inputDialog;
        String string5 = getString(R.string.taking_again);
        String string6 = getString(R.string.if_retaking);
        String string7 = getString(R.string.yes);
        String string8 = getString(R.string.cancel);
        ModelDialog.b bVar4 = new ModelDialog.b(null);
        bVar4.f2067a = string5;
        bVar4.f2073g = false;
        bVar4.f2068b = string6;
        e.c.d.m.e.d.a aVar2 = new e.c.d.m.e.d.a(this);
        bVar4.f2069c = string8;
        bVar4.f2074h = aVar2;
        f fVar = new f(this);
        bVar4.f2071e = string7;
        bVar4.f2075i = fVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar4;
        this.w = modelDialog;
        ((v) this.r).a(this);
    }

    public e.c.d.m.a.d h0() {
        return new i(this);
    }

    public final void i0() {
        if (((v) this.r).r.getVisibility() != 8) {
            ((v) this.r).r.setVisibility(8);
            ((g) this.s).n();
        }
    }

    public void j(boolean z2) {
        ((v) this.r).r.setVisibility(z2 ? 0 : 8);
    }

    public final void j0() {
        this.x = true;
        this.w.show();
    }

    public /* synthetic */ void m(int i2) {
        i0();
    }

    public void onBackPressed() {
        j0();
    }

    public void onDestroy() {
        super.onDestroy();
        SpinView spinView = ((v) this.r).t;
        SpinView.b bVar = this.y;
        if (spinView.f2008c.contains(bVar)) {
            spinView.f2008c.unregisterObserver(bVar);
        }
        SpinView spinView2 = ((v) this.r).t;
        a aVar = this.z;
        if (spinView2.f2009d.contains(aVar)) {
            spinView2.f2009d.unregisterObserver(aVar);
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        ((v) this.r).t.f6844a.a(bundle.getFloat("photo_scale"), true);
        boolean z2 = bundle.getBoolean("input_dialog_showing_tag", false);
        this.u = z2;
        if (z2) {
            this.v = bundle.getString("input_dialog_showing_text_tag");
        }
        this.x = bundle.getBoolean("confirm_dialog_showing_tag", false);
    }

    public void onResume() {
        super.onResume();
        if (this.u) {
            c(this.v);
        } else if (this.x) {
            j0();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        String str;
        super.onSaveInstanceState(bundle);
        bundle.putFloat("photo_scale", ((v) this.r).t.getScale());
        bundle.putBoolean("input_dialog_showing_tag", this.u);
        if (this.u) {
            InputDialog inputDialog = this.t;
            if (inputDialog.f2029c.getText() == null) {
                str = "";
            } else {
                str = inputDialog.f2029c.getText().toString().trim();
            }
            bundle.putString("input_dialog_showing_text_tag", str);
        }
        bundle.putBoolean("confirm_dialog_showing_tag", this.x);
    }

    public void c(String str) {
        this.u = true;
        InputDialog inputDialog = this.t;
        inputDialog.f2027a.f2039c = str;
        inputDialog.f2034h.postDelayed(inputDialog.f2035i, 200);
        inputDialog.show();
    }

    public void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("task_id", str);
        bundle.putString("task_name", str2);
        a(SpinDetailActivity.class, bundle);
    }

    public /* synthetic */ void a(k kVar, String str) {
        this.u = false;
        ((g) this.s).b(str);
        kVar.dismiss();
    }

    public /* synthetic */ void a(k kVar) {
        this.x = false;
        kVar.dismiss();
    }

    public void a(File[] fileArr) {
        ((v) this.r).t.setImages(fileArr);
    }
}
