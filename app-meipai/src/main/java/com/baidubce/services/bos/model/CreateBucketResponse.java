package com.baidubce.services.bos.model;

public class CreateBucketResponse {
    public String location = null;
    public String name = null;

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
