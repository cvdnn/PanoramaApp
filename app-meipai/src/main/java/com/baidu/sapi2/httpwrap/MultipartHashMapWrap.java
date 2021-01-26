package com.baidu.sapi2.httpwrap;

import com.baidu.pass.http.MultipartHashMap;
import com.baidu.sapi2.utils.SapiUtils;

public class MultipartHashMapWrap extends MultipartHashMap {
    public MultipartHashMapWrap() {
        putAll(Utils.a());
    }

    public void doSign(String str) {
        put("sig", SapiUtils.calculateSig(getMap(), str));
    }
}
