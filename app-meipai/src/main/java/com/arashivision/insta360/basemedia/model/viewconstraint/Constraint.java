package com.arashivision.insta360.basemedia.model.viewconstraint;

import com.arashivision.insta360.basemedia.util.FovDistanceUtils;
import e.a.a.a.a;

public class Constraint implements Cloneable {
    public float I1I;
    public String IL1Iii;
    public int ILL;
    public float ILil;
    public float Ilil;

    /* renamed from: I丨L reason: contains not printable characters */
    public float f43IL;

    /* renamed from: I丨iL reason: contains not printable characters */
    public float f44IiL;

    /* renamed from: L丨1丨1丨I reason: contains not printable characters */
    public float f45L11I;

    /* renamed from: iI丨LLL1 reason: contains not printable characters */
    public float f46iILLL1;

    /* renamed from: l丨Li1LL reason: contains not printable characters */
    public float f47lLi1LL;

    /* renamed from: 丨il reason: contains not printable characters */
    public float f48il;

    @Deprecated
    public Constraint(float f2, float f3, float f4, float f5, float f6, float f7) {
        this("", f2, f3, f4, f5, f6, f7, 0.0f);
    }

    public Constraint(int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7) {
        this("", i2, i3, f2, f3, f4, f5, f6, f7, 0.0f);
    }

    @Deprecated
    public Constraint(String str, float f2, float f3, float f4, float f5, float f6, float f7) {
        this(str, f2, f3, f4, f5, f6, f7, 0.0f);
    }

    @Deprecated
    public Constraint(String str, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f45L11I = 1.0f;
        this.f48il = 1.0f;
        this.ILL = 0;
        this.IL1Iii = str;
        this.ILil = f2;
        this.I1I = f3;
        this.f43IL = f4;
        this.Ilil = f5;
        this.f47lLi1LL = f6;
        this.f46iILLL1 = f7;
        this.f44IiL = f8;
    }

    public Constraint(String str, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7) {
        this(str, i2, i3, f2, f3, f4, f5, f6, f7, 0.0f);
    }

    public Constraint(String str, int i2, int i3, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f45L11I = 1.0f;
        this.f48il = 1.0f;
        this.ILL = 0;
        this.IL1Iii = str;
        this.ILil = (float) Math.toRadians((double) FovDistanceUtils.convertXFovToYFov((double) f2, i2, i3));
        this.I1I = (float) Math.toRadians((double) FovDistanceUtils.convertXFovToYFov((double) f3, i2, i3));
        this.f43IL = (float) Math.toRadians((double) FovDistanceUtils.convertXFovToYFov((double) f4, i2, i3));
        this.Ilil = FovDistanceUtils.convertRajawaliDistanceToBmgDistance(f5);
        this.f47lLi1LL = FovDistanceUtils.convertRajawaliDistanceToBmgDistance(f6);
        this.f46iILLL1 = FovDistanceUtils.convertRajawaliDistanceToBmgDistance(f7);
        this.f44IiL = (float) Math.toRadians((double) f8);
    }

    public Constraint clone() {
        Constraint constraint = new Constraint(this.IL1Iii, 1, 1, this.ILil, this.I1I, this.f43IL, this.Ilil, this.f47lLi1LL, this.f46iILLL1, this.f44IiL);
        constraint.setXScale(this.f45L11I);
        constraint.setYScale(this.f48il);
        constraint.setPovMode(this.ILL);
        return constraint;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Constraint)) {
            return false;
        }
        Constraint constraint = (Constraint) obj;
        return this.IL1Iii.equals(constraint.IL1Iii) && this.ILil == constraint.ILil && this.I1I == constraint.I1I && this.f43IL == constraint.f43IL && this.Ilil == constraint.Ilil && this.f47lLi1LL == constraint.f47lLi1LL && this.f46iILLL1 == constraint.f46iILLL1 && this.f45L11I == constraint.f45L11I && this.f48il == constraint.f48il && this.ILL == constraint.ILL;
    }

    public float getDefaultDistance() {
        return this.f46iILLL1;
    }

    public float getDefaultFov() {
        return this.f43IL;
    }

    public float getDefaultPitch() {
        return this.f44IiL;
    }

    public float getMaxDistance() {
        return this.f47lLi1LL;
    }

    public float getMaxFov() {
        return this.I1I;
    }

    public float getMinDistance() {
        return this.Ilil;
    }

    public float getMinFov() {
        return this.ILil;
    }

    public String getName() {
        return this.IL1Iii;
    }

    public int getPovMode() {
        return this.ILL;
    }

    public float getXScale() {
        return this.f45L11I;
    }

    public float getYScale() {
        return this.f48il;
    }

    public void setDefaultDistance(float f2) {
        this.f46iILLL1 = f2;
    }

    public void setDefaultFov(float f2) {
        this.f43IL = f2;
    }

    public void setDefaultPitch(float f2) {
        this.f44IiL = f2;
    }

    public void setMaxDistance(float f2) {
        this.f47lLi1LL = f2;
    }

    public void setMaxFov(float f2) {
        this.I1I = f2;
    }

    public void setMinDistance(float f2) {
        this.Ilil = f2;
    }

    public void setMinFov(float f2) {
        this.ILil = f2;
    }

    public void setName(String str) {
        this.IL1Iii = str;
    }

    public void setPovMode(int i2) {
        this.ILL = i2;
    }

    public void setXScale(float f2) {
        this.f45L11I = f2;
    }

    public void setYScale(float f2) {
        this.f48il = f2;
    }

    public String toString() {
        StringBuilder a2 = a.a("name: ");
        a2.append(this.IL1Iii);
        a2.append(", defaultFov: ");
        a2.append(this.f43IL);
        a2.append(", minFov: ");
        a2.append(this.ILil);
        a2.append(", maxFov: ");
        a2.append(this.I1I);
        a2.append(", defaultDistance: ");
        a2.append(this.f46iILLL1);
        a2.append(", minDistance: ");
        a2.append(this.Ilil);
        a2.append(", maxDistance: ");
        a2.append(this.f47lLi1LL);
        a2.append(", xScale: ");
        a2.append(this.f45L11I);
        a2.append(", yScale: ");
        a2.append(this.f48il);
        a2.append(", povMode: ");
        a2.append(this.ILL);
        return a2.toString();
    }
}
