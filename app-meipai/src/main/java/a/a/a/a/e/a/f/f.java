package a.a.a.a.e.a.f;

import a.a.a.a.e.a.g.b;
import com.arashivision.arvbmg.previewer.BMGSessionRender.Callbacks;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.ui.player.capture.CapturePlayerView;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;

public class f implements Callbacks {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ CapturePlayerView f575a;

    public f(CapturePlayerView capturePlayerView) {
        this.f575a = capturePlayerView;
    }

    public void onComplete(int i2) {
        if (this.f575a.Ilil()) {
            CapturePlayerView.LL1IL.d("onComplete");
        }
    }

    public void onDecodeReport(int i2, int i3) {
    }

    public void onFail(int i2, String str, String str2) {
        if (this.f575a.Ilil()) {
            MediaLogger mediaLogger = CapturePlayerView.LL1IL;
            StringBuilder sb = new StringBuilder();
            sb.append("onFail, errorCode is ");
            sb.append(i2);
            sb.append(", domain is ");
            sb.append(str);
            sb.append(", desc is ");
            sb.append(str2);
            mediaLogger.e(sb.toString());
            IBasePlayerViewListener iBasePlayerViewListener = this.f575a.f741;
            if (iBasePlayerViewListener != null) {
                iBasePlayerViewListener.onFail(i2, str, str2);
            }
        }
    }

    public void onFpsNotify(double d2) {
        b bVar = this.f575a.f64LlLLL;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void onPrepared() {
        CapturePlayerView.LL1IL.d("onPrepared");
    }

    public void onReBuffer(int i2, int i3) {
        b bVar = this.f575a.f64LlLLL;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void onSeek(int i2, int i3, String str, String str2) {
        MediaLogger mediaLogger = CapturePlayerView.LL1IL;
        StringBuilder sb = new StringBuilder();
        sb.append("onSeek, seekId is ");
        sb.append(i3);
        mediaLogger.d(sb.toString());
    }

    public void onStartLoading() {
        CapturePlayerView.LL1IL.w("BMGPreviewerSessionRender, onStartLoading");
    }

    public void onStopLoading() {
        CapturePlayerView.LL1IL.w("BMGPreviewerSessionRender, onStopLoading");
    }

    public void onSubStreamDecodeReport(int i2, int i3) {
    }

    public void onSubStreamFail(int i2, String str, String str2) {
    }

    public void onSubStreamPrepared() {
    }

    public void onSubStreamReBuffer(int i2, int i3) {
    }

    public void onSubStreamSeek(int i2, int i3, String str, String str2) {
    }
}
