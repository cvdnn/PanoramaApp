package b.a.a.a;

import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.CameraType;
import com.arashivision.insta360.basemedia.model.FileType;

public class h implements g {
    public int a(boolean z) {
        return 16;
    }

    public long a() {
        return 0;
    }

    public AssetInfo a(String str, boolean z, int i2, int i3, int i4) {
        AssetInfo assetInfo = new AssetInfo();
        Boolean valueOf = Boolean.valueOf(true);
        assetInfo.isInsFormat = valueOf;
        assetInfo.isVideo = valueOf;
        assetInfo.captureCameraName = CameraType.ONEX.type;
        assetInfo.offset = str;
        Integer valueOf2 = Integer.valueOf(2880);
        assetInfo.cropWindowDstWidth = valueOf2;
        assetInfo.cropWindowDstHeight = valueOf2;
        Integer valueOf3 = Integer.valueOf(3040);
        assetInfo.cropWindowSrcWidth = valueOf3;
        assetInfo.cropWindowSrcHeight = valueOf3;
        assetInfo.cameraLensCount = Integer.valueOf(2);
        assetInfo.cameraLensType = Integer.valueOf(19);
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
        return true;
    }

    public int f() {
        return 0;
    }
}
