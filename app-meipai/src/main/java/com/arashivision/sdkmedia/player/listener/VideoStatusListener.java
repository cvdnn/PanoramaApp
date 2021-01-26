package com.arashivision.sdkmedia.player.listener;

public interface VideoStatusListener {
    void onCompletion();

    void onPlayStateChanged(boolean z);

    void onProgressChanged(long j2, long j3);

    void onSeekComplete();
}
