package com.arashivision.insta360.basemedia.util;

import a.a.a.a.a.f.c;
import android.text.TextUtils;
import com.arashivision.graphicpath.render.source.Asset;
import com.arashivision.insta360.basemedia.asset.AssetUtils;
import com.arashivision.insta360.basemedia.model.work.CameraWork;
import com.arashivision.insta360.basemedia.model.work.CameraWork.IL1Iii;
import com.arashivision.insta360.basemedia.model.work.LocalWork;
import com.arashivision.insta360.basemedia.model.work.Work;
import com.baidubce.BceConfig;
import e.b.c.b.c.a;
import e.b.c.b.c.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class MediaUtils {
    public static String I1I(String str) {
        return ILil(str).split("_")[3];
    }

    public static /* synthetic */ int IL1Iii(String str, String str2) {
        return Integer.parseInt(I1I(str)) - Integer.parseInt(I1I(str2));
    }

    public static c IL1Iii(HashMap<String, List<String>> hashMap, Entry<String, Asset> entry) {
        String[] strArr;
        String str = (String) entry.getKey();
        String fileUrlName = FileUtils.getFileUrlName(str);
        boolean z = ((String) entry.getKey()).endsWith(".mp4") || ((String) entry.getKey()).endsWith(".insv");
        if (fileUrlName.split("_").length != 5 || !z) {
            strArr = new String[]{str};
        } else {
            List<String> list = (List) hashMap.get(IL1Iii(str));
            if (list == null) {
                list = new ArrayList<>();
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : list) {
                if (ILil(str2).startsWith("VID")) {
                    arrayList.add(str2);
                }
                if (ILil(str2).startsWith("LRV")) {
                    arrayList2.add(str2);
                }
            }
            Collections.sort(arrayList, b.f5817a);
            Collections.sort(arrayList2, a.f5816a);
            strArr = new String[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String) arrayList.get(i2);
            }
            String[] strArr2 = new String[arrayList2.size()];
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                strArr2[i3] = (String) arrayList2.get(i3);
            }
        }
        c cVar = new c();
        cVar.f379a = strArr;
        Asset[] assetArr = new Asset[strArr.length];
        if (strArr.length > 0) {
            assetArr[0] = (Asset) entry.getValue();
        }
        cVar.f381c = assetArr;
        return cVar;
    }

    public static String IL1Iii(String str) {
        String[] split = ILil(str).split("_");
        if (split.length < 5) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(split[0].replace("LRV", "VID"));
        sb.append(split[1]);
        sb.append(split[2]);
        sb.append(split[4]);
        return sb.toString();
    }

    public static ArrayList<File> IL1Iii(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    arrayList.addAll(IL1Iii(file2));
                } else {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ int ILil(String str, String str2) {
        return Integer.parseInt(I1I(str)) - Integer.parseInt(I1I(str2));
    }

    public static String ILil(String str) {
        String[] split = str.split(BceConfig.BOS_DELIMITER);
        if (split.length > 0) {
            str = split[split.length - 1];
        }
        String[] split2 = str.split("\\.");
        return split2.length > 0 ? split2[0] : str;
    }

    public static List<c> searchCameraMediaModels(String str, HashMap<String, byte[]> hashMap, List<String> list, List<String> list2) {
        String[] strArr;
        a.a.a.a.a.f.d.a[] aVarArr;
        Object obj;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(entry.getKey(), AssetUtils.convert((byte[]) entry.getValue()));
        }
        HashMap hashMap3 = new HashMap();
        for (String str2 : list) {
            String IL1Iii = IL1Iii(str2);
            if (hashMap3.get(IL1Iii) == null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str2);
                obj = arrayList2;
            } else {
                List list3 = (List) hashMap3.get(IL1Iii);
                if (list3 == 0) {
                    list3 = new ArrayList();
                }
                list3.add(str2);
                obj = list3;
            }
            hashMap3.put(IL1Iii, obj);
        }
        HashMap hashMap4 = new HashMap();
        for (Entry entry2 : hashMap2.entrySet()) {
            Asset asset = (Asset) entry2.getValue();
            int subMediaType = AssetUtils.getSubMediaType(asset);
            String fileGroupIdentify = AssetUtils.getFileGroupIdentify(asset);
            int fileGroupIndex = AssetUtils.getFileGroupIndex(asset);
            if (subMediaType == a.a.a.a.b.c.PHOTO_HDR.f417a || subMediaType == a.a.a.a.b.c.PHOTO_INTERVALSHOOTING.f417a || subMediaType == a.a.a.a.b.c.PHOTO_BURST.f417a || subMediaType == a.a.a.a.b.c.PHOTO_AEB_NIGHT_MODE.f417a) {
                a.a.a.a.a.f.d.a[] aVarArr2 = (a.a.a.a.a.f.d.a[]) hashMap4.get(fileGroupIdentify);
                if (aVarArr2 == null) {
                    aVarArr2 = new a.a.a.a.a.f.d.a[0];
                }
                hashMap4.put(fileGroupIdentify, a.a.a.a.a.f.d.a.a(subMediaType, aVarArr2, new a.a.a.a.a.f.d.a((String) entry2.getKey(), asset), FileUtils.getFileUrlName((String) entry2.getKey()).split("_"), fileGroupIndex));
            } else {
                arrayList.add(IL1Iii(hashMap3, entry2));
            }
        }
        for (Entry entry3 : hashMap4.entrySet()) {
            ArrayList arrayList3 = new ArrayList();
            for (a.a.a.a.a.f.d.a aVar : (a.a.a.a.a.f.d.a[]) entry3.getValue()) {
                if (aVar != null) {
                    arrayList3.add(aVar);
                }
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                try {
                    if (TextUtils.isEmpty(((a.a.a.a.a.f.d.a) it.next()).f382a)) {
                        it.remove();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    throw e2;
                }
            }
            if (arrayList3.size() > 0) {
                c cVar = new c();
                String[] strArr2 = new String[arrayList3.size()];
                Asset[] assetArr = new Asset[arrayList3.size()];
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    strArr2[i2] = ((a.a.a.a.a.f.d.a) arrayList3.get(i2)).f382a;
                    assetArr[i2] = ((a.a.a.a.a.f.d.a) arrayList3.get(i2)).f383b;
                }
                cVar.f379a = strArr2;
                cVar.f381c = assetArr;
                arrayList.add(cVar);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            c cVar2 = (c) it2.next();
            String[] strArr3 = cVar2.f379a;
            if (strArr3 != null && strArr3.length > 0) {
                if (strArr3[0].endsWith(".jpg") || cVar2.f379a[0].endsWith(".insp")) {
                    ArrayList arrayList4 = new ArrayList();
                    for (String str3 : cVar2.f379a) {
                        for (String str4 : list2) {
                            if (ILil(str3).equals(ILil(str4))) {
                                arrayList4.add(str4);
                            }
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        cVar2.f380b = null;
                    } else {
                        String[] strArr4 = new String[arrayList4.size()];
                        for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                            strArr4[i3] = (String) arrayList4.get(i3);
                        }
                        cVar2.f380b = strArr4;
                    }
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<Work> searchCameraWorks(String str, HashMap<String, byte[]> hashMap, List<String> list, List<String> list2) {
        List<c> searchCameraMediaModels = searchCameraMediaModels(str, hashMap, list, list2);
        ArrayList<Work> arrayList = new ArrayList<>();
        for (c cVar : searchCameraMediaModels) {
            CameraWork cameraWork = new CameraWork(str, cVar.f379a, cVar.f381c, (IL1Iii) null);
            cameraWork.setRawUrls(cVar.f380b);
            arrayList.add(cameraWork);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x01aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<a.a.a.a.a.f.c> searchLocalMediaModels(java.lang.String r19) {
        /*
            java.io.File r0 = new java.io.File
            r1 = r19
            r0.<init>(r1)
            boolean r1 = r0.isDirectory()
            if (r1 != 0) goto L_0x0013
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        L_0x0013:
            java.util.ArrayList r0 = IL1Iii(r0)
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0023
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        L_0x0023:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0031:
            boolean r3 = r0.hasNext()
            java.lang.String r4 = "jpg"
            java.lang.String r5 = "insp"
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x009c
            java.lang.Object r3 = r0.next()
            java.io.File r3 = (java.io.File) r3
            long r8 = r3.length()
            r10 = 0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0031
            java.lang.String r8 = r3.getName()
            if (r8 == 0) goto L_0x0063
            int r9 = r8.length()
            if (r9 < r6) goto L_0x0063
            char r9 = r8.charAt(r7)
            r10 = 46
            if (r10 == r9) goto L_0x0063
            r9 = r6
            goto L_0x0064
        L_0x0063:
            r9 = r7
        L_0x0064:
            if (r9 == 0) goto L_0x0084
            boolean r5 = a.a.a.a.b.a.a(r8, r5)
            if (r5 != 0) goto L_0x0082
            java.lang.String r5 = "insv"
            boolean r5 = a.a.a.a.b.a.a(r8, r5)
            if (r5 != 0) goto L_0x0082
            java.lang.String r5 = "mp4"
            boolean r5 = a.a.a.a.b.a.a(r8, r5)
            if (r5 != 0) goto L_0x0082
            boolean r4 = a.a.a.a.b.a.a(r8, r4)
            if (r4 == 0) goto L_0x0084
        L_0x0082:
            r4 = r6
            goto L_0x0085
        L_0x0084:
            r4 = r7
        L_0x0085:
            if (r9 == 0) goto L_0x0090
            java.lang.String r5 = "dng"
            boolean r5 = a.a.a.a.b.a.a(r8, r5)
            if (r5 == 0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r6 = r7
        L_0x0091:
            if (r4 == 0) goto L_0x0096
            r1.add(r3)
        L_0x0096:
            if (r6 == 0) goto L_0x0031
            r2.add(r3)
            goto L_0x0031
        L_0x009c:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x00a5:
            boolean r3 = r1.hasNext()
            java.lang.String r8 = "LRV"
            r9 = 0
            if (r3 == 0) goto L_0x01b5
            java.lang.Object r3 = r1.next()
            java.io.File r3 = (java.io.File) r3
            a.a.a.a.a.f.d.a r10 = new a.a.a.a.a.f.d.a
            java.lang.String r11 = r3.getAbsolutePath()
            r10.<init>(r11, r9)
            java.lang.String r3 = r3.getName()
            java.lang.String r3 = com.arashivision.insta360.basemedia.util.FileUtils.removeFileExtension(r3)
            java.lang.String r11 = "_"
            java.lang.String[] r12 = r3.split(r11)
            com.arashivision.graphicpath.render.source.Asset r13 = r10.f383b
            java.lang.String r13 = com.arashivision.insta360.basemedia.asset.AssetUtils.getCameraType(r13)
            com.arashivision.insta360.basemedia.model.CameraType r14 = com.arashivision.insta360.basemedia.model.CameraType.NANOS
            java.lang.String r14 = r14.type
            boolean r13 = r13.equals(r14)
            r14 = 4
            if (r13 == 0) goto L_0x00e1
            int r13 = r12.length
            if (r13 != r14) goto L_0x00e1
            r13 = r6
            goto L_0x00e2
        L_0x00e1:
            r13 = r7
        L_0x00e2:
            int r15 = r12.length
            r9 = 5
            if (r15 == r9) goto L_0x00ef
            if (r13 == 0) goto L_0x00e9
            goto L_0x00ef
        L_0x00e9:
            a.a.a.a.a.f.d.a[] r8 = new a.a.a.a.a.f.d.a[r7]
            r0.put(r3, r8)
            goto L_0x00a5
        L_0x00ef:
            com.arashivision.graphicpath.render.source.Asset r3 = r10.f383b
            java.lang.String r3 = com.arashivision.insta360.basemedia.asset.AssetUtils.getFileGroupIdentify(r3)
            com.arashivision.graphicpath.render.source.Asset r13 = r10.f383b
            int r13 = com.arashivision.insta360.basemedia.asset.AssetUtils.getFileGroupIndex(r13)
            com.arashivision.graphicpath.render.source.Asset r15 = r10.f383b
            int r15 = com.arashivision.insta360.basemedia.asset.AssetUtils.getSubMediaType(r15)
            if (r3 == 0) goto L_0x010c
            java.lang.String r3 = com.arashivision.insta360.basemedia.util.FileUtils.getFileUrlName(r3)
            java.lang.String[] r3 = r3.split(r11)
            goto L_0x010d
        L_0x010c:
            r3 = 0
        L_0x010d:
            a.a.a.a.b.c r11 = a.a.a.a.b.c.PHOTO_HDR
            int r11 = r11.f417a
            r16 = 2
            if (r15 == r11) goto L_0x0145
            a.a.a.a.b.c r11 = a.a.a.a.b.c.PHOTO_INTERVALSHOOTING
            int r11 = r11.f417a
            if (r15 == r11) goto L_0x0145
            a.a.a.a.b.c r11 = a.a.a.a.b.c.PHOTO_BURST
            int r11 = r11.f417a
            if (r15 == r11) goto L_0x0145
            a.a.a.a.b.c r11 = a.a.a.a.b.c.PHOTO_AEB_NIGHT_MODE
            int r11 = r11.f417a
            if (r15 != r11) goto L_0x0128
            goto L_0x0145
        L_0x0128:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r9 = r12[r7]
            java.lang.String r11 = "VID"
            java.lang.String r8 = r9.replace(r8, r11)
            r3.append(r8)
            r8 = r12[r6]
            r3.append(r8)
            r8 = r12[r16]
            r3.append(r8)
            r8 = r12[r14]
            goto L_0x019b
        L_0x0145:
            if (r3 == 0) goto L_0x0168
            int r8 = r3.length
            if (r8 != r9) goto L_0x0168
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = r3[r7]
            r8.append(r9)
            r9 = r3[r6]
            r8.append(r9)
            r9 = r3[r16]
            r8.append(r9)
            r3 = r3[r14]
        L_0x0160:
            r8.append(r3)
            java.lang.String r3 = r8.toString()
            goto L_0x01a2
        L_0x0168:
            if (r3 == 0) goto L_0x0185
            int r8 = r3.length
            if (r8 != r14) goto L_0x0185
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = r3[r7]
            r8.append(r9)
            r9 = r3[r6]
            r8.append(r9)
            r9 = r3[r16]
            r8.append(r9)
            r9 = 3
            r3 = r3[r9]
            goto L_0x0160
        L_0x0185:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r8 = r12[r7]
            r3.append(r8)
            r8 = r12[r6]
            r3.append(r8)
            r8 = r12[r16]
            r3.append(r8)
            r8 = r12[r14]
        L_0x019b:
            r3.append(r8)
            java.lang.String r3 = r3.toString()
        L_0x01a2:
            java.lang.Object r8 = r0.get(r3)
            a.a.a.a.a.f.d.a[] r8 = (a.a.a.a.a.f.d.a[]) r8
            if (r8 != 0) goto L_0x01ac
            a.a.a.a.a.f.d.a[] r8 = new a.a.a.a.a.f.d.a[r7]
        L_0x01ac:
            a.a.a.a.a.f.d.a[] r8 = a.a.a.a.a.f.d.a.a(r15, r8, r10, r12, r13)
            r0.put(r3, r8)
            goto L_0x00a5
        L_0x01b5:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r3 = r0.size()
            if (r3 <= 0) goto L_0x0308
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x01cd:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0305
            java.lang.Object r6 = r0.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.lang.Object r6 = r6.getValue()
            a.a.a.a.a.f.d.a[] r6 = (a.a.a.a.a.f.d.a[]) r6
            int r10 = r6.length
            r11 = r7
        L_0x01e6:
            if (r11 >= r10) goto L_0x01f2
            r12 = r6[r11]
            if (r12 == 0) goto L_0x01ef
            r9.add(r12)
        L_0x01ef:
            int r11 = r11 + 1
            goto L_0x01e6
        L_0x01f2:
            int r6 = r9.size()
            if (r6 <= 0) goto L_0x01cd
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x0202:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0229
            java.lang.Object r11 = r9.next()
            a.a.a.a.a.f.d.a r11 = (a.a.a.a.a.f.d.a) r11
            java.lang.String r12 = r11.f382a
            boolean r12 = r12.contains(r8)
            if (r12 == 0) goto L_0x0223
            if (r10 != 0) goto L_0x021d
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x021d:
            java.lang.String r11 = r11.f382a
            r10.add(r11)
            goto L_0x0202
        L_0x0223:
            java.lang.String r11 = r11.f382a
            r6.add(r11)
            goto L_0x0202
        L_0x0229:
            a.a.a.a.a.f.c r9 = new a.a.a.a.a.f.c
            r9.<init>()
            if (r10 == 0) goto L_0x024e
            int r11 = r10.size()
            if (r11 <= 0) goto L_0x024e
            int r11 = r10.size()
            java.lang.String[] r11 = new java.lang.String[r11]
            r12 = r7
        L_0x023d:
            int r13 = r10.size()
            if (r12 >= r13) goto L_0x024f
            java.lang.Object r13 = r10.get(r12)
            java.lang.String r13 = (java.lang.String) r13
            r11[r12] = r13
            int r12 = r12 + 1
            goto L_0x023d
        L_0x024e:
            r11 = 0
        L_0x024f:
            boolean r10 = r6.isEmpty()
            if (r10 == 0) goto L_0x025b
            if (r11 == 0) goto L_0x025b
            r10 = 0
            r9.f379a = r10
            goto L_0x0275
        L_0x025b:
            int r10 = r6.size()
            java.lang.String[] r10 = new java.lang.String[r10]
            r11 = r7
        L_0x0262:
            int r12 = r6.size()
            if (r11 >= r12) goto L_0x0273
            java.lang.Object r12 = r6.get(r11)
            java.lang.String r12 = (java.lang.String) r12
            r10[r11] = r12
            int r11 = r11 + 1
            goto L_0x0262
        L_0x0273:
            r9.f379a = r10
        L_0x0275:
            java.lang.String[] r6 = r9.f379a
            if (r6 == 0) goto L_0x02fa
            r6 = r6[r7]
            boolean r6 = r6.endsWith(r4)
            if (r6 != 0) goto L_0x028b
            java.lang.String[] r6 = r9.f379a
            r6 = r6[r7]
            boolean r6 = r6.endsWith(r5)
            if (r6 == 0) goto L_0x02fa
        L_0x028b:
            int r6 = r2.size()
            if (r6 <= 0) goto L_0x02fa
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String[] r10 = r9.f379a
            int r11 = r10.length
            r12 = r7
        L_0x029a:
            if (r12 >= r11) goto L_0x02d3
            r13 = r10[r12]
            java.util.Iterator r14 = r2.iterator()
        L_0x02a2:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x02cd
            java.lang.Object r15 = r14.next()
            java.io.File r15 = (java.io.File) r15
            java.lang.String r7 = com.arashivision.insta360.basemedia.util.FileUtils.getFileUrlName(r13)
            java.lang.String r17 = r15.getName()
            r18 = r0
            java.lang.String r0 = com.arashivision.insta360.basemedia.util.FileUtils.getFileUrlName(r17)
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L_0x02c9
            java.lang.String r0 = r15.getAbsolutePath()
            r6.add(r0)
        L_0x02c9:
            r0 = r18
            r7 = 0
            goto L_0x02a2
        L_0x02cd:
            r18 = r0
            int r12 = r12 + 1
            r7 = 0
            goto L_0x029a
        L_0x02d3:
            r18 = r0
            int r0 = r6.size()
            if (r0 <= 0) goto L_0x02f6
            int r0 = r6.size()
            java.lang.String[] r0 = new java.lang.String[r0]
            r7 = 0
        L_0x02e2:
            int r10 = r6.size()
            if (r7 >= r10) goto L_0x02f3
            java.lang.Object r10 = r6.get(r7)
            java.lang.String r10 = (java.lang.String) r10
            r0[r7] = r10
            int r7 = r7 + 1
            goto L_0x02e2
        L_0x02f3:
            r9.f380b = r0
            goto L_0x02fc
        L_0x02f6:
            r0 = 0
            r9.f380b = r0
            goto L_0x02fd
        L_0x02fa:
            r18 = r0
        L_0x02fc:
            r0 = 0
        L_0x02fd:
            r3.add(r9)
            r0 = r18
            r7 = 0
            goto L_0x01cd
        L_0x0305:
            r1.addAll(r3)
        L_0x0308:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.util.MediaUtils.searchLocalMediaModels(java.lang.String):java.util.ArrayList");
    }

    public static ArrayList<Work> searchLocalWorks(String str) {
        ArrayList searchLocalMediaModels = searchLocalMediaModels(str);
        ArrayList<Work> arrayList = new ArrayList<>();
        Iterator it = searchLocalMediaModels.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            LocalWork localWork = new LocalWork(cVar.f379a, cVar.f381c);
            localWork.setRawUrls(cVar.f380b);
            arrayList.add(localWork);
        }
        return arrayList;
    }
}
