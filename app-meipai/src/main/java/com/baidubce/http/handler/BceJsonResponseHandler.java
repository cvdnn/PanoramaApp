package com.baidubce.http.handler;

public class BceJsonResponseHandler implements HttpResponseHandler {
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if ("chunked".equalsIgnoreCase(r7.getMetadata().getTransferEncoding()) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handle(com.baidubce.http.BceHttpResponse r6, com.baidubce.model.AbstractBceResponse r7) throws java.lang.Exception {
        /*
            r5 = this;
            java.io.InputStream r0 = r6.getContent()
            if (r0 == 0) goto L_0x002a
            com.baidubce.BceResponseMetadata r1 = r7.getMetadata()
            long r1 = r1.getContentLength()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0024
            com.baidubce.BceResponseMetadata r1 = r7.getMetadata()
            java.lang.String r1 = r1.getTransferEncoding()
            java.lang.String r2 = "chunked"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0027
        L_0x0024:
            com.baidubce.util.JsonUtils.load(r6, r7)
        L_0x0027:
            r0.close()
        L_0x002a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.http.handler.BceJsonResponseHandler.handle(com.baidubce.http.BceHttpResponse, com.baidubce.model.AbstractBceResponse):boolean");
    }
}
