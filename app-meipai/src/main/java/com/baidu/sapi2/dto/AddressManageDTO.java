package com.baidu.sapi2.dto;

import com.baidu.sapi2.permissions.PermissionsDTO;

public class AddressManageDTO extends SapiWebDTO {
    public static final String ADDRESS_EDIT = "1";
    public static final String ADDRESS_LIST = "0";
    public static final String TYPE_MANAGE = "0";
    public static final String TYPE_SELECT = "1";
    public String openPageName;
    public PermissionsDTO permissionsDTO;
    public String tplse;
    public String tplt;
    public String type;

    public AddressManageDTO() {
        String str = "0";
        this.type = str;
        this.openPageName = str;
    }
}
