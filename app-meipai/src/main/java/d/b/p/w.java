package d.b.p;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import d.h.k.m;

/* compiled from: AppCompatSpinner */
public class w extends Spinner {

    /* renamed from: i reason: collision with root package name */
    public static final int[] f4460i = {16843505};

    /* renamed from: a reason: collision with root package name */
    public final e f4461a;

    /* renamed from: b reason: collision with root package name */
    public final Context f4462b;

    /* renamed from: c reason: collision with root package name */
    public h0 f4463c;

    /* renamed from: d reason: collision with root package name */
    public SpinnerAdapter f4464d;

    /* renamed from: e reason: collision with root package name */
    public final boolean f4465e;

    /* renamed from: f reason: collision with root package name */
    public f f4466f;

    /* renamed from: g reason: collision with root package name */
    public int f4467g;

    /* renamed from: h reason: collision with root package name */
    public final Rect f4468h = new Rect();

    /* compiled from: AppCompatSpinner */
    public class a implements OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (!w.this.getInternalPopup().a()) {
                w.this.a();
            }
            ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* compiled from: AppCompatSpinner */
    public class b implements f, OnClickListener {

        /* renamed from: a reason: collision with root package name */
        public AlertDialog f4470a;

        /* renamed from: b reason: collision with root package name */
        public ListAdapter f4471b;

        /* renamed from: c reason: collision with root package name */
        public CharSequence f4472c;

        public b() {
        }

        public boolean a() {
            AlertDialog alertDialog = this.f4470a;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public int b() {
            return 0;
        }

        public void b(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public CharSequence c() {
            return this.f4472c;
        }

        public void dismiss() {
            AlertDialog alertDialog = this.f4470a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f4470a = null;
            }
        }

        public Drawable e() {
            return null;
        }

        public int g() {
            return 0;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            w.this.setSelection(i2);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i2, this.f4471b.getItemId(i2));
            }
            AlertDialog alertDialog = this.f4470a;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f4470a = null;
            }
        }

        public void a(ListAdapter listAdapter) {
            this.f4471b = listAdapter;
        }

        public void c(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public void a(CharSequence charSequence) {
            this.f4472c = charSequence;
        }

        public void a(int i2, int i3) {
            if (this.f4471b != null) {
                androidx.appcompat.app.AlertDialog.a aVar = new androidx.appcompat.app.AlertDialog.a(w.this.getPopupContext());
                CharSequence charSequence = this.f4472c;
                if (charSequence != null) {
                    aVar.f698a.f691f = charSequence;
                }
                ListAdapter listAdapter = this.f4471b;
                int selectedItemPosition = w.this.getSelectedItemPosition();
                androidx.appcompat.app.AlertController.b bVar = aVar.f698a;
                bVar.l = listAdapter;
                bVar.m = this;
                bVar.p = selectedItemPosition;
                bVar.o = true;
                AlertDialog a2 = aVar.a();
                this.f4470a = a2;
                ListView listView = a2.f697c.f679g;
                listView.setTextDirection(i2);
                listView.setTextAlignment(i3);
                this.f4470a.show();
            }
        }

        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public void a(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }
    }

    /* compiled from: AppCompatSpinner */
    public static class c implements ListAdapter, SpinnerAdapter {

        /* renamed from: a reason: collision with root package name */
        public SpinnerAdapter f4474a;

        /* renamed from: b reason: collision with root package name */
        public ListAdapter f4475b;

        public c(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f4474a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f4475b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof t0) {
                t0 t0Var = (t0) spinnerAdapter;
                if (t0Var.getDropDownViewTheme() == null) {
                    t0Var.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f4475b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f4475b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f4474a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner */
    public class d extends k0 implements f {
        public CharSequence F;
        public ListAdapter G;
        public final Rect H = new Rect();
        public int I;

        /* compiled from: AppCompatSpinner */
        public class a implements OnItemClickListener {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ w f4476a;

            public a(w wVar) {
                this.f4476a = wVar;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                w.this.setSelection(i2);
                if (w.this.getOnItemClickListener() != null) {
                    d dVar = d.this;
                    w.this.performItemClick(view, i2, dVar.G.getItemId(i2));
                }
                d.this.dismiss();
            }
        }

        /* compiled from: AppCompatSpinner */
        public class b implements OnGlobalLayoutListener {
            public b() {
            }

            public void onGlobalLayout() {
                d dVar = d.this;
                w wVar = w.this;
                if (dVar != null) {
                    if (!(m.y(wVar) && wVar.getGlobalVisibleRect(dVar.H))) {
                        d.this.dismiss();
                        return;
                    }
                    d.this.h();
                    d.super.d();
                    return;
                }
                throw null;
            }
        }

        /* compiled from: AppCompatSpinner */
        public class c implements OnDismissListener {

            /* renamed from: a reason: collision with root package name */
            public final /* synthetic */ OnGlobalLayoutListener f4479a;

            public c(OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f4479a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f4479a);
                }
            }
        }

        public d(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2, 0);
            this.r = w.this;
            a(true);
            this.p = 0;
            this.s = new a(w.this);
        }

        public CharSequence c() {
            return this.F;
        }

        public void h() {
            int i2;
            Drawable e2 = e();
            int i3 = 0;
            if (e2 != null) {
                e2.getPadding(w.this.f4468h);
                i3 = d1.a(w.this) ? w.this.f4468h.right : -w.this.f4468h.left;
            } else {
                Rect rect = w.this.f4468h;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = w.this.getPaddingLeft();
            int paddingRight = w.this.getPaddingRight();
            int width = w.this.getWidth();
            w wVar = w.this;
            int i4 = wVar.f4467g;
            if (i4 == -2) {
                int a2 = wVar.a((SpinnerAdapter) this.G, e());
                int i5 = w.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = w.this.f4468h;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (a2 > i6) {
                    a2 = i6;
                }
                d(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                d((width - paddingLeft) - paddingRight);
            } else {
                d(i4);
            }
            if (d1.a(w.this)) {
                i2 = (((width - paddingRight) - this.f4384e) - this.I) + i3;
            } else {
                i2 = paddingLeft + this.I + i3;
            }
            this.f4385f = i2;
        }

        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.G = listAdapter;
        }

        public void c(int i2) {
            this.I = i2;
        }

        public void a(CharSequence charSequence) {
            this.F = charSequence;
        }

        public void a(int i2, int i3) {
            boolean a2 = a();
            h();
            this.B.setInputMethodMode(2);
            super.d();
            f0 f0Var = this.f4382c;
            f0Var.setChoiceMode(1);
            f0Var.setTextDirection(i2);
            f0Var.setTextAlignment(i3);
            int selectedItemPosition = w.this.getSelectedItemPosition();
            f0 f0Var2 = this.f4382c;
            if (a() && f0Var2 != null) {
                f0Var2.setListSelectionHidden(false);
                f0Var2.setSelection(selectedItemPosition);
                if (f0Var2.getChoiceMode() != 0) {
                    f0Var2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!a2) {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    b bVar = new b();
                    viewTreeObserver.addOnGlobalLayoutListener(bVar);
                    this.B.setOnDismissListener(new c(bVar));
                }
            }
        }
    }

    /* compiled from: AppCompatSpinner */
    public static class e extends BaseSavedState {
        public static final Creator<e> CREATOR = new a();

        /* renamed from: a reason: collision with root package name */
        public boolean f4481a;

        /* compiled from: AppCompatSpinner */
        public static class a implements Creator<e> {
            public Object createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            public Object[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f4481a ? (byte) 1 : 0);
        }

        public e(Parcel parcel) {
            super(parcel);
            this.f4481a = parcel.readByte() != 0;
        }
    }

    /* compiled from: AppCompatSpinner */
    public interface f {
        void a(int i2);

        void a(int i2, int i3);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        boolean a();

        int b();

        void b(int i2);

        CharSequence c();

        void c(int i2);

        void dismiss();

        Drawable e();

        int g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        if (r4 != null) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.f4468h = r0
            int[] r0 = d.b.j.Spinner
            r1 = 0
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r10, r0, r11, r1)
            d.b.p.e r2 = new d.b.p.e
            r2.<init>(r8)
            r8.f4461a = r2
            int r2 = d.b.j.Spinner_popupTheme
            int r2 = r0.getResourceId(r2, r1)
            if (r2 == 0) goto L_0x0028
            d.b.o.c r3 = new d.b.o.c
            r3.<init>(r9, r2)
            r8.f4462b = r3
            goto L_0x002a
        L_0x0028:
            r8.f4462b = r9
        L_0x002a:
            r2 = 0
            r3 = -1
            int[] r4 = f4460i     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            android.content.res.TypedArray r4 = r9.obtainStyledAttributes(r10, r4, r11, r1)     // Catch:{ Exception -> 0x0046, all -> 0x0043 }
            boolean r5 = r4.hasValue(r1)     // Catch:{ Exception -> 0x0041 }
            if (r5 == 0) goto L_0x0052
            int r3 = r4.getInt(r1, r1)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0052
        L_0x003d:
            r9 = move-exception
            r2 = r4
            goto L_0x00d1
        L_0x0041:
            r5 = move-exception
            goto L_0x0049
        L_0x0043:
            r9 = move-exception
            goto L_0x00d1
        L_0x0046:
            r4 = move-exception
            r5 = r4
            r4 = r2
        L_0x0049:
            java.lang.String r6 = "AppCompatSpinner"
            java.lang.String r7 = "Could not read android:spinnerMode"
            android.util.Log.i(r6, r7, r5)     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x0055
        L_0x0052:
            r4.recycle()
        L_0x0055:
            r4 = 1
            if (r3 == 0) goto L_0x0095
            if (r3 == r4) goto L_0x005b
            goto L_0x00a5
        L_0x005b:
            d.b.p.w$d r3 = new d.b.p.w$d
            android.content.Context r5 = r8.f4462b
            r3.<init>(r5, r10, r11)
            android.content.Context r5 = r8.f4462b
            int[] r6 = d.b.j.Spinner
            d.b.p.x0 r1 = d.b.p.x0.a(r5, r10, r6, r11, r1)
            int r5 = d.b.j.Spinner_android_dropDownWidth
            r6 = -2
            int r5 = r1.e(r5, r6)
            r8.f4467g = r5
            int r5 = d.b.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r5 = r1.b(r5)
            android.widget.PopupWindow r6 = r3.B
            r6.setBackgroundDrawable(r5)
            int r5 = d.b.j.Spinner_android_prompt
            java.lang.String r5 = r0.getString(r5)
            r3.F = r5
            android.content.res.TypedArray r1 = r1.f4485b
            r1.recycle()
            r8.f4466f = r3
            d.b.p.v r1 = new d.b.p.v
            r1.<init>(r8, r8, r3)
            r8.f4463c = r1
            goto L_0x00a5
        L_0x0095:
            d.b.p.w$b r1 = new d.b.p.w$b
            r1.<init>()
            r8.f4466f = r1
            int r3 = d.b.j.Spinner_android_prompt
            java.lang.String r3 = r0.getString(r3)
            r1.a(r3)
        L_0x00a5:
            int r1 = d.b.j.Spinner_android_entries
            java.lang.CharSequence[] r1 = r0.getTextArray(r1)
            if (r1 == 0) goto L_0x00bd
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r5 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r9, r5, r1)
            int r9 = d.b.g.support_simple_spinner_dropdown_item
            r3.setDropDownViewResource(r9)
            r8.setAdapter(r3)
        L_0x00bd:
            r0.recycle()
            r8.f4465e = r4
            android.widget.SpinnerAdapter r9 = r8.f4464d
            if (r9 == 0) goto L_0x00cb
            r8.setAdapter(r9)
            r8.f4464d = r2
        L_0x00cb:
            d.b.p.e r9 = r8.f4461a
            r9.a(r10, r11)
            return
        L_0x00d1:
            if (r2 == 0) goto L_0x00d6
            r2.recycle()
        L_0x00d6:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.w.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f4468h);
            Rect rect = this.f4468h;
            i3 += rect.left + rect.right;
        }
        return i3;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f4461a;
        if (eVar != null) {
            eVar.a();
        }
    }

    public int getDropDownHorizontalOffset() {
        f fVar = this.f4466f;
        if (fVar != null) {
            return fVar.b();
        }
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        f fVar = this.f4466f;
        if (fVar != null) {
            return fVar.g();
        }
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.f4466f != null) {
            return this.f4467g;
        }
        return super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.f4466f;
    }

    public Drawable getPopupBackground() {
        f fVar = this.f4466f;
        if (fVar != null) {
            return fVar.e();
        }
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f4462b;
    }

    public CharSequence getPrompt() {
        f fVar = this.f4466f;
        return fVar != null ? fVar.c() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f4461a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        e eVar = this.f4461a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.f4466f;
        if (fVar != null && fVar.a()) {
            this.f4466f.dismiss();
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f4466f != null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        if (eVar.f4481a) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new a());
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        f fVar = this.f4466f;
        eVar.f4481a = fVar != null && fVar.a();
        return eVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var = this.f4463c;
        if (h0Var == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        f fVar = this.f4466f;
        if (fVar == null) {
            return super.performClick();
        }
        if (!fVar.a()) {
            a();
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f4461a;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        e eVar = this.f4461a;
        if (eVar != null) {
            eVar.a(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        f fVar = this.f4466f;
        if (fVar != null) {
            fVar.c(i2);
            this.f4466f.a(i2);
            return;
        }
        super.setDropDownHorizontalOffset(i2);
    }

    public void setDropDownVerticalOffset(int i2) {
        f fVar = this.f4466f;
        if (fVar != null) {
            fVar.b(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.f4466f != null) {
            this.f4467g = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.f4466f;
        if (fVar != null) {
            fVar.a(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(d.b.l.a.a.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        f fVar = this.f4466f;
        if (fVar != null) {
            fVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f4461a;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        e eVar = this.f4461a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f4465e) {
            this.f4464d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f4466f != null) {
            Context context = this.f4462b;
            if (context == null) {
                context = getContext();
            }
            this.f4466f.a((ListAdapter) new c(spinnerAdapter, context.getTheme()));
        }
    }

    public void a() {
        this.f4466f.a(getTextDirection(), getTextAlignment());
    }
}
