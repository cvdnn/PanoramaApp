package com.arashivision.insbase.joml;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PolygonsIntersection {
    public static final ByEndComparator byEndComparator = new ByEndComparator();
    public static final ByStartComparator byStartComparator = new ByStartComparator();
    public float centerX;
    public float centerY;
    public float maxX;
    public float maxY;
    public float minX;
    public float minY;
    public float radiusSquared;
    public IntervalTreeNode tree;
    public final float[] verticesXY;

    public static class ByEndComparator implements Comparator {
        public int compare(Object obj, Object obj2) {
            return Float.compare(((Interval) obj2).end, ((Interval) obj).end);
        }
    }

    public static class ByStartComparator implements Comparator {
        public int compare(Object obj, Object obj2) {
            return Float.compare(((Interval) obj).start, ((Interval) obj2).start);
        }
    }

    public static class Interval {
        public float end;

        /* renamed from: i reason: collision with root package name */
        public int f1233i;

        /* renamed from: j reason: collision with root package name */
        public int f1234j;
        public int polyIndex;
        public float start;
    }

    public static class IntervalTreeNode {
        public List byBeginning;
        public List byEnding;
        public float center;
        public float childrenMinMax;
        public IntervalTreeNode left;
        public IntervalTreeNode right;

        public static boolean computeEvenOdd(float[] fArr, Interval interval, float f2, float f3, boolean z, BitSet bitSet) {
            int i2 = interval.f1233i;
            int i3 = interval.f1234j;
            int i4 = i2 * 2;
            float f4 = fArr[i4 + 1];
            int i5 = i3 * 2;
            float f5 = fArr[i5 + 1];
            boolean z2 = false;
            float f6 = fArr[i4 + 0];
            float f7 = fArr[i5 + 0];
            if ((f4 >= f3 || f5 < f3) && (f5 >= f3 || f4 < f3)) {
                return z;
            }
            if (f6 > f2 && f7 > f2) {
                return z;
            }
            if ((((f7 - f6) * ((f3 - f4) / (f5 - f4))) + f6) - f2 < 0.0f) {
                z2 = true;
            }
            boolean z3 = z ^ z2;
            if (!(z3 == z || bitSet == null)) {
                bitSet.flip(interval.polyIndex);
            }
            return z3;
        }

        public boolean traverse(float[] fArr, float f2, float f3, boolean z, BitSet bitSet) {
            boolean z2;
            int i2 = 0;
            if (f3 == this.center) {
                List list = this.byBeginning;
                if (list != null) {
                    int size = list.size();
                    z2 = z;
                    while (i2 < size) {
                        z2 = computeEvenOdd(fArr, (Interval) this.byBeginning.get(i2), f2, f3, z2, bitSet);
                        i2++;
                    }
                    return z2;
                }
            }
            float f4 = this.center;
            if (f3 < f4) {
                IntervalTreeNode intervalTreeNode = this.left;
                if (intervalTreeNode != null && intervalTreeNode.childrenMinMax >= f3) {
                    z = intervalTreeNode.traverse(fArr, f2, f3, z, bitSet);
                }
                List list2 = this.byBeginning;
                if (list2 == null) {
                    return z;
                }
                int size2 = list2.size();
                boolean z3 = z;
                while (i2 < size2) {
                    Interval interval = (Interval) this.byBeginning.get(i2);
                    if (interval.start > f3) {
                        break;
                    }
                    z3 = computeEvenOdd(fArr, interval, f2, f3, z2, bitSet);
                    i2++;
                }
            } else if (f3 <= f4) {
                return z;
            } else {
                IntervalTreeNode intervalTreeNode2 = this.right;
                if (intervalTreeNode2 != null && intervalTreeNode2.childrenMinMax <= f3) {
                    z = intervalTreeNode2.traverse(fArr, f2, f3, z, bitSet);
                }
                List list3 = this.byEnding;
                if (list3 == null) {
                    return z;
                }
                int size3 = list3.size();
                boolean z4 = z;
                while (i2 < size3) {
                    Interval interval2 = (Interval) this.byEnding.get(i2);
                    if (interval2.end < f3) {
                        break;
                    }
                    z4 = computeEvenOdd(fArr, interval2, f2, f3, z2, bitSet);
                    i2++;
                }
            }
            return z2;
        }
    }

    public PolygonsIntersection(float[] fArr, int[] iArr, int i2) {
        this.verticesXY = fArr;
        preprocess(i2, iArr);
    }

    private IntervalTreeNode buildNode(List list, float f2) {
        float f3 = f2;
        float f4 = -1.0E38f;
        float f5 = 1.0E38f;
        float f6 = 1.0E38f;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        List list5 = null;
        float f7 = -1.0E38f;
        float f8 = -1.0E38f;
        float f9 = 1.0E38f;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Interval interval = (Interval) list.get(i2);
            if (interval.start < f3 && interval.end < f3) {
                if (list4 == null) {
                    list4 = new ArrayList();
                }
                list4.add(interval);
                float f10 = interval.start;
                if (f9 >= f10) {
                    f9 = f10;
                }
                float f11 = interval.end;
                if (f4 <= f11) {
                    f4 = f11;
                }
            } else if (interval.start <= f3 || interval.end <= f3) {
                if (list2 == null || list3 == null) {
                    list2 = new ArrayList();
                    list3 = new ArrayList();
                }
                float f12 = interval.start;
                if (f12 < f6) {
                    f6 = f12;
                }
                float f13 = interval.end;
                if (f13 > f8) {
                    f8 = f13;
                }
                list2.add(interval);
                list3.add(interval);
            } else {
                if (list5 == null) {
                    list5 = new ArrayList();
                }
                list5.add(interval);
                float f14 = interval.start;
                if (f5 >= f14) {
                    f5 = f14;
                }
                float f15 = interval.end;
                if (f7 <= f15) {
                    f7 = f15;
                }
            }
        }
        if (list2 != null) {
            Collections.sort(list2, byStartComparator);
            Collections.sort(list3, byEndComparator);
        }
        IntervalTreeNode intervalTreeNode = new IntervalTreeNode();
        intervalTreeNode.byBeginning = list2;
        intervalTreeNode.byEnding = list3;
        intervalTreeNode.center = f3;
        if (list4 != null) {
            IntervalTreeNode buildNode = buildNode(list4, (f9 + f4) / 2.0f);
            intervalTreeNode.left = buildNode;
            buildNode.childrenMinMax = f4;
        }
        if (list5 != null) {
            IntervalTreeNode buildNode2 = buildNode(list5, (f7 + f5) / 2.0f);
            intervalTreeNode.right = buildNode2;
            buildNode2.childrenMinMax = f5;
        }
        return intervalTreeNode;
    }

    private void preprocess(int i2, int[] iArr) {
        int i3;
        this.minY = 1.0E38f;
        this.minX = 1.0E38f;
        this.maxY = -1.0E38f;
        this.maxX = -1.0E38f;
        ArrayList arrayList = new ArrayList(i2);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1;
        while (i7 < i2) {
            if (iArr == null || iArr.length <= i5 || iArr[i5] != i7) {
                int i8 = i6;
                i6 = i7;
                i3 = i8;
            } else {
                float[] fArr = this.verticesXY;
                int i9 = i7 - 1;
                float f2 = fArr[(i9 * 2) + 1];
                float f3 = fArr[(i4 * 2) + 1];
                Interval interval = new Interval();
                interval.start = f2 < f3 ? f2 : f3;
                if (f3 > f2) {
                    f2 = f3;
                }
                interval.end = f2;
                interval.f1233i = i9;
                interval.f1234j = i4;
                interval.polyIndex = i5;
                arrayList.add(interval);
                i5++;
                int i10 = i7 + 1;
                int i11 = i10 - 1;
                int i12 = i10;
                i4 = i7;
                i3 = i11;
                i6 = i12;
            }
            float[] fArr2 = this.verticesXY;
            int i13 = i6 * 2;
            float f4 = fArr2[i13 + 1];
            float f5 = fArr2[i13 + 0];
            float f6 = fArr2[(i3 * 2) + 1];
            float f7 = this.minX;
            if (f5 < f7) {
                f7 = f5;
            }
            this.minX = f7;
            float f8 = this.minY;
            if (f4 < f8) {
                f8 = f4;
            }
            this.minY = f8;
            float f9 = this.maxX;
            if (f5 <= f9) {
                f5 = f9;
            }
            this.maxX = f5;
            float f10 = this.maxY;
            if (f4 > f10) {
                f10 = f4;
            }
            this.maxY = f10;
            Interval interval2 = new Interval();
            interval2.start = f4 < f6 ? f4 : f6;
            if (f6 > f4) {
                f4 = f6;
            }
            interval2.end = f4;
            interval2.f1233i = i6;
            interval2.f1234j = i3;
            interval2.polyIndex = i5;
            arrayList.add(interval2);
            i7 = i6 + 1;
        }
        float[] fArr3 = this.verticesXY;
        int i14 = i7 - 1;
        int i15 = i14 * 2;
        float f11 = fArr3[i15 + 1];
        float f12 = fArr3[i15 + 0];
        float f13 = fArr3[(i4 * 2) + 1];
        float f14 = this.minX;
        if (f12 < f14) {
            f14 = f12;
        }
        this.minX = f14;
        float f15 = this.minY;
        if (f11 < f15) {
            f15 = f11;
        }
        this.minY = f15;
        float f16 = this.maxX;
        if (f12 <= f16) {
            f12 = f16;
        }
        this.maxX = f12;
        float f17 = this.maxY;
        if (f11 > f17) {
            f17 = f11;
        }
        this.maxY = f17;
        Interval interval3 = new Interval();
        interval3.start = f11 < f13 ? f11 : f13;
        if (f13 > f11) {
            f11 = f13;
        }
        interval3.end = f11;
        interval3.f1233i = i14;
        interval3.f1234j = i4;
        interval3.polyIndex = i5;
        arrayList.add(interval3);
        float f18 = this.maxX;
        float f19 = (this.minX + f18) * 0.5f;
        this.centerX = f19;
        float f20 = this.maxY;
        float f21 = (this.minY + f20) * 0.5f;
        this.centerY = f21;
        float f22 = f18 - f19;
        float f23 = f20 - f21;
        this.radiusSquared = (f23 * f23) + (f22 * f22);
        this.tree = buildNode(arrayList, f21);
    }

    public boolean testPoint(float f2, float f3) {
        return testPoint(f2, f3, null);
    }

    public boolean testPoint(float f2, float f3, BitSet bitSet) {
        float f4 = f2 - this.centerX;
        float f5 = f3 - this.centerY;
        if (bitSet != null) {
            bitSet.clear();
        }
        if ((f5 * f5) + (f4 * f4) <= this.radiusSquared && this.maxX >= f2 && this.maxY >= f3 && this.minX <= f2 && this.minY <= f3) {
            return this.tree.traverse(this.verticesXY, f2, f3, false, bitSet);
        }
        return false;
    }
}
