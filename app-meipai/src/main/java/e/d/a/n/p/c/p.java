package e.d.a.n.p.c;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import d.m.a.a;
import e.d.a.n.n.c0.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ExifInterfaceImageHeaderParser */
public final class p implements ImageHeaderParser {
    public ImageType a(InputStream inputStream) {
        return ImageType.UNKNOWN;
    }

    public ImageType a(ByteBuffer byteBuffer) {
        return ImageType.UNKNOWN;
    }

    public int a(InputStream inputStream, b bVar) throws IOException {
        int a2 = new a(inputStream).a("Orientation", 1);
        if (a2 == 0) {
            return -1;
        }
        return a2;
    }
}
