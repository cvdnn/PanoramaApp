package com.baidu.picapture.model.net.spin;

public class SpinContentCreateResp {
    public String contentDesc;
    public String contentId;
    public String contentName;
    public ContentPropertiesBean contentProperties;
    public String materialUuid;

    public static class ContentPropertiesBean {
    }

    public String getContentDesc() {
        return this.contentDesc;
    }

    public String getContentId() {
        return this.contentId;
    }

    public String getContentName() {
        return this.contentName;
    }

    public ContentPropertiesBean getContentProperties() {
        return this.contentProperties;
    }

    public String getMaterialUuid() {
        return this.materialUuid;
    }

    public void setContentDesc(String str) {
        this.contentDesc = str;
    }

    public void setContentId(String str) {
        this.contentId = str;
    }

    public void setContentName(String str) {
        this.contentName = str;
    }

    public void setContentProperties(ContentPropertiesBean contentPropertiesBean) {
        this.contentProperties = contentPropertiesBean;
    }

    public void setMaterialUuid(String str) {
        this.materialUuid = str;
    }
}
