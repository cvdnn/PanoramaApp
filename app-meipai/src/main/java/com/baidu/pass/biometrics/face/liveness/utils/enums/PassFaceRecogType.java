package com.baidu.pass.biometrics.face.liveness.utils.enums;

public enum PassFaceRecogType {
    RECOG_TYPE_BDUSS("recog_type_bduss", 1),
    RECOG_TYPE_AUTHTOKEN("recog_type_authtoken", 2),
    RECOG_TYPE_CERTINFO("recog_type_certinfo", 3),
    RECOG_TYPE_FACEDETECT("recog_type_facedetect", 4),
    RECOG_TYPE_OUTER("recog_type_outer", 5);
    
    public String recogTypeName;
    public int recogTypeNum;

    /* access modifiers changed from: public */
    PassFaceRecogType(String str, int i2) {
        this.recogTypeName = str;
        this.recogTypeNum = i2;
    }

    public String getRecogTypeName() {
        return this.recogTypeName;
    }

    public int getRecogTypeNum() {
        return this.recogTypeNum;
    }
}
