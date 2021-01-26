package e.c.d.d.c;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountManager.SilentShareListener;

/* compiled from: lambda */
public final /* synthetic */ class a implements SilentShareListener {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ a f6002a = new a();

    private /* synthetic */ a() {
    }

    public final void onSilentShare() {
        SapiAccountManager.unregisterSilentShareListener();
    }
}
