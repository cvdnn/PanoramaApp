package e.d.a;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.GeneratedAppGlideModule;
import e.c.f.n.n;
import e.d.a.n.j;
import e.d.a.n.n.c0.d;
import e.d.a.n.n.d0.a.C0083a;
import e.d.a.n.n.d0.i;
import e.d.a.n.n.e0.a.C0084a;
import e.d.a.n.o.f.e;
import e.d.a.n.o.s;
import e.d.a.n.o.s.c;
import e.d.a.n.o.u;
import e.d.a.n.o.w;
import e.d.a.n.o.y.a.C0092a;
import e.d.a.n.p.c.a0;
import e.d.a.n.p.c.b0;
import e.d.a.n.p.c.b0.g;
import e.d.a.n.p.c.h;
import e.d.a.n.p.c.k;
import e.d.a.n.p.c.m;
import e.d.a.n.p.c.p;
import e.d.a.n.p.c.t;
import e.d.a.n.p.c.v;
import e.d.a.n.p.c.x;
import e.d.a.n.p.c.y;
import e.d.a.n.p.d.a.C0095a;
import e.d.a.o.l;
import e.d.a.r.h.f;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Glide */
public class b implements ComponentCallbacks2 {

    /* renamed from: i reason: collision with root package name */
    public static volatile b f7081i;

    /* renamed from: j reason: collision with root package name */
    public static volatile boolean f7082j;

    /* renamed from: a reason: collision with root package name */
    public final d f7083a;

    /* renamed from: b reason: collision with root package name */
    public final i f7084b;

    /* renamed from: c reason: collision with root package name */
    public final d f7085c;

    /* renamed from: d reason: collision with root package name */
    public final h f7086d;

    /* renamed from: e reason: collision with root package name */
    public final e.d.a.n.n.c0.b f7087e;

    /* renamed from: f reason: collision with root package name */
    public final l f7088f;

    /* renamed from: g reason: collision with root package name */
    public final e.d.a.o.d f7089g;

    /* renamed from: h reason: collision with root package name */
    public final List<j> f7090h = new ArrayList();

    /* compiled from: Glide */
    public interface a {
    }

    public b(Context context, e.d.a.n.n.l lVar, i iVar, d dVar, e.d.a.n.n.c0.b bVar, l lVar2, e.d.a.o.d dVar2, int i2, a aVar, Map<Class<?>, k<?, ?>> map, List<e.d.a.r.d<Object>> list, boolean z, boolean z2) {
        j jVar;
        j jVar2;
        Context context2 = context;
        d dVar3 = dVar;
        e.d.a.n.n.c0.b bVar2 = bVar;
        Class<e.d.a.m.a> cls = e.d.a.m.a.class;
        Class<String> cls2 = String.class;
        Class<Integer> cls3 = Integer.class;
        Class<byte[]> cls4 = byte[].class;
        e eVar = e.NORMAL;
        this.f7083a = dVar3;
        this.f7087e = bVar2;
        this.f7084b = iVar;
        this.f7088f = lVar2;
        this.f7089g = dVar2;
        Resources resources = context.getResources();
        h hVar = new h();
        this.f7086d = hVar;
        hVar.f7126g.a(new k());
        if (VERSION.SDK_INT >= 27) {
            h hVar2 = this.f7086d;
            hVar2.f7126g.a(new p());
        }
        List a2 = this.f7086d.a();
        e.d.a.n.p.g.a aVar2 = new e.d.a.n.p.g.a(context2, a2, dVar3, bVar2);
        b0 b0Var = new b0(dVar3, new g());
        m mVar = new m(this.f7086d.a(), resources.getDisplayMetrics(), dVar3, bVar2);
        if (!z2 || VERSION.SDK_INT < 28) {
            jVar = new e.d.a.n.p.c.g(mVar);
            jVar2 = new y(mVar, bVar2);
        } else {
            jVar2 = new t();
            jVar = new h();
        }
        e.d.a.n.p.e.d dVar4 = new e.d.a.n.p.e.d(context2);
        Class<byte[]> cls5 = cls4;
        c cVar = new c(resources);
        s.d dVar5 = new s.d(resources);
        Class<String> cls6 = cls2;
        e.d.a.n.o.s.b bVar3 = new e.d.a.n.o.s.b(resources);
        s.d dVar6 = dVar5;
        e.d.a.n.o.s.a aVar3 = new e.d.a.n.o.s.a(resources);
        e.d.a.n.p.c.c cVar2 = new e.d.a.n.p.c.c(bVar2);
        Class<Integer> cls7 = cls3;
        e.d.a.n.p.h.a aVar4 = new e.d.a.n.p.h.a();
        e.d.a.n.p.h.d dVar7 = new e.d.a.n.p.h.d();
        ContentResolver contentResolver = context.getContentResolver();
        h hVar3 = this.f7086d;
        e.d.a.n.o.s.b bVar4 = bVar3;
        c cVar3 = cVar;
        e.d.a.n.o.c cVar4 = new e.d.a.n.o.c();
        e.d.a.n.p.e.d dVar8 = dVar4;
        hVar3.f7121b.a(ByteBuffer.class, cVar4);
        e.d.a.n.o.t tVar = new e.d.a.n.o.t(bVar2);
        hVar3.f7121b.a(InputStream.class, tVar);
        Class<e.d.a.m.a> cls8 = cls;
        String str = "Bitmap";
        hVar3.f7122c.a(str, jVar, ByteBuffer.class, Bitmap.class);
        hVar3.f7122c.a(str, jVar2, InputStream.class, Bitmap.class);
        h hVar4 = this.f7086d;
        v vVar = new v(mVar);
        hVar4.f7122c.a(str, vVar, ParcelFileDescriptor.class, Bitmap.class);
        h hVar5 = this.f7086d;
        hVar5.f7122c.a(str, b0Var, ParcelFileDescriptor.class, Bitmap.class);
        b0 b0Var2 = new b0(dVar3, new b0.c(null));
        hVar5.f7122c.a(str, b0Var2, AssetFileDescriptor.class, Bitmap.class);
        e.d.a.n.o.v.a<?> aVar5 = e.d.a.n.o.v.a.f7612a;
        hVar5.f7120a.a(Bitmap.class, Bitmap.class, aVar5);
        a0 a0Var = new a0();
        hVar5.f7122c.a(str, a0Var, Bitmap.class, Bitmap.class);
        hVar5.f7123d.a(Bitmap.class, cVar2);
        e.d.a.n.p.c.a aVar6 = new e.d.a.n.p.c.a(resources, jVar);
        String str2 = "BitmapDrawable";
        hVar5.f7122c.a(str2, aVar6, ByteBuffer.class, BitmapDrawable.class);
        e.d.a.n.p.c.a aVar7 = new e.d.a.n.p.c.a(resources, jVar2);
        hVar5.f7122c.a(str2, aVar7, InputStream.class, BitmapDrawable.class);
        e.d.a.n.p.c.a aVar8 = new e.d.a.n.p.c.a(resources, b0Var);
        hVar5.f7122c.a(str2, aVar8, ParcelFileDescriptor.class, BitmapDrawable.class);
        e.d.a.n.p.c.b bVar5 = new e.d.a.n.p.c.b(dVar3, cVar2);
        hVar5.f7123d.a(BitmapDrawable.class, bVar5);
        e.d.a.n.p.g.j jVar3 = new e.d.a.n.p.g.j(a2, aVar2, bVar2);
        String str3 = "Gif";
        hVar5.f7122c.a(str3, jVar3, InputStream.class, e.d.a.n.p.g.c.class);
        hVar5.f7122c.a(str3, aVar2, ByteBuffer.class, e.d.a.n.p.g.c.class);
        e.d.a.n.p.g.d dVar9 = new e.d.a.n.p.g.d();
        hVar5.f7123d.a(e.d.a.n.p.g.c.class, dVar9);
        Class<e.d.a.m.a> cls9 = cls8;
        hVar5.f7120a.a(cls9, cls9, e.d.a.n.o.v.a.f7612a);
        e.d.a.n.p.g.h hVar6 = new e.d.a.n.p.g.h(dVar3);
        hVar5.f7122c.a(str, hVar6, cls9, Bitmap.class);
        String str4 = "legacy_append";
        e.d.a.n.p.e.d dVar10 = dVar8;
        hVar5.f7122c.a(str4, dVar10, Uri.class, Drawable.class);
        x xVar = new x(dVar10, dVar3);
        hVar5.f7122c.a(str4, xVar, Uri.class, Bitmap.class);
        hVar5.f7124e.a((e.d.a.n.m.e.a<?>) new C0095a<Object>());
        e.d.a.n.o.d.b bVar6 = new e.d.a.n.o.d.b();
        hVar5.f7120a.a(File.class, ByteBuffer.class, bVar6);
        e eVar2 = new e();
        hVar5.f7120a.a(File.class, InputStream.class, eVar2);
        e.d.a.n.p.f.a aVar9 = new e.d.a.n.p.f.a();
        hVar5.f7122c.a(str4, aVar9, File.class, File.class);
        e.d.a.n.o.f.b bVar7 = new e.d.a.n.o.f.b();
        hVar5.f7120a.a(File.class, ParcelFileDescriptor.class, bVar7);
        e.d.a.n.o.v.a<?> aVar10 = e.d.a.n.o.v.a.f7612a;
        hVar5.f7120a.a(File.class, File.class, aVar10);
        hVar5.f7124e.a((e.d.a.n.m.e.a<?>) new e.d.a.n.m.k.a<Object>(bVar2));
        h hVar7 = this.f7086d;
        hVar7.f7124e.a((e.d.a.n.m.e.a<?>) new e.d.a.n.m.m.a<Object>());
        h hVar8 = this.f7086d;
        c cVar5 = cVar3;
        hVar8.f7120a.a(Integer.TYPE, InputStream.class, cVar5);
        e.d.a.n.o.s.b bVar8 = bVar4;
        hVar8.f7120a.a(Integer.TYPE, ParcelFileDescriptor.class, bVar8);
        Class<Integer> cls10 = cls7;
        hVar8.f7120a.a(cls10, InputStream.class, cVar5);
        hVar8.f7120a.a(cls10, ParcelFileDescriptor.class, bVar8);
        s.d dVar11 = dVar6;
        hVar8.f7120a.a(cls10, Uri.class, dVar11);
        e.d.a.n.o.s.a aVar11 = aVar3;
        hVar8.f7120a.a(Integer.TYPE, AssetFileDescriptor.class, aVar11);
        hVar8.f7120a.a(cls10, AssetFileDescriptor.class, aVar11);
        hVar8.f7120a.a(Integer.TYPE, Uri.class, dVar11);
        e.d.a.n.o.e.c cVar6 = new e.d.a.n.o.e.c();
        Class<String> cls11 = cls6;
        hVar8.f7120a.a(cls11, InputStream.class, cVar6);
        e.d.a.n.o.e.c cVar7 = new e.d.a.n.o.e.c();
        hVar8.f7120a.a(Uri.class, InputStream.class, cVar7);
        u.c cVar8 = new u.c();
        hVar8.f7120a.a(cls11, InputStream.class, cVar8);
        e.d.a.n.o.u.b bVar9 = new e.d.a.n.o.u.b();
        hVar8.f7120a.a(cls11, ParcelFileDescriptor.class, bVar9);
        e.d.a.n.o.u.a aVar12 = new e.d.a.n.o.u.a();
        hVar8.f7120a.a(cls11, AssetFileDescriptor.class, aVar12);
        e.d.a.n.o.y.b.a aVar13 = new e.d.a.n.o.y.b.a();
        hVar8.f7120a.a(Uri.class, InputStream.class, aVar13);
        e.d.a.n.o.a.c cVar9 = new e.d.a.n.o.a.c(context.getAssets());
        hVar8.f7120a.a(Uri.class, InputStream.class, cVar9);
        e.d.a.n.o.a.b bVar10 = new e.d.a.n.o.a.b(context.getAssets());
        hVar8.f7120a.a(Uri.class, ParcelFileDescriptor.class, bVar10);
        Context context3 = context;
        e.d.a.n.o.y.c.a aVar14 = new e.d.a.n.o.y.c.a(context3);
        hVar8.f7120a.a(Uri.class, InputStream.class, aVar14);
        e.d.a.n.o.y.d.a aVar15 = new e.d.a.n.o.y.d.a(context3);
        hVar8.f7120a.a(Uri.class, InputStream.class, aVar15);
        if (VERSION.SDK_INT >= 29) {
            h hVar9 = this.f7086d;
            e.d.a.n.o.y.e.c cVar10 = new e.d.a.n.o.y.e.c(context3);
            hVar9.f7120a.a(Uri.class, InputStream.class, cVar10);
            h hVar10 = this.f7086d;
            e.d.a.n.o.y.e.b bVar11 = new e.d.a.n.o.y.e.b(context3);
            hVar10.f7120a.a(Uri.class, ParcelFileDescriptor.class, bVar11);
        }
        h hVar11 = this.f7086d;
        ContentResolver contentResolver2 = contentResolver;
        w.d dVar12 = new w.d(contentResolver2);
        hVar11.f7120a.a(Uri.class, InputStream.class, dVar12);
        e.d.a.n.o.w.b bVar12 = new e.d.a.n.o.w.b(contentResolver2);
        hVar11.f7120a.a(Uri.class, ParcelFileDescriptor.class, bVar12);
        e.d.a.n.o.w.a aVar16 = new e.d.a.n.o.w.a(contentResolver2);
        hVar11.f7120a.a(Uri.class, AssetFileDescriptor.class, aVar16);
        e.d.a.n.o.x.a aVar17 = new e.d.a.n.o.x.a();
        hVar11.f7120a.a(Uri.class, InputStream.class, aVar17);
        e.d.a.n.o.y.f.a aVar18 = new e.d.a.n.o.y.f.a();
        hVar11.f7120a.a(URL.class, InputStream.class, aVar18);
        e.d.a.n.o.k.a aVar19 = new e.d.a.n.o.k.a(context3);
        hVar11.f7120a.a(Uri.class, File.class, aVar19);
        C0092a aVar20 = new C0092a();
        hVar11.f7120a.a(e.d.a.n.o.g.class, InputStream.class, aVar20);
        e.d.a.n.o.b.a aVar21 = new e.d.a.n.o.b.a();
        Class<byte[]> cls12 = cls5;
        hVar11.f7120a.a(cls12, ByteBuffer.class, aVar21);
        e.d.a.n.o.b.d dVar13 = new e.d.a.n.o.b.d();
        hVar11.f7120a.a(cls12, InputStream.class, dVar13);
        e.d.a.n.o.v.a<?> aVar22 = e.d.a.n.o.v.a.f7612a;
        hVar11.f7120a.a(Uri.class, Uri.class, aVar22);
        e.d.a.n.o.v.a<?> aVar23 = e.d.a.n.o.v.a.f7612a;
        hVar11.f7120a.a(Drawable.class, Drawable.class, aVar23);
        e.d.a.n.p.e.e eVar3 = new e.d.a.n.p.e.e();
        hVar11.f7122c.a(str4, eVar3, Drawable.class, Drawable.class);
        e.d.a.n.p.h.b bVar13 = new e.d.a.n.p.h.b(resources);
        hVar11.f7125f.a(Bitmap.class, BitmapDrawable.class, bVar13);
        e.d.a.n.p.h.a aVar24 = aVar4;
        hVar11.f7125f.a(Bitmap.class, cls12, aVar24);
        e.d.a.n.p.h.d dVar14 = dVar7;
        e.d.a.n.p.h.c cVar11 = new e.d.a.n.p.h.c(dVar3, aVar24, dVar14);
        hVar11.f7125f.a(Drawable.class, cls12, cVar11);
        hVar11.f7125f.a(e.d.a.n.p.g.c.class, cls12, dVar14);
        b0 b0Var3 = new b0(dVar3, new b0.d());
        this.f7086d.f7122c.a(str4, b0Var3, ByteBuffer.class, Bitmap.class);
        h hVar12 = this.f7086d;
        e.d.a.n.p.c.a aVar25 = new e.d.a.n.p.c.a(resources, b0Var3);
        hVar12.f7122c.a(str4, aVar25, ByteBuffer.class, BitmapDrawable.class);
        Context context4 = context;
        e.d.a.n.n.c0.b bVar14 = bVar;
        d dVar15 = new d(context4, bVar14, this.f7086d, new f(), aVar, map, list, lVar, z, i2);
        this.f7085c = dVar15;
    }

    public static b a(Context context) {
        if (f7081i == null) {
            Context applicationContext = context.getApplicationContext();
            GeneratedAppGlideModule generatedAppGlideModule = null;
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{applicationContext.getApplicationContext()});
            } catch (ClassNotFoundException unused) {
                String str = "Glide";
                if (Log.isLoggable(str, 5)) {
                    Log.w(str, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
            } catch (InstantiationException e2) {
                a((Exception) e2);
                throw null;
            } catch (IllegalAccessException e3) {
                a((Exception) e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                a((Exception) e4);
                throw null;
            } catch (InvocationTargetException e5) {
                a((Exception) e5);
                throw null;
            }
            synchronized (b.class) {
                if (f7081i == null) {
                    a(context, generatedAppGlideModule);
                }
            }
        }
        return f7081i;
    }

    public static l b(Context context) {
        n.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).f7088f;
    }

    public static j c(Context context) {
        return b(context).a(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        e.d.a.t.j.a();
        ((e.d.a.t.g) this.f7084b).a(0);
        this.f7083a.a();
        this.f7087e.a();
    }

    public void onTrimMemory(int i2) {
        e.d.a.t.j.a();
        for (j jVar : this.f7090h) {
            if (jVar == null) {
                throw null;
            }
        }
        e.d.a.n.n.d0.h hVar = (e.d.a.n.n.d0.h) this.f7084b;
        if (hVar != null) {
            if (i2 >= 40) {
                hVar.a(0);
            } else if (i2 >= 20 || i2 == 15) {
                hVar.a(hVar.a() / 2);
            }
            this.f7083a.a(i2);
            this.f7087e.a(i2);
            return;
        }
        throw null;
    }

    public void b(j jVar) {
        synchronized (this.f7090h) {
            if (this.f7090h.contains(jVar)) {
                this.f7090h.remove(jVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        List<e.d.a.p.c> list;
        GeneratedAppGlideModule generatedAppGlideModule2 = generatedAppGlideModule;
        if (!f7082j) {
            f7082j = true;
            c cVar = new c();
            Context applicationContext = context.getApplicationContext();
            List emptyList = Collections.emptyList();
            if (generatedAppGlideModule2 == null || generatedAppGlideModule.a()) {
                String str = "ManifestParser";
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Loading Glide modules");
                }
                ArrayList arrayList = new ArrayList();
                try {
                    ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                    if (applicationInfo.metaData != null) {
                        if (Log.isLoggable(str, 2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Got app info metadata: ");
                            sb.append(applicationInfo.metaData);
                            Log.v(str, sb.toString());
                        }
                        for (String str2 : applicationInfo.metaData.keySet()) {
                            if ("GlideModule".equals(applicationInfo.metaData.get(str2))) {
                                arrayList.add(e.d.a.p.e.a(str2));
                                if (Log.isLoggable(str, 3)) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Loaded Glide module: ");
                                    sb2.append(str2);
                                    Log.d(str, sb2.toString());
                                }
                            }
                        }
                        if (Log.isLoggable(str, 3)) {
                            Log.d(str, "Finished loading Glide modules");
                        }
                    } else if (Log.isLoggable(str, 3)) {
                        Log.d(str, "Got null app info metadata");
                    }
                    list = arrayList;
                } catch (NameNotFoundException e2) {
                    throw new RuntimeException("Unable to find metadata to parse GlideModules", e2);
                }
            } else {
                list = emptyList;
            }
            String str3 = "Glide";
            if (generatedAppGlideModule2 != null && !generatedAppGlideModule.b().isEmpty()) {
                Set b2 = generatedAppGlideModule.b();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    e.d.a.p.c cVar2 = (e.d.a.p.c) it.next();
                    if (b2.contains(cVar2.getClass())) {
                        if (Log.isLoggable(str3, 3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("AppGlideModule excludes manifest GlideModule: ");
                            sb3.append(cVar2);
                            Log.d(str3, sb3.toString());
                        }
                        it.remove();
                    }
                }
            }
            if (Log.isLoggable(str3, 3)) {
                for (e.d.a.p.c cVar3 : list) {
                    StringBuilder a2 = e.a.a.a.a.a("Discovered GlideModule from manifest: ");
                    a2.append(cVar3.getClass());
                    Log.d(str3, a2.toString());
                }
            }
            cVar.m = generatedAppGlideModule2 != null ? generatedAppGlideModule.c() : null;
            for (e.d.a.p.c a3 : list) {
                a3.a(applicationContext, cVar);
            }
            if (generatedAppGlideModule2 != null) {
                generatedAppGlideModule2.a(applicationContext, cVar);
            }
            if (cVar.f7096f == null) {
                cVar.f7096f = e.d.a.n.n.e0.a.c();
            }
            if (cVar.f7097g == null) {
                cVar.f7097g = e.d.a.n.n.e0.a.b();
            }
            if (cVar.n == null) {
                int i2 = e.d.a.n.n.e0.a.a() >= 4 ? 2 : 1;
                e.d.a.n.n.e0.a.b bVar = e.d.a.n.n.e0.a.b.f7387b;
                String str4 = "animation";
                if (!TextUtils.isEmpty(str4)) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C0084a(str4, bVar, true));
                    cVar.n = new e.d.a.n.n.e0.a(threadPoolExecutor);
                } else {
                    throw new IllegalArgumentException(e.a.a.a.a.a("Name must be non-null and non-empty, but given: ", str4));
                }
            }
            if (cVar.f7099i == null) {
                cVar.f7099i = new e.d.a.n.n.d0.j(new e.d.a.n.n.d0.j.a(applicationContext));
            }
            if (cVar.f7100j == null) {
                cVar.f7100j = new e.d.a.o.f();
            }
            if (cVar.f7093c == null) {
                int i3 = cVar.f7099i.f7358a;
                if (i3 > 0) {
                    cVar.f7093c = new e.d.a.n.n.c0.j((long) i3);
                } else {
                    cVar.f7093c = new e.d.a.n.n.c0.e();
                }
            }
            if (cVar.f7094d == null) {
                cVar.f7094d = new e.d.a.n.n.c0.i(cVar.f7099i.f7361d);
            }
            if (cVar.f7095e == null) {
                cVar.f7095e = new e.d.a.n.n.d0.h((long) cVar.f7099i.f7359b);
            }
            if (cVar.f7098h == null) {
                cVar.f7098h = new e.d.a.n.n.d0.g(applicationContext);
            }
            if (cVar.f7092b == null) {
                i iVar = cVar.f7095e;
                C0083a aVar = cVar.f7098h;
                e.d.a.n.n.e0.a aVar2 = cVar.f7097g;
                e.d.a.n.n.e0.a aVar3 = cVar.f7096f;
                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(0, Integer.MAX_VALUE, e.d.a.n.n.e0.a.f7378b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new C0084a("source-unlimited", e.d.a.n.n.e0.a.b.f7387b, false));
                e.d.a.n.n.l lVar = new e.d.a.n.n.l(iVar, aVar, aVar2, aVar3, new e.d.a.n.n.e0.a(threadPoolExecutor2), cVar.n, false);
                cVar.f7092b = lVar;
            }
            List<e.d.a.r.d<Object>> list2 = cVar.o;
            if (list2 == null) {
                cVar.o = Collections.emptyList();
            } else {
                cVar.o = Collections.unmodifiableList(list2);
            }
            l lVar2 = new l(cVar.m);
            e.d.a.n.n.l lVar3 = cVar.f7092b;
            i iVar2 = cVar.f7095e;
            d dVar = cVar.f7093c;
            e.d.a.n.n.c0.b bVar2 = cVar.f7094d;
            e.d.a.o.d dVar2 = cVar.f7100j;
            int i4 = cVar.k;
            a aVar4 = cVar.l;
            Map<Class<?>, k<?, ?>> map = cVar.f7091a;
            List<e.d.a.r.d<Object>> list3 = cVar.o;
            Context context2 = applicationContext;
            b bVar3 = new b(applicationContext, lVar3, iVar2, dVar, bVar2, lVar2, dVar2, i4, aVar4, map, list3, false, false);
            for (e.d.a.p.c cVar4 : list) {
                try {
                    cVar4.a(context2, bVar3, bVar3.f7086d);
                } catch (AbstractMethodError e3) {
                    StringBuilder a4 = e.a.a.a.a.a("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                    a4.append(cVar4.getClass().getName());
                    throw new IllegalStateException(a4.toString(), e3);
                }
            }
            if (generatedAppGlideModule2 != null) {
                generatedAppGlideModule2.a(context2, bVar3, bVar3.f7086d);
            }
            context2.registerComponentCallbacks(bVar3);
            f7081i = bVar3;
            f7082j = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static j a(d.n.a.d dVar) {
        return b((Context) dVar).a(dVar);
    }

    public boolean a(e.d.a.r.h.h<?> hVar) {
        synchronized (this.f7090h) {
            for (j b2 : this.f7090h) {
                if (b2.b(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void a(j jVar) {
        synchronized (this.f7090h) {
            if (!this.f7090h.contains(jVar)) {
                this.f7090h.add(jVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
