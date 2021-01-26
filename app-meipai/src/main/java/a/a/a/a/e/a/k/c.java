package a.a.a.a.e.a.k;

import com.arashivision.arvbmg.previewer.BMGSessionRender.Callbacks;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.ui.player.image.ImagePlayerView;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;

public class c implements Callbacks {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ ImagePlayerView f638a;

    public c(ImagePlayerView imagePlayerView) {
        this.f638a = imagePlayerView;
    }

    public void onComplete(int i2) {
        if (this.f638a.Ilil()) {
            ImagePlayerView.f96LLlI1.d("onComplete");
            this.f638a.iIlLiL = true;
            this.f638a.setLoading(false);
            IBasePlayerViewListener iBasePlayerViewListener = this.f638a.f106lIII;
            if (iBasePlayerViewListener != null) {
                iBasePlayerViewListener.onLoadingFinish();
            }
        }
    }

    public void onDecodeReport(int i2, int i3) {
    }

    public void onFail(int i2, String str, String str2) {
        if (this.f638a.Ilil()) {
            MediaLogger mediaLogger = ImagePlayerView.f96LLlI1;
            StringBuilder sb = new StringBuilder();
            sb.append("onFail, errorCode is ");
            sb.append(i2);
            sb.append(", domain is ");
            sb.append(str);
            sb.append(", desc is ");
            sb.append(str2);
            mediaLogger.e(sb.toString());
            IBasePlayerViewListener iBasePlayerViewListener = this.f638a.f106lIII;
            if (iBasePlayerViewListener != null) {
                iBasePlayerViewListener.onFail(i2, str, str2);
            }
        }
    }

    public void onFpsNotify(double d2) {
    }

    public void onPrepared() {
        ImagePlayerView.f96LLlI1.d("onPrepared");
    }

    public void onReBuffer(int i2, int i3) {
    }

    public void onSeek(int i2, int i3, String str, String str2) {
        MediaLogger mediaLogger = ImagePlayerView.f96LLlI1;
        StringBuilder sb = new StringBuilder();
        sb.append("onSeek, seekId is ");
        sb.append(i3);
        mediaLogger.d(sb.toString());
    }

    public void onStartLoading() {
        ImagePlayerView.f96LLlI1.w("BMGPreviewerSessionRender, onStartLoading");
    }

    public void onStopLoading() {
        ImagePlayerView.f96LLlI1.w("BMGPreviewerSessionRender, onStopLoading");
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
