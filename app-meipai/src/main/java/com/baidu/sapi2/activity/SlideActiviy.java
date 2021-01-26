package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.baidu.sapi2.C0164b;
import com.baidu.sapi2.SapiJsCallBacks.StopSlideWebviewCallback;
import com.baidu.sapi2.SapiWebView.LoadSlideWebViewCallback;
import com.baidu.sapi2.SapiWebView.LoadSlideWebViewResult;
import com.baidu.sapi2.utils.Log;
import e.c.e.a.a;
import e.c.e.a.b;
import e.c.e.a.c;
import e.c.e.a.d;
import e.c.e.a.e;
import e.c.e.a.e.f;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class SlideActiviy extends BaseActivity {
    public static final String ACCOUNT_CENTER_PAGE_NAME = "accountCenter";
    public static final String ADDRESS_PAGE_NAME = "address";
    public static final String EXTRAS_ACTION = "action";
    public static final String EXTRA_PARAMS_SLIDE_PAGE = "slidePage";
    public static final String INVOICE_PAGE_NAME = "invoice";
    public static final String SLIDE_ACTION_QUIT = "quit";
    public static final String r = "SlideActivity";
    public static final boolean s = true;
    public c mSlideHelper;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public d w;
    public f x;
    public boolean y = true;
    public WeakReference<Activity> z;

    public class PassSlideInterceptor implements d {
        public PassSlideInterceptor() {
        }

        public boolean isSlidable(MotionEvent motionEvent) {
            return SlideActiviy.this.y;
        }
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r13v4, types: [android.graphics.drawable.BitmapDrawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019a  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e() {
        /*
            r20 = this;
            r1 = r20
            boolean r0 = r1.t
            if (r0 == 0) goto L_0x019b
            android.content.res.Resources r0 = r20.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.orientation
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != r2) goto L_0x0017
            r0 = r4
            goto L_0x0018
        L_0x0017:
            r0 = r3
        L_0x0018:
            boolean r2 = r1.u
            if (r2 != 0) goto L_0x0024
            boolean r2 = r20.isTaskRoot()
            if (r2 == 0) goto L_0x0024
            r2 = r4
            goto L_0x0025
        L_0x0024:
            r2 = r0
        L_0x0025:
            android.view.Window r0 = r20.getWindow()
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            int r0 = r0.flags
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x003f
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.String r5 = "Sliding failed, have you forgot the Activity Theme: @android:style/Theme.Translucent.NoTitleBar"
            r0[r4] = r5
            java.lang.String r5 = "SlideActivity"
            com.baidu.sapi2.utils.Log.e(r5, r0)
        L_0x003f:
            android.content.res.Resources r0 = r20.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            if (r0 == 0) goto L_0x004d
            int r0 = r0.widthPixels
            r5 = r0
            goto L_0x004e
        L_0x004d:
            r5 = r4
        L_0x004e:
            e.c.e.a.c r0 = new e.c.e.a.c
            r0.<init>()
            r1.mSlideHelper = r0
            r6 = 0
            r7 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r7 = r1.findViewById(r7)
            boolean r8 = r7.isFocused()
            android.view.ViewParent r9 = r7.getParent()
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            r9.removeView(r7)
            android.view.View r10 = r0.f6878b
            if (r10 != 0) goto L_0x007e
            android.view.View r10 = new android.view.View
            r10.<init>(r1)
            r0.f6878b = r10
            java.lang.String r11 = "#40000000"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setBackgroundColor(r11)
        L_0x007e:
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r11 = -1
            r10.<init>(r11, r11)
            e.c.e.a.a r11 = new e.c.e.a.a
            r11.<init>(r1)
            r0.f6877a = r11
            java.lang.String r12 = "sliding_layout_shadow.9.png"
            boolean r13 = android.text.TextUtils.isEmpty(r12)
            if (r13 == 0) goto L_0x0094
            goto L_0x009a
        L_0x0094:
            android.graphics.Bitmap r12 = android.graphics.BitmapFactory.decodeFile(r12)
            if (r12 != 0) goto L_0x009c
        L_0x009a:
            r13 = r6
            goto L_0x00c3
        L_0x009c:
            byte[] r17 = r12.getNinePatchChunk()
            boolean r13 = android.graphics.NinePatch.isNinePatchChunk(r17)
            if (r13 == 0) goto L_0x00ba
            android.graphics.drawable.NinePatchDrawable r13 = new android.graphics.drawable.NinePatchDrawable
            android.content.res.Resources r15 = r20.getResources()
            android.graphics.Rect r18 = new android.graphics.Rect
            r18.<init>()
            r19 = 0
            r14 = r13
            r16 = r12
            r14.<init>(r15, r16, r17, r18, r19)
            goto L_0x00c3
        L_0x00ba:
            android.graphics.drawable.BitmapDrawable r13 = new android.graphics.drawable.BitmapDrawable
            android.content.res.Resources r14 = r20.getResources()
            r13.<init>(r14, r12)
        L_0x00c3:
            r11.setShadowDrawable(r13)
            e.c.e.a.e r11 = r0.f6877a
            android.view.View r12 = r0.f6878b
            r11.addView(r12, r10)
            e.c.e.a.e r11 = r0.f6877a
            r11.addView(r7, r10)
            e.c.e.a.e r7 = r0.f6877a
            r7.setSliderFadeColor(r4)
            e.c.e.a.e r7 = r0.f6877a
            r9.addView(r7)
            if (r8 == 0) goto L_0x00e3
            e.c.e.a.e r7 = r0.f6877a
            r7.requestFocus()
        L_0x00e3:
            e.c.e.a.e r0 = r0.f6877a
            r7 = r0
            e.c.e.a.a r7 = (e.c.e.a.a) r7
            if (r7 == 0) goto L_0x019a
            android.view.Window r0 = r20.getWindow()
            if (r0 == 0) goto L_0x0156
            android.view.Window r0 = r20.getWindow()
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x0156
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r1)
            r7.E = r0
            android.view.Window r0 = r20.getWindow()
            android.view.View r0 = r0.getDecorView()
            r0.setBackgroundColor(r4)
            boolean r0 = r7.B
            if (r0 != 0) goto L_0x0156
            java.lang.ref.WeakReference<android.app.Activity> r0 = r7.E
            if (r0 == 0) goto L_0x014f
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x011b
            goto L_0x014f
        L_0x011b:
            java.lang.ref.WeakReference<android.app.Activity> r0 = r7.E
            java.lang.Object r0 = r0.get()
            android.app.Activity r0 = (android.app.Activity) r0
            java.lang.Class<android.app.Activity> r8 = android.app.Activity.class
            java.lang.String r9 = "convertFromTranslucent"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch:{ all -> 0x0140 }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r9, r10)     // Catch:{ all -> 0x0140 }
            r8.setAccessible(r3)     // Catch:{ all -> 0x0140 }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x0140 }
            r8.invoke(r0, r9)     // Catch:{ all -> 0x0140 }
            r7.setActivityIsTranslucent(r4)     // Catch:{ all -> 0x0140 }
            e.c.e.a.b r0 = r7.F     // Catch:{ all -> 0x0140 }
            if (r0 == 0) goto L_0x0156
            r0.onTranslucent(r4)     // Catch:{ all -> 0x0140 }
            goto L_0x0156
        L_0x0140:
            r0 = move-exception
            r7.setActivityIsTranslucent(r3)
            e.c.e.a.b r4 = r7.F
            if (r4 == 0) goto L_0x014b
            r4.onTranslucent(r3)
        L_0x014b:
            r0.printStackTrace()
            goto L_0x0156
        L_0x014f:
            e.c.e.a.b r0 = r7.F
            if (r0 == 0) goto L_0x0156
            r0.onTranslucent(r3)
        L_0x0156:
            e.c.e.a.c r0 = r1.mSlideHelper
            e.c.e.a.e r0 = r0.f6877a
            if (r0 == 0) goto L_0x0165
            boolean r3 = r0 instanceof e.c.e.a.a
            if (r3 == 0) goto L_0x0165
            e.c.e.a.a r0 = (e.c.e.a.a) r0
            r0.setCanSlidable(r2)
        L_0x0165:
            e.c.e.a.c r0 = r1.mSlideHelper
            boolean r2 = r1.v
            e.c.e.a.e r0 = r0.f6877a
            if (r0 == 0) goto L_0x0175
            boolean r3 = r0 instanceof e.c.e.a.a
            if (r3 == 0) goto L_0x0175
            e.c.e.a.a r0 = (e.c.e.a.a) r0
            r0.B = r2
        L_0x0175:
            e.c.e.a.c r0 = r1.mSlideHelper
            e.c.e.a.d r2 = r1.w
            if (r0 == 0) goto L_0x0199
            if (r2 == 0) goto L_0x018a
            e.c.e.a.e r0 = r0.f6877a
            if (r0 == 0) goto L_0x018a
            boolean r3 = r0 instanceof e.c.e.a.a
            if (r3 == 0) goto L_0x018a
            e.c.e.a.a r0 = (e.c.e.a.a) r0
            r0.setSlideInterceptor(r2)
        L_0x018a:
            e.c.e.a.c r0 = r1.mSlideHelper
            com.baidu.sapi2.activity.SlideActiviy$4 r2 = new com.baidu.sapi2.activity.SlideActiviy$4
            r2.<init>(r5)
            e.c.e.a.e r0 = r0.f6877a
            if (r0 == 0) goto L_0x019b
            r0.setPanelSlideListener(r2)
            goto L_0x019b
        L_0x0199:
            throw r6
        L_0x019a:
            throw r6
        L_0x019b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.activity.SlideActiviy.e():void");
    }

    private void f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th) {
            Log.e(th);
        }
    }

    public void finishActivityAfterSlideOver() {
        finish();
    }

    public void forceActivityTransparent(boolean z2) {
        this.v = z2;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z2 = true;
        Log.d(r, "onConfigurationChanged: ");
        c cVar = this.mSlideHelper;
        if (cVar != null) {
            if (configuration.orientation == 2) {
                z2 = false;
            }
            e eVar = cVar.f6877a;
            if (eVar != null && (eVar instanceof a)) {
                ((a) eVar).setCanSlidable(z2);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT == 26) {
            f();
        }
        super.onCreate(bundle);
        if (this.configuration.supportGestureSlide) {
            this.t = true;
        } else {
            this.t = false;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(r, "onDetachedFromWindow: ");
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        Log.d(r, "onPostCreate");
        e();
    }

    public void onPostResume() {
        super.onPostResume();
        Log.d(r, "onPostResume: ");
    }

    public void onResume() {
        super.onResume();
        Log.d(r, "onResume: ");
    }

    public void onStart() {
        super.onStart();
        Log.d(r, "onStart: ");
    }

    public void setCurrentActivityNoTransparent() {
        e.c.d.n.e.b((Activity) this, (b) new b() {
            public void onTranslucent(boolean z) {
            }
        });
    }

    public void setEnableSliding(boolean z2) {
        this.t = z2;
    }

    public void setEnableTaskRootSlide(boolean z2) {
        this.u = z2;
    }

    public void setSlideExtraListener(f fVar) {
        this.x = fVar;
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setLoadSlideWebViewCallback(new LoadSlideWebViewCallback() {
            public void loadSlideWebview(LoadSlideWebViewResult loadSlideWebViewResult) {
                String str = loadSlideWebViewResult.page;
                String str2 = loadSlideWebViewResult.url;
                String str3 = "extra_external_url";
                if (SlideActiviy.ADDRESS_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str2)) {
                    Intent intent = new Intent(SlideActiviy.this, AddressManageExternalActivity.class);
                    intent.putExtra(str3, str2);
                    SlideActiviy.this.startActivity(intent);
                } else if (SlideActiviy.INVOICE_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str2)) {
                    Intent intent2 = new Intent(SlideActiviy.this, InvoiceBuildExternalActivity.class);
                    intent2.putExtra(str3, str2);
                    SlideActiviy.this.startActivity(intent2);
                } else if (SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str2)) {
                    Intent intent3 = new Intent(SlideActiviy.this, AccountCenterExternalActivity.class);
                    intent3.putExtra(str3, str2);
                    SlideActiviy.this.startActivity(intent3);
                }
            }
        });
        this.sapiWebView.setStopSlideWebviewCallback(new StopSlideWebviewCallback() {
            public void onStopSlide(boolean z) {
                String str = SlideActiviy.r;
                if (z) {
                    Log.d(str, "Slide should be opened now");
                    SlideActiviy.this.y = false;
                } else {
                    Log.d(str, "Slide should be closed now");
                    SlideActiviy.this.y = true;
                }
                SlideActiviy slideActiviy = SlideActiviy.this;
                slideActiviy.w = new PassSlideInterceptor();
                SlideActiviy slideActiviy2 = SlideActiviy.this;
                c cVar = slideActiviy2.mSlideHelper;
                d b2 = slideActiviy2.w;
                if (cVar == null) {
                    throw null;
                } else if (b2 != null) {
                    e eVar = cVar.f6877a;
                    if (eVar != null && (eVar instanceof a)) {
                        ((a) eVar).setSlideInterceptor(b2);
                    }
                }
            }
        });
    }

    public void setEnableSliding(boolean z2, d dVar) {
        this.t = z2;
        this.w = dVar;
    }

    /* access modifiers changed from: private */
    public void a(float f2) {
        try {
            if (this.z == null || this.z.get() == null) {
                this.z = new WeakReference<>(C0164b.b().c());
            }
            if (this.z.get() != null) {
                Activity d2 = C0164b.b().d();
                Activity activity = (Activity) this.z.get();
                if (d2 == null || activity == null || !d2.getLocalClassName().equals(activity.getLocalClassName())) {
                    a(activity, f2);
                } else {
                    a(activity, 0.0f);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Activity activity, float f2) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(16908290);
            if (viewGroup != null) {
                viewGroup.setX(f2);
            }
        }
    }
}
