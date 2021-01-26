package com.baidu.sapi2.share;

import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.share.m.b;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.t;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SapiShareClient */
public class g implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ IBinder f2927a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f2928b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ h f2929c;

    public g(h hVar, IBinder iBinder, ServiceConnection serviceConnection) {
        this.f2929c = hVar;
        this.f2927a = iBinder;
        this.f2928b = serviceConnection;
    }

    public void run() {
        try {
            Parcel a2 = SapiShareClient.a(new ShareModel(ShareEvent.SYNC_REQ), false);
            Parcel obtain = Parcel.obtain();
            if (this.f2927a.transact(0, a2, obtain, 0)) {
                SapiShareClient.b(obtain);
            }
            if (this.f2929c.f2931b.f2933b) {
                HashMap hashMap = new HashMap();
                hashMap.put("cuid", SapiUtils.getClientId(SapiShareClient.f2873i.context));
                hashMap.put(Config.DEVICE_PART, Build.MODEL);
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                String str = "isLogin";
                if (currentAccount != null) {
                    hashMap.put(str, "true");
                    hashMap.put("uid", currentAccount.uid);
                    hashMap.put(b.f2952c, currentAccount.app);
                } else {
                    hashMap.put(str, "false");
                }
                t.a("share_silent_account_success", (Map<String, String>) hashMap);
            }
            try {
                SapiShareClient.f2873i.context.unbindService(this.f2928b);
            } catch (Throwable th) {
                Log.e(th);
            }
        } catch (Throwable th2) {
            Log.e(th2);
        }
        this.f2929c.f2931b.f2932a.remove(0);
        if (this.f2929c.f2931b.f2932a.isEmpty() || SapiShareClient.f2874j.getShareAccounts().size() >= 5) {
            this.f2929c.f2931b.f2935d.quit();
            return;
        }
        h hVar = this.f2929c;
        hVar.f2931b.f2934c.post(hVar.f2930a);
    }
}
