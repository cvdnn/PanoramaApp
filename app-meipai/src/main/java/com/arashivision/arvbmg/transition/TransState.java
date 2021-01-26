package com.arashivision.arvbmg.transition;

import e.a.a.a.a;

public class TransState {
    public double distance;
    public double fov;
    public double pitch;
    public double roll;
    public double yaw;

    public String toString() {
        StringBuilder a2 = a.a("TransState{fov=");
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
