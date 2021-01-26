package d.b.k;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

/* compiled from: TwilightManager */
public class n {

    /* renamed from: d reason: collision with root package name */
    public static n f4037d;

    /* renamed from: a reason: collision with root package name */
    public final Context f4038a;

    /* renamed from: b reason: collision with root package name */
    public final LocationManager f4039b;

    /* renamed from: c reason: collision with root package name */
    public final a f4040c = new a();

    /* compiled from: TwilightManager */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public boolean f4041a;

        /* renamed from: b reason: collision with root package name */
        public long f4042b;
    }

    public n(Context context, LocationManager locationManager) {
        this.f4038a = context;
        this.f4039b = locationManager;
    }

    public final Location a(String str) {
        try {
            if (this.f4039b.isProviderEnabled(str)) {
                return this.f4039b.getLastKnownLocation(str);
            }
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
        }
        return null;
    }
}
