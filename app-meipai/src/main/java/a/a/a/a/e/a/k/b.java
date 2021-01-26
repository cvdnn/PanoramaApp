package a.a.a.a.e.a.k;

import com.arashivision.algorithm.StapleTrackResult;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo;
import com.arashivision.arvbmg.previewer.BMGSessionRender.PreviewerRenderCallback;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo;
import com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView;
import java.text.DecimalFormat;

public class b implements PreviewerRenderCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ImagePlayerView f637a;

    public b(ImagePlayerView imagePlayerView) {
        this.f637a = imagePlayerView;
        new DecimalFormat("#.##");
        this.f637a.IL1Iii.getAssetInfo();
    }

    public static /* synthetic */ void a(b bVar) {
        if (bVar == null) {
            throw null;
        }
    }

    public void onCutSceneFrameRender(int i2, double d2, double d3, double d4, double d5, int i3, double d6, double d7, double d8, double d9) {
    }

    public void onFrameRender(int i2, double d2, double d3, double d4, double d5) {
    }

    public ClipRenderInfo onGetClipRenderInfo(int i2) {
        if (!this.f637a.Ilil()) {
            return null;
        }
        ImagePlayerView.f96LLlI1.d("onGetClipRenderInfo");
        return this.f637a.getClipRenderInfo();
    }

    public LottieSetupInfo onLottieSetup(int i2, int i3, double d2) {
        return null;
    }

    public LottieUpdateInfo onLottieUpdate(int i2, int i3, double d2) {
        return null;
    }

    public boolean onMultiviewFrameRender(int i2, double d2, double d3, double d4, double d5) {
        return false;
    }

    public void onRenderBefore() {
        if (this.f637a.Ilil()) {
            ImagePlayerView imagePlayerView = this.f637a;
            if (imagePlayerView.iIi1 < 0) {
                imagePlayerView.iIi1 = Thread.currentThread().getId();
            }
            try {
                this.f637a.m20IiL();
                this.f637a.post(new a(this));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Runnable runnable = (Runnable) this.f637a.I11li1.poll();
            if (runnable != null) {
                ImagePlayerView.f96LLlI1.d("execute a setting runnable~");
                runnable.run();
            }
        }
    }

    public void onRenderNotify(int i2, int i3, int i4) {
    }

    public void onStapleTrackError(int i2) {
    }

    public void onStapleTrackResult(StapleTrackResult stapleTrackResult) {
    }

    public void onStapleTrackStop() {
    }

    public void onStopTrack(long j2) {
    }

    public void onSubStreamFrameRender(int i2, double d2, double d3, double d4, double d5) {
    }

    public BlendImageInfo onTrackFlash(int i2, double d2, double d3, double d4) {
        return null;
    }

    public void onTrackStart(String str, boolean z) {
    }

    public void onTrackUpdate(int i2, long j2, float f2, float[] fArr, float[] fArr2, float[] fArr3) {
    }

    public MultiViewRectInfo onUpdateMultiviewInfo(int i2, double d2, double d3, double d4, double d5) {
        return null;
    }
}
