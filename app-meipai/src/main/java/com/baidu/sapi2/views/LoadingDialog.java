package com.baidu.sapi2.views;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.sapi2.NoProguard;
import e.c.c.a.e;
import e.c.c.a.f;
import e.c.c.a.h;

public class LoadingDialog extends Dialog implements NoProguard {

    public static class Builder implements NoProguard {

        /* renamed from: a reason: collision with root package name */
        public Context f3148a;

        /* renamed from: b reason: collision with root package name */
        public String f3149b;

        /* renamed from: c reason: collision with root package name */
        public boolean f3150c = true;

        /* renamed from: d reason: collision with root package name */
        public boolean f3151d = false;

        /* renamed from: e reason: collision with root package name */
        public boolean f3152e = false;

        public Builder(Context context) {
            this.f3148a = context;
        }

        public LoadingDialog createDialog() {
            View inflate = LayoutInflater.from(this.f3148a).inflate(f.layout_sapi_sdk_loading_dialog, null);
            LoadingDialog loadingDialog = new LoadingDialog(this.f3148a, h.sapi_sdk_loading_dialog);
            TextView textView = (TextView) inflate.findViewById(e.tipTextView);
            if (this.f3150c) {
                textView.setText(this.f3149b);
            } else {
                textView.setVisibility(8);
            }
            loadingDialog.setContentView(inflate);
            loadingDialog.setCancelable(this.f3151d);
            loadingDialog.setCanceledOnTouchOutside(this.f3152e);
            return loadingDialog;
        }

        public Builder setCancelOutside(boolean z) {
            this.f3152e = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.f3151d = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.f3149b = str;
            return this;
        }

        public Builder setShowMessage(boolean z) {
            this.f3150c = z;
            return this;
        }
    }

    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
    }
}
