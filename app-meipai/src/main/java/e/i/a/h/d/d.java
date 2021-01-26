package e.i.a.h.d;

import android.database.Cursor;

/* compiled from: BreakpointInfoRow */
public class d {

    /* renamed from: a reason: collision with root package name */
    public final int f8711a;

    /* renamed from: b reason: collision with root package name */
    public final String f8712b;

    /* renamed from: c reason: collision with root package name */
    public final String f8713c;

    /* renamed from: d reason: collision with root package name */
    public final String f8714d;

    /* renamed from: e reason: collision with root package name */
    public final String f8715e;

    /* renamed from: f reason: collision with root package name */
    public final boolean f8716f;

    /* renamed from: g reason: collision with root package name */
    public final boolean f8717g;

    public d(Cursor cursor) {
        this.f8711a = cursor.getInt(cursor.getColumnIndex("id"));
        this.f8712b = cursor.getString(cursor.getColumnIndex("url"));
        this.f8713c = cursor.getString(cursor.getColumnIndex("etag"));
        this.f8714d = cursor.getString(cursor.getColumnIndex("parent_path"));
        this.f8715e = cursor.getString(cursor.getColumnIndex("filename"));
        boolean z = false;
        this.f8716f = cursor.getInt(cursor.getColumnIndex("task_only_parent_path")) == 1;
        if (cursor.getInt(cursor.getColumnIndex("chunked")) == 1) {
            z = true;
        }
        this.f8717g = z;
    }
}
