package a.a.a.a.e.a.f;

import com.arashivision.arvbmg.previewer.BMGCameraPreviewerSessionRender.MultiviewTrackInfo.MultiviewTrackCallback;
import com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView;

public class e implements MultiviewTrackCallback {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ CapturePlayerView f574a;

    public e(CapturePlayerView capturePlayerView) {
        this.f574a = capturePlayerView;
    }

    public boolean onMultiviewTrackEnable() {
        return this.f574a.isApplyMultiView();
    }
}
