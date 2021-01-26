package com.arashivision.arvbmg.transition;

import e.a.a.a.a;
import java.util.Arrays;

public class LayerInfo {
    public KeyFrameState[] keyFrameStates;
    public SlerpCure[] slerpCures;

    public static class KeyFrameState {
        public StateEntity distance;
        public StateEntity fov;
        public String frameId;
        public StateEntity pitch;
        public int point;
        public StateEntity roll;
        public double timeRatio;
        public StateEntity yaw;

        public String toString() {
            StringBuilder a2 = a.a("KeyFrameState{timeRatio=");
            a2.append(this.timeRatio);
            a2.append(", point=");
            a2.append(this.point);
            a2.append(", frameId='");
            a.a(a2, this.frameId, '\'', ", fov=");
            a2.append(this.fov);
            a2.append(", distance=");
            a2.append(this.distance);
            a2.append(", yaw=");
            a2.append(this.yaw);
            a2.append(", pitch=");
            a2.append(this.pitch);
            a2.append(", roll=");
            a2.append(this.roll);
            a2.append('}');
            return a2.toString();
        }
    }

    public static class SlerpCure {
        public double bazierCtrlX1;
        public double bazierCtrlX2;
        public double bazierCtrlY1;
        public double bazierCtrlY2;
        public String fromFrameId;
        public String toFrameId;

        public String toString() {
            StringBuilder a2 = a.a("SlerpCure{fromFrameId='");
            a.a(a2, this.fromFrameId, '\'', ", toFrameId='");
            a.a(a2, this.toFrameId, '\'', ", bazierCtrlX1=");
            a2.append(this.bazierCtrlX1);
            a2.append(", bazierCtrlY1=");
            a2.append(this.bazierCtrlY1);
            a2.append(", bazierCtrlX2=");
            a2.append(this.bazierCtrlX2);
            a2.append(", bazierCtrlY2=");
            a2.append(this.bazierCtrlY2);
            a2.append('}');
            return a2.toString();
        }
    }

    public static class StateEntity {
        public int type;
        public double value;

        public String toString() {
            StringBuilder a2 = a.a("StateEntity{type=");
            a2.append(this.type);
            a2.append(", value=");
            a2.append(this.value);
            a2.append('}');
            return a2.toString();
        }
    }

    public String toString() {
        StringBuilder a2 = a.a("LayerInfo{keyFrameStates=");
        a2.append(Arrays.toString(this.keyFrameStates));
        a2.append(", slerpCures=");
        a2.append(Arrays.toString(this.slerpCures));
        a2.append('}');
        return a2.toString();
    }
}
