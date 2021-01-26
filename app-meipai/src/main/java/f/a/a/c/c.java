package f.a.a.c;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import f.a.a.b.a;
import f.a.a.c.j.d;
import java.io.IOException;

/* compiled from: AudioTrackTranscoder */
public class c extends m {
    public static final d w = d.AUDIO;

    /* renamed from: h reason: collision with root package name */
    public d f9017h;

    /* renamed from: i reason: collision with root package name */
    public final j f9018i;

    /* renamed from: j reason: collision with root package name */
    public final MediaFormat f9019j;
    public final MediaFormat k;
    public final BufferInfo l = new BufferInfo();
    public MediaCodec m;
    public MediaCodec n;
    public MediaFormat o;
    public a p;
    public a q;
    public boolean r;
    public boolean s;
    public boolean t;
    public a u;
    public boolean v;

    public c(MediaExtractor mediaExtractor, int i2, MediaFormat mediaFormat, j jVar, o oVar) {
        this.k = mediaFormat;
        this.f9018i = jVar;
        if (oVar.v) {
            this.f9017h = new k(mediaExtractor, i2, "remoteAudioExtractor", 8192);
        } else {
            this.f9017h = new g(mediaExtractor, i2, "localAudioExtractor", 8192);
        }
        this.f9017h.a(oVar.f9099c, oVar.f9100d);
        this.f9017h.a();
        this.f9019j = this.f9017h.f9022c;
        if (oVar.s) {
            f.a.a.a aVar = new f.a.a.a(oVar);
            this.f9092c = aVar;
            int i3 = oVar.o;
            int i4 = oVar.l;
            aVar.k = i3;
            aVar.l = i4;
            aVar.f9049h = (double) (i4 / i3);
            StringBuilder a2 = e.a.a.a.a.a(" frameSize_ ");
            a2.append(aVar.k);
            a2.append(" sampleRate_ ");
            a2.append(aVar.l);
            Log.i("AudioPtsRebuild", a2.toString());
            aVar.b();
        }
        this.v = oVar.t;
    }

    public MediaFormat a() {
        return this.f9019j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x02e1 A[LOOP:2: B:78:0x01b8->B:106:0x02e1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0379 A[LOOP:3: B:108:0x02ee->B:130:0x0379, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x00c0 A[EDGE_INSN: B:135:0x00c0->B:33:0x00c0 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02ec A[EDGE_INSN: B:142:0x02ec->B:107:0x02ec ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x037c A[EDGE_INSN: B:143:0x037c->B:131:0x037c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd A[LOOP:0: B:1:0x0005->B:32:0x00bd, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(long r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r2 = 1
            r3 = r1
        L_0x0005:
            long r4 = r0.f9096g
            int r4 = (r4 > r22 ? 1 : (r4 == r22 ? 0 : -1))
            r5 = -2
            r6 = -3
            java.lang.String r7 = "AudioTrackTranscoder"
            r8 = -1
            r9 = 2
            r10 = 0
            if (r4 >= 0) goto L_0x00c0
            boolean r4 = r0.f9094e
            if (r4 == 0) goto L_0x0019
            goto L_0x0093
        L_0x0019:
            android.media.MediaCodec r4 = r0.n
            android.media.MediaCodec$BufferInfo r12 = r0.l
            int r4 = r4.dequeueOutputBuffer(r12, r10)
            if (r4 == r6) goto L_0x00b1
            if (r4 == r5) goto L_0x0095
            if (r4 == r8) goto L_0x0093
            android.media.MediaFormat r12 = r0.o
            if (r12 == 0) goto L_0x008b
            android.media.MediaCodec$BufferInfo r12 = r0.l
            int r12 = r12.flags
            r13 = r12 & 4
            if (r13 == 0) goto L_0x0048
            java.lang.String r12 = " audio eos"
            android.util.Log.i(r7, r12)
            r0.f9094e = r2
            android.media.MediaCodec$BufferInfo r13 = r0.l
            r14 = 0
            r15 = 0
            r16 = 0
            int r12 = r13.flags
            r18 = r12
            r13.set(r14, r15, r16, r18)
            goto L_0x0084
        L_0x0048:
            r12 = r12 & 2
            if (r12 == 0) goto L_0x0052
            android.media.MediaCodec r12 = r0.n
            r12.releaseOutputBuffer(r4, r1)
            goto L_0x00ba
        L_0x0052:
            f.a.a.c.j r12 = r0.f9018i
            f.a.a.c.j$d r13 = w
            f.a.a.b.a r14 = r0.q
            android.media.MediaCodec r14 = r14.f8998a
            java.nio.ByteBuffer r14 = r14.getOutputBuffer(r4)
            android.media.MediaCodec$BufferInfo r15 = r0.l
            r12.a(r13, r14, r15)
            android.media.MediaCodec$BufferInfo r12 = r0.l
            long r12 = r12.presentationTimeUs
            r0.f9096g = r12
            boolean r12 = r0.f9093d
            if (r12 == 0) goto L_0x0084
            java.lang.String r12 = " audio mWrittenPresentationTimeUs "
            java.lang.StringBuilder r12 = e.a.a.a.a.a(r12)
            long r13 = r0.f9096g
            r12.append(r13)
            java.lang.String r13 = " size "
            r12.append(r13)
            android.media.MediaCodec$BufferInfo r13 = r0.l
            int r13 = r13.size
            e.a.a.a.a.c(r12, r13, r7)
        L_0x0084:
            android.media.MediaCodec r12 = r0.n
            r12.releaseOutputBuffer(r4, r1)
            r4 = r9
            goto L_0x00bb
        L_0x008b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Could not determine actual output format."
            r1.<init>(r2)
            throw r1
        L_0x0093:
            r4 = r1
            goto L_0x00bb
        L_0x0095:
            android.media.MediaFormat r4 = r0.o
            if (r4 != 0) goto L_0x00a9
            android.media.MediaCodec r4 = r0.n
            android.media.MediaFormat r4 = r4.getOutputFormat()
            r0.o = r4
            f.a.a.c.j r12 = r0.f9018i
            f.a.a.c.j$d r13 = w
            r12.a(r13, r4)
            goto L_0x00ba
        L_0x00a9:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Audio output format changed twice."
            r1.<init>(r2)
            throw r1
        L_0x00b1:
            f.a.a.b.a r4 = new f.a.a.b.a
            android.media.MediaCodec r12 = r0.n
            r4.<init>(r12)
            r0.q = r4
        L_0x00ba:
            r4 = r2
        L_0x00bb:
            if (r4 == 0) goto L_0x00c0
            r3 = r2
            goto L_0x0005
        L_0x00c0:
            long r12 = r0.f9096g
            int r4 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x037c
        L_0x00c6:
            boolean r4 = r0.f9095f
            if (r4 == 0) goto L_0x00cb
            goto L_0x0105
        L_0x00cb:
            android.media.MediaCodec r4 = r0.m
            android.media.MediaCodec$BufferInfo r12 = r0.l
            int r4 = r4.dequeueOutputBuffer(r12, r10)
            if (r4 == r6) goto L_0x01a5
            if (r4 == r5) goto L_0x0108
            if (r4 == r8) goto L_0x0105
            android.media.MediaCodec$BufferInfo r12 = r0.l
            int r13 = r12.flags
            r13 = r13 & 4
            if (r13 == 0) goto L_0x00e9
            r0.f9095f = r2
            f.a.a.c.a r4 = r0.u
            r4.a(r8, r10)
            goto L_0x0102
        L_0x00e9:
            int r13 = r12.size
            if (r13 <= 0) goto L_0x00f5
            f.a.a.c.a r13 = r0.u
            long r14 = r12.presentationTimeUs
            r13.a(r4, r14)
            goto L_0x0102
        L_0x00f5:
            java.lang.String r4 = "bad audio buffer size "
            java.lang.StringBuilder r4 = e.a.a.a.a.a(r4)
            android.media.MediaCodec$BufferInfo r12 = r0.l
            int r12 = r12.size
            e.a.a.a.a.b(r4, r12, r7)
        L_0x0102:
            r4 = r9
            goto L_0x01b3
        L_0x0105:
            r4 = r1
            goto L_0x01b3
        L_0x0108:
            f.a.a.c.a r12 = r0.u
            android.media.MediaCodec r13 = r0.m
            android.media.MediaFormat r13 = r13.getOutputFormat()
            r12.m = r13
            java.lang.String r13 = " mActualDecodedFormat "
            java.lang.StringBuilder r13 = e.a.a.a.a.a(r13)
            android.media.MediaFormat r14 = r12.m
            java.lang.String r14 = r14.toString()
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r14 = "AudioChannel"
            android.util.Log.i(r14, r13)
            android.media.MediaFormat r13 = r12.m
            java.lang.String r14 = "sample-rate"
            int r13 = r13.getInteger(r14)
            r12.f9006f = r13
            android.media.MediaFormat r15 = r12.f9005e
            int r14 = r15.getInteger(r14)
            if (r13 != r14) goto L_0x019d
            android.media.MediaFormat r13 = r12.m
            java.lang.String r14 = "channel-count"
            int r13 = r13.getInteger(r14)
            r12.f9007g = r13
            android.media.MediaFormat r13 = r12.f9005e
            int r13 = r13.getInteger(r14)
            r12.f9008h = r13
            int r13 = r12.f9007g
            java.lang.String r14 = ") not supported."
            if (r13 == r2) goto L_0x0169
            if (r13 != r9) goto L_0x0157
            goto L_0x0169
        L_0x0157:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Input channel count ("
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            int r3 = r12.f9007g
            java.lang.String r2 = e.a.a.a.a.a(r2, r3, r14)
            r1.<init>(r2)
            throw r1
        L_0x0169:
            int r13 = r12.f9008h
            if (r13 == r2) goto L_0x0182
            if (r13 != r9) goto L_0x0170
            goto L_0x0182
        L_0x0170:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Output channel count ("
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            int r3 = r12.f9008h
            java.lang.String r2 = e.a.a.a.a.a(r2, r3, r14)
            r1.<init>(r2)
            throw r1
        L_0x0182:
            int r13 = r12.f9007g
            int r14 = r12.f9008h
            if (r13 <= r14) goto L_0x018d
            f.a.a.c.b r13 = f.a.a.c.b.f9014a
            r12.f9009i = r13
            goto L_0x0198
        L_0x018d:
            if (r13 >= r14) goto L_0x0194
            f.a.a.c.b r13 = f.a.a.c.b.f9015b
            r12.f9009i = r13
            goto L_0x0198
        L_0x0194:
            f.a.a.c.b r13 = f.a.a.c.b.f9016c
            r12.f9009i = r13
        L_0x0198:
            f.a.a.c.a$b r12 = r12.l
            r12.f9012b = r10
            goto L_0x01a5
        L_0x019d:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.String r2 = "Audio sample rate conversion not supported yet."
            r1.<init>(r2)
            throw r1
        L_0x01a5:
            if (r4 != r5) goto L_0x01ad
            java.lang.String r4 = "audio output format change"
            android.util.Log.i(r7, r4)
            goto L_0x01b2
        L_0x01ad:
            java.lang.String r4 = "audio output buffer change"
            android.util.Log.i(r7, r4)
        L_0x01b2:
            r4 = r2
        L_0x01b3:
            if (r4 == 0) goto L_0x01b6
            r3 = r2
        L_0x01b6:
            if (r4 == r2) goto L_0x00c6
        L_0x01b8:
            f.a.a.c.a r4 = r0.u
            f.a.a.c.a$b r5 = r4.l
            java.nio.ShortBuffer r5 = r5.f9013c
            if (r5 == 0) goto L_0x01c7
            boolean r5 = r5.hasRemaining()
            if (r5 == 0) goto L_0x01c7
            goto L_0x01c8
        L_0x01c7:
            r2 = r1
        L_0x01c8:
            java.util.Queue<f.a.a.c.a$b> r5 = r4.f9002b
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x01d3
            if (r2 != 0) goto L_0x01d3
            goto L_0x01db
        L_0x01d3:
            android.media.MediaCodec r5 = r4.f9004d
            int r13 = r5.dequeueInputBuffer(r10)
            if (r13 >= 0) goto L_0x01e0
        L_0x01db:
            r2 = r1
            r23 = r3
            goto L_0x02df
        L_0x01e0:
            f.a.a.b.a r1 = r4.k
            android.media.MediaCodec r1 = r1.f8998a
            java.nio.ByteBuffer r1 = r1.getInputBuffer(r13)
            java.nio.ShortBuffer r1 = r1.asShortBuffer()
            r5 = 1000000(0xf4240, double:4.940656E-318)
            if (r2 == 0) goto L_0x024a
            f.a.a.c.a$b r2 = r4.l
            java.nio.ShortBuffer r2 = r2.f9013c
            int r8 = r2.limit()
            int r9 = r2.remaining()
            f.a.a.c.a$b r10 = r4.l
            long r10 = r10.f9012b
            int r12 = r2.position()
            int r14 = r4.f9006f
            int r15 = r4.f9008h
            r22 = r13
            long r12 = (long) r12
            r23 = r3
            r19 = r4
            long r3 = (long) r14
            long r3 = r3 * r5
            long r12 = r12 / r3
            long r3 = (long) r15
            long r12 = r12 / r3
            long r16 = r12 + r10
            r1.clear()
            int r3 = r1.capacity()
            r2.limit(r3)
            r1.put(r2)
            int r3 = r1.capacity()
            if (r9 < r3) goto L_0x0233
            java.nio.Buffer r2 = r2.clear()
            r3 = 0
            r2.limit(r3)
            goto L_0x0236
        L_0x0233:
            r2.limit(r8)
        L_0x0236:
            r2 = r19
            android.media.MediaCodec r12 = r2.f9004d
            r14 = 0
            int r1 = r1.position()
            int r15 = r1 * 2
            r18 = 0
            r13 = r22
            r12.queueInputBuffer(r13, r14, r15, r16, r18)
            r1 = 1
            goto L_0x026a
        L_0x024a:
            r23 = r3
            r2 = r4
            r22 = r13
            java.util.Queue<f.a.a.c.a$b> r3 = r2.f9002b
            java.lang.Object r3 = r3.poll()
            f.a.a.c.a$b r3 = (f.a.a.c.a.b) r3
            int r4 = r3.f9011a
            r8 = -1
            if (r4 != r8) goto L_0x026e
            android.media.MediaCodec r12 = r2.f9004d
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 4
            r13 = r22
            r12.queueInputBuffer(r13, r14, r15, r16, r18)
            r1 = 0
        L_0x026a:
            r2 = 0
            r3 = 2
            r9 = r3
            goto L_0x02df
        L_0x026e:
            java.nio.ShortBuffer r4 = r3.f9013c
            f.a.a.c.a$b r8 = r2.l
            java.nio.ShortBuffer r8 = r8.f9013c
            r1.clear()
            r4.clear()
            int r9 = r4.remaining()
            int r10 = r1.remaining()
            if (r9 <= r10) goto L_0x02b5
            int r9 = r1.capacity()
            r4.limit(r9)
            f.a.a.c.b r9 = r2.f9009i
            r9.a(r4, r1)
            int r9 = r4.capacity()
            r4.limit(r9)
            int r9 = r4.position()
            int r10 = r2.f9006f
            int r11 = r2.f9007g
            long r12 = (long) r9
            long r9 = (long) r10
            long r9 = r9 * r5
            long r12 = r12 / r9
            long r5 = (long) r11
            long r12 = r12 / r5
            f.a.a.c.b r5 = r2.f9009i
            r5.a(r4, r8)
            r8.flip()
            f.a.a.c.a$b r4 = r2.l
            long r5 = r3.f9012b
            long r5 = r5 + r12
            r4.f9012b = r5
            goto L_0x02ba
        L_0x02b5:
            f.a.a.c.b r5 = r2.f9009i
            r5.a(r4, r1)
        L_0x02ba:
            long r4 = r3.f9012b
            android.media.MediaCodec r12 = r2.f9004d
            r14 = 0
            int r1 = r1.position()
            r6 = 2
            int r15 = r1 * 2
            r18 = 0
            r13 = r22
            r16 = r4
            r12.queueInputBuffer(r13, r14, r15, r16, r18)
            android.media.MediaCodec r1 = r2.f9003c
            int r4 = r3.f9011a
            r5 = 0
            r1.releaseOutputBuffer(r4, r5)
            java.util.Queue<f.a.a.c.a$b> r1 = r2.f9001a
            r1.add(r3)
            r1 = 1
            r2 = r5
            r9 = r6
        L_0x02df:
            if (r1 == 0) goto L_0x02ec
            r1 = 1
            r3 = 1
            r10 = 0
            r20 = r2
            r2 = r1
            r1 = r20
            goto L_0x01b8
        L_0x02ec:
            r3 = r23
        L_0x02ee:
            boolean r1 = r0.r
            if (r1 == 0) goto L_0x02f7
            r1 = 1
        L_0x02f3:
            r4 = r1
            r1 = r2
            goto L_0x0377
        L_0x02f7:
            android.media.MediaCodec r1 = r0.m
            r4 = 0
            int r11 = r1.dequeueInputBuffer(r4)
            if (r11 >= 0) goto L_0x0303
            r1 = r2
            goto L_0x0365
        L_0x0303:
            f.a.a.b.a r1 = r0.p
            android.media.MediaCodec r1 = r1.f8998a
            java.nio.ByteBuffer r1 = r1.getInputBuffer(r11)
        L_0x030b:
            f.a.a.c.d r4 = r0.f9017h
            f.a.a.c.q r4 = r4.a(r1)
            if (r4 == 0) goto L_0x0367
            long r5 = r4.f9119c
            boolean r5 = r0.a(r5)
            if (r5 == 0) goto L_0x030b
            int r5 = r4.f9117a
            if (r5 > 0) goto L_0x032a
            java.lang.String r5 = " audio queueEndInputBuffer sampleSize "
            java.lang.StringBuilder r5 = e.a.a.a.a.a(r5)
            int r6 = r4.f9117a
            e.a.a.a.a.b(r5, r6, r7)
        L_0x032a:
            boolean r5 = r0.f9093d
            if (r5 == 0) goto L_0x0354
            java.lang.String r5 = "queue audio sampleSize "
            java.lang.StringBuilder r5 = e.a.a.a.a.a(r5)
            int r6 = r4.f9117a
            r5.append(r6)
            java.lang.String r6 = " timeUs "
            r5.append(r6)
            long r12 = r4.f9119c
            r5.append(r12)
            java.lang.String r6 = " isKeyFrame "
            r5.append(r6)
            boolean r6 = r4.f9118b
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.i(r7, r5)
        L_0x0354:
            android.media.MediaCodec r10 = r0.m
            r12 = 0
            int r13 = r1.remaining()
            long r14 = r4.f9119c
            boolean r1 = r4.f9118b
            r16 = r1
            r10.queueInputBuffer(r11, r12, r13, r14, r16)
            r1 = r9
        L_0x0365:
            r4 = 1
            goto L_0x0377
        L_0x0367:
            r1 = 1
            r0.r = r1
            android.media.MediaCodec r10 = r0.m
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 4
            r10.queueInputBuffer(r11, r12, r13, r14, r16)
            goto L_0x02f3
        L_0x0377:
            if (r1 == 0) goto L_0x037c
            r3 = r4
            goto L_0x02ee
        L_0x037c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a.c.c.b(long):boolean");
    }

    public void c() {
        String str = "mime";
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType(this.k.getString(str));
            this.n = createEncoderByType;
            createEncoderByType.configure(this.k, null, null, 1);
            this.n.start();
            this.t = true;
            this.q = new a(this.n);
            try {
                this.m = MediaCodec.createDecoderByType(this.f9019j.getString(str));
                String str2 = "AudioTrackTranscoder";
                if (this.v) {
                    Log.i(str2, "set input adts format");
                    this.f9019j.setInteger("is-adts", 1);
                }
                this.m.configure(this.f9019j, null, null, 0);
                this.m.start();
                this.s = true;
                this.p = new a(this.m);
                this.u = new a(this.m, this.n, this.k);
                StringBuilder a2 = e.a.a.a.a.a(" audio input format ");
                a2.append(this.f9019j.toString());
                Log.i(str2, a2.toString());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        } catch (IOException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public void b() {
        MediaCodec mediaCodec = this.m;
        if (mediaCodec != null) {
            if (this.s) {
                mediaCodec.stop();
            }
            this.m.release();
            this.m = null;
        }
        MediaCodec mediaCodec2 = this.n;
        if (mediaCodec2 != null) {
            if (this.t) {
                mediaCodec2.stop();
            }
            this.n.release();
            this.n = null;
        }
        d dVar = this.f9017h;
        if (dVar != null) {
            dVar.b();
            this.f9017h = null;
        }
        this.f9092c = null;
    }
}
