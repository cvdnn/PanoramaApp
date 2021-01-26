package b.a.a.a;

import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.FileType;

public class b implements g {
    public int a(boolean z) {
        return 4;
    }

    public long a() {
        return 0;
    }

    public AssetInfo a(String str, boolean z, int i2, int i3, int i4) {
        AssetInfo assetInfo = new AssetInfo();
        Boolean valueOf = Boolean.valueOf(true);
        assetInfo.isInsFormat = valueOf;
        assetInfo.isVideo = valueOf;
        assetInfo.offset = str;
        assetInfo.cameraLensCount = Integer.valueOf(2);
        assetInfo.cameraLensType = Integer.valueOf(16);
        return assetInfo;
    }

    public FileType b() {
        return FileType.VR360;
    }

    public int c() {
        return 0;
    }

    public /* synthetic */ boolean d() {
        return f.a(this);
    }

    public boolean e() {
        return false;
    }

    public int f() {
        return 0;
    }
}
