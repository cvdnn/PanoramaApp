package com.baidubce.services.bos.model;

import com.baidubce.model.AbstractBceRequest;
import e.a.a.a.a;

public abstract class GenericBucketRequest extends AbstractBceRequest {
    public static final int MAX_BUCKET_NAME_LENGTH = 63;
    public static final int MIN_BUCKET_NAME_LENGTH = 3;
    public String bucketName;

    public GenericBucketRequest() {
    }

    public static boolean isLowercaseOrDigit(char c2) {
        return Character.isDigit(c2) || (c2 >= 'a' && c2 <= 'z');
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        if (str == null || str.isEmpty()) {
            this.bucketName = str;
            return;
        }
        String trim = str.trim();
        String str2 = ".";
        if (trim.length() >= 3) {
            String str3 = "Invalid bucketName:";
            if (trim.length() > 63) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(trim);
                sb.append(". bucketName should not be greater than ");
                sb.append(63);
                sb.append(str2);
                throw new IllegalArgumentException(sb.toString());
            } else if (!isLowercaseOrDigit(trim.charAt(0))) {
                throw new IllegalArgumentException(a.a(str3, trim, ". bucketName should start with a lowercase letter or digit."));
            } else if (isLowercaseOrDigit(trim.charAt(trim.length() - 1))) {
                int i2 = 1;
                while (i2 < trim.length() - 1) {
                    char charAt = trim.charAt(i2);
                    if (isLowercaseOrDigit(charAt) || charAt == '-') {
                        i2++;
                    } else {
                        throw new IllegalArgumentException(a.a(str3, trim, ". bucketName should contain only lowercase leters, digits and hyphens(-)."));
                    }
                }
                this.bucketName = trim;
            } else {
                throw new IllegalArgumentException(a.a(str3, trim, ". bucketName should end with a lowercase letter or digit."));
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid bucketNamse:");
            sb2.append(trim);
            sb2.append(". bucketName should not be less than ");
            sb2.append(3);
            sb2.append(str2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public abstract GenericBucketRequest withBucketName(String str);

    public GenericBucketRequest(String str) {
        setBucketName(str);
    }
}
