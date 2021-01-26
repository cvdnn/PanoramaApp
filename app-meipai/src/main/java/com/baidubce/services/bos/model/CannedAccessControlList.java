package com.baidubce.services.bos.model;

public enum CannedAccessControlList {
    Private("private"),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write");
    
    public final String cannedAclHeader;

    /* access modifiers changed from: public */
    CannedAccessControlList(String str) {
        this.cannedAclHeader = str;
    }

    public String toString() {
        return this.cannedAclHeader;
    }
}
