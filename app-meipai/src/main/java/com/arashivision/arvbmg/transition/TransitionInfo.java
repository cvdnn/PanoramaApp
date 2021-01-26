package com.arashivision.arvbmg.transition;

import e.a.a.a.a;

public class TransitionInfo {
    public long frameCount;
    public LayerEndCut layerEndCut;
    public LayerInfo layerInfo1;
    public LayerInfo layerInfo2;

    private void setFrameCount(long j2) {
        this.frameCount = j2;
    }

    private void setLayerEndCut(LayerEndCut layerEndCut2) {
        this.layerEndCut = layerEndCut2;
    }

    private void setLayerInfo1(LayerInfo layerInfo) {
        this.layerInfo1 = layerInfo;
    }

    private void setLayerInfo2(LayerInfo layerInfo) {
        this.layerInfo2 = layerInfo;
    }

    public String toString() {
        StringBuilder a2 = a.a("TransitionInfo{, layerInfo1=");
        a2.append(this.layerInfo1);
        a2.append(", layerInfo2=");
        a2.append(this.layerInfo2);
        a2.append(", layerEndCut=");
        a2.append(this.layerEndCut);
        a2.append(", frameCount=");
        a2.append(this.frameCount);
        a2.append('}');
        return a2.toString();
    }
}
