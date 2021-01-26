package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.baidu.sapi2.utils.SapiUtils;
import e.c.c.a.e;
import e.c.c.a.f;
import e.c.c.a.h;

/* compiled from: SpeechRecognitionDialog */
public class o extends Dialog {

    /* renamed from: a reason: collision with root package name */
    public Context f3223a;

    /* renamed from: b reason: collision with root package name */
    public RippleSurfaceView f3224b;

    public o(Context context) {
        super(context, h.sapi_sdk_speech_dialog);
        this.f3223a = context;
    }

    public void a(int i2) {
        this.f3224b.setAmplitude(i2);
    }

    @TargetApi(3)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(h.sapi_sdk_anim_speech);
        setContentView(f.layout_sapi_sdk_dialog_speech_recognition);
        Display defaultDisplay = ((Activity) this.f3223a).getWindowManager().getDefaultDisplay();
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (defaultDisplay.getWidth() * 91) / 100;
        attributes.height = (defaultDisplay.getHeight() * 3) / 10;
        attributes.y = SapiUtils.dip2px(getContext(), 17.0f);
        getWindow().setAttributes(attributes);
        this.f3224b = (RippleSurfaceView) findViewById(e.ripple_view);
        findViewById(e.stop_speech_tx).setOnClickListener(new n(this));
    }
}
