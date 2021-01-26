package e.i.a.h.d;

import android.database.Cursor;

/* compiled from: BlockInfoRow */
public class b {

    /* renamed from: a reason: collision with root package name */
    public final int f8698a;

    /* renamed from: b reason: collision with root package name */
    public final long f8699b;

    /* renamed from: c reason: collision with root package name */
    public final long f8700c;

    /* renamed from: d reason: collision with root package name */
    public final long f8701d;

    public b(Cursor cursor) {
        this.f8698a = cursor.getInt(cursor.getColumnIndex("breakpoint_id"));
        this.f8699b = (long) cursor.getInt(cursor.getColumnIndex("start_offset"));
        this.f8700c = (long) cursor.getInt(cursor.getColumnIndex("content_length"));
        this.f8701d = (long) cursor.getInt(cursor.getColumnIndex("current_offset"));
    }
}
