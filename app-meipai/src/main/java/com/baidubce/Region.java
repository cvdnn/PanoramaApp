package com.baidubce;

import com.baidubce.util.CheckUtils;
import e.a.a.a.a;
import java.util.Arrays;
import java.util.List;

public enum Region {
    CN_N1("bj");
    
    public List<String> regionIds;

    /* access modifiers changed from: public */
    Region(String... strArr) {
        CheckUtils.isNotNull(strArr, "regionIds should not be null.");
        CheckUtils.checkArgument(strArr.length > 0, "regionIds should not be empty");
        this.regionIds = Arrays.asList(strArr);
    }

    public static Region fromValue(String str) {
        Region[] values;
        CheckUtils.isNotNull(str, "regionId should not be null.");
        for (Region region : values()) {
            List<String> list = region.regionIds;
            if (list != null && list.contains(str)) {
                return region;
            }
        }
        throw new IllegalArgumentException(a.a("Cannot create region from ", str));
    }

    public String toString() {
        return (String) this.regionIds.get(0);
    }
}
