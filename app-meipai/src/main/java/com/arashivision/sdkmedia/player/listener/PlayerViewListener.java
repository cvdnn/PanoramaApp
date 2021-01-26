package com.arashivision.sdkmedia.player.listener;

public interface PlayerViewListener {
    void onFail(String str);

    void onLoadingFinish();

    void onLoadingStatusChanged(boolean z);
}
