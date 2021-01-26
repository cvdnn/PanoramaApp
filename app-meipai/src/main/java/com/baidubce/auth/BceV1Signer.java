package com.baidubce.auth;

import android.annotation.SuppressLint;
import com.baidubce.BceConfig;
import com.baidubce.http.Headers;
import com.baidubce.internal.InternalRequest;
import com.baidubce.util.BLog;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.DateUtils;
import com.baidubce.util.HashUtils;
import com.baidubce.util.HttpUtils;
import com.baidubce.util.JoinerUtils;
import e.a.a.a.a;
import e.c.f.n.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

@SuppressLint({"NewApi", "DefaultLocale"})
public class BceV1Signer implements Signer {
    public static final Set<String> defaultHeadersToSign;

    static {
        HashSet hashSet = new HashSet();
        defaultHeadersToSign = hashSet;
        hashSet.add(Headers.HOST.toLowerCase());
        defaultHeadersToSign.add("Content-Length".toLowerCase());
        defaultHeadersToSign.add("Content-Type".toLowerCase());
        defaultHeadersToSign.add(Headers.CONTENT_MD5.toLowerCase());
    }

    private String getCanonicalHeaders(SortedMap<String, String> sortedMap) {
        String str = "";
        if (sortedMap.isEmpty()) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        for (Entry entry : sortedMap.entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2 != null) {
                String str3 = (String) entry.getValue();
                if (str3 == null) {
                    str3 = str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(HttpUtils.normalize(str2.trim().toLowerCase()));
                sb.append(':');
                sb.append(HttpUtils.normalize(str3.trim()));
                arrayList.add(sb.toString());
            }
        }
        Collections.sort(arrayList);
        return JoinerUtils.on("\n", (List<String>) arrayList);
    }

    private String getCanonicalURIPath(String str) {
        String str2 = BceConfig.BOS_DELIMITER;
        if (str == null) {
            return str2;
        }
        if (str.startsWith(str2)) {
            return HttpUtils.normalizePath(str);
        }
        StringBuilder a2 = a.a(str2);
        a2.append(HttpUtils.normalizePath(str));
        return a2.toString();
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [java.util.Set] */
    /* JADX WARNING: type inference failed for: r6v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.SortedMap<java.lang.String, java.lang.String> getHeadersToSign(java.util.Map<java.lang.String, java.lang.String> r5, java.util.Set<java.lang.String> r6) {
        /*
            r4 = this;
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            if (r6 == 0) goto L_0x0029
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0010:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0028
            java.lang.Object r2 = r6.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.trim()
            java.lang.String r2 = r2.toLowerCase()
            r1.add(r2)
            goto L_0x0010
        L_0x0028:
            r6 = r1
        L_0x0029:
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0031:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r5.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r1.getValue()
            if (r3 == 0) goto L_0x0031
            java.lang.Object r3 = r1.getValue()
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0031
            if (r6 != 0) goto L_0x005d
            boolean r3 = r4.isDefaultHeaderToSign(r2)
            if (r3 != 0) goto L_0x0071
        L_0x005d:
            if (r6 == 0) goto L_0x0031
            java.lang.String r3 = r2.toLowerCase()
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x0031
            java.lang.String r3 = "Authorization"
            boolean r3 = r3.equalsIgnoreCase(r2)
            if (r3 != 0) goto L_0x0031
        L_0x0071:
            java.lang.Object r1 = r1.getValue()
            r0.put(r2, r1)
            goto L_0x0031
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.auth.BceV1Signer.getHeadersToSign(java.util.Map, java.util.Set):java.util.SortedMap");
    }

    private boolean isDefaultHeaderToSign(String str) {
        String lowerCase = str.trim().toLowerCase();
        return lowerCase.startsWith(Headers.BCE_PREFIX) || defaultHeadersToSign.contains(lowerCase);
    }

    public void sign(InternalRequest internalRequest, BceCredentials bceCredentials) {
        sign(internalRequest, bceCredentials, null);
    }

    public void sign(InternalRequest internalRequest, BceCredentials bceCredentials, SignOptions signOptions) {
        CheckUtils.isNotNull(internalRequest, "request should not be null.");
        if (bceCredentials != null) {
            if (signOptions == null) {
                if (internalRequest.getSignOptions() != null) {
                    signOptions = internalRequest.getSignOptions();
                } else {
                    signOptions = SignOptions.DEFAULT;
                }
            }
            String accessKeyId = bceCredentials.getAccessKeyId();
            String secretKey = bceCredentials.getSecretKey();
            internalRequest.addHeader(Headers.HOST, HttpUtils.generateHostHeader(internalRequest.getUri()));
            String name = internalRequest.getHttpMethod().name();
            boolean z = n.c(name) || n.b(name);
            String str = "Content-Length";
            if (internalRequest.getHeaders().get(str) == null && internalRequest.getContent() == null && z) {
                internalRequest.addHeader(str, "0");
            }
            if (bceCredentials instanceof BceSessionCredentials) {
                internalRequest.addHeader(Headers.BCE_SECURITY_TOKEN, ((BceSessionCredentials) bceCredentials).getSessionToken());
            }
            Date timestamp = signOptions.getTimestamp();
            if (timestamp == null) {
                timestamp = new Date();
            }
            Object[] objArr = {BceConfig.BCE_AUTH_VERSION, accessKeyId, DateUtils.alternateIso8601DateFormat(timestamp), Integer.valueOf(signOptions.getExpirationInSeconds())};
            String str2 = BceConfig.BOS_DELIMITER;
            String on = JoinerUtils.on(str2, objArr);
            String sha256Hex = HashUtils.sha256Hex(secretKey, on);
            String canonicalURIPath = getCanonicalURIPath(internalRequest.getUri().getPath());
            String canonicalQueryString = HttpUtils.getCanonicalQueryString(internalRequest.getParameters(), true);
            SortedMap headersToSign = getHeadersToSign(internalRequest.getHeaders(), signOptions.getHeadersToSign());
            String canonicalHeaders = getCanonicalHeaders(headersToSign);
            String lowerCase = signOptions.getHeadersToSign() != null ? JoinerUtils.on(";", headersToSign.keySet()).trim().toLowerCase() : "";
            Object[] objArr2 = {internalRequest.getHttpMethod(), canonicalURIPath, canonicalQueryString, canonicalHeaders};
            String str3 = "\n";
            String on2 = JoinerUtils.on(str3, objArr2);
            String on3 = JoinerUtils.on(str2, on, lowerCase, HashUtils.sha256Hex(sha256Hex, on2));
            BLog.debug("CanonicalRequest:{}\tAuthorization:{}", (Object) on2.replace(str3, "[\\n]"), (Object) on3);
            internalRequest.addHeader(Headers.AUTHORIZATION, on3);
        }
    }
}
