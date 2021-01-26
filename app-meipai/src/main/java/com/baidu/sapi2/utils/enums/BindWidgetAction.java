package com.baidu.sapi2.utils.enums;

public enum BindWidgetAction {
    BIND_MOBILE("/wp/bindwidget-bindmobile", "绑定手机"),
    BIND_EMAIL("/wp/bindwidget-bindemail", "绑定邮箱"),
    REBIND_MOBILE("/wp/bindwidget-rebindmobile", "换绑手机"),
    REBIND_EMAIL("/wp/bindwidget-rebindemail", "换绑邮箱"),
    UNBIND_MOBILE("/wp/bindwidget-unbindmobile", "解绑手机"),
    UNBIND_EMAIL("/wp/bindwidget-unbindemail", "解绑邮箱");
    

    /* renamed from: b reason: collision with root package name */
    public String f3046b;

    /* renamed from: c reason: collision with root package name */
    public String f3047c;

    /* access modifiers changed from: public */
    BindWidgetAction(String str, String str2) {
        this.f3046b = str;
        this.f3047c = str2;
    }

    public String getName() {
        return this.f3047c;
    }

    public String getUri() {
        return this.f3046b;
    }
}
