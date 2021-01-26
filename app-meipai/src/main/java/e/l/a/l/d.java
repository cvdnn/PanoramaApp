package e.l.a.l;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import e.l.a.m.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Runtime */
public class d implements e.l.a.l.e.a {

    /* renamed from: b reason: collision with root package name */
    public static final a f8969b = new b();

    /* renamed from: c reason: collision with root package name */
    public static List<String> f8970c;

    /* renamed from: a reason: collision with root package name */
    public c f8971a;

    /* compiled from: Runtime */
    public interface a {
    }

    public d(c cVar) {
        this.f8971a = cVar;
    }

    public c a(String... strArr) {
        if (f8970c == null) {
            Context a2 = this.f8971a.a();
            try {
                String[] strArr2 = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 4096).requestedPermissions;
                if (strArr2 == null || strArr2.length == 0) {
                    throw new IllegalStateException("You did not register any permissions in the manifest.xml.");
                }
                ArrayList arrayList = new ArrayList(Arrays.asList(strArr2));
                f8970c = arrayList;
                if (arrayList.contains("android.permission.ADD_VOICEMAIL")) {
                    f8970c.add("com.android.voicemail.permission.ADD_VOICEMAIL");
                }
            } catch (NameNotFoundException unused) {
                throw new AssertionError("Package name cannot be found.");
            }
        }
        if (strArr.length != 0) {
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                if (f8970c.contains(str)) {
                    i2++;
                } else {
                    throw new IllegalStateException(String.format("The permission %1$s is not registered in manifest.xml", new Object[]{str}));
                }
            }
            a aVar = new a(this.f8971a);
            aVar.f8963b = strArr;
            return aVar;
        }
        throw new IllegalArgumentException("Please enter at least one permission.");
    }
}
