package com.baidubce.http;

import com.baidubce.BceClientConfiguration;
import com.baidubce.auth.NTLMEngineImpl;
import g.b;
import g.b0;
import g.h;
import g.l;
import g.u;
import g.v;
import g.x;
import g.x.a;
import g.z;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class HttpClientFactory {

    public static class NTLMAuthenticator implements b {
        public final String domain;
        public final NTLMEngineImpl engine;
        public final String ntlmMsg1;
        public final String password;
        public final String username;
        public final String workstation;

        public NTLMAuthenticator(String str, String str2, String str3, String str4) {
            NTLMEngineImpl nTLMEngineImpl = new NTLMEngineImpl();
            this.engine = nTLMEngineImpl;
            this.domain = str4;
            this.username = str;
            this.password = str2;
            this.workstation = str3;
            String str5 = null;
            try {
                str5 = nTLMEngineImpl.generateType1Msg(null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.ntlmMsg1 = str5;
        }

        public x authenticate(b0 b0Var, z zVar) throws IOException {
            String str;
            List b2 = zVar.f9619f.b("WWW-Authenticate");
            boolean contains = b2.contains("NTLM");
            String str2 = "NTLM ";
            String str3 = Headers.AUTHORIZATION;
            if (contains) {
                x xVar = zVar.f9614a;
                if (xVar != null) {
                    a aVar = new a(xVar);
                    StringBuilder a2 = e.a.a.a.a.a(str2);
                    a2.append(this.ntlmMsg1);
                    aVar.b(str3, a2.toString());
                    return aVar.a();
                }
                throw null;
            }
            try {
                str = this.engine.generateType3Msg(this.username, this.password, this.domain, this.workstation, ((String) b2.get(0)).substring(5));
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
            x xVar2 = zVar.f9614a;
            if (xVar2 != null) {
                a aVar2 = new a(xVar2);
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str);
                aVar2.b(str3, sb.toString());
                return aVar2.a();
            }
            throw null;
        }
    }

    public u createHttpClient(BceClientConfiguration bceClientConfiguration) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(v.HTTP_1_1);
        u.b bVar = new u.b();
        bVar.a(arrayList);
        bVar.o = new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
            }
        };
        bVar.w = false;
        bVar.f9580j = null;
        bVar.k = null;
        bVar.v = false;
        bVar.u = false;
        if (bceClientConfiguration != null) {
            l lVar = new l();
            lVar.a(bceClientConfiguration.getMaxConnections());
            h hVar = new h(bceClientConfiguration.getMaxConnections(), bceClientConfiguration.getKeepAliveDuration(), TimeUnit.SECONDS);
            bVar.a(arrayList);
            bVar.a((long) bceClientConfiguration.getConnectionTimeoutInMillis(), TimeUnit.MILLISECONDS);
            bVar.c((long) bceClientConfiguration.getSocketTimeoutInMillis(), TimeUnit.MILLISECONDS);
            bVar.b((long) bceClientConfiguration.getSocketTimeoutInMillis(), TimeUnit.MILLISECONDS);
            bVar.f9571a = lVar;
            bVar.s = hVar;
            String proxyHost = bceClientConfiguration.getProxyHost();
            int proxyPort = bceClientConfiguration.getProxyPort();
            if (proxyHost != null && proxyPort > 0) {
                bVar.f9572b = new Proxy(Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                String proxyUsername = bceClientConfiguration.getProxyUsername();
                String proxyPassword = bceClientConfiguration.getProxyPassword();
                String proxyDomain = bceClientConfiguration.getProxyDomain();
                String proxyWorkstation = bceClientConfiguration.getProxyWorkstation();
                if (!(proxyUsername == null || proxyPassword == null)) {
                    bVar.q = new NTLMAuthenticator(proxyUsername, proxyPassword, proxyDomain, proxyWorkstation);
                }
            }
        }
        return new u(bVar);
    }
}
