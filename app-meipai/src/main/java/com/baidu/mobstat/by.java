package com.baidu.mobstat;

import java.net.InetSocketAddress;

public interface by {

    public enum a {
        NOT_YET_CONNECTED,
        CONNECTING,
        OPEN,
        CLOSING,
        CLOSED
    }

    public enum b {
        CLIENT
    }

    InetSocketAddress a();

    void a(cq cqVar);
}
