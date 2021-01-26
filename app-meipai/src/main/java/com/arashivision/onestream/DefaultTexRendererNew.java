package com.arashivision.onestream;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class DefaultTexRendererNew implements Renderer {
    public static final int FLOAT_SIZE_BYTES = 4;
    public static final String FRAGMENT_SHADER_2D = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public static final String FRAGMENT_SHADER_OES = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n  gl_FragColor.a = 1.0;\n}\n";
    public static final int GL_TEXTURE_EXTERNAL_OES = 36197;
    public static final String TAG = "DefaultTexRenderer";
    public static float[] TRIANGLE_VERTICES = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final String VERTEX_SHADER = "uniform mat4 uSTMatrix;\nuniform mat4 uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    public int mAPositionHandle = -1;
    public int mATextureHandle = -1;
    public boolean mGLClear = false;
    public float[] mMVPMatrix = new float[16];
    public FloatBuffer mMVPMatrixBuf;
    public int mProgram;
    public int mTargetFrameBuffer = -1;
    public int mTargetHeight;
    public int mTargetTexutre;
    public int mTargetWidth;
    public FloatBuffer mTextureMatrixBuf;
    public TextureType mTextureType;
    public int mUMVPMatrixHandle = -1;
    public int mUSTMatrixHandle = -1;
    public int mVerBufHandle = 0;
    public FloatBuffer mVerticesBuf;

    public DefaultTexRendererNew(TextureType textureType, int i2, int i3, boolean z) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(TRIANGLE_VERTICES.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mVerticesBuf = asFloatBuffer;
        asFloatBuffer.put(TRIANGLE_VERTICES).position(0);
        this.mTextureMatrixBuf = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mMVPMatrixBuf = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureType = textureType;
        this.mTargetWidth = i2;
        this.mTargetHeight = i3;
        if (z) {
            Matrix.orthoM(this.mMVPMatrix, 0, -1.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f);
        } else {
            Matrix.orthoM(this.mMVPMatrix, 0, -1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f);
        }
        this.mMVPMatrixBuf.put(this.mMVPMatrix).position(0);
        StringBuilder sb = new StringBuilder();
        sb.append("DefaultTexRenderer: mTextureType ");
        sb.append(this.mTextureType);
        sb.append(" w ");
        sb.append(this.mTargetWidth);
        sb.append(" h ");
        sb.append(this.mTargetHeight);
        Log.d(TAG, sb.toString());
    }

    public void deInit() {
        GLES20.glDeleteBuffers(1, new int[]{this.mVerBufHandle}, 0);
        GLES20.glUseProgram(0);
        int i2 = this.mProgram;
        if (i2 != 0) {
            GLES20.glDeleteProgram(i2);
        }
        this.mProgram = 0;
    }

    public int init() {
        int createProgram = GLUtils.createProgram(VERTEX_SHADER, this.mTextureType == TextureType.GL2_OES ? FRAGMENT_SHADER_OES : FRAGMENT_SHADER_2D);
        this.mProgram = createProgram;
        String str = TAG;
        if (createProgram == 0) {
            Log.e(str, "failed createProgram");
            return -1;
        }
        this.mAPositionHandle = GLES20.glGetAttribLocation(createProgram, "aPosition");
        this.mATextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        this.mUSTMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uSTMatrix");
        this.mUMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        int i2 = iArr[0];
        this.mVerBufHandle = i2;
        GLES20.glBindBuffer(34962, i2);
        GLES20.glBufferData(34962, this.mVerticesBuf.remaining() * 4, this.mVerticesBuf, 35044);
        GLES20.glBindBuffer(34962, 0);
        Log.i(str, "init OK");
        return 0;
    }

    public int render(int i2, float[] fArr, float[] fArr2) {
        GLES20.glBindFramebuffer(36160, this.mTargetFrameBuffer);
        int i3 = 3553;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mTargetTexutre, 0);
        GLES20.glViewport(0, 0, this.mTargetWidth, this.mTargetHeight);
        if (this.mGLClear) {
            GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            GLUtils.checkGLError("DefaultTexRenderer glClear ");
        }
        GLES20.glUseProgram(this.mProgram);
        StringBuilder sb = new StringBuilder();
        sb.append("DefaultTexRenderer glUseProgram ");
        sb.append(i2);
        if (GLUtils.checkGLError(sb.toString())) {
            return -203;
        }
        GLES20.glActiveTexture(33984);
        if (this.mTextureType == TextureType.GL2_OES) {
            i3 = 36197;
        }
        GLES20.glBindTexture(i3, i2);
        GLES20.glBindBuffer(34962, this.mVerBufHandle);
        GLES20.glVertexAttribPointer(this.mAPositionHandle, 3, 5126, false, 20, 0);
        GLES20.glEnableVertexAttribArray(this.mAPositionHandle);
        GLES20.glVertexAttribPointer(this.mATextureHandle, 2, 5126, false, 20, 12);
        GLES20.glEnableVertexAttribArray(this.mATextureHandle);
        this.mTextureMatrixBuf.put(fArr).position(0);
        GLES20.glUniformMatrix4fv(this.mUSTMatrixHandle, 1, false, this.mTextureMatrixBuf);
        this.mMVPMatrixBuf.put(this.mMVPMatrix).position(0);
        GLES20.glUniformMatrix4fv(this.mUMVPMatrixHandle, 1, false, this.mMVPMatrixBuf);
        GLES20.glDrawArrays(5, 0, 4);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DefaultTexRenderer glDrawArrays ");
        sb2.append(i2);
        if (GLUtils.checkGLError(sb2.toString())) {
            return -203;
        }
        GLES20.glUseProgram(0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(i3, 0);
        GLES20.glDisableVertexAttribArray(this.mATextureHandle);
        GLES20.glDisableVertexAttribArray(this.mAPositionHandle);
        GLUtils.checkGLError("DefaultTexRenderer 138");
        return 0;
    }

    public void setTargetFb(int i2) {
        this.mTargetFrameBuffer = i2;
    }

    public void setTargetSize(int i2, int i3) {
        this.mTargetWidth = i2;
        this.mTargetHeight = i3;
    }

    public void setTargetTexture(int i2) {
        this.mTargetTexutre = i2;
    }
}
