package com.arashivision.arvbmg.transcode;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.LongSparseArray;
import com.arashivision.arvbmg.transcode.TranscodeEngine.EngineCallback;
import e.a.a.a.a;
import f.a.a.c.o;

public class BMGMediaTranscode {
    public static final String TAG = "arvbmg_transcode";
    public Handler mCallbackHandler;
    public boolean mDebug;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public boolean mReleased;
    public TranscodeCallback mTranscodeCallback;
    public LongSparseArray<TranscodeEngine> mTranscodeEngineSparseArray;
    public long mUniqueId;

    public interface TranscodeCallback {
        void onTranscodeCancel(long j2);

        void onTranscodeComplete(long j2);

        void onTranscodeFail(long j2, TranscodeError transcodeError);

        void onTranscodeProgress(long j2, double d2);
    }

    public BMGMediaTranscode(TranscodeCallback transcodeCallback, Handler handler) {
        this(transcodeCallback, handler, 2);
    }

    /* access modifiers changed from: private */
    public boolean checkEngineEmpty() {
        if (this.mTranscodeEngineSparseArray.size() == 0) {
            return true;
        }
        StringBuilder a2 = a.a(" error transcode size  ");
        a2.append(this.mTranscodeEngineSparseArray.size());
        String sb = a2.toString();
        String str = TAG;
        Log.e(str, sb);
        for (int i2 = 0; i2 < this.mTranscodeEngineSparseArray.size(); i2++) {
            long keyAt = this.mTranscodeEngineSparseArray.keyAt(i2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("force release startId ");
            sb2.append(keyAt);
            Log.e(str, sb2.toString());
            ((TranscodeEngine) this.mTranscodeEngineSparseArray.get(keyAt)).cancel();
            ((TranscodeEngine) this.mTranscodeEngineSparseArray.get(keyAt)).release();
        }
        this.mTranscodeEngineSparseArray.clear();
        Log.i(str, " force over");
        return false;
    }

    /* access modifiers changed from: private */
    public void handleOnProgress(long j2, double d2) {
        final long j3 = j2;
        final double d3 = d2;
        AnonymousClass3 r0 = new Runnable() {
            public void run() {
                if (BMGMediaTranscode.this.isEngineMatch("handleOnProgress", j3, false)) {
                    BMGMediaTranscode.this.mCallbackHandler.post(new Runnable() {
                        public void run() {
                            TranscodeCallback access$300 = BMGMediaTranscode.this.mTranscodeCallback;
                            AnonymousClass3 r1 = AnonymousClass3.this;
                            access$300.onTranscodeProgress(j3, d3);
                        }
                    });
                    return;
                }
                StringBuilder a2 = a.a("handleOnProgress startId ");
                a2.append(j3);
                a2.append(" not match");
                Log.e(BMGMediaTranscode.TAG, a2.toString());
            }
        };
        runOnHandlerThread(r0);
    }

    /* access modifiers changed from: private */
    public boolean isEngineMatch(String str, long j2) {
        return isEngineMatch(str, j2, true);
    }

    /* access modifiers changed from: private */
    public void releaseEngine(String str, long j2, Runnable runnable) {
        final String str2 = str;
        final long j3 = j2;
        final Runnable runnable2 = runnable;
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                if (BMGMediaTranscode.this.isEngineMatch(str2, j3)) {
                    BMGMediaTranscode.this.mCallbackHandler.post(new Runnable() {
                        public void run() {
                            runnable2.run();
                        }
                    });
                    return;
                }
                StringBuilder a2 = a.a("releaseEngine startId ");
                a2.append(j3);
                a2.append(" not match");
                Log.e(BMGMediaTranscode.TAG, a2.toString());
            }
        };
        runOnHandlerThread(r0);
    }

    private void runOnHandlerThread(final Runnable runnable) {
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(new Runnable() {
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public void cancel(final long j2) {
        runOnHandlerThread(new Runnable() {
            public void run() {
                StringBuilder a2 = a.a("cancel startId ");
                a2.append(j2);
                Log.i(BMGMediaTranscode.TAG, a2.toString());
                if (BMGMediaTranscode.this.isEngineMatch("cancel", j2, false)) {
                    ((TranscodeEngine) BMGMediaTranscode.this.mTranscodeEngineSparseArray.get(j2)).cancel();
                }
            }
        });
    }

    public void finalize() {
        boolean z = this.mReleased;
        String str = TAG;
        if (!z) {
            Log.e(str, "release by finalize?");
            release();
        }
        try {
            super.finalize();
        } catch (Throwable th) {
            Log.e(str, "finalize error");
            th.printStackTrace();
        }
    }

    public long getUniqueId() {
        long j2 = this.mUniqueId;
        this.mUniqueId = 1 + j2;
        return j2;
    }

    public boolean isDebug() {
        return this.mDebug;
    }

    public void release() {
        boolean z = this.mReleased;
        String str = TAG;
        if (!z) {
            Log.i(str, "release");
            checkEngineEmpty();
            this.mReleased = true;
            this.mHandlerThread.quit();
            try {
                this.mHandlerThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mHandlerThread = null;
            this.mHandler = null;
            return;
        }
        Log.e(str, " release twice?");
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    public long start(final o oVar) {
        final long uniqueId = getUniqueId();
        runOnHandlerThread(new Runnable() {
            public void run() {
                final long nanoTime = System.nanoTime();
                BMGMediaTranscode.this.checkEngineEmpty();
                TranscodeEngine transcodeEngine = new TranscodeEngine();
                transcodeEngine.setDebug(BMGMediaTranscode.this.isDebug());
                BMGMediaTranscode.this.mTranscodeEngineSparseArray.put(uniqueId, transcodeEngine);
                StringBuilder sb = new StringBuilder();
                sb.append("transcode start startId ");
                sb.append(uniqueId);
                Log.i(BMGMediaTranscode.TAG, sb.toString());
                transcodeEngine.start(oVar, new EngineCallback() {
                    public void onTranscodeCancel() {
                        AnonymousClass4 r0 = AnonymousClass4.this;
                        BMGMediaTranscode.this.releaseEngine("onTranscodeCancel", uniqueId, new Runnable() {
                            public void run() {
                                StringBuilder a2 = a.a("onCancel startId ");
                                a2.append(uniqueId);
                                Log.i(BMGMediaTranscode.TAG, a2.toString());
                                BMGMediaTranscode.this.mTranscodeCallback.onTranscodeCancel(uniqueId);
                            }
                        });
                    }

                    public void onTranscodeComplete() {
                        StringBuilder a2 = a.a("transcode complete cost ");
                        a2.append((System.nanoTime() - nanoTime) / 1000000);
                        a2.append("(ms)");
                        Log.i(BMGMediaTranscode.TAG, a2.toString());
                        AnonymousClass4 r0 = AnonymousClass4.this;
                        BMGMediaTranscode.this.releaseEngine("onTranscodeComplete", uniqueId, new Runnable() {
                            public void run() {
                                BMGMediaTranscode.this.mTranscodeCallback.onTranscodeComplete(uniqueId);
                            }
                        });
                    }

                    public void onTranscodeFail(final TranscodeError transcodeError) {
                        AnonymousClass4 r0 = AnonymousClass4.this;
                        BMGMediaTranscode.this.releaseEngine("onTranscodeFail", uniqueId, new Runnable() {
                            public void run() {
                                BMGMediaTranscode.this.mTranscodeCallback.onTranscodeFail(uniqueId, transcodeError);
                            }
                        });
                    }

                    public void onTranscodeProgress(double d2) {
                        AnonymousClass4 r0 = AnonymousClass4.this;
                        BMGMediaTranscode.this.handleOnProgress(uniqueId, d2);
                    }
                });
            }
        });
        StringBuilder a2 = a.a("transcodeInfo[", uniqueId, "] toString ");
        a2.append(oVar.toString());
        Log.i(TAG, a2.toString());
        return uniqueId;
    }

    public BMGMediaTranscode(TranscodeCallback transcodeCallback, Handler handler, int i2) {
        HandlerThread handlerThread = new HandlerThread(TAG);
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mTranscodeEngineSparseArray = new LongSparseArray<>(i2);
        this.mCallbackHandler = handler;
        this.mTranscodeCallback = transcodeCallback;
    }

    /* access modifiers changed from: private */
    public boolean isEngineMatch(String str, long j2, boolean z) {
        if (this.mTranscodeEngineSparseArray.indexOfKey(j2) == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" error transcode key  ");
            sb.append(j2);
            sb.append(" size ");
            sb.append(this.mTranscodeEngineSparseArray.size());
            Log.e(TAG, sb.toString());
            return false;
        }
        if (z) {
            ((TranscodeEngine) this.mTranscodeEngineSparseArray.get(j2)).release();
            this.mTranscodeEngineSparseArray.remove(j2);
        }
        return true;
    }
}
