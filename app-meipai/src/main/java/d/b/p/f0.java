package d.b.p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidubce.auth.NTLMEngineImpl;
import d.h.k.r;
import d.h.l.c;
import java.lang.reflect.Field;

/* compiled from: DropDownListView */
public class f0 extends ListView {

    /* renamed from: a reason: collision with root package name */
    public final Rect f4321a = new Rect();

    /* renamed from: b reason: collision with root package name */
    public int f4322b = 0;

    /* renamed from: c reason: collision with root package name */
    public int f4323c = 0;

    /* renamed from: d reason: collision with root package name */
    public int f4324d = 0;

    /* renamed from: e reason: collision with root package name */
    public int f4325e = 0;

    /* renamed from: f reason: collision with root package name */
    public int f4326f;

    /* renamed from: g reason: collision with root package name */
    public Field f4327g;

    /* renamed from: h reason: collision with root package name */
    public a f4328h;

    /* renamed from: i reason: collision with root package name */
    public boolean f4329i;

    /* renamed from: j reason: collision with root package name */
    public boolean f4330j;
    public boolean k;
    public r l;
    public c m;
    public b n;

    /* compiled from: DropDownListView */
    public static class a extends d.b.m.a.c {

        /* renamed from: b reason: collision with root package name */
        public boolean f4331b = true;

        public a(Drawable drawable) {
            super(drawable);
        }

        public void draw(Canvas canvas) {
            if (this.f4331b) {
                this.f4093a.draw(canvas);
            }
        }

        public void setHotspot(float f2, float f3) {
            if (this.f4331b) {
                this.f4093a.setHotspot(f2, f3);
            }
        }

        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f4331b) {
                this.f4093a.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f4331b) {
                return this.f4093a.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f4331b) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            f0 f0Var = f0.this;
            f0Var.n = null;
            f0Var.drawableStateChanged();
        }
    }

    public f0(Context context, boolean z) {
        super(context, null, d.b.a.dropDownListViewStyle);
        this.f4330j = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f4327g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.f4328h;
        if (aVar != null) {
            aVar.f4331b = z;
        }
    }

    public int a(int i2, int i3, int i4) {
        int i5;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i7 = 0;
        int i8 = 0;
        View view = null;
        for (int i9 = 0; i9 < count; i9++) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i10 = layoutParams.height;
            if (i10 > 0) {
                i5 = MeasureSpec.makeMeasureSpec(i10, NTLMEngineImpl.FLAG_REQUEST_EXPLICIT_KEY_EXCH);
            } else {
                i5 = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i2, i5);
            view.forceLayout();
            if (i9 > 0) {
                i6 += dividerHeight;
            }
            i6 += view.getMeasuredHeight();
            if (i6 >= i3) {
                if (i4 >= 0 && i9 > i4 && i8 > 0 && i6 != i3) {
                    i3 = i8;
                }
                return i3;
            }
            if (i4 >= 0 && i9 >= i4) {
                i8 = i6;
            }
        }
        return i6;
    }

    public void dispatchDraw(Canvas canvas) {
        if (!this.f4321a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f4321a);
                selector.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    public void drawableStateChanged() {
        if (this.n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            a();
        }
    }

    public boolean hasFocus() {
        return this.f4330j || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f4330j || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f4330j || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f4330j && this.f4329i) || super.isInTouchMode();
    }

    public void onDetachedFromWindow() {
        this.n = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.n == null) {
            b bVar = new b();
            this.n = bVar;
            f0.this.post(bVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                a();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f4326f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.n;
        if (bVar != null) {
            f0 f0Var = f0.this;
            f0Var.n = null;
            f0Var.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f4329i = z;
    }

    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f4328h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f4322b = rect.left;
        this.f4323c = rect.top;
        this.f4324d = rect.right;
        this.f4325e = rect.bottom;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0164  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            int r3 = r17.getActionMasked()
            r4 = 1
            r5 = 0
            if (r3 == r4) goto L_0x0018
            r0 = 2
            if (r3 == r0) goto L_0x0016
            r0 = 3
            if (r3 == r0) goto L_0x001f
            r0 = r4
            r4 = r5
            goto L_0x0126
        L_0x0016:
            r0 = r4
            goto L_0x0019
        L_0x0018:
            r0 = r5
        L_0x0019:
            int r6 = r17.findPointerIndex(r18)
            if (r6 >= 0) goto L_0x0023
        L_0x001f:
            r0 = r5
            r4 = r0
            goto L_0x0126
        L_0x0023:
            float r7 = r2.getX(r6)
            int r7 = (int) r7
            float r6 = r2.getY(r6)
            int r6 = (int) r6
            int r8 = r1.pointToPosition(r7, r6)
            r9 = -1
            if (r8 != r9) goto L_0x0036
            goto L_0x0126
        L_0x0036:
            int r0 = r16.getFirstVisiblePosition()
            int r0 = r8 - r0
            android.view.View r10 = r1.getChildAt(r0)
            float r7 = (float) r7
            float r6 = (float) r6
            r1.k = r4
            r1.drawableHotspotChanged(r7, r6)
            boolean r0 = r16.isPressed()
            if (r0 != 0) goto L_0x0050
            r1.setPressed(r4)
        L_0x0050:
            r16.layoutChildren()
            int r0 = r1.f4326f
            if (r0 == r9) goto L_0x006d
            int r11 = r16.getFirstVisiblePosition()
            int r0 = r0 - r11
            android.view.View r0 = r1.getChildAt(r0)
            if (r0 == 0) goto L_0x006d
            if (r0 == r10) goto L_0x006d
            boolean r11 = r0.isPressed()
            if (r11 == 0) goto L_0x006d
            r0.setPressed(r5)
        L_0x006d:
            r1.f4326f = r8
            int r0 = r10.getLeft()
            float r0 = (float) r0
            float r0 = r7 - r0
            int r11 = r10.getTop()
            float r11 = (float) r11
            float r11 = r6 - r11
            r10.drawableHotspotChanged(r0, r11)
            boolean r0 = r10.isPressed()
            if (r0 != 0) goto L_0x0089
            r10.setPressed(r4)
        L_0x0089:
            android.graphics.drawable.Drawable r11 = r16.getSelector()
            if (r11 == 0) goto L_0x0093
            if (r8 == r9) goto L_0x0093
            r12 = r4
            goto L_0x0094
        L_0x0093:
            r12 = r5
        L_0x0094:
            if (r12 == 0) goto L_0x0099
            r11.setVisible(r5, r5)
        L_0x0099:
            android.graphics.Rect r0 = r1.f4321a
            int r13 = r10.getLeft()
            int r14 = r10.getTop()
            int r15 = r10.getRight()
            int r4 = r10.getBottom()
            r0.set(r13, r14, r15, r4)
            int r4 = r0.left
            int r13 = r1.f4322b
            int r4 = r4 - r13
            r0.left = r4
            int r4 = r0.top
            int r13 = r1.f4323c
            int r4 = r4 - r13
            r0.top = r4
            int r4 = r0.right
            int r13 = r1.f4324d
            int r4 = r4 + r13
            r0.right = r4
            int r4 = r0.bottom
            int r13 = r1.f4325e
            int r4 = r4 + r13
            r0.bottom = r4
            java.lang.reflect.Field r0 = r1.f4327g     // Catch:{ IllegalAccessException -> 0x00ea }
            boolean r0 = r0.getBoolean(r1)     // Catch:{ IllegalAccessException -> 0x00ea }
            boolean r4 = r10.isEnabled()     // Catch:{ IllegalAccessException -> 0x00ea }
            if (r4 == r0) goto L_0x00ee
            java.lang.reflect.Field r4 = r1.f4327g     // Catch:{ IllegalAccessException -> 0x00ea }
            if (r0 != 0) goto L_0x00dc
            r0 = 1
            goto L_0x00dd
        L_0x00dc:
            r0 = r5
        L_0x00dd:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ IllegalAccessException -> 0x00ea }
            r4.set(r1, r0)     // Catch:{ IllegalAccessException -> 0x00ea }
            if (r8 == r9) goto L_0x00ee
            r16.refreshDrawableState()     // Catch:{ IllegalAccessException -> 0x00ea }
            goto L_0x00ee
        L_0x00ea:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ee:
            if (r12 == 0) goto L_0x0109
            android.graphics.Rect r0 = r1.f4321a
            float r4 = r0.exactCenterX()
            float r0 = r0.exactCenterY()
            int r12 = r16.getVisibility()
            if (r12 != 0) goto L_0x0102
            r12 = 1
            goto L_0x0103
        L_0x0102:
            r12 = r5
        L_0x0103:
            r11.setVisible(r12, r5)
            r11.setHotspot(r4, r0)
        L_0x0109:
            android.graphics.drawable.Drawable r0 = r16.getSelector()
            if (r0 == 0) goto L_0x0114
            if (r8 == r9) goto L_0x0114
            r0.setHotspot(r7, r6)
        L_0x0114:
            r1.setSelectorEnabled(r5)
            r16.refreshDrawableState()
            r4 = 1
            if (r3 != r4) goto L_0x0124
            long r3 = r1.getItemIdAtPosition(r8)
            r1.performItemClick(r10, r8, r3)
        L_0x0124:
            r4 = r5
            r0 = 1
        L_0x0126:
            if (r0 == 0) goto L_0x012a
            if (r4 == 0) goto L_0x014c
        L_0x012a:
            r1.k = r5
            r1.setPressed(r5)
            r16.drawableStateChanged()
            int r3 = r1.f4326f
            int r4 = r16.getFirstVisiblePosition()
            int r3 = r3 - r4
            android.view.View r3 = r1.getChildAt(r3)
            if (r3 == 0) goto L_0x0142
            r3.setPressed(r5)
        L_0x0142:
            d.h.k.r r3 = r1.l
            if (r3 == 0) goto L_0x014c
            r3.a()
            r3 = 0
            r1.l = r3
        L_0x014c:
            if (r0 == 0) goto L_0x0164
            d.h.l.c r3 = r1.m
            if (r3 != 0) goto L_0x0159
            d.h.l.c r3 = new d.h.l.c
            r3.<init>(r1)
            r1.m = r3
        L_0x0159:
            d.h.l.c r3 = r1.m
            boolean r4 = r3.p
            r5 = 1
            r3.p = r5
            r3.onTouch(r1, r2)
            goto L_0x0171
        L_0x0164:
            d.h.l.c r2 = r1.m
            if (r2 == 0) goto L_0x0171
            boolean r3 = r2.p
            if (r3 == 0) goto L_0x016f
            r2.a()
        L_0x016f:
            r2.p = r5
        L_0x0171:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.p.f0.a(android.view.MotionEvent, int):boolean");
    }

    public final void a() {
        Drawable selector = getSelector();
        if (selector != null && this.k && isPressed()) {
            selector.setState(getDrawableState());
        }
    }
}
