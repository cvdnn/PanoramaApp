package com.baidu.sapi2.b;

import android.hardware.fingerprint.FingerprintManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;

/* compiled from: FingerprintUtil */
public class h {
    public static int a(SapiConfiguration sapiConfiguration) {
        if (!sapiConfiguration.isSupportTouchLogin()) {
            return 102;
        }
        FingerprintManager fingerprintManager = null;
        try {
            fingerprintManager = (FingerprintManager) sapiConfiguration.context.getSystemService(FingerprintManager.class);
        } catch (Exception e2) {
            Log.e(e2);
        }
        return (fingerprintManager == null || !fingerprintManager.isHardwareDetected() || !fingerprintManager.hasEnrolledFingerprints()) ? 104 : 0;
    }
}
