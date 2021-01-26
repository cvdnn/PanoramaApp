package com.baidu.sapi2.dto;

public class InvoiceBuildDTO extends SapiWebDTO {
    public static final String TYPE_MANAGE = "0";
    public static final String TYPE_SELECT = "1";
    public String TYPE = "0";
    public boolean isExamineVAT = false;
    public boolean showCheckTag = false;
    public String tplse;
    public String tplt;
}
