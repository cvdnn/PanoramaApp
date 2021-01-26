package d.h.i;

import android.os.Build.VERSION;
import android.text.PrecomputedText.Params;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Objects;

/* compiled from: PrecomputedTextCompat */
public class b implements Spannable {

    /* compiled from: PrecomputedTextCompat */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        public final TextPaint f4886a;

        /* renamed from: b reason: collision with root package name */
        public final TextDirectionHeuristic f4887b;

        /* renamed from: c reason: collision with root package name */
        public final int f4888c;

        /* renamed from: d reason: collision with root package name */
        public final int f4889d;

        /* renamed from: e reason: collision with root package name */
        public final Params f4890e = null;

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            this.f4886a = textPaint;
            this.f4887b = textDirectionHeuristic;
            this.f4888c = i2;
            this.f4889d = i3;
        }

        public boolean a(a aVar) {
            Params params = this.f4890e;
            if (params != null) {
                return params.equals(aVar.f4890e);
            }
            if (this.f4888c != aVar.f4888c || this.f4889d != aVar.f4889d || this.f4886a.getTextSize() != aVar.f4886a.getTextSize() || this.f4886a.getTextScaleX() != aVar.f4886a.getTextScaleX() || this.f4886a.getTextSkewX() != aVar.f4886a.getTextSkewX() || this.f4886a.getLetterSpacing() != aVar.f4886a.getLetterSpacing() || !TextUtils.equals(this.f4886a.getFontFeatureSettings(), aVar.f4886a.getFontFeatureSettings()) || this.f4886a.getFlags() != aVar.f4886a.getFlags()) {
                return false;
            }
            if (VERSION.SDK_INT >= 24) {
                if (!this.f4886a.getTextLocales().equals(aVar.f4886a.getTextLocales())) {
                    return false;
                }
            } else if (!this.f4886a.getTextLocale().equals(aVar.f4886a.getTextLocale())) {
                return false;
            }
            if (this.f4886a.getTypeface() == null) {
                if (aVar.f4886a.getTypeface() != null) {
                    return false;
                }
            } else if (!this.f4886a.getTypeface().equals(aVar.f4886a.getTypeface())) {
                return false;
            }
            return true;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f4887b == aVar.f4887b;
        }

        public int hashCode() {
            if (VERSION.SDK_INT >= 24) {
                return Objects.hash(new Object[]{Float.valueOf(this.f4886a.getTextSize()), Float.valueOf(this.f4886a.getTextScaleX()), Float.valueOf(this.f4886a.getTextSkewX()), Float.valueOf(this.f4886a.getLetterSpacing()), Integer.valueOf(this.f4886a.getFlags()), this.f4886a.getTextLocales(), this.f4886a.getTypeface(), Boolean.valueOf(this.f4886a.isElegantTextHeight()), this.f4887b, Integer.valueOf(this.f4888c), Integer.valueOf(this.f4889d)});
            }
            return Objects.hash(new Object[]{Float.valueOf(this.f4886a.getTextSize()), Float.valueOf(this.f4886a.getTextScaleX()), Float.valueOf(this.f4886a.getTextSkewX()), Float.valueOf(this.f4886a.getLetterSpacing()), Integer.valueOf(this.f4886a.getFlags()), this.f4886a.getTextLocale(), this.f4886a.getTypeface(), Boolean.valueOf(this.f4886a.isElegantTextHeight()), this.f4887b, Integer.valueOf(this.f4888c), Integer.valueOf(this.f4889d)});
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder a2 = e.a.a.a.a.a("textSize=");
            a2.append(this.f4886a.getTextSize());
            sb.append(a2.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", textScaleX=");
            sb2.append(this.f4886a.getTextScaleX());
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(", textSkewX=");
            sb3.append(this.f4886a.getTextSkewX());
            sb.append(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(", letterSpacing=");
            sb4.append(this.f4886a.getLetterSpacing());
            sb.append(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(", elegantTextHeight=");
            sb5.append(this.f4886a.isElegantTextHeight());
            sb.append(sb5.toString());
            String str = ", textLocale=";
            if (VERSION.SDK_INT >= 24) {
                StringBuilder a3 = e.a.a.a.a.a(str);
                a3.append(this.f4886a.getTextLocales());
                sb.append(a3.toString());
            } else {
                StringBuilder a4 = e.a.a.a.a.a(str);
                a4.append(this.f4886a.getTextLocale());
                sb.append(a4.toString());
            }
            StringBuilder a5 = e.a.a.a.a.a(", typeface=");
            a5.append(this.f4886a.getTypeface());
            sb.append(a5.toString());
            if (VERSION.SDK_INT >= 26) {
                StringBuilder a6 = e.a.a.a.a.a(", variationSettings=");
                a6.append(this.f4886a.getFontVariationSettings());
                sb.append(a6.toString());
            }
            StringBuilder a7 = e.a.a.a.a.a(", textDir=");
            a7.append(this.f4887b);
            sb.append(a7.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(", breakStrategy=");
            sb6.append(this.f4888c);
            sb.append(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(", hyphenationFrequency=");
            sb7.append(this.f4889d);
            sb.append(sb7.toString());
            sb.append("}");
            return sb.toString();
        }

        public a(Params params) {
            this.f4886a = params.getTextPaint();
            this.f4887b = params.getTextDirection();
            this.f4888c = params.getBreakStrategy();
            this.f4889d = params.getHyphenationFrequency();
        }
    }

    public char charAt(int i2) {
        throw null;
    }

    public int getSpanEnd(Object obj) {
        throw null;
    }

    public int getSpanFlags(Object obj) {
        throw null;
    }

    public int getSpanStart(Object obj) {
        throw null;
    }

    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        throw null;
    }

    public int length() {
        throw null;
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        throw null;
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        throw null;
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        throw null;
    }

    public CharSequence subSequence(int i2, int i3) {
        throw null;
    }

    public String toString() {
        throw null;
    }
}
