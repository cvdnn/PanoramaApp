package com.baidu.sapi2.outsdk;

import android.content.Context;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiWebView.WeixinHandler;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.BceConfig;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.net.HttpCookie;
import java.util.ArrayList;

/* compiled from: WeiXinCall */
public class e {
    public void a(Context context, SapiConfiguration sapiConfiguration, WeixinHandler weixinHandler) {
        if (!a(sapiConfiguration)) {
            if (weixinHandler != null) {
                weixinHandler.handleNotInstall();
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        HttpCookie httpCookie = new HttpCookie("cuid", SapiUtils.getClientId(sapiConfiguration.context));
        String str = "";
        httpCookie.setDomain(sapiConfiguration.environment.getURL().replace("http://", str).replace("https://", str).replaceAll("(:[0-9]{1,4})?", str));
        httpCookie.setPath(BceConfig.BOS_DELIMITER);
        arrayList.add(httpCookie);
        weixinHandler.onFinish();
        Req req = new Req();
        req.scope = "snsapi_userinfo";
        WXAPIFactory.createWXAPI(context, sapiConfiguration.wxAppID).sendReq(req);
    }

    public boolean a(SapiConfiguration sapiConfiguration) {
        return WXAPIFactory.createWXAPI(sapiConfiguration.context, sapiConfiguration.wxAppID).isWXAppInstalled();
    }
}
