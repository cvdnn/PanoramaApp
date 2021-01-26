package com.arashivision.arvbmg.transition;

import e.a.a.a.a;

public class LayerEndCut {
    public String endCutJsonId;
    public int endPoint;
    public int startPoint;

    public String toString() {
        StringBuilder a2 = a.a("LayerEndCut{startPoint=");
        a2.append(this.startPoint);
        a2.append(", endPoint=");
        a2.append(this.endPoint);
        a2.append(", endCutJsonId='");
        a2.append(this.endCutJsonId);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
