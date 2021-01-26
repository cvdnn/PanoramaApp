package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnBackCallback;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.SocialType;
import e.c.c.a.f;
import java.util.ArrayList;

public class NormalizeGuestAccountActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public NormalizeGuestAccountResult r = new NormalizeGuestAccountResult() {
        public void finishActivity() {
            super.finishActivity();
            NormalizeGuestAccountActivity.this.finish();
            PassportSDK.getInstance().release();
        }
    };
    public String s;
    public SocialType t;

    /* access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.goBack();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        if (PassportSDK.getInstance().getNormalizeGuestAccountCallback() != null) {
            PassportSDK.getInstance().getNormalizeGuestAccountCallback().onFailure(this.r);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* access modifiers changed from: private */
    public void g() {
        if (PassportSDK.getInstance().getNormalizeGuestAccountCallback() != null) {
            PassportSDK.getInstance().getNormalizeGuestAccountCallback().onSuccess(this.r);
        }
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = PassportSDK.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null && normalizeGuestAccountDTO.finishActivityAfterSuc) {
            finish();
            PassportSDK.getInstance().release();
        }
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getNormalizeGuestAccountDTO();
    }

    public void init() {
        super.init();
        this.r.activity = this;
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    public void onClose() {
        super.onClose();
        this.r.setResultCode(-301);
        this.r.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        f();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            this.s = getIntent().getStringExtra("EXTRA_BDUSS");
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(this.s);
            if (TextUtils.isEmpty(this.s) || accountFromBduss == null) {
                this.r.setResultCode(-204);
                this.r.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                f();
                return;
            }
            this.t = accountFromBduss.getSocialType();
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.r.setResultCode(-202);
            this.r.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            f();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            e();
        }
    }

    public void setupViews() {
        String str;
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnBackCallback(new OnBackCallback() {
            public void onBack() {
                NormalizeGuestAccountActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                NormalizeGuestAccountActivity.this.onClose();
            }
        });
        ArrayList arrayList = new ArrayList();
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = PassportSDK.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null) {
            if (WebLoginDTO.statExtraValid(normalizeGuestAccountDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(normalizeGuestAccountDTO.statExtra)));
            }
            str = normalizeGuestAccountDTO.description;
        } else {
            str = "";
        }
        this.sapiWebView.setNormalizeGuestAccountCallback(new NormalizeGuestAccountCallback() {
            public void onFailure(int i2, String str) {
                NormalizeGuestAccountActivity.this.r.setResultCode(i2);
                NormalizeGuestAccountActivity.this.r.setResultMsg(str);
                NormalizeGuestAccountActivity.this.f();
            }

            public void onSuccess(boolean z, String str) {
                NormalizeGuestAccountActivity.this.r.isAccountMerge = z;
                NormalizeGuestAccountActivity.this.r.setNormalizeWay(str);
                NormalizeGuestAccountActivity.this.r.setResultCode(0);
                NormalizeGuestAccountActivity.this.r.setResultMsg(SapiResult.RESULT_MSG_SUCCESS);
                NormalizeGuestAccountActivity.this.g();
                new b().a(b.f3028e);
            }
        }, str);
        this.sapiWebView.loadNormalizeGuestAccount(arrayList, this.s, this.t);
    }
}
