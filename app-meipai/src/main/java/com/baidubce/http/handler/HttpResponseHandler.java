package com.baidubce.http.handler;

import com.baidubce.http.BceHttpResponse;
import com.baidubce.model.AbstractBceResponse;

public interface HttpResponseHandler {
    boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception;
}
