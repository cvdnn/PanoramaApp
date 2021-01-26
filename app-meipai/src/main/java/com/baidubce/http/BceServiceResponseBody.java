package com.baidubce.http;

import com.baidubce.callback.BceProgressCallback;
import com.baidubce.model.AbstractBceRequest;
import g.a0;
import g.t;
import h.e;
import h.g;
import h.j;
import h.o;
import h.x;
import java.io.IOException;

public class BceServiceResponseBody<T extends AbstractBceRequest> extends a0 {
    public BceProgressCallback<T> bceProgressCallback;
    public g bceRespBufferedSource;
    public final a0 bceResponseBody;
    public T request;

    public BceServiceResponseBody(a0 a0Var, T t, BceProgressCallback<T> bceProgressCallback2) {
        this.bceResponseBody = a0Var;
        this.request = t;
        this.bceProgressCallback = bceProgressCallback2;
    }

    public long contentLength() {
        return this.bceResponseBody.contentLength();
    }

    public t contentType() {
        return this.bceResponseBody.contentType();
    }

    public g source() {
        if (this.bceRespBufferedSource == null) {
            this.bceRespBufferedSource = o.a(source(this.bceResponseBody.source()));
        }
        return this.bceRespBufferedSource;
    }

    private x source(g gVar) {
        return new j(gVar) {
            public long totalBytesRead = 0;

            public long read(e eVar, long j2) throws IOException {
                long read = super.read(eVar, j2);
                this.totalBytesRead += read != -1 ? read : 0;
                if (BceServiceResponseBody.this.bceProgressCallback != null && this.totalBytesRead > 0) {
                    BceServiceResponseBody.this.bceProgressCallback.onProgress(BceServiceResponseBody.this.request, this.totalBytesRead, BceServiceResponseBody.this.bceResponseBody.contentLength());
                }
                return read;
            }
        };
    }
}
