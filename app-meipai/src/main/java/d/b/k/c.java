package d.b.k;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController.b;

/* compiled from: AlertController */
public class c implements OnItemClickListener {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ AlertController f3989a;

    /* renamed from: b reason: collision with root package name */
    public final /* synthetic */ b f3990b;

    public c(b bVar, AlertController alertController) {
        this.f3990b = bVar;
        this.f3989a = alertController;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f3990b.m.onClick(this.f3989a.f674b, i2);
        if (!this.f3990b.o) {
            this.f3989a.f674b.dismiss();
        }
    }
}
