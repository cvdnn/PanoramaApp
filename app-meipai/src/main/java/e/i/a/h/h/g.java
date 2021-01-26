package e.i.a.h.h;

import android.net.ConnectivityManager;
import e.i.a.e;
import e.i.a.h.d.c;
import e.i.a.h.e.b;
import e.i.a.h.i.d;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DownloadStrategy */
public class g {

    /* renamed from: c reason: collision with root package name */
    public static final Pattern f8851c = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");

    /* renamed from: a reason: collision with root package name */
    public Boolean f8852a = null;

    /* renamed from: b reason: collision with root package name */
    public ConnectivityManager f8853b = null;

    /* compiled from: DownloadStrategy */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public volatile String f8854a;

        public a() {
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (this.f8854a != null) {
                return this.f8854a.equals(((a) obj).f8854a);
            }
            if (((a) obj).f8854a != null) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            if (this.f8854a == null) {
                return 0;
            }
            return this.f8854a.hashCode();
        }

        public a(String str) {
            this.f8854a = str;
        }
    }

    public b a(int i2, boolean z, c cVar, String str) {
        String str2 = cVar.f8704c;
        if (i2 == 412) {
            return b.RESPONSE_PRECONDITION_FAILED;
        }
        if (!e.i.a.h.c.a((CharSequence) str2) && !e.i.a.h.c.a((CharSequence) str) && !str.equals(str2)) {
            return b.RESPONSE_ETAG_CHANGED;
        }
        if (i2 == 201 && z) {
            return b.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i2 != 205 || !z) {
            return null;
        }
        return b.RESPONSE_RESET_RANGE_NOT_FROM_0;
    }

    public boolean a(int i2, boolean z) {
        if (i2 == 206 || i2 == 200) {
            return i2 == 200 && z;
        }
        return true;
    }

    public void a(String str, e.i.a.c cVar, c cVar2) throws IOException {
        byte[] bArr;
        if (e.i.a.h.c.a((CharSequence) cVar.v.f8854a)) {
            if (e.i.a.h.c.a((CharSequence) str)) {
                String str2 = cVar.f8650c;
                Matcher matcher = f8851c.matcher(str2);
                String str3 = null;
                String str4 = null;
                while (matcher.find()) {
                    str4 = matcher.group(1);
                }
                if (e.i.a.h.c.a((CharSequence) str4)) {
                    try {
                        bArr = MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8"));
                    } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
                        bArr = null;
                    }
                    if (bArr != null) {
                        StringBuilder sb = new StringBuilder(bArr.length * 2);
                        for (byte b2 : bArr) {
                            byte b3 = b2 & 255;
                            if (b3 < 16) {
                                sb.append('0');
                            }
                            sb.append(Integer.toHexString(b3));
                        }
                        str3 = sb.toString();
                    }
                    str = str3;
                } else {
                    str = str4;
                }
                if (str == null) {
                    throw new IOException("Can't find valid filename.");
                }
            }
            if (e.i.a.h.c.a((CharSequence) cVar.v.f8854a)) {
                synchronized (cVar) {
                    if (e.i.a.h.c.a((CharSequence) cVar.v.f8854a)) {
                        cVar.v.f8854a = str;
                        cVar2.f8707f.f8854a = str;
                    }
                }
            }
        }
    }

    public void a() throws UnknownHostException {
        if (this.f8852a == null) {
            this.f8852a = Boolean.valueOf(e.i.a.h.c.a("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.f8852a.booleanValue()) {
            if (this.f8853b == null) {
                this.f8853b = (ConnectivityManager) e.a().f8671h.getSystemService("connectivity");
            }
            if (!e.i.a.h.c.a(this.f8853b)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void a(e.i.a.c cVar) throws IOException {
        if (this.f8852a == null) {
            this.f8852a = Boolean.valueOf(e.i.a.h.c.a("android.permission.ACCESS_NETWORK_STATE"));
        }
        if (cVar.s) {
            if (this.f8852a.booleanValue()) {
                if (this.f8853b == null) {
                    this.f8853b = (ConnectivityManager) e.a().f8671h.getSystemService("connectivity");
                }
                if (e.i.a.h.c.b(this.f8853b)) {
                    throw new d();
                }
                return;
            }
            throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
        }
    }
}
