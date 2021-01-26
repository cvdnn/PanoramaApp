package com.baidu.picapture.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    /* renamed from: a reason: collision with root package name */
    public IWXAPI f2103a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, SapiAccountManager.getInstance().getSapiConfiguration().wxAppID, false);
        this.f2103a = createWXAPI;
        createWXAPI.handleIntent(getIntent(), this);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f2103a.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
        finish();
    }

    public void onResp(BaseResp baseResp) {
        if (1 == baseResp.getType()) {
            Resp resp = (Resp) baseResp;
            PassportSDK.getInstance().handleWXLoginResp(this, resp.state, resp.code, baseResp.errCode);
            finish();
            return;
        }
        finish();
    }
}
