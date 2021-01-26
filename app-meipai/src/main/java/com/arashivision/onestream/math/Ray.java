package com.arashivision.onestream.math;

import android.util.Log;
import com.arashivision.onestream.math.vector.Vector3;
import e.a.a.a.a;

public class Ray {
    public Vector3 mDirection;
    public Vector3 mOrigin;

    public Ray(Vector3 vector3, Vector3 vector32) {
        this.mOrigin = vector3;
        this.mDirection = vector32;
    }

    public static double[] Intersects(Ray ray, Vector3 vector3, double d2) {
        Vector3 vector32 = new Vector3();
        vector32.subtractAndSet(vector3, ray.getOrigin());
        double dot = ray.getDirection().dot(vector32);
        double length2 = (d2 * d2) - (vector32.length2() - (dot * dot));
        if (length2 < 0.0d) {
            return null;
        }
        if (length2 < 1.0E-6d) {
            return new double[]{dot};
        }
        double sqrt = Math.sqrt(length2);
        return new double[]{dot - sqrt, dot + sqrt};
    }

    public static Vector3[] intersects(Ray ray, Vector3 vector3, double d2) {
        double[] Intersects = Intersects(ray, vector3, d2);
        if (Intersects == null) {
            return null;
        }
        String str = "t1:";
        String str2 = "Rect";
        if (Intersects.length == 1) {
            StringBuilder a2 = a.a(str);
            a2.append(Intersects[0]);
            Log.i(str2, a2.toString());
            return new Vector3[]{ray.getDirection().clone().multiply(Intersects[0]).add(ray.getOrigin())};
        }
        StringBuilder a3 = a.a(str);
        a3.append(Intersects[0]);
        a3.append("t2:");
        a3.append(Intersects[1]);
        Log.i(str2, a3.toString());
        return new Vector3[]{ray.getDirection().clone().multiply(Intersects[0]).add(ray.getOrigin()), ray.getDirection().clone().multiply(Intersects[1]).add(ray.getOrigin())};
    }

    public static Ray screenPointToViewportRay(double d2, double d3, Matrix4 matrix4) {
        double d4 = d2;
        double d5 = d3;
        StringBuilder sb = new StringBuilder();
        sb.append("screen_x:");
        sb.append(d4);
        sb.append(" screen_y:");
        sb.append(d5);
        Log.i("Rect", sb.toString());
        Matrix4 inverse = matrix4.clone().inverse();
        double d6 = (d4 * 2.0d) - 1.0d;
        double d7 = 1.0d - (d5 * 2.0d);
        double[] dArr = {d6, d7, -1.0d, 1.0d};
        double[] dArr2 = {d6, d7, 0.0d, 1.0d};
        double[] dArr3 = new double[4];
        double[] dArr4 = dArr2;
        Matrix.multiplyMV(dArr3, 0, inverse.getDoubleValues(), 0, dArr, 0);
        double[] dArr5 = new double[4];
        Matrix.multiplyMV(dArr5, 0, inverse.getDoubleValues(), 0, dArr4, 0);
        Vector3 divide = new Vector3(dArr3).divide(dArr3[3]);
        Vector3 divide2 = new Vector3(dArr5).divide(dArr5[3]);
        Vector3 vector3 = new Vector3();
        vector3.subtractAndSet(divide2, divide);
        vector3.normalize();
        return new Ray(divide, vector3);
    }

    public Vector3 getDirection() {
        return this.mDirection;
    }

    public Vector3 getOrigin() {
        return this.mOrigin;
    }

    public void setDirection(Vector3 vector3) {
        this.mDirection = vector3;
    }

    public void setOrigin(Vector3 vector3) {
        this.mOrigin = vector3;
    }
}
