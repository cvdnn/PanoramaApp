package e.e.a.b;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import android.util.Log;
import e.e.a.d.l;

/* compiled from: AdvertiseManager */
public class a extends AdvertiseCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ l f7940a;

    public a(c cVar, l lVar) {
        this.f7940a = lVar;
    }

    public void onStartFailure(int i2) {
        super.onStartFailure(i2);
        StringBuilder sb = new StringBuilder();
        sb.append("Fail to setup errorCode");
        sb.append(i2);
        e.e.a.h.a.a(sb.toString());
        l lVar = this.f7940a;
        if (lVar != null) {
            lVar.a(i2);
        }
    }

    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
        super.onStartSuccess(advertiseSettings);
        StringBuilder a2 = e.a.a.a.a.a("onStartSuccess");
        a2.append(advertiseSettings.toString());
        String sb = a2.toString();
        if (e.e.a.h.a.f8024a && sb != null) {
            Log.d("FastBle", sb);
        }
        l lVar = this.f7940a;
        if (lVar != null) {
            lVar.a(advertiseSettings);
        }
    }
}
