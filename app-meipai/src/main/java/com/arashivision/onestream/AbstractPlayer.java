package com.arashivision.onestream;

import android.os.Handler;
import android.util.Log;
import com.arashivision.onestream.Gyro.GyroType;
import com.arashivision.onestream.Gyro.OneGyroField;
import com.arashivision.onestream.Gyro.OneLatestIDR;
import com.arashivision.onestreamtarget.OneStreamTarget;
import com.arashivision.onestreamtarget.StreamTarget;
import com.arashivision.onestreamtarget.TextureInfo;
import e.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.LinkedList;

public abstract class AbstractPlayer {
    public static final int NOTIFY_ERROR = 0;
    public static final int NOTIFY_FPS = 1;
    public static final String TAG = "OneAbstractPlayer";
    public Handler mCBHandler;
    public ExposureQueue mExposureQueue;
    public ByteBuffer mLatestIDRBuf;
    public volatile OneLatestIDR mLatestIDRFrame = new OneLatestIDR();
    public ByteBuffer mLatestSecondIDRBuf;
    public PlayerInfoListenr mPlayerInfoListenr;
    public long mPreviewDeltaNs = 150000000;
    public boolean mReleased;
    public StreamTarget mStreamTarget;
    public OneStreamTarget mTarget;

    public static class ExposureQueue {
        public int mCapacity;
        public LinkedList<StreamExposureInfo> mListExposureQueue = new LinkedList<>();
        public long mPreviewDeltaNs;
        public boolean mTrace;

        public ExposureQueue(int i2) {
            this.mCapacity = i2;
        }

        public void clear() {
            this.mListExposureQueue.clear();
        }

        public void enqueExposureTime(StreamExposureInfo streamExposureInfo) {
            this.mListExposureQueue.add(streamExposureInfo);
            if (this.mListExposureQueue.size() > this.mCapacity) {
                Log.e(AbstractPlayer.TAG, "exposure exceed");
                this.mListExposureQueue.removeFirst();
            }
        }

        public long getExactTimestamp(long j2, long j3) {
            return (j2 - (j3 / 2)) + this.mPreviewDeltaNs;
        }

        public long getExposureTime(int i2) {
            return ((StreamExposureInfo) this.mListExposureQueue.get(i2)).exposureTimeNs;
        }

        public int getExposureTimeIdx(long j2) {
            int size = this.mListExposureQueue.size();
            int i2 = -1;
            String str = AbstractPlayer.TAG;
            if (size > 0) {
                String str2 = " size ";
                if (j2 < ((StreamExposureInfo) this.mListExposureQueue.get(0)).timestampNs) {
                    StringBuilder a2 = a.a("early exposure frameTsNs ", j2, "<");
                    a2.append(((StreamExposureInfo) this.mListExposureQueue.get(0)).timestampNs);
                    a2.append(str2);
                    a2.append(this.mListExposureQueue.size());
                    Log.e(str, a2.toString());
                    return 0;
                }
                LinkedList<StreamExposureInfo> linkedList = this.mListExposureQueue;
                if (j2 > ((StreamExposureInfo) linkedList.get(linkedList.size() - 1)).timestampNs) {
                    StringBuilder a3 = a.a("late exposure frameTsNs ", j2, ">");
                    LinkedList<StreamExposureInfo> linkedList2 = this.mListExposureQueue;
                    a3.append(((StreamExposureInfo) linkedList2.get(linkedList2.size() - 1)).timestampNs);
                    a3.append(str2);
                    a3.append(this.mListExposureQueue.size());
                    Log.w(str, a3.toString());
                    return this.mListExposureQueue.size() - 1;
                }
                int size2 = this.mListExposureQueue.size() - 1;
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        i3 = -1;
                        break;
                    }
                    if (j2 >= ((StreamExposureInfo) this.mListExposureQueue.get(i3)).timestampNs) {
                        int i4 = i3 + 1;
                        if (j2 <= ((StreamExposureInfo) this.mListExposureQueue.get(i4)).timestampNs) {
                            if (this.mTrace) {
                                StringBuilder a4 = a.a("find (");
                                a4.append(((StreamExposureInfo) this.mListExposureQueue.get(i3)).timestampNs);
                                String str3 = ",";
                                a4.append(str3);
                                a4.append(j2);
                                a4.append(str3);
                                a4.append(((StreamExposureInfo) this.mListExposureQueue.get(i4)).timestampNs);
                                a4.append(") time ");
                                a4.append(((StreamExposureInfo) this.mListExposureQueue.get(i3)).exposureTimeNs);
                                a4.append(" i ");
                                a4.append(i3);
                                a4.append(str2);
                                a4.append(this.mListExposureQueue.size());
                                Log.i(str, a4.toString());
                            }
                        }
                    }
                    i3++;
                }
                if (i3 == -1) {
                    StringBuilder a5 = a.a("exposure not found frameTsNs ", j2, str2);
                    a5.append(this.mListExposureQueue.size());
                    Log.e(str, a5.toString());
                    return 0;
                }
                i2 = i3;
            } else {
                Log.w(str, "no exposure");
            }
            return i2;
        }

        public void removeExposure(int i2) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 < i2) {
                    this.mListExposureQueue.removeFirst();
                    i3 = i4;
                } else {
                    return;
                }
            }
        }

        public void setPreviewDeltaNs(long j2) {
            StringBuilder sb = new StringBuilder();
            sb.append("setPreviewDeltaNs ");
            sb.append(j2);
            Log.i(AbstractPlayer.TAG, sb.toString());
            this.mPreviewDeltaNs = j2;
        }

        public void setTrace(boolean z) {
            this.mTrace = z;
        }
    }

    public static class StreamExposureInfo {
        public long exposureTimeNs;
        public long timestampNs;
    }

    private void infoNotify(int i2, int i3, int i4, String str) {
        Handler handler = this.mCBHandler;
        final int i5 = i2;
        final int i6 = i4;
        final int i7 = i3;
        final String str2 = str;
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                int i2 = i5;
                String str = AbstractPlayer.TAG;
                if (i2 == 0) {
                    StringBuilder a2 = a.a("notify error ");
                    a2.append(i6);
                    a2.append(" playerIndex ");
                    a2.append(i7);
                    a2.append(" info ");
                    String str2 = str2;
                    if (str2 == null) {
                        str2 = " null";
                    }
                    a2.append(str2);
                    Log.i(str, a2.toString());
                    AbstractPlayer.this.mPlayerInfoListenr.onError(i6);
                } else if (i2 != 1) {
                    a.b(a.a("error infoNotfy "), i5, str);
                } else {
                    StringBuilder a3 = a.a("notify ");
                    a3.append(i6);
                    a3.append("　fps ");
                    a3.append(str2);
                    a3.append(" ");
                    a3.append(Double.valueOf(str2.toString()));
                    Log.i(str, a3.toString());
                    AbstractPlayer.this.mPlayerInfoListenr.onFps(Double.valueOf(str2.toString()).doubleValue());
                }
            }
        };
        handler.post(r1);
    }

    private void renderNotify(long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer != null) {
            setLatestIDRBuf(byteBuffer);
        }
        if (byteBuffer2 != null) {
            setLatestSecondIDRBuf(byteBuffer2);
        }
    }

    private void renderTextureNotify(TextureInfo textureInfo) {
        this.mStreamTarget.notifyTextureRender(textureInfo);
    }

    private void setLatestIDRBuf(ByteBuffer byteBuffer) {
        this.mLatestIDRBuf = byteBuffer;
    }

    private void setLatestIDRGyro(OneGyroField oneGyroField) {
        this.mLatestIDRFrame.mOneGyroField = oneGyroField;
    }

    private void setLatestSecondIDRBuf(ByteBuffer byteBuffer) {
        this.mLatestSecondIDRBuf = byteBuffer;
    }

    public OneLatestIDR getLatestIDRFrame() {
        return this.mLatestIDRFrame;
    }

    public abstract void putData(ImageData imageData);

    public abstract void putData(ImageData imageData, ImageData imageData2);

    public void putExposureTime(StreamExposureInfo streamExposureInfo) {
        this.mExposureQueue.enqueExposureTime(streamExposureInfo);
    }

    public void putGyro(LinkedList<OneGyroField> linkedList) {
    }

    public abstract void release();

    public void setGyroType(GyroType gyroType, float[] fArr, boolean z) {
        this.mExposureQueue = new ExposureQueue(300);
    }

    public void setInfoNotify(PlayerInfoListenr playerInfoListenr) {
        this.mPlayerInfoListenr = playerInfoListenr;
    }

    public void setPreviewDeltaNs(long j2) {
        this.mExposureQueue.setPreviewDeltaNs(j2);
    }

    public abstract void start();
}
