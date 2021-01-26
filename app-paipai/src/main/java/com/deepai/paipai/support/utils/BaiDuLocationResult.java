package com.deepai.paipai.support.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;

public class BaiDuLocationResult {
    /* access modifiers changed from: private */
    public Handler HandlerForRequestLocation = new Handler() {
        public void handleMessage(Message paramMessage) {
            if (BaiDuLocationResult.this.locationClient == null || !BaiDuLocationResult.this.locationClient.isStarted()) {
                BaiDuLocationResult.this.HandlerForRequestLocation.sendEmptyMessageDelayed(0, 1000);
            } else {
                BaiDuLocationResult.this.locationClient.requestLocation();
            }
        }
    };
    private boolean isStop = false;
    /* access modifiers changed from: private */
    public LocationClient locationClient;
    private LocationClientOption locationClientOption;

    public boolean getPositionResult(Context mContext, BDLocationListener tempBDLocationListener) {
        if (this.locationClient == null && this.locationClientOption == null) {
            this.locationClient = new LocationClient(mContext.getApplicationContext());
            this.locationClientOption = new LocationClientOption();
            this.locationClientOption.setCoorType(BDLocation.BDLOCATION_GCJ02_TO_BD09LL);
            this.locationClientOption.setLocationMode(LocationMode.Battery_Saving);
            this.locationClientOption.setAddrType("all");
            this.locationClientOption.setIsNeedAddress(true);
            this.locationClient.setLocOption(this.locationClientOption);
            this.locationClient.registerLocationListener(tempBDLocationListener);
            this.locationClient.start();
        }
        this.HandlerForRequestLocation.sendEmptyMessageDelayed(0, 1000);
        return true;
    }

    public void stopBaiduSDK() {
        if (this.locationClient != null) {
            this.locationClient.stop();
        }
    }
}
