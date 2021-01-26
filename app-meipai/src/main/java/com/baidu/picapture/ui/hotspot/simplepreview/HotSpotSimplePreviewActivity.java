package com.baidu.picapture.ui.hotspot.simplepreview;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.baidu.picapture.ui.home.HomeActivity;
import e.c.b.e.Utils;
import e.c.d.e.c;
import e.c.d.m.a.b;
import e.d.a.n.f;
import e.d.a.n.n.r;
import e.d.a.r.d;
import e.d.a.r.h.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class HotSpotSimplePreviewActivity extends b<e.c.d.m.c.c.b, c> implements e.c.d.m.c.c.c {

    public class a implements d<Drawable> {
        public a() {
        }

        public boolean a(r rVar, Object obj, h<Drawable> hVar, boolean z) {
            return false;
        }

        public boolean a(Object obj, Object obj2, h hVar, e.d.a.n.a aVar, boolean z) {
            Drawable drawable = (Drawable) obj;
            ((e.c.d.m.c.c.b) HotSpotSimplePreviewActivity.this.s).f();
            return false;
        }
    }

    public void b(String str) {
        Utils.a(str, 0);
    }

    public void f(String str) {
        Utils.a(getApplicationContext(), Collections.singletonList(str));
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("from", 4);
        intent.putExtra("picture_path", str);
        startActivity(intent);
    }

    public d.w.a f0() {
        return c.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ((c) this.r).a(this);
        ((e.c.d.m.c.c.b) this.s).a(getIntent().getStringExtra("picture_path"));
        WindowManager windowManager = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        LayoutParams layoutParams = ((c) this.r).o.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i2;
        ((c) this.r).o.setLayoutParams(layoutParams);
    }

    public e.c.d.m.a.d h0() {
        return new e.c.d.m.c.c.d(this);
    }

    public void a(File file) {
        e.d.a.i iVar = (e.d.a.i) e.d.a.b.a((d.n.a.d) this).a(file).a((f) new e.d.a.s.b(Long.valueOf(file.lastModified())));
        a aVar = new a();
        iVar.G = null;
        ArrayList arrayList = new ArrayList();
        iVar.G = arrayList;
        arrayList.add(aVar);
        iVar.a(((c) this.r).o);
    }
}
