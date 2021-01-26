package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.util.CheckUtils;
import java.io.File;
import java.io.InputStream;

public class PutObjectRequest extends GenericObjectRequest {
    public File file;
    public InputStream inputStream;
    public ObjectMetadata objectMetadata;
    public BosProgressCallback progressCallback;
    public String storageClass;

    public PutObjectRequest(String str, String str2, File file2) {
        this(str, str2, file2, null, new ObjectMetadata());
        CheckUtils.isNotNull(file2, "file should not be null.");
    }

    public File getFile() {
        return this.file;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public BosProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public void setInputStream(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public <T extends PutObjectRequest> void setProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public PutObjectRequest withFile(File file2) {
        setFile(file2);
        return this;
    }

    public PutObjectRequest withInputStream(InputStream inputStream2) {
        setInputStream(inputStream2);
        return this;
    }

    public PutObjectRequest withObjectMetadata(ObjectMetadata objectMetadata2) {
        setObjectMetadata(objectMetadata2);
        return this;
    }

    public <T extends PutObjectRequest> PutObjectRequest withProgressCallback(BosProgressCallback<T> bosProgressCallback) {
        this.progressCallback = bosProgressCallback;
        return this;
    }

    public PutObjectRequest withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public PutObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public PutObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public PutObjectRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public PutObjectRequest(String str, String str2, File file2, ObjectMetadata objectMetadata2) {
        this(str, str2, file2, null, objectMetadata2);
        CheckUtils.isNotNull(file2, "file should not be null.");
        CheckUtils.isNotNull(objectMetadata2, "metadata should not be null.");
    }

    public PutObjectRequest(String str, String str2, InputStream inputStream2) {
        this(str, str2, null, inputStream2, new ObjectMetadata());
        CheckUtils.isNotNull(inputStream2, "inputStream should not be null.");
    }

    public PutObjectRequest(String str, String str2, InputStream inputStream2, ObjectMetadata objectMetadata2) {
        this(str, str2, null, inputStream2, objectMetadata2);
        CheckUtils.isNotNull(inputStream2, "inputStream should not be null.");
        CheckUtils.isNotNull(objectMetadata2, "metadata should not be null.");
    }

    public PutObjectRequest(String str, String str2, File file2, InputStream inputStream2, ObjectMetadata objectMetadata2) {
        super(str, str2);
        this.objectMetadata = new ObjectMetadata();
        this.progressCallback = null;
        this.file = file2;
        this.inputStream = inputStream2;
        this.objectMetadata = objectMetadata2;
    }
}
