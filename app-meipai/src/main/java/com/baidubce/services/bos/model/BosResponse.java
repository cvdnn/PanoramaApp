package com.baidubce.services.bos.model;

import com.baidubce.model.AbstractBceResponse;

public class BosResponse extends AbstractBceResponse {
    public BosResponseMetadata getMetadata() {
        return (BosResponseMetadata) this.metadata;
    }
}
