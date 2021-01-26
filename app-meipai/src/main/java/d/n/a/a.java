package d.n.a;

import android.util.Log;
import androidx.fragment.app.Fragment;
import d.n.a.j.h;
import d.p.e.b;
import java.io.PrintWriter;
import java.util.ArrayList;

/* compiled from: BackStackRecord */
public final class a extends q implements h {
    public final j r;
    public boolean s;
    public int t = -1;

    public a(j jVar) {
        this.r = jVar;
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f5197i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f5194f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f5194f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f5195g));
            }
            if (!(this.f5190b == 0 && this.f5191c == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5190b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5191c));
            }
            if (!(this.f5192d == 0 && this.f5193e == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5192d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5193e));
            }
            if (!(this.f5198j == 0 && this.k == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5198j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (!(this.l == 0 && this.m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        if (!this.f5189a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f5189a.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.n.a.q.a aVar = (d.n.a.q.a) this.f5189a.get(i2);
                switch (aVar.f5199a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        StringBuilder a2 = e.a.a.a.a.a("cmd=");
                        a2.append(aVar.f5199a);
                        str2 = a2.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f5200b);
                if (z) {
                    if (!(aVar.f5201c == 0 && aVar.f5202d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f5201c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f5202d));
                    }
                    if (aVar.f5203e != 0 || aVar.f5204f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f5203e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f5204f));
                    }
                }
            }
        }
    }

    public boolean b(int i2) {
        int size = this.f5189a.size();
        for (int i3 = 0; i3 < size; i3++) {
            Fragment fragment = ((d.n.a.q.a) this.f5189a.get(i3)).f5200b;
            int i4 = fragment != null ? fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        int size = this.f5189a.size();
        for (int i2 = 0; i2 < size; i2++) {
            d.n.a.q.a aVar = (d.n.a.q.a) this.f5189a.get(i2);
            Fragment fragment = aVar.f5200b;
            if (fragment != null) {
                fragment.setNextTransition(this.f5194f, this.f5195g);
            }
            switch (aVar.f5199a) {
                case 1:
                    fragment.setNextAnim(aVar.f5201c);
                    this.r.a(fragment, false);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f5202d);
                    this.r.i(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f5202d);
                    if (this.r != null) {
                        if (!fragment.mHidden) {
                            fragment.mHidden = true;
                            fragment.mHiddenChanged = !fragment.mHiddenChanged;
                            break;
                        }
                    } else {
                        throw null;
                    }
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f5201c);
                    if (this.r != null) {
                        if (fragment.mHidden) {
                            fragment.mHidden = false;
                            fragment.mHiddenChanged = !fragment.mHiddenChanged;
                            break;
                        }
                    } else {
                        throw null;
                    }
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f5202d);
                    this.r.b(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f5201c);
                    this.r.a(fragment);
                    break;
                case 8:
                    this.r.m(fragment);
                    break;
                case 9:
                    this.r.m(null);
                    break;
                case 10:
                    this.r.a(fragment, aVar.f5206h);
                    break;
                default:
                    StringBuilder a2 = e.a.a.a.a.a("Unknown cmd: ");
                    a2.append(aVar.f5199a);
                    throw new IllegalArgumentException(a2.toString());
            }
            if (!(this.p || aVar.f5199a == 1 || fragment == null)) {
                this.r.g(fragment);
            }
        }
        if (!this.p) {
            j jVar = this.r;
            jVar.a(jVar.o, true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.f5197i != null) {
            sb.append(" ");
            sb.append(this.f5197i);
        }
        sb.append("}");
        return sb.toString();
    }

    public void b(boolean z) {
        for (int size = this.f5189a.size() - 1; size >= 0; size--) {
            d.n.a.q.a aVar = (d.n.a.q.a) this.f5189a.get(size);
            Fragment fragment = aVar.f5200b;
            if (fragment != null) {
                fragment.setNextTransition(j.d(this.f5194f), this.f5195g);
            }
            switch (aVar.f5199a) {
                case 1:
                    fragment.setNextAnim(aVar.f5204f);
                    this.r.i(fragment);
                    break;
                case 3:
                    fragment.setNextAnim(aVar.f5203e);
                    this.r.a(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.f5203e);
                    if (this.r != null) {
                        if (fragment.mHidden) {
                            fragment.mHidden = false;
                            fragment.mHiddenChanged = !fragment.mHiddenChanged;
                            break;
                        }
                    } else {
                        throw null;
                    }
                    break;
                case 5:
                    fragment.setNextAnim(aVar.f5204f);
                    if (this.r != null) {
                        if (!fragment.mHidden) {
                            fragment.mHidden = true;
                            fragment.mHiddenChanged = !fragment.mHiddenChanged;
                            break;
                        }
                    } else {
                        throw null;
                    }
                    break;
                case 6:
                    fragment.setNextAnim(aVar.f5203e);
                    this.r.a(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.f5204f);
                    this.r.b(fragment);
                    break;
                case 8:
                    this.r.m(null);
                    break;
                case 9:
                    this.r.m(fragment);
                    break;
                case 10:
                    this.r.a(fragment, aVar.f5205g);
                    break;
                default:
                    StringBuilder a2 = e.a.a.a.a.a("Unknown cmd: ");
                    a2.append(aVar.f5199a);
                    throw new IllegalArgumentException(a2.toString());
            }
            if (!(this.p || aVar.f5199a == 3 || fragment == null)) {
                this.r.g(fragment);
            }
        }
        if (!this.p && z) {
            j jVar = this.r;
            jVar.a(jVar.o, true);
        }
    }

    public void b() {
        if (!this.f5196h) {
            j jVar = this.r;
            jVar.c(false);
            if (a(jVar.y, jVar.z)) {
                jVar.f5129d = true;
                try {
                    jVar.c(jVar.y, jVar.z);
                } finally {
                    jVar.f();
                }
            }
            jVar.q();
            jVar.j();
            jVar.d();
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void a(int i2, Fragment fragment, String str, int i3) {
        super.a(i2, fragment, str, i3);
        fragment.mFragmentManager = this.r;
    }

    public static boolean b(d.n.a.q.a aVar) {
        Fragment fragment = aVar.f5200b;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    public q a(Fragment fragment) {
        j jVar = fragment.mFragmentManager;
        if (jVar == null || jVar == this.r) {
            super.a(fragment);
            return this;
        }
        StringBuilder a2 = e.a.a.a.a.a("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
        a2.append(fragment.toString());
        a2.append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(a2.toString());
    }

    public q a(Fragment fragment, b bVar) {
        if (fragment.mFragmentManager != this.r) {
            StringBuilder a2 = e.a.a.a.a.a("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            a2.append(this.r);
            throw new IllegalArgumentException(a2.toString());
        } else if (bVar.a(b.CREATED)) {
            super.a(fragment, bVar);
            return this;
        } else {
            StringBuilder a3 = e.a.a.a.a.a("Cannot set maximum Lifecycle below ");
            a3.append(b.CREATED);
            throw new IllegalArgumentException(a3.toString());
        }
    }

    public void a(int i2) {
        if (this.f5196h) {
            String str = "FragmentManager";
            if (j.G) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(i2);
                Log.v(str, sb.toString());
            }
            int size = this.f5189a.size();
            for (int i3 = 0; i3 < size; i3++) {
                d.n.a.q.a aVar = (d.n.a.q.a) this.f5189a.get(i3);
                Fragment fragment = aVar.f5200b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (j.G) {
                        StringBuilder a2 = e.a.a.a.a.a("Bump nesting of ");
                        a2.append(aVar.f5200b);
                        a2.append(" to ");
                        a2.append(aVar.f5200b.mBackStackNesting);
                        Log.v(str, a2.toString());
                    }
                }
            }
        }
    }

    public int a() {
        return a(true);
    }

    public int a(boolean z) {
        if (!this.s) {
            if (j.G) {
                StringBuilder sb = new StringBuilder();
                sb.append("Commit: ");
                sb.append(this);
                String str = "FragmentManager";
                Log.v(str, sb.toString());
                PrintWriter printWriter = new PrintWriter(new d.h.j.a(str));
                a("  ", printWriter, true);
                printWriter.close();
            }
            this.s = true;
            if (this.f5196h) {
                this.t = this.r.a(this);
            } else {
                this.t = -1;
            }
            this.r.a((h) this, z);
            return this.t;
        }
        throw new IllegalStateException("commit already called");
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (j.G) {
            StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
            Log.v("FragmentManager", sb.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.valueOf(false));
        if (this.f5196h) {
            j jVar = this.r;
            if (jVar.f5133h == null) {
                jVar.f5133h = new ArrayList<>();
            }
            jVar.f5133h.add(this);
        }
        return true;
    }

    public boolean a(ArrayList<a> arrayList, int i2, int i3) {
        if (i3 == i2) {
            return false;
        }
        int size = this.f5189a.size();
        int i4 = -1;
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = ((d.n.a.q.a) this.f5189a.get(i5)).f5200b;
            int i6 = fragment != null ? fragment.mContainerId : 0;
            if (!(i6 == 0 || i6 == i4)) {
                for (int i7 = i2; i7 < i3; i7++) {
                    a aVar = (a) arrayList.get(i7);
                    int size2 = aVar.f5189a.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        Fragment fragment2 = ((d.n.a.q.a) aVar.f5189a.get(i8)).f5200b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i6) {
                            return true;
                        }
                    }
                }
                i4 = i6;
            }
        }
        return false;
    }
}
