package e.d.a.n.o;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import e.d.a.n.h;
import e.d.a.n.m.i;
import e.d.a.n.m.o;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UriLoader */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: b reason: collision with root package name */
    public static final Set<String> f7614b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{SdkConfigOptions.KEY_SO_FILE, "android.resource", Config.LAUNCH_CONTENT})));

    /* renamed from: a reason: collision with root package name */
    public final c<Data> f7615a;

    /* compiled from: UriLoader */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        public final ContentResolver f7616a;

        public a(ContentResolver contentResolver) {
            this.f7616a = contentResolver;
        }

        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        public e.d.a.n.m.d<AssetFileDescriptor> a(Uri uri) {
            return new e.d.a.n.m.a(this.f7616a, uri);
        }
    }

    /* compiled from: UriLoader */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        public final ContentResolver f7617a;

        public b(ContentResolver contentResolver) {
            this.f7617a = contentResolver;
        }

        public e.d.a.n.m.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.f7617a, uri);
        }

        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }
    }

    /* compiled from: UriLoader */
    public interface c<Data> {
        e.d.a.n.m.d<Data> a(Uri uri);
    }

    /* compiled from: UriLoader */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final ContentResolver f7618a;

        public d(ContentResolver contentResolver) {
            this.f7618a = contentResolver;
        }

        public e.d.a.n.m.d<InputStream> a(Uri uri) {
            return new o(this.f7618a, uri);
        }

        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f7615a = cVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        Uri uri = (Uri) obj;
        return new e.d.a.n.o.n.a(new e.d.a.s.b(uri), this.f7615a.a(uri));
    }

    public boolean a(Object obj) {
        return f7614b.contains(((Uri) obj).getScheme());
    }
}
