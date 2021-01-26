package com.deepai.library.support.utils;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

public class FormatUtil {
    public static String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    }

    public static String getTime(Date date, String formatStr) {
        return new SimpleDateFormat(formatStr).format(date);
    }

    public static long getTimestamp() {
        long time = 0;
        try {
            return new Date().getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return time;
        }
    }

    public static long getTimestamp(Date date) {
        long time = 0;
        try {
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return time;
        }
    }

    public static String timeFormat(long infos, String format) {
        return new SimpleDateFormat(format).format(new Date(infos));
    }

    public static long parseDate1(String string) {
        long l = 0;
        try {
            return new SimpleDateFormat("yyyy年MM月dd日").parse(string).getTime();
        } catch (ParseException e) {
            Log.e("-----", "时间解析错误");
            return l;
        }
    }

    public static Date timeFormat(int dayNum) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(new Date());
        ca.add(5, dayNum);
        return ca.getTime();
    }

    public static String stringPattern(String date, String oldPattern, String newPattern) {
        if (date == null || oldPattern == null || newPattern == null) {
            return "";
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern);
        SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern);
        Date d = null;
        try {
            d = sdf1.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdf2.format(d);
    }

    public static String toJson(Object obj) {
        return new Gson().toJson(obj);
    }

    public static <T> T fromJson(String str, Type type) {
        return new Gson().fromJson(str, type);
    }

    public static <T> T fromJson(String str, Class<T> type) throws JsonSyntaxException {
        return new Gson().fromJson(str, type);
    }

    public static <T> List<T> jsonToList(String str, Class<T[]> clazz) throws JsonSyntaxException {
        return new ArrayList(Arrays.asList((Object[]) new Gson().fromJson(str, clazz)));
    }

    public static String getStringFromJson(String jsonStr, String name, String key, String value) throws JSONException {
        String str = "";
        JSONObject jsonObject = new JSONObject(jsonStr);
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return jsonObject.getString(name);
        }
        if (jsonObject.getString(key).equals(value)) {
            return jsonObject.getString(name);
        }
        return str;
    }

    public static boolean getStringFromJson(String jsonStr, String key, String value) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonStr);
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value) || !jsonObject.getString(key).equals(value)) {
            return false;
        }
        return true;
    }

    public static String decimalFormat(float f) {
        return new DecimalFormat("0.00").format((double) f);
    }

    public static String decimalFormat(float f, String formatStr) {
        return new DecimalFormat(formatStr).format((double) f);
    }

    public static String dbDecimalFormat(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    public static String dbDecimalFormat(double d, String formatStr) {
        return new DecimalFormat(formatStr).format(d);
    }

    public static boolean isNumeric(String str) {
        if (!Pattern.compile("[0-9]*").matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static boolean isMobileNO(String mobiles) {
        return Pattern.compile("[1][34578]\\d{9}").matcher(mobiles).matches();
    }

    public static boolean isIdentify(String identify) {
        return Pattern.compile("\\d{6}").matcher(identify).matches();
    }

    public static boolean isUserName(String identify) {
        return Pattern.compile("^[\\w_-]{3,15}$").matcher(identify).matches();
    }

    public static boolean isEmail(String email) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(email).matches();
    }

    public static String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 255).append(".");
        sb.append((ipInt >> 8) & 255).append(".");
        sb.append((ipInt >> 16) & 255).append(".");
        sb.append((ipInt >> 24) & 255);
        return sb.toString();
    }

    public static byte[] strToByteArray(String str) throws UnsupportedEncodingException {
        return str.getBytes(HTTP.UTF_8);
    }

    public static String byteArrayToString(byte[] b) throws UnsupportedEncodingException {
        return new String(b, HTTP.UTF_8);
    }

    public static String getWeekOfDate(Date date) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(7) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    public static String getWeekOfDate(long time) {
        Date date = new Date(time);
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(7) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }
}
