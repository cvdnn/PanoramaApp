package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.HttpHashMap;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.Map;

public class HttpHashMapWrap extends HttpHashMap {
    public HttpHashMapWrap() {
        putAll(Utils.a());
    }

    public void doSign(String str) {
        Map map = getMap();
        if (map != null) {
            String str2 = "sig";
            if (!map.containsKey(str2)) {
                put(str2, SapiUtils.calculateSig(getMap(), str));
            }
        }
    }
}
