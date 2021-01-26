package f.a.a.c;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.baidu.mobstat.Config;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: TextureRender */
public class l {

    /* renamed from: a reason: collision with root package name */
    public long f9080a = -1;

    /* renamed from: b reason: collision with root package name */
    public final float[] f9081b;

    /* renamed from: c reason: collision with root package name */
    public FloatBuffer f9082c;

    /* renamed from: d reason: collision with root package name */
    public float[] f9083d;

    /* renamed from: e reason: collision with root package name */
    public float[] f9084e;

    /* renamed from: f reason: collision with root package name */
    public int f9085f;

    /* renamed from: g reason: collision with root package name */
    public int f9086g;

    /* renamed from: h reason: collision with root package name */
    public int f9087h;

    /* renamed from: i reason: collision with root package name */
    public int f9088i;

    /* renamed from: j reason: collision with root package name */
    public int f9089j;
    public int k;

    public l() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f9081b = fArr;
        this.f9083d = new float[16];
        this.f9084e = new float[16];
        this.f9085f = -1;
        this.f9086g = -1;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f9082c = asFloatBuffer;
        asFloatBuffer.put(this.f9081b).position(0);
        Matrix.setIdentityM(this.f9084e, 0);
    }

    public final int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        StringBuilder sb = new StringBuilder();
        sb.append("glCreateShader type=");
        sb.append(i2);
        a(sb.toString());
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Could not compile shader ");
        sb2.append(i2);
        sb2.append(Config.TRACE_TODAY_VISIT_SPLIT);
        String sb3 = sb2.toString();
        String str2 = "TextureRender";
        Log.e(str2, sb3);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(" ");
        sb4.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e(str2, sb4.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = ": glError ";
            sb.append(str2);
            sb.append(glGetError);
            Log.e("TextureRender", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
            sb2.append(glGetError);
            throw new RuntimeException(sb2.toString());
        }
    }
}
