package a.a.a.a.e.a.c;

import a.a.a.a.e.a.g.f;
import a.a.a.a.e.a.i.c;
import android.text.TextUtils;
import com.arashivision.insta360.basemedia.MediaModule;
import com.arashivision.insta360.basemedia.ui.player.video.IVideoParams;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class g implements h, Serializable {

    /* renamed from: a reason: collision with root package name */
    public List<IVideoParams> f463a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    public List<c> f464b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    public boolean f465c = false;

    /* renamed from: d reason: collision with root package name */
    public f f466d = f.f462a;

    /* renamed from: e reason: collision with root package name */
    public String f467e;

    /* renamed from: f reason: collision with root package name */
    public int[] f468f;

    /* renamed from: g reason: collision with root package name */
    public String f469g;

    /* renamed from: h reason: collision with root package name */
    public long f470h;

    /* renamed from: i reason: collision with root package name */
    public long f471i;

    /* renamed from: j reason: collision with root package name */
    public float f472j;
    public String k;

    @Deprecated
    public g() {
        String str = "";
        this.f467e = str;
        this.f468f = new int[]{1, 1};
        this.f469g = str;
        this.f470h = -1;
        this.f472j = 0.0f;
        this.f471i = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(MediaModule.getCacheFolder());
        sb.append("cutscene/project/");
        this.k = sb.toString();
    }

    public static /* synthetic */ float[] a(int i2, int i3, int i4, int i5) {
        return new float[]{200.0f, 100.0f, 0.0f, 0.0f};
    }

    public Object clone() {
        try {
            g gVar = (g) super.clone();
            ArrayList arrayList = new ArrayList();
            for (IVideoParams clone : gVar.f463a) {
                arrayList.add(clone.clone());
            }
            gVar.f463a = arrayList;
            return gVar;
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean containsBgmData() {
        if (!TextUtils.isEmpty(this.f469g) && this.f470h >= 0 && this.f471i >= 0) {
            float f2 = this.f472j;
            if (f2 >= 0.0f && f2 <= 1.0f) {
                return true;
            }
        }
        return false;
    }

    public f getWatermarkRectCalculator() {
        return this.f466d;
    }

    public String getWatermarkResourcesPath() {
        return this.f467e;
    }

    public boolean isWatermarkEnabled() {
        return this.f465c;
    }
}
