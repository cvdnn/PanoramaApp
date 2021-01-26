package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.arashivision.onecamera.OneDriverInfo.Options;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LoadSo {
    public static final String[] SO_NAME_ARRAY = {"bd_idl_pass_token", "idl_license", "FaceSDK"};
    public static final String ZIP_VERSION = "3.0.0";
    public Bundle bundle;
    public Context context;
    public StatService statService;

    public class StatService {
        public static final String EXCEPTION_INFO = "exception_info";
        public static final String EXCEPTION_ZIP_VERSION = "execption_zip_version";
        public static final String HOST_VERSION = "host_version";
        public static final String LIVENESS_CUID = "bio_cuid";
        public static final String LIVENESS_DEVICE_MODEL = "device_model";
        public static final String LIVENESS_PHONO_SYS = "phone_sys";
        public static final String LIVENESS_PROCESS_ID = "bio_processid";
        public static final String LIVENESS_SUBPRO = "liveness_subpro";
        public static final String LIVENESS_TPL = "tpl";
        public static final String LOAD_DEFAULT_SO = "load_default_so";
        public static final String LOAD_DOWNLOAD_SO_SUC = "load_download_so_suc";
        public static final String LOAD_SO_SUCCESS = "load_so_success";
        public static final String MODLE_NAME = "modle_name";
        public static final String STAT_NAME_LIVENESS_FACE = "sapi_bio_dynamic_load_so";
        public static final String ZIP_VERSION = "zip_version";
        public String exceptionInfo;
        public String execptionZipVersion;
        public String hostVersion;
        public boolean loadDefaultSo;
        public boolean loadDownloadSoSuc;
        public boolean loadSoSuccess;
        public String productId;
        public String tpl;
        public String uuid;
        public String zipVersion;

        public StatService() {
            this.loadDefaultSo = false;
            this.loadDownloadSoSuc = true;
        }

        private Map<String, String> prepareData() {
            String str = "tpl";
            if (LoadSo.this.bundle != null) {
                this.uuid = LoadSo.this.bundle.getString(Options.ONE_UUID);
                this.tpl = LoadSo.this.bundle.getString(str);
                this.productId = LoadSo.this.bundle.getString("productId");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host_version", this.hostVersion);
            hashMap.put("zip_version", this.zipVersion);
            boolean z = this.loadDefaultSo;
            String str2 = "1";
            String str3 = LivenessStat.TYPE_STRING_DEFAULT;
            hashMap.put(LOAD_DEFAULT_SO, z ? str2 : str3);
            hashMap.put(LOAD_SO_SUCCESS, this.loadSoSuccess ? str2 : str3);
            if (!this.loadDownloadSoSuc) {
                str2 = str3;
            }
            hashMap.put(LOAD_DOWNLOAD_SO_SUC, str2);
            hashMap.put("exception_info", this.exceptionInfo);
            hashMap.put(EXCEPTION_ZIP_VERSION, this.execptionZipVersion);
            hashMap.put(LIVENESS_PROCESS_ID, this.uuid);
            hashMap.put(LIVENESS_SUBPRO, this.productId);
            hashMap.put(str, this.tpl);
            hashMap.put(LIVENESS_CUID, PassBiometricUtil.getClientId(LoadSo.this.context));
            hashMap.put(LIVENESS_DEVICE_MODEL, PassBiometricUtil.getOSModel());
            hashMap.put(LIVENESS_PHONO_SYS, PassBiometricUtil.getOSVersion());
            return hashMap;
        }

        /* access modifiers changed from: private */
        public void startStatService() {
            com.baidu.pass.biometrics.base.utils.StatService.onEvent(LoadSo.this.context, STAT_NAME_LIVENESS_FACE, prepareData());
        }
    }

    public static boolean inWhitePkgLoadDefaultSO(Context context2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.BaiduMap(.*)");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (context2.getPackageName().matches((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private void loadDefaultSo() {
        for (String loadLibrary : SO_NAME_ARRAY) {
            System.loadLibrary(loadLibrary);
        }
        this.statService.loadDefaultSo = true;
    }

    private void loadPathSo(SdkConfigOptions sdkConfigOptions) {
        String[] strArr;
        boolean z = false;
        try {
            for (String str : SO_NAME_ARRAY) {
                StringBuilder sb = new StringBuilder();
                sb.append(LocalConfigOptions.getLoadSoPath(this.context));
                sb.append("/lib");
                sb.append(str);
                sb.append(".so");
                System.load(sb.toString());
            }
            this.statService.zipVersion = sdkConfigOptions.zipVersion;
            z = true;
        } catch (Throwable th) {
            this.statService.loadDownloadSoSuc = false;
            this.statService.zipVersion = sdkConfigOptions.zipVersion;
            this.statService.exceptionInfo = Log.getStackTraceString(th);
            this.statService.execptionZipVersion = sdkConfigOptions.zipVersion;
        }
        if (!z) {
            loadDefaultSo();
        }
    }

    public boolean load(Context context2, Bundle bundle2) {
        this.context = context2;
        StatService statService2 = new StatService();
        this.statService = statService2;
        String str = "3.0.0";
        statService2.hostVersion = str;
        this.bundle = bundle2;
        SdkConfigOptions bioOptions = LocalConfigOptions.getInstance(context2).getBioOptions();
        try {
            if (bioOptions.globalEnable && bioOptions.enable) {
                if (!inWhitePkgLoadDefaultSO(context2)) {
                    if (!bioOptions.updateFail) {
                        loadPathSo(bioOptions);
                    } else if (str.compareTo(bioOptions.zipVersion) > 0) {
                        this.statService.zipVersion = str;
                        loadDefaultSo();
                    } else {
                        loadPathSo(bioOptions);
                    }
                    this.statService.loadSoSuccess = true;
                    return true;
                }
            }
            this.statService.zipVersion = bioOptions.zipVersion;
            this.statService.loadSoSuccess = true;
            loadDefaultSo();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            this.statService.exceptionInfo = Log.getStackTraceString(th);
            this.statService.execptionZipVersion = this.statService.zipVersion;
            this.statService.loadSoSuccess = false;
            return false;
        } finally {
            this.statService.startStatService();
        }
    }
}
