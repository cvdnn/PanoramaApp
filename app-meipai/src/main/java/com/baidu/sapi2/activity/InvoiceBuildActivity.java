package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiJsCallBacks.InvoiceBuildCallback;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.SapiWebView.OnFinishCallback;
import com.baidu.sapi2.SapiWebView.OnNewBackCallback;
import com.baidu.sapi2.dto.InvoiceBuildDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.InvoiceBuildResult;
import com.baidu.sapi2.utils.Log;
import e.a.a.a.a;
import e.c.c.a.d;
import e.c.c.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class InvoiceBuildActivity extends SlideActiviy {
    public static final String A = "InvoiceBuildActivity";
    public static final String B = "select";
    public static final String C = "isCheck";
    public static final String D = "isCheckTag";
    public InvoiceBuildDTO E;
    public InvoiceBuildResult F = new InvoiceBuildResult();

    /* access modifiers changed from: private */
    public void finishActivity() {
        if (PassportSDK.getInstance().getInvoiceBuildCallback() != null) {
            PassportSDK.getInstance().getInvoiceBuildCallback().onFinish(this.F);
        }
        PassportSDK.getInstance().release();
        finish();
    }

    /* access modifiers changed from: private */
    public void g() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            this.F.setResultCode(-301);
            finishActivity();
            return;
        }
        this.sapiWebView.goBack();
    }

    public void configTitle() {
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        switchDarkmode();
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setLeftBtnDrawable(getResources().getDrawable(d.sapi_sdk_btn_back), null, null, null);
        if (this.configuration.showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    public void finishActivityAfterSlideOver() {
        if (A.equals(getClass().getSimpleName())) {
            this.F.setResultCode(-301);
            finishActivity();
            return;
        }
        super.finish();
    }

    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getInvoiceBuildDTO();
    }

    public void init() {
        super.init();
        InvoiceBuildDTO invoiceBuildDTO = PassportSDK.getInstance().getInvoiceBuildDTO();
        this.E = invoiceBuildDTO;
        if (invoiceBuildDTO == null) {
            this.F.setResultCode(-204);
            finishActivity();
        }
    }

    public void loadInvoiceUrl(List<PassNameValuePair> list) {
        this.sapiWebView.loadInvoiceBuild(list);
    }

    public void onBottomBackBtnClick() {
        g();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.F.setResultCode(-202);
        }
    }

    public void onLeftBtnClick() {
        g();
    }

    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnNewBackCallback(new OnNewBackCallback() {
            public boolean onBack() {
                InvoiceBuildActivity.this.g();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new OnFinishCallback() {
            public void onFinish() {
                InvoiceBuildActivity.this.F.setResultCode(-301);
                InvoiceBuildActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setInvoiceBuildCallback(new InvoiceBuildCallback() {
            public void onCallback(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        InvoiceBuildActivity.this.F.map.put(str2, jSONObject.optString(str2));
                    }
                    InvoiceBuildActivity.this.F.setResultCode(0);
                } catch (JSONException e2) {
                    Log.e(e2);
                    InvoiceBuildActivity.this.F.setResultCode(-205);
                }
                InvoiceBuildActivity.this.finishActivity();
            }
        });
        ArrayList arrayList = new ArrayList(1);
        String str = "1";
        a.a(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, str, arrayList);
        InvoiceBuildDTO invoiceBuildDTO = this.E;
        if (invoiceBuildDTO != null) {
            arrayList.add(new PassNameValuePair("select", invoiceBuildDTO.TYPE));
            arrayList.add(new PassNameValuePair("tplse", this.E.tplse));
            arrayList.add(new PassNameValuePair("tplt", this.E.tplt));
            if (this.E.isExamineVAT) {
                a.a(C, str, arrayList);
            }
            if (this.E.showCheckTag) {
                a.a(D, str, arrayList);
            }
        }
        loadInvoiceUrl(arrayList);
    }
}
