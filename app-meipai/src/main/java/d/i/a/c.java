package d.i.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter */
public abstract class c extends a {

    /* renamed from: i reason: collision with root package name */
    public int f5009i;

    /* renamed from: j reason: collision with root package name */
    public int f5010j;
    public LayoutInflater k;

    @Deprecated
    public c(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f5010j = i2;
        this.f5009i = i2;
        this.k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.k.inflate(this.f5009i, viewGroup, false);
    }
}
