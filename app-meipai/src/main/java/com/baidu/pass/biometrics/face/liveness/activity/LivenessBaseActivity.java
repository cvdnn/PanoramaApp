package com.baidu.pass.biometrics.face.liveness.activity;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.activity.BaseActivity;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.beans.BeanDataCache;
import com.baidu.pass.biometrics.face.liveness.dto.PassFaceRecogDTO;
import e.a.a.a.a;
import java.io.Serializable;
import java.lang.reflect.Field;

public class LivenessBaseActivity extends BaseActivity {
    public PassBiometricConfiguration configuration;
    public PassFaceRecogDTO passFaceRecogDTO;

    @TargetApi(27)
    public void customLiuHai() {
        if (VERSION.SDK_INT >= 27) {
            LayoutParams attributes = getWindow().getAttributes();
            try {
                Field declaredField = attributes.getClass().getDeclaredField("layoutInDisplayCutoutMode");
                declaredField.setAccessible(true);
                Class<LayoutParams> cls = LayoutParams.class;
                declaredField.set(attributes, Integer.valueOf(cls.getField("LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES").getInt(cls)));
            } catch (Exception unused) {
            }
            getWindow().setAttributes(attributes);
        }
    }

    public String getAtbc(PassFaceRecogDTO passFaceRecogDTO2) {
        StringBuilder sb = new StringBuilder();
        if (passFaceRecogDTO2 != null) {
            StringBuilder a2 = a.a("bduss=");
            a2.append(passFaceRecogDTO2.bduss);
            sb.append(a2.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(";stoken=");
            sb2.append(passFaceRecogDTO2.stoken);
            sb.append(sb2.toString());
        }
        return sb.toString();
    }

    public String getFaceDetectUrl() {
        return a.a(new StringBuilder(), this.configuration.passDomain, PassBioEnv.FACE_DETECT_URI);
    }

    public String getPortraitContrastUrl() {
        return a.a(new StringBuilder(), this.configuration.passDomain, PassBioEnv.GET_UPLOAD_PHOTO_CONTRAST_URI);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = BeanDataCache.KEY;
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("PassFaceRecogDTO");
            if (serializable != null && (serializable instanceof PassFaceRecogDTO)) {
                this.passFaceRecogDTO = (PassFaceRecogDTO) serializable;
                BeanDataCache.getInstance().addToCache(str, this.passFaceRecogDTO);
            }
        } else {
            this.passFaceRecogDTO = (PassFaceRecogDTO) BeanDataCache.getInstance().getCacheData(str);
        }
        this.configuration = PassFaceRecogManager.getInstance().getConfiguration();
        customLiuHai();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("PassFaceRecogDTO", this.passFaceRecogDTO);
    }
}
