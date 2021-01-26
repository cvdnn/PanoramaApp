package e.c.d.k;

import android.content.Context;
import com.baidu.picapture.nativeapi.Permission;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;
import e.l.a.f;
import e.l.a.g;
import java.util.List;

/* compiled from: lambda */
public final /* synthetic */ class d implements f {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Permission f6341a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6342b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f6343c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ String f6344d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f6345e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ a f6346f;

    public /* synthetic */ d(Permission permission, String str, String str2, String str3, String str4, a aVar) {
        this.f6341a = permission;
        this.f6342b = str;
        this.f6343c = str2;
        this.f6344d = str3;
        this.f6345e = str4;
        this.f6346f = aVar;
    }

    public final void a(Context context, Object obj, g gVar) {
        this.f6341a.a(this.f6342b, this.f6343c, this.f6344d, this.f6345e, this.f6346f, context, (List) obj, gVar);
    }
}
