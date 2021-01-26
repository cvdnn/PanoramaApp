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

public class AddressManageExternalActivity extends AddressManageActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String K = "AddressManageExternalActivity";
    public String L;

    /* access modifiers changed from: private */
    public void j() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    public void finishActivity() {
        super.finish();
    }

    public void loadAddressUrl(List<PassNameValuePair> list) {
        String stringExtra = getIntent().getStringExtra("extra_external_url");
        this.L = stringExtra;
        this.sapiWebView.loadUrl(stringExtra);
    }

    public void onBottomBackBtnClick() {
        j();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(K, "AddressManageExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                AddressManageExternalActivity.this.j();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                AddressManageExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new OnSlidePageFinishCallback() {
            public void onFinish(String str) {
                if (SlideActiviy.ADDRESS_PAGE_NAME.equals(str)) {
                    Intent intent = new Intent(AddressManageExternalActivity.this, AddressManageActivity.class);
                    intent.setFlags(67108864);
                    AddressManageExternalActivity.this.startActivity(intent);
                }
            }
        });
    }

    public void onLeftBtnClick() {
        j();
    }
}
