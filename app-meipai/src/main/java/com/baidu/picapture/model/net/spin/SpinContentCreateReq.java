package com.baidu.picapture.model.net.spin;

public class SpinContentCreateReq {
    public String contentDesc;
    public String contentName;
    public ContentPropertiesBean contentProperties;

    public static class ContentPropertiesBean {
    }

    public String getContentDesc() {
        return this.contentDesc;
    }

    public String getContentName() {
        return this.contentName;
    }

    public ContentPropertiesBean getContentProperties() {
        return this.contentProperties;
    }

    public void setContentDesc(String str) {
        this.contentDesc = str;
    }

    public void setContentName(String str) {
        this.contentName = str;
    }

    public void setContentProperties(ContentPropertiesBean contentPropertiesBean) {
        this.contentProperties = contentPropertiesBean;
    }
}
