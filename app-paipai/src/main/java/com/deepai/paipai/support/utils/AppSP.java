package com.deepai.paipai.support.utils;

import android.content.Context;
import com.deepai.library.support.utils.SPUtil;

public class AppSP extends SPUtil {
    private static final String BASE_FILE_NAME = "paipai360";
    private static final String KEY_BLE_ADDRESS = "lbeAddress";
    private static final String KEY_BLE_NAME = "lbeName";
    private static final String KEY_OPENED_FLAG = "opened";
    private static final String KEY_USER_EXPIRE = "Expire";
    private static final String KEY_USER_HJEAD_URL = "loginUserHeadUrl";
    private static final String KEY_USER_NAME = "loginUserName";
    private static final String KEY_USER_NUBMBER = "loginUserPhone";
    private static final String KEY_USER_TOKEN = "token";

    public static Object getBleAddress(Context context, Object defaultObject) {
        return get(context, BASE_FILE_NAME, KEY_BLE_ADDRESS, defaultObject);
    }

    public static boolean setBleAddress(Context context, Object defaultObject) {
        return set(context, BASE_FILE_NAME, KEY_BLE_ADDRESS, defaultObject);
    }

    public static Object getBleName(Context context, Object defaultObject) {
        return get(context, BASE_FILE_NAME, KEY_BLE_NAME, defaultObject);
    }

    public static boolean setBleName(Context context, Object defaultObject) {
        return set(context, BASE_FILE_NAME, KEY_BLE_NAME, defaultObject);
    }

    public static Object getToken(Context context, Object defaultObject) {
        return get(context, BASE_FILE_NAME, "token", defaultObject);
    }

    public static boolean setToken(Context context, Object defaultObject) {
        return set(context, BASE_FILE_NAME, "token", defaultObject);
    }

    public static Object getUserName(Context context, Object defaultObject) {
        return get(context, BASE_FILE_NAME, KEY_USER_NAME, defaultObject);
    }

    public static boolean setUserName(Context context, Object defaultObject) {
        return set(context, BASE_FILE_NAME, KEY_USER_NAME, defaultObject);
    }

    public static Object getUserHeadUrl(Context context, Object defaultObject) {
        return get(context, BASE_FILE_NAME, KEY_USER_HJEAD_URL, defaultObject);
    }

    public static boolean setUserHeadUrl(Context context, Object defaultObject) {
        return set(context, BASE_FILE_NAME, KEY_USER_HJEAD_URL, defaultObject);
    }

    public static Object getExpire(Context context, Object defaultObject) {
        return get(context, BASE_FILE_NAME, KEY_USER_EXPIRE, defaultObject);
    }

    public static boolean setExpire(Context context, Object defaultObject) {
        return set(context, BASE_FILE_NAME, KEY_USER_EXPIRE, defaultObject);
    }

    public static boolean getOpened(Context context) {
        return ((Boolean) get(context, BASE_FILE_NAME, KEY_OPENED_FLAG, Boolean.valueOf(false))).booleanValue();
    }

    public static boolean setOpened(Context context) {
        return set(context, BASE_FILE_NAME, KEY_OPENED_FLAG, Boolean.valueOf(true));
    }

    public static Object getUserNumber(Context context, Object defaultObject) {
        return get(context, BASE_FILE_NAME, KEY_USER_NUBMBER, defaultObject);
    }

    public static boolean setUserNumber(Context context, Object defaultObject) {
        return set(context, BASE_FILE_NAME, KEY_USER_NUBMBER, defaultObject);
    }
}
