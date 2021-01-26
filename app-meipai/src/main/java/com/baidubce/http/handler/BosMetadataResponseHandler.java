package com.baidubce.http.handler;

import com.baidubce.BceResponseMetadata;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.http.Headers;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.services.bos.model.BosResponseMetadata;

public class BosMetadataResponseHandler implements HttpResponseHandler {
    public boolean handle(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws Exception {
        BceResponseMetadata metadata = abstractBceResponse.getMetadata();
        if (metadata instanceof BosResponseMetadata) {
            BosResponseMetadata bosResponseMetadata = (BosResponseMetadata) metadata;
            bosResponseMetadata.setBosDebugId(bceHttpResponse.getHeader(Headers.BCE_DEBUG_ID));
            String str = Headers.BCE_NEXT_APPEND_OFFSET;
            if (bceHttpResponse.getHeader(str) != null) {
                bosResponseMetadata.setNextAppendOffset(Long.valueOf(Long.parseLong(bceHttpResponse.getHeader(str))));
            }
            String str2 = Headers.LOCATION;
            if (bceHttpResponse.getHeader(str2) != null) {
                metadata.setLocation(bceHttpResponse.getHeader(str2));
            }
        }
        return false;
    }
}
