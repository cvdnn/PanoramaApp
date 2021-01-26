package com.deepai.paipai.app;

public class AppConstant {
    public static final String BASEUSERSERVICEURL = "http://www.paipai360.cn/paipai360/";
    public static final String BASEUSERSERVICEURL_HEADER = "http://www.paipai360.cn/paipai360/userLoginAndRegister/upUserHead.action";
    public static final String BASEUSERSERVICEURL_LOGIN = "http://www.paipai360.cn/paipai360/userLoginAndRegister/dologin.action";
    public static final String BASEUSERSERVICEURL_LOGOUT = "http://www.paipai360.cn/paipai360/userLoginAndRegister/logout.action";
    public static final String BASEUSERSERVICEURL_NAME = "http://www.paipai360.cn/paipai360/userLoginAndRegister/upUserName.action";
    public static final String BASEUSERSERVICEURL_NET_WORKS = "http://www.paipai360.cn/paipai360/production/getMyProductions.action";
    public static final String BASEUSERSERVICEURL_REFRESH = "http://www.paipai360.cn/paipai360/userLoginAndRegister/refresh.action";
    public static final String BASEUSERSERVICEURL_THIRD_LOGIN = "http://www.paipai360.cn/paipai360/userLoginAndRegister/dothirdlogin.action";
    public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String DELETE_COMMENT_LIST = "http://www.paipai360.cn/paipai360/paipaicomments/desubmitComments.action";
    public static final String DELETE_UPLOADIMAGE = "http://www.paipai360.cn/paipai360/production/delProduction.action";
    public static final String FAIL = "fail";
    public static final String GET_COMMENT_LIST = "http://www.paipai360.cn/paipai360/paipaicomments/submitComments.action";
    public static final String SEND_CHECK_CODE = "http://www.paipai360.cn/paipai360/userLoginAndRegister/fPwdSendCoad.action";
    public static final String SUCCESS = "success";
    public static final String UPDATE_PASSWORD = "http://www.paipai360.cn/paipai360/userLoginAndRegister/fPwdUpPassword.action";
    public static final String USER_PHONE_REGISTER = "http://www.paipai360.cn/paipai360/userLoginAndRegister/userPhoneRegister.action";
    public static final String VERIFY_CHECK_CODE = "http://www.paipai360.cn/paipai360/userLoginAndRegister/fPwdValiCoad.action";
    public static final String VERIFY_PHONE_NUM = "http://www.paipai360.cn/paipai360/userLoginAndRegister/checkPhoneMail.action";

    public class RequestKey {
        public static final String LATITUDE = "latitude";
        public static final String LOGIN_NAME = "loginname";
        public static final String LONGITUDE = "longitude";
        public static final String PASSWORD = "passwd";
        public static final String TOKEN = "token";

        public RequestKey() {
        }
    }
}
