package d.h.f;

import a.a.a.a.b.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import d.e.h;
import d.h.e.b.c;
import d.h.e.b.d;
import d.h.h.b.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl */
public class e extends h {

    /* renamed from: b reason: collision with root package name */
    public static final Class f4817b;

    /* renamed from: c reason: collision with root package name */
    public static final Constructor f4818c;

    /* renamed from: d reason: collision with root package name */
    public static final Method f4819d;

    /* renamed from: e reason: collision with root package name */
    public static final Method f4820e;

    static {
        Method method;
        Method method2;
        Class cls;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method2 = null;
            method = null;
        }
        f4818c = constructor;
        f4817b = cls;
        f4819d = method;
        f4820e = method2;
    }

    public Typeface a(Context context, c cVar, Resources resources, int i2) {
        Object obj;
        d[] dVarArr;
        ByteBuffer byteBuffer;
        Throwable th;
        try {
            obj = f4818c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        for (d dVar : cVar.f4792a) {
            int i3 = dVar.f4798f;
            File b2 = a.b(context);
            Resources resources2 = resources;
            if (b2 != null) {
                try {
                    if (a.a(b2, resources2, i3)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(b2);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                byteBuffer = channel.map(MapMode.READ_ONLY, 0, channel.size());
                                fileInputStream.close();
                                b2.delete();
                                if (byteBuffer != null || !a(obj, byteBuffer, dVar.f4797e, dVar.f4794b, dVar.f4795c)) {
                                    return null;
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                fileInputStream.close();
                                throw th3;
                            }
                        } catch (IOException unused2) {
                            byteBuffer = null;
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    }
                } finally {
                    b2.delete();
                }
            }
            byteBuffer = null;
            if (byteBuffer != null) {
                return null;
            }
        }
        return a(obj);
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f[] fVarArr, int i2) {
        Object obj;
        try {
            obj = f4818c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        h hVar = new h();
        for (f fVar : fVarArr) {
            Uri uri = fVar.f4846a;
            ByteBuffer byteBuffer = (ByteBuffer) hVar.get(uri);
            if (byteBuffer == null) {
                byteBuffer = a.a(context, cancellationSignal, uri);
                hVar.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !a(obj, byteBuffer, fVar.f4847b, fVar.f4848c, fVar.f4849d)) {
                return null;
            }
        }
        Typeface a2 = a(obj);
        if (a2 == null) {
            return null;
        }
        return Typeface.create(a2, i2);
    }

    public static boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f4819d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f4817b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f4820e.invoke(null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
