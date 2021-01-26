package f.a.a.c;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import java.io.IOException;
import java.util.LinkedList;

/* compiled from: VideoTrackTranscoder */
public class s extends m {

    /* renamed from: h reason: collision with root package name */
    public final MediaFormat f9121h;

    /* renamed from: i reason: collision with root package name */
    public final j f9122i;

    /* renamed from: j reason: collision with root package name */
    public final BufferInfo f9123j = new BufferInfo();
    public MediaCodec k;
    public MediaCodec l;
    public MediaFormat m;
    public h n;
    public e o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public a t;
    public long u;
    public long v;
    public long w = -1;
    public LinkedList<Long> x = new LinkedList<>();
    public d y;

    /* compiled from: VideoTrackTranscoder */
    public interface a {
        void onFirstFramePtsUs(long j2);
    }

    public s(MediaExtractor mediaExtractor, int i2, MediaFormat mediaFormat, j jVar, o oVar) {
        this.f9121h = mediaFormat;
        this.f9122i = jVar;
        if (this.f9093d) {
            StringBuilder a2 = e.a.a.a.a.a("mOutputFormat is ");
            a2.append(this.f9121h.toString());
            Log.e("VideoTrackTranscoder", a2.toString());
        }
        String str = "loacalVideoExtracotr";
        if (oVar != null) {
            this.f9092c = new r(oVar);
            if (oVar.u) {
                this.y = new k(mediaExtractor, i2, "remoteVideoExtracotr", 4194304);
            } else {
                this.y = new g(mediaExtractor, i2, str, 4194304);
            }
            this.y.a(oVar.f9099c, oVar.f9100d);
        } else {
            this.y = new g(mediaExtractor, i2, str, 4194304);
        }
        this.y.a();
    }

    public MediaFormat a() {
        return this.m;
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r3v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r2v48 */
    /* JADX WARNING: type inference failed for: r2v49 */
    /* JADX WARNING: type inference failed for: r3v57 */
    /* JADX WARNING: type inference failed for: r2v50 */
    /* JADX WARNING: type inference failed for: r2v59 */
    /* JADX WARNING: type inference failed for: r2v61 */
    /* JADX WARNING: type inference failed for: r2v77 */
    /* JADX WARNING: type inference failed for: r2v78 */
    /* JADX WARNING: type inference failed for: r2v79 */
    /* JADX WARNING: type inference failed for: r3v90 */
    /* JADX WARNING: type inference failed for: r2v80 */
    /* JADX WARNING: type inference failed for: r2v81 */
    /* JADX WARNING: type inference failed for: r2v82 */
    /* JADX WARNING: type inference failed for: r2v83 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v78
  assigns: []
  uses: []
  mth insns count: 458
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
    /* JADX WARNING: Removed duplicated region for block: B:124:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0494 A[LOOP:2: B:126:0x044f->B:137:0x0494, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0278 A[EDGE_INSN: B:142:0x0278->B:70:0x0278 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0279 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0496 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0271 A[LOOP:0: B:1:0x0006->B:68:0x0271, LOOP_END] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(long r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = 0
            r2 = 1
            r3 = r2
            r2 = r1
        L_0x0006:
            long r4 = r0.f9096g
            int r4 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            java.lang.String r5 = ")"
            java.lang.String r6 = " result "
            java.lang.String r7 = " buffer size "
            r8 = -1
            r9 = -2
            r10 = -3
            java.lang.String r11 = "VideoTrackTranscoder"
            r12 = 0
            if (r4 > 0) goto L_0x0276
            boolean r4 = r0.f9094e
            if (r4 == 0) goto L_0x0021
        L_0x001d:
            r10 = r6
            r6 = r7
            goto L_0x026f
        L_0x0021:
            android.media.MediaCodec r4 = r0.l
            android.media.MediaCodec$BufferInfo r14 = r0.f9123j
            int r4 = r4.dequeueOutputBuffer(r14, r12)
            if (r4 == r10) goto L_0x026c
            if (r4 == r9) goto L_0x0236
            if (r4 == r8) goto L_0x0232
            android.media.MediaFormat r8 = r0.m
            if (r8 == 0) goto L_0x022a
            android.media.MediaCodec$BufferInfo r8 = r0.f9123j
            long r9 = r8.presentationTimeUs
            int r8 = r8.flags
            r8 = r8 & 4
            if (r8 == 0) goto L_0x009e
            java.lang.String r8 = " encoder eos "
            android.util.Log.i(r11, r8)
            r0.f9094e = r3
            java.util.LinkedList<java.lang.Long> r8 = r0.x
            int r8 = r8.size()
            if (r8 == 0) goto L_0x0062
            java.lang.String r8 = "mDecoderPtsUsList not empty("
            java.lang.StringBuilder r8 = e.a.a.a.a.a(r8)
            java.util.LinkedList<java.lang.Long> r14 = r0.x
            int r14 = r14.size()
            r8.append(r14)
            java.lang.String r8 = r8.toString()
            android.util.Log.e(r11, r8)
        L_0x0062:
            int r8 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x0074
            java.lang.String r8 = " video encoder eos pts "
            java.lang.StringBuilder r8 = e.a.a.a.a.a(r8, r9, r7)
            android.media.MediaCodec$BufferInfo r14 = r0.f9123j
            int r14 = r14.size
            e.a.a.a.a.b(r8, r14, r11)
            goto L_0x009e
        L_0x0074:
            android.media.MediaCodec$BufferInfo r3 = r0.f9123j
            int r3 = r3.size
            if (r3 <= 0) goto L_0x0087
            java.lang.String r3 = " video encoder eos meet  buffer size "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            android.media.MediaCodec$BufferInfo r8 = r0.f9123j
            int r8 = r8.size
            e.a.a.a.a.b(r3, r8, r11)
        L_0x0087:
            android.media.MediaCodec$BufferInfo r14 = r0.f9123j
            r15 = 0
            r16 = 0
            r17 = 0
            int r3 = r14.flags
            r19 = r3
            r14.set(r15, r16, r17, r19)
            android.media.MediaCodec r3 = r0.l
            r3.releaseOutputBuffer(r4, r2)
            r10 = r6
            r6 = r7
            goto L_0x0228
        L_0x009e:
            android.media.MediaCodec$BufferInfo r8 = r0.f9123j
            int r8 = r8.flags
            r8 = r8 & 2
            if (r8 == 0) goto L_0x00b3
            java.lang.String r8 = " encoder BUFFER_FLAG_CODEC_CONFIG "
            android.util.Log.i(r11, r8)
            android.media.MediaCodec r8 = r0.l
            r8.releaseOutputBuffer(r4, r2)
            r2 = r3
            goto L_0x001d
        L_0x00b3:
            int r2 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r2 >= 0) goto L_0x00cb
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r14 = "error encoder ptsUs "
            r8.append(r14)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.util.Log.e(r11, r8)
        L_0x00cb:
            android.media.MediaCodec$BufferInfo r8 = r0.f9123j
            int r8 = r8.size
            if (r8 >= 0) goto L_0x00de
            java.lang.String r8 = "error encoder buffer size "
            java.lang.StringBuilder r8 = e.a.a.a.a.a(r8)
            android.media.MediaCodec$BufferInfo r14 = r0.f9123j
            int r14 = r14.size
            e.a.a.a.a.b(r8, r14, r11)
        L_0x00de:
            boolean r8 = r0.s
            if (r8 != 0) goto L_0x012c
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r14 = " first ptsUs "
            r8.append(r14)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.util.Log.i(r11, r8)
            r0.s = r3
            f.a.a.c.s$a r3 = r0.t
            if (r3 == 0) goto L_0x00ff
            r3.onFirstFramePtsUs(r9)
        L_0x00ff:
            if (r2 == 0) goto L_0x012c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "force write pts0 before first ptsUs "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r11, r2)
            android.media.MediaCodec$BufferInfo r2 = r0.f9123j
            r2.presentationTimeUs = r12
            f.a.a.c.j r2 = r0.f9122i
            f.a.a.c.j$d r3 = f.a.a.c.j.d.VIDEO
            android.media.MediaCodec r8 = r0.l
            java.nio.ByteBuffer r8 = r8.getOutputBuffer(r4)
            android.media.MediaCodec$BufferInfo r14 = r0.f9123j
            r2.a(r3, r8, r14)
            android.media.MediaCodec$BufferInfo r2 = r0.f9123j
            r2.presentationTimeUs = r9
        L_0x012c:
            android.media.MediaCodec$BufferInfo r2 = r0.f9123j
            f.a.a.c.j r3 = r0.f9122i
            f.a.a.c.j$d r8 = f.a.a.c.j.d.VIDEO
            android.media.MediaCodec r9 = r0.l
            java.nio.ByteBuffer r9 = r9.getOutputBuffer(r4)
            r3.a(r8, r9, r2)
            long r8 = r2.presentationTimeUs
            r0.f9096g = r8
            boolean r3 = r0.f9093d
            if (r3 == 0) goto L_0x0163
            java.lang.String r3 = " video mWrittenPresentationTimeUs "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            long r8 = r0.f9096g
            r3.append(r8)
            r3.append(r7)
            int r8 = r2.size
            r3.append(r8)
            r3.append(r6)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r11, r3)
        L_0x0163:
            r3 = 30
            long r8 = java.lang.System.nanoTime()
            long r14 = r0.u
            r16 = 1
            long r14 = r14 + r16
            r0.u = r14
            r10 = r6
            r16 = r7
            long r6 = (long) r3
            long r14 = r14 % r6
            int r3 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r3 != 0) goto L_0x019f
            long r6 = r0.v
            long r6 = r8 - r6
            double r6 = (double) r6
            r14 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r6 = r6 / r14
            r3 = 30000(0x7530, float:4.2039E-41)
            double r14 = (double) r3
            double r14 = r14 / r6
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "video transcode fps: "
            r3.append(r6)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            android.util.Log.i(r11, r3)
            r0.v = r8
        L_0x019f:
            android.media.MediaCodec r3 = r0.l
            r6 = 0
            r3.releaseOutputBuffer(r4, r6)
            long r6 = r0.w
            long r8 = r2.presentationTimeUs
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x01ce
            java.lang.String r3 = "pts error ("
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            long r6 = r0.w
            r3.append(r6)
            java.lang.String r6 = ">"
            r3.append(r6)
            long r6 = r2.presentationTimeUs
            r3.append(r6)
            java.lang.String r6 = ") b-frame?"
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r11, r3)
        L_0x01ce:
            long r6 = r2.presentationTimeUs
            r0.w = r6
            java.util.LinkedList<java.lang.Long> r3 = r0.x
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0206
            java.util.LinkedList<java.lang.Long> r2 = r0.x
            java.lang.Object r2 = r2.removeFirst()
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            long r6 = r0.w
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0203
            java.lang.String r4 = "mDecoderPtsUsList mismatch("
            java.lang.String r6 = ","
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r4, r2, r6)
            long r3 = r0.w
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r11, r2)
        L_0x0203:
            r6 = r16
            goto L_0x0228
        L_0x0206:
            java.lang.String r3 = "no decode pts to remove??render info: video mWrittenPresentationTimeUs "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            long r6 = r0.f9096g
            r3.append(r6)
            r6 = r16
            r3.append(r6)
            int r2 = r2.size
            r3.append(r2)
            r3.append(r10)
            r3.append(r4)
            java.lang.String r2 = r3.toString()
            android.util.Log.e(r11, r2)
        L_0x0228:
            r2 = 2
            goto L_0x026f
        L_0x022a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Could not determine actual output format."
            r1.<init>(r2)
            throw r1
        L_0x0232:
            r10 = r6
            r6 = r7
            r2 = 0
            goto L_0x026f
        L_0x0236:
            r10 = r6
            r6 = r7
            android.media.MediaFormat r2 = r0.m
            if (r2 != 0) goto L_0x0264
            android.media.MediaCodec r2 = r0.l
            android.media.MediaFormat r2 = r2.getOutputFormat()
            r0.m = r2
            java.lang.String r2 = " mActualOutputFormat "
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            android.media.MediaFormat r3 = r0.m
            java.lang.String r3 = r3.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r11, r2)
            f.a.a.c.j r2 = r0.f9122i
            f.a.a.c.j$d r3 = f.a.a.c.j.d.VIDEO
            android.media.MediaFormat r4 = r0.m
            r2.a(r3, r4)
            goto L_0x026e
        L_0x0264:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Video output format changed twice."
            r1.<init>(r2)
            throw r1
        L_0x026c:
            r10 = r6
            r6 = r7
        L_0x026e:
            r2 = 1
        L_0x026f:
            if (r2 == 0) goto L_0x0278
            r2 = 0
            r3 = 1
            r1 = 1
            goto L_0x0006
        L_0x0276:
            r10 = r6
            r6 = r7
        L_0x0278:
            r2 = 1
        L_0x0279:
            java.util.LinkedList<java.lang.Long> r3 = r0.x
            int r3 = r3.size()
            r4 = 8
            if (r3 <= r4) goto L_0x029e
            java.lang.String r3 = "mDecoderPtsUsList too much("
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            java.util.LinkedList<java.lang.Long> r4 = r0.x
            int r4 = r4.size()
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r11, r3)
            r3 = 1
            goto L_0x029f
        L_0x029e:
            r3 = 0
        L_0x029f:
            if (r3 != 0) goto L_0x044e
            r3 = 1
            if (r2 != r3) goto L_0x044e
            boolean r2 = r0.f9095f
            if (r2 == 0) goto L_0x02ab
        L_0x02a8:
            r2 = 0
            goto L_0x0449
        L_0x02ab:
            android.media.MediaCodec r2 = r0.k
            android.media.MediaCodec$BufferInfo r3 = r0.f9123j
            int r2 = r2.dequeueOutputBuffer(r3, r12)
            r3 = -3
            if (r2 == r3) goto L_0x043a
            r3 = -2
            if (r2 == r3) goto L_0x043a
            r3 = -1
            if (r2 == r3) goto L_0x02a8
            android.media.MediaCodec$BufferInfo r3 = r0.f9123j
            long r7 = r3.presentationTimeUs
            int r4 = r3.flags
            r4 = r4 & 4
            if (r4 == 0) goto L_0x02f9
            android.media.MediaCodec r3 = r0.l
            r3.signalEndOfInputStream()
            r3 = 1
            r0.f9095f = r3
            int r3 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x02e0
            java.lang.String r3 = " drainDecoder signalEndOfInputStream pts "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3, r7, r6)
            android.media.MediaCodec$BufferInfo r4 = r0.f9123j
            int r4 = r4.size
            e.a.a.a.a.b(r3, r4, r11)
            goto L_0x030a
        L_0x02e0:
            android.media.MediaCodec$BufferInfo r3 = r0.f9123j
            int r3 = r3.size
            if (r3 <= 0) goto L_0x030a
            java.lang.String r3 = " drainDecoder signalEndOfInputStream pts 0 but buffer size "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            android.media.MediaCodec$BufferInfo r4 = r0.f9123j
            int r4 = r4.size
            e.a.a.a.a.b(r3, r4, r11)
            android.media.MediaCodec$BufferInfo r3 = r0.f9123j
            r4 = 0
            r3.size = r4
            goto L_0x030a
        L_0x02f9:
            int r3 = r3.size
            if (r3 > 0) goto L_0x030a
            java.lang.String r3 = "bad render buffer size "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3)
            android.media.MediaCodec$BufferInfo r4 = r0.f9123j
            int r4 = r4.size
            e.a.a.a.a.b(r3, r4, r11)
        L_0x030a:
            android.media.MediaCodec$BufferInfo r3 = r0.f9123j
            int r3 = r3.size
            if (r3 <= 0) goto L_0x0312
            r3 = 1
            goto L_0x0313
        L_0x0312:
            r3 = 0
        L_0x0313:
            if (r3 == 0) goto L_0x034f
            boolean r4 = r0.a(r7)
            if (r4 == 0) goto L_0x033d
            boolean r4 = r0.f9093d
            if (r4 == 0) goto L_0x034f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "decode to render timeUs "
            r4.append(r9)
            r4.append(r7)
            r4.append(r10)
            r4.append(r2)
            r4.append(r6)
            android.media.MediaCodec$BufferInfo r9 = r0.f9123j
            int r9 = r9.size
            e.a.a.a.a.c(r4, r9, r11)
            goto L_0x034f
        L_0x033d:
            boolean r3 = r0.f9093d
            if (r3 == 0) goto L_0x034e
            java.lang.String r3 = "skip decode to render timeUs "
            java.lang.StringBuilder r3 = e.a.a.a.a.a(r3, r7, r6)
            android.media.MediaCodec$BufferInfo r4 = r0.f9123j
            int r4 = r4.size
            e.a.a.a.a.c(r3, r4, r11)
        L_0x034e:
            r3 = 0
        L_0x034f:
            android.media.MediaCodec r4 = r0.k
            r4.releaseOutputBuffer(r2, r3)
            if (r3 == 0) goto L_0x0438
            f.a.a.c.h r2 = r0.n
            r2.a()
            f.a.a.c.h r2 = r0.n
            f.a.a.c.l r3 = r2.f9039h
            android.graphics.SurfaceTexture r2 = r2.f9035d
            java.lang.String r4 = "onDrawFrame start"
            r3.a(r4)
            float[] r4 = r3.f9084e
            r2.getTransformMatrix(r4)
            r2 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            android.opengl.GLES20.glClearColor(r4, r2, r4, r2)
            r2 = 16640(0x4100, float:2.3318E-41)
            android.opengl.GLES20.glClear(r2)
            int r2 = r3.f9085f
            android.opengl.GLES20.glUseProgram(r2)
            java.lang.String r2 = "glUseProgram"
            r3.a(r2)
            r2 = 33984(0x84c0, float:4.7622E-41)
            android.opengl.GLES20.glActiveTexture(r2)
            int r2 = r3.f9086g
            r4 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r4, r2)
            java.nio.FloatBuffer r2 = r3.f9082c
            r4 = 0
            r2.position(r4)
            int r14 = r3.f9089j
            java.nio.FloatBuffer r2 = r3.f9082c
            r15 = 3
            r4 = 5126(0x1406, float:7.183E-42)
            r9 = 0
            r20 = 20
            r16 = 5126(0x1406, float:7.183E-42)
            r17 = 0
            r18 = 20
            r19 = r2
            android.opengl.GLES20.glVertexAttribPointer(r14, r15, r16, r17, r18, r19)
            java.lang.String r2 = "glVertexAttribPointer maPosition"
            r3.a(r2)
            int r2 = r3.f9089j
            android.opengl.GLES20.glEnableVertexAttribArray(r2)
            java.lang.String r2 = "glEnableVertexAttribArray maPositionHandle"
            r3.a(r2)
            java.nio.FloatBuffer r2 = r3.f9082c
            r14 = 3
            r2.position(r14)
            int r2 = r3.k
            java.nio.FloatBuffer r14 = r3.f9082c
            r17 = 2
            r16 = r2
            r18 = r4
            r19 = r9
            r21 = r14
            android.opengl.GLES20.glVertexAttribPointer(r16, r17, r18, r19, r20, r21)
            java.lang.String r2 = "glVertexAttribPointer maTextureHandle"
            r3.a(r2)
            int r2 = r3.k
            android.opengl.GLES20.glEnableVertexAttribArray(r2)
            java.lang.String r2 = "glEnableVertexAttribArray maTextureHandle"
            r3.a(r2)
            float[] r2 = r3.f9083d
            r4 = 0
            android.opengl.Matrix.setIdentityM(r2, r4)
            int r2 = r3.f9087h
            float[] r9 = r3.f9083d
            r14 = 1
            android.opengl.GLES20.glUniformMatrix4fv(r2, r14, r4, r9, r4)
            int r2 = r3.f9088i
            float[] r9 = r3.f9084e
            android.opengl.GLES20.glUniformMatrix4fv(r2, r14, r4, r9, r4)
            r2 = 5
            r9 = 4
            android.opengl.GLES20.glDrawArrays(r2, r4, r9)
            java.lang.String r2 = "glDrawArrays"
            r3.a(r2)
            android.opengl.GLES20.glFinish()
            f.a.a.c.e r2 = r0.o
            r3 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r7
            android.opengl.EGLDisplay r9 = r2.f9028a
            android.opengl.EGLSurface r2 = r2.f9030c
            android.opengl.EGLExt.eglPresentationTimeANDROID(r9, r2, r3)
            f.a.a.c.e r2 = r0.o
            android.opengl.EGLDisplay r3 = r2.f9028a
            android.opengl.EGLSurface r2 = r2.f9030c
            android.opengl.EGL14.eglSwapBuffers(r3, r2)
            java.util.LinkedList<java.lang.Long> r2 = r0.x
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r2.add(r3)
            boolean r2 = r0.f9093d
            if (r2 == 0) goto L_0x0438
            java.lang.String r2 = " mDecoderPtsUsList size "
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            java.util.LinkedList<java.lang.Long> r3 = r0.x
            int r3 = r3.size()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r11, r2)
        L_0x0438:
            r2 = 2
            goto L_0x0449
        L_0x043a:
            r3 = -2
            if (r2 != r3) goto L_0x0443
            java.lang.String r2 = "video output format change"
            android.util.Log.i(r11, r2)
            goto L_0x0448
        L_0x0443:
            java.lang.String r2 = "video output buffer change"
            android.util.Log.i(r11, r2)
        L_0x0448:
            r2 = 1
        L_0x0449:
            if (r2 == 0) goto L_0x0279
            r1 = 1
            goto L_0x0279
        L_0x044e:
            r2 = 0
        L_0x044f:
            boolean r3 = r0.p
            if (r3 == 0) goto L_0x0454
            goto L_0x045c
        L_0x0454:
            android.media.MediaCodec r3 = r0.k
            int r5 = r3.dequeueInputBuffer(r12)
            if (r5 >= 0) goto L_0x045f
        L_0x045c:
            r3 = 1
        L_0x045d:
            r4 = r2
            goto L_0x0492
        L_0x045f:
            android.media.MediaCodec r3 = r0.k
            java.nio.ByteBuffer r3 = r3.getInputBuffer(r5)
            r3.clear()
            f.a.a.c.d r4 = r0.y
            f.a.a.c.q r4 = r4.a(r3)
            if (r4 == 0) goto L_0x0484
            android.media.MediaCodec r6 = r0.k
            r7 = 0
            int r3 = r3.remaining()
            long r8 = r4.f9119c
            boolean r10 = r4.f9118b
            r4 = r6
            r6 = r7
            r7 = r3
            r4.queueInputBuffer(r5, r6, r7, r8, r10)
            r3 = 1
            r4 = 2
            goto L_0x0492
        L_0x0484:
            r3 = 1
            r0.p = r3
            android.media.MediaCodec r4 = r0.k
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 4
            r4.queueInputBuffer(r5, r6, r7, r8, r10)
            goto L_0x045d
        L_0x0492:
            if (r4 == 0) goto L_0x0496
            r1 = r3
            goto L_0x044f
        L_0x0496:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.c.s.b(long):boolean");
    }

    public void c() {
        String str = "mime";
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.f9121h.getString(str));
            this.l = createEncoderByType;
            createEncoderByType.configure(this.f9121h, null, null, 1);
            e eVar = new e(this.l.createInputSurface());
            this.o = eVar;
            EGLDisplay eGLDisplay = eVar.f9028a;
            EGLSurface eGLSurface = eVar.f9030c;
            if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eVar.f9029b)) {
                this.l.start();
                this.r = true;
                MediaFormat mediaFormat = this.y.f9022c;
                StringBuilder a2 = e.a.a.a.a.a("original video input format ");
                a2.append(mediaFormat.toString());
                String str2 = "VideoTrackTranscoder";
                Log.i(str2, a2.toString());
                String str3 = "rotation-degrees";
                if (mediaFormat.containsKey(str3)) {
                    StringBuilder a3 = e.a.a.a.a.a("include KEY_ROTATION_DEGREES set from ");
                    a3.append(mediaFormat.getInteger(str3));
                    a3.append(" to 0");
                    Log.e(str2, a3.toString());
                    mediaFormat.setInteger(str3, 0);
                }
                this.n = new h();
                String string = mediaFormat.getString(str);
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("transcode input mime ");
                    sb.append(string);
                    Log.i(str2, sb.toString());
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
                    this.k = createDecoderByType;
                    try {
                        createDecoderByType.configure(mediaFormat, this.n.f9036e, null, 0);
                        try {
                            this.k.start();
                            this.q = true;
                            this.v = System.nanoTime();
                        } catch (Exception e2) {
                            StringBuilder a4 = e.a.a.a.a.a(" decode start error inputFormat ");
                            a4.append(mediaFormat.toString());
                            Log.e(str2, a4.toString());
                            throw new IllegalStateException(e2);
                        }
                    } catch (Exception e3) {
                        StringBuilder a5 = e.a.a.a.a.a(" decode configure error inputFormat ");
                        a5.append(mediaFormat.toString());
                        Log.e(str2, a5.toString());
                        throw new IllegalStateException(e3);
                    }
                } catch (IOException e4) {
                    throw new IllegalStateException(e4);
                }
            } else {
                throw new RuntimeException("eglMakeCurrent failed");
            }
        } catch (IOException e5) {
            throw new IllegalStateException(e5);
        }
    }

    public void b() {
        h hVar = this.n;
        String str = "release";
        if (hVar != null) {
            if (hVar != null) {
                Log.i("OutputSurface", str);
                EGLDisplay eGLDisplay = hVar.f9032a;
                if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                    EGL14.eglDestroySurface(eGLDisplay, hVar.f9034c);
                    EGL14.eglDestroyContext(hVar.f9032a, hVar.f9033b);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(hVar.f9032a);
                }
                l lVar = hVar.f9039h;
                if (lVar != null) {
                    String str2 = "TextureRender";
                    if (lVar.f9080a == Thread.currentThread().getId()) {
                        StringBuilder a2 = e.a.a.a.a.a("release mTextureID ");
                        a2.append(lVar.f9086g);
                        a2.append(" mProgram ");
                        e.a.a.a.a.c(a2, lVar.f9085f, str2);
                        int i2 = lVar.f9086g;
                        if (i2 > 0) {
                            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                            lVar.f9086g = -1;
                        }
                        int i3 = lVar.f9085f;
                        if (i3 > 0) {
                            GLES20.glDeleteProgram(i3);
                            lVar.f9085f = -1;
                        }
                        hVar.f9039h = null;
                    } else {
                        StringBuilder b2 = e.a.a.a.a.b(str, "thread( ");
                        b2.append(Thread.currentThread().getId());
                        b2.append(") not in opengl thread( ");
                        b2.append(lVar.f9080a);
                        b2.append(")");
                        String sb = b2.toString();
                        Log.e(str2, sb);
                        throw new IllegalStateException(sb);
                    }
                }
                SurfaceTexture surfaceTexture = hVar.f9035d;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    hVar.f9035d = null;
                }
                Surface surface = hVar.f9036e;
                if (surface != null) {
                    surface.release();
                    hVar.f9036e = null;
                }
                hVar.f9032a = EGL14.EGL_NO_DISPLAY;
                hVar.f9033b = EGL14.EGL_NO_CONTEXT;
                hVar.f9034c = EGL14.EGL_NO_SURFACE;
                HandlerThread handlerThread = hVar.f9040i;
                if (handlerThread != null) {
                    handlerThread.quit();
                    try {
                        hVar.f9040i.join();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    hVar.f9040i = null;
                }
                this.n = null;
            } else {
                throw null;
            }
        }
        e eVar = this.o;
        if (eVar != null) {
            if (eVar != null) {
                Log.i("InputSurface", str);
                EGLDisplay eGLDisplay2 = eVar.f9028a;
                if (eGLDisplay2 != EGL14.EGL_NO_DISPLAY) {
                    EGL14.eglDestroySurface(eGLDisplay2, eVar.f9030c);
                    EGL14.eglDestroyContext(eVar.f9028a, eVar.f9029b);
                    EGL14.eglReleaseThread();
                    EGL14.eglTerminate(eVar.f9028a);
                }
                Surface surface2 = eVar.f9031d;
                if (surface2 != null) {
                    surface2.release();
                    eVar.f9031d = null;
                }
                eVar.f9028a = EGL14.EGL_NO_DISPLAY;
                eVar.f9029b = EGL14.EGL_NO_CONTEXT;
                eVar.f9030c = EGL14.EGL_NO_SURFACE;
                this.o = null;
            } else {
                throw null;
            }
        }
        MediaCodec mediaCodec = this.k;
        if (mediaCodec != null) {
            if (this.q) {
                if (this.s) {
                    mediaCodec.stop();
                } else {
                    try {
                        mediaCodec.stop();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Log.e("VideoTrackTranscoder", "skip decoder stop for no first frame render, maybe 4kx3k?");
                    }
                }
            }
            this.k.release();
            this.k = null;
        }
        MediaCodec mediaCodec2 = this.l;
        if (mediaCodec2 != null) {
            if (this.r) {
                mediaCodec2.stop();
            }
            this.l.release();
            this.l = null;
        }
        d dVar = this.y;
        if (dVar != null) {
            dVar.b();
            this.y = null;
        }
        this.f9092c = null;
    }
}
