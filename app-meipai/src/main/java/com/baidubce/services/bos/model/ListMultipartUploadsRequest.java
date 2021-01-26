package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;

public class ListMultipartUploadsRequest extends GenericBucketRequest {
    public String delimiter;
    public String keyMarker;
    public int maxUploads;
    public String prefix;

    public ListMultipartUploadsRequest(String str) {
        this(str, null);
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public int getMaxUploads() {
        return this.maxUploads;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public void setMaxUploads(int i2) {
        this.maxUploads = i2;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListMultipartUploadsRequest withDelimiter(String str) {
        setDelimiter(str);
        return this;
    }

    public ListMultipartUploadsRequest withKeyMarker(String str) {
        this.keyMarker = str;
        return this;
    }

    public ListMultipartUploadsRequest withMaxUploads(int i2) {
        this.maxUploads = i2;
        return this;
    }

    public ListMultipartUploadsRequest withPrefix(String str) {
        setPrefix(str);
        return this;
    }

    public ListMultipartUploadsRequest(String str, String str2) {
        super(str);
        this.maxUploads = -1;
        this.prefix = str2;
    }

    public ListMultipartUploadsRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public ListMultipartUploadsRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
