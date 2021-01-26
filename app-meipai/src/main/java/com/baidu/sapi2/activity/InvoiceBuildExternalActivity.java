package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import java.util.List;

public class InvoiceBuildExternalActivity extends InvoiceBuildActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String G = "InvoiceBuildExternalActivity";
    public String H;

    /* access modifiers changed from: private */
    public void h() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    public void finishActivity() {
        super.finish();
    }

    public void loadInvoiceUrl(List<PassNameValuePair> list) {
        String stringExtra = getIntent().getStringExtra("extra_external_url");
        this.H = stringExtra;
        this.sapiWebView.loadUrl(stringExtra);
    }

    public void onBottomBackBtnClick() {
        h();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(G, "InvoiceBuildExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                InvoiceBuildExternalActivity.this.h();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                InvoiceBuildExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new OnSlidePageFinishCallback() {
            public void onFinish(String str) {
                if (SlideActiviy.INVOICE_PAGE_NAME.equals(str)) {
                    Intent intent = new Intent(InvoiceBuildExternalActivity.this, InvoiceBuildActivity.class);
                    intent.setFlags(67108864);
                    InvoiceBuildExternalActivity.this.startActivity(intent);
                }
            }
        });
    }

    public void onLeftBtnClick() {
        h();
    }
}
