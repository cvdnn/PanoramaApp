package com.baidu.sapi2.views;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.sapi2.SapiAccountManager;
import e.c.c.a.b;
import e.c.c.a.e;
import e.c.c.a.f;

/* compiled from: SweepLightLoadingView */
public class p extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    public View f3225a;

    /* renamed from: b reason: collision with root package name */
    public ObjectAnimator f3226b;

    /* renamed from: c reason: collision with root package name */
    public View f3227c;

    /* renamed from: d reason: collision with root package name */
    public LinearLayout f3228d = ((LinearLayout) this.f3225a.findViewById(e.sapi_sdk_sweep_light_loading_bg_layout));

    public p(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(f.layout_sapi_sdk_sweep_light_loading_view, this, true);
        this.f3225a = inflate;
        this.f3227c = inflate.findViewById(e.sweep_iv);
        if (SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            this.f3228d.setBackgroundColor(getResources().getColor(b.sapi_sdk_dark_mode_color));
        }
    }

    @TargetApi(11)
    private void a() {
        b();
        new ObjectAnimator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3227c, "translationX", new float[]{-300.0f, 300.0f});
        this.f3226b = ofFloat;
        ofFloat.setDuration(1000);
        this.f3226b.setRepeatMode(1);
        this.f3226b.setRepeatCount(Integer.MAX_VALUE);
        this.f3226b.start();
    }

    @TargetApi(11)
    private void b() {
        ObjectAnimator objectAnimator = this.f3226b;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f3226b.end();
        }
    }

    public void setVisibility(int i2) {
        if (i2 == 0) {
            a();
        } else {
            b();
        }
        super.setVisibility(i2);
    }
}
