package com.yanzhenjie.permission.bridge;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import e.l.a.k.a.b;
import e.l.a.m.a;
import e.l.a.m.c;

public final class BridgeActivity extends Activity {

    /* renamed from: a reason: collision with root package name */
    public String f3974a;

    public static void a(c cVar, String str, String[] strArr) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 2);
        intent.putExtra("KEY_PERMISSIONS", strArr);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }

    public static void b(c cVar, String str) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 1);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }

    public static void c(c cVar, String str) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 3);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }

    public static void d(c cVar, String str) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 7);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }

    public static void e(c cVar, String str) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 6);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }

    public static void f(c cVar, String str) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 4);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }

    public static void g(c cVar, String str) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 8);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        e.l.a.h.c.a(this, this.f3974a);
        finish();
    }

    public void onCreate(Bundle bundle) {
        Intent intent;
        Intent intent2;
        Intent a2;
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent3 = getIntent();
            int intExtra = intent3.getIntExtra("KEY_TYPE", -1);
            this.f3974a = intent3.getStringExtra("KEY_ACTION_SUFFIX");
            String str = "com.meizu.safe.security.AppSecActivity";
            String str2 = "com.meizu.safe";
            String str3 = "packageName";
            String str4 = "com.meizu.safe.security.SHOW_APPSEC";
            String str5 = "meizu";
            String str6 = "package";
            switch (intExtra) {
                case 1:
                    Intent intent4 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent4.setData(Uri.fromParts(str6, getPackageName(), null));
                    super.startActivityForResult(intent4, 1);
                    break;
                case 2:
                    requestPermissions(intent3.getStringArrayExtra("KEY_PERMISSIONS"), 2);
                    break;
                case 3:
                    Intent intent5 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    intent5.setData(Uri.fromParts(str6, getPackageName(), null));
                    super.startActivityForResult(intent5, 3);
                    break;
                case 4:
                    b bVar = new b(new a(this));
                    if (b.f8958b.contains(str5)) {
                        Context a3 = bVar.f8959a.a();
                        intent = new Intent(str4);
                        intent.putExtra(str3, a3.getPackageName());
                        intent.setClassName(str2, str);
                        if (!b.a(a3, intent)) {
                            intent = b.b(a3);
                        }
                    } else {
                        intent = b.b(bVar.f8959a.a());
                    }
                    try {
                        bVar.f8959a.a(intent, 4);
                        break;
                    } catch (Exception unused) {
                        bVar.f8959a.a(b.a(bVar.f8959a.a()), 4);
                        break;
                    }
                case 5:
                    e.l.a.k.a.a aVar = new e.l.a.k.a.a(new a(this));
                    if (e.l.a.k.a.a.f8956b.contains("huawei")) {
                        Context a4 = aVar.f8957a.a();
                        intent2 = new Intent();
                        intent2.putExtra(str6, a4.getPackageName());
                        intent2.putExtra(str3, a4.getPackageName());
                        intent2.setData(Uri.fromParts(str6, a4.getPackageName(), null));
                        String str7 = "com.huawei.systemmanager";
                        intent2.setClassName(str7, "com.huawei.permissionmanager.ui.MainActivity");
                        if (!e.l.a.k.a.a.a(a4, intent2)) {
                            intent2.setClassName(str7, "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
                            if (!e.l.a.k.a.a.a(a4, intent2)) {
                                intent2.setClassName(str7, "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
                                if (!e.l.a.k.a.a.a(a4, intent2)) {
                                    intent2 = e.l.a.k.a.a.a(a4);
                                }
                            }
                        }
                    } else {
                        if (e.l.a.k.a.a.f8956b.contains("xiaomi")) {
                            Context a5 = aVar.f8957a.a();
                            intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
                            intent2.putExtra("extra_pkgname", a5.getPackageName());
                            if (!e.l.a.k.a.a.a(a5, intent2)) {
                                intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                                if (!e.l.a.k.a.a.a(a5, intent2)) {
                                    a2 = e.l.a.k.a.a.a(a5);
                                }
                            }
                        } else if (e.l.a.k.a.a.f8956b.contains("oppo")) {
                            Context a6 = aVar.f8957a.a();
                            intent2 = new Intent();
                            intent2.putExtra(str3, a6.getPackageName());
                            intent2.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
                            if (!e.l.a.k.a.a.a(a6, intent2)) {
                                intent2.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
                                if (!e.l.a.k.a.a.a(a6, intent2)) {
                                    intent2.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
                                    if (!e.l.a.k.a.a.a(a6, intent2)) {
                                        a2 = e.l.a.k.a.a.a(a6);
                                    }
                                }
                            }
                        } else if (e.l.a.k.a.a.f8956b.contains("vivo")) {
                            Context a7 = aVar.f8957a.a();
                            intent2 = new Intent();
                            String str8 = "com.iqoo.secure";
                            intent2.setClassName(str8, "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
                            intent2.putExtra("packagename", a7.getPackageName());
                            if (!e.l.a.k.a.a.a(a7, intent2)) {
                                intent2.setClassName(str8, "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
                                if (!e.l.a.k.a.a.a(a7, intent2)) {
                                    a2 = e.l.a.k.a.a.a(a7);
                                }
                            }
                        } else if (e.l.a.k.a.a.f8956b.contains(str5)) {
                            Context a8 = aVar.f8957a.a();
                            Intent intent6 = new Intent(str4);
                            intent6.putExtra(str3, a8.getPackageName());
                            intent6.setComponent(new ComponentName(str2, str));
                            if (e.l.a.k.a.a.a(a8, intent6)) {
                                intent2 = intent6;
                            } else {
                                a2 = e.l.a.k.a.a.a(a8);
                            }
                        } else {
                            intent2 = e.l.a.k.a.a.a(aVar.f8957a.a());
                        }
                        intent2 = a2;
                    }
                    try {
                        aVar.f8957a.a(intent2, 5);
                        break;
                    } catch (Exception unused2) {
                        aVar.f8957a.a(e.l.a.k.a.a.a(aVar.f8957a.a()), 5);
                        break;
                    }
                case 6:
                    Intent intent7 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent7.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                    intent7.setData(Uri.fromParts(str6, getPackageName(), null));
                    super.startActivityForResult(intent7, 6);
                    break;
                case 7:
                    Intent intent8 = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                    intent8.setData(Uri.fromParts(str6, getPackageName(), null));
                    super.startActivityForResult(intent8, 7);
                    break;
                case 8:
                    Intent intent9 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                    intent9.setData(Uri.fromParts(str6, getPackageName(), null));
                    super.startActivityForResult(intent9, 8);
                    break;
            }
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        e.l.a.h.c.a(this, this.f3974a);
        finish();
    }

    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    public static void a(c cVar, String str) {
        Intent intent = new Intent(cVar.a(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 5);
        intent.putExtra("KEY_ACTION_SUFFIX", str);
        cVar.a(intent);
    }
}
