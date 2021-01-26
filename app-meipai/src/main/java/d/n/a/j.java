package d.n.a;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcher.LifecycleOnBackPressedCancellable;
import androidx.fragment.app.Fragment;
import com.baidu.mobstat.Config;
import d.h.k.l;
import d.p.q;
import d.p.r;
import d.p.s;
import d.p.t;
import d.p.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: FragmentManagerImpl */
public final class j extends i implements Factory2 {
    public static boolean G = false;
    public static final Interpolator H = new DecelerateInterpolator(2.5f);
    public static final Interpolator I = new DecelerateInterpolator(1.5f);
    public ArrayList<Fragment> A;
    public Bundle B = null;
    public SparseArray<Parcelable> C = null;
    public ArrayList<C0050j> D;
    public o E;
    public Runnable F = new b();

    /* renamed from: c reason: collision with root package name */
    public ArrayList<h> f5128c;

    /* renamed from: d reason: collision with root package name */
    public boolean f5129d;

    /* renamed from: e reason: collision with root package name */
    public int f5130e = 0;

    /* renamed from: f reason: collision with root package name */
    public final ArrayList<Fragment> f5131f = new ArrayList<>();

    /* renamed from: g reason: collision with root package name */
    public final HashMap<String, Fragment> f5132g = new HashMap<>();

    /* renamed from: h reason: collision with root package name */
    public ArrayList<a> f5133h;

    /* renamed from: i reason: collision with root package name */
    public ArrayList<Fragment> f5134i;

    /* renamed from: j reason: collision with root package name */
    public OnBackPressedDispatcher f5135j;
    public final d.a.b k = new a(false);
    public ArrayList<a> l;
    public ArrayList<Integer> m;
    public final CopyOnWriteArrayList<f> n = new CopyOnWriteArrayList<>();
    public int o = 0;
    public h p;
    public e q;
    public Fragment r;
    public Fragment s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public ArrayList<a> y;
    public ArrayList<Boolean> z;

    /* compiled from: FragmentManagerImpl */
    public class a extends d.a.b {
        public a(boolean z) {
            super(z);
        }
    }

    /* compiled from: FragmentManagerImpl */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            j.this.k();
        }
    }

    /* compiled from: FragmentManagerImpl */
    public class c extends g {
        public c() {
        }

        public Fragment a(ClassLoader classLoader, String str) {
            h hVar = j.this.p;
            Context context = hVar.f5122b;
            if (hVar != null) {
                return Fragment.instantiate(context, str, null);
            }
            throw null;
        }
    }

    /* compiled from: FragmentManagerImpl */
    public static class d {

        /* renamed from: a reason: collision with root package name */
        public final Animation f5139a;

        /* renamed from: b reason: collision with root package name */
        public final Animator f5140b;

        public d(Animation animation) {
            this.f5139a = animation;
            this.f5140b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public d(Animator animator) {
            this.f5139a = null;
            this.f5140b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentManagerImpl */
    public static class e extends AnimationSet implements Runnable {

        /* renamed from: a reason: collision with root package name */
        public final ViewGroup f5141a;

        /* renamed from: b reason: collision with root package name */
        public final View f5142b;

        /* renamed from: c reason: collision with root package name */
        public boolean f5143c;

        /* renamed from: d reason: collision with root package name */
        public boolean f5144d;

        /* renamed from: e reason: collision with root package name */
        public boolean f5145e = true;

        public e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f5141a = viewGroup;
            this.f5142b = view;
            addAnimation(animation);
            this.f5141a.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation) {
            this.f5145e = true;
            if (this.f5143c) {
                return !this.f5144d;
            }
            if (!super.getTransformation(j2, transformation)) {
                this.f5143c = true;
                l.a(this.f5141a, this);
            }
            return true;
        }

        public void run() {
            if (this.f5143c || !this.f5145e) {
                this.f5141a.endViewTransition(this.f5142b);
                this.f5144d = true;
                return;
            }
            this.f5145e = false;
            this.f5141a.post(this);
        }

        public boolean getTransformation(long j2, Transformation transformation, float f2) {
            this.f5145e = true;
            if (this.f5143c) {
                return !this.f5144d;
            }
            if (!super.getTransformation(j2, transformation, f2)) {
                this.f5143c = true;
                l.a(this.f5141a, this);
            }
            return true;
        }
    }

    /* compiled from: FragmentManagerImpl */
    public static final class f {

        /* renamed from: a reason: collision with root package name */
        public final d.n.a.i.a f5146a;

        /* renamed from: b reason: collision with root package name */
        public final boolean f5147b;

        public f(d.n.a.i.a aVar, boolean z) {
            this.f5146a = aVar;
            this.f5147b = z;
        }
    }

    /* compiled from: FragmentManagerImpl */
    public static class g {

        /* renamed from: a reason: collision with root package name */
        public static final int[] f5148a = {16842755, 16842960, 16842961};
    }

    /* compiled from: FragmentManagerImpl */
    public interface h {
        boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManagerImpl */
    public class i implements h {

        /* renamed from: a reason: collision with root package name */
        public final String f5149a;

        /* renamed from: b reason: collision with root package name */
        public final int f5150b;

        /* renamed from: c reason: collision with root package name */
        public final int f5151c;

        public i(String str, int i2, int i3) {
            this.f5149a = str;
            this.f5150b = i2;
            this.f5151c = i3;
        }

        public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = j.this.s;
            if (fragment != null && this.f5150b < 0 && this.f5149a == null && fragment.getChildFragmentManager().c()) {
                return false;
            }
            return j.this.a(arrayList, arrayList2, this.f5149a, this.f5150b, this.f5151c);
        }
    }

    /* renamed from: d.n.a.j$j reason: collision with other inner class name */
    /* compiled from: FragmentManagerImpl */
    public static class C0050j implements androidx.fragment.app.Fragment.f {

        /* renamed from: a reason: collision with root package name */
        public final boolean f5153a;

        /* renamed from: b reason: collision with root package name */
        public final a f5154b;

        /* renamed from: c reason: collision with root package name */
        public int f5155c;

        public C0050j(a aVar, boolean z) {
            this.f5153a = z;
            this.f5154b = aVar;
        }

        public void a() {
            boolean z = this.f5155c > 0;
            j jVar = this.f5154b.r;
            int size = jVar.f5131f.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = (Fragment) jVar.f5131f.get(i2);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            a aVar = this.f5154b;
            aVar.r.a(aVar, this.f5153a, !z, true);
        }
    }

    public static int d(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    public final void a(RuntimeException runtimeException) {
        String str = "FragmentManager";
        Log.e(str, runtimeException.getMessage());
        Log.e(str, "Activity state:");
        PrintWriter printWriter = new PrintWriter(new d.h.j.a(str));
        h hVar = this.p;
        String str2 = "Failed dumping state";
        String str3 = "  ";
        if (hVar != null) {
            try {
                d.this.dump(str3, null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e(str, str2, e2);
            }
        } else {
            try {
                a(str3, (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e(str, str2, e3);
            }
        }
        throw runtimeException;
    }

    public void b(Fragment fragment) {
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                synchronized (this.f5131f) {
                    this.f5131f.remove(fragment);
                }
                if (d(fragment)) {
                    this.t = true;
                }
                fragment.mAdded = false;
            }
        }
    }

    public boolean c() {
        e();
        k();
        c(true);
        Fragment fragment = this.s;
        if (fragment != null && fragment.getChildFragmentManager().c()) {
            return true;
        }
        boolean a2 = a(this.y, this.z, (String) null, -1, 0);
        if (a2) {
            this.f5129d = true;
            try {
                c(this.y, this.z);
            } finally {
                f();
            }
        }
        q();
        j();
        d();
        return a2;
    }

    public final void d() {
        this.f5132g.values().removeAll(Collections.singleton(null));
    }

    public boolean e(Fragment fragment) {
        boolean z2 = true;
        if (fragment == null) {
            return true;
        }
        j jVar = fragment.mFragmentManager;
        if (fragment != jVar.s || !e(jVar.r)) {
            z2 = false;
        }
        return z2;
    }

    public void f(Fragment fragment) {
        if (this.f5132g.get(fragment.mWho) == null) {
            this.f5132g.put(fragment.mWho, fragment);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (!fragment.mRetainInstance) {
                    j(fragment);
                } else if (!b()) {
                    this.E.f5173b.add(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
        }
    }

    public void g(Fragment fragment) {
        if (fragment != null && this.f5132g.containsKey(fragment.mWho)) {
            int i2 = this.o;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i2 = Math.min(i2, 1);
                } else {
                    i2 = Math.min(i2, 0);
                }
            }
            a(fragment, i2, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            View view = fragment.mView;
            if (view != null) {
                ViewGroup viewGroup = fragment.mContainer;
                Fragment fragment2 = null;
                if (viewGroup != null && view != null) {
                    int indexOf = this.f5131f.indexOf(fragment);
                    while (true) {
                        indexOf--;
                        if (indexOf < 0) {
                            break;
                        }
                        Fragment fragment3 = (Fragment) this.f5131f.get(indexOf);
                        if (fragment3.mContainer == viewGroup && fragment3.mView != null) {
                            fragment2 = fragment3;
                            break;
                        }
                    }
                }
                if (fragment2 != null) {
                    View view2 = fragment2.mView;
                    ViewGroup viewGroup2 = fragment.mContainer;
                    int indexOfChild = viewGroup2.indexOfChild(view2);
                    int indexOfChild2 = viewGroup2.indexOfChild(fragment.mView);
                    if (indexOfChild2 < indexOfChild) {
                        viewGroup2.removeViewAt(indexOfChild2);
                        viewGroup2.addView(fragment.mView, indexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    float f2 = fragment.mPostponedAlpha;
                    if (f2 > 0.0f) {
                        fragment.mView.setAlpha(f2);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    d a2 = a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (a2 != null) {
                        Animation animation = a2.f5139a;
                        if (animation != null) {
                            fragment.mView.startAnimation(animation);
                        } else {
                            a2.f5140b.setTarget(fragment.mView);
                            a2.f5140b.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                if (fragment.mView != null) {
                    d a3 = a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
                    if (a3 != null) {
                        Animator animator = a3.f5140b;
                        if (animator != null) {
                            animator.setTarget(fragment.mView);
                            if (!fragment.mHidden) {
                                fragment.mView.setVisibility(0);
                            } else if (fragment.isHideReplaced()) {
                                fragment.setHideReplaced(false);
                            } else {
                                ViewGroup viewGroup3 = fragment.mContainer;
                                View view3 = fragment.mView;
                                viewGroup3.startViewTransition(view3);
                                a3.f5140b.addListener(new m(this, viewGroup3, view3, fragment));
                            }
                            a3.f5140b.start();
                        }
                    }
                    if (a3 != null) {
                        fragment.mView.startAnimation(a3.f5139a);
                        a3.f5139a.start();
                    }
                    fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    }
                }
                if (fragment.mAdded && d(fragment)) {
                    this.t = true;
                }
                fragment.mHiddenChanged = false;
                fragment.onHiddenChanged(fragment.mHidden);
            }
        }
    }

    public void h(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f5129d) {
                this.x = true;
                return;
            }
            fragment.mDeferStart = false;
            a(fragment, this.o, 0, 0, false);
        }
    }

    public void i(Fragment fragment) {
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            synchronized (this.f5131f) {
                this.f5131f.remove(fragment);
            }
            if (d(fragment)) {
                this.t = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    public void j(Fragment fragment) {
        if (!b()) {
            boolean remove = this.E.f5173b.remove(fragment);
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean k() {
        c(true);
        boolean z2 = false;
        while (b(this.y, this.z)) {
            this.f5129d = true;
            try {
                c(this.y, this.z);
                f();
                z2 = true;
            } catch (Throwable th) {
                f();
                throw th;
            }
        }
        q();
        j();
        d();
        return z2;
    }

    public g l() {
        if (this.f5127a == null) {
            this.f5127a = i.f5126b;
        }
        if (this.f5127a == i.f5126b) {
            Fragment fragment = this.r;
            if (fragment != null) {
                return fragment.mFragmentManager.l();
            }
            this.f5127a = new c();
        }
        if (this.f5127a == null) {
            this.f5127a = i.f5126b;
        }
        return this.f5127a;
    }

    public void m() {
        this.u = false;
        this.v = false;
        int size = this.f5131f.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = (Fragment) this.f5131f.get(i2);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public Parcelable n() {
        b[] bVarArr;
        ArrayList<String> arrayList;
        if (this.D != null) {
            while (!this.D.isEmpty()) {
                ((C0050j) this.D.remove(0)).a();
            }
        }
        Iterator it = this.f5132g.values().iterator();
        while (true) {
            bVarArr = null;
            if (!it.hasNext()) {
                break;
            }
            Fragment fragment = (Fragment) it.next();
            if (fragment != null) {
                if (fragment.getAnimatingAway() != null) {
                    int stateAfterAnimating = fragment.getStateAfterAnimating();
                    View animatingAway = fragment.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    fragment.setAnimatingAway(null);
                    a(fragment, stateAfterAnimating, 0, 0, false);
                } else if (fragment.getAnimator() != null) {
                    fragment.getAnimator().end();
                }
            }
        }
        k();
        this.u = true;
        if (this.f5132g.isEmpty()) {
            return null;
        }
        ArrayList<p> arrayList2 = new ArrayList<>(this.f5132g.size());
        Iterator it2 = this.f5132g.values().iterator();
        boolean z2 = false;
        while (true) {
            String str = " was removed from the FragmentManager";
            String str2 = "Failure saving state: active ";
            if (it2.hasNext()) {
                Fragment fragment2 = (Fragment) it2.next();
                if (fragment2 != null) {
                    if (fragment2.mFragmentManager == this) {
                        p pVar = new p(fragment2);
                        arrayList2.add(pVar);
                        if (fragment2.mState <= 0 || pVar.m != null) {
                            pVar.m = fragment2.mSavedFragmentState;
                        } else {
                            pVar.m = k(fragment2);
                            String str3 = fragment2.mTargetWho;
                            if (str3 != null) {
                                Fragment fragment3 = (Fragment) this.f5132g.get(str3);
                                if (fragment3 != null) {
                                    if (pVar.m == null) {
                                        pVar.m = new Bundle();
                                    }
                                    a(pVar.m, "android:target_state", fragment3);
                                    int i2 = fragment2.mTargetRequestCode;
                                    if (i2 != 0) {
                                        pVar.m.putInt("android:target_req_state", i2);
                                    }
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Failure saving state: ");
                                    sb.append(fragment2);
                                    sb.append(" has target not in fragment manager: ");
                                    sb.append(fragment2.mTargetWho);
                                    a((RuntimeException) new IllegalStateException(sb.toString()));
                                    throw null;
                                }
                            }
                        }
                        z2 = true;
                    } else {
                        a((RuntimeException) new IllegalStateException(e.a.a.a.a.a(str2, fragment2, str)));
                        throw null;
                    }
                }
            } else if (!z2) {
                return null;
            } else {
                int size = this.f5131f.size();
                if (size > 0) {
                    arrayList = new ArrayList<>(size);
                    Iterator it3 = this.f5131f.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment4 = (Fragment) it3.next();
                        arrayList.add(fragment4.mWho);
                        if (fragment4.mFragmentManager != this) {
                            a((RuntimeException) new IllegalStateException(e.a.a.a.a.a(str2, fragment4, str)));
                            throw null;
                        }
                    }
                } else {
                    arrayList = null;
                }
                ArrayList<a> arrayList3 = this.f5133h;
                if (arrayList3 != null) {
                    int size2 = arrayList3.size();
                    if (size2 > 0) {
                        bVarArr = new b[size2];
                        for (int i3 = 0; i3 < size2; i3++) {
                            bVarArr[i3] = new b((a) this.f5133h.get(i3));
                        }
                    }
                }
                n nVar = new n();
                nVar.f5167a = arrayList2;
                nVar.f5168b = arrayList;
                nVar.f5169c = bVarArr;
                Fragment fragment5 = this.s;
                if (fragment5 != null) {
                    nVar.f5170d = fragment5.mWho;
                }
                nVar.f5171e = this.f5130e;
                return nVar;
            }
        }
    }

    public void o() {
        synchronized (this) {
            boolean z2 = false;
            boolean z3 = this.D != null && !this.D.isEmpty();
            if (this.f5128c != null && this.f5128c.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.p.f5123c.removeCallbacks(this.F);
                this.p.f5123c.post(this.F);
                q();
            }
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue(null, "class");
        Context context2 = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, g.f5148a);
        int i2 = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str3 == null || !g.b(context.getClassLoader(), str3)) {
            return null;
        }
        if (view != null) {
            i2 = view.getId();
        }
        if (i2 == -1 && resourceId == -1 && string == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(attributeSet.getPositionDescription());
            sb.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            sb.append(str3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (resourceId != -1) {
            fragment = b(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = a(string);
        }
        if (fragment == null && i2 != -1) {
            fragment = b(i2);
        }
        if (fragment == null) {
            fragment = l().a(context.getClassLoader(), str3);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : i2;
            fragment.mContainerId = i2;
            fragment.mTag = string;
            fragment.mInLayout = true;
            fragment.mFragmentManager = this;
            h hVar = this.p;
            fragment.mHost = hVar;
            fragment.onInflate(hVar.f5122b, attributeSet2, fragment.mSavedFragmentState);
            a(fragment, true);
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            h hVar2 = this.p;
            fragment.mHost = hVar2;
            fragment.onInflate(hVar2.f5122b, attributeSet2, fragment.mSavedFragmentState);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(attributeSet.getPositionDescription());
            sb2.append(": Duplicate id 0x");
            sb2.append(Integer.toHexString(resourceId));
            sb2.append(", tag ");
            sb2.append(string);
            sb2.append(", or parent id 0x");
            sb2.append(Integer.toHexString(i2));
            sb2.append(" with another fragment for ");
            sb2.append(str3);
            throw new IllegalArgumentException(sb2.toString());
        }
        Fragment fragment2 = fragment;
        if (this.o >= 1 || !fragment2.mFromLayout) {
            a(fragment2, this.o, 0, 0, false);
        } else {
            a(fragment2, 1, 0, 0, false);
        }
        View view2 = fragment2.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment2.mView.getTag() == null) {
                fragment2.mView.setTag(string);
            }
            return fragment2.mView;
        }
        throw new IllegalStateException(e.a.a.a.a.a("Fragment ", str3, " did not create a view."));
    }

    public void p() {
        for (Fragment fragment : this.f5132g.values()) {
            if (fragment != null) {
                h(fragment);
            }
        }
    }

    public final void q() {
        ArrayList<h> arrayList = this.f5128c;
        boolean z2 = true;
        if (arrayList == null || arrayList.isEmpty()) {
            d.a.b bVar = this.k;
            ArrayList<a> arrayList2 = this.f5133h;
            if ((arrayList2 != null ? arrayList2.size() : 0) <= 0 || !e(this.r)) {
                z2 = false;
            }
            bVar.f3984a = z2;
            return;
        }
        this.k.f3984a = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.r;
        if (fragment != null) {
            a.a.a.a.b.a.a((Object) fragment, sb);
        } else {
            a.a.a.a.b.a.a((Object) this.p, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void d(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).d(fragment, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentPaused(this, fragment);
            }
        }
    }

    public void j() {
        if (this.x) {
            this.x = false;
            p();
        }
    }

    public final void e() {
        if (b()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public void h() {
        this.w = true;
        k();
        a(0);
        this.p = null;
        this.q = null;
        this.r = null;
        if (this.f5135j != null) {
            Iterator it = this.k.f3985b.iterator();
            while (it.hasNext()) {
                ((d.a.a) it.next()).cancel();
            }
            this.f5135j = null;
        }
    }

    public void m(Fragment fragment) {
        if (fragment == null || (this.f5132g.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this))) {
            Fragment fragment2 = this.s;
            this.s = fragment;
            c(fragment2);
            c(this.s);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(fragment);
        sb.append(" is not an active fragment of FragmentManager ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    public void e(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).e(fragment, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentResumed(this, fragment);
            }
        }
    }

    public final void f() {
        this.f5129d = false;
        this.z.clear();
        this.y.clear();
    }

    public Bundle k(Fragment fragment) {
        if (this.B == null) {
            this.B = new Bundle();
        }
        fragment.performSaveInstanceState(this.B);
        d(fragment, this.B, false);
        Bundle bundle = null;
        if (!this.B.isEmpty()) {
            Bundle bundle2 = this.B;
            this.B = null;
            bundle = bundle2;
        }
        if (fragment.mView != null) {
            l(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    public Fragment b(int i2) {
        for (int size = this.f5131f.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f5131f.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f5132g.values()) {
            if (fragment2 != null && fragment2.mFragmentId == i2) {
                return fragment2;
            }
        }
        return null;
    }

    public void d(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).d(fragment, bundle, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    public void i() {
        for (int i2 = 0; i2 < this.f5131f.size(); i2++) {
            Fragment fragment = (Fragment) this.f5131f.get(i2);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            a((RuntimeException) new IllegalStateException(e.a.a.a.a.a("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public void l(Fragment fragment) {
        if (fragment.mInnerView != null) {
            SparseArray<Parcelable> sparseArray = this.C;
            if (sparseArray == null) {
                this.C = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.C);
            if (this.C.size() > 0) {
                fragment.mSavedViewState = this.C;
                this.C = null;
            }
        }
    }

    public void f(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).f(fragment, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentStarted(this, fragment);
            }
        }
    }

    public Fragment a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = (Fragment) this.f5132g.get(string);
        if (fragment != null) {
            return fragment;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment no longer exists for key ");
        sb.append(str);
        sb.append(": unique id ");
        sb.append(string);
        a((RuntimeException) new IllegalStateException(sb.toString()));
        throw null;
    }

    public void c(int i2) {
        synchronized (this) {
            this.l.set(i2, null);
            if (this.m == null) {
                this.m = new ArrayList<>();
            }
            this.m.add(Integer.valueOf(i2));
        }
    }

    public Fragment b(String str) {
        for (Fragment fragment : this.f5132g.values()) {
            if (fragment != null) {
                Fragment findFragmentByWho = fragment.findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    return findFragmentByWho;
                }
            }
        }
        return null;
    }

    public void h(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).h(fragment, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    public List<Fragment> a() {
        List<Fragment> list;
        if (this.f5131f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f5131f) {
            list = (List) this.f5131f.clone();
        }
        return list;
    }

    public boolean b() {
        return this.u || this.v;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.util.ArrayList<d.n.a.a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<d.n.a.j$h> r0 = r4.f5128c     // Catch:{ all -> 0x003a }
            r1 = 0
            if (r0 == 0) goto L_0x0038
            java.util.ArrayList<d.n.a.j$h> r0 = r4.f5128c     // Catch:{ all -> 0x003a }
            int r0 = r0.size()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x000f
            goto L_0x0038
        L_0x000f:
            java.util.ArrayList<d.n.a.j$h> r0 = r4.f5128c     // Catch:{ all -> 0x003a }
            int r0 = r0.size()     // Catch:{ all -> 0x003a }
            r2 = r1
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<d.n.a.j$h> r3 = r4.f5128c     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003a }
            d.n.a.j$h r3 = (d.n.a.j.h) r3     // Catch:{ all -> 0x003a }
            boolean r3 = r3.a(r5, r6)     // Catch:{ all -> 0x003a }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<d.n.a.j$h> r5 = r4.f5128c     // Catch:{ all -> 0x003a }
            r5.clear()     // Catch:{ all -> 0x003a }
            d.n.a.h r5 = r4.p     // Catch:{ all -> 0x003a }
            android.os.Handler r5 = r5.f5123c     // Catch:{ all -> 0x003a }
            java.lang.Runnable r6 = r4.F     // Catch:{ all -> 0x003a }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003a }
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            return r2
        L_0x0038:
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            return r1
        L_0x003a:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n.a.j.b(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    public final boolean d(Fragment fragment) {
        boolean z2;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        j jVar = fragment.mChildFragmentManager;
        Iterator it = jVar.f5132g.values().iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z3 = jVar.d(fragment2);
                continue;
            }
            if (z3) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public final void c(boolean z2) {
        if (this.f5129d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.p == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.p.f5123c.getLooper()) {
            if (!z2) {
                e();
            }
            if (this.y == null) {
                this.y = new ArrayList<>();
                this.z = new ArrayList<>();
            }
            this.f5129d = true;
            try {
                a(null, null);
            } finally {
                this.f5129d = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String a2 = e.a.a.a.a.a(str, "    ");
        if (!this.f5132g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(Config.TRACE_TODAY_VISIT_SPLIT);
            for (Fragment fragment : this.f5132g.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(a2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size = this.f5131f.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment2 = (Fragment) this.f5131f.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f5134i;
        if (arrayList != null) {
            int size2 = arrayList.size();
            if (size2 > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (int i3 = 0; i3 < size2; i3++) {
                    Fragment fragment3 = (Fragment) this.f5134i.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(fragment3.toString());
                }
            }
        }
        ArrayList<a> arrayList2 = this.f5133h;
        if (arrayList2 != null) {
            int size3 = arrayList2.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (int i4 = 0; i4 < size3; i4++) {
                    a aVar = (a) this.f5133h.get(i4);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.a(a2, printWriter, true);
                }
            }
        }
        synchronized (this) {
            if (this.l != null) {
                int size4 = this.l.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (int i5 = 0; i5 < size4; i5++) {
                        a aVar2 = (a) this.l.get(i5);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i5);
                        printWriter.print(": ");
                        printWriter.println(aVar2);
                    }
                }
            }
            if (this.m != null && this.m.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.m.toArray()));
            }
        }
        ArrayList<h> arrayList3 = this.f5128c;
        if (arrayList3 != null) {
            int size5 = arrayList3.size();
            if (size5 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i6 = 0; i6 < size5; i6++) {
                    h hVar = (h) this.f5128c.get(i6);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i6);
                    printWriter.print(": ");
                    printWriter.println(hVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.p);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.q);
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.r);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.o);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.u);
        printWriter.print(" mStopped=");
        printWriter.print(this.v);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.w);
        if (this.t) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.t);
        }
    }

    public void b(boolean z2) {
        for (int size = this.f5131f.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f5131f.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public boolean b(Menu menu) {
        if (this.o < 1) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < this.f5131f.size(); i2++) {
            Fragment fragment = (Fragment) this.f5131f.get(i2);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean b(MenuItem menuItem) {
        if (this.o < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f5131f.size(); i2++) {
            Fragment fragment = (Fragment) this.f5131f.get(i2);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void c(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                if (!((a) arrayList.get(i2)).p) {
                    if (i3 != i2) {
                        a(arrayList, arrayList2, i3, i2);
                    }
                    i3 = i2 + 1;
                    if (((Boolean) arrayList2.get(i2)).booleanValue()) {
                        while (i3 < size && ((Boolean) arrayList2.get(i3)).booleanValue() && !((a) arrayList.get(i3)).p) {
                            i3++;
                        }
                    }
                    a(arrayList, arrayList2, i2, i3);
                    i2 = i3 - 1;
                }
                i2++;
            }
            if (i3 != size) {
                a(arrayList, arrayList2, i3, size);
            }
        }
    }

    public void b(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).b(fragment, context, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public void b(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).b(fragment, bundle, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    public final void c(Fragment fragment) {
        if (fragment != null && this.f5132g.get(fragment.mWho) == fragment) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).c(fragment, bundle, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    public void b(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).b(fragment, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentDestroyed(this, fragment);
            }
        }
    }

    public void g() {
        this.u = false;
        this.v = false;
        a(1);
    }

    public void c(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).c(fragment, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentDetached(this, fragment);
            }
        }
    }

    public void g(Fragment fragment, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).g(fragment, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentStopped(this, fragment);
            }
        }
    }

    public static d a(float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(H);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(I);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new d((Animation) animationSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A[SYNTHETIC, Splitter:B:28:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d.n.a.j.d a(androidx.fragment.app.Fragment r7, int r8, boolean r9, int r10) {
        /*
            r6 = this;
            int r0 = r7.getNextAnim()
            r1 = 0
            r7.setNextAnim(r1)
            android.view.ViewGroup r2 = r7.mContainer
            r3 = 0
            if (r2 == 0) goto L_0x0014
            android.animation.LayoutTransition r2 = r2.getLayoutTransition()
            if (r2 == 0) goto L_0x0014
            return r3
        L_0x0014:
            android.view.animation.Animation r2 = r7.onCreateAnimation(r8, r9, r0)
            if (r2 == 0) goto L_0x0020
            d.n.a.j$d r7 = new d.n.a.j$d
            r7.<init>(r2)
            return r7
        L_0x0020:
            android.animation.Animator r7 = r7.onCreateAnimator(r8, r9, r0)
            if (r7 == 0) goto L_0x002c
            d.n.a.j$d r8 = new d.n.a.j$d
            r8.<init>(r7)
            return r8
        L_0x002c:
            r7 = 1
            if (r0 == 0) goto L_0x007e
            d.n.a.h r2 = r6.p
            android.content.Context r2 = r2.f5122b
            android.content.res.Resources r2 = r2.getResources()
            java.lang.String r2 = r2.getResourceTypeName(r0)
            java.lang.String r4 = "anim"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0057
            d.n.a.h r4 = r6.p     // Catch:{ NotFoundException -> 0x0055, RuntimeException -> 0x0057 }
            android.content.Context r4 = r4.f5122b     // Catch:{ NotFoundException -> 0x0055, RuntimeException -> 0x0057 }
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r0)     // Catch:{ NotFoundException -> 0x0055, RuntimeException -> 0x0057 }
            if (r4 == 0) goto L_0x0053
            d.n.a.j$d r5 = new d.n.a.j$d     // Catch:{ NotFoundException -> 0x0055, RuntimeException -> 0x0057 }
            r5.<init>(r4)     // Catch:{ NotFoundException -> 0x0055, RuntimeException -> 0x0057 }
            return r5
        L_0x0053:
            r4 = r7
            goto L_0x0058
        L_0x0055:
            r7 = move-exception
            throw r7
        L_0x0057:
            r4 = r1
        L_0x0058:
            if (r4 != 0) goto L_0x007e
            d.n.a.h r4 = r6.p     // Catch:{ RuntimeException -> 0x006a }
            android.content.Context r4 = r4.f5122b     // Catch:{ RuntimeException -> 0x006a }
            android.animation.Animator r4 = android.animation.AnimatorInflater.loadAnimator(r4, r0)     // Catch:{ RuntimeException -> 0x006a }
            if (r4 == 0) goto L_0x007e
            d.n.a.j$d r5 = new d.n.a.j$d     // Catch:{ RuntimeException -> 0x006a }
            r5.<init>(r4)     // Catch:{ RuntimeException -> 0x006a }
            return r5
        L_0x006a:
            r4 = move-exception
            if (r2 != 0) goto L_0x007d
            d.n.a.h r2 = r6.p
            android.content.Context r2 = r2.f5122b
            android.view.animation.Animation r0 = android.view.animation.AnimationUtils.loadAnimation(r2, r0)
            if (r0 == 0) goto L_0x007e
            d.n.a.j$d r7 = new d.n.a.j$d
            r7.<init>(r0)
            return r7
        L_0x007d:
            throw r4
        L_0x007e:
            if (r8 != 0) goto L_0x0081
            return r3
        L_0x0081:
            r0 = 4097(0x1001, float:5.741E-42)
            if (r8 == r0) goto L_0x009b
            r0 = 4099(0x1003, float:5.744E-42)
            if (r8 == r0) goto L_0x0095
            r0 = 8194(0x2002, float:1.1482E-41)
            if (r8 == r0) goto L_0x008f
            r8 = -1
            goto L_0x00a0
        L_0x008f:
            if (r9 == 0) goto L_0x0093
            r8 = 3
            goto L_0x00a0
        L_0x0093:
            r8 = 4
            goto L_0x00a0
        L_0x0095:
            if (r9 == 0) goto L_0x0099
            r8 = 5
            goto L_0x00a0
        L_0x0099:
            r8 = 6
            goto L_0x00a0
        L_0x009b:
            if (r9 == 0) goto L_0x009f
            r8 = r7
            goto L_0x00a0
        L_0x009f:
            r8 = 2
        L_0x00a0:
            if (r8 >= 0) goto L_0x00a3
            return r3
        L_0x00a3:
            r4 = 220(0xdc, double:1.087E-321)
            r9 = 1064933786(0x3f79999a, float:0.975)
            r0 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            switch(r8) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00e6;
                case 3: goto L_0x00e1;
                case 4: goto L_0x00d9;
                case 5: goto L_0x00c6;
                case 6: goto L_0x00b3;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            if (r10 != 0) goto L_0x0112
            d.n.a.h r8 = r6.p
            goto L_0x00f2
        L_0x00b3:
            android.view.animation.AlphaAnimation r7 = new android.view.animation.AlphaAnimation
            r7.<init>(r2, r0)
            android.view.animation.Interpolator r8 = I
            r7.setInterpolator(r8)
            r7.setDuration(r4)
            d.n.a.j$d r8 = new d.n.a.j$d
            r8.<init>(r7)
            return r8
        L_0x00c6:
            android.view.animation.AlphaAnimation r7 = new android.view.animation.AlphaAnimation
            r7.<init>(r0, r2)
            android.view.animation.Interpolator r8 = I
            r7.setInterpolator(r8)
            r7.setDuration(r4)
            d.n.a.j$d r8 = new d.n.a.j$d
            r8.<init>(r7)
            return r8
        L_0x00d9:
            r7 = 1065982362(0x3f89999a, float:1.075)
            d.n.a.j$d r7 = a(r2, r7, r2, r0)
            return r7
        L_0x00e1:
            d.n.a.j$d r7 = a(r9, r2, r0, r2)
            return r7
        L_0x00e6:
            d.n.a.j$d r7 = a(r2, r9, r2, r0)
            return r7
        L_0x00eb:
            r7 = 1066401792(0x3f900000, float:1.125)
            d.n.a.j$d r7 = a(r7, r2, r0, r2)
            return r7
        L_0x00f2:
            d.n.a.d$a r8 = (d.n.a.d.a) r8
            d.n.a.d r8 = d.n.a.d.this
            android.view.Window r8 = r8.getWindow()
            if (r8 == 0) goto L_0x00fd
            r1 = r7
        L_0x00fd:
            if (r1 == 0) goto L_0x0112
            d.n.a.h r7 = r6.p
            d.n.a.d$a r7 = (d.n.a.d.a) r7
            d.n.a.d r7 = d.n.a.d.this
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L_0x010c
            goto L_0x0112
        L_0x010c:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
            int r7 = r7.windowAnimations
        L_0x0112:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n.a.j.a(androidx.fragment.app.Fragment, int, boolean, int):d.n.a.j$d");
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [int] */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r8v2 */
    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r10v1 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0084, code lost:
        if (r0 != 3) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00dc, code lost:
        if (r11 > 2) goto L_0x00e0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x04e0  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.fragment.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
            r16 = this;
            r6 = r16
            r7 = r17
            boolean r0 = r7.mAdded
            r8 = 1
            if (r0 == 0) goto L_0x0011
            boolean r0 = r7.mDetached
            if (r0 == 0) goto L_0x000e
            goto L_0x0011
        L_0x000e:
            r0 = r18
            goto L_0x0016
        L_0x0011:
            r0 = r18
            if (r0 <= r8) goto L_0x0016
            r0 = r8
        L_0x0016:
            boolean r1 = r7.mRemoving
            if (r1 == 0) goto L_0x002a
            int r1 = r7.mState
            if (r0 <= r1) goto L_0x002a
            if (r1 != 0) goto L_0x0028
            boolean r0 = r17.isInBackStack()
            if (r0 == 0) goto L_0x0028
            r0 = r8
            goto L_0x002a
        L_0x0028:
            int r0 = r7.mState
        L_0x002a:
            boolean r1 = r7.mDeferStart
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0037
            int r1 = r7.mState
            if (r1 >= r9) goto L_0x0037
            if (r0 <= r10) goto L_0x0037
            r0 = r10
        L_0x0037:
            d.p.e$b r1 = r7.mMaxState
            d.p.e$b r2 = d.p.e.b.CREATED
            if (r1 != r2) goto L_0x0042
            int r0 = java.lang.Math.min(r0, r8)
            goto L_0x004a
        L_0x0042:
            int r1 = r1.ordinal()
            int r0 = java.lang.Math.min(r0, r1)
        L_0x004a:
            r11 = r0
            int r0 = r7.mState
            java.lang.String r12 = "FragmentManager"
            r13 = 0
            r14 = 0
            if (r0 > r11) goto L_0x02c7
            boolean r0 = r7.mFromLayout
            if (r0 == 0) goto L_0x005c
            boolean r0 = r7.mInLayout
            if (r0 != 0) goto L_0x005c
            return
        L_0x005c:
            android.view.View r0 = r17.getAnimatingAway()
            if (r0 != 0) goto L_0x0068
            android.animation.Animator r0 = r17.getAnimator()
            if (r0 == 0) goto L_0x007c
        L_0x0068:
            r7.setAnimatingAway(r14)
            r7.setAnimator(r14)
            int r2 = r17.getStateAfterAnimating()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r16
            r1 = r17
            r0.a(r1, r2, r3, r4, r5)
        L_0x007c:
            int r0 = r7.mState
            if (r0 == 0) goto L_0x0088
            if (r0 == r8) goto L_0x01b2
            if (r0 == r10) goto L_0x02b0
            if (r0 == r9) goto L_0x02b9
            goto L_0x04db
        L_0x0088:
            if (r11 <= 0) goto L_0x01b2
            android.os.Bundle r0 = r7.mSavedFragmentState
            if (r0 == 0) goto L_0x00df
            d.n.a.h r1 = r6.p
            android.content.Context r1 = r1.f5122b
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.mSavedViewState = r0
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_state"
            androidx.fragment.app.Fragment r0 = r6.a(r0, r1)
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = r0.mWho
            goto L_0x00b1
        L_0x00b0:
            r0 = r14
        L_0x00b1:
            r7.mTargetWho = r0
            if (r0 == 0) goto L_0x00bf
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r13)
            r7.mTargetRequestCode = r0
        L_0x00bf:
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            if (r0 == 0) goto L_0x00cc
            boolean r0 = r0.booleanValue()
            r7.mUserVisibleHint = r0
            r7.mSavedUserVisibleHint = r14
            goto L_0x00d6
        L_0x00cc:
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.mUserVisibleHint = r0
        L_0x00d6:
            boolean r0 = r7.mUserVisibleHint
            if (r0 != 0) goto L_0x00df
            r7.mDeferStart = r8
            if (r11 <= r10) goto L_0x00df
            goto L_0x00e0
        L_0x00df:
            r10 = r11
        L_0x00e0:
            d.n.a.h r0 = r6.p
            r7.mHost = r0
            androidx.fragment.app.Fragment r1 = r6.r
            r7.mParentFragment = r1
            if (r1 == 0) goto L_0x00ed
            d.n.a.j r0 = r1.mChildFragmentManager
            goto L_0x00ef
        L_0x00ed:
            d.n.a.j r0 = r0.f5125e
        L_0x00ef:
            r7.mFragmentManager = r0
            androidx.fragment.app.Fragment r0 = r7.mTarget
            java.lang.String r9 = " that does not belong to this FragmentManager!"
            java.lang.String r11 = " declared target fragment "
            java.lang.String r15 = "Fragment "
            if (r0 == 0) goto L_0x013d
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r1 = r6.f5132g
            java.lang.String r0 = r0.mWho
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.Fragment r1 = r7.mTarget
            if (r0 != r1) goto L_0x011d
            int r0 = r1.mState
            if (r0 >= r8) goto L_0x0114
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r16
            r0.a(r1, r2, r3, r4, r5)
        L_0x0114:
            androidx.fragment.app.Fragment r0 = r7.mTarget
            java.lang.String r0 = r0.mWho
            r7.mTargetWho = r0
            r7.mTarget = r14
            goto L_0x013d
        L_0x011d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            r1.append(r11)
            androidx.fragment.app.Fragment r2 = r7.mTarget
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x013d:
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x0174
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r1 = r6.f5132g
            java.lang.Object r0 = r1.get(r0)
            r1 = r0
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            if (r1 == 0) goto L_0x015a
            int r0 = r1.mState
            if (r0 >= r8) goto L_0x0174
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r16
            r0.a(r1, r2, r3, r4, r5)
            goto L_0x0174
        L_0x015a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r15)
            r1.append(r7)
            r1.append(r11)
            java.lang.String r2 = r7.mTargetWho
            java.lang.String r1 = e.a.a.a.a.a(r1, r2, r9)
            r0.<init>(r1)
            throw r0
        L_0x0174:
            d.n.a.h r0 = r6.p
            android.content.Context r0 = r0.f5122b
            r6.b(r7, r0, r13)
            r17.performAttach()
            androidx.fragment.app.Fragment r0 = r7.mParentFragment
            if (r0 != 0) goto L_0x018c
            d.n.a.h r0 = r6.p
            d.n.a.d$a r0 = (d.n.a.d.a) r0
            d.n.a.d r0 = d.n.a.d.this
            if (r0 == 0) goto L_0x018b
            goto L_0x018f
        L_0x018b:
            throw r14
        L_0x018c:
            r0.onAttachFragment(r7)
        L_0x018f:
            d.n.a.h r0 = r6.p
            android.content.Context r0 = r0.f5122b
            r6.a(r7, r0, r13)
            boolean r0 = r7.mIsCreated
            if (r0 != 0) goto L_0x01aa
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.c(r7, r0, r13)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.performCreate(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.b(r7, r0, r13)
            goto L_0x01b1
        L_0x01aa:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.restoreChildFragmentState(r0)
            r7.mState = r8
        L_0x01b1:
            r11 = r10
        L_0x01b2:
            r0 = 8
            if (r11 <= 0) goto L_0x01ec
            boolean r1 = r7.mFromLayout
            if (r1 == 0) goto L_0x01ec
            boolean r1 = r7.mPerformedCreateView
            if (r1 != 0) goto L_0x01ec
            android.os.Bundle r1 = r7.mSavedFragmentState
            android.view.LayoutInflater r1 = r7.performGetLayoutInflater(r1)
            android.os.Bundle r2 = r7.mSavedFragmentState
            r7.performCreateView(r1, r14, r2)
            android.view.View r1 = r7.mView
            if (r1 == 0) goto L_0x01ea
            r7.mInnerView = r1
            r1.setSaveFromParentEnabled(r13)
            boolean r1 = r7.mHidden
            if (r1 == 0) goto L_0x01db
            android.view.View r1 = r7.mView
            r1.setVisibility(r0)
        L_0x01db:
            android.view.View r1 = r7.mView
            android.os.Bundle r2 = r7.mSavedFragmentState
            r7.onViewCreated(r1, r2)
            android.view.View r1 = r7.mView
            android.os.Bundle r2 = r7.mSavedFragmentState
            r6.a(r7, r1, r2, r13)
            goto L_0x01ec
        L_0x01ea:
            r7.mInnerView = r14
        L_0x01ec:
            if (r11 <= r8) goto L_0x02af
            boolean r1 = r7.mFromLayout
            if (r1 != 0) goto L_0x029a
            int r1 = r7.mContainerId
            if (r1 == 0) goto L_0x0252
            r2 = -1
            if (r1 == r2) goto L_0x0241
            d.n.a.e r2 = r6.q
            android.view.View r1 = r2.a(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            if (r1 != 0) goto L_0x0253
            boolean r2 = r7.mRestored
            if (r2 == 0) goto L_0x0208
            goto L_0x0253
        L_0x0208:
            android.content.res.Resources r0 = r17.getResources()     // Catch:{ NotFoundException -> 0x0213 }
            int r1 = r7.mContainerId     // Catch:{ NotFoundException -> 0x0213 }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x0213 }
            goto L_0x0215
        L_0x0213:
            java.lang.String r0 = "unknown"
        L_0x0215:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "No view found for id 0x"
            java.lang.StringBuilder r2 = e.a.a.a.a.a(r2)
            int r3 = r7.mContainerId
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            r2.append(r7)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            r6.a(r1)
            throw r14
        L_0x0241:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Cannot create fragment "
            java.lang.String r2 = " for a container view with no id"
            java.lang.String r1 = e.a.a.a.a.a(r1, r7, r2)
            r0.<init>(r1)
            r6.a(r0)
            throw r14
        L_0x0252:
            r1 = r14
        L_0x0253:
            r7.mContainer = r1
            android.os.Bundle r2 = r7.mSavedFragmentState
            android.view.LayoutInflater r2 = r7.performGetLayoutInflater(r2)
            android.os.Bundle r3 = r7.mSavedFragmentState
            r7.performCreateView(r2, r1, r3)
            android.view.View r2 = r7.mView
            if (r2 == 0) goto L_0x0298
            r7.mInnerView = r2
            r2.setSaveFromParentEnabled(r13)
            if (r1 == 0) goto L_0x0270
            android.view.View r2 = r7.mView
            r1.addView(r2)
        L_0x0270:
            boolean r1 = r7.mHidden
            if (r1 == 0) goto L_0x0279
            android.view.View r1 = r7.mView
            r1.setVisibility(r0)
        L_0x0279:
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r7.onViewCreated(r0, r1)
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r6.a(r7, r0, r1, r13)
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0294
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x0294
            goto L_0x0295
        L_0x0294:
            r8 = r13
        L_0x0295:
            r7.mIsNewlyAdded = r8
            goto L_0x029a
        L_0x0298:
            r7.mInnerView = r14
        L_0x029a:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.performActivityCreated(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r6.a(r7, r0, r13)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x02ad
            android.os.Bundle r0 = r7.mSavedFragmentState
            r7.restoreViewState(r0)
        L_0x02ad:
            r7.mSavedFragmentState = r14
        L_0x02af:
            r10 = 2
        L_0x02b0:
            if (r11 <= r10) goto L_0x02b8
            r17.performStart()
            r6.f(r7, r13)
        L_0x02b8:
            r9 = 3
        L_0x02b9:
            if (r11 <= r9) goto L_0x04db
            r17.performResume()
            r6.e(r7, r13)
            r7.mSavedFragmentState = r14
            r7.mSavedViewState = r14
            goto L_0x04db
        L_0x02c7:
            if (r0 <= r11) goto L_0x04db
            if (r0 == r8) goto L_0x039e
            r1 = 2
            if (r0 == r1) goto L_0x02e8
            r1 = 3
            if (r0 == r1) goto L_0x02df
            r1 = 4
            if (r0 == r1) goto L_0x02d6
            goto L_0x04db
        L_0x02d6:
            if (r11 >= r1) goto L_0x02de
            r17.performPause()
            r6.d(r7, r13)
        L_0x02de:
            r1 = 3
        L_0x02df:
            if (r11 >= r1) goto L_0x02e7
            r17.performStop()
            r6.g(r7, r13)
        L_0x02e7:
            r1 = 2
        L_0x02e8:
            if (r11 >= r1) goto L_0x039e
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x0302
            d.n.a.h r0 = r6.p
            d.n.a.d$a r0 = (d.n.a.d.a) r0
            d.n.a.d r0 = d.n.a.d.this
            boolean r0 = r0.isFinishing()
            r0 = r0 ^ r8
            if (r0 == 0) goto L_0x0302
            android.util.SparseArray<android.os.Parcelable> r0 = r7.mSavedViewState
            if (r0 != 0) goto L_0x0302
            r16.l(r17)
        L_0x0302:
            r17.performDestroyView()
            r6.h(r7, r13)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x038f
            android.view.ViewGroup r1 = r7.mContainer
            if (r1 == 0) goto L_0x038f
            r1.endViewTransition(r0)
            android.view.View r0 = r7.mView
            r0.clearAnimation()
            androidx.fragment.app.Fragment r0 = r17.getParentFragment()
            if (r0 == 0) goto L_0x0326
            androidx.fragment.app.Fragment r0 = r17.getParentFragment()
            boolean r0 = r0.mRemoving
            if (r0 != 0) goto L_0x038f
        L_0x0326:
            int r0 = r6.o
            r1 = 0
            if (r0 <= 0) goto L_0x0346
            boolean r0 = r6.w
            if (r0 != 0) goto L_0x0346
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0346
            float r0 = r7.mPostponedAlpha
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0346
            r0 = r19
            r2 = r20
            d.n.a.j$d r0 = r6.a(r7, r0, r13, r2)
            goto L_0x0347
        L_0x0346:
            r0 = r14
        L_0x0347:
            r7.mPostponedAlpha = r1
            if (r0 == 0) goto L_0x0388
            android.view.View r1 = r7.mView
            android.view.ViewGroup r2 = r7.mContainer
            r2.startViewTransition(r1)
            r7.setStateAfterAnimating(r11)
            android.view.animation.Animation r3 = r0.f5139a
            if (r3 == 0) goto L_0x0373
            d.n.a.j$e r3 = new d.n.a.j$e
            android.view.animation.Animation r0 = r0.f5139a
            r3.<init>(r0, r2, r1)
            android.view.View r0 = r7.mView
            r7.setAnimatingAway(r0)
            d.n.a.k r0 = new d.n.a.k
            r0.<init>(r6, r2, r7)
            r3.setAnimationListener(r0)
            android.view.View r0 = r7.mView
            r0.startAnimation(r3)
            goto L_0x0388
        L_0x0373:
            android.animation.Animator r0 = r0.f5140b
            r7.setAnimator(r0)
            d.n.a.l r3 = new d.n.a.l
            r3.<init>(r6, r2, r1, r7)
            r0.addListener(r3)
            android.view.View r1 = r7.mView
            r0.setTarget(r1)
            r0.start()
        L_0x0388:
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.removeView(r1)
        L_0x038f:
            r7.mContainer = r14
            r7.mView = r14
            r7.mViewLifecycleOwner = r14
            d.p.m<d.p.h> r0 = r7.mViewLifecycleOwnerLiveData
            r0.a(r14)
            r7.mInnerView = r14
            r7.mInLayout = r13
        L_0x039e:
            if (r11 >= r8) goto L_0x04db
            boolean r0 = r6.w
            if (r0 == 0) goto L_0x03c5
            android.view.View r0 = r17.getAnimatingAway()
            if (r0 == 0) goto L_0x03b5
            android.view.View r0 = r17.getAnimatingAway()
            r7.setAnimatingAway(r14)
            r0.clearAnimation()
            goto L_0x03c5
        L_0x03b5:
            android.animation.Animator r0 = r17.getAnimator()
            if (r0 == 0) goto L_0x03c5
            android.animation.Animator r0 = r17.getAnimator()
            r7.setAnimator(r14)
            r0.cancel()
        L_0x03c5:
            android.view.View r0 = r17.getAnimatingAway()
            if (r0 != 0) goto L_0x04d7
            android.animation.Animator r0 = r17.getAnimator()
            if (r0 == 0) goto L_0x03d3
            goto L_0x04d7
        L_0x03d3:
            boolean r0 = r7.mRemoving
            if (r0 == 0) goto L_0x03df
            boolean r0 = r17.isInBackStack()
            if (r0 != 0) goto L_0x03df
            r0 = r8
            goto L_0x03e0
        L_0x03df:
            r0 = r13
        L_0x03e0:
            if (r0 != 0) goto L_0x03ee
            d.n.a.o r1 = r6.E
            boolean r1 = r1.a(r7)
            if (r1 == 0) goto L_0x03eb
            goto L_0x03ee
        L_0x03eb:
            r7.mState = r13
            goto L_0x0458
        L_0x03ee:
            d.n.a.h r1 = r6.p
            boolean r2 = r1 instanceof d.p.u
            if (r2 == 0) goto L_0x03f9
            d.n.a.o r1 = r6.E
            boolean r8 = r1.f5177f
            goto L_0x0406
        L_0x03f9:
            android.content.Context r1 = r1.f5122b
            boolean r2 = r1 instanceof android.app.Activity
            if (r2 == 0) goto L_0x0406
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r1 = r1.isChangingConfigurations()
            r8 = r8 ^ r1
        L_0x0406:
            if (r0 != 0) goto L_0x040a
            if (r8 == 0) goto L_0x0452
        L_0x040a:
            d.n.a.o r1 = r6.E
            if (r1 == 0) goto L_0x04d6
            boolean r2 = G
            if (r2 == 0) goto L_0x0426
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Clearing non-config state for "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r12, r2)
        L_0x0426:
            java.util.HashMap<java.lang.String, d.n.a.o> r2 = r1.f5174c
            java.lang.String r3 = r7.mWho
            java.lang.Object r2 = r2.get(r3)
            d.n.a.o r2 = (d.n.a.o) r2
            if (r2 == 0) goto L_0x043c
            r2.b()
            java.util.HashMap<java.lang.String, d.n.a.o> r2 = r1.f5174c
            java.lang.String r3 = r7.mWho
            r2.remove(r3)
        L_0x043c:
            java.util.HashMap<java.lang.String, d.p.t> r2 = r1.f5175d
            java.lang.String r3 = r7.mWho
            java.lang.Object r2 = r2.get(r3)
            d.p.t r2 = (d.p.t) r2
            if (r2 == 0) goto L_0x0452
            r2.a()
            java.util.HashMap<java.lang.String, d.p.t> r1 = r1.f5175d
            java.lang.String r2 = r7.mWho
            r1.remove(r2)
        L_0x0452:
            r17.performDestroy()
            r6.b(r7, r13)
        L_0x0458:
            r17.performDetach()
            r6.c(r7, r13)
            if (r21 != 0) goto L_0x04db
            if (r0 != 0) goto L_0x0488
            d.n.a.o r0 = r6.E
            boolean r0 = r0.a(r7)
            if (r0 == 0) goto L_0x046b
            goto L_0x0488
        L_0x046b:
            r7.mHost = r14
            r7.mParentFragment = r14
            r7.mFragmentManager = r14
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x04db
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r1 = r6.f5132g
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            if (r0 == 0) goto L_0x04db
            boolean r1 = r0.getRetainInstance()
            if (r1 == 0) goto L_0x04db
            r7.mTarget = r0
            goto L_0x04db
        L_0x0488:
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r0 = r6.f5132g
            java.lang.String r1 = r7.mWho
            java.lang.Object r0 = r0.get(r1)
            if (r0 != 0) goto L_0x0493
            goto L_0x04db
        L_0x0493:
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r0 = r6.f5132g
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x049d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x04ba
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            if (r1 == 0) goto L_0x049d
            java.lang.String r2 = r7.mWho
            java.lang.String r3 = r1.mTargetWho
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x049d
            r1.mTarget = r7
            r1.mTargetWho = r14
            goto L_0x049d
        L_0x04ba:
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r0 = r6.f5132g
            java.lang.String r1 = r7.mWho
            r0.put(r1, r14)
            r16.j(r17)
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x04d2
            java.util.HashMap<java.lang.String, androidx.fragment.app.Fragment> r1 = r6.f5132g
            java.lang.Object r0 = r1.get(r0)
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            r7.mTarget = r0
        L_0x04d2:
            r17.initState()
            goto L_0x04db
        L_0x04d6:
            throw r14
        L_0x04d7:
            r7.setStateAfterAnimating(r11)
            goto L_0x04dc
        L_0x04db:
            r8 = r11
        L_0x04dc:
            int r0 = r7.mState
            if (r0 == r8) goto L_0x0508
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r7.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r12, r0)
            r7.mState = r8
        L_0x0508:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n.a.j.a(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    public void a(int i2, boolean z2) {
        if (this.p == null && i2 != 0) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.o) {
            this.o = i2;
            int size = this.f5131f.size();
            for (int i3 = 0; i3 < size; i3++) {
                g((Fragment) this.f5131f.get(i3));
            }
            for (Fragment fragment : this.f5132g.values()) {
                if (fragment != null && ((fragment.mRemoving || fragment.mDetached) && !fragment.mIsNewlyAdded)) {
                    g(fragment);
                }
            }
            p();
            if (this.t) {
                h hVar = this.p;
                if (hVar != null && this.o == 4) {
                    d.this.c0();
                    this.t = false;
                }
            }
        }
    }

    public void a(Fragment fragment, boolean z2) {
        f(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.f5131f.contains(fragment)) {
            synchronized (this.f5131f) {
                this.f5131f.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (d(fragment)) {
                this.t = true;
            }
            if (z2) {
                a(fragment, this.o, 0, 0, false);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment already added: ");
        sb.append(fragment);
        throw new IllegalStateException(sb.toString());
    }

    public void a(Fragment fragment) {
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.f5131f.contains(fragment)) {
                synchronized (this.f5131f) {
                    this.f5131f.add(fragment);
                }
                fragment.mAdded = true;
                if (d(fragment)) {
                    this.t = true;
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment already added: ");
            sb.append(fragment);
            throw new IllegalStateException(sb.toString());
        }
    }

    public Fragment a(String str) {
        if (str != null) {
            for (int size = this.f5131f.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f5131f.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (Fragment fragment2 : this.f5132g.values()) {
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public void a(h hVar, boolean z2) {
        if (!z2) {
            e();
        }
        synchronized (this) {
            if (!this.w) {
                if (this.p != null) {
                    if (this.f5128c == null) {
                        this.f5128c = new ArrayList<>();
                    }
                    this.f5128c.add(hVar);
                    o();
                    return;
                }
            }
            if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public int a(a aVar) {
        synchronized (this) {
            if (this.m != null) {
                if (this.m.size() > 0) {
                    int intValue = ((Integer) this.m.remove(this.m.size() - 1)).intValue();
                    this.l.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.l == null) {
                this.l = new ArrayList<>();
            }
            int size = this.l.size();
            this.l.add(aVar);
            return size;
        }
    }

    public void a(int i2, a aVar) {
        synchronized (this) {
            if (this.l == null) {
                this.l = new ArrayList<>();
            }
            int size = this.l.size();
            if (i2 < size) {
                this.l.set(i2, aVar);
            } else {
                while (size < i2) {
                    this.l.add(null);
                    if (this.m == null) {
                        this.m = new ArrayList<>();
                    }
                    this.m.add(Integer.valueOf(size));
                    size++;
                }
                this.l.add(aVar);
            }
        }
    }

    public final void a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        ArrayList<C0050j> arrayList3 = this.D;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            C0050j jVar = (C0050j) this.D.get(i2);
            if (arrayList != null && !jVar.f5153a) {
                int indexOf = arrayList.indexOf(jVar.f5154b);
                if (indexOf != -1 && ((Boolean) arrayList2.get(indexOf)).booleanValue()) {
                    this.D.remove(i2);
                    i2--;
                    size--;
                    a aVar = jVar.f5154b;
                    aVar.r.a(aVar, jVar.f5153a, false, false);
                    i2++;
                }
            }
            if ((jVar.f5155c == 0) || (arrayList != null && jVar.f5154b.a(arrayList, 0, arrayList.size()))) {
                this.D.remove(i2);
                i2--;
                size--;
                if (arrayList != null && !jVar.f5153a) {
                    int indexOf2 = arrayList.indexOf(jVar.f5154b);
                    if (indexOf2 != -1 && ((Boolean) arrayList2.get(indexOf2)).booleanValue()) {
                        a aVar2 = jVar.f5154b;
                        aVar2.r.a(aVar2, jVar.f5153a, false, false);
                    }
                }
                jVar.a();
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<d.n.a.a> r20, java.util.ArrayList<java.lang.Boolean> r21, int r22, int r23) {
        /*
            r19 = this;
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            java.lang.Object r0 = r7.get(r9)
            d.n.a.a r0 = (d.n.a.a) r0
            boolean r11 = r0.p
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.A
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.A = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.A
            java.util.ArrayList<androidx.fragment.app.Fragment> r1 = r6.f5131f
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r6.s
            r1 = r9
            r2 = 0
        L_0x002c:
            r15 = 1
            if (r1 >= r10) goto L_0x016c
            java.lang.Object r3 = r7.get(r1)
            d.n.a.a r3 = (d.n.a.a) r3
            java.lang.Object r4 = r8.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r5 = 3
            if (r4 != 0) goto L_0x0121
            java.util.ArrayList<androidx.fragment.app.Fragment> r4 = r6.A
            r13 = 0
        L_0x0045:
            java.util.ArrayList<d.n.a.q$a> r12 = r3.f5189a
            int r12 = r12.size()
            if (r13 >= r12) goto L_0x015a
            java.util.ArrayList<d.n.a.q$a> r12 = r3.f5189a
            java.lang.Object r12 = r12.get(r13)
            d.n.a.q$a r12 = (d.n.a.q.a) r12
            int r14 = r12.f5199a
            if (r14 == r15) goto L_0x0112
            r15 = 2
            r9 = 9
            if (r14 == r15) goto L_0x0097
            if (r14 == r5) goto L_0x007f
            r15 = 6
            if (r14 == r15) goto L_0x007f
            r15 = 7
            if (r14 == r15) goto L_0x007c
            r15 = 8
            if (r14 == r15) goto L_0x006c
            goto L_0x0109
        L_0x006c:
            java.util.ArrayList<d.n.a.q$a> r14 = r3.f5189a
            d.n.a.q$a r15 = new d.n.a.q$a
            r15.<init>(r9, r0)
            r14.add(r13, r15)
            int r13 = r13 + 1
            androidx.fragment.app.Fragment r0 = r12.f5200b
            goto L_0x0109
        L_0x007c:
            r5 = 1
            goto L_0x0113
        L_0x007f:
            androidx.fragment.app.Fragment r14 = r12.f5200b
            r4.remove(r14)
            androidx.fragment.app.Fragment r12 = r12.f5200b
            if (r12 != r0) goto L_0x0109
            java.util.ArrayList<d.n.a.q$a> r0 = r3.f5189a
            d.n.a.q$a r14 = new d.n.a.q$a
            r14.<init>(r9, r12)
            r0.add(r13, r14)
            int r13 = r13 + 1
            r0 = 0
            goto L_0x0109
        L_0x0097:
            androidx.fragment.app.Fragment r14 = r12.f5200b
            int r15 = r14.mContainerId
            int r17 = r4.size()
            r16 = -1
            int r17 = r17 + -1
            r5 = r17
            r17 = 0
        L_0x00a7:
            if (r5 < 0) goto L_0x0100
            java.lang.Object r18 = r4.get(r5)
            r9 = r18
            androidx.fragment.app.Fragment r9 = (androidx.fragment.app.Fragment) r9
            int r8 = r9.mContainerId
            if (r8 != r15) goto L_0x00f5
            if (r9 != r14) goto L_0x00bc
            r18 = r15
            r17 = 1
            goto L_0x00f7
        L_0x00bc:
            if (r9 != r0) goto L_0x00d0
            java.util.ArrayList<d.n.a.q$a> r0 = r3.f5189a
            d.n.a.q$a r8 = new d.n.a.q$a
            r18 = r15
            r15 = 9
            r8.<init>(r15, r9)
            r0.add(r13, r8)
            int r13 = r13 + 1
            r0 = 0
            goto L_0x00d4
        L_0x00d0:
            r18 = r15
            r15 = 9
        L_0x00d4:
            d.n.a.q$a r8 = new d.n.a.q$a
            r15 = 3
            r8.<init>(r15, r9)
            int r15 = r12.f5201c
            r8.f5201c = r15
            int r15 = r12.f5203e
            r8.f5203e = r15
            int r15 = r12.f5202d
            r8.f5202d = r15
            int r15 = r12.f5204f
            r8.f5204f = r15
            java.util.ArrayList<d.n.a.q$a> r15 = r3.f5189a
            r15.add(r13, r8)
            r4.remove(r9)
            r8 = 1
            int r13 = r13 + r8
            goto L_0x00f7
        L_0x00f5:
            r18 = r15
        L_0x00f7:
            int r5 = r5 + -1
            r8 = r21
            r15 = r18
            r9 = 9
            goto L_0x00a7
        L_0x0100:
            if (r17 == 0) goto L_0x010b
            java.util.ArrayList<d.n.a.q$a> r5 = r3.f5189a
            r5.remove(r13)
            int r13 = r13 + -1
        L_0x0109:
            r5 = 1
            goto L_0x0118
        L_0x010b:
            r5 = 1
            r12.f5199a = r5
            r4.add(r14)
            goto L_0x0118
        L_0x0112:
            r5 = r15
        L_0x0113:
            androidx.fragment.app.Fragment r8 = r12.f5200b
            r4.add(r8)
        L_0x0118:
            int r13 = r13 + r5
            r8 = r21
            r9 = r22
            r15 = r5
            r5 = 3
            goto L_0x0045
        L_0x0121:
            r5 = r15
            java.util.ArrayList<androidx.fragment.app.Fragment> r4 = r6.A
            java.util.ArrayList<d.n.a.q$a> r8 = r3.f5189a
            int r8 = r8.size()
            int r8 = r8 - r5
        L_0x012b:
            if (r8 < 0) goto L_0x015a
            java.util.ArrayList<d.n.a.q$a> r9 = r3.f5189a
            java.lang.Object r9 = r9.get(r8)
            d.n.a.q$a r9 = (d.n.a.q.a) r9
            int r12 = r9.f5199a
            if (r12 == r5) goto L_0x0150
            r5 = 3
            if (r12 == r5) goto L_0x014a
            switch(r12) {
                case 6: goto L_0x014a;
                case 7: goto L_0x0151;
                case 8: goto L_0x0148;
                case 9: goto L_0x0145;
                case 10: goto L_0x0140;
                default: goto L_0x013f;
            }
        L_0x013f:
            goto L_0x0156
        L_0x0140:
            d.p.e$b r12 = r9.f5205g
            r9.f5206h = r12
            goto L_0x0156
        L_0x0145:
            androidx.fragment.app.Fragment r0 = r9.f5200b
            goto L_0x0156
        L_0x0148:
            r0 = 0
            goto L_0x0156
        L_0x014a:
            androidx.fragment.app.Fragment r9 = r9.f5200b
            r4.add(r9)
            goto L_0x0156
        L_0x0150:
            r5 = 3
        L_0x0151:
            androidx.fragment.app.Fragment r9 = r9.f5200b
            r4.remove(r9)
        L_0x0156:
            int r8 = r8 + -1
            r5 = 1
            goto L_0x012b
        L_0x015a:
            if (r2 != 0) goto L_0x0163
            boolean r2 = r3.f5196h
            if (r2 == 0) goto L_0x0161
            goto L_0x0163
        L_0x0161:
            r2 = 0
            goto L_0x0164
        L_0x0163:
            r2 = 1
        L_0x0164:
            int r1 = r1 + 1
            r8 = r21
            r9 = r22
            goto L_0x002c
        L_0x016c:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.A
            r0.clear()
            if (r11 != 0) goto L_0x0181
            r5 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            d.n.a.v.a(r0, r1, r2, r3, r4, r5)
        L_0x0181:
            r0 = r22
        L_0x0183:
            if (r0 >= r10) goto L_0x01b2
            java.lang.Object r1 = r7.get(r0)
            d.n.a.a r1 = (d.n.a.a) r1
            r8 = r21
            java.lang.Object r2 = r8.get(r0)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x01a8
            r2 = -1
            r1.a(r2)
            int r2 = r10 + -1
            if (r0 != r2) goto L_0x01a3
            r2 = 1
            goto L_0x01a4
        L_0x01a3:
            r2 = 0
        L_0x01a4:
            r1.b(r2)
            goto L_0x01af
        L_0x01a8:
            r2 = 1
            r1.a(r2)
            r1.c()
        L_0x01af:
            int r0 = r0 + 1
            goto L_0x0183
        L_0x01b2:
            r8 = r21
            if (r11 == 0) goto L_0x0276
            d.e.c r0 = new d.e.c
            r0.<init>()
            r6.a(r0)
            int r1 = r10 + -1
            r9 = r22
            r2 = r10
        L_0x01c3:
            if (r1 < r9) goto L_0x0253
            java.lang.Object r3 = r7.get(r1)
            d.n.a.a r3 = (d.n.a.a) r3
            java.lang.Object r4 = r8.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r5 = 0
        L_0x01d6:
            java.util.ArrayList<d.n.a.q$a> r12 = r3.f5189a
            int r12 = r12.size()
            if (r5 >= r12) goto L_0x01f1
            java.util.ArrayList<d.n.a.q$a> r12 = r3.f5189a
            java.lang.Object r12 = r12.get(r5)
            d.n.a.q$a r12 = (d.n.a.q.a) r12
            boolean r12 = d.n.a.a.b(r12)
            if (r12 == 0) goto L_0x01ee
            r5 = 1
            goto L_0x01f2
        L_0x01ee:
            int r5 = r5 + 1
            goto L_0x01d6
        L_0x01f1:
            r5 = 0
        L_0x01f2:
            if (r5 == 0) goto L_0x01fe
            int r5 = r1 + 1
            boolean r5 = r3.a(r7, r5, r10)
            if (r5 != 0) goto L_0x01fe
            r5 = 1
            goto L_0x01ff
        L_0x01fe:
            r5 = 0
        L_0x01ff:
            if (r5 == 0) goto L_0x024e
            java.util.ArrayList<d.n.a.j$j> r5 = r6.D
            if (r5 != 0) goto L_0x020c
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.D = r5
        L_0x020c:
            d.n.a.j$j r5 = new d.n.a.j$j
            r5.<init>(r3, r4)
            java.util.ArrayList<d.n.a.j$j> r12 = r6.D
            r12.add(r5)
            r12 = 0
        L_0x0217:
            java.util.ArrayList<d.n.a.q$a> r13 = r3.f5189a
            int r13 = r13.size()
            if (r12 >= r13) goto L_0x0235
            java.util.ArrayList<d.n.a.q$a> r13 = r3.f5189a
            java.lang.Object r13 = r13.get(r12)
            d.n.a.q$a r13 = (d.n.a.q.a) r13
            boolean r14 = d.n.a.a.b(r13)
            if (r14 == 0) goto L_0x0232
            androidx.fragment.app.Fragment r13 = r13.f5200b
            r13.setOnStartEnterTransitionListener(r5)
        L_0x0232:
            int r12 = r12 + 1
            goto L_0x0217
        L_0x0235:
            if (r4 == 0) goto L_0x023c
            r3.c()
            r12 = 0
            goto L_0x0240
        L_0x023c:
            r12 = 0
            r3.b(r12)
        L_0x0240:
            int r2 = r2 + -1
            if (r1 == r2) goto L_0x024a
            r7.remove(r1)
            r7.add(r2, r3)
        L_0x024a:
            r6.a(r0)
            goto L_0x024f
        L_0x024e:
            r12 = 0
        L_0x024f:
            int r1 = r1 + -1
            goto L_0x01c3
        L_0x0253:
            r12 = 0
            int r1 = r0.f4564c
            r3 = r12
        L_0x0257:
            if (r3 >= r1) goto L_0x0274
            java.lang.Object[] r4 = r0.f4563b
            r4 = r4[r3]
            androidx.fragment.app.Fragment r4 = (androidx.fragment.app.Fragment) r4
            boolean r5 = r4.mAdded
            if (r5 != 0) goto L_0x0271
            android.view.View r5 = r4.requireView()
            float r13 = r5.getAlpha()
            r4.mPostponedAlpha = r13
            r4 = 0
            r5.setAlpha(r4)
        L_0x0271:
            int r3 = r3 + 1
            goto L_0x0257
        L_0x0274:
            r4 = r2
            goto L_0x027a
        L_0x0276:
            r9 = r22
            r12 = 0
            r4 = r10
        L_0x027a:
            if (r4 == r9) goto L_0x0290
            if (r11 == 0) goto L_0x0290
            r5 = 1
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            d.n.a.v.a(r0, r1, r2, r3, r4, r5)
            int r0 = r6.o
            r1 = 1
            r6.a(r0, r1)
        L_0x0290:
            if (r9 >= r10) goto L_0x02d3
            java.lang.Object r0 = r7.get(r9)
            d.n.a.a r0 = (d.n.a.a) r0
            java.lang.Object r1 = r8.get(r9)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x02af
            int r1 = r0.t
            if (r1 < 0) goto L_0x02af
            r6.c(r1)
            r1 = -1
            r0.t = r1
            goto L_0x02b0
        L_0x02af:
            r1 = -1
        L_0x02b0:
            java.util.ArrayList<java.lang.Runnable> r2 = r0.q
            if (r2 == 0) goto L_0x02cf
            r2 = r12
        L_0x02b5:
            java.util.ArrayList<java.lang.Runnable> r3 = r0.q
            int r3 = r3.size()
            if (r2 >= r3) goto L_0x02cb
            java.util.ArrayList<java.lang.Runnable> r3 = r0.q
            java.lang.Object r3 = r3.get(r2)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r3.run()
            int r2 = r2 + 1
            goto L_0x02b5
        L_0x02cb:
            r2 = 0
            r0.q = r2
            goto L_0x02d0
        L_0x02cf:
            r2 = 0
        L_0x02d0:
            int r9 = r9 + 1
            goto L_0x0290
        L_0x02d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.n.a.j.a(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    public void a(a aVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            aVar.b(z4);
        } else {
            aVar.c();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3) {
            v.a(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z4) {
            a(this.o, true);
        }
        for (Fragment fragment : this.f5132g.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.b(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z4) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public final void a(d.e.c<Fragment> cVar) {
        int i2 = this.o;
        if (i2 >= 1) {
            int min = Math.min(i2, 3);
            int size = this.f5131f.size();
            for (int i3 = 0; i3 < size; i3++) {
                Fragment fragment = (Fragment) this.f5131f.get(i3);
                if (fragment.mState < min) {
                    a(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        cVar.add(fragment);
                    }
                }
            }
        }
    }

    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<a> arrayList3 = this.f5133h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f5133h.remove(size));
            arrayList2.add(Boolean.valueOf(true));
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = this.f5133h.size() - 1;
                while (size2 >= 0) {
                    a aVar = (a) this.f5133h.get(size2);
                    if ((str != null && str.equals(aVar.f5197i)) || (i2 >= 0 && i2 == aVar.t)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        a aVar2 = (a) this.f5133h.get(size2);
                        if ((str == null || !str.equals(aVar2.f5197i)) && (i2 < 0 || i2 != aVar2.t)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.f5133h.size() - 1) {
                return false;
            }
            for (int size3 = this.f5133h.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f5133h.remove(size3));
                arrayList2.add(Boolean.valueOf(true));
            }
        }
        return true;
    }

    public void a(Parcelable parcelable) {
        p pVar;
        if (parcelable != null) {
            n nVar = (n) parcelable;
            if (nVar.f5167a != null) {
                for (Fragment fragment : this.E.f5173b) {
                    Iterator it = nVar.f5167a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            pVar = null;
                            break;
                        }
                        pVar = (p) it.next();
                        if (pVar.f5180b.equals(fragment.mWho)) {
                            break;
                        }
                    }
                    if (pVar == null) {
                        Fragment fragment2 = fragment;
                        a(fragment2, 1, 0, 0, false);
                        fragment.mRemoving = true;
                        a(fragment2, 0, 0, 0, false);
                    } else {
                        pVar.n = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        Fragment fragment3 = fragment.mTarget;
                        fragment.mTargetWho = fragment3 != null ? fragment3.mWho : null;
                        fragment.mTarget = null;
                        Bundle bundle = pVar.m;
                        if (bundle != null) {
                            bundle.setClassLoader(this.p.f5122b.getClassLoader());
                            fragment.mSavedViewState = pVar.m.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = pVar.m;
                        }
                    }
                }
                this.f5132g.clear();
                Iterator it2 = nVar.f5167a.iterator();
                while (it2.hasNext()) {
                    p pVar2 = (p) it2.next();
                    if (pVar2 != null) {
                        ClassLoader classLoader = this.p.f5122b.getClassLoader();
                        g l2 = l();
                        if (pVar2.n == null) {
                            Bundle bundle2 = pVar2.f5188j;
                            if (bundle2 != null) {
                                bundle2.setClassLoader(classLoader);
                            }
                            Fragment a2 = l2.a(classLoader, pVar2.f5179a);
                            pVar2.n = a2;
                            a2.setArguments(pVar2.f5188j);
                            Bundle bundle3 = pVar2.m;
                            if (bundle3 != null) {
                                bundle3.setClassLoader(classLoader);
                                pVar2.n.mSavedFragmentState = pVar2.m;
                            } else {
                                pVar2.n.mSavedFragmentState = new Bundle();
                            }
                            Fragment fragment4 = pVar2.n;
                            fragment4.mWho = pVar2.f5180b;
                            fragment4.mFromLayout = pVar2.f5181c;
                            fragment4.mRestored = true;
                            fragment4.mFragmentId = pVar2.f5182d;
                            fragment4.mContainerId = pVar2.f5183e;
                            fragment4.mTag = pVar2.f5184f;
                            fragment4.mRetainInstance = pVar2.f5185g;
                            fragment4.mRemoving = pVar2.f5186h;
                            fragment4.mDetached = pVar2.f5187i;
                            fragment4.mHidden = pVar2.k;
                            fragment4.mMaxState = d.p.e.b.values()[pVar2.l];
                            if (G) {
                                StringBuilder a3 = e.a.a.a.a.a("Instantiated fragment ");
                                a3.append(pVar2.n);
                                Log.v("FragmentManager", a3.toString());
                            }
                        }
                        Fragment fragment5 = pVar2.n;
                        fragment5.mFragmentManager = this;
                        this.f5132g.put(fragment5.mWho, fragment5);
                        pVar2.n = null;
                    }
                }
                this.f5131f.clear();
                ArrayList<String> arrayList = nVar.f5168b;
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        String str = (String) it3.next();
                        Fragment fragment6 = (Fragment) this.f5132g.get(str);
                        if (fragment6 != null) {
                            fragment6.mAdded = true;
                            if (!this.f5131f.contains(fragment6)) {
                                synchronized (this.f5131f) {
                                    this.f5131f.add(fragment6);
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Already added ");
                                sb.append(fragment6);
                                throw new IllegalStateException(sb.toString());
                            }
                        } else {
                            a((RuntimeException) new IllegalStateException(e.a.a.a.a.a("No instantiated fragment for (", str, ")")));
                            throw null;
                        }
                    }
                }
                if (nVar.f5169c != null) {
                    this.f5133h = new ArrayList<>(nVar.f5169c.length);
                    int i2 = 0;
                    while (true) {
                        b[] bVarArr = nVar.f5169c;
                        if (i2 >= bVarArr.length) {
                            break;
                        }
                        b bVar = bVarArr[i2];
                        if (bVar != null) {
                            a aVar = new a(this);
                            int i3 = 0;
                            int i4 = 0;
                            while (i3 < bVar.f5091a.length) {
                                d.n.a.q.a aVar2 = new d.n.a.q.a();
                                int i5 = i3 + 1;
                                aVar2.f5199a = bVar.f5091a[i3];
                                if (G) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Instantiate ");
                                    sb2.append(aVar);
                                    sb2.append(" op #");
                                    sb2.append(i4);
                                    sb2.append(" base fragment #");
                                    sb2.append(bVar.f5091a[i5]);
                                    Log.v("FragmentManager", sb2.toString());
                                }
                                String str2 = (String) bVar.f5092b.get(i4);
                                if (str2 != null) {
                                    aVar2.f5200b = (Fragment) this.f5132g.get(str2);
                                } else {
                                    aVar2.f5200b = null;
                                }
                                aVar2.f5205g = d.p.e.b.values()[bVar.f5093c[i4]];
                                aVar2.f5206h = d.p.e.b.values()[bVar.f5094d[i4]];
                                int[] iArr = bVar.f5091a;
                                int i6 = i5 + 1;
                                int i7 = iArr[i5];
                                aVar2.f5201c = i7;
                                int i8 = i6 + 1;
                                int i9 = iArr[i6];
                                aVar2.f5202d = i9;
                                int i10 = i8 + 1;
                                int i11 = iArr[i8];
                                aVar2.f5203e = i11;
                                int i12 = i10 + 1;
                                int i13 = iArr[i10];
                                aVar2.f5204f = i13;
                                aVar.f5190b = i7;
                                aVar.f5191c = i9;
                                aVar.f5192d = i11;
                                aVar.f5193e = i13;
                                aVar.a(aVar2);
                                i4++;
                                i3 = i12;
                            }
                            aVar.f5194f = bVar.f5095e;
                            aVar.f5195g = bVar.f5096f;
                            aVar.f5197i = bVar.f5097g;
                            aVar.t = bVar.f5098h;
                            aVar.f5196h = true;
                            aVar.f5198j = bVar.f5099i;
                            aVar.k = bVar.f5100j;
                            aVar.l = bVar.k;
                            aVar.m = bVar.l;
                            aVar.n = bVar.m;
                            aVar.o = bVar.n;
                            aVar.p = bVar.o;
                            aVar.a(1);
                            this.f5133h.add(aVar);
                            int i14 = aVar.t;
                            if (i14 >= 0) {
                                a(i14, aVar);
                            }
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                } else {
                    this.f5133h = null;
                }
                String str3 = nVar.f5170d;
                if (str3 != null) {
                    Fragment fragment7 = (Fragment) this.f5132g.get(str3);
                    this.s = fragment7;
                    c(fragment7);
                }
                this.f5130e = nVar.f5171e;
            }
        }
    }

    public void a(h hVar, e eVar, Fragment fragment) {
        q qVar;
        if (this.p == null) {
            this.p = hVar;
            this.q = eVar;
            this.r = fragment;
            if (fragment != 0) {
                q();
            }
            if (hVar instanceof d.a.c) {
                d.a.c cVar = (d.a.c) hVar;
                this.f5135j = cVar.j();
                if (fragment != 0) {
                    cVar = fragment;
                }
                OnBackPressedDispatcher onBackPressedDispatcher = this.f5135j;
                d.a.b bVar = this.k;
                if (onBackPressedDispatcher != null) {
                    d.p.e lifecycle = cVar.getLifecycle();
                    if (((d.p.i) lifecycle).f5281b != d.p.e.b.DESTROYED) {
                        bVar.f3985b.add(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
                    }
                } else {
                    throw null;
                }
            }
            if (fragment != 0) {
                o oVar = fragment.mFragmentManager.E;
                o oVar2 = (o) oVar.f5174c.get(fragment.mWho);
                if (oVar2 == null) {
                    oVar2 = new o(oVar.f5176e);
                    oVar.f5174c.put(fragment.mWho, oVar2);
                }
                this.E = oVar2;
            } else if (hVar instanceof u) {
                t viewModelStore = ((u) hVar).getViewModelStore();
                r rVar = o.f5172h;
                Class<o> cls = o.class;
                String canonicalName = cls.getCanonicalName();
                if (canonicalName != null) {
                    String a2 = e.a.a.a.a.a("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    q qVar2 = (q) viewModelStore.f5293a.get(a2);
                    if (!cls.isInstance(qVar2)) {
                        if (rVar instanceof s) {
                            qVar = ((s) rVar).a(a2, cls);
                        } else {
                            qVar = rVar.a(cls);
                        }
                        qVar2 = qVar;
                        q qVar3 = (q) viewModelStore.f5293a.put(a2, qVar2);
                        if (qVar3 != null) {
                            qVar3.b();
                        }
                    }
                    this.E = (o) qVar2;
                    return;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            } else {
                this.E = new o(false);
            }
        } else {
            throw new IllegalStateException("Already attached");
        }
    }

    /* JADX INFO: finally extract failed */
    public final void a(int i2) {
        try {
            this.f5129d = true;
            a(i2, false);
            this.f5129d = false;
            k();
        } catch (Throwable th) {
            this.f5129d = false;
            throw th;
        }
    }

    public void a(boolean z2) {
        for (int size = this.f5131f.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f5131f.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    public void a(Configuration configuration) {
        for (int i2 = 0; i2 < this.f5131f.size(); i2++) {
            Fragment fragment = (Fragment) this.f5131f.get(i2);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.o < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < this.f5131f.size(); i2++) {
            Fragment fragment = (Fragment) this.f5131f.get(i2);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.f5134i != null) {
            for (int i3 = 0; i3 < this.f5134i.size(); i3++) {
                Fragment fragment2 = (Fragment) this.f5134i.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f5134i = arrayList;
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.o < 1) {
            return false;
        }
        for (int i2 = 0; i2 < this.f5131f.size(); i2++) {
            Fragment fragment = (Fragment) this.f5131f.get(i2);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void a(Menu menu) {
        if (this.o >= 1) {
            for (int i2 = 0; i2 < this.f5131f.size(); i2++) {
                Fragment fragment = (Fragment) this.f5131f.get(i2);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void a(Fragment fragment, d.p.e.b bVar) {
        if (this.f5132g.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = bVar;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(fragment);
        sb.append(" is not an active fragment of FragmentManager ");
        sb.append(this);
        throw new IllegalArgumentException(sb.toString());
    }

    public void a(d.n.a.i.a aVar) {
        synchronized (this.n) {
            int i2 = 0;
            int size = this.n.size();
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (((f) this.n.get(i2)).f5146a == aVar) {
                    this.n.remove(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
    }

    public void a(Fragment fragment, Context context, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).a(fragment, context, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentAttached(this, fragment, context);
            }
        }
    }

    public void a(Fragment fragment, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).a(fragment, bundle, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    public void a(Fragment fragment, View view, Bundle bundle, boolean z2) {
        Fragment fragment2 = this.r;
        if (fragment2 != null) {
            i fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof j) {
                ((j) fragmentManager).a(fragment, view, bundle, true);
            }
        }
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (!z2 || fVar.f5147b) {
                fVar.f5146a.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }
}
