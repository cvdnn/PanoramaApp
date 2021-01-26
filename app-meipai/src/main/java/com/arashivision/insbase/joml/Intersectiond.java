package com.arashivision.insbase.joml;

import com.arashivision.insbase.joml.internal.Runtime;
import e.a.a.a.a;

public class Intersectiond {
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

    public static double computeLowestRoot(double d2, double d3, double d4, double d5) {
        double d6 = d3;
        double d7 = (d6 * d6) - ((4.0d * d2) * d4);
        if (d7 < 0.0d) {
            return Double.POSITIVE_INFINITY;
        }
        double sqrt = Math.sqrt(d7);
        double d8 = -d6;
        double d9 = 2.0d * d2;
        double d10 = (d8 - sqrt) / d9;
        double d11 = (d8 + sqrt) / d9;
        if (d10 > d11) {
            double d12 = d11;
            d11 = d10;
            d10 = d12;
        }
        if (d10 > 0.0d && d10 < d5) {
            return d10;
        }
        if (d11 <= 0.0d || d11 >= d5) {
            return Double.POSITIVE_INFINITY;
        }
        return d11;
    }

    public static double distancePointLine(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 * d5;
        return (((d5 * d3) + (d4 * d2)) + d6) / Math.sqrt(d7 + (d4 * d4));
    }

    public static double distancePointPlane(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return (((d7 * d4) + ((d6 * d3) + (d5 * d2))) + d8) / Math.sqrt((d7 * d7) + ((d6 * d6) + (d5 * d5)));
    }

    public static Vector3d findClosestPointOnLineSegment(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d11 = d5 - d2;
        double d12 = d6 - d3;
        double d13 = d7 - d4;
        double l = a.l(d13, d13, (d11 * d11) + (d12 * d12), a.h(d10, d4, d13, a.h(d9, d3, d12, (d8 - d2) * d11)));
        if (l < 0.0d) {
            l = 0.0d;
        }
        if (l > 1.0d) {
            l = 1.0d;
        }
        vector3d2.x = (d11 * l) + d2;
        vector3d2.y = (d12 * l) + d3;
        vector3d2.z = (l * d13) + d4;
        return vector3d2;
    }

    public static Vector3d findClosestPointOnPlane(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d11 = (d6 * d3) + (d5 * d2);
        double d12 = ((d7 * d10) + ((d6 * d9) + (d5 * d8))) - (-((d7 * d4) + d11));
        vector3d2.x = d8 - (d12 * d5);
        vector3d2.y = d9 - (d12 * d6);
        vector3d2.z = d10 - (d12 * d7);
        return vector3d2;
    }

    public static Vector3d findClosestPointOnRectangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, Vector3d vector3d) {
        double d14;
        double d15;
        double d16;
        Vector3d vector3d2 = vector3d;
        double d17 = d5 - d2;
        double d18 = d6 - d3;
        double d19 = d7 - d4;
        double d20 = d8 - d2;
        double d21 = d9 - d3;
        double d22 = d10 - d4;
        double d23 = d11 - d2;
        double d24 = d12 - d3;
        double d25 = d13 - d4;
        double i2 = (d25 * d19) + a.i(d23, d17, d24, d18);
        double d26 = (d19 * d19) + (d18 * d18) + (d17 * d17);
        if (i2 >= d26) {
            d16 = d2 + d17;
            d15 = d3 + d18;
            d14 = d4 + d19;
        } else if (i2 > 0.0d) {
            double d27 = i2 / d26;
            d16 = (d17 * d27) + d2;
            d15 = (d18 * d27) + d3;
            d14 = (d27 * d19) + d4;
        } else {
            d16 = d2;
            d15 = d3;
            d14 = d4;
        }
        double d28 = d25 * d22;
        double d29 = d28 + (d24 * d21) + (d23 * d20);
        double d30 = (d22 * d22) + (d21 * d21) + (d20 * d20);
        if (d29 >= d30) {
            d16 += d20;
            d15 += d21;
            d14 += d22;
        } else if (d29 > 0.0d) {
            double d31 = d29 / d30;
            d16 += d20 * d31;
            d15 += d21 * d31;
            d14 = (d31 * d22) + d14;
        }
        vector3d2.x = d16;
        vector3d2.y = d15;
        vector3d2.z = d14;
        return vector3d2;
    }

    public static int findClosestPointOnTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, Vector3d vector3d) {
        double d14 = d2;
        double d15 = d3;
        double d16 = d4;
        double d17 = d5;
        double d18 = d6;
        double d19 = d7;
        double d20 = d8;
        double d21 = d17 - d14;
        double d22 = d18 - d15;
        double d23 = d19 - d16;
        double d24 = d20 - d14;
        double d25 = d9 - d15;
        double d26 = d10 - d16;
        double d27 = d11 - d14;
        double d28 = d12 - d15;
        double d29 = d13 - d16;
        double d30 = (d23 * d29) + (d22 * d28) + (d21 * d27);
        double d31 = d29 * d26;
        double d32 = d31 + (d28 * d25) + (d27 * d24);
        if (d30 > 0.0d || d32 > 0.0d) {
            Vector3d vector3d2 = vector3d;
            double d33 = d11 - d17;
            double d34 = d12 - d18;
            double d35 = d13 - d19;
            double d36 = (d23 * d35) + (d22 * d34) + (d21 * d33);
            double d37 = d35 * d26;
            double d38 = d37 + (d34 * d25) + (d33 * d24);
            if (d36 < 0.0d || d38 > d36) {
                double d39 = (d30 * d38) - (d36 * d32);
                if (d39 > 0.0d || d30 < 0.0d || d36 > 0.0d) {
                    double d40 = d11 - d20;
                    double d41 = d9;
                    double d42 = d10;
                    double d43 = d12 - d41;
                    double d44 = d13 - d42;
                    double d45 = (d23 * d44) + (d22 * d43) + (d21 * d40);
                    double d46 = d44 * d26;
                    double d47 = d46 + (d43 * d25) + (d40 * d24);
                    if (d47 < 0.0d || d45 > d47) {
                        double d48 = (d45 * d32) - (d30 * d47);
                        if (d48 > 0.0d || d32 < 0.0d || d47 > 0.0d) {
                            double d49 = (d36 * d47) - (d45 * d38);
                            if (d49 <= 0.0d) {
                                double d50 = d38 - d36;
                                if (d50 >= 0.0d && d45 - d47 >= 0.0d) {
                                    double d51 = d50 / ((d50 + d45) - d47);
                                    vector3d2.x = a.h(d8, d5, d51, d5);
                                    double d52 = d51;
                                    vector3d2.y = a.h(d9, d6, d52, d6);
                                    vector3d2.z = a.h(d10, d7, d52, d7);
                                    return 5;
                                }
                            }
                            double d53 = 1.0d / ((d49 + d48) + d39);
                            double d54 = d48 * d53;
                            double d55 = d39 * d53;
                            vector3d2.x = (d24 * d55) + (d21 * d54) + d14;
                            vector3d2.y = (d25 * d55) + (d22 * d54) + d15;
                            vector3d2.z = (d26 * d55) + (d23 * d54) + d16;
                            return 2;
                        }
                        double d56 = d32 / (d32 - d47);
                        vector3d2.x = (d24 * d56) + d14;
                        vector3d2.y = (d25 * d56) + d15;
                        vector3d2.z = (d56 * d26) + d16;
                        return 6;
                    }
                    vector3d2.x = d20;
                    vector3d2.y = d41;
                    vector3d2.z = d42;
                    return 3;
                }
                double d57 = d30 / (d30 - d36);
                vector3d2.x = (d21 * d57) + d14;
                vector3d2.y = (d22 * d57) + d15;
                vector3d2.z = (d57 * d23) + d16;
                return 4;
            }
            vector3d2.x = d17;
            vector3d2.y = d18;
            vector3d2.z = d19;
            return 2;
        }
        Vector3d vector3d3 = vector3d;
        vector3d3.x = d14;
        vector3d3.y = d15;
        vector3d3.z = d16;
        return 1;
    }

    public static double findClosestPointsLineSegmentTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, Vector3d vector3d, Vector3d vector3d2) {
        double d17;
        double d18;
        double d19;
        double d20;
        double d21;
        double d22;
        double d23;
        double d24;
        double d25;
        double d26;
        double d27;
        double d28;
        Vector3d vector3d3 = vector3d;
        Vector3d vector3d4 = vector3d2;
        double d29 = d2;
        double d30 = d3;
        double d31 = d4;
        double d32 = d5;
        double d33 = d6;
        double d34 = d7;
        double d35 = d11;
        double d36 = d12;
        double d37 = d13;
        double d38 = d14;
        double d39 = d15;
        double d40 = d16;
        Vector3d vector3d5 = vector3d;
        Vector3d vector3d6 = vector3d2;
        double findClosestPointsLineSegments = findClosestPointsLineSegments(d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, vector3d, vector3d2);
        Vector3d vector3d7 = vector3d;
        double d41 = vector3d7.x;
        double d42 = vector3d7.y;
        double d43 = vector3d7.z;
        Vector3d vector3d8 = vector3d2;
        double d44 = vector3d8.x;
        double d45 = vector3d8.y;
        double d46 = vector3d8.z;
        double findClosestPointsLineSegments2 = findClosestPointsLineSegments(d29, d30, d31, d32, d33, d34, d35, d36, d37, d38, d39, d40, vector3d5, vector3d6);
        if (findClosestPointsLineSegments2 < findClosestPointsLineSegments) {
            double d47 = vector3d7.x;
            double d48 = vector3d7.y;
            double d49 = vector3d7.z;
            double d50 = vector3d8.x;
            d22 = d47;
            d21 = d48;
            d20 = d49;
            d19 = d50;
            d18 = vector3d8.y;
            d17 = vector3d8.z;
            d23 = findClosestPointsLineSegments2;
        } else {
            d23 = findClosestPointsLineSegments;
            d22 = d41;
            d21 = d42;
            d20 = d43;
            d19 = d44;
            d18 = d45;
            d17 = d46;
        }
        double findClosestPointsLineSegments3 = findClosestPointsLineSegments(d2, d3, d4, d5, d6, d7, d14, d15, d16, d8, d9, d10, vector3d, vector3d2);
        if (findClosestPointsLineSegments3 < d23) {
            Vector3d vector3d9 = vector3d;
            double d51 = vector3d9.x;
            double d52 = vector3d9.y;
            double d53 = vector3d9.z;
            Vector3d vector3d10 = vector3d2;
            double d54 = vector3d10.x;
            d23 = findClosestPointsLineSegments3;
            d22 = d51;
            d21 = d52;
            d20 = d53;
            d19 = d54;
            d18 = vector3d10.y;
            d17 = vector3d10.z;
        } else {
            Vector3d vector3d11 = vector3d;
            Vector3d vector3d12 = vector3d2;
        }
        boolean z = false;
        double d55 = Double.NaN;
        if (testPointInTriangle(d2, d3, d4, d8, d9, d10, d11, d12, d13, d14, d15, d16)) {
            double d56 = d12 - d9;
            double d57 = d16 - d10;
            double d58 = d15 - d9;
            double d59 = d13 - d10;
            double d60 = d14 - d8;
            double d61 = d11 - d8;
            double d62 = (d56 * d57) - (d58 * d59);
            double d63 = (d59 * d60) - (d57 * d61);
            double d64 = (d61 * d58) - (d60 * d56);
            z = true;
            double d65 = d64;
            double d66 = d64;
            double e2 = a.e(d65, d66, (d63 * d63) + (d62 * d62), 1.0d);
            double d67 = d62 * e2;
            double d68 = d63 * e2;
            double d69 = e2 * d64;
            double d70 = -((d69 * d10) + (d68 * d9) + (d67 * d8));
            double d71 = d69;
            double d72 = d4;
            double i2 = a.i(d71, d72, (d68 * d3) + (d67 * d2), d70);
            double d73 = i2 * i2;
            if (d73 < d23) {
                d19 = d2 - (d67 * i2);
                d18 = d3 - (d68 * i2);
                d17 = d4 - (i2 * d69);
                d22 = d2;
                d21 = d3;
                d20 = d4;
                d23 = d73;
            }
            d24 = d70;
            d25 = d68;
            d55 = d67;
            d26 = d69;
        } else {
            d26 = Double.NaN;
            d25 = Double.NaN;
            d24 = Double.NaN;
        }
        if (testPointInTriangle(d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16)) {
            if (!z) {
                double d74 = d12 - d9;
                double d75 = d16 - d10;
                double d76 = d15 - d9;
                double d77 = d13 - d10;
                double d78 = d14 - d8;
                double d79 = d11 - d8;
                double d80 = (d74 * d75) - (d76 * d77);
                double d81 = (d77 * d78) - (d75 * d79);
                double d82 = (d79 * d76) - (d78 * d74);
                double e3 = a.e(d82, d82, (d80 * d80) + (d81 * d81), 1.0d);
                double d83 = d80 * e3;
                d25 = d81 * e3;
                double d84 = e3 * d82;
                d24 = -((d84 * d10) + (d25 * d9) + (d83 * d8));
                d55 = d83;
                d26 = d84;
            }
            double i3 = a.i(d26, d7, (d55 * d5) + (d25 * d6), d24);
            double d85 = i3 * i3;
            if (d85 < d23) {
                d28 = d5 - (d55 * i3);
                d27 = d7 - (d26 * i3);
                d22 = d5;
                d21 = d6;
                d20 = d7;
                d18 = d6 - (d25 * i3);
                d23 = d85;
                vector3d.set(d22, d21, d20);
                vector3d2.set(d28, d18, d27);
                return d23;
            }
        }
        d28 = d19;
        d27 = d17;
        vector3d.set(d22, d21, d20);
        vector3d2.set(d28, d18, d27);
        return d23;
    }

    public static double findClosestPointsLineSegments(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, Vector3d vector3d, Vector3d vector3d2) {
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        Vector3d vector3d3 = vector3d;
        Vector3d vector3d4 = vector3d2;
        double d20 = d5 - d2;
        double d21 = d6 - d3;
        double d22 = d7 - d4;
        double d23 = d11 - d8;
        double d24 = d12 - d9;
        double d25 = d13 - d10;
        double d26 = d2 - d8;
        double d27 = d3 - d9;
        double d28 = d4 - d10;
        double d29 = (d22 * d22) + (d21 * d21) + (d20 * d20);
        double d30 = (d25 * d25) + (d24 * d24) + (d23 * d23);
        double d31 = (d25 * d28) + (d24 * d27) + (d23 * d26);
        int i2 = (d29 > 1.0E-8d ? 1 : (d29 == 1.0E-8d ? 0 : -1));
        if (i2 > 0 || d30 > 1.0E-8d) {
            if (i2 <= 0) {
                d16 = d25;
                d15 = d23;
                d14 = d24;
                d17 = Math.min(Math.max(d31 / d30, 0.0d), 1.0d);
                d18 = 0.0d;
            } else {
                d16 = d25;
                double d32 = d28 * d22;
                double d33 = d32 + (d27 * d21) + (d26 * d20);
                if (d30 <= 1.0E-8d) {
                    d18 = Math.min(Math.max((-d33) / d29, 0.0d), 1.0d);
                    d15 = d23;
                    d14 = d24;
                    d17 = 0.0d;
                } else {
                    double d34 = (d22 * d16) + (d21 * d24) + (d20 * d23);
                    double d35 = (d29 * d30) - (d34 * d34);
                    d14 = d24;
                    if (d35 != 0.0d) {
                        d15 = d23;
                        d19 = Math.min(Math.max(((d34 * d31) - (d33 * d30)) / d35, 0.0d), 1.0d);
                    } else {
                        d15 = d23;
                        d19 = 0.0d;
                    }
                    double d36 = ((d34 * d19) + d31) / d30;
                    d17 = 0.0d;
                    if (d36 < 0.0d) {
                        d18 = Math.min(Math.max((-d33) / d29, 0.0d), 1.0d);
                    } else {
                        d17 = 1.0d;
                        if (d36 > 1.0d) {
                            d18 = Math.min(Math.max((d34 - d33) / d29, 0.0d), 1.0d);
                        } else {
                            d18 = d19;
                            d17 = d36;
                        }
                    }
                }
            }
            vector3d.set((d20 * d18) + d2, (d21 * d18) + d3, (d22 * d18) + d4);
            vector3d2.set((d15 * d17) + d8, (d14 * d17) + d9, (d16 * d17) + d10);
            Vector3d vector3d5 = vector3d;
            Vector3d vector3d6 = vector3d2;
            double d37 = vector3d5.x - vector3d6.x;
            double d38 = vector3d5.y - vector3d6.y;
            double d39 = vector3d5.z - vector3d6.z;
            return (d39 * d39) + (d38 * d38) + (d37 * d37);
        }
        vector3d.set(d2, d3, d4);
        vector3d2.set(d8, d9, d10);
        return vector3d.dot(vector3d2);
    }

    public static boolean intersectCircleCircle(double d2, double d3, double d4, double d5, double d6, double d7, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        double d10 = (d9 * d9) + (d8 * d8);
        double d11 = ((d4 - d7) / d10) + 0.5d;
        double sqrt = Math.sqrt(d4 - ((d11 * d11) * d10));
        if (sqrt < 0.0d) {
            return false;
        }
        vector3d2.x = (d8 * d11) + d2;
        vector3d2.y = (d11 * d9) + d3;
        vector3d2.z = sqrt;
        return true;
    }

    public static boolean intersectLineCircle(double d2, double d3, double d4, double d5, double d6, double d7, Vector3d vector3d) {
        double d8 = d7;
        Vector3d vector3d2 = vector3d;
        double e2 = a.e(d3, d3, d2 * d2, 1.0d);
        double d9 = ((d3 * d6) + (d2 * d5) + d4) * e2;
        if ((-d8) > d9 || d9 > d8) {
            return false;
        }
        vector3d2.x = a.d(d9, d2, e2, d5);
        vector3d2.y = a.d(d9, d3, e2, d6);
        vector3d2.z = Math.sqrt((d8 * d8) - (d9 * d9));
        return true;
    }

    public static boolean intersectLineLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Vector2d vector2d) {
        Vector2d vector2d2 = vector2d;
        double d10 = d2 - d4;
        double d11 = d5 - d3;
        double d12 = (d10 * d3) + (d11 * d2);
        double d13 = d6 - d8;
        double d14 = d9 - d7;
        double d15 = (d13 * d7) + (d14 * d6);
        double d16 = (d11 * d13) - (d14 * d10);
        if (d16 == 0.0d) {
            return false;
        }
        vector2d2.x = ((d13 * d12) - (d10 * d15)) / d16;
        vector2d2.y = ((d11 * d15) - (d14 * d12)) / d16;
        return true;
    }

    public static int intersectLineSegmentAab(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, Vector2d vector2d) {
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        double d20;
        double d21;
        Vector2d vector2d2 = vector2d;
        double d22 = 1.0d / (d5 - d2);
        double d23 = 1.0d / (d6 - d3);
        double d24 = 1.0d / (d7 - d4);
        if (d22 >= 0.0d) {
            d15 = (d8 - d2) * d22;
            d14 = d11 - d2;
        } else {
            d15 = (d11 - d2) * d22;
            d14 = d8 - d2;
        }
        double d25 = d14 * d22;
        if (d23 >= 0.0d) {
            d17 = (d9 - d3) * d23;
            d16 = d12 - d3;
        } else {
            d17 = (d12 - d3) * d23;
            d16 = d9 - d3;
        }
        double d26 = d16 * d23;
        int i2 = -1;
        if (d15 <= d26 && d17 <= d25) {
            if (d24 >= 0.0d) {
                d19 = (d10 - d4) * d24;
                d18 = d13 - d4;
            } else {
                d19 = (d13 - d4) * d24;
                d18 = d10 - d4;
            }
            double d27 = d18 * d24;
            if (d15 <= d27 && d19 <= d25) {
                if (d17 > d15 || Double.isNaN(d15)) {
                    d15 = d17;
                }
                if (d26 < d25 || Double.isNaN(d25)) {
                    d25 = d26;
                }
                if (d19 <= d15) {
                    d19 = d15;
                }
                if (d27 >= d25) {
                    d27 = d25;
                }
                if (d19 < d27 && d19 <= 1.0d && d27 >= 0.0d) {
                    if (d19 <= 0.0d || d27 <= 1.0d) {
                        int i3 = (d19 > 0.0d ? 1 : (d19 == 0.0d ? 0 : -1));
                        if (i3 >= 0 || d27 >= 1.0d) {
                            i2 = (i3 >= 0 || d27 <= 1.0d) ? 2 : 3;
                            d21 = d19;
                            d20 = d27;
                            vector2d2.x = d21;
                            vector2d2.y = d20;
                        } else {
                            i2 = 1;
                            d21 = d27;
                        }
                    } else {
                        i2 = 1;
                        d21 = d19;
                    }
                    d20 = d21;
                    vector2d2.x = d21;
                    vector2d2.y = d20;
                }
            }
        }
        return i2;
    }

    public static int intersectLineSegmentAar(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Vector2d vector2d) {
        double d10;
        double d11;
        double d12;
        double d13;
        Vector2d vector2d2 = vector2d;
        double d14 = 1.0d / (d4 - d2);
        double d15 = 1.0d / (d5 - d3);
        if (d14 >= 0.0d) {
            d11 = (d6 - d2) * d14;
            d10 = d8 - d2;
        } else {
            d11 = (d8 - d2) * d14;
            d10 = d6 - d2;
        }
        double d16 = d10 * d14;
        if (d15 >= 0.0d) {
            d13 = (d7 - d3) * d15;
            d12 = d9 - d3;
        } else {
            d13 = (d9 - d3) * d15;
            d12 = d7 - d3;
        }
        double d17 = d12 * d15;
        int i2 = -1;
        if (d11 <= d17 && d13 <= d16) {
            if (d13 > d11 || Double.isNaN(d11)) {
                d11 = d13;
            }
            if (d17 < d16 || Double.isNaN(d16)) {
                d16 = d17;
            }
            if (d11 < d16 && d11 <= 1.0d && d16 >= 0.0d) {
                if (d11 <= 0.0d || d16 <= 1.0d) {
                    int i3 = (d11 > 0.0d ? 1 : (d11 == 0.0d ? 0 : -1));
                    if (i3 >= 0 || d16 >= 1.0d) {
                        i2 = (i3 >= 0 || d16 <= 1.0d) ? 2 : 3;
                    } else {
                        i2 = 1;
                        d11 = d16;
                    }
                } else {
                    i2 = 1;
                    d16 = d11;
                }
                vector2d2.x = d11;
                vector2d2.y = d16;
            }
        }
        return i2;
    }

    public static boolean intersectLineSegmentPlane(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d12 = d5 - d2;
        double d13 = d6 - d3;
        double d14 = d7 - d4;
        double d15 = (-a.i(d10, d4, (d8 * d2) + (d9 * d3), d11)) / ((d10 * d14) + ((d9 * d13) + (d8 * d12)));
        if (d15 < 0.0d || d15 > 1.0d) {
            return false;
        }
        vector3d2.x = (d12 * d15) + d2;
        vector3d2.y = (d13 * d15) + d3;
        vector3d2.z = (d15 * d14) + d4;
        return true;
    }

    public static boolean intersectLineSegmentTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        double d18 = d5 - d2;
        double d19 = d6 - d3;
        double d20 = d7 - d4;
        double intersectRayTriangle = intersectRayTriangle(d2, d3, d4, d18, d19, d20, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17);
        if (intersectRayTriangle < 0.0d || intersectRayTriangle > 1.0d) {
            return false;
        }
        Vector3d vector3d3 = vector3d;
        vector3d3.x = (d18 * intersectRayTriangle) + d2;
        vector3d3.y = (d19 * intersectRayTriangle) + d3;
        vector3d3.z = (d20 * intersectRayTriangle) + d4;
        return true;
    }

    public static boolean intersectPlaneSphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Vector4d vector4d) {
        double d10 = d9;
        Vector4d vector4d2 = vector4d;
        double d11 = d4;
        double d12 = d4;
        double e2 = a.e(d11, d12, (d3 * d3) + (d2 * d2), 1.0d);
        double d13 = ((d4 * d8) + (d3 * d7) + (d2 * d6) + d5) * e2;
        if ((-d10) > d13 || d13 > d10) {
            return false;
        }
        double d14 = e2;
        vector4d2.x = a.d(d13, d2, d14, d6);
        vector4d2.y = a.d(d13, d3, d14, d7);
        vector4d2.z = a.d(d13, d4, d14, d8);
        vector4d2.w = Math.sqrt((d10 * d10) - (d13 * d13));
        return true;
    }

    public static boolean intersectPlaneSweptSphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, Vector4d vector4d) {
        double d13 = d9;
        double d14 = ((d4 * d8) + ((d3 * d7) + (d2 * d6))) - d5;
        if (Math.abs(d14) <= d13) {
            vector4d.set(d6, d7, d8, 0.0d);
            return true;
        }
        double d15 = (d4 * d12) + (d3 * d11) + (d2 * d10);
        if (d15 * d14 >= 0.0d) {
            return false;
        }
        if (d14 <= 0.0d) {
            d13 = -d13;
        }
        double d16 = (d13 - d14) / d15;
        vector4d.set(((d16 * d10) + d6) - (d13 * d2), ((d16 * d11) + d7) - (d13 * d3), ((d16 * d12) + d8) - (d13 * d4), d16);
        return true;
    }

    public static int intersectPolygonRay(double[] dArr, double d2, double d3, double d4, double d5, Vector2d vector2d) {
        double[] dArr2 = dArr;
        Vector2d vector2d2 = vector2d;
        int length = dArr2.length >> 1;
        int i2 = (length - 1) << 1;
        double d6 = dArr2[i2];
        double d7 = dArr2[i2 + 1];
        int i3 = -1;
        double d8 = Double.POSITIVE_INFINITY;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 << 1;
            double d9 = dArr2[i5];
            double d10 = dArr2[i5 + 1];
            double d11 = d2 - d6;
            double d12 = d3 - d7;
            double d13 = d9 - d6;
            double d14 = d10 - d7;
            double d15 = 1.0d / ((d14 * d4) - (d13 * d5));
            double c2 = a.c(d14, d11, d13 * d12, d15);
            if (c2 >= 0.0d && c2 < d8) {
                double c3 = a.c(d11, d5, d12 * d4, d15);
                if (c3 >= 0.0d && c3 <= 1.0d) {
                    int i6 = ((i4 - 1) + length) % length;
                    vector2d2.x = (c2 * d4) + d2;
                    vector2d2.y = (c2 * d5) + d3;
                    i3 = i6;
                    d8 = c2;
                }
            }
            i4++;
            d6 = d9;
            d7 = d10;
        }
        return i3;
    }

    public static boolean intersectRayAab(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, Vector2d vector2d) {
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        Vector2d vector2d2 = vector2d;
        double d20 = 1.0d / d5;
        double d21 = 1.0d / d6;
        double d22 = 1.0d / d7;
        if (d20 >= 0.0d) {
            d15 = (d8 - d2) * d20;
            d14 = d11 - d2;
        } else {
            d15 = (d11 - d2) * d20;
            d14 = d8 - d2;
        }
        double d23 = d14 * d20;
        if (d21 >= 0.0d) {
            d17 = (d9 - d3) * d21;
            d16 = d12 - d3;
        } else {
            d17 = (d12 - d3) * d21;
            d16 = d9 - d3;
        }
        double d24 = d16 * d21;
        if (d15 <= d24 && d17 <= d23) {
            if (d22 >= 0.0d) {
                d19 = (d10 - d4) * d22;
                d18 = d13 - d4;
            } else {
                d19 = (d13 - d4) * d22;
                d18 = d10 - d4;
            }
            double d25 = d18 * d22;
            if (d15 <= d25 && d19 <= d23) {
                if (d17 > d15 || Double.isNaN(d15)) {
                    d15 = d17;
                }
                if (d24 < d23 || Double.isNaN(d23)) {
                    d23 = d24;
                }
                if (d19 > d15) {
                    d15 = d19;
                }
                if (d25 < d23) {
                    d23 = d25;
                }
                if (d15 < d23 && d23 >= 0.0d) {
                    vector2d2.x = d15;
                    vector2d2.y = d23;
                    return true;
                }
            }
        }
        return false;
    }

    public static int intersectRayAar(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Vector2d vector2d) {
        double d10;
        double d11;
        double d12;
        double d13;
        Vector2d vector2d2 = vector2d;
        double d14 = 1.0d / d4;
        double d15 = 1.0d / d5;
        if (d14 >= 0.0d) {
            d11 = (d6 - d2) * d14;
            d10 = d8 - d2;
        } else {
            d11 = (d8 - d2) * d14;
            d10 = d6 - d2;
        }
        double d16 = d10 * d14;
        if (d15 >= 0.0d) {
            d13 = (d7 - d3) * d15;
            d12 = d9 - d3;
        } else {
            d13 = (d9 - d3) * d15;
            d12 = d7 - d3;
        }
        double d17 = d12 * d15;
        if (d11 > d17 || d13 > d16) {
            return -1;
        }
        if (d13 > d11 || Double.isNaN(d11)) {
            d11 = d13;
        }
        if (d17 < d16 || Double.isNaN(d16)) {
            d16 = d17;
        }
        if (d11 >= d16 || d16 < 0.0d) {
            return -1;
        }
        double d18 = (d11 * d4) + d2;
        double d19 = (d11 * d5) + d3;
        vector2d2.x = d11;
        vector2d2.y = d16;
        double abs = Math.abs(d18 - d6);
        double abs2 = Math.abs(d19 - d7);
        double abs3 = Math.abs(d18 - d8);
        double abs4 = Math.abs(d19 - d9);
        int i2 = 0;
        if (abs2 < abs) {
            i2 = 1;
            abs = abs2;
        }
        if (abs3 < abs) {
            i2 = 2;
        } else {
            abs3 = abs;
        }
        if (abs4 < abs3) {
            return 3;
        }
        return i2;
    }

    public static boolean intersectRayCircle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, Vector2d vector2d) {
        double d9 = d6 - d2;
        double d10 = d7 - d3;
        double d11 = (d5 * d10) + (d4 * d9);
        double d12 = ((d10 * d10) + (d9 * d9)) - (d11 * d11);
        if (d12 > d8) {
            return false;
        }
        double sqrt = Math.sqrt(d8 - d12);
        double d13 = d11 - sqrt;
        double d14 = d11 + sqrt;
        if (d13 >= d14 || d14 < 0.0d) {
            return false;
        }
        vector2d.x = d13;
        vector2d.y = d14;
        return true;
    }

    public static double intersectRayLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = (d9 * d5) + (d8 * d4);
        if (d11 < d10) {
            double d12 = (((d7 - d3) * d9) + ((d6 - d2) * d8)) / d11;
            if (d12 >= 0.0d) {
                return d12;
            }
        }
        return -1.0d;
    }

    public static double intersectRayLine(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4, double d2) {
        return intersectRayLine(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y(), d2);
    }

    public static double intersectRayLineSegment(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d2 - d6;
        double d11 = d3 - d7;
        double d12 = d8 - d6;
        double d13 = d9 - d7;
        double d14 = 1.0d / ((d13 * d4) - (d12 * d5));
        double c2 = a.c(d13, d10, d12 * d11, d14);
        double c3 = a.c(d10, d5, d11 * d4, d14);
        if (c2 < 0.0d || c3 < 0.0d || c3 > 1.0d) {
            return -1.0d;
        }
        return c2;
    }

    public static double intersectRayLineSegment(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4) {
        return intersectRayLineSegment(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y());
    }

    public static double intersectRayPlane(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        double d13 = (d10 * d7) + (d9 * d6) + (d8 * d5);
        if (d13 < 0.0d) {
            double d14 = (-a.i(d10, d4, (d8 * d2) + (d9 * d3), d11)) / d13;
            if (d14 >= 0.0d) {
                return d14;
            }
        }
        return -1.0d;
    }

    public static double intersectRayPlane(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14) {
        double d15 = (d13 * d7) + (d12 * d6) + (d11 * d5);
        if (d15 < d14) {
            double h2 = (((d10 - d4) * d13) + a.h(d9, d3, d12, (d8 - d2) * d11)) / d15;
            if (h2 >= 0.0d) {
                return h2;
            }
        }
        return -1.0d;
    }

    public static double intersectRayPlane(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, double d2) {
        return intersectRayPlane(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), d2);
    }

    public static boolean intersectRaySphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, Vector2d vector2d) {
        Vector2d vector2d2 = vector2d;
        double d12 = d8 - d2;
        double d13 = d9 - d3;
        double d14 = d10 - d4;
        double d15 = (d14 * d7) + (d13 * d6) + (d12 * d5);
        double d16 = d14 * d14;
        double d17 = (d16 + ((d13 * d13) + (d12 * d12))) - (d15 * d15);
        if (d17 > d11) {
            return false;
        }
        double sqrt = Math.sqrt(d11 - d17);
        double d18 = d15 - sqrt;
        double d19 = d15 + sqrt;
        if (d18 >= d19 || d19 < 0.0d) {
            return false;
        }
        vector2d2.x = d18;
        vector2d2.y = d19;
        return true;
    }

    public static double intersectRayTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d17;
        double d19 = d11 - d8;
        double d20 = d12 - d9;
        double d21 = d13 - d10;
        double d22 = d14 - d8;
        double d23 = d15 - d9;
        double d24 = d16 - d10;
        double d25 = (d6 * d24) - (d7 * d23);
        double d26 = (d7 * d22) - (d5 * d24);
        double d27 = (d5 * d23) - (d6 * d22);
        double d28 = (d21 * d27) + (d20 * d26) + (d19 * d25);
        double d29 = d24;
        if (d28 > (-d18) && d28 < d18) {
            return -1.0d;
        }
        double d30 = d2 - d8;
        double d31 = d3 - d9;
        double d32 = d4 - d10;
        double d33 = 1.0d / d28;
        double k = a.k(d27, d32, (d26 * d31) + (d25 * d30), d33);
        if (k >= 0.0d && k <= 1.0d) {
            double d34 = (d31 * d21) - (d32 * d20);
            double d35 = (d32 * d19) - (d21 * d30);
            double d36 = (d30 * d20) - (d31 * d19);
            double k2 = a.k(d7, d36, (d5 * d34) + (d6 * d35), d33);
            if (k2 >= 0.0d && k + k2 <= 1.0d) {
                return a.k(d29, d36, (d23 * d35) + (d22 * d34), d33);
            }
        }
        return -1.0d;
    }

    public static double intersectRayTriangle(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector3dc vector3dc5, double d2) {
        return intersectRayTriangle(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector3dc5.x(), vector3dc5.y(), vector3dc5.z(), d2);
    }

    public static double intersectRayTriangleFront(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d11 - d8;
        double d19 = d12 - d9;
        double d20 = d13 - d10;
        double d21 = d14 - d8;
        double d22 = d15 - d9;
        double d23 = d16 - d10;
        double d24 = (d6 * d23) - (d7 * d22);
        double d25 = (d7 * d21) - (d5 * d23);
        double d26 = (d5 * d22) - (d6 * d21);
        double d27 = (d20 * d26) + (d19 * d25) + (d18 * d24);
        if (d27 <= d17) {
            return -1.0d;
        }
        double d28 = d2 - d8;
        double d29 = d3 - d9;
        double d30 = d4 - d10;
        double d31 = d26 * d30;
        double d32 = d31 + (d25 * d29) + (d24 * d28);
        if (d32 >= 0.0d && d32 <= d27) {
            double d33 = (d29 * d20) - (d30 * d19);
            double d34 = (d30 * d18) - (d20 * d28);
            double d35 = (d28 * d19) - (d29 * d18);
            double d36 = (d7 * d35) + (d6 * d34) + (d5 * d33);
            if (d36 >= 0.0d && d32 + d36 <= d27) {
                return a.k(d23, d35, (d22 * d34) + (d21 * d33), 1.0d / d27);
            }
        }
        return -1.0d;
    }

    public static double intersectRayTriangleFront(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector3dc vector3dc5, double d2) {
        return intersectRayTriangleFront(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector3dc5.x(), vector3dc5.y(), vector3dc5.z(), d2);
    }

    public static boolean intersectSphereSphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Vector4d vector4d) {
        Vector4d vector4d2 = vector4d;
        double d10 = d6 - d2;
        double d11 = d7 - d3;
        double d12 = d8 - d4;
        double d13 = (d12 * d12) + (d11 * d11) + (d10 * d10);
        double d14 = ((d5 - d9) / d13) + 0.5d;
        double d15 = d5 - ((d14 * d14) * d13);
        if (d15 < 0.0d) {
            return false;
        }
        vector4d2.x = (d10 * d14) + d2;
        vector4d2.y = (d11 * d14) + d3;
        vector4d2.z = (d14 * d12) + d4;
        vector4d2.w = Math.sqrt(d15);
        return true;
    }

    public static int intersectSphereTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, Vector3d vector3d) {
        Vector3d vector3d2 = vector3d;
        int findClosestPointOnTriangle = findClosestPointOnTriangle(d6, d7, d8, d9, d10, d11, d12, d13, d14, d2, d3, d4, vector3d);
        Vector3d vector3d3 = vector3d;
        double d15 = vector3d3.x - d2;
        double d16 = vector3d3.y - d3;
        double d17 = vector3d3.z - d4;
        if ((d17 * d17) + (d16 * d16) + (d15 * d15) <= d5 * d5) {
            return findClosestPointOnTriangle;
        }
        return 0;
    }

    public static int intersectSweptSphereTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, Vector4d vector4d) {
        double d20;
        double d21;
        double d22;
        Vector4d vector4d2;
        double d23;
        double d24 = d5;
        double d25 = d9;
        double d26 = d10;
        double d27 = d11;
        double d28 = d12;
        double d29 = d28 - d25;
        double d30 = d13 - d26;
        double d31 = d14 - d27;
        double d32 = d15 - d25;
        double d33 = d16 - d26;
        double d34 = d17 - d27;
        double d35 = (d30 * d34) - (d33 * d31);
        double d36 = (d31 * d32) - (d34 * d29);
        double d37 = (d29 * d33) - (d32 * d30);
        double d38 = -((d37 * d27) + (d36 * d26) + (d35 * d25));
        double d39 = d37;
        double d40 = d37;
        double e2 = a.e(d39, d40, (d36 * d36) + (d35 * d35), 1.0d);
        double d41 = ((d37 * d4) + (d36 * d3) + (d35 * d2) + d38) * e2;
        double d42 = d28;
        double k = a.k(d37, d8, (d36 * d7) + (d35 * d6), e2);
        double d43 = d18;
        int i2 = 0;
        if (k < d43 && k > (-d43)) {
            return 0;
        }
        double d44 = d5;
        double d45 = d16;
        double d46 = (d44 - d41) / k;
        if (d46 > d19) {
            return 0;
        }
        double d47 = ((-d44) - d41) / k;
        double d48 = (d2 - ((d44 * d35) * e2)) + (d6 * d46);
        double d49 = d48;
        double d50 = d48;
        double d51 = (d7 * d46) + (d3 - ((d44 * d36) * e2));
        double d52 = d49;
        double d53 = d46;
        double d54 = d51;
        double d55 = d51;
        double d56 = (d8 * d53) + (d4 - ((d44 * d37) * e2));
        double d57 = d53;
        if (testPointInTriangle(d52, d54, d56, d9, d10, d11, d12, d13, d14, d15, d16, d17)) {
            Vector4d vector4d3 = vector4d;
            vector4d3.x = d50;
            vector4d3.y = d55;
            vector4d3.z = d56;
            vector4d3.w = d57;
            return 2;
        }
        Vector4d vector4d4 = vector4d;
        double d58 = (d8 * d8) + (d7 * d7) + (d6 * d6);
        double d59 = d5 * d5;
        double d60 = d2 - d9;
        double d61 = d3 - d10;
        double d62 = d4 - d11;
        double d63 = d61;
        double d64 = d62;
        double d65 = (d64 * d64) + (d63 * d63) + (d60 * d60);
        double d66 = d58;
        double d67 = d64;
        double computeLowestRoot = computeLowestRoot(d66, a.k(d8, d62, (d7 * d61) + (d6 * d60), 2.0d), d65 - d59, d19);
        if (computeLowestRoot < d19) {
            double d68 = d63;
            vector4d4.x = d9;
            vector4d4.y = d10;
            vector4d4.z = d11;
            vector4d4.w = computeLowestRoot;
            i2 = 1;
            d21 = computeLowestRoot;
            d20 = d68;
            d22 = d12;
        } else {
            double d69 = d10;
            double d70 = d11;
            double d71 = d63;
            double d72 = d9;
            d22 = d12;
            d21 = d19;
            d20 = d71;
        }
        double d73 = d2 - d22;
        double d74 = d60;
        double d75 = d3 - d13;
        double d76 = d14;
        double d77 = d58;
        double d78 = d4 - d76;
        double d79 = (d78 * d78) + (d75 * d75) + (d73 * d73);
        double d80 = d20;
        double d81 = d73;
        double k2 = a.k(d8, d78, (d7 * d75) + (d6 * d73), 2.0d);
        double d82 = d74;
        double d83 = d75;
        double d84 = d76;
        double d85 = d13;
        double d86 = k2;
        double d87 = d78;
        double d88 = d77;
        double computeLowestRoot2 = computeLowestRoot(d77, d86, d79 - d59, d21);
        if (computeLowestRoot2 < d21) {
            d23 = d12;
            vector4d2 = vector4d;
            vector4d2.x = d23;
            vector4d2.y = d85;
            vector4d2.z = d84;
            vector4d2.w = computeLowestRoot2;
            i2 = 2;
            d21 = computeLowestRoot2;
        } else {
            d23 = d12;
            vector4d2 = vector4d;
        }
        double d89 = d15;
        double d90 = d2 - d89;
        double d91 = d16;
        double d92 = d3 - d91;
        double d93 = d17;
        double d94 = d4 - d93;
        double d95 = d94 * d94;
        double computeLowestRoot3 = computeLowestRoot(d88, a.k(d8, d94, (d7 * d92) + (d6 * d90), 2.0d), (d95 + ((d92 * d92) + (d90 * d90))) - d59, d21);
        if (computeLowestRoot3 < d21) {
            vector4d2.x = d89;
            vector4d2.y = d91;
            vector4d2.z = d93;
            vector4d2.w = computeLowestRoot3;
            i2 = 3;
            d21 = computeLowestRoot3;
        }
        double d96 = (d31 * d31) + (d30 * d30) + (d29 * d29);
        double d97 = (d31 * d8) + (d30 * d7) + (d29 * d6);
        double d98 = -d88;
        double d99 = (d97 * d97) + (d96 * d98);
        double d100 = -d74;
        double d101 = -d80;
        double d102 = -d67;
        double d103 = d31 * d102;
        double d104 = d103 + (d30 * d101) + (d29 * d100);
        double d105 = (d8 * d102) + (d7 * d101) + (d6 * d100);
        double d106 = d59 - d65;
        double computeLowestRoot4 = computeLowestRoot(d99, ((d96 * 2.0d) * d105) - ((d97 * 2.0d) * d104), (d104 * d104) + (d96 * d106), d21);
        double d107 = ((d97 * computeLowestRoot4) - d104) / d96;
        if (d107 >= 0.0d && d107 <= 1.0d && computeLowestRoot4 < d21) {
            vector4d2.x = (d29 * d107) + d9;
            vector4d2.y = (d30 * d107) + d10;
            vector4d2.z = (d107 * d31) + d11;
            vector4d2.w = computeLowestRoot4;
            i2 = 4;
            d21 = computeLowestRoot4;
        }
        double d108 = (d34 * d34) + (d33 * d33) + (d32 * d32);
        double d109 = (d34 * d8) + (d33 * d7) + (d32 * d6);
        double d110 = d102 * d34;
        double d111 = d110 + (d101 * d33) + (d100 * d32);
        double d112 = ((d108 * 2.0d) * d105) - ((d109 * 2.0d) * d111);
        double computeLowestRoot5 = computeLowestRoot((d109 * d109) + (d108 * d98), d112, (d111 * d111) + (d106 * d108), d21);
        double d113 = ((d109 * computeLowestRoot5) - d111) / d108;
        if (d113 >= 0.0d && d113 <= 1.0d && computeLowestRoot5 < d47) {
            vector4d2.x = (d32 * d113) + d9;
            vector4d2.y = (d33 * d113) + d10;
            vector4d2.z = (d113 * d34) + d11;
            vector4d2.w = computeLowestRoot5;
            i2 = 6;
            d21 = computeLowestRoot5;
        }
        double d114 = d15 - d23;
        double d115 = d16 - d13;
        double d116 = d17 - d14;
        double d117 = (d116 * d116) + (d115 * d115) + (d114 * d114);
        double d118 = (d116 * d8) + (d115 * d7) + (d114 * d6);
        double d119 = -d81;
        double d120 = d114 * d119;
        double d121 = d114;
        double d122 = -d83;
        double d123 = (d115 * d122) + d120;
        double d124 = d115;
        double d125 = -d87;
        double d126 = (d116 * d125) + d123;
        double d127 = d125 * d8;
        double computeLowestRoot6 = computeLowestRoot((d98 * d117) + (d118 * d118), ((d117 * 2.0d) * (d127 + ((d122 * d7) + (d119 * d6)))) - ((2.0d * d118) * d126), (d126 * d126) + ((d59 - d79) * d117), d21);
        double d128 = ((d118 * computeLowestRoot6) - d126) / d117;
        if (d128 >= 0.0d && d128 <= 1.0d && computeLowestRoot6 < d21) {
            vector4d2.x = (d121 * d128) + d12;
            vector4d2.y = (d128 * d124) + d13;
            vector4d2.z = (d128 * d116) + d14;
            vector4d2.w = computeLowestRoot6;
            i2 = 5;
        }
        return i2;
    }

    public static boolean separatingAxis(Vector2d[] vector2dArr, Vector2d[] vector2dArr2, double d2, double d3) {
        Vector2d[] vector2dArr3 = vector2dArr;
        Vector2d[] vector2dArr4 = vector2dArr2;
        int max = Math.max(vector2dArr3.length, vector2dArr4.length);
        double d4 = Double.NEGATIVE_INFINITY;
        double d5 = Double.POSITIVE_INFINITY;
        double d6 = Double.POSITIVE_INFINITY;
        int i2 = 0;
        double d7 = Double.NEGATIVE_INFINITY;
        while (i2 < max) {
            if (i2 < vector2dArr3.length) {
                Vector2d vector2d = vector2dArr3[i2];
                double d8 = d4;
                double d9 = (vector2d.y * d3) + (vector2d.x * d2);
                if (d9 < d5) {
                    d5 = d9;
                }
                d4 = d9 > d8 ? d9 : d8;
            } else {
                double d10 = d4;
            }
            if (i2 < vector2dArr4.length) {
                Vector2d vector2d2 = vector2dArr4[i2];
                double d11 = (vector2d2.y * d3) + (vector2d2.x * d2);
                if (d11 < d6) {
                    d6 = d11;
                }
                if (d11 > d7) {
                    d7 = d11;
                }
            }
            if (d5 <= d7 && d6 <= d4) {
                return false;
            }
            i2++;
            vector2dArr3 = vector2dArr;
            vector2dArr4 = vector2dArr2;
        }
        return true;
    }

    public static boolean testAabAab(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        return d5 >= d8 && d6 >= d9 && d7 >= d10 && d2 <= d11 && d3 <= d12 && d4 <= d13;
    }

    public static boolean testAabAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4) {
        return testAabAab(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z());
    }

    public static boolean testAabPlane(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        if (d8 > 0.0d) {
            d13 = d2;
            d12 = d5;
        } else {
            d12 = d2;
            d13 = d5;
        }
        if (d9 > 0.0d) {
            d15 = d3;
            d14 = d6;
        } else {
            d14 = d3;
            d15 = d6;
        }
        if (d10 > 0.0d) {
            d17 = d4;
            d16 = d7;
        } else {
            d16 = d4;
            d17 = d7;
        }
        return (d10 * d17) + ((d15 * d9) + ((d13 * d8) + d11)) <= 0.0d && (d10 * d16) + ((d9 * d14) + ((d12 * d8) + d11)) >= 0.0d;
    }

    public static boolean testAabPlane(AABBd aABBd, Planed planed) {
        AABBd aABBd2 = aABBd;
        Planed planed2 = planed;
        return testAabPlane(aABBd2.minX, aABBd2.minY, aABBd2.minZ, aABBd2.maxX, aABBd2.maxY, aABBd2.maxZ, planed2.f1225a, planed2.f1226b, planed2.f1227c, planed2.f1228d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean testAabSphere(double r4, double r6, double r8, double r10, double r12, double r14, double r16, double r18, double r20, double r22) {
        /*
            int r0 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x000a
            double r0 = r16 - r4
        L_0x0006:
            double r0 = r0 * r0
            double r0 = r22 - r0
            goto L_0x0013
        L_0x000a:
            int r0 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0011
            double r0 = r16 - r10
            goto L_0x0006
        L_0x0011:
            r0 = r22
        L_0x0013:
            int r2 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x001c
            double r2 = r18 - r6
        L_0x0019:
            double r2 = r2 * r2
            double r0 = r0 - r2
            goto L_0x0023
        L_0x001c:
            int r2 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r2 <= 0) goto L_0x0023
            double r2 = r18 - r12
            goto L_0x0019
        L_0x0023:
            int r2 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x002c
            double r2 = r20 - r8
        L_0x0029:
            double r2 = r2 * r2
            double r0 = r0 - r2
            goto L_0x0033
        L_0x002c:
            int r2 = (r20 > r14 ? 1 : (r20 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x0033
            double r2 = r20 - r14
            goto L_0x0029
        L_0x0033:
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x003b
            r0 = 1
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.Intersectiond.testAabSphere(double, double, double, double, double, double, double, double, double, double):boolean");
    }

    public static boolean testAabSphere(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, double d2) {
        return testAabSphere(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), d2);
    }

    public static boolean testAarAar(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return d4 >= d6 && d5 >= d7 && d2 <= d8 && d3 <= d9;
    }

    public static boolean testAarAar(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4) {
        return testAarAar(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean testAarCircle(double r1, double r3, double r5, double r7, double r9, double r11, double r13) {
        /*
            int r0 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0008
            double r9 = r9 - r1
        L_0x0005:
            double r9 = r9 * r9
            double r13 = r13 - r9
            goto L_0x000e
        L_0x0008:
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x000e
            double r9 = r9 - r5
            goto L_0x0005
        L_0x000e:
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0016
            double r11 = r11 - r3
        L_0x0013:
            double r11 = r11 * r11
            double r13 = r13 - r11
            goto L_0x001c
        L_0x0016:
            int r1 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x001c
            double r11 = r11 - r7
            goto L_0x0013
        L_0x001c:
            r1 = 0
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insbase.joml.Intersectiond.testAarCircle(double, double, double, double, double, double, double):boolean");
    }

    public static boolean testAarCircle(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, double d2) {
        return testAarCircle(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), d2);
    }

    public static boolean testAarLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9;
        double d10;
        double d11;
        double d12;
        if (d6 > 0.0d) {
            d10 = d2;
            d9 = d4;
        } else {
            d9 = d2;
            d10 = d4;
        }
        if (d7 > 0.0d) {
            d12 = d3;
            d11 = d5;
        } else {
            d11 = d3;
            d12 = d5;
        }
        return (d12 * d7) + ((d10 * d6) + d8) <= 0.0d && (d7 * d11) + ((d6 * d9) + d8) >= 0.0d;
    }

    public static boolean testAarLine(Vector2dc vector2dc, Vector2dc vector2dc2, double d2, double d3, double d4) {
        return testAarLine(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), d2, d3, d4);
    }

    public static boolean testCircleCircle(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d2 - d5;
        double d9 = d3 - d6;
        double d10 = d4 + d7;
        return (d9 * d9) + (d8 * d8) <= d10 * d10;
    }

    public static boolean testCircleCircle(Vector2dc vector2dc, double d2, Vector2dc vector2dc2, double d3) {
        return testCircleCircle(vector2dc.x(), vector2dc.y(), d2, vector2dc2.x(), vector2dc2.y(), d3);
    }

    public static boolean testCircleTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d2 - d5;
        double d12 = d3 - d6;
        double d13 = ((d12 * d12) + (d11 * d11)) - d4;
        if (d13 <= 0.0d) {
            return true;
        }
        double d14 = d2 - d7;
        double d15 = d3 - d8;
        double d16 = ((d15 * d15) + (d14 * d14)) - d4;
        if (d16 <= 0.0d) {
            return true;
        }
        double d17 = d2 - d9;
        double d18 = d3 - d10;
        double d19 = ((d18 * d18) + (d17 * d17)) - d4;
        if (d19 <= 0.0d) {
            return true;
        }
        double d20 = d7 - d5;
        double d21 = d8 - d6;
        double d22 = d9 - d7;
        double d23 = d10 - d8;
        double d24 = d5 - d9;
        double d25 = d6 - d10;
        if ((d20 * d12) - (d21 * d11) >= 0.0d && (d22 * d15) - (d23 * d14) >= 0.0d && (d24 * d18) - (d25 * d17) >= 0.0d) {
            return true;
        }
        double d26 = (d12 * d21) + (d11 * d20);
        if (d26 >= 0.0d) {
            double d27 = (d21 * d21) + (d20 * d20);
            if (d26 <= d27 && d13 * d27 <= d26 * d26) {
                return true;
            }
        }
        double d28 = (d15 * d23) + (d14 * d22);
        if (d28 > 0.0d) {
            double d29 = (d23 * d23) + (d22 * d22);
            if (d28 <= d29 && d16 * d29 <= d28 * d28) {
                return true;
            }
        }
        double d30 = (d18 * d25) + (d17 * d24);
        if (d30 >= 0.0d) {
            double d31 = (d25 * d25) + (d24 * d24);
            if (d30 < d31 && d19 * d31 <= d30 * d30) {
                return true;
            }
        }
        return false;
    }

    public static boolean testCircleTriangle(Vector2dc vector2dc, double d2, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4) {
        return testCircleTriangle(vector2dc.x(), vector2dc.y(), d2, vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y());
    }

    public static boolean testLineCircle(double d2, double d3, double d4, double d5, double d6, double d7) {
        double sqrt = (((d3 * d6) + (d2 * d5)) + d4) / Math.sqrt((d3 * d3) + (d2 * d2));
        return (-d7) <= sqrt && sqrt <= d7;
    }

    public static boolean testLineSegmentSphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12;
        double d13;
        double d14;
        double d15 = d5 - d2;
        double d16 = d6 - d3;
        double d17 = d7 - d4;
        double l = a.l(d17, d17, (d16 * d16) + (d15 * d15), a.h(d10, d4, d17, a.h(d9, d3, d16, (d8 - d2) * d15)));
        if (l < 0.0d) {
            d14 = d2 - d8;
            d13 = d3 - d9;
            d12 = d4 - d10;
        } else if (l > 1.0d) {
            d14 = d5 - d8;
            d13 = d6 - d9;
            d12 = d7 - d10;
        } else {
            d13 = ((d16 * l) + d3) - d9;
            d12 = ((l * d17) + d4) - d10;
            d14 = ((d15 * l) + d2) - d8;
        }
        return (d12 * d12) + ((d13 * d13) + (d14 * d14)) <= d11;
    }

    public static boolean testLineSegmentSphere(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, double d2) {
        return testLineSegmentSphere(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), d2);
    }

    public static boolean testLineSegmentTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double intersectRayTriangle = intersectRayTriangle(d2, d3, d4, d5 - d2, d6 - d3, d7 - d4, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17);
        return intersectRayTriangle >= 0.0d && intersectRayTriangle <= 1.0d;
    }

    public static boolean testMovingCircleCircle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d6 + d9;
        double d11 = d2 - d7;
        double d12 = d3 - d8;
        double sqrt = Math.sqrt((d12 * d12) + (d11 * d11)) - d10;
        double sqrt2 = Math.sqrt((d5 * d5) + (d4 * d4));
        if (sqrt2 < sqrt) {
            return false;
        }
        double d13 = 1.0d / sqrt2;
        double d14 = d4 * d13;
        double d15 = d7 - d2;
        double d16 = d8 - d3;
        double d17 = (d13 * d5 * d16) + (d14 * d15);
        if (d17 <= 0.0d) {
            return false;
        }
        double sqrt3 = Math.sqrt((d16 * d16) + (d15 * d15));
        double d18 = (sqrt3 * sqrt3) - (d17 * d17);
        double d19 = d10 * d10;
        if (d18 >= d19) {
            return false;
        }
        double d20 = d19 - d18;
        if (d20 >= 0.0d && sqrt2 >= d17 - Math.sqrt(d20)) {
            return true;
        }
        return false;
    }

    public static boolean testObOb(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, Vector3d vector3d4, Vector3d vector3d5, Vector3d vector3d6, Vector3d vector3d7, Vector3d vector3d8, Vector3d vector3d9, Vector3d vector3d10) {
        Vector3d vector3d11 = vector3d;
        Vector3d vector3d12 = vector3d2;
        Vector3d vector3d13 = vector3d3;
        Vector3d vector3d14 = vector3d4;
        Vector3d vector3d15 = vector3d5;
        Vector3d vector3d16 = vector3d6;
        Vector3d vector3d17 = vector3d7;
        Vector3d vector3d18 = vector3d8;
        Vector3d vector3d19 = vector3d9;
        Vector3d vector3d20 = vector3d10;
        return testObOb(vector3d11.x, vector3d11.y, vector3d11.z, vector3d12.x, vector3d12.y, vector3d12.z, vector3d13.x, vector3d13.y, vector3d13.z, vector3d14.x, vector3d14.y, vector3d14.z, vector3d15.x, vector3d15.y, vector3d15.z, vector3d16.x, vector3d16.y, vector3d16.z, vector3d17.x, vector3d17.y, vector3d17.z, vector3d18.x, vector3d18.y, vector3d18.z, vector3d19.x, vector3d19.y, vector3d19.z, vector3d20.x, vector3d20.y, vector3d20.z);
    }

    public static boolean testPlaneSphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d9;
        double sqrt = (((d4 * d8) + ((d3 * d7) + (d2 * d6))) + d5) / Math.sqrt((d4 * d4) + ((d3 * d3) + (d2 * d2)));
        return (-d10) <= sqrt && sqrt <= d10;
    }

    public static boolean testPlaneSweptSphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        double d13 = ((d8 * d4) + ((d7 * d3) + (d6 * d2))) - d5;
        double d14 = ((d12 * d4) + ((d11 * d3) + (d10 * d2))) - d5;
        return d13 * d14 < 0.0d || Math.abs(d13) <= d9 || Math.abs(d14) <= d9;
    }

    public static boolean testPointAar(double d2, double d3, double d4, double d5, double d6, double d7) {
        return d2 >= d4 && d3 >= d5 && d2 <= d6 && d3 <= d7;
    }

    public static boolean testPointCircle(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 - d4;
        double d8 = d3 - d5;
        return (d8 * d8) + (d7 * d7) <= d6;
    }

    public static boolean testPointInTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        double d14 = d8 - d5;
        double d15 = d9 - d6;
        double d16 = d10 - d7;
        double d17 = d11 - d5;
        double d18 = d12 - d6;
        double d19 = d13 - d7;
        double d20 = (d16 * d16) + (d15 * d15) + (d14 * d14);
        double d21 = (d16 * d19) + (d15 * d18) + (d14 * d17);
        double d22 = (d19 * d19) + (d18 * d18) + (d17 * d17);
        double d23 = (d20 * d22) - (d21 * d21);
        double d24 = d2 - d5;
        double d25 = d3 - d6;
        double d26 = d4 - d7;
        double d27 = (d16 * d26) + (d15 * d25) + (d14 * d24);
        double d28 = (d26 * d19) + (d25 * d18) + (d24 * d17);
        double d29 = (d22 * d27) - (d28 * d21);
        double d30 = (d28 * d20) - (d27 * d21);
        return ((Runtime.doubleToLongBits((d29 + d30) - d23) & (~(Runtime.doubleToLongBits(d29) | Runtime.doubleToLongBits(d30)))) & Long.MIN_VALUE) != 0;
    }

    public static boolean testPointTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        boolean z = true;
        boolean z2 = ((d5 - d7) * (d2 - d6)) - ((d3 - d7) * (d4 - d6)) < 0.0d;
        boolean z3 = ((d7 - d9) * (d2 - d8)) - ((d3 - d9) * (d6 - d8)) < 0.0d;
        if (z2 != z3) {
            return false;
        }
        if (z3 != (((d9 - d5) * (d2 - d4)) - ((d3 - d5) * (d8 - d4)) < 0.0d)) {
            z = false;
        }
        return z;
    }

    public static boolean testPointTriangle(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4) {
        return testPointTriangle(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y());
    }

    public static boolean testPolygonPolygon(Vector2d[] vector2dArr, Vector2d[] vector2dArr2) {
        int length = vector2dArr.length - 1;
        int i2 = 0;
        while (i2 < vector2dArr.length) {
            Vector2d vector2d = vector2dArr[i2];
            Vector2d vector2d2 = vector2dArr[length];
            if (separatingAxis(vector2dArr, vector2dArr2, vector2d.y - vector2d2.y, vector2d2.x - vector2d.x)) {
                return false;
            }
            int i3 = i2;
            i2++;
            length = i3;
        }
        int length2 = vector2dArr2.length - 1;
        int i4 = 0;
        while (i4 < vector2dArr2.length) {
            Vector2d vector2d3 = vector2dArr2[i4];
            Vector2d vector2d4 = vector2dArr2[length2];
            if (separatingAxis(vector2dArr, vector2dArr2, vector2d3.y - vector2d4.y, vector2d4.x - vector2d3.x)) {
                return false;
            }
            int i5 = i4;
            i4++;
            length2 = i5;
        }
        return true;
    }

    public static boolean testRayAab(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        double d20 = 1.0d / d5;
        double d21 = 1.0d / d6;
        double d22 = 1.0d / d7;
        if (d20 >= 0.0d) {
            d15 = (d8 - d2) * d20;
            d14 = d11 - d2;
        } else {
            d15 = (d11 - d2) * d20;
            d14 = d8 - d2;
        }
        double d23 = d14 * d20;
        if (d21 >= 0.0d) {
            d17 = (d9 - d3) * d21;
            d16 = d12 - d3;
        } else {
            d17 = (d12 - d3) * d21;
            d16 = d9 - d3;
        }
        double d24 = d16 * d21;
        if (d15 > d24 || d17 > d23) {
            return false;
        }
        if (d22 >= 0.0d) {
            d19 = (d10 - d4) * d22;
            d18 = d13 - d4;
        } else {
            d19 = (d13 - d4) * d22;
            d18 = d10 - d4;
        }
        double d25 = d18 * d22;
        if (d15 > d25 || d19 > d23) {
            return false;
        }
        if (d17 > d15 || Double.isNaN(d15)) {
            d15 = d17;
        }
        if (d24 < d23 || Double.isNaN(d23)) {
            d23 = d24;
        }
        if (d19 <= d15) {
            d19 = d15;
        }
        if (d25 >= d23) {
            d25 = d23;
        }
        if (d19 >= d25 || d25 < 0.0d) {
            return false;
        }
        return true;
    }

    public static boolean testRayAar(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10;
        double d11;
        double d12;
        double d13;
        double d14 = 1.0d / d4;
        double d15 = 1.0d / d5;
        if (d14 >= 0.0d) {
            d11 = (d6 - d2) * d14;
            d10 = d8 - d2;
        } else {
            d11 = (d8 - d2) * d14;
            d10 = d6 - d2;
        }
        double d16 = d10 * d14;
        if (d15 >= 0.0d) {
            d13 = (d7 - d3) * d15;
            d12 = d9 - d3;
        } else {
            d13 = (d9 - d3) * d15;
            d12 = d7 - d3;
        }
        double d17 = d12 * d15;
        if (d11 > d17 || d13 > d16) {
            return false;
        }
        if (d13 > d11 || Double.isNaN(d11)) {
            d11 = d13;
        }
        if (d17 < d16 || Double.isNaN(d16)) {
            d16 = d17;
        }
        if (d11 >= d16 || d16 < 0.0d) {
            return false;
        }
        return true;
    }

    public static boolean testRayCircle(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d6 - d2;
        double d10 = d7 - d3;
        double d11 = (d5 * d10) + (d4 * d9);
        double d12 = ((d10 * d10) + (d9 * d9)) - (d11 * d11);
        boolean z = false;
        if (d12 > d8) {
            return false;
        }
        double sqrt = Math.sqrt(d8 - d12);
        double d13 = d11 - sqrt;
        double d14 = d11 + sqrt;
        if (d13 < d14 && d14 >= 0.0d) {
            z = true;
        }
        return z;
    }

    public static boolean testRaySphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        double d12 = d8 - d2;
        double d13 = d9 - d3;
        double d14 = d10 - d4;
        double d15 = (d14 * d7) + (d13 * d6) + (d12 * d5);
        double d16 = d14 * d14;
        double d17 = (d16 + ((d13 * d13) + (d12 * d12))) - (d15 * d15);
        boolean z = false;
        if (d17 > d11) {
            return false;
        }
        double sqrt = Math.sqrt(d11 - d17);
        double d18 = d15 - sqrt;
        double d19 = d15 + sqrt;
        if (d18 < d19 && d19 >= 0.0d) {
            z = true;
        }
        return z;
    }

    public static boolean testRayTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d17;
        double d19 = d11 - d8;
        double d20 = d12 - d9;
        double d21 = d13 - d10;
        double d22 = d14 - d8;
        double d23 = d15 - d9;
        double d24 = d16 - d10;
        double d25 = (d6 * d24) - (d7 * d23);
        double d26 = (d7 * d22) - (d5 * d24);
        double d27 = (d5 * d23) - (d6 * d22);
        double d28 = (d21 * d27) + (d20 * d26) + (d19 * d25);
        double d29 = d24;
        boolean z = false;
        if (d28 > (-d18) && d28 < d18) {
            return false;
        }
        double d30 = d2 - d8;
        double d31 = d3 - d9;
        double d32 = d4 - d10;
        double d33 = 1.0d / d28;
        double k = a.k(d27, d32, (d26 * d31) + (d25 * d30), d33);
        if (k >= 0.0d && k <= 1.0d) {
            double d34 = (d31 * d21) - (d32 * d20);
            double d35 = (d32 * d19) - (d21 * d30);
            double d36 = (d30 * d20) - (d31 * d19);
            double k2 = a.k(d7, d36, (d5 * d34) + (d6 * d35), d33);
            if (k2 >= 0.0d && k + k2 <= 1.0d) {
                if (a.k(d29, d36, (d23 * d35) + (d22 * d34), d33) >= d18) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean testRayTriangle(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector3dc vector3dc5, double d2) {
        return testRayTriangle(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector3dc5.x(), vector3dc5.y(), vector3dc5.z(), d2);
    }

    public static boolean testRayTriangleFront(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d11 - d8;
        double d19 = d12 - d9;
        double d20 = d13 - d10;
        double d21 = d14 - d8;
        double d22 = d15 - d9;
        double d23 = d16 - d10;
        double d24 = (d6 * d23) - (d7 * d22);
        double d25 = (d7 * d21) - (d5 * d23);
        double d26 = (d5 * d22) - (d6 * d21);
        double d27 = (d20 * d26) + (d19 * d25) + (d18 * d24);
        boolean z = false;
        if (d27 < d17) {
            return false;
        }
        double d28 = d2 - d8;
        double d29 = d3 - d9;
        double d30 = d4 - d10;
        double d31 = d26 * d30;
        double d32 = d31 + (d25 * d29) + (d24 * d28);
        if (d32 >= 0.0d && d32 <= d27) {
            double d33 = (d29 * d20) - (d30 * d19);
            double d34 = (d30 * d18) - (d20 * d28);
            double d35 = (d28 * d19) - (d29 * d18);
            double d36 = (d7 * d35) + (d6 * d34) + (d5 * d33);
            if (d36 >= 0.0d && d32 + d36 <= d27) {
                if (a.k(d23, d35, (d22 * d34) + (d21 * d33), 1.0d / d27) >= d17) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static boolean testRayTriangleFront(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector3dc vector3dc5, double d2) {
        return testRayTriangleFront(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector3dc5.x(), vector3dc5.y(), vector3dc5.z(), d2);
    }

    public static boolean testSphereSphere(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d6 - d2;
        double d11 = d7 - d3;
        double d12 = d8 - d4;
        double d13 = (d12 * d12) + (d11 * d11) + (d10 * d10);
        double d14 = ((d5 - d9) / d13) + 0.5d;
        return d5 - ((d14 * d14) * d13) >= 0.0d;
    }

    public static boolean testSphereSphere(Vector3dc vector3dc, double d2, Vector3dc vector3dc2, double d3) {
        return testSphereSphere(vector3dc.x(), vector3dc.y(), vector3dc.z(), d2, vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), d3);
    }

    public static double distancePointLine(double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d6 - d4;
        double d9 = d7 - d5;
        return (((d5 - d3) * d8) - ((d4 - d2) * d9)) / Math.sqrt((d9 * d9) + (d8 * d8));
    }

    public static double distancePointPlane(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13) {
        double d14 = d9 - d6;
        double d15 = d13 - d7;
        double d16 = d12 - d6;
        double d17 = d10 - d7;
        double d18 = d11 - d5;
        double d19 = d8 - d5;
        double d20 = (d14 * d15) - (d16 * d17);
        double d21 = (d17 * d18) - (d15 * d19);
        double d22 = (d19 * d16) - (d18 * d14);
        return distancePointPlane(d2, d3, d4, d20, d21, d22, -((d22 * d7) + (d21 * d6) + (d20 * d5)));
    }

    public static double intersectRayPlane(Rayd rayd, Planed planed, double d2) {
        Rayd rayd2 = rayd;
        Planed planed2 = planed;
        double d3 = d2;
        return intersectRayPlane(rayd2.oX, rayd2.oY, rayd2.oZ, rayd2.dX, rayd2.dY, rayd2.dZ, planed2.f1225a, planed2.f1226b, planed2.f1227c, planed2.f1228d, d3);
    }

    public static boolean testAabAab(AABBd aABBd, AABBd aABBd2) {
        AABBd aABBd3 = aABBd;
        AABBd aABBd4 = aABBd2;
        return testAabAab(aABBd3.minX, aABBd3.minY, aABBd3.minZ, aABBd3.maxX, aABBd3.maxY, aABBd3.maxZ, aABBd4.minX, aABBd4.minY, aABBd4.minZ, aABBd4.maxX, aABBd4.maxY, aABBd4.maxZ);
    }

    public static boolean testAabPlane(Vector3dc vector3dc, Vector3dc vector3dc2, double d2, double d3, double d4, double d5) {
        return testAabPlane(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), d2, d3, d4, d5);
    }

    public static boolean testAabSphere(AABBd aABBd, Spheref spheref) {
        AABBd aABBd2 = aABBd;
        Spheref spheref2 = spheref;
        double d2 = aABBd2.minX;
        double d3 = aABBd2.minY;
        double d4 = aABBd2.minZ;
        double d5 = aABBd2.maxX;
        double d6 = aABBd2.maxY;
        double d7 = aABBd2.maxZ;
        double d8 = (double) spheref2.x;
        double d9 = d2;
        double d10 = (double) spheref2.y;
        double d11 = (double) spheref2.z;
        float f2 = spheref2.r;
        return testAabSphere(d9, d3, d4, d5, d6, d7, d8, d10, d11, (double) (f2 * f2));
    }

    public static boolean testAarLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d7 - d9;
        double d11 = d8 - d6;
        return testAarLine(d2, d3, d4, d5, d10, d11, ((-d11) * d7) - (d10 * d6));
    }

    public static boolean testLineSegmentTriangle(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector3dc vector3dc5, double d2) {
        return testLineSegmentTriangle(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector3dc5.x(), vector3dc5.y(), vector3dc5.z(), d2);
    }

    public static boolean testObOb(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19, double d20, double d21, double d22, double d23, double d24, double d25, double d26, double d27, double d28, double d29, double d30, double d31) {
        double d32 = (d11 * d26) + (d8 * d23) + (d5 * d20);
        double d33 = (d11 * d27) + (d8 * d24) + (d5 * d21);
        double d34 = (d11 * d28) + (d8 * d25) + (d5 * d22);
        double d35 = (d12 * d26) + (d9 * d23) + (d6 * d20);
        double d36 = (d12 * d27) + (d9 * d24) + (d6 * d21);
        double d37 = (d12 * d28) + (d9 * d25) + (d6 * d22);
        double d38 = (d13 * d26) + (d10 * d23) + (d7 * d20);
        double d39 = (d13 * d27) + (d10 * d24) + (d7 * d21);
        double d40 = (d13 * d28) + (d10 * d25) + (d7 * d22);
        double abs = Math.abs(d32) + 1.0E-8d;
        double abs2 = Math.abs(d35) + 1.0E-8d;
        double abs3 = Math.abs(d38) + 1.0E-8d;
        double abs4 = Math.abs(d33) + 1.0E-8d;
        double abs5 = Math.abs(d36) + 1.0E-8d;
        double abs6 = Math.abs(d39) + 1.0E-8d;
        double abs7 = Math.abs(d34) + 1.0E-8d;
        double abs8 = Math.abs(d37) + 1.0E-8d;
        double abs9 = Math.abs(d40) + 1.0E-8d;
        double d41 = d17 - d2;
        double d42 = d18 - d3;
        double d43 = d19 - d4;
        double d44 = (d43 * d7) + (d42 * d6) + (d41 * d5);
        double d45 = (d43 * d10) + (d42 * d9) + (d41 * d8);
        double d46 = d43 * d13;
        double d47 = d46 + (d42 * d12) + (d41 * d11);
        if (Math.abs(d44) > d14 + (d31 * abs3) + (d30 * abs2) + (d29 * abs)) {
            return false;
        }
        if (Math.abs(d45) > d15 + (d31 * abs6) + (d30 * abs5) + (d29 * abs4)) {
            return false;
        }
        if (Math.abs(d47) > d16 + (d31 * abs9) + (d30 * abs8) + (d29 * abs7)) {
            return false;
        }
        if (Math.abs((d47 * d34) + (d45 * d33) + (d44 * d32)) > (d16 * abs7) + (d15 * abs4) + (d14 * abs) + d29) {
            return false;
        }
        if (Math.abs((d47 * d37) + (d45 * d36) + (d44 * d35)) > (d16 * abs8) + (d15 * abs5) + (d14 * abs2) + d30) {
            return false;
        }
        if (Math.abs((d47 * d40) + (d45 * d39) + (d44 * d38)) > (d16 * abs9) + (d15 * abs6) + (d14 * abs3) + d31) {
            return false;
        }
        if (Math.abs((d47 * d33) - (d45 * d34)) > (d16 * abs4) + (d15 * abs7) + (d31 * abs2) + (d30 * abs3)) {
            return false;
        }
        if (Math.abs((d47 * d36) - (d45 * d37)) > (d16 * abs5) + (d15 * abs8) + (d31 * abs) + (d29 * abs3)) {
            return false;
        }
        if (Math.abs((d47 * d39) - (d45 * d40)) > (d16 * abs6) + (d15 * abs9) + (d30 * abs) + (d29 * abs2)) {
            return false;
        }
        if (Math.abs((d34 * d44) - (d47 * d32)) > (d16 * abs) + (d14 * abs7) + (d31 * abs5) + (d30 * abs6)) {
            return false;
        }
        if (Math.abs((d37 * d44) - (d47 * d35)) > (d16 * abs2) + (d14 * abs8) + (d31 * abs4) + (d29 * abs6)) {
            return false;
        }
        if (Math.abs((d40 * d44) - (d47 * d38)) > (d16 * abs3) + (d14 * abs9) + (d30 * abs4) + (d29 * abs5)) {
            return false;
        }
        if (Math.abs((d32 * d45) - (d33 * d44)) > (d15 * abs) + (d14 * abs4) + (d31 * abs8) + (d30 * abs9)) {
            return false;
        }
        if (Math.abs((d35 * d45) - (d36 * d44)) > (d15 * abs2) + (d14 * abs5) + (d31 * abs7) + (d29 * abs9)) {
            return false;
        }
        if (Math.abs((d45 * d38) - (d44 * d39)) > (d15 * abs3) + (d14 * abs6) + (d30 * abs7) + (d29 * abs8)) {
            return false;
        }
        return true;
    }

    public static boolean testPlaneSphere(Planed planed, Spheref spheref) {
        Planed planed2 = planed;
        Spheref spheref2 = spheref;
        return testPlaneSphere(planed2.f1225a, planed2.f1226b, planed2.f1227c, planed2.f1228d, (double) spheref2.x, (double) spheref2.y, (double) spheref2.z, (double) spheref2.r);
    }

    public static boolean testRayCircle(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, double d2) {
        return testRayCircle(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), d2);
    }

    public static boolean testRaySphere(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, double d2) {
        return testRaySphere(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), d2);
    }

    public static double distancePointLine(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        double d11 = d8 - d5;
        double d12 = d9 - d6;
        double d13 = d10 - d7;
        double d14 = d5 - d2;
        double d15 = d6 - d3;
        double d16 = d7 - d4;
        double d17 = (d12 * d16) - (d13 * d15);
        double d18 = (d13 * d14) - (d16 * d11);
        double d19 = (d15 * d11) - (d14 * d12);
        return Math.sqrt(((d19 * d19) + ((d18 * d18) + (d17 * d17))) / ((d13 * d13) + ((d12 * d12) + (d11 * d11))));
    }

    public static boolean testRayAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4) {
        return testRayAab(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z());
    }

    public static boolean testRayAar(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4) {
        return testRayAar(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y());
    }

    public static boolean testRaySphere(Rayd rayd, Spheref spheref) {
        Rayd rayd2 = rayd;
        Spheref spheref2 = spheref;
        double d2 = rayd2.oX;
        double d3 = rayd2.oY;
        double d4 = rayd2.oZ;
        double d5 = rayd2.dX;
        double d6 = rayd2.dY;
        double d7 = rayd2.dZ;
        double d8 = (double) spheref2.x;
        double d9 = d2;
        double d10 = (double) spheref2.y;
        double d11 = (double) spheref2.z;
        float f2 = spheref2.r;
        return testRaySphere(d9, d3, d4, d5, d6, d7, d8, d10, d11, (double) (f2 * f2));
    }

    public static boolean intersectRayCircle(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, double d2, Vector2d vector2d) {
        return intersectRayCircle(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), d2, vector2d);
    }

    public static boolean intersectRaySphere(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, double d2, Vector2d vector2d) {
        return intersectRaySphere(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), d2, vector2d);
    }

    public static boolean testRayAab(Rayd rayd, AABBd aABBd) {
        Rayd rayd2 = rayd;
        AABBd aABBd2 = aABBd;
        return testRayAab(rayd2.oX, rayd2.oY, rayd2.oZ, rayd2.dX, rayd2.dY, rayd2.dZ, aABBd2.minX, aABBd2.minY, aABBd2.minZ, aABBd2.maxX, aABBd2.maxY, aABBd2.maxZ);
    }

    public static boolean intersectCircleCircle(Vector2dc vector2dc, double d2, Vector2dc vector2dc2, double d3, Vector3d vector3d) {
        return intersectCircleCircle(vector2dc.x(), vector2dc.y(), d2, vector2dc2.x(), vector2dc2.y(), d3, vector3d);
    }

    public static boolean intersectLineCircle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, Vector3d vector3d) {
        return intersectLineCircle(d3 - d5, d4 - d2, a.h(d5, d3, d2, (d2 - d4) * d3), d6, d7, d8, vector3d);
    }

    public static int intersectLineSegmentAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector2d vector2d) {
        return intersectLineSegmentAab(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector2d);
    }

    public static int intersectLineSegmentAar(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4, Vector2d vector2d) {
        return intersectLineSegmentAar(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y(), vector2d);
    }

    public static boolean intersectLineSegmentTriangle(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector3dc vector3dc5, double d2, Vector3d vector3d) {
        return intersectLineSegmentTriangle(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector3dc5.x(), vector3dc5.y(), vector3dc5.z(), d2, vector3d);
    }

    public static boolean intersectRayAab(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector2d vector2d) {
        return intersectRayAab(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector2d);
    }

    public static boolean intersectRaySphere(Rayd rayd, Spheref spheref, Vector2d vector2d) {
        Rayd rayd2 = rayd;
        Spheref spheref2 = spheref;
        Vector2d vector2d2 = vector2d;
        double d2 = rayd2.oX;
        double d3 = rayd2.oY;
        double d4 = rayd2.oZ;
        double d5 = rayd2.dX;
        double d6 = rayd2.dY;
        double d7 = rayd2.dZ;
        double d8 = (double) spheref2.x;
        double d9 = d2;
        double d10 = (double) spheref2.y;
        double d11 = (double) spheref2.z;
        float f2 = spheref2.r;
        return intersectRaySphere(d9, d3, d4, d5, d6, d7, d8, d10, d11, (double) (f2 * f2), vector2d2);
    }

    public static boolean intersectSphereSphere(Vector3dc vector3dc, double d2, Vector3dc vector3dc2, double d3, Vector4d vector4d) {
        return intersectSphereSphere(vector3dc.x(), vector3dc.y(), vector3dc.z(), d2, vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), d3, vector4d);
    }

    public static boolean testMovingCircleCircle(Vector2d vector2d, Vector2d vector2d2, double d2, Vector2d vector2d3, double d3) {
        Vector2d vector2d4 = vector2d;
        Vector2d vector2d5 = vector2d2;
        Vector2d vector2d6 = vector2d3;
        return testMovingCircleCircle(vector2d4.x, vector2d4.y, vector2d5.x, vector2d5.y, d2, vector2d6.x, vector2d6.y, d3);
    }

    public static int intersectLineSegmentAab(LineSegmentf lineSegmentf, AABBd aABBd, Vector2d vector2d) {
        LineSegmentf lineSegmentf2 = lineSegmentf;
        AABBd aABBd2 = aABBd;
        return intersectLineSegmentAab((double) lineSegmentf2.aX, (double) lineSegmentf2.aY, (double) lineSegmentf2.aZ, (double) lineSegmentf2.bX, (double) lineSegmentf2.bY, (double) lineSegmentf2.bZ, aABBd2.minX, aABBd2.minY, aABBd2.minZ, aABBd2.maxX, aABBd2.maxY, aABBd2.maxZ, vector2d);
    }

    public static boolean intersectRayAab(Rayd rayd, AABBd aABBd, Vector2d vector2d) {
        Rayd rayd2 = rayd;
        AABBd aABBd2 = aABBd;
        Vector2d vector2d2 = vector2d;
        return intersectRayAab(rayd2.oX, rayd2.oY, rayd2.oZ, rayd2.dX, rayd2.dY, rayd2.dZ, aABBd2.minX, aABBd2.minY, aABBd2.minZ, aABBd2.maxX, aABBd2.maxY, aABBd2.maxZ, vector2d2);
    }

    public static boolean intersectSphereSphere(Spheref spheref, Spheref spheref2, Vector4d vector4d) {
        Spheref spheref3 = spheref;
        Spheref spheref4 = spheref2;
        Vector4d vector4d2 = vector4d;
        double d2 = (double) spheref3.x;
        double d3 = (double) spheref3.y;
        double d4 = (double) spheref3.z;
        float f2 = spheref3.r;
        double d5 = (double) (f2 * f2);
        double d6 = (double) spheref4.x;
        double d7 = (double) spheref4.y;
        double d8 = (double) spheref4.z;
        float f3 = spheref4.r;
        return intersectSphereSphere(d2, d3, d4, d5, d6, d7, d8, (double) (f3 * f3), vector4d2);
    }

    public static int intersectPolygonRay(Vector2dc[] vector2dcArr, double d2, double d3, double d4, double d5, Vector2d vector2d) {
        Vector2dc[] vector2dcArr2 = vector2dcArr;
        Vector2d vector2d2 = vector2d;
        int length = vector2dcArr2.length;
        int i2 = length - 1;
        double x = vector2dcArr2[i2].x();
        double y = vector2dcArr2[i2].y();
        int i3 = -1;
        double d6 = Double.POSITIVE_INFINITY;
        int i4 = 0;
        while (i4 < length) {
            Vector2dc vector2dc = vector2dcArr2[i4];
            double x2 = vector2dc.x();
            double y2 = vector2dc.y();
            double d7 = d2 - x;
            double d8 = d3 - y;
            double d9 = x2 - x;
            double d10 = y2 - y;
            double d11 = 1.0d / ((d10 * d4) - (d9 * d5));
            double c2 = a.c(d10, d7, d9 * d8, d11);
            if (c2 >= 0.0d && c2 < d6) {
                double c3 = a.c(d7, d5, d8 * d4, d11);
                if (c3 >= 0.0d && c3 <= 1.0d) {
                    int i5 = ((i4 - 1) + length) % length;
                    vector2d2.x = (c2 * d4) + d2;
                    vector2d2.y = (c2 * d5) + d3;
                    i3 = i5;
                    d6 = c2;
                }
            }
            i4++;
            x = x2;
            y = y2;
        }
        return i3;
    }

    public static int intersectRayAar(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4, Vector2d vector2d) {
        return intersectRayAar(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y(), vector2d);
    }

    public static int findClosestPointOnTriangle(Vector3dc vector3dc, Vector3dc vector3dc2, Vector3dc vector3dc3, Vector3dc vector3dc4, Vector3d vector3d) {
        return findClosestPointOnTriangle(vector3dc.x(), vector3dc.y(), vector3dc.z(), vector3dc2.x(), vector3dc2.y(), vector3dc2.z(), vector3dc3.x(), vector3dc3.y(), vector3dc3.z(), vector3dc4.x(), vector3dc4.y(), vector3dc4.z(), vector3d);
    }

    public static int findClosestPointOnTriangle(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, Vector2d vector2d) {
        double d10 = d2;
        double d11 = d3;
        double d12 = d4;
        double d13 = d5;
        double d14 = d6;
        double d15 = d7;
        Vector2d vector2d2 = vector2d;
        double d16 = d12 - d10;
        double d17 = d13 - d11;
        double d18 = d14 - d10;
        double d19 = d15 - d11;
        double d20 = d8 - d10;
        double d21 = d9 - d11;
        double d22 = (d17 * d21) + (d16 * d20);
        double d23 = (d21 * d19) + (d20 * d18);
        if (d22 > 0.0d || d23 > 0.0d) {
            double d24 = d8 - d12;
            double d25 = d9 - d13;
            double d26 = (d17 * d25) + (d16 * d24);
            double d27 = (d25 * d19) + (d24 * d18);
            if (d26 < 0.0d || d27 > d26) {
                double d28 = (d22 * d27) - (d26 * d23);
                if (d28 > 0.0d || d22 < 0.0d || d26 > 0.0d) {
                    double d29 = d8 - d14;
                    double d30 = d9 - d15;
                    double d31 = (d17 * d30) + (d16 * d29);
                    double d32 = (d30 * d19) + (d29 * d18);
                    if (d32 < 0.0d || d31 > d32) {
                        double d33 = (d31 * d23) - (d22 * d32);
                        if (d33 > 0.0d || d23 < 0.0d || d32 > 0.0d) {
                            double d34 = (d26 * d32) - (d31 * d27);
                            if (d34 <= 0.0d) {
                                double d35 = d27 - d26;
                                if (d35 >= 0.0d && d31 - d32 >= 0.0d) {
                                    double d36 = d35 / ((d35 + d31) - d32);
                                    vector2d2.x = a.h(d6, d4, d36, d4);
                                    vector2d2.y = a.h(d7, d5, d36, d5);
                                    return 5;
                                }
                            }
                            double d37 = 1.0d / ((d34 + d33) + d28);
                            double d38 = d33 * d37;
                            double d39 = d28 * d37;
                            vector2d2.x = (d18 * d39) + (d16 * d38) + d10;
                            vector2d2.y = (d19 * d39) + (d17 * d38) + d11;
                            return 2;
                        }
                        double d40 = d23 / (d23 - d32);
                        vector2d2.x = (d18 * d40) + d10;
                        vector2d2.y = (d40 * d19) + d11;
                        return 6;
                    }
                    vector2d2.x = d14;
                    vector2d2.y = d15;
                    return 3;
                }
                double d41 = d22 / (d22 - d26);
                vector2d2.x = (d16 * d41) + d10;
                vector2d2.y = (d41 * d17) + d11;
                return 4;
            }
            vector2d2.x = d12;
            vector2d2.y = d13;
            return 2;
        }
        vector2d2.x = d10;
        vector2d2.y = d11;
        return 1;
    }

    public static int findClosestPointOnTriangle(Vector2dc vector2dc, Vector2dc vector2dc2, Vector2dc vector2dc3, Vector2dc vector2dc4, Vector2d vector2d) {
        return findClosestPointOnTriangle(vector2dc.x(), vector2dc.y(), vector2dc2.x(), vector2dc2.y(), vector2dc3.x(), vector2dc3.y(), vector2dc4.x(), vector2dc4.y(), vector2d);
    }
}
