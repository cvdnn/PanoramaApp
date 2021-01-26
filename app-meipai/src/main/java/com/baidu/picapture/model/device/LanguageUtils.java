package com.baidu.picapture.model.device;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import com.baidu.picapture.App;
import e.c.d.n.e;
import java.util.LinkedHashSet;
import java.util.Locale;

public class LanguageUtils {
    public static final String AUTO = "auto";
    public static final String DEFAULT = "";
    public static final String EN_REGION = "en";
    public static final String EN_US = "en-us";
    public static final String ZH_CN = "zh-cn";
    public static final String ZH_REGION = "zh";
    public static boolean isSystemLanguageChange = false;
    public static Locale mSystemLanguage;

    public static Context attachBaseContext(Context context) {
        return VERSION.SDK_INT >= 24 ? updateResources(context) : context;
    }

    public static Locale getLocalAppLanguage(Context context) {
        String b2 = e.b(context);
        if (b2 == null || b2.equals(AUTO)) {
            if (getSystemLanguage().getLanguage().equals(ZH_REGION)) {
                return Locale.CHINA;
            }
            return Locale.US;
        } else if (b2.equals(ZH_CN)) {
            return Locale.CHINA;
        } else {
            return Locale.US;
        }
    }

    public static Locale getSystemLanguage() {
        Locale locale = mSystemLanguage;
        if (locale != null) {
            return locale;
        }
        return Locale.getDefault();
    }

    public static String getSystemLanguageValue(Locale locale) {
        return locale.getLanguage().equals(ZH_REGION) ? ZH_CN : EN_US;
    }

    public static void initContextSettingLanguage(Context context) {
        Locale locale;
        String b2 = e.b(context);
        String str = ZH_REGION;
        if (b2 == null || b2.equals(AUTO)) {
            if (getSystemLanguage().getLanguage().equals(str)) {
                locale = Locale.CHINA;
            } else {
                locale = Locale.US;
            }
        } else if (b2.startsWith(str)) {
            locale = Locale.CHINA;
        } else {
            locale = Locale.US;
        }
        setContextLanguage(context, locale);
    }

    public static boolean isChineseLanguage() {
        String d2 = e.d();
        if (d2 == null || d2.equals(AUTO)) {
            d2 = getSystemLanguageValue(getSystemLanguage());
        }
        return !d2.equals(EN_US);
    }

    public static boolean isIsSystemLanguageChange() {
        return isSystemLanguageChange;
    }

    public static void setContextLanguage(Context context, Locale locale) {
        if (context != null) {
            if (mSystemLanguage == null) {
                mSystemLanguage = getSystemLanguage();
            }
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            if (VERSION.SDK_INT >= 24) {
                LocaleList localeList = new LocaleList(new Locale[]{locale});
                LocaleList.setDefault(localeList);
                configuration.setLocales(localeList);
            } else {
                configuration.locale = locale;
            }
            resources.updateConfiguration(configuration, displayMetrics);
            updateResources(App.f1954b);
            return;
        }
        throw new NullPointerException("context cannot be null");
    }

    public static void setIsSystemLanguageChange(boolean z) {
        isSystemLanguageChange = z;
    }

    public static void setLocaleForApi24(Configuration configuration, Locale locale) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(locale);
        LocaleList localeList = LocaleList.getDefault();
        for (int i2 = 0; i2 < localeList.size(); i2++) {
            linkedHashSet.add(localeList.get(i2));
        }
        configuration.setLocales(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[0])));
    }

    public static void setSystemLanguage(Locale locale) {
        mSystemLanguage = locale;
    }

    @TargetApi(24)
    public static Context updateResources(Context context) {
        Locale localAppLanguage = getLocalAppLanguage(context);
        Locale.setDefault(localAppLanguage);
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (VERSION.SDK_INT >= 24) {
            setLocaleForApi24(configuration, localAppLanguage);
            return context.createConfigurationContext(configuration);
        }
        configuration.setLocale(localAppLanguage);
        return context.createConfigurationContext(configuration);
    }
}
