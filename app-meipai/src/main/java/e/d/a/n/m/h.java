package e.d.a.n.m;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* compiled from: FileDescriptorAssetPathFetcher */
public class h extends b<ParcelFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public void a(Object obj) throws IOException {
        ((ParcelFileDescriptor) obj).close();
    }

    public Object a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }

    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }
}
