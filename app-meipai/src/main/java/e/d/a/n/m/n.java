package e.d.a.n.m;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher */
public class n extends b<InputStream> {
    public n(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    public void a(Object obj) throws IOException {
        ((InputStream) obj).close();
    }

    public Object a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }
}
