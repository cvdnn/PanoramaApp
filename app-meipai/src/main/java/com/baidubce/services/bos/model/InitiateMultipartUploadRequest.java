package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;

public class InitiateMultipartUploadRequest extends GenericObjectRequest {
    public ObjectMetadata objectMetadata = new ObjectMetadata();
    public String storageClass;

    public InitiateMultipartUploadRequest(String str, String str2) {
        super(str, str2);
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public InitiateMultipartUploadRequest withMetadata(ObjectMetadata objectMetadata2) {
        setObjectMetadata(objectMetadata2);
        return this;
    }

    public InitiateMultipartUploadRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public InitiateMultipartUploadRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public InitiateMultipartUploadRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public InitiateMultipartUploadRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
