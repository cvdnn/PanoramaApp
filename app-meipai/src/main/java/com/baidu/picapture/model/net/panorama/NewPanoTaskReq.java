package com.baidu.picapture.model.net.panorama;

public class NewPanoTaskReq {
    public String imageUrl;
    public String packageDesc;
    public String packageName;
    public PackagePropertiesBean packageProperties;
    public long storageBytes;

    public static class PackagePropertiesBean {
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getPackageDesc() {
        return this.packageDesc;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public PackagePropertiesBean getPackageProperties() {
        return this.packageProperties;
    }

    public long getStorageBytes() {
        return this.storageBytes;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setPackageDesc(String str) {
        this.packageDesc = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPackageProperties(PackagePropertiesBean packagePropertiesBean) {
        this.packageProperties = packagePropertiesBean;
    }

    public void setStorageBytes(long j2) {
        this.storageBytes = j2;
    }
}
