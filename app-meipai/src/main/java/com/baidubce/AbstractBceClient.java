package com.baidubce;

import com.baidubce.auth.BceV1Signer;
import com.baidubce.callback.BceProgressCallback;
import com.baidubce.http.BceHttpClient;
import com.baidubce.http.Headers;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.DateUtils;
import e.a.a.a.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public abstract class AbstractBceClient {
    public static final String DEFAULT_CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String DEFAULT_SERVICE_DOMAIN = "baidubce.com";
    public static final String URL_PREFIX = "v1";
    public BceHttpClient client;
    public BceClientConfiguration config;
    public URI endpoint;
    public HttpResponseHandler[] responseHandlers;
    public String serviceId = computeServiceId();

    public AbstractBceClient(BceClientConfiguration bceClientConfiguration, HttpResponseHandler[] httpResponseHandlerArr) {
        this.config = bceClientConfiguration;
        this.endpoint = computeEndpoint();
        this.client = new BceHttpClient(bceClientConfiguration, new BceV1Signer());
        this.responseHandlers = httpResponseHandlerArr;
    }

    private URI computeEndpoint() {
        String endpoint2 = this.config.getEndpoint();
        if (endpoint2 == null) {
            try {
                boolean isRegionSupported = isRegionSupported();
                String str = DEFAULT_SERVICE_DOMAIN;
                if (isRegionSupported) {
                    endpoint2 = String.format("%s://%s.%s.%s", new Object[]{this.config.getProtocol(), this.serviceId, this.config.getRegion(), str});
                } else {
                    endpoint2 = String.format("%s://%s.%s", new Object[]{this.config.getProtocol(), this.serviceId, str});
                }
            } catch (URISyntaxException e2) {
                throw new IllegalArgumentException(a.a("Invalid endpoint.", endpoint2), e2);
            }
        }
        return new URI(endpoint2);
    }

    private String computeServiceId() {
        String name = getClass().getPackage().getName();
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractBceClient.class.getPackage().getName());
        sb.append(".services.");
        String sb2 = sb.toString();
        if (name.startsWith(sb2)) {
            String substring = name.substring(sb2.length());
            if (substring.indexOf(46) == -1) {
                String name2 = getClass().getName();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(name);
                sb3.append('.');
                sb3.append(Character.toUpperCase(substring.charAt(0)));
                sb3.append(substring.substring(1));
                sb3.append("Client");
                String sb4 = sb3.toString();
                if (name2.equals(sb4)) {
                    return substring;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Invalid class name ");
                sb5.append(name2);
                sb5.append(", ");
                sb5.append(sb4);
                sb5.append(" expected");
                throw new IllegalStateException(sb5.toString());
            }
            throw new IllegalStateException(a.a("The client class should be put in package like ", sb2, "XXX"));
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("Unrecognized prefix for the client package : ");
        sb6.append(name);
        sb6.append(", '");
        sb6.append(sb2);
        sb6.append("' expected");
        throw new IllegalStateException(sb6.toString());
    }

    public BceHttpClient getClient() {
        return this.client;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T invokeHttpClient(InternalRequest<M> internalRequest, Class<T> cls) {
        return invokeHttpClient(internalRequest, cls, null);
    }

    public boolean isRegionSupported() {
        return true;
    }

    public void setClient(BceHttpClient bceHttpClient) {
        this.client = bceHttpClient;
    }

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T invokeHttpClient(InternalRequest<M> internalRequest, Class<T> cls, BceProgressCallback<M> bceProgressCallback) {
        String str = "Content-Type";
        if (!internalRequest.getHeaders().containsKey(str)) {
            internalRequest.addHeader(str, DEFAULT_CONTENT_TYPE);
        }
        Map headers = internalRequest.getHeaders();
        String str2 = Headers.DATE;
        if (!headers.containsKey(str2)) {
            internalRequest.addHeader(str2, DateUtils.rfc822DateFormat());
        }
        return this.client.execute(internalRequest, cls, this.responseHandlers, bceProgressCallback);
    }
}
