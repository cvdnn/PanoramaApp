package com.baidubce;

public enum Protocol {
    HTTP("http", 80),
    HTTPS("https", 443);
    
    public int defaultPort;
    public String protocol;

    /* access modifiers changed from: public */
    Protocol(String str, int i2) {
        this.protocol = str;
        this.defaultPort = i2;
    }

    public int getDefaultPort() {
        return this.defaultPort;
    }

    public String toString() {
        return this.protocol;
    }
}
