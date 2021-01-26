package com.arashivision.onestream.pipeline;

import com.arashivision.onestream.ImageData;
import com.arashivision.onestream.OneStreamPipeline.RecordParam;

public interface ICameraPreviewPipeline {
    void onAudioStream(long j2, byte[] bArr);

    void onExposureStream(long j2, double d2);

    void onGyroStream(byte[] bArr, long j2);

    void onScreenCapture(int i2, int i3, String str, ICameraPreviewScreenCaptureCallback iCameraPreviewScreenCaptureCallback);

    void onStartLive(RecordParam recordParam, ICameraLivePipline iCameraLivePipline);

    void onStopLive();

    void onUpdatePreviewDelta(long j2);

    void onVideoStream(ImageData[] imageDataArr);
}
