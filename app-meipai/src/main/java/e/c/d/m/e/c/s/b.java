package e.c.d.m.e.c.s;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.picapture.R;
import com.baidu.picapture.model.device.DeviceInfo;
import java.util.List;

/* compiled from: SpinDeviceAdapter */
public class b<T> extends BaseAdapter {

    /* renamed from: a reason: collision with root package name */
    public List<T> f6769a;

    /* renamed from: b reason: collision with root package name */
    public Context f6770b;

    /* renamed from: c reason: collision with root package name */
    public e.c.d.m.i.g.b<DeviceInfo> f6771c;

    /* renamed from: e.c.d.m.e.c.s.b$b reason: collision with other inner class name */
    /* compiled from: SpinDeviceAdapter */
    public static class C0070b {

        /* renamed from: a reason: collision with root package name */
        public View f6772a;

        /* renamed from: b reason: collision with root package name */
        public TextView f6773b;

        /* renamed from: c reason: collision with root package name */
        public ImageView f6774c;

        /* renamed from: d reason: collision with root package name */
        public LottieAnimationView f6775d;

        public C0070b() {
        }

        public /* synthetic */ C0070b(a aVar) {
        }
    }

    public b(List<T> list, Context context) {
        this.f6769a = list;
        this.f6770b = context;
    }

    public /* synthetic */ void a(DeviceInfo deviceInfo, View view) {
        e.c.d.m.i.g.b<DeviceInfo> bVar = this.f6771c;
        if (bVar != null) {
            bVar.a(view, deviceInfo);
        }
    }

    public int getCount() {
        return this.f6769a.size();
    }

    public Object getItem(int i2) {
        return this.f6769a.get(i2);
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        C0070b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f6770b).inflate(R.layout.device_item, viewGroup, false);
            bVar = new C0070b(null);
            bVar.f6773b = (TextView) view.findViewById(R.id.device_name);
            bVar.f6772a = view.findViewById(R.id.device_item);
            bVar.f6774c = (ImageView) view.findViewById(R.id.device_status);
            bVar.f6775d = (LottieAnimationView) view.findViewById(R.id.connecting_anim);
            view.setTag(bVar);
        } else {
            bVar = (C0070b) view.getTag();
        }
        DeviceInfo deviceInfo = (DeviceInfo) this.f6769a.get(i2);
        bVar.f6773b.setText(deviceInfo.getName());
        bVar.f6772a.setOnClickListener(new a(this, deviceInfo));
        if (deviceInfo.getDeviceStatus() == 2) {
            bVar.f6774c.setVisibility(0);
            bVar.f6775d.setVisibility(4);
        } else if (deviceInfo.getDeviceStatus() == 1) {
            bVar.f6775d.setVisibility(0);
        } else {
            bVar.f6774c.setVisibility(4);
            bVar.f6775d.setVisibility(4);
        }
        return view;
    }
}
