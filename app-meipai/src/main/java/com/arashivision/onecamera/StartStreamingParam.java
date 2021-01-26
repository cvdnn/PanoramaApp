package com.arashivision.onecamera;

import com.arashivision.onecamera.camerarequest.AudioParam;
import com.arashivision.onecamera.camerarequest.VideoParam;
import com.arashivision.onestream.Gyro.GyroType;

public class StartStreamingParam {
    public boolean diretionalZ;
    public boolean dualStream;
    public VideoParam firstVideoParam;
    public AudioParam mAudioParam;
    public GyroType mGyroType;
    public boolean mRecordOriginH264;
    public int previewNum;
    public VideoParam secVideoParam;

    public AudioParam getAudioParam() {
        return this.mAudioParam;
    }

    public VideoParam getFirstVideoParam() {
        return this.firstVideoParam;
    }

    public GyroType getGyroType() {
        return this.mGyroType;
    }

    public int getPreviewNum() {
        return this.previewNum;
    }

    public VideoParam getSecVideoParam() {
        return this.secVideoParam;
    }

    public boolean isDiretionalZ() {
        return this.diretionalZ;
    }

    public boolean isDualStream() {
        return this.dualStream;
    }

    public boolean isRecordOriginH264() {
        return this.mRecordOriginH264;
    }

    public void setAudioParam(AudioParam audioParam) {
        this.mAudioParam = audioParam;
    }

    public void setDiretionalZ(boolean z) {
        this.diretionalZ = z;
    }

    public void setDualStream(boolean z) {
        this.dualStream = z;
    }

    public void setFirstVideoParam(VideoParam videoParam) {
        this.firstVideoParam = videoParam;
    }

    public void setGyroType(GyroType gyroType) {
        this.mGyroType = gyroType;
    }

    public void setPreviewNum(int i2) {
        this.previewNum = i2;
    }

    public void setRecordOriginH264(boolean z) {
        this.mRecordOriginH264 = z;
    }

    public void setSecVideoParam(VideoParam videoParam) {
        this.secVideoParam = videoParam;
    }
}
