package com.baidu.picapture.model.nativeapi;

import java.util.List;

public class PermissionRequest {
    public List<String> permissions;
    public String rationale;

    public List<String> getPermissions() {
        return this.permissions;
    }

    public String getRationale() {
        return this.rationale;
    }

    public void setPermissions(List<String> list) {
        this.permissions = list;
    }

    public void setRationale(String str) {
        this.rationale = str;
    }
}
