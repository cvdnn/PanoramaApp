package e.d.a.n.m;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: AssetFileDescriptorLocalUriFetcher */
public final class a extends l<AssetFileDescriptor> {
    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public void a(Object obj) throws IOException {
        ((AssetFileDescriptor) obj).close();
    }

    public Object a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        throw new FileNotFoundException(e.a.a.a.a.a("FileDescriptor is null for: ", uri));
    }

    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }
}
