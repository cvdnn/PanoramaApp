package e.l.a.i;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* compiled from: SensorActivityTest */
public class g {

    /* renamed from: b reason: collision with root package name */
    public static final SensorEventListener f8948b = new a();

    /* renamed from: a reason: collision with root package name */
    public Context f8949a;

    /* compiled from: SensorActivityTest */
    public static class a implements SensorEventListener {
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
        }
    }

    public g(Context context) {
        this.f8949a = context;
    }

    public boolean a() throws Throwable {
        SensorManager sensorManager = (SensorManager) this.f8949a.getSystemService("sensor");
        try {
            Sensor defaultSensor = sensorManager.getDefaultSensor(18);
            sensorManager.registerListener(f8948b, defaultSensor, 3);
            sensorManager.unregisterListener(f8948b, defaultSensor);
            return true;
        } catch (Throwable unused) {
            return !this.f8949a.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
        }
    }
}
