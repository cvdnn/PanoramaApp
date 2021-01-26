package com.baidu.picapture.model.net.panorama;

public class NewPanoTaskResp {
    public DataBean data;
    public int error_code;
    public String error_msg;

    public static class DataBean {
        public String packageDesc;
        public String packageId;
        public String packageName;
        public PackagePropertiesBean packageProperties;

        public static class PackagePropertiesBean {
        }

        public String getPackageDesc() {
            return this.packageDesc;
        }

        public String getPackageId() {
            return this.packageId;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public PackagePropertiesBean getPackageProperties() {
            return this.packageProperties;
        }

        public void setPackageDesc(String str) {
            this.packageDesc = str;
        }

        public void setPackageId(String str) {
            this.packageId = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setPackageProperties(PackagePropertiesBean packagePropertiesBean) {
            this.packageProperties = packagePropertiesBean;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public int getErrorCode() {
        return this.error_code;
    }

    public String getErrorMsg() {
        return this.error_msg;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setErrorCode(int i2) {
        this.error_code = i2;
    }

    public void setErrorMsg(String str) {
        this.error_msg = str;
    }
}
