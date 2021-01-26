package com.arashivision.insta360.basemedia.ui.player.listener;

@Deprecated
public interface IVideoPlayerViewListener {

    public interface IL1Iii {
    }

    void onCalculateAntiShakeDataProgress(int i2, float f2);

    void onCompletion();

    void onDecodeReport(int i2, int i3);

    void onFpsNotify(double d2);

    void onFrameUpdate(long j2);

    void onGenerateProxyFileProgress(int i2, float f2);

    void onPlayClip(int i2);

    void onPlayCutScene(int i2, int i3);

    void onPlayStateChanged();

    void onProgressChanged(double d2, double d3);

    void onReBuffer(int i2, int i3);

    void onSeekComplete();

    void onSeekError(int i2);

    void setCallback(IL1Iii iL1Iii);
}
