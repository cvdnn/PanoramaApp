package e.d.a.n.o;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import e.d.a.n.m.d;
import e.d.a.n.m.h;
import e.d.a.n.m.n;
import java.io.InputStream;

/* compiled from: AssetUriLoader */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: a reason: collision with root package name */
    public final AssetManager f7536a;

    /* renamed from: b reason: collision with root package name */
    public final C0088a<Data> f7537b;

    /* renamed from: e.d.a.n.o.a$a reason: collision with other inner class name */
    /* compiled from: AssetUriLoader */
    public interface C0088a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader */
    public static class b implements o<Uri, ParcelFileDescriptor>, C0088a<ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        public final AssetManager f7538a;

        public b(AssetManager assetManager) {
            this.f7538a = assetManager;
        }

        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f7538a, this);
        }

        public d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader */
    public static class c implements o<Uri, InputStream>, C0088a<InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final AssetManager f7539a;

        public c(AssetManager assetManager) {
            this.f7539a = assetManager;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f7539a, this);
        }

        public d<InputStream> a(AssetManager assetManager, String str) {
            return new n(assetManager, str);
        }
    }

    public a(AssetManager assetManager, C0088a<Data> aVar) {
        this.f7536a = assetManager;
        this.f7537b = aVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, e.d.a.n.h hVar) {
        Uri uri = (Uri) obj;
        return new e.d.a.n.o.n.a(new e.d.a.s.b(uri), this.f7537b.a(this.f7536a, uri.toString().substring(22)));
    }

    public boolean a(Object obj) {
        Uri uri = (Uri) obj;
        if (!SdkConfigOptions.KEY_SO_FILE.equals(uri.getScheme()) || uri.getPathSegments().isEmpty()) {
            return false;
        }
        if ("android_asset".equals(uri.getPathSegments().get(0))) {
            return true;
        }
        return false;
    }
}
