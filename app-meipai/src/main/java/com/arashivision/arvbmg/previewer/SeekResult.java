package com.arashivision.arvbmg.previewer;

import android.os.Handler;
import android.os.Looper;

public final class SeekResult {
    public volatile boolean complete;
    public boolean directCallListener;
    public Handler handler = new Handler(Looper.getMainLooper());
    public SeekListener listener;
    public final Object mutex = new Object();
    public final int seekId;

    public interface SeekListener {
        void onSeekResult(int i2);
    }

    public SeekResult(int i2) {
        this.seekId = i2;
    }

    private final void setDirectCallListener(SeekListener seekListener) {
        synchronized (this.mutex) {
            this.listener = seekListener;
            this.directCallListener = true;
            trySendResult();
        }
    }

    private final void trySendResult() {
        if (this.complete) {
            Handler handler2 = this.handler;
            SeekListener seekListener = this.listener;
            if (seekListener == null) {
                return;
            }
            if (!this.directCallListener) {
                handler2.post(new Runnable() {
                    public final void run() {
                        SeekResult.this.listener.onSeekResult(SeekResult.this.getSeekId());
                    }
                });
            } else {
                seekListener.onSeekResult(this.seekId);
            }
        }
    }

    public final int await() {
        return this.seekId;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final int getSeekId() {
        return this.seekId;
    }

    public final void onResult() {
        synchronized (this.mutex) {
            this.complete = true;
            trySendResult();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setResultListener(Handler handler2, SeekListener seekListener) {
        synchronized (this.mutex) {
            this.listener = seekListener;
            this.directCallListener = false;
            if (handler2 != null) {
                this.handler = handler2;
            }
            trySendResult();
        }
    }
}
