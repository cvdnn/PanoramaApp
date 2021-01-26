package e.d.a;

import e.d.a.k;
import e.d.a.r.i.a;
import e.d.a.r.i.c;

/* compiled from: TransitionOptions */
public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    public c<? super TranscodeType> f7145a = a.f7895b;

    public final CHILD clone() {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: clone reason: collision with other method in class */
    public Object m78clone() throws CloneNotSupportedException {
        try {
            return (k) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }
}
