package com.arashivision.insta360.basemedia.util;

import java.util.concurrent.atomic.AtomicInteger;

public class EventIdUtils {
    public static AtomicInteger IL1Iii = new AtomicInteger(0);

    public static int getEventId() {
        return IL1Iii.incrementAndGet();
    }
}
