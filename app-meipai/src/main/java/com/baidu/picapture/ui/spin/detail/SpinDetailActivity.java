package com.baidu.picapture.ui.spin.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import com.baidu.picapture.R;
import com.baidu.picapture.model.hotspot.HotSpot;
import com.baidu.picapture.ui.home.HomeActivity;
import com.baidu.picapture.ui.hotspot.capture.HotSpotCaptureActivity;
import com.baidu.picapture.ui.hotspot.preview.HotSpotPreviewActivity;
import com.baidu.picapture.ui.spin.capture.SpinCaptureActivity;
import com.baidu.picapture.ui.spinphoto.SpinPhotoActivity;
import com.baidu.picapture.ui.widget.dialog.Model1Dialog;
import com.gyf.immersionbar.ImmersionBar;
import com.youth.banner.config.BannerConfig;
import d.n.a.d;
import e.c.b.e.Utils;
import e.c.d.e.y;
import e.c.d.m.a.b;
import e.c.d.m.e.b.c;
import e.c.d.m.e.b.o;
import e.c.d.m.e.b.p;
import e.c.d.m.e.b.q;
import e.c.d.m.e.b.t.a;
import e.c.d.m.i.i.k;
import e.d.a.i;
import e.d.a.n.p.c.l;
import java.io.File;
import java.util.List;

public class SpinDetailActivity extends b<o, y> implements p {
    public a t;

    public void E() {
        ((y) this.r).p.setText(R.string.spin_task_detail_creating_content);
    }

    public void V() {
        y yVar = (y) this.r;
        Boolean valueOf = Boolean.valueOf(true);
        yVar.b(valueOf);
        ((y) this.r).e(valueOf);
        ((y) this.r).p.setText(R.string.spin_task_detail_uploading);
        k(0);
    }

    public void Y() {
        ((y) this.r).e(Boolean.valueOf(false));
        ((y) this.r).c(Boolean.valueOf(true));
        ((y) this.r).p.setText(R.string.spin_task_detail_upload_failed);
    }

    public /* synthetic */ void a(View view) {
        ((o) this.s).y();
    }

    public void b(File file) {
        ((i) e.d.a.b.a((d) this).a(file).b(l.f7687c, (e.d.a.n.l<Bitmap>) new e.d.a.n.p.c.i<Bitmap>())).a(((y) this.r).o);
    }

    public void d(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("task_id", str);
        a(SpinPhotoActivity.class, bundle);
    }

    public void f(int i2) {
        ((y) this.r).d(Boolean.valueOf(false));
        ((y) this.r).c(Boolean.valueOf(true));
        ((y) this.r).p.setText(R.string.spin_task_detail_creating_content_failed);
        if (i2 == 2) {
            Model1Dialog.b bVar = new Model1Dialog.b(null);
            bVar.f2057f = false;
            bVar.f2052a = getString(R.string.create_content_reason_no_enough_storage);
            String string = getString(R.string.i_know);
            e.c.d.m.e.b.b bVar2 = new e.c.d.m.e.b.b(this);
            bVar.f2055d = string;
            bVar.f2059h = bVar2;
            Model1Dialog model1Dialog = new Model1Dialog(this, null);
            model1Dialog.f2046a = bVar;
            model1Dialog.show();
        }
    }

    public d.w.a f0() {
        return y.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((y) this.r).a(this);
        y yVar = (y) this.r;
        Boolean valueOf = Boolean.valueOf(false);
        yVar.b(valueOf);
        ((y) this.r).e(valueOf);
        ((y) this.r).d(valueOf);
        ((y) this.r).c(valueOf);
        String stringExtra = getIntent().getStringExtra("task_id");
        String stringExtra2 = getIntent().getStringExtra("task_name");
        ((y) this.r).r.q.setText(stringExtra2);
        ((o) this.s).a(stringExtra, stringExtra2);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        LayoutParams layoutParams = ((y) this.r).t.getLayoutParams();
        layoutParams.height = point.x;
        ((y) this.r).t.setLayoutParams(layoutParams);
        ((y) this.r).r.n.setOnClickListener(new c(this));
    }

    public e.c.d.m.a.d h0() {
        return new q(this);
    }

    public void k(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append("%");
        ((y) this.r).u.a((i2 * 360) / 100, sb.toString());
    }

    public void m() {
        ((y) this.r).d(Boolean.valueOf(false));
        ((y) this.r).c(Boolean.valueOf(true));
        ((y) this.r).p.setText(R.string.spin_task_detail_process_failed);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onBackPressed() {
    }

    public void t() {
        ((y) this.r).e(Boolean.valueOf(false));
        ((y) this.r).d(Boolean.valueOf(true));
        ((y) this.r).p.setText(R.string.spin_task_detail_processing);
    }

    public void a(List<HotSpot> list, String str) {
        a aVar = new a(this, list, str);
        this.t = aVar;
        ((y) this.r).q.setAdapter(aVar);
        ((y) this.r).q.setOnItemClickListener(new e.c.d.m.e.b.a(this));
    }

    public void d() {
        a(SpinCaptureActivity.class, null);
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i2, long j2) {
        ((o) this.s).d(i2);
    }

    public void a() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    @SuppressLint({"WrongConstant", "ShowToast"})
    public void b(String str) {
        Utils.a(str, (int) BannerConfig.LOOP_TIME);
    }

    public void d(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", 1);
        bundle.putString("task_id", str);
        bundle.putString("picture_path", str2);
        a(HotSpotCaptureActivity.class, bundle);
    }

    public void a(String str, String str2, HotSpot hotSpot) {
        Intent intent = new Intent(getApplicationContext(), HotSpotPreviewActivity.class);
        intent.putExtra("from", 1);
        intent.putExtra("picture_path", str);
        if (hotSpot != null) {
            intent.putExtra("hotspot", hotSpot);
        }
        intent.putExtra("task_id", str2);
        startActivity(intent);
    }

    public /* synthetic */ void a(k kVar) {
        ((o) this.s).g();
        kVar.dismiss();
    }
}
