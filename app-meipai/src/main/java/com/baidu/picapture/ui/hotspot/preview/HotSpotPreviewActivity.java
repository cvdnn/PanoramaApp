package com.baidu.picapture.ui.hotspot.preview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.baidu.picapture.R;
import com.baidu.picapture.model.hotspot.HotSpot;
import com.baidu.picapture.ui.spin.detail.SpinDetailActivity;
import com.baidubce.auth.NTLMEngineImpl;
import com.gyf.immersionbar.ImmersionBar;
import e.c.b.e.Utils;
import e.c.d.e.b0;
import e.c.d.m.c.b.d;
import e.c.d.m.c.b.e;
import e.c.d.m.c.b.f;
import e.c.d.m.i.i.k;
import e.d.a.n.n.r;
import e.d.a.r.h.h;
import java.io.File;
import java.util.ArrayList;

public class HotSpotPreviewActivity extends e.c.d.m.a.b<d, b0> implements e {
    public int t = 1;

    public class a implements TextWatcher {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ String f1978a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ String f1979b;

        public a(String str, String str2) {
            this.f1978a = str;
            this.f1979b = str2;
        }

        public void afterTextChanged(Editable editable) {
            if (!this.f1978a.equals(((b0) HotSpotPreviewActivity.this.r).q.getText().toString().trim()) || !this.f1979b.equals(((b0) HotSpotPreviewActivity.this.r).p.getText().toString().trim())) {
                ((b0) HotSpotPreviewActivity.this.r).x.setEnabled(true);
            } else {
                ((b0) HotSpotPreviewActivity.this.r).x.setEnabled(false);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements e.d.a.r.d<Drawable> {
        public b() {
        }

        public boolean a(r rVar, Object obj, h<Drawable> hVar, boolean z) {
            return false;
        }

        public boolean a(Object obj, Object obj2, h hVar, e.d.a.n.a aVar, boolean z) {
            Drawable drawable = (Drawable) obj;
            HotSpotPreviewActivity hotSpotPreviewActivity = HotSpotPreviewActivity.this;
            if (hotSpotPreviewActivity.t == 2) {
                ((d) hotSpotPreviewActivity.s).f();
            }
            return false;
        }
    }

    public void N() {
        Intent intent = new Intent(this, SpinDetailActivity.class);
        intent.setFlags(67108864);
        intent.addFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
        startActivity(intent);
    }

    public void b(String str) {
        Utils.a(str, 0);
    }

    public void d() {
        finish();
    }

    public d.w.a f0() {
        return b0.a(getLayoutInflater());
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((b0) this.r).a(this);
        WindowManager windowManager = getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i2 = displayMetrics.widthPixels;
        LayoutParams layoutParams = ((b0) this.r).t.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i2;
        ((b0) this.r).t.setLayoutParams(layoutParams);
        Intent intent = getIntent();
        this.t = intent.getIntExtra("from", 1);
        ((d) this.s).a(intent.getStringExtra("task_id"), intent.getStringExtra("picture_path"));
        ((b0) this.r).b(Boolean.valueOf(this.t == 2));
        if (this.t == 1) {
            HotSpot hotSpot = (HotSpot) intent.getSerializableExtra("hotspot");
            if (hotSpot != null) {
                ((b0) this.r).p.setText(hotSpot.getDescribe());
                ((b0) this.r).q.setText(hotSpot.getTitle());
            }
            ((d) this.s).a(hotSpot);
            ((b0) this.r).x.setEnabled(false);
            a aVar = new a(((b0) this.r).q.getText().toString().trim(), ((b0) this.r).p.getText().toString().trim());
            ((b0) this.r).p.addTextChangedListener(aVar);
            ((b0) this.r).q.addTextChangedListener(aVar);
            B b2 = this.r;
            ((b0) b2).q.setSelection(((b0) b2).q.getText().toString().length());
            B b3 = this.r;
            ((b0) b3).p.setSelection(((b0) b3).p.getText().toString().length());
        }
    }

    public e.c.d.m.a.d h0() {
        return new f(this);
    }

    public void i0() {
        ((d) this.s).b(((b0) this.r).q.getText().toString().trim(), ((b0) this.r).p.getText().toString().trim());
    }

    public void onBackPressed() {
        if (this.t == 2) {
            ((d) this.s).D();
        } else {
            finish();
        }
    }

    public /* synthetic */ void a(k kVar) {
        ((d) this.s).h();
        kVar.dismiss();
    }

    public void a(File file) {
        e.d.a.i iVar = (e.d.a.i) e.d.a.b.a((d.n.a.d) this).a(file).a((e.d.a.n.f) new e.d.a.s.b(Long.valueOf(file.lastModified())));
        b bVar = new b();
        iVar.G = null;
        ArrayList arrayList = new ArrayList();
        iVar.G = arrayList;
        arrayList.add(bVar);
        iVar.a(((b0) this.r).t);
    }
}
