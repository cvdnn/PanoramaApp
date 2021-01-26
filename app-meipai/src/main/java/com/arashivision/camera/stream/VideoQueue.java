package com.arashivision.camera.stream;

import android.util.Log;
import com.arashivision.onecamera.camerarequest.VideoParam;
import com.arashivision.onecamera.util.H2645Parser;
import com.arashivision.onecamera.util.H2645Parser.H2645Frame;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.a.a.a.a;
import java.util.LinkedList;

public abstract class VideoQueue {
    public static final String TAG = "com.arashivision.camera.stream.VideoQueue";
    public int mCapacity;
    public boolean mGyroStabilizerApplied;
    public boolean mH265;
    public ICameraPreviewPipeline mICameraPreviewPipeline;
    public OneStreamPipeline mImagePipeline;
    public LinkedList<ExposureInfo> mListExposureQueue = new LinkedList<>();
    public H2645Parser mParser;
    public H2645Parser mParserR;
    public long mPreviewDeltaNs;
    public boolean mTrace;
    public VideoParam mVideoParam;

    public static class ExposureInfo {
        public long exposureTimeNs;
        public long timestampNs;
    }

    public VideoQueue(int i2, OneStreamPipeline oneStreamPipeline, ICameraPreviewPipeline iCameraPreviewPipeline) {
        this.mImagePipeline = oneStreamPipeline;
        this.mCapacity = i2;
    }

    public abstract void clear();

    public boolean enqueExposureTime(ExposureInfo exposureInfo) {
        this.mListExposureQueue.add(exposureInfo);
        if (this.mListExposureQueue.size() > this.mCapacity) {
            this.mListExposureQueue.removeFirst();
        }
        return this.mListExposureQueue.size() == 1;
    }

    public abstract void enqueSecVideo(H2645Frame h2645Frame, long j2);

    public abstract void enqueVideo(H2645Frame h2645Frame, long j2);

    public long getExactTimestamp(long j2, long j3) {
        return (j2 - (j3 / 2)) + this.mPreviewDeltaNs;
    }

    public long getExposureTime(int i2) {
        return ((ExposureInfo) this.mListExposureQueue.get(i2)).exposureTimeNs;
    }

    public int getExposureTimeIdx(long j2) {
        int i2 = -1;
        if (this.mListExposureQueue.size() > 0) {
            String str = " size ";
            if (j2 < ((ExposureInfo) this.mListExposureQueue.get(0)).timestampNs) {
                if (this.mTrace) {
                    String str2 = TAG;
                    StringBuilder a2 = a.a("early exposure frameTsNs ", j2, "<");
                    a2.append(((ExposureInfo) this.mListExposureQueue.get(0)).timestampNs);
                    a2.append(str);
                    a2.append(this.mListExposureQueue.size());
                    Log.e(str2, a2.toString());
                }
                return 0;
            }
            LinkedList<ExposureInfo> linkedList = this.mListExposureQueue;
            if (j2 > ((ExposureInfo) linkedList.get(linkedList.size() - 1)).timestampNs) {
                if (this.mTrace) {
                    String str3 = TAG;
                    StringBuilder a3 = a.a("late exposure frameTsNs ", j2, ">");
                    LinkedList<ExposureInfo> linkedList2 = this.mListExposureQueue;
                    a3.append(((ExposureInfo) linkedList2.get(linkedList2.size() - 1)).timestampNs);
                    a3.append(str);
                    a3.append(this.mListExposureQueue.size());
                    Log.w(str3, a3.toString());
                }
                return this.mListExposureQueue.size() - 1;
            }
            int size = this.mListExposureQueue.size() - 1;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                }
                if (j2 >= ((ExposureInfo) this.mListExposureQueue.get(i3)).timestampNs) {
                    int i4 = i3 + 1;
                    if (j2 <= ((ExposureInfo) this.mListExposureQueue.get(i4)).timestampNs) {
                        if (this.mTrace) {
                            String str4 = TAG;
                            StringBuilder a4 = a.a("find (");
                            a4.append(((ExposureInfo) this.mListExposureQueue.get(i3)).timestampNs);
                            String str5 = ",";
                            a4.append(str5);
                            a4.append(j2);
                            a4.append(str5);
                            a4.append(((ExposureInfo) this.mListExposureQueue.get(i4)).timestampNs);
                            a4.append(") time ");
                            a4.append(((ExposureInfo) this.mListExposureQueue.get(i3)).exposureTimeNs);
                            a4.append(" i ");
                            a4.append(i3);
                            a4.append(str);
                            a4.append(this.mListExposureQueue.size());
                            Log.i(str4, a4.toString());
                        }
                    }
                }
                i3++;
            }
            if (i3 == -1) {
                String str6 = TAG;
                StringBuilder a5 = a.a("exposure not found frameTsNs ", j2, str);
                a5.append(this.mListExposureQueue.size());
                Log.w(str6, a5.toString());
                return 0;
            }
            i2 = i3;
        } else {
            Log.e(TAG, " no exposure");
        }
        return i2;
    }

    public void removeExposure(int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            if (i3 < i2) {
                this.mListExposureQueue.remove(0);
                i3 = i4;
            } else {
                return;
            }
        }
    }

    public void setGyroStabilizerApplied(boolean z) {
        this.mGyroStabilizerApplied = z;
    }

    public void setH265(boolean z) {
        this.mH265 = z;
    }

    public void setParser(H2645Parser h2645Parser, H2645Parser h2645Parser2) {
        this.mParser = h2645Parser;
        this.mParserR = h2645Parser2;
    }

    public void setTrace(boolean z) {
        this.mTrace = z;
    }

    public void setVideoParam(VideoParam videoParam) {
        this.mVideoParam = videoParam;
    }

    public void updatePipleline(ICameraPreviewPipeline iCameraPreviewPipeline) {
        this.mICameraPreviewPipeline = iCameraPreviewPipeline;
    }
}
