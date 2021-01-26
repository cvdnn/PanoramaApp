package e.g.b.c0;

import e.a.a.a.a;
import e.g.b.p;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* compiled from: ConstructorConstructor */
public class j implements s<T> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Type f8495a;

    public j(g gVar, Type type) {
        this.f8495a = type;
    }

    public T a() {
        Type type = this.f8495a;
        String str = "Invalid EnumSet type: ";
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return EnumSet.noneOf((Class) type2);
            }
            StringBuilder a2 = a.a(str);
            a2.append(this.f8495a.toString());
            throw new p(a2.toString());
        }
        StringBuilder a3 = a.a(str);
        a3.append(this.f8495a.toString());
        throw new p(a3.toString());
    }
}
