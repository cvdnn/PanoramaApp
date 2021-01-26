package a.a.a.a.e.a.e;

import android.os.Handler;
import android.os.Looper;
import com.arashivision.arvbmg.exporter.ExportError;
import com.arashivision.arvbmg.exporter.OneExportCallback;
import com.arashivision.arvbmg.exporter.OneTrimExport;
import com.arashivision.arvbmg.transcode.BMGMediaTranscode;
import com.arashivision.arvbmg.transcode.BMGMediaTranscode.TranscodeCallback;
import com.arashivision.arvbmg.transcode.TranscodeError;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.ui.player.listener.IVideoPlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView;
import com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView.IL;
import com.arashivision.insta360.basemedia.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class o {

    /* renamed from: h reason: collision with root package name */
    public static final MediaLogger f540h = MediaLogger.getLogger("TranscodeDelegate");

    /* renamed from: a reason: collision with root package name */
    public BMGMediaTranscode f541a;

    /* renamed from: b reason: collision with root package name */
    public OneTrimExport f542b;

    /* renamed from: c reason: collision with root package name */
    public d f543c;

    /* renamed from: d reason: collision with root package name */
    public boolean f544d;

    /* renamed from: e reason: collision with root package name */
    public Handler f545e = new Handler(Looper.getMainLooper());

    /* renamed from: f reason: collision with root package name */
    public long f546f;

    /* renamed from: g reason: collision with root package name */
    public a f547g;

    public interface a {
    }

    public class b implements OneExportCallback {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f548a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ String[] f549b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ int[] f550c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ String[] f551d;

        public b(CountDownLatch countDownLatch, String[] strArr, int[] iArr, String[] strArr2) {
            this.f548a = countDownLatch;
            this.f549b = strArr;
            this.f550c = iArr;
            this.f551d = strArr2;
        }

        public void onExportProgressNotify(double d2) {
        }

        public void onExportStateNotify(int i2, int i3, ExportError exportError) {
            o oVar;
            if (i2 == 0) {
                o.f540h.i("trim export error");
                FileUtils.fullDeleteAllFiles(this.f549b);
                o.this.f544d = true;
                this.f550c[0] = exportError.getErrorCode();
                String[] strArr = this.f551d;
                StringBuilder sb = new StringBuilder();
                sb.append(exportError.getDomain());
                sb.append("-");
                sb.append(exportError.getDesc());
                strArr[0] = sb.toString();
                oVar = o.this;
            } else if (i2 == 1) {
                o.f540h.i("trim export cancel");
                FileUtils.fullDeleteAllFiles(this.f549b);
                oVar = o.this;
                oVar.f544d = true;
                this.f550c[0] = -1;
            } else if (i2 == 2) {
                o.f540h.i("trim export success");
                oVar = o.this;
            } else {
                return;
            }
            oVar.f542b = null;
            this.f548a.countDown();
        }
    }

    public class c implements TranscodeCallback {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ int f553a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ File f554b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f555c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ File f556d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ int[] f557e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ String[] f558f;

        /* renamed from: g reason: collision with root package name */
        public final /* synthetic */ String[] f559g;

        public c(int i2, File file, CountDownLatch countDownLatch, File file2, int[] iArr, String[] strArr, String[] strArr2) {
            this.f553a = i2;
            this.f554b = file;
            this.f555c = countDownLatch;
            this.f556d = file2;
            this.f557e = iArr;
            this.f558f = strArr;
            this.f559g = strArr2;
        }

        public void onTranscodeCancel(long j2) {
            MediaLogger mediaLogger = o.f540h;
            StringBuilder a2 = e.a.a.a.a.a("proxy generating canceled: ");
            a2.append(this.f553a);
            mediaLogger.d(a2.toString());
            this.f556d.delete();
            this.f557e[0] = -1;
            o.this.f544d = true;
            this.f555c.countDown();
        }

        public void onTranscodeComplete(long j2) {
            MediaLogger mediaLogger = o.f540h;
            StringBuilder a2 = e.a.a.a.a.a("proxy generating completed: ");
            a2.append(this.f553a);
            mediaLogger.d(a2.toString());
            try {
                this.f554b.createNewFile();
            } catch (IOException e2) {
                MediaLogger mediaLogger2 = o.f540h;
                StringBuilder a3 = e.a.a.a.a.a("create proxy transcode complete indicator file failed!");
                a3.append(this.f553a);
                mediaLogger2.e(a3.toString());
                e2.printStackTrace();
            }
            this.f555c.countDown();
        }

        public void onTranscodeFail(long j2, TranscodeError transcodeError) {
            String str;
            MediaLogger mediaLogger = o.f540h;
            StringBuilder a2 = e.a.a.a.a.a("proxy generating failed: ");
            a2.append(this.f553a);
            String str2 = "-";
            String str3 = "";
            if (transcodeError != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(transcodeError.getDomain());
                sb.append(str2);
                sb.append(transcodeError.getDesc());
                sb.append("(");
                sb.append(transcodeError.getErrorCode());
                sb.append(")");
                str = sb.toString();
            } else {
                str = str3;
            }
            a2.append(str);
            mediaLogger.e(a2.toString());
            this.f556d.delete();
            this.f557e[0] = transcodeError != null ? transcodeError.getErrorCode() : -15062;
            String[] strArr = this.f558f;
            if (transcodeError != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(transcodeError.getDomain());
                sb2.append(str2);
                sb2.append(transcodeError.getDesc());
                str3 = sb2.toString();
            }
            strArr[0] = str3;
            o.this.f544d = true;
            this.f555c.countDown();
        }

        public void onTranscodeProgress(long j2, double d2) {
            MediaLogger mediaLogger = o.f540h;
            StringBuilder a2 = e.a.a.a.a.a("proxy generating progress: ");
            a2.append(this.f553a);
            a2.append(", ");
            a2.append(d2);
            mediaLogger.d(a2.toString());
            double d3 = (double) this.f553a;
            String[] strArr = this.f559g;
            double length = (d2 / ((double) strArr.length)) + (d3 / ((double) strArr.length));
            a aVar = o.this.f547g;
            if (aVar != null) {
                a.a.a.a.e.a.e.q.b bVar = ((m) aVar).f535a.f567b;
                if (bVar != null) {
                    IL r4 = (IL) bVar;
                    for (IVideoPlayerViewListener onGenerateProxyFileProgress : VideoPlayerView.this.f244i11i) {
                        onGenerateProxyFileProgress.onGenerateProxyFileProgress(r4.IL1Iii, (float) length);
                    }
                }
            }
        }
    }

    public interface d {
    }

    public final String[] a() {
        int length = ((j) this.f543c).a().length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String cacheVideoProxyRootPath = ((j) this.f543c).f531a.f566a.getCacheVideoProxyRootPath();
            StringBuilder sb = new StringBuilder();
            sb.append(((j) this.f543c).f531a.a(i2));
            sb.append(".indicator");
            strArr[i2] = new File(cacheVideoProxyRootPath, sb.toString()).getAbsolutePath();
        }
        return strArr;
    }

    public final String[] b() {
        int length = ((j) this.f543c).a().length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String cacheVideoProxyRootPath = ((j) this.f543c).f531a.f566a.getCacheVideoProxyRootPath();
            StringBuilder sb = new StringBuilder();
            sb.append(((j) this.f543c).f531a.a(i2));
            sb.append("trim.");
            sb.append(FileUtils.getFileExtension(((j) this.f543c).a()[i2]));
            strArr[i2] = new File(cacheVideoProxyRootPath, sb.toString()).getAbsolutePath();
        }
        return strArr;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String[] strArr, CountDownLatch countDownLatch, int[] iArr, String[] strArr2) {
        String[] a2 = ((j) this.f543c).a();
        j jVar = (j) this.f543c;
        if (jVar != null) {
            OneTrimExport oneTrimExport = new OneTrimExport(a2, strArr, (long) 0.0d, (long) jVar.f531a.f566a.getTrimEnd(), false);
            this.f542b = oneTrimExport;
            b bVar = new b(countDownLatch, strArr, iArr, strArr2);
            oneTrimExport.setStateCallback(bVar, this.f545e);
            this.f542b.start();
            return;
        }
        throw null;
    }

    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r7v3, types: [int] */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v4, types: [int, boolean]
  assigns: []
  uses: [?[int, short, byte, char], ?[int, boolean, short, byte, char], boolean, ?[int, float, boolean, short, byte, char, OBJECT, ARRAY], int]
  mth insns count: 184
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r24) {
        /*
            r23 = this;
            r10 = r23
            long r11 = java.lang.System.currentTimeMillis()
            a.a.a.a.e.a.e.o$d r0 = r10.f543c
            a.a.a.a.e.a.e.j r0 = (a.a.a.a.e.a.e.j) r0
            a.a.a.a.e.a.e.q r0 = r0.f531a
            java.lang.String[] r13 = r0.a()
            java.lang.String[] r14 = r23.a()
            r0 = 1
            int[] r15 = new int[r0]
            r16 = 0
            r15[r16] = r16
            java.lang.String r1 = ""
            java.lang.String[] r17 = new java.lang.String[]{r1}
            r9 = r16
        L_0x0023:
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            if (r1 != 0) goto L_0x002a
            r1 = r16
            goto L_0x0031
        L_0x002a:
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            java.lang.String[] r1 = r1.a()
            int r1 = r1.length
        L_0x0031:
            if (r9 >= r1) goto L_0x01b1
            boolean r1 = r10.f544d
            if (r1 == 0) goto L_0x0039
            goto L_0x01b1
        L_0x0039:
            java.io.File r6 = new java.io.File
            r1 = r13[r9]
            r6.<init>(r1)
            java.io.File r4 = new java.io.File
            r1 = r14[r9]
            r4.<init>(r1)
            boolean r1 = r6.exists()
            if (r1 == 0) goto L_0x0063
            boolean r1 = r4.exists()
            if (r1 != 0) goto L_0x0054
            goto L_0x0063
        L_0x0054:
            com.arashivision.insta360.basemedia.log.MediaLogger r0 = f540h
            java.lang.String r1 = "proxy url matched!"
            r0.d(r1)
            r22 = r9
            r20 = r11
            r18 = r14
            goto L_0x01a4
        L_0x0063:
            com.arashivision.insta360.basemedia.util.FileUtils.fullDelete(r6)
            com.arashivision.insta360.basemedia.util.FileUtils.fullDelete(r4)
            f.a.a.c.o r8 = new f.a.a.c.o
            r8.<init>()
            if (r24 == 0) goto L_0x0077
            java.lang.String[] r1 = r23.b()
            r1 = r1[r9]
            goto L_0x0081
        L_0x0077:
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            java.lang.String[] r1 = r1.a()
            r1 = r1[r9]
        L_0x0081:
            r8.f9097a = r1
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            a.a.a.a.e.a.e.q r1 = r1.f531a
            a.a.a.a.e.a.e.k.h r1 = r1.f566a
            double r1 = r1.getFps()
            r8.f9098b = r1
            r1 = r13[r9]
            r8.f9102f = r1
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            a.a.a.a.e.a.e.q r1 = r1.f531a
            r2 = 2
            int[] r3 = new int[r2]
            a.a.a.a.e.a.e.k.h r5 = r1.f566a
            int r5 = r5.getWidth()
            a.a.a.a.e.a.e.k.h r7 = r1.f566a
            java.lang.String[] r7 = r7.getUrlsForPlay()
            int r7 = r7.length
            if (r7 != r2) goto L_0x00af
            r7 = r2
            goto L_0x00b0
        L_0x00af:
            r7 = r0
        L_0x00b0:
            int r5 = r5 / r7
            r3[r16] = r5
            a.a.a.a.e.a.e.k.h r1 = r1.f566a
            int r1 = r1.getHeight()
            r3[r0] = r1
            r1 = r3[r16]
            r5 = 720(0x2d0, float:1.009E-42)
            int r1 = r1 * r5
            r3 = r3[r0]
            int r1 = r1 / r3
            int r3 = r1 % 2
            if (r3 == 0) goto L_0x00d1
            com.arashivision.insta360.basemedia.log.MediaLogger r3 = a.a.a.a.e.a.e.q.f565d
            java.lang.String r7 = "proxy width is not 2n"
            r3.e(r7)
            int r1 = r1 / 2
            int r1 = r1 * r2
        L_0x00d1:
            r8.f9103g = r1
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            a.a.a.a.e.a.e.q r1 = r1.f531a
            if (r1 == 0) goto L_0x01af
            r8.f9104h = r5
            int r1 = r1.c()
            double r1 = (double) r1
            r8.f9105i = r1
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            if (r1 == 0) goto L_0x01ad
            r2 = 10485760(0xa00000, float:1.469368E-38)
            r8.f9106j = r2
            a.a.a.a.e.a.e.q r1 = r1.f531a
            a.a.a.a.e.a.e.k.h r1 = r1.f566a
            double r1 = r1.getTrimStart()
            r18 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r1 = r1 - r18
            double r1 = r1 * r18
            r20 = r11
            r11 = 0
            double r1 = java.lang.Math.max(r1, r11)
            long r1 = (long) r1
            r8.f9099c = r1
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            a.a.a.a.e.a.e.q r2 = r1.f531a
            a.a.a.a.e.a.e.k.h r2 = r2.f566a
            double r2 = r2.getTrimEnd()
            double r2 = r2 + r18
            double r2 = r2 * r18
            a.a.a.a.e.a.e.q r1 = r1.f531a
            a.a.a.a.e.a.e.k.h r1 = r1.f566a
            double r11 = r1.getDurationInMs()
            double r11 = r11 * r18
            double r1 = java.lang.Math.min(r2, r11)
            long r1 = (long) r1
            r8.f9100d = r1
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            a.a.a.a.e.a.e.q r1 = r1.f531a
            a.a.a.a.e.a.e.k.h r1 = r1.f566a
            boolean r1 = r1.hasAudio()
            r1 = r1 ^ r0
            r8.k = r1
            a.a.a.a.e.a.e.o$d r1 = r10.f543c
            a.a.a.a.e.a.e.j r1 = (a.a.a.a.e.a.e.j) r1
            a.a.a.a.e.a.e.q r1 = r1.f531a
            java.util.List r2 = r1.a(r0)
            f.a.a.c.o$a[] r1 = r1.a(r2)
            r8.f9101e = r1
            java.util.concurrent.CountDownLatch r11 = new java.util.concurrent.CountDownLatch
            r11.<init>(r0)
            com.arashivision.arvbmg.transcode.BMGMediaTranscode r0 = new com.arashivision.arvbmg.transcode.BMGMediaTranscode
            a.a.a.a.e.a.e.o$c r12 = new a.a.a.a.e.a.e.o$c
            r7 = 0
            r1 = r12
            r2 = r23
            r3 = r9
            r5 = r11
            r18 = r14
            r14 = r7
            r7 = r15
            r14 = r8
            r8 = r17
            r22 = r9
            r9 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8, r9)
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            r0.<init>(r12, r1)
            r10.f541a = r0
            long r0 = r0.start(r14)
            r10.f546f = r0
            r11.await()     // Catch:{ InterruptedException -> 0x017e }
            goto L_0x0183
        L_0x017e:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0183:
            com.arashivision.arvbmg.transcode.BMGMediaTranscode r0 = r10.f541a
            r0.release()
            r1 = 0
            r10.f541a = r1
            r0 = -1
            r10.f546f = r0
            a.a.a.a.e.a.e.o$a r0 = r10.f547g
            if (r0 == 0) goto L_0x01a4
            boolean r1 = r10.f544d
            if (r1 != 0) goto L_0x0198
            goto L_0x01a2
        L_0x0198:
            r1 = r15[r16]
            r2 = -1
            if (r1 != r2) goto L_0x019e
            goto L_0x01a2
        L_0x019e:
            r1 = r15[r16]
            r1 = r17[r16]
        L_0x01a2:
            a.a.a.a.e.a.e.m r0 = (a.a.a.a.e.a.e.m) r0
        L_0x01a4:
            int r9 = r22 + 1
            r0 = 1
            r14 = r18
            r11 = r20
            goto L_0x0023
        L_0x01ad:
            r0 = 0
            throw r0
        L_0x01af:
            r0 = 0
            throw r0
        L_0x01b1:
            r20 = r11
            long r0 = java.lang.System.currentTimeMillis()
            com.arashivision.insta360.basemedia.log.MediaLogger r2 = f540h
            java.lang.String r3 = "proxy step2 transcode cost : "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            long r0 = r0 - r20
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.i(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.e.a.e.o.a(boolean):void");
    }
}
