package com.baidubce.services.bos.model;

import com.baidubce.services.bos.BosObjectInputStream;
import e.a.a.a.a;
import java.io.Closeable;
import java.io.IOException;

public class BosObject implements Closeable {
    public String bucketName = null;
    public String key = null;
    public BosObjectInputStream objectContent;
    public ObjectMetadata objectMetadata = new ObjectMetadata();

    public void close() throws IOException {
        if (getObjectContent() != null) {
            getObjectContent().close();
        }
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public BosObjectInputStream getObjectContent() {
        return this.objectContent;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setObjectContent(BosObjectInputStream bosObjectInputStream) {
        this.objectContent = bosObjectInputStream;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public String toString() {
        StringBuilder a2 = a.a("BosObject [bucketName=");
        a2.append(this.bucketName);
        a2.append(", key=");
        a2.append(this.key);
        a2.append(", metadata=");
        a2.append(this.objectMetadata);
        a2.append("]");
        return a2.toString();
    }
}
