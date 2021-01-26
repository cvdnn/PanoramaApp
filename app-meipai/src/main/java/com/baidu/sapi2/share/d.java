package com.baidu.sapi2.share;

import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.sapi2.utils.Log;
import java.util.Collections;

/* compiled from: SapiShareClient */
public class d implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ IBinder f2910a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ ServiceConnection f2911b;

    /* renamed from: c reason: collision with root package name */
    public final /* synthetic */ e f2912c;

    public d(e eVar, IBinder iBinder, ServiceConnection serviceConnection) {
        this.f2912c = eVar;
        this.f2910a = iBinder;
        this.f2911b = serviceConnection;
    }

    public void run() {
        try {
            this.f2910a.transact(0, SapiShareClient.a(new ShareModel(ShareEvent.INVALIDATE, null, Collections.singletonList(this.f2912c.f2914b.f2917c)), false), Parcel.obtain(), 0);
            try {
                SapiShareClient.f2873i.context.unbindService(this.f2911b);
            } catch (Throwable th) {
                Log.e(th);
            }
        } catch (Throwable th2) {
            Log.e(th2);
        }
        this.f2912c.f2914b.f2915a.remove(0);
        if (!this.f2912c.f2914b.f2915a.isEmpty()) {
            e eVar = this.f2912c;
            eVar.f2914b.f2916b.post(eVar.f2913a);
            return;
        }
        this.f2912c.f2914b.f2918d.quit();
    }
}
