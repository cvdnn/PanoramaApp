package e.d.a.n.p.g;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import e.c.f.n.n;
import e.d.a.n.h;
import e.d.a.n.n.c0.b;
import e.d.a.n.n.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder */
public class j implements e.d.a.n.j<InputStream, c> {

    /* renamed from: a reason: collision with root package name */
    public final List<ImageHeaderParser> f7788a;

    /* renamed from: b reason: collision with root package name */
    public final e.d.a.n.j<ByteBuffer, c> f7789b;

    /* renamed from: c reason: collision with root package name */
    public final b f7790c;

    public j(List<ImageHeaderParser> list, e.d.a.n.j<ByteBuffer, c> jVar, b bVar) {
        this.f7788a = list;
        this.f7789b = jVar;
        this.f7790c = bVar;
    }

    public w a(Object obj, int i2, int i3, h hVar) throws IOException {
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            String str = "StreamGifDecoder";
            if (Log.isLoggable(str, 5)) {
                Log.w(str, "Error reading data from stream", e2);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.f7789b.a(ByteBuffer.wrap(bArr), i2, i3, hVar);
    }

    public boolean a(Object obj, h hVar) throws IOException {
        return !((Boolean) hVar.a(i.f7787b)).booleanValue() && n.b(this.f7788a, (InputStream) obj, this.f7790c) == ImageType.GIF;
    }
}
