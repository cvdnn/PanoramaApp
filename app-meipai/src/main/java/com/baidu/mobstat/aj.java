package com.baidu.mobstat;

import android.text.TextUtils;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class aj {

    /* renamed from: c reason: collision with root package name */
    public static final ByteBuffer f1519c = ByteBuffer.allocate(0);

    /* renamed from: a reason: collision with root package name */
    public a f1520a;

    /* renamed from: b reason: collision with root package name */
    public b f1521b;

    public interface a {
        void a();

        void a(String str);

        void a(boolean z);

        void b();
    }

    public class b extends cc {
        public b(URI uri, int i2, Socket socket) throws InterruptedException {
            super(uri, new cf(), null, i2);
            a(socket);
        }

        public void a(cz czVar) {
            if (bd.c().b()) {
                bd.c().a("onOpen");
            }
            if (aj.this.f1520a != null) {
                aj.this.f1520a.a();
            }
        }

        public void a(String str) {
            JSONObject jSONObject;
            if (bd.c().b()) {
                bd c2 = bd.c();
                StringBuilder sb = new StringBuilder();
                sb.append("onMessage: ");
                sb.append(str);
                c2.a(sb.toString());
            }
            if (!TextUtils.isEmpty(str)) {
                String str2 = null;
                try {
                    jSONObject = new JSONObject(str);
                } catch (Exception unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    try {
                        str2 = jSONObject.getString("type");
                    } catch (Exception unused2) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        boolean equals = str2.equals("deploy");
                        String str3 = WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_DATA;
                        if (equals) {
                            try {
                                aj.this.f1520a.a(((JSONObject) jSONObject.get(str3)).toString());
                            } catch (Exception unused3) {
                            }
                            return;
                        }
                        int i2 = -1;
                        try {
                            i2 = ((Integer) ((JSONObject) jSONObject.get(str3)).get("status")).intValue();
                        } catch (Exception unused4) {
                        }
                        switch (i2) {
                            case 801020:
                                bc.c().a("autotrace: connect established");
                                am.a().a(2);
                                break;
                            case 801021:
                                bc.c().a("autotrace: connect failed, connect has been established");
                                am.a().a(5, "already connect");
                                break;
                            case 801024:
                                bc.c().a("autotrace: connect confirm");
                                am.a().a(3);
                                if (aj.this.f1520a != null) {
                                    aj.this.f1520a.b();
                                    break;
                                }
                                break;
                        }
                    }
                }
            }
        }

        public void a(int i2, String str, boolean z) {
            if (bd.c().b()) {
                bd c2 = bd.c();
                StringBuilder sb = new StringBuilder();
                sb.append("onClose,  reason:");
                sb.append(str);
                sb.append(", remote:");
                sb.append(z);
                c2.a(sb.toString());
            }
            bc c3 = bc.c();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("autotrace: connect closed, server:");
            sb2.append(z);
            sb2.append(" reason:");
            sb2.append(str);
            c3.a(sb2.toString());
            am a2 = am.a();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("remote:");
            sb3.append(z);
            sb3.append("|reason:");
            sb3.append(str);
            a2.a(5, sb3.toString());
            if (aj.this.f1520a != null) {
                aj.this.f1520a.a(z);
            }
        }

        public void a(Exception exc) {
            if (bd.c().b()) {
                bd.c().a("onError");
            }
        }
    }

    public class c extends IOException {
        public c(Throwable th) {
            super(th.getMessage());
        }
    }

    public aj(URI uri, a aVar) throws c {
        this.f1520a = aVar;
        Socket socket = null;
        try {
            if (uri.toString().startsWith("wss://")) {
                socket = c();
            }
            b bVar = new b(uri, 5000, socket);
            this.f1521b = bVar;
            bVar.c();
        } catch (InterruptedException e2) {
            throw new c(e2);
        }
    }

    private Socket c() {
        SSLSocketFactory sSLSocketFactory;
        Socket socket = null;
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, null, null);
            sSLSocketFactory = instance.getSocketFactory();
        } catch (Exception unused) {
            sSLSocketFactory = null;
        }
        if (sSLSocketFactory == null) {
            return null;
        }
        try {
            socket = sSLSocketFactory.createSocket();
        } catch (Exception unused2) {
        }
        return socket;
    }

    public boolean b() {
        return !this.f1521b.f() && !this.f1521b.g() && !this.f1521b.e();
    }

    public void a() {
        b bVar = this.f1521b;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void a(JSONObject jSONObject) throws NotYetConnectedException {
        if (this.f1521b != null) {
            this.f1521b.a(jSONObject.toString().getBytes());
        }
    }
}
