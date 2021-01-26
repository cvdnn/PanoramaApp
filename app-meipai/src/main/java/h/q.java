package h;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Options */
public final class q extends AbstractList<h> implements RandomAccess {

    /* renamed from: a reason: collision with root package name */
    public final h[] f9670a;

    /* renamed from: b reason: collision with root package name */
    public final int[] f9671b;

    public q(h[] hVarArr, int[] iArr) {
        this.f9670a = hVarArr;
        this.f9671b = iArr;
    }

    public static q a(h... hVarArr) {
        if (hVarArr.length == 0) {
            return new q(new h[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(hVarArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(Integer.valueOf(-1));
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.set(Collections.binarySearch(arrayList, hVarArr[i3]), Integer.valueOf(i3));
        }
        if (((h) arrayList.get(0)).d() != 0) {
            int i4 = 0;
            while (i4 < arrayList.size()) {
                h hVar = (h) arrayList.get(i4);
                int i5 = i4 + 1;
                int i6 = i5;
                while (i6 < arrayList.size()) {
                    h hVar2 = (h) arrayList.get(i6);
                    if (hVar2 == null) {
                        throw null;
                    } else if (!hVar2.a(0, hVar, 0, hVar.d())) {
                        continue;
                        break;
                    } else if (hVar2.d() == hVar.d()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("duplicate option: ");
                        sb.append(hVar2);
                        throw new IllegalArgumentException(sb.toString());
                    } else if (((Integer) arrayList2.get(i6)).intValue() > ((Integer) arrayList2.get(i4)).intValue()) {
                        arrayList.remove(i6);
                        arrayList2.remove(i6);
                    } else {
                        i6++;
                    }
                }
                i4 = i5;
            }
            e eVar = new e();
            a(0, eVar, 0, arrayList, 0, arrayList.size(), arrayList2);
            int i7 = (int) (eVar.f9647b / 4);
            int[] iArr = new int[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                iArr[i8] = eVar.readInt();
            }
            if (eVar.g()) {
                return new q((h[]) hVarArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    public Object get(int i2) {
        return this.f9670a[i2];
    }

    public final int size() {
        return this.f9670a.length;
    }

    public static void a(long j2, e eVar, int i2, List<h> list, int i3, int i4, List<Integer> list2) {
        int i5;
        int i6;
        int i7;
        e eVar2;
        e eVar3 = eVar;
        int i8 = i2;
        List<h> list3 = list;
        int i9 = i3;
        int i10 = i4;
        List<Integer> list4 = list2;
        if (i9 < i10) {
            int i11 = i9;
            while (i11 < i10) {
                if (((h) list3.get(i11)).d() >= i8) {
                    i11++;
                } else {
                    throw new AssertionError();
                }
            }
            h hVar = (h) list.get(i3);
            h hVar2 = (h) list3.get(i10 - 1);
            int i12 = -1;
            if (i8 == hVar.d()) {
                i12 = ((Integer) list4.get(i9)).intValue();
                i9++;
                hVar = (h) list3.get(i9);
            }
            int i13 = i9;
            long j3 = 4;
            if (hVar.a(i8) != hVar2.a(i8)) {
                int i14 = 1;
                for (int i15 = i13 + 1; i15 < i10; i15++) {
                    if (((h) list3.get(i15 - 1)).a(i8) != ((h) list3.get(i15)).a(i8)) {
                        i14++;
                    }
                }
                long j4 = j2 + ((long) ((int) (eVar3.f9647b / 4))) + 2 + ((long) (i14 * 2));
                eVar3.writeInt(i14);
                eVar3.writeInt(i12);
                for (int i16 = i13; i16 < i10; i16++) {
                    byte a2 = ((h) list3.get(i16)).a(i8);
                    if (i16 == i13 || a2 != ((h) list3.get(i16 - 1)).a(i8)) {
                        eVar3.writeInt((int) a2 & 255);
                    }
                }
                e eVar4 = new e();
                int i17 = i13;
                while (i17 < i10) {
                    byte a3 = ((h) list3.get(i17)).a(i8);
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        if (i19 >= i10) {
                            i6 = i10;
                            break;
                        } else if (a3 != ((h) list3.get(i19)).a(i8)) {
                            i6 = i19;
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i18 == i6 && i8 + 1 == ((h) list3.get(i17)).d()) {
                        eVar3.writeInt(((Integer) list4.get(i17)).intValue());
                        i7 = i6;
                        eVar2 = eVar4;
                    } else {
                        eVar3.writeInt((int) ((((long) ((int) (eVar4.f9647b / j3))) + j4) * -1));
                        i7 = i6;
                        eVar2 = eVar4;
                        a(j4, eVar4, i8 + 1, list, i17, i6, list2);
                    }
                    eVar4 = eVar2;
                    i17 = i7;
                    j3 = 4;
                }
                e eVar5 = eVar4;
                eVar3.a(eVar5, eVar5.f9647b);
                return;
            }
            int i20 = 0;
            int min = Math.min(hVar.d(), hVar2.d());
            int i21 = i8;
            while (i21 < min && hVar.a(i21) == hVar2.a(i21)) {
                i20++;
                i21++;
            }
            long j5 = 1 + j2 + ((long) ((int) (eVar3.f9647b / 4))) + 2 + ((long) i20);
            eVar3.writeInt(-i20);
            eVar3.writeInt(i12);
            int i22 = i8;
            while (true) {
                i5 = i8 + i20;
                if (i22 >= i5) {
                    break;
                }
                eVar3.writeInt((int) hVar.a(i22) & 255);
                i22++;
            }
            if (i13 + 1 != i10) {
                e eVar6 = new e();
                eVar3.writeInt((int) ((((long) ((int) (eVar6.f9647b / 4))) + j5) * -1));
                a(j5, eVar6, i5, list, i13, i4, list2);
                eVar3.a(eVar6, eVar6.f9647b);
            } else if (i5 == ((h) list3.get(i13)).d()) {
                eVar3.writeInt(((Integer) list4.get(i13)).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }
}
