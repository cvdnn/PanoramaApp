package e.c.d.d.c;

import android.annotation.SuppressLint;
import com.baidu.picapture.ui.home.HomeActivity;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import e.c.b.e.Utils;
import e.c.d.d.c.e.a;

/* compiled from: PassportManager */
public class d extends WebAuthListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f6004a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ e f6005b;

    public d(e eVar, a aVar) {
        this.f6005b = eVar;
        this.f6004a = aVar;
    }

    @SuppressLint({"DefaultLocale"})
    public void onFailure(SapiResult sapiResult) {
        WebAuthResult webAuthResult = (WebAuthResult) sapiResult;
        String.format("登录失败（%d:%s）", new Object[]{Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()});
        a aVar = this.f6004a;
        if (aVar != null) {
            webAuthResult.getResultCode();
            webAuthResult.getResultMsg();
            HomeActivity.this.finish();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void onSuccess(SapiResult sapiResult) {
        WebAuthResult webAuthResult = (WebAuthResult) sapiResult;
        String.format("登录成功（%d:%s）", new Object[]{Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()});
        SapiAccountManager.getInstance().getSession();
        this.f6005b.f6009c = Utils.i(e.f6006d.a().uid);
        a aVar = this.f6004a;
        if (aVar != null) {
            HomeActivity.this.k0();
        }
    }
}
