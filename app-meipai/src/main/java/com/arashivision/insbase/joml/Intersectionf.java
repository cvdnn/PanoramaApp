package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;

public class Intersectionf {
    public static final int AAR_SIDE_MAXX = 2;
    public static final int AAR_SIDE_MAXY = 3;
    public static final int AAR_SIDE_MINX = 0;
    public static final int AAR_SIDE_MINY = 1;
    public static final int INSIDE = 3;
    public static final int ONE_INTERSECTION = 1;
    public static final int OUTSIDE = -1;
    public static final int POINT_ON_TRIANGLE_EDGE_01 = 4;
    public static final int POINT_ON_TRIANGLE_EDGE_12 = 5;
    public static final int POINT_ON_TRIANGLE_EDGE_20 = 6;
    public static final int POINT_ON_TRIANGLE_FACE = 2;
    public static final int POINT_ON_TRIANGLE_VERTEX_0 = 1;
    public static final int POINT_ON_TRIANGLE_VERTEX_1 = 2;
    public static final int POINT_ON_TRIANGLE_VERTEX_2 = 3;
    public static final int TWO_INTERSECTION = 2;

    public static float computeLowestRoot(float f2, float f3, float f4, float f5) {
        float f6 = (f3 * f3) - ((4.0f * f2) * f4);
        if (f6 < 0.0f) {
            return Float.POSITIVE_INFINITY;
        }
        float sqrt = (float) Math.sqrt((double) f6);
        float f7 = -f3;
        float f8 = f2 * 2.0f;
        float f9 = (f7 - sqrt) / f8;
        float f10 = (f7 + sqrt) / f8;
        if (f9 > f10) {
            float f11 = f9;
            f9 = f10;
            f10 = f11;
        }
        if (f9 > 0.0f && f9 < f5) {
            return f9;
        }
        if (f10 <= 0.0f || f10 >= f5) {
            return Float.POSITIVE_INFINITY;
        }
        return f10;
    }

    public static float distancePointLine(float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 * f5;
        return (((f5 * f3) + (f4 * f2)) + f6) / ((float) Math.sqrt((double) (f7 + (f4 * f4))));
    }

    public static float distancePointPlane(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f7 * f4;
        return ((f9 + ((f6 * f3) + (f5 * f2))) + f8) / ((float) Math.sqrt((double) ((f7 * f7) + ((f6 * f6) + (f5 * f5)))));
    }

    public static Vector3f findClosestPointOnLineSegment(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Vector3f vector3f) {
        float f11 = f5 - f2;
        float f12 = f6 - f3;
        float f13 = f7 - f4;
        float h2 = a.h(f13, f13, (f12 * f12) + (f11 * f11), a.e(f10, f4, f13, a.e(f9, f3, f12, (f8 - f2) * f11)));
        if (h2 < 0.0f) {
            h2 = 0.0f;
        }
        if (h2 > 1.0f) {
            h2 = 1.0f;
        }
        vector3f.x = (f11 * h2) + f2;
        vector3f.y = (f12 * h2) + f3;
        vector3f.z = (h2 * f13) + f4;
        return vector3f;
    }

    public static Vector3f findClosestPointOnPlane(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, Vector3f vector3f) {
        float f11 = f4 * f7;
        float f12 = ((f7 * f10) + ((f6 * f9) + (f5 * f8))) - (-(f11 + ((f3 * f6) + (f2 * f5))));
        vector3f.x = f8 - (f5 * f12);
        vector3f.y = f9 - (f6 * f12);
        vector3f.z = f10 - (f12 * f7);
        return vector3f;
    }

    public static Vector3f findClosestPointOnRectangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, Vector3f vector3f) {
        float f14;
        float f15;
        float f16;
        Vector3f vector3f2 = vector3f;
        float f17 = f5 - f2;
        float f18 = f6 - f3;
        float f19 = f7 - f4;
        float f20 = f8 - f2;
        float f21 = f9 - f3;
        float f22 = f10 - f4;
        float f23 = f11 - f2;
        float f24 = f12 - f3;
        float f25 = f13 - f4;
        float f26 = (f25 * f19) + a.f(f23, f17, f24, f18);
        float f27 = (f19 * f19) + (f18 * f18) + (f17 * f17);
        if (f26 >= f27) {
            f16 = f17 + f2;
            f15 = f18 + f3;
            f14 = f4 + f19;
        } else if (f26 > 0.0f) {
            float f28 = f26 / f27;
            f16 = (f17 * f28) + f2;
            f15 = (f18 * f28) + f3;
            f14 = (f28 * f19) + f4;
        } else {
            f16 = f2;
            f15 = f3;
            f14 = f4;
        }
        float f29 = f25 * f22;
        float f30 = f29 + (f24 * f21) + (f23 * f20);
        float f31 = (f22 * f22) + (f21 * f21) + (f20 * f20);
        if (f30 >= f31) {
            f16 += f20;
            f15 += f21;
            f14 += f22;
        } else if (f30 > 0.0f) {
            float f32 = f30 / f31;
            f16 += f20 * f32;
            f15 += f21 * f32;
            f14 += f32 * f22;
        }
        vector3f2.x = f16;
        vector3f2.y = f15;
        vector3f2.z = f14;
        return vector3f2;
    }

    public static int findClosestPointOnTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, Vector3f vector3f) {
        float f14 = f2;
        float f15 = f3;
        float f16 = f4;
        float f17 = f5;
        float f18 = f6;
        float f19 = f7;
        float f20 = f8;
        float f21 = f9;
        float f22 = f10;
        Vector3f vector3f2 = vector3f;
        float f23 = f17 - f14;
        float f24 = f18 - f15;
        float f25 = f19 - f16;
        float f26 = f20 - f14;
        float f27 = f21 - f15;
        float f28 = f22 - f16;
        float f29 = f11 - f14;
        float f30 = f12 - f15;
        float f31 = f13 - f16;
        float f32 = (f25 * f31) + (f24 * f30) + (f23 * f29);
        float f33 = f31 * f28;
        float f34 = f33 + (f30 * f27) + (f29 * f26);
        if (f32 > 0.0f || f34 > 0.0f) {
            float f35 = f11 - f17;
            float f36 = f12 - f18;
            float f37 = f13 - f19;
            float f38 = (f25 * f37) + (f24 * f36) + (f23 * f35);
            float f39 = f37 * f28;
            float f40 = f39 + (f36 * f27) + (f35 * f26);
            if (f38 < 0.0f || f40 > f38) {
                float f41 = (f32 * f40) - (f38 * f34);
                if (f41 > 0.0f || f32 < 0.0f || f38 > 0.0f) {
                    float f42 = f11 - f20;
                    float f43 = f12 - f21;
                    float f44 = f13 - f22;
                    float f45 = (f25 * f44) + (f24 * f43) + (f23 * f42);
                    float f46 = f44 * f28;
                    float f47 = f46 + (f43 * f27) + (f42 * f26);
                    if (f47 < 0.0f || f45 > f47) {
                        float f48 = (f45 * f34) - (f32 * f47);
                        if (f48 > 0.0f || f34 < 0.0f || f47 > 0.0f) {
                            float f49 = (f38 * f47) - (f45 * f40);
                            if (f49 <= 0.0f) {
                                float f50 = f40 - f38;
                                if (f50 >= 0.0f && f45 - f47 >= 0.0f) {
                                    float f51 = f50 / ((f50 + f45) - f47);
                                    vector3f2.x = a.e(f20, f17, f51, f17);
                                    vector3f2.y = a.e(f21, f18, f51, f18);
                                    vector3f2.z = a.e(f22, f19, f51, f19);
                                    return 5;
                                }
                            }
                            float f52 = 1.0f / ((f49 + f48) + f41);
                            float f53 = f48 * f52;
                            float f54 = f41 * f52;
                            vector3f2.x = (f26 * f54) + (f23 * f53) + f14;
                            vector3f2.y = (f27 * f54) + (f24 * f53) + f15;
                            vector3f2.z = (f28 * f54) + (f25 * f53) + f16;
                            return 2;
                        }
                        float f55 = f34 / (f34 - f47);
                        vector3f2.x = (f26 * f55) + f14;
                        vector3f2.y = (f27 * f55) + f15;
                        vector3f2.z = (f55 * f28) + f16;
                        return 6;
                    }
                    vector3f2.x = f20;
                    vector3f2.y = f21;
                    vector3f2.z = f22;
                    return 3;
                }
                float f56 = f32 / (f32 - f38);
                vector3f2.x = (f23 * f56) + f14;
                vector3f2.y = (f24 * f56) + f15;
                vector3f2.z = (f56 * f25) + f16;
                return 4;
            }
            vector3f2.x = f17;
            vector3f2.y = f18;
            vector3f2.z = f19;
            return 2;
        }
        vector3f2.x = f14;
        vector3f2.y = f15;
        vector3f2.z = f16;
        return 1;
    }

    public static float findClosestPointsLineSegmentTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, Vector3f vector3f, Vector3f vector3f2) {
        Vector3f vector3f3;
        float f17;
        float f18;
        float f19;
        Vector3f vector3f4;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26 = f4;
        float f27 = f7;
        float f28 = f2;
        float f29 = f3;
        float f30 = f4;
        float f31 = f5;
        float f32 = f6;
        float f33 = f7;
        Vector3f vector3f5 = vector3f2;
        Vector3f vector3f6 = vector3f;
        float findClosestPointsLineSegments = findClosestPointsLineSegments(f28, f29, f30, f31, f32, f33, f8, f9, f10, f11, f12, f13, vector3f, vector3f2);
        float f34 = vector3f6.x;
        float f35 = vector3f6.y;
        float f36 = vector3f6.z;
        float f37 = vector3f5.x;
        float f38 = vector3f5.y;
        float f39 = vector3f5.z;
        float f40 = f38;
        float f41 = f37;
        float f42 = f36;
        float f43 = f35;
        float f44 = f34;
        float findClosestPointsLineSegments2 = findClosestPointsLineSegments(f28, f29, f30, f31, f32, f33, f11, f12, f13, f14, f15, f16, vector3f, vector3f2);
        if (findClosestPointsLineSegments2 < findClosestPointsLineSegments) {
            float f45 = vector3f6.x;
            float f46 = vector3f6.y;
            float f47 = vector3f6.z;
            float f48 = vector3f5.x;
            float f49 = vector3f5.y;
            findClosestPointsLineSegments = findClosestPointsLineSegments2;
            f39 = vector3f5.z;
            f40 = f49;
            f41 = f48;
            f42 = f47;
            f43 = f46;
            f44 = f45;
        }
        float findClosestPointsLineSegments3 = findClosestPointsLineSegments(f2, f3, f4, f5, f6, f7, f14, f15, f16, f8, f9, f10, vector3f, vector3f2);
        if (findClosestPointsLineSegments3 < findClosestPointsLineSegments) {
            float f50 = vector3f6.x;
            float f51 = vector3f6.y;
            float f52 = vector3f6.z;
            float f53 = vector3f5.x;
            findClosestPointsLineSegments = findClosestPointsLineSegments3;
            f44 = f50;
            f43 = f51;
            f42 = f52;
            f41 = f53;
            f40 = vector3f5.y;
            f39 = vector3f5.z;
        }
        boolean z = false;
        float f54 = Float.NaN;
        if (testPointInTriangle(f2, f3, f4, f8, f9, f10, f11, f12, f13, f14, f15, f16)) {
            float f55 = f12 - f9;
            float f56 = f16 - f10;
            float f57 = f15 - f9;
            float f58 = f13 - f10;
            float f59 = f14 - f8;
            float f60 = f11 - f8;
            float f61 = (f55 * f56) - (f57 * f58);
            float f62 = (f58 * f59) - (f56 * f60);
            float f63 = (f60 * f57) - (f59 * f55);
            z = true;
            float sqrt = 1.0f / ((float) Math.sqrt((double) ((f63 * f63) + ((f62 * f62) + (f61 * f61)))));
            float f64 = f61 * sqrt;
            f18 = f62 * sqrt;
            float f65 = sqrt * f63;
            f17 = -((f65 * f10) + (f18 * f9) + (f64 * f8));
            float f66 = f4;
            vector3f3 = vector3f6;
            float f67 = a.f(f65, f66, (f18 * f3) + (f64 * f2), f17);
            float f68 = f67 * f67;
            if (f68 < findClosestPointsLineSegments) {
                f41 = f2 - (f64 * f67);
                f40 = f3 - (f18 * f67);
                f39 = f66 - (f67 * f65);
                f44 = f2;
                f43 = f3;
                f42 = f66;
                findClosestPointsLineSegments = f68;
            }
            float f69 = f64;
            f54 = f65;
            f19 = f69;
        } else {
            vector3f3 = vector3f6;
            f19 = Float.NaN;
            f18 = Float.NaN;
            f17 = Float.NaN;
        }
        if (testPointInTriangle(f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16)) {
            if (!z) {
                float f70 = f12 - f9;
                float f71 = f16 - f10;
                float f72 = f15 - f9;
                float f73 = f13 - f10;
                float f74 = f14 - f8;
                float f75 = f11 - f8;
                float f76 = (f70 * f71) - (f72 * f73);
                float f77 = (f73 * f74) - (f71 * f75);
                float f78 = (f75 * f72) - (f74 * f70);
                float sqrt2 = 1.0f / ((float) Math.sqrt((double) ((f78 * f78) + ((f77 * f77) + (f76 * f76)))));
                f19 = f76 * sqrt2;
                f18 = f77 * sqrt2;
                f54 = f78 * sqrt2;
                f17 = -((f54 * f10) + (f18 * f9) + (f19 * f8));
            }
            float f79 = f7;
            vector3f4 = vector3f5;
            float f80 = a.f(f54, f79, (f18 * f6) + (f19 * f5), f17);
            float f81 = f80 * f80;
            if (f81 < findClosestPointsLineSegments) {
                float f82 = f5 - (f19 * f80);
                float f83 = f6 - (f18 * f80);
                float f84 = f79 - (f54 * f80);
                f25 = f5;
                f23 = f79;
                findClosestPointsLineSegments = f81;
                f22 = f84;
                f21 = f83;
                f20 = f82;
                f24 = f6;
                vector3f3.set(f25, f24, f23);
                vector3f4.set(f20, f21, f22);
                return findClosestPointsLineSegments;
            }
        } else {
            vector3f4 = vector3f5;
        }
        f22 = f39;
        f21 = f40;
        f20 = f41;
        f23 = f42;
        f24 = f43;
        f25 = f44;
        vector3f3.set(f25, f24, f23);
        vector3f4.set(f20, f21, f22);
        return findClosestPointsLineSegments;
    }

    public static float findClosestPointsLineSegments(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, Vector3f vector3f, Vector3f vector3f2) {
        float f14;
        float f15;
        float f16;
        float f17 = f2;
        float f18 = f3;
        float f19 = f4;
        float f20 = f8;
        float f21 = f9;
        float f22 = f10;
        Vector3f vector3f3 = vector3f;
        Vector3f vector3f4 = vector3f2;
        float f23 = f5 - f17;
        float f24 = f6 - f18;
        float f25 = f7 - f19;
        float f26 = f11 - f20;
        float f27 = f12 - f21;
        float f28 = f13 - f22;
        float f29 = f17 - f20;
        float f30 = f18 - f21;
        float f31 = f19 - f22;
        float f32 = (f25 * f25) + (f24 * f24) + (f23 * f23);
        float f33 = (f28 * f28) + (f27 * f27) + (f26 * f26);
        float f34 = (f28 * f31) + (f27 * f30) + (f26 * f29);
        int i2 = (f32 > 1.0E-5f ? 1 : (f32 == 1.0E-5f ? 0 : -1));
        if (i2 > 0 || f33 > 1.0E-5f) {
            float f35 = 0.0f;
            if (i2 <= 0) {
                f15 = f27;
                f14 = f28;
                f16 = Math.min(Math.max(f34 / f33, 0.0f), 1.0f);
            } else {
                float f36 = (f31 * f25) + (f30 * f24) + (f29 * f23);
                if (f33 <= 1.0E-5f) {
                    f16 = 0.0f;
                    f15 = f27;
                    f14 = f28;
                    f35 = Math.min(Math.max((-f36) / f32, 0.0f), 1.0f);
                } else {
                    float f37 = (f25 * f28) + (f24 * f27) + (f23 * f26);
                    float f38 = (f32 * f33) - (f37 * f37);
                    float min = ((double) f38) != 0.0d ? Math.min(Math.max(((f37 * f34) - (f36 * f33)) / f38, 0.0f), 1.0f) : 0.0f;
                    f16 = ((f37 * min) + f34) / f33;
                    f15 = f27;
                    f14 = f28;
                    double d2 = (double) f16;
                    if (d2 < 0.0d) {
                        f35 = Math.min(Math.max((-f36) / f32, 0.0f), 1.0f);
                        f16 = 0.0f;
                    } else if (d2 > 1.0d) {
                        f35 = Math.min(Math.max((f37 - f36) / f32, 0.0f), 1.0f);
                        f16 = 1.0f;
                    } else {
                        f35 = min;
                    }
                }
            }
            vector3f3.set((f23 * f35) + f17, (f24 * f35) + f18, (f25 * f35) + f19);
            Vector3f vector3f5 = vector3f2;
            vector3f5.set((f26 * f16) + f20, (f15 * f16) + f9, (f14 * f16) + f10);
            float f39 = vector3f3.x - vector3f5.x;
            float f40 = vector3f3.y - vector3f5.y;
            float f41 = vector3f3.z - vector3f5.z;
            return (f41 * f41) + (f40 * f40) + (f39 * f39);
        }
        vector3f3.set(f17, f18, f19);
        vector3f4.set(f20, f21, f22);
        return vector3f.dot(vector3f2);
    }

    public static boolean intersectCircleCircle(float f2, float f3, float f4, float f5, float f6, float f7, Vector3f vector3f) {
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        float f10 = (f9 * f9) + (f8 * f8);
        float f11 = ((f4 - f7) / f10) + 0.5f;
        float sqrt = (float) Math.sqrt((double) (f4 - ((f11 * f11) * f10)));
        if (sqrt < 0.0f) {
            return false;
        }
        vector3f.x = (f8 * f11) + f2;
        vector3f.y = (f11 * f9) + f3;
        vector3f.z = sqrt;
        return true;
    }

    public static boolean intersectLineCircle(float f2, float f3, float f4, float f5, float f6, float f7, Vector3f vector3f) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f3 * f3) + (f2 * f2))));
        float f8 = ((f3 * f6) + (f2 * f5) + f4) * sqrt;
        if ((-f7) > f8 || f8 > f7) {
            return false;
        }
        vector3f.x = (f2 * f8 * sqrt) + f5;
        vector3f.y = (f3 * f8 * sqrt) + f6;
        vector3f.z = (float) Math.sqrt((double) ((f7 * f7) - (f8 * f8)));
        return true;
    }

    public static boolean intersectLineLine(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector2f vector2f) {
        float f10 = f2 - f4;
        float f11 = f5 - f3;
        float f12 = (f3 * f10) + (f2 * f11);
        float f13 = f6 - f8;
        float f14 = f9 - f7;
        float f15 = (f7 * f13) + (f6 * f14);
        float f16 = (f11 * f13) - (f14 * f10);
        if (f16 == 0.0f) {
            return false;
        }
        vector2f.x = ((f13 * f12) - (f10 * f15)) / f16;
        vector2f.y = ((f11 * f15) - (f14 * f12)) / f16;
        return true;
    }

    public static int intersectLineSegmentAab(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, Vector2f vector2f) {
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20 = 1.0f / (f5 - f2);
        float f21 = 1.0f / (f6 - f3);
        float f22 = 1.0f / (f7 - f4);
        if (f20 >= 0.0f) {
            f15 = (f8 - f2) * f20;
            f14 = (f11 - f2) * f20;
        } else {
            float f23 = (f8 - f2) * f20;
            f15 = (f11 - f2) * f20;
            f14 = f23;
        }
        if (f21 >= 0.0f) {
            f17 = (f9 - f3) * f21;
            f16 = (f12 - f3) * f21;
        } else {
            float f24 = (f12 - f3) * f21;
            f16 = (f9 - f3) * f21;
            f17 = f24;
        }
        int i2 = -1;
        if (f15 <= f16 && f17 <= f14) {
            if (f22 >= 0.0f) {
                f19 = (f10 - f4) * f22;
                f18 = (f13 - f4) * f22;
            } else {
                float f25 = (f13 - f4) * f22;
                f18 = (f10 - f4) * f22;
                f19 = f25;
            }
            if (f15 <= f18 && f19 <= f14) {
                if (f17 > f15 || Float.isNaN(f15)) {
                    f15 = f17;
                }
                if (f16 < f14 || Float.isNaN(f14)) {
                    f14 = f16;
                }
                if (f19 <= f15) {
                    f19 = f15;
                }
                if (f18 >= f14) {
                    f18 = f14;
                }
                if (f19 < f18 && f19 <= 1.0f && f18 >= 0.0f) {
                    i2 = 1;
                    if (f19 <= 0.0f || f18 <= 1.0f) {
                        int i3 = (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1));
                        if (i3 >= 0 || f18 >= 1.0f) {
                            i2 = (i3 >= 0 || f18 <= 1.0f) ? 2 : 3;
                        } else {
                            f19 = f18;
                        }
                    } else {
                        f18 = f19;
                    }
                    vector2f.x = f19;
                    vector2f.y = f18;
                }
            }
        }
        return i2;
    }

    public static int intersectLineSegmentAar(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector2f vector2f) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14 = 1.0f / (f4 - f2);
        float f15 = 1.0f / (f5 - f3);
        if (f14 >= 0.0f) {
            f11 = (f6 - f2) * f14;
            f10 = (f8 - f2) * f14;
        } else {
            float f16 = (f6 - f2) * f14;
            f11 = (f8 - f2) * f14;
            f10 = f16;
        }
        if (f15 >= 0.0f) {
            f13 = (f7 - f3) * f15;
            f12 = (f9 - f3) * f15;
        } else {
            float f17 = (f9 - f3) * f15;
            f12 = (f7 - f3) * f15;
            f13 = f17;
        }
        int i2 = -1;
        if (f11 <= f12 && f13 <= f10) {
            if (f13 > f11 || Float.isNaN(f11)) {
                f11 = f13;
            }
            if (f12 < f10 || Float.isNaN(f10)) {
                f10 = f12;
            }
            if (f11 < f10 && f11 <= 1.0f && f10 >= 0.0f) {
                i2 = 1;
                if (f11 <= 0.0f || f10 <= 1.0f) {
                    int i3 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                    if (i3 >= 0 || f10 >= 1.0f) {
                        i2 = (i3 >= 0 || f10 <= 1.0f) ? 2 : 3;
                    } else {
                        f11 = f10;
                    }
                } else {
                    f10 = f11;
                }
                vector2f.x = f11;
                vector2f.y = f10;
            }
        }
        return i2;
    }

    public static boolean intersectLineSegmentPlane(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Vector3f vector3f) {
        float f12 = f5 - f2;
        float f13 = f6 - f3;
        float f14 = f7 - f4;
        float f15 = (-a.f(f10, f4, (f9 * f3) + (f8 * f2), f11)) / ((f10 * f14) + ((f9 * f13) + (f8 * f12)));
        if (f15 < 0.0f || f15 > 1.0f) {
            return false;
        }
        vector3f.x = (f12 * f15) + f2;
        vector3f.y = (f13 * f15) + f3;
        vector3f.z = (f15 * f14) + f4;
        return true;
    }

    public static boolean intersectLineSegmentTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        float f18 = f5 - f2;
        float f19 = f6 - f3;
        float f20 = f7 - f4;
        float intersectRayTriangle = intersectRayTriangle(f2, f3, f4, f18, f19, f20, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
        if (intersectRayTriangle < 0.0f || intersectRayTriangle > 1.0f) {
            return false;
        }
        Vector3f vector3f3 = vector3f;
        vector3f3.x = (f18 * intersectRayTriangle) + f2;
        vector3f3.y = (f19 * intersectRayTriangle) + f3;
        vector3f3.z = (f20 * intersectRayTriangle) + f4;
        return true;
    }

    public static boolean intersectPlaneSphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector4f vector4f) {
        float sqrt = 1.0f / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        float f10 = ((f4 * f8) + (f3 * f7) + (f2 * f6) + f5) * sqrt;
        if ((-f9) > f10 || f10 > f9) {
            return false;
        }
        vector4f.x = (f2 * f10 * sqrt) + f6;
        vector4f.y = (f3 * f10 * sqrt) + f7;
        vector4f.z = (f4 * f10 * sqrt) + f8;
        vector4f.w = (float) Math.sqrt((double) ((f9 * f9) - (f10 * f10)));
        return true;
    }

    public static boolean intersectPlaneSweptSphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, Vector4f vector4f) {
        float f13 = ((f4 * f8) + ((f3 * f7) + (f2 * f6))) - f5;
        if (Math.abs(f13) <= f9) {
            vector4f.set(f6, f7, f8, 0.0f);
            return true;
        }
        float f14 = (f4 * f12) + (f3 * f11) + (f2 * f10);
        if (f14 * f13 >= 0.0f) {
            return false;
        }
        if (f13 <= 0.0f) {
            f9 = -f9;
        }
        float f15 = (f9 - f13) / f14;
        vector4f.set(((f10 * f15) + f6) - (f2 * f9), ((f11 * f15) + f7) - (f3 * f9), ((f12 * f15) + f8) - (f9 * f4), f15);
        return true;
    }

    public static int intersectPolygonRay(float[] fArr, float f2, float f3, float f4, float f5, Vector2f vector2f) {
        float[] fArr2 = fArr;
        float f6 = f5;
        Vector2f vector2f2 = vector2f;
        int length = fArr2.length >> 1;
        int i2 = (length - 1) << 1;
        float f7 = fArr2[i2];
        float f8 = fArr2[i2 + 1];
        float f9 = Float.POSITIVE_INFINITY;
        int i3 = -1;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 << 1;
            float f10 = fArr2[i5];
            float f11 = fArr2[i5 + 1];
            float f12 = f2 - f7;
            float f13 = f3 - f8;
            float f14 = f10 - f7;
            float f15 = f11 - f8;
            float f16 = 1.0f / ((f15 * f4) - (f14 * f6));
            float i6 = a.i(f15, f12, f14 * f13, f16);
            if (i6 >= 0.0f && i6 < f9) {
                float i7 = a.i(f12, f6, f13 * f4, f16);
                if (i7 >= 0.0f && i7 <= 1.0f) {
                    int i8 = ((i4 - 1) + length) % length;
                    vector2f2.x = (i6 * f4) + f2;
                    vector2f2.y = (i6 * f6) + f3;
                    f9 = i6;
                    i3 = i8;
                }
            }
            i4++;
            f8 = f11;
            f7 = f10;
        }
        return i3;
    }

    public static boolean intersectRayAab(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, Vector2f vector2f) {
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20 = 1.0f / f5;
        float f21 = 1.0f / f6;
        float f22 = 1.0f / f7;
        if (f20 >= 0.0f) {
            f15 = (f8 - f2) * f20;
            f14 = (f11 - f2) * f20;
        } else {
            float f23 = (f8 - f2) * f20;
            f15 = (f11 - f2) * f20;
            f14 = f23;
        }
        if (f21 >= 0.0f) {
            f17 = (f9 - f3) * f21;
            f16 = (f12 - f3) * f21;
        } else {
            float f24 = (f12 - f3) * f21;
            f16 = (f9 - f3) * f21;
            f17 = f24;
        }
        if (f15 <= f16 && f17 <= f14) {
            if (f22 >= 0.0f) {
                f19 = (f10 - f4) * f22;
                f18 = (f13 - f4) * f22;
            } else {
                float f25 = (f13 - f4) * f22;
                f18 = (f10 - f4) * f22;
                f19 = f25;
            }
            if (f15 <= f18 && f19 <= f14) {
                if (f17 > f15 || Float.isNaN(f15)) {
                    f15 = f17;
                }
                if (f16 < f14 || Float.isNaN(f14)) {
                    f14 = f16;
                }
                if (f19 <= f15) {
                    f19 = f15;
                }
                if (f18 >= f14) {
                    f18 = f14;
                }
                if (f19 < f18 && f18 >= 0.0f) {
                    vector2f.x = f19;
                    vector2f.y = f18;
                    return true;
                }
            }
        }
        return false;
    }

    public static int intersectRayAar(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector2f vector2f) {
        float f10;
        float f11;
        float f12;
        float f13;
        int i2;
        float f14 = 1.0f / f4;
        float f15 = 1.0f / f5;
        if (f14 >= 0.0f) {
            f11 = (f6 - f2) * f14;
            f10 = f8 - f2;
        } else {
            f11 = (f8 - f2) * f14;
            f10 = f6 - f2;
        }
        float f16 = f10 * f14;
        if (f15 >= 0.0f) {
            f13 = (f7 - f3) * f15;
            f12 = f9 - f3;
        } else {
            f13 = (f9 - f3) * f15;
            f12 = f7 - f3;
        }
        float f17 = f12 * f15;
        if (f11 > f17 || f13 > f16) {
            return -1;
        }
        if (f13 > f11 || Float.isNaN(f11)) {
            f11 = f13;
        }
        if (f17 < f16 || Float.isNaN(f16)) {
            f16 = f17;
        }
        if (f11 >= f16 || f16 < 0.0f) {
            return -1;
        }
        float f18 = (f4 * f11) + f2;
        float f19 = (f5 * f11) + f3;
        vector2f.x = f11;
        vector2f.y = f16;
        float abs = Math.abs(f18 - f6);
        float abs2 = Math.abs(f19 - f7);
        float abs3 = Math.abs(f18 - f8);
        float abs4 = Math.abs(f19 - f9);
        int i3 = 0;
        if (abs2 < abs) {
            i3 = 1;
            abs = abs2;
        }
        if (abs3 < abs) {
            i2 = 2;
        } else {
            abs3 = abs;
            i2 = i3;
        }
        if (abs4 < abs3) {
            return 3;
        }
        return i2;
    }

    public static boolean intersectRayCircle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, Vector2f vector2f) {
        float f9 = f6 - f2;
        float f10 = f7 - f3;
        float f11 = (f5 * f10) + (f4 * f9);
        float f12 = ((f10 * f10) + (f9 * f9)) - (f11 * f11);
        if (f12 > f8) {
            return false;
        }
        float sqrt = (float) Math.sqrt((double) (f8 - f12));
        float f13 = f11 - sqrt;
        float f14 = f11 + sqrt;
        if (f13 >= f14 || f14 < 0.0f) {
            return false;
        }
        vector2f.x = f13;
        vector2f.y = f14;
        return true;
    }

    public static float intersectRayLine(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = (f5 * f9) + (f4 * f8);
        if (f11 < f10) {
            float f12 = (((f7 - f3) * f9) + ((f6 - f2) * f8)) / f11;
            if (f12 >= 0.0f) {
                return f12;
            }
        }
        return -1.0f;
    }

    public static float intersectRayLine(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4, float f2) {
        return intersectRayLine(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y(), f2);
    }

    public static float intersectRayLineSegment(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f2 - f6;
        float f11 = f3 - f7;
        float f12 = f8 - f6;
        float f13 = f9 - f7;
        float f14 = 1.0f / ((f13 * f4) - (f12 * f5));
        float i2 = a.i(f13, f10, f12 * f11, f14);
        float i3 = a.i(f10, f5, f11 * f4, f14);
        if (i2 < 0.0f || i3 < 0.0f || i3 > 1.0f) {
            return -1.0f;
        }
        return i2;
    }

    public static float intersectRayLineSegment(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4) {
        return intersectRayLineSegment(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y());
    }

    public static float intersectRayPlane(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        float f13 = f7 * f10;
        float f14 = f13 + (f6 * f9) + (f5 * f8);
        if (f14 < 0.0f) {
            float f15 = (-a.f(f10, f4, (f9 * f3) + (f8 * f2), f11)) / f14;
            if (f15 >= 0.0f) {
                return f15;
            }
        }
        return -1.0f;
    }

    public static float intersectRayPlane(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14) {
        float f15 = f7 * f13;
        float f16 = f15 + (f6 * f12) + (f5 * f11);
        if (f16 < f14) {
            float e2 = (((f10 - f4) * f13) + a.e(f9, f3, f12, (f8 - f2) * f11)) / f16;
            if (e2 >= 0.0f) {
                return e2;
            }
        }
        return -1.0f;
    }

    public static float intersectRayPlane(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, float f2) {
        return intersectRayPlane(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), f2);
    }

    public static boolean intersectRaySphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Vector2f vector2f) {
        float f12 = f8 - f2;
        float f13 = f9 - f3;
        float f14 = f10 - f4;
        float f15 = f7 * f14;
        float f16 = f15 + (f6 * f13) + (f5 * f12);
        float f17 = f14 * f14;
        float f18 = (f17 + ((f13 * f13) + (f12 * f12))) - (f16 * f16);
        if (f18 > f11) {
            return false;
        }
        float sqrt = (float) Math.sqrt((double) (f11 - f18));
        float f19 = f16 - sqrt;
        float f20 = f16 + sqrt;
        if (f19 >= f20 || f20 < 0.0f) {
            return false;
        }
        vector2f.x = f19;
        vector2f.y = f20;
        return true;
    }

    public static float intersectRayTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = f7;
        float f19 = f17;
        float f20 = f11 - f8;
        float f21 = f12 - f9;
        float f22 = f13 - f10;
        float f23 = f14 - f8;
        float f24 = f15 - f9;
        float f25 = f16 - f10;
        float f26 = (f6 * f25) - (f18 * f24);
        float f27 = (f18 * f23) - (f5 * f25);
        float f28 = (f5 * f24) - (f6 * f23);
        float f29 = (f22 * f28) + (f21 * f27) + (f20 * f26);
        if (f29 > (-f19) && f29 < f19) {
            return -1.0f;
        }
        float f30 = f2 - f8;
        float f31 = f3 - f9;
        float f32 = f4 - f10;
        float f33 = 1.0f / f29;
        float g2 = a.g(f28, f32, (f27 * f31) + (f26 * f30), f33);
        if (g2 >= 0.0f && g2 <= 1.0f) {
            float f34 = (f31 * f22) - (f32 * f21);
            float f35 = (f32 * f20) - (f22 * f30);
            float f36 = (f30 * f21) - (f31 * f20);
            float g3 = a.g(f18, f36, (f6 * f35) + (f5 * f34), f33);
            if (g3 >= 0.0f && g2 + g3 <= 1.0f) {
                return a.g(f25, f36, (f24 * f35) + (f23 * f34), f33);
            }
        }
        return -1.0f;
    }

    public static float intersectRayTriangle(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector3fc vector3fc5, float f2) {
        return intersectRayTriangle(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector3fc5.x(), vector3fc5.y(), vector3fc5.z(), f2);
    }

    public static float intersectRayTriangleFront(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = f11 - f8;
        float f19 = f12 - f9;
        float f20 = f13 - f10;
        float f21 = f14 - f8;
        float f22 = f15 - f9;
        float f23 = f16 - f10;
        float f24 = (f6 * f23) - (f7 * f22);
        float f25 = (f7 * f21) - (f5 * f23);
        float f26 = (f5 * f22) - (f6 * f21);
        float f27 = (f20 * f26) + (f19 * f25) + (f18 * f24);
        if (f27 <= f17) {
            return -1.0f;
        }
        float f28 = f2 - f8;
        float f29 = f3 - f9;
        float f30 = f4 - f10;
        float f31 = f26 * f30;
        float f32 = f31 + (f25 * f29) + (f24 * f28);
        if (f32 >= 0.0f && f32 <= f27) {
            float f33 = (f29 * f20) - (f30 * f19);
            float f34 = (f30 * f18) - (f20 * f28);
            float f35 = (f28 * f19) - (f29 * f18);
            float f36 = (f7 * f35) + (f6 * f34) + (f5 * f33);
            if (f36 >= 0.0f && f32 + f36 <= f27) {
                return a.g(f23, f35, (f22 * f34) + (f21 * f33), 1.0f / f27);
            }
        }
        return -1.0f;
    }

    public static float intersectRayTriangleFront(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector3fc vector3fc5, float f2) {
        return intersectRayTriangleFront(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector3fc5.x(), vector3fc5.y(), vector3fc5.z(), f2);
    }

    public static boolean intersectSphereSphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector4f vector4f) {
        float f10 = f6 - f2;
        float f11 = f7 - f3;
        float f12 = f8 - f4;
        float f13 = (f12 * f12) + (f11 * f11) + (f10 * f10);
        float f14 = ((f5 - f9) / f13) + 0.5f;
        float f15 = f5 - ((f14 * f14) * f13);
        if (f15 < 0.0f) {
            return false;
        }
        vector4f.x = (f10 * f14) + f2;
        vector4f.y = (f11 * f14) + f3;
        vector4f.z = (f14 * f12) + f4;
        vector4f.w = (float) Math.sqrt((double) f15);
        return true;
    }

    public static int intersectSphereTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, Vector3f vector3f) {
        Vector3f vector3f2 = vector3f;
        int findClosestPointOnTriangle = findClosestPointOnTriangle(f6, f7, f8, f9, f10, f11, f12, f13, f14, f2, f3, f4, vector3f);
        float f15 = vector3f2.x - f2;
        float f16 = vector3f2.y - f3;
        float f17 = vector3f2.z - f4;
        if ((f17 * f17) + (f16 * f16) + (f15 * f15) <= f5 * f5) {
            return findClosestPointOnTriangle;
        }
        return 0;
    }

    public static int intersectSweptSphereTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, Vector4f vector4f) {
        float f20;
        float f21 = f5;
        float f22 = f8;
        float f23 = f9;
        float f24 = f10;
        float f25 = f11;
        float f26 = f18;
        float f27 = f19;
        Vector4f vector4f2 = vector4f;
        float f28 = f12 - f23;
        float f29 = f13 - f24;
        float f30 = f14 - f25;
        float f31 = f15 - f23;
        float f32 = f16 - f24;
        float f33 = f17 - f25;
        float f34 = (f29 * f33) - (f32 * f30);
        float f35 = (f30 * f31) - (f33 * f28);
        float f36 = (f28 * f32) - (f31 * f29);
        float f37 = -((f36 * f25) + (f35 * f24) + (f34 * f23));
        float sqrt = (float) (1.0d / Math.sqrt((double) ((f36 * f36) + ((f35 * f35) + (f34 * f34)))));
        float f38 = ((f36 * f4) + (f35 * f3) + (f34 * f2) + f37) * sqrt;
        float g2 = a.g(f36, f22, (f35 * f7) + (f34 * f6), sqrt);
        int i2 = 0;
        if (g2 < f26 && g2 > (-f26)) {
            return 0;
        }
        float f39 = (f21 - f38) / g2;
        if (f39 > f27) {
            return 0;
        }
        float f40 = ((-f21) - f38) / g2;
        float f41 = (f6 * f39) + (f2 - ((f34 * f21) * sqrt));
        float f42 = (f7 * f39) + (f3 - ((f21 * f35) * sqrt));
        float f43 = (f22 * f39) + (f4 - ((f21 * f36) * sqrt));
        Vector4f vector4f3 = vector4f;
        float f44 = f42;
        float f45 = f43;
        float f46 = f39;
        float f47 = f41;
        if (testPointInTriangle(f41, f42, f43, f9, f10, f11, f12, f13, f14, f15, f16, f17)) {
            vector4f3.x = f47;
            vector4f3.y = f44;
            vector4f3.z = f45;
            vector4f3.w = f46;
            return 2;
        }
        float f48 = f8;
        float f49 = (f48 * f48) + (f7 * f7) + (f6 * f6);
        float f50 = f5 * f5;
        float f51 = f9;
        float f52 = f2 - f51;
        float f53 = f10;
        Vector4f vector4f4 = vector4f3;
        float f54 = f3 - f53;
        float f55 = f11;
        float f56 = f4 - f55;
        float g3 = a.g(f48, f56, (f7 * f54) + (f6 * f52), 2.0f);
        float f57 = (f56 * f56) + (f54 * f54) + (f52 * f52);
        float f58 = f19;
        float computeLowestRoot = computeLowestRoot(f49, g3, f57 - f50, f58);
        if (computeLowestRoot < f58) {
            vector4f4.x = f51;
            vector4f4.y = f53;
            vector4f4.z = f55;
            vector4f4.w = computeLowestRoot;
            i2 = 1;
            f58 = computeLowestRoot;
        }
        float f59 = f12;
        float f60 = f2 - f59;
        float f61 = f13;
        float f62 = f3 - f61;
        float f63 = f14;
        float f64 = f4 - f63;
        float f65 = (f64 * f64) + (f62 * f62) + (f60 * f60);
        float f66 = f62;
        float f67 = f60;
        float computeLowestRoot2 = computeLowestRoot(f49, a.g(f48, f64, (f7 * f62) + (f6 * f60), 2.0f), f65 - f50, f58);
        if (computeLowestRoot2 < f58) {
            vector4f4.x = f59;
            vector4f4.y = f61;
            vector4f4.z = f63;
            vector4f4.w = computeLowestRoot2;
            i2 = 2;
            f58 = computeLowestRoot2;
        }
        float f68 = f15;
        float f69 = f2 - f68;
        float f70 = f64;
        float f71 = f16;
        float f72 = f3 - f71;
        float f73 = f17;
        float f74 = f4 - f73;
        float f75 = f74 * f74;
        float computeLowestRoot3 = computeLowestRoot(f49, a.g(f48, f74, (f7 * f72) + (f6 * f69), 2.0f), (f75 + ((f72 * f72) + (f69 * f69))) - f50, f58);
        if (computeLowestRoot3 < f58) {
            vector4f4.x = f68;
            vector4f4.y = f71;
            vector4f4.z = f73;
            vector4f4.w = computeLowestRoot3;
            i2 = 3;
            f58 = computeLowestRoot3;
        }
        float f76 = (f30 * f30) + (f29 * f29) + (f28 * f28);
        float f77 = (f30 * f48) + (f29 * f7) + (f28 * f6);
        float f78 = -f49;
        float f79 = -f52;
        float f80 = -f54;
        float f81 = -f56;
        float f82 = (f30 * f81) + (f29 * f80) + (f28 * f79);
        float f83 = (f48 * f81) + (f7 * f80) + (f6 * f79);
        float f84 = f50 - f57;
        float f85 = f50;
        float computeLowestRoot4 = computeLowestRoot((f77 * f77) + (f76 * f78), ((f76 * 2.0f) * f83) - ((2.0f * f77) * f82), (f82 * f82) + (f76 * f84), f58);
        float f86 = ((f77 * computeLowestRoot4) - f82) / f76;
        if (f86 < 0.0f || f86 > 1.0f || computeLowestRoot4 >= f58) {
            f20 = f70;
        } else {
            vector4f4.x = (f28 * f86) + f9;
            f20 = f70;
            vector4f4.y = (f29 * f86) + f10;
            vector4f4.z = (f86 * f30) + f11;
            vector4f4.w = computeLowestRoot4;
            i2 = 4;
            f58 = computeLowestRoot4;
        }
        float f87 = (f33 * f33) + (f32 * f32) + (f31 * f31);
        float f88 = (f33 * f48) + (f32 * f7) + (f31 * f6);
        float f89 = f81 * f33;
        float f90 = f89 + (f80 * f32) + (f79 * f31);
        float f91 = ((f87 * 2.0f) * f83) - ((2.0f * f88) * f90);
        float computeLowestRoot5 = computeLowestRoot((f88 * f88) + (f87 * f78), f91, (f90 * f90) + (f84 * f87), f58);
        float f92 = ((f88 * computeLowestRoot5) - f90) / f87;
        if (f92 >= 0.0f && f92 <= 1.0f && computeLowestRoot5 < f40) {
            vector4f4.x = (f31 * f92) + f9;
            vector4f4.y = (f32 * f92) + f10;
            vector4f4.z = (f92 * f33) + f11;
            vector4f4.w = computeLowestRoot5;
            i2 = 6;
            f58 = computeLowestRoot5;
        }
        float f93 = f68 - f12;
        float f94 = f71 - f13;
        float f95 = f17 - f14;
        float f96 = (f95 * f95) + (f94 * f94) + (f93 * f93);
        float f97 = (f95 * f48) + (f94 * f7) + (f93 * f6);
        float f98 = (f97 * f97) + (f78 * f96);
        float f99 = -f67;
        float f100 = -f66;
        float f101 = -f20;
        float f102 = (f95 * f101) + (f94 * f100) + (f93 * f99);
        float f103 = f48 * f101;
        float f104 = f96 * 2.0f;
        float computeLowestRoot6 = computeLowestRoot(f98, (f104 * (f103 + ((f100 * f7) + (f99 * f6)))) - ((2.0f * f97) * f102), (f102 * f102) + ((f85 - f65) * f96), f58);
        float f105 = ((f97 * computeLowestRoot6) - f102) / f96;
        if (f105 >= 0.0f && f105 <= 1.0f && computeLowestRoot6 < f58) {
            vector4f4.x = (f93 * f105) + f12;
            vector4f4.y = (f94 * f105) + f13;
            vector4f4.z = (f105 * f95) + f14;
            vector4f4.w = computeLowestRoot6;
            i2 = 5;
        }
        return i2;
    }

    public static boolean separatingAxis(Vector2f[] vector2fArr, Vector2f[] vector2fArr2, float f2, float f3) {
        int max = Math.max(vector2fArr.length, vector2fArr2.length);
        float f4 = Float.NEGATIVE_INFINITY;
        float f5 = Float.POSITIVE_INFINITY;
        float f6 = Float.POSITIVE_INFINITY;
        float f7 = Float.NEGATIVE_INFINITY;
        for (int i2 = 0; i2 < max; i2++) {
            if (i2 < vector2fArr.length) {
                Vector2f vector2f = vector2fArr[i2];
                float f8 = (vector2f.y * f3) + (vector2f.x * f2);
                if (f8 < f5) {
                    f5 = f8;
                }
                if (f8 > f4) {
                    f4 = f8;
                }
            }
            if (i2 < vector2fArr2.length) {
                Vector2f vector2f2 = vector2fArr2[i2];
                float f9 = (vector2f2.y * f3) + (vector2f2.x * f2);
                if (f9 < f6) {
                    f6 = f9;
                }
                if (f9 > f7) {
                    f7 = f9;
                }
            }
            if (f5 <= f7 && f6 <= f4) {
                return false;
            }
        }
        return true;
    }

    public static boolean testAabAab(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        return f5 >= f8 && f6 >= f9 && f7 >= f10 && f2 <= f11 && f3 <= f12 && f4 <= f13;
    }

    public static boolean testAabAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4) {
        return testAabAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z());
    }

    public static boolean testAabPlane(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        if (f8 <= 0.0f) {
            float f12 = f5;
            f5 = f2;
            f2 = f12;
        }
        if (f9 <= 0.0f) {
            float f13 = f6;
            f6 = f3;
            f3 = f13;
        }
        if (f10 <= 0.0f) {
            float f14 = f7;
            f7 = f4;
            f4 = f14;
        }
        return (f4 * f10) + ((f3 * f9) + ((f2 * f8) + f11)) <= 0.0f && (f10 * f7) + ((f9 * f6) + ((f8 * f5) + f11)) >= 0.0f;
    }

    public static boolean testAabPlane(AABBf aABBf, Planef planef) {
        return testAabPlane(aABBf.minX, aABBf.minY, aABBf.minZ, aABBf.maxX, aABBf.maxY, aABBf.maxZ, planef.f1229a, planef.f1230b, planef.f1231c, planef.f1232d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean testAabSphere(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10) {
        /*
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0008
            float r7 = r7 - r1
        L_0x0005:
            float r7 = r7 * r7
            float r10 = r10 - r7
            goto L_0x000e
        L_0x0008:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x000e
            float r7 = r7 - r4
            goto L_0x0005
        L_0x000e:
            int r1 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0016
            float r8 = r8 - r2
        L_0x0013:
            float r8 = r8 * r8
            float r10 = r10 - r8
            goto L_0x001c
        L_0x0016:
            int r1 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x001c
            float r8 = r8 - r5
            goto L_0x0013
        L_0x001c:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0024
            float r9 = r9 - r3
        L_0x0021:
            float r9 = r9 * r9
            float r10 = r10 - r9
            goto L_0x002a
        L_0x0024:
            int r1 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x002a
            float r9 = r9 - r6
            goto L_0x0021
        L_0x002a:
            r1 = 0
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0031
            r1 = 1
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.Intersectionf.testAabSphere(float, float, float, float, float, float, float, float, float, float):boolean");
    }

    public static boolean testAabSphere(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, float f2) {
        return testAabSphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), f2);
    }

    public static boolean testAarAar(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return f4 >= f6 && f5 >= f7 && f2 <= f8 && f3 <= f9;
    }

    public static boolean testAarAar(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4) {
        return testAarAar(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean testAarCircle(float r1, float r2, float r3, float r4, float r5, float r6, float r7) {
        /*
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0008
            float r5 = r5 - r1
        L_0x0005:
            float r5 = r5 * r5
            float r7 = r7 - r5
            goto L_0x000e
        L_0x0008:
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x000e
            float r5 = r5 - r3
            goto L_0x0005
        L_0x000e:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0016
            float r6 = r6 - r2
        L_0x0013:
            float r6 = r6 * r6
            float r7 = r7 - r6
            goto L_0x001c
        L_0x0016:
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x001c
            float r6 = r6 - r4
            goto L_0x0013
        L_0x001c:
            r1 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0023
            r1 = 1
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.Intersectionf.testAarCircle(float, float, float, float, float, float, float):boolean");
    }

    public static boolean testAarCircle(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, float f2) {
        return testAarCircle(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), f2);
    }

    public static boolean testAarLine(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (f6 <= 0.0f) {
            float f9 = f4;
            f4 = f2;
            f2 = f9;
        }
        if (f7 <= 0.0f) {
            float f10 = f5;
            f5 = f3;
            f3 = f10;
        }
        return (f3 * f7) + ((f2 * f6) + f8) <= 0.0f && (f7 * f5) + ((f6 * f4) + f8) >= 0.0f;
    }

    public static boolean testAarLine(Vector2fc vector2fc, Vector2fc vector2fc2, float f2, float f3, float f4) {
        return testAarLine(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), f2, f3, f4);
    }

    public static boolean testCircleCircle(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f2 - f5;
        float f9 = f3 - f6;
        float f10 = f4 + f7;
        return (f9 * f9) + (f8 * f8) <= f10 * f10;
    }

    public static boolean testCircleCircle(Vector2fc vector2fc, float f2, Vector2fc vector2fc2, float f3) {
        return testCircleCircle(vector2fc.x(), vector2fc.y(), f2, vector2fc2.x(), vector2fc2.y(), f3);
    }

    public static boolean testCircleTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f2 - f5;
        float f12 = f3 - f6;
        float f13 = ((f12 * f12) + (f11 * f11)) - f4;
        if (f13 <= 0.0f) {
            return true;
        }
        float f14 = f2 - f7;
        float f15 = f3 - f8;
        float f16 = ((f15 * f15) + (f14 * f14)) - f4;
        if (f16 <= 0.0f) {
            return true;
        }
        float f17 = f2 - f9;
        float f18 = f3 - f10;
        float f19 = ((f18 * f18) + (f17 * f17)) - f4;
        if (f19 <= 0.0f) {
            return true;
        }
        float f20 = f7 - f5;
        float f21 = f8 - f6;
        float f22 = f9 - f7;
        float f23 = f10 - f8;
        float f24 = f5 - f9;
        float f25 = f6 - f10;
        if ((f20 * f12) - (f21 * f11) >= 0.0f && (f22 * f15) - (f23 * f14) >= 0.0f && (f24 * f18) - (f25 * f17) >= 0.0f) {
            return true;
        }
        float f26 = (f12 * f21) + (f11 * f20);
        if (f26 >= 0.0f) {
            float f27 = (f21 * f21) + (f20 * f20);
            if (f26 <= f27 && f13 * f27 <= f26 * f26) {
                return true;
            }
        }
        float f28 = (f15 * f23) + (f14 * f22);
        if (f28 > 0.0f) {
            float f29 = (f23 * f23) + (f22 * f22);
            if (f28 <= f29 && f16 * f29 <= f28 * f28) {
                return true;
            }
        }
        float f30 = (f18 * f25) + (f17 * f24);
        if (f30 >= 0.0f) {
            float f31 = (f25 * f25) + (f24 * f24);
            if (f30 < f31 && f19 * f31 <= f30 * f30) {
                return true;
            }
        }
        return false;
    }

    public static boolean testCircleTriangle(Vector2fc vector2fc, float f2, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4) {
        return testCircleTriangle(vector2fc.x(), vector2fc.y(), f2, vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y());
    }

    public static boolean testLineCircle(float f2, float f3, float f4, float f5, float f6, float f7) {
        float sqrt = (((f3 * f6) + (f2 * f5)) + f4) / ((float) Math.sqrt((double) ((f3 * f3) + (f2 * f2))));
        return (-f7) <= sqrt && sqrt <= f7;
    }

    public static boolean testLineSegmentSphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12;
        float f13;
        float f14;
        float f15 = f5 - f2;
        float f16 = f6 - f3;
        float f17 = f7 - f4;
        float h2 = a.h(f17, f17, (f16 * f16) + (f15 * f15), a.e(f10, f4, f17, a.e(f9, f3, f16, (f8 - f2) * f15)));
        if (h2 < 0.0f) {
            f14 = f2 - f8;
            f13 = f3 - f9;
            f12 = f4 - f10;
        } else if (h2 > 1.0f) {
            f14 = f5 - f8;
            f13 = f6 - f9;
            f12 = f7 - f10;
        } else {
            f14 = ((f15 * h2) + f2) - f8;
            f13 = ((f16 * h2) + f3) - f9;
            f12 = ((h2 * f17) + f4) - f10;
        }
        return (f12 * f12) + ((f13 * f13) + (f14 * f14)) <= f11;
    }

    public static boolean testLineSegmentSphere(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, float f2) {
        return testLineSegmentSphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), f2);
    }

    public static boolean testLineSegmentTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float intersectRayTriangle = intersectRayTriangle(f2, f3, f4, f5 - f2, f6 - f3, f7 - f4, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17);
        return intersectRayTriangle >= 0.0f && intersectRayTriangle <= 1.0f;
    }

    public static boolean testMovingCircleCircle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f6 + f9;
        float f11 = f2 - f7;
        float f12 = f3 - f8;
        float sqrt = ((float) Math.sqrt((double) ((f12 * f12) + (f11 * f11)))) - f10;
        float sqrt2 = (float) Math.sqrt((double) ((f5 * f5) + (f4 * f4)));
        if (sqrt2 < sqrt) {
            return false;
        }
        float f13 = 1.0f / sqrt2;
        float f14 = f7 - f2;
        float f15 = f8 - f3;
        float f16 = (f5 * f13 * f15) + (f4 * f13 * f14);
        if (f16 <= 0.0f) {
            return false;
        }
        float sqrt3 = (float) Math.sqrt((double) ((f15 * f15) + (f14 * f14)));
        float f17 = (sqrt3 * sqrt3) - (f16 * f16);
        float f18 = f10 * f10;
        if (f17 >= f18) {
            return false;
        }
        float f19 = f18 - f17;
        if (f19 >= 0.0f && sqrt2 >= f16 - ((float) Math.sqrt((double) f19))) {
            return true;
        }
        return false;
    }

    public static boolean testObOb(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector3f vector3f5, Vector3f vector3f6, Vector3f vector3f7, Vector3f vector3f8, Vector3f vector3f9, Vector3f vector3f10) {
        Vector3f vector3f11 = vector3f;
        Vector3f vector3f12 = vector3f2;
        Vector3f vector3f13 = vector3f3;
        Vector3f vector3f14 = vector3f4;
        Vector3f vector3f15 = vector3f5;
        Vector3f vector3f16 = vector3f6;
        Vector3f vector3f17 = vector3f7;
        Vector3f vector3f18 = vector3f8;
        Vector3f vector3f19 = vector3f9;
        Vector3f vector3f20 = vector3f10;
        return testObOb(vector3f11.x, vector3f11.y, vector3f11.z, vector3f12.x, vector3f12.y, vector3f12.z, vector3f13.x, vector3f13.y, vector3f13.z, vector3f14.x, vector3f14.y, vector3f14.z, vector3f15.x, vector3f15.y, vector3f15.z, vector3f16.x, vector3f16.y, vector3f16.z, vector3f17.x, vector3f17.y, vector3f17.z, vector3f18.x, vector3f18.y, vector3f18.z, vector3f19.x, vector3f19.y, vector3f19.z, vector3f20.x, vector3f20.y, vector3f20.z);
    }

    public static boolean testPlaneSphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float sqrt = (((f4 * f8) + ((f3 * f7) + (f2 * f6))) + f5) / ((float) Math.sqrt((double) ((f4 * f4) + ((f3 * f3) + (f2 * f2)))));
        return (-f9) <= sqrt && sqrt <= f9;
    }

    public static boolean testPlaneSweptSphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12) {
        float f13 = ((f8 * f4) + ((f7 * f3) + (f6 * f2))) - f5;
        float f14 = ((f12 * f4) + ((f11 * f3) + (f10 * f2))) - f5;
        return f13 * f14 < 0.0f || Math.abs(f13) <= f9 || Math.abs(f14) <= f9;
    }

    public static boolean testPointAar(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f2 >= f4 && f3 >= f5 && f2 <= f6 && f3 <= f7;
    }

    public static boolean testPointCircle(float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 - f4;
        float f8 = f3 - f5;
        return (f8 * f8) + (f7 * f7) <= f6;
    }

    public static boolean testPointInTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        float f14 = f8 - f5;
        float f15 = f9 - f6;
        float f16 = f10 - f7;
        float f17 = f11 - f5;
        float f18 = f12 - f6;
        float f19 = f13 - f7;
        float f20 = (f16 * f16) + (f15 * f15) + (f14 * f14);
        float f21 = (f16 * f19) + (f15 * f18) + (f14 * f17);
        float f22 = (f19 * f19) + (f18 * f18) + (f17 * f17);
        float f23 = (f20 * f22) - (f21 * f21);
        float f24 = f2 - f5;
        float f25 = f3 - f6;
        float f26 = f4 - f7;
        float f27 = (f16 * f26) + (f15 * f25) + (f14 * f24);
        float f28 = (f26 * f19) + (f25 * f18) + (f24 * f17);
        float f29 = (f22 * f27) - (f28 * f21);
        float f30 = (f28 * f20) - (f27 * f21);
        return (((long) (Runtime.floatToIntBits((f29 + f30) - f23) & (~(Runtime.floatToIntBits(f29) | Runtime.floatToIntBits(f30))))) & Long.MIN_VALUE) != 0;
    }

    public static boolean testPointTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        boolean z = true;
        boolean z2 = ((f5 - f7) * (f2 - f6)) - ((f3 - f7) * (f4 - f6)) < 0.0f;
        boolean z3 = ((f7 - f9) * (f2 - f8)) - ((f3 - f9) * (f6 - f8)) < 0.0f;
        if (z2 != z3) {
            return false;
        }
        if (z3 != (((f9 - f5) * (f2 - f4)) - ((f3 - f5) * (f8 - f4)) < 0.0f)) {
            z = false;
        }
        return z;
    }

    public static boolean testPointTriangle(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4) {
        return testPointTriangle(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y());
    }

    public static boolean testPolygonPolygon(Vector2f[] vector2fArr, Vector2f[] vector2fArr2) {
        int length = vector2fArr.length - 1;
        for (int i2 = 0; i2 < vector2fArr.length; i2++) {
            Vector2f vector2f = vector2fArr[i2];
            Vector2f vector2f2 = vector2fArr[length];
            if (separatingAxis(vector2fArr, vector2fArr2, vector2f.y - vector2f2.y, vector2f2.x - vector2f.x)) {
                return false;
            }
            length = i2;
        }
        int length2 = vector2fArr2.length - 1;
        for (int i3 = 0; i3 < vector2fArr2.length; i3++) {
            Vector2f vector2f3 = vector2fArr2[i3];
            Vector2f vector2f4 = vector2fArr2[length2];
            if (separatingAxis(vector2fArr, vector2fArr2, vector2f3.y - vector2f4.y, vector2f4.x - vector2f3.x)) {
                return false;
            }
            length2 = i3;
        }
        return true;
    }

    public static boolean testRayAab(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20 = 1.0f / f5;
        float f21 = 1.0f / f6;
        float f22 = 1.0f / f7;
        if (f20 >= 0.0f) {
            f15 = (f8 - f2) * f20;
            f14 = (f11 - f2) * f20;
        } else {
            float f23 = (f8 - f2) * f20;
            f15 = (f11 - f2) * f20;
            f14 = f23;
        }
        if (f21 >= 0.0f) {
            f17 = (f9 - f3) * f21;
            f16 = (f12 - f3) * f21;
        } else {
            float f24 = (f12 - f3) * f21;
            f16 = (f9 - f3) * f21;
            f17 = f24;
        }
        if (f15 > f16 || f17 > f14) {
            return false;
        }
        if (f22 >= 0.0f) {
            f19 = (f10 - f4) * f22;
            f18 = (f13 - f4) * f22;
        } else {
            float f25 = (f13 - f4) * f22;
            f18 = (f10 - f4) * f22;
            f19 = f25;
        }
        if (f15 > f18 || f19 > f14) {
            return false;
        }
        if (f17 > f15 || Float.isNaN(f15)) {
            f15 = f17;
        }
        if (f16 < f14 || Float.isNaN(f14)) {
            f14 = f16;
        }
        if (f19 <= f15) {
            f19 = f15;
        }
        if (f18 >= f14) {
            f18 = f14;
        }
        if (f19 >= f18 || f18 < 0.0f) {
            return false;
        }
        return true;
    }

    public static boolean testRayAar(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14 = 1.0f / f4;
        float f15 = 1.0f / f5;
        if (f14 >= 0.0f) {
            f11 = (f6 - f2) * f14;
            f10 = (f8 - f2) * f14;
        } else {
            float f16 = (f6 - f2) * f14;
            f11 = (f8 - f2) * f14;
            f10 = f16;
        }
        if (f15 >= 0.0f) {
            f13 = (f7 - f3) * f15;
            f12 = (f9 - f3) * f15;
        } else {
            float f17 = (f9 - f3) * f15;
            f12 = (f7 - f3) * f15;
            f13 = f17;
        }
        if (f11 > f12 || f13 > f10) {
            return false;
        }
        if (f13 > f11 || Float.isNaN(f11)) {
            f11 = f13;
        }
        if (f12 < f10 || Float.isNaN(f10)) {
            f10 = f12;
        }
        if (f11 >= f10 || f10 < 0.0f) {
            return false;
        }
        return true;
    }

    public static boolean testRayCircle(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f6 - f2;
        float f10 = f7 - f3;
        float f11 = (f5 * f10) + (f4 * f9);
        float f12 = ((f10 * f10) + (f9 * f9)) - (f11 * f11);
        boolean z = false;
        if (f12 > f8) {
            return false;
        }
        float sqrt = (float) Math.sqrt((double) (f8 - f12));
        float f13 = f11 - sqrt;
        float f14 = f11 + sqrt;
        if (f13 < f14 && f14 >= 0.0f) {
            z = true;
        }
        return z;
    }

    public static boolean testRaySphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        float f12 = f8 - f2;
        float f13 = f9 - f3;
        float f14 = f10 - f4;
        float f15 = f7 * f14;
        float f16 = f15 + (f6 * f13) + (f5 * f12);
        float f17 = f14 * f14;
        float f18 = (f17 + ((f13 * f13) + (f12 * f12))) - (f16 * f16);
        boolean z = false;
        if (f18 > f11) {
            return false;
        }
        float sqrt = (float) Math.sqrt((double) (f11 - f18));
        float f19 = f16 - sqrt;
        float f20 = f16 + sqrt;
        if (f19 < f20 && f20 >= 0.0f) {
            z = true;
        }
        return z;
    }

    public static boolean testRayTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = f7;
        float f19 = f17;
        float f20 = f11 - f8;
        float f21 = f12 - f9;
        float f22 = f13 - f10;
        float f23 = f14 - f8;
        float f24 = f15 - f9;
        float f25 = f16 - f10;
        float f26 = (f6 * f25) - (f18 * f24);
        float f27 = (f18 * f23) - (f5 * f25);
        float f28 = (f5 * f24) - (f6 * f23);
        float f29 = (f22 * f28) + (f21 * f27) + (f20 * f26);
        boolean z = false;
        if (f29 > (-f19) && f29 < f19) {
            return false;
        }
        float f30 = f2 - f8;
        float f31 = f3 - f9;
        float f32 = f4 - f10;
        float f33 = 1.0f / f29;
        float g2 = a.g(f28, f32, (f27 * f31) + (f26 * f30), f33);
        if (g2 >= 0.0f && g2 <= 1.0f) {
            float f34 = (f31 * f22) - (f32 * f21);
            float f35 = (f32 * f20) - (f22 * f30);
            float f36 = (f30 * f21) - (f31 * f20);
            float g3 = a.g(f18, f36, (f6 * f35) + (f5 * f34), f33);
            if (g3 >= 0.0f && g2 + g3 <= 1.0f) {
                if (a.g(f25, f36, (f24 * f35) + (f23 * f34), f33) >= f19) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean testRayTriangle(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector3fc vector3fc5, float f2) {
        return testRayTriangle(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector3fc5.x(), vector3fc5.y(), vector3fc5.z(), f2);
    }

    public static boolean testRayTriangleFront(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        float f18 = f11 - f8;
        float f19 = f12 - f9;
        float f20 = f13 - f10;
        float f21 = f14 - f8;
        float f22 = f15 - f9;
        float f23 = f16 - f10;
        float f24 = (f6 * f23) - (f7 * f22);
        float f25 = (f7 * f21) - (f5 * f23);
        float f26 = (f5 * f22) - (f6 * f21);
        float f27 = (f20 * f26) + (f19 * f25) + (f18 * f24);
        boolean z = false;
        if (f27 < f17) {
            return false;
        }
        float f28 = f2 - f8;
        float f29 = f3 - f9;
        float f30 = f4 - f10;
        float f31 = f26 * f30;
        float f32 = f31 + (f25 * f29) + (f24 * f28);
        if (f32 >= 0.0f && f32 <= f27) {
            float f33 = (f29 * f20) - (f30 * f19);
            float f34 = (f30 * f18) - (f20 * f28);
            float f35 = (f28 * f19) - (f29 * f18);
            float f36 = (f7 * f35) + (f6 * f34) + (f5 * f33);
            if (f36 >= 0.0f && f32 + f36 <= f27) {
                if (a.g(f23, f35, (f22 * f34) + (f21 * f33), 1.0f / f27) >= f17) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean testRayTriangleFront(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector3fc vector3fc5, float f2) {
        return testRayTriangleFront(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector3fc5.x(), vector3fc5.y(), vector3fc5.z(), f2);
    }

    public static boolean testSphereSphere(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f6 - f2;
        float f11 = f7 - f3;
        float f12 = f8 - f4;
        float f13 = (f12 * f12) + (f11 * f11) + (f10 * f10);
        float f14 = ((f5 - f9) / f13) + 0.5f;
        return f5 - ((f14 * f14) * f13) >= 0.0f;
    }

    public static boolean testSphereSphere(Vector3fc vector3fc, float f2, Vector3fc vector3fc2, float f3) {
        return testSphereSphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), f2, vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), f3);
    }

    public static float distancePointLine(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f6 - f4;
        float f9 = f7 - f5;
        return (((f5 - f3) * f8) - ((f4 - f2) * f9)) / ((float) Math.sqrt((double) ((f9 * f9) + (f8 * f8))));
    }

    public static float distancePointPlane(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        float f14 = f9 - f6;
        float f15 = f13 - f7;
        float f16 = f12 - f6;
        float f17 = f10 - f7;
        float f18 = f11 - f5;
        float f19 = f8 - f5;
        float f20 = (f14 * f15) - (f16 * f17);
        float f21 = (f17 * f18) - (f15 * f19);
        float f22 = (f19 * f16) - (f18 * f14);
        return distancePointPlane(f2, f3, f4, f20, f21, f22, -((f22 * f7) + (f21 * f6) + (f20 * f5)));
    }

    public static float intersectRayPlane(Rayf rayf, Planef planef, float f2) {
        return intersectRayPlane(rayf.oX, rayf.oY, rayf.oZ, rayf.dX, rayf.dY, rayf.dZ, planef.f1229a, planef.f1230b, planef.f1231c, planef.f1232d, f2);
    }

    public static boolean testAabAab(AABBf aABBf, AABBf aABBf2) {
        return testAabAab(aABBf.minX, aABBf.minY, aABBf.minZ, aABBf.maxX, aABBf.maxY, aABBf.maxZ, aABBf2.minX, aABBf2.minY, aABBf2.minZ, aABBf2.maxX, aABBf2.maxY, aABBf2.maxZ);
    }

    public static boolean testAabPlane(Vector3fc vector3fc, Vector3fc vector3fc2, float f2, float f3, float f4, float f5) {
        return testAabPlane(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), f2, f3, f4, f5);
    }

    public static boolean testAabSphere(AABBf aABBf, Spheref spheref) {
        float f2 = aABBf.minX;
        float f3 = aABBf.minY;
        float f4 = aABBf.minZ;
        float f5 = aABBf.maxX;
        float f6 = aABBf.maxY;
        float f7 = aABBf.maxZ;
        float f8 = spheref.x;
        float f9 = spheref.y;
        float f10 = spheref.z;
        float f11 = spheref.r;
        return testAabSphere(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11 * f11);
    }

    public static boolean testAarLine(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = f7 - f9;
        float f11 = f8 - f6;
        return testAarLine(f2, f3, f4, f5, f10, f11, ((-f11) * f7) - (f6 * f10));
    }

    public static boolean testLineSegmentTriangle(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector3fc vector3fc5, float f2) {
        return testLineSegmentTriangle(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector3fc5.x(), vector3fc5.y(), vector3fc5.z(), f2);
    }

    public static boolean testObOb(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25, float f26, float f27, float f28, float f29, float f30, float f31) {
        float f32 = (f11 * f26) + (f8 * f23) + (f5 * f20);
        float f33 = (f11 * f27) + (f8 * f24) + (f5 * f21);
        float f34 = (f11 * f28) + (f8 * f25) + (f5 * f22);
        float f35 = (f12 * f26) + (f9 * f23) + (f6 * f20);
        float f36 = (f12 * f27) + (f9 * f24) + (f6 * f21);
        float f37 = (f12 * f28) + (f9 * f25) + (f6 * f22);
        float f38 = (f13 * f26) + (f10 * f23) + (f7 * f20);
        float f39 = (f13 * f27) + (f10 * f24) + (f7 * f21);
        float f40 = (f13 * f28) + (f10 * f25) + (f7 * f22);
        float abs = Math.abs(f32) + 1.0E-5f;
        float abs2 = Math.abs(f35) + 1.0E-5f;
        float abs3 = Math.abs(f38) + 1.0E-5f;
        float abs4 = Math.abs(f33) + 1.0E-5f;
        float abs5 = Math.abs(f36) + 1.0E-5f;
        float abs6 = Math.abs(f39) + 1.0E-5f;
        float abs7 = Math.abs(f34) + 1.0E-5f;
        float abs8 = Math.abs(f37) + 1.0E-5f;
        float abs9 = Math.abs(f40) + 1.0E-5f;
        float f41 = f17 - f2;
        float f42 = f18 - f3;
        float f43 = f19 - f4;
        float f44 = (f43 * f7) + (f42 * f6) + (f41 * f5);
        float f45 = (f43 * f10) + (f42 * f9) + (f41 * f8);
        float f46 = f43 * f13;
        float f47 = f46 + (f42 * f12) + (f41 * f11);
        if (Math.abs(f44) > f14 + (f31 * abs3) + (f30 * abs2) + (f29 * abs)) {
            return false;
        }
        if (Math.abs(f45) > f15 + (f31 * abs6) + (f30 * abs5) + (f29 * abs4)) {
            return false;
        }
        if (Math.abs(f47) > f16 + (f31 * abs9) + (f30 * abs8) + (f29 * abs7)) {
            return false;
        }
        if (Math.abs((f47 * f34) + (f45 * f33) + (f44 * f32)) > (f16 * abs7) + (f15 * abs4) + (f14 * abs) + f29) {
            return false;
        }
        if (Math.abs((f47 * f37) + (f45 * f36) + (f44 * f35)) > (f16 * abs8) + (f15 * abs5) + (f14 * abs2) + f30) {
            return false;
        }
        if (Math.abs((f47 * f40) + (f45 * f39) + (f44 * f38)) > (f16 * abs9) + (f15 * abs6) + (f14 * abs3) + f31) {
            return false;
        }
        if (Math.abs((f47 * f33) - (f45 * f34)) > (f16 * abs4) + (f15 * abs7) + (f31 * abs2) + (f30 * abs3)) {
            return false;
        }
        if (Math.abs((f47 * f36) - (f45 * f37)) > (f16 * abs5) + (f15 * abs8) + (f31 * abs) + (f29 * abs3)) {
            return false;
        }
        if (Math.abs((f47 * f39) - (f45 * f40)) > (f16 * abs6) + (f15 * abs9) + (f30 * abs) + (f29 * abs2)) {
            return false;
        }
        if (Math.abs((f34 * f44) - (f47 * f32)) > (f16 * abs) + (f14 * abs7) + (f31 * abs5) + (f30 * abs6)) {
            return false;
        }
        if (Math.abs((f37 * f44) - (f47 * f35)) > (f16 * abs2) + (f14 * abs8) + (f31 * abs4) + (f29 * abs6)) {
            return false;
        }
        if (Math.abs((f40 * f44) - (f47 * f38)) > (f16 * abs3) + (f14 * abs9) + (f30 * abs4) + (f29 * abs5)) {
            return false;
        }
        if (Math.abs((f32 * f45) - (f33 * f44)) > (f15 * abs) + (f14 * abs4) + (f31 * abs8) + (f30 * abs9)) {
            return false;
        }
        if (Math.abs((f35 * f45) - (f36 * f44)) > (f15 * abs2) + (f14 * abs5) + (f31 * abs7) + (f29 * abs9)) {
            return false;
        }
        if (Math.abs((f45 * f38) - (f44 * f39)) > (f15 * abs3) + (f14 * abs6) + (f30 * abs7) + (f29 * abs8)) {
            return false;
        }
        return true;
    }

    public static boolean testPlaneSphere(Planef planef, Spheref spheref) {
        return testPlaneSphere(planef.f1229a, planef.f1230b, planef.f1231c, planef.f1232d, spheref.x, spheref.y, spheref.z, spheref.r);
    }

    public static boolean testRayCircle(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, float f2) {
        return testRayCircle(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), f2);
    }

    public static boolean testRaySphere(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, float f2) {
        return testRaySphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), f2);
    }

    public static float distancePointLine(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f8 - f5;
        float f12 = f9 - f6;
        float f13 = f10 - f7;
        float f14 = f5 - f2;
        float f15 = f6 - f3;
        float f16 = f7 - f4;
        float f17 = (f12 * f16) - (f13 * f15);
        float f18 = (f13 * f14) - (f16 * f11);
        float f19 = (f15 * f11) - (f14 * f12);
        return (float) Math.sqrt((double) a.h(f13, f13, (f12 * f12) + (f11 * f11), (f19 * f19) + (f18 * f18) + (f17 * f17)));
    }

    public static boolean testRayAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4) {
        return testRayAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z());
    }

    public static boolean testRayAar(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4) {
        return testRayAar(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y());
    }

    public static boolean testRaySphere(Rayf rayf, Spheref spheref) {
        float f2 = rayf.oX;
        float f3 = rayf.oY;
        float f4 = rayf.oZ;
        float f5 = rayf.dX;
        float f6 = rayf.dY;
        float f7 = rayf.dZ;
        float f8 = spheref.x;
        float f9 = spheref.y;
        float f10 = spheref.z;
        float f11 = spheref.r;
        return testRaySphere(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11 * f11);
    }

    public static boolean intersectRayCircle(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, float f2, Vector2f vector2f) {
        return intersectRayCircle(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), f2, vector2f);
    }

    public static boolean intersectRaySphere(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, float f2, Vector2f vector2f) {
        return intersectRaySphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), f2, vector2f);
    }

    public static boolean testRayAab(Rayf rayf, AABBf aABBf) {
        return testRayAab(rayf.oX, rayf.oY, rayf.oZ, rayf.dX, rayf.dY, rayf.dZ, aABBf.minX, aABBf.minY, aABBf.minZ, aABBf.maxX, aABBf.maxY, aABBf.maxZ);
    }

    public static boolean intersectCircleCircle(Vector2fc vector2fc, float f2, Vector2fc vector2fc2, float f3, Vector3f vector3f) {
        return intersectCircleCircle(vector2fc.x(), vector2fc.y(), f2, vector2fc2.x(), vector2fc2.y(), f3, vector3f);
    }

    public static boolean intersectLineCircle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, Vector3f vector3f) {
        return intersectLineCircle(f3 - f5, f4 - f2, a.e(f5, f3, f2, (f2 - f4) * f3), f6, f7, f8, vector3f);
    }

    public static int intersectLineSegmentAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector2f vector2f) {
        return intersectLineSegmentAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector2f);
    }

    public static int intersectLineSegmentAar(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4, Vector2f vector2f) {
        return intersectLineSegmentAar(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y(), vector2f);
    }

    public static boolean intersectLineSegmentTriangle(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector3fc vector3fc5, float f2, Vector3f vector3f) {
        return intersectLineSegmentTriangle(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector3fc5.x(), vector3fc5.y(), vector3fc5.z(), f2, vector3f);
    }

    public static boolean intersectRayAab(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector2f vector2f) {
        return intersectRayAab(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector2f);
    }

    public static boolean intersectRaySphere(Rayf rayf, Spheref spheref, Vector2f vector2f) {
        float f2 = rayf.oX;
        float f3 = rayf.oY;
        float f4 = rayf.oZ;
        float f5 = rayf.dX;
        float f6 = rayf.dY;
        float f7 = rayf.dZ;
        float f8 = spheref.x;
        float f9 = spheref.y;
        float f10 = spheref.z;
        float f11 = spheref.r;
        return intersectRaySphere(f2, f3, f4, f5, f6, f7, f8, f9, f10, f11 * f11, vector2f);
    }

    public static boolean intersectSphereSphere(Vector3fc vector3fc, float f2, Vector3fc vector3fc2, float f3, Vector4f vector4f) {
        return intersectSphereSphere(vector3fc.x(), vector3fc.y(), vector3fc.z(), f2, vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), f3, vector4f);
    }

    public static boolean testMovingCircleCircle(Vector2f vector2f, Vector2f vector2f2, float f2, Vector2f vector2f3, float f3) {
        return testMovingCircleCircle(vector2f.x, vector2f.y, vector2f2.x, vector2f2.y, f2, vector2f3.x, vector2f3.y, f3);
    }

    public static int intersectLineSegmentAab(LineSegmentf lineSegmentf, AABBf aABBf, Vector2f vector2f) {
        return intersectLineSegmentAab(lineSegmentf.aX, lineSegmentf.aY, lineSegmentf.aZ, lineSegmentf.bX, lineSegmentf.bY, lineSegmentf.bZ, aABBf.minX, aABBf.minY, aABBf.minZ, aABBf.maxX, aABBf.maxY, aABBf.maxZ, vector2f);
    }

    public static boolean intersectRayAab(Rayf rayf, AABBf aABBf, Vector2f vector2f) {
        return intersectRayAab(rayf.oX, rayf.oY, rayf.oZ, rayf.dX, rayf.dY, rayf.dZ, aABBf.minX, aABBf.minY, aABBf.minZ, aABBf.maxX, aABBf.maxY, aABBf.maxZ, vector2f);
    }

    public static boolean intersectSphereSphere(Spheref spheref, Spheref spheref2, Vector4f vector4f) {
        float f2 = spheref.x;
        float f3 = spheref.y;
        float f4 = spheref.z;
        float f5 = spheref.r;
        float f6 = f5 * f5;
        float f7 = spheref2.x;
        float f8 = spheref2.y;
        float f9 = spheref2.z;
        float f10 = spheref2.r;
        return intersectSphereSphere(f2, f3, f4, f6, f7, f8, f9, f10 * f10, vector4f);
    }

    public static int intersectPolygonRay(Vector2fc[] vector2fcArr, float f2, float f3, float f4, float f5, Vector2f vector2f) {
        Vector2fc[] vector2fcArr2 = vector2fcArr;
        float f6 = f5;
        Vector2f vector2f2 = vector2f;
        int length = vector2fcArr2.length;
        int i2 = length - 1;
        float x = vector2fcArr2[i2].x();
        float y = vector2fcArr2[i2].y();
        float f7 = Float.POSITIVE_INFINITY;
        int i3 = -1;
        int i4 = 0;
        while (i4 < length) {
            Vector2fc vector2fc = vector2fcArr2[i4];
            float x2 = vector2fc.x();
            float y2 = vector2fc.y();
            float f8 = f2 - x;
            float f9 = f3 - y;
            float f10 = x2 - x;
            float f11 = y2 - y;
            float f12 = 1.0f / ((f11 * f4) - (f10 * f6));
            float i5 = a.i(f11, f8, f10 * f9, f12);
            if (i5 >= 0.0f && i5 < f7) {
                float i6 = a.i(f8, f6, f9 * f4, f12);
                if (i6 >= 0.0f && i6 <= 1.0f) {
                    int i7 = ((i4 - 1) + length) % length;
                    vector2f2.x = (i5 * f4) + f2;
                    vector2f2.y = (i5 * f6) + f3;
                    f7 = i5;
                    i3 = i7;
                }
            }
            i4++;
            y = y2;
            x = x2;
        }
        return i3;
    }

    public static int intersectRayAar(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4, Vector2f vector2f) {
        return intersectRayAar(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y(), vector2f);
    }

    public static int findClosestPointOnTriangle(Vector3fc vector3fc, Vector3fc vector3fc2, Vector3fc vector3fc3, Vector3fc vector3fc4, Vector3f vector3f) {
        return findClosestPointOnTriangle(vector3fc.x(), vector3fc.y(), vector3fc.z(), vector3fc2.x(), vector3fc2.y(), vector3fc2.z(), vector3fc3.x(), vector3fc3.y(), vector3fc3.z(), vector3fc4.x(), vector3fc4.y(), vector3fc4.z(), vector3f);
    }

    public static int findClosestPointOnTriangle(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, Vector2f vector2f) {
        float f10 = f2;
        float f11 = f3;
        float f12 = f4;
        float f13 = f5;
        float f14 = f6;
        float f15 = f7;
        Vector2f vector2f2 = vector2f;
        float f16 = f12 - f10;
        float f17 = f13 - f11;
        float f18 = f14 - f10;
        float f19 = f15 - f11;
        float f20 = f8 - f10;
        float f21 = f9 - f11;
        float f22 = (f17 * f21) + (f16 * f20);
        float f23 = (f21 * f19) + (f20 * f18);
        if (f22 > 0.0f || f23 > 0.0f) {
            float f24 = f8 - f12;
            float f25 = f9 - f13;
            float f26 = (f17 * f25) + (f16 * f24);
            float f27 = (f25 * f19) + (f24 * f18);
            if (f26 < 0.0f || f27 > f26) {
                float f28 = (f22 * f27) - (f26 * f23);
                if (f28 > 0.0f || f22 < 0.0f || f26 > 0.0f) {
                    float f29 = f8 - f14;
                    float f30 = f9 - f15;
                    float f31 = (f17 * f30) + (f16 * f29);
                    float f32 = (f30 * f19) + (f29 * f18);
                    if (f32 < 0.0f || f31 > f32) {
                        float f33 = (f31 * f23) - (f22 * f32);
                        if (f33 > 0.0f || f23 < 0.0f || f32 > 0.0f) {
                            float f34 = (f26 * f32) - (f31 * f27);
                            if (f34 <= 0.0f) {
                                float f35 = f27 - f26;
                                if (f35 >= 0.0f && f31 - f32 >= 0.0f) {
                                    float f36 = f35 / ((f35 + f31) - f32);
                                    vector2f2.x = a.e(f14, f12, f36, f12);
                                    vector2f2.y = a.e(f15, f13, f36, f13);
                                    return 5;
                                }
                            }
                            float f37 = 1.0f / ((f34 + f33) + f28);
                            float f38 = f33 * f37;
                            float f39 = f28 * f37;
                            vector2f2.x = (f18 * f39) + (f16 * f38) + f10;
                            vector2f2.y = (f19 * f39) + (f17 * f38) + f11;
                            return 2;
                        }
                        float f40 = f23 / (f23 - f32);
                        vector2f2.x = (f18 * f40) + f10;
                        vector2f2.y = (f40 * f19) + f11;
                        return 6;
                    }
                    vector2f2.x = f14;
                    vector2f2.y = f15;
                    return 3;
                }
                float f41 = f22 / (f22 - f26);
                vector2f2.x = (f16 * f41) + f10;
                vector2f2.y = (f41 * f17) + f11;
                return 4;
            }
            vector2f2.x = f12;
            vector2f2.y = f13;
            return 2;
        }
        vector2f2.x = f10;
        vector2f2.y = f11;
        return 1;
    }

    public static int findClosestPointOnTriangle(Vector2fc vector2fc, Vector2fc vector2fc2, Vector2fc vector2fc3, Vector2fc vector2fc4, Vector2f vector2f) {
        return findClosestPointOnTriangle(vector2fc.x(), vector2fc.y(), vector2fc2.x(), vector2fc2.y(), vector2fc3.x(), vector2fc3.y(), vector2fc4.x(), vector2fc4.y(), vector2f);
    }
}
