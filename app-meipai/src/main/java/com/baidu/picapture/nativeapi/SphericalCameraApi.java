package com.baidu.picapture.nativeapi;

import android.webkit.JavascriptInterface;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import com.arashivision.sdkcamera.camera.callback.ICameraChangedCallback;
import com.baidu.mobstat.Config;
import com.baidu.picapture.ui.widget.bdwebview.NativeBridge.a;
import e.c.d.i.c.k;
import e.c.d.i.c.r;
import e.c.d.k.g;
import e.c.d.k.h;
import e.c.d.k.i;
import e.c.d.k.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SphericalCameraApi {

    /* renamed from: a reason: collision with root package name */
    public boolean f1968a = false;

    /* renamed from: b reason: collision with root package name */
    public List<a> f1969b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    public ICameraChangedCallback f1970c;

    public SphericalCameraApi() {
        AnonymousClass1 r0 = new ICameraChangedCallback() {
            public /* synthetic */ void onCameraBatteryLow() {
                e.b.d.a.j.a.$default$onCameraBatteryLow(this);
            }

            public /* synthetic */ void onCameraBatteryUpdate(int i2, boolean z) {
                e.b.d.a.j.a.$default$onCameraBatteryUpdate(this, i2, z);
            }

            public void onCameraConnectError() {
                SphericalCameraApi sphericalCameraApi = SphericalCameraApi.this;
                sphericalCameraApi.f1968a = false;
                SphericalCameraApi.a(sphericalCameraApi);
            }

            public /* synthetic */ void onCameraSDCardStateChanged(boolean z) {
                e.b.d.a.j.a.$default$onCameraSDCardStateChanged(this, z);
            }

            public void onCameraStatusChanged(boolean z) {
                SphericalCameraApi sphericalCameraApi = SphericalCameraApi.this;
                sphericalCameraApi.f1968a = false;
                if (!z) {
                    SphericalCameraApi.a(sphericalCameraApi);
                } else if (sphericalCameraApi.f1969b.size() > 0) {
                    r rVar = r.f6218b;
                    rVar.f6219a.execute(new k(rVar, new h(sphericalCameraApi)));
                }
            }

            public /* synthetic */ void onCameraStorageChanged(long j2, long j3) {
                e.b.d.a.j.a.$default$onCameraStorageChanged(this, j2, j3);
            }
        };
        this.f1970c = r0;
        r.f6218b.a((ICameraChangedCallback) r0);
    }

    public /* synthetic */ void a(String str, int i2) {
        for (a aVar : this.f1969b) {
            if (i2 == 0) {
                aVar.a("0");
            } else {
                aVar.a(String.valueOf(i2));
            }
        }
        this.f1969b.clear();
    }

    public void connect() {
        if (r.f6218b == null) {
            throw null;
        } else if (InstaCameraManager.getInstance().getCameraConnectedType() == -1) {
            this.f1968a = true;
            r.f6218b.a(this.f1970c);
            r.f6218b.a();
        }
    }

    @JavascriptInterface
    public void formatSDCard(a aVar) {
        if (this.f1968a) {
            this.f1969b.add(aVar);
        } else if (r.f6218b != null) {
            if (InstaCameraManager.getInstance().getCameraConnectedType() != -1) {
                r rVar = r.f6218b;
                rVar.f6219a.execute(new k(rVar, new i(aVar)));
            } else {
                this.f1968a = true;
                this.f1969b.add(aVar);
                r.f6218b.a();
            }
        } else {
            throw null;
        }
    }

    @JavascriptInterface
    public void isConnected(a aVar) {
        r.f6218b.a((r.a<Boolean>) new j<Boolean>(aVar));
    }

    @JavascriptInterface
    public void storage(a aVar) {
        r.f6218b.b(new g(aVar));
    }

    public static /* synthetic */ void a(SphericalCameraApi sphericalCameraApi) {
        for (a a2 : sphericalCameraApi.f1969b) {
            a2.a("1");
        }
        sphericalCameraApi.f1969b.clear();
    }

    public static /* synthetic */ void a(a aVar, String str, int i2) {
        if (i2 == 0) {
            aVar.a("0");
        } else {
            aVar.a(String.valueOf(i2));
        }
    }

    public static /* synthetic */ void a(a aVar, Boolean bool, int i2) {
        if (bool.booleanValue()) {
            aVar.a("1");
        } else {
            aVar.a("0");
        }
    }

    public static /* synthetic */ void a(a aVar, List list, int i2) {
        String str = "";
        if (i2 != 0) {
            aVar.a(str);
        } else if (list == null || list.size() != 2) {
            aVar.a(str);
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EXCEPTION_MEMORY_TOTAL, list.get(0));
                jSONObject.put(Config.EXCEPTION_MEMORY_FREE, list.get(1));
                aVar.a(jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
                aVar.a(str);
            }
        }
    }
}
