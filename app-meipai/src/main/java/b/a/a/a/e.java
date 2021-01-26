package b.a.a.a;

import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.CameraType;
import com.arashivision.insta360.basemedia.model.FileType;

public class e implements g {
    public int a(boolean z) {
        return z ? 19 : 17;
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
        assetInfo.isSelfie = Boolean.valueOf(z);
        assetInfo.captureCameraName = CameraType.AKIKO.type;
        Integer valueOf2 = Integer.valueOf(3040);
        assetInfo.cropWindowSrcWidth = valueOf2;
        assetInfo.cropWindowSrcHeight = valueOf2;
        Integer valueOf3 = Integer.valueOf(2880);
        assetInfo.cropWindowDstWidth = valueOf3;
        assetInfo.cropWindowDstHeight = valueOf3;
        assetInfo.cameraLensCount = Integer.valueOf(2);
        assetInfo.cameraLensType = Integer.valueOf(33);
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
