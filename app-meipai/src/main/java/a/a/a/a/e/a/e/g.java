package a.a.a.a.e.a.e;

import a.a.a.a.e.a.e.k.j;
import a.a.a.a.e.a.g.f;
import android.text.TextUtils;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.FilterName;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.WaterMarkParam;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import java.io.File;
import java.util.HashMap;

public class g {

    /* renamed from: b reason: collision with root package name */
    public static final MediaLogger f519b = MediaLogger.getLogger(g.class);

    /* renamed from: a reason: collision with root package name */
    public j f520a;

    public g(j jVar) {
        this.f520a = jVar;
    }

    public FilterInfo a(int i2, int i3, boolean z) {
        if (!a(z)) {
            return null;
        }
        String watermarkResourcesPath = this.f520a.getWatermarkResourcesPath();
        if (TextUtils.isEmpty(watermarkResourcesPath) || !new File(watermarkResourcesPath).exists()) {
            return null;
        }
        FilterInfo filterInfo = new FilterInfo();
        filterInfo.setFilterName(FilterName.WATERMARK_FILTER);
        HashMap hashMap = new HashMap();
        ImageAsset imageAsset = new ImageAsset(watermarkResourcesPath);
        imageAsset.parse(256);
        hashMap.put(WaterMarkParam.WATERMARK_IMAGEASSET, imageAsset);
        hashMap.put(WaterMarkParam.WATERMARK_RECT, a(i2, i3, imageAsset.getWidth(), imageAsset.getHeight(), false));
        filterInfo.setFilterParams(hashMap);
        return filterInfo;
    }

    public boolean a(boolean z) {
        return z && this.f520a.isWatermarkEnabled();
    }

    public float[] a(int i2, int i3, int i4, int i5, boolean z) {
        f watermarkRectCalculator = this.f520a.getWatermarkRectCalculator();
        float[] fArr = {200.0f, 100.0f, 0.0f, 0.0f};
        if (watermarkRectCalculator != null) {
            fArr = watermarkRectCalculator.a(i2, i3, i4, i5);
        } else {
            f519b.e("watermarkRectCalculator is null!");
        }
        int round = Math.round((fArr[0] / 2.0f) * 2.0f);
        int round2 = Math.round((fArr[1] / 2.0f) * 2.0f);
        int round3 = Math.round((fArr[2] / 2.0f) * 2.0f);
        int round4 = Math.round((fArr[3] / 2.0f) * 2.0f);
        float[] fArr2 = new float[4];
        fArr2[0] = (float) ((i2 - round) - round3);
        fArr2[1] = z ? (float) ((i3 - round2) - round4) : (float) round4;
        fArr2[2] = (float) round;
        fArr2[3] = (float) round2;
        return fArr2;
    }
}
