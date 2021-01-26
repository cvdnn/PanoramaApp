package com.arashivision.arvbmg.previewer;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;
import e.a.a.a.a;

public class BMGPreviewerRenderSessionData {
    public ClipRenderInfo[] mClipRenderInfos;
    public int mCurClipIndex = -1;

    public void checkSingleClip() {
        ClipRenderInfo[] clipRenderInfoArr = this.mClipRenderInfos;
        String str = BMGConstants.TAG;
        if (clipRenderInfoArr == null) {
            Log.e(str, "checkSingleClip mClipRenderInfos null");
        } else if (clipRenderInfoArr.length != 1) {
            a.b(a.a("checkSingleClip error clip size:"), this.mClipRenderInfos.length, str);
        } else if (this.mCurClipIndex != 0) {
            a.b(a.a("checkSingleClip error clip index:"), this.mCurClipIndex, str);
            this.mCurClipIndex = 0;
        }
    }

    public ClipRenderInfo getClipRenderInfo() {
        return this.mClipRenderInfos[this.mCurClipIndex];
    }

    public ClipRenderInfo[] getClipRenderInfos() {
        return this.mClipRenderInfos;
    }

    public int getCurClipIndex() {
        return this.mCurClipIndex;
    }

    public void setClipRenderInfos(ClipRenderInfo[] clipRenderInfoArr) {
        this.mClipRenderInfos = clipRenderInfoArr;
    }

    public void setCurClipIndex(int i2) {
        this.mCurClipIndex = i2;
    }
}
