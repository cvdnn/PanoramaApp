package com.baidubce.services.bos.model;

public class GetObjectResponse extends BosResponse {
    public BosObject object;

    public BosObject getObject() {
        return this.object;
    }

    public void setObject(BosObject bosObject) {
        this.object = bosObject;
    }
}
