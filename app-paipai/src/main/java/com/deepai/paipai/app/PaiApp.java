package com.deepai.paipai.app;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.deepai.library.app.BaseApp;
import com.deepai.library.support.crash.CrashHandler;
import com.deepai.library.support.net.NetChangeObserver;
import com.deepai.library.support.net.NetWorkUtil.NetType;
import com.deepai.library.support.net.NetworkStateReceiver;
import com.deepai.paipai.R;
import com.deepai.paipai.db.SQLHelper;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import org.opencv.videoio.Videoio;

public class PaiApp extends BaseApp {
    private static PaiApp application;
    public static RequestQueue vQueue;
    public MeNetChngeOberver observer = new MeNetChngeOberver();
    private SQLHelper sqlHelper;

    public class MeNetChngeOberver extends NetChangeObserver {
        public MeNetChngeOberver() {
        }

        public void onConnect(NetType type) {
            super.onConnect(type);
            switch (type) {
            }
        }

        public void onDisConnect() {
            super.onDisConnect();
        }
    }

    public void onCreate() {
        super.onCreate();
        NetworkStateReceiver.registerNetworkStateReceiver(this);
        NetworkStateReceiver.registerObserver(this.observer);
        application = this;
        vQueue = Volley.newRequestQueue(getApplicationContext());
        ImageLoader.getInstance().init(new Builder(getApplicationContext()).defaultDisplayImageOptions(new DisplayImageOptions.Builder().showImageForEmptyUri((int) R.mipmap.ssdk_recomm_def_ad_image).showImageOnFail((int) R.mipmap.ssdk_recomm_def_ad_image).cacheInMemory(true).cacheOnDisk(false).build()).memoryCacheExtraOptions(480, Videoio.CAP_PVAPI).denyCacheImageMultipleSizesInMemory().memoryCache(new LruMemoryCache(2097152)).memoryCacheSize(2097152).build());
        CrashHandler.getInstance().init(this);
    }

    public void unRegisterNetworkStateReceiver() {
        NetworkStateReceiver.removeRegisterObserver(this.observer);
        NetworkStateReceiver.unRegisterNetworkStateReceiver(getInstance());
    }

    public SQLHelper getSQLHelper() {
        if (this.sqlHelper == null) {
            this.sqlHelper = new SQLHelper(this);
        }
        return this.sqlHelper;
    }

    public static PaiApp getPaiApplication() {
        return application;
    }

    public void onTerminate() {
        super.onTerminate();
    }
}
