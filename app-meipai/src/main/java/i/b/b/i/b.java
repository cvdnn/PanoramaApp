package i.b.b.i;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: FastCursor */
public final class b implements Cursor {

    /* renamed from: a reason: collision with root package name */
    public final CursorWindow f9822a;

    /* renamed from: b reason: collision with root package name */
    public int f9823b;

    /* renamed from: c reason: collision with root package name */
    public final int f9824c;

    public b(CursorWindow cursorWindow) {
        this.f9822a = cursorWindow;
        this.f9824c = cursorWindow.getNumRows();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    public void deactivate() {
        throw new UnsupportedOperationException();
    }

    public byte[] getBlob(int i2) {
        return this.f9822a.getBlob(this.f9823b, i2);
    }

    public int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndex(String str) {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public String getColumnName(int i2) {
        throw new UnsupportedOperationException();
    }

    public String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        return this.f9822a.getNumRows();
    }

    public double getDouble(int i2) {
        return this.f9822a.getDouble(this.f9823b, i2);
    }

    public Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    public float getFloat(int i2) {
        return this.f9822a.getFloat(this.f9823b, i2);
    }

    public int getInt(int i2) {
        return this.f9822a.getInt(this.f9823b, i2);
    }

    public long getLong(int i2) {
        return this.f9822a.getLong(this.f9823b, i2);
    }

    public Uri getNotificationUri() {
        return null;
    }

    public int getPosition() {
        return this.f9823b;
    }

    public short getShort(int i2) {
        return this.f9822a.getShort(this.f9823b, i2);
    }

    public String getString(int i2) {
        return this.f9822a.getString(this.f9823b, i2);
    }

    public int getType(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    public boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    public boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    public boolean isFirst() {
        return this.f9823b == 0;
    }

    public boolean isLast() {
        return this.f9823b == this.f9824c - 1;
    }

    public boolean isNull(int i2) {
        return this.f9822a.isNull(this.f9823b, i2);
    }

    public boolean move(int i2) {
        return moveToPosition(this.f9823b + i2);
    }

    public boolean moveToFirst() {
        this.f9823b = 0;
        if (this.f9824c > 0) {
            return true;
        }
        return false;
    }

    public boolean moveToLast() {
        int i2 = this.f9824c;
        if (i2 <= 0) {
            return false;
        }
        this.f9823b = i2 - 1;
        return true;
    }

    public boolean moveToNext() {
        int i2 = this.f9823b;
        if (i2 >= this.f9824c - 1) {
            return false;
        }
        this.f9823b = i2 + 1;
        return true;
    }

    public boolean moveToPosition(int i2) {
        if (i2 < 0 || i2 >= this.f9824c) {
            return false;
        }
        this.f9823b = i2;
        return true;
    }

    public boolean moveToPrevious() {
        int i2 = this.f9823b;
        if (i2 <= 0) {
            return false;
        }
        this.f9823b = i2 - 1;
        return true;
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    public boolean requery() {
        throw new UnsupportedOperationException();
    }

    public Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }
}
