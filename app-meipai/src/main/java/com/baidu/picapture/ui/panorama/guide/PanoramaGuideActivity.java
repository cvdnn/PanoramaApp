package com.baidu.picapture.ui.panorama.guide;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.picapture.R;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.picapture.ui.panorama.capture.PanoramaCaptureActivity;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.gyf.immersionbar.ImmersionBar;
import e.c.d.e.i;
import e.c.d.m.a.b;
import e.c.d.m.a.d;
import e.c.d.m.d.b.e;
import e.c.d.m.d.b.h;
import e.c.d.m.i.i.k;
import e.l.a.g;
import e.l.a.l.a;
import e.l.a.l.c;
import java.util.ArrayList;
import java.util.List;

public class PanoramaGuideActivity extends b<h, i> implements e.c.d.m.d.b.i {
    public static /* synthetic */ void a(g gVar, k kVar) {
        ((a) gVar).a();
        kVar.dismiss();
    }

    public static /* synthetic */ void b(g gVar, k kVar) {
        ((a) gVar).b();
        kVar.dismiss();
    }

    public d.w.a f0() {
        return i.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((i) this.r).a(this);
        ArrayList arrayList = new ArrayList();
        if (LanguageUtils.isChineseLanguage()) {
            arrayList.add(Integer.valueOf(R.mipmap.pano_guide_1));
            arrayList.add(Integer.valueOf(R.mipmap.pano_guide_2));
            arrayList.add(Integer.valueOf(R.mipmap.pano_guide_3));
        } else {
            arrayList.add(Integer.valueOf(R.mipmap.pano_guide_1_en));
            arrayList.add(Integer.valueOf(R.mipmap.pano_guide_2_en));
            arrayList.add(Integer.valueOf(R.mipmap.pano_guide_3_en));
        }
        ((i) this.r).n.setAdapter(new e.c.d.m.d.b.l.a(arrayList));
        i iVar = (i) this.r;
        iVar.n.setIndicator(iVar.q, false);
        ((i) this.r).p.q.setText(getResources().getText(R.string.device_header));
        ((i) this.r).p.n.setOnClickListener(new e.c.d.m.d.b.a(this));
    }

    public /* synthetic */ void h(List list) {
        a(PanoramaCaptureActivity.class, null);
        finish();
    }

    public d h0() {
        return new e.c.d.m.d.b.k(this);
    }

    public void onBackPressed() {
    }

    public void q() {
        String str = "android.permission.READ_EXTERNAL_STORAGE";
        String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (e.l.a.b.a((Activity) this, str2, str)) {
            a(PanoramaCaptureActivity.class, null);
            finish();
            return;
        }
        String string = getString(R.string.reminder);
        String string2 = getString(R.string.allow);
        String string3 = getString(R.string.cancel);
        String string4 = getString(R.string.access_file_taking_tips);
        c a2 = ((e.l.a.l.d) ((e.l.a.c) e.l.a.b.a((Activity) this)).a()).a(str2, str);
        e.c.d.m.d.b.d dVar = new e.c.d.m.d.b.d(this, string, string4, string2, string3);
        a aVar = (a) a2;
        aVar.f8964c = dVar;
        aVar.f8965d = new e.c.d.m.d.b.c(this);
        aVar.c();
    }

    public /* synthetic */ void a(View view) {
        finish();
        overridePendingTransition(R.anim.activity_silent_anim, R.anim.activity_up_to_bottom_anim);
    }

    public /* synthetic */ void a(String str, String str2, String str3, String str4, Context context, List list, g gVar) {
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        e eVar = new e(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = eVar;
        e.c.d.m.d.b.b bVar2 = new e.c.d.m.d.b.b(gVar);
        bVar.f2069c = str4;
        bVar.f2074h = bVar2;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }
}
