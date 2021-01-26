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
import e.c.d.e.n0;
import java.util.List;

/* compiled from: ExposureModeAdapter */
public class h extends g<c> {

    /* renamed from: a reason: collision with root package name */
    public List<a> f6593a;

    /* renamed from: b reason: collision with root package name */
    public b f6594b;

    /* compiled from: ExposureModeAdapter */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public int f6595a;

        /* renamed from: b reason: collision with root package name */
        public boolean f6596b;

        /* renamed from: c reason: collision with root package name */
        public boolean f6597c = true;

        public a(int i2, boolean z) {
            this.f6595a = i2;
            this.f6596b = z;
        }
    }

    /* compiled from: ExposureModeAdapter */
    public interface b {
        void a(int i2);
    }

    /* compiled from: ExposureModeAdapter */
    public static class c extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final n0 f6598a;

        public c(n0 n0Var) {
            super(n0Var.f6048a);
            this.f6598a = n0Var;
        }
    }

    public h(List<a> list) {
        this.f6593a = list;
    }

    public /* synthetic */ void a(int i2, View view) {
        b bVar = this.f6594b;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public int getItemCount() {
        return this.f6593a.size();
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        c cVar = (c) d0Var;
        List<a> list = this.f6593a;
        a aVar = list != null ? (a) list.get(i2) : null;
        if (aVar != null) {
            if (cVar == null) {
                throw null;
            } else if (!aVar.f6597c) {
                cVar.f6598a.f6049b.setVisibility(8);
            } else {
                cVar.f6598a.f6049b.setVisibility(0);
                int i3 = aVar.f6595a;
                if (2 == i3) {
                    cVar.f6598a.f6049b.setText(R.string.auto);
                } else if (9 == i3) {
                    cVar.f6598a.f6049b.setText(R.string.iso_priority);
                } else if (4 == i3) {
                    cVar.f6598a.f6049b.setText(R.string.shutter_priority);
                } else if (1 == i3) {
                    cVar.f6598a.f6049b.setText(R.string.manual);
                }
                Context context = cVar.f6598a.f6048a.getContext();
                if (aVar.f6596b) {
                    cVar.f6598a.f6049b.setTextColor(context.getColor(R.color.pano_setting_text_select));
                } else {
                    cVar.f6598a.f6049b.setTextColor(context.getColor(R.color.white));
                }
            }
        }
        cVar.itemView.setOnClickListener(new b(this, i2));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panorama_exposure_mode_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.mode);
        if (textView != null) {
            return new c(new n0((LinearLayout) inflate, textView));
        }
        throw new NullPointerException("Missing required view with ID: ".concat("mode"));
    }
}
