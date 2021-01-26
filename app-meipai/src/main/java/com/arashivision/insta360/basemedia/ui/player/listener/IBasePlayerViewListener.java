package com.arashivision.insta360.basemedia.ui.player.listener;

@Deprecated
public interface IBasePlayerViewListener {

    public interface IL1Iii {
    }

    void onFail(int i2, String str, String str2);

    void onLoadingFinish();

    void onLoadingStatusChanged();

    void setCallback(IL1Iii iL1Iii);
}
