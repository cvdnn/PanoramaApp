package d.n.a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionCompat21 */
public class w extends a0 {

    /* compiled from: FragmentTransitionCompat21 */
    public class a extends EpicenterCallback {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Rect f5242a;

        public a(w wVar, Rect rect) {
            this.f5242a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f5242a;
        }
    }

    /* compiled from: FragmentTransitionCompat21 */
    public class b implements TransitionListener {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ View f5243a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ ArrayList f5244b;

        public b(w wVar, View view, ArrayList arrayList) {
            this.f5243a = view;
            this.f5244b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f5243a.setVisibility(8);
            int size = this.f5244b.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((View) this.f5244b.get(i2)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    /* compiled from: FragmentTransitionCompat21 */
    public class c implements TransitionListener {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Object f5245a;

        /* renamed from: b reason: collision with root package name */
        public final /* synthetic */ ArrayList f5246b;

        /* renamed from: c reason: collision with root package name */
        public final /* synthetic */ Object f5247c;

        /* renamed from: d reason: collision with root package name */
        public final /* synthetic */ ArrayList f5248d;

        /* renamed from: e reason: collision with root package name */
        public final /* synthetic */ Object f5249e;

        /* renamed from: f reason: collision with root package name */
        public final /* synthetic */ ArrayList f5250f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f5245a = obj;
            this.f5246b = arrayList;
            this.f5247c = obj2;
            this.f5248d = arrayList2;
            this.f5249e = obj3;
            this.f5250f = arrayList3;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f5245a;
            if (obj != null) {
                w.this.a(obj, this.f5246b, null);
            }
            Object obj2 = this.f5247c;
            if (obj2 != null) {
                w.this.a(obj2, this.f5248d, null);
            }
            Object obj3 = this.f5249e;
            if (obj3 != null) {
                w.this.a(obj3, this.f5250f, null);
            }
        }
    }

    /* compiled from: FragmentTransitionCompat21 */
    public class d extends EpicenterCallback {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ Rect f5252a;

        public d(w wVar, Rect rect) {
            this.f5252a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f5252a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f5252a;
        }
    }

    public boolean a(Object obj) {
        return obj instanceof Transition;
    }

    public Object b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i2 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i2 < transitionCount) {
                    a((Object) transitionSet.getTransitionAt(i2), arrayList);
                    i2++;
                }
            } else if (!a(transition) && a0.a(transition.getTargets())) {
                int size = arrayList.size();
                while (i2 < size) {
                    transition.addTarget((View) arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public void b(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            a0.a(targets, (View) arrayList.get(i2));
        }
        targets.add(view);
        arrayList.add(view);
        a((Object) transitionSet, arrayList);
    }

    public void c(Object obj, View view) {
        if (view != null) {
            Transition transition = (Transition) obj;
            Rect rect = new Rect();
            a(view, rect);
            transition.setEpicenterCallback(new a(this, rect));
        }
    }

    public Object b(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public static boolean a(Transition transition) {
        return !a0.a(transition.getTargetIds()) || !a0.a(transition.getTargetNames()) || !a0.a(transition.getTargetTypes());
    }

    public void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            a((Object) transitionSet, arrayList, arrayList2);
        }
    }

    public void a(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(this, view, arrayList));
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public void b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public void a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        Transition transition = (Transition) obj;
        c cVar = new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3);
        transition.addListener(cVar);
    }

    public void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i2;
        Transition transition = (Transition) obj;
        int i3 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i3 < transitionCount) {
                a((Object) transitionSet.getTransitionAt(i3), arrayList, arrayList2);
                i3++;
            }
        } else if (!a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i2 = 0;
                } else {
                    i2 = arrayList2.size();
                }
                while (i3 < i2) {
                    transition.addTarget((View) arrayList2.get(i3));
                    i3++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.removeTarget((View) arrayList.get(size));
                }
            }
        }
    }

    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void a(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new d(this, rect));
        }
    }
}
