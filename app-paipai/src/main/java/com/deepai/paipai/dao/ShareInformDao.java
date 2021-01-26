package com.deepai.paipai.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.deepai.paipai.db.SQLHelper;
import com.deepai.paipai.support.bean.SaveShareDataBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShareInformDao implements ShareInformDaoInface {
    private SQLHelper helper = null;

    public ShareInformDao(Context context) {
        this.helper = new SQLHelper(context);
    }

    public boolean addCache(SaveShareDataBean item, String type) {
        boolean flag = false;
        SQLiteDatabase database = null;
        try {
            database = this.helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(SQLHelper.PHOTOIMAGPATH, item.getPhotoImagPath());
            values.put(SQLHelper.MUSICNAME, item.getMusicName());
            values.put(SQLHelper.HIDEINFORM, item.getHideInform());
            values.put(SQLHelper.SAVETYPE, type);
            flag = database.insert(SQLHelper.TABLE_PHOTO, null, values) != -1;
            if (database != null) {
                database.close();
            }
        } catch (Exception e) {
            if (database != null) {
                database.close();
            }
        } catch (Throwable th) {
            if (database != null) {
                database.close();
            }
            throw th;
        }
        return flag;
    }

    public boolean deleteCache(String whereClause, String[] whereArgs) {
        boolean flag = false;
        SQLiteDatabase database = null;
        try {
            database = this.helper.getWritableDatabase();
            flag = database.delete(SQLHelper.TABLE_PHOTO, whereClause, whereArgs) > 0;
            if (database != null) {
                database.close();
            }
        } catch (Exception e) {
            if (database != null) {
                database.close();
            }
        } catch (Throwable th) {
            if (database != null) {
                database.close();
            }
            throw th;
        }
        return flag;
    }

    public boolean updateCache(ContentValues values, String whereClause, String[] whereArgs) {
        boolean flag = false;
        SQLiteDatabase database = null;
        try {
            database = this.helper.getWritableDatabase();
            flag = database.update(SQLHelper.TABLE_PHOTO, values, whereClause, whereArgs) > 0;
            if (database != null) {
                database.close();
            }
        } catch (Exception e) {
            if (database != null) {
                database.close();
            }
        } catch (Throwable th) {
            if (database != null) {
                database.close();
            }
            throw th;
        }
        return flag;
    }

    public Map<String, String> viewCache(String selection, String[] selectionArgs) {
        SQLiteDatabase database = null;
        HashMap hashMap = new HashMap();
        try {
            SQLiteDatabase database2 = this.helper.getReadableDatabase();
            Cursor cursor = database2.query(true, SQLHelper.TABLE_PHOTO, null, selection, selectionArgs, null, null, null, null);
            int cols_len = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                for (int i = 0; i < cols_len; i++) {
                    String cols_name = cursor.getColumnName(i);
                    String cols_values = cursor.getString(cursor.getColumnIndex(cols_name));
                    if (cols_values == null) {
                        cols_values = "";
                    }
                    hashMap.put(cols_name, cols_values);
                }
            }
            if (database2 != null) {
                database2.close();
            }
        } catch (Exception e) {
            if (database != null) {
                database.close();
            }
        } catch (Throwable th) {
            if (database != null) {
                database.close();
            }
            throw th;
        }
        return hashMap;
    }

    public List<Map<String, String>> listCache(String selection, String[] selectionArgs) {
        List<Map<String, String>> list = new ArrayList<>();
        SQLiteDatabase database = null;
        try {
            SQLiteDatabase database2 = this.helper.getReadableDatabase();
            Cursor cursor = database2.query(false, SQLHelper.TABLE_PHOTO, null, selection, selectionArgs, null, null, null, null);
            int cols_len = cursor.getColumnCount();
            while (cursor.moveToNext()) {
                HashMap hashMap = new HashMap();
                for (int i = 0; i < cols_len; i++) {
                    String cols_name = cursor.getColumnName(i);
                    String cols_values = cursor.getString(cursor.getColumnIndex(cols_name));
                    if (cols_values == null) {
                        cols_values = "";
                    }
                    hashMap.put(cols_name, cols_values);
                }
                list.add(hashMap);
            }
            if (database2 != null) {
                database2.close();
            }
        } catch (Exception e) {
            if (database != null) {
                database.close();
            }
        } catch (Throwable th) {
            if (database != null) {
                database.close();
            }
            throw th;
        }
        return list;
    }

    public void clearFeedTable() {
        this.helper.getWritableDatabase().execSQL("DELETE FROM photo_table;");
        revertSeq();
    }

    private void revertSeq() {
        this.helper.getWritableDatabase().execSQL("update sqlite_sequence set seq=0 where name='photo_table'");
    }

    public void deleteLikeData(String selection, String selectValue) {
        this.helper.getWritableDatabase().execSQL("DELETE FROM photo_table WHERE " + selection + " LIKE '" + selectValue + "';");
    }
}
