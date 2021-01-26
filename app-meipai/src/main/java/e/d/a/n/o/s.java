package e.d.a.n.o;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import e.d.a.n.h;
import java.io.InputStream;

/* compiled from: ResourceLoader */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a reason: collision with root package name */
    public final n<Uri, Data> f7603a;

    /* renamed from: b reason: collision with root package name */
    public final Resources f7604b;

    /* compiled from: ResourceLoader */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        public final Resources f7605a;

        public a(Resources resources) {
            this.f7605a = resources;
        }

        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f7605a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a reason: collision with root package name */
        public final Resources f7606a;

        public b(Resources resources) {
            this.f7606a = resources;
        }

        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f7606a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a reason: collision with root package name */
        public final Resources f7607a;

        public c(Resources resources) {
            this.f7607a = resources;
        }

        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f7607a, rVar.a(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a reason: collision with root package name */
        public final Resources f7608a;

        public d(Resources resources) {
            this.f7608a = resources;
        }

        public n<Integer, Uri> a(r rVar) {
            return new s(this.f7608a, v.f7611a);
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f7604b = resources;
        this.f7603a = nVar;
    }

    public e.d.a.n.o.n.a a(Object obj, int i2, int i3, h hVar) {
        Object obj2;
        Integer num = (Integer) obj;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.f7604b.getResourcePackageName(num.intValue()));
            sb.append('/');
            sb.append(this.f7604b.getResourceTypeName(num.intValue()));
            sb.append('/');
            sb.append(this.f7604b.getResourceEntryName(num.intValue()));
            obj2 = Uri.parse(sb.toString());
        } catch (NotFoundException e2) {
            String str = "ResourceLoader";
            if (Log.isLoggable(str, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Received invalid resource id: ");
                sb2.append(num);
                Log.w(str, sb2.toString(), e2);
            }
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return this.f7603a.a(obj2, i2, i3, hVar);
    }

    public boolean a(Object obj) {
        Integer num = (Integer) obj;
        return true;
    }
}
