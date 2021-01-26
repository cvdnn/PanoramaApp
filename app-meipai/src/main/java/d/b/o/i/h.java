package d.b.o.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import d.b.o.i.m.a;

/* compiled from: MenuDialogHelper */
public class h implements OnKeyListener, OnClickListener, OnDismissListener, a {

    /* renamed from: a reason: collision with root package name */
    public g f4208a;

    /* renamed from: b reason: collision with root package name */
    public AlertDialog f4209b;

    /* renamed from: c reason: collision with root package name */
    public e f4210c;

    public h(g gVar) {
        this.f4208a = gVar;
    }

    public void a(g gVar, boolean z) {
        if (z || gVar == this.f4208a) {
            AlertDialog alertDialog = this.f4209b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        }
    }

    public boolean a(g gVar) {
        return false;
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f4208a.a((MenuItem) (i) this.f4210c.a().getItem(i2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        e eVar = this.f4210c;
        g gVar = this.f4208a;
        a aVar = eVar.f4188h;
        if (aVar != null) {
            aVar.a(gVar, true);
        }
    }

    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window = this.f4209b.getWindow();
                if (window != null) {
                    View decorView = window.getDecorView();
                    if (decorView != null) {
                        DispatcherState keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                Window window2 = this.f4209b.getWindow();
                if (window2 != null) {
                    View decorView2 = window2.getDecorView();
                    if (decorView2 != null) {
                        DispatcherState keyDispatcherState2 = decorView2.getKeyDispatcherState();
                        if (keyDispatcherState2 != null && keyDispatcherState2.isTracking(keyEvent)) {
                            this.f4208a.a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f4208a.performShortcut(i2, keyEvent, 0);
    }
}
