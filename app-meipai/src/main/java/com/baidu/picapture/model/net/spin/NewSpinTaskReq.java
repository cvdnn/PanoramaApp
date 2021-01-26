package com.baidu.picapture.model.net.spin;

public class NewSpinTaskReq {
    public String packageDesc;
    public String packageName;
    public PackagePropertiesBean packageProperties;
    public String productId;

    public static class PackagePropertiesBean {
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

    public String getProductId() {
        return this.productId;
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

    public void setProductId(String str) {
        this.productId = str;
    }
}
