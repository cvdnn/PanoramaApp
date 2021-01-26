package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;

public class GetBucketLocationRequest extends GenericBucketRequest {
    public GetBucketLocationRequest(String str) {
        super(str);
    }

    public GetBucketLocationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetBucketLocationRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
