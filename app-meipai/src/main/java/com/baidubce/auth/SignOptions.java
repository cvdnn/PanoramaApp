package com.baidubce.auth;

import e.a.a.a.a;
import java.util.Date;
import java.util.Set;

public class SignOptions {
    public static final SignOptions DEFAULT = new SignOptions();
    public static final int DEFAULT_EXPIRATION_IN_SECONDS = 1800;
    public int expirationInSeconds = DEFAULT_EXPIRATION_IN_SECONDS;
    public Set<String> headersToSign = null;
    public Date timestamp = null;

    public int getExpirationInSeconds() {
        return this.expirationInSeconds;
    }

    public Set<String> getHeadersToSign() {
        return this.headersToSign;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setExpirationInSeconds(int i2) {
        this.expirationInSeconds = i2;
    }

    public void setHeadersToSign(Set<String> set) {
        this.headersToSign = set;
    }

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public String toString() {
        StringBuilder a2 = a.a("SignOptions [\n  headersToSign=");
        a2.append(this.headersToSign);
        a2.append(",\n  timestamp=");
        a2.append(this.timestamp);
        a2.append(",\n  expirationInSeconds=");
        return a.a(a2, this.expirationInSeconds, "]");
    }
}
