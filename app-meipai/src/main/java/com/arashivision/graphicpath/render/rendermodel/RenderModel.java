package com.arashivision.graphicpath.render.rendermodel;

import com.arashivision.graphicpath.lifecycle.FreeNativeOnDeinit;
import com.arashivision.graphicpath.lifecycle.RenderLifecycle;
import com.arashivision.graphicpath.lifecycle.RenderLifecycleNativeObserverAdapter;
import com.arashivision.graphicpath.render.RenderLibsLoader;
import com.arashivision.graphicpath.render.filter.FilterObject;
import com.arashivision.graphicpath.render.rendermodel.feature.LogoFeatureState;
import com.arashivision.graphicpath.render.rendermodel.feature.StabilizerFeatureState;
import com.arashivision.graphicpath.render.rendermodel.feature.StickerFeatureState;
import com.arashivision.graphicpath.render.rendermodel.feature.StickerFeatureState.StickerSetup;
import com.arashivision.graphicpath.render.source.ImageAsset;
import com.arashivision.graphicpath.render.util.Stabilizer;
import com.arashivision.insbase.joml.Vector2f;
import com.arashivision.insbase.joml.Vector3f;
import java.util.ArrayList;
import java.util.Iterator;

public class RenderModel extends RenderLifecycleNativeObserverAdapter {
    public static final String FACING_CONTROL_FEATURE = "facing_control_feature";
    public static final String LOG_FEATURE = "logo_feature";
    public static final String SPHERE_SCENE_FEATURE = "sphere_scene_feature";
    public static final String STABILIZER_FEATURE = "stabilizer_feature";
    public static final String STICKER_FEATURE = "sticker_feature";

    static {
        RenderLibsLoader.load();
    }

    public RenderModel(long j2, RenderLifecycle renderLifecycle) {
        this(j2, "RenderModel", renderLifecycle);
    }

    private void checkFeature(String str) {
        if (!isFeatureSupport(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("current render model not support: ");
            sb.append(str);
            sb.append("(");
            sb.append(toString());
            sb.append(")");
            throw new IllegalStateException(sb.toString());
        }
    }

    private native boolean isFeatureSupport(String str);

    private boolean isFilterInList(FilterObject filterObject, ArrayList<FilterObject> arrayList) {
        if (!(filterObject == null || arrayList == null)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((FilterObject) it.next()) != filterObject) {
                    if (filterObject.hasSameNativeObject(arrayList)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private native int nativeAddSticker(float f2, float[] fArr, ImageAsset imageAsset, float f3, boolean z, int i2);

    private native void nativeEnableLogoFeature(boolean z);

    private native void nativeEnableStabilizerFeature(boolean z);

    private native void nativeFreeStickerStateCacheResult(long j2);

    private native int nativeGetCurrentDefaultFacing();

    private native void nativeGetLogoFeatureState(boolean[] zArr, float[] fArr, float[] fArr2, long[] jArr);

    private native int nativeGetNextIdFromNativeCacheResult(long j2);

    private native long nativeGetRenderModelType();

    private native long nativeGetStabilizerState(boolean[] zArr);

    private native int nativeGetStickerCountFromNativeCacheResult(long j2);

    private native long nativeGetStickerFeatureStateCacheResult();

    private native void nativeGetStickerFromNativeCacheResult(long j2, int i2, float[] fArr, float[] fArr2, long[] jArr, float[] fArr3, boolean[] zArr, int[] iArr);

    private native boolean nativeHitTest(float f2, float f3, float[] fArr, float[] fArr2, long[] jArr, float[] fArr3, boolean[] zArr, int[] iArr);

    private native void nativeRemoveSticker(int i2);

    private native void nativeSetLogoPosition(float[] fArr);

    private native void nativeSetLogoSize(float f2);

    private native void nativeSetPostFilters(Object[] objArr);

    private native void nativeSetStabilizer(Stabilizer stabilizer);

    private native boolean nativeSupportModel(RenderModelType renderModelType);

    private native void nativeUpdateDefaultFacing(int i2);

    private native void nativeUpdateLogoImage(ImageAsset imageAsset);

    private native void nativeUpdateModel(RenderModelType renderModelType);

    private native void nativeUpdateSticker(float f2, float[] fArr, ImageAsset imageAsset, float f3, boolean z, int i2);

    public void addSticker(StickerSetup stickerSetup) {
        checkFeature(STICKER_FEATURE);
        stickerSetup.setStickerId(nativeAddSticker(stickerSetup.getSize(), new float[]{stickerSetup.getPosition().x, stickerSetup.getPosition().y, stickerSetup.getPosition().z}, stickerSetup.getAsset(), stickerSetup.getRotation(), stickerSetup.isEnablePositionRoll(), stickerSetup.getStickerId()));
    }

    public void discard() {
        super.discard();
    }

    public void enableLogoFeature(boolean z) {
        checkFeature(LOG_FEATURE);
        nativeEnableLogoFeature(z);
    }

    public void enableStabilizerFeature(boolean z) {
        checkFeature(STABILIZER_FEATURE);
        nativeEnableStabilizerFeature(z);
    }

    public void free() {
        RenderLifecycle renderLifecycle = getRenderLifecycle();
        if (!isRenderInited() || renderLifecycle == null || renderLifecycle.isInsideRenderThread()) {
            super.free();
            return;
        }
        throw new IllegalStateException("free inited RenderModel outside render thread");
    }

    public int getCurrentDefaultFacing() {
        checkFeature(FACING_CONTROL_FEATURE);
        return nativeGetCurrentDefaultFacing();
    }

    public LogoFeatureState getLogoFeatureState() {
        checkFeature(LOG_FEATURE);
        boolean[] zArr = new boolean[1];
        float[] fArr = new float[1];
        float[] fArr2 = new float[3];
        long[] jArr = new long[1];
        nativeGetLogoFeatureState(zArr, fArr, fArr2, jArr);
        return new LogoFeatureState(zArr[0], fArr[0], new Vector3f(fArr2[0], fArr2[1], fArr2[2]), jArr[0] != 0 ? new ImageAsset(jArr[0]) : null);
    }

    public RenderModelType getRenderModelType() {
        return new RenderModelType(nativeGetRenderModelType());
    }

    public StabilizerFeatureState getStabilizerState() {
        checkFeature(STABILIZER_FEATURE);
        boolean[] zArr = new boolean[1];
        return new StabilizerFeatureState(Stabilizer.createStabilizerWithNativeWrap(nativeGetStabilizerState(zArr)), zArr[0]);
    }

    public StickerFeatureState getStickerFeatureState() {
        checkFeature(STICKER_FEATURE);
        StickerFeatureState stickerFeatureState = new StickerFeatureState();
        ArrayList arrayList = new ArrayList();
        stickerFeatureState.setStickers(arrayList);
        long nativeGetStickerFeatureStateCacheResult = nativeGetStickerFeatureStateCacheResult();
        stickerFeatureState.setNextId(nativeGetNextIdFromNativeCacheResult(nativeGetStickerFeatureStateCacheResult));
        long nativeGetStickerCountFromNativeCacheResult = (long) nativeGetStickerCountFromNativeCacheResult(nativeGetStickerFeatureStateCacheResult);
        int i2 = 0;
        while (((long) i2) < nativeGetStickerCountFromNativeCacheResult) {
            float[] fArr = new float[1];
            float[] fArr2 = new float[1];
            boolean[] zArr = new boolean[1];
            long[] jArr = new long[1];
            float[] fArr3 = new float[3];
            float[] fArr4 = fArr;
            int i3 = i2;
            long j2 = nativeGetStickerCountFromNativeCacheResult;
            nativeGetStickerFromNativeCacheResult(nativeGetStickerFeatureStateCacheResult, i2, fArr, fArr3, jArr, fArr2, zArr, new int[1]);
            StickerSetup stickerSetup = new StickerSetup(fArr4[0], new Vector3f(fArr3[0], fArr3[1], fArr3[2]), jArr[0] != 0 ? new ImageAsset(jArr[0]) : null, fArr2[0], zArr[0]);
            arrayList.add(stickerSetup);
            i2 = i3 + 1;
            nativeGetStickerCountFromNativeCacheResult = j2;
        }
        nativeFreeStickerStateCacheResult(nativeGetStickerFeatureStateCacheResult);
        return stickerFeatureState;
    }

    public boolean hasFacingControlFeature() {
        return isFeatureSupport(FACING_CONTROL_FEATURE);
    }

    public boolean hasLogoFeature() {
        return isFeatureSupport(LOG_FEATURE);
    }

    public boolean hasStabilizerFeature() {
        return isFeatureSupport(STABILIZER_FEATURE);
    }

    public boolean hasStickerFeature() {
        return isFeatureSupport(STICKER_FEATURE);
    }

    public StickerSetup hitTest(Vector2f vector2f) {
        Vector2f vector2f2 = vector2f;
        checkFeature(STICKER_FEATURE);
        float[] fArr = new float[1];
        float[] fArr2 = new float[3];
        long[] jArr = new long[1];
        float[] fArr3 = new float[1];
        boolean[] zArr = new boolean[1];
        boolean[] zArr2 = zArr;
        ImageAsset imageAsset = null;
        if (!nativeHitTest(vector2f2.x, vector2f2.y, fArr, fArr2, jArr, fArr3, zArr, new int[1])) {
            return null;
        }
        float f2 = fArr[0];
        Vector3f vector3f = new Vector3f(fArr2[0], fArr2[1], fArr2[2]);
        if (jArr[0] != 0) {
            imageAsset = new ImageAsset(jArr[0]);
        }
        StickerSetup stickerSetup = new StickerSetup(f2, vector3f, imageAsset, fArr3[0], zArr2[0]);
        return stickerSetup;
    }

    public void removeSticker(int i2) {
        checkFeature(STICKER_FEATURE);
        nativeRemoveSticker(i2);
    }

    public void setLogoPosition(Vector3f vector3f) {
        checkFeature(LOG_FEATURE);
        nativeSetLogoPosition(new float[]{vector3f.x, vector3f.y, vector3f.z});
    }

    public void setLogoSize(float f2) {
        checkFeature(LOG_FEATURE);
        nativeSetLogoSize(f2);
    }

    public void setPostFilter(FilterObject filterObject) {
        ArrayList arrayList = new ArrayList();
        if (filterObject != null) {
            filterObject.enable();
            arrayList.add(filterObject);
        }
        setPostFilters(arrayList);
    }

    public void setPostFilters(ArrayList<FilterObject> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((FilterObject) it.next()).enable();
        }
        nativeSetPostFilters(arrayList.toArray());
    }

    public void setStabilizer(Stabilizer stabilizer) {
        checkFeature(STABILIZER_FEATURE);
        nativeSetStabilizer(stabilizer);
    }

    public boolean supportModel(RenderModelType renderModelType) {
        return nativeSupportModel(renderModelType);
    }

    public void updateDefaultFacing(int i2) {
        checkFeature(FACING_CONTROL_FEATURE);
        nativeUpdateDefaultFacing(i2);
    }

    public void updateLogoImage(ImageAsset imageAsset) {
        checkFeature(LOG_FEATURE);
        nativeUpdateLogoImage(imageAsset);
    }

    public void updateModel(RenderModelType renderModelType) {
        nativeUpdateModel(renderModelType);
    }

    public void updateSticker(StickerSetup stickerSetup) {
        checkFeature(STICKER_FEATURE);
        nativeUpdateSticker(stickerSetup.getSize(), new float[]{stickerSetup.getPosition().x, stickerSetup.getPosition().y, stickerSetup.getPosition().z}, stickerSetup.getAsset(), stickerSetup.getRotation(), stickerSetup.isEnablePositionRoll(), stickerSetup.getStickerId());
    }

    public RenderModel(long j2, String str, RenderLifecycle renderLifecycle) {
        super(j2, str, renderLifecycle, FreeNativeOnDeinit.YES);
    }
}
