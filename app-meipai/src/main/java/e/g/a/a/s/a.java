package e.g.a.a.s;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* compiled from: Chip */
public class a extends ViewOutlineProvider {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ Chip f8305a;

    public a(Chip chip) {
        this.f8305a = chip;
    }

    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        b bVar = this.f8305a.f3367d;
        if (bVar != null) {
            bVar.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
