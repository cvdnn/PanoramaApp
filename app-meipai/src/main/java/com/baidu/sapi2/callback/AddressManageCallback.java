package com.baidu.sapi2.callback;

import android.app.Activity;
import com.baidu.sapi2.permissions.AlertDialogInterface;
import com.baidu.sapi2.result.AddressManageResult;
import com.baidu.sapi2.views.CustomAlertDialog;

public abstract class AddressManageCallback {

    public static abstract class VoiceRecognitionResult {
        public abstract void onVoiceResult(String str);

        public abstract void onVolumeResult(int i2);
    }

    public void activityOnCreate() {
    }

    public void activityOnDestory() {
    }

    public void activityOnPause() {
    }

    public void activityOnResume() {
    }

    public AlertDialogInterface getDialog(Activity activity) {
        return new CustomAlertDialog(activity);
    }

    public abstract void onFinish(AddressManageResult addressManageResult);

    public void onStartSpeech(VoiceRecognitionResult voiceRecognitionResult) {
    }

    public void onStopSpeech() {
    }
}
