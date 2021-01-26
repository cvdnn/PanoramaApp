package com.baidu.pass.biometrics.base.dynamicupdate;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions.DistributedFile;
import com.baidu.pass.biometrics.base.http.BinaryHttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.utils.PassBioBaseUtil;
import com.baidu.pass.biometrics.base.utils.PassBioFileUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.RSA;
import com.baidu.pass.biometrics.base.utils.thread.TPRunnable;
import com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import e.a.a.a.a;
import e.c.b.e.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateSo {
    public static String TAG = "UpdateSo";
    public Application application;
    public PassBiometricConfiguration configuration;
    public SdkConfigOptions newOptions;
    public SdkConfigOptions oldOptions;
    public StatService statService;
    public CountDownLatch statServiceCountDownLatch;

    public interface LoadModuleEventListener {
        void onFailure(DistributedFile distributedFile);

        void onSuccess(DistributedFile distributedFile, byte[] bArr);
    }

    public class StatService {
        public static final String DOWNLOAD_ZIP_FILE_SUCCESS = "download_zip_file_success";
        public static final String EXCEPTION_INFO = "exception_info";
        public static final String GET_CONFIG_SUCCESS = "get_config_success";
        public static final String HOST_VERSION = "host_version";
        public static final String MEET_GRAY = "meet_gray";
        public static final String NEED_UPDATE = "need_update";
        public static final String SDK_VERSION_ENABLE = "sdk_version_enable";
        public static final String STAT_NAME_LIVENESS_FACE = "sapi_bio_dynamic_update_so";
        public static final String UPDATE_FROM_NET = "update_from_net";
        public static final String ZIP_ENABLE = "zip_enable";
        public static final String ZIP_VERSION = "zip_version";
        public boolean downloadZipFileSuccess;
        public String exceptionInfo;
        public boolean getConfigSuccess;
        public boolean meetGray;
        public boolean needUpdate;
        public boolean sdkVersionBelow19;
        public boolean updateFromNet;
        public boolean zipEnable;
        public String zipVersion;

        public StatService() {
        }

        private Map<String, String> prepareData() {
            HashMap hashMap = new HashMap();
            hashMap.put("host_version", "3.0.0");
            hashMap.put("zip_version", this.zipVersion);
            boolean z = this.getConfigSuccess;
            String str = "1";
            String str2 = LivenessStat.TYPE_STRING_DEFAULT;
            hashMap.put(GET_CONFIG_SUCCESS, z ? str : str2);
            if (this.getConfigSuccess) {
                hashMap.put(ZIP_ENABLE, this.zipEnable ? str : str2);
                hashMap.put(NEED_UPDATE, this.needUpdate ? str : str2);
            }
            if (this.zipEnable) {
                hashMap.put(MEET_GRAY, this.meetGray ? str : str2);
            }
            if (this.needUpdate) {
                hashMap.put(UPDATE_FROM_NET, this.updateFromNet ? str : str2);
                hashMap.put(DOWNLOAD_ZIP_FILE_SUCCESS, this.downloadZipFileSuccess ? str : str2);
            }
            boolean z2 = this.sdkVersionBelow19;
            if (z2) {
                if (!z2) {
                    str = str2;
                }
                hashMap.put(SDK_VERSION_ENABLE, str);
            }
            hashMap.put("exception_info", this.exceptionInfo);
            return hashMap;
        }

        /* access modifiers changed from: private */
        public void startStatService() {
            com.baidu.pass.biometrics.base.utils.StatService.onEvent(UpdateSo.this.application, STAT_NAME_LIVENESS_FACE, prepareData());
        }
    }

    private void copyInternalFileToExternal(DistributedFile distributedFile) {
        loadFileFromExternal(distributedFile, new LoadModuleEventListener() {
            public void onFailure(DistributedFile distributedFile) {
                String internalZipPath = LocalConfigOptions.getInternalZipPath(UpdateSo.this.application, UpdateSo.this.newOptions.zipVersion);
                String externalZipPath = LocalConfigOptions.getExternalZipPath(UpdateSo.this.newOptions.zipVersion);
                Log.e(UpdateSo.TAG, a.a("asyncDistributeConf(), loadFileFromExternal failure internalFile:", internalZipPath));
                if (PassBioFileUtils.isFileExist(internalZipPath)) {
                    byte[] access$2200 = UpdateSo.this.loadDataFromInternal(internalZipPath);
                    if (PassBiometricUtil.checkRequestPermission(UpdateSo.this.application, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        if (PassBioFileUtils.isFileExist(externalZipPath)) {
                            PassBioFileUtils.deleteFile(externalZipPath);
                        }
                        UpdateSo.this.writeExternal(externalZipPath, access$2200);
                    }
                }
            }

            public void onSuccess(DistributedFile distributedFile, byte[] bArr) {
                Log.e(UpdateSo.TAG, "copyInternalFileToExternal(), loadFileFromExternal distributed success");
            }
        }, LocalConfigOptions.getExternalZipPath(this.newOptions.zipVersion));
    }

    /* access modifiers changed from: private */
    public void downloadFile(SdkConfigOptions sdkConfigOptions) {
        this.statService.updateFromNet = true;
        String[] strArr = {"application/octet-stream", "*/*", "application/apk", "application/vnd.android.package-archive", "application/zip"};
        String str = TAG;
        StringBuilder a2 = a.a("loadFileFromExternal onFailure distributedSdk uri:");
        a2.append(sdkConfigOptions.distributedSdk.downloadUrl);
        Log.e(str, a2.toString());
        new HttpClientWrap(this.application).get(sdkConfigOptions.distributedSdk.downloadUrl, (BinaryHttpHandlerWrap) new BinaryHttpHandlerWrap(true, strArr) {
            public void onFailure(Throwable th, int i2, String str) {
                String str2 = UpdateSo.TAG;
                StringBuilder a2 = a.a("distributeFileDownload() onFailure");
                a2.append(th.toString());
                Log.e(str2, a2.toString());
                UpdateSo.this.oldOptions.updateFail = true;
                LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                UpdateSo.this.statService.downloadZipFileSuccess = false;
                UpdateSo.this.statService.exceptionInfo = android.util.Log.getStackTraceString(th);
                UpdateSo.this.statServiceCountDownLatch.countDown();
            }

            public void onSuccess(int i2, byte[] bArr) {
                UpdateSo.this.downloadFileSuccess(bArr);
            }
        });
    }

    /* access modifiers changed from: private */
    public void downloadFileSuccess(byte[] bArr) {
        try {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("distributeFileDownload() onSuccess");
            sb.append(this.newOptions.distributedSdk.downloadUrl);
            sb.append(",:");
            sb.append(LocalConfigOptions.getInternalZipPath(this.application, this.newOptions.zipVersion));
            Log.e(str, sb.toString());
            String a2 = Utils.a(bArr, false);
            String decrypt = RSA.decrypt(this.newOptions.distributedSdk.hash);
            if (decrypt == null || !decrypt.equals(a2)) {
                this.oldOptions.updateFail = true;
                LocalConfigOptions.getInstance(this.application).setBioOptions(this.oldOptions);
                this.statService.downloadZipFileSuccess = false;
                this.statService.exceptionInfo = "localMd5 is not equals onlineMd5";
                this.statServiceCountDownLatch.countDown();
                return;
            }
            if (writeInternal(LocalConfigOptions.getInternalZipPath(this.application, this.newOptions.zipVersion), bArr)) {
                unZipApkSoToLibDir(LocalConfigOptions.getInternalZipPath(this.application, this.newOptions.zipVersion), LocalConfigOptions.getInternalRootPath(this.application));
                this.newOptions.updateFail = false;
                LocalConfigOptions.getInstance(this.application).setBioOptions(this.newOptions);
            } else {
                this.oldOptions.updateFail = true;
                LocalConfigOptions.getInstance(this.application).setBioOptions(this.oldOptions);
                this.statService.downloadZipFileSuccess = false;
                this.statService.exceptionInfo = "zip file write internal fail";
                this.statServiceCountDownLatch.countDown();
            }
            if (PassBiometricUtil.checkRequestPermission(this.application, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalZipPath = LocalConfigOptions.getExternalZipPath(this.newOptions.zipVersion);
                if (PassBioFileUtils.isFileExist(externalZipPath)) {
                    PassBioFileUtils.deleteFile(externalZipPath);
                }
                writeExternal(externalZipPath, bArr);
            }
        } catch (Exception e2) {
            String str2 = TAG;
            StringBuilder a3 = a.a("distributeFileDownload() Exception ");
            a3.append(e2.toString());
            Log.e(str2, a3.toString());
            this.oldOptions.updateFail = true;
            LocalConfigOptions.getInstance(this.application).setBioOptions(this.oldOptions);
            this.statService.downloadZipFileSuccess = false;
            this.statService.exceptionInfo = android.util.Log.getStackTraceString(e2);
            this.statServiceCountDownLatch.countDown();
        }
    }

    /* access modifiers changed from: private */
    public void getHostConfig() {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("appid", this.configuration.appId);
        httpHashMapWrap.put("tpl", this.configuration.tpl);
        new HttpClientWrap(this.application).get("https://wappass.bdimg.com/static/appsapi/appdistribute/android.txt", httpHashMapWrap, null, new HttpHandlerWrap(true) {
            public void onFailure(Throwable th, int i2, String str) {
                SdkConfigOptions bioOptions = LocalConfigOptions.getInstance(UpdateSo.this.application).getBioOptions();
                bioOptions.updateFail = true;
                LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(bioOptions);
                UpdateSo.this.statService.getConfigSuccess = false;
                UpdateSo.this.statService.exceptionInfo = android.util.Log.getStackTraceString(th);
                UpdateSo.this.statServiceCountDownLatch.countDown();
            }

            public void onSuccess(int i2, String str) {
                UpdateSo.this.loadConfigSuccess(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadConfigSuccess(String str) {
        try {
            this.newOptions = SdkConfigOptions.fromOnLineJSON(new JSONObject(str));
            this.oldOptions = LocalConfigOptions.getInstance(this.application).getBioOptions();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("asyncDistributeConf() newOptions:");
            sb.append(this.newOptions.toJSON());
            Log.e(str2, sb.toString());
            String str3 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("asyncDistributeConf() oldOptions:");
            sb2.append(this.oldOptions.toJSON());
            Log.e(str3, sb2.toString());
            if (!PassBioBaseUtil.listValueEqual(this.newOptions.livenessConfigOption.illumList, this.oldOptions.livenessConfigOption.illumList)) {
                LocalConfigOptions.getInstance(this.application).setIllumValueGray(-1);
            }
            this.oldOptions.globalEnable = this.newOptions.globalEnable;
            this.oldOptions.enable = this.newOptions.enable;
            this.oldOptions.livenessConfigOption = this.newOptions.livenessConfigOption;
            LocalConfigOptions.getInstance(this.application).setBioOptions(this.oldOptions);
            this.statService.getConfigSuccess = true;
            this.statService.zipVersion = this.newOptions.zipVersion;
            if (this.newOptions.globalEnable) {
                if (this.newOptions.enable) {
                    this.statService.zipEnable = true;
                    updateGrayPlugins(this.oldOptions);
                    int i2 = this.newOptions.grayThreshold;
                    this.newOptions.grayThreshold = this.oldOptions.grayThreshold;
                    if (!meetGrayDemand(i2, this.oldOptions)) {
                        this.statService.meetGray = false;
                        this.statService.needUpdate = false;
                        this.statServiceCountDownLatch.countDown();
                        this.oldOptions.updateFail = true;
                        LocalConfigOptions.getInstance(this.application).setBioOptions(this.oldOptions);
                        return;
                    }
                    this.statService.meetGray = true;
                    if ("3.0.0".compareTo(this.newOptions.zipVersion) > 0) {
                        this.statService.needUpdate = false;
                        this.statServiceCountDownLatch.countDown();
                        this.oldOptions.updateFail = true;
                        LocalConfigOptions.getInstance(this.application).setBioOptions(this.oldOptions);
                        return;
                    }
                    if (needUpdate(this.newOptions.distributedSdk, this.oldOptions.distributedSdk)) {
                        updateFile(this.newOptions);
                        this.statService.needUpdate = true;
                    } else {
                        copyInternalFileToExternal(this.newOptions.distributedSdk);
                        this.statService.needUpdate = false;
                        this.statServiceCountDownLatch.countDown();
                    }
                    return;
                }
            }
            this.statService.zipEnable = false;
            this.statService.needUpdate = false;
            this.statServiceCountDownLatch.countDown();
            this.oldOptions.updateFail = true;
            LocalConfigOptions.getInstance(this.application).setBioOptions(this.oldOptions);
        } catch (JSONException e2) {
            Log.e(TAG, (Throwable) e2);
        }
    }

    private byte[] loadData(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        } finally {
            inputStream.close();
        }
    }

    private byte[] loadDataFromExternal(String str) throws IOException {
        return loadData(new FileInputStream(new File(str)));
    }

    /* access modifiers changed from: private */
    public byte[] loadDataFromInternal(String str) {
        try {
            return loadData(new FileInputStream(new File(str)));
        } catch (IOException e2) {
            Log.e(TAG, (Throwable) e2);
            return new byte[0];
        }
    }

    private void loadFileFromExternal(DistributedFile distributedFile, LoadModuleEventListener loadModuleEventListener, String str) {
        if (loadModuleEventListener != null) {
            try {
                if (!"mounted".equals(Environment.getExternalStorageState()) || !new File(str).exists()) {
                    loadModuleEventListener.onFailure(distributedFile);
                    return;
                }
                byte[] loadDataFromExternal = loadDataFromExternal(str);
                String a2 = Utils.a(loadDataFromExternal, false);
                String decrypt = RSA.decrypt(distributedFile.hash);
                String str2 = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("loadFileFromExternal() localMd5:");
                sb.append(a2);
                sb.append(",onlineMd5");
                sb.append(decrypt);
                Log.e(str2, sb.toString());
                if (decrypt == null || !decrypt.equals(a2)) {
                    loadModuleEventListener.onFailure(distributedFile);
                } else {
                    loadModuleEventListener.onSuccess(distributedFile, loadDataFromExternal);
                }
            } catch (Throwable th) {
                String str3 = TAG;
                StringBuilder a3 = a.a("loadFileFromExternal() Throwable");
                a3.append(th.toString());
                Log.e(str3, a3.toString());
                loadModuleEventListener.onFailure(distributedFile);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(LoadModuleEventListener.class.getName());
            sb2.append("can't be null");
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private boolean meetGrayDemand(int i2, SdkConfigOptions sdkConfigOptions) {
        if (100 != this.newOptions.grayThreshold && sdkConfigOptions.grayThreshold >= i2) {
            return false;
        }
        return true;
    }

    private boolean needUpdate(DistributedFile distributedFile, DistributedFile distributedFile2) {
        return distributedFile2 == null || distributedFile == null || TextUtils.isEmpty(distributedFile2.hash) || !distributedFile.hash.equals(distributedFile2.hash);
    }

    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r13v1, types: [java.util.zip.ZipInputStream] */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.util.zip.ZipInputStream] */
    /* JADX WARNING: type inference failed for: r13v6 */
    /* JADX WARNING: type inference failed for: r13v8, types: [java.util.zip.ZipInputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r7v0, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v12, types: [java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r13v9 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: type inference failed for: r7v14 */
    /* JADX WARNING: type inference failed for: r7v15 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v8
  assigns: []
  uses: []
  mth insns count: 166
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(ArrayList.java:1249)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016b A[Catch:{ Exception -> 0x0175, all -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0192 A[SYNTHETIC, Splitter:B:62:0x0192] */
    /* JADX WARNING: Unknown variable types count: 11 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unZipApkSoToLibDir(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = ".so"
            com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo$StatService r1 = r12.statService
            r2 = 1
            r1.downloadZipFileSuccess = r2
            java.util.concurrent.CountDownLatch r1 = r12.statServiceCountDownLatch
            r1.countDown()
            java.lang.String r1 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "thread name unZipApkSoToLibDir = "
            java.lang.StringBuilder r4 = e.a.a.a.a.a(r4)
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            java.lang.String r5 = r5.getName()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            r3[r5] = r4
            com.baidu.pass.biometrics.base.debug.Log.i(r1, r3)
            java.lang.String r1 = TAG
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "unZipApkSoToLibDir(), zipFilePath:"
            r4.append(r6)
            r4.append(r13)
            java.lang.String r6 = ",libDir:"
            r4.append(r6)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            r3[r5] = r4
            com.baidu.pass.biometrics.base.debug.Log.d(r1, r3)
            r1 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x017b }
            r3.<init>(r13)     // Catch:{ Exception -> 0x017b }
            java.util.zip.ZipInputStream r13 = new java.util.zip.ZipInputStream     // Catch:{ Exception -> 0x017b }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x017b }
            r4.<init>(r3)     // Catch:{ Exception -> 0x017b }
            r13.<init>(r4)     // Catch:{ Exception -> 0x017b }
        L_0x005e:
            java.util.zip.ZipEntry r3 = r13.getNextEntry()     // Catch:{ Exception -> 0x0175, all -> 0x0173 }
            if (r3 == 0) goto L_0x016f
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r4]     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9.<init>()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r10 = "unZipApkSoToLibDir() entryName,"
            r9.append(r10)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9.append(r3)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r8[r5] = r9     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.baidu.pass.biometrics.base.debug.Log.e(r7, r8)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            boolean r7 = r3.endsWith(r0)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r7 != 0) goto L_0x0090
            if (r1 == 0) goto L_0x005e
            goto L_0x015e
        L_0x0090:
            java.lang.String r7 = "/"
            int r7 = r3.lastIndexOf(r7)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            int r7 = r7 + r2
            java.lang.String r8 = "_"
            int r8 = r3.lastIndexOf(r8)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9.<init>()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r3 = r3.substring(r7, r8)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9.append(r3)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9.append(r0)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r3 = r9.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r7 = TAG     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9.<init>()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r10 = "unZipApkSoToLibDir(),fileName2:"
            r9.append(r10)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9.append(r3)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r8[r5] = r9     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.baidu.pass.biometrics.base.debug.Log.d(r7, r8)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r8.<init>()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r8.append(r14)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r9 = java.io.File.separator     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r8.append(r9)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r8.append(r3)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.<init>(r3)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            boolean r3 = r7.exists()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r3 == 0) goto L_0x00ec
            r7.delete()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
        L_0x00ec:
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r8 = r7.getParent()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r3.<init>(r8)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r8 = TAG     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r10.<init>()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r11 = "unZipApkSoToLibDir()entryFile"
            r10.append(r11)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r10.append(r11)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r11 = "entryDir"
            r10.append(r11)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r11 = r3.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r10.append(r11)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r9[r5] = r10     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.baidu.pass.biometrics.base.debug.Log.d(r8, r9)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            boolean r8 = r3.exists()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            if (r8 != 0) goto L_0x0133
            java.lang.String r8 = TAG     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.lang.String r10 = "unZipApkSoToLibDir() not exists"
            r9[r5] = r10     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            com.baidu.pass.biometrics.base.debug.Log.d(r8, r9)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r3.mkdirs()     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
        L_0x0133:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
            r7.<init>(r3, r4)     // Catch:{ Exception -> 0x0155, all -> 0x0153 }
        L_0x013d:
            int r1 = r13.read(r6, r5, r4)     // Catch:{ Exception -> 0x0151, all -> 0x014f }
            r3 = -1
            if (r1 == r3) goto L_0x0148
            r7.write(r6, r5, r1)     // Catch:{ Exception -> 0x0151, all -> 0x014f }
            goto L_0x013d
        L_0x0148:
            r7.flush()     // Catch:{ Exception -> 0x0151, all -> 0x014f }
            r7.close()     // Catch:{ Exception -> 0x0175, all -> 0x0173 }
            goto L_0x0163
        L_0x014f:
            r14 = move-exception
            goto L_0x0169
        L_0x0151:
            r1 = move-exception
            goto L_0x0158
        L_0x0153:
            r14 = move-exception
            goto L_0x0168
        L_0x0155:
            r3 = move-exception
            r7 = r1
            r1 = r3
        L_0x0158:
            r1.printStackTrace()     // Catch:{ all -> 0x0166 }
            if (r7 == 0) goto L_0x0163
            r1 = r7
        L_0x015e:
            r1.close()     // Catch:{ Exception -> 0x0175, all -> 0x0173 }
            goto L_0x005e
        L_0x0163:
            r1 = r7
            goto L_0x005e
        L_0x0166:
            r14 = move-exception
            r1 = r7
        L_0x0168:
            r7 = r1
        L_0x0169:
            if (r7 == 0) goto L_0x016e
            r7.close()     // Catch:{ Exception -> 0x0175, all -> 0x0173 }
        L_0x016e:
            throw r14     // Catch:{ Exception -> 0x0175, all -> 0x0173 }
        L_0x016f:
            r13.close()     // Catch:{ IOException -> 0x0188 }
            goto L_0x018e
        L_0x0173:
            r14 = move-exception
            goto L_0x0190
        L_0x0175:
            r14 = move-exception
            r1 = r13
            goto L_0x017d
        L_0x0178:
            r13 = move-exception
            r14 = r13
            goto L_0x018f
        L_0x017b:
            r13 = move-exception
            r14 = r13
        L_0x017d:
            java.lang.String r13 = TAG     // Catch:{ all -> 0x0178 }
            com.baidu.pass.biometrics.base.debug.Log.e(r13, r14)     // Catch:{ all -> 0x0178 }
            if (r1 == 0) goto L_0x018e
            r1.close()     // Catch:{ IOException -> 0x0188 }
            goto L_0x018e
        L_0x0188:
            r13 = move-exception
            java.lang.String r14 = TAG
            com.baidu.pass.biometrics.base.debug.Log.e(r14, r13)
        L_0x018e:
            return
        L_0x018f:
            r13 = r1
        L_0x0190:
            if (r13 == 0) goto L_0x019c
            r13.close()     // Catch:{ IOException -> 0x0196 }
            goto L_0x019c
        L_0x0196:
            r13 = move-exception
            java.lang.String r0 = TAG
            com.baidu.pass.biometrics.base.debug.Log.e(r0, r13)
        L_0x019c:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.unZipApkSoToLibDir(java.lang.String, java.lang.String):void");
    }

    private void updateFile(final SdkConfigOptions sdkConfigOptions) {
        loadFileFromExternal(sdkConfigOptions.distributedSdk, new LoadModuleEventListener() {
            public void onFailure(DistributedFile distributedFile) {
                UpdateSo.this.downloadFile(sdkConfigOptions);
            }

            public void onSuccess(DistributedFile distributedFile, byte[] bArr) {
                UpdateSo updateSo = UpdateSo.this;
                boolean access$1400 = updateSo.writeInternal(LocalConfigOptions.getInternalZipPath(updateSo.application, sdkConfigOptions.zipVersion), bArr);
                if (access$1400) {
                    UpdateSo.this.statService.updateFromNet = false;
                    UpdateSo updateSo2 = UpdateSo.this;
                    updateSo2.unZipApkSoToLibDir(LocalConfigOptions.getInternalZipPath(updateSo2.application, sdkConfigOptions.zipVersion), LocalConfigOptions.getInternalRootPath(UpdateSo.this.application));
                    sdkConfigOptions.updateFail = false;
                    LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(sdkConfigOptions);
                } else {
                    UpdateSo.this.downloadFile(sdkConfigOptions);
                }
                String str = UpdateSo.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("loadFileFromExternal writeFileSuccess:");
                sb.append(access$1400);
                Log.e(str, sb.toString());
            }
        }, LocalConfigOptions.getExternalZipPath(sdkConfigOptions.zipVersion));
    }

    private void updateGrayPlugins(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions.distributedSdk == null) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            sdkConfigOptions.grayThreshold = random.nextInt(100);
            LocalConfigOptions.getInstance(this.application).setBioOptions(sdkConfigOptions);
        }
        String str = TAG;
        StringBuilder a2 = a.a("current gray = ");
        a2.append(sdkConfigOptions.grayThreshold);
        Log.i(str, a2.toString());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A[SYNTHETIC, Splitter:B:23:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeExternal(java.lang.String r4, byte[] r5) {
        /*
            r3 = this;
            r0 = 0
            java.lang.String r1 = "mounted"
            java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch:{ all -> 0x0040 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x003a
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0040 }
            r1.<init>(r4)     // Catch:{ all -> 0x0040 }
            java.io.File r4 = r1.getParentFile()     // Catch:{ all -> 0x0040 }
            boolean r4 = r4.exists()     // Catch:{ all -> 0x0040 }
            if (r4 != 0) goto L_0x0023
            java.io.File r4 = r1.getParentFile()     // Catch:{ all -> 0x0040 }
            r4.mkdirs()     // Catch:{ all -> 0x0040 }
        L_0x0023:
            boolean r4 = r1.exists()     // Catch:{ all -> 0x0040 }
            if (r4 != 0) goto L_0x002c
            r1.createNewFile()     // Catch:{ all -> 0x0040 }
        L_0x002c:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0040 }
            r4.<init>(r1)     // Catch:{ all -> 0x0040 }
            r4.write(r5)     // Catch:{ all -> 0x0036 }
            r0 = r4
            goto L_0x003a
        L_0x0036:
            r5 = move-exception
            r0 = r4
            r4 = r5
            goto L_0x0041
        L_0x003a:
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ all -> 0x004c }
            goto L_0x0052
        L_0x0040:
            r4 = move-exception
        L_0x0041:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0053 }
            com.baidu.pass.biometrics.base.debug.Log.e(r5, r4)     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ all -> 0x004c }
            goto L_0x0052
        L_0x004c:
            r4 = move-exception
            java.lang.String r5 = TAG
            com.baidu.pass.biometrics.base.debug.Log.e(r5, r4)
        L_0x0052:
            return
        L_0x0053:
            r4 = move-exception
            if (r0 == 0) goto L_0x0060
            r0.close()     // Catch:{ all -> 0x005a }
            goto L_0x0060
        L_0x005a:
            r5 = move-exception
            java.lang.String r0 = TAG
            com.baidu.pass.biometrics.base.debug.Log.e(r0, r5)
        L_0x0060:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.writeExternal(java.lang.String, byte[]):void");
    }

    /* access modifiers changed from: private */
    public boolean writeInternal(String str, byte[] bArr) {
        if (PassBioFileUtils.isFileExist(str)) {
            PassBioFileUtils.deleteFile(str);
        }
        File file = new File(str);
        boolean z = false;
        try {
            boolean checkAndCreadFile = PassBioFileUtils.checkAndCreadFile(file);
            boolean write = PassBioFileUtils.write(file, bArr);
            if (checkAndCreadFile && write) {
                z = true;
            }
            return z;
        } catch (IOException e2) {
            Log.e(TAG, (Throwable) e2);
            return false;
        }
    }

    public void checkSoUpdate(PassBiometricConfiguration passBiometricConfiguration) {
        this.configuration = passBiometricConfiguration;
        Application application2 = passBiometricConfiguration.getApplication();
        this.application = application2;
        CheckDefaultSoExist.isExist(application2);
        this.statService = new StatService();
        this.statServiceCountDownLatch = new CountDownLatch(1);
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() {
            public void run() {
                UpdateSo.this.getHostConfig();
                try {
                    UpdateSo.this.statServiceCountDownLatch.await();
                    Log.i(UpdateSo.TAG, "begin stat service");
                    UpdateSo.this.statService.startStatService();
                } catch (InterruptedException e2) {
                    Log.e(UpdateSo.TAG, (Throwable) e2);
                }
            }
        }));
    }
}
