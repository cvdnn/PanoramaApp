package e.d.a.m;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import e.d.a.m.a.C0079a;
import e.d.a.n.n.c0.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* compiled from: StandardGifDecoder */
public class e implements a {

    /* renamed from: a reason: collision with root package name */
    public int[] f7201a;

    /* renamed from: b reason: collision with root package name */
    public final int[] f7202b = new int[256];

    /* renamed from: c reason: collision with root package name */
    public final C0079a f7203c;

    /* renamed from: d reason: collision with root package name */
    public ByteBuffer f7204d;

    /* renamed from: e reason: collision with root package name */
    public byte[] f7205e;

    /* renamed from: f reason: collision with root package name */
    public short[] f7206f;

    /* renamed from: g reason: collision with root package name */
    public byte[] f7207g;

    /* renamed from: h reason: collision with root package name */
    public byte[] f7208h;

    /* renamed from: i reason: collision with root package name */
    public byte[] f7209i;

    /* renamed from: j reason: collision with root package name */
    public int[] f7210j;
    public int k;
    public c l;
    public Bitmap m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Boolean s;
    public Config t = Config.ARGB_8888;

    public e(C0079a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this.f7203c = aVar;
        this.l = new c();
        a(cVar, byteBuffer, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f1, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap a() {
        /*
            r8 = this;
            monitor-enter(r8)
            e.d.a.m.c r0 = r8.l     // Catch:{ all -> 0x00f2 }
            int r0 = r0.f7189c     // Catch:{ all -> 0x00f2 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.k     // Catch:{ all -> 0x00f2 }
            if (r0 >= 0) goto L_0x003b
        L_0x000d:
            java.lang.String r0 = "e"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "e"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r3.<init>()     // Catch:{ all -> 0x00f2 }
            java.lang.String r4 = "Unable to decode frame, frameCount="
            r3.append(r4)     // Catch:{ all -> 0x00f2 }
            e.d.a.m.c r4 = r8.l     // Catch:{ all -> 0x00f2 }
            int r4 = r4.f7189c     // Catch:{ all -> 0x00f2 }
            r3.append(r4)     // Catch:{ all -> 0x00f2 }
            java.lang.String r4 = ", framePointer="
            r3.append(r4)     // Catch:{ all -> 0x00f2 }
            int r4 = r8.k     // Catch:{ all -> 0x00f2 }
            r3.append(r4)     // Catch:{ all -> 0x00f2 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f2 }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00f2 }
        L_0x0039:
            r8.o = r2     // Catch:{ all -> 0x00f2 }
        L_0x003b:
            int r0 = r8.o     // Catch:{ all -> 0x00f2 }
            r3 = 0
            if (r0 == r2) goto L_0x00d0
            int r0 = r8.o     // Catch:{ all -> 0x00f2 }
            r4 = 2
            if (r0 != r4) goto L_0x0047
            goto L_0x00d0
        L_0x0047:
            r0 = 0
            r8.o = r0     // Catch:{ all -> 0x00f2 }
            byte[] r5 = r8.f7205e     // Catch:{ all -> 0x00f2 }
            if (r5 != 0) goto L_0x005a
            e.d.a.m.a$a r5 = r8.f7203c     // Catch:{ all -> 0x00f2 }
            r6 = 255(0xff, float:3.57E-43)
            e.d.a.n.p.g.b r5 = (e.d.a.n.p.g.b) r5
            byte[] r5 = r5.a(r6)     // Catch:{ all -> 0x00f2 }
            r8.f7205e = r5     // Catch:{ all -> 0x00f2 }
        L_0x005a:
            e.d.a.m.c r5 = r8.l     // Catch:{ all -> 0x00f2 }
            java.util.List<e.d.a.m.b> r5 = r5.f7191e     // Catch:{ all -> 0x00f2 }
            int r6 = r8.k     // Catch:{ all -> 0x00f2 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00f2 }
            e.d.a.m.b r5 = (e.d.a.m.b) r5     // Catch:{ all -> 0x00f2 }
            int r6 = r8.k     // Catch:{ all -> 0x00f2 }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0076
            e.d.a.m.c r7 = r8.l     // Catch:{ all -> 0x00f2 }
            java.util.List<e.d.a.m.b> r7 = r7.f7191e     // Catch:{ all -> 0x00f2 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00f2 }
            e.d.a.m.b r6 = (e.d.a.m.b) r6     // Catch:{ all -> 0x00f2 }
            goto L_0x0077
        L_0x0076:
            r6 = r3
        L_0x0077:
            int[] r7 = r5.k     // Catch:{ all -> 0x00f2 }
            if (r7 == 0) goto L_0x007e
            int[] r7 = r5.k     // Catch:{ all -> 0x00f2 }
            goto L_0x0082
        L_0x007e:
            e.d.a.m.c r7 = r8.l     // Catch:{ all -> 0x00f2 }
            int[] r7 = r7.f7187a     // Catch:{ all -> 0x00f2 }
        L_0x0082:
            r8.f7201a = r7     // Catch:{ all -> 0x00f2 }
            if (r7 != 0) goto L_0x00aa
            java.lang.String r0 = "e"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x00a6
            java.lang.String r0 = "e"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r1.<init>()     // Catch:{ all -> 0x00f2 }
            java.lang.String r4 = "No valid color table found for frame #"
            r1.append(r4)     // Catch:{ all -> 0x00f2 }
            int r4 = r8.k     // Catch:{ all -> 0x00f2 }
            r1.append(r4)     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f2 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00f2 }
        L_0x00a6:
            r8.o = r2     // Catch:{ all -> 0x00f2 }
            monitor-exit(r8)
            return r3
        L_0x00aa:
            boolean r1 = r5.f7182f     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x00ca
            int[] r1 = r8.f7202b     // Catch:{ all -> 0x00f2 }
            int r3 = r7.length     // Catch:{ all -> 0x00f2 }
            java.lang.System.arraycopy(r7, r0, r1, r0, r3)     // Catch:{ all -> 0x00f2 }
            int[] r1 = r8.f7202b     // Catch:{ all -> 0x00f2 }
            r8.f7201a = r1     // Catch:{ all -> 0x00f2 }
            int r3 = r5.f7184h     // Catch:{ all -> 0x00f2 }
            r1[r3] = r0     // Catch:{ all -> 0x00f2 }
            int r0 = r5.f7183g     // Catch:{ all -> 0x00f2 }
            if (r0 != r4) goto L_0x00ca
            int r0 = r8.k     // Catch:{ all -> 0x00f2 }
            if (r0 != 0) goto L_0x00ca
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x00f2 }
            r8.s = r0     // Catch:{ all -> 0x00f2 }
        L_0x00ca:
            android.graphics.Bitmap r0 = r8.a(r5, r6)     // Catch:{ all -> 0x00f2 }
            monitor-exit(r8)
            return r0
        L_0x00d0:
            java.lang.String r0 = "e"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00f2 }
            if (r0 == 0) goto L_0x00f0
            java.lang.String r0 = "e"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f2 }
            r1.<init>()     // Catch:{ all -> 0x00f2 }
            java.lang.String r2 = "Unable to decode frame, status="
            r1.append(r2)     // Catch:{ all -> 0x00f2 }
            int r2 = r8.o     // Catch:{ all -> 0x00f2 }
            r1.append(r2)     // Catch:{ all -> 0x00f2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00f2 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00f2 }
        L_0x00f0:
            monitor-exit(r8)
            return r3
        L_0x00f2:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.m.e.a():android.graphics.Bitmap");
    }

    public void b() {
        this.k = (this.k + 1) % this.l.f7189c;
    }

    public int c() {
        c cVar = this.l;
        int i2 = cVar.f7189c;
        if (i2 > 0) {
            int i3 = this.k;
            if (i3 >= 0) {
                return (i3 < 0 || i3 >= i2) ? -1 : ((b) cVar.f7191e.get(i3)).f7185i;
            }
        }
        return 0;
    }

    public void clear() {
        this.l = null;
        byte[] bArr = this.f7209i;
        if (bArr != null) {
            b bVar = ((e.d.a.n.p.g.b) this.f7203c).f7757b;
            if (bVar != null) {
                bVar.a(bArr);
            }
        }
        int[] iArr = this.f7210j;
        if (iArr != null) {
            b bVar2 = ((e.d.a.n.p.g.b) this.f7203c).f7757b;
            if (bVar2 != null) {
                bVar2.a(iArr);
            }
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            ((e.d.a.n.p.g.b) this.f7203c).f7756a.a(bitmap);
        }
        this.m = null;
        this.f7204d = null;
        this.s = null;
        byte[] bArr2 = this.f7205e;
        if (bArr2 != null) {
            b bVar3 = ((e.d.a.n.p.g.b) this.f7203c).f7757b;
            if (bVar3 != null) {
                bVar3.a(bArr2);
            }
        }
    }

    public ByteBuffer d() {
        return this.f7204d;
    }

    public void e() {
        this.k = -1;
    }

    public int f() {
        return this.k;
    }

    public int g() {
        return (this.f7210j.length * 4) + this.f7204d.limit() + this.f7209i.length;
    }

    public int getFrameCount() {
        return this.l.f7189c;
    }

    public final Bitmap h() {
        Boolean bool = this.s;
        Config config = (bool == null || bool.booleanValue()) ? Config.ARGB_8888 : this.t;
        Bitmap b2 = ((e.d.a.n.p.g.b) this.f7203c).f7756a.b(this.r, this.q, config);
        b2.setHasAlpha(true);
        return b2;
    }

    public synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        int[] iArr;
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.o = 0;
            this.l = cVar;
            this.k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f7204d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f7204d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator it = cVar.f7191e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((b) it.next()).f7183g == 3) {
                        this.n = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.p = highestOneBit;
            this.r = cVar.f7192f / highestOneBit;
            this.q = cVar.f7193g / highestOneBit;
            this.f7209i = ((e.d.a.n.p.g.b) this.f7203c).a(cVar.f7192f * cVar.f7193g);
            int i3 = this.r * this.q;
            b bVar = ((e.d.a.n.p.g.b) this.f7203c).f7757b;
            if (bVar == null) {
                iArr = new int[i3];
            } else {
                iArr = (int[]) bVar.b(i3, int[].class);
            }
            this.f7210j = iArr;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Sample size must be >=0, not: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void a(Config config) {
        if (config == Config.ARGB_8888 || config == Config.RGB_565) {
            this.t = config;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported format: ");
        sb.append(config);
        sb.append(", must be one of ");
        sb.append(Config.ARGB_8888);
        sb.append(" or ");
        sb.append(Config.RGB_565);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r7v20 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: type inference failed for: r13v6, types: [int] */
    /* JADX WARNING: type inference failed for: r13v7, types: [int] */
    /* JADX WARNING: type inference failed for: r7v21 */
    /* JADX WARNING: type inference failed for: r7v22 */
    /* JADX WARNING: type inference failed for: r11v37 */
    /* JADX WARNING: type inference failed for: r23v8 */
    /* JADX WARNING: type inference failed for: r11v38 */
    /* JADX WARNING: type inference failed for: r11v40 */
    /* JADX WARNING: type inference failed for: r10v23 */
    /* JADX WARNING: type inference failed for: r11v48 */
    /* JADX WARNING: type inference failed for: r13v17 */
    /* JADX WARNING: type inference failed for: r7v28 */
    /* JADX WARNING: type inference failed for: r11v49 */
    /* JADX WARNING: type inference failed for: r23v10 */
    /* JADX WARNING: type inference failed for: r11v50 */
    /* JADX WARNING: type inference failed for: r11v51 */
    /* JADX WARNING: type inference failed for: r10v24 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        if (r3.f7196j == r1.f7184h) goto L_0x0047;
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r23v8
  assigns: []
  uses: []
  mth insns count: 539
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap a(e.d.a.m.b r36, e.d.a.m.b r37) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r37
            int[] r10 = r0.f7210j
            r11 = 0
            if (r2 != 0) goto L_0x001e
            android.graphics.Bitmap r3 = r0.m
            if (r3 == 0) goto L_0x0018
            e.d.a.m.a$a r4 = r0.f7203c
            e.d.a.n.p.g.b r4 = (e.d.a.n.p.g.b) r4
            e.d.a.n.n.c0.d r4 = r4.f7756a
            r4.a(r3)
        L_0x0018:
            r3 = 0
            r0.m = r3
            java.util.Arrays.fill(r10, r11)
        L_0x001e:
            r12 = 3
            if (r2 == 0) goto L_0x002c
            int r3 = r2.f7183g
            if (r3 != r12) goto L_0x002c
            android.graphics.Bitmap r3 = r0.m
            if (r3 != 0) goto L_0x002c
            java.util.Arrays.fill(r10, r11)
        L_0x002c:
            r13 = 2
            if (r2 == 0) goto L_0x007e
            int r3 = r2.f7183g
            if (r3 <= 0) goto L_0x007e
            if (r3 != r13) goto L_0x006c
            boolean r3 = r1.f7182f
            if (r3 != 0) goto L_0x0047
            e.d.a.m.c r3 = r0.l
            int r4 = r3.l
            int[] r5 = r1.k
            if (r5 == 0) goto L_0x0048
            int r3 = r3.f7196j
            int r5 = r1.f7184h
            if (r3 != r5) goto L_0x0048
        L_0x0047:
            r4 = r11
        L_0x0048:
            int r3 = r2.f7180d
            int r5 = r0.p
            int r3 = r3 / r5
            int r6 = r2.f7178b
            int r6 = r6 / r5
            int r7 = r2.f7179c
            int r7 = r7 / r5
            int r2 = r2.f7177a
            int r2 = r2 / r5
            int r5 = r0.r
            int r6 = r6 * r5
            int r6 = r6 + r2
            int r3 = r3 * r5
            int r3 = r3 + r6
        L_0x005c:
            if (r6 >= r3) goto L_0x007e
            int r2 = r6 + r7
            r5 = r6
        L_0x0061:
            if (r5 >= r2) goto L_0x0068
            r10[r5] = r4
            int r5 = r5 + 1
            goto L_0x0061
        L_0x0068:
            int r2 = r0.r
            int r6 = r6 + r2
            goto L_0x005c
        L_0x006c:
            if (r3 != r12) goto L_0x007e
            android.graphics.Bitmap r2 = r0.m
            if (r2 == 0) goto L_0x007e
            r4 = 0
            int r8 = r0.r
            r6 = 0
            r7 = 0
            int r9 = r0.q
            r3 = r10
            r5 = r8
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x007e:
            if (r1 == 0) goto L_0x0087
            java.nio.ByteBuffer r2 = r0.f7204d
            int r3 = r1.f7186j
            r2.position(r3)
        L_0x0087:
            if (r1 != 0) goto L_0x0090
            e.d.a.m.c r2 = r0.l
            int r3 = r2.f7192f
            int r2 = r2.f7193g
            goto L_0x0094
        L_0x0090:
            int r3 = r1.f7179c
            int r2 = r1.f7180d
        L_0x0094:
            int r3 = r3 * r2
            byte[] r2 = r0.f7209i
            if (r2 == 0) goto L_0x009c
            int r2 = r2.length
            if (r2 >= r3) goto L_0x00a6
        L_0x009c:
            e.d.a.m.a$a r2 = r0.f7203c
            e.d.a.n.p.g.b r2 = (e.d.a.n.p.g.b) r2
            byte[] r2 = r2.a(r3)
            r0.f7209i = r2
        L_0x00a6:
            byte[] r2 = r0.f7209i
            short[] r4 = r0.f7206f
            r5 = 4096(0x1000, float:5.74E-42)
            if (r4 != 0) goto L_0x00b2
            short[] r4 = new short[r5]
            r0.f7206f = r4
        L_0x00b2:
            short[] r4 = r0.f7206f
            byte[] r6 = r0.f7207g
            if (r6 != 0) goto L_0x00bc
            byte[] r6 = new byte[r5]
            r0.f7207g = r6
        L_0x00bc:
            byte[] r6 = r0.f7207g
            byte[] r7 = r0.f7208h
            if (r7 != 0) goto L_0x00c8
            r7 = 4097(0x1001, float:5.741E-42)
            byte[] r7 = new byte[r7]
            r0.f7208h = r7
        L_0x00c8:
            byte[] r7 = r0.f7208h
            java.nio.ByteBuffer r8 = r0.f7204d
            byte r8 = r8.get()
            r8 = r8 & 255(0xff, float:3.57E-43)
            r9 = 1
            int r14 = r9 << r8
            int r15 = r14 + 1
            int r16 = r14 + 2
            int r8 = r8 + r9
            int r17 = r9 << r8
            r13 = -1
            int r17 = r17 + -1
            r5 = r11
        L_0x00e0:
            if (r5 >= r14) goto L_0x00eb
            r4[r5] = r11
            byte r13 = (byte) r5
            r6[r5] = r13
            int r5 = r5 + 1
            r13 = -1
            goto L_0x00e0
        L_0x00eb:
            byte[] r5 = r0.f7205e
            r12 = r0
            r26 = r8
            r9 = r11
            r20 = r9
            r21 = r20
            r22 = r21
            r23 = r22
            r24 = r23
            r27 = r24
            r29 = r27
            r25 = r16
            r28 = r17
            r13 = -1
        L_0x0104:
            r30 = 8
            if (r9 >= r3) goto L_0x0202
            if (r21 != 0) goto L_0x0144
            java.nio.ByteBuffer r11 = r12.f7204d
            byte r11 = r11.get()
            r11 = r11 & 255(0xff, float:3.57E-43)
            if (r11 > 0) goto L_0x011d
            r31 = r8
            r32 = r9
            r34 = r10
            r33 = r13
            goto L_0x0135
        L_0x011d:
            r31 = r8
            java.nio.ByteBuffer r8 = r12.f7204d
            r32 = r9
            byte[] r9 = r12.f7205e
            r33 = r13
            int r13 = r8.remaining()
            int r13 = java.lang.Math.min(r11, r13)
            r34 = r10
            r10 = 0
            r8.get(r9, r10, r13)
        L_0x0135:
            if (r11 > 0) goto L_0x013f
            r8 = 3
            r12.o = r8
            r11 = r20
            r10 = 0
            goto L_0x0207
        L_0x013f:
            r21 = r11
            r22 = 0
            goto L_0x014c
        L_0x0144:
            r31 = r8
            r32 = r9
            r34 = r10
            r33 = r13
        L_0x014c:
            byte r8 = r5[r22]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r23
            int r24 = r24 + r8
            int r23 = r23 + 8
            r8 = 1
            int r22 = r22 + 1
            r8 = -1
            int r21 = r21 + -1
            r10 = r23
            r11 = r25
            r8 = r26
            r9 = r32
            r13 = r33
            r23 = r5
            r5 = r27
        L_0x016a:
            if (r10 < r8) goto L_0x01f0
            r25 = r12
            r12 = r24 & r28
            int r24 = r24 >> r8
            int r10 = r10 - r8
            if (r12 != r14) goto L_0x017f
            r11 = r16
            r28 = r17
            r12 = r25
            r8 = r31
            r13 = -1
            goto L_0x016a
        L_0x017f:
            if (r12 != r15) goto L_0x0194
            r27 = r5
            r26 = r8
            r5 = r23
            r12 = r25
            r8 = r31
            r23 = r10
            r25 = r11
            r10 = r34
            r11 = 0
            goto L_0x0104
        L_0x0194:
            r26 = r10
            r10 = -1
            if (r13 != r10) goto L_0x01a6
            byte r5 = r6[r12]
            r2[r20] = r5
            int r20 = r20 + 1
            int r9 = r9 + 1
            r25 = r12
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x01e8
        L_0x01a6:
            if (r12 < r11) goto L_0x01af
            byte r5 = (byte) r5
            r7[r29] = r5
            int r29 = r29 + 1
            r5 = r13
            goto L_0x01b0
        L_0x01af:
            r5 = r12
        L_0x01b0:
            if (r5 < r14) goto L_0x01bb
            byte r10 = r6[r5]
            r7[r29] = r10
            int r29 = r29 + 1
            short r5 = r4[r5]
            goto L_0x01b0
        L_0x01bb:
            byte r5 = r6[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r5
            r2[r20] = r10
        L_0x01c2:
            r19 = 1
            int r20 = r20 + 1
            int r9 = r9 + 1
            if (r29 <= 0) goto L_0x01d1
            int r29 = r29 + -1
            byte r25 = r7[r29]
            r2[r20] = r25
            goto L_0x01c2
        L_0x01d1:
            r25 = r5
            r5 = 4096(0x1000, float:5.74E-42)
            if (r11 >= r5) goto L_0x01e8
            short r13 = (short) r13
            r4[r11] = r13
            r6[r11] = r10
            int r11 = r11 + 1
            r10 = r11 & r28
            if (r10 != 0) goto L_0x01e8
            if (r11 >= r5) goto L_0x01e8
            int r8 = r8 + 1
            int r28 = r28 + r11
        L_0x01e8:
            r13 = r12
            r5 = r25
            r10 = r26
            r12 = r0
            goto L_0x016a
        L_0x01f0:
            r27 = r5
            r12 = r0
            r26 = r8
            r25 = r11
            r5 = r23
            r8 = r31
            r11 = 0
            r23 = r10
            r10 = r34
            goto L_0x0104
        L_0x0202:
            r34 = r10
            r10 = r11
            r11 = r20
        L_0x0207:
            java.util.Arrays.fill(r2, r11, r3, r10)
            boolean r2 = r1.f7181e
            if (r2 != 0) goto L_0x0281
            int r2 = r0.p
            r3 = 1
            if (r2 == r3) goto L_0x0215
            goto L_0x0281
        L_0x0215:
            int[] r2 = r0.f7210j
            int r3 = r1.f7180d
            int r4 = r1.f7178b
            int r5 = r1.f7179c
            int r6 = r1.f7177a
            int r7 = r0.k
            if (r7 != 0) goto L_0x0225
            r7 = 1
            goto L_0x0226
        L_0x0225:
            r7 = r10
        L_0x0226:
            int r8 = r0.r
            byte[] r9 = r0.f7209i
            int[] r11 = r0.f7201a
            r13 = r10
            r12 = -1
        L_0x022e:
            if (r13 >= r3) goto L_0x0263
            int r14 = r13 + r4
            int r14 = r14 * r8
            int r15 = r14 + r6
            int r10 = r15 + r5
            int r14 = r14 + r8
            if (r14 >= r10) goto L_0x023b
            r10 = r14
        L_0x023b:
            int r14 = r1.f7179c
            int r14 = r14 * r13
        L_0x023e:
            if (r15 >= r10) goto L_0x025b
            r16 = r3
            byte r3 = r9[r14]
            r17 = r4
            r4 = r3 & 255(0xff, float:3.57E-43)
            if (r4 == r12) goto L_0x0252
            r4 = r11[r4]
            if (r4 == 0) goto L_0x0251
            r2[r15] = r4
            goto L_0x0252
        L_0x0251:
            r12 = r3
        L_0x0252:
            int r14 = r14 + 1
            int r15 = r15 + 1
            r3 = r16
            r4 = r17
            goto L_0x023e
        L_0x025b:
            r16 = r3
            r17 = r4
            int r13 = r13 + 1
            r10 = 0
            goto L_0x022e
        L_0x0263:
            java.lang.Boolean r2 = r0.s
            if (r2 == 0) goto L_0x026d
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0276
        L_0x026d:
            java.lang.Boolean r2 = r0.s
            if (r2 != 0) goto L_0x0278
            if (r7 == 0) goto L_0x0278
            r2 = -1
            if (r12 == r2) goto L_0x0278
        L_0x0276:
            r11 = 1
            goto L_0x0279
        L_0x0278:
            r11 = 0
        L_0x0279:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r11)
            r0.s = r2
            goto L_0x0413
        L_0x0281:
            int[] r2 = r0.f7210j
            int r3 = r1.f7180d
            int r4 = r0.p
            int r3 = r3 / r4
            int r5 = r1.f7178b
            int r5 = r5 / r4
            int r6 = r1.f7179c
            int r6 = r6 / r4
            int r7 = r1.f7177a
            int r7 = r7 / r4
            int r4 = r0.k
            r8 = 1
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r8)
            if (r4 != 0) goto L_0x029c
            r10 = 1
            goto L_0x029d
        L_0x029c:
            r10 = 0
        L_0x029d:
            int r4 = r0.p
            int r8 = r0.r
            int r11 = r0.q
            byte[] r12 = r0.f7209i
            int[] r13 = r0.f7201a
            java.lang.Boolean r14 = r0.s
            r37 = r9
            r15 = r14
            r17 = r30
            r9 = 0
            r14 = 0
            r16 = 1
        L_0x02b2:
            if (r14 >= r3) goto L_0x03ff
            r18 = r15
            boolean r15 = r1.f7181e
            if (r15 == 0) goto L_0x02e1
            if (r9 < r3) goto L_0x02dc
            int r15 = r16 + 1
            r21 = r3
            r3 = 2
            if (r15 == r3) goto L_0x02d7
            r3 = 3
            if (r15 == r3) goto L_0x02d0
            r3 = 4
            r16 = r15
            if (r15 == r3) goto L_0x02cc
            goto L_0x02de
        L_0x02cc:
            r9 = 1
            r17 = 2
            goto L_0x02de
        L_0x02d0:
            r3 = 4
            r17 = r3
            r16 = r15
            r9 = 2
            goto L_0x02de
        L_0x02d7:
            r3 = 4
            r9 = r3
            r16 = r15
            goto L_0x02de
        L_0x02dc:
            r21 = r3
        L_0x02de:
            int r3 = r9 + r17
            goto L_0x02e5
        L_0x02e1:
            r21 = r3
            r3 = r9
            r9 = r14
        L_0x02e5:
            int r9 = r9 + r5
            r15 = 1
            if (r4 != r15) goto L_0x02eb
            r15 = 1
            goto L_0x02ec
        L_0x02eb:
            r15 = 0
        L_0x02ec:
            if (r9 >= r11) goto L_0x03df
            int r9 = r9 * r8
            int r20 = r9 + r7
            r22 = r3
            int r3 = r20 + r6
            int r9 = r9 + r8
            if (r9 >= r3) goto L_0x02f9
            r3 = r9
        L_0x02f9:
            int r9 = r14 * r4
            r23 = r5
            int r5 = r1.f7179c
            int r9 = r9 * r5
            if (r15 == 0) goto L_0x0321
            r15 = r18
            r5 = r20
        L_0x0306:
            r24 = r6
            if (r5 >= r3) goto L_0x03d8
            byte r6 = r12[r9]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r13[r6]
            if (r6 == 0) goto L_0x0315
            r2[r5] = r6
            goto L_0x031b
        L_0x0315:
            if (r10 == 0) goto L_0x031b
            if (r15 != 0) goto L_0x031b
            r15 = r37
        L_0x031b:
            int r9 = r9 + r4
            int r5 = r5 + 1
            r6 = r24
            goto L_0x0306
        L_0x0321:
            r24 = r6
            int r5 = r3 - r20
            int r5 = r5 * r4
            int r5 = r5 + r9
            r15 = r18
            r6 = r20
        L_0x032b:
            if (r6 >= r3) goto L_0x03d8
            r20 = r3
            int r3 = r1.f7179c
            r29 = r7
            r31 = r8
            r7 = r9
            r18 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x0340:
            int r8 = r0.p
            int r8 = r8 + r9
            if (r7 >= r8) goto L_0x0375
            byte[] r8 = r0.f7209i
            r32 = r11
            int r11 = r8.length
            if (r7 >= r11) goto L_0x0377
            if (r7 >= r5) goto L_0x0377
            byte r8 = r8[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int[] r11 = r0.f7201a
            r8 = r11[r8]
            if (r8 == 0) goto L_0x0370
            int r11 = r8 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r18 = r18 + r11
            int r11 = r8 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r25 = r25 + r11
            int r11 = r8 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r11
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r8
            int r28 = r28 + 1
        L_0x0370:
            int r7 = r7 + 1
            r11 = r32
            goto L_0x0340
        L_0x0375:
            r32 = r11
        L_0x0377:
            int r3 = r3 + r9
            r7 = r3
        L_0x0379:
            int r8 = r0.p
            int r8 = r8 + r3
            if (r7 >= r8) goto L_0x03aa
            byte[] r8 = r0.f7209i
            int r11 = r8.length
            if (r7 >= r11) goto L_0x03aa
            if (r7 >= r5) goto L_0x03aa
            byte r8 = r8[r7]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int[] r11 = r0.f7201a
            r8 = r11[r8]
            if (r8 == 0) goto L_0x03a7
            int r11 = r8 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r18 = r18 + r11
            int r11 = r8 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r25 = r25 + r11
            int r11 = r8 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r11
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r8
            int r28 = r28 + 1
        L_0x03a7:
            int r7 = r7 + 1
            goto L_0x0379
        L_0x03aa:
            if (r28 != 0) goto L_0x03ae
            r3 = 0
            goto L_0x03c0
        L_0x03ae:
            int r18 = r18 / r28
            int r3 = r18 << 24
            int r25 = r25 / r28
            int r7 = r25 << 16
            r3 = r3 | r7
            int r26 = r26 / r28
            int r7 = r26 << 8
            r3 = r3 | r7
            int r27 = r27 / r28
            r3 = r3 | r27
        L_0x03c0:
            if (r3 == 0) goto L_0x03c5
            r2[r6] = r3
            goto L_0x03cb
        L_0x03c5:
            if (r10 == 0) goto L_0x03cb
            if (r15 != 0) goto L_0x03cb
            r15 = r37
        L_0x03cb:
            int r9 = r9 + r4
            int r6 = r6 + 1
            r3 = r20
            r7 = r29
            r8 = r31
            r11 = r32
            goto L_0x032b
        L_0x03d8:
            r29 = r7
            r31 = r8
            r32 = r11
            goto L_0x03ed
        L_0x03df:
            r22 = r3
            r23 = r5
            r24 = r6
            r29 = r7
            r31 = r8
            r32 = r11
            r15 = r18
        L_0x03ed:
            int r14 = r14 + 1
            r3 = r21
            r9 = r22
            r5 = r23
            r6 = r24
            r7 = r29
            r8 = r31
            r11 = r32
            goto L_0x02b2
        L_0x03ff:
            r18 = r15
            java.lang.Boolean r2 = r0.s
            if (r2 != 0) goto L_0x0413
            if (r18 != 0) goto L_0x0409
            r11 = 0
            goto L_0x040d
        L_0x0409:
            boolean r11 = r18.booleanValue()
        L_0x040d:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r11)
            r0.s = r2
        L_0x0413:
            boolean r2 = r0.n
            if (r2 == 0) goto L_0x0437
            int r1 = r1.f7183g
            if (r1 == 0) goto L_0x041e
            r2 = 1
            if (r1 != r2) goto L_0x0437
        L_0x041e:
            android.graphics.Bitmap r1 = r0.m
            if (r1 != 0) goto L_0x0428
            android.graphics.Bitmap r1 = r35.h()
            r0.m = r1
        L_0x0428:
            android.graphics.Bitmap r1 = r0.m
            r3 = 0
            int r7 = r0.r
            r5 = 0
            r6 = 0
            int r8 = r0.q
            r2 = r34
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x0437:
            android.graphics.Bitmap r9 = r35.h()
            r3 = 0
            int r7 = r0.r
            r5 = 0
            r6 = 0
            int r8 = r0.q
            r1 = r9
            r2 = r34
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.m.e.a(e.d.a.m.b, e.d.a.m.b):android.graphics.Bitmap");
    }
}
