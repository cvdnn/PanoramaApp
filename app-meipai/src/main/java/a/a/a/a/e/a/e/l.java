package a.a.a.a.e.a.e;

import a.a.a.a.a.d.b;
import a.a.a.a.b.a;
import a.a.a.a.e.a.e.k.f;
import a.a.a.a.e.a.e.k.g;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.DynamicStitchType;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.FilterInfo;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.BeautyParam;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.FilterName;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.ImageBlendFilterParam;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.LutParam;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.Filters.LutStyleParam;
import com.arashivision.arvbmg.previewer.ClipRenderInfo.LogoInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.gyro.BMGSequenceStabilizer;
import com.arashivision.arvbmg.render.gyro.BMGStabilizer;
import com.arashivision.graphicpath.render.rendermodel.RenderModelType;
import com.arashivision.graphicpath.render.source.AssetInfo;
import com.arashivision.graphicpath.render.source.Source;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.ui.player.image.IImageParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class l {

    /* renamed from: c reason: collision with root package name */
    public static final MediaLogger f532c = MediaLogger.getLogger(l.class);

    /* renamed from: a reason: collision with root package name */
    public f f533a;

    /* renamed from: b reason: collision with root package name */
    public g f534b;

    public l(f fVar, g gVar) {
        this.f533a = fVar;
        this.f534b = gVar;
    }

    public int a() {
        if (this.f534b == null) {
            throw new RuntimeException("fit mode doesn't support image currently");
        } else if (this.f533a.getFileType() == FileType.UNPANORAMA) {
            int fitMode = this.f534b.getFitMode();
            if (fitMode != 1) {
                return fitMode != 2 ? 3 : 2;
            }
            return 1;
        } else {
            return this.f534b.getFitMode() == 1 ? 11 : 10;
        }
    }

    public int a(boolean z) {
        int i2 = 0;
        if (z) {
            g gVar = this.f534b;
            if (!(gVar == null || gVar.getLrvUrlsForPlay() == null || this.f534b.getLrvUrlsForPlay().length == 0)) {
                if (this.f534b.getLrvUrlsForPlay().length == 2) {
                    i2 = 2;
                }
                return i2;
            }
        }
        if (this.f533a.isDualStream()) {
            i2 = 2;
        }
        return i2;
    }

    public DynamicStitchType a(boolean z, boolean z2, boolean z3, int i2, BMGStabilizer bMGStabilizer, boolean z4) {
        boolean z5 = z && this.f533a.getFileType() == FileType.VR360 && (bMGStabilizer instanceof BMGSequenceStabilizer) && (i2 == 11 || i2 == 2);
        boolean b2 = a.b();
        if (!b2) {
            f532c.e("device do not support dynamic stitch, force it to off");
        }
        return (!z5 || !b2) ? (z2 || z3) ? DynamicStitchType.TEMPLATE : DynamicStitchType.OFF : z4 ? DynamicStitchType.VIDEO : DynamicStitchType.IMAGE;
    }

    public RenderModelType a(int i2) {
        if (i2 == 0) {
            if (this.f533a.getFileType() != FileType.UNPANORAMA) {
                f fVar = this.f533a;
                if (!(fVar instanceof IImageParams) || !((IImageParams) fVar).isPowerPanoMode()) {
                    i2 = 1;
                }
            }
            i2 = 10;
        }
        AssetInfo assetInfo = this.f533a.getAssetInfo();
        if (this.f533a.isInstaMedia() && assetInfo != null) {
            return Source.resolveRenderModelType(assetInfo, new RenderModelType(i2));
        }
        if (assetInfo == null) {
            f532c.e("getRenderModelType, but assetInfo is null, maybe camera is disconnected?");
        }
        return i2 != 1 ? i2 != 10 ? new RenderModelType(i2, this.f533a.getOffsetForPlay()) : new RenderModelType(20) : new RenderModelType(3);
    }

    public boolean a(FileType fileType, int i2) {
        return fileType == FileType.VR360 && (i2 == 2 || i2 == 11);
    }

    public FilterInfo[] a(boolean z, BlendImageInfo blendImageInfo) {
        a.a.a.a.a.d.a aVar;
        FilterInfo filterInfo;
        FilterInfo filterInfo2;
        FilterInfo filterInfo3;
        FilterInfo filterInfo4;
        ArrayList arrayList = new ArrayList();
        g gVar = this.f534b;
        FilterInfo filterInfo5 = null;
        if (gVar == null) {
            f532c.w("getLutFilter, but mVideoRenderOptionParams is null, maybe a image?");
            aVar = null;
        } else {
            aVar = gVar.getLutFilter();
        }
        if (aVar == null || aVar == b.a()) {
            filterInfo = null;
        } else {
            filterInfo = new FilterInfo();
            filterInfo.setFilterName("lut_filter");
            HashMap hashMap = new HashMap();
            hashMap.put(LutParam.LUT_DATA, null);
            hashMap.put(LutParam.LUT_DIMENSION, null);
            filterInfo.setFilterParams(hashMap);
        }
        if (filterInfo != null) {
            arrayList.add(filterInfo);
        }
        a.a.a.a.a.g.a styleFilter = this.f533a.getStyleFilter();
        if (styleFilter == null || styleFilter == a.a.a.a.a.g.b.b()) {
            filterInfo2 = null;
        } else {
            filterInfo2 = new FilterInfo();
            filterInfo2.setFilterName(FilterName.LUT_STYLE_FILTER);
            HashMap hashMap2 = new HashMap();
            if (styleFilter.f389a == null) {
                styleFilter.a();
            }
            hashMap2.put(LutStyleParam.LUT_STYLE_DATA, styleFilter.f389a);
            if (styleFilter.f390b == null) {
                styleFilter.a();
            }
            hashMap2.put(LutStyleParam.LUT_STYLE_DIMENSION, styleFilter.f390b);
            hashMap2.put(LutStyleParam.LUT_STYLE_INTENSITY, Float.valueOf(this.f533a.getStyleFilterIntensity()));
            filterInfo2.setFilterParams(hashMap2);
        }
        if (filterInfo2 != null) {
            arrayList.add(filterInfo2);
        }
        int beautyFilterLevel = this.f533a.getBeautyFilterLevel();
        if (beautyFilterLevel != 0) {
            filterInfo3 = new FilterInfo();
            filterInfo3.setFilterName(FilterName.BEAUTIFY);
            HashMap hashMap3 = new HashMap();
            hashMap3.put(BeautyParam.LEVEL, Integer.valueOf(beautyFilterLevel));
            filterInfo3.setFilterParams(hashMap3);
        } else {
            filterInfo3 = null;
        }
        if (filterInfo3 != null) {
            arrayList.add(filterInfo3);
        }
        g gVar2 = this.f534b;
        float contrastIntensity = gVar2 != null ? gVar2.getContrastIntensity() : 0.0f;
        if (contrastIntensity != 0.0f) {
            filterInfo4 = new FilterInfo();
            filterInfo4.setFilterName(FilterName.COLOR_CONTROL_FILTER);
            HashMap hashMap4 = new HashMap();
            hashMap4.put("contrast", Float.valueOf(contrastIntensity));
            filterInfo4.setFilterParams(hashMap4);
        } else {
            filterInfo4 = null;
        }
        if (filterInfo4 != null) {
            arrayList.add(filterInfo4);
        }
        if (z) {
            g gVar3 = this.f534b;
            float sharpnessIntensity = gVar3 != null ? gVar3.getSharpnessIntensity() : 0.0f;
            if (sharpnessIntensity != 0.0f) {
                filterInfo5 = new FilterInfo();
                filterInfo5.setFilterName(FilterName.SHARPNESS_FILTER);
                HashMap hashMap5 = new HashMap();
                hashMap5.put("sharpness", Float.valueOf(sharpnessIntensity));
                filterInfo5.setFilterParams(hashMap5);
            }
            if (filterInfo5 != null) {
                arrayList.add(filterInfo5);
            }
        }
        if (blendImageInfo != null) {
            FilterInfo filterInfo6 = new FilterInfo();
            filterInfo6.setFilterName(FilterName.IMAGE_BLEND_FILTER);
            HashMap hashMap6 = new HashMap();
            hashMap6.put(ImageBlendFilterParam.IMAGEBLEND_INFO, blendImageInfo);
            filterInfo6.setFilterParams(hashMap6);
            arrayList.add(filterInfo6);
        }
        FilterInfo[] filterInfoArr = (FilterInfo[]) arrayList.toArray(new FilterInfo[0]);
        MediaLogger mediaLogger = f532c;
        StringBuilder a2 = e.a.a.a.a.a("filterInfoList");
        a2.append(Arrays.toString(filterInfoArr));
        mediaLogger.i(a2.toString());
        return filterInfoArr;
    }

    public int b() {
        g gVar = this.f534b;
        if (gVar == null || gVar.getLrvUrlsForPlay() == null || this.f534b.getLrvUrlsForPlay().length == 0) {
            return -1;
        }
        int i2 = 2;
        if (this.f534b.getLrvUrlsForPlay().length != 2) {
            i2 = 0;
        }
        return i2;
    }

    public LogoInfo b(boolean z) {
        if (z) {
            return this.f533a.getLogoInfo();
        }
        return null;
    }
}
