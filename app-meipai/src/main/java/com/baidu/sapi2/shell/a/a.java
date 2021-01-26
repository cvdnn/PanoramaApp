package com.baidu.sapi2.shell.a;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore.Images.Media;
import com.baidu.sapi2.shell.listener.IScreenShotListener;
import com.baidu.sapi2.utils.Log;

/* compiled from: ScreenShotManager */
public class a {

    /* renamed from: a reason: collision with root package name */
    public static final String f2978a = "screen_shot_observer";

    /* renamed from: b reason: collision with root package name */
    public static final String[] f2979b = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};

    /* renamed from: c reason: collision with root package name */
    public static final String[] f2980c = {"_data", "datetaken"};

    /* renamed from: d reason: collision with root package name */
    public ContentResolver f2981d;

    /* renamed from: e reason: collision with root package name */
    public IScreenShotListener f2982e;

    /* renamed from: f reason: collision with root package name */
    public HandlerThread f2983f;

    /* renamed from: g reason: collision with root package name */
    public Handler f2984g;

    /* renamed from: h reason: collision with root package name */
    public C0012a f2985h;

    /* renamed from: i reason: collision with root package name */
    public C0012a f2986i;

    /* renamed from: com.baidu.sapi2.shell.a.a$a reason: collision with other inner class name */
    /* compiled from: ScreenShotManager */
    public class C0012a extends ContentObserver {

        /* renamed from: a reason: collision with root package name */
        public final Uri f2987a;

        public C0012a(Uri uri, Handler handler) {
            super(handler);
            this.f2987a = uri;
        }

        public void onChange(boolean z) {
            super.onChange(z);
            a.this.a(this.f2987a);
        }
    }

    public void b() {
        this.f2981d.unregisterContentObserver(this.f2985h);
        this.f2981d.unregisterContentObserver(this.f2986i);
    }

    public void a(ContentResolver contentResolver, IScreenShotListener iScreenShotListener) {
        this.f2981d = contentResolver;
        this.f2982e = iScreenShotListener;
        HandlerThread handlerThread = new HandlerThread(f2978a);
        this.f2983f = handlerThread;
        handlerThread.start();
        this.f2984g = new Handler(this.f2983f.getLooper());
        this.f2985h = new C0012a(Media.INTERNAL_CONTENT_URI, this.f2984g);
        this.f2986i = new C0012a(Media.EXTERNAL_CONTENT_URI, this.f2984g);
    }

    public void a() {
        this.f2981d.registerContentObserver(Media.INTERNAL_CONTENT_URI, false, this.f2985h);
        this.f2981d.registerContentObserver(Media.EXTERNAL_CONTENT_URI, false, this.f2986i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (r0.isClosed() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004e, code lost:
        if (r0.isClosed() == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.net.Uri r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.ContentResolver r1 = r7.f2981d     // Catch:{ Exception -> 0x0035 }
            java.lang.String[] r3 = f2980c     // Catch:{ Exception -> 0x0035 }
            r4 = 0
            r5 = 0
            java.lang.String r6 = "date_added desc limit 1"
            r2 = r8
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0035 }
            if (r0 == 0) goto L_0x0037
            boolean r8 = r0.moveToFirst()     // Catch:{ Exception -> 0x0035 }
            if (r8 != 0) goto L_0x0017
            goto L_0x0037
        L_0x0017:
            java.lang.String r8 = "_data"
            int r8 = r0.getColumnIndex(r8)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r8 = r0.getString(r8)     // Catch:{ Exception -> 0x0035 }
            java.lang.String r1 = "datetaken"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x0035 }
            long r1 = r0.getLong(r1)     // Catch:{ Exception -> 0x0035 }
            r7.a(r8, r1)     // Catch:{ Exception -> 0x0035 }
            boolean r8 = r0.isClosed()
            if (r8 != 0) goto L_0x0053
            goto L_0x0050
        L_0x0035:
            r8 = move-exception
            goto L_0x0045
        L_0x0037:
            if (r0 == 0) goto L_0x0042
            boolean r8 = r0.isClosed()
            if (r8 != 0) goto L_0x0042
            r0.close()
        L_0x0042:
            return
        L_0x0043:
            r8 = move-exception
            goto L_0x0054
        L_0x0045:
            com.baidu.sapi2.utils.Log.e(r8)     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0053
            boolean r8 = r0.isClosed()
            if (r8 != 0) goto L_0x0053
        L_0x0050:
            r0.close()
        L_0x0053:
            return
        L_0x0054:
            if (r0 == 0) goto L_0x005f
            boolean r1 = r0.isClosed()
            if (r1 != 0) goto L_0x005f
            r0.close()
        L_0x005f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.shell.a.a.a(android.net.Uri):void");
    }

    private void a(String str, long j2) {
        long j3 = 0;
        while (!a(str) && j3 <= 500) {
            j3 += 100;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e2) {
                Log.e(e2);
            }
        }
        if (a(str)) {
            IScreenShotListener iScreenShotListener = this.f2982e;
            if (iScreenShotListener != null) {
                iScreenShotListener.onScreenShot();
            }
        }
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String contains : f2979b) {
            if (lowerCase.contains(contains)) {
                return true;
            }
        }
        return false;
    }
}
