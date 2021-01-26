package d.v;

import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VersionedParcel */
public abstract class a {

    /* renamed from: a reason: collision with root package name */
    public final d.e.a<String, Method> f5601a;

    /* renamed from: b reason: collision with root package name */
    public final d.e.a<String, Method> f5602b;

    /* renamed from: c reason: collision with root package name */
    public final d.e.a<String, Class> f5603c;

    public a(d.e.a<String, Method> aVar, d.e.a<String, Method> aVar2, d.e.a<String, Class> aVar3) {
        this.f5601a = aVar;
        this.f5602b = aVar2;
        this.f5603c = aVar3;
    }

    public abstract void a();

    public abstract boolean a(int i2);

    public boolean a(boolean z, int i2) {
        if (!a(i2)) {
            return z;
        }
        return ((b) this).f5605e.readInt() != 0;
    }

    public abstract a b();

    public abstract void b(int i2);

    public void b(int i2, int i3) {
        b(i3);
        ((b) this).f5605e.writeInt(i2);
    }

    public <T extends c> T c() {
        String readString = ((b) this).f5605e.readString();
        if (readString == null) {
            return null;
        }
        a b2 = b();
        try {
            return (c) a(readString).invoke(null, new Object[]{b2});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    public int a(int i2, int i3) {
        if (!a(i3)) {
            return i2;
        }
        return ((b) this).f5605e.readInt();
    }

    public void b(Parcelable parcelable, int i2) {
        b(i2);
        ((b) this).f5605e.writeParcelable(parcelable, 0);
    }

    public <T extends Parcelable> T a(T t, int i2) {
        if (!a(i2)) {
            return t;
        }
        return ((b) this).f5605e.readParcelable(b.class.getClassLoader());
    }

    public final Method b(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = (Method) this.f5602b.getOrDefault(cls.getName(), null);
        if (method != null) {
            return method;
        }
        Class a2 = a(cls);
        System.currentTimeMillis();
        Method declaredMethod = a2.getDeclaredMethod("write", new Class[]{cls, a.class});
        this.f5602b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public CharSequence a(CharSequence charSequence, int i2) {
        if (!a(i2)) {
            return charSequence;
        }
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((b) this).f5605e);
    }

    public void a(c cVar) {
        if (cVar == null) {
            ((b) this).f5605e.writeString(null);
            return;
        }
        try {
            ((b) this).f5605e.writeString(a(cVar.getClass()).getName());
            a b2 = b();
            try {
                b(cVar.getClass()).invoke(null, new Object[]{cVar, b2});
                b2.a();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (InvocationTargetException e3) {
                if (e3.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e3.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
            }
        } catch (ClassNotFoundException e6) {
            StringBuilder sb = new StringBuilder();
            sb.append(cVar.getClass().getSimpleName());
            sb.append(" does not have a Parcelizer");
            throw new RuntimeException(sb.toString(), e6);
        }
    }

    public final Method a(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<a> cls = a.class;
        Method method = (Method) this.f5601a.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f5601a.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Class a(Class<? extends c> cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f5603c.getOrDefault(cls.getName(), null);
        if (cls2 != null) {
            return cls2;
        }
        Class cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f5603c.put(cls.getName(), cls3);
        return cls3;
    }
}
