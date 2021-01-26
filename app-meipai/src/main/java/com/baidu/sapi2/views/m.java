package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import e.c.c.a.f;
import e.c.c.a.h;

/* compiled from: SpeechLoadingDialog */
public class m extends Dialog {
    public m(Context context) {
        super(context, h.sapi_sdk_total_transparency_dialog);
        setContentView(f.layout_sapi_sdk_dialog_loading_gray);
        setCancelable(false);
    }
}
