package e.d.a.n.m;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher */
public class o extends l<InputStream> {

    /* renamed from: d reason: collision with root package name */
    public static final UriMatcher f7264d;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f7264d = uriMatcher;
        String str = "com.android.contacts";
        uriMatcher.addURI(str, "contacts/lookup/*/#", 1);
        f7264d.addURI(str, "contacts/lookup/*", 1);
        f7264d.addURI(str, "contacts/#/photo", 2);
        f7264d.addURI(str, "contacts/#", 3);
        f7264d.addURI(str, "contacts/#/display_photo", 4);
        f7264d.addURI(str, "phone_lookup/*", 5);
    }

    public o(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(android.net.Uri r4, android.content.ContentResolver r5) throws java.io.FileNotFoundException {
        /*
            r3 = this;
            android.content.UriMatcher r0 = f7264d
            int r0 = r0.match(r4)
            r1 = 1
            if (r0 == r1) goto L_0x0019
            r2 = 3
            if (r0 == r2) goto L_0x0014
            r2 = 5
            if (r0 == r2) goto L_0x0019
            java.io.InputStream r5 = r5.openInputStream(r4)
            goto L_0x0023
        L_0x0014:
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r5, r4, r1)
            goto L_0x0023
        L_0x0019:
            android.net.Uri r0 = android.provider.ContactsContract.Contacts.lookupContact(r5, r4)
            if (r0 == 0) goto L_0x0032
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r5, r0, r1)
        L_0x0023:
            if (r5 == 0) goto L_0x0026
            return r5
        L_0x0026:
            java.io.FileNotFoundException r5 = new java.io.FileNotFoundException
            java.lang.String r0 = "InputStream is null for "
            java.lang.String r4 = e.a.a.a.a.a(r0, r4)
            r5.<init>(r4)
            throw r5
        L_0x0032:
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException
            java.lang.String r5 = "Contact cannot be found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.n.m.o.a(android.net.Uri, android.content.ContentResolver):java.lang.Object");
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
