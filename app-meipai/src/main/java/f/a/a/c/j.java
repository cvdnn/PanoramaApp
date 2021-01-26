package f.a.a.c;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: QueuedMuxer */
public class j {

    /* renamed from: a reason: collision with root package name */
    public final p f9052a;

    /* renamed from: b reason: collision with root package name */
    public final b f9053b;

    /* renamed from: c reason: collision with root package name */
    public MediaFormat f9054c;

    /* renamed from: d reason: collision with root package name */
    public MediaFormat f9055d;

    /* renamed from: e reason: collision with root package name */
    public int f9056e;

    /* renamed from: f reason: collision with root package name */
    public int f9057f;

    /* renamed from: g reason: collision with root package name */
    public ByteBuffer f9058g;

    /* renamed from: h reason: collision with root package name */
    public final List<c> f9059h = new ArrayList();

    /* renamed from: i reason: collision with root package name */
    public boolean f9060i;

    /* renamed from: j reason: collision with root package name */
    public boolean f9061j;

    /* compiled from: QueuedMuxer */
    public static /* synthetic */ class a {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f9062a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                f.a.a.c.j$d[] r0 = f.a.a.c.j.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9062a = r0
                r1 = 1
                f.a.a.c.j$d r2 = f.a.a.c.j.d.VIDEO     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f9062a     // Catch:{ NoSuchFieldError -> 0x0016 }
                f.a.a.c.j$d r2 = f.a.a.c.j.d.AUDIO     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f.a.a.c.j.a.<clinit>():void");
        }
    }

    /* compiled from: QueuedMuxer */
    public interface b {
        void onDetermineOutputFormat();
    }

    /* compiled from: QueuedMuxer */
    public static class c {

        /* renamed from: a reason: collision with root package name */
        public final d f9063a;

        /* renamed from: b reason: collision with root package name */
        public final int f9064b;

        /* renamed from: c reason: collision with root package name */
        public final long f9065c;

        /* renamed from: d reason: collision with root package name */
        public final int f9066d;

        public /* synthetic */ c(d dVar, int i2, BufferInfo bufferInfo, a aVar) {
            this.f9063a = dVar;
            this.f9064b = i2;
            this.f9065c = bufferInfo.presentationTimeUs;
            this.f9066d = bufferInfo.flags;
        }
    }

    /* compiled from: QueuedMuxer */
    public enum d {
        VIDEO,
        AUDIO
    }

    public j(p pVar, b bVar) {
        this.f9052a = pVar;
        this.f9053b = bVar;
    }

    public void a(d dVar, MediaFormat mediaFormat) {
        int ordinal = dVar.ordinal();
        if (ordinal == 0) {
            this.f9054c = mediaFormat;
        } else if (ordinal == 1) {
            this.f9055d = mediaFormat;
        } else {
            throw new AssertionError();
        }
        StringBuilder a2 = e.a.a.a.a.a(" onSetOutputFormat mNoAudio ");
        a2.append(this.f9061j);
        String str = "QueuedMuxer";
        Log.i(str, a2.toString());
        String str2 = " bytes to muxer.";
        String str3 = " samples / ";
        String str4 = "Output format determined, writing ";
        String str5 = "Added video track #";
        String str6 = " to muxer";
        String str7 = "mime";
        String str8 = " with ";
        int i2 = 0;
        if (this.f9061j) {
            if (this.f9054c != null) {
                this.f9053b.onDetermineOutputFormat();
                this.f9056e = this.f9052a.a(this.f9054c);
                StringBuilder a3 = e.a.a.a.a.a(str5);
                a3.append(this.f9056e);
                a3.append(str8);
                a3.append(this.f9054c.getString(str7));
                a3.append(str6);
                Log.v(str, a3.toString());
                p pVar = this.f9052a;
                if (pVar != null) {
                    pVar.a(f.a.a.c.p.a.TRANSCODE_INIT);
                    pVar.f9110a.start();
                    pVar.f9111b = f.a.a.c.p.a.TRANSCODE_START;
                    this.f9060i = true;
                    if (this.f9058g == null) {
                        this.f9058g = ByteBuffer.allocate(0);
                    }
                    this.f9058g.flip();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str4);
                    sb.append(this.f9059h.size());
                    sb.append(str3);
                    sb.append(this.f9058g.limit());
                    sb.append(str2);
                    Log.v(str, sb.toString());
                    BufferInfo bufferInfo = new BufferInfo();
                    for (c cVar : this.f9059h) {
                        bufferInfo.set(i2, cVar.f9064b, cVar.f9065c, cVar.f9066d);
                        this.f9052a.a(a(cVar.f9063a), this.f9058g, bufferInfo);
                        i2 += cVar.f9064b;
                    }
                    this.f9059h.clear();
                    this.f9058g = null;
                    return;
                }
                throw null;
            }
        } else if (this.f9054c != null && this.f9055d != null) {
            this.f9053b.onDetermineOutputFormat();
            this.f9056e = this.f9052a.a(this.f9054c);
            StringBuilder a4 = e.a.a.a.a.a(str5);
            a4.append(this.f9056e);
            a4.append(str8);
            a4.append(this.f9054c.getString(str7));
            a4.append(str6);
            Log.v(str, a4.toString());
            this.f9057f = this.f9052a.a(this.f9055d);
            StringBuilder a5 = e.a.a.a.a.a("Added audio track #");
            a5.append(this.f9057f);
            a5.append(str8);
            a5.append(this.f9055d.getString(str7));
            a5.append(str6);
            Log.v(str, a5.toString());
            p pVar2 = this.f9052a;
            if (pVar2 != null) {
                pVar2.a(f.a.a.c.p.a.TRANSCODE_INIT);
                pVar2.f9110a.start();
                pVar2.f9111b = f.a.a.c.p.a.TRANSCODE_START;
                this.f9060i = true;
                if (this.f9058g == null) {
                    this.f9058g = ByteBuffer.allocate(0);
                }
                this.f9058g.flip();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(this.f9059h.size());
                sb2.append(str3);
                sb2.append(this.f9058g.limit());
                sb2.append(str2);
                Log.v(str, sb2.toString());
                BufferInfo bufferInfo2 = new BufferInfo();
                for (c cVar2 : this.f9059h) {
                    bufferInfo2.set(i2, cVar2.f9064b, cVar2.f9065c, cVar2.f9066d);
                    this.f9052a.a(a(cVar2.f9063a), this.f9058g, bufferInfo2);
                    i2 += cVar2.f9064b;
                }
                this.f9059h.clear();
                this.f9058g = null;
                return;
            }
            throw null;
        }
    }

    public void a(d dVar, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.f9060i) {
            this.f9052a.a(a(dVar), byteBuffer, bufferInfo);
            return;
        }
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        byteBuffer.position(bufferInfo.offset);
        if (this.f9058g == null) {
            this.f9058g = ByteBuffer.allocateDirect(67108864).order(ByteOrder.nativeOrder());
        }
        this.f9058g.put(byteBuffer);
        this.f9059h.add(new c(dVar, bufferInfo.size, bufferInfo, null));
    }

    public final int a(d dVar) {
        int ordinal = dVar.ordinal();
        if (ordinal == 0) {
            return this.f9056e;
        }
        if (ordinal == 1) {
            return this.f9057f;
        }
        throw new AssertionError();
    }
}
