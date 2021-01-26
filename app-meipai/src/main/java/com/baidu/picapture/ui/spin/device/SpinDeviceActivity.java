package com.baidu.picapture.ui.spin.device;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;
import com.baidu.picapture.R;
import com.baidu.picapture.model.device.DeviceInfo;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.picapture.ui.spin.capture.SpinCaptureActivity;
import com.baidu.picapture.ui.webview.WebViewActivity;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.baidu.sapi2.utils.i;
import com.gyf.immersionbar.ImmersionBar;
import d.w.a;
import e.c.b.e.Utils;
import e.c.d.e.q;
import e.c.d.m.a.b;
import e.c.d.m.a.d;
import e.c.d.m.e.c.c;
import e.c.d.m.e.c.f;
import e.c.d.m.e.c.h;
import e.c.d.m.e.c.p;
import e.c.d.m.e.c.r;
import e.c.d.m.i.i.k;
import e.c.d.n.e;
import e.l.a.g;
import java.util.ArrayList;
import java.util.List;

public class SpinDeviceActivity extends b<p, q> implements e.c.d.m.e.c.q {
    public List<DeviceInfo> t = new ArrayList();
    public e.c.d.m.e.c.s.b<DeviceInfo> u;

    public void C() {
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(17, 0, 0);
        toast.setView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.device_connect_error_toast, null));
        toast.show();
    }

    public void H() {
        String string = getString(R.string.user_guide);
        Bundle bundle = new Bundle();
        bundle.putString("title", string);
        bundle.putString("URL", e.e());
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, i.f3089d);
    }

    public void W() {
        ((q) this.r).u.setVisibility(8);
        ((q) this.r).x.setVisibility(8);
        ((q) this.r).w.setVisibility(8);
        ((q) this.r).r.setVisibility(0);
        ((q) this.r).u.setEnabled(false);
    }

    public /* synthetic */ void a(View view, DeviceInfo deviceInfo) {
        ((p) this.s).a(deviceInfo);
    }

    public void b(List<DeviceInfo> list) {
        this.t.clear();
        this.t.addAll(list);
        ((q) this.r).p.setAdapter(this.u);
        this.u.notifyDataSetChanged();
    }

    public void f(boolean z) {
        ((q) this.r).u.setEnabled(true);
        ((q) this.r).q.setVisibility(4);
        if (!z) {
            ((q) this.r).u.setVisibility(8);
            ((q) this.r).x.setVisibility(8);
            ((q) this.r).r.setVisibility(8);
            ((q) this.r).w.setVisibility(0);
            LayoutParams layoutParams = ((q) this.r).y.getLayoutParams();
            if (!LanguageUtils.isChineseLanguage()) {
                ((q) this.r).y.setImageResource(R.mipmap.no_search_device_us);
                layoutParams.height = Utils.b(328.0f);
            } else {
                ((q) this.r).y.setImageResource(R.mipmap.no_search_device);
                layoutParams.height = Utils.b(244.0f);
            }
            ((q) this.r).y.setLayoutParams(layoutParams);
        }
    }

    public a f0() {
        return q.a(getLayoutInflater());
    }

    public void g(String str) {
        String string = getString(R.string.disconnect);
        String string2 = getString(R.string.yes);
        String string3 = getString(R.string.no);
        String string4 = getString(R.string.spin_disconnect_tips);
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = string;
        bVar.f2073g = false;
        bVar.f2068b = string4;
        e.c.d.m.e.c.a aVar = e.c.d.m.e.c.a.f6735a;
        bVar.f2069c = string3;
        bVar.f2074h = aVar;
        c cVar = new c(this, str);
        bVar.f2071e = string2;
        bVar.f2075i = cVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((q) this.r).a(this);
        e.c.d.m.e.c.s.b<DeviceInfo> bVar = new e.c.d.m.e.c.s.b<>(this.t, getBaseContext());
        this.u = bVar;
        ((q) this.r).p.setAdapter(bVar);
        this.u.f6771c = new e.c.d.m.e.c.b(this);
        ((q) this.r).t.q.setText(getResources().getText(R.string.device_header));
        ((q) this.r).t.n.setOnClickListener(new f(this));
        ((p) this.s).c(getIntent().getIntExtra("from", 1));
    }

    public /* synthetic */ void h(List list) {
        a(SpinCaptureActivity.class, null);
        finish();
    }

    public d h0() {
        return new r(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10004) {
            ((p) this.s).E();
        }
    }

    public void v() {
        ((q) this.r).u.setVisibility(0);
        ((q) this.r).x.setVisibility(0);
        ((q) this.r).w.setVisibility(8);
        ((q) this.r).r.setVisibility(8);
        ((q) this.r).q.setVisibility(0);
    }

    public /* synthetic */ void a(View view) {
        finish();
    }

    public /* synthetic */ void a(String str, String str2, String str3, String str4, Context context, List list, g gVar) {
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        h hVar = new h(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = hVar;
        e.c.d.m.e.c.e eVar = new e.c.d.m.e.c.e(gVar);
        bVar.f2069c = str4;
        bVar.f2074h = eVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public void b() {
        String str = "android.permission.WRITE_EXTERNAL_STORAGE";
        String str2 = "android.permission.CAMERA";
        if (e.l.a.b.a((Activity) this, str2, str)) {
            a(SpinCaptureActivity.class, null);
            finish();
            return;
        }
        String string = getString(R.string.reminder);
        String string2 = getString(R.string.yes);
        String string3 = getString(R.string.no);
        String string4 = getString(R.string.access_cameras_tips);
        e.l.a.l.c a2 = ((e.l.a.l.d) ((e.l.a.c) e.l.a.b.a((Activity) this)).a()).a(str2, str);
        e.c.d.m.e.c.g gVar = new e.c.d.m.e.c.g(this, string, string4, string2, string3);
        e.l.a.l.a aVar = (e.l.a.l.a) a2;
        aVar.f8964c = gVar;
        aVar.f8965d = new e.c.d.m.e.c.d(this);
        aVar.c();
    }

    public /* synthetic */ void a(String str, k kVar) {
        ((p) this.s).d(str);
        kVar.dismiss();
    }

    public static /* synthetic */ void a(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).a();
        kVar.dismiss();
    }

    public void g() {
        startActivity(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
    }

    public static /* synthetic */ void b(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).b();
        kVar.dismiss();
    }
}
