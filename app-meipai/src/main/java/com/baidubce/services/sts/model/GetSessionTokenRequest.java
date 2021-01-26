package com.baidubce.services.sts.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;

public class GetSessionTokenRequest extends AbstractBceRequest {
    public String acl;
    public Integer durationSeconds = Integer.valueOf(43200);

    public String getAcl() {
        return this.acl;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public void setAcl(String str) {
        this.acl = str;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public GetSessionTokenRequest withAcl(String str) {
        this.acl = str;
        return this;
    }

    public GetSessionTokenRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public GetSessionTokenRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
