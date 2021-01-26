package com.arashivision.bmgmedia.utils;

import android.opengl.GLES20;
import android.opengl.GLU;
import android.util.Log;

public class GLUtils {
    public static final String TAG = "ins";

    public static boolean checkGLError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return false;
        }
        String str2 = "ins";
        Log.e(str2, String.format("%s error: %s", new Object[]{str, GLU.gluErrorString(glGetError)}));
        return true;
    }

    public static int createProgram(String str, String str2) {
        int loadShader = loadShader(35633, str);
        int i2 = 0;
        if (loadShader == 0) {
            return 0;
        }
        int loadShader2 = loadShader(35632, str2);
        if (loadShader2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader);
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String str3 = "ins";
                Log.e(str3, "Could not link program");
                Log.e(str3, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                GLES20.glDeleteShader(loadShader);
                GLES20.glDeleteShader(loadShader2);
                return i2;
            }
        }
        i2 = glCreateProgram;
        GLES20.glDeleteShader(loadShader);
        GLES20.glDeleteShader(loadShader2);
        return i2;
    }

    public static int loadShader(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Object[] objArr = new Object[1];
        objArr[0] = i2 == 35632 ? "fragment" : "vertex";
        String format = String.format("failed compile %s shader.", objArr);
        String str2 = "ins";
        Log.e(str2, format);
        StringBuilder sb = new StringBuilder();
        sb.append("Shader log: ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e(str2, sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}
