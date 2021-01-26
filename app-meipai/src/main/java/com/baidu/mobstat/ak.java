package com.baidu.mobstat;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.Window.Callback;

public class ak {

    /* renamed from: a reason: collision with root package name */
    public static volatile boolean f1524a = true;

    /* renamed from: b reason: collision with root package name */
    public a f1525b;

    /* renamed from: c reason: collision with root package name */
    public Activity f1526c;

    /* renamed from: d reason: collision with root package name */
    public Handler f1527d = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 100 && ak.this.f1525b != null) {
                ak.this.f1525b.a();
            }
        }
    };

    public interface a {
        void a();
    }

    public ak(a aVar) {
        this.f1525b = aVar;
    }

    private void c(Activity activity) {
        if (activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                window.setCallback(a(window.getCallback()));
            }
        }
    }

    private void d(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            Callback callback = window.getCallback();
            if (callback != null) {
                window.setCallback(new al(callback, new com.baidu.mobstat.al.a() {
                    public void a(KeyEvent keyEvent) {
                    }

                    public void a(MotionEvent motionEvent) {
                        ak.a(true);
                        int actionMasked = motionEvent.getActionMasked();
                        if (actionMasked == 5) {
                            int pointerCount = motionEvent.getPointerCount();
                            if (pointerCount == 3 && motionEvent.getEventTime() - motionEvent.getDownTime() <= 50) {
                                ak.this.f1527d.sendEmptyMessageDelayed(100, 2500);
                            } else if (pointerCount > 3) {
                                ak.this.f1527d.removeMessages(100);
                            }
                        } else if (actionMasked == 6 && motionEvent.getEventTime() - motionEvent.getDownTime() < 2500) {
                            ak.this.f1527d.removeMessages(100);
                        }
                    }
                }));
            }
        }
    }

    public static void a(boolean z) {
        if (z) {
            an.a();
        }
        f1524a = z;
    }

    public void b() {
        c(this.f1526c);
        this.f1526c = null;
    }

    public static boolean a() {
        return f1524a;
    }

    private void b(Activity activity) {
        d(activity);
    }

    public void a(Activity activity) {
        if (activity != null) {
            this.f1526c = activity;
            b(activity);
        }
    }

    private Callback a(Callback callback) {
        while (callback != null && (callback instanceof al)) {
            callback = ((al) callback).a();
        }
        return callback;
    }
}
