package com.arashivision.arvbmg.previewer;

import java.util.List;

public abstract class BMGSourceClip {
    public long[] mediaPartSize;
    public List<String> url;

    public long getMediaPartSize() {
        long[] jArr = this.mediaPartSize;
        if (jArr == null || jArr.length <= 0) {
            return 0;
        }
        return jArr[0];
    }

    public long[] getMediaPartSizes() {
        return this.mediaPartSize;
    }

    public String getUrl() {
        return (String) this.url.get(0);
    }

    public List<String> getUrls() {
        return this.url;
    }
}
