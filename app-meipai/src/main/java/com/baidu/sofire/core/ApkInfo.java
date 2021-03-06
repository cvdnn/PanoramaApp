package com.baidu.sofire.core;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import e.c.f.f.h;
import java.util.List;

public class ApkInfo {
    public ActivityInfo[] activities;
    public String apkMD5;
    public int apkParseSuc;
    public int applicationTheme;
    public ClassLoader classLoader;
    public String className;
    public PackageInfo cloudPkgInfo;
    public String dataDir;
    public String dexPath;
    public String downloadURL;
    public int duration;
    public Context hostContext;
    public int initStatus;
    public List<h> intentFilters;
    public boolean isMem = false;
    public boolean isNextLoad = false;
    public int isOnce;
    public int key;
    public String libPath;
    public int network;
    public String packageName;
    public String pkgPath;
    public int priority = -1;
    public String signMD5;
    public long startTime;
    public String versionName;

    public ApkInfo() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApkInfo.class != obj.getClass()) {
            return false;
        }
        ApkInfo apkInfo = (ApkInfo) obj;
        String str = this.packageName;
        if (str == null) {
            if (apkInfo.packageName != null) {
                return false;
            }
        } else if (!str.equals(apkInfo.packageName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.packageName;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public ApkInfo(int i2, String str, String str2) {
        this.key = i2;
        this.versionName = str;
        this.pkgPath = str2;
    }

    public ApkInfo(String str, String str2) {
        this.versionName = str;
        this.pkgPath = str2;
    }

    public ApkInfo(int i2, String str, String str2, String str3, String str4) {
        this.key = i2;
        this.packageName = str;
        this.versionName = str2;
        this.downloadURL = str3;
        this.apkMD5 = str4;
    }

    public ApkInfo(ApkInfo apkInfo) {
        this.key = apkInfo.key;
        this.initStatus = apkInfo.initStatus;
        this.packageName = apkInfo.packageName;
        this.versionName = apkInfo.versionName;
        this.pkgPath = apkInfo.pkgPath;
        this.hostContext = apkInfo.hostContext;
        this.libPath = apkInfo.libPath;
        this.downloadURL = apkInfo.downloadURL;
        this.apkMD5 = apkInfo.apkMD5;
        this.signMD5 = apkInfo.signMD5;
        this.activities = apkInfo.activities;
        this.dataDir = apkInfo.dataDir;
        this.dexPath = apkInfo.dexPath;
        this.className = apkInfo.className;
        this.apkParseSuc = apkInfo.apkParseSuc;
        this.applicationTheme = apkInfo.applicationTheme;
        this.intentFilters = apkInfo.intentFilters;
        this.cloudPkgInfo = apkInfo.cloudPkgInfo;
        this.startTime = apkInfo.startTime;
        this.duration = apkInfo.duration;
        this.network = apkInfo.network;
        this.isOnce = apkInfo.isOnce;
        this.priority = apkInfo.priority;
        this.isMem = apkInfo.isMem;
        this.isNextLoad = apkInfo.isNextLoad;
    }
}
