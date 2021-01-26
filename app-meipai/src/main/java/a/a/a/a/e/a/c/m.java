package a.a.a.a.e.a.c;

import com.arashivision.arvbmg.previewer.BMGPreviewerSessionRender;
import com.arashivision.arvbmg.previewer.BMGSessionRender.Callbacks;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.ui.player.listener.IBasePlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.listener.IVideoPlayerViewListener;
import com.arashivision.insta360.basemedia.ui.player.video.VideoPlayerView;
import java.text.DecimalFormat;

public class m implements Callbacks {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ VideoPlayerView f487a;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            VideoPlayerView videoPlayerView = m.this.f487a;
            BMGPreviewerSessionRender bMGPreviewerSessionRender = videoPlayerView.f216I;
            if (bMGPreviewerSessionRender != null) {
                videoPlayerView.f229LlLLL = bMGPreviewerSessionRender.seek(videoPlayerView.LL1IL);
                MediaLogger mediaLogger = VideoPlayerView.l1Lll;
                StringBuilder a2 = e.a.a.a.a.a("seekTo ");
                a2.append(m.this.f487a.LL1IL);
                a2.append(", seekId is ");
                a2.append(m.this.f487a.f229LlLLL);
                mediaLogger.d(a2.toString());
                m.this.f487a.f238lIII = -1;
            }
        }
    }

    public m(VideoPlayerView videoPlayerView) {
        this.f487a = videoPlayerView;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        synchronized (this.f487a) {
            this.f487a.m42lIlii();
        }
    }

    public void onComplete(int i2) {
        if (this.f487a.m39L11I()) {
            VideoPlayerView.l1Lll.d("onComplete");
            this.f487a.llliI = true;
            this.f487a.Lil();
            this.f487a.m45il();
            for (IVideoPlayerViewListener onCompletion : this.f487a.f244i11i) {
                onCompletion.onCompletion();
            }
        }
    }

    public void onDecodeReport(int i2, int i3) {
        for (IVideoPlayerViewListener onDecodeReport : this.f487a.f244i11i) {
            onDecodeReport.onDecodeReport(i2, i3);
        }
    }

    public void onFail(int i2, String str, String str2) {
        if (this.f487a.m39L11I()) {
            MediaLogger mediaLogger = VideoPlayerView.l1Lll;
            StringBuilder sb = new StringBuilder();
            sb.append("onFail, errorCode is ");
            sb.append(i2);
            sb.append(", domain is ");
            sb.append(str);
            sb.append(", desc is ");
            sb.append(str2);
            mediaLogger.e(sb.toString());
            this.f487a.setLoading(false);
            IBasePlayerViewListener iBasePlayerViewListener = this.f487a.I1;
            if (iBasePlayerViewListener != null) {
                iBasePlayerViewListener.onFail(i2, str, str2);
            }
        }
    }

    public void onFpsNotify(double d2) {
        this.f487a.f248l = new DecimalFormat("#.##").format(d2);
        for (IVideoPlayerViewListener onFpsNotify : this.f487a.f244i11i) {
            onFpsNotify.onFpsNotify(d2);
        }
    }

    public void onPrepared() {
        if (this.f487a.m39L11I()) {
            VideoPlayerView.l1Lll.d("onPrepared");
            this.f487a.f212I1L11L = true;
            this.f487a.iIi1();
            this.f487a.setLoading(false);
            IBasePlayerViewListener iBasePlayerViewListener = this.f487a.I1;
            if (iBasePlayerViewListener != null) {
                iBasePlayerViewListener.onLoadingFinish();
            }
            if (this.f487a.ILil.isAutoPlayAfterPrepared()) {
                this.f487a.f216I.start();
            }
            this.f487a.m45il();
            if (!this.f487a.f239lIlii.isEmpty()) {
                VideoPlayerView.IL1Iii(this.f487a);
            }
        }
    }

    public void onReBuffer(int i2, int i3) {
        if (i2 == 500) {
            VideoPlayerView.l1Lll.d("buffer start~");
        } else if (i2 == 502) {
            VideoPlayerView.l1Lll.d("buffer end~");
        }
        for (IVideoPlayerViewListener onReBuffer : this.f487a.f244i11i) {
            onReBuffer.onReBuffer(i2, i3);
        }
    }

    public void onSeek(int i2, int i3, String str, String str2) {
        if (this.f487a.m39L11I()) {
            MediaLogger mediaLogger = VideoPlayerView.l1Lll;
            StringBuilder sb = new StringBuilder();
            sb.append("onSeek, seekId is ");
            sb.append(i3);
            mediaLogger.d(sb.toString());
            VideoPlayerView videoPlayerView = this.f487a;
            if (videoPlayerView.f229LlLLL == i3 && videoPlayerView.f238lIII == -1) {
                VideoPlayerView.l1Lll.d("onSeek, seekId matched");
                this.f487a.llliI = false;
                this.f487a.Lil();
                this.f487a.post(new e(this));
                this.f487a.IL1Iii((Boolean) null);
                if (this.f487a.ILil.isResetViewAngleOnSeekComplete()) {
                    this.f487a.f2511 = true;
                }
                for (IVideoPlayerViewListener iVideoPlayerViewListener : this.f487a.f244i11i) {
                    if (i2 == 0) {
                        iVideoPlayerViewListener.onSeekComplete();
                    } else {
                        iVideoPlayerViewListener.onSeekError(i2);
                    }
                }
                VideoPlayerView videoPlayerView2 = this.f487a;
                if (videoPlayerView2.f221L111) {
                    videoPlayerView2.resume();
                }
                if (this.f487a.f250LLlI1 == i3) {
                    VideoPlayerView.l1Lll.d("onSeek, resume after seek");
                    VideoPlayerView videoPlayerView3 = this.f487a;
                    videoPlayerView3.f250LLlI1 = -1;
                    videoPlayerView3.resume();
                }
                this.f487a.f229LlLLL = -1;
            } else if (this.f487a.llliI) {
                VideoPlayerView.l1Lll.d("onSeek, from complete state");
                this.f487a.llliI = false;
                if (this.f487a.ILil.isLooping() && this.f487a.ILil.isResetViewAngleOnSeekComplete()) {
                    this.f487a.f2511 = true;
                }
            }
        }
    }

    public void onStartLoading() {
        VideoPlayerView.l1Lll.w("BMGPreviewerSessionRender, onStartLoading");
    }

    public void onStopLoading() {
        VideoPlayerView.l1Lll.w("BMGPreviewerSessionRender, onStopLoading");
    }

    public void onSubStreamDecodeReport(int i2, int i3) {
    }

    public void onSubStreamFail(int i2, String str, String str2) {
    }

    public void onSubStreamPrepared() {
        if (this.f487a.m39L11I()) {
            this.f487a.f214ILLIi = true;
        }
    }

    public void onSubStreamReBuffer(int i2, int i3) {
    }

    public void onSubStreamSeek(int i2, int i3, String str, String str2) {
        if (this.f487a.m39L11I()) {
            MediaLogger mediaLogger = VideoPlayerView.l1Lll;
            StringBuilder sb = new StringBuilder();
            sb.append("onSubStreamSeek, seekId is ");
            sb.append(i3);
            mediaLogger.d(sb.toString());
            if (this.f487a.f238lIII == i3) {
                VideoPlayerView.l1Lll.d("onSubStreamSeek, seekId matched");
                this.f487a.post(new a());
            }
        }
    }
}
