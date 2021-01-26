package e.l.a.i;

import android.content.Context;
import android.media.AudioRecord;
import com.baidu.sapi2.permissions.PermissionsHelperActivity;

/* compiled from: RecordAudioTest */
public class f {

    /* renamed from: b reason: collision with root package name */
    public static final int[] f8946b = {PermissionsHelperActivity.f2829a, 11025, 22050, 44100};

    /* renamed from: a reason: collision with root package name */
    public Context f8947a;

    public f(Context context) {
        this.f8947a = context;
    }

    public static int[] b() {
        int[] iArr;
        for (int i2 : f8946b) {
            int[] iArr2 = {16, 12};
            for (int i3 = 0; i3 < 2; i3++) {
                int i4 = iArr2[i3];
                int[] iArr3 = {3, 2};
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = iArr3[i5];
                    int minBufferSize = AudioRecord.getMinBufferSize(i2, i4, i6);
                    if (minBufferSize != -2) {
                        return new int[]{i2, i4, i6, minBufferSize};
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:41|40|46|47|48|(2:50|51)|(1:56)|(1:58)|59) */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00b8, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b9, code lost:
        if (r0 != 0) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c6, code lost:
        r4.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00c9, code lost:
        if (r9 != 0) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00cb, code lost:
        r9.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00ce, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x009b */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a4 A[SYNTHETIC, Splitter:B:50:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b4 A[DONT_GENERATE] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() throws java.lang.Throwable {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            int[] r2 = b()     // Catch:{ all -> 0x0099 }
            if (r2 != 0) goto L_0x0010
            android.content.Context r2 = r12.f8947a     // Catch:{ all -> 0x0099 }
            boolean r0 = a(r2)     // Catch:{ all -> 0x0099 }
            r0 = r0 ^ r1
            return r0
        L_0x0010:
            android.media.AudioRecord r9 = new android.media.AudioRecord     // Catch:{ all -> 0x0099 }
            r4 = 1
            r10 = 0
            r5 = r2[r10]     // Catch:{ all -> 0x0099 }
            r6 = r2[r1]     // Catch:{ all -> 0x0099 }
            r3 = 2
            r7 = r2[r3]     // Catch:{ all -> 0x0099 }
            r11 = 3
            r8 = r2[r11]     // Catch:{ all -> 0x0099 }
            r3 = r9
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0099 }
            int r3 = r9.getState()     // Catch:{ all -> 0x0097 }
            if (r3 == r1) goto L_0x0033
            android.content.Context r2 = r12.f8947a     // Catch:{ all -> 0x0097 }
            boolean r0 = a(r2)     // Catch:{ all -> 0x0097 }
            r0 = r0 ^ r1
            r9.release()
            return r0
        L_0x0033:
            int r3 = r9.getRecordingState()     // Catch:{ all -> 0x0097 }
            if (r3 == r1) goto L_0x003d
            r9.release()
            return r1
        L_0x003d:
            r9.startRecording()     // Catch:{ all -> 0x0097 }
            int r3 = r9.getRecordingState()     // Catch:{ all -> 0x0097 }
            if (r3 == r11) goto L_0x004a
            r9.release()
            return r1
        L_0x004a:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0097 }
            android.content.Context r4 = r12.f8947a     // Catch:{ all -> 0x0097 }
            java.io.File r4 = r4.getCacheDir()     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = "_andpermission_audio_record_test_"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0097 }
            r3.mkdirs()     // Catch:{ all -> 0x0097 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0097 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = java.lang.Long.toString(r5)     // Catch:{ all -> 0x0097 }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0097 }
            boolean r3 = r4.exists()     // Catch:{ all -> 0x009b }
            if (r3 == 0) goto L_0x0070
            r4.createNewFile()     // Catch:{ all -> 0x009b }
        L_0x0070:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x009b }
            r3.<init>(r4)     // Catch:{ all -> 0x009b }
            r0 = r2[r11]     // Catch:{ all -> 0x0095 }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0095 }
            r2 = r2[r11]     // Catch:{ all -> 0x0095 }
            int r2 = r9.read(r0, r10, r2)     // Catch:{ all -> 0x0095 }
            r3.write(r0, r10, r2)     // Catch:{ all -> 0x0095 }
            r3.flush()     // Catch:{ all -> 0x0095 }
            r3.close()     // Catch:{ IOException -> 0x0088 }
        L_0x0088:
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x0091
            r4.delete()
        L_0x0091:
            r9.release()
            return r1
        L_0x0095:
            r0 = r3
            goto L_0x009b
        L_0x0097:
            r4 = r0
            goto L_0x009b
        L_0x0099:
            r4 = r0
            r9 = r4
        L_0x009b:
            android.content.Context r2 = r12.f8947a     // Catch:{ all -> 0x00b8 }
            boolean r2 = a(r2)     // Catch:{ all -> 0x00b8 }
            r1 = r1 ^ r2
            if (r0 == 0) goto L_0x00a7
            r0.close()     // Catch:{ IOException -> 0x00a7 }
        L_0x00a7:
            if (r4 == 0) goto L_0x00b2
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x00b2
            r4.delete()
        L_0x00b2:
            if (r9 == 0) goto L_0x00b7
            r9.release()
        L_0x00b7:
            return r1
        L_0x00b8:
            r1 = move-exception
            if (r0 == 0) goto L_0x00be
            r0.close()     // Catch:{ IOException -> 0x00be }
        L_0x00be:
            if (r4 == 0) goto L_0x00c9
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x00c9
            r4.delete()
        L_0x00c9:
            if (r9 == 0) goto L_0x00ce
            r9.release()
        L_0x00ce:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.a.i.f.a():boolean");
    }

    public static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.microphone");
    }
}
