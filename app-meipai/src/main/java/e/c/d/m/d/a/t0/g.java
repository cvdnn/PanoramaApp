package e.c.d.m.d.a.t0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.d0;
import com.baidu.picapture.R;
import e.c.d.e.m0;
import java.util.List;

/* compiled from: DelayCaptureAdapter */
public class g extends androidx.recyclerview.widget.RecyclerView.g<c> {

    /* renamed from: a reason: collision with root package name */
    public List<a> f6587a;

    /* renamed from: b reason: collision with root package name */
    public b f6588b;

    /* compiled from: DelayCaptureAdapter */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f6589a;

        /* renamed from: b reason: collision with root package name */
        public int f6590b;

        /* renamed from: c reason: collision with root package name */
        public boolean f6591c;

        public a(String str, int i2, boolean z) {
            this.f6589a = str;
            this.f6590b = i2;
            this.f6591c = z;
        }
    }

    /* compiled from: DelayCaptureAdapter */
    public interface b {
        void a(int i2);
    }

    /* compiled from: DelayCaptureAdapter */
    public static class c extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final m0 f6592a;

        public c(m0 m0Var) {
            super(m0Var.f6046a);
            this.f6592a = m0Var;
        }
    }

    public g(List<a> list) {
        this.f6587a = list;
    }

    public /* synthetic */ void a(int i2, View view) {
        b bVar = this.f6588b;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public int getItemCount() {
        return this.f6587a.size();
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        c cVar = (c) d0Var;
        List<a> list = this.f6587a;
        a aVar = list != null ? (a) list.get(i2) : null;
        if (aVar != null) {
            cVar.f6592a.f6047b.setText(aVar.f6589a);
            Context context = cVar.f6592a.f6046a.getContext();
            if (aVar.f6591c) {
                cVar.f6592a.f6047b.setTextColor(context.getColor(R.color.pano_setting_text_select));
            } else {
                cVar.f6592a.f6047b.setTextColor(context.getColor(R.color.white));
            }
        }
        cVar.itemView.setOnClickListener(new a(this, i2));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panorama_delay_capture_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.delay_value);
        if (textView != null) {
            return new c(new m0((LinearLayout) inflate, textView));
        }
        throw new NullPointerException("Missing required view with ID: ".concat("delayValue"));
    }
}
