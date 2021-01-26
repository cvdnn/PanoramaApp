package com.baidubce.services.bos.model;

import e.a.a.a.a;

public class PartETag {
    public String eTag;
    public int partNumber;

    public PartETag() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PartETag.class != obj.getClass()) {
            return false;
        }
        PartETag partETag = (PartETag) obj;
        String str = this.eTag;
        if (str == null) {
            if (partETag.eTag != null) {
                return false;
            }
        } else if (!str.equals(partETag.eTag)) {
            return false;
        }
        return this.partNumber == partETag.partNumber;
    }

    public String getETag() {
        return this.eTag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public int hashCode() {
        String str = this.eTag;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + this.partNumber;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setPartNumber(int i2) {
        this.partNumber = i2;
    }

    public String toString() {
        StringBuilder a2 = a.a("PartETag [partNumber=");
        a2.append(this.partNumber);
        a2.append(", eTag=");
        return a.a(a2, this.eTag, "]");
    }

    public PartETag withETag(String str) {
        setETag(str);
        return this;
    }

    public PartETag withPartNumber(int i2) {
        setPartNumber(i2);
        return this;
    }

    public PartETag(int i2, String str) {
        setPartNumber(i2);
        setETag(str);
    }
}
