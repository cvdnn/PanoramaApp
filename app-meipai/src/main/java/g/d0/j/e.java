package g.d0.j;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: OkHostnameVerifier */
public final class e implements HostnameVerifier {

    /* renamed from: a reason: collision with root package name */
    public static final e f9472a = new e();

    public static List<String> a(X509Certificate x509Certificate) {
        List a2 = a(x509Certificate, 7);
        List a3 = a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a3.size() + a2.size());
        arrayList.addAll(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public static List<String> a(X509Certificate x509Certificate, int i2) {
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null) {
                    if (list.size() >= 2) {
                        Integer num = (Integer) list.get(0);
                        if (num != null) {
                            if (num.intValue() == i2) {
                                String str = (String) list.get(1);
                                if (str != null) {
                                    arrayList.add(str);
                                }
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public boolean a(String str, String str2) {
        if (!(str == null || str.length() == 0)) {
            String str3 = ".";
            if (!str.startsWith(str3)) {
                String str4 = "..";
                if (!str.endsWith(str4) && str2 != null && str2.length() != 0 && !str2.startsWith(str3) && !str2.endsWith(str4)) {
                    if (!str.endsWith(str3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append('.');
                        str = sb.toString();
                    }
                    if (!str2.endsWith(str3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append('.');
                        str2 = sb2.toString();
                    }
                    String lowerCase = str2.toLowerCase(Locale.US);
                    if (!lowerCase.contains("*")) {
                        return str.equals(lowerCase);
                    }
                    String str5 = "*.";
                    if (!lowerCase.startsWith(str5) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || str5.equals(lowerCase)) {
                        return false;
                    }
                    String substring = lowerCase.substring(1);
                    if (!str.endsWith(substring)) {
                        return false;
                    }
                    int length = str.length() - substring.length();
                    if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0129, code lost:
        r4 = r3.f9471g;
        r5 = r3.f9468d;
        r1 = new java.lang.String(r4, r5, r3.f9470f - r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x018d, code lost:
        r3.f9469e = r3.f9467c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0229  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r14, java.security.cert.X509Certificate r15) {
        /*
            r13 = this;
            java.util.regex.Pattern r0 = g.d0.c.q
            java.util.regex.Matcher r0 = r0.matcher(r14)
            boolean r0 = r0.matches()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x002a
            r0 = 7
            java.util.List r15 = a(r15, r0)
            int r0 = r15.size()
            r3 = r1
        L_0x0018:
            if (r3 >= r0) goto L_0x02a7
            java.lang.Object r4 = r15.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r14.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0027
            goto L_0x0049
        L_0x0027:
            int r3 = r3 + 1
            goto L_0x0018
        L_0x002a:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r14 = r14.toLowerCase(r0)
            r0 = 2
            java.util.List r3 = a(r15, r0)
            int r4 = r3.size()
            r5 = r1
            r6 = r5
        L_0x003b:
            if (r5 >= r4) goto L_0x0050
            java.lang.Object r6 = r3.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = r13.a(r14, r6)
            if (r6 == 0) goto L_0x004c
        L_0x0049:
            r1 = r2
            goto L_0x02a7
        L_0x004c:
            int r5 = r5 + 1
            r6 = r2
            goto L_0x003b
        L_0x0050:
            if (r6 != 0) goto L_0x02a6
            javax.security.auth.x500.X500Principal r15 = r15.getSubjectX500Principal()
            g.d0.j.d r3 = new g.d0.j.d
            r3.<init>(r15)
            r3.f9467c = r1
            r3.f9468d = r1
            r3.f9469e = r1
            r3.f9470f = r1
            java.lang.String r15 = r3.f9465a
            char[] r15 = r15.toCharArray()
            r3.f9471g = r15
            java.lang.String r15 = r3.b()
            if (r15 != 0) goto L_0x0073
            goto L_0x0226
        L_0x0073:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 != r4) goto L_0x007b
            goto L_0x0226
        L_0x007b:
            char[] r5 = r3.f9471g
            char r5 = r5[r1]
            r6 = 92
            java.lang.String r7 = "Unexpected end of DN: "
            r8 = 34
            r9 = 32
            r10 = 59
            r11 = 44
            r12 = 43
            if (r5 == r8) goto L_0x01e2
            r8 = 35
            if (r5 == r8) goto L_0x013b
            if (r5 == r12) goto L_0x0137
            if (r5 == r11) goto L_0x0137
            if (r5 == r10) goto L_0x0137
            r3.f9468d = r1
            r3.f9469e = r1
        L_0x009d:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 < r4) goto L_0x00b1
            java.lang.String r1 = new java.lang.String
            char[] r4 = r3.f9471g
            int r5 = r3.f9468d
            int r6 = r3.f9469e
            int r6 = r6 - r5
            r1.<init>(r4, r5, r6)
            goto L_0x0217
        L_0x00b1:
            char[] r4 = r3.f9471g
            char r5 = r4[r1]
            if (r5 == r9) goto L_0x00ee
            if (r5 == r10) goto L_0x00e0
            if (r5 == r6) goto L_0x00ce
            if (r5 == r12) goto L_0x00e0
            if (r5 == r11) goto L_0x00e0
            int r5 = r3.f9469e
            int r7 = r5 + 1
            r3.f9469e = r7
            char r7 = r4[r1]
            r4[r5] = r7
            int r1 = r1 + 1
            r3.f9467c = r1
            goto L_0x009d
        L_0x00ce:
            int r1 = r3.f9469e
            int r5 = r1 + 1
            r3.f9469e = r5
            char r5 = r3.a()
            r4[r1] = r5
            int r1 = r3.f9467c
            int r1 = r1 + r2
            r3.f9467c = r1
            goto L_0x009d
        L_0x00e0:
            java.lang.String r1 = new java.lang.String
            char[] r4 = r3.f9471g
            int r5 = r3.f9468d
            int r6 = r3.f9469e
            int r6 = r6 - r5
            r1.<init>(r4, r5, r6)
            goto L_0x0217
        L_0x00ee:
            int r5 = r3.f9469e
            r3.f9470f = r5
            int r1 = r1 + 1
            r3.f9467c = r1
            int r1 = r5 + 1
            r3.f9469e = r1
            r4[r5] = r9
        L_0x00fc:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 >= r4) goto L_0x0115
            char[] r4 = r3.f9471g
            char r5 = r4[r1]
            if (r5 != r9) goto L_0x0115
            int r5 = r3.f9469e
            int r7 = r5 + 1
            r3.f9469e = r7
            r4[r5] = r9
            int r1 = r1 + 1
            r3.f9467c = r1
            goto L_0x00fc
        L_0x0115:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 == r4) goto L_0x0129
            char[] r4 = r3.f9471g
            char r5 = r4[r1]
            if (r5 == r11) goto L_0x0129
            char r5 = r4[r1]
            if (r5 == r12) goto L_0x0129
            char r1 = r4[r1]
            if (r1 != r10) goto L_0x009d
        L_0x0129:
            java.lang.String r1 = new java.lang.String
            char[] r4 = r3.f9471g
            int r5 = r3.f9468d
            int r6 = r3.f9470f
            int r6 = r6 - r5
            r1.<init>(r4, r5, r6)
            goto L_0x0217
        L_0x0137:
            java.lang.String r1 = ""
            goto L_0x0217
        L_0x013b:
            int r5 = r1 + 4
            if (r5 >= r4) goto L_0x01cf
            r3.f9468d = r1
            int r1 = r1 + 1
            r3.f9467c = r1
        L_0x0145:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 == r4) goto L_0x018d
            char[] r4 = r3.f9471g
            char r5 = r4[r1]
            if (r5 == r12) goto L_0x018d
            char r5 = r4[r1]
            if (r5 == r11) goto L_0x018d
            char r5 = r4[r1]
            if (r5 != r10) goto L_0x015a
            goto L_0x018d
        L_0x015a:
            char r5 = r4[r1]
            if (r5 != r9) goto L_0x0175
            r3.f9469e = r1
            int r1 = r1 + 1
            r3.f9467c = r1
        L_0x0164:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 >= r4) goto L_0x0191
            char[] r4 = r3.f9471g
            char r4 = r4[r1]
            if (r4 != r9) goto L_0x0191
            int r1 = r1 + 1
            r3.f9467c = r1
            goto L_0x0164
        L_0x0175:
            char r5 = r4[r1]
            r6 = 65
            if (r5 < r6) goto L_0x0187
            char r5 = r4[r1]
            r6 = 70
            if (r5 > r6) goto L_0x0187
            char r5 = r4[r1]
            int r5 = r5 + r9
            char r5 = (char) r5
            r4[r1] = r5
        L_0x0187:
            int r1 = r3.f9467c
            int r1 = r1 + r2
            r3.f9467c = r1
            goto L_0x0145
        L_0x018d:
            int r1 = r3.f9467c
            r3.f9469e = r1
        L_0x0191:
            int r1 = r3.f9469e
            int r4 = r3.f9468d
            int r1 = r1 - r4
            r5 = 5
            if (r1 < r5) goto L_0x01bc
            r5 = r1 & 1
            if (r5 == 0) goto L_0x01bc
            int r5 = r1 / 2
            byte[] r6 = new byte[r5]
            int r4 = r4 + 1
            r7 = 0
        L_0x01a4:
            if (r7 >= r5) goto L_0x01b1
            int r8 = r3.a(r4)
            byte r8 = (byte) r8
            r6[r7] = r8
            int r4 = r4 + r0
            int r7 = r7 + 1
            goto L_0x01a4
        L_0x01b1:
            java.lang.String r4 = new java.lang.String
            char[] r5 = r3.f9471g
            int r6 = r3.f9468d
            r4.<init>(r5, r6, r1)
            r1 = r4
            goto L_0x0217
        L_0x01bc:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r15 = e.a.a.a.a.a(r7)
            java.lang.String r0 = r3.f9465a
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x01cf:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r15 = e.a.a.a.a.a(r7)
            java.lang.String r0 = r3.f9465a
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x01e2:
            int r1 = r1 + 1
            r3.f9467c = r1
            r3.f9468d = r1
            r3.f9469e = r1
        L_0x01ea:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 == r4) goto L_0x0293
            char[] r4 = r3.f9471g
            char r5 = r4[r1]
            if (r5 != r8) goto L_0x0274
            int r1 = r1 + 1
            r3.f9467c = r1
        L_0x01fa:
            int r1 = r3.f9467c
            int r4 = r3.f9466b
            if (r1 >= r4) goto L_0x020b
            char[] r4 = r3.f9471g
            char r4 = r4[r1]
            if (r4 != r9) goto L_0x020b
            int r1 = r1 + 1
            r3.f9467c = r1
            goto L_0x01fa
        L_0x020b:
            java.lang.String r1 = new java.lang.String
            char[] r4 = r3.f9471g
            int r5 = r3.f9468d
            int r6 = r3.f9469e
            int r6 = r6 - r5
            r1.<init>(r4, r5, r6)
        L_0x0217:
            java.lang.String r4 = "cn"
            boolean r15 = r4.equalsIgnoreCase(r15)
            if (r15 == 0) goto L_0x0220
            goto L_0x0227
        L_0x0220:
            int r15 = r3.f9467c
            int r1 = r3.f9466b
            if (r15 < r1) goto L_0x022f
        L_0x0226:
            r1 = 0
        L_0x0227:
            if (r1 == 0) goto L_0x02a6
            boolean r1 = r13.a(r14, r1)
            goto L_0x02a7
        L_0x022f:
            char[] r1 = r3.f9471g
            char r4 = r1[r15]
            java.lang.String r5 = "Malformed DN: "
            if (r4 == r11) goto L_0x0254
            char r4 = r1[r15]
            if (r4 != r10) goto L_0x023c
            goto L_0x0254
        L_0x023c:
            char r15 = r1[r15]
            if (r15 != r12) goto L_0x0241
            goto L_0x0254
        L_0x0241:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r15 = e.a.a.a.a.a(r5)
            java.lang.String r0 = r3.f9465a
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x0254:
            int r15 = r3.f9467c
            int r15 = r15 + r2
            r3.f9467c = r15
            java.lang.String r15 = r3.b()
            if (r15 == 0) goto L_0x0261
            goto L_0x0073
        L_0x0261:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r15 = e.a.a.a.a.a(r5)
            java.lang.String r0 = r3.f9465a
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x0274:
            char r5 = r4[r1]
            if (r5 != r6) goto L_0x0281
            int r1 = r3.f9469e
            char r5 = r3.a()
            r4[r1] = r5
            goto L_0x0287
        L_0x0281:
            int r5 = r3.f9469e
            char r1 = r4[r1]
            r4[r5] = r1
        L_0x0287:
            int r1 = r3.f9467c
            int r1 = r1 + r2
            r3.f9467c = r1
            int r1 = r3.f9469e
            int r1 = r1 + r2
            r3.f9469e = r1
            goto L_0x01ea
        L_0x0293:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.StringBuilder r15 = e.a.a.a.a.a(r7)
            java.lang.String r0 = r3.f9465a
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x02a6:
            r1 = 0
        L_0x02a7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.d0.j.e.a(java.lang.String, java.security.cert.X509Certificate):boolean");
    }
}
