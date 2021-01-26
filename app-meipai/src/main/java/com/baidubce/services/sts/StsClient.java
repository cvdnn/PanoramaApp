package com.baidubce.services.sts;

import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientConfiguration;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceMetadataResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.services.sts.model.GetSessionTokenRequest;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;

public class StsClient extends AbstractBceClient {
    public static final String GET_SESSION_TOKEN_PATH = "sessionToken";
    public static HttpResponseHandler[] stsHandlers = {new BceMetadataResponseHandler(), new BceErrorResponseHandler(), new BceStsJsonResponseHandler()};

    public StsClient() {
        this(new BceClientConfiguration());
    }

    public GetSessionTokenResponse getSessionToken() {
        return getSessionToken(new GetSessionTokenRequest());
    }

    public StsClient(BceClientConfiguration bceClientConfiguration) {
        super(bceClientConfiguration, stsHandlers);
    }

    public GetSessionTokenResponse getSessionToken(GetSessionTokenRequest getSessionTokenRequest) {
        CheckUtils.isNotNull(getSessionTokenRequest, "The parameter request should NOT be null.");
        int i2 = 0;
        CheckUtils.checkArgument(getSessionTokenRequest.getDurationSeconds().intValue() > 0, "the durationSeconds parameter should be greater than zero");
        InternalRequest internalRequest = new InternalRequest(HttpMethodName.POST, HttpUtils.appendUri(getEndpoint(), AbstractBceClient.URL_PREFIX, GET_SESSION_TOKEN_PATH));
        if (getSessionTokenRequest.getDurationSeconds() != null) {
            internalRequest.addParameter("durationSeconds", String.valueOf(getSessionTokenRequest.getDurationSeconds()));
        }
        internalRequest.setCredentials(getSessionTokenRequest.getRequestCredentials());
        if (getSessionTokenRequest.getAcl() != null) {
            i2 = getSessionTokenRequest.getAcl().length();
        }
        internalRequest.addHeader("Content-Length", String.valueOf(i2));
        internalRequest.addHeader("Content-Type", "application/json");
        if (getSessionTokenRequest.getAcl() != null) {
            internalRequest.setContent(RestartableInputStream.wrap(getSessionTokenRequest.getAcl().getBytes()));
        }
        return (GetSessionTokenResponse) invokeHttpClient(internalRequest, GetSessionTokenResponse.class);
    }
}
