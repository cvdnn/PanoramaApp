package com.baidu.picapture.common.bos.beans;

import e.c.d.d.a.p;
import e.c.d.d.a.r;
import g.e;

public class UploadTask {
    public e mBosKeyCall;
    public r mBosUploader;
    public String mBucketKey;
    public e mCheckStorageCall;
    public String mFilePath;
    public int mStatus = 1;
    public String mUploadId;
    public p mUploadListener;

    public interface Status {
        public static final int CHECK_STORAGE = 2;
        public static final int GET_BOS_KEY = 3;
        public static final int UPLOADING = 4;
        public static final int WAIT_UPLOAD = 1;
    }

    public UploadTask(String str, String str2, String str3, p pVar) {
        this.mFilePath = str;
        this.mBucketKey = str2;
        this.mUploadId = str3;
        this.mUploadListener = pVar;
    }

    public e getBosKeyCall() {
        return this.mBosKeyCall;
    }

    public r getBosUploader() {
        return this.mBosUploader;
    }

    public String getBucketKey() {
        return this.mBucketKey;
    }

    public e getCheckStorageCall() {
        return this.mCheckStorageCall;
    }

    public String getFilePath() {
        return this.mFilePath;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getUploadId() {
        return this.mUploadId;
    }

    public p getUploadListener() {
        return this.mUploadListener;
    }

    public void setBosKeyCall(e eVar) {
        this.mBosKeyCall = eVar;
    }

    public void setBosUploader(r rVar) {
        this.mBosUploader = rVar;
    }

    public void setCheckStorageCall(e eVar) {
        this.mCheckStorageCall = eVar;
    }

    public void setStatus(int i2) {
        this.mStatus = i2;
    }

    public void setUploadId(String str) {
        this.mUploadId = str;
    }
}
