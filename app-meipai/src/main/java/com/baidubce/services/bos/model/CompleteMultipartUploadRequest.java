package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.util.CheckUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompleteMultipartUploadRequest extends GenericUploadRequest {
    public ObjectMetadata objectMetadata;
    public List<PartETag> partETags;

    public CompleteMultipartUploadRequest() {
        this.objectMetadata = new ObjectMetadata();
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public List<PartETag> getPartETags() {
        return this.partETags;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public void setPartETags(List<PartETag> list) {
        CheckUtils.isNotNull(list, "partETags should not be null.");
        for (int i2 = 0; i2 < list.size(); i2++) {
            PartETag partETag = (PartETag) list.get(i2);
            CheckUtils.isNotNull(partETag, "partETags[%s] should not be null.", Integer.valueOf(i2));
            int partNumber = partETag.getPartNumber();
            CheckUtils.checkArgument(partNumber > 0, "partNumber should be positive. partETags[%s].partNumber:%s", Integer.valueOf(i2), Integer.valueOf(partNumber));
            CheckUtils.isNotNull(partETag.getETag(), "partETags[%s].eTag should not be null.", Integer.valueOf(i2));
        }
        Collections.sort(list, new Comparator<PartETag>() {
            public int compare(PartETag partETag, PartETag partETag2) {
                return partETag.getPartNumber() - partETag2.getPartNumber();
            }
        });
        int i3 = 0;
        int i4 = 0;
        while (i3 < list.size()) {
            int partNumber2 = ((PartETag) list.get(i3)).getPartNumber();
            CheckUtils.checkArgument(partNumber2 != i4, "Duplicated partNumber %s.", Integer.valueOf(partNumber2));
            i3++;
            i4 = partNumber2;
        }
        this.partETags = list;
    }

    public CompleteMultipartUploadRequest withObjectMetadata(ObjectMetadata objectMetadata2) {
        setObjectMetadata(objectMetadata2);
        return this;
    }

    public CompleteMultipartUploadRequest withPartETags(List<PartETag> list) {
        setPartETags(list);
        return this;
    }

    public CompleteMultipartUploadRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public CompleteMultipartUploadRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public CompleteMultipartUploadRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }

    public CompleteMultipartUploadRequest withUploadId(String str) {
        setUploadId(str);
        return this;
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list) {
        this(str, str2, str3, list, null);
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata2) {
        super(str, str2, str3);
        this.objectMetadata = new ObjectMetadata();
        this.partETags = list;
        this.objectMetadata = objectMetadata2;
    }
}
