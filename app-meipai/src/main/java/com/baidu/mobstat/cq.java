package com.baidu.mobstat;

import java.nio.ByteBuffer;

public interface cq {

    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    void a(cq cqVar) throws ci;

    ByteBuffer c();

    boolean d();

    boolean e();

    a f();
}
