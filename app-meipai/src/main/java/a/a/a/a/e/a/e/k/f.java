package a.a.a.a.e.a.e.k;

import a.a.a.a.a.g.a;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.insta360.basemedia.model.FileType;

public interface f {
    boolean cancelStabilizer();

    AssetInfo getAssetInfo();

    int getBeautyFilterLevel();

    FileType getFileType();

    LogoInfo getLogoInfo();

    String getOffsetForPlay();

    BMGStabilizer getStabilizer();

    a getStyleFilter();

    float getStyleFilterIntensity();

    boolean isDualStream();

    boolean isInstaMedia();

    boolean isLogoEnabled();

    void setBeautyFilterLevel(int i2);

    void setLogoEnabled(boolean z);

    void setOffsetForPlay(String str);

    void setStyleFilter(a aVar);

    void setStyleFilterIntensity(float f2);
}
