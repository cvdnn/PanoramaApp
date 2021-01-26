package e.c.d.m.d.a.t0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import com.baidu.picapture.R;
import e.c.b.e.Utils;
import e.c.d.e.q0;
import java.util.List;

/* compiled from: ShutterSpeedAdapter */
public class k extends g<c> {

    /* renamed from: a reason: collision with root package name */
    public List<a> f6618a;

    /* renamed from: b reason: collision with root package name */
    public b f6619b;

    /* compiled from: ShutterSpeedAdapter */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public float f6620a;

        /* renamed from: b reason: collision with root package name */
        public boolean f6621b;

        public a(float f2, boolean z) {
            this.f6620a = f2;
            this.f6621b = z;
        }
    }

    /* compiled from: ShutterSpeedAdapter */
    public interface b {
        void a(int i2);
    }

    /* compiled from: ShutterSpeedAdapter */
    public static class c extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final q0 f6622a;

        public c(q0 q0Var) {
            super(q0Var.f6054a);
            this.f6622a = q0Var;
        }
    }

    public k(List<a> list) {
        this.f6618a = list;
    }

    public /* synthetic */ void a(int i2, View view) {
        b bVar = this.f6619b;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public int getItemCount() {
        return this.f6618a.size();
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        c cVar = (c) d0Var;
        List<a> list = this.f6618a;
        a aVar = list != null ? (a) list.get(i2) : null;
        if (aVar != null) {
            if (cVar != null) {
                float f2 = aVar.f6620a;
                if (f2 >= 1.0f) {
                    cVar.f6622a.f6055b.setText(String.format("%d", new Object[]{Integer.valueOf((int) f2)}));
                } else {
                    cVar.f6622a.f6055b.setText(Utils.a(f2));
                }
                Context context = cVar.f6622a.f6054a.getContext();
                if (aVar.f6621b) {
                    cVar.f6622a.f6055b.setTextColor(context.getColor(R.color.pano_setting_text_select));
                } else {
                    cVar.f6622a.f6055b.setTextColor(context.getColor(R.color.white));
                }
            } else {
                throw null;
            }
        }
        cVar.itemView.setOnClickListener(new e(this, i2));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panorama_shutter_speed_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.value);
        if (textView != null) {
            return new c(new q0((LinearLayout) inflate, textView));
        }
        throw new NullPointerException("Missing required view with ID: ".concat("value"));
    }
}
