package com.arashivision.arvbmg.render.lottie.utils;

import com.arashivision.arvbmg.render.lottie.data.BezierKeyFrame;
import com.arashivision.arvbmg.render.lottie.data.FloatBezierData;
import com.arashivision.arvbmg.render.lottie.data.IntBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.PathBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.PointBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.ScaleBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.SizeBezierData;
import e.a.a.a.a;
import e.g.b.l;
import e.g.b.o;
import e.g.b.t;
import java.util.ArrayList;
import java.util.List;

public class BezierDataUtils {
    public static float INS_Cubed(float f2) {
        return f2 * f2 * f2;
    }

    public static float INS_CubicRoot(float f2) {
        return (float) Math.pow((double) f2, 0.3333333432674408d);
    }

    public static float INS_SolveCubic(float f2, float f3, float f4, float f5) {
        if (f2 == 0.0f) {
            return INS_SolveQuadratic(f3, f4, f5);
        }
        if (f5 == 0.0f) {
            return 0.0f;
        }
        float f6 = f3 / f2;
        float f7 = f4 / f2;
        float INS_Squared = ((f7 * 3.0f) - INS_Squared(f6)) / 9.0f;
        float INS_Squared2 = ((((f7 * 9.0f) - (INS_Squared(f6) * 2.0f)) * f6) + ((f5 / f2) * -27.0f)) / 54.0f;
        float INS_Squared3 = INS_Squared(INS_Squared2) + INS_Cubed(INS_Squared);
        float f8 = f6 / 3.0f;
        int i2 = (INS_Squared3 > 0.0f ? 1 : (INS_Squared3 == 0.0f ? 0 : -1));
        if (i2 > 0) {
            double d2 = (double) INS_Squared2;
            double d3 = (double) INS_Squared3;
            float sqrt = (float) (Math.sqrt(d3) + d2);
            float sqrt2 = (float) (d2 - Math.sqrt(d3));
            float INS_CubicRoot = (-f8) + (sqrt < 0.0f ? -INS_CubicRoot(-sqrt) : INS_CubicRoot(sqrt)) + (sqrt2 < 0.0f ? -INS_CubicRoot(-sqrt2) : INS_CubicRoot(sqrt2));
            if (INS_CubicRoot >= 0.0f && INS_CubicRoot <= 1.0f) {
                return INS_CubicRoot;
            }
        } else if (i2 == 0) {
            float INS_CubicRoot2 = INS_Squared2 < 0.0f ? -INS_CubicRoot(-INS_Squared2) : INS_CubicRoot(INS_Squared2);
            float f9 = (2.0f * INS_CubicRoot2) + (-f8);
            if (f9 >= 0.0f && f9 <= 1.0f) {
                return f9;
            }
            float f10 = -(INS_CubicRoot2 + f8);
            if (f10 >= 0.0f && f10 <= 1.0f) {
                return f10;
            }
        } else {
            float f11 = -INS_Squared;
            float acos = (float) Math.acos(((double) INS_Squared2) / Math.sqrt((double) ((f11 * f11) * f11)));
            float sqrt3 = ((float) Math.sqrt((double) f11)) * 2.0f;
            float f12 = -f8;
            float cos = (((float) Math.cos((double) (acos / 3.0f))) * sqrt3) + f12;
            if (cos >= 0.0f && cos <= 1.0f) {
                return cos;
            }
            double d4 = (double) acos;
            float cos2 = (((float) Math.cos((6.283185307179586d + d4) / 3.0d)) * sqrt3) + f12;
            if (cos2 >= 0.0f && cos2 <= 1.0f) {
                return cos2;
            }
            float cos3 = (sqrt3 * ((float) Math.cos((d4 + 12.566370614359172d) / 3.0d))) + f12;
            if (cos3 >= 0.0f && cos3 <= 1.0f) {
                return cos3;
            }
        }
        return -1.0f;
    }

    public static float INS_SolveQuadratic(float f2, float f3, float f4) {
        float f5 = -f3;
        float f6 = 4.0f * f2 * f4;
        float f7 = f2 * 2.0f;
        float sqrt = (((float) Math.sqrt((double) (INS_Squared(f3) - f6))) + f5) / f7;
        if (sqrt >= 0.0f && sqrt <= 1.0f) {
            return sqrt;
        }
        float sqrt2 = (f5 - ((float) Math.sqrt((double) (INS_Squared(f3) - f6)))) / f7;
        if (sqrt2 < 0.0f || sqrt2 > 1.0f) {
            return -1.0f;
        }
        return sqrt2;
    }

    public static float INS_Squared(float f2) {
        return f2 * f2;
    }

    public static FloatBezierData createFloat(o oVar) {
        if (oVar != null) {
            if (oVar instanceof l) {
                l d2 = oVar.d();
                if (d2.size() == 1) {
                    return new FloatBezierData(d2.get(0).b());
                }
            } else if (oVar instanceof t) {
                return new FloatBezierData(oVar.b());
            }
        }
        return null;
    }

    public static IntBezierData createInt(o oVar) {
        if (oVar != null) {
            if (oVar instanceof l) {
                l d2 = oVar.d();
                if (d2.size() == 1) {
                    return new IntBezierData(d2.get(0).c());
                }
            } else if (oVar instanceof t) {
                return new IntBezierData(oVar.c());
            }
        }
        return null;
    }

    public static PathBezierData createPath(o oVar, int i2, int i3) {
        if (oVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        l d2 = oVar.d();
        for (int i4 = 0; i4 < d2.size(); i4++) {
            o oVar2 = d2.get(i4);
            if (oVar2 != null) {
                List parsePath = parsePath(oVar2.e().a("v"), i2, i3);
                if (parsePath != null) {
                    arrayList.add(parsePath);
                }
            }
        }
        return new PathBezierData(arrayList);
    }

    public static PointBezierData createPoint(o oVar, int i2, int i3) {
        if (oVar == null) {
            return null;
        }
        l d2 = oVar.d();
        return new PointBezierData(new float[]{d2.get(0).b() / ((float) i2), d2.get(1).b() / ((float) i3)});
    }

    public static ScaleBezierData createScale(o oVar) {
        if (oVar == null) {
            return null;
        }
        l d2 = oVar.d();
        return new ScaleBezierData(((float) d2.get(0).c()) / 100.0f, ((float) d2.get(1).c()) / 100.0f);
    }

    public static SizeBezierData createSize(o oVar) {
        if (oVar == null) {
            return null;
        }
        l d2 = oVar.d();
        return new SizeBezierData(d2.get(0).c(), d2.get(1).c());
    }

    public static float getBezierProgress(float[] fArr, float[] fArr2, float f2) {
        float f3;
        float[] fArr3 = {0.0f, 0.0f};
        float[] fArr4 = {1.0f, 1.0f};
        if (f2 <= fArr3[0]) {
            f3 = 0.0f;
        } else if (f2 >= fArr4[0]) {
            f3 = 1.0f;
        } else {
            f3 = INS_SolveCubic((((fArr[0] * 3.0f) + (-fArr3[0])) - (fArr2[0] * 3.0f)) + fArr4[0], (fArr2[0] * 3.0f) + ((fArr3[0] * 3.0f) - (fArr[0] * 6.0f)), (fArr[0] * 3.0f) + (fArr3[0] * -3.0f), fArr3[0] - f2);
            if (f3 == -1.0f) {
                return -1.0f;
            }
        }
        float f4 = 1.0f - f3;
        return (INS_Cubed(f3) * fArr4[1]) + (INS_Cubed(f3) * 3.0f * f4 * fArr2[1]) + (INS_Cubed(f4) * f3 * 3.0f * fArr[1]) + (INS_Cubed(f4) * fArr3[1]);
    }

    public static FloatBezierData getCurrentFloat(BezierKeyFrame bezierKeyFrame, float f2) {
        return new FloatBezierData((float) getCurrentValue(((FloatBezierData) bezierKeyFrame.getStartData()).getValue(), ((FloatBezierData) bezierKeyFrame.getEndData()).getValue(), f2));
    }

    public static IntBezierData getCurrentInt(BezierKeyFrame bezierKeyFrame, float f2) {
        return new IntBezierData((int) getCurrentValue((float) ((IntBezierData) bezierKeyFrame.getStartData()).getValue(), (float) ((IntBezierData) bezierKeyFrame.getEndData()).getValue(), f2));
    }

    public static PathBezierData getCurrentPath(BezierKeyFrame bezierKeyFrame, float f2) {
        ArrayList arrayList = new ArrayList();
        List paths = ((PathBezierData) bezierKeyFrame.getStartData()).getPaths();
        List paths2 = ((PathBezierData) bezierKeyFrame.getEndData()).getPaths();
        for (int i2 = 0; i2 < paths.size(); i2++) {
            ArrayList arrayList2 = new ArrayList();
            List list = (List) paths.get(i2);
            List list2 = (List) paths2.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                float[] fArr = (float[]) list.get(i3);
                float[] fArr2 = (float[]) list2.get(i3);
                arrayList2.add(new float[]{(float) getCurrentValue(fArr[0], fArr2[0], f2), (float) getCurrentValue(fArr[1], fArr2[1], f2)});
            }
            arrayList.add(arrayList2);
        }
        return new PathBezierData(arrayList);
    }

    public static PointBezierData getCurrentPoint(BezierKeyFrame bezierKeyFrame, float f2) {
        return new PointBezierData(new float[]{(float) getCurrentValue(((PointBezierData) bezierKeyFrame.getStartData()).getPoint()[0], ((PointBezierData) bezierKeyFrame.getEndData()).getPoint()[0], f2), (float) getCurrentValue(((PointBezierData) bezierKeyFrame.getStartData()).getPoint()[1], ((PointBezierData) bezierKeyFrame.getEndData()).getPoint()[1], f2)});
    }

    public static ScaleBezierData getCurrentScale(BezierKeyFrame bezierKeyFrame, float f2) {
        return new ScaleBezierData((float) getCurrentValue(((ScaleBezierData) bezierKeyFrame.getStartData()).getXScale(), ((ScaleBezierData) bezierKeyFrame.getEndData()).getXScale(), f2), (float) getCurrentValue(((ScaleBezierData) bezierKeyFrame.getStartData()).getYScale(), ((ScaleBezierData) bezierKeyFrame.getEndData()).getYScale(), f2));
    }

    public static SizeBezierData getCurrentSize(BezierKeyFrame bezierKeyFrame, float f2) {
        return new SizeBezierData((int) getCurrentValue((float) ((SizeBezierData) bezierKeyFrame.getStartData()).getWidth(), (float) ((SizeBezierData) bezierKeyFrame.getEndData()).getWidth(), f2), (int) getCurrentValue((float) ((SizeBezierData) bezierKeyFrame.getStartData()).getHeight(), (float) ((SizeBezierData) bezierKeyFrame.getEndData()).getHeight(), f2));
    }

    public static double getCurrentValue(float f2, float f3, float f4) {
        return (double) a.e(f3, f2, f4, f2);
    }

    public static List<float[]> parsePath(o oVar, int i2, int i3) {
        if (oVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        l d2 = oVar.d();
        for (int i4 = 0; i4 < d2.size(); i4++) {
            o oVar2 = d2.get(i4);
            if (oVar2 != null) {
                l d3 = oVar2.d();
                arrayList.add(new float[]{d3.get(0).b() / ((float) i2), d3.get(1).b() / ((float) i3)});
            }
        }
        return arrayList;
    }
}
