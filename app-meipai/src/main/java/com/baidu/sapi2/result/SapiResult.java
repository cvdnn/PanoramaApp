package com.baidu.sapi2.result;

import android.text.TextUtils;
import android.util.SparseArray;

public class SapiResult {
    public static final int ERROR_CODE_METHOD_DEPRECATED = -206;
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_PARAMS_ERROR = -204;
    public static final int ERROR_CODE_PROCESSED_END = -301;
    public static final int ERROR_CODE_SDK_NOT_INIT = -801;
    public static final int ERROR_CODE_SERVER_DATA_ERROR = -205;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_V2_SHARE_ACCOUNT_FAIL = -207;
    public static final String ERROR_MSG_METHOD_DEPRECATED = "接口已下线";
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = "网络连接不可用，请检查网络设置";
    public static final String ERROR_MSG_PARAMS_ERROR = "参数错误，请稍后再试";
    public static final String ERROR_MSG_PROCESSED_END = "您已取消操作";
    public static final String ERROR_MSG_SDK_NOT_INIT = "服务异常，请稍后再试";
    public static final String ERROR_MSG_SERVER_DATA_ERROR = "服务端数据异常，请稍后再试";
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String ERROR_MSG_UNKNOWN = "网络连接失败，请检查网络设置";
    public static final String ERROR_MSG_V2_SHARE_ACCOUNT_FAIL = "互通登录失败,请稍后再试";
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_WAPPASS_SUCCESS = 110000;
    public static final String RESULT_MSG_SUCCESS = "成功";
    public SparseArray<String> msgMap;
    public int resultCode = -202;
    public String resultMsg;

    public SapiResult() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.msgMap = sparseArray;
        String str = RESULT_MSG_SUCCESS;
        sparseArray.put(0, str);
        this.msgMap.put(110000, str);
        this.msgMap.put(-201, ERROR_MSG_NETWORK_UNAVAILABLE);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
        this.msgMap.put(-203, "网站安全证书已过期或不可信，系统时间错误可能导致此问题");
        this.msgMap.put(-204, ERROR_MSG_PARAMS_ERROR);
        this.msgMap.put(-205, ERROR_MSG_SERVER_DATA_ERROR);
        this.msgMap.put(-206, ERROR_MSG_METHOD_DEPRECATED);
        this.msgMap.put(-301, ERROR_MSG_PROCESSED_END);
        this.msgMap.put(ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, ERROR_MSG_V2_SHARE_ACCOUNT_FAIL);
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        int i2;
        SparseArray<String> sparseArray;
        if (!TextUtils.isEmpty(this.resultMsg)) {
            return this.resultMsg;
        }
        if (this.msgMap.get(this.resultCode) != null) {
            sparseArray = this.msgMap;
            i2 = this.resultCode;
        } else {
            sparseArray = this.msgMap;
            i2 = -202;
        }
        return (String) sparseArray.get(i2);
    }

    public void setResultCode(int i2) {
        this.resultCode = i2;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
