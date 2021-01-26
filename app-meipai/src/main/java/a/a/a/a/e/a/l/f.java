package a.a.a.a.e.a.l;

import a.a.a.a.e.a.i.f.b;
import a.a.a.a.e.a.i.f.c;
import a.a.a.a.e.a.i.f.e;
import a.a.a.a.e.a.i.f.g;
import a.a.a.a.e.a.i.h;
import com.arashivision.algorithm.SmoothPoints;
import com.arashivision.algorithm.SmoothPoints.InsQuat;
import com.arashivision.insbase.joml.Quaternionf;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class f {

    /* renamed from: a reason: collision with root package name */
    public static final MediaLogger f651a = MediaLogger.getLogger(f.class);

    public interface a {
        h a(h hVar, int[] iArr, Constraint constraint);
    }

    public static int a(double d2) {
        return (int) (d2 * 500.0d);
    }

    public static e a(double d2, Constraint constraint) {
        e eVar = new e();
        eVar.f605d = 0.0f;
        eVar.f607f = 0.0f;
        eVar.f606e = 0.0f;
        eVar.f608g = 0.0f;
        eVar.f604c = d2;
        eVar.f603b = constraint.getDefaultDistance();
        eVar.f602a = constraint.getDefaultFov();
        return eVar;
    }

    public static g a(e eVar, e eVar2) {
        g gVar = new g();
        gVar.f597a.add(eVar.clone());
        gVar.f597a.add(eVar2.clone());
        return gVar;
    }

    public static e a(e eVar, double d2, Constraint constraint) {
        e eVar2 = new e();
        eVar2.f607f = 0.0f;
        eVar2.f605d = eVar.f605d;
        eVar2.f606e = 0.0f;
        eVar2.f608g = 0.0f;
        eVar2.f604c = d2;
        eVar2.f602a = constraint.getDefaultFov();
        eVar2.f603b = constraint.getDefaultDistance();
        return eVar2;
    }

    public static e a(List<c> list, double d2) {
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = (c) list.get(size);
            e eVar = (e) cVar.f597a.get(cVar.f597a.size() - 1);
            if (d2 >= eVar.f604c) {
                e eVar2 = new e();
                eVar2.f602a = eVar.f602a;
                eVar2.f603b = eVar.f603b;
                eVar2.f604c = d2;
                eVar2.f606e = eVar.f606e;
                eVar2.f607f = eVar.f607f;
                eVar2.f605d = eVar.f605d;
                eVar2.f608g = eVar.f608g;
                return eVar2;
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [a.a.a.a.e.a.i.f.c] */
    /* JADX WARNING: type inference failed for: r0v4, types: [a.a.a.a.e.a.i.f.a, a.a.a.a.e.a.i.f.c] */
    /* JADX WARNING: type inference failed for: r0v5, types: [a.a.a.a.e.a.i.f.f, a.a.a.a.e.a.i.f.c] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.a.a.a.e.a.i.f.c a(a.a.a.a.e.a.i.h r3) {
        /*
            a.a.a.a.e.a.i.h$a r0 = r3.f614b
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x003c
            r1 = 1
            if (r0 == r1) goto L_0x0026
            r1 = 2
            if (r0 == r1) goto L_0x0010
            r0 = 0
            goto L_0x004d
        L_0x0010:
            a.a.a.a.e.a.i.f.f r0 = new a.a.a.a.e.a.i.f.f
            r0.<init>()
            java.util.List<a.a.a.a.e.a.i.f.e> r1 = r3.f617e
            java.util.List<a.a.a.a.e.a.i.f.e> r2 = r0.f597a
            r2.clear()
            java.util.List<a.a.a.a.e.a.i.f.e> r2 = r0.f597a
            r2.addAll(r1)
            boolean r1 = r3.f621i
            r0.f600d = r1
            goto L_0x004d
        L_0x0026:
            a.a.a.a.e.a.i.f.a r0 = new a.a.a.a.e.a.i.f.a
            r0.<init>()
            java.util.List<a.a.a.a.e.a.i.f.e> r1 = r3.f617e
            java.util.List<a.a.a.a.e.a.i.f.e> r2 = r0.f597a
            r2.clear()
            java.util.List<a.a.a.a.e.a.i.f.e> r2 = r0.f597a
            r2.addAll(r1)
            boolean r1 = r3.f621i
            r0.f600d = r1
            goto L_0x004d
        L_0x003c:
            a.a.a.a.e.a.i.f.b r0 = new a.a.a.a.e.a.i.f.b
            r0.<init>()
            java.util.List<a.a.a.a.e.a.i.f.e> r1 = r3.f617e
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            a.a.a.a.e.a.i.f.e r1 = (a.a.a.a.e.a.i.f.e) r1
            r0.a(r1)
        L_0x004d:
            a.a.a.a.e.a.j.b r3 = r3.c()
            r0.f599c = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.e.a.l.f.a(a.a.a.a.e.a.i.h):a.a.a.a.e.a.i.f.c");
    }

    public static List<e> a(List<e> list) {
        int size = list.size();
        e eVar = (e) list.get(0);
        e eVar2 = (e) list.get(size - 1);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < size; i2++) {
            float size2 = (((float) i2) * 1.0f) / ((float) (list.size() - 1));
            e eVar3 = new e();
            double d2 = eVar.f604c;
            eVar3.f604c = ((eVar2.f604c - d2) * ((double) size2)) + d2;
            float f2 = eVar.f605d;
            eVar3.f605d = e.a.a.a.a.e(eVar2.f605d, f2, size2, f2);
            float f3 = eVar.f606e;
            eVar3.f606e = e.a.a.a.a.e(eVar2.f606e, f3, size2, f3);
            float f4 = eVar.f607f;
            eVar3.f607f = e.a.a.a.a.e(eVar2.f607f, f4, size2, f4);
            float f5 = eVar.f608g;
            eVar3.f608g = e.a.a.a.a.e(eVar2.f608g, f5, size2, f5);
            float f6 = eVar.f602a;
            eVar3.f602a = e.a.a.a.a.e(eVar2.f602a, f6, size2, f6);
            float f7 = eVar.f603b;
            eVar3.f603b = e.a.a.a.a.e(eVar2.f603b, f7, size2, f7);
            arrayList.add(eVar3);
            if (list.size() > 2) {
                MediaLogger mediaLogger = f651a;
                StringBuilder a2 = e.a.a.a.a.a("duplicated StatePoint is smoothed from ");
                a2.append(list.get(i2));
                a2.append(" to ");
                a2.append(eVar3);
                mediaLogger.d(a2.toString());
            }
        }
        return arrayList;
    }

    public static List<c> a(List<h> list, double d2, double d3, double d4, int[] iArr, Constraint constraint, a aVar) {
        int i2;
        e eVar;
        e eVar2;
        h hVar;
        Iterator it;
        ArrayList arrayList;
        Object obj;
        int i3;
        Object obj2;
        int i4;
        List<h> list2 = list;
        double d5 = d2;
        double d6 = d3;
        Constraint constraint2 = constraint;
        a aVar2 = aVar;
        h[] hVarArr = new h[list.size()];
        list2.toArray(hVarArr);
        Arrays.sort(hVarArr, new g());
        List asList = Arrays.asList(hVarArr);
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (list2.get(i5) != asList.get(i5)) {
                f651a.w("preparePlayStateList(), but originList is not sorted!");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = asList.iterator();
        while (true) {
            i2 = -1;
            if (!it2.hasNext()) {
                break;
            }
            h hVar2 = (h) it2.next();
            if (hVar2 == null) {
                f651a.e("RecordList contains null??? ignored~");
            } else if (hVar2.f617e.size() == 0) {
                f651a.e("RecordList contains a record with empty point list??? ignored~");
            } else {
                MediaLogger mediaLogger = f651a;
                StringBuilder a2 = e.a.a.a.a.a("statePointList size before smooth is ");
                a2.append(hVar2.f617e.size());
                mediaLogger.d(a2.toString());
                List<e> list3 = hVar2.f617e;
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (e eVar3 : list3) {
                    if (arrayList4.size() > 0 && ((e) arrayList4.get(arrayList4.size() - 1)).f604c != eVar3.f604c) {
                        if (arrayList3.size() == 0) {
                            i4 = 0;
                            obj2 = arrayList4.get(0);
                        } else {
                            i4 = 0;
                            obj2 = arrayList3.get(arrayList3.size() - 1);
                        }
                        arrayList4.add(i4, (e) obj2);
                        arrayList3.addAll(a((List<e>) arrayList4));
                        arrayList4.clear();
                    }
                    arrayList4.add(eVar3);
                    double d7 = d3;
                }
                if (arrayList4.size() > 0) {
                    if (arrayList3.size() == 0) {
                        i3 = 0;
                        obj = arrayList4.get(0);
                    } else {
                        i3 = 0;
                        obj = arrayList3.get(arrayList3.size() - 1);
                    }
                    arrayList4.add(i3, (e) obj);
                    arrayList3.addAll(a((List<e>) arrayList4));
                    arrayList4.clear();
                }
                MediaLogger mediaLogger2 = f651a;
                StringBuilder a3 = e.a.a.a.a.a("statePointList size after smooth is ");
                a3.append(arrayList3.size());
                mediaLogger2.d(a3.toString());
                if (hVar2.f617e.size() > 2) {
                    a.a.a.a.e.a.i.h.a aVar3 = hVar2.f614b;
                    if (aVar3 == a.a.a.a.e.a.i.h.a.SMARTTRACK || aVar3 == a.a.a.a.e.a.i.h.a.VIEWFINDER) {
                        int size = arrayList3.size();
                        float[] fArr = new float[size];
                        float[] fArr2 = new float[arrayList3.size()];
                        float[] fArr3 = new float[arrayList3.size()];
                        ArrayList arrayList5 = new ArrayList(arrayList3.size());
                        double[] dArr = new double[arrayList3.size()];
                        int size2 = arrayList3.size();
                        it = it2;
                        int[] iArr2 = new int[2];
                        iArr2[1] = 2;
                        iArr2[0] = size2;
                        double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr2);
                        int i6 = 0;
                        while (i6 < arrayList3.size()) {
                            e eVar4 = (e) arrayList3.get(i6);
                            fArr[i6] = eVar4.f608g;
                            fArr2[i6] = eVar4.f602a;
                            fArr3[i6] = eVar4.f603b;
                            Quaternionf a4 = a.a.a.a.b.a.a(eVar4);
                            ArrayList arrayList6 = arrayList2;
                            arrayList5.add(new InsQuat(a4.x, a4.y, a4.z, a4.w));
                            dArr[i6] = eVar4.f604c;
                            dArr2[i6] = eVar4.f609h;
                            i6++;
                            double d8 = d2;
                            Constraint constraint3 = constraint;
                            a aVar4 = aVar;
                            arrayList2 = arrayList6;
                        }
                        arrayList = arrayList2;
                        SmoothPoints.averageSmoothKeepBothEnd(fArr, size);
                        SmoothPoints.movingAverageSmooth(fArr2, 10);
                        SmoothPoints.movingAverageSmooth(fArr3, 10);
                        SmoothPoints.smoothQuaternion(arrayList5, 10);
                        ArrayList arrayList7 = new ArrayList();
                        for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                            InsQuat insQuat = (InsQuat) arrayList5.get(i7);
                            arrayList7.add(a.a.a.a.b.a.a(new Quaternionf(insQuat.getX(), insQuat.getY(), insQuat.getZ(), insQuat.getW()), fArr[i7], fArr2[i7], fArr3[i7], dArr[i7], dArr2[i7]));
                        }
                        arrayList3 = new ArrayList();
                        for (int i8 = 0; i8 < arrayList7.size(); i8++) {
                            e clone = ((e) arrayList7.get(i8)).clone();
                            if (i8 > 0) {
                                e eVar5 = (e) arrayList3.get(i8 - 1);
                                while (((double) Math.abs(clone.f605d - eVar5.f605d)) > 3.141592653589793d) {
                                    float f2 = clone.f605d;
                                    clone.f605d = (float) (f2 > eVar5.f605d ? ((double) f2) - 6.283185307179586d : ((double) f2) + 6.283185307179586d);
                                }
                                while (((double) Math.abs(clone.f606e - eVar5.f606e)) > 3.141592653589793d) {
                                    float f3 = clone.f606e;
                                    clone.f606e = (float) (f3 > eVar5.f606e ? ((double) f3) - 6.283185307179586d : ((double) f3) + 6.283185307179586d);
                                }
                                while (((double) Math.abs(clone.f607f - eVar5.f607f)) > 3.141592653589793d) {
                                    float f4 = clone.f607f;
                                    clone.f607f = (float) (f4 > eVar5.f607f ? ((double) f4) - 6.283185307179586d : ((double) f4) + 6.283185307179586d);
                                }
                            }
                            arrayList3.add(clone);
                        }
                        h clone2 = hVar2.clone();
                        clone2.f617e = arrayList3;
                        ArrayList arrayList8 = arrayList;
                        arrayList8.add(clone2);
                        it2 = it;
                        double d9 = d3;
                        Constraint constraint4 = constraint;
                        a aVar5 = aVar;
                        arrayList2 = arrayList8;
                        double d10 = d2;
                    }
                }
                arrayList = arrayList2;
                it = it2;
                h clone22 = hVar2.clone();
                clone22.f617e = arrayList3;
                ArrayList arrayList82 = arrayList;
                arrayList82.add(clone22);
                it2 = it;
                double d92 = d3;
                Constraint constraint42 = constraint;
                a aVar52 = aVar;
                arrayList2 = arrayList82;
                double d102 = d2;
            }
        }
        ArrayList arrayList9 = arrayList2;
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        for (int i9 = 0; i9 < arrayList9.size(); i9++) {
            if (((h) arrayList9.get(i9)).f620h) {
                a aVar6 = aVar;
                if (aVar6 != null) {
                    hVar = aVar6.a((h) arrayList9.get(i9), iArr, constraint);
                    arrayList11.add(hVar);
                } else {
                    int[] iArr3 = iArr;
                    Constraint constraint5 = constraint;
                }
            } else {
                int[] iArr4 = iArr;
                Constraint constraint6 = constraint;
                a aVar7 = aVar;
            }
            hVar = ((h) arrayList9.get(i9)).clone();
            arrayList11.add(hVar);
        }
        Constraint constraint7 = constraint;
        while (i2 < arrayList11.size()) {
            h hVar3 = null;
            h hVar4 = (i2 < 0 || i2 >= arrayList11.size()) ? null : (h) arrayList11.get(i2);
            i2++;
            if (i2 >= 0 && i2 < arrayList11.size()) {
                hVar3 = (h) arrayList11.get(i2);
            }
            if (hVar4 != null && hVar3 != null) {
                arrayList10.add(a(hVar4));
                a.a.a.a.e.a.i.h.a aVar8 = hVar4.f614b;
                a.a.a.a.e.a.i.h.a aVar9 = a.a.a.a.e.a.i.h.a.PIVOTPOINT;
                if (!(aVar8 == aVar9 && hVar3.f614b == aVar9)) {
                    a.a.a.a.e.a.i.h.a aVar10 = hVar4.f614b;
                    a.a.a.a.e.a.i.h.a aVar11 = a.a.a.a.e.a.i.h.a.PIVOTPOINT;
                    if (aVar10 != aVar11 || hVar3.f614b == aVar11) {
                        a.a.a.a.e.a.i.h.a aVar12 = hVar4.f614b;
                        a.a.a.a.e.a.i.h.a aVar13 = a.a.a.a.e.a.i.h.a.PIVOTPOINT;
                        if (aVar12 == aVar13 || hVar3.f614b != aVar13) {
                            long j2 = 0;
                            if (hVar4.f614b == a.a.a.a.e.a.i.h.a.VIEWFINDER) {
                                j2 = (long) a(d4);
                            }
                            if (hVar3.b().f604c - hVar4.a().f604c <= ((double) (j2 + ((long) a(d4))))) {
                                eVar = hVar4.a();
                                arrayList10.add(a(eVar, hVar3.b()));
                            } else if (hVar4.f614b == a.a.a.a.e.a.i.h.a.VIEWFINDER) {
                                arrayList10.add(a(hVar4.a(), a(hVar4.a(), hVar4.a().f604c + ((double) a(d4)), constraint7)));
                            }
                        } else {
                            b bVar = new b();
                            if (hVar3.b().f604c - hVar4.a().f604c <= ((double) a(d4)) || hVar4.f614b != a.a.a.a.e.a.i.h.a.VIEWFINDER) {
                                eVar2 = hVar4.a();
                            } else {
                                double a5 = hVar4.a().f604c + ((double) a(d4));
                                arrayList10.add(a(hVar4.a(), a(hVar4.a(), a5, constraint7)));
                                eVar2 = a((List<c>) arrayList10, a5);
                            }
                            bVar.a(eVar2);
                            arrayList10.add(bVar);
                        }
                    } else if (hVar3.b().f604c - hVar4.a().f604c <= ((double) a(d4))) {
                        b bVar2 = new b();
                        bVar2.a(hVar3.b());
                        arrayList10.add(bVar2);
                    }
                    eVar = a((List<c>) arrayList10, hVar3.b().f604c - ((double) a(d4)));
                    arrayList10.add(a(eVar, hVar3.b()));
                }
                double d11 = d2;
            } else if (hVar4 != null || hVar3 == null) {
                double d12 = d2;
                if (hVar4 != null && hVar3 == null) {
                    arrayList10.add(a(hVar4));
                    double d13 = d3;
                    if (hVar4.a().f604c < d13 && hVar4.f614b.ordinal() == 2) {
                        arrayList10.add(a(hVar4.a(), a(hVar4.a(), Math.min(hVar4.a().f604c + ((double) a(d4)), d13), constraint7)));
                    }
                }
            } else {
                double d14 = d2;
                if (hVar3.b().f604c > d14) {
                    int ordinal = hVar3.f614b.ordinal();
                    if (ordinal == 0) {
                        b bVar3 = new b();
                        bVar3.f597a.add(a(0.0d, constraint7));
                        Collections.sort(bVar3.f597a, new a.a.a.a.e.a.i.f.b.a());
                        arrayList10.add(0, bVar3);
                    } else if (ordinal == 1 || ordinal == 2) {
                        arrayList10.add(0, a(a(Math.max(hVar3.b().f604c - ((double) a(d4)), d14), constraint7), hVar3.b()));
                    }
                }
            }
            double d15 = d3;
        }
        ArrayList arrayList12 = new ArrayList();
        for (int i10 = 0; i10 < arrayList10.size(); i10++) {
            c cVar = (c) arrayList10.get(i10);
            if ((cVar instanceof b) && arrayList12.size() > 0) {
                c cVar2 = (c) arrayList12.get(arrayList12.size() - 1);
                if (cVar2 instanceof b) {
                    int size3 = cVar2.f597a.size() - 1;
                    if (((e) cVar.f597a.get(0)).f604c == ((e) cVar2.f597a.get(size3)).f604c) {
                        cVar2.f597a.remove(size3);
                    }
                    cVar2.a((e) cVar.f597a.get(0));
                }
            }
            arrayList12.add(arrayList10.get(i10));
        }
        return arrayList12;
    }
}
