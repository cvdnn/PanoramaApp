package com.baidubce.http;

import com.baidu.mobstat.Config;
import com.baidubce.util.BLog;
import com.baidubce.util.DateUtils;
import g.q;
import g.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BceHttpResponse {
    public InputStream content;
    public z httpResponse;

    public BceHttpResponse(z zVar) throws IOException {
        this.httpResponse = zVar;
        try {
            this.content = zVar.f9620g.byteStream();
        } catch (Exception unused) {
            this.content = null;
        }
    }

    public InputStream getContent() {
        return this.content;
    }

    public String getHeader(String str) {
        String a2 = this.httpResponse.f9619f.a(str);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    public long getHeaderAsLong(String str) {
        String header = getHeader(str);
        if (header == null) {
            return -1;
        }
        try {
            return Long.valueOf(header).longValue();
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid ");
            sb.append(str);
            sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
            sb.append(header);
            BLog.error(sb.toString(), (Throwable) e2);
            return -1;
        }
    }

    public Date getHeaderAsRfc822Date(String str) {
        String header = getHeader(str);
        if (header == null) {
            return null;
        }
        try {
            return DateUtils.parseRfc822Date(header);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid ");
            sb.append(str);
            sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
            sb.append(header);
            BLog.error(sb.toString(), (Throwable) e2);
            return null;
        }
    }

    public Map<String, String> getHeaders() {
        q qVar = getHttpResponse().f9619f;
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < qVar.b(); i2++) {
            hashMap.put(qVar.a(i2), qVar.b(i2));
        }
        return hashMap;
    }

    public z getHttpResponse() {
        return this.httpResponse;
    }

    public int getStatusCode() {
        return this.httpResponse.f9616c;
    }

    public String getStatusText() {
        return this.httpResponse.f9617d;
    }
}
