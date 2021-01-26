package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.sapi2.SapiJsInterpreters.SendUpwardSms;
import com.baidu.sapi2.SapiWebView;

public class ai {
    @SuppressLint({"NewApi"})
    public static void b(final Activity activity) {
        final ViewGroup viewGroup;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup != null && a(viewGroup) == null) {
            final ag agVar = new ag(activity);
            agVar.setBackgroundColor(-16745729);
            agVar.setGravity(17);
            agVar.setText("连接中");
            agVar.setTag(-5000, "baidu_mtj_edit_txtview");
            viewGroup.post(new Runnable() {
                public void run() {
                    int width = viewGroup.getWidth();
                    int height = viewGroup.getHeight();
                    int c2 = ah.c(activity, 55.0f);
                    LayoutParams layoutParams = new LayoutParams(c2, c2);
                    layoutParams.leftMargin = (width - c2) / 6;
                    layoutParams.topMargin = ((height - c2) * 5) / 6;
                    agVar.setLayoutParams(layoutParams);
                }
            });
            viewGroup.addView(agVar);
            a(activity, (TextView) agVar);
        }
    }

    public static boolean a(View view) {
        Object tag = view.getTag(-5000);
        return tag != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview");
    }

    public static void a(Activity activity, boolean z) {
        ViewGroup viewGroup;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup != null) {
            View a2 = a(viewGroup);
            if (a2 != null) {
                a2.setVisibility(z ? 0 : 4);
            }
        }
    }

    public static void a(Activity activity) {
        ViewGroup viewGroup;
        try {
            viewGroup = (ViewGroup) bj.a(activity).findViewById(16908290);
        } catch (Exception unused) {
            viewGroup = null;
        }
        if (viewGroup != null) {
            View a2 = a(viewGroup);
            if (a2 != null) {
                viewGroup.removeView(a2);
            }
        }
    }

    public static boolean b(float f2, float f3, float f4, float f5) {
        return Math.abs(f2 - f3) <= 5.0f && Math.abs(f4 - f5) <= 5.0f;
    }

    public static void b(Context context) {
        Builder builder = new Builder(context);
        builder.setMessage("是否确认退出连接?");
        builder.setPositiveButton(SendUpwardSms.f2353c, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                am.a().c();
                bc.c().a("autotrace: connect close, app close");
                am.a().a(4);
                am.a().d();
            }
        });
        builder.setNegativeButton(SapiWebView.A, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public static void a(final Activity activity, TextView textView) {
        final View view = (View) textView.getParent();
        textView.setOnTouchListener(new OnTouchListener() {

            /* renamed from: a reason: collision with root package name */
            public int f1513a = 0;

            /* renamed from: b reason: collision with root package name */
            public int f1514b = 0;

            /* renamed from: c reason: collision with root package name */
            public int f1515c = 0;

            /* renamed from: d reason: collision with root package name */
            public int f1516d = 0;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f1513a = rawX;
                    this.f1514b = rawY;
                    this.f1515c = rawX - view.getLeft();
                    this.f1516d = rawY - view.getTop();
                } else if (action == 1) {
                    if (ai.b((float) this.f1513a, (float) ((int) motionEvent.getRawX()), (float) this.f1514b, (float) ((int) motionEvent.getRawY()))) {
                        ai.b((Context) activity);
                    }
                } else if (action == 2) {
                    int i2 = rawX - this.f1515c;
                    int i3 = rawY - this.f1516d;
                    Rect rect = new Rect();
                    view.getLocalVisibleRect(rect);
                    if (rect.contains(new Rect(i2, i3, view.getWidth() + i2, view.getHeight() + i3))) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                        marginLayoutParams.leftMargin = i2;
                        marginLayoutParams.topMargin = i3;
                        view.setLayoutParams(marginLayoutParams);
                    }
                }
                return true;
            }
        });
    }

    public static View a(ViewGroup viewGroup) {
        View view = null;
        if (viewGroup == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= viewGroup.getChildCount()) {
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null) {
                Object tag = childAt.getTag(-5000);
                if (tag != null && (tag instanceof String) && ((String) tag).equals("baidu_mtj_edit_txtview")) {
                    view = childAt;
                    break;
                }
            }
            i2++;
        }
        return view;
    }
}
