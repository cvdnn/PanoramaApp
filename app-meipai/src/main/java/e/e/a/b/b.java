package e.e.a.b;

import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseSettings;
import e.e.a.d.k;

/* compiled from: AdvertiseManager */
public class b extends AdvertiseCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ k f7941a;

    public b(c cVar, k kVar) {
        this.f7941a = kVar;
    }

    public void onStartFailure(int i2) {
        super.onStartFailure(i2);
        k kVar = this.f7941a;
        if (kVar != null) {
            kVar.a(i2);
        }
    }

    public void onStartSuccess(AdvertiseSettings advertiseSettings) {
        super.onStartSuccess(advertiseSettings);
        k kVar = this.f7941a;
        if (kVar != null) {
            kVar.a(advertiseSettings);
        }
    }
}
