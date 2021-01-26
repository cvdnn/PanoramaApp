package e.l.a.i;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: SensorHeartTest */
public class h {

    /* renamed from: b reason: collision with root package name */
    public static final SensorEventListener f8950b = new a();

    /* renamed from: a reason: collision with root package name */
    public Context f8951a;

    /* compiled from: SensorHeartTest */
    public static class a implements SensorEventListener {
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    public h(Context context) {
        this.f8951a = context;
    }

    public boolean a() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f8951a.getSystemService("sensor");
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(21);
            sensorManager.registerListener(f8950b, defaultSensor, 3);
            sensorManager.unregisterListener(f8950b, defaultSensor);
            return true;
        } catch (Throwable unused) {
            return !this.f8951a.getPackageManager().hasSystemFeature("android.hardware.sensor.heartrate");
        }
    }
}
