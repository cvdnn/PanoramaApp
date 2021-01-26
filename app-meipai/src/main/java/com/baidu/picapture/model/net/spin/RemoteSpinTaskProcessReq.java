package com.baidu.picapture.model.net.spin;

public class RemoteSpinTaskProcessReq {
    public String materialName;
    public String materialType;
    public String materialUrl;
    public String source;
    public long storageBytes;

    public String getMaterialName() {
        return this.materialName;
    }

    public String getMaterialType() {
        return this.materialType;
    }

    public String getMaterialUrl() {
        return this.materialUrl;
    }

    public String getSource() {
        return this.source;
    }

    public long getStorageBytes() {
        return this.storageBytes;
    }

    public void setMaterialName(String str) {
        this.materialName = str;
    }

    public void setMaterialType(String str) {
        this.materialType = str;
    }

    public void setMaterialUrl(String str) {
        this.materialUrl = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setStorageBytes(long j2) {
        this.storageBytes = j2;
    }
}
