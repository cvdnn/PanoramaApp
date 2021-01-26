package com.deepai.paipai.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBUtil {
    private static DBUtil mInstance;
    private Context mContext;
    private SQLHelper mSQLHelp;
    private SQLiteDatabase mSQLiteDatabase = this.mSQLHelp.getWritableDatabase();

    private DBUtil(Context context) {
        this.mContext = context;
        this.mSQLHelp = new SQLHelper(context);
    }

    public static DBUtil getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DBUtil(context);
        }
        return mInstance;
    }

    public void close() {
        this.mSQLHelp.close();
        this.mSQLHelp = null;
        this.mSQLiteDatabase.close();
        this.mSQLiteDatabase = null;
        mInstance = null;
    }

    public void insertData(ContentValues values) {
        this.mSQLiteDatabase.insert(SQLHelper.TABLE_PHOTO, null, values);
    }

    public void updateData(ContentValues values, String whereClause, String[] whereArgs) {
        this.mSQLiteDatabase.update(SQLHelper.TABLE_PHOTO, values, whereClause, whereArgs);
    }

    public void deleteData(String whereClause, String[] whereArgs) {
        this.mSQLiteDatabase.delete(SQLHelper.TABLE_PHOTO, whereClause, whereArgs);
    }

    public Cursor selectData(String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return this.mSQLiteDatabase.query(SQLHelper.TABLE_PHOTO, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
}
