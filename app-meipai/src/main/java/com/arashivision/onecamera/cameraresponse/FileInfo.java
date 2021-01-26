package com.arashivision.onecamera.cameraresponse;

import e.a.a.a.a;

public class FileInfo {
    public byte[] extraData;
    public String mUrl;

    private void setExtraData(byte[] bArr) {
        this.extraData = bArr;
    }

    private void setUrl(String str) {
        this.mUrl = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("FileInfo{, mUrl='");
        a2.append(this.mUrl);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }
}
