package com.arashivision.insbase.joml;

public class RayAabIntersection {
    public float c_xy;
    public float c_xz;
    public float c_yx;
    public float c_yz;
    public float c_zx;
    public float c_zy;
    public byte classification;
    public float dirX;
    public float dirY;
    public float dirZ;
    public float originX;
    public float originY;
    public float originZ;
    public float s_xy;
    public float s_xz;
    public float s_yx;
    public float s_yz;
    public float s_zx;
    public float s_zy;

    public RayAabIntersection() {
    }

    private boolean MMM(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX >= f2 && this.originY >= f3 && this.originZ >= f4 && ((this.s_xy * f2) - f6) + this.c_xy <= 0.0f && ((this.s_yx * f3) - f5) + this.c_yx <= 0.0f && ((this.s_zy * f4) - f6) + this.c_zy <= 0.0f && ((this.s_yz * f3) - f7) + this.c_yz <= 0.0f && ((this.s_xz * f2) - f7) + this.c_xz <= 0.0f && ((this.s_zx * f4) - f5) + this.c_zx <= 0.0f;
    }

    private boolean MMO(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originZ;
        return f8 >= f4 && f8 <= f7 && this.originX >= f2 && this.originY >= f3 && ((this.s_xy * f2) - f6) + this.c_xy <= 0.0f && ((this.s_yx * f3) - f5) + this.c_yx <= 0.0f;
    }

    private boolean MMP(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX >= f2 && this.originY >= f3 && this.originZ <= f7 && ((this.s_xy * f2) - f6) + this.c_xy <= 0.0f && ((this.s_yx * f3) - f5) + this.c_yx <= 0.0f && ((this.s_zy * f7) - f6) + this.c_zy <= 0.0f && ((this.s_yz * f3) - f4) + this.c_yz >= 0.0f && ((this.s_xz * f2) - f4) + this.c_xz >= 0.0f && ((this.s_zx * f7) - f5) + this.c_zx <= 0.0f;
    }

    private boolean MOM(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originY;
        return f8 >= f3 && f8 <= f6 && this.originX >= f2 && this.originZ >= f4 && ((this.s_xz * f2) - f7) + this.c_xz <= 0.0f && ((this.s_zx * f4) - f5) + this.c_zx <= 0.0f;
    }

    private boolean MOO(float f2, float f3, float f4, float f5, float f6) {
        if (this.originX >= f2) {
            float f7 = this.originY;
            if (f7 >= f3 && f7 <= f5) {
                float f8 = this.originZ;
                if (f8 >= f4 && f8 <= f6) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean MOP(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originY;
        return f8 >= f3 && f8 <= f6 && this.originX >= f2 && this.originZ <= f7 && ((this.s_xz * f2) - f4) + this.c_xz >= 0.0f && ((this.s_zx * f7) - f5) + this.c_zx <= 0.0f;
    }

    private boolean MPM(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX >= f2 && this.originY <= f6 && this.originZ >= f4 && ((this.s_xy * f2) - f3) + this.c_xy >= 0.0f && ((this.s_yx * f6) - f5) + this.c_yx <= 0.0f && ((this.s_zy * f4) - f3) + this.c_zy >= 0.0f && ((this.s_yz * f6) - f7) + this.c_yz <= 0.0f && ((this.s_xz * f2) - f7) + this.c_xz <= 0.0f && ((this.s_zx * f4) - f5) + this.c_zx <= 0.0f;
    }

    private boolean MPO(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originZ;
        return f8 >= f4 && f8 <= f7 && this.originX >= f2 && this.originY <= f6 && ((this.s_xy * f2) - f3) + this.c_xy >= 0.0f && ((this.s_yx * f6) - f5) + this.c_yx <= 0.0f;
    }

    private boolean MPP(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX >= f2 && this.originY <= f6 && this.originZ <= f7 && ((this.s_xy * f2) - f3) + this.c_xy >= 0.0f && ((this.s_yx * f6) - f5) + this.c_yx <= 0.0f && ((this.s_zy * f7) - f3) + this.c_zy >= 0.0f && ((this.s_yz * f6) - f4) + this.c_yz >= 0.0f && ((this.s_xz * f2) - f4) + this.c_xz >= 0.0f && ((this.s_zx * f7) - f5) + this.c_zx <= 0.0f;
    }

    private boolean OMM(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originX;
        return f8 >= f2 && f8 <= f5 && this.originY >= f3 && this.originZ >= f4 && ((this.s_zy * f4) - f6) + this.c_zy <= 0.0f && ((this.s_yz * f3) - f7) + this.c_yz <= 0.0f;
    }

    private boolean OMO(float f2, float f3, float f4, float f5, float f6) {
        if (this.originY >= f3) {
            float f7 = this.originX;
            if (f7 >= f2 && f7 <= f5) {
                float f8 = this.originZ;
                if (f8 >= f4 && f8 <= f6) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean OMP(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originX;
        return f8 >= f2 && f8 <= f5 && this.originY >= f3 && this.originZ <= f7 && ((this.s_zy * f7) - f6) + this.c_zy <= 0.0f && ((this.s_yz * f3) - f4) + this.c_yz >= 0.0f;
    }

    private boolean OOM(float f2, float f3, float f4, float f5, float f6) {
        if (this.originZ >= f4) {
            float f7 = this.originX;
            if (f7 >= f2 && f7 <= f5) {
                float f8 = this.originY;
                if (f8 >= f3 && f8 <= f6) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean OOP(float f2, float f3, float f4, float f5, float f6) {
        if (this.originZ <= f6) {
            float f7 = this.originX;
            if (f7 >= f2 && f7 <= f4) {
                float f8 = this.originY;
                if (f8 >= f3 && f8 <= f5) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean OPM(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originX;
        return f8 >= f2 && f8 <= f5 && this.originY <= f6 && this.originZ >= f4 && ((this.s_zy * f4) - f3) + this.c_zy >= 0.0f && ((this.s_yz * f6) - f7) + this.c_yz <= 0.0f;
    }

    private boolean OPO(float f2, float f3, float f4, float f5, float f6) {
        if (this.originY <= f5) {
            float f7 = this.originX;
            if (f7 >= f2 && f7 <= f4) {
                float f8 = this.originZ;
                if (f8 >= f3 && f8 <= f6) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean OPP(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originX;
        return f8 >= f2 && f8 <= f5 && this.originY <= f6 && this.originZ <= f7 && ((this.s_zy * f7) - f3) + this.c_zy <= 0.0f && ((this.s_yz * f6) - f4) + this.c_yz <= 0.0f;
    }

    private boolean PMM(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX <= f5 && this.originY >= f3 && this.originZ >= f4 && ((this.s_xy * f5) - f6) + this.c_xy <= 0.0f && ((this.s_yx * f3) - f2) + this.c_yx >= 0.0f && ((this.s_zy * f4) - f6) + this.c_zy <= 0.0f && ((this.s_yz * f3) - f7) + this.c_yz <= 0.0f && ((this.s_xz * f5) - f7) + this.c_xz <= 0.0f && ((this.s_zx * f4) - f2) + this.c_zx >= 0.0f;
    }

    private boolean PMO(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originZ;
        return f8 >= f4 && f8 <= f7 && this.originX <= f5 && this.originY >= f3 && ((this.s_xy * f5) - f6) + this.c_xy <= 0.0f && ((this.s_yx * f3) - f2) + this.c_yx >= 0.0f;
    }

    private boolean PMP(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX <= f5 && this.originY >= f3 && this.originZ <= f7 && ((this.s_xy * f5) - f6) + this.c_xy <= 0.0f && ((this.s_yx * f3) - f2) + this.c_yx >= 0.0f && ((this.s_zy * f7) - f6) + this.c_zy <= 0.0f && ((this.s_yz * f3) - f4) + this.c_yz >= 0.0f && ((this.s_xz * f5) - f4) + this.c_xz >= 0.0f && ((this.s_zx * f7) - f2) + this.c_zx >= 0.0f;
    }

    private boolean POM(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originY;
        return f8 >= f3 && f8 <= f6 && this.originX <= f5 && this.originZ >= f4 && ((this.s_xz * f5) - f7) + this.c_xz <= 0.0f && ((this.s_zx * f4) - f2) + this.c_zx >= 0.0f;
    }

    private boolean POO(float f2, float f3, float f4, float f5, float f6) {
        if (this.originX <= f4) {
            float f7 = this.originY;
            if (f7 >= f2 && f7 <= f5) {
                float f8 = this.originZ;
                if (f8 >= f3 && f8 <= f6) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean POP(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originY;
        return f8 >= f3 && f8 <= f6 && this.originX <= f5 && this.originZ <= f7 && ((this.s_xz * f5) - f4) + this.c_xz >= 0.0f && ((this.s_zx * f7) - f2) + this.c_zx <= 0.0f;
    }

    private boolean PPM(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX <= f5 && this.originY <= f6 && this.originZ >= f4 && ((this.s_xy * f5) - f3) + this.c_xy >= 0.0f && ((this.s_yx * f6) - f2) + this.c_yx >= 0.0f && ((this.s_zy * f4) - f3) + this.c_zy >= 0.0f && ((this.s_yz * f6) - f7) + this.c_yz <= 0.0f && ((this.s_xz * f5) - f7) + this.c_xz <= 0.0f && ((this.s_zx * f4) - f2) + this.c_zx >= 0.0f;
    }

    private boolean PPO(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = this.originZ;
        return f8 >= f4 && f8 <= f7 && this.originX <= f5 && this.originY <= f6 && ((this.s_xy * f5) - f3) + this.c_xy >= 0.0f && ((this.s_yx * f6) - f2) + this.c_yx >= 0.0f;
    }

    private boolean PPP(float f2, float f3, float f4, float f5, float f6, float f7) {
        return this.originX <= f5 && this.originY <= f6 && this.originZ <= f7 && ((this.s_xy * f5) - f3) + this.c_xy >= 0.0f && ((this.s_yx * f6) - f2) + this.c_yx >= 0.0f && ((this.s_zy * f7) - f3) + this.c_zy >= 0.0f && ((this.s_yz * f6) - f4) + this.c_yz >= 0.0f && ((this.s_xz * f5) - f4) + this.c_xz >= 0.0f && ((this.s_zx * f7) - f2) + this.c_zx >= 0.0f;
    }

    private void precomputeSlope() {
        float f2 = this.dirX;
        float f3 = 1.0f / f2;
        float f4 = this.dirY;
        float f5 = 1.0f / f4;
        float f6 = this.dirZ;
        float f7 = 1.0f / f6;
        float f8 = f2 * f5;
        this.s_yx = f8;
        float f9 = f4 * f3;
        this.s_xy = f9;
        float f10 = f4 * f7;
        this.s_zy = f10;
        float f11 = f5 * f6;
        this.s_yz = f11;
        float f12 = f6 * f3;
        this.s_xz = f12;
        float f13 = f7 * f2;
        this.s_zx = f13;
        float f14 = this.originY;
        float f15 = this.originX;
        this.c_xy = f14 - (f9 * f15);
        this.c_yx = f15 - (f8 * f14);
        float f16 = this.originZ;
        this.c_zy = f14 - (f10 * f16);
        this.c_yz = f16 - (f11 * f14);
        this.c_xz = f16 - (f12 * f15);
        this.c_zx = f15 - (f13 * f16);
        int signum = signum(f2);
        int i2 = signum + 1;
        this.classification = (byte) (i2 | ((signum(this.dirY) + 1) << 2) | ((signum(this.dirZ) + 1) << 4));
    }

    public static int signum(float f2) {
        if (f2 == 0.0f || Float.isNaN(f2)) {
            return 0;
        }
        return (((1 - Float.floatToIntBits(f2)) >>> 31) << 1) - 1;
    }

    public void set(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.originX = f2;
        this.originY = f3;
        this.originZ = f4;
        this.dirX = f5;
        this.dirY = f6;
        this.dirZ = f7;
        precomputeSlope();
    }

    public boolean test(float f2, float f3, float f4, float f5, float f6, float f7) {
        switch (this.classification) {
            case 0:
                return MMM(f2, f3, f4, f5, f6, f7);
            case 1:
                return OMM(f2, f3, f4, f5, f6, f7);
            case 2:
                return PMM(f2, f3, f4, f5, f6, f7);
            case 4:
                return MOM(f2, f3, f4, f5, f6, f7);
            case 5:
                return OOM(f2, f3, f4, f5, f6);
            case 6:
                return POM(f2, f3, f4, f5, f6, f7);
            case 8:
                return MPM(f2, f3, f4, f5, f6, f7);
            case 9:
                return OPM(f2, f3, f4, f5, f6, f7);
            case 10:
                return PPM(f2, f3, f4, f5, f6, f7);
            case 16:
                return MMO(f2, f3, f4, f5, f6, f7);
            case 17:
                return OMO(f2, f3, f4, f5, f7);
            case 18:
                return PMO(f2, f3, f4, f5, f6, f7);
            case 20:
                return MOO(f2, f3, f4, f6, f7);
            case 22:
                return POO(f3, f4, f5, f6, f7);
            case 24:
                return MPO(f2, f3, f4, f5, f6, f7);
            case 25:
                return OPO(f2, f4, f5, f6, f7);
            case 26:
                return PPO(f2, f3, f4, f5, f6, f7);
            case 32:
                return MMP(f2, f3, f4, f5, f6, f7);
            case 33:
                return OMP(f2, f3, f4, f5, f6, f7);
            case 34:
                return PMP(f2, f3, f4, f5, f6, f7);
            case 36:
                return MOP(f2, f3, f4, f5, f6, f7);
            case 37:
                return OOP(f2, f3, f5, f6, f7);
            case 38:
                return POP(f2, f3, f4, f5, f6, f7);
            case 40:
                return MPP(f2, f3, f4, f5, f6, f7);
            case 41:
                return OPP(f2, f3, f4, f5, f6, f7);
            case 42:
                return PPP(f2, f3, f4, f5, f6, f7);
            default:
                return false;
        }
    }

    public RayAabIntersection(float f2, float f3, float f4, float f5, float f6, float f7) {
        set(f2, f3, f4, f5, f6, f7);
    }
}
