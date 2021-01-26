package com.baidubce.services.bos.model;

import com.baidubce.util.CheckUtils;

public abstract class GenericObjectRequest extends GenericBucketRequest {
    public static final int MAX_OBJECT_KEY_LENGTH = 1024;
    public static final int MIN_OBJECT_KEY_LENGTH = 0;
    public String key;

    public GenericObjectRequest() {
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        CheckUtils.isNotNull(str, "key should not be null.");
        String str2 = ".";
        String str3 = "Invalid objectKey:";
        if (str.length() < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            sb.append(". objectKey should not be less than ");
            sb.append(0);
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        } else if (str.length() <= 1024) {
            this.key = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(str);
            sb2.append(". objectKey should not be greater than ");
            sb2.append(1024);
            sb2.append(str2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public abstract GenericObjectRequest withKey(String str);

    public GenericObjectRequest(String str, String str2) {
        super(str);
        setKey(str2);
    }
}
