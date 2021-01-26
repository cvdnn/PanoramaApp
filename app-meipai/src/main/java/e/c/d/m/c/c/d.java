package e.c.d.m.c.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import e.c.b.e.Utils;
import e.c.d.d.e.ThreadPoolService;
import e.c.d.m.a.c;
import java.io.File;

/* compiled from: HotSpotSimplePreviewPresenter */
public class d extends c<c> implements b {

    /* renamed from: b reason: collision with root package name */
    public String f6510b;

    /* renamed from: c reason: collision with root package name */
    public boolean f6511c = false;

    public d(c cVar) {
        super(cVar);
    }

    public /* synthetic */ void F() {
        Bitmap decodeFile = BitmapFactory.decodeFile(this.f6510b);
        Utils.a(Utils.a(Utils.p(this.f6510b), Utils.a(decodeFile, Math.min(decodeFile.getWidth(), decodeFile.getHeight()))), this.f6510b);
        this.f6511c = false;
    }

    public void a(String str) {
        this.f6510b = str;
        File file = new File(this.f6510b);
        if (file.exists()) {
            ((c) this.f6403a).a(file);
        }
    }

    public void f() {
        this.f6511c = true;
        ThreadPoolService.fixedThreadPool.execute(new ThreadPoolService(this));
    }

    public void w() {
        boolean z;
        if (this.f6511c) {
            ((c) this.f6403a).b(App.f1954b.getString(R.string.processing_image));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ((c) this.f6403a).f(this.f6510b);
        }
    }
}
