package com.arashivision.arvbmg.util;

import android.opengl.GLES20;
import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;

public class EGLUtil {
    public static void checkEGLInfo() {
        String glGetString = GLES20.glGetString(7938);
        StringBuilder sb = new StringBuilder();
        sb.append("egl version: ");
        sb.append(glGetString);
        String sb2 = sb.toString();
        String str = BMGConstants.TAG;
        Log.i(str, sb2);
        String glGetString2 = GLES20.glGetString(7939);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("egl extension ");
        sb3.append(glGetString2);
        Log.i(str, sb3.toString());
    }
}
