package com.baidubce.util;

import com.arashivision.graphicpath.render.Stabilization.GyroType;
import com.baidu.mobstat.Config;
import com.baidubce.BceConfig;
import com.baidubce.Protocol;
import com.baidubce.http.Headers;
import e.a.a.a.a;
import g.q;
import g.x;
import g.z;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtils {
    public static boolean HTTP_VERBOSE = Boolean.parseBoolean(System.getProperty("bce.sdk.http", "false"));
    public static String[] PERCENT_ENCODED_STRINGS = new String[256];
    public static BitSet URI_UNRESERVED_CHARACTERS = new BitSet();

    static {
        for (int i2 = 97; i2 <= 122; i2++) {
            URI_UNRESERVED_CHARACTERS.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            URI_UNRESERVED_CHARACTERS.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            URI_UNRESERVED_CHARACTERS.set(i4);
        }
        URI_UNRESERVED_CHARACTERS.set(45);
        URI_UNRESERVED_CHARACTERS.set(46);
        URI_UNRESERVED_CHARACTERS.set(95);
        URI_UNRESERVED_CHARACTERS.set(GyroType.INS_EVO_TEST);
        int i5 = 0;
        while (true) {
            String[] strArr = PERCENT_ENCODED_STRINGS;
            if (i5 < strArr.length) {
                strArr[i5] = String.format("%%%02X", new Object[]{Integer.valueOf(i5)});
                i5++;
            } else {
                return;
            }
        }
    }

    public static URI appendUri(URI uri, String... strArr) {
        StringBuilder sb = new StringBuilder(uri.toASCIIString());
        for (String str : strArr) {
            if (str != null && str.length() > 0) {
                String normalizePath = normalizePath(str);
                if (normalizePath.startsWith(BceConfig.BOS_DELIMITER)) {
                    if (sb.charAt(sb.length() - 1) == '/') {
                        sb.setLength(sb.length() - 1);
                    }
                } else if (sb.charAt(sb.length() - 1) != '/') {
                    sb.append('/');
                }
                sb.append(normalizePath);
            }
        }
        try {
            return new URI(sb.toString());
        } catch (URISyntaxException e2) {
            throw new RuntimeException("Unexpected error", e2);
        }
    }

    public static String generateHostHeader(URI uri) {
        String host = uri.getHost();
        if (!isUsingNonDefaultPort(uri)) {
            return host;
        }
        StringBuilder b2 = a.b(host, Config.TRACE_TODAY_VISIT_SPLIT);
        b2.append(uri.getPort());
        return b2.toString();
    }

    public static String getCanonicalQueryString(Map<String, String> map, boolean z) {
        if (map.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (Entry entry : map.entrySet()) {
            if (z) {
                if (Headers.AUTHORIZATION.equalsIgnoreCase((String) entry.getKey())) {
                }
            }
            String str = (String) entry.getKey();
            CheckUtils.isNotNull(str, "parameter key should not be null");
            String str2 = (String) entry.getValue();
            if (str2 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(normalize(str));
                sb.append('=');
                sb.append(normalize(str2));
                arrayList.add(sb.toString());
            } else if (z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(normalize(str));
                sb2.append('=');
                arrayList.add(sb2.toString());
            } else {
                arrayList.add(normalize(str));
            }
        }
        Collections.sort(arrayList);
        return JoinerUtils.on("&", (List<String>) arrayList);
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        String lowerCase = uri.getScheme().toLowerCase();
        int port = uri.getPort();
        boolean z = false;
        if (port <= 0) {
            return false;
        }
        if (lowerCase.equals(Protocol.HTTP.toString())) {
            if (port != Protocol.HTTP.getDefaultPort()) {
                z = true;
            }
            return z;
        }
        if (lowerCase.equals(Protocol.HTTPS.toString()) && port != Protocol.HTTPS.getDefaultPort()) {
            z = true;
        }
        return z;
    }

    public static String normalize(String str) {
        byte[] bytes;
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : str.getBytes("UTF-8")) {
                byte b3 = b2 & 255;
                if (URI_UNRESERVED_CHARACTERS.get(b3)) {
                    sb.append((char) b2);
                } else {
                    sb.append(PERCENT_ENCODED_STRINGS[b3]);
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String normalizePath(String str) {
        return normalize(str).replace("%2F", BceConfig.BOS_DELIMITER);
    }

    public static void printRequest(x xVar) {
        if (HTTP_VERBOSE) {
            BLog.info("\n-------------> ");
            StringBuilder sb = new StringBuilder();
            sb.append(xVar.f9596b);
            sb.append(" ");
            sb.append(xVar.f9595a);
            sb.append("");
            BLog.info(sb.toString());
            q qVar = xVar.f9597c;
            for (int i2 = 0; i2 < qVar.b(); i2++) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(qVar.a(i2));
                sb2.append(Config.TRACE_TODAY_VISIT_SPLIT);
                sb2.append(qVar.b(i2));
                BLog.info(sb2.toString());
            }
        }
    }

    public static void printResponse(z zVar) {
        if (HTTP_VERBOSE) {
            BLog.info("\n<------------- ");
            StringBuilder sb = new StringBuilder();
            sb.append(zVar.f9616c);
            sb.append(" - ");
            sb.append(zVar.f9617d);
            BLog.info(sb.toString());
            q qVar = zVar.f9619f;
            for (int i2 = 0; i2 < qVar.b(); i2++) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(qVar.a(i2));
                sb2.append(Config.TRACE_TODAY_VISIT_SPLIT);
                sb2.append(qVar.b(i2));
                BLog.info(sb2.toString());
            }
        }
    }
}
