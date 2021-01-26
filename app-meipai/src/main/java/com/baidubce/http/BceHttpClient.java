package com.baidubce.http;

import android.annotation.SuppressLint;
import com.baidubce.BceClientConfiguration;
import com.baidubce.BceClientException;
import com.baidubce.auth.Signer;
import com.baidubce.callback.BceProgressCallback;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;
import com.tencent.connect.common.Constants;
import g.d0.c;
import g.s;
import g.s.a;
import g.t;
import g.u;
import g.u.b;
import g.y;
import g.z;
import h.f;
import h.o;
import h.x;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

@SuppressLint({"NewApi"})
public class BceHttpClient {
    public static final HttpClientFactory httpClientFactory = new HttpClientFactory();
    public final BceClientConfiguration config;
    public long diffMillis;
    public u httpClient;
    public final Signer signer;

    public class BceServiceRequestBody<T extends AbstractBceRequest> extends y {
        public BceProgressCallback<T> callback;
        public long length;
        public t mediaType;
        public T request;
        public InputStream restartableInputStream;

        public BceServiceRequestBody(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
            if (internalRequest.getContent() != null) {
                this.mediaType = t.a((String) internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = bceProgressCallback;
                this.request = internalRequest.getRequest();
            }
        }

        private long getContentLength(InternalRequest<T> internalRequest) {
            String str = (String) internalRequest.getHeaders().get("Content-Length");
            if (str != null) {
                return Long.parseLong(str);
            }
            return 0;
        }

        public long contentLength() throws IOException {
            return this.length;
        }

        public t contentType() {
            return this.mediaType;
        }

        public void writeTo(f fVar) throws IOException {
            long contentLength = contentLength();
            x a2 = o.a(this.restartableInputStream);
            long j2 = 0;
            while (j2 < contentLength) {
                long read = a2.read(fVar.c(), Math.min(contentLength - j2, BceHttpClient.this.config.getUploadSegmentPart()));
                if (read == -1) {
                    break;
                }
                long j3 = j2 + read;
                fVar.flush();
                BceProgressCallback<T> bceProgressCallback = this.callback;
                if (bceProgressCallback != null) {
                    bceProgressCallback.onProgress(this.request, j3, contentLength);
                }
                j2 = j3;
            }
            if (a2 != null) {
                a2.close();
            }
        }

        public BceServiceRequestBody(InternalRequest<T> internalRequest) {
            if (internalRequest.getContent() != null) {
                this.mediaType = t.a((String) internalRequest.getHeaders().get("Content-Type"));
                this.restartableInputStream = internalRequest.getContent();
                this.length = getContentLength(internalRequest);
                this.callback = null;
                this.request = internalRequest.getRequest();
            }
        }
    }

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, Signer signer2) {
        this(bceClientConfiguration, httpClientFactory.createHttpClient(bceClientConfiguration), signer2);
    }

    public <T extends AbstractBceRequest> u addResponseProgressCallback(final T t, final BceProgressCallback<T> bceProgressCallback) {
        u uVar = this.httpClient;
        if (uVar != null) {
            b bVar = new b(uVar);
            bVar.f9576f.add(new s() {
                public z intercept(a aVar) throws IOException {
                    z a2 = ((g.d0.f.f) aVar).a(((g.d0.f.f) aVar).f9242f);
                    if (a2 != null) {
                        z.a aVar2 = new z.a(a2);
                        aVar2.f9630g = new BceServiceResponseBody(a2.f9620g, t, bceProgressCallback);
                        return aVar2.a();
                    }
                    throw null;
                }
            });
            return new u(bVar);
        }
        throw null;
    }

    public <T extends AbstractBceRequest> g.x createHttpRequest(InternalRequest<T> internalRequest, BceProgressCallback<T> bceProgressCallback) {
        String aSCIIString = internalRequest.getUri().toASCIIString();
        String canonicalQueryString = HttpUtils.getCanonicalQueryString(internalRequest.getParameters(), false);
        if (canonicalQueryString.length() > 0) {
            aSCIIString = e.a.a.a.a.a(aSCIIString, "?", canonicalQueryString);
        }
        g.x.a aVar = new g.x.a();
        aVar.a(aSCIIString);
        if (internalRequest.getHttpMethod() == HttpMethodName.GET) {
            aVar.b();
        } else if (internalRequest.getHttpMethod() == HttpMethodName.PUT) {
            String str = "PUT";
            if (internalRequest.getContent() != null) {
                aVar.a(str, (y) new BceServiceRequestBody(internalRequest, bceProgressCallback));
            } else {
                aVar.a(str, y.create((t) null, new byte[0]));
            }
        } else if (internalRequest.getHttpMethod() == HttpMethodName.POST) {
            RestartableInputStream content = internalRequest.getContent();
            String str2 = Constants.HTTP_POST;
            if (content != null) {
                aVar.a(str2, (y) new BceServiceRequestBody(internalRequest, bceProgressCallback));
            } else {
                aVar.a(str2, y.create((t) null, new byte[0]));
            }
        } else if (internalRequest.getHttpMethod() == HttpMethodName.DELETE) {
            aVar.a("DELETE", c.f9177d);
        } else if (internalRequest.getHttpMethod() == HttpMethodName.HEAD) {
            aVar.a("HEAD", (y) null);
        } else {
            StringBuilder a2 = e.a.a.a.a.a("Unknown HTTP method name: ");
            a2.append(internalRequest.getHttpMethod());
            throw new BceClientException(a2.toString());
        }
        for (Entry entry : internalRequest.getHeaders().entrySet()) {
            if (!((String) entry.getKey()).equalsIgnoreCase("Content-Length") && !((String) entry.getKey()).equalsIgnoreCase(Headers.HOST)) {
                aVar.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return aVar.a();
    }

    public <T extends AbstractBceResponse, M extends AbstractBceRequest> T execute(InternalRequest<M> internalRequest, Class<T> cls, HttpResponseHandler[] httpResponseHandlerArr) {
        return execute(internalRequest, cls, httpResponseHandlerArr, null);
    }

    public long getDelayBeforeNextRetryInMillis(InternalRequest internalRequest, BceClientException bceClientException, int i2, RetryPolicy retryPolicy) {
        int i3 = i2 - 1;
        if (i3 >= retryPolicy.getMaxErrorRetry()) {
            return -1;
        }
        return Math.min(retryPolicy.getMaxDelayInMillis(), retryPolicy.getDelayBeforeNextRetryInMillis(bceClientException, i3));
    }

    public BceHttpClient(BceClientConfiguration bceClientConfiguration, u uVar, Signer signer2) {
        this.diffMillis = 0;
        CheckUtils.isNotNull(bceClientConfiguration, "config should not be null.");
        CheckUtils.isNotNull(signer2, "signer should not be null.");
        this.config = bceClientConfiguration;
        this.httpClient = uVar;
        this.signer = signer2;
    }

    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v23, types: [com.baidubce.BceServiceException] */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25, types: [com.baidubce.BceClientException] */
    /* JADX WARNING: type inference failed for: r12v6, types: [com.baidubce.BceClientException] */
    /* JADX WARNING: type inference failed for: r12v9, types: [com.baidubce.BceClientException] */
    /* JADX WARNING: type inference failed for: r0v31, types: [com.baidubce.BceServiceException] */
    /* JADX WARNING: type inference failed for: r0v32, types: [com.baidubce.BceClientException] */
    /* JADX WARNING: type inference failed for: r0v46 */
    /* JADX WARNING: type inference failed for: r0v47 */
    /* JADX WARNING: type inference failed for: r0v48 */
    /* JADX WARNING: type inference failed for: r0v49 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0185 A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends com.baidubce.model.AbstractBceResponse, M extends com.baidubce.model.AbstractBceRequest> T execute(com.baidubce.internal.InternalRequest<M> r17, java.lang.Class<T> r18, com.baidubce.http.handler.HttpResponseHandler[] r19, com.baidubce.callback.BceProgressCallback<M> r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r3 = r19
            com.baidubce.BceClientConfiguration r0 = r1.config
            java.lang.String r0 = r0.getUserAgent()
            java.lang.String r4 = "User-Agent"
            r2.addHeader(r4, r0)
            com.baidubce.BceClientConfiguration r0 = r1.config
            java.lang.String r0 = r0.getAcceptEncoding()
            java.lang.String r4 = "Accept-Encoding"
            r2.addHeader(r4, r0)
            com.baidubce.BceClientConfiguration r0 = r1.config
            com.baidubce.auth.BceCredentials r0 = r0.getCredentials()
            com.baidubce.auth.BceCredentials r4 = r17.getCredentials()
            if (r4 == 0) goto L_0x002c
            com.baidubce.auth.BceCredentials r0 = r17.getCredentials()
        L_0x002c:
            r4 = r0
            r0 = 1
            r5 = 0
            java.lang.String r7 = ""
            r9 = r5
            r8 = r7
            r7 = r0
        L_0x0035:
            java.util.Calendar r0 = java.util.Calendar.getInstance()     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            long r9 = r0.getTimeInMillis()     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            java.util.Date r0 = new java.util.Date     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            long r11 = r1.diffMillis     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            long r11 = r11 + r9
            r0.<init>(r11)     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            com.baidubce.auth.SignOptions r11 = r17.getSignOptions()     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            if (r11 != 0) goto L_0x004e
            com.baidubce.auth.SignOptions r11 = com.baidubce.auth.SignOptions.DEFAULT     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            goto L_0x0052
        L_0x004e:
            com.baidubce.auth.SignOptions r11 = r17.getSignOptions()     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
        L_0x0052:
            r11.setTimestamp(r0)     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            r2.setSignOptions(r11)     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            long r11 = r1.diffMillis     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            int r11 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r11 == 0) goto L_0x0067
            java.lang.String r11 = "x-bce-date"
            java.lang.String r0 = com.baidubce.util.DateUtils.alternateIso8601DateFormat(r0)     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            r2.addHeader(r11, r0)     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
        L_0x0067:
            if (r4 == 0) goto L_0x006e
            com.baidubce.auth.Signer r0 = r1.signer     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            r0.sign(r2, r4)     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
        L_0x006e:
            g.u r0 = r1.httpClient     // Catch:{ BceServiceException -> 0x010d, BceClientException -> 0x0108, Exception -> 0x00e5 }
            r11 = r20
            g.x r12 = r1.createHttpRequest(r2, r11)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.model.AbstractBceRequest r13 = r17.getRequest()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            boolean r13 = r13 instanceof com.baidubce.services.bos.model.GetObjectRequest     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            if (r13 == 0) goto L_0x0095
            com.baidubce.model.AbstractBceRequest r0 = r17.getRequest()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.model.AbstractBceRequest r13 = r17.getRequest()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.services.bos.model.GetObjectRequest r13 = (com.baidubce.services.bos.model.GetObjectRequest) r13     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.services.bos.callback.BosProgressCallback r13 = r13.getProgressCallback()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            g.u r0 = r1.addResponseProgressCallback(r0, r13)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            java.lang.String r13 = "getObject"
            com.baidubce.util.BLog.debug(r13)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
        L_0x0095:
            g.e r0 = r0.a(r12)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.model.AbstractBceRequest r12 = r17.getRequest()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            if (r12 == 0) goto L_0x00b9
            com.baidubce.model.AbstractBceRequest r12 = r17.getRequest()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            r12.setCall(r0)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.model.AbstractBceRequest r12 = r17.getRequest()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            boolean r12 = r12.getCanceled()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            if (r12 != 0) goto L_0x00b1
            goto L_0x00b9
        L_0x00b1:
            com.baidubce.BceClientException r0 = new com.baidubce.BceClientException     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            java.lang.String r12 = "Request is canceled!"
            r0.<init>(r12)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            throw r0     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
        L_0x00b9:
            g.z r0 = r0.d()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.http.BceHttpResponse r12 = new com.baidubce.http.BceHttpResponse     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            r12.<init>(r0)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            java.lang.String r0 = "Date"
            java.lang.String r8 = r12.getHeader(r0)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            java.lang.Object r0 = r18.newInstance()     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            com.baidubce.model.AbstractBceResponse r0 = (com.baidubce.model.AbstractBceResponse) r0     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            int r13 = r3.length     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            r14 = 0
        L_0x00d0:
            if (r14 >= r13) goto L_0x00de
            r15 = r3[r14]     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            boolean r15 = r15.handle(r12, r0)     // Catch:{ BceServiceException -> 0x00e3, BceClientException -> 0x00e1, Exception -> 0x00df }
            if (r15 == 0) goto L_0x00db
            goto L_0x00de
        L_0x00db:
            int r14 = r14 + 1
            goto L_0x00d0
        L_0x00de:
            return r0
        L_0x00df:
            r0 = move-exception
            goto L_0x00e8
        L_0x00e1:
            r0 = move-exception
            goto L_0x010b
        L_0x00e3:
            r0 = move-exception
            goto L_0x0110
        L_0x00e5:
            r0 = move-exception
            r11 = r20
        L_0x00e8:
            com.baidubce.model.AbstractBceRequest r12 = r17.getRequest()
            if (r12 == 0) goto L_0x0100
            com.baidubce.model.AbstractBceRequest r12 = r17.getRequest()
            boolean r12 = r12.isCanceled()
            if (r12 == 0) goto L_0x0100
            com.baidubce.BceClientException r12 = new com.baidubce.BceClientException
            java.lang.String r13 = "Request is canceled!"
            r12.<init>(r13, r0)
            goto L_0x0138
        L_0x0100:
            com.baidubce.BceClientException r12 = new com.baidubce.BceClientException
            java.lang.String r13 = "Unable to execute HTTP request"
            r12.<init>(r13, r0)
            goto L_0x0138
        L_0x0108:
            r0 = move-exception
            r11 = r20
        L_0x010b:
            r12 = r0
            goto L_0x0138
        L_0x010d:
            r0 = move-exception
            r11 = r20
        L_0x0110:
            r12 = r0
            com.baidubce.ErrorCode r0 = com.baidubce.ErrorCode.REQUEST_TIME_TOO_SKEWED
            java.lang.String r13 = r12.getErrorCode()
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0138
            java.util.Date r0 = com.baidubce.util.DateUtils.parseRfc822Date(r8)
            java.lang.String r13 = ""
            boolean r13 = r8.equals(r13)
            if (r13 != 0) goto L_0x0138
            if (r0 == 0) goto L_0x0138
            monitor-enter(r16)
            long r13 = r0.getTime()     // Catch:{ all -> 0x0135 }
            long r13 = r13 - r9
            r1.diffMillis = r13     // Catch:{ all -> 0x0135 }
            monitor-exit(r16)     // Catch:{ all -> 0x0135 }
            goto L_0x0138
        L_0x0135:
            r0 = move-exception
            monitor-exit(r16)     // Catch:{ all -> 0x0135 }
            throw r0
        L_0x0138:
            java.lang.String r0 = "Unable to execute HTTP request"
            com.baidubce.util.BLog.warn(r0)
            com.baidubce.BceClientConfiguration r0 = r1.config
            com.baidubce.http.RetryPolicy r0 = r0.getRetryPolicy()
            long r13 = r1.getDelayBeforeNextRetryInMillis(r2, r12, r7, r0)
            int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0185
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r12 = "Retriable error detected, will retry in "
            r0.append(r12)
            r0.append(r13)
            java.lang.String r12 = " ms, attempt number: "
            r0.append(r12)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.baidubce.util.BLog.warn(r0)
            java.lang.Thread.sleep(r13)     // Catch:{ InterruptedException -> 0x017b }
            com.baidubce.internal.RestartableInputStream r0 = r17.getContent()
            if (r0 == 0) goto L_0x0177
            com.baidubce.internal.RestartableInputStream r0 = r17.getContent()
            r0.restart()
        L_0x0177:
            int r7 = r7 + 1
            goto L_0x0035
        L_0x017b:
            r0 = move-exception
            r2 = r0
            com.baidubce.BceClientException r0 = new com.baidubce.BceClientException
            java.lang.String r3 = "Delay interrupted"
            r0.<init>(r3, r2)
            throw r0
        L_0x0185:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.http.BceHttpClient.execute(com.baidubce.internal.InternalRequest, java.lang.Class, com.baidubce.http.handler.HttpResponseHandler[], com.baidubce.callback.BceProgressCallback):com.baidubce.model.AbstractBceResponse");
    }
}
