package e.c.d.m.d.a.t0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import com.baidu.picapture.R;
import e.c.d.e.p0;
import java.util.List;

/* compiled from: MainSettingAdapter */
public class j extends g<d> {

    /* renamed from: a reason: collision with root package name */
    public List<a> f6604a;

    /* renamed from: b reason: collision with root package name */
    public c f6605b;

    /* compiled from: MainSettingAdapter */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public b f6606a;

        /* renamed from: b reason: collision with root package name */
        public String f6607b;

        /* renamed from: c reason: collision with root package name */
        public boolean f6608c;

        public a(b bVar, String str, boolean z) {
            this.f6606a = bVar;
            this.f6607b = str;
            this.f6608c = z;
        }
    }

    /* compiled from: MainSettingAdapter */
    public enum b {
        HDR,
        DELAY_CAPTURE,
        EXPOSURE_PROGRAM,
        EXPOSURE_VALUE,
        WHITE_BALANCE,
        ISO,
        SHUTTER_SPEED
    }

    /* compiled from: MainSettingAdapter */
    public interface c {
        void a(int i2);
    }

    /* compiled from: MainSettingAdapter */
    public static class d extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final p0 f6617a;

        public d(p0 p0Var) {
            super(p0Var.f6052a);
            this.f6617a = p0Var;
        }
    }

    public j(List<a> list) {
        this.f6604a = list;
    }

    public /* synthetic */ void a(int i2, View view) {
        c cVar = this.f6605b;
        if (cVar != null) {
            cVar.a(i2);
        }
    }

    public int getItemCount() {
        return this.f6604a.size();
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        Drawable drawable;
        Drawable drawable2;
        d dVar = (d) d0Var;
        List<a> list = this.f6604a;
        a aVar = list != null ? (a) list.get(i2) : null;
        if (aVar != null) {
            if (dVar == null) {
                throw null;
            } else if (!aVar.f6608c) {
                dVar.f6617a.f6053b.setVisibility(8);
            } else {
                dVar.f6617a.f6053b.setVisibility(0);
                b bVar = aVar.f6606a;
                String str = "";
                if (bVar != b.HDR) {
                    Context context = dVar.f6617a.f6052a.getContext();
                    switch (bVar.ordinal()) {
                        case 1:
                            drawable2 = context.getDrawable(R.drawable.pano_setting_delay_capture_selector);
                            break;
                        case 2:
                            drawable2 = context.getDrawable(R.drawable.pano_setting_exposure_mode_selector);
                            break;
                        case 3:
                            drawable2 = context.getDrawable(R.drawable.pano_setting_exposure_value_selector);
                            break;
                        case 4:
                            drawable2 = context.getDrawable(R.drawable.pano_setting_white_balance_selector);
                            break;
                        case 5:
                            drawable2 = context.getDrawable(R.drawable.pano_setting_iso_selector);
                            break;
                        case 6:
                            drawable2 = context.getDrawable(R.drawable.pano_setting_shutter_speed_selector);
                            break;
                        default:
                            drawable2 = null;
                            break;
                    }
                    str = aVar.f6607b;
                    drawable = drawable2;
                } else if (aVar.f6607b.equalsIgnoreCase("hdr")) {
                    drawable = dVar.f6617a.f6052a.getContext().getDrawable(R.drawable.pano_setting_hdr_open_selector);
                } else {
                    drawable = dVar.f6617a.f6052a.getContext().getDrawable(R.drawable.pano_setting_hdr_close_selector);
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                dVar.f6617a.f6053b.setCompoundDrawables(null, drawable, null, null);
                dVar.f6617a.f6053b.setText(str);
            }
        }
        dVar.itemView.setOnClickListener(new d(this, i2));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panorama_main_setting_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.name);
        if (textView != null) {
            return new d(new p0((LinearLayout) inflate, textView));
        }
        throw new NullPointerException("Missing required view with ID: ".concat("name"));
    }
}
