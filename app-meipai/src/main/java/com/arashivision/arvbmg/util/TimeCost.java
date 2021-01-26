package com.arashivision.arvbmg.util;

import android.util.Log;
import com.arashivision.arvbmg.BMGConstants;

public class TimeCost {
    public String mTimeCostName;
    public long startTimeNs = getNanoTime();

    public TimeCost(String str) {
        this.mTimeCostName = str;
    }

    private long getNanoTime() {
        return System.nanoTime();
    }

    public static TimeCost newInstance(String str) {
        return new TimeCost(str);
    }

    public void cost() {
        long nanoTime = (getNanoTime() - this.startTimeNs) / 1000000;
        if (nanoTime > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mTimeCostName);
            sb.append(" cost ");
            sb.append(nanoTime);
            sb.append("(ms)");
            Log.i(BMGConstants.TAG, sb.toString());
        }
    }

    public void reset() {
        this.startTimeNs = System.nanoTime();
    }
}
