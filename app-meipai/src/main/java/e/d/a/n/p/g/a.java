package e.d.a.n.p.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import e.d.a.m.c;
import e.d.a.m.d;
import e.d.a.m.e;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import e.d.a.t.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder */
public class a implements j<ByteBuffer, c> {

    /* renamed from: f reason: collision with root package name */
    public static final C0096a f7748f = new C0096a();

    /* renamed from: g reason: collision with root package name */
    public static final b f7749g = new b();

    /* renamed from: a reason: collision with root package name */
    public final Context f7750a;

    /* renamed from: b reason: collision with root package name */
    public final List<ImageHeaderParser> f7751b;

    /* renamed from: c reason: collision with root package name */
    public final b f7752c;

    /* renamed from: d reason: collision with root package name */
    public final C0096a f7753d;

    /* renamed from: e reason: collision with root package name */
    public final b f7754e;

    /* renamed from: e.d.a.n.p.g.a$a reason: collision with other inner class name */
    /* compiled from: ByteBufferGifDecoder */
    public static class C0096a {
    }

    /* compiled from: ByteBufferGifDecoder */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        public final Queue<d> f7755a = e.d.a.t.j.a(0);

        public synchronized void a(d dVar) {
            dVar.f7198b = null;
            dVar.f7199c = null;
            this.f7755a.offer(dVar);
        }

        public synchronized d a(ByteBuffer byteBuffer) {
            d dVar;
            dVar = (d) this.f7755a.poll();
            if (dVar == null) {
                dVar = new d();
            }
            dVar.f7198b = null;
            Arrays.fill(dVar.f7197a, 0);
            dVar.f7199c = new c();
            dVar.f7200d = 0;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            dVar.f7198b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            dVar.f7198b.order(ByteOrder.LITTLE_ENDIAN);
            return dVar;
        }
    }

    public a(Context context, List<ImageHeaderParser> list, e.d.a.n.n.c0.d dVar, e.d.a.n.n.c0.b bVar) {
        b bVar2 = f7749g;
        C0096a aVar = f7748f;
        this.f7750a = context.getApplicationContext();
        this.f7751b = list;
        this.f7753d = aVar;
        this.f7754e = new b(dVar, bVar);
        this.f7752c = bVar2;
    }

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        d a2 = this.f7752c.a(byteBuffer);
        try {
            e a3 = a(byteBuffer, i2, i3, a2, hVar);
            return a3;
        } finally {
            this.f7752c.a(a2);
        }
    }

    public boolean a(Object obj, h hVar) throws IOException {
        ImageType imageType;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (((Boolean) hVar.a(i.f7787b)).booleanValue()) {
            return false;
        }
        List<ImageHeaderParser> list = this.f7751b;
        if (byteBuffer != null) {
            int size = list.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    imageType = ImageType.UNKNOWN;
                    break;
                }
                ImageType a2 = ((ImageHeaderParser) list.get(i2)).a(byteBuffer);
                if (a2 != ImageType.UNKNOWN) {
                    imageType = a2;
                    break;
                }
                i2++;
            }
        } else {
            imageType = ImageType.UNKNOWN;
        }
        if (imageType == ImageType.GIF) {
            return true;
        }
        return false;
    }

    public static int a(c cVar, int i2, int i3) {
        int i4;
        int min = Math.min(cVar.f7193g / i3, cVar.f7192f / i2);
        if (min == 0) {
            i4 = 0;
        } else {
            i4 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i4);
        String str = "BufferGifDecoder";
        if (Log.isLoggable(str, 2) && max > 1) {
            String str2 = Config.EVENT_HEAT_X;
            StringBuilder a2 = e.a.a.a.a.a("Downsampling GIF, sampleSize: ", max, ", target dimens: [", i2, str2);
            a2.append(i3);
            a2.append("], actual dimens: [");
            a2.append(cVar.f7192f);
            a2.append(str2);
            a2.append(cVar.f7193g);
            a2.append("]");
            Log.v(str, a2.toString());
        }
        return max;
    }

    public final e a(ByteBuffer byteBuffer, int i2, int i3, d dVar, h hVar) {
        Bitmap.Config config;
        String str = "Decoded GIF from stream in ";
        String str2 = "BufferGifDecoder";
        long a2 = f.a();
        try {
            c b2 = dVar.b();
            if (b2.f7189c > 0) {
                if (b2.f7188b == 0) {
                    if (hVar.a(i.f7786a) == e.d.a.n.b.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    int a3 = a(b2, i2, i3);
                    C0096a aVar = this.f7753d;
                    b bVar = this.f7754e;
                    if (aVar != null) {
                        e eVar = new e(bVar, b2, byteBuffer, a3);
                        eVar.a(config);
                        eVar.b();
                        Bitmap a4 = eVar.a();
                        if (a4 == null) {
                            if (Log.isLoggable(str2, 2)) {
                                StringBuilder a5 = e.a.a.a.a.a(str);
                                a5.append(f.a(a2));
                                Log.v(str2, a5.toString());
                            }
                            return null;
                        }
                        c cVar = new c(this.f7750a, eVar, (e.d.a.n.p.b) e.d.a.n.p.b.f7655b, i2, i3, a4);
                        e eVar2 = new e(cVar);
                        if (Log.isLoggable(str2, 2)) {
                            StringBuilder a6 = e.a.a.a.a.a(str);
                            a6.append(f.a(a2));
                            Log.v(str2, a6.toString());
                        }
                        return eVar2;
                    }
                    throw null;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(str2, 2)) {
                StringBuilder a7 = e.a.a.a.a.a(str);
                a7.append(f.a(a2));
                Log.v(str2, a7.toString());
            }
        }
    }
}
