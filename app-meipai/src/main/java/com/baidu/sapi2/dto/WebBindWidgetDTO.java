package com.baidu.sapi2.dto;

import com.baidu.sapi2.utils.enums.BindWidgetAction;

public class WebBindWidgetDTO extends SapiWebDTO {
    public String bduss;
    public BindWidgetAction bindWidgetAction;
    public boolean handleLogin = false;
}
