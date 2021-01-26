package e.c.d.j;

import com.baidu.picapture.model.spin.SpinTaskInfo;

/* compiled from: lambda */
public final /* synthetic */ class v0 implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ j1 f6317a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6318b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ SpinTaskInfo f6319c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ boolean f6320d;

    public /* synthetic */ v0(j1 j1Var, String str, SpinTaskInfo spinTaskInfo, boolean z) {
        this.f6317a = j1Var;
        this.f6318b = str;
        this.f6319c = spinTaskInfo;
        this.f6320d = z;
    }

    public final void run() {
        this.f6317a.a(this.f6318b, this.f6319c, this.f6320d);
    }
}
