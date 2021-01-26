package e.c.d.m.i.g;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.d0;
import androidx.recyclerview.widget.RecyclerView.g;
import androidx.recyclerview.widget.RecyclerView.o;
import com.baidu.picapture.R;
import java.util.List;

/* compiled from: SpinCaptureModeAdapter */
public class c extends g<a> {

    /* renamed from: a reason: collision with root package name */
    public List<e.c.d.m.i.g.d.a> f6799a;

    /* renamed from: b reason: collision with root package name */
    public RecyclerView f6800b;

    /* compiled from: SpinCaptureModeAdapter */
    public class a extends d0 {

        /* renamed from: a reason: collision with root package name */
        public TextView f6801a;

        public a(View view) {
            super(view);
            this.f6801a = (TextView) view.findViewById(R.id.tv);
            view.setLayoutParams(new o(-2, view.getLayoutParams().height));
            this.f6801a.setOnClickListener(new a(this));
        }

        public /* synthetic */ void a(View view) {
            c.this.f6800b.smoothScrollToPosition(getAdapterPosition());
        }
    }

    public c(List<e.c.d.m.i.g.d.a> list) {
        this.f6799a = list;
    }

    public int getItemCount() {
        return this.f6799a.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f6800b = recyclerView;
    }

    public void onBindViewHolder(d0 d0Var, int i2) {
        a aVar = (a) d0Var;
        e.c.d.m.i.g.d.a aVar2 = (e.c.d.m.i.g.d.a) this.f6799a.get(i2);
        aVar.f6801a.setText(aVar2.f6803a);
        if (aVar2.f6804b) {
            aVar.f6801a.setTextColor(Color.parseColor("#FFFFFFFF"));
        } else {
            aVar.f6801a.setTextColor(Color.parseColor("#FF999999"));
        }
    }

    public d0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_mode_item, viewGroup, false));
    }
}
