package com.baidu.sapi2.dto;

public class PassNameValuePair {
    public String name;
    public String value;

    public PassNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || PassNameValuePair.class != obj.getClass()) {
            return false;
        }
        PassNameValuePair passNameValuePair = (PassNameValuePair) obj;
        String str = this.name;
        if (str == null ? passNameValuePair.name != null : !str.equals(passNameValuePair.name)) {
            return false;
        }
        String str2 = this.value;
        String str3 = passNameValuePair.value;
        if (str2 != null) {
            z = str2.equals(str3);
        } else if (str3 != null) {
            z = false;
        }
        return z;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }
}
