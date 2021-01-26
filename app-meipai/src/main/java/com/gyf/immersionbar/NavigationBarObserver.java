package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import java.util.ArrayList;
import java.util.Iterator;

public final class NavigationBarObserver extends ContentObserver {
    public Application mApplication;
    public Boolean mIsRegister;
    public ArrayList<OnNavigationBarListener> mListeners;

    public static class NavigationBarObserverInstance {
        public static final NavigationBarObserver INSTANCE = new NavigationBarObserver();
    }

    public static NavigationBarObserver getInstance() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    public void addOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList<>();
            }
            if (!this.mListeners.contains(onNavigationBarListener)) {
                this.mListeners.add(onNavigationBarListener);
            }
        }
    }

    public void onChange(boolean z) {
        int i2;
        super.onChange(z);
        Application application = this.mApplication;
        if (application != null && application.getContentResolver() != null) {
            ArrayList<OnNavigationBarListener> arrayList = this.mListeners;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (OSUtils.isMIUI()) {
                    i2 = Global.getInt(this.mApplication.getContentResolver(), Constants.IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW, 0);
                } else if (OSUtils.isEMUI()) {
                    boolean isEMUI3_x = OSUtils.isEMUI3_x();
                    String str = Constants.IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW;
                    i2 = !isEMUI3_x ? Global.getInt(this.mApplication.getContentResolver(), str, 0) : System.getInt(this.mApplication.getContentResolver(), str, 0);
                } else {
                    i2 = 0;
                }
                Iterator it = this.mListeners.iterator();
                while (it.hasNext()) {
                    OnNavigationBarListener onNavigationBarListener = (OnNavigationBarListener) it.next();
                    boolean z2 = true;
                    if (i2 == 1) {
                        z2 = false;
                    }
                    onNavigationBarListener.onNavigationBarChange(z2);
                }
            }
        }
    }

    public void register(Application application) {
        this.mApplication = application;
        if (application != null && application.getContentResolver() != null && !this.mIsRegister.booleanValue()) {
            Uri uri = null;
            if (OSUtils.isMIUI()) {
                uri = Global.getUriFor(Constants.IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW);
            } else if (OSUtils.isEMUI()) {
                boolean isEMUI3_x = OSUtils.isEMUI3_x();
                String str = Constants.IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW;
                if (!isEMUI3_x) {
                    uri = Global.getUriFor(str);
                } else {
                    uri = System.getUriFor(str);
                }
            }
            if (uri != null) {
                this.mApplication.getContentResolver().registerContentObserver(uri, true, this);
                this.mIsRegister = Boolean.valueOf(true);
            }
        }
    }

    public void removeOnNavigationBarListener(OnNavigationBarListener onNavigationBarListener) {
        if (onNavigationBarListener != null) {
            ArrayList<OnNavigationBarListener> arrayList = this.mListeners;
            if (arrayList != null) {
                arrayList.remove(onNavigationBarListener);
            }
        }
    }

    public NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mIsRegister = Boolean.valueOf(false);
    }
}
