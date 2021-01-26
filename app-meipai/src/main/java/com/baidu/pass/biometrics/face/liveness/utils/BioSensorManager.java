package com.baidu.pass.biometrics.face.liveness.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.pass.biometrics.base.debug.Log;
import e.a.a.a.a;

public class BioSensorManager {
    public static long SHOW_WHITE_BG_INTERNAL_TIME = 1000;
    public static final String TAG = "BioSensorManager";
    public Context context;
    public float curIllum = 2.14748365E9f;
    public long lastSensorChangeTime = 0;
    public SensorEventListener listener;
    public SensorManager senserManager;
    public Sensor sensor;

    public interface SensorCallback {
        void onChange(float f2);
    }

    public BioSensorManager(Context context2) {
        this.context = context2;
    }

    public float getIllumValue() {
        if (this.lastSensorChangeTime != 0 && System.currentTimeMillis() - this.lastSensorChangeTime > SHOW_WHITE_BG_INTERNAL_TIME) {
            this.curIllum = 0.0f;
        }
        return this.curIllum;
    }

    @TargetApi(3)
    public void registerSensorListener(final SensorCallback sensorCallback) {
        SensorManager sensorManager = (SensorManager) this.context.getSystemService("sensor");
        this.senserManager = sensorManager;
        if (sensorManager == null) {
            Log.w(TAG, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.sensor = defaultSensor;
        if (defaultSensor != null) {
            AnonymousClass1 r0 = new SensorEventListener() {
                public void onAccuracyChanged(Sensor sensor, int i2) {
                    Log.w(BioSensorManager.TAG, a.a("onAccuracyChanged", i2));
                }

                public void onSensorChanged(SensorEvent sensorEvent) {
                    String str = BioSensorManager.TAG;
                    StringBuilder a2 = a.a("onSensorChanged() time:");
                    a2.append(System.currentTimeMillis());
                    Log.w(str, a2.toString());
                    float[] fArr = sensorEvent.values;
                    if (fArr != null && fArr.length > 0) {
                        BioSensorManager.this.curIllum = fArr[0];
                        String str2 = BioSensorManager.TAG;
                        StringBuilder a3 = a.a("onSensorChanged() event.values[0]:");
                        a3.append(BioSensorManager.this.curIllum);
                        Log.w(str2, a3.toString());
                    }
                    BioSensorManager.this.lastSensorChangeTime = System.currentTimeMillis();
                    SensorCallback sensorCallback = sensorCallback;
                    if (sensorCallback != null) {
                        sensorCallback.onChange(BioSensorManager.this.getIllumValue());
                    }
                }
            };
            this.listener = r0;
            this.senserManager.registerListener(r0, this.sensor, 3);
        }
    }

    @TargetApi(3)
    public void unRegisterSensorListener() {
        Log.w(TAG, "unRegisterSensorListener()");
        SensorManager sensorManager = this.senserManager;
        if (sensorManager != null && this.sensor != null) {
            sensorManager.unregisterListener(this.listener);
        }
    }
}
