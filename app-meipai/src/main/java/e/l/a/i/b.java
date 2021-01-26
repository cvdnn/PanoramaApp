package e.l.a.i;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

/* compiled from: CameraTest */
public class b {

    /* renamed from: b reason: collision with root package name */
    public static final PreviewCallback f8941b = new a();

    /* renamed from: a reason: collision with root package name */
    public Context f8942a;

    /* compiled from: CameraTest */
    public static class a implements PreviewCallback {
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    public b(Context context) {
        this.f8942a = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|13|14|(1:16)|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        return true ^ r5.f8942a.getPackageManager().hasSystemFeature("android.hardware.camera");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r2 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        r2.stopPreview();
        r2.setPreviewCallback(null);
        r2.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            int r2 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0027 }
            if (r2 > 0) goto L_0x0009
            return r0
        L_0x0009:
            int r2 = r2 - r0
            android.hardware.Camera r2 = android.hardware.Camera.open(r2)     // Catch:{ all -> 0x0027 }
            android.hardware.Camera$Parameters r3 = r2.getParameters()     // Catch:{ all -> 0x0028 }
            r2.setParameters(r3)     // Catch:{ all -> 0x0028 }
            android.hardware.Camera$PreviewCallback r3 = f8941b     // Catch:{ all -> 0x0028 }
            r2.setPreviewCallback(r3)     // Catch:{ all -> 0x0028 }
            r2.startPreview()     // Catch:{ all -> 0x0028 }
            r2.stopPreview()
            r2.setPreviewCallback(r1)
            r2.release()
            return r0
        L_0x0027:
            r2 = r1
        L_0x0028:
            android.content.Context r3 = r5.f8942a     // Catch:{ all -> 0x0041 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "android.hardware.camera"
            boolean r3 = r3.hasSystemFeature(r4)     // Catch:{ all -> 0x0041 }
            r0 = r0 ^ r3
            if (r2 == 0) goto L_0x0040
            r2.stopPreview()
            r2.setPreviewCallback(r1)
            r2.release()
        L_0x0040:
            return r0
        L_0x0041:
            r0 = move-exception
            if (r2 == 0) goto L_0x004d
            r2.stopPreview()
            r2.setPreviewCallback(r1)
            r2.release()
        L_0x004d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.a.i.b.a():boolean");
    }
}
