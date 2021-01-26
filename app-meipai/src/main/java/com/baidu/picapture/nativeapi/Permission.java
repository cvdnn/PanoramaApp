package com.baidu.picapture.nativeapi;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.model.nativeapi.PermissionRequest;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.baidu.picapture.ui.widget.dialog.ModelDialog.b;
import e.c.d.k.c;
import e.c.d.k.e;
import e.c.d.k.f;
import e.c.d.m.i.i.k;
import e.g.b.j;
import e.l.a.g;
import e.l.a.l.d;
import java.util.List;

public class Permission {

    /* renamed from: a reason: collision with root package name */
    public Context f1967a;

    public Permission(Context context) {
        this.f1967a = context;
    }

    public /* synthetic */ void a(String str, String str2, String str3, String str4, a aVar, Context context, List list, g gVar) {
        Context context2 = this.f1967a;
        b bVar = new b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        c cVar = new c(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = cVar;
        e eVar = new e(gVar, aVar);
        bVar.f2069c = str4;
        bVar.f2074h = eVar;
        ModelDialog modelDialog = new ModelDialog(context2, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    @JavascriptInterface
    public void hasPermissions(String str, a aVar) {
        String str2 = "0";
        try {
            List list = (List) new j().a(str, new e.g.b.d0.a<List<String>>(this) {
            }.getType());
            if (list != null) {
                if (!list.isEmpty()) {
                    if (e.l.a.b.f8923a.a(App.f1954b.getApplicationContext(), (String[]) list.toArray(new String[0]))) {
                        aVar.a("1");
                    } else {
                        aVar.a(str2);
                    }
                    return;
                }
            }
            aVar.a(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            aVar.a(str2);
        }
    }

    @JavascriptInterface
    public void requestPermissions(String str, a aVar) {
        String str2 = "0";
        try {
            PermissionRequest permissionRequest = (PermissionRequest) new j().a(str, PermissionRequest.class);
            if (permissionRequest.getPermissions() != null) {
                if (!permissionRequest.getPermissions().isEmpty()) {
                    if (e.l.a.b.f8923a.a(App.f1954b.getApplicationContext(), (String[]) permissionRequest.getPermissions().toArray(new String[0]))) {
                        aVar.a("1");
                        return;
                    }
                    String rationale = permissionRequest.getRationale();
                    if (TextUtils.isEmpty(rationale)) {
                        rationale = "请授予权限，方可进行后续操作。";
                    }
                    String str3 = rationale;
                    String string = this.f1967a.getResources().getString(R.string.reminder);
                    String string2 = this.f1967a.getResources().getString(R.string.allow);
                    String string3 = this.f1967a.getResources().getString(R.string.cancel);
                    e.l.a.l.c a2 = ((d) new e.l.a.c(e.l.a.b.a(this.f1967a)).a()).a((String[]) permissionRequest.getPermissions().toArray(new String[0]));
                    e.c.d.k.d dVar = new e.c.d.k.d(this, string, str3, string2, string3, aVar);
                    e.l.a.l.a aVar2 = (e.l.a.l.a) a2;
                    aVar2.f8964c = dVar;
                    aVar2.f8965d = new e.c.d.k.b(aVar);
                    aVar2.f8966e = new f(aVar);
                    aVar2.c();
                    return;
                }
            }
            aVar.a(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            aVar.a(str2);
        }
    }

    public static /* synthetic */ void a(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).a();
        kVar.dismiss();
    }

    public static /* synthetic */ void a(g gVar, a aVar, k kVar) {
        ((e.l.a.l.a) gVar).b();
        aVar.a("0");
        kVar.dismiss();
    }
}
