package e.l.a.i;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;

/* compiled from: ContactsWriteTest */
public class c {

    /* renamed from: a reason: collision with root package name */
    public ContentResolver f8943a;

    public c(ContentResolver contentResolver) {
        this.f8943a = contentResolver;
    }

    public boolean a() throws Throwable {
        ContentValues contentValues = new ContentValues();
        long parseId = ContentUris.parseId(this.f8943a.insert(RawContacts.CONTENT_URI, contentValues));
        contentValues.put("raw_contact_id", Long.valueOf(parseId));
        String str = "PERMISSION";
        contentValues.put("data1", str);
        contentValues.put("data2", str);
        contentValues.put("mimetype", "vnd.android.cursor.item/name");
        long[] jArr = {parseId, ContentUris.parseId(this.f8943a.insert(Data.CONTENT_URI, contentValues))};
        long j2 = jArr[0];
        long j3 = jArr[1];
        if (j2 <= 0 || j3 <= 0) {
            return false;
        }
        String[] strArr = {Long.toString(j3)};
        String str2 = "_id=?";
        int delete = this.f8943a.delete(Data.CONTENT_URI, str2, strArr);
        if (this.f8943a.delete(RawContacts.CONTENT_URI, str2, new String[]{Long.toString(j2)}) <= 0 || delete <= 0) {
            return false;
        }
        return true;
    }
}
