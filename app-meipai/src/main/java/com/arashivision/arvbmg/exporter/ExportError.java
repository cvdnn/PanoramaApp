package com.arashivision.arvbmg.exporter;

public class ExportError {
    public String desc;
    public String domain;
    public int errorCode;

    private void setDesc(String str) {
        this.desc = str;
    }

    private void setDomain(String str) {
        this.domain = str;
    }

    private void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
