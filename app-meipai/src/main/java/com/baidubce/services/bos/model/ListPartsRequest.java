package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;

public class ListPartsRequest extends GenericUploadRequest {
    public int maxParts = -1;
    public int partNumberMarker;

    public ListPartsRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public void setMaxParts(int i2) {
        this.maxParts = i2;
    }

    public void setPartNumberMarker(int i2) {
        this.partNumberMarker = i2;
    }

    public ListPartsRequest withMaxParts(int i2) {
        this.maxParts = i2;
        return this;
    }

    public ListPartsRequest withPartNumberMarker(int i2) {
        setPartNumberMarker(i2);
        return this;
    }

    public ListPartsRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public ListPartsRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public ListPartsRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public ListPartsRequest withUploadId(String str) {
        setUploadId(str);
        return this;
    }
}
