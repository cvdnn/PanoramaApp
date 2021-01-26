package com.arashivision.bmgmedia.utils;

import android.opengl.GLES20;
import e.a.a.a.a;

public class FboTarget {
    public int mFramebuffer;
    public int mOffscreenTexture;
    public boolean mReleased;

    public FboTarget(int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLUtils.checkGLError("glGenTextures");
        int i4 = iArr[0];
        this.mOffscreenTexture = i4;
        GLES20.glBindTexture(3553, i4);
        StringBuilder sb = new StringBuilder();
        sb.append("glBindTexture ");
        sb.append(this.mOffscreenTexture);
        GLUtils.checkGLError(sb.toString());
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.checkGLError("glTexParameter");
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLUtils.checkGLError("glGenFramebuffers");
        int i5 = iArr[0];
        this.mFramebuffer = i5;
        GLES20.glBindFramebuffer(36160, i5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("glBindFramebuffer ");
        sb2.append(this.mFramebuffer);
        GLUtils.checkGLError(sb2.toString());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mOffscreenTexture, 0);
        GLUtils.checkGLError("glFramebufferTexture2D");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus == 36053) {
            GLES20.glBindFramebuffer(36160, 0);
            return;
        }
        throw new RuntimeException(a.a("Framebuffer not complete, status=", glCheckFramebufferStatus));
    }

    public void bind() {
        GLES20.glBindFramebuffer(36160, this.mFramebuffer);
    }

    public void finalize() throws Throwable {
        if (!this.mReleased) {
            release();
        }
        super.finalize();
    }

    public int getFramebuffer() {
        return this.mFramebuffer;
    }

    public int getTexture() {
        return this.mOffscreenTexture;
    }

    public void release() {
        int[] iArr = {this.mOffscreenTexture};
        GLES20.glDeleteFramebuffers(1, new int[]{this.mFramebuffer}, 0);
        GLES20.glDeleteTextures(1, iArr, 0);
        this.mReleased = true;
    }

    public void resize(int i2, int i3) {
        GLES20.glBindTexture(3553, this.mOffscreenTexture);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
    }

    public void unbind() {
        GLES20.glBindFramebuffer(36160, 0);
    }
}
