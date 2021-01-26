package com.baidu.sapi2.httpwrap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.http.BinaryHttpResponseHandler;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.HttpResponseHandler;
import com.baidu.pass.http.PassHttpClient;
import com.baidu.pass.http.PassHttpParamDTO;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiDeviceUtils.DeviceCrypto;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.t;
import e.a.a.a.a;
import java.net.HttpCookie;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public class HttpClientWrap {

    /* renamed from: a reason: collision with root package name */
    public PassHttpClient f2742a = new PassHttpClient();

    /* renamed from: b reason: collision with root package name */
    public Context f2743b;

    /* renamed from: c reason: collision with root package name */
    public String f2744c;

    /* renamed from: d reason: collision with root package name */
    public String f2745d;

    public HttpClientWrap() {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (confignation != null) {
            this.f2743b = confignation.context;
            this.f2744c = confignation.environment.getURL();
            this.f2745d = confignation.appSignKey;
        }
    }

    public void cancelRequest() {
        PassHttpClient passHttpClient = this.f2742a;
        if (passHttpClient != null) {
            passHttpClient.cancelRequests(true);
        }
    }

    public void get(String str, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, null, httpHandlerWrap);
    }

    /* access modifiers changed from: private */
    public void a(HttpHandlerWrap httpHandlerWrap, Throwable th, String str) {
        int i2;
        if (th == null || !SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
            i2 = -202;
        } else {
            i2 = -203;
            t.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"));
        }
        httpHandlerWrap.onFailure(th, i2, str);
    }

    public void get(String str, List<HttpCookie> list, HttpHandlerWrap httpHandlerWrap) {
        get(str, null, list, null, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, hashMap, null, null, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, null, list, str2, 0, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, HttpHandlerWrap httpHandlerWrap) {
        post(str, httpHashMap, null, list, str2, 0, httpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, List<HttpCookie> list, String str2, int i2, HttpHandlerWrap httpHandlerWrap) {
        get(str, httpHashMap, null, list, str2, i2, httpHandlerWrap);
    }

    public void post(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2, final HttpHandlerWrap httpHandlerWrap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                httpHandlerWrap.onStart();
            }
        });
        if (a(httpHandlerWrap)) {
            PassHttpClient passHttpClient = this.f2742a;
            Context context = this.f2743b;
            PassHttpParamDTO a2 = a(str, httpHashMap, hashMap, list, str2, i2);
            final HttpHandlerWrap httpHandlerWrap2 = httpHandlerWrap;
            final String str3 = str;
            AnonymousClass5 r2 = new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) {
                public void onFailure(Throwable th, String str) {
                    HttpClientWrap.this.a(httpHandlerWrap2, th, str);
                }

                public void onFinish() {
                    httpHandlerWrap2.onFinish();
                }

                public void onStart() {
                }

                public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                    try {
                        httpHandlerWrap2.onSuccess(i2, str, hashMap);
                    } catch (Throwable th) {
                        onFailure(th, str);
                        if (!TextUtils.isEmpty(str3)) {
                            t.a("http_client_response_error", Collections.singletonMap("url", DeviceCrypto.base64Encode(str3.getBytes())));
                        }
                    }
                }
            };
            passHttpClient.post(context, a2, r2);
        }
    }

    public void get(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2, final HttpHandlerWrap httpHandlerWrap) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                httpHandlerWrap.onStart();
            }
        });
        if (a(httpHandlerWrap)) {
            PassHttpClient passHttpClient = this.f2742a;
            Context context = this.f2743b;
            PassHttpParamDTO a2 = a(str, httpHashMap, hashMap, list, str2, i2);
            final HttpHandlerWrap httpHandlerWrap2 = httpHandlerWrap;
            final String str3 = str;
            AnonymousClass2 r2 = new HttpResponseHandler(Looper.getMainLooper(), httpHandlerWrap.isExecutCallbackInChildThread()) {
                public void onFailure(Throwable th, String str) {
                    HttpClientWrap.this.a(httpHandlerWrap2, th, str);
                }

                public void onFinish() {
                    httpHandlerWrap2.onFinish();
                }

                public void onStart() {
                }

                public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                    try {
                        httpHandlerWrap2.onSuccess(i2, str, hashMap);
                    } catch (Throwable th) {
                        onFailure(th, str);
                        if (!TextUtils.isEmpty(str3)) {
                            t.a("http_client_response_error", Collections.singletonMap("url", DeviceCrypto.base64Encode(str3.getBytes())));
                        }
                    }
                }
            };
            passHttpClient.get(context, a2, r2);
        }
    }

    private boolean a(HttpHandlerWrap httpHandlerWrap) {
        Context context = this.f2743b;
        if (context == null) {
            httpHandlerWrap.onFailure(null, SapiResult.ERROR_CODE_SDK_NOT_INIT, "服务异常，请稍后再试");
            httpHandlerWrap.onFinish();
            return false;
        } else if (SapiUtils.hasActiveNetwork(context)) {
            return true;
        } else {
            httpHandlerWrap.onFailure(null, -201, SapiResult.ERROR_MSG_NETWORK_UNAVAILABLE);
            httpHandlerWrap.onFinish();
            return false;
        }
    }

    public void get(String str, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        get(str, (HttpHashMap) null, null, null, (String) null, 0, binaryHttpHandlerWrap);
    }

    public void get(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2, BinaryHttpHandlerWrap binaryHttpHandlerWrap) {
        BinaryHttpHandlerWrap binaryHttpHandlerWrap2 = binaryHttpHandlerWrap;
        binaryHttpHandlerWrap.onStart();
        if (a(binaryHttpHandlerWrap2)) {
            PassHttpClient passHttpClient = this.f2742a;
            Context context = this.f2743b;
            PassHttpParamDTO a2 = a(str, httpHashMap, hashMap, list, str2, i2);
            final BinaryHttpHandlerWrap binaryHttpHandlerWrap3 = binaryHttpHandlerWrap;
            final String str3 = str;
            AnonymousClass3 r0 = new BinaryHttpResponseHandler(Looper.getMainLooper(), binaryHttpHandlerWrap2.allowedContentTypes, binaryHttpHandlerWrap.isExecutCallbackInChildThread()) {
                public void onFailure(Throwable th, String str) {
                    HttpClientWrap.this.a(binaryHttpHandlerWrap3, th, str);
                }

                public void onFinish() {
                    binaryHttpHandlerWrap3.onFinish();
                }

                public void onStart() {
                }

                public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
                    try {
                        binaryHttpHandlerWrap3.onSuccess(i2, str, hashMap);
                    } catch (Throwable th) {
                        onFailure(th, str);
                        if (!TextUtils.isEmpty(str3)) {
                            t.a("http_client_response_error", Collections.singletonMap("url", DeviceCrypto.base64Encode(str3.getBytes())));
                        }
                    }
                }
            };
            passHttpClient.get(context, a2, r0);
        }
    }

    private PassHttpParamDTO a(String str, HttpHashMap httpHashMap, HashMap<String, String> hashMap, List<HttpCookie> list, String str2, int i2) {
        PassHttpParamDTO passHttpParamDTO = new PassHttpParamDTO();
        if (str != null && !str.contains("://")) {
            str = a.a(new StringBuilder(), this.f2744c, str);
        }
        passHttpParamDTO.url = str;
        if (httpHashMap != null) {
            httpHashMap.doSign(this.f2745d);
        }
        passHttpParamDTO.paramsMap = httpHashMap;
        passHttpParamDTO.headers = hashMap;
        passHttpParamDTO.cookie = list;
        passHttpParamDTO.userAgent = str2;
        passHttpParamDTO.connectTimeout = i2;
        passHttpParamDTO.asyncCookie = SapiContext.getInstance().getAsyncCookie();
        return passHttpParamDTO;
    }
}
