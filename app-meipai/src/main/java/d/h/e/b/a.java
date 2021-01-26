package d.h.e.b;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* compiled from: ComplexColorCompat */
public final class a {

    /* renamed from: a reason: collision with root package name */
    public final Shader f4789a;

    /* renamed from: b reason: collision with root package name */
    public final ColorStateList f4790b;

    /* renamed from: c reason: collision with root package name */
    public int f4791c;

    public a(Shader shader, ColorStateList colorStateList, int i2) {
        this.f4789a = shader;
        this.f4790b = colorStateList;
        this.f4791c = i2;
    }

    public boolean a() {
        return this.f4789a != null;
    }

    public boolean b() {
        if (this.f4789a == null) {
            ColorStateList colorStateList = this.f4790b;
            if (colorStateList != null && colorStateList.isStateful()) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int[] iArr) {
        if (b()) {
            ColorStateList colorStateList = this.f4790b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f4791c) {
                this.f4791c = colorForState;
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r17v0, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r4v11, types: [android.graphics.SweepGradient] */
    /* JADX WARNING: type inference failed for: r12v8, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: type inference failed for: r17v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r12v9, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x014f, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r1.toString());
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r17v2, types: [android.graphics.RadialGradient]
  assigns: [android.graphics.RadialGradient, android.graphics.LinearGradient]
  uses: [android.graphics.RadialGradient, android.graphics.Shader, android.graphics.LinearGradient]
  mth insns count: 197
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static d.h.e.b.a a(android.content.res.Resources r26, int r27, android.content.res.Resources.Theme r28) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r0 = r26
            r1 = r28
            android.content.res.XmlResourceParser r2 = r26.getXml(r27)
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r2)
        L_0x000c:
            int r4 = r2.next()
            r5 = 2
            r6 = 1
            if (r4 == r5) goto L_0x0017
            if (r4 == r6) goto L_0x0017
            goto L_0x000c
        L_0x0017:
            if (r4 != r5) goto L_0x0235
            java.lang.String r4 = r2.getName()
            r7 = -1
            int r8 = r4.hashCode()
            r9 = 89650992(0x557f730, float:1.01546526E-35)
            java.lang.String r10 = "gradient"
            r11 = 0
            if (r8 == r9) goto L_0x003a
            r9 = 1191572447(0x4705f3df, float:34291.87)
            if (r8 == r9) goto L_0x0030
            goto L_0x0041
        L_0x0030:
            java.lang.String r8 = "selector"
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto L_0x0041
            r7 = r11
            goto L_0x0041
        L_0x003a:
            boolean r8 = r4.equals(r10)
            if (r8 == 0) goto L_0x0041
            r7 = r6
        L_0x0041:
            if (r7 == 0) goto L_0x0226
            if (r7 != r6) goto L_0x0208
            java.lang.String r4 = r2.getName()
            boolean r7 = r4.equals(r10)
            if (r7 == 0) goto L_0x01ea
            int[] r4 = d.h.c.GradientColor
            android.content.res.TypedArray r4 = a.a.a.a.b.a.a(r0, r1, r3, r4)
            int r7 = d.h.c.GradientColor_android_startX
            r9 = 0
            java.lang.String r10 = "startX"
            float r13 = a.a.a.a.b.a.a(r4, r2, r10, r7, r9)
            int r7 = d.h.c.GradientColor_android_startY
            java.lang.String r10 = "startY"
            float r14 = a.a.a.a.b.a.a(r4, r2, r10, r7, r9)
            int r7 = d.h.c.GradientColor_android_endX
            java.lang.String r10 = "endX"
            float r15 = a.a.a.a.b.a.a(r4, r2, r10, r7, r9)
            int r7 = d.h.c.GradientColor_android_endY
            java.lang.String r10 = "endY"
            float r16 = a.a.a.a.b.a.a(r4, r2, r10, r7, r9)
            int r7 = d.h.c.GradientColor_android_centerX
            java.lang.String r10 = "centerX"
            float r7 = a.a.a.a.b.a.a(r4, r2, r10, r7, r9)
            int r10 = d.h.c.GradientColor_android_centerY
            java.lang.String r12 = "centerY"
            float r10 = a.a.a.a.b.a.a(r4, r2, r12, r10, r9)
            int r12 = d.h.c.GradientColor_android_type
            java.lang.String r8 = "type"
            int r8 = a.a.a.a.b.a.b(r4, r2, r8, r12, r11)
            int r12 = d.h.c.GradientColor_android_startColor
            java.lang.String r5 = "startColor"
            int r5 = a.a.a.a.b.a.a(r4, r2, r5, r12, r11)
            java.lang.String r12 = "centerColor"
            boolean r18 = a.a.a.a.b.a.a(r2, r12)
            int r6 = d.h.c.GradientColor_android_centerColor
            int r6 = a.a.a.a.b.a.a(r4, r2, r12, r6, r11)
            int r12 = d.h.c.GradientColor_android_endColor
            java.lang.String r9 = "endColor"
            int r9 = a.a.a.a.b.a.a(r4, r2, r9, r12, r11)
            int r12 = d.h.c.GradientColor_android_tileMode
            java.lang.String r0 = "tileMode"
            int r0 = a.a.a.a.b.a.b(r4, r2, r0, r12, r11)
            int r12 = d.h.c.GradientColor_android_gradientRadius
            java.lang.String r11 = "gradientRadius"
            r21 = r7
            r7 = 0
            float r11 = a.a.a.a.b.a.a(r4, r2, r11, r12, r7)
            r4.recycle()
            int r4 = r2.getDepth()
            r7 = 1
            int r4 = r4 + r7
            java.util.ArrayList r12 = new java.util.ArrayList
            r7 = 20
            r12.<init>(r7)
            r22 = r11
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>(r7)
            r7 = r26
            r23 = r10
        L_0x00d8:
            int r10 = r2.next()
            r24 = r15
            r15 = 1
            if (r10 == r15) goto L_0x0157
            int r15 = r2.getDepth()
            r25 = r14
            if (r15 >= r4) goto L_0x00ec
            r14 = 3
            if (r10 == r14) goto L_0x0159
        L_0x00ec:
            r14 = 2
            if (r10 == r14) goto L_0x00f0
            goto L_0x0152
        L_0x00f0:
            if (r15 > r4) goto L_0x0150
            java.lang.String r10 = r2.getName()
            java.lang.String r14 = "item"
            boolean r10 = r10.equals(r14)
            if (r10 != 0) goto L_0x00ff
            goto L_0x0152
        L_0x00ff:
            int[] r10 = d.h.c.GradientColorItem
            android.content.res.TypedArray r7 = a.a.a.a.b.a.a(r7, r1, r3, r10)
            int r10 = d.h.c.GradientColorItem_android_color
            boolean r10 = r7.hasValue(r10)
            int r14 = d.h.c.GradientColorItem_android_offset
            boolean r14 = r7.hasValue(r14)
            if (r10 == 0) goto L_0x0135
            if (r14 == 0) goto L_0x0135
            int r10 = d.h.c.GradientColorItem_android_color
            r14 = 0
            int r10 = r7.getColor(r10, r14)
            int r14 = d.h.c.GradientColorItem_android_offset
            r15 = 0
            float r14 = r7.getFloat(r14, r15)
            r7.recycle()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r11.add(r7)
            java.lang.Float r7 = java.lang.Float.valueOf(r14)
            r12.add(r7)
            goto L_0x0150
        L_0x0135:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r2.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0150:
            r7 = r26
        L_0x0152:
            r15 = r24
            r14 = r25
            goto L_0x00d8
        L_0x0157:
            r25 = r14
        L_0x0159:
            int r1 = r11.size()
            if (r1 <= 0) goto L_0x0165
            d.h.e.b.f r1 = new d.h.e.b.f
            r1.<init>(r11, r12)
            goto L_0x0166
        L_0x0165:
            r1 = 0
        L_0x0166:
            if (r1 == 0) goto L_0x016a
        L_0x0168:
            r2 = 1
            goto L_0x0178
        L_0x016a:
            if (r18 == 0) goto L_0x0172
            d.h.e.b.f r1 = new d.h.e.b.f
            r1.<init>(r5, r6, r9)
            goto L_0x0168
        L_0x0172:
            d.h.e.b.f r1 = new d.h.e.b.f
            r1.<init>(r5, r9)
            goto L_0x0168
        L_0x0178:
            if (r8 == r2) goto L_0x01ac
            r3 = 2
            if (r8 == r3) goto L_0x019e
            android.graphics.LinearGradient r4 = new android.graphics.LinearGradient
            int[] r5 = r1.f4802a
            float[] r1 = r1.f4803b
            if (r0 == r2) goto L_0x018d
            if (r0 == r3) goto L_0x018a
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.CLAMP
            goto L_0x018f
        L_0x018a:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.MIRROR
            goto L_0x018f
        L_0x018d:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.REPEAT
        L_0x018f:
            r19 = r0
            r12 = r4
            r14 = r25
            r15 = r24
            r17 = r5
            r18 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18, r19)
            goto L_0x01da
        L_0x019e:
            android.graphics.SweepGradient r4 = new android.graphics.SweepGradient
            int[] r0 = r1.f4802a
            float[] r1 = r1.f4803b
            r2 = r21
            r3 = r23
            r4.<init>(r2, r3, r0, r1)
            goto L_0x01da
        L_0x01ac:
            r2 = r21
            r3 = r23
            r4 = 0
            int r4 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x01e2
            android.graphics.RadialGradient r4 = new android.graphics.RadialGradient
            int[] r5 = r1.f4802a
            float[] r1 = r1.f4803b
            r6 = 1
            if (r0 == r6) goto L_0x01c7
            r6 = 2
            if (r0 == r6) goto L_0x01c4
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.CLAMP
            goto L_0x01c9
        L_0x01c4:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.MIRROR
            goto L_0x01c9
        L_0x01c7:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.REPEAT
        L_0x01c9:
            r23 = r0
            r17 = r4
            r18 = r2
            r19 = r3
            r20 = r22
            r21 = r5
            r22 = r1
            r17.<init>(r18, r19, r20, r21, r22, r23)
        L_0x01da:
            d.h.e.b.a r0 = new d.h.e.b.a
            r1 = 0
            r2 = 0
            r0.<init>(r4, r1, r2)
            return r0
        L_0x01e2:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r1 = "<gradient> tag requires 'gradientRadius' attribute with radial type"
            r0.<init>(r1)
            throw r0
        L_0x01ea:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r2.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": invalid gradient color tag "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0208:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r2.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": unsupported complex color tag "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0226:
            android.content.res.ColorStateList r0 = a.a.a.a.b.a.a(r0, r2, r3, r1)
            d.h.e.b.a r1 = new d.h.e.b.a
            int r2 = r0.getDefaultColor()
            r3 = 0
            r1.<init>(r3, r0, r2)
            return r1
        L_0x0235:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r1 = "No start tag found"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.h.e.b.a.a(android.content.res.Resources, int, android.content.res.Resources$Theme):d.h.e.b.a");
    }
}
