package com.deepai.library.support.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.regex.Pattern;
import org.apache.http.protocol.HTTP;

public class Util {
    public static final int NETWORN_MOBILE = 2;
    public static final int NETWORN_NONE = 0;
    public static final int NETWORN_WIFI = 1;

    public static int getNetworkState(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connManager.getActiveNetworkInfo() == null) {
            return 0;
        }
        State state = connManager.getNetworkInfo(1).getState();
        if (state == State.CONNECTED || state == State.CONNECTING) {
            return 1;
        }
        State state2 = connManager.getNetworkInfo(0).getState();
        if (state2 == State.CONNECTED || state2 == State.CONNECTING) {
            return 2;
        }
        return 0;
    }

    public static boolean isFirstRun(Context context) {
        SharedPreferences sp = context.getSharedPreferences("isFirst", 0);
        int version = sp.getInt("version", 0);
        int appVersion = getVersionCode(context);
        if (version == appVersion) {
            return false;
        }
        sp.edit().putInt("version", appVersion).commit();
        return true;
    }

    public static int getVersionCode(Context context) {
        int z = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return z;
        }
    }

    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("获取版本号错误信息", e.getMessage());
        }
        return versionName;
    }

    public static String getAndroidIp(Context context, int type) {
        String IP = null;
        if (type == 1) {
            try {
                IP = int2ip(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress());
            } catch (Exception e) {
            }
        }
        if (type != 0) {
            return IP;
        }
        StringBuilder IPStringBuilder = new StringBuilder();
        try {
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaceEnumeration.hasMoreElements()) {
                Enumeration<InetAddress> inetAddressEnumeration = ((NetworkInterface) networkInterfaceEnumeration.nextElement()).getInetAddresses();
                while (inetAddressEnumeration.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddressEnumeration.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        IPStringBuilder.append(inetAddress.getHostAddress().toString() + "\n");
                    }
                }
            }
        } catch (SocketException e2) {
        }
        return IPStringBuilder.toString();
    }

    public static String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 255).append(".");
        sb.append((ipInt >> 8) & 255).append(".");
        sb.append((ipInt >> 16) & 255).append(".");
        sb.append((ipInt >> 24) & 255);
        return sb.toString();
    }

    public static String md5(String string) {
        try {
            byte[] hash = MessageDigest.getInstance("MD5").digest(string.getBytes(HTTP.UTF_8));
            StringBuilder hex = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                if ((b & 255) < 16) {
                    hex.append("0");
                }
                hex.append(Integer.toHexString(b & 255));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        }
    }

    public static boolean isMobileNO(String mobiles) {
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$").matcher(mobiles).matches();
    }

    public static boolean isEmail(String email) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(email).matches();
    }

    public static int dp2px(int dp, Context context) {
        return (int) TypedValue.applyDimension(1, (float) dp, context.getResources().getDisplayMetrics());
    }

    public static int dpRes2px(int dpRes, Context context) {
        return (int) TypedValue.applyDimension(1, context.getResources().getDimension(dpRes), context.getResources().getDisplayMetrics());
    }

    public static final int getWindowsWidth(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Drawable bitmap2Drawable(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static final boolean isApkInstalled(Context context, String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(packageName, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
