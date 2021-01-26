package com.baidubce.internal;

import com.baidubce.auth.BceCredentials;
import com.baidubce.auth.SignOptions;
import com.baidubce.http.HttpMethodName;
import com.baidubce.model.AbstractBceRequest;
import e.a.a.a.a;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class InternalRequest<T extends AbstractBceRequest> {
    public RestartableInputStream content;
    public BceCredentials credentials;
    public boolean expectContinueEnabled;
    public Map<String, String> headers = new HashMap();
    public HttpMethodName httpMethod;
    public Map<String, String> parameters = new HashMap();
    public T request;
    public SignOptions signOptions;
    public URI uri;

    public InternalRequest(HttpMethodName httpMethodName, URI uri2) {
        this.httpMethod = httpMethodName;
        this.uri = uri2;
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public void addParameter(String str, String str2) {
        this.parameters.put(str, str2);
    }

    public RestartableInputStream getContent() {
        return this.content;
    }

    public BceCredentials getCredentials() {
        return this.credentials;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public HttpMethodName getHttpMethod() {
        return this.httpMethod;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public T getRequest() {
        return this.request;
    }

    public SignOptions getSignOptions() {
        return this.signOptions;
    }

    public URI getUri() {
        return this.uri;
    }

    public boolean isExpectContinueEnabled() {
        return this.expectContinueEnabled;
    }

    public void setContent(RestartableInputStream restartableInputStream) {
        this.content = restartableInputStream;
    }

    public void setCredentials(BceCredentials bceCredentials) {
        this.credentials = bceCredentials;
    }

    public void setExpectContinueEnabled(boolean z) {
        this.expectContinueEnabled = z;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers.clear();
        this.headers.putAll(map);
    }

    public void setParameters(Map<String, String> map) {
        this.parameters.clear();
        this.parameters.putAll(map);
    }

    public void setRequest(T t) {
        this.request = t;
    }

    public void setSignOptions(SignOptions signOptions2) {
        this.signOptions = signOptions2;
    }

    public String toString() {
        StringBuilder a2 = a.a("InternalRequest [httpMethod=");
        a2.append(this.httpMethod);
        a2.append(", uri=");
        a2.append(this.uri);
        a2.append(", expectContinueEnabled=");
        a2.append(this.expectContinueEnabled);
        a2.append(", parameters=");
        a2.append(this.parameters);
        a2.append(", headers=");
        a2.append(this.headers);
        a2.append("]");
        return a2.toString();
    }
}
