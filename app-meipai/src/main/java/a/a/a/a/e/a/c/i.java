package a.a.a.a.e.a.c;

import a.a.a.a.e.a.g.e;
import com.arashivision.arvbmg.longtracker.LongTrackInfo;
import com.arashivision.arvbmg.longtracker.LongTracker;
import com.arashivision.arvbmg.longtracker.LongTracker.ILongTrackCallback;
import com.arashivision.arvbmg.longtracker.LongTracker.ITrackInitCompleteCallback;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insta360.basemedia.log.MediaLogger;

public class i {

    /* renamed from: f reason: collision with root package name */
    public static final MediaLogger f473f = MediaLogger.getLogger(i.class);

    /* renamed from: a reason: collision with root package name */
    public LongTracker f474a;

    /* renamed from: b reason: collision with root package name */
    public boolean f475b;

    /* renamed from: c reason: collision with root package name */
    public boolean f476c;

    /* renamed from: d reason: collision with root package name */
    public long f477d;

    /* renamed from: e reason: collision with root package name */
    public e f478e;

    public class a implements ITrackInitCompleteCallback {
        public void onInitComplete(boolean z) {
        }
    }

    public class b implements ILongTrackCallback {
        public b() {
        }

        public void onNotify(LongTracker longTracker, int i2, int i3, long j2, long j3, float f2, String str, String str2, Object obj, Object obj2, Object obj3) {
            Object obj4 = obj;
            Object obj5 = obj2;
            Object obj6 = obj3;
            MediaLogger mediaLogger = i.f473f;
            StringBuilder sb = new StringBuilder();
            sb.append("onNotify() called with: tracker = [");
            LongTracker longTracker2 = longTracker;
            sb.append(longTracker);
            sb.append("], notifyType = [");
            int i4 = i2;
            sb.append(i2);
            sb.append("], value = [");
            int i5 = i3;
            sb.append(i3);
            sb.append("], extra = [");
            long j4 = j2;
            sb.append(j2);
            sb.append("], time = [");
            long j5 = j3;
            sb.append(j3);
            sb.append("], fov = [");
            float f3 = f2;
            sb.append(f2);
            sb.append("], domain = [");
            sb.append(str);
            sb.append("], desc = [");
            sb.append(str2);
            sb.append("], rect = [");
            sb.append(obj4);
            sb.append("], smoothObj = [");
            sb.append(obj5);
            sb.append("], unsmoothObj = [");
            sb.append(obj6);
            sb.append("]");
            mediaLogger.d(sb.toString());
            e eVar = i.this.f478e;
            if (eVar != null) {
                float[] fArr = (float[]) obj5;
                float[] fArr2 = (float[]) obj6;
                float[] fArr3 = (float[]) obj4;
                eVar.a();
            }
        }

        public void onStartCallback(String str, boolean z) {
            MediaLogger mediaLogger = i.f473f;
            StringBuilder sb = new StringBuilder();
            sb.append("onStartCallback() called with: obj = [");
            sb.append(str);
            sb.append("], isDetectSkeleton = [");
            sb.append(z);
            sb.append("]");
            mediaLogger.d(sb.toString());
            e eVar = i.this.f478e;
            if (eVar != null) {
                eVar.onTrackStart(str, z);
            }
        }

        public void onStopCallback(long j2) {
            MediaLogger mediaLogger = i.f473f;
            StringBuilder sb = new StringBuilder();
            sb.append("onStopCallback() called with: skeletonCount = [");
            sb.append(j2);
            sb.append("]");
            mediaLogger.d(sb.toString());
            e eVar = i.this.f478e;
            if (eVar != null) {
                eVar.onStopTrack(j2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(float[] fArr, Transform transform, String str, String str2, String str3, float f2, float f3, int i2, int[] iArr, int i3, long j2, String[] strArr, double d2, long j3) {
        this.f474a = new LongTracker();
        LongTrackInfo longTrackInfo = new LongTrackInfo();
        longTrackInfo.screenX = (double) fArr[0];
        boolean z = true;
        longTrackInfo.screenY = (double) fArr[1];
        longTrackInfo.minFov = (float) Math.toRadians(0.0d);
        longTrackInfo.maxFov = (float) Math.toRadians(150.0d);
        longTrackInfo.curentFov = transform.getFov();
        longTrackInfo.mnnPath = str;
        longTrackInfo.namePath = str2;
        longTrackInfo.roiPath = str3;
        longTrackInfo.headThreshold = f2;
        longTrackInfo.objectRatio = f3;
        longTrackInfo.intervalTrack = i2;
        longTrackInfo.offscreenWidth = iArr[0];
        longTrackInfo.offscreenHeight = iArr[1];
        longTrackInfo.objectName = i3;
        longTrackInfo.useOffRenderOnly = true;
        longTrackInfo.offStartTime = j2;
        longTrackInfo.urls = strArr;
        longTrackInfo.transform = transform;
        this.f474a.setInitCompleteCallback(new a());
        this.f474a.setLongTrackCallback(new b());
        int i4 = (int) (1000.0d / d2);
        this.f474a.startOffTrack(longTrackInfo);
        while (true) {
            long j4 = this.f477d;
            if (j4 >= j3) {
                z = false;
                break;
            } else if (this.f476c) {
                this.f474a.stopOffTrack();
                break;
            } else {
                this.f474a.updateOffTrack(j4);
                this.f477d += (long) i4;
            }
        }
        if (!z) {
            this.f474a.stopOffTrack();
        }
        this.f474a.release();
        this.f475b = false;
    }

    public synchronized void a() {
        if (this.f475b) {
            this.f476c = true;
        }
    }

    public synchronized void a(String[] strArr, Transform transform, long j2, float[] fArr, int[] iArr, int i2, String str, String str2, String str3, float f2, int i3, float f3, double d2, long j3) {
        synchronized (this) {
            if (this.f475b) {
                f473f.w("startTrack, but now is tracking");
                return;
            }
            this.f475b = true;
            this.f476c = false;
            this.f477d = j2;
            a aVar = r1;
            a aVar2 = new a(this, fArr, transform, str, str2, str3, f2, f3, i2, iArr, i3, j2, strArr, d2, j3);
            Thread thread = new Thread(aVar);
            thread.start();
        }
    }
}
