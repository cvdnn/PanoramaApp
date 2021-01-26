package g.d0.i;

import g.v;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: JdkWithJettyBootPlatform */
public class c extends e {

    /* renamed from: c reason: collision with root package name */
    public final Method f9450c;

    /* renamed from: d reason: collision with root package name */
    public final Method f9451d;

    /* renamed from: e reason: collision with root package name */
    public final Method f9452e;

    /* renamed from: f reason: collision with root package name */
    public final Class<?> f9453f;

    /* renamed from: g reason: collision with root package name */
    public final Class<?> f9454g;

    /* compiled from: JdkWithJettyBootPlatform */
    public static class a implements InvocationHandler {

        /* renamed from: a reason: collision with root package name */
        public final List<String> f9455a;

        /* renamed from: b reason: collision with root package name */
        public boolean f9456b;

        /* renamed from: c reason: collision with root package name */
        public String f9457c;

        public a(List<String> list) {
            this.f9455a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<String> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = g.d0.c.f9175b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f9456b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f9455a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f9455a.contains(list.get(i2))) {
                            String str = (String) list.get(i2);
                            this.f9457c = str;
                            return str;
                        }
                    }
                    String str2 = (String) this.f9455a.get(0);
                    this.f9457c = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f9457c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f9450c = method;
        this.f9451d = method2;
        this.f9452e = method3;
        this.f9453f = cls;
        this.f9454g = cls2;
    }

    public void a(SSLSocket sSLSocket, String str, List<v> list) {
        List a2 = e.a(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(e.class.getClassLoader(), new Class[]{this.f9453f, this.f9454g}, new a(a2));
            this.f9450c.invoke(null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw g.d0.c.a("unable to set alpn", (Exception) e2);
        }
    }

    public String b(SSLSocket sSLSocket) {
        try {
            Object[] objArr = {sSLSocket};
            String str = null;
            a aVar = (a) Proxy.getInvocationHandler(this.f9451d.invoke(null, objArr));
            if (aVar.f9456b || aVar.f9457c != null) {
                if (!aVar.f9456b) {
                    str = aVar.f9457c;
                }
                return str;
            }
            e.f9461a.a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw g.d0.c.a("unable to get selected protocol", (Exception) e2);
        }
    }

    public void a(SSLSocket sSLSocket) {
        try {
            this.f9452e.invoke(null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw g.d0.c.a("unable to remove alpn", (Exception) e2);
        }
    }

    public static e a() {
        try {
            Class cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            Class cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider");
            Class cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider");
            c cVar = new c(cls.getMethod("put", new Class[]{SSLSocket.class, cls2}), cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
            return cVar;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }
}
