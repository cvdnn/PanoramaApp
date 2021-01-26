package e.d.a.n.p.e;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import e.a.a.a.a;
import e.d.a.n.h;
import e.d.a.n.j;
import e.d.a.n.n.w;
import java.io.IOException;
import java.util.List;

/* compiled from: ResourceDrawableDecoder */
public class d implements j<Uri, Drawable> {

    /* renamed from: a reason: collision with root package name */
    public final Context f7746a;

    public d(Context context) {
        this.f7746a = context.getApplicationContext();
    }

    public /* bridge */ /* synthetic */ w a(Object obj, int i2, int i3, h hVar) throws IOException {
        return a((Uri) obj);
    }

    public boolean a(Object obj, h hVar) throws IOException {
        return ((Uri) obj).getScheme().equals("android.resource");
    }

    public w a(Uri uri) {
        Context context;
        int i2;
        String authority = uri.getAuthority();
        if (authority.equals(this.f7746a.getPackageName())) {
            context = this.f7746a;
        } else {
            try {
                context = this.f7746a.createPackageContext(authority, 0);
            } catch (NameNotFoundException e2) {
                if (authority.contains(this.f7746a.getPackageName())) {
                    context = this.f7746a;
                } else {
                    throw new IllegalArgumentException(a.a("Failed to obtain context or unrecognized Uri format for: ", uri), e2);
                }
            }
        }
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List pathSegments2 = uri.getPathSegments();
            String str = (String) pathSegments2.get(0);
            String str2 = (String) pathSegments2.get(1);
            i2 = context.getResources().getIdentifier(str2, str, uri.getAuthority());
            if (i2 == 0) {
                i2 = Resources.getSystem().getIdentifier(str2, str, SapiDeviceInfo.f3010c);
            }
            if (i2 == 0) {
                throw new IllegalArgumentException(a.a("Failed to find resource id for: ", uri));
            }
        } else {
            String str3 = "Unrecognized Uri format: ";
            if (pathSegments.size() == 1) {
                try {
                    i2 = Integer.parseInt((String) uri.getPathSegments().get(0));
                } catch (NumberFormatException e3) {
                    throw new IllegalArgumentException(a.a(str3, uri), e3);
                }
            } else {
                throw new IllegalArgumentException(a.a(str3, uri));
            }
        }
        Drawable a2 = a.a(this.f7746a, context, i2, null);
        if (a2 != null) {
            return new c(a2);
        }
        return null;
    }
}
