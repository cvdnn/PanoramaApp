package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.util.CheckUtils;

public class GetObjectRequest extends GenericObjectRequest {
    public BosProgressCallback progressCallback = null;
    public long[] range;

    public GetObjectRequest() {
    }

    public BosProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public long[] getRange() {
        long[] jArr = this.range;
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public <T extends GetObjectRequest> void setProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
    }

    public void setRange(long j2, long j3) {
        CheckUtils.checkArgument(j2 >= 0, "start should be non-negative.");
        CheckUtils.checkArgument(j2 <= j3, "start should not be greater than end");
        this.range = new long[]{j2, j3};
    }

    public <T extends GetObjectRequest> GetObjectRequest withProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
        return this;
    }

    public GetObjectRequest withRange(long j2, long j3) {
        setRange(j2, j3);
        return this;
    }

    public GetObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public GetObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public GetObjectRequest(String str, String str2) {
        super(str, str2);
    }
}
