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
import e.c.d.e.o0;
import java.util.List;

/* compiled from: ISOAdapter */
public class i extends g<c> {

    /* renamed from: a reason: collision with root package name */
    public List<a> f6599a;

    /* renamed from: b reason: collision with root package name */
    public b f6600b;

    /* compiled from: ISOAdapter */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public int f6601a;

        /* renamed from: b reason: collision with root package name */
        public boolean f6602b;

        public a(int i2, boolean z) {
            this.f6601a = i2;
            this.f6602b = z;
        }
    }

    /* compiled from: ISOAdapter */
    public interface b {
        void a(int i2);
    }

    /* compiled from: ISOAdapter */
    public static class c extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final o0 f6603a;

        public c(o0 o0Var) {
            super(o0Var.f6050a);
            this.f6603a = o0Var;
        }
    }

    public i(List<a> list) {
        this.f6599a = list;
    }

    public /* synthetic */ void a(int i2, View view) {
        b bVar = this.f6600b;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public int getItemCount() {
        return this.f6599a.size();
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        c cVar = (c) d0Var;
        List<a> list = this.f6599a;
        a aVar = list != null ? (a) list.get(i2) : null;
        if (aVar != null) {
            cVar.f6603a.f6051b.setText(String.valueOf(aVar.f6601a));
            Context context = cVar.f6603a.f6050a.getContext();
            if (aVar.f6602b) {
                cVar.f6603a.f6051b.setTextColor(context.getColor(R.color.pano_setting_text_select));
            } else {
                cVar.f6603a.f6051b.setTextColor(context.getColor(R.color.white));
            }
        }
        cVar.itemView.setOnClickListener(new c(this, i2));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panorama_iso_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.value);
        if (textView != null) {
            return new c(new o0((LinearLayout) inflate, textView));
        }
        throw new NullPointerException("Missing required view with ID: ".concat("value"));
    }
}
