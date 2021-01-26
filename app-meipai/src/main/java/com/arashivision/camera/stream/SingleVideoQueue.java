package com.arashivision.camera.stream;

import android.util.Log;
import com.arashivision.camera.strategy.TraceUtil;
import com.arashivision.onecamera.util.H2645Parser.FrameType;
import com.arashivision.onecamera.util.H2645Parser.H2645Frame;
import com.arashivision.onestream.ImageData;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.pipeline.ICameraPreviewPipeline;
import e.a.a.a.a;

public class SingleVideoQueue extends VideoQueue {
    public SingleVideoQueue(int i2, OneStreamPipeline oneStreamPipeline, ICameraPreviewPipeline iCameraPreviewPipeline) {
        super(i2, oneStreamPipeline, iCameraPreviewPipeline);
    }

    private void putImage(ImageData[] imageDataArr) {
        ICameraPreviewPipeline iCameraPreviewPipeline = this.mICameraPreviewPipeline;
        if (iCameraPreviewPipeline != null) {
            iCameraPreviewPipeline.onVideoStream(imageDataArr);
        } else {
            this.mImagePipeline.putImage(imageDataArr[0]);
        }
    }

    public void clear() {
    }

    public void enqueSecVideo(H2645Frame h2645Frame, long j2) {
    }

    public void enqueVideo(H2645Frame h2645Frame, long j2) {
        feedPipelineVideo(h2645Frame, j2);
    }

    public void feedPipelineVideo(H2645Frame h2645Frame, long j2) {
        ImageData imageData = new ImageData();
        imageData.data = h2645Frame.data;
        imageData.data_offset = h2645Frame.offset;
        imageData.data_size = h2645Frame.size;
        imageData.csd = this.mParser.getCsdData();
        int i2 = imageData.flags;
        FrameType frameType = h2645Frame.type;
        imageData.flags = i2 | ((frameType == FrameType.IDR || frameType == FrameType.IFrame) ? 1 : 0);
        imageData.timestampNs = j2;
        imageData.width = getPreviewWidth();
        imageData.height = getPreviewHeight();
        imageData.fps = getPreviewFps();
        imageData.mH265 = this.mH265;
        if (TraceUtil.TRACE) {
            String str = VideoQueue.TAG;
            StringBuilder a2 = a.a("put video packet: offset: ");
            a2.append(imageData.data_offset);
            a2.append(", size: ");
            a2.append(imageData.data_size);
            a2.append(", type: ");
            a2.append(h2645Frame.type);
            a2.append(" , flags ");
            a2.append(imageData.flags);
            a2.append(" imageData.mH265 ");
            a2.append(imageData.mH265);
            a2.append(", start bytes: ");
            a2.append(imageData.data[imageData.data_offset]);
            String str2 = ", ";
            a2.append(str2);
            a2.append(imageData.data[imageData.data_offset + 1]);
            a2.append(str2);
            a2.append(imageData.data[imageData.data_offset + 2]);
            a2.append(" frameSysTimeNs ");
            a2.append(j2);
            Log.i(str, a2.toString());
        }
        putImage(new ImageData[]{imageData});
    }

    public int getPreviewFps() {
        return this.mVideoParam.fps;
    }

    public int getPreviewHeight() {
        return this.mVideoParam.height;
    }

    public int getPreviewWidth() {
        return this.mVideoParam.width;
    }
}
