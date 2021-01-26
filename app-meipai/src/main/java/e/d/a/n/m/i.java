package e.d.a.n.m;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import e.a.a.a.a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileDescriptorLocalUriFetcher */
public class i extends l<ParcelFileDescriptor> {
    public i(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public void a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    public Object a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        throw new FileNotFoundException(a.a("FileDescriptor is null for: ", uri));
    }

    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
