package com.arashivision.sdkmedia.work;

import com.arashivision.insta360.basemedia.model.work.Work;
import com.arashivision.insta360.basemedia.util.MediaUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WorkUtils {
    public static List<WorkWrapper> getAllCameraWorks(String str, HashMap<String, byte[]> hashMap, List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = MediaUtils.searchCameraWorks(str, hashMap, list, list2).iterator();
        while (it.hasNext()) {
            arrayList.add(new WorkWrapper((Work) it.next()));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<WorkWrapper> getAllLocalWorks(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = MediaUtils.searchLocalWorks(str).iterator();
        while (it.hasNext()) {
            arrayList.add(new WorkWrapper((Work) it.next()));
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
