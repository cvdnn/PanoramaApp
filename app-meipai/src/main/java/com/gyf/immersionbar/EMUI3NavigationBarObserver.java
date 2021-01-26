package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import java.util.ArrayList;
import java.util.Iterator;

public final class EMUI3NavigationBarObserver extends ContentObserver {
    public Application mApplication;
    public ArrayList<ImmersionCallback> mCallbacks;
    public Boolean mIsRegister;

    public static class NavigationBarObserverInstance {
        public static final EMUI3NavigationBarObserver INSTANCE = new EMUI3NavigationBarObserver();
    }

    public static EMUI3NavigationBarObserver getInstance() {
        return NavigationBarObserverInstance.INSTANCE;
    }

    public void addOnNavigationBarListener(ImmersionCallback immersionCallback) {
        if (immersionCallback != null) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new ArrayList<>();
            }
            if (!this.mCallbacks.contains(immersionCallback)) {
                this.mCallbacks.add(immersionCallback);
            }
        }
    }

    public void onChange(boolean z) {
        super.onChange(z);
        Application application = this.mApplication;
        if (application != null && application.getContentResolver() != null) {
            ArrayList<ImmersionCallback> arrayList = this.mCallbacks;
            if (arrayList != null && !arrayList.isEmpty()) {
                int i2 = System.getInt(this.mApplication.getContentResolver(), Constants.IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW, 0);
                Iterator it = this.mCallbacks.iterator();
                while (it.hasNext()) {
                    ImmersionCallback immersionCallback = (ImmersionCallback) it.next();
                    boolean z2 = true;
                    if (i2 == 1) {
                        z2 = false;
                    }
                    immersionCallback.onNavigationBarChange(z2);
                }
            }
        }
    }

    public void register(Application application) {
        this.mApplication = application;
        if (application != null && application.getContentResolver() != null && !this.mIsRegister.booleanValue()) {
            Uri uriFor = System.getUriFor(Constants.IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW);
            if (uriFor != null) {
                this.mApplication.getContentResolver().registerContentObserver(uriFor, true, this);
                this.mIsRegister = Boolean.valueOf(true);
            }
        }
    }

    public void removeOnNavigationBarListener(ImmersionCallback immersionCallback) {
        if (immersionCallback != null) {
            ArrayList<ImmersionCallback> arrayList = this.mCallbacks;
            if (arrayList != null) {
                arrayList.remove(immersionCallback);
            }
        }
    }

    public EMUI3NavigationBarObserver() {
        super(new Handler(Looper.getMainLooper()));
        this.mIsRegister = Boolean.valueOf(false);
    }
}
