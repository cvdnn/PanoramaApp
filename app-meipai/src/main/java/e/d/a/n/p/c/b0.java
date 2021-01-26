package e.d.a.n.p.c;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder */
public class b0<T> implements j<T, Bitmap> {

    /* renamed from: d reason: collision with root package name */
    public static final e.d.a.n.g<Long> f7661d = new e.d.a.n.g<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new a());

    /* renamed from: e reason: collision with root package name */
    public static final e.d.a.n.g<Integer> f7662e = new e.d.a.n.g<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new b());

    /* renamed from: f reason: collision with root package name */
    public static final e f7663f = new e();

    /* renamed from: a reason: collision with root package name */
    public final f<T> f7664a;

    /* renamed from: b reason: collision with root package name */
    public final e.d.a.n.n.c0.d f7665b;

    /* renamed from: c reason: collision with root package name */
    public final e f7666c;

    /* compiled from: VideoDecoder */
    public class a implements e.d.a.n.g.b<Long> {

        /* renamed from: a reason: collision with root package name */
        public final ByteBuffer f7667a = ByteBuffer.allocate(8);

        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f7667a) {
                this.f7667a.position(0);
                messageDigest.update(this.f7667a.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder */
    public class b implements e.d.a.n.g.b<Integer> {

        /* renamed from: a reason: collision with root package name */
        public final ByteBuffer f7668a = ByteBuffer.allocate(4);

        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num != null) {
                messageDigest.update(bArr);
                synchronized (this.f7668a) {
                    this.f7668a.position(0);
                    messageDigest.update(this.f7668a.putInt(num.intValue()).array());
                }
            }
        }
    }

    /* compiled from: VideoDecoder */
    public static final class c implements f<AssetFileDescriptor> {
        public /* synthetic */ c(a aVar) {
        }

        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            AssetFileDescriptor assetFileDescriptor = (AssetFileDescriptor) obj;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* compiled from: VideoDecoder */
    public static final class d implements f<ByteBuffer> {
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            mediaMetadataRetriever.setDataSource(new c0(this, (ByteBuffer) obj));
        }
    }

    /* compiled from: VideoDecoder */
    public static class e {
    }

    /* compiled from: VideoDecoder */
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* compiled from: VideoDecoder */
    public static final class g implements f<ParcelFileDescriptor> {
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
            mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
        }
    }

    public b0(e.d.a.n.n.c0.d dVar, f<T> fVar) {
        e eVar = f7663f;
        this.f7665b = dVar;
        this.f7664a = fVar;
        this.f7666c = eVar;
    }

    public w<Bitmap> a(T t, int i2, int i3, h hVar) throws IOException {
        long longValue = ((Long) hVar.a(f7661d)).longValue();
        if (longValue >= 0 || longValue == -1) {
            Integer num = (Integer) hVar.a(f7662e);
            if (num == null) {
                num = Integer.valueOf(2);
            }
            l lVar = (l) hVar.a(l.f7690f);
            if (lVar == null) {
                lVar = l.f7689e;
            }
            l lVar2 = lVar;
            if (this.f7666c != null) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    this.f7664a.a(mediaMetadataRetriever, t);
                    Bitmap a2 = a(mediaMetadataRetriever, longValue, num.intValue(), i2, i3, lVar2);
                    mediaMetadataRetriever.release();
                    return e.a(a2, this.f7665b);
                } catch (RuntimeException e2) {
                    throw new IOException(e2);
                } catch (Throwable th) {
                    mediaMetadataRetriever.release();
                    throw th;
                }
            } else {
                throw null;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
            sb.append(longValue);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public boolean a(T t, h hVar) {
        return true;
    }

    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, l lVar) {
        MediaMetadataRetriever mediaMetadataRetriever2 = mediaMetadataRetriever;
        int i5 = i3;
        int i6 = i4;
        l lVar2 = lVar;
        Bitmap bitmap = null;
        if (!(VERSION.SDK_INT < 27 || i5 == Integer.MIN_VALUE || i6 == Integer.MIN_VALUE || lVar2 == l.f7688d)) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    int i7 = parseInt2;
                    parseInt2 = parseInt;
                    parseInt = i7;
                }
                float b2 = lVar2.b(parseInt, parseInt2, i3, i4);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(((float) parseInt) * b2), Math.round(b2 * ((float) parseInt2)));
            } catch (Throwable th) {
                String str = "VideoDecoder";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Exception trying to decode frame on oreo+", th);
                }
            }
        }
        return bitmap == null ? mediaMetadataRetriever.getFrameAtTime(j2, i2) : bitmap;
    }
}
