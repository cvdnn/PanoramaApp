package e.c.d.m.b;

import com.baidu.picapture.model.spin.SpinTaskInfo;

/* compiled from: lambda */
public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ q0 f6414a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ SpinTaskInfo f6415b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ int f6416c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ int f6417d;

    public /* synthetic */ c0(q0 q0Var, SpinTaskInfo spinTaskInfo, int i2, int i3) {
        this.f6414a = q0Var;
        this.f6415b = spinTaskInfo;
        this.f6416c = i2;
        this.f6417d = i3;
    }

    public final void run() {
        this.f6414a.a(this.f6415b, this.f6416c, this.f6417d);
    }
}
