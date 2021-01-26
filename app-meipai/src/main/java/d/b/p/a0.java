package d.b.p;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper */
public class a0 {
    public static final RectF k = new RectF();
    public static ConcurrentHashMap<String, Method> l = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Field> m = new ConcurrentHashMap<>();

    /* renamed from: a reason: collision with root package name */
    public int f4268a = 0;

    /* renamed from: b reason: collision with root package name */
    public boolean f4269b = false;

    /* renamed from: c reason: collision with root package name */
    public float f4270c = -1.0f;

    /* renamed from: d reason: collision with root package name */
    public float f4271d = -1.0f;

    /* renamed from: e reason: collision with root package name */
    public float f4272e = -1.0f;

    /* renamed from: f reason: collision with root package name */
    public int[] f4273f = new int[0];

    /* renamed from: g reason: collision with root package name */
    public boolean f4274g = false;

    /* renamed from: h reason: collision with root package name */
    public TextPaint f4275h;

    /* renamed from: i reason: collision with root package name */
    public final TextView f4276i;

    /* renamed from: j reason: collision with root package name */
    public final Context f4277j;

    public a0(TextView textView) {
        this.f4276i = textView;
        this.f4277j = textView.getContext();
    }

    public final int[] a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    public final boolean b() {
        if (!d() || this.f4268a != 1) {
            this.f4269b = false;
        } else {
            if (!this.f4274g || this.f4273f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f4272e - this.f4271d) / this.f4270c))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round((((float) i2) * this.f4270c) + this.f4271d);
                }
                this.f4273f = a(iArr);
            }
            this.f4269b = true;
        }
        return this.f4269b;
    }

    public final boolean c() {
        int length = this.f4273f.length;
        boolean z = length > 0;
        this.f4274g = z;
        if (z) {
            this.f4268a = 1;
            int[] iArr = this.f4273f;
            this.f4271d = (float) iArr[0];
            this.f4272e = (float) iArr[length - 1];
            this.f4270c = -1.0f;
        }
        return this.f4274g;
    }

    public final boolean d() {
        return !(this.f4276i instanceof k);
    }

    public final void a(float f2, float f3, float f4) throws IllegalArgumentException {
        String str = "px) is less or equal to (0px)";
        if (f2 <= 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Minimum auto-size text size (");
            sb.append(f2);
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        } else if (f3 <= f2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Maximum auto-size text size (");
            sb2.append(f3);
            sb2.append("px) is less or equal to minimum auto-size text size (");
            sb2.append(f2);
            sb2.append("px)");
            throw new IllegalArgumentException(sb2.toString());
        } else if (f4 > 0.0f) {
            this.f4268a = 1;
            this.f4271d = f2;
            this.f4272e = f3;
            this.f4270c = f4;
            this.f4274g = false;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("The auto-size step granularity (");
            sb3.append(f4);
            sb3.append(str);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public void a(int i2, float f2) {
        Resources resources;
        Context context = this.f4277j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics());
        if (applyDimension != this.f4276i.getPaint().getTextSize()) {
            this.f4276i.getPaint().setTextSize(applyDimension);
            boolean isInLayout = this.f4276i.isInLayout();
            if (this.f4276i.getLayout() != null) {
                this.f4269b = false;
                try {
                    Method a2 = a("nullLayouts");
                    if (a2 != null) {
                        a2.invoke(this.f4276i, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f4276i.requestLayout();
                } else {
                    this.f4276i.forceLayout();
                }
                this.f4276i.invalidate();
            }
        }
    }

    public final int a(RectF rectF) {
        TextDirectionHeuristic textDirectionHeuristic;
        int length = this.f4273f.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                int i6 = this.f4273f[i5];
                CharSequence text = this.f4276i.getText();
                TransformationMethod transformationMethod = this.f4276i.getTransformationMethod();
                if (transformationMethod != null) {
                    CharSequence transformation = transformationMethod.getTransformation(text, this.f4276i);
                    if (transformation != null) {
                        text = transformation;
                    }
                }
                int maxLines = this.f4276i.getMaxLines();
                TextPaint textPaint = this.f4275h;
                if (textPaint == null) {
                    this.f4275h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f4275h.set(this.f4276i.getPaint());
                this.f4275h.setTextSize((float) i6);
                Alignment alignment = (Alignment) a((Object) this.f4276i, "getLayoutAlignment", (T) Alignment.ALIGN_NORMAL);
                Builder obtain = Builder.obtain(text, 0, text.length(), this.f4275h, Math.round(rectF.right));
                obtain.setAlignment(alignment).setLineSpacing(this.f4276i.getLineSpacingExtra(), this.f4276i.getLineSpacingMultiplier()).setIncludePad(this.f4276i.getIncludeFontPadding()).setBreakStrategy(this.f4276i.getBreakStrategy()).setHyphenationFrequency(this.f4276i.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
                try {
                    if (VERSION.SDK_INT >= 29) {
                        textDirectionHeuristic = this.f4276i.getTextDirectionHeuristic();
                    } else {
                        textDirectionHeuristic = (TextDirectionHeuristic) a((Object) this.f4276i, "getTextDirectionHeuristic", (T) TextDirectionHeuristics.FIRSTSTRONG_LTR);
                    }
                    obtain.setTextDirection(textDirectionHeuristic);
                } catch (ClassCastException unused) {
                    Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
                }
                StaticLayout build = obtain.build();
                if ((maxLines == -1 || (build.getLineCount() <= maxLines && build.getLineEnd(build.getLineCount() - 1) == text.length())) && ((float) build.getHeight()) <= rectF.bottom) {
                    int i7 = i5 + 1;
                    i4 = i3;
                    i3 = i7;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f4273f[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public static <T> T a(Object obj, String str, T t) {
        try {
            return a(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            String str2 = "ACTVAutoSizeHelper";
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(str);
            sb.append("() method");
            Log.w(str2, sb.toString(), e2);
            return t;
        }
    }

    public static Method a(String str) {
        try {
            Method method = (Method) l.get(str);
            if (method == null) {
                method = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    l.put(str, method);
                }
            }
            return method;
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            Log.w("ACTVAutoSizeHelper", sb.toString(), e2);
            return null;
        }
    }

    public void a() {
        boolean z;
        int i2;
        if (d() && this.f4268a != 0) {
            if (this.f4269b) {
                if (this.f4276i.getMeasuredHeight() > 0 && this.f4276i.getMeasuredWidth() > 0) {
                    if (VERSION.SDK_INT >= 29) {
                        z = this.f4276i.isHorizontallyScrollable();
                    } else {
                        z = ((Boolean) a((Object) this.f4276i, "getHorizontallyScrolling", (T) Boolean.valueOf(false))).booleanValue();
                    }
                    if (z) {
                        i2 = 1048576;
                    } else {
                        i2 = (this.f4276i.getMeasuredWidth() - this.f4276i.getTotalPaddingLeft()) - this.f4276i.getTotalPaddingRight();
                    }
                    int height = (this.f4276i.getHeight() - this.f4276i.getCompoundPaddingBottom()) - this.f4276i.getCompoundPaddingTop();
                    if (i2 > 0 && height > 0) {
                        synchronized (k) {
                            k.setEmpty();
                            k.right = (float) i2;
                            k.bottom = (float) height;
                            float a2 = (float) a(k);
                            if (a2 != this.f4276i.getTextSize()) {
                                a(0, a2);
                            }
                        }
                    }
                }
                return;
            }
            this.f4269b = true;
        }
    }
}
