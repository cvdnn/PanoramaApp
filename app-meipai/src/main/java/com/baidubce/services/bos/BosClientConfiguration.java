package com.baidubce.services.bos;

import com.baidubce.BceClientConfiguration;
import com.baidubce.Protocol;
import com.baidubce.Region;
import com.baidubce.auth.BceCredentials;
import com.baidubce.http.RetryPolicy;
import com.baidubce.util.CheckUtils;
import java.net.InetAddress;

public class BosClientConfiguration extends BceClientConfiguration {
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 5242880;
    public Boolean cnameEnabled;
    public int streamBufferSize = DEFAULT_STREAM_BUFFER_SIZE;

    public int getStreamBufferSize() {
        return this.streamBufferSize;
    }

    public Boolean isCnameEnabled() {
        return this.cnameEnabled;
    }

    public void setCnameEnabled(Boolean bool) {
        this.cnameEnabled = bool;
    }

    public void setStreamBufferSize(int i2) {
        CheckUtils.checkArgument(i2 > 0, "streamBufferSize should be positive.");
        this.streamBufferSize = i2;
    }

    public BosClientConfiguration withCnameEnabled(Boolean bool) {
        setCnameEnabled(bool);
        return this;
    }

    public BceClientConfiguration withProxyPreemptiveAuthenticationEnabled(boolean z) {
        setProxyPreemptiveAuthenticationEnabled(z);
        return this;
    }

    public BosClientConfiguration withStreamBufferSize(int i2) {
        setStreamBufferSize(i2);
        return this;
    }

    public BosClientConfiguration withConnectionTimeoutInMillis(int i2) {
        setConnectionTimeoutInMillis(i2);
        return this;
    }

    public BosClientConfiguration withCredentials(BceCredentials bceCredentials) {
        setCredentials(bceCredentials);
        return this;
    }

    public BosClientConfiguration withEndpoint(String str) {
        setEndpoint(str);
        return this;
    }

    public BosClientConfiguration withLocalAddress(InetAddress inetAddress) {
        setLocalAddress(inetAddress);
        return this;
    }

    public BosClientConfiguration withMaxConnections(int i2) {
        setMaxConnections(i2);
        return this;
    }

    public BosClientConfiguration withProtocol(Protocol protocol) {
        setProtocol(protocol);
        return this;
    }

    public BosClientConfiguration withProxyDomain(String str) {
        setProxyDomain(str);
        return this;
    }

    public BosClientConfiguration withProxyHost(String str) {
        setProxyHost(str);
        return this;
    }

    public BosClientConfiguration withProxyPassword(String str) {
        setProxyPassword(str);
        return this;
    }

    public BosClientConfiguration withProxyPort(int i2) {
        setProxyPort(i2);
        return this;
    }

    public BosClientConfiguration withProxyUsername(String str) {
        setProxyUsername(str);
        return this;
    }

    public BosClientConfiguration withProxyWorkstation(String str) {
        setProxyWorkstation(str);
        return this;
    }

    public BosClientConfiguration withRegion(Region region) {
        setRegion(region);
        return this;
    }

    public BosClientConfiguration withRetryPolicy(RetryPolicy retryPolicy) {
        setRetryPolicy(retryPolicy);
        return this;
    }

    public BosClientConfiguration withSocketBufferSizeInBytes(int i2) {
        setSocketBufferSizeInBytes(i2);
        return this;
    }

    public BosClientConfiguration withSocketTimeoutInMillis(int i2) {
        setSocketTimeoutInMillis(i2);
        return this;
    }

    public BosClientConfiguration withUserAgent(String str) {
        setUserAgent(str);
        return this;
    }
}
