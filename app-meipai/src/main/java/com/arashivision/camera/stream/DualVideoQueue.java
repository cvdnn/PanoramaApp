package com.arashivision.camera.stream;

import android.util.Log;
import android.util.LongSparseArray;
import com.arashivision.camera.strategy.TraceUtil;
import com.arashivision.onecamera.util.H2645Parser.FrameType;
import com.arashivision.onecamera.util.H2645Parser.H2645Frame;
import com.arashivision.onestream.ImageData;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.a.a.a.a;

public class DualVideoQueue extends VideoQueue {
    public LongSparseArray<DualImageInfo> mQueue = new LongSparseArray<>();

    public static class DualImageInfo {
        public H2645Frame mLeftFrame;
        public H2645Frame mRightFrame;

        public DualImageInfo() {
        }

        public boolean isIDRReady() {
            return isReady() && this.mLeftFrame.isIDR();
        }

        public boolean isReady() {
            return (this.mLeftFrame == null || this.mRightFrame == null) ? false : true;
        }
    }

    public DualVideoQueue(int i2, OneStreamPipeline oneStreamPipeline, ICameraPreviewPipeline iCameraPreviewPipeline) {
        super(i2, oneStreamPipeline, iCameraPreviewPipeline);
    }

    private void dropImage(String str) {
        if (isQueueExceed(str)) {
            int i2 = 0;
            while (i2 < this.mQueue.size()) {
                DualImageInfo dualImageInfo = (DualImageInfo) this.mQueue.valueAt(i2);
                H2645Frame h2645Frame = dualImageInfo.mLeftFrame;
                if (h2645Frame == null) {
                    H2645Frame h2645Frame2 = dualImageInfo.mRightFrame;
                    if (h2645Frame2 != null && h2645Frame2.type == FrameType.Other) {
                        String str2 = VideoQueue.TAG;
                        StringBuilder a2 = a.a("drop right ts ");
                        a2.append(this.mQueue.keyAt(i2));
                        Log.d(str2, a2.toString());
                        this.mQueue.removeAt(i2);
                    }
                } else if (h2645Frame.type == FrameType.Other) {
                    String str3 = VideoQueue.TAG;
                    StringBuilder a3 = a.a("drop left ts ");
                    a3.append(this.mQueue.keyAt(i2));
                    Log.d(str3, a3.toString());
                    this.mQueue.removeAt(i2);
                }
                i2++;
            }
            String str4 = VideoQueue.TAG;
            StringBuilder b2 = a.b(str, " after drop mQueue.size() ");
            b2.append(this.mQueue.size());
            Log.e(str4, b2.toString());
        }
    }

    private int getPreviewHeight() {
        return this.mVideoParam.height;
    }

    private int getPreviewWidth() {
        return this.mVideoParam.width / 2;
    }

    private boolean isQueueExceed(String str) {
        if (this.mQueue.size() < this.mCapacity) {
            return false;
        }
        String str2 = VideoQueue.TAG;
        StringBuilder b2 = a.b(str, " mQueue size ");
        b2.append(this.mQueue.size());
        Log.e(str2, b2.toString());
        return true;
    }

    private void putImage(ImageData[] imageDataArr) {
        ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
        if (iCameraPreviewPipeline != null) {
            iCameraPreviewPipeline.onVideoStream(imageDataArr);
        } else if (imageDataArr.length == 2) {
            this.mImagePipeline.putImage(imageDataArr[0], imageDataArr[1]);
        }
    }

    private void removeAtRange(int i2, int i3) {
        int min = Math.min(this.mQueue.size(), i3 + i2);
        while (i2 < min) {
            this.mQueue.removeAt(i2);
            i2++;
        }
    }

    public void clear() {
    }

    public void enqueSecVideo(H2645Frame h2645Frame, long j2) {
        if (TraceUtil.TRACE) {
            String str = VideoQueue.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("enqueSecVideo timestamp ");
            sb.append(j2);
            Log.d(str, sb.toString());
        }
        int i2 = 0;
        while (i2 < this.mQueue.size() && this.mQueue.keyAt(i2) < j2) {
            DualImageInfo dualImageInfo = (DualImageInfo) this.mQueue.valueAt(i2);
            if (dualImageInfo.mRightFrame == null) {
                String str2 = VideoQueue.TAG;
                StringBuilder a2 = a.a("sec remove early ts (");
                a2.append(this.mQueue.keyAt(i2));
                a2.append(",");
                a2.append(j2);
                a2.append(")");
                Log.e(str2, a2.toString());
                if (dualImageInfo.mLeftFrame != null) {
                    String str3 = VideoQueue.TAG;
                    StringBuilder a3 = a.a(" type ");
                    a3.append(dualImageInfo.mLeftFrame.type);
                    Log.e(str3, a3.toString());
                }
                this.mQueue.removeAt(i2);
            } else {
                i2++;
            }
        }
        DualImageInfo dualImageInfo2 = (DualImageInfo) this.mQueue.get(j2);
        if (dualImageInfo2 == null) {
            DualImageInfo dualImageInfo3 = new DualImageInfo();
            dualImageInfo3.mRightFrame = h2645Frame;
            this.mQueue.append(j2, dualImageInfo3);
            dropImage("right");
        } else if (dualImageInfo2.mLeftFrame != null) {
            dualImageInfo2.mRightFrame = h2645Frame;
            if (j2 > this.mQueue.keyAt(0)) {
                removeAtRange(0, this.mQueue.indexOfKey(j2) - 1);
            }
            this.mQueue.remove(j2);
            feedPipelineVideo(dualImageInfo2.mLeftFrame, dualImageInfo2.mRightFrame, j2);
        } else {
            throw new RuntimeException("dual enqueSecVideo null");
        }
    }

    public void enqueVideo(H2645Frame h2645Frame, long j2) {
        if (TraceUtil.TRACE) {
            String str = VideoQueue.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("enqueVideo timestamp ");
            sb.append(j2);
            Log.d(str, sb.toString());
        }
        int i2 = 0;
        while (i2 < this.mQueue.size() && this.mQueue.keyAt(i2) < j2) {
            DualImageInfo dualImageInfo = (DualImageInfo) this.mQueue.valueAt(i2);
            if (dualImageInfo.mLeftFrame == null) {
                String str2 = VideoQueue.TAG;
                StringBuilder a2 = a.a("remove early ts (");
                a2.append(this.mQueue.keyAt(i2));
                a2.append(",");
                a2.append(j2);
                a2.append(")");
                Log.e(str2, a2.toString());
                this.mQueue.removeAt(i2);
                if (dualImageInfo.mRightFrame != null) {
                    String str3 = VideoQueue.TAG;
                    StringBuilder a3 = a.a(" type ");
                    a3.append(dualImageInfo.mRightFrame.type);
                    Log.e(str3, a3.toString());
                }
            } else {
                i2++;
            }
        }
        DualImageInfo dualImageInfo2 = (DualImageInfo) this.mQueue.get(j2);
        if (dualImageInfo2 == null) {
            DualImageInfo dualImageInfo3 = new DualImageInfo();
            dualImageInfo3.mLeftFrame = h2645Frame;
            this.mQueue.append(j2, dualImageInfo3);
            dropImage("left");
        } else if (dualImageInfo2.mRightFrame != null) {
            dualImageInfo2.mLeftFrame = h2645Frame;
            if (j2 > this.mQueue.keyAt(0)) {
                removeAtRange(0, this.mQueue.indexOfKey(j2) - 1);
            }
            this.mQueue.remove(j2);
            feedPipelineVideo(dualImageInfo2.mLeftFrame, dualImageInfo2.mRightFrame, j2);
        } else {
            throw new RuntimeException("dual enqueVideo null");
        }
    }

    public void feedPipelineVideo(H2645Frame h2645Frame, H2645Frame h2645Frame2, long j2) {
        ImageData imageData = new ImageData();
        imageData.data = h2645Frame.data;
        imageData.data_offset = h2645Frame.offset;
        imageData.data_size = h2645Frame.size;
        imageData.csd = this.mParser.getCsdData();
        int i2 = imageData.flags;
        FrameType frameType = h2645Frame.type;
        imageData.flags = ((frameType == FrameType.IDR || frameType == FrameType.IFrame) ? 1 : 0) | i2;
        imageData.timestampNs = j2;
        imageData.width = getPreviewWidth();
        imageData.height = getPreviewHeight();
        imageData.fps = getPreviewFps();
        imageData.mH265 = this.mH265;
        ImageData imageData2 = new ImageData();
        imageData2.data = h2645Frame2.data;
        imageData2.data_offset = h2645Frame2.offset;
        imageData2.data_size = h2645Frame2.size;
        imageData2.csd = this.mParserR.getCsdData();
        int i3 = imageData2.flags;
        FrameType frameType2 = h2645Frame2.type;
        imageData2.flags = ((frameType2 == FrameType.IDR || frameType2 == FrameType.IFrame) ? 1 : 0) | i3;
        imageData2.timestampNs = j2;
        imageData2.width = getPreviewWidth();
        imageData2.height = getPreviewHeight();
        imageData2.fps = getPreviewFps();
        imageData2.mH265 = this.mH265;
        putImage(new ImageData[]{imageData, imageData2});
    }

    public int getPreviewFps() {
        return this.mVideoParam.fps;
    }
}
