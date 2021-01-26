package e.k.a;

import com.weibo.ssosdk.WeiboSsoSdk;
import com.weibo.ssosdk.WeiboSsoSdk.c;

/* compiled from: WeiboSsoSdk */
public class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ a f8913a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ WeiboSsoSdk f8914b;

    public b(WeiboSsoSdk weiboSsoSdk, a aVar) {
        this.f8914b = weiboSsoSdk;
        this.f8913a = aVar;
    }

    public void run() {
        try {
            WeiboSsoSdk.a(this.f8914b, "", 1);
        } catch (Exception unused) {
        }
        WeiboSsoSdk weiboSsoSdk = this.f8914b;
        if (weiboSsoSdk.f3963c == null) {
            weiboSsoSdk.f3963c = new c();
        }
        this.f8913a.handler(this.f8914b.f3963c);
    }
}
