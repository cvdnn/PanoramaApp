package com.baidubce.model;

import com.baidubce.BceResponseMetadata;

public class AbstractBceResponse {
    public BceResponseMetadata metadata = new BceResponseMetadata();

    public BceResponseMetadata getMetadata() {
        return this.metadata;
    }
}
