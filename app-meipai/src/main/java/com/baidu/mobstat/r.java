package com.baidu.mobstat;

import android.content.ContentValues;
import android.database.Cursor;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.util.ArrayList;

public class r extends j {
    public r() {
        super("app_trace3", "Create table if not exists app_trace3(_id Integer primary key AUTOINCREMENT,time VARCHAR(50),content TEXT);");
    }

    public ArrayList<i> a(int i2, int i3) {
        Cursor a2 = a(LogBuilder.KEY_TIME, i2, i3);
        ArrayList<i> a3 = a(a2);
        if (a2 != null) {
            a2.close();
        }
        return a3;
    }

    public boolean b(long j2) {
        return a(j2);
    }

    public long a(String str, String str2) {
        String str3 = LogBuilder.KEY_TIME;
        String str4 = Config.LAUNCH_CONTENT;
        Cursor a2 = a(str4, str2, str3, 1);
        ArrayList a3 = a(a2);
        if (a2 != null) {
            a2.close();
        }
        if (a3.size() != 0) {
            return ((i) a3.get(0)).a();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(str3, str);
        contentValues.put(str4, str2);
        return a(contentValues);
    }

    private ArrayList<i> a(Cursor cursor) {
        ArrayList<i> arrayList = new ArrayList<>();
        if (cursor == null || cursor.getCount() == 0) {
            return arrayList;
        }
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex(LogBuilder.KEY_TIME);
        int columnIndex3 = cursor.getColumnIndex(Config.LAUNCH_CONTENT);
        while (cursor.moveToNext()) {
            arrayList.add(new i(cursor.getLong(columnIndex), cursor.getString(columnIndex2), cursor.getString(columnIndex3)));
        }
        return arrayList;
    }
}
