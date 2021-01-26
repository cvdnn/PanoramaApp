package a.a.a.a.e.a.f;

import a.a.a.a.e.a.e.i;
import com.arashivision.algorithm.StapleTrackResult;
import com.arashivision.arvbmg.previewer.BMGSessionRender.LottieSetupInfo;
import com.arashivision.arvbmg.previewer.BMGSessionRender.PreviewerRenderCallback;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.arvbmg.render.filter.BlendImageInfo;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo;
import com.arashivision.graphicpath.render.engine.Transform;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insbase.joml.Vector3f;
import com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView;

public class d implements PreviewerRenderCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ CapturePlayerView f573a;

    public d(CapturePlayerView capturePlayerView) {
        this.f573a = capturePlayerView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        i iVar = this.f573a.Ilil;
        if (iVar != null) {
            iVar.a(-1.0d, true);
        }
    }

    public void onCutSceneFrameRender(int i2, double d2, double d3, double d4, double d5, int i3, double d6, double d7, double d8, double d9) {
    }

    public void onFrameRender(int i2, double d2, double d3, double d4, double d5) {
    }

    public ClipRenderInfo onGetClipRenderInfo(int i2) {
        return null;
    }

    public LottieSetupInfo onLottieSetup(int i2, int i3, double d2) {
        return null;
    }

    public LottieUpdateInfo onLottieUpdate(int i2, int i3, double d2) {
        return null;
    }

    public boolean onMultiviewFrameRender(int i2, double d2, double d3, double d4, double d5) {
        return this.f573a.isApplyMultiView();
    }

    public void onRenderBefore() {
        if (this.f573a.Ilil()) {
            CapturePlayerView capturePlayerView = this.f573a;
            if (!capturePlayerView.f59ILl) {
                capturePlayerView.f59ILl = true;
                if (this.f573a.ILil.isAutoRotateEnable()) {
                    this.f573a.I11L.setGyroCountForRotation(100);
                }
            }
            CapturePlayerView capturePlayerView2 = this.f573a;
            if (capturePlayerView2.IL1Iii() && capturePlayerView2.f70lLi1LL.f513b != null) {
                float[] fArr = capturePlayerView2.Lil;
                if (fArr != null) {
                    Vector3f eulerAnglesYXZ = new Quaternionf(fArr[0], fArr[1], fArr[2], fArr[3]).getEulerAnglesYXZ(new Vector3f());
                    capturePlayerView2.f65iILLL1.a(eulerAnglesYXZ.y, eulerAnglesYXZ.x, 0.0f);
                }
                Transform transform = new Transform();
                transform.setFov(capturePlayerView2.f61IiL.getFov());
                transform.setDistance(capturePlayerView2.f61IiL.getDistance());
                a.a.a.a.e.a.l.d.a(transform, capturePlayerView2.IL1Iii.getRotateDegree(), capturePlayerView2.IL1Iii.getFileType(), capturePlayerView2.IL1Iii.getConstraintRatio());
                capturePlayerView2.f70lLi1LL.a(transform.getFov(), transform.getDistance());
                capturePlayerView2.f70lLi1LL.a(capturePlayerView2.f61IiL.getRotate()[0], capturePlayerView2.f61IiL.getRotate()[1], capturePlayerView2.f63L11I);
                capturePlayerView2.f70lLi1LL.f513b.setRoll(transform.getRoll());
            }
            Runnable runnable = (Runnable) this.f573a.iIlLiL.poll();
            if (runnable != null) {
                CapturePlayerView.LL1IL.d("execute a setting runnable~");
                runnable.run();
            }
            this.f573a.post(new a(this));
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
