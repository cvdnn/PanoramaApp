package i.b.b.j;

import i.b.b.d;
import i.b.b.f;
import java.util.Date;
import java.util.List;

/* compiled from: WhereCondition */
public interface h {

    /* compiled from: WhereCondition */
    public static abstract class a implements h {

        /* renamed from: a reason: collision with root package name */
        public final boolean f9865a = true;

        /* renamed from: b reason: collision with root package name */
        public final Object f9866b;

        /* renamed from: c reason: collision with root package name */
        public final Object[] f9867c = null;

        public a(Object obj) {
            this.f9866b = obj;
        }

        public void a(List<Object> list) {
            if (this.f9865a) {
                list.add(this.f9866b);
                return;
            }
            Object[] objArr = this.f9867c;
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }
    }

    /* compiled from: WhereCondition */
    public static class b extends a {

        /* renamed from: d reason: collision with root package name */
        public final f f9868d;

        /* renamed from: e reason: collision with root package name */
        public final String f9869e;

        public b(f fVar, String str, Object obj) {
            if (obj == null || !obj.getClass().isArray()) {
                Class<?> cls = fVar.f9799b;
                if (cls == Date.class) {
                    if (obj instanceof Date) {
                        obj = Long.valueOf(((Date) obj).getTime());
                    } else if (!(obj instanceof Long)) {
                        throw new d(e.a.a.a.a.a("Illegal date value: expected java.util.Date or Long for value ", obj));
                    }
                } else if (cls == Boolean.TYPE || cls == Boolean.class) {
                    if (obj instanceof Boolean) {
                        obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                    } else if (obj instanceof Number) {
                        int intValue = ((Number) obj).intValue();
                        if (!(intValue == 0 || intValue == 1)) {
                            throw new d(e.a.a.a.a.a("Illegal boolean value: numbers must be 0 or 1, but was ", obj));
                        }
                    } else if (obj instanceof String) {
                        String str2 = (String) obj;
                        if ("TRUE".equalsIgnoreCase(str2)) {
                            obj = Integer.valueOf(1);
                        } else if ("FALSE".equalsIgnoreCase(str2)) {
                            obj = Integer.valueOf(0);
                        } else {
                            throw new d(e.a.a.a.a.a("Illegal boolean value: Strings must be \"TRUE\" or \"FALSE\" (case insensitive), but was ", obj));
                        }
                    }
                }
                super(obj);
                this.f9868d = fVar;
                this.f9869e = str;
                return;
            }
            throw new d("Illegal value: found array, but simple object required");
        }

        public void a(StringBuilder sb, String str) {
            i.b.b.i.d.a(sb, str, this.f9868d);
            sb.append(this.f9869e);
        }
    }

    void a(StringBuilder sb, String str);

    void a(List<Object> list);
}
