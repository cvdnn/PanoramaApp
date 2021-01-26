package com.arashivision.insta360.basecamera.util;

import com.arashivision.insta360.basecamera.camera.BaseCamera;
import e.b.c.a.b.a;
import e.b.c.a.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CameraMediaUtils {
    public static List<String> OooO00o(BaseCamera baseCamera, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 >= 0) {
            List OooO00o = OooO00o(baseCamera, i3, 100, i2);
            arrayList.addAll(OooO00o);
            i3 = ((ArrayList) OooO00o).size() == 100 ? i3 + 100 : -1;
        }
        return arrayList;
    }

    public static List<String> OooO00o(BaseCamera baseCamera, int i2, int i3, int i4) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ArrayList arrayList = new ArrayList();
        baseCamera.getFileList(i4, i2, i3, new a(arrayList, countDownLatch));
        try {
            countDownLatch.await();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public static /* synthetic */ void OooO00o(ArrayList arrayList, CountDownLatch countDownLatch, int i2, List list) {
        if (i2 == 0) {
            arrayList.addAll(list);
        }
        countDownLatch.countDown();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<com.arashivision.onecamera.cameraresponse.FileInfo>, for r5v0, types: [java.util.List, java.util.List<com.arashivision.onecamera.cameraresponse.FileInfo>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void OooO00o(java.util.HashMap r2, java.util.concurrent.CountDownLatch r3, int r4, java.util.List<com.arashivision.onecamera.cameraresponse.FileInfo> r5) {
        /*
            if (r4 != 0) goto L_0x0026
            java.util.Iterator r4 = r5.iterator()
        L_0x0006:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0026
            java.lang.Object r5 = r4.next()
            com.arashivision.onecamera.cameraresponse.FileInfo r5 = (com.arashivision.onecamera.cameraresponse.FileInfo) r5
            java.lang.String r0 = r5.mUrl
            if (r0 == 0) goto L_0x0006
            java.lang.String r1 = ".raw"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L_0x0006
            java.lang.String r0 = r5.mUrl
            byte[] r5 = r5.extraData
            r2.put(r0, r5)
            goto L_0x0006
        L_0x0026:
            r3.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basecamera.util.CameraMediaUtils.OooO00o(java.util.HashMap, java.util.concurrent.CountDownLatch, int, java.util.List):void");
    }

    public static List<String> getAllFileList(BaseCamera baseCamera) {
        if (!baseCamera.isReady() || baseCamera.getStorageCardState() == 1) {
            return new ArrayList();
        }
        List instaFileList = getInstaFileList(baseCamera, false);
        List OooO00o = OooO00o(baseCamera, 5);
        List OooO00o2 = OooO00o(baseCamera, 4);
        ArrayList arrayList = new ArrayList(instaFileList);
        Iterator it = ((ArrayList) OooO00o).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        Iterator it2 = ((ArrayList) OooO00o2).iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (!arrayList.contains(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static HashMap<String, byte[]> getFileInfoMap(BaseCamera baseCamera) {
        if (!baseCamera.isReady() || baseCamera.getStorageCardState() == 1) {
            return new HashMap<>();
        }
        HashMap<String, byte[]> hashMap = new HashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        baseCamera.getFileInfoList(new b(hashMap, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public static List<String> getInstaFileList(BaseCamera baseCamera, boolean z) {
        if (!baseCamera.isReady() || baseCamera.getStorageCardState() == 1) {
            return new ArrayList();
        }
        return OooO00o(baseCamera, z ? 3 : 2);
    }
}
