package d.u.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat */
public class g extends f {

    /* renamed from: j reason: collision with root package name */
    public static final Mode f5551j = Mode.SRC_IN;

    /* renamed from: b reason: collision with root package name */
    public h f5552b;

    /* renamed from: c reason: collision with root package name */
    public PorterDuffColorFilter f5553c;

    /* renamed from: d reason: collision with root package name */
    public ColorFilter f5554d;

    /* renamed from: e reason: collision with root package name */
    public boolean f5555e;

    /* renamed from: f reason: collision with root package name */
    public boolean f5556f;

    /* renamed from: g reason: collision with root package name */
    public final float[] f5557g;

    /* renamed from: h reason: collision with root package name */
    public final Matrix f5558h;

    /* renamed from: i reason: collision with root package name */
    public final Rect f5559i;

    /* compiled from: VectorDrawableCompat */
    public static class b extends f {
        public b() {
        }

        public boolean b() {
            return true;
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    /* compiled from: VectorDrawableCompat */
    public static class c extends f {

        /* renamed from: e reason: collision with root package name */
        public int[] f5560e;

        /* renamed from: f reason: collision with root package name */
        public d.h.e.b.a f5561f;

        /* renamed from: g reason: collision with root package name */
        public float f5562g = 0.0f;

        /* renamed from: h reason: collision with root package name */
        public d.h.e.b.a f5563h;

        /* renamed from: i reason: collision with root package name */
        public float f5564i = 1.0f;

        /* renamed from: j reason: collision with root package name */
        public float f5565j = 1.0f;
        public float k = 0.0f;
        public float l = 1.0f;
        public float m = 0.0f;
        public Cap n = Cap.BUTT;
        public Join o = Join.MITER;
        public float p = 4.0f;

        public c() {
        }

        public boolean a() {
            return this.f5563h.b() || this.f5561f.b();
        }

        public float getFillAlpha() {
            return this.f5565j;
        }

        public int getFillColor() {
            return this.f5563h.f4791c;
        }

        public float getStrokeAlpha() {
            return this.f5564i;
        }

        public int getStrokeColor() {
            return this.f5561f.f4791c;
        }

        public float getStrokeWidth() {
            return this.f5562g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f2) {
            this.f5565j = f2;
        }

        public void setFillColor(int i2) {
            this.f5563h.f4791c = i2;
        }

        public void setStrokeAlpha(float f2) {
            this.f5564i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f5561f.f4791c = i2;
        }

        public void setStrokeWidth(float f2) {
            this.f5562g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.k = f2;
        }

        public boolean a(int[] iArr) {
            return this.f5561f.a(iArr) | this.f5563h.a(iArr);
        }

        public c(c cVar) {
            super(cVar);
            this.f5560e = cVar.f5560e;
            this.f5561f = cVar.f5561f;
            this.f5562g = cVar.f5562g;
            this.f5564i = cVar.f5564i;
            this.f5563h = cVar.f5563h;
            this.f5578c = cVar.f5578c;
            this.f5565j = cVar.f5565j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }
    }

    /* compiled from: VectorDrawableCompat */
    public static class d extends e {

        /* renamed from: a reason: collision with root package name */
        public final Matrix f5566a = new Matrix();

        /* renamed from: b reason: collision with root package name */
        public final ArrayList<e> f5567b = new ArrayList<>();

        /* renamed from: c reason: collision with root package name */
        public float f5568c = 0.0f;

        /* renamed from: d reason: collision with root package name */
        public float f5569d = 0.0f;

        /* renamed from: e reason: collision with root package name */
        public float f5570e = 0.0f;

        /* renamed from: f reason: collision with root package name */
        public float f5571f = 1.0f;

        /* renamed from: g reason: collision with root package name */
        public float f5572g = 1.0f;

        /* renamed from: h reason: collision with root package name */
        public float f5573h = 0.0f;

        /* renamed from: i reason: collision with root package name */
        public float f5574i = 0.0f;

        /* renamed from: j reason: collision with root package name */
        public final Matrix f5575j = new Matrix();
        public int k;
        public int[] l;
        public String m = null;

        public d(d dVar, d.e.a<String, Object> aVar) {
            f fVar;
            super(null);
            this.f5568c = dVar.f5568c;
            this.f5569d = dVar.f5569d;
            this.f5570e = dVar.f5570e;
            this.f5571f = dVar.f5571f;
            this.f5572g = dVar.f5572g;
            this.f5573h = dVar.f5573h;
            this.f5574i = dVar.f5574i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f5575j.set(dVar.f5575j);
            ArrayList<e> arrayList = dVar.f5567b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Object obj = arrayList.get(i2);
                if (obj instanceof d) {
                    this.f5567b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        fVar = new c((c) obj);
                    } else if (obj instanceof b) {
                        fVar = new b((b) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f5567b.add(fVar);
                    String str2 = fVar.f5577b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.f5567b.size(); i2++) {
                if (((e) this.f5567b.get(i2)).a()) {
                    return true;
                }
            }
            return false;
        }

        public final void b() {
            this.f5575j.reset();
            this.f5575j.postTranslate(-this.f5569d, -this.f5570e);
            this.f5575j.postScale(this.f5571f, this.f5572g);
            this.f5575j.postRotate(this.f5568c, 0.0f, 0.0f);
            this.f5575j.postTranslate(this.f5573h + this.f5569d, this.f5574i + this.f5570e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f5575j;
        }

        public float getPivotX() {
            return this.f5569d;
        }

        public float getPivotY() {
            return this.f5570e;
        }

        public float getRotation() {
            return this.f5568c;
        }

        public float getScaleX() {
            return this.f5571f;
        }

        public float getScaleY() {
            return this.f5572g;
        }

        public float getTranslateX() {
            return this.f5573h;
        }

        public float getTranslateY() {
            return this.f5574i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f5569d) {
                this.f5569d = f2;
                b();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f5570e) {
                this.f5570e = f2;
                b();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f5568c) {
                this.f5568c = f2;
                b();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f5571f) {
                this.f5571f = f2;
                b();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f5572g) {
                this.f5572g = f2;
                b();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f5573h) {
                this.f5573h = f2;
                b();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f5574i) {
                this.f5574i = f2;
                b();
            }
        }

        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f5567b.size(); i2++) {
                z |= ((e) this.f5567b.get(i2)).a(iArr);
            }
            return z;
        }

        public d() {
            super(null);
        }
    }

    /* compiled from: VectorDrawableCompat */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }

        public /* synthetic */ e(a aVar) {
        }
    }

    /* compiled from: VectorDrawableCompat */
    public static abstract class f extends e {

        /* renamed from: a reason: collision with root package name */
        public d.h.f.b[] f5576a = null;

        /* renamed from: b reason: collision with root package name */
        public String f5577b;

        /* renamed from: c reason: collision with root package name */
        public int f5578c = 0;

        /* renamed from: d reason: collision with root package name */
        public int f5579d;

        public f() {
            super(null);
        }

        public boolean b() {
            return false;
        }

        public d.h.f.b[] getPathData() {
            return this.f5576a;
        }

        public String getPathName() {
            return this.f5577b;
        }

        public void setPathData(d.h.f.b[] bVarArr) {
            if (!a.a.a.a.b.a.a(this.f5576a, bVarArr)) {
                this.f5576a = a.a.a.a.b.a.a(bVarArr);
                return;
            }
            d.h.f.b[] bVarArr2 = this.f5576a;
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                bVarArr2[i2].f4808a = bVarArr[i2].f4808a;
                for (int i3 = 0; i3 < bVarArr[i2].f4809b.length; i3++) {
                    bVarArr2[i2].f4809b[i3] = bVarArr[i2].f4809b[i3];
                }
            }
        }

        public f(f fVar) {
            super(null);
            this.f5577b = fVar.f5577b;
            this.f5579d = fVar.f5579d;
            this.f5576a = a.a.a.a.b.a.a(fVar.f5576a);
        }
    }

    /* renamed from: d.u.a.a.g$g reason: collision with other inner class name */
    /* compiled from: VectorDrawableCompat */
    public static class C0060g {
        public static final Matrix q = new Matrix();

        /* renamed from: a reason: collision with root package name */
        public final Path f5580a;

        /* renamed from: b reason: collision with root package name */
        public final Path f5581b;

        /* renamed from: c reason: collision with root package name */
        public final Matrix f5582c;

        /* renamed from: d reason: collision with root package name */
        public Paint f5583d;

        /* renamed from: e reason: collision with root package name */
        public Paint f5584e;

        /* renamed from: f reason: collision with root package name */
        public PathMeasure f5585f;

        /* renamed from: g reason: collision with root package name */
        public int f5586g;

        /* renamed from: h reason: collision with root package name */
        public final d f5587h;

        /* renamed from: i reason: collision with root package name */
        public float f5588i;

        /* renamed from: j reason: collision with root package name */
        public float f5589j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final d.e.a<String, Object> p;

        public C0060g() {
            this.f5582c = new Matrix();
            this.f5588i = 0.0f;
            this.f5589j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new d.e.a<>();
            this.f5587h = new d();
            this.f5580a = new Path();
            this.f5581b = new Path();
        }

        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r11v1, types: [boolean] */
        /* JADX WARNING: type inference failed for: r11v2 */
        /* JADX WARNING: type inference failed for: r11v10 */
        /* JADX WARNING: type inference failed for: r11v11 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v1, types: [boolean]
  assigns: []
  uses: [?[int, short, byte, char], boolean]
  mth insns count: 240
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.util.ArrayList.forEach(ArrayList.java:1249)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(d.u.a.a.g.d r18, android.graphics.Matrix r19, android.graphics.Canvas r20, int r21, int r22, android.graphics.ColorFilter r23) {
            /*
                r17 = this;
                r7 = r17
                r8 = r18
                r9 = r20
                r10 = r23
                android.graphics.Matrix r0 = r8.f5566a
                r1 = r19
                r0.set(r1)
                android.graphics.Matrix r0 = r8.f5566a
                android.graphics.Matrix r1 = r8.f5575j
                r0.preConcat(r1)
                r20.save()
                r11 = 0
                r12 = r11
            L_0x001b:
                java.util.ArrayList<d.u.a.a.g$e> r0 = r8.f5567b
                int r0 = r0.size()
                if (r12 >= r0) goto L_0x0233
                java.util.ArrayList<d.u.a.a.g$e> r0 = r8.f5567b
                java.lang.Object r0 = r0.get(r12)
                d.u.a.a.g$e r0 = (d.u.a.a.g.e) r0
                boolean r1 = r0 instanceof d.u.a.a.g.d
                if (r1 == 0) goto L_0x0043
                r1 = r0
                d.u.a.a.g$d r1 = (d.u.a.a.g.d) r1
                android.graphics.Matrix r2 = r8.f5566a
                r0 = r17
                r3 = r20
                r4 = r21
                r5 = r22
                r6 = r23
                r0.a(r1, r2, r3, r4, r5, r6)
                goto L_0x0228
            L_0x0043:
                boolean r1 = r0 instanceof d.u.a.a.g.f
                if (r1 == 0) goto L_0x0228
                d.u.a.a.g$f r0 = (d.u.a.a.g.f) r0
                r1 = r21
                float r2 = (float) r1
                float r3 = r7.k
                float r2 = r2 / r3
                r3 = r22
                float r4 = (float) r3
                float r5 = r7.l
                float r4 = r4 / r5
                float r5 = java.lang.Math.min(r2, r4)
                android.graphics.Matrix r6 = r8.f5566a
                android.graphics.Matrix r13 = r7.f5582c
                r13.set(r6)
                android.graphics.Matrix r13 = r7.f5582c
                r13.postScale(r2, r4)
                r2 = 4
                float[] r2 = new float[r2]
                r2 = {0, 1065353216, 1065353216, 0} // fill-array
                r6.mapVectors(r2)
                r4 = r2[r11]
                double r13 = (double) r4
                r4 = 1
                r6 = r2[r4]
                r19 = r5
                double r4 = (double) r6
                double r4 = java.lang.Math.hypot(r13, r4)
                float r4 = (float) r4
                r5 = 2
                r6 = r2[r5]
                double r13 = (double) r6
                r6 = 3
                r15 = r2[r6]
                double r6 = (double) r15
                double r6 = java.lang.Math.hypot(r13, r6)
                float r6 = (float) r6
                r7 = r2[r11]
                r13 = 1
                r14 = r2[r13]
                r5 = r2[r5]
                r13 = 3
                r2 = r2[r13]
                float r7 = r7 * r2
                float r14 = r14 * r5
                float r7 = r7 - r14
                float r2 = java.lang.Math.max(r4, r6)
                r4 = 0
                int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r5 <= 0) goto L_0x00a5
                float r5 = java.lang.Math.abs(r7)
                float r5 = r5 / r2
                goto L_0x00a6
            L_0x00a5:
                r5 = r4
            L_0x00a6:
                int r2 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x00ae
                r2 = r17
                goto L_0x022d
            L_0x00ae:
                r2 = r17
                android.graphics.Path r6 = r2.f5580a
                if (r0 == 0) goto L_0x0226
                r6.reset()
                d.h.f.b[] r13 = r0.f5576a
                if (r13 == 0) goto L_0x00be
                d.h.f.b.a(r13, r6)
            L_0x00be:
                android.graphics.Path r6 = r2.f5580a
                android.graphics.Path r13 = r2.f5581b
                r13.reset()
                boolean r13 = r0.b()
                if (r13 == 0) goto L_0x00e7
                android.graphics.Path r4 = r2.f5581b
                int r0 = r0.f5578c
                if (r0 != 0) goto L_0x00d4
                android.graphics.Path$FillType r0 = android.graphics.Path.FillType.WINDING
                goto L_0x00d6
            L_0x00d4:
                android.graphics.Path$FillType r0 = android.graphics.Path.FillType.EVEN_ODD
            L_0x00d6:
                r4.setFillType(r0)
                android.graphics.Path r0 = r2.f5581b
                android.graphics.Matrix r4 = r2.f5582c
                r0.addPath(r6, r4)
                android.graphics.Path r0 = r2.f5581b
                r9.clipPath(r0)
                goto L_0x022d
            L_0x00e7:
                d.u.a.a.g$c r0 = (d.u.a.a.g.c) r0
                float r13 = r0.k
                int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
                r14 = 1065353216(0x3f800000, float:1.0)
                if (r13 != 0) goto L_0x00f7
                float r13 = r0.l
                int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
                if (r13 == 0) goto L_0x0137
            L_0x00f7:
                float r13 = r0.k
                float r15 = r0.m
                float r13 = r13 + r15
                float r13 = r13 % r14
                float r7 = r0.l
                float r7 = r7 + r15
                float r7 = r7 % r14
                android.graphics.PathMeasure r14 = r2.f5585f
                if (r14 != 0) goto L_0x010c
                android.graphics.PathMeasure r14 = new android.graphics.PathMeasure
                r14.<init>()
                r2.f5585f = r14
            L_0x010c:
                android.graphics.PathMeasure r14 = r2.f5585f
                android.graphics.Path r15 = r2.f5580a
                r14.setPath(r15, r11)
                android.graphics.PathMeasure r14 = r2.f5585f
                float r14 = r14.getLength()
                float r13 = r13 * r14
                float r7 = r7 * r14
                r6.reset()
                int r15 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r15 <= 0) goto L_0x012e
                android.graphics.PathMeasure r15 = r2.f5585f
                r11 = 1
                r15.getSegment(r13, r14, r6, r11)
                android.graphics.PathMeasure r13 = r2.f5585f
                r13.getSegment(r4, r7, r6, r11)
                goto L_0x0134
            L_0x012e:
                r11 = 1
                android.graphics.PathMeasure r14 = r2.f5585f
                r14.getSegment(r13, r7, r6, r11)
            L_0x0134:
                r6.rLineTo(r4, r4)
            L_0x0137:
                android.graphics.Path r4 = r2.f5581b
                android.graphics.Matrix r7 = r2.f5582c
                r4.addPath(r6, r7)
                d.h.e.b.a r4 = r0.f5563h
                boolean r6 = r4.a()
                if (r6 != 0) goto L_0x014d
                int r4 = r4.f4791c
                if (r4 == 0) goto L_0x014b
                goto L_0x014d
            L_0x014b:
                r4 = 0
                goto L_0x014e
            L_0x014d:
                r4 = 1
            L_0x014e:
                r6 = 1132396544(0x437f0000, float:255.0)
                r7 = 255(0xff, float:3.57E-43)
                if (r4 == 0) goto L_0x01ac
                d.h.e.b.a r4 = r0.f5563h
                android.graphics.Paint r11 = r2.f5584e
                if (r11 != 0) goto L_0x0167
                android.graphics.Paint r11 = new android.graphics.Paint
                r13 = 1
                r11.<init>(r13)
                r2.f5584e = r11
                android.graphics.Paint$Style r13 = android.graphics.Paint.Style.FILL
                r11.setStyle(r13)
            L_0x0167:
                android.graphics.Paint r11 = r2.f5584e
                boolean r13 = r4.a()
                if (r13 == 0) goto L_0x0184
                android.graphics.Shader r4 = r4.f4789a
                android.graphics.Matrix r13 = r2.f5582c
                r4.setLocalMatrix(r13)
                r11.setShader(r4)
                float r4 = r0.f5565j
                float r4 = r4 * r6
                int r4 = java.lang.Math.round(r4)
                r11.setAlpha(r4)
                goto L_0x0196
            L_0x0184:
                r13 = 0
                r11.setShader(r13)
                r11.setAlpha(r7)
                int r4 = r4.f4791c
                float r13 = r0.f5565j
                int r4 = d.u.a.a.g.a(r4, r13)
                r11.setColor(r4)
            L_0x0196:
                r11.setColorFilter(r10)
                android.graphics.Path r4 = r2.f5581b
                int r13 = r0.f5578c
                if (r13 != 0) goto L_0x01a2
                android.graphics.Path$FillType r13 = android.graphics.Path.FillType.WINDING
                goto L_0x01a4
            L_0x01a2:
                android.graphics.Path$FillType r13 = android.graphics.Path.FillType.EVEN_ODD
            L_0x01a4:
                r4.setFillType(r13)
                android.graphics.Path r4 = r2.f5581b
                r9.drawPath(r4, r11)
            L_0x01ac:
                d.h.e.b.a r4 = r0.f5561f
                boolean r11 = r4.a()
                if (r11 != 0) goto L_0x01bc
                int r4 = r4.f4791c
                if (r4 == 0) goto L_0x01b9
                goto L_0x01bc
            L_0x01b9:
                r16 = 0
                goto L_0x01be
            L_0x01bc:
                r16 = 1
            L_0x01be:
                if (r16 == 0) goto L_0x022d
                d.h.e.b.a r4 = r0.f5561f
                android.graphics.Paint r11 = r2.f5583d
                if (r11 != 0) goto L_0x01d3
                android.graphics.Paint r11 = new android.graphics.Paint
                r13 = 1
                r11.<init>(r13)
                r2.f5583d = r11
                android.graphics.Paint$Style r13 = android.graphics.Paint.Style.STROKE
                r11.setStyle(r13)
            L_0x01d3:
                android.graphics.Paint r11 = r2.f5583d
                android.graphics.Paint$Join r13 = r0.o
                if (r13 == 0) goto L_0x01dc
                r11.setStrokeJoin(r13)
            L_0x01dc:
                android.graphics.Paint$Cap r13 = r0.n
                if (r13 == 0) goto L_0x01e3
                r11.setStrokeCap(r13)
            L_0x01e3:
                float r13 = r0.p
                r11.setStrokeMiter(r13)
                boolean r13 = r4.a()
                if (r13 == 0) goto L_0x0203
                android.graphics.Shader r4 = r4.f4789a
                android.graphics.Matrix r7 = r2.f5582c
                r4.setLocalMatrix(r7)
                r11.setShader(r4)
                float r4 = r0.f5564i
                float r4 = r4 * r6
                int r4 = java.lang.Math.round(r4)
                r11.setAlpha(r4)
                goto L_0x0215
            L_0x0203:
                r6 = 0
                r11.setShader(r6)
                r11.setAlpha(r7)
                int r4 = r4.f4791c
                float r6 = r0.f5564i
                int r4 = d.u.a.a.g.a(r4, r6)
                r11.setColor(r4)
            L_0x0215:
                r11.setColorFilter(r10)
                float r5 = r5 * r19
                float r0 = r0.f5562g
                float r0 = r0 * r5
                r11.setStrokeWidth(r0)
                android.graphics.Path r0 = r2.f5581b
                r9.drawPath(r0, r11)
                goto L_0x022d
            L_0x0226:
                r0 = 0
                throw r0
            L_0x0228:
                r1 = r21
                r3 = r22
                r2 = r7
            L_0x022d:
                int r12 = r12 + 1
                r7 = r2
                r11 = 0
                goto L_0x001b
            L_0x0233:
                r2 = r7
                r20.restore()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.u.a.a.g.C0060g.a(d.u.a.a.g$d, android.graphics.Matrix, android.graphics.Canvas, int, int, android.graphics.ColorFilter):void");
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }

        public C0060g(C0060g gVar) {
            this.f5582c = new Matrix();
            this.f5588i = 0.0f;
            this.f5589j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            d.e.a<String, Object> aVar = new d.e.a<>();
            this.p = aVar;
            this.f5587h = new d(gVar.f5587h, aVar);
            this.f5580a = new Path(gVar.f5580a);
            this.f5581b = new Path(gVar.f5581b);
            this.f5588i = gVar.f5588i;
            this.f5589j = gVar.f5589j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.f5586g = gVar.f5586g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }
    }

    /* compiled from: VectorDrawableCompat */
    public static class h extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        public int f5590a;

        /* renamed from: b reason: collision with root package name */
        public C0060g f5591b;

        /* renamed from: c reason: collision with root package name */
        public ColorStateList f5592c;

        /* renamed from: d reason: collision with root package name */
        public Mode f5593d;

        /* renamed from: e reason: collision with root package name */
        public boolean f5594e;

        /* renamed from: f reason: collision with root package name */
        public Bitmap f5595f;

        /* renamed from: g reason: collision with root package name */
        public ColorStateList f5596g;

        /* renamed from: h reason: collision with root package name */
        public Mode f5597h;

        /* renamed from: i reason: collision with root package name */
        public int f5598i;

        /* renamed from: j reason: collision with root package name */
        public boolean f5599j;
        public boolean k;
        public Paint l;

        public h(h hVar) {
            this.f5592c = null;
            this.f5593d = g.f5551j;
            if (hVar != null) {
                this.f5590a = hVar.f5590a;
                C0060g gVar = new C0060g(hVar.f5591b);
                this.f5591b = gVar;
                if (hVar.f5591b.f5584e != null) {
                    gVar.f5584e = new Paint(hVar.f5591b.f5584e);
                }
                if (hVar.f5591b.f5583d != null) {
                    this.f5591b.f5583d = new Paint(hVar.f5591b.f5583d);
                }
                this.f5592c = hVar.f5592c;
                this.f5593d = hVar.f5593d;
                this.f5594e = hVar.f5594e;
            }
        }

        public void a(int i2, int i3) {
            this.f5595f.eraseColor(0);
            Canvas canvas = new Canvas(this.f5595f);
            C0060g gVar = this.f5591b;
            gVar.a(gVar.f5587h, C0060g.q, canvas, i2, i3, null);
        }

        public int getChangingConfigurations() {
            return this.f5590a;
        }

        public Drawable newDrawable() {
            return new g(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }

        public boolean a() {
            C0060g gVar = this.f5591b;
            if (gVar.o == null) {
                gVar.o = Boolean.valueOf(gVar.f5587h.a());
            }
            return gVar.o.booleanValue();
        }

        public h() {
            this.f5592c = null;
            this.f5593d = g.f5551j;
            this.f5591b = new C0060g();
        }
    }

    /* compiled from: VectorDrawableCompat */
    public static class i extends ConstantState {

        /* renamed from: a reason: collision with root package name */
        public final ConstantState f5600a;

        public i(ConstantState constantState) {
            this.f5600a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f5600a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f5600a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            g gVar = new g();
            gVar.f5550a = (VectorDrawable) this.f5600a.newDrawable();
            return gVar;
        }

        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.f5550a = (VectorDrawable) this.f5600a.newDrawable(resources);
            return gVar;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            g gVar = new g();
            gVar.f5550a = (VectorDrawable) this.f5600a.newDrawable(resources, theme);
            return gVar;
        }
    }

    public g() {
        this.f5556f = true;
        this.f5557g = new float[9];
        this.f5558h = new Matrix();
        this.f5559i = new Rect();
        this.f5552b = new h();
    }

    public static g createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        g gVar = new g();
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    public PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.canApplyTheme();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f5595f.getHeight()) == false) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            android.graphics.drawable.Drawable r0 = r10.f5550a
            if (r0 == 0) goto L_0x0008
            r0.draw(r11)
            return
        L_0x0008:
            android.graphics.Rect r0 = r10.f5559i
            r10.copyBounds(r0)
            android.graphics.Rect r0 = r10.f5559i
            int r0 = r0.width()
            if (r0 <= 0) goto L_0x0167
            android.graphics.Rect r0 = r10.f5559i
            int r0 = r0.height()
            if (r0 > 0) goto L_0x001f
            goto L_0x0167
        L_0x001f:
            android.graphics.ColorFilter r0 = r10.f5554d
            if (r0 != 0) goto L_0x0025
            android.graphics.PorterDuffColorFilter r0 = r10.f5553c
        L_0x0025:
            android.graphics.Matrix r1 = r10.f5558h
            r11.getMatrix(r1)
            android.graphics.Matrix r1 = r10.f5558h
            float[] r2 = r10.f5557g
            r1.getValues(r2)
            float[] r1 = r10.f5557g
            r2 = 0
            r1 = r1[r2]
            float r1 = java.lang.Math.abs(r1)
            float[] r3 = r10.f5557g
            r4 = 4
            r3 = r3[r4]
            float r3 = java.lang.Math.abs(r3)
            float[] r4 = r10.f5557g
            r5 = 1
            r4 = r4[r5]
            float r4 = java.lang.Math.abs(r4)
            float[] r6 = r10.f5557g
            r7 = 3
            r6 = r6[r7]
            float r6 = java.lang.Math.abs(r6)
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x0060
            int r4 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0062
        L_0x0060:
            r1 = r8
            r3 = r1
        L_0x0062:
            android.graphics.Rect r4 = r10.f5559i
            int r4 = r4.width()
            float r4 = (float) r4
            float r4 = r4 * r1
            int r1 = (int) r4
            android.graphics.Rect r4 = r10.f5559i
            int r4 = r4.height()
            float r4 = (float) r4
            float r4 = r4 * r3
            int r3 = (int) r4
            r4 = 2048(0x800, float:2.87E-42)
            int r1 = java.lang.Math.min(r4, r1)
            int r3 = java.lang.Math.min(r4, r3)
            if (r1 <= 0) goto L_0x0167
            if (r3 > 0) goto L_0x0084
            goto L_0x0167
        L_0x0084:
            int r4 = r11.save()
            android.graphics.Rect r6 = r10.f5559i
            int r9 = r6.left
            float r9 = (float) r9
            int r6 = r6.top
            float r6 = (float) r6
            r11.translate(r9, r6)
            boolean r6 = r10.isAutoMirrored()
            if (r6 == 0) goto L_0x00a1
            int r6 = r10.getLayoutDirection()
            if (r6 != r5) goto L_0x00a1
            r6 = r5
            goto L_0x00a2
        L_0x00a1:
            r6 = r2
        L_0x00a2:
            if (r6 == 0) goto L_0x00b3
            android.graphics.Rect r6 = r10.f5559i
            int r6 = r6.width()
            float r6 = (float) r6
            r11.translate(r6, r7)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11.scale(r6, r8)
        L_0x00b3:
            android.graphics.Rect r6 = r10.f5559i
            r6.offsetTo(r2, r2)
            d.u.a.a.g$h r6 = r10.f5552b
            android.graphics.Bitmap r7 = r6.f5595f
            if (r7 == 0) goto L_0x00d1
            int r7 = r7.getWidth()
            if (r1 != r7) goto L_0x00ce
            android.graphics.Bitmap r7 = r6.f5595f
            int r7 = r7.getHeight()
            if (r3 != r7) goto L_0x00ce
            r7 = r5
            goto L_0x00cf
        L_0x00ce:
            r7 = r2
        L_0x00cf:
            if (r7 != 0) goto L_0x00db
        L_0x00d1:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r1, r3, r7)
            r6.f5595f = r7
            r6.k = r5
        L_0x00db:
            boolean r6 = r10.f5556f
            if (r6 != 0) goto L_0x00e5
            d.u.a.a.g$h r6 = r10.f5552b
            r6.a(r1, r3)
            goto L_0x0129
        L_0x00e5:
            d.u.a.a.g$h r6 = r10.f5552b
            boolean r7 = r6.k
            if (r7 != 0) goto L_0x0109
            android.content.res.ColorStateList r7 = r6.f5596g
            android.content.res.ColorStateList r8 = r6.f5592c
            if (r7 != r8) goto L_0x0109
            android.graphics.PorterDuff$Mode r7 = r6.f5597h
            android.graphics.PorterDuff$Mode r8 = r6.f5593d
            if (r7 != r8) goto L_0x0109
            boolean r7 = r6.f5599j
            boolean r8 = r6.f5594e
            if (r7 != r8) goto L_0x0109
            int r7 = r6.f5598i
            d.u.a.a.g$g r6 = r6.f5591b
            int r6 = r6.getRootAlpha()
            if (r7 != r6) goto L_0x0109
            r6 = r5
            goto L_0x010a
        L_0x0109:
            r6 = r2
        L_0x010a:
            if (r6 != 0) goto L_0x0129
            d.u.a.a.g$h r6 = r10.f5552b
            r6.a(r1, r3)
            d.u.a.a.g$h r1 = r10.f5552b
            android.content.res.ColorStateList r3 = r1.f5592c
            r1.f5596g = r3
            android.graphics.PorterDuff$Mode r3 = r1.f5593d
            r1.f5597h = r3
            d.u.a.a.g$g r3 = r1.f5591b
            int r3 = r3.getRootAlpha()
            r1.f5598i = r3
            boolean r3 = r1.f5594e
            r1.f5599j = r3
            r1.k = r2
        L_0x0129:
            d.u.a.a.g$h r1 = r10.f5552b
            android.graphics.Rect r3 = r10.f5559i
            d.u.a.a.g$g r6 = r1.f5591b
            int r6 = r6.getRootAlpha()
            r7 = 255(0xff, float:3.57E-43)
            if (r6 >= r7) goto L_0x0138
            r2 = r5
        L_0x0138:
            r6 = 0
            if (r2 != 0) goto L_0x013f
            if (r0 != 0) goto L_0x013f
            r0 = r6
            goto L_0x015f
        L_0x013f:
            android.graphics.Paint r2 = r1.l
            if (r2 != 0) goto L_0x014d
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r1.l = r2
            r2.setFilterBitmap(r5)
        L_0x014d:
            android.graphics.Paint r2 = r1.l
            d.u.a.a.g$g r5 = r1.f5591b
            int r5 = r5.getRootAlpha()
            r2.setAlpha(r5)
            android.graphics.Paint r2 = r1.l
            r2.setColorFilter(r0)
            android.graphics.Paint r0 = r1.l
        L_0x015f:
            android.graphics.Bitmap r1 = r1.f5595f
            r11.drawBitmap(r1, r6, r3, r0)
            r11.restoreToCount(r4)
        L_0x0167:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d.u.a.a.g.draw(android.graphics.Canvas):void");
    }

    public int getAlpha() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f5552b.f5591b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f5552b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f5554d;
    }

    public ConstantState getConstantState() {
        if (this.f5550a != null && VERSION.SDK_INT >= 24) {
            return new i(this.f5550a.getConstantState());
        }
        this.f5552b.f5590a = getChangingConfigurations();
        return this.f5552b;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f5552b.f5591b.f5589j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f5552b.f5591b.f5588i;
    }

    public int getOpacity() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f5552b.f5594e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r0.isStateful() != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f5550a
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            d.u.a.a.g$h r0 = r1.f5552b
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0028
            d.u.a.a.g$h r0 = r1.f5552b
            android.content.res.ColorStateList r0 = r0.f5592c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.u.a.a.g.isStateful():boolean");
    }

    public Drawable mutate() {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f5555e && super.mutate() == this) {
            this.f5552b = new h(this.f5552b);
            this.f5555e = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f5552b;
        ColorStateList colorStateList = hVar.f5592c;
        boolean z2 = true;
        if (colorStateList != null) {
            Mode mode = hVar.f5593d;
            if (mode != null) {
                this.f5553c = a(colorStateList, mode);
                invalidateSelf();
                z = true;
            }
        }
        if (hVar.a()) {
            boolean a2 = hVar.f5591b.f5587h.a(iArr);
            hVar.k |= a2;
            if (a2) {
                invalidateSelf();
                return z2;
            }
        }
        z2 = z;
        return z2;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.setAlpha(i2);
            return;
        }
        if (this.f5552b.f5591b.getRootAlpha() != i2) {
            this.f5552b.f5591b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f5552b.f5594e = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f5554d = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i2) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            a.a.a.a.b.a.a(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            a.a.a.a.b.a.a(drawable, colorStateList);
            return;
        }
        h hVar = this.f5552b;
        if (hVar.f5592c != colorStateList) {
            hVar.f5592c = colorStateList;
            this.f5553c = a(colorStateList, hVar.f5593d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            a.a.a.a.b.a.a(drawable, mode);
            return;
        }
        h hVar = this.f5552b;
        if (hVar.f5593d != mode) {
            hVar.f5593d = mode;
            this.f5553c = a(hVar.f5592c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f5550a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b A[Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static d.u.a.a.g a(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0021
            d.u.a.a.g r0 = new d.u.a.a.g
            r0.<init>()
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7, r8)
            r0.f5550a = r6
            d.u.a.a.g$i r6 = new d.u.a.a.g$i
            android.graphics.drawable.Drawable r7 = r0.f5550a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            return r0
        L_0x0021:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0029:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            r4 = 2
            if (r3 == r4) goto L_0x0034
            r5 = 1
            if (r3 == r5) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            if (r3 != r4) goto L_0x003b
            d.u.a.a.g r6 = createFromXmlInner(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            return r6
        L_0x003b:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
            throw r6     // Catch:{ XmlPullParserException -> 0x0048, IOException -> 0x0043 }
        L_0x0043:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004c
        L_0x0048:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d.u.a.a.g.a(android.content.res.Resources, int, android.content.res.Resources$Theme):d.u.a.a.g");
    }

    /* JADX WARNING: Removed duplicated region for block: B:132:0x043f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void inflate(android.content.res.Resources r28, org.xmlpull.v1.XmlPullParser r29, android.util.AttributeSet r30, android.content.res.Resources.Theme r31) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r9 = r29
            r10 = r30
            r11 = r31
            android.graphics.drawable.Drawable r0 = r1.f5550a
            if (r0 == 0) goto L_0x0012
            r0.inflate(r2, r9, r10, r11)
            return
        L_0x0012:
            d.u.a.a.g$h r12 = r1.f5552b
            d.u.a.a.g$g r0 = new d.u.a.a.g$g
            r0.<init>()
            r12.f5591b = r0
            int[] r0 = d.u.a.a.a.f5527a
            android.content.res.TypedArray r3 = a.a.a.a.b.a.a(r2, r11, r10, r0)
            d.u.a.a.g$h r4 = r1.f5552b
            d.u.a.a.g$g r5 = r4.f5591b
            r13 = 6
            r14 = -1
            java.lang.String r0 = "tintMode"
            int r0 = a.a.a.a.b.a.b(r3, r9, r0, r13, r14)
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_IN
            r15 = 9
            r8 = 5
            r7 = 3
            if (r0 == r7) goto L_0x0049
            if (r0 == r8) goto L_0x004b
            if (r0 == r15) goto L_0x0046
            switch(r0) {
                case 14: goto L_0x0043;
                case 15: goto L_0x0040;
                case 16: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x004b
        L_0x003d:
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.ADD
            goto L_0x004b
        L_0x0040:
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SCREEN
            goto L_0x004b
        L_0x0043:
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x004b
        L_0x0046:
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_ATOP
            goto L_0x004b
        L_0x0049:
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_OVER
        L_0x004b:
            r4.f5593d = r6
            java.lang.String r0 = "tint"
            boolean r0 = a.a.a.a.b.a.a(r9, r0)
            r13 = 0
            r15 = 1
            r14 = 2
            if (r0 == 0) goto L_0x00ac
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r3.getValue(r15, r0)
            int r6 = r0.type
            if (r6 == r14) goto L_0x008d
            r14 = 28
            if (r6 < r14) goto L_0x0073
            r14 = 31
            if (r6 > r14) goto L_0x0073
            int r0 = r0.data
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            goto L_0x00ad
        L_0x0073:
            android.content.res.Resources r0 = r3.getResources()
            int r6 = r3.getResourceId(r15, r13)
            android.content.res.XmlResourceParser r6 = r0.getXml(r6)     // Catch:{ Exception -> 0x0084 }
            android.content.res.ColorStateList r0 = a.a.a.a.b.a.a(r0, r6, r11)     // Catch:{ Exception -> 0x0084 }
            goto L_0x00ad
        L_0x0084:
            r0 = move-exception
            java.lang.String r6 = "CSLCompat"
            java.lang.String r14 = "Failed to inflate ColorStateList."
            android.util.Log.e(r6, r14, r0)
            goto L_0x00ac
        L_0x008d:
            java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to resolve attribute at index "
            r3.append(r4)
            r3.append(r15)
            java.lang.String r4 = ": "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00ac:
            r0 = 0
        L_0x00ad:
            if (r0 == 0) goto L_0x00b1
            r4.f5592c = r0
        L_0x00b1:
            boolean r0 = r4.f5594e
            java.lang.String r6 = "autoMirrored"
            boolean r6 = a.a.a.a.b.a.a(r9, r6)
            if (r6 != 0) goto L_0x00bc
            goto L_0x00c0
        L_0x00bc:
            boolean r0 = r3.getBoolean(r8, r0)
        L_0x00c0:
            r4.f5594e = r0
            float r0 = r5.k
            r14 = 7
            java.lang.String r4 = "viewportWidth"
            float r0 = a.a.a.a.b.a.a(r3, r9, r4, r14, r0)
            r5.k = r0
            float r0 = r5.l
            r6 = 8
            java.lang.String r4 = "viewportHeight"
            float r0 = a.a.a.a.b.a.a(r3, r9, r4, r6, r0)
            r5.l = r0
            float r4 = r5.k
            r19 = 0
            int r4 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r4 <= 0) goto L_0x043f
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x0423
            float r0 = r5.f5588i
            float r0 = r3.getDimension(r7, r0)
            r5.f5588i = r0
            float r0 = r5.f5589j
            r4 = 2
            float r0 = r3.getDimension(r4, r0)
            r5.f5589j = r0
            float r4 = r5.f5588i
            int r4 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r4 <= 0) goto L_0x0407
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 <= 0) goto L_0x03eb
            float r0 = r5.getAlpha()
            r4 = 4
            java.lang.String r6 = "alpha"
            float r0 = a.a.a.a.b.a.a(r3, r9, r6, r4, r0)
            r5.setAlpha(r0)
            java.lang.String r0 = r3.getString(r13)
            if (r0 == 0) goto L_0x011b
            r5.n = r0
            d.e.a<java.lang.String, java.lang.Object> r6 = r5.p
            r6.put(r0, r5)
        L_0x011b:
            r3.recycle()
            int r0 = r27.getChangingConfigurations()
            r12.f5590a = r0
            r12.k = r15
            d.u.a.a.g$h r0 = r1.f5552b
            d.u.a.a.g$g r6 = r0.f5591b
            java.util.ArrayDeque r5 = new java.util.ArrayDeque
            r5.<init>()
            d.u.a.a.g$d r3 = r6.f5587h
            r5.push(r3)
            int r3 = r29.getEventType()
            int r20 = r29.getDepth()
            int r14 = r20 + 1
            r20 = r15
        L_0x0140:
            if (r3 == r15) goto L_0x03d2
            int r4 = r29.getDepth()
            if (r4 >= r14) goto L_0x014a
            if (r3 == r7) goto L_0x03d2
        L_0x014a:
            java.lang.String r4 = "group"
            r7 = 2
            if (r3 != r7) goto L_0x03a2
            java.lang.String r3 = r29.getName()
            java.lang.Object r7 = r5.peek()
            d.u.a.a.g$d r7 = (d.u.a.a.g.d) r7
            java.lang.String r8 = "path"
            boolean r8 = r8.equals(r3)
            java.lang.String r15 = "fillType"
            java.lang.String r13 = "pathData"
            if (r8 == 0) goto L_0x02a9
            d.u.a.a.g$c r8 = new d.u.a.a.g$c
            r8.<init>()
            int[] r3 = d.u.a.a.a.f5529c
            android.content.res.TypedArray r4 = a.a.a.a.b.a.a(r2, r11, r10, r3)
            r3 = 0
            r8.f5560e = r3
            boolean r13 = a.a.a.a.b.a.a(r9, r13)
            if (r13 != 0) goto L_0x018b
            r1 = r4
            r25 = r5
            r26 = r6
            r13 = r8
            r18 = r14
            r5 = 4
            r17 = -1
            r21 = 9
            r22 = 8
            r14 = r7
            goto L_0x027a
        L_0x018b:
            r13 = 0
            java.lang.String r3 = r4.getString(r13)
            if (r3 == 0) goto L_0x0194
            r8.f5577b = r3
        L_0x0194:
            r3 = 2
            java.lang.String r13 = r4.getString(r3)
            if (r13 == 0) goto L_0x01a1
            d.h.f.b[] r3 = a.a.a.a.b.a.a(r13)
            r8.f5576a = r3
        L_0x01a1:
            r13 = 1
            r20 = 0
            java.lang.String r23 = "fillColor"
            r18 = 0
            r3 = r4
            r24 = r4
            r4 = r29
            r25 = r5
            r5 = r31
            r26 = r6
            r6 = r23
            r18 = r14
            r1 = 3
            r14 = r7
            r7 = r13
            r13 = r8
            r1 = 5
            r8 = r20
            d.h.e.b.a r3 = a.a.a.a.b.a.a(r3, r4, r5, r6, r7, r8)
            r13.f5563h = r3
            r3 = 12
            float r4 = r13.f5565j
            java.lang.String r5 = "fillAlpha"
            r8 = r24
            float r3 = a.a.a.a.b.a.a(r8, r9, r5, r3, r4)
            r13.f5565j = r3
            java.lang.String r3 = "strokeLineCap"
            r4 = -1
            r7 = 8
            int r3 = a.a.a.a.b.a.b(r8, r9, r3, r7, r4)
            android.graphics.Paint$Cap r4 = r13.n
            if (r3 == 0) goto L_0x01ec
            r5 = 1
            if (r3 == r5) goto L_0x01e9
            r5 = 2
            if (r3 == r5) goto L_0x01e6
            goto L_0x01ee
        L_0x01e6:
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.SQUARE
            goto L_0x01ee
        L_0x01e9:
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.ROUND
            goto L_0x01ee
        L_0x01ec:
            android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.BUTT
        L_0x01ee:
            r13.n = r4
            java.lang.String r3 = "strokeLineJoin"
            r5 = -1
            r6 = 9
            int r3 = a.a.a.a.b.a.b(r8, r9, r3, r6, r5)
            android.graphics.Paint$Join r4 = r13.o
            if (r3 == 0) goto L_0x020a
            r5 = 1
            if (r3 == r5) goto L_0x0207
            r5 = 2
            if (r3 == r5) goto L_0x0204
            goto L_0x020c
        L_0x0204:
            android.graphics.Paint$Join r4 = android.graphics.Paint.Join.BEVEL
            goto L_0x020c
        L_0x0207:
            android.graphics.Paint$Join r4 = android.graphics.Paint.Join.ROUND
            goto L_0x020c
        L_0x020a:
            android.graphics.Paint$Join r4 = android.graphics.Paint.Join.MITER
        L_0x020c:
            r13.o = r4
            r3 = 10
            float r4 = r13.p
            java.lang.String r5 = "strokeMiterLimit"
            float r3 = a.a.a.a.b.a.a(r8, r9, r5, r3, r4)
            r13.p = r3
            r16 = 3
            r19 = 0
            java.lang.String r20 = "strokeColor"
            r3 = r8
            r4 = r29
            r17 = -1
            r5 = r31
            r21 = r6
            r6 = r20
            r22 = r7
            r7 = r16
            r1 = r8
            r8 = r19
            d.h.e.b.a r3 = a.a.a.a.b.a.a(r3, r4, r5, r6, r7, r8)
            r13.f5561f = r3
            r3 = 11
            float r4 = r13.f5564i
            java.lang.String r5 = "strokeAlpha"
            float r3 = a.a.a.a.b.a.a(r1, r9, r5, r3, r4)
            r13.f5564i = r3
            float r3 = r13.f5562g
            java.lang.String r4 = "strokeWidth"
            r5 = 4
            float r3 = a.a.a.a.b.a.a(r1, r9, r4, r5, r3)
            r13.f5562g = r3
            float r3 = r13.l
            java.lang.String r4 = "trimPathEnd"
            r6 = 6
            float r3 = a.a.a.a.b.a.a(r1, r9, r4, r6, r3)
            r13.l = r3
            float r3 = r13.m
            java.lang.String r4 = "trimPathOffset"
            r6 = 7
            float r3 = a.a.a.a.b.a.a(r1, r9, r4, r6, r3)
            r13.m = r3
            float r3 = r13.k
            java.lang.String r4 = "trimPathStart"
            r6 = 5
            float r3 = a.a.a.a.b.a.a(r1, r9, r4, r6, r3)
            r13.k = r3
            r3 = 13
            int r4 = r13.f5578c
            int r3 = a.a.a.a.b.a.b(r1, r9, r15, r3, r4)
            r13.f5578c = r3
        L_0x027a:
            r1.recycle()
            java.util.ArrayList<d.u.a.a.g$e> r1 = r14.f5567b
            r1.add(r13)
            java.lang.String r1 = r13.getPathName()
            if (r1 == 0) goto L_0x0294
            r1 = r26
            d.e.a<java.lang.String, java.lang.Object> r3 = r1.p
            java.lang.String r4 = r13.getPathName()
            r3.put(r4, r13)
            goto L_0x0296
        L_0x0294:
            r1 = r26
        L_0x0296:
            int r3 = r0.f5590a
            int r4 = r13.f5579d
            r3 = r3 | r4
            r0.f5590a = r3
            r7 = r25
            r5 = 7
            r6 = 0
            r8 = 6
            r13 = 5
            r14 = 3
            r15 = 2
            r20 = 0
            goto L_0x03c1
        L_0x02a9:
            r25 = r5
            r1 = r6
            r18 = r14
            r5 = 4
            r17 = -1
            r21 = 9
            r22 = 8
            r14 = r7
            java.lang.String r6 = "clip-path"
            boolean r6 = r6.equals(r3)
            if (r6 == 0) goto L_0x030d
            d.u.a.a.g$b r3 = new d.u.a.a.g$b
            r3.<init>()
            boolean r4 = a.a.a.a.b.a.a(r9, r13)
            if (r4 != 0) goto L_0x02ca
            goto L_0x02f0
        L_0x02ca:
            int[] r4 = d.u.a.a.a.f5530d
            android.content.res.TypedArray r4 = a.a.a.a.b.a.a(r2, r11, r10, r4)
            r6 = 0
            java.lang.String r7 = r4.getString(r6)
            if (r7 == 0) goto L_0x02d9
            r3.f5577b = r7
        L_0x02d9:
            r7 = 1
            java.lang.String r8 = r4.getString(r7)
            if (r8 == 0) goto L_0x02e6
            d.h.f.b[] r7 = a.a.a.a.b.a.a(r8)
            r3.f5576a = r7
        L_0x02e6:
            r7 = 2
            int r8 = a.a.a.a.b.a.b(r4, r9, r15, r7, r6)
            r3.f5578c = r8
            r4.recycle()
        L_0x02f0:
            java.util.ArrayList<d.u.a.a.g$e> r4 = r14.f5567b
            r4.add(r3)
            java.lang.String r4 = r3.getPathName()
            if (r4 == 0) goto L_0x0304
            d.e.a<java.lang.String, java.lang.Object> r4 = r1.p
            java.lang.String r6 = r3.getPathName()
            r4.put(r6, r3)
        L_0x0304:
            int r4 = r0.f5590a
            int r3 = r3.f5579d
            r3 = r3 | r4
            r0.f5590a = r3
            goto L_0x0399
        L_0x030d:
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0399
            d.u.a.a.g$d r3 = new d.u.a.a.g$d
            r3.<init>()
            int[] r4 = d.u.a.a.a.f5528b
            android.content.res.TypedArray r4 = a.a.a.a.b.a.a(r2, r11, r10, r4)
            r6 = 0
            r3.l = r6
            float r7 = r3.f5568c
            java.lang.String r8 = "rotation"
            r13 = 5
            float r7 = a.a.a.a.b.a.a(r4, r9, r8, r13, r7)
            r3.f5568c = r7
            float r7 = r3.f5569d
            r8 = 1
            float r7 = r4.getFloat(r8, r7)
            r3.f5569d = r7
            float r7 = r3.f5570e
            r15 = 2
            float r7 = r4.getFloat(r15, r7)
            r3.f5570e = r7
            float r7 = r3.f5571f
            java.lang.String r6 = "scaleX"
            r8 = 3
            float r6 = a.a.a.a.b.a.a(r4, r9, r6, r8, r7)
            r3.f5571f = r6
            float r6 = r3.f5572g
            java.lang.String r7 = "scaleY"
            float r6 = a.a.a.a.b.a.a(r4, r9, r7, r5, r6)
            r3.f5572g = r6
            float r6 = r3.f5573h
            java.lang.String r7 = "translateX"
            r8 = 6
            float r6 = a.a.a.a.b.a.a(r4, r9, r7, r8, r6)
            r3.f5573h = r6
            float r6 = r3.f5574i
            java.lang.String r7 = "translateY"
            r5 = 7
            float r6 = a.a.a.a.b.a.a(r4, r9, r7, r5, r6)
            r3.f5574i = r6
            r6 = 0
            java.lang.String r7 = r4.getString(r6)
            if (r7 == 0) goto L_0x0372
            r3.m = r7
        L_0x0372:
            r3.b()
            r4.recycle()
            java.util.ArrayList<d.u.a.a.g$e> r4 = r14.f5567b
            r4.add(r3)
            r7 = r25
            r7.push(r3)
            java.lang.String r4 = r3.getGroupName()
            if (r4 == 0) goto L_0x0391
            d.e.a<java.lang.String, java.lang.Object> r4 = r1.p
            java.lang.String r14 = r3.getGroupName()
            r4.put(r14, r3)
        L_0x0391:
            int r4 = r0.f5590a
            int r3 = r3.k
            r3 = r3 | r4
            r0.f5590a = r3
            goto L_0x03a0
        L_0x0399:
            r7 = r25
            r5 = 7
            r6 = 0
            r8 = 6
            r13 = 5
            r15 = 2
        L_0x03a0:
            r14 = 3
            goto L_0x03c1
        L_0x03a2:
            r1 = r6
            r15 = r7
            r6 = r13
            r18 = r14
            r14 = 3
            r17 = -1
            r21 = 9
            r22 = 8
            r7 = r5
            r13 = r8
            r5 = 7
            r8 = 6
            if (r3 != r14) goto L_0x03c1
            java.lang.String r3 = r29.getName()
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x03c1
            r7.pop()
        L_0x03c1:
            int r3 = r29.next()
            r5 = r7
            r8 = r13
            r7 = r14
            r14 = r18
            r4 = 4
            r15 = 1
            r13 = r6
            r6 = r1
            r1 = r27
            goto L_0x0140
        L_0x03d2:
            if (r20 != 0) goto L_0x03e1
            android.content.res.ColorStateList r0 = r12.f5592c
            android.graphics.PorterDuff$Mode r1 = r12.f5593d
            r2 = r27
            android.graphics.PorterDuffColorFilter r0 = r2.a(r0, r1)
            r2.f5553c = r0
            return
        L_0x03e1:
            r2 = r27
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r1 = "no path defined"
            r0.<init>(r1)
            throw r0
        L_0x03eb:
            r2 = r1
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r3.getPositionDescription()
            r1.append(r3)
            java.lang.String r3 = "<vector> tag requires height > 0"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0407:
            r2 = r1
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r3.getPositionDescription()
            r1.append(r3)
            java.lang.String r3 = "<vector> tag requires width > 0"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0423:
            r2 = r1
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r3.getPositionDescription()
            r1.append(r3)
            java.lang.String r3 = "<vector> tag requires viewportHeight > 0"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x043f:
            r2 = r1
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r3.getPositionDescription()
            r1.append(r3)
            java.lang.String r3 = "<vector> tag requires viewportWidth > 0"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.u.a.a.g.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    public g(h hVar) {
        this.f5556f = true;
        this.f5557g = new float[9];
        this.f5558h = new Matrix();
        this.f5559i = new Rect();
        this.f5552b = hVar;
        this.f5553c = a(hVar.f5592c, hVar.f5593d);
    }

    public static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }
}
