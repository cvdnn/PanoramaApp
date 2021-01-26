package com.deepai.paipai.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    public static final String CONTENT = "content";
    public static final String DB_NAME = "database.db";
    public static final String HIDEINFORM = "hide_inform";
    public static final String ID = "id";
    public static final String MUSICNAME = "music_name";
    public static final String NAME = "name";
    public static final String PHOTOIMAGPATH = "photo_image";
    public static final String SAVETYPE = "save_type";
    public static final String TABLE_PHOTO = "photo_table";
    public static final int VERSION = 1;
    private Context context;

    public SQLHelper(Context context2) {
        super(context2, DB_NAME, null, 1);
        this.context = context2;
    }

    public Context getContext() {
        return this.context;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS photo_table(_id INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT , name TEXT , content TEXT , photo_image TEXT , music_name TEXT , hide_inform TEXT , save_type TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}
