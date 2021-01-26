package e.c.d;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.baidu.picapture.R;
import d.k.d;
import e.a.a.a.a;
import e.c.d.e.c0;
import e.c.d.e.f;
import e.c.d.e.f0;
import e.c.d.e.h;
import e.c.d.e.h0;
import e.c.d.e.j;
import e.c.d.e.j0;
import e.c.d.e.l;
import e.c.d.e.l0;
import e.c.d.e.o;
import e.c.d.e.p;
import e.c.d.e.r;
import e.c.d.e.t;
import e.c.d.e.u;
import e.c.d.e.w;
import e.c.d.e.x;
import e.c.d.e.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DataBinderMapperImpl */
public class b extends d.k.b {

    /* renamed from: a reason: collision with root package name */
    public static final SparseIntArray f5944a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(16);
        f5944a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_home, 1);
        f5944a.put(R.layout.activity_hot_spot_simple_preview, 2);
        f5944a.put(R.layout.activity_hotspot_capture, 3);
        f5944a.put(R.layout.activity_panorama_capture, 4);
        f5944a.put(R.layout.activity_panorama_guide, 5);
        f5944a.put(R.layout.activity_panorama_preview, 6);
        f5944a.put(R.layout.activity_spin_capture, 7);
        f5944a.put(R.layout.activity_spin_device, 8);
        f5944a.put(R.layout.activity_spin_photo, 9);
        f5944a.put(R.layout.activity_spin_preview, 10);
        f5944a.put(R.layout.activity_spin_task_detail, 11);
        f5944a.put(R.layout.activity_spot_preview, 12);
        f5944a.put(R.layout.app_force_update_dialog, 13);
        f5944a.put(R.layout.app_update_dialog, 14);
        f5944a.put(R.layout.capture_guide_dialog, 15);
        f5944a.put(R.layout.navigation_bar, 16);
    }

    public ViewDataBinding a(d dVar, View view, int i2) {
        int i3 = f5944a.get(i2);
        if (i3 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                switch (i3) {
                    case 1:
                        if ("layout/activity_home_0".equals(tag)) {
                            return new e.c.d.e.b(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_home is invalid. Received: ", tag));
                    case 2:
                        if ("layout/activity_hot_spot_simple_preview_0".equals(tag)) {
                            return new e.c.d.e.d(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_hot_spot_simple_preview is invalid. Received: ", tag));
                    case 3:
                        if ("layout/activity_hotspot_capture_0".equals(tag)) {
                            return new f(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_hotspot_capture is invalid. Received: ", tag));
                    case 4:
                        if ("layout/activity_panorama_capture_0".equals(tag)) {
                            return new h(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_panorama_capture is invalid. Received: ", tag));
                    case 5:
                        if ("layout/activity_panorama_guide_0".equals(tag)) {
                            return new j(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_panorama_guide is invalid. Received: ", tag));
                    case 6:
                        if ("layout/activity_panorama_preview_0".equals(tag)) {
                            return new l(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_panorama_preview is invalid. Received: ", tag));
                    case 7:
                        if ("layout/activity_spin_capture_0".equals(tag)) {
                            return new o(dVar, view);
                        }
                        if ("layout-land/activity_spin_capture_0".equals(tag)) {
                            return new p(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_spin_capture is invalid. Received: ", tag));
                    case 8:
                        if ("layout/activity_spin_device_0".equals(tag)) {
                            return new r(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_spin_device is invalid. Received: ", tag));
                    case 9:
                        if ("layout/activity_spin_photo_0".equals(tag)) {
                            return new t(dVar, view);
                        }
                        if ("layout-land/activity_spin_photo_0".equals(tag)) {
                            return new u(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_spin_photo is invalid. Received: ", tag));
                    case 10:
                        if ("layout-land/activity_spin_preview_0".equals(tag)) {
                            return new x(dVar, view);
                        }
                        if ("layout/activity_spin_preview_0".equals(tag)) {
                            return new w(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_spin_preview is invalid. Received: ", tag));
                    case 11:
                        if ("layout/activity_spin_task_detail_0".equals(tag)) {
                            return new z(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_spin_task_detail is invalid. Received: ", tag));
                    case 12:
                        if ("layout/activity_spot_preview_0".equals(tag)) {
                            return new c0(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for activity_spot_preview is invalid. Received: ", tag));
                    case 13:
                        if ("layout/app_force_update_dialog_0".equals(tag)) {
                            return new f0(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for app_force_update_dialog is invalid. Received: ", tag));
                    case 14:
                        if ("layout/app_update_dialog_0".equals(tag)) {
                            return new h0(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for app_update_dialog is invalid. Received: ", tag));
                    case 15:
                        if ("layout/capture_guide_dialog_0".equals(tag)) {
                            return new j0(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for capture_guide_dialog is invalid. Received: ", tag));
                    case 16:
                        if ("layout/navigation_bar_0".equals(tag)) {
                            return new l0(dVar, view);
                        }
                        throw new IllegalArgumentException(a.a("The tag for navigation_bar is invalid. Received: ", tag));
                }
            } else {
                throw new RuntimeException("view must have a tag");
            }
        }
        return null;
    }

    public ViewDataBinding a(d dVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f5944a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public List<d.k.b> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new d.k.g.b.a());
        return arrayList;
    }
}
