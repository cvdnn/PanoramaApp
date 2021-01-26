package com.baidubce.services.bos.model;

import e.a.a.a.a;
import java.util.Date;

public class BucketSummary {
    public Date creationDate = null;
    public String location = null;
    public String name = null;

    public BucketSummary() {
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("Bucket [name=");
        a2.append(this.name);
        a2.append(", creationDate=");
        a2.append(this.creationDate);
        a2.append("]");
        return a2.toString();
    }

    public BucketSummary(String str, String str2) {
        this.name = str;
        this.location = str2;
    }
}
