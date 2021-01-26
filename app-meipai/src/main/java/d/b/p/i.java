package d.b.p;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* compiled from: AppCompatCompoundButtonHelper */
public class i {

    /* renamed from: a reason: collision with root package name */
    public final CompoundButton f4349a;

    /* renamed from: b reason: collision with root package name */
    public ColorStateList f4350b = null;

    /* renamed from: c reason: collision with root package name */
    public Mode f4351c = null;

    /* renamed from: d reason: collision with root package name */
    public boolean f4352d = false;

    /* renamed from: e reason: collision with root package name */
    public boolean f4353e = false;

    /* renamed from: f reason: collision with root package name */
    public boolean f4354f;

    public i(CompoundButton compoundButton) {
        this.f4349a = compoundButton;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[SYNTHETIC, Splitter:B:12:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ all -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[Catch:{ all -> 0x0080 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f4349a
            android.content.Context r0 = r0.getContext()
            int[] r1 = d.b.j.CompoundButton
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = d.b.j.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            int r5 = d.b.j.CompoundButton_buttonCompat     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x002e
            android.widget.CompoundButton r0 = r3.f4349a     // Catch:{ NotFoundException -> 0x002e }
            android.widget.CompoundButton r1 = r3.f4349a     // Catch:{ NotFoundException -> 0x002e }
            android.content.Context r1 = r1.getContext()     // Catch:{ NotFoundException -> 0x002e }
            android.graphics.drawable.Drawable r5 = d.b.l.a.a.b(r1, r5)     // Catch:{ NotFoundException -> 0x002e }
            r0.setButtonDrawable(r5)     // Catch:{ NotFoundException -> 0x002e }
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = r2
        L_0x002f:
            if (r5 != 0) goto L_0x0050
            int r5 = d.b.j.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            int r5 = d.b.j.CompoundButton_android_button     // Catch:{ all -> 0x0080 }
            int r5 = r4.getResourceId(r5, r2)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0050
            android.widget.CompoundButton r0 = r3.f4349a     // Catch:{ all -> 0x0080 }
            android.widget.CompoundButton r1 = r3.f4349a     // Catch:{ all -> 0x0080 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0080 }
            android.graphics.drawable.Drawable r5 = d.b.l.a.a.b(r1, r5)     // Catch:{ all -> 0x0080 }
            r0.setButtonDrawable(r5)     // Catch:{ all -> 0x0080 }
        L_0x0050:
            int r5 = d.b.j.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0063
            android.widget.CompoundButton r5 = r3.f4349a     // Catch:{ all -> 0x0080 }
            int r0 = d.b.j.CompoundButton_buttonTint     // Catch:{ all -> 0x0080 }
            android.content.res.ColorStateList r0 = r4.getColorStateList(r0)     // Catch:{ all -> 0x0080 }
            r5.setButtonTintList(r0)     // Catch:{ all -> 0x0080 }
        L_0x0063:
            int r5 = d.b.j.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            boolean r5 = r4.hasValue(r5)     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x007c
            android.widget.CompoundButton r5 = r3.f4349a     // Catch:{ all -> 0x0080 }
            int r0 = d.b.j.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0080 }
            r1 = -1
            int r0 = r4.getInt(r0, r1)     // Catch:{ all -> 0x0080 }
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = d.b.p.e0.a(r0, r1)     // Catch:{ all -> 0x0080 }
            r5.setButtonTintMode(r0)     // Catch:{ all -> 0x0080 }
        L_0x007c:
            r4.recycle()
            return
        L_0x0080:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.i.a(android.util.AttributeSet, int):void");
    }

    public void a() {
        Drawable buttonDrawable = this.f4349a.getButtonDrawable();
        if (buttonDrawable == null) {
            return;
        }
        if (this.f4352d || this.f4353e) {
            Drawable mutate = buttonDrawable.mutate();
            if (this.f4352d) {
                mutate.setTintList(this.f4350b);
            }
            if (this.f4353e) {
                mutate.setTintMode(this.f4351c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f4349a.getDrawableState());
            }
            this.f4349a.setButtonDrawable(mutate);
        }
    }
}
