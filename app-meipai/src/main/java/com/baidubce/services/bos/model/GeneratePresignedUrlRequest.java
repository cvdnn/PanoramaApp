package com.baidubce.services.bos.model;

import com.baidubce.auth.BceCredentials;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.AbstractBceRequest;
import java.util.HashMap;
import java.util.Map;

public class GeneratePresignedUrlRequest extends AbstractBceRequest {
    public String bucketName;
    public String contentMd5;
    public String contentType;
    public int expirationInSeconds;
    public String key;
    public HttpMethodName method;
    public Map<String, String> requestHeaders;
    public Map<String, String> requestParameters;
    public ResponseHeaderOverrides responseHeaders;

    public GeneratePresignedUrlRequest(String str, String str2) {
        this(str, str2, HttpMethodName.GET);
    }

    public void addRequestHeaders(String str, String str2) {
        this.requestHeaders.put(str, str2);
    }

    public void addRequestParameter(String str, String str2) {
        this.requestParameters.put(str, str2);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public String getContentType() {
        return this.contentType;
    }

    public int getExpiration() {
        return this.expirationInSeconds;
    }

    public String getKey() {
        return this.key;
    }

    public HttpMethodName getMethod() {
        return this.method;
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public Map<String, String> getRequestParameters() {
        return this.requestParameters;
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setContentMd5(String str) {
        this.contentMd5 = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setExpiration(int i2) {
        this.expirationInSeconds = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMethod(HttpMethodName httpMethodName) {
        this.method = httpMethodName;
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        this.responseHeaders = responseHeaderOverrides;
    }

    public GeneratePresignedUrlRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GeneratePresignedUrlRequest withContentMd5(String str) {
        this.contentMd5 = str;
        return this;
    }

    public GeneratePresignedUrlRequest withContentType(String str) {
        setContentType(str);
        return this;
    }

    public GeneratePresignedUrlRequest withExpiration(int i2) {
        setExpiration(i2);
        return this;
    }

    public GeneratePresignedUrlRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public GeneratePresignedUrlRequest withMethod(HttpMethodName httpMethodName) {
        setMethod(httpMethodName);
        return this;
    }

    public GeneratePresignedUrlRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        setResponseHeaders(responseHeaderOverrides);
        return this;
    }

    public GeneratePresignedUrlRequest(String str, String str2, HttpMethodName httpMethodName) {
        this.expirationInSeconds = -1;
        this.requestParameters = new HashMap();
        this.requestHeaders = new HashMap();
        this.bucketName = str;
        this.key = str2;
        this.method = httpMethodName;
    }

    public GeneratePresignedUrlRequest withRequestCredentials(BceCredentials bceCredentials) {
        setRequestCredentials(bceCredentials);
        return this;
    }
}
