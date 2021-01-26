package com.baidu.picapture.ui.hotspot.capture;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.picapture.R;
import com.baidu.picapture.ui.home.HomeActivity;
import com.baidu.picapture.ui.hotspot.preview.HotSpotPreviewActivity;
import com.baidu.picapture.ui.hotspot.simplepreview.HotSpotSimplePreviewActivity;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.gyf.immersionbar.ImmersionBar;
import e.c.b.e.Utils;
import e.c.d.i.b.g;
import e.c.d.i.b.j;
import e.c.d.m.a.b;
import e.c.d.m.a.d;
import e.c.d.m.c.a.a;
import e.c.d.m.c.a.c;
import e.c.d.m.c.a.e;
import e.c.d.m.c.a.f;
import e.c.d.m.i.i.k;

public class HotSpotCaptureActivity extends b<e, e.c.d.e.e> implements f {
    public j t;
    public ModelDialog u;
    public ModelDialog v;
    public j.b w = new a(this);

    public /* synthetic */ void a(String str, int i2, String str2) {
        ((e) this.s).a(str, i2, str2);
    }

    public /* synthetic */ void b(k kVar) {
        i0();
        kVar.dismiss();
    }

    public void c() {
        finish();
    }

    public void e() {
        if (this.v == null) {
            String string = getString(R.string.memory_full);
            String string2 = getString(R.string.free_up_space);
            String string3 = getString(R.string.exit_picture_taking);
            ModelDialog.b bVar = new ModelDialog.b(null);
            bVar.f2067a = string;
            bVar.f2073g = false;
            bVar.f2068b = string2;
            e.c.d.m.c.a.b bVar2 = new e.c.d.m.c.a.b(this);
            bVar.f2071e = string3;
            bVar.f2075i = bVar2;
            ModelDialog modelDialog = new ModelDialog(this, null);
            modelDialog.f2060a = bVar;
            this.v = modelDialog;
        }
        if (!this.v.isShowing()) {
            this.v.show();
        }
    }

    public void f() {
        if (this.u == null) {
            String string = getString(R.string.camera_no_working);
            String string2 = getString(R.string.try_again_later);
            String string3 = getString(R.string.exit_picture_taking);
            ModelDialog.b bVar = new ModelDialog.b(null);
            bVar.f2067a = string;
            bVar.f2073g = false;
            bVar.f2068b = string2;
            c cVar = new c(this);
            bVar.f2071e = string3;
            bVar.f2075i = cVar;
            ModelDialog modelDialog = new ModelDialog(this, null);
            modelDialog.f2060a = bVar;
            this.u = modelDialog;
        }
        if (!this.u.isShowing()) {
            this.u.show();
        }
    }

    public d.w.a f0() {
        return e.c.d.e.e.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.black).init();
        getWindow().addFlags(128);
        ((e.c.d.e.e) this.r).a(this);
        ((e) this.s).a(getIntent().getIntExtra("from", 1), getIntent().getStringExtra("picture_path"), getIntent().getStringExtra("task_id"));
        j a2 = Utils.a(e.c.d.i.b.k.CAMERA1, ((e.c.d.e.e) this.r).q);
        this.t = a2;
        ((g) a2).f6162e = this.w;
    }

    public d h0() {
        return new e.c.d.m.c.a.g(this);
    }

    public void i0() {
        ((e) this.s).a();
    }

    public void k(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("picture_path", str);
        a(HotSpotSimplePreviewActivity.class, bundle);
    }

    public void onBackPressed() {
    }

    public void onDestroy() {
        super.onDestroy();
        this.t.e();
    }

    public void onPause() {
        super.onPause();
        this.t.f();
    }

    public void onResume() {
        super.onResume();
        this.t.a(4, 3);
        this.t.a(getWindowManager().getDefaultDisplay().getRotation());
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        ConstraintLayout.a aVar = (ConstraintLayout.a) ((e.c.d.e.e) this.r).q.getLayoutParams();
        aVar.height = (point.x * 4) / 3;
        ((e.c.d.e.e) this.r).q.setLayoutParams(aVar);
        LayoutParams layoutParams = ((e.c.d.e.e) this.r).t.getLayoutParams();
        LayoutParams layoutParams2 = ((e.c.d.e.e) this.r).o.getLayoutParams();
        int i2 = (aVar.height - point.x) / 2;
        layoutParams.height = i2;
        layoutParams2.height = i2;
        ((e.c.d.e.e) this.r).t.setLayoutParams(layoutParams);
        ((e.c.d.e.e) this.r).o.setLayoutParams(layoutParams2);
        ((e.c.d.e.e) this.r).b(Boolean.valueOf(false));
    }

    public void a() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("from", 4);
        startActivity(intent);
    }

    public void a(String str) {
        try {
            this.t.a(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            f();
        }
    }

    public void a(String str, String str2) {
        Intent intent = new Intent(getApplicationContext(), HotSpotPreviewActivity.class);
        intent.putExtra("from", 2);
        intent.putExtra("task_id", str);
        intent.putExtra("picture_path", str2);
        startActivity(intent);
    }

    public /* synthetic */ void a(k kVar) {
        i0();
        kVar.dismiss();
    }
}
