package com.baidu.sapi2.utils;

import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.io.PrintStream;

/* compiled from: SoftKeyBoardListener */
public class o implements OnGlobalLayoutListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ p f3109a;

    public o(p pVar) {
        this.f3109a = pVar;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        this.f3109a.f3110a.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(height);
        printStream.println(sb.toString());
        p pVar = this.f3109a;
        int i2 = pVar.f3111b;
        if (i2 == 0) {
            pVar.f3111b = height;
        } else if (i2 != height) {
            if (i2 - height > 200) {
                if (pVar.f3112c != null) {
                    this.f3109a.f3112c.keyBoardShow(this.f3109a.f3111b - height);
                }
                this.f3109a.f3111b = height;
                return;
            }
            if (height - i2 > 200) {
                if (pVar.f3112c != null) {
                    this.f3109a.f3112c.keyBoardHide(height - this.f3109a.f3111b);
                }
                this.f3109a.f3111b = height;
            }
        }
    }
}
