package com.deepai.library.support.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeviceInfoUtil {
    public static Map<String, Integer> getMeminfo() {
        String str1 = "/proc/meminfo";
        Map<String, Integer> map = new HashMap<>();
        try {
            BufferedReader localBufferedReader = new BufferedReader(new FileReader(str1), 8192);
            while (true) {
                String str2 = localBufferedReader.readLine();
                if (str2 == null) {
                    break;
                }
                String[] a = str2.replace(" ", "").toLowerCase().split(":|kb");
                if (a.length == 2) {
                    map.put(a[0], Integer.valueOf(a[1]));
                }
            }
        } catch (IOException e) {
        }
        return map;
    }

    public static int getTotalMem() {
        Map<String, Integer> map = getMeminfo();
        if (map.size() > 0) {
            return (int) (((((float) ((Integer) map.get("memtotal")).intValue()) / 1204.0f) / 1024.0f) + 0.5f);
        }
        return -1;
    }
}
