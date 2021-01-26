package e.c.d.l.b;

import e.g.b.j;
import e.g.b.w;
import g.a0;
import g.e;
import g.z;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: HttpCallBack */
public abstract class a<T> {
    public void a(e eVar, z zVar) {
        if (eVar.i()) {
            a(eVar, null, 2);
            return;
        }
        int i2 = zVar.f9616c;
        if (i2 >= 200 && i2 < 300) {
            a0 a0Var = zVar.f9620g;
            if (a0Var != null) {
                try {
                    a(eVar, new j().a(a0Var.string(), a()), 0);
                } catch (w | IOException | IllegalStateException e2) {
                    e2.printStackTrace();
                    a(eVar, null, 1);
                }
                return;
            }
        }
        a(eVar, null, 1);
    }

    public abstract void a(e eVar, T t, int i2);

    public Type a() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Type[] typeArr = new Type[0];
        if (parameterizedType != null) {
            typeArr = parameterizedType.getActualTypeArguments();
        }
        return typeArr[0];
    }
}
