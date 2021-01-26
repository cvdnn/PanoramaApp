package com.arashivision.sdkcamera;

import android.app.Application;
import com.arashivision.insta360.basecamera.CameraModule;
import com.arashivision.insta360.basecamera.camera.CameraManager;
import com.arashivision.sdkcamera.camera.InstaCameraManager;
import j.a.a.b.g;
import j.a.a.b.h;

public class InstaCameraSDK {
    public static void init(Application application) {
        CameraModule.init(application);
        InstaCameraManager instance = InstaCameraManager.getInstance();
        if (instance != null) {
            CameraManager.getInstance().setConfiguration(new h());
            CameraManager.getInstance().setBaseCameraChangedCallback(new g(instance));
            return;
        }
        throw null;
    }
}
