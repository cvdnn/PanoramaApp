package com.baidubce;

import e.a.a.a.a;
import java.util.Date;

public class BceResponseMetadata {
    public String bceContentSha256;
    public String bceRequestId;
    public String contentDisposition;
    public String contentEncoding;
    public long contentLength = -1;
    public String contentMd5;
    public String contentRange;
    public String contentType;
    public Long crc32;
    public Date date;
    public String eTag;
    public Date expires;
    public Date lastModified;
    public String location;
    public String server;
    public String transferEncoding;

    public String getBceContentSha256() {
        return this.bceContentSha256;
    }

    public String getBceRequestId() {
        return this.bceRequestId;
    }

    public String getContentDisposition() {
        return this.contentDisposition;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public String getContentRange() {
        return this.contentRange;
    }

    public String getContentType() {
        return this.contentType;
    }

    public Long getCrc32() {
        return this.crc32;
    }

    public Date getDate() {
        return this.date;
    }

    public String getETag() {
        return this.eTag;
    }

    public Date getExpires() {
        return this.expires;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public String getLocation() {
        return this.location;
    }

    public String getServer() {
        return this.server;
    }

    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public void setBceContentSha256(String str) {
        this.bceContentSha256 = str;
    }

    public void setBceRequestId(String str) {
        this.bceRequestId = str;
    }

    public void setContentDisposition(String str) {
        this.contentDisposition = str;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public void setContentLength(long j2) {
        this.contentLength = j2;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public void setContentRange(String str) {
        this.contentRange = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setCrc32(Long l) {
        this.crc32 = l;
    }

    public void setDate(Date date2) {
        this.date = date2;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setExpires(Date date2) {
        this.expires = date2;
    }

    public void setLastModified(Date date2) {
        this.lastModified = date2;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setServer(String str) {
        this.server = str;
    }

    public void setTransferEncoding(String str) {
        this.transferEncoding = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("BceResponseMetadata [\n  bceRequestId=");
        a2.append(this.bceRequestId);
        a2.append(", \n  bceContentSha256=");
        a2.append(this.bceContentSha256);
        a2.append(", \n  contentDisposition=");
        a2.append(this.contentDisposition);
        a2.append(", \n  contentEncoding=");
        a2.append(this.contentEncoding);
        a2.append(", \n  contentLength=");
        a2.append(this.contentLength);
        a2.append(", \n  contentMd5=");
        a2.append(this.contentMd5);
        a2.append(", \n  contentRange=");
        a2.append(this.contentRange);
        a2.append(", \n  contentType=");
        a2.append(this.contentType);
        a2.append(", \n  date=");
        a2.append(this.date);
        a2.append(", \n  eTag=");
        a2.append(this.eTag);
        a2.append(", \n  expires=");
        a2.append(this.expires);
        a2.append(", \n  lastModified=");
        a2.append(this.lastModified);
        a2.append(", \n  server=");
        a2.append(this.server);
        a2.append(", \n  location=");
        return a.a(a2, this.location, "]");
    }
}
