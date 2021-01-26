package e.c.d.m.c.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.picapture.App;
import com.baidu.picapture.R;
import com.baidu.picapture.model.hotspot.HotSpot;
import com.baidubce.BceConfig;
import e.a.a.a.a;
import e.c.b.e.Utils;
import e.c.d.d.e.ThreadPoolService;
import e.c.d.m.a.c;
import e.c.d.n.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: HotSpotPreviewPresenter */
public class f extends c<e> implements d {

    /* renamed from: b reason: collision with root package name */
    public String f6505b;

    /* renamed from: c reason: collision with root package name */
    public String f6506c;

    /* renamed from: d reason: collision with root package name */
    public HotSpot f6507d;

    /* renamed from: e reason: collision with root package name */
    public boolean f6508e = false;

    public f(e eVar) {
        super(eVar);
    }

    public void D() {
        if (!F()) {
            Utils.d(this.f6506c);
            ((e) this.f6403a).d();
        }
    }

    public final boolean F() {
        if (!this.f6508e) {
            return false;
        }
        ((e) this.f6403a).b(App.f1954b.getString(R.string.processing_image));
        return true;
    }

    public /* synthetic */ void G() {
        Bitmap decodeFile = BitmapFactory.decodeFile(this.f6506c);
        Utils.a(Utils.a(Utils.p(this.f6506c), Utils.a(decodeFile, Math.min(decodeFile.getWidth(), decodeFile.getHeight()))), this.f6506c);
        this.f6508e = false;
    }

    public void a(String str, String str2) {
        this.f6505b = str;
        this.f6506c = str2;
        File file = new File(this.f6506c);
        if (file.exists()) {
            ((e) this.f6403a).a(file);
        }
    }

    public void b(String str, String str2) {
        if (!F()) {
            List f2 = e.f(this.f6505b);
            if (f2 == null) {
                f2 = new ArrayList();
            }
            if (this.f6507d != null) {
                Iterator it = f2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HotSpot hotSpot = (HotSpot) it.next();
                    if (hotSpot.getImg().compareToIgnoreCase(this.f6507d.getImg()) == 0) {
                        hotSpot.setTitle(str);
                        hotSpot.setDescribe(str2);
                        break;
                    }
                }
            } else {
                HotSpot hotSpot2 = new HotSpot();
                hotSpot2.setTitle(str);
                hotSpot2.setDescribe(str2);
                File file = new File(this.f6506c);
                StringBuilder a2 = a.a("hotspots/");
                a2.append(file.getName());
                hotSpot2.setImg(a2.toString());
                f2.add(hotSpot2);
            }
            e.a(this.f6505b, f2);
            ((e) this.f6403a).N();
        }
    }

    public void f() {
        this.f6508e = true;
        ThreadPoolService.fixedThreadPool.execute(new c(this));
    }

    public void h() {
        if (!F() && this.f6507d != null) {
            List f2 = e.f(this.f6505b);
            if (f2 != null) {
                Iterator it = f2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    HotSpot hotSpot = (HotSpot) it.next();
                    if (hotSpot.getImg().compareToIgnoreCase(this.f6507d.getImg()) == 0) {
                        f2.remove(hotSpot);
                        break;
                    }
                }
                f2.remove(this.f6507d);
                e.a(this.f6505b, f2);
                StringBuilder sb = new StringBuilder();
                sb.append(e.j(this.f6505b));
                sb.append(BceConfig.BOS_DELIMITER);
                sb.append(this.f6507d.getImg());
                Utils.d(sb.toString());
                ((e) this.f6403a).N();
            }
        }
    }

    public void a(HotSpot hotSpot) {
        this.f6507d = hotSpot;
    }
}
