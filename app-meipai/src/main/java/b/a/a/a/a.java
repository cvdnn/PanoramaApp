package b.a.a.a;

import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.CameraType;
import com.arashivision.insta360.basemedia.model.FileType;
import java.util.Arrays;

public class a implements g {
    public int a(boolean z) {
        return 18;
    }

    public long a() {
        return -6300000;
    }

    public AssetInfo a(String str, boolean z, int i2, int i3, int i4) {
        AssetInfo assetInfo = new AssetInfo();
        Boolean valueOf = Boolean.valueOf(true);
        assetInfo.isInsFormat = valueOf;
        assetInfo.isVideo = valueOf;
        assetInfo.captureCameraName = CameraType.AKIKO.type;
        assetInfo.offset = str;
        assetInfo.isSelfie = Boolean.valueOf(z);
        Integer valueOf2 = Integer.valueOf(5312);
        assetInfo.cropWindowSrcWidth = valueOf2;
        assetInfo.cropWindowSrcHeight = Integer.valueOf(3542);
        if (i2 == 1152 && i3 == 768 && i4 == 30) {
            assetInfo.cropWindowDstWidth = Integer.valueOf(5376);
            assetInfo.cropWindowDstHeight = Integer.valueOf(3552);
        } else {
            if (Arrays.asList(new Integer[]{Integer.valueOf(24), Integer.valueOf(25), Integer.valueOf(30)}).contains(Integer.valueOf(i4))) {
                assetInfo.cropWindowDstWidth = valueOf2;
                assetInfo.cropWindowDstHeight = Integer.valueOf(2988);
            } else {
                assetInfo.cropWindowDstWidth = Integer.valueOf(3840);
                assetInfo.cropWindowDstHeight = Integer.valueOf(2160);
            }
        }
        assetInfo.isFisheye3dFormat = valueOf;
        assetInfo.cameraLensCount = Integer.valueOf(1);
        assetInfo.cameraLensType = Integer.valueOf(35);
        return assetInfo;
    }

    public FileType b() {
        return FileType.FISH_EYE;
    }

    public int c() {
        return 4;
    }

    public /* synthetic */ boolean d() {
        return f.a(this);
    }

    public boolean e() {
        return true;
    }

    public int f() {
        return 1;
    }
}
