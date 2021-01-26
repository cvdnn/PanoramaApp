package e.g.c.a.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;

/* compiled from: HeadTracker */
public class a {

    /* renamed from: j reason: collision with root package name */
    public static final int[] f8592j = {1, 4};

    /* renamed from: a reason: collision with root package name */
    public final Context f8593a;

    /* renamed from: b reason: collision with root package name */
    public final float[] f8594b = new float[16];

    /* renamed from: c reason: collision with root package name */
    public final float[] f8595c = new float[16];

    /* renamed from: d reason: collision with root package name */
    public final float[] f8596d = new float[3];

    /* renamed from: e reason: collision with root package name */
    public Looper f8597e;

    /* renamed from: f reason: collision with root package name */
    public SensorEventListener f8598f;

    /* renamed from: g reason: collision with root package name */
    public volatile boolean f8599g;

    /* renamed from: h reason: collision with root package name */
    public final e.g.c.a.a.b.b f8600h = new e.g.c.a.a.b.b();

    /* renamed from: i reason: collision with root package name */
    public long f8601i;

    /* renamed from: e.g.c.a.a.a$a reason: collision with other inner class name */
    /* compiled from: HeadTracker */
    public class C0119a implements SensorEventListener {
        public C0119a() {
        }

        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            a.this.a(sensorEvent);
        }
    }

    /* compiled from: HeadTracker */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Looper.prepare();
            a.this.f8597e = Looper.myLooper();
            Handler handler = new Handler();
            SensorManager sensorManager = (SensorManager) a.this.f8593a.getSystemService("sensor");
            for (int defaultSensor : a.f8592j) {
                sensorManager.registerListener(a.this.f8598f, sensorManager.getDefaultSensor(defaultSensor), 0, handler);
            }
            Looper.loop();
        }
    }

    public a(Context context) {
        this.f8593a = context;
        Matrix.setRotateEulerM(this.f8594b, 0, -90.0f, 0.0f, 0.0f);
    }

    public void a() {
        if (!this.f8599g) {
            this.f8600h.a();
            this.f8598f = new C0119a();
            new Thread(new b()).start();
            this.f8599g = true;
        }
    }

    public void b() {
        if (this.f8599g) {
            ((SensorManager) this.f8593a.getSystemService("sensor")).unregisterListener(this.f8598f);
            this.f8598f = null;
            this.f8597e.quit();
            this.f8597e = null;
            this.f8599g = false;
        }
    }

    public void a(float[] fArr, int i2) {
        if (i2 + 16 <= fArr.length) {
            synchronized (this.f8600h) {
                double[] a2 = this.f8600h.a((((double) (System.nanoTime() - this.f8601i)) * 1.0E-9d) + 0.03333333333333333d);
                for (int i3 = 0; i3 < fArr.length; i3++) {
                    this.f8595c[i3] = (float) a2[i3];
                }
            }
            Matrix.multiplyMM(fArr, i2, this.f8595c, 0, this.f8594b, 0);
            return;
        }
        throw new IllegalArgumentException("Not enough space to write the result");
    }

    public final void a(SensorEvent sensorEvent) {
        long nanoTime = System.nanoTime();
        float[] fArr = this.f8596d;
        float[] fArr2 = sensorEvent.values;
        fArr[0] = -fArr2[1];
        fArr[1] = fArr2[0];
        fArr[2] = fArr2[2];
        synchronized (this.f8600h) {
            if (sensorEvent.sensor.getType() == 1) {
                this.f8600h.a(this.f8596d, sensorEvent.timestamp);
            } else if (sensorEvent.sensor.getType() == 4) {
                this.f8601i = nanoTime;
                this.f8600h.b(this.f8596d, sensorEvent.timestamp);
            }
        }
    }
}
