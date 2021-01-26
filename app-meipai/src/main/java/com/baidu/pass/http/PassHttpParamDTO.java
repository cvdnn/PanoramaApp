package com.baidu.pass.http;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;

public class PassHttpParamDTO {
    public boolean asyncCookie = false;
    public int connectTimeout;
    public List<HttpCookie> cookie;
    public HashMap<String, String> headers = new HashMap<>(1);
    public HttpHashMap paramsMap = new HttpHashMap();
    public String url;
    public String userAgent;
}
