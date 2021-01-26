package com.baidu.sapi2.share;

import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.sapi2.utils.Log;
import java.util.Collections;

/* compiled from: SapiShareClient */
public class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ IBinder f2899a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f2900b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ b f2901c;

    public a(b bVar, IBinder iBinder, ServiceConnection serviceConnection) {
        this.f2901c = bVar;
        this.f2899a = iBinder;
        this.f2900b = serviceConnection;
    }

    public void run() {
        try {
            ShareModel shareModel = new ShareModel(ShareEvent.VALIDATE, this.f2901c.f2903b.f2906c, Collections.singletonList(this.f2901c.f2903b.f2906c));
            if (this.f2901c.f2903b.f2907d) {
                shareModel = new ShareModel(ShareEvent.VALIDATE);
            }
            this.f2899a.transact(0, SapiShareClient.a(shareModel, this.f2901c.f2903b.f2907d), Parcel.obtain(), 0);
            try {
                SapiShareClient.f2873i.context.unbindService(this.f2900b);
            } catch (Throwable th) {
                Log.e(th);
            }
        } catch (Throwable th2) {
            Log.e(th2);
        }
        this.f2901c.f2903b.f2904a.remove(0);
        if (!this.f2901c.f2903b.f2904a.isEmpty()) {
            b bVar = this.f2901c;
            bVar.f2903b.f2905b.post(bVar.f2902a);
            return;
        }
        this.f2901c.f2903b.f2908e.quit();
    }
}
