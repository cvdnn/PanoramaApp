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
import com.baidu.picapture.model.device.LanguageUtils;
import e.c.d.e.r0;
import java.util.List;

/* compiled from: WhiteBalanceAdapter */
public class l extends g<c> {

    /* renamed from: a reason: collision with root package name */
    public List<a> f6623a;

    /* renamed from: b reason: collision with root package name */
    public b f6624b;

    /* compiled from: WhiteBalanceAdapter */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        public String f6625a;

        /* renamed from: b reason: collision with root package name */
        public boolean f6626b;

        public a(String str, boolean z) {
            this.f6625a = str;
            this.f6626b = z;
        }
    }

    /* compiled from: WhiteBalanceAdapter */
    public interface b {
        void a(int i2);
    }

    /* compiled from: WhiteBalanceAdapter */
    public static class c extends d0 {

        /* renamed from: a reason: collision with root package name */
        public final r0 f6627a;

        public c(r0 r0Var) {
            super(r0Var.f6056a);
            this.f6627a = r0Var;
        }
    }

    public l(List<a> list) {
        this.f6623a = list;
    }

    public /* synthetic */ void a(int i2, View view) {
        b bVar = this.f6624b;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    public int getItemCount() {
        return this.f6623a.size();
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        c cVar = (c) d0Var;
        List<a> list = this.f6623a;
        a aVar = list != null ? (a) list.get(i2) : null;
        if (aVar != null) {
            if (cVar != null) {
                String str = aVar.f6625a;
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -939299377:
                        if (str.equals("incandescent")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -351699028:
                        if (str.equals("datalight")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3005871:
                        if (str.equals(LanguageUtils.AUTO)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 474934723:
                        if (str.equals("cloudy-daylight")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1902580840:
                        if (str.equals("fluorescent")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    cVar.f6627a.f6057b.setText(R.string.auto);
                } else if (c2 == 1) {
                    cVar.f6627a.f6057b.setText(R.string.incandescent);
                } else if (c2 == 2) {
                    cVar.f6627a.f6057b.setText(R.string.daylight);
                } else if (c2 == 3) {
                    cVar.f6627a.f6057b.setText(R.string.cloudy_daylight);
                } else if (c2 == 4) {
                    cVar.f6627a.f6057b.setText(R.string.fluorescent);
                }
                Context context = cVar.f6627a.f6056a.getContext();
                if (aVar.f6626b) {
                    cVar.f6627a.f6057b.setTextColor(context.getColor(R.color.pano_setting_text_select));
                } else {
                    cVar.f6627a.f6057b.setTextColor(context.getColor(R.color.white));
                }
            } else {
                throw null;
            }
        }
        cVar.itemView.setOnClickListener(new f(this, i2));
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.panorama_white_balance_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.mode);
        if (textView != null) {
            return new c(new r0((LinearLayout) inflate, textView));
        }
        throw new NullPointerException("Missing required view with ID: ".concat("mode"));
    }
}
