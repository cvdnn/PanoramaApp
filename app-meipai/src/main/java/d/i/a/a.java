package d.i.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* compiled from: CursorAdapter */
public abstract class a extends BaseAdapter implements Filterable, d.i.a.b.a {

    /* renamed from: a reason: collision with root package name */
    public boolean f4998a;

    /* renamed from: b reason: collision with root package name */
    public boolean f4999b;

    /* renamed from: c reason: collision with root package name */
    public Cursor f5000c;

    /* renamed from: d reason: collision with root package name */
    public Context f5001d;

    /* renamed from: e reason: collision with root package name */
    public int f5002e;

    /* renamed from: f reason: collision with root package name */
    public C0044a f5003f;

    /* renamed from: g reason: collision with root package name */
    public DataSetObserver f5004g;

    /* renamed from: h reason: collision with root package name */
    public b f5005h;

    /* renamed from: d.i.a.a$a reason: collision with other inner class name */
    /* compiled from: CursorAdapter */
    public class C0044a extends ContentObserver {
        public C0044a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z) {
            a aVar = a.this;
            if (aVar.f4999b) {
                Cursor cursor = aVar.f5000c;
                if (cursor != null && !cursor.isClosed()) {
                    aVar.f4998a = aVar.f5000c.requery();
                }
            }
        }
    }

    /* compiled from: CursorAdapter */
    public class b extends DataSetObserver {
        public b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f4998a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f4998a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        boolean z2 = true;
        boolean z3 = z ? true : true;
        if (z3 && true) {
            z3 |= true;
            this.f4999b = true;
        } else {
            this.f4999b = false;
        }
        if (cursor == null) {
            z2 = false;
        }
        this.f5000c = cursor;
        this.f4998a = z2;
        this.f5001d = context;
        this.f5002e = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if (z3 & true) {
            this.f5003f = new C0044a();
            this.f5004g = new b();
        } else {
            this.f5003f = null;
            this.f5004g = null;
        }
        if (z2) {
            C0044a aVar = this.f5003f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f5004g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public void a(Cursor cursor) {
        Cursor cursor2 = this.f5000c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0044a aVar = this.f5003f;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.f5004g;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.f5000c = cursor;
            if (cursor != null) {
                C0044a aVar2 = this.f5003f;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.f5004g;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f5002e = cursor.getColumnIndexOrThrow("_id");
                this.f4998a = true;
                notifyDataSetChanged();
            } else {
                this.f5002e = -1;
                this.f4998a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract CharSequence b(Cursor cursor);

    public int getCount() {
        if (this.f4998a) {
            Cursor cursor = this.f5000c;
            if (cursor != null) {
                return cursor.getCount();
            }
        }
        return 0;
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f4998a) {
            return null;
        }
        this.f5000c.moveToPosition(i2);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.k.inflate(cVar.f5010j, viewGroup, false);
        }
        a(view, this.f5001d, this.f5000c);
        return view;
    }

    public Filter getFilter() {
        if (this.f5005h == null) {
            this.f5005h = new b(this);
        }
        return this.f5005h;
    }

    public Object getItem(int i2) {
        if (this.f4998a) {
            Cursor cursor = this.f5000c;
            if (cursor != null) {
                cursor.moveToPosition(i2);
                return this.f5000c;
            }
        }
        return null;
    }

    public long getItemId(int i2) {
        if (this.f4998a) {
            Cursor cursor = this.f5000c;
            if (cursor != null && cursor.moveToPosition(i2)) {
                return this.f5000c.getLong(this.f5002e);
            }
        }
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f4998a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f5000c.moveToPosition(i2)) {
            if (view == null) {
                view = a(this.f5001d, this.f5000c, viewGroup);
            }
            a(view, this.f5001d, this.f5000c);
            return view;
        } else {
            throw new IllegalStateException(e.a.a.a.a.a("couldn't move cursor to position ", i2));
        }
    }
}
