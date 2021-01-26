package com.arashivision.onecamera;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import e.a.a.a.a;

public class SensorService implements SensorEventListener {
    public static final String TAG = "SensorService";
    public boolean mAccelDataUpdated;
    public Sensor mAccelerometerDeltaSensor;
    public Sensor mAccelerometerOriginSensor;
    public boolean mActived;
    public Context mContext;
    public float[] mDeltaData = new float[3];
    public float[] mGyroData = new float[3];
    public boolean mGyroDataUpdated;
    public Sensor mGyroSensor;
    public float[] mOriginAccelData = new float[3];
    public SensorManager mSensorManager;

    public SensorService(Context context) {
        this.mContext = context;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mAccelerometerOriginSensor = sensorManager.getDefaultSensor(1);
        this.mAccelerometerDeltaSensor = this.mSensorManager.getDefaultSensor(10);
        this.mGyroSensor = this.mSensorManager.getDefaultSensor(4);
        StringBuilder a2 = a.a("TYPE_ACCELEROMETER sensor: ");
        a2.append(this.mAccelerometerOriginSensor);
        a2.append("\n TYPE_LINEAR_ACCELERATION sensor: ");
        a2.append(this.mAccelerometerDeltaSensor);
        a2.append("\n TYPE_GYROSCOPE sensor: ");
        a2.append(this.mGyroSensor);
        Log.i(TAG, a2.toString());
    }

    public void active() {
        if (!this.mActived) {
            Log.i(TAG, "active");
            this.mActived = true;
            this.mSensorManager.registerListener(this, this.mAccelerometerOriginSensor, 0);
            this.mSensorManager.registerListener(this, this.mAccelerometerDeltaSensor, 0);
            this.mSensorManager.registerListener(this, this.mGyroSensor, 0);
        }
    }

    public void deActive() {
        if (this.mActived) {
            Log.i(TAG, "deActive");
            this.mActived = false;
            this.mSensorManager.unregisterListener(this, this.mAccelerometerOriginSensor);
            this.mSensorManager.unregisterListener(this, this.mAccelerometerDeltaSensor);
            this.mSensorManager.unregisterListener(this, this.mGyroSensor);
            this.mAccelDataUpdated = false;
            this.mGyroDataUpdated = false;
        }
    }

    public synchronized boolean getAccelData(float[] fArr) {
        if (!this.mAccelDataUpdated) {
            return false;
        }
        fArr[0] = this.mOriginAccelData[0] - this.mDeltaData[0];
        fArr[1] = this.mOriginAccelData[1] - this.mDeltaData[1];
        fArr[2] = this.mOriginAccelData[2] - this.mDeltaData[2];
        return true;
    }

    public synchronized boolean getGyroData(float[] fArr) {
        if (!this.mGyroDataUpdated) {
            return false;
        }
        System.arraycopy(this.mGyroData, 0, fArr, 0, 3);
        return true;
    }

    public void onAccuracyChanged(Sensor sensor, int i2) {
        Sensor sensor2 = this.mAccelerometerOriginSensor;
        String str = TAG;
        if (sensor == sensor2) {
            StringBuilder sb = new StringBuilder();
            sb.append("accelermeter sensor accuracy changed: ");
            sb.append(i2);
            Log.w(str, sb.toString());
        } else if (sensor == this.mAccelerometerDeltaSensor) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("accelermeter delta sensor accuracy changed: ");
            sb2.append(i2);
            Log.w(str, sb2.toString());
        } else if (sensor == this.mGyroSensor) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("gyro sensor accuracy changed: ");
            sb3.append(i2);
            Log.w(str, sb3.toString());
        }
    }

    public synchronized void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            System.arraycopy(sensorEvent.values, 0, this.mOriginAccelData, 0, 3);
            this.mAccelDataUpdated = true;
        } else if (sensorEvent.sensor.getType() == 10) {
            System.arraycopy(sensorEvent.values, 0, this.mDeltaData, 0, 3);
        } else if (sensorEvent.sensor.getType() == 4) {
            System.arraycopy(sensorEvent.values, 0, this.mGyroData, 0, 3);
            this.mGyroDataUpdated = true;
        }
    }
}
