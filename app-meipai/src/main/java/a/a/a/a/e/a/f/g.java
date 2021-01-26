package a.a.a.a.e.a.f;

import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender.CameraPreviewRenderCallback;
import com.arashivision.arvbmg.previewer.ClipRenderInfo;
import com.arashivision.arvbmg.previewer.MultiViewRectInfo;
import com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView;

public class g implements CameraPreviewRenderCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ CapturePlayerView f576a;

    public g(CapturePlayerView capturePlayerView) {
        this.f576a = capturePlayerView;
    }

    public ClipRenderInfo onGetCameraHistorgramClipRenderInfo() {
        return this.f576a.getHistogramClipRenderInfo();
    }

    public ClipRenderInfo onGetCameraLiveClipRenerInfo() {
        return this.f576a.getLiveClipRenderInfo();
    }

    public MultiViewRectInfo onGetCameraLiveMultivewRectInfo() {
        return this.f576a.getMultiViewRectInfo();
    }

    public boolean onGetCameraLiveMultiviewFrameRender() {
        return this.f576a.isApplyMultiView();
    }

    public ClipRenderInfo onGetCameraMultviewTrackClipRenderInfo() {
        return this.f576a.getCameraMultViewTrackClipRenderInfo();
    }
}
