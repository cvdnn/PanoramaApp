package d.h.k;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* compiled from: NestedScrollingChildHelper */
public class g {

    /* renamed from: a reason: collision with root package name */
    public ViewParent f4917a;

    /* renamed from: b reason: collision with root package name */
    public ViewParent f4918b;

    /* renamed from: c reason: collision with root package name */
    public final View f4919c;

    /* renamed from: d reason: collision with root package name */
    public boolean f4920d;

    /* renamed from: e reason: collision with root package name */
    public int[] f4921e;

    public g(View view) {
        this.f4919c = view;
    }

    public boolean a(float f2, float f3, boolean z) {
        if (!this.f4920d) {
            return false;
        }
        ViewParent a2 = a(0);
        if (a2 == null) {
            return false;
        }
        try {
            return a2.onNestedFling(this.f4919c, f2, f3, z);
        } catch (AbstractMethodError e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(a2);
            sb.append(" does not implement interface method onNestedFling");
            Log.e("ViewParentCompat", sb.toString(), e2);
            return false;
        }
    }

    public boolean b(int i2) {
        return a(i2) != null;
    }

    public void c(int i2) {
        ViewParent a2 = a(i2);
        if (a2 != null) {
            View view = this.f4919c;
            if (a2 instanceof h) {
                ((h) a2).a(view, i2);
            } else if (i2 == 0) {
                try {
                    a2.onStopNestedScroll(view);
                } catch (AbstractMethodError e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ViewParent ");
                    sb.append(a2);
                    sb.append(" does not implement interface method onStopNestedScroll");
                    Log.e("ViewParentCompat", sb.toString(), e2);
                }
            }
            if (i2 == 0) {
                this.f4917a = null;
            } else if (i2 == 1) {
                this.f4918b = null;
            }
        }
    }

    public boolean a(float f2, float f3) {
        if (!this.f4920d) {
            return false;
        }
        ViewParent a2 = a(0);
        if (a2 == null) {
            return false;
        }
        try {
            return a2.onNestedPreFling(this.f4919c, f2, f3);
        } catch (AbstractMethodError e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("ViewParent ");
            sb.append(a2);
            sb.append(" does not implement interface method onNestedPreFling");
            Log.e("ViewParentCompat", sb.toString(), e2);
            return false;
        }
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        int i5;
        int i6;
        int[] iArr3;
        int i7 = i2;
        int i8 = i3;
        int[] iArr4 = iArr2;
        int i9 = i4;
        boolean z = false;
        if (this.f4920d) {
            ViewParent a2 = a(i9);
            if (a2 == null) {
                return false;
            }
            if (i7 != 0 || i8 != 0) {
                if (iArr4 != null) {
                    this.f4919c.getLocationInWindow(iArr4);
                    i6 = iArr4[0];
                    i5 = iArr4[1];
                } else {
                    i6 = 0;
                    i5 = 0;
                }
                if (iArr == null) {
                    if (this.f4921e == null) {
                        this.f4921e = new int[2];
                    }
                    iArr3 = this.f4921e;
                } else {
                    iArr3 = iArr;
                }
                iArr3[0] = 0;
                iArr3[1] = 0;
                View view = this.f4919c;
                if (a2 instanceof h) {
                    ((h) a2).a(view, i2, i3, iArr3, i4);
                } else if (i9 == 0) {
                    try {
                        a2.onNestedPreScroll(view, i2, i8, iArr3);
                    } catch (AbstractMethodError e2) {
                        AbstractMethodError abstractMethodError = e2;
                        StringBuilder sb = new StringBuilder();
                        sb.append("ViewParent ");
                        sb.append(a2);
                        sb.append(" does not implement interface method onNestedPreScroll");
                        Log.e("ViewParentCompat", sb.toString(), abstractMethodError);
                    }
                }
                if (iArr4 != null) {
                    this.f4919c.getLocationInWindow(iArr4);
                    iArr4[0] = iArr4[0] - i6;
                    iArr4[1] = iArr4[1] - i5;
                }
                if (!(iArr3[0] == 0 && iArr3[1] == 0)) {
                    z = true;
                }
            } else if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
        }
        return z;
    }

    public final boolean a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        int i7;
        int i8;
        int[] iArr3;
        int[] iArr4 = iArr;
        int i9 = i6;
        if (this.f4920d) {
            ViewParent a2 = a(i9);
            if (a2 == null) {
                return false;
            }
            if (i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
                if (iArr4 != null) {
                    this.f4919c.getLocationInWindow(iArr4);
                    i8 = iArr4[0];
                    i7 = iArr4[1];
                } else {
                    i8 = 0;
                    i7 = 0;
                }
                if (iArr2 == null) {
                    if (this.f4921e == null) {
                        this.f4921e = new int[2];
                    }
                    int[] iArr5 = this.f4921e;
                    iArr5[0] = 0;
                    iArr5[1] = 0;
                    iArr3 = iArr5;
                } else {
                    iArr3 = iArr2;
                }
                View view = this.f4919c;
                if (a2 instanceof i) {
                    ((i) a2).a(view, i2, i3, i4, i5, i6, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i4;
                    iArr3[1] = iArr3[1] + i5;
                    if (a2 instanceof h) {
                        ((h) a2).a(view, i2, i3, i4, i5, i6);
                    } else if (i9 == 0) {
                        try {
                            a2.onNestedScroll(view, i2, i3, i4, i5);
                        } catch (AbstractMethodError e2) {
                            AbstractMethodError abstractMethodError = e2;
                            StringBuilder sb = new StringBuilder();
                            sb.append("ViewParent ");
                            sb.append(a2);
                            sb.append(" does not implement interface method onNestedScroll");
                            Log.e("ViewParentCompat", sb.toString(), abstractMethodError);
                        }
                    }
                }
                if (iArr4 != null) {
                    this.f4919c.getLocationInWindow(iArr4);
                    iArr4[0] = iArr4[0] - i8;
                    iArr4[1] = iArr4[1] - i7;
                }
                return true;
            } else if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
        }
        return false;
    }

    public boolean a(int i2, int i3) {
        boolean z;
        if (a(i3) != null) {
            return true;
        }
        if (this.f4920d) {
            View view = this.f4919c;
            for (ViewParent parent = this.f4919c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.f4919c;
                boolean z2 = parent instanceof h;
                String str = "ViewParentCompat";
                String str2 = "ViewParent ";
                if (z2) {
                    z = ((h) parent).a(view, view2, i2, i3);
                } else {
                    if (i3 == 0) {
                        try {
                            z = parent.onStartNestedScroll(view, view2, i2);
                        } catch (AbstractMethodError e2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str2);
                            sb.append(parent);
                            sb.append(" does not implement interface method onStartNestedScroll");
                            Log.e(str, sb.toString(), e2);
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i3 == 0) {
                        this.f4917a = parent;
                    } else if (i3 == 1) {
                        this.f4918b = parent;
                    }
                    View view3 = this.f4919c;
                    if (z2) {
                        ((h) parent).b(view, view3, i2, i3);
                    } else if (i3 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i2);
                        } catch (AbstractMethodError e3) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str2);
                            sb2.append(parent);
                            sb2.append(" does not implement interface method onNestedScrollAccepted");
                            Log.e(str, sb2.toString(), e3);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr) {
        return a(i2, i3, i4, i5, iArr, 0, null);
    }

    public final ViewParent a(int i2) {
        if (i2 == 0) {
            return this.f4917a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f4918b;
    }
}
