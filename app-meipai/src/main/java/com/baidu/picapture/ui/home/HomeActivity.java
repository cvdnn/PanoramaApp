package com.baidu.picapture.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.baidu.picapture.R;
import com.baidu.picapture.model.device.LanguageUtils;
import com.baidu.picapture.nativeapi.Account;
import com.baidu.picapture.nativeapi.Download;
import com.baidu.picapture.nativeapi.Permission;
import com.baidu.picapture.nativeapi.SphericalCameraApi;
import com.baidu.picapture.nativeapi.Task;
import com.baidu.picapture.nativeapi.Tools;
import com.baidu.picapture.ui.hotspot.capture.HotSpotCaptureActivity;
import com.baidu.picapture.ui.panorama.capture.PanoramaCaptureActivity;
import com.baidu.picapture.ui.panorama.guide.PanoramaGuideActivity;
import com.baidu.picapture.ui.panorama.simplepreview.PanoramaSimplePreviewActivity;
import com.baidu.picapture.ui.spin.capture.SpinCaptureActivity;
import com.baidu.picapture.ui.spin.device.SpinDeviceActivity;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge;
import com.baidu.picapture.ui.widget.dialog.AppForceUpdateDialog;
import com.baidu.picapture.ui.widget.dialog.AppUpdateDialog;
import com.baidu.picapture.ui.widget.dialog.ModelDialog;
import com.baidu.sapi2.SapiAccountManager;
import com.gyf.immersionbar.ImmersionBar;
import e.c.d.d.c.e;
import e.c.d.m.a.b;
import e.c.d.m.b.a0;
import e.c.d.m.b.f;
import e.c.d.m.b.h;
import e.c.d.m.b.i;
import e.c.d.m.b.j;
import e.c.d.m.b.l;
import e.c.d.m.b.m;
import e.c.d.m.b.n;
import e.c.d.m.b.n0;
import e.c.d.m.b.o;
import e.c.d.m.b.o0;
import e.c.d.m.b.p;
import e.c.d.m.b.p0;
import e.c.d.m.b.q;
import e.c.d.m.b.q0;
import e.c.d.m.b.r;
import e.c.d.m.b.s;
import e.c.d.m.b.t;
import e.c.d.m.b.u;
import e.c.d.m.b.v;
import e.c.d.m.b.w;
import e.c.d.m.b.x;
import e.c.d.m.b.y;
import e.c.d.m.b.z;
import e.c.d.m.i.i.k;
import e.l.a.g;
import e.l.a.l.c;
import e.l.a.l.d;
import java.io.File;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

public class HomeActivity extends b<o0, e.c.d.e.a> implements p0 {
    public boolean t = false;
    public ValueCallback<Uri[]> u;
    public int v = -1;

    public class a implements e.c.d.d.c.e.a {
        public a() {
        }
    }

    public static /* synthetic */ void f(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).a();
        kVar.dismiss();
    }

    public static /* synthetic */ void j(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).a();
        kVar.dismiss();
    }

    public void L() {
        a(PanoramaGuideActivity.class, null);
        overridePendingTransition(R.anim.activity_bottom_to_up_anim, R.anim.activity_silent_anim);
    }

    public /* synthetic */ void b(String str, String str2, String str3, String str4, Context context, List list, g gVar) {
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        z zVar = new z(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = zVar;
        e.c.d.m.b.g gVar2 = new e.c.d.m.b.g(this, gVar);
        bVar.f2069c = str4;
        bVar.f2074h = gVar2;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public /* synthetic */ void c(String str, String str2, String str3, String str4, Context context, List list, g gVar) {
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        e.c.d.m.b.b bVar2 = new e.c.d.m.b.b(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = bVar2;
        i iVar = new i(this, gVar);
        bVar.f2069c = str4;
        bVar.f2074h = iVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    @JavascriptInterface
    public void close() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(67108864);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    public /* synthetic */ void d(String str, String str2, String str3, String str4, Context context, List list, g gVar) {
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        q qVar = new q(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = qVar;
        r rVar = new r(this, gVar);
        bVar.f2069c = str4;
        bVar.f2074h = rVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public /* synthetic */ void e(String str, String str2, String str3, String str4, Context context, List list, g gVar) {
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        t tVar = new t(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = tVar;
        m mVar = new m(this, gVar);
        bVar.f2069c = str4;
        bVar.f2074h = mVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public d.w.a f0() {
        return e.c.d.e.a.a(getLayoutInflater());
    }

    public void g(int i2) {
        LocationManager locationManager = (LocationManager) getSystemService("location");
        boolean z = false;
        if (locationManager != null) {
            boolean isProviderEnabled = locationManager.isProviderEnabled(ExtraMetadataKey.kGps);
            boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
            if (isProviderEnabled || isProviderEnabled2) {
                z = true;
            }
        }
        if (!z) {
            this.v = i2;
            startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), com.baidu.sapi2.utils.i.f3087b);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("from", i2);
        String str = "android.permission.ACCESS_FINE_LOCATION";
        String str2 = "android.permission.ACCESS_COARSE_LOCATION";
        if (e.l.a.b.a((Activity) this, str2, str)) {
            a(SpinDeviceActivity.class, bundle);
        } else {
            String string = getString(R.string.reminder);
            String string2 = getString(R.string.ok);
            String string3 = getString(R.string.cancel);
            String string4 = getString(R.string.access_file_connect_box_tips);
            c a2 = ((d) ((e.l.a.c) e.l.a.b.a((Activity) this)).a()).a(str2, str, "android.permission.WRITE_EXTERNAL_STORAGE");
            h hVar = new h(this, string, string4, string2, string3);
            e.l.a.l.a aVar = (e.l.a.l.a) a2;
            aVar.f8964c = hVar;
            aVar.f8965d = new f(this, bundle);
            aVar.f8966e = new e.c.d.m.b.d(this);
            aVar.c();
        }
    }

    public void g0() {
        super.g0();
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((e.c.d.e.a) this.r).b(Boolean.valueOf(false));
        i.b.a.c.b().b(this);
        NativeBridge bridge = ((e.c.d.e.a) this.r).o.getBridge();
        String str = "Page";
        if (!bridge.f2017b.containsKey(str)) {
            bridge.f2017b.put(str, this);
        }
        ((e.c.d.e.a) this.r).o.getBridge().a((Object) new Account());
        ((e.c.d.e.a) this.r).o.getBridge().a((Object) new Tools(this));
        ((e.c.d.e.a) this.r).o.getBridge().a((Object) new Task());
        ((e.c.d.e.a) this.r).o.getBridge().a((Object) new Download(this));
        ((e.c.d.e.a) this.r).o.getBridge().a((Object) new Permission(this));
        ((e.c.d.e.a) this.r).o.getBridge().a((Object) new SphericalCameraApi());
        e.c.d.m.i.h.f fVar = new e.c.d.m.i.h.f();
        fVar.f6817a = new v(this);
        ((e.c.d.e.a) this.r).o.setWebChromeClient(fVar);
        ((e.c.d.e.a) this.r).o.setLifecycle(this.f652b);
    }

    @JavascriptInterface
    public void goTo(String str) {
        ((o0) this.s).a(str, null);
    }

    public void h(boolean z) {
        ((e.c.d.e.a) this.r).o.getBridge().a("Device.deviceConnect", z ? "1" : "0", null);
    }

    public e.c.d.m.a.d h0() {
        return new q0(this);
    }

    @i.b.a.m(threadMode = ThreadMode.MAIN)
    public void handleIPCEvent(e.c.d.d.b.c cVar) {
        if (cVar.f6000a.equalsIgnoreCase("ipc_new_pano_task")) {
            ((o0) this.s).c(cVar.f6001b);
        }
    }

    @i.b.a.m(threadMode = ThreadMode.MAIN)
    public void handleLogOutEvent(e.c.d.g.b bVar) {
        if (e.f6006d != null) {
            SapiAccountManager.getInstance().logout();
            this.t = false;
            ((o0) this.s).B();
            i0();
            return;
        }
        throw null;
    }

    @i.b.a.m(threadMode = ThreadMode.MAIN)
    public void handleSystemsLanguageChangeEvent(e.c.d.g.c cVar) {
        String str = "Tool.languageChange";
        ((e.c.d.e.a) this.r).o.getBridge().a(str, Tools.getLanguageJsonString(LanguageUtils.AUTO, cVar.f6097a), null);
    }

    @i.b.a.m(threadMode = ThreadMode.MAIN)
    public void handleWebPageNavigateEvent(e.c.d.g.d dVar) {
        ((e.c.d.e.a) this.r).o.getBridge().a("Page.navigate", dVar.f6098a, null);
    }

    public /* synthetic */ void i(List list) {
        a(PanoramaCaptureActivity.class, null);
    }

    public final void i0() {
        if (e.f6006d.c()) {
            k0();
            return;
        }
        e eVar = e.f6006d;
        eVar.f6007a.startLogin(getBaseContext(), new e.c.d.d.c.d(eVar, new a()), eVar.f6008b);
    }

    public final void j0() {
        ValueCallback<Uri[]> valueCallback = this.u;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.u = null;
        }
    }

    public /* synthetic */ void k(List list) {
        j0();
    }

    public final void k0() {
        if (!this.t) {
            this.t = true;
            CookieManager instance = CookieManager.getInstance();
            StringBuilder a2 = e.a.a.a.a.a("BDUSS=");
            a2.append(e.f6006d.a().bduss);
            instance.setCookie(".baidu.com", a2.toString());
            ((e.c.d.e.a) this.r).o.loadUrl("https://penglai.baidu.com/");
            ((e.c.d.e.a) this.r).o.loadUrl("javascript:window.location.reload(true)");
        }
    }

    public /* synthetic */ void l(List list) {
        a(SpinCaptureActivity.class, null);
        overridePendingTransition(R.anim.activity_bottom_to_up_anim, R.anim.activity_silent_anim);
    }

    public /* synthetic */ void m(List list) {
        j0();
    }

    public /* synthetic */ void n(List list) {
        j0();
    }

    public final void o(String str) {
        String str2 = "android.permission.READ_EXTERNAL_STORAGE";
        String str3 = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (e.l.a.b.a((Activity) this, str3, str2)) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            startActivityForResult(Intent.createChooser(intent, "Image Chooser"), 10001);
            return;
        }
        String string = getString(R.string.reminder);
        String string2 = getString(R.string.allow);
        String string3 = getString(R.string.cancel);
        String string4 = getString(R.string.access_file_upload_tips);
        c a2 = ((d) ((e.l.a.c) e.l.a.b.a((Activity) this)).a()).a(str3, str2);
        j jVar = new j(this, string, string4, string2, string3);
        e.l.a.l.a aVar = (e.l.a.l.a) a2;
        aVar.f8964c = jVar;
        aVar.f8965d = new l(this, str);
        aVar.f8966e = new x(this);
        aVar.c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 10000) {
                g(this.v);
            } else if (i2 == 10001) {
                ValueCallback<Uri[]> valueCallback = this.u;
                if (valueCallback != null) {
                    if (intent == null) {
                        valueCallback.onReceiveValue(null);
                    } else {
                        valueCallback.onReceiveValue(new Uri[]{intent.getData()});
                    }
                    this.u = null;
                }
            }
        } else if (i3 != 0) {
        } else {
            if (i2 == 10002) {
                g(this.v);
            } else if (i2 == 10001) {
                ValueCallback<Uri[]> valueCallback2 = this.u;
                if (valueCallback2 != null) {
                    valueCallback2.onReceiveValue(new Uri[0]);
                    this.u = null;
                }
            }
        }
    }

    public void onBackPressed() {
        ((e.c.d.e.a) this.r).o.getBridge().a("Page.backPressed", null, null);
    }

    public void onDestroy() {
        super.onDestroy();
        i.b.a.c.b().c(this);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int intExtra = intent.getIntExtra("from", -1);
        if (intExtra != -1 && intExtra == 4 && this.u != null) {
            String stringExtra = intent.getStringExtra("picture_path");
            if (TextUtils.isEmpty(stringExtra)) {
                this.u.onReceiveValue(null);
            } else {
                Uri fromFile = Uri.fromFile(new File(stringExtra));
                this.u.onReceiveValue(new Uri[]{fromFile});
            }
            this.u = null;
        }
    }

    public void onResume() {
        super.onResume();
        i0();
    }

    public void r() {
        ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor((int) R.color.white).init();
        ((e.c.d.e.a) this.r).b(Boolean.valueOf(false));
    }

    @JavascriptInterface
    public void setStatusBarColor(String str) {
        if (!TextUtils.isEmpty(str)) {
            ImmersionBar statusBarColor = ImmersionBar.with((Activity) this).statusBarDarkFont(true).statusBarColor(str);
            statusBarColor.getClass();
            runOnUiThread(new n0(statusBarColor));
        }
    }

    @JavascriptInterface
    public void webLoadComplete() {
        ((o0) this.s).p();
    }

    public /* synthetic */ boolean a(ValueCallback valueCallback, FileChooserParams fileChooserParams) {
        this.u = valueCallback;
        if (fileChooserParams.isCaptureEnabled()) {
            ((o0) this.s).m();
            return true;
        }
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        if (acceptTypes == null || acceptTypes.length <= 0) {
            o("image/*");
        } else {
            o(acceptTypes[0]);
        }
        return true;
    }

    @JavascriptInterface
    public void goTo(String str, com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a aVar) {
        ((o0) this.s).a(str, aVar);
    }

    public void m(String str) {
        new AppForceUpdateDialog(this, str).show();
    }

    public void n(String str) {
        ((e.c.d.e.a) this.r).b(Boolean.valueOf(true));
        ((e.c.d.e.a) this.r).n.setText(str);
        setStatusBarColor("#B3000000");
    }

    public static /* synthetic */ void i(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).a();
        kVar.dismiss();
    }

    public void h() {
        String str = "android.permission.READ_EXTERNAL_STORAGE";
        String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        if (e.l.a.b.a((Activity) this, str2, str)) {
            a(PanoramaCaptureActivity.class, null);
            return;
        }
        String string = getString(R.string.reminder);
        String string2 = getString(R.string.allow);
        String string3 = getString(R.string.cancel);
        String string4 = getString(R.string.access_file_taking_tips);
        c a2 = ((d) ((e.l.a.c) e.l.a.b.a((Activity) this)).a()).a(str2, str);
        p pVar = new p(this, string, string4, string2, string3);
        e.l.a.l.a aVar = (e.l.a.l.a) a2;
        aVar.f8964c = pVar;
        aVar.f8965d = new o(this);
        aVar.f8966e = new e.c.d.m.b.e(this);
        aVar.c();
    }

    public /* synthetic */ void j(List list) {
        j0();
    }

    public void j(String str) {
        String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        String str3 = "android.permission.CAMERA";
        if (e.l.a.b.a((Activity) this, str3, str2)) {
            Bundle bundle = new Bundle();
            bundle.putInt("from", 3);
            bundle.putString("picture_path", str);
            a(HotSpotCaptureActivity.class, bundle);
            return;
        }
        String string = getString(R.string.reminder);
        String string2 = getString(R.string.yes);
        String string3 = getString(R.string.no);
        String string4 = getString(R.string.access_cameras_tips);
        c a2 = ((d) ((e.l.a.c) e.l.a.b.a((Activity) this)).a()).a(str3, str2);
        n nVar = new n(this, string, string4, string2, string3);
        e.l.a.l.a aVar = (e.l.a.l.a) a2;
        aVar.f8964c = nVar;
        aVar.f8965d = new w(this, str);
        aVar.f8966e = new u(this);
        aVar.c();
    }

    public void l(String str) {
        ((e.c.d.e.a) this.r).o.getBridge().a("Task.progress", str, null);
    }

    @i.b.a.m(threadMode = ThreadMode.MAIN)
    public void handleSystemsLanguageChangeEvent(e.c.d.g.a aVar) {
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse(aVar.f6096a)));
    }

    public void l() {
        startActivity(new Intent("android.settings.WIFI_SETTINGS"));
    }

    public /* synthetic */ void a(String str, String str2, String str3, String str4, Context context, List list, g gVar) {
        ModelDialog.b bVar = new ModelDialog.b(null);
        bVar.f2067a = str;
        bVar.f2073g = false;
        bVar.f2068b = str2;
        a0 a0Var = new a0(gVar);
        bVar.f2071e = str3;
        bVar.f2075i = a0Var;
        s sVar = new s(this, gVar);
        bVar.f2069c = str4;
        bVar.f2074h = sVar;
        ModelDialog modelDialog = new ModelDialog(this, null);
        modelDialog.f2060a = bVar;
        modelDialog.show();
    }

    public /* synthetic */ void b(String str, List list) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        startActivityForResult(Intent.createChooser(intent, "Image Chooser"), 10001);
    }

    public /* synthetic */ void c(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).b();
        j0();
        kVar.dismiss();
    }

    public /* synthetic */ void d(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).b();
        ((o0) this.s).t();
        j0();
        kVar.dismiss();
    }

    public /* synthetic */ void e(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).b();
        j0();
        kVar.dismiss();
    }

    public void b() {
        String str = "android.permission.READ_EXTERNAL_STORAGE";
        String str2 = "android.permission.WRITE_EXTERNAL_STORAGE";
        String str3 = "android.permission.CAMERA";
        if (e.l.a.b.a((Activity) this, str3, str2, str)) {
            a(SpinCaptureActivity.class, null);
            overridePendingTransition(R.anim.activity_bottom_to_up_anim, R.anim.activity_silent_anim);
            return;
        }
        String string = getString(R.string.reminder);
        String string2 = getString(R.string.yes);
        String string3 = getString(R.string.no);
        String string4 = getString(R.string.access_cameras_tips);
        c a2 = ((d) ((e.l.a.c) e.l.a.b.a((Activity) this)).a()).a(str3, str2, str);
        e.c.d.m.b.c cVar = new e.c.d.m.b.c(this, string, string4, string2, string3);
        e.l.a.l.a aVar = (e.l.a.l.a) a2;
        aVar.f8964c = cVar;
        aVar.f8965d = new y(this);
        aVar.f8966e = new e.c.d.m.b.k(this);
        aVar.c();
    }

    public void e(String str) {
        ((e.c.d.e.a) this.r).o.getBridge().a("Network.bindChange", str, null);
    }

    public static /* synthetic */ void h(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).a();
        kVar.dismiss();
    }

    public void e(boolean z) {
        String str = "SphericalCameraApi.wifiConnectChange";
        if (z) {
            ((e.c.d.e.a) this.r).o.getBridge().a(str, "1", null);
        } else {
            ((e.c.d.e.a) this.r).o.getBridge().a(str, "0", null);
        }
    }

    public /* synthetic */ void a(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).b();
        j0();
        kVar.dismiss();
    }

    public /* synthetic */ void h(List list) {
        j0();
    }

    public void h(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("task_id", str);
        a(PanoramaSimplePreviewActivity.class, bundle);
    }

    public void e(String str, String str2) {
        new AppUpdateDialog(this, str, str2).show();
    }

    public static /* synthetic */ void g(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).a();
        kVar.dismiss();
    }

    public /* synthetic */ void a(Bundle bundle, List list) {
        a(SpinDeviceActivity.class, bundle);
    }

    public /* synthetic */ void a(String str, List list) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", 3);
        bundle.putString("picture_path", str);
        a(HotSpotCaptureActivity.class, bundle);
    }

    public void g() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), d.r.d.o.TARGET_SEEK_SCROLL_DISTANCE_PX);
    }

    public /* synthetic */ void b(g gVar, k kVar) {
        ((e.l.a.l.a) gVar).b();
        j0();
        kVar.dismiss();
    }
}
