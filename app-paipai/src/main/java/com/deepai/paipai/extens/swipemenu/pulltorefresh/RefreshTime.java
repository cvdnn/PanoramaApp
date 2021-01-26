package com.deepai.paipai.extens.swipemenu.pulltorefresh;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class RefreshTime {
    static final String PRE_NAME = "refresh_time";
    static final String SET_FRESHTIME = "set_refresh_time";

    public static String getRefreshTime(Context context) {
        return context.getSharedPreferences(PRE_NAME, 32768).getString(SET_FRESHTIME, "");
    }

    public static void setRefreshTime(Context context, String newPasswd) {
        Editor editor = context.getSharedPreferences(PRE_NAME, 32768).edit();
        editor.putString(SET_FRESHTIME, newPasswd);
        editor.commit();
    }
}
