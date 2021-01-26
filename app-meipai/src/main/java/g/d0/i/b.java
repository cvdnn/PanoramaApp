package g.d0.i;

import g.d0.c;
import g.v;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: Jdk9Platform */
public final class b extends e {

    /* renamed from: c reason: collision with root package name */
    public final Method f9448c;

    /* renamed from: d reason: collision with root package name */
    public final Method f9449d;

    public b(Method method, Method method2) {
        this.f9448c = method;
        this.f9449d = method2;
    }

    public void a(SSLSocket sSLSocket, String str, List<v> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List a2 = e.a(list);
            Method method = this.f9448c;
            Object[] objArr = new Object[1];
            ArrayList arrayList = (ArrayList) a2;
            objArr[0] = arrayList.toArray(new String[arrayList.size()]);
            method.invoke(sSLParameters, objArr);
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw c.a("unable to set ssl parameters", (Exception) e2);
        }
    }

    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f9449d.invoke(sSLSocket, new Object[0]);
            if (str == null || str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw c.a("unable to get selected protocols", (Exception) e2);
        }
    }

    public static b a() {
        try {
            return new b(SSLParameters.class.getMethod("setApplicationProtocols", new Class[]{String[].class}), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
