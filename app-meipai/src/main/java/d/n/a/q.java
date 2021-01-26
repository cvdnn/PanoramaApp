package d.n.a;

import androidx.fragment.app.Fragment;
import d.p.e.b;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction */
public abstract class q {

    /* renamed from: a reason: collision with root package name */
    public ArrayList<a> f5189a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    public int f5190b;

    /* renamed from: c reason: collision with root package name */
    public int f5191c;

    /* renamed from: d reason: collision with root package name */
    public int f5192d;

    /* renamed from: e reason: collision with root package name */
    public int f5193e;

    /* renamed from: f reason: collision with root package name */
    public int f5194f;

    /* renamed from: g reason: collision with root package name */
    public int f5195g;

    /* renamed from: h reason: collision with root package name */
    public boolean f5196h;

    /* renamed from: i reason: collision with root package name */
    public String f5197i;

    /* renamed from: j reason: collision with root package name */
    public int f5198j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;
    public ArrayList<Runnable> q;

    /* compiled from: FragmentTransaction */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public int f5199a;

        /* renamed from: b reason: collision with root package name */
        public Fragment f5200b;

        /* renamed from: c reason: collision with root package name */
        public int f5201c;

        /* renamed from: d reason: collision with root package name */
        public int f5202d;

        /* renamed from: e reason: collision with root package name */
        public int f5203e;

        /* renamed from: f reason: collision with root package name */
        public int f5204f;

        /* renamed from: g reason: collision with root package name */
        public b f5205g;

        /* renamed from: h reason: collision with root package name */
        public b f5206h;

        public a() {
        }

        public a(int i2, Fragment fragment) {
            this.f5199a = i2;
            this.f5200b = fragment;
            b bVar = b.RESUMED;
            this.f5205g = bVar;
            this.f5206h = bVar;
        }

        public a(int i2, Fragment fragment, b bVar) {
            this.f5199a = i2;
            this.f5200b = fragment;
            this.f5205g = fragment.mMaxState;
            this.f5206h = bVar;
        }
    }

    public abstract int a();

    public void a(a aVar) {
        this.f5189a.add(aVar);
        aVar.f5201c = this.f5190b;
        aVar.f5202d = this.f5191c;
        aVar.f5203e = this.f5192d;
        aVar.f5204f = this.f5193e;
    }

    public abstract void b();

    public void a(int i2, Fragment fragment, String str, int i3) {
        Class cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder a2 = e.a.a.a.a.a("Fragment ");
            a2.append(cls.getCanonicalName());
            a2.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(a2.toString());
        }
        String str2 = " now ";
        String str3 = ": was ";
        if (str != null) {
            String str4 = fragment.mTag;
            if (str4 == null || str.equals(str4)) {
                fragment.mTag = str;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't change tag of fragment ");
                sb.append(fragment);
                sb.append(str3);
                sb.append(fragment.mTag);
                sb.append(str2);
                sb.append(str);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.mFragmentId;
                if (i4 == 0 || i4 == i2) {
                    fragment.mFragmentId = i2;
                    fragment.mContainerId = i2;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Can't change container ID of fragment ");
                    sb2.append(fragment);
                    sb2.append(str3);
                    sb2.append(fragment.mFragmentId);
                    sb2.append(str2);
                    sb2.append(i2);
                    throw new IllegalStateException(sb2.toString());
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Can't add fragment ");
                sb3.append(fragment);
                sb3.append(" with tag ");
                sb3.append(str);
                sb3.append(" to container view with no id");
                throw new IllegalArgumentException(sb3.toString());
            }
        }
        a(new a(i3, fragment));
    }

    public q a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    public q a(Fragment fragment, b bVar) {
        a(new a(10, fragment, bVar));
        return this;
    }
}
