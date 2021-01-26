package com.baidubce.services.bos.model;

import com.baidubce.model.User;
import e.a.a.a.a;
import java.util.Date;

public class BosObjectSummary {
    public String bucketName;
    public String eTag;
    public String key;
    public Date lastModified;
    public User owner;
    public long size;
    public String storageClass;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getKey() {
        return this.key;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public User getOwner() {
        return this.owner;
    }

    public long getSize() {
        return this.size;
    }

    public String getStorageClass() {
        return this.storageClass;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public void setSize(long j2) {
        this.size = j2;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("BosObjectSummary [\n  bucketName=");
        a2.append(this.bucketName);
        a2.append(", \n  key=");
        a2.append(this.key);
        a2.append(", \n  eTag=");
        a2.append(this.eTag);
        a2.append(", \n  size=");
        a2.append(this.size);
        a2.append(", \n  lastModified=");
        a2.append(this.lastModified);
        a2.append(", \n  owner=");
        a2.append(this.owner);
        a2.append(", \n  storageClass=");
        return a.a(a2, this.storageClass, "\n]");
    }
}
