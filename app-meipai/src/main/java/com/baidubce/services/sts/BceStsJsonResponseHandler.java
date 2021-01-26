package com.baidubce.services.sts;

import com.baidubce.http.handler.BceJsonResponseHandler;

public class BceStsJsonResponseHandler extends BceJsonResponseHandler {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0029, code lost:
        if ("chunked".equalsIgnoreCase(r7.getMetadata().getTransferEncoding()) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(com.baidubce.http.BceHttpResponse r6, com.baidubce.model.AbstractBceResponse r7) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.baidubce.services.sts.model.GetSessionTokenResponse
            if (r0 == 0) goto L_0x0033
            r0 = r7
            com.baidubce.services.sts.model.GetSessionTokenResponse r0 = (com.baidubce.services.sts.model.GetSessionTokenResponse) r0
            java.io.InputStream r6 = r6.getContent()
            if (r6 == 0) goto L_0x0031
            com.baidubce.BceResponseMetadata r1 = r7.getMetadata()
            long r1 = r1.getContentLength()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x002b
            com.baidubce.BceResponseMetadata r7 = r7.getMetadata()
            java.lang.String r7 = r7.getTransferEncoding()
            java.lang.String r1 = "chunked"
            boolean r7 = r1.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002e
        L_0x002b:
            com.baidubce.util.JsonUtils.load(r6, r0)
        L_0x002e:
            r6.close()
        L_0x0031:
            r6 = 1
            return r6
        L_0x0033:
            boolean r6 = super.handle(r6, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.sts.BceStsJsonResponseHandler.handle(com.baidubce.http.BceHttpResponse, com.baidubce.model.AbstractBceResponse):boolean");
    }
}
