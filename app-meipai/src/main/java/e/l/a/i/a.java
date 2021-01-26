package e.l.a.i;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract.Calendars;
import java.util.TimeZone;

/* compiled from: CalendarWriteTest */
public class a {

    /* renamed from: b reason: collision with root package name */
    public static final String f8938b = e.l.a.o.a.a("5045524D495353494F4E");

    /* renamed from: c reason: collision with root package name */
    public static final String f8939c = e.l.a.o.a.a("7065726D697373696F6E40676D61696C2E636F6D");

    /* renamed from: a reason: collision with root package name */
    public ContentResolver f8940a;

    public a(Context context) {
        this.f8940a = context.getContentResolver();
    }

    public boolean a() throws Throwable {
        String str = "LOCAL";
        String str2 = "account_type";
        String str3 = "account_name";
        String str4 = "account_name=?";
        try {
            TimeZone timeZone = TimeZone.getDefault();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", f8938b);
            contentValues.put(str3, f8939c);
            contentValues.put(str2, str);
            contentValues.put("calendar_displayName", f8938b);
            contentValues.put("visible", Integer.valueOf(1));
            contentValues.put("calendar_color", Integer.valueOf(-16776961));
            contentValues.put("calendar_access_level", Integer.valueOf(700));
            contentValues.put("sync_events", Integer.valueOf(1));
            contentValues.put("calendar_timezone", timeZone.getID());
            contentValues.put("ownerAccount", f8938b);
            contentValues.put("canOrganizerRespond", Integer.valueOf(0));
            boolean z = ContentUris.parseId(this.f8940a.insert(Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter(str3, f8938b).appendQueryParameter(str2, str).build(), contentValues)) > 0;
            return z;
        } finally {
            this.f8940a.delete(Calendars.CONTENT_URI.buildUpon().build(), str4, new String[]{f8939c});
        }
    }
}
