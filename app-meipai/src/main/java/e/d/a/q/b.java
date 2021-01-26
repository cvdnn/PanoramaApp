package e.d.a.q;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ImageHeaderParserRegistry */
public final class b {

    /* renamed from: a reason: collision with root package name */
    public final List<ImageHeaderParser> f7841a = new ArrayList();

    public synchronized List<ImageHeaderParser> a() {
        return this.f7841a;
    }

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f7841a.add(imageHeaderParser);
    }
}
