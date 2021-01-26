package com.baidu.sofire.ac;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.jni.Asc;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.connect.common.Constants;
import e.c.d.n.e;
import e.c.f.c;
import e.c.f.d.a;
import e.c.f.f.d;
import e.c.f.i;
import e.c.f.n.g;
import e.c.f.n.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class U extends Thread {
    public static final int FROM_DAILY_ALARM = 6;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_HANDLE_REMOVE = 4;
    public static final int FROM_INIT = 1;
    public static final int FROM_INIT_ALARM = 2;
    public static final int FROM_NET_CHANGE = 3;
    public static final int FROM_OUT_FLASH = 5;
    public static final int NETWORK_TYPE_2G = 1;
    public static final int NETWORK_TYPE_3G = 2;
    public static final int NETWORK_TYPE_4G = 3;
    public static final int NETWORK_TYPE_MOBILE = 5;
    public static final int NETWORK_TYPE_UNCONNECTED = -1;
    public static final int NETWORK_TYPE_UNKNOWN = -2;
    public static final int NETWORK_TYPE_WIFI = 4;
    public static final int OUT_AES_FAIL = 8;
    public static final int OUT_FINISH = 1;
    public static final int OUT_NO_INTERNET = 3;
    public static final int OUT_NULL_APPKEY = 5;
    public static final int OUT_NULL_HOST_PKGINFO = 6;
    public static final int OUT_NULL_PLUGIN_JSON = 10;
    public static final int OUT_NULL_RESPONSE_JSON = 9;
    public static final int OUT_OTHER_THROWABLE = 11;
    public static final int OUT_PING_FAIL = 4;
    public static final int OUT_RESPONSE_EMPTY = 7;
    public static final int OUT_TIME_TOO_CLOSE = 2;
    public static final int OUT_UNSET = 0;
    public static final int TYPE_END = 1;
    public static final int TYPE_START = 0;
    public static final int UPGRADE_DECRYPT_FAIL = 7;
    public static final int UPGRADE_DOWNLOAD_FAIL = 4;
    public static final int UPGRADE_ERROR_CRASH_TIMES = 6;
    public static final int UPGRADE_LOAD_FAIL = 5;
    public static final int UPGRADE_MD5_FAIL = 8;
    public static final int UPGRADE_NETWORK_CHECK_FAIL = 3;
    public static final int UPGRADE_RESULT_EXCEPTION = 2;
    public static final int UPGRADE_RESULT_SUCCESS = 1;
    public static long sLastCheckTime = 0;
    public static boolean sMonitorNetworkWhenUpgradeNoNet = false;
    public static volatile boolean sOutGoing = false;
    public static boolean sPidRegister = false;
    public static Map<String, String> sRealtimeMd5Map = null;
    public static int sRetryDownoadHostCareApksTimesCount = 0;
    public static int sRetryPingTimesCount = 0;
    public static boolean sSetRetrmAlarm = false;
    public Context context;
    public d forHostAPP;
    public a loadedPluginDB;
    public Map<Integer, String> mCloudKeyMap = new HashMap();
    public List<Integer> mDownloadPluginsList = new ArrayList();
    public int mEndReason = 0;
    public int mFrom = 0;
    public boolean mOut = false;
    public Map<Integer, String> mStartKeyMap;
    public int mStartNetwork = -2;
    public List<Integer> mUnloadPluginsList = new ArrayList();
    public Map<Integer, UpgradeResult> mUpgradeResultMap = new HashMap();
    public JSONObject mWholeJson;
    public i preference;
    public File tmpDir;

    public class UpgradeResult {
        public int networkId;
        public int resultId;

        public UpgradeResult(int i2, int i3) {
            this.networkId = i2;
            this.resultId = i3;
        }
    }

    public U(Context context2, int i2, boolean z) {
        this.context = context2;
        this.loadedPluginDB = a.a(context2);
        this.preference = new i(context2);
        this.forHostAPP = d.a(context2);
        this.tmpDir = new File(context2.getFilesDir(), ".tmp");
        this.mFrom = i2;
        this.mOut = z;
    }

    /* access modifiers changed from: private */
    public void handlePluginDownError(ApkInfo apkInfo, File file, int i2, List<Integer> list) {
        Map<Integer, UpgradeResult> map = this.mUpgradeResultMap;
        if (map != null && !map.keySet().contains(Integer.valueOf(apkInfo.key))) {
            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 8));
        }
        int i3 = this.mFrom;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            if (list != null && list.contains(Integer.valueOf(apkInfo.key)) && !sSetRetrmAlarm) {
                sSetRetrmAlarm = true;
                e.a(this.context, sRetryDownoadHostCareApksTimesCount, false);
                sRetryDownoadHostCareApksTimesCount++;
            }
            if (!sMonitorNetworkWhenUpgradeNoNet) {
                IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                MyReceiver myReceiver = e.c.f.n.a.f7040e;
                if (myReceiver == null) {
                    MyReceiver myReceiver2 = new MyReceiver();
                    myReceiver2.a();
                    e.c.f.n.a.f7040e = myReceiver2;
                } else {
                    myReceiver.a();
                }
                e.c.f.n.a.a(this.context, (BroadcastReceiver) e.c.f.n.a.f7040e, intentFilter);
                sMonitorNetworkWhenUpgradeNoNet = true;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        i iVar = this.preference;
        String str = "pu_ap_fd";
        long j2 = iVar.f7007a.getLong(str, 0);
        if (j2 == 0) {
            j2 = System.currentTimeMillis();
            iVar.f7009c.putLong(str, System.currentTimeMillis());
            iVar.f7009c.commit();
        }
        if (currentTimeMillis - j2 > LogBuilder.MAX_INTERVAL) {
            HashMap hashMap = new HashMap();
            String str2 = "1";
            String str3 = "0";
            if (e.c.f.n.a.c(this.context)) {
                hashMap.put(str3, Integer.valueOf(this.preference.c() + 1));
                hashMap.put(str2, Integer.valueOf(this.preference.d()));
            } else {
                hashMap.put(str3, Integer.valueOf(this.preference.c()));
                hashMap.put(str2, Integer.valueOf(this.preference.d() + 1));
            }
            this.preference.a(0);
            this.preference.b(0);
            i iVar2 = this.preference;
            iVar2.f7009c.putLong(str, System.currentTimeMillis());
            iVar2.f7009c.commit();
            e.c.f.n.a.a(this.context, "1003116", (Map<String, Object>) hashMap);
        } else if (e.c.f.n.a.c(this.context)) {
            i iVar3 = this.preference;
            iVar3.a(iVar3.c() + 1);
        } else {
            i iVar4 = this.preference;
            iVar4.b(iVar4.d() + 1);
        }
        c.a();
        file.delete();
    }

    /* access modifiers changed from: private */
    public boolean handlePluginDownload(ApkInfo apkInfo, File file, File file2, int i2) {
        try {
            if (file.exists()) {
                file.delete();
            }
            if ("com.baidu.input_huawei".equals(this.context.getPackageName()) && !this.preference.a()) {
                return false;
            }
            boolean a2 = new g(this.context).a(apkInfo.downloadURL, file);
            c.a();
            if (a2) {
                if (file2.exists()) {
                    file2.delete();
                }
                Asc asc = new Asc();
                byte[] bytes = apkInfo.signMD5.substring(0, apkInfo.signMD5.length() / 2).getBytes("utf-8");
                e.c.f.n.a.e(Constants.VIA_REPORT_TYPE_SET_AVATAR);
                if (e.a(file, file2, bytes) != 0) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    e.c.f.n.a.e("13");
                    if (asc.df(file.getAbsolutePath(), file2.getAbsolutePath(), bytes) != 0) {
                        e.c.f.n.a.e(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
                        if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                            this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 7));
                        }
                        a2 = false;
                    }
                }
            } else if (this.mUpgradeResultMap != null && !this.mUpgradeResultMap.keySet().contains(Integer.valueOf(apkInfo.key))) {
                this.mUpgradeResultMap.put(Integer.valueOf(apkInfo.key), new UpgradeResult(i2, 4));
            }
            new StringBuilder().append(a2);
            String a3 = h.a(file2);
            StringBuilder sb = new StringBuilder("ds=");
            sb.append(a2);
            sb.append(", fm=");
            sb.append(apkInfo.apkMD5);
            sb.append(", am=");
            sb.append(a3);
            file.delete();
            if (a2 && apkInfo.apkMD5.equals(a3)) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            c.d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0125 A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0175 A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x017a A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0196 A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01df A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e7 A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01fe A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x022e A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x023e A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x025e A[Catch:{ all -> 0x0262, all -> 0x0293, all -> 0x02f1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handlePluginUpgrade(com.baidu.sofire.core.ApkInfo r19) {
        /*
            r18 = this;
            r7 = r18
            r8 = r19
            java.lang.String r0 = "-"
            java.lang.String r9 = "android.net.conn.CONNECTIVITY_CHANGE"
            r10 = 3
            r12 = 1
            android.content.Context r1 = r7.context     // Catch:{ all -> 0x0262 }
            int r13 = e.c.f.n.a.g(r1)     // Catch:{ all -> 0x0262 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = "a="
            r1.<init>(r2)     // Catch:{ all -> 0x0262 }
            r1.append(r8)     // Catch:{ all -> 0x0262 }
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            e.c.f.i r1 = r7.preference     // Catch:{ all -> 0x0262 }
            java.util.List r14 = r1.f()     // Catch:{ all -> 0x0262 }
            int r1 = r8.key     // Catch:{ all -> 0x0262 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0262 }
            r2 = r14
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x0262 }
            if (r1 != 0) goto L_0x0084
            android.content.Context r1 = r7.context     // Catch:{ all -> 0x0262 }
            int r2 = r8.network     // Catch:{ all -> 0x0262 }
            if (r2 != r12) goto L_0x005a
            boolean r2 = e.c.f.n.a.c(r1)     // Catch:{ all -> 0x0262 }
            if (r2 != 0) goto L_0x005a
            android.content.IntentFilter r2 = new android.content.IntentFilter     // Catch:{ all -> 0x0262 }
            r2.<init>(r9)     // Catch:{ all -> 0x0262 }
            com.baidu.sofire.MyReceiver r3 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x0262 }
            if (r3 != 0) goto L_0x0051
            com.baidu.sofire.MyReceiver r3 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x0262 }
            r3.<init>()     // Catch:{ all -> 0x0262 }
            r3.a()     // Catch:{ all -> 0x0262 }
            e.c.f.n.a.f7040e = r3     // Catch:{ all -> 0x0262 }
        L_0x0051:
            com.baidu.sofire.MyReceiver r3 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x0262 }
            e.c.f.n.a.a(r1, r3, r2)     // Catch:{ all -> 0x0262 }
            e.c.f.n.a.f7036a = r12     // Catch:{ all -> 0x0262 }
            r1 = 0
            goto L_0x005b
        L_0x005a:
            r1 = r12
        L_0x005b:
            if (r1 != 0) goto L_0x0084
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r0 = r7.mUpgradeResultMap     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x0083
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r0 = r7.mUpgradeResultMap     // Catch:{ all -> 0x0262 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x0262 }
            int r1 = r8.key     // Catch:{ all -> 0x0262 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0262 }
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x0262 }
            if (r0 != 0) goto L_0x0083
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r0 = r7.mUpgradeResultMap     // Catch:{ all -> 0x0262 }
            int r1 = r8.key     // Catch:{ all -> 0x0262 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0262 }
            com.baidu.sofire.ac.U$UpgradeResult r2 = new com.baidu.sofire.ac.U$UpgradeResult     // Catch:{ all -> 0x0262 }
            r2.<init>(r13, r10)     // Catch:{ all -> 0x0262 }
            r0.put(r1, r2)     // Catch:{ all -> 0x0262 }
        L_0x0083:
            return
        L_0x0084:
            java.io.File r1 = r7.tmpDir     // Catch:{ all -> 0x0262 }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x0262 }
            if (r1 != 0) goto L_0x0091
            java.io.File r1 = r7.tmpDir     // Catch:{ all -> 0x0262 }
            r1.mkdir()     // Catch:{ all -> 0x0262 }
        L_0x0091:
            e.c.f.d.a r1 = r7.loadedPluginDB     // Catch:{ all -> 0x0262 }
            int r2 = r8.key     // Catch:{ all -> 0x0262 }
            r15 = 10000000(0x989680, float:1.4012985E-38)
            int r2 = r2 + r15
            com.baidu.sofire.core.ApkInfo r6 = r1.a(r2)     // Catch:{ all -> 0x0262 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0262 }
            java.io.File r1 = r7.tmpDir     // Catch:{ all -> 0x0262 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r2.<init>()     // Catch:{ all -> 0x0262 }
            int r4 = r8.key     // Catch:{ all -> 0x0262 }
            r2.append(r4)     // Catch:{ all -> 0x0262 }
            r2.append(r0)     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = r8.versionName     // Catch:{ all -> 0x0262 }
            r2.append(r4)     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = ".tmp"
            r2.append(r4)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0262 }
            r3.<init>(r1, r2)     // Catch:{ all -> 0x0262 }
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0262 }
            java.io.File r1 = r7.tmpDir     // Catch:{ all -> 0x0262 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r2.<init>()     // Catch:{ all -> 0x0262 }
            int r4 = r8.key     // Catch:{ all -> 0x0262 }
            r2.append(r4)     // Catch:{ all -> 0x0262 }
            r2.append(r0)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = r8.versionName     // Catch:{ all -> 0x0262 }
            r2.append(r0)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = ".zip"
            r2.append(r0)     // Catch:{ all -> 0x0262 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0262 }
            r5.<init>(r1, r0)     // Catch:{ all -> 0x0262 }
            boolean r0 = r5.exists()     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x0120
            java.lang.String r0 = e.c.f.n.h.a(r5)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r8.apkMD5     // Catch:{ all -> 0x0262 }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x010e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r0.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r8.versionName     // Catch:{ all -> 0x0262 }
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = " exists! "
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            int r1 = r8.key     // Catch:{ all -> 0x0262 }
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            r16 = r12
            r0 = 0
            goto L_0x0123
        L_0x010e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r0.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = r8.versionName     // Catch:{ all -> 0x0262 }
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            java.lang.String r1 = " exists! but mdf "
            r0.append(r1)     // Catch:{ all -> 0x0262 }
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
        L_0x0120:
            r0 = r12
            r16 = 0
        L_0x0123:
            if (r0 == 0) goto L_0x0175
            boolean r0 = r8.isNextLoad     // Catch:{ all -> 0x0262 }
            if (r0 == 0) goto L_0x013d
            com.baidu.sofire.ac.U$2 r17 = new com.baidu.sofire.ac.U$2     // Catch:{ all -> 0x0262 }
            r0 = r17
            r1 = r18
            r2 = r19
            r4 = r5
            r11 = r5
            r5 = r13
            r10 = r6
            r6 = r14
            r0.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0262 }
            r17.start()     // Catch:{ all -> 0x0262 }
            goto L_0x0177
        L_0x013d:
            r11 = r5
            r10 = r6
            boolean r0 = r7.handlePluginDownload(r8, r3, r11, r13)     // Catch:{ all -> 0x0262 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r1.<init>()     // Catch:{ all -> 0x0262 }
            r1.append(r0)     // Catch:{ all -> 0x0262 }
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            r1 = r0 ^ 1
            if (r10 == 0) goto L_0x0172
            e.c.f.d.a r2 = r7.loadedPluginDB     // Catch:{ all -> 0x0262 }
            int r3 = r10.key     // Catch:{ all -> 0x0262 }
            int r3 = r3 + r15
            r2.h(r3)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r10.pkgPath     // Catch:{ all -> 0x0262 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0262 }
            if (r2 != 0) goto L_0x0172
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = r10.pkgPath     // Catch:{ all -> 0x0262 }
            r2.<init>(r3)     // Catch:{ all -> 0x0262 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0262 }
            if (r3 == 0) goto L_0x0172
            r2.delete()     // Catch:{ all -> 0x0262 }
        L_0x0172:
            r16 = r0
            goto L_0x0178
        L_0x0175:
            r11 = r5
            r10 = r6
        L_0x0177:
            r1 = 0
        L_0x0178:
            if (r16 == 0) goto L_0x0196
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r0.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r8.versionName     // Catch:{ all -> 0x0262 }
            r0.append(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = " "
            r0.append(r2)     // Catch:{ all -> 0x0262 }
            int r2 = r8.key     // Catch:{ all -> 0x0262 }
            r0.append(r2)     // Catch:{ all -> 0x0262 }
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            r7.pluginUpdate(r11, r8, r13)     // Catch:{ all -> 0x0262 }
            goto L_0x025c
        L_0x0196:
            r0 = 0
            if (r10 == 0) goto L_0x023b
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            e.c.f.d.a r2 = r7.loadedPluginDB     // Catch:{ all -> 0x0262 }
            int r3 = r8.key     // Catch:{ all -> 0x0262 }
            com.baidu.sofire.core.ApkInfo r2 = r2.a(r3)     // Catch:{ all -> 0x0262 }
            if (r2 == 0) goto L_0x01b6
            java.lang.String r3 = r10.versionName     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r2.versionName     // Catch:{ all -> 0x0262 }
            boolean r2 = e.c.f.n.a.a(r3, r2)     // Catch:{ all -> 0x0262 }
            if (r2 == 0) goto L_0x01b4
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            goto L_0x01b6
        L_0x01b4:
            r2 = 0
            goto L_0x01b7
        L_0x01b6:
            r2 = r12
        L_0x01b7:
            java.lang.String r3 = r10.versionName     // Catch:{ all -> 0x0262 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0262 }
            if (r3 != 0) goto L_0x01d7
            java.lang.String r3 = r10.versionName     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = r8.versionName     // Catch:{ all -> 0x0262 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0262 }
            if (r3 == 0) goto L_0x01d7
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            e.c.f.d.a r2 = r7.loadedPluginDB     // Catch:{ all -> 0x0262 }
            int r3 = r10.key     // Catch:{ all -> 0x0262 }
            int r3 = r3 + r15
            java.lang.String r4 = r10.versionName     // Catch:{ all -> 0x0262 }
            r2.a(r3, r4)     // Catch:{ all -> 0x0262 }
            r2 = 0
        L_0x01d7:
            java.lang.String r3 = r10.pkgPath     // Catch:{ all -> 0x0262 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0262 }
            if (r3 != 0) goto L_0x01e7
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = r10.pkgPath     // Catch:{ all -> 0x0262 }
            r3.<init>(r4)     // Catch:{ all -> 0x0262 }
            goto L_0x01e8
        L_0x01e7:
            r3 = r0
        L_0x01e8:
            if (r3 == 0) goto L_0x023b
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0262 }
            if (r4 == 0) goto L_0x023b
            if (r2 == 0) goto L_0x023b
            java.lang.String r2 = e.c.f.n.h.a(r3)     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = r10.apkMD5     // Catch:{ all -> 0x0262 }
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0262 }
            if (r2 == 0) goto L_0x022e
            int r2 = r10.key     // Catch:{ all -> 0x0262 }
            int r2 = r2 - r15
            r10.key = r2     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r10.packageName     // Catch:{ all -> 0x0262 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0262 }
            if (r2 != 0) goto L_0x021c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = r10.packageName     // Catch:{ all -> 0x0262 }
            r2.<init>(r4)     // Catch:{ all -> 0x0262 }
            java.lang.StringBuilder r2 = r2.reverse()     // Catch:{ all -> 0x0262 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0262 }
            r10.packageName = r2     // Catch:{ all -> 0x0262 }
        L_0x021c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0262 }
            r2.<init>()     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = r10.versionName     // Catch:{ all -> 0x0262 }
            r2.append(r4)     // Catch:{ all -> 0x0262 }
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            r7.pluginUpdate(r3, r10, r13)     // Catch:{ all -> 0x0262 }
            r2 = r12
            goto L_0x023c
        L_0x022e:
            e.c.f.d.a r2 = r7.loadedPluginDB     // Catch:{ all -> 0x0262 }
            int r4 = r10.key     // Catch:{ all -> 0x0262 }
            int r4 = r4 + r15
            java.lang.String r5 = r10.versionName     // Catch:{ all -> 0x0262 }
            r2.a(r4, r5)     // Catch:{ all -> 0x0262 }
            r3.delete()     // Catch:{ all -> 0x0262 }
        L_0x023b:
            r2 = 0
        L_0x023c:
            if (r2 != 0) goto L_0x025c
            e.c.f.c.a()     // Catch:{ all -> 0x0262 }
            android.content.Context r2 = r7.context     // Catch:{ all -> 0x0262 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0262 }
            e.c.f.f.g r2 = e.c.f.f.g.a(r2)     // Catch:{ all -> 0x0262 }
            java.lang.String r3 = r8.packageName     // Catch:{ all -> 0x0262 }
            com.baidu.sofire.core.ApkInfo r2 = r2.c(r3)     // Catch:{ all -> 0x0262 }
            if (r2 != 0) goto L_0x025c
            e.c.f.f.d r2 = r7.forHostAPP     // Catch:{ all -> 0x0262 }
            int r3 = r8.key     // Catch:{ all -> 0x0262 }
            java.lang.String r4 = r8.versionName     // Catch:{ all -> 0x0262 }
            r2.a(r3, r4, r0)     // Catch:{ all -> 0x0262 }
        L_0x025c:
            if (r1 == 0) goto L_0x0261
            r7.handlePluginDownError(r8, r11, r13, r14)     // Catch:{ all -> 0x0262 }
        L_0x0261:
            return
        L_0x0262:
            e.c.f.c.d()
            r0 = 2
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r1 = r7.mUpgradeResultMap     // Catch:{ all -> 0x0293 }
            if (r1 == 0) goto L_0x0296
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r1 = r7.mUpgradeResultMap     // Catch:{ all -> 0x0293 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0293 }
            int r2 = r8.key     // Catch:{ all -> 0x0293 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0293 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0293 }
            if (r1 != 0) goto L_0x0296
            android.content.Context r1 = r7.context     // Catch:{ all -> 0x0293 }
            int r1 = e.c.f.n.a.g(r1)     // Catch:{ all -> 0x0293 }
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r2 = r7.mUpgradeResultMap     // Catch:{ all -> 0x0293 }
            int r3 = r8.key     // Catch:{ all -> 0x0293 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0293 }
            com.baidu.sofire.ac.U$UpgradeResult r4 = new com.baidu.sofire.ac.U$UpgradeResult     // Catch:{ all -> 0x0293 }
            r4.<init>(r1, r0)     // Catch:{ all -> 0x0293 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0293 }
            goto L_0x0296
        L_0x0293:
            e.c.f.c.d()
        L_0x0296:
            e.c.f.i r1 = r7.preference     // Catch:{ all -> 0x02f1 }
            java.util.List r1 = r1.f()     // Catch:{ all -> 0x02f1 }
            int r2 = r7.mFrom     // Catch:{ all -> 0x02f1 }
            if (r2 == r12) goto L_0x02a9
            int r2 = r7.mFrom     // Catch:{ all -> 0x02f1 }
            if (r2 == r0) goto L_0x02a9
            int r0 = r7.mFrom     // Catch:{ all -> 0x02f1 }
            r2 = 3
            if (r0 != r2) goto L_0x02f0
        L_0x02a9:
            int r0 = r8.key     // Catch:{ all -> 0x02f1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x02f1 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            boolean r0 = r1.contains(r0)     // Catch:{ all -> 0x02f1 }
            if (r0 == 0) goto L_0x02ca
            boolean r0 = sSetRetrmAlarm     // Catch:{ all -> 0x02f1 }
            if (r0 != 0) goto L_0x02ca
            sSetRetrmAlarm = r12     // Catch:{ all -> 0x02f1 }
            android.content.Context r0 = r7.context     // Catch:{ all -> 0x02f1 }
            int r1 = sRetryDownoadHostCareApksTimesCount     // Catch:{ all -> 0x02f1 }
            r2 = 0
            e.c.d.n.e.a(r0, r1, r2)     // Catch:{ all -> 0x02f1 }
            int r0 = sRetryDownoadHostCareApksTimesCount     // Catch:{ all -> 0x02f1 }
            int r0 = r0 + r12
            sRetryDownoadHostCareApksTimesCount = r0     // Catch:{ all -> 0x02f1 }
        L_0x02ca:
            boolean r0 = sMonitorNetworkWhenUpgradeNoNet     // Catch:{ all -> 0x02f1 }
            if (r0 != 0) goto L_0x02f0
            android.content.IntentFilter r0 = new android.content.IntentFilter     // Catch:{ all -> 0x02f1 }
            r0.<init>(r9)     // Catch:{ all -> 0x02f1 }
            com.baidu.sofire.MyReceiver r1 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x02f1 }
            if (r1 != 0) goto L_0x02e2
            com.baidu.sofire.MyReceiver r1 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x02f1 }
            r1.<init>()     // Catch:{ all -> 0x02f1 }
            r1.a()     // Catch:{ all -> 0x02f1 }
            e.c.f.n.a.f7040e = r1     // Catch:{ all -> 0x02f1 }
            goto L_0x02e7
        L_0x02e2:
            com.baidu.sofire.MyReceiver r1 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x02f1 }
            r1.a()     // Catch:{ all -> 0x02f1 }
        L_0x02e7:
            android.content.Context r1 = r7.context     // Catch:{ all -> 0x02f1 }
            com.baidu.sofire.MyReceiver r2 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x02f1 }
            e.c.f.n.a.a(r1, r2, r0)     // Catch:{ all -> 0x02f1 }
            sMonitorNetworkWhenUpgradeNoNet = r12     // Catch:{ all -> 0x02f1 }
        L_0x02f0:
            return
        L_0x02f1:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.U.handlePluginUpgrade(com.baidu.sofire.core.ApkInfo):void");
    }

    private void handleThreadEnd(String str) {
        String str2 = "";
        try {
            this.preference.d(this.preference.f7007a.getInt("sufzfd", 0) + 1);
            if (this.mEndReason != 0) {
                this.preference.a(1, this.mEndReason, this.preference.a(1, this.mEndReason) + 1);
            }
        } catch (Throwable unused) {
            c.d();
        }
        try {
            HashMap hashMap = new HashMap();
            String str3 = "1";
            if (this.mStartKeyMap != null) {
                hashMap.put(str3, this.mStartKeyMap.keySet());
                hashMap.put("2", this.mStartKeyMap.values());
            }
            hashMap.put("3", Integer.valueOf(this.mFrom));
            if (this.mCloudKeyMap != null) {
                hashMap.put("4", this.mCloudKeyMap.keySet());
                hashMap.put("5", this.mCloudKeyMap.values());
            }
            if (this.mUnloadPluginsList != null) {
                hashMap.put(Constants.VIA_SHARE_TYPE_INFO, this.mUnloadPluginsList);
            }
            if (this.mDownloadPluginsList != null) {
                hashMap.put("7", this.mDownloadPluginsList);
            }
            if (this.mUpgradeResultMap != null) {
                JSONObject jSONObject = new JSONObject();
                for (Entry entry : this.mUpgradeResultMap.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    int intValue = ((Integer) entry.getKey()).intValue();
                    UpgradeResult upgradeResult = (UpgradeResult) entry.getValue();
                    if (upgradeResult != null) {
                        jSONObject2.put(str3, upgradeResult.networkId);
                        jSONObject2.put("0", upgradeResult.resultId);
                    }
                    jSONObject.put(String.valueOf(intValue), jSONObject2);
                }
                hashMap.put(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, jSONObject);
            }
            HashMap hashMap2 = (HashMap) this.loadedPluginDB.b();
            hashMap.put("9", hashMap2.keySet());
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, hashMap2.values());
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, Integer.valueOf(this.mEndReason));
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, str.replace("\n", str2).replace("\t", str2).replace("\r", str2));
            }
            hashMap.put("13", Integer.valueOf(this.mStartNetwork));
            hashMap.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Integer.valueOf(e.c.f.n.a.g(this.context)));
            e.c.f.n.a.a(this.context, "1003129", (Map<String, Object>) hashMap);
        } catch (Throwable unused2) {
            c.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r13.preference.c(0);
        r13.preference.d(0);
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c9, code lost:
        if (r1 <= 6) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00cb, code lost:
        r13.preference.a(0, r1, 0);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d3, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d4, code lost:
        if (r1 <= 11) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d6, code lost:
        r13.preference.a(1, r1, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00db, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00de, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e1, code lost:
        e.c.f.c.d();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00be */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00fe A[Catch:{ all -> 0x0117 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleThreadStart() {
        /*
            r13 = this;
            java.lang.String r0 = "sustfd"
            java.lang.String r1 = "slruct"
            r2 = 1
            r3 = 11
            r4 = 6
            r5 = 0
            e.c.f.i r6 = r13.preference     // Catch:{ all -> 0x00be }
            android.content.SharedPreferences r6 = r6.f7007a     // Catch:{ all -> 0x00be }
            r7 = 0
            long r9 = r6.getLong(r1, r7)     // Catch:{ all -> 0x00be }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00be }
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x00af
            long r7 = r11 - r9
            r9 = 86400000(0x5265c00, double:4.2687272E-316)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x00af
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x00be }
            r6.<init>()     // Catch:{ all -> 0x00be }
            java.lang.String r7 = "1"
            e.c.f.i r8 = r13.preference     // Catch:{ all -> 0x00be }
            android.content.SharedPreferences r8 = r8.f7007a     // Catch:{ all -> 0x00be }
            int r8 = r8.getInt(r0, r5)     // Catch:{ all -> 0x00be }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00be }
            r6.put(r7, r8)     // Catch:{ all -> 0x00be }
            e.c.f.i r7 = r13.preference     // Catch:{ all -> 0x00be }
            r7.c(r5)     // Catch:{ all -> 0x00be }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x00be }
            r7.<init>()     // Catch:{ all -> 0x00be }
            r8 = r2
        L_0x0045:
            if (r8 > r4) goto L_0x005c
            e.c.f.i r9 = r13.preference     // Catch:{ all -> 0x00be }
            int r9 = r9.a(r5, r8)     // Catch:{ all -> 0x00be }
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00be }
            r7.put(r10, r9)     // Catch:{ all -> 0x00be }
            e.c.f.i r9 = r13.preference     // Catch:{ all -> 0x00be }
            r9.a(r5, r8, r5)     // Catch:{ all -> 0x00be }
            int r8 = r8 + 1
            goto L_0x0045
        L_0x005c:
            java.lang.String r8 = "2"
            r6.put(r8, r7)     // Catch:{ all -> 0x00be }
            java.lang.String r7 = "3"
            e.c.f.i r8 = r13.preference     // Catch:{ all -> 0x00be }
            android.content.SharedPreferences r8 = r8.f7007a     // Catch:{ all -> 0x00be }
            java.lang.String r9 = "sufzfd"
            int r8 = r8.getInt(r9, r5)     // Catch:{ all -> 0x00be }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x00be }
            r6.put(r7, r8)     // Catch:{ all -> 0x00be }
            e.c.f.i r7 = r13.preference     // Catch:{ all -> 0x00be }
            r7.d(r5)     // Catch:{ all -> 0x00be }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x00be }
            r7.<init>()     // Catch:{ all -> 0x00be }
            r8 = r2
        L_0x007f:
            if (r8 > r3) goto L_0x0096
            e.c.f.i r9 = r13.preference     // Catch:{ all -> 0x00be }
            int r9 = r9.a(r2, r8)     // Catch:{ all -> 0x00be }
            java.lang.String r10 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00be }
            r7.put(r10, r9)     // Catch:{ all -> 0x00be }
            e.c.f.i r9 = r13.preference     // Catch:{ all -> 0x00be }
            r9.a(r2, r8, r5)     // Catch:{ all -> 0x00be }
            int r8 = r8 + 1
            goto L_0x007f
        L_0x0096:
            java.lang.String r8 = "4"
            r6.put(r8, r7)     // Catch:{ all -> 0x00be }
            android.content.Context r7 = r13.context     // Catch:{ all -> 0x00be }
            java.lang.String r8 = "1003128"
            e.c.f.n.a.a(r7, r8, r6)     // Catch:{ all -> 0x00be }
            e.c.f.i r6 = r13.preference     // Catch:{ all -> 0x00be }
            android.content.SharedPreferences$Editor r7 = r6.f7009c     // Catch:{ all -> 0x00be }
            r7.putLong(r1, r11)     // Catch:{ all -> 0x00be }
            android.content.SharedPreferences$Editor r1 = r6.f7009c     // Catch:{ all -> 0x00be }
            r1.commit()     // Catch:{ all -> 0x00be }
            goto L_0x00e4
        L_0x00af:
            if (r6 != 0) goto L_0x00e4
            e.c.f.i r6 = r13.preference     // Catch:{ all -> 0x00be }
            android.content.SharedPreferences$Editor r7 = r6.f7009c     // Catch:{ all -> 0x00be }
            r7.putLong(r1, r11)     // Catch:{ all -> 0x00be }
            android.content.SharedPreferences$Editor r1 = r6.f7009c     // Catch:{ all -> 0x00be }
            r1.commit()     // Catch:{ all -> 0x00be }
            goto L_0x00e4
        L_0x00be:
            e.c.f.i r1 = r13.preference     // Catch:{ all -> 0x00de }
            r1.c(r5)     // Catch:{ all -> 0x00de }
            e.c.f.i r1 = r13.preference     // Catch:{ all -> 0x00de }
            r1.d(r5)     // Catch:{ all -> 0x00de }
            r1 = r2
        L_0x00c9:
            if (r1 > r4) goto L_0x00d3
            e.c.f.i r6 = r13.preference     // Catch:{ all -> 0x00de }
            r6.a(r5, r1, r5)     // Catch:{ all -> 0x00de }
            int r1 = r1 + 1
            goto L_0x00c9
        L_0x00d3:
            r1 = r2
        L_0x00d4:
            if (r1 > r3) goto L_0x00e1
            e.c.f.i r4 = r13.preference     // Catch:{ all -> 0x00de }
            r4.a(r2, r1, r5)     // Catch:{ all -> 0x00de }
            int r1 = r1 + 1
            goto L_0x00d4
        L_0x00de:
            e.c.f.c.d()
        L_0x00e1:
            e.c.f.c.d()
        L_0x00e4:
            e.c.f.d.a r1 = r13.loadedPluginDB     // Catch:{ all -> 0x0117 }
            java.util.Map r1 = r1.b()     // Catch:{ all -> 0x0117 }
            r13.mStartKeyMap = r1     // Catch:{ all -> 0x0117 }
            e.c.f.i r1 = r13.preference     // Catch:{ all -> 0x0117 }
            e.c.f.i r3 = r13.preference     // Catch:{ all -> 0x0117 }
            android.content.SharedPreferences r3 = r3.f7007a     // Catch:{ all -> 0x0117 }
            int r0 = r3.getInt(r0, r5)     // Catch:{ all -> 0x0117 }
            int r0 = r0 + r2
            r1.c(r0)     // Catch:{ all -> 0x0117 }
            int r0 = r13.mFrom     // Catch:{ all -> 0x0117 }
            if (r0 == 0) goto L_0x010e
            e.c.f.i r0 = r13.preference     // Catch:{ all -> 0x0117 }
            int r1 = r13.mFrom     // Catch:{ all -> 0x0117 }
            e.c.f.i r3 = r13.preference     // Catch:{ all -> 0x0117 }
            int r4 = r13.mFrom     // Catch:{ all -> 0x0117 }
            int r3 = r3.a(r5, r4)     // Catch:{ all -> 0x0117 }
            int r3 = r3 + r2
            r0.a(r5, r1, r3)     // Catch:{ all -> 0x0117 }
        L_0x010e:
            android.content.Context r0 = r13.context     // Catch:{ all -> 0x0117 }
            int r0 = e.c.f.n.a.g(r0)     // Catch:{ all -> 0x0117 }
            r13.mStartNetwork = r0     // Catch:{ all -> 0x0117 }
            return
        L_0x0117:
            e.c.f.c.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.U.handleThreadStart():void");
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Object, java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v11, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v16 */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r6v22, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r6v25, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r6v26 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r24v5 */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r24v7 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r6v34 */
    /* JADX WARNING: type inference failed for: r9v12 */
    /* JADX WARNING: type inference failed for: r9v13, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r24v9 */
    /* JADX WARNING: type inference failed for: r6v36 */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r6v45 */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r24v12 */
    /* JADX WARNING: type inference failed for: r24v13 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r9v15 */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r24v14 */
    /* JADX WARNING: type inference failed for: r6v46 */
    /* JADX WARNING: type inference failed for: r24v15 */
    /* JADX WARNING: type inference failed for: r24v16 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r24v17 */
    /* JADX WARNING: type inference failed for: r24v18 */
    /* JADX WARNING: type inference failed for: r24v19 */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:85|86|87) */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02d3, code lost:
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        e.c.f.c.d();
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02d6, code lost:
        r15 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:112:0x0394 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x02d3 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v13
  assigns: []
  uses: []
  mth insns count: 572
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
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0576  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x059e  */
    /* JADX WARNING: Unknown variable types count: 17 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pluginUpdate(java.io.File r26, com.baidu.sofire.core.ApkInfo r27, int r28) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            r2 = r27
            r3 = r28
            java.lang.String r4 = r26.getAbsolutePath()
            r5 = 1
            e.c.f.n.a.a(r4, r5)
            e.c.f.i r4 = r1.preference
            boolean r4 = r4.b()
            if (r4 == 0) goto L_0x0055
            java.io.File r4 = new java.io.File
            android.content.Context r6 = r1.context
            java.io.File r6 = r6.getFilesDir()
            java.lang.String r7 = ".b"
            r4.<init>(r6, r7)
            boolean r6 = r4.exists()
            if (r6 != 0) goto L_0x002e
            r4.mkdir()
        L_0x002e:
            java.io.File r6 = new java.io.File
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            int r8 = r2.key
            r7.append(r8)
            java.lang.String r8 = "-"
            r7.append(r8)
            java.lang.String r8 = r2.versionName
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r4, r7)
            e.c.f.n.a.a(r0, r6)
            android.content.Context r4 = r1.context
            int r7 = r2.key
            e.c.f.e.a(r4, r7, r0, r6)
        L_0x0055:
            java.lang.String r4 = r26.getAbsolutePath()
            r2.pkgPath = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "before update, time="
            r4.<init>(r6)
            long r7 = java.lang.System.currentTimeMillis()
            r4.append(r7)
            java.lang.String r7 = ", downloadAPK path:"
            r4.append(r7)
            java.lang.String r7 = r26.getAbsolutePath()
            r4.append(r7)
            java.lang.String r7 = ", exists="
            r4.append(r7)
            boolean r8 = r26.exists()
            r4.append(r8)
            java.lang.String r8 = ", canRead="
            r4.append(r8)
            boolean r9 = r26.canRead()
            r4.append(r9)
            java.lang.String r9 = ", isFile="
            r4.append(r9)
            boolean r10 = r26.isFile()
            r4.append(r10)
            java.lang.String r10 = ",length"
            r4.append(r10)
            long r11 = r26.length()
            r4.append(r11)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r6)
            long r12 = java.lang.System.currentTimeMillis()
            r11.append(r12)
            java.lang.String r6 = ", "
            r11.append(r6)
            java.lang.String r6 = r11.toString()
            r4.<init>(r6)
            e.c.f.d.a r6 = r1.loadedPluginDB
            int r11 = r2.key
            com.baidu.sofire.core.ApkInfo r6 = r6.a(r11)
            if (r6 != 0) goto L_0x00d3
            java.lang.String r6 = "apkInDB == null"
            r4.append(r6)
            goto L_0x0117
        L_0x00d3:
            java.io.File r11 = new java.io.File
            java.lang.String r6 = r6.pkgPath
            r11.<init>(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r12 = "origAPK path:"
            r6.<init>(r12)
            java.lang.String r12 = r11.getAbsolutePath()
            r6.append(r12)
            r6.append(r7)
            boolean r12 = r11.exists()
            r6.append(r12)
            r6.append(r8)
            boolean r12 = r11.canRead()
            r6.append(r12)
            r6.append(r9)
            boolean r12 = r11.isFile()
            r6.append(r12)
            r6.append(r10)
            long r11 = r11.length()
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r4.append(r6)
        L_0x0117:
            e.c.f.f.d r4 = r1.forHostAPP
            if (r4 == 0) goto L_0x05e0
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            java.lang.String r12 = "\r"
            java.lang.String r13 = "\t"
            java.lang.String r14 = "\n"
            java.lang.String r15 = "3"
            java.lang.String r6 = "1003106"
            java.lang.String r5 = "2"
            java.lang.String r3 = "1"
            java.lang.String r1 = "0"
            r17 = r11
            java.lang.String r11 = ""
            r18 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            e.c.f.c.a()
            r4 = 0
            r19 = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.io.File r4 = new java.io.File
            r21 = r6
            java.lang.String r6 = r2.pkgPath
            r4.<init>(r6)
            boolean r22 = e.c.f.n.a.a(r4)     // Catch:{ all -> 0x04da }
            if (r22 != 0) goto L_0x0218
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x020b }
            r6.<init>()     // Catch:{ all -> 0x020b }
            r23 = r15
            r16 = 1
            java.lang.Integer r15 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0202 }
            r6.put(r1, r15)     // Catch:{ all -> 0x0202 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0202 }
            r15.<init>()     // Catch:{ all -> 0x0202 }
            r24 = r1
            int r1 = r2.key     // Catch:{ all -> 0x01fe }
            r15.append(r1)     // Catch:{ all -> 0x01fe }
            java.lang.String r1 = r15.toString()     // Catch:{ all -> 0x01fe }
            r6.put(r3, r1)     // Catch:{ all -> 0x01fe }
            java.lang.String r1 = r2.versionName     // Catch:{ all -> 0x01fe }
            r6.put(r5, r1)     // Catch:{ all -> 0x01fe }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fe }
            java.lang.String r15 = "nowTime:"
            r1.<init>(r15)     // Catch:{ all -> 0x01fe }
            r15 = r3
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01f6 }
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = ", nowFileInfo: path="
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = r4.getAbsolutePath()     // Catch:{ all -> 0x01f6 }
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            r1.append(r7)     // Catch:{ all -> 0x01f6 }
            boolean r2 = r4.exists()     // Catch:{ all -> 0x01f6 }
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            r1.append(r8)     // Catch:{ all -> 0x01f6 }
            boolean r2 = r4.canRead()     // Catch:{ all -> 0x01f6 }
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            r1.append(r9)     // Catch:{ all -> 0x01f6 }
            boolean r2 = r4.isFile()     // Catch:{ all -> 0x01f6 }
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            r1.append(r10)     // Catch:{ all -> 0x01f6 }
            long r2 = r4.length()     // Catch:{ all -> 0x01f6 }
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = " - "
            r1.append(r2)     // Catch:{ all -> 0x01f6 }
            r1.append(r0)     // Catch:{ all -> 0x01f6 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01f6 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x01f6 }
            r1 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ all -> 0x01f6 }
            java.lang.String r0 = r0.replace(r14, r11)     // Catch:{ all -> 0x01f6 }
            java.lang.String r0 = r0.replace(r13, r11)     // Catch:{ all -> 0x01f6 }
            java.lang.String r0 = r0.replace(r12, r11)     // Catch:{ all -> 0x01f6 }
            r1 = r23
            r6.put(r1, r0)     // Catch:{ all -> 0x01f0 }
            android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x01f0 }
            r2 = r19
            e.c.f.n.a.a(r0, r2, r6)     // Catch:{ all -> 0x01ee }
            goto L_0x02d9
        L_0x01ee:
            r0 = move-exception
            goto L_0x01f3
        L_0x01f0:
            r0 = move-exception
            r2 = r19
        L_0x01f3:
            r23 = r1
            goto L_0x01f9
        L_0x01f6:
            r0 = move-exception
            r2 = r19
        L_0x01f9:
            r10 = r15
            r3 = r18
            goto L_0x04d5
        L_0x01fe:
            r0 = move-exception
            r2 = r19
            goto L_0x0213
        L_0x0202:
            r0 = move-exception
            r2 = r19
            r6 = r1
            r10 = r3
            r3 = r18
            goto L_0x04d7
        L_0x020b:
            r0 = move-exception
            r24 = r1
            r1 = r15
            r2 = r19
            r23 = r1
        L_0x0213:
            r10 = r3
            r3 = r18
            goto L_0x04d5
        L_0x0218:
            r24 = r1
            r1 = r15
            r2 = r19
            r15 = r3
            r3 = r18
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04d1 }
            r6 = r27
            int r7 = r6.key     // Catch:{ all -> 0x04d1 }
            boolean r0 = r0.b(r7)     // Catch:{ all -> 0x04d1 }
            if (r0 != 0) goto L_0x0231
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04d1 }
            r0.a(r6)     // Catch:{ all -> 0x04d1 }
        L_0x0231:
            android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04d1 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ all -> 0x04d1 }
            e.c.f.f.g r0 = e.c.f.f.g.a(r0)     // Catch:{ all -> 0x04d1 }
            e.c.f.d.a r7 = r3.f6945d     // Catch:{ all -> 0x04d1 }
            int r8 = r6.key     // Catch:{ all -> 0x04d1 }
            r9 = 1
            r7.a(r8, r9)     // Catch:{ all -> 0x04cc }
            java.lang.String r7 = r6.packageName     // Catch:{ all -> 0x04cc }
            e.c.f.f.d.b(r7)     // Catch:{ all -> 0x04cc }
            boolean r7 = r0.a(r6, r9)     // Catch:{ all -> 0x04cc }
            r8 = 2
            if (r7 != 0) goto L_0x029d
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0294 }
            r0.<init>()     // Catch:{ all -> 0x0294 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0294 }
            r9 = r24
            r0.put(r9, r7)     // Catch:{ all -> 0x0291 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0291 }
            r7.<init>()     // Catch:{ all -> 0x0291 }
            int r8 = r6.key     // Catch:{ all -> 0x0291 }
            r7.append(r8)     // Catch:{ all -> 0x0291 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0291 }
            r10 = r15
            r0.put(r10, r7)     // Catch:{ all -> 0x04c9 }
            java.lang.String r7 = r6.versionName     // Catch:{ all -> 0x04c9 }
            r0.put(r5, r7)     // Catch:{ all -> 0x04c9 }
            android.content.Context r7 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04c9 }
            e.c.f.n.a.a(r7, r2, r0)     // Catch:{ all -> 0x04c9 }
            e.c.f.e.a(r4)     // Catch:{ all -> 0x04c9 }
            r4.delete()     // Catch:{ all -> 0x04c9 }
            int r0 = r6.key     // Catch:{ all -> 0x04c9 }
            java.lang.String r7 = r6.versionName     // Catch:{ all -> 0x04c9 }
            r8 = 0
            r15 = 1
            r3.a(r0, r7, r15, r8)     // Catch:{ all -> 0x04c9 }
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04c9 }
            int r7 = r6.key     // Catch:{ all -> 0x04c9 }
            r8 = 0
            r0.a(r7, r8)     // Catch:{ all -> 0x04c9 }
            goto L_0x02d9
        L_0x0291:
            r0 = move-exception
            r10 = r15
            goto L_0x0298
        L_0x0294:
            r0 = move-exception
            r10 = r15
            r9 = r24
        L_0x0298:
            r23 = r1
            r6 = r9
            goto L_0x04d7
        L_0x029d:
            r10 = r15
            r9 = r24
            android.content.Context r7 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04c9 }
            java.lang.String[] r7 = e.c.f.n.a.e(r7)     // Catch:{ all -> 0x04c9 }
            if (r7 == 0) goto L_0x02c3
            int r15 = r7.length     // Catch:{ all -> 0x04c9 }
            if (r15 != r8) goto L_0x02c3
            r15 = 0
            r18 = r7[r15]     // Catch:{ all -> 0x04c9 }
            boolean r18 = android.text.TextUtils.isEmpty(r18)     // Catch:{ all -> 0x04c9 }
            if (r18 != 0) goto L_0x02c3
            r16 = 1
            r18 = r7[r16]     // Catch:{ all -> 0x04c9 }
            boolean r18 = android.text.TextUtils.isEmpty(r18)     // Catch:{ all -> 0x04c9 }
            if (r18 != 0) goto L_0x02c3
            r18 = r7[r15]     // Catch:{ all -> 0x04c9 }
            r7 = r7[r16]     // Catch:{ all -> 0x04c9 }
            goto L_0x02c7
        L_0x02c3:
            java.lang.String r7 = "925fc15df8a49bed0b3eca8d2b44cb7b"
            r18 = r1
        L_0x02c7:
            java.lang.String r15 = r6.pkgPath     // Catch:{ all -> 0x04c9 }
            java.util.Map<java.lang.String, com.baidu.sofire.core.ApkInfo> r0 = r0.f6984c     // Catch:{ all -> 0x02d3 }
            java.lang.Object r0 = r0.get(r15)     // Catch:{ all -> 0x02d3 }
            com.baidu.sofire.core.ApkInfo r0 = (com.baidu.sofire.core.ApkInfo) r0     // Catch:{ all -> 0x02d3 }
            r15 = r0
            goto L_0x02d7
        L_0x02d3:
            e.c.f.c.d()     // Catch:{ all -> 0x04c9 }
            r15 = 0
        L_0x02d7:
            if (r15 != 0) goto L_0x02dc
        L_0x02d9:
            r4 = 0
            goto L_0x0551
        L_0x02dc:
            java.lang.ClassLoader r0 = r15.classLoader     // Catch:{ all -> 0x04c4 }
            e.c.f.f.f r0 = (e.c.f.f.f) r0     // Catch:{ all -> 0x04c4 }
            java.lang.String r8 = "com.baidu.sofire.engine.EngineImpl"
            java.lang.Class r8 = r0.a(r8)     // Catch:{ all -> 0x04c4 }
            if (r8 != 0) goto L_0x0360
            java.lang.String r7 = "java.lang.String"
            java.lang.Class r7 = r0.a(r7)     // Catch:{ all -> 0x035c }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x035c }
            r8.<init>()     // Catch:{ all -> 0x035c }
            r17 = 6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x035c }
            r8.put(r9, r6)     // Catch:{ all -> 0x035c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x035c }
            r6.<init>()     // Catch:{ all -> 0x035c }
            r24 = r9
            int r9 = r15.key     // Catch:{ all -> 0x04c1 }
            r6.append(r9)     // Catch:{ all -> 0x04c1 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x04c1 }
            r8.put(r10, r6)     // Catch:{ all -> 0x04c1 }
            java.lang.String r6 = r15.versionName     // Catch:{ all -> 0x04c1 }
            r8.put(r5, r6)     // Catch:{ all -> 0x04c1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x04c1 }
            java.lang.String r9 = "classloader="
            r6.<init>(r9)     // Catch:{ all -> 0x04c1 }
            r6.append(r0)     // Catch:{ all -> 0x04c1 }
            java.lang.String r0 = ",StringClass="
            r6.append(r0)     // Catch:{ all -> 0x04c1 }
            r6.append(r7)     // Catch:{ all -> 0x04c1 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x04c1 }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x04c1 }
            r6 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r6)     // Catch:{ all -> 0x04c1 }
            java.lang.String r0 = r0.replace(r14, r11)     // Catch:{ all -> 0x04c1 }
            java.lang.String r0 = r0.replace(r13, r11)     // Catch:{ all -> 0x04c1 }
            java.lang.String r0 = r0.replace(r12, r11)     // Catch:{ all -> 0x04c1 }
            r8.put(r1, r0)     // Catch:{ all -> 0x04c1 }
            android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04c1 }
            e.c.f.n.a.a(r0, r2, r8)     // Catch:{ all -> 0x04c1 }
            e.c.f.e.a(r4)     // Catch:{ all -> 0x04c1 }
            r4.delete()     // Catch:{ all -> 0x04c1 }
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04c1 }
            int r6 = r15.key     // Catch:{ all -> 0x04c1 }
            r7 = 0
            r0.a(r6, r7)     // Catch:{ all -> 0x04c1 }
            goto L_0x02d9
        L_0x0356:
            r23 = r1
        L_0x0358:
            r6 = r24
            goto L_0x04e4
        L_0x035c:
            r0 = move-exception
            r24 = r9
            goto L_0x0356
        L_0x0360:
            r24 = r9
            java.lang.String r0 = "getInstance"
            r6 = 1
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ all -> 0x04c1 }
            java.lang.Class<android.content.Context> r16 = android.content.Context.class
            r20 = 0
            r9[r20] = r16     // Catch:{ all -> 0x04c1 }
            java.lang.reflect.Method r0 = r8.getDeclaredMethod(r0, r9)     // Catch:{ all -> 0x04c1 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x04c1 }
            android.content.Context r6 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04c1 }
            r9[r20] = r6     // Catch:{ all -> 0x04c1 }
            java.lang.Object r0 = r0.invoke(r8, r9)     // Catch:{ all -> 0x04c1 }
            java.lang.String r6 = "setSecurityVerifyInfo"
            r8 = 2
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ all -> 0x0392 }
            r9[r20] = r17     // Catch:{ all -> 0x0392 }
            r16 = 1
            r9[r16] = r17     // Catch:{ all -> 0x0392 }
            r23 = r1
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ all -> 0x0394 }
            r1[r20] = r18     // Catch:{ all -> 0x0394 }
            r1[r16] = r7     // Catch:{ all -> 0x0394 }
            e.c.f.n.a.a(r0, r6, (java.lang.Class<?>[]) r9, r1)     // Catch:{ all -> 0x0394 }
            goto L_0x0397
        L_0x0392:
            r23 = r1
        L_0x0394:
            e.c.f.c.d()     // Catch:{ all -> 0x04be }
        L_0x0397:
            java.lang.String r1 = "init"
            r6 = 2
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x04be }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ all -> 0x04be }
            r9 = 0
            r7[r9] = r8     // Catch:{ all -> 0x04be }
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x04be }
            r16 = 1
            r7[r16] = r8     // Catch:{ all -> 0x04be }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x04be }
            r6[r9] = r21     // Catch:{ all -> 0x04be }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x04be }
            r6[r16] = r8     // Catch:{ all -> 0x04be }
            java.lang.Object r0 = e.c.f.n.a.a(r0, r1, (java.lang.Class<?>[]) r7, r6)     // Catch:{ all -> 0x04be }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x04be }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x04be }
            if (r0 != 0) goto L_0x0405
            e.c.f.e.a(r4)     // Catch:{ all -> 0x04be }
            java.lang.String r0 = r15.packageName     // Catch:{ all -> 0x04be }
            e.c.f.f.d.b(r0)     // Catch:{ all -> 0x04be }
            r4.delete()     // Catch:{ all -> 0x04be }
            int r0 = r15.key     // Catch:{ all -> 0x04be }
            java.lang.String r1 = r15.versionName     // Catch:{ all -> 0x04be }
            r6 = 0
            r7 = 1
            r3.a(r0, r1, r7, r6)     // Catch:{ all -> 0x04be }
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04be }
            int r1 = r15.key     // Catch:{ all -> 0x04be }
            r6 = 0
            r0.a(r1, r6)     // Catch:{ all -> 0x04be }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x04be }
            r0.<init>()     // Catch:{ all -> 0x04be }
            r1 = 4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x04be }
            r6 = r24
            r0.put(r6, r1)     // Catch:{ all -> 0x04bc }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04bc }
            r1.<init>()     // Catch:{ all -> 0x04bc }
            int r7 = r15.key     // Catch:{ all -> 0x04bc }
            r1.append(r7)     // Catch:{ all -> 0x04bc }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x04bc }
            r0.put(r10, r1)     // Catch:{ all -> 0x04bc }
            java.lang.String r1 = r15.versionName     // Catch:{ all -> 0x04bc }
            r0.put(r5, r1)     // Catch:{ all -> 0x04bc }
            android.content.Context r1 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04bc }
            e.c.f.n.a.a(r1, r2, r0)     // Catch:{ all -> 0x04bc }
            goto L_0x02d9
        L_0x0405:
            r6 = r24
            boolean r0 = r15.isMem     // Catch:{ all -> 0x04bc }
            if (r0 == 0) goto L_0x0425
            e.c.f.e.a(r4)     // Catch:{ all -> 0x04bc }
            r4.delete()     // Catch:{ all -> 0x04bc }
            java.lang.String r0 = r15.dataDir     // Catch:{ all -> 0x04bc }
            e.c.f.n.a.d(r0)     // Catch:{ all -> 0x04bc }
            java.util.List<java.lang.Integer> r0 = e.c.f.f.g.f6981j     // Catch:{ all -> 0x04bc }
            if (r0 == 0) goto L_0x0425
            java.util.List<java.lang.Integer> r0 = e.c.f.f.g.f6981j     // Catch:{ all -> 0x04bc }
            int r1 = r15.key     // Catch:{ all -> 0x04bc }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x04bc }
            r0.add(r1)     // Catch:{ all -> 0x04bc }
        L_0x0425:
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04b6 }
            int r1 = r15.key     // Catch:{ all -> 0x04b6 }
            com.baidu.sofire.core.ApkInfo r0 = r0.a(r1)     // Catch:{ all -> 0x04b6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04b6 }
            r1.<init>()     // Catch:{ all -> 0x04b6 }
            r1.append(r0)     // Catch:{ all -> 0x04b6 }
            if (r0 == 0) goto L_0x0449
            java.lang.String r1 = r0.versionName     // Catch:{ all -> 0x04b6 }
            java.lang.String r4 = r15.versionName     // Catch:{ all -> 0x04b6 }
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x04b6 }
            if (r1 != 0) goto L_0x0449
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x04b6 }
            java.lang.String r0 = r0.pkgPath     // Catch:{ all -> 0x04b6 }
            r1.<init>(r0)     // Catch:{ all -> 0x04b6 }
            goto L_0x044a
        L_0x0449:
            r1 = 0
        L_0x044a:
            r4 = 1
            r15.initStatus = r4     // Catch:{ all -> 0x04b6 }
            r15.apkParseSuc = r4     // Catch:{ all -> 0x04b6 }
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04b6 }
            long r7 = r0.a(r15)     // Catch:{ all -> 0x04b6 }
            r11 = 0
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x0472
            if (r1 == 0) goto L_0x0472
            boolean r0 = r1.exists()     // Catch:{ all -> 0x04b6 }
            if (r0 == 0) goto L_0x0472
            e.c.f.e.a(r1)     // Catch:{ all -> 0x04b6 }
            boolean r0 = r1.delete()     // Catch:{ all -> 0x04b6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04b6 }
            r1.<init>()     // Catch:{ all -> 0x04b6 }
            r1.append(r0)     // Catch:{ all -> 0x04b6 }
        L_0x0472:
            e.c.f.d.a r0 = r3.f6945d     // Catch:{ all -> 0x04b6 }
            int r1 = r15.key     // Catch:{ all -> 0x04b6 }
            r3 = 0
            int r0 = r0.a(r1, r3)     // Catch:{ all -> 0x04b6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04b6 }
            r1.<init>()     // Catch:{ all -> 0x04b6 }
            r1.append(r7)     // Catch:{ all -> 0x04b6 }
            java.lang.String r3 = ", c="
            r1.append(r3)     // Catch:{ all -> 0x04b6 }
            r1.append(r0)     // Catch:{ all -> 0x04b6 }
            android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04b6 }
            e.c.f.n.a.b(r0)     // Catch:{ all -> 0x04b6 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x04b6 }
            r0.<init>()     // Catch:{ all -> 0x04b6 }
            r1 = r21
            r0.put(r6, r1)     // Catch:{ all -> 0x04b6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x04b6 }
            r1.<init>()     // Catch:{ all -> 0x04b6 }
            int r3 = r15.key     // Catch:{ all -> 0x04b6 }
            r1.append(r3)     // Catch:{ all -> 0x04b6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x04b6 }
            r0.put(r10, r1)     // Catch:{ all -> 0x04b6 }
            java.lang.String r1 = r15.versionName     // Catch:{ all -> 0x04b6 }
            r0.put(r5, r1)     // Catch:{ all -> 0x04b6 }
            android.content.Context r1 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x04b6 }
            e.c.f.n.a.a(r1, r2, r0)     // Catch:{ all -> 0x04b6 }
            goto L_0x04b9
        L_0x04b6:
            e.c.f.c.d()
        L_0x04b9:
            r4 = 1
            goto L_0x0551
        L_0x04bc:
            r0 = move-exception
            goto L_0x04e4
        L_0x04be:
            r0 = move-exception
            goto L_0x0358
        L_0x04c1:
            r0 = move-exception
            goto L_0x0356
        L_0x04c4:
            r0 = move-exception
            r23 = r1
            r6 = r9
            goto L_0x04e4
        L_0x04c9:
            r0 = move-exception
            goto L_0x0298
        L_0x04cc:
            r0 = move-exception
            r23 = r1
            r10 = r15
            goto L_0x04d5
        L_0x04d1:
            r0 = move-exception
            r23 = r1
            r10 = r15
        L_0x04d5:
            r6 = r24
        L_0x04d7:
            r15 = r27
            goto L_0x04e4
        L_0x04da:
            r0 = move-exception
            r6 = r1
            r10 = r3
            r23 = r15
            r3 = r18
            r2 = r19
            goto L_0x04d7
        L_0x04e4:
            r0.getMessage()     // Catch:{ all -> 0x054c }
            e.c.f.e.a(r4)     // Catch:{ all -> 0x054c }
            java.lang.String r1 = r15.packageName     // Catch:{ all -> 0x054c }
            e.c.f.f.d.b(r1)     // Catch:{ all -> 0x054c }
            r4.delete()     // Catch:{ all -> 0x054c }
            int r1 = r15.key     // Catch:{ all -> 0x054c }
            java.lang.String r4 = r15.versionName     // Catch:{ all -> 0x054c }
            r7 = 0
            r8 = 1
            r3.a(r1, r4, r8, r7)     // Catch:{ all -> 0x054c }
            e.c.f.d.a r1 = r3.f6945d     // Catch:{ all -> 0x054c }
            int r3 = r15.key     // Catch:{ all -> 0x054c }
            r4 = 0
            r1.a(r3, r4)     // Catch:{ all -> 0x054a }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x054c }
            r1.<init>()     // Catch:{ all -> 0x054c }
            r3 = 5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x054c }
            r1.put(r6, r4)     // Catch:{ all -> 0x054c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x054c }
            r3.<init>()     // Catch:{ all -> 0x054c }
            int r4 = r15.key     // Catch:{ all -> 0x054c }
            r3.append(r4)     // Catch:{ all -> 0x054c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x054c }
            r1.put(r10, r3)     // Catch:{ all -> 0x054c }
            java.lang.String r3 = r15.versionName     // Catch:{ all -> 0x054c }
            r1.put(r5, r3)     // Catch:{ all -> 0x054c }
            java.lang.String r0 = e.c.f.c.a(r0)     // Catch:{ all -> 0x054c }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x054c }
            r3 = 0
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r3)     // Catch:{ all -> 0x054d }
            java.lang.String r0 = r0.replace(r14, r11)     // Catch:{ all -> 0x054d }
            java.lang.String r0 = r0.replace(r13, r11)     // Catch:{ all -> 0x054d }
            java.lang.String r0 = r0.replace(r12, r11)     // Catch:{ all -> 0x054d }
            r4 = r23
            r1.put(r4, r0)     // Catch:{ all -> 0x054d }
            android.content.Context r0 = e.c.f.f.d.f6939f     // Catch:{ all -> 0x054d }
            e.c.f.n.a.a(r0, r2, r1)     // Catch:{ all -> 0x054d }
            goto L_0x0550
        L_0x054a:
            r3 = r4
            goto L_0x054d
        L_0x054c:
            r3 = 0
        L_0x054d:
            e.c.f.c.d()
        L_0x0550:
            r4 = r3
        L_0x0551:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r27
            java.lang.String r2 = r1.packageName
            r0.append(r2)
            java.lang.String r2 = " s="
            r0.append(r2)
            r0.append(r4)
            r2 = r25
            e.c.f.d.a r0 = r2.loadedPluginDB
            int r3 = r1.key
            r5 = 10000000(0x989680, float:1.4012985E-38)
            int r3 = r3 + r5
            java.lang.String r5 = r1.versionName
            r0.a(r3, r5)
            if (r4 != 0) goto L_0x059e
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r0 = r2.mUpgradeResultMap
            if (r0 == 0) goto L_0x05df
            java.util.Set r0 = r0.keySet()
            int r3 = r1.key
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x05df
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r0 = r2.mUpgradeResultMap
            int r1 = r1.key
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.baidu.sofire.ac.U$UpgradeResult r3 = new com.baidu.sofire.ac.U$UpgradeResult
            r4 = r28
            r5 = 5
            r3.<init>(r4, r5)
            r0.put(r1, r3)
            return
        L_0x059e:
            r4 = r28
            e.c.f.d.a r0 = r2.loadedPluginDB
            int r3 = r1.key
            int r0 = r0.g(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "new plugin now loadStatus :"
            r3.<init>(r5)
            int r5 = r1.key
            r3.append(r5)
            java.lang.String r5 = " "
            r3.append(r5)
            r3.append(r0)
            r3 = 3
            if (r0 >= r3) goto L_0x05cc
            r3 = -1
            if (r0 == r3) goto L_0x05cc
            e.c.f.d.a r3 = r2.loadedPluginDB
            int r5 = r1.key
            r6 = 1
            int r0 = r0 + r6
            r3.b(r5, r0)
            goto L_0x05cd
        L_0x05cc:
            r6 = 1
        L_0x05cd:
            java.util.Map<java.lang.Integer, com.baidu.sofire.ac.U$UpgradeResult> r0 = r2.mUpgradeResultMap
            if (r0 == 0) goto L_0x05df
            int r1 = r1.key
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.baidu.sofire.ac.U$UpgradeResult r3 = new com.baidu.sofire.ac.U$UpgradeResult
            r3.<init>(r4, r6)
            r0.put(r1, r3)
        L_0x05df:
            return
        L_0x05e0:
            r2 = r1
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.U.pluginUpdate(java.io.File, com.baidu.sofire.core.ApkInfo, int):void");
    }

    public void handleWork(Context context2, Intent intent) {
        this.context = context2;
        this.loadedPluginDB = a.a(context2);
        this.preference = new i(context2);
        this.tmpDir = new File(context2.getFilesDir(), ".tmp");
        this.forHostAPP = d.a(context2);
        this.mFrom = intent.getIntExtra("from", 0);
        c.a();
        start();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:246|245|247|248|507|249) */
    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        e.c.f.n.a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:?, code lost:
        e.c.f.n.a.a();
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004b, code lost:
        if (r1.mOut == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004f, code lost:
        if (sOutGoing == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0051, code lost:
        sOutGoing = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x0894, code lost:
        if (r1.mEndReason != 0) goto L_0x0899;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:408:0x0896, code lost:
        r1.mEndReason = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0899, code lost:
        handleThreadEnd(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x089f, code lost:
        if (r1.mOut == false) goto L_0x08a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x08a3, code lost:
        if (sOutGoing == false) goto L_0x08a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x08a5, code lost:
        sOutGoing = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:417:0x08a9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:?, code lost:
        e.c.f.n.a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        e.c.f.n.a.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x08ae, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0059, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:115:0x01e7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0011 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:163:0x02fe */
    /* JADX WARNING: Missing exception handler attribute for start block: B:247:0x04f5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:256:0x051b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0055 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:418:0x08aa */
    /* JADX WARNING: Missing exception handler attribute for start block: B:459:0x0922 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:472:0x0956 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:482:0x0966 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:494:0x0979 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x015b */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01bc A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01c5 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0530 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0532 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x054a A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x054c A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x0551 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x055b A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0573 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x05df A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0614 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x062b A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x0630 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x06ca A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x08cf A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x08e4 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x08e9 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x08f1 A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017b A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x018b A[Catch:{ all -> 0x053e, all -> 0x08f9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void run() {
        /*
            r29 = this;
            r1 = r29
            monitor-enter(r29)
            r2 = 1
            boolean r3 = r1.mOut     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x0014
            boolean r3 = sOutGoing     // Catch:{ all -> 0x0011 }
            if (r3 == 0) goto L_0x000e
            monitor-exit(r29)
            return
        L_0x000e:
            sOutGoing = r2     // Catch:{ all -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            e.c.f.n.a.a()     // Catch:{ all -> 0x097d }
        L_0x0014:
            r3 = 0
            java.lang.Class<com.baidu.sofire.ac.U> r4 = com.baidu.sofire.ac.U.class
            monitor-enter(r4)     // Catch:{ all -> 0x08fd }
            super.run()     // Catch:{ all -> 0x08f9 }
            r29.handleThreadStart()     // Catch:{ all -> 0x08f9 }
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            r6 = 600000(0x927c0, double:2.964394E-318)
            r8 = 3
            r9 = 2
            r10 = 0
            if (r5 == r2) goto L_0x005a
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            if (r5 == r9) goto L_0x005a
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            if (r5 == r8) goto L_0x005a
            boolean r5 = r1.mOut     // Catch:{ all -> 0x08f9 }
            if (r5 != 0) goto L_0x005a
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x08f9 }
            long r13 = sLastCheckTime     // Catch:{ all -> 0x08f9 }
            long r11 = r11 - r13
            int r5 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r5 >= 0) goto L_0x005a
            int r2 = r1.mEndReason     // Catch:{ all -> 0x08f9 }
            if (r2 != 0) goto L_0x0048
            r1.mEndReason = r9     // Catch:{ all -> 0x08f9 }
            r1.handleThreadEnd(r10)     // Catch:{ all -> 0x08f9 }
        L_0x0048:
            monitor-exit(r4)     // Catch:{ all -> 0x08f9 }
            boolean r2 = r1.mOut     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0053
            boolean r2 = sOutGoing     // Catch:{ all -> 0x0055 }
            if (r2 == 0) goto L_0x0053
            sOutGoing = r3     // Catch:{ all -> 0x0055 }
        L_0x0053:
            monitor-exit(r29)
            return
        L_0x0055:
            e.c.f.n.a.a()     // Catch:{ all -> 0x097d }
            monitor-exit(r29)
            return
        L_0x005a:
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x08f9 }
            boolean r5 = e.c.f.n.a.d(r5)     // Catch:{ all -> 0x08f9 }
            if (r5 == 0) goto L_0x0068
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x08f9 }
            sLastCheckTime = r11     // Catch:{ all -> 0x08f9 }
        L_0x0068:
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x08f9 }
            r11 = 4
            java.lang.String r12 = "leroadcfg"
            android.content.SharedPreferences r13 = r5.getSharedPreferences(r12, r11)     // Catch:{ all -> 0x008d }
            android.content.SharedPreferences$Editor r14 = r13.edit()     // Catch:{ all -> 0x0089 }
            android.content.SharedPreferences r12 = r5.getSharedPreferences(r12, r11)     // Catch:{ all -> 0x0086 }
            r12.edit()     // Catch:{ all -> 0x0086 }
            java.lang.String r12 = "re_po_rt"
            android.content.SharedPreferences r12 = r5.getSharedPreferences(r12, r11)     // Catch:{ all -> 0x0086 }
            r12.edit()     // Catch:{ all -> 0x0086 }
            goto L_0x0097
        L_0x0086:
            r0 = move-exception
            r12 = r0
            goto L_0x0091
        L_0x0089:
            r0 = move-exception
            r12 = r0
            r14 = r10
            goto L_0x0091
        L_0x008d:
            r0 = move-exception
            r12 = r0
            r13 = r10
            r14 = r13
        L_0x0091:
            r12.getMessage()     // Catch:{ all -> 0x015b }
            e.c.f.c.c()     // Catch:{ all -> 0x015b }
        L_0x0097:
            java.lang.String r12 = "appal_te"
            r15 = 24
            int r12 = r13.getInt(r12, r15)     // Catch:{ all -> 0x015b }
            long r10 = (long) r12     // Catch:{ all -> 0x015b }
            r17 = 3600000(0x36ee80, double:1.7786363E-317)
            long r10 = r10 * r17
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            java.lang.String r9 = "sjh-alarm gap "
            r12.<init>(r9)     // Catch:{ all -> 0x015b }
            java.lang.String r9 = "appal_te"
            int r9 = r13.getInt(r9, r15)     // Catch:{ all -> 0x015b }
            r12.append(r9)     // Catch:{ all -> 0x015b }
            e.c.f.c.a()     // Catch:{ all -> 0x015b }
            java.lang.String r9 = "alarm"
            java.lang.Object r9 = r5.getSystemService(r9)     // Catch:{ all -> 0x015b }
            android.app.AlarmManager r9 = (android.app.AlarmManager) r9     // Catch:{ all -> 0x015b }
            android.content.Intent r12 = new android.content.Intent     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "com.baidu.action.SOFIRE.VIEW"
            r12.<init>(r13)     // Catch:{ all -> 0x015b }
            java.lang.Class<com.baidu.sofire.MyService> r13 = com.baidu.sofire.MyService.class
            r12.setClass(r5, r13)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = r5.getPackageName()     // Catch:{ all -> 0x015b }
            r12.setPackage(r13)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "com.baidu.category.SOFIRE"
            r12.addCategory(r13)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "android.intent.category.DEFAULT"
            r12.addCategory(r13)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "from_plugin_package"
            java.lang.String r15 = r5.getPackageName()     // Catch:{ all -> 0x015b }
            r12.putExtra(r13, r15)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "target_class"
            java.lang.Class<com.baidu.sofire.ac.U> r15 = com.baidu.sofire.ac.U.class
            java.lang.String r15 = r15.getCanonicalName()     // Catch:{ all -> 0x015b }
            r12.putExtra(r13, r15)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "target_method"
            java.lang.String r15 = "handleWork"
            r12.putExtra(r13, r15)     // Catch:{ all -> 0x015b }
            java.lang.String r13 = "from"
            r15 = 6
            r12.putExtra(r13, r15)     // Catch:{ all -> 0x015b }
            r13 = 1000(0x3e8, float:1.401E-42)
            r15 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r5 = android.app.PendingIntent.getService(r5, r13, r12, r15)     // Catch:{ all -> 0x015b }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015b }
            long r12 = r12 + r10
            long r12 = r12 - r6
            r6 = 4697904772475256832(0x41324f8000000000, double:1200000.0)
            double r18 = java.lang.Math.random()     // Catch:{ all -> 0x015b }
            double r6 = r6 * r18
            long r6 = (long) r6     // Catch:{ all -> 0x015b }
            long r12 = r12 + r6
            java.lang.String r6 = "npuct"
            r14.putLong(r6, r12)     // Catch:{ all -> 0x015b }
            r14.commit()     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            java.lang.String r7 = "b=false,"
            r6.<init>(r7)     // Catch:{ all -> 0x015b }
            r6.append(r12)     // Catch:{ all -> 0x015b }
            java.lang.String r7 = ","
            r6.append(r7)     // Catch:{ all -> 0x015b }
            r6.append(r10)     // Catch:{ all -> 0x015b }
            java.lang.String r7 = ","
            r6.append(r7)     // Catch:{ all -> 0x015b }
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x015b }
            r6.append(r10)     // Catch:{ all -> 0x015b }
            e.c.f.c.a()     // Catch:{ all -> 0x015b }
            r9.cancel(r5)     // Catch:{ all -> 0x0146 }
            goto L_0x014e
        L_0x0146:
            r0 = move-exception
            r6 = r0
            r6.getMessage()     // Catch:{ all -> 0x015b }
            e.c.f.c.c()     // Catch:{ all -> 0x015b }
        L_0x014e:
            r9.set(r3, r12, r5)     // Catch:{ all -> 0x0152 }
            goto L_0x015e
        L_0x0152:
            r0 = move-exception
            r5 = r0
            r5.getMessage()     // Catch:{ all -> 0x015b }
            e.c.f.c.c()     // Catch:{ all -> 0x015b }
            goto L_0x015e
        L_0x015b:
            e.c.f.n.a.a()     // Catch:{ all -> 0x08f9 }
        L_0x015e:
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x08f9 }
            e.c.d.n.e.a(r5)     // Catch:{ all -> 0x08f9 }
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            if (r5 == r2) goto L_0x016b
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            if (r5 != r8) goto L_0x0176
        L_0x016b:
            sRetryPingTimesCount = r3     // Catch:{ all -> 0x08f9 }
            sRetryDownoadHostCareApksTimesCount = r3     // Catch:{ all -> 0x08f9 }
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x08f9 }
            e.c.d.n.e.a(r5, r3, r2)     // Catch:{ all -> 0x08f9 }
            sSetRetrmAlarm = r3     // Catch:{ all -> 0x08f9 }
        L_0x0176:
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            r6 = 2
            if (r5 != r6) goto L_0x017d
            sSetRetrmAlarm = r3     // Catch:{ all -> 0x08f9 }
        L_0x017d:
            java.lang.String r5 = "com.baidu.input_huawei"
            android.content.Context r6 = r1.context     // Catch:{ all -> 0x08f9 }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x08f9 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x08f9 }
            if (r5 == 0) goto L_0x01bc
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x08f9 }
            java.lang.String r6 = "leroadcfg"
            r7 = 4
            android.content.SharedPreferences r9 = r5.getSharedPreferences(r6, r7)     // Catch:{ all -> 0x01ab }
            r9.edit()     // Catch:{ all -> 0x01a8 }
            android.content.SharedPreferences r6 = r5.getSharedPreferences(r6, r7)     // Catch:{ all -> 0x01a8 }
            r6.edit()     // Catch:{ all -> 0x01a8 }
            java.lang.String r6 = "re_po_rt"
            android.content.SharedPreferences r5 = r5.getSharedPreferences(r6, r7)     // Catch:{ all -> 0x01a8 }
            r5.edit()     // Catch:{ all -> 0x01a8 }
            goto L_0x01b4
        L_0x01a8:
            r0 = move-exception
            r5 = r0
            goto L_0x01ae
        L_0x01ab:
            r0 = move-exception
            r5 = r0
            r9 = 0
        L_0x01ae:
            r5.getMessage()     // Catch:{ all -> 0x08f9 }
            e.c.f.c.c()     // Catch:{ all -> 0x08f9 }
        L_0x01b4:
            java.lang.String r5 = "s_c_c"
            boolean r5 = r9.getBoolean(r5, r2)     // Catch:{ all -> 0x08f9 }
            r5 = r5 ^ r2
            goto L_0x01bd
        L_0x01bc:
            r5 = r3
        L_0x01bd:
            android.content.Context r6 = r1.context     // Catch:{ all -> 0x08f9 }
            boolean r6 = e.c.f.n.a.d(r6)     // Catch:{ all -> 0x08f9 }
            if (r6 == 0) goto L_0x08af
            if (r5 == 0) goto L_0x01c9
            goto L_0x08af
        L_0x01c9:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x08f9 }
            sLastCheckTime = r5     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.MyReceiver r5 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x08f9 }
            if (r5 == 0) goto L_0x01ea
            boolean r5 = sMonitorNetworkWhenUpgradeNoNet     // Catch:{ all -> 0x08f9 }
            if (r5 != 0) goto L_0x01db
            boolean r5 = e.c.f.n.a.f7036a     // Catch:{ all -> 0x08f9 }
            if (r5 == 0) goto L_0x01ea
        L_0x01db:
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x01e7 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ all -> 0x01e7 }
            com.baidu.sofire.MyReceiver r6 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x01e7 }
            r5.unregisterReceiver(r6)     // Catch:{ all -> 0x01e7 }
            goto L_0x01ea
        L_0x01e7:
            e.c.f.n.a.a()     // Catch:{ all -> 0x08f9 }
        L_0x01ea:
            sMonitorNetworkWhenUpgradeNoNet = r3     // Catch:{ all -> 0x08f9 }
            e.c.f.n.a.f7036a = r3     // Catch:{ all -> 0x08f9 }
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            if (r5 == r2) goto L_0x01fa
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x08f9 }
            org.json.JSONObject r5 = e.c.f.n.a.k(r5)     // Catch:{ all -> 0x08f9 }
            r1.mWholeJson = r5     // Catch:{ all -> 0x08f9 }
        L_0x01fa:
            org.json.JSONObject r5 = r1.mWholeJson     // Catch:{ all -> 0x08f9 }
            if (r5 != 0) goto L_0x0267
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            if (r5 == r2) goto L_0x020f
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            r6 = 2
            if (r5 == r6) goto L_0x020f
            int r5 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            if (r5 != r8) goto L_0x022b
            boolean r5 = sSetRetrmAlarm     // Catch:{ all -> 0x08f9 }
            if (r5 != 0) goto L_0x022b
        L_0x020f:
            e.c.f.i r5 = r1.preference     // Catch:{ all -> 0x08f9 }
            java.util.List r5 = r5.f()     // Catch:{ all -> 0x08f9 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()     // Catch:{ all -> 0x08f9 }
            if (r5 <= 0) goto L_0x022b
            sSetRetrmAlarm = r2     // Catch:{ all -> 0x08f9 }
            android.content.Context r5 = r1.context     // Catch:{ all -> 0x08f9 }
            int r6 = sRetryPingTimesCount     // Catch:{ all -> 0x08f9 }
            e.c.d.n.e.a(r5, r6, r3)     // Catch:{ all -> 0x08f9 }
            int r5 = sRetryPingTimesCount     // Catch:{ all -> 0x08f9 }
            int r5 = r5 + r2
            sRetryPingTimesCount = r5     // Catch:{ all -> 0x08f9 }
        L_0x022b:
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x08f9 }
            java.lang.String r6 = "android.net.conn.CONNECTIVITY_CHANGE"
            r5.<init>(r6)     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.MyReceiver r6 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x08f9 }
            if (r6 != 0) goto L_0x0241
            com.baidu.sofire.MyReceiver r6 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x08f9 }
            r6.<init>()     // Catch:{ all -> 0x08f9 }
            r6.a()     // Catch:{ all -> 0x08f9 }
            e.c.f.n.a.f7040e = r6     // Catch:{ all -> 0x08f9 }
            goto L_0x0246
        L_0x0241:
            com.baidu.sofire.MyReceiver r6 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x08f9 }
            r6.a()     // Catch:{ all -> 0x08f9 }
        L_0x0246:
            android.content.Context r6 = r1.context     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.MyReceiver r7 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x08f9 }
            e.c.f.n.a.a(r6, r7, r5)     // Catch:{ all -> 0x08f9 }
            sMonitorNetworkWhenUpgradeNoNet = r2     // Catch:{ all -> 0x08f9 }
            int r2 = r1.mEndReason     // Catch:{ all -> 0x08f9 }
            if (r2 != 0) goto L_0x025f
            int r2 = e.c.f.n.a.f7039d     // Catch:{ all -> 0x08f9 }
            if (r2 == 0) goto L_0x025c
            int r2 = e.c.f.n.a.f7039d     // Catch:{ all -> 0x08f9 }
            r1.mEndReason = r2     // Catch:{ all -> 0x08f9 }
            goto L_0x025f
        L_0x025c:
            r2 = 4
            r1.mEndReason = r2     // Catch:{ all -> 0x08f9 }
        L_0x025f:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x08f9 }
            java.lang.String r5 = "ping faild"
            r2.<init>(r5)     // Catch:{ all -> 0x08f9 }
            throw r2     // Catch:{ all -> 0x08f9 }
        L_0x0267:
            sRetryPingTimesCount = r3     // Catch:{ all -> 0x08f9 }
            e.c.f.f.d r5 = r1.forHostAPP     // Catch:{ all -> 0x08f9 }
            org.json.JSONObject r6 = r1.mWholeJson     // Catch:{ all -> 0x08f9 }
            r5.a(r6)     // Catch:{ all -> 0x08f9 }
            e.c.f.d.a r5 = r1.loadedPluginDB     // Catch:{ all -> 0x08f9 }
            r5.d()     // Catch:{ all -> 0x08f9 }
            boolean r5 = sPidRegister     // Catch:{ all -> 0x08f9 }
            if (r5 != 0) goto L_0x0303
            e.c.f.i r5 = r1.preference     // Catch:{ all -> 0x08f9 }
            e.c.f.i r6 = r1.preference     // Catch:{ all -> 0x08f9 }
            android.content.SharedPreferences r6 = r6.f7007a     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = "pdcg"
            int r6 = r6.getInt(r7, r3)     // Catch:{ all -> 0x08f9 }
            int r6 = r6 + r2
            android.content.SharedPreferences$Editor r7 = r5.f7009c     // Catch:{ all -> 0x08f9 }
            java.lang.String r9 = "pdcg"
            r7.putInt(r9, r6)     // Catch:{ all -> 0x08f9 }
            android.content.SharedPreferences$Editor r5 = r5.f7009c     // Catch:{ all -> 0x08f9 }
            r5.commit()     // Catch:{ all -> 0x08f9 }
            e.c.f.i r5 = r1.preference     // Catch:{ all -> 0x08f9 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x08f9 }
            r9 = 0
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 != 0) goto L_0x02ad
            android.content.SharedPreferences$Editor r6 = r5.f7009c     // Catch:{ all -> 0x02fe }
            java.lang.String r7 = "pdcgts"
            java.lang.String r9 = ""
            r6.putString(r7, r9)     // Catch:{ all -> 0x02fe }
            android.content.SharedPreferences$Editor r5 = r5.f7009c     // Catch:{ all -> 0x02fe }
            r5.commit()     // Catch:{ all -> 0x02fe }
            goto L_0x0301
        L_0x02ad:
            android.content.SharedPreferences r9 = r5.f7007a     // Catch:{ all -> 0x02fe }
            java.lang.String r10 = "pdcgts"
            java.lang.String r11 = ""
            java.lang.String r9 = r9.getString(r10, r11)     // Catch:{ all -> 0x02fe }
            boolean r10 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x02fe }
            if (r10 == 0) goto L_0x02c2
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x02fe }
            goto L_0x02e6
        L_0x02c2:
            java.lang.String r10 = "_"
            java.lang.String[] r10 = r9.split(r10)     // Catch:{ all -> 0x02fe }
            int r10 = r10.length     // Catch:{ all -> 0x02fe }
            r11 = 20
            if (r10 < r11) goto L_0x02ce
            goto L_0x0301
        L_0x02ce:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fe }
            r10.<init>()     // Catch:{ all -> 0x02fe }
            r10.append(r9)     // Catch:{ all -> 0x02fe }
            java.lang.String r9 = "_"
            r10.append(r9)     // Catch:{ all -> 0x02fe }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x02fe }
            r10.append(r6)     // Catch:{ all -> 0x02fe }
            java.lang.String r6 = r10.toString()     // Catch:{ all -> 0x02fe }
        L_0x02e6:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fe }
            r7.<init>()     // Catch:{ all -> 0x02fe }
            r7.append(r6)     // Catch:{ all -> 0x02fe }
            e.c.f.c.a()     // Catch:{ all -> 0x02fe }
            android.content.SharedPreferences$Editor r7 = r5.f7009c     // Catch:{ all -> 0x02fe }
            java.lang.String r9 = "pdcgts"
            r7.putString(r9, r6)     // Catch:{ all -> 0x02fe }
            android.content.SharedPreferences$Editor r5 = r5.f7009c     // Catch:{ all -> 0x02fe }
            r5.commit()     // Catch:{ all -> 0x02fe }
            goto L_0x0301
        L_0x02fe:
            e.c.f.n.a.a()     // Catch:{ all -> 0x08f9 }
        L_0x0301:
            sPidRegister = r2     // Catch:{ all -> 0x08f9 }
        L_0x0303:
            e.c.f.i r5 = r1.preference     // Catch:{ all -> 0x08f9 }
            e.c.f.i r6 = r1.preference     // Catch:{ all -> 0x08f9 }
            android.content.SharedPreferences r6 = r6.f7007a     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = "rtqe"
            int r6 = r6.getInt(r7, r3)     // Catch:{ all -> 0x08f9 }
            int r6 = r6 + r2
            android.content.SharedPreferences$Editor r7 = r5.f7009c     // Catch:{ all -> 0x08f9 }
            java.lang.String r9 = "rtqe"
            r7.putInt(r9, r6)     // Catch:{ all -> 0x08f9 }
            android.content.SharedPreferences$Editor r5 = r5.f7009c     // Catch:{ all -> 0x08f9 }
            r5.commit()     // Catch:{ all -> 0x08f9 }
            e.c.f.d.a r5 = r1.loadedPluginDB     // Catch:{ all -> 0x08f9 }
            java.util.List r5 = r5.a()     // Catch:{ all -> 0x08f9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = "a="
            r6.<init>(r7)     // Catch:{ all -> 0x08f9 }
            r6.append(r5)     // Catch:{ all -> 0x08f9 }
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x08f9 }
            r6.<init>()     // Catch:{ all -> 0x08f9 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x08f9 }
            r7.<init>()     // Catch:{ all -> 0x08f9 }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x08f9 }
            r9.<init>()     // Catch:{ all -> 0x08f9 }
            org.json.JSONObject r10 = r1.mWholeJson     // Catch:{ all -> 0x08f9 }
            java.lang.String r11 = "5"
            org.json.JSONObject r10 = r10.optJSONObject(r11)     // Catch:{ all -> 0x08f9 }
            if (r10 != 0) goto L_0x0358
            int r2 = r1.mEndReason     // Catch:{ all -> 0x08f9 }
            if (r2 != 0) goto L_0x0350
            r2 = 10
            r1.mEndReason = r2     // Catch:{ all -> 0x08f9 }
        L_0x0350:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x08f9 }
            java.lang.String r5 = "plugin json is null"
            r2.<init>(r5)     // Catch:{ all -> 0x08f9 }
            throw r2     // Catch:{ all -> 0x08f9 }
        L_0x0358:
            java.util.Iterator r11 = r10.keys()     // Catch:{ all -> 0x08f9 }
        L_0x035c:
            boolean r12 = r11.hasNext()     // Catch:{ all -> 0x08f9 }
            if (r12 == 0) goto L_0x06ef
            java.lang.Object r12 = r11.next()     // Catch:{ all -> 0x08f9 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x08f9 }
            org.json.JSONObject r13 = r10.optJSONObject(r12)     // Catch:{ all -> 0x08f9 }
            java.lang.String r14 = "l"
            int r14 = r13.optInt(r14)     // Catch:{ all -> 0x08f9 }
            java.lang.String r15 = "v"
            java.lang.String r15 = r13.optString(r15)     // Catch:{ all -> 0x08f9 }
            java.util.Map<java.lang.Integer, java.lang.String> r8 = r1.mCloudKeyMap     // Catch:{ all -> 0x08f9 }
            if (r8 == 0) goto L_0x0385
            java.util.Map<java.lang.Integer, java.lang.String> r8 = r1.mCloudKeyMap     // Catch:{ all -> 0x08f9 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x08f9 }
            r8.put(r3, r15)     // Catch:{ all -> 0x08f9 }
        L_0x0385:
            java.lang.String r3 = "u"
            java.lang.String r20 = r13.optString(r3)     // Catch:{ all -> 0x08f9 }
            java.lang.String r3 = "m"
            java.lang.String r3 = r13.optString(r3)     // Catch:{ all -> 0x08f9 }
            java.lang.String r8 = "sm"
            java.lang.String r8 = r13.optString(r8)     // Catch:{ all -> 0x08f9 }
            if (r3 == 0) goto L_0x039d
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x08f9 }
        L_0x039d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r2.<init>()     // Catch:{ all -> 0x08f9 }
            r2.append(r14)     // Catch:{ all -> 0x08f9 }
            r2.append(r15)     // Catch:{ all -> 0x08f9 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x08f9 }
            java.util.Map<java.lang.String, java.lang.String> r16 = sRealtimeMd5Map     // Catch:{ all -> 0x08f9 }
            if (r16 != 0) goto L_0x03b7
            java.util.HashMap r16 = new java.util.HashMap     // Catch:{ all -> 0x08f9 }
            r16.<init>()     // Catch:{ all -> 0x08f9 }
            sRealtimeMd5Map = r16     // Catch:{ all -> 0x08f9 }
        L_0x03b7:
            boolean r16 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x08f9 }
            if (r16 != 0) goto L_0x03cb
            boolean r16 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x08f9 }
            if (r16 != 0) goto L_0x03cb
            r22 = r10
            java.util.Map<java.lang.String, java.lang.String> r10 = sRealtimeMd5Map     // Catch:{ all -> 0x08f9 }
            r10.put(r2, r3)     // Catch:{ all -> 0x08f9 }
            goto L_0x03cd
        L_0x03cb:
            r22 = r10
        L_0x03cd:
            if (r8 == 0) goto L_0x03d3
            java.lang.String r8 = r8.toLowerCase()     // Catch:{ all -> 0x08f9 }
        L_0x03d3:
            java.lang.String r2 = "o"
            int r2 = r13.optInt(r2)     // Catch:{ all -> 0x08f9 }
            r10 = 1
            if (r2 != r10) goto L_0x03de
            r2 = r10
            goto L_0x03df
        L_0x03de:
            r2 = 0
        L_0x03df:
            java.lang.String r10 = "d"
            int r10 = r13.optInt(r10)     // Catch:{ all -> 0x08f9 }
            r23 = r11
            r11 = 1
            if (r10 != r11) goto L_0x03ec
            r10 = 1
            goto L_0x03ed
        L_0x03ec:
            r10 = 0
        L_0x03ed:
            java.lang.String r11 = "r"
            int r11 = r13.optInt(r11)     // Catch:{ all -> 0x08f9 }
            if (r2 == 0) goto L_0x0417
            r24 = r6
            e.c.f.i r6 = r1.preference     // Catch:{ all -> 0x08f9 }
            r25 = r7
            android.content.SharedPreferences r7 = r6.f7007a     // Catch:{ all -> 0x08f9 }
            r26 = r5
            java.lang.String r5 = "opi"
            r27 = r8
            r8 = 0
            int r5 = r7.getInt(r5, r8)     // Catch:{ all -> 0x08f9 }
            if (r11 <= r5) goto L_0x041f
            android.content.SharedPreferences$Editor r5 = r6.f7009c     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = "opi"
            r5.putInt(r7, r11)     // Catch:{ all -> 0x08f9 }
            android.content.SharedPreferences$Editor r5 = r6.f7009c     // Catch:{ all -> 0x08f9 }
            r5.commit()     // Catch:{ all -> 0x08f9 }
            goto L_0x041f
        L_0x0417:
            r26 = r5
            r24 = r6
            r25 = r7
            r27 = r8
        L_0x041f:
            if (r2 == 0) goto L_0x042e
            if (r10 == 0) goto L_0x042e
            r9.add(r12)     // Catch:{ all -> 0x08f9 }
            r28 = r9
            r8 = r24
            r3 = r25
            goto L_0x06e0
        L_0x042e:
            android.content.pm.PackageInfo r5 = new android.content.pm.PackageInfo     // Catch:{ all -> 0x0519 }
            r5.<init>()     // Catch:{ all -> 0x0519 }
            java.lang.String r6 = "p"
            java.lang.String r6 = r13.optString(r6)     // Catch:{ all -> 0x0519 }
            r5.packageName = r6     // Catch:{ all -> 0x0519 }
            r5.versionName = r15     // Catch:{ all -> 0x0519 }
            android.content.pm.ApplicationInfo r6 = new android.content.pm.ApplicationInfo     // Catch:{ all -> 0x0519 }
            r6.<init>()     // Catch:{ all -> 0x0519 }
            java.lang.String r7 = "n"
            java.lang.String r7 = r13.optString(r7)     // Catch:{ all -> 0x0519 }
            r6.className = r7     // Catch:{ all -> 0x0519 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0519 }
            if (r7 != 0) goto L_0x046d
            java.lang.String r7 = r6.className     // Catch:{ all -> 0x0519 }
            java.lang.String r8 = "."
            boolean r7 = r7.startsWith(r8)     // Catch:{ all -> 0x0519 }
            if (r7 == 0) goto L_0x046d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0519 }
            r7.<init>()     // Catch:{ all -> 0x0519 }
            r7.append(r12)     // Catch:{ all -> 0x0519 }
            java.lang.String r8 = r6.className     // Catch:{ all -> 0x0519 }
            r7.append(r8)     // Catch:{ all -> 0x0519 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0519 }
            r6.className = r7     // Catch:{ all -> 0x0519 }
        L_0x046d:
            java.lang.String r7 = "t"
            int r7 = r13.optInt(r7)     // Catch:{ all -> 0x0519 }
            r6.theme = r7     // Catch:{ all -> 0x0519 }
            r5.applicationInfo = r6     // Catch:{ all -> 0x0519 }
            java.lang.String r6 = "a"
            org.json.JSONArray r6 = r13.optJSONArray(r6)     // Catch:{ all -> 0x0519 }
            if (r6 == 0) goto L_0x0516
            int r7 = r6.length()     // Catch:{ all -> 0x0519 }
            if (r7 <= 0) goto L_0x0516
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0519 }
            r7.<init>()     // Catch:{ all -> 0x0519 }
            r8 = 0
        L_0x048b:
            int r10 = r6.length()     // Catch:{ all -> 0x0519 }
            if (r8 >= r10) goto L_0x04ff
            org.json.JSONObject r10 = r6.getJSONObject(r8)     // Catch:{ all -> 0x04f1 }
            if (r10 == 0) goto L_0x04ec
            android.content.pm.ActivityInfo r11 = new android.content.pm.ActivityInfo     // Catch:{ all -> 0x04f1 }
            r11.<init>()     // Catch:{ all -> 0x04f1 }
            r16 = r6
            java.lang.String r6 = "n"
            java.lang.String r6 = r10.optString(r6)     // Catch:{ all -> 0x04f3 }
            r11.name = r6     // Catch:{ all -> 0x04f3 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x04f3 }
            if (r6 != 0) goto L_0x04cc
            java.lang.String r6 = r11.name     // Catch:{ all -> 0x04f3 }
            r28 = r9
            java.lang.String r9 = "."
            boolean r6 = r6.startsWith(r9)     // Catch:{ all -> 0x04f5 }
            if (r6 == 0) goto L_0x04ce
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x04f5 }
            r6.<init>()     // Catch:{ all -> 0x04f5 }
            r6.append(r12)     // Catch:{ all -> 0x04f5 }
            java.lang.String r9 = r11.name     // Catch:{ all -> 0x04f5 }
            r6.append(r9)     // Catch:{ all -> 0x04f5 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x04f5 }
            r11.name = r6     // Catch:{ all -> 0x04f5 }
            goto L_0x04ce
        L_0x04cc:
            r28 = r9
        L_0x04ce:
            r11.packageName = r12     // Catch:{ all -> 0x04f5 }
            java.lang.String r6 = "t"
            int r6 = r10.optInt(r6)     // Catch:{ all -> 0x04f5 }
            r11.theme = r6     // Catch:{ all -> 0x04f5 }
            java.lang.String r6 = "l"
            int r6 = r10.optInt(r6)     // Catch:{ all -> 0x04f5 }
            r11.labelRes = r6     // Catch:{ all -> 0x04f5 }
            java.lang.String r6 = r11.name     // Catch:{ all -> 0x04f5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x04f5 }
            if (r6 != 0) goto L_0x04f8
            r7.add(r11)     // Catch:{ all -> 0x04f5 }
            goto L_0x04f8
        L_0x04ec:
            r16 = r6
            r28 = r9
            goto L_0x04f8
        L_0x04f1:
            r16 = r6
        L_0x04f3:
            r28 = r9
        L_0x04f5:
            e.c.f.n.a.a()     // Catch:{ all -> 0x051b }
        L_0x04f8:
            int r8 = r8 + 1
            r6 = r16
            r9 = r28
            goto L_0x048b
        L_0x04ff:
            r28 = r9
            int r6 = r7.size()     // Catch:{ all -> 0x051b }
            if (r6 <= 0) goto L_0x051f
            int r6 = r7.size()     // Catch:{ all -> 0x051b }
            android.content.pm.ActivityInfo[] r6 = new android.content.pm.ActivityInfo[r6]     // Catch:{ all -> 0x051b }
            java.lang.Object[] r6 = r7.toArray(r6)     // Catch:{ all -> 0x051b }
            android.content.pm.ActivityInfo[] r6 = (android.content.pm.ActivityInfo[]) r6     // Catch:{ all -> 0x051b }
            r5.activities = r6     // Catch:{ all -> 0x051b }
            goto L_0x051f
        L_0x0516:
            r28 = r9
            goto L_0x051f
        L_0x0519:
            r28 = r9
        L_0x051b:
            e.c.f.n.a.a()     // Catch:{ all -> 0x08f9 }
            r5 = 0
        L_0x051f:
            com.baidu.sofire.core.ApkInfo r6 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x08f9 }
            r16 = r6
            r17 = r14
            r18 = r12
            r19 = r15
            r21 = r3
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x08f9 }
            if (r2 == 0) goto L_0x0532
            r2 = 1
            goto L_0x0533
        L_0x0532:
            r2 = 0
        L_0x0533:
            r6.isOnce = r2     // Catch:{ all -> 0x08f9 }
            java.lang.String r2 = "pr"
            int r2 = r13.getInt(r2)     // Catch:{ all -> 0x053e }
            r6.priority = r2     // Catch:{ all -> 0x053e }
            goto L_0x0541
        L_0x053e:
            r2 = -1
            r6.priority = r2     // Catch:{ all -> 0x08f9 }
        L_0x0541:
            java.lang.String r2 = "mem"
            int r2 = r13.optInt(r2)     // Catch:{ all -> 0x08f9 }
            r3 = 1
            if (r2 != r3) goto L_0x054c
            r2 = 1
            goto L_0x054d
        L_0x054c:
            r2 = 0
        L_0x054d:
            r6.isMem = r2     // Catch:{ all -> 0x08f9 }
            if (r5 == 0) goto L_0x0553
            r6.cloudPkgInfo = r5     // Catch:{ all -> 0x08f9 }
        L_0x0553:
            java.lang.String r2 = "e"
            org.json.JSONObject r2 = r13.optJSONObject(r2)     // Catch:{ all -> 0x08f9 }
            if (r2 == 0) goto L_0x056b
            java.lang.String r3 = "d"
            int r3 = r2.optInt(r3)     // Catch:{ all -> 0x08f9 }
            java.lang.String r5 = "n"
            int r2 = r2.optInt(r5)     // Catch:{ all -> 0x08f9 }
            r6.duration = r3     // Catch:{ all -> 0x08f9 }
            r6.network = r2     // Catch:{ all -> 0x08f9 }
        L_0x056b:
            java.lang.String r2 = "ext"
            org.json.JSONObject r2 = r13.optJSONObject(r2)     // Catch:{ all -> 0x08f9 }
            if (r2 == 0) goto L_0x05df
            java.lang.String r3 = "nl"
            r5 = 0
            int r3 = r2.optInt(r3, r5)     // Catch:{ all -> 0x08f9 }
            r5 = 1
            if (r3 != r5) goto L_0x057f
            r3 = 1
            goto L_0x0580
        L_0x057f:
            r3 = 0
        L_0x0580:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r5.<init>()     // Catch:{ all -> 0x08f9 }
            r5.append(r12)     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = " nlld "
            r5.append(r7)     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = java.lang.Boolean.toString(r3)     // Catch:{ all -> 0x08f9 }
            r5.append(r7)     // Catch:{ all -> 0x08f9 }
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            java.lang.String r5 = "a"
            int r2 = r2.optInt(r5)     // Catch:{ all -> 0x08f9 }
            r5 = 1
            if (r2 != r5) goto L_0x05dc
            e.c.f.i r2 = r1.preference     // Catch:{ all -> 0x08f9 }
            java.util.List r2 = r2.f()     // Catch:{ all -> 0x08f9 }
            if (r14 <= 0) goto L_0x05dc
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x08f9 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            boolean r5 = r2.contains(r5)     // Catch:{ all -> 0x08f9 }
            if (r5 != 0) goto L_0x05dc
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x08f9 }
            r2.add(r5)     // Catch:{ all -> 0x08f9 }
            int r5 = r2.size()     // Catch:{ all -> 0x08f9 }
            int[] r5 = new int[r5]     // Catch:{ all -> 0x08f9 }
            r7 = 0
        L_0x05c2:
            int r8 = r2.size()     // Catch:{ all -> 0x08f9 }
            if (r7 >= r8) goto L_0x05d7
            java.lang.Object r8 = r2.get(r7)     // Catch:{ all -> 0x08f9 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x08f9 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x08f9 }
            r5[r7] = r8     // Catch:{ all -> 0x08f9 }
            int r7 = r7 + 1
            goto L_0x05c2
        L_0x05d7:
            e.c.f.i r2 = r1.preference     // Catch:{ all -> 0x08f9 }
            r2.a(r5)     // Catch:{ all -> 0x08f9 }
        L_0x05dc:
            r8 = r27
            goto L_0x05e2
        L_0x05df:
            r8 = r27
            r3 = 0
        L_0x05e2:
            r6.signMD5 = r8     // Catch:{ all -> 0x08f9 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x08f9 }
            r6.startTime = r7     // Catch:{ all -> 0x08f9 }
            r5 = r26
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r2 = r5.indexOf(r6)     // Catch:{ all -> 0x08f9 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            java.lang.String r8 = "t="
            r7.<init>(r8)     // Catch:{ all -> 0x08f9 }
            r7.append(r6)     // Catch:{ all -> 0x08f9 }
            java.lang.String r8 = ", i="
            r7.append(r8)     // Catch:{ all -> 0x08f9 }
            r7.append(r2)     // Catch:{ all -> 0x08f9 }
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.core.ApkInfo r7 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x08f9 }
            r7.<init>(r6)     // Catch:{ all -> 0x08f9 }
            java.lang.String r8 = r6.packageName     // Catch:{ all -> 0x08f9 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x08f9 }
            if (r8 != 0) goto L_0x0625
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            java.lang.String r9 = r7.packageName     // Catch:{ all -> 0x08f9 }
            r8.<init>(r9)     // Catch:{ all -> 0x08f9 }
            java.lang.StringBuilder r8 = r8.reverse()     // Catch:{ all -> 0x08f9 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x08f9 }
            r7.packageName = r8     // Catch:{ all -> 0x08f9 }
        L_0x0625:
            int r7 = r5.indexOf(r7)     // Catch:{ all -> 0x08f9 }
            if (r7 < 0) goto L_0x062e
            r5.remove(r7)     // Catch:{ all -> 0x08f9 }
        L_0x062e:
            if (r2 < 0) goto L_0x06ca
            java.lang.Object r7 = r5.get(r2)     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.core.ApkInfo r7 = (com.baidu.sofire.core.ApkInfo) r7     // Catch:{ all -> 0x08f9 }
            java.lang.String r8 = r6.versionName     // Catch:{ all -> 0x08f9 }
            java.lang.String r9 = r7.versionName     // Catch:{ all -> 0x08f9 }
            boolean r8 = e.c.f.n.a.a(r8, r9)     // Catch:{ all -> 0x08f9 }
            if (r8 == 0) goto L_0x06ac
            java.util.List<java.lang.Integer> r8 = e.c.f.f.d.f6941h     // Catch:{ all -> 0x08f9 }
            if (r8 == 0) goto L_0x0658
            java.util.List<java.lang.Integer> r8 = e.c.f.f.d.f6941h     // Catch:{ all -> 0x08f9 }
            if (r8 == 0) goto L_0x0656
            java.util.List<java.lang.Integer> r8 = e.c.f.f.d.f6941h     // Catch:{ all -> 0x08f9 }
            int r9 = r6.key     // Catch:{ all -> 0x08f9 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x08f9 }
            boolean r8 = r8.contains(r9)     // Catch:{ all -> 0x08f9 }
            if (r8 == 0) goto L_0x0658
        L_0x0656:
            if (r3 == 0) goto L_0x06ac
        L_0x0658:
            int r8 = r7.priority     // Catch:{ all -> 0x08f9 }
            int r9 = r6.priority     // Catch:{ all -> 0x08f9 }
            if (r8 == r9) goto L_0x0667
            e.c.f.d.a r8 = r1.loadedPluginDB     // Catch:{ all -> 0x08f9 }
            int r9 = r6.key     // Catch:{ all -> 0x08f9 }
            int r10 = r6.priority     // Catch:{ all -> 0x08f9 }
            r8.c(r9, r10)     // Catch:{ all -> 0x08f9 }
        L_0x0667:
            e.c.f.d.a r8 = r1.loadedPluginDB     // Catch:{ all -> 0x08f9 }
            int r7 = r7.key     // Catch:{ all -> 0x08f9 }
            boolean r7 = r8.e(r7)     // Catch:{ all -> 0x08f9 }
            if (r7 != 0) goto L_0x06a7
            if (r3 == 0) goto L_0x0692
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r3.<init>()     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = r6.versionName     // Catch:{ all -> 0x08f9 }
            r3.append(r7)     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = " "
            r3.append(r7)     // Catch:{ all -> 0x08f9 }
            int r7 = r6.key     // Catch:{ all -> 0x08f9 }
            r3.append(r7)     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = " nl is t"
            r3.append(r7)     // Catch:{ all -> 0x08f9 }
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            r3 = 1
            r6.isNextLoad = r3     // Catch:{ all -> 0x08f9 }
        L_0x0692:
            r3 = r25
            r3.add(r6)     // Catch:{ all -> 0x08f9 }
            java.util.List<java.lang.Integer> r7 = r1.mDownloadPluginsList     // Catch:{ all -> 0x08f9 }
            if (r7 == 0) goto L_0x06a9
            java.util.List<java.lang.Integer> r7 = r1.mDownloadPluginsList     // Catch:{ all -> 0x08f9 }
            int r6 = r6.key     // Catch:{ all -> 0x08f9 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x08f9 }
            r7.add(r6)     // Catch:{ all -> 0x08f9 }
            goto L_0x06a9
        L_0x06a7:
            r3 = r25
        L_0x06a9:
            r8 = r24
            goto L_0x06c6
        L_0x06ac:
            r3 = r25
            int r8 = r7.priority     // Catch:{ all -> 0x08f9 }
            int r9 = r6.priority     // Catch:{ all -> 0x08f9 }
            if (r8 == r9) goto L_0x06c1
            int r8 = r6.priority     // Catch:{ all -> 0x08f9 }
            r7.priority = r8     // Catch:{ all -> 0x08f9 }
            e.c.f.d.a r8 = r1.loadedPluginDB     // Catch:{ all -> 0x08f9 }
            int r9 = r6.key     // Catch:{ all -> 0x08f9 }
            int r6 = r6.priority     // Catch:{ all -> 0x08f9 }
            r8.c(r9, r6)     // Catch:{ all -> 0x08f9 }
        L_0x06c1:
            r8 = r24
            r8.add(r7)     // Catch:{ all -> 0x08f9 }
        L_0x06c6:
            r5.remove(r2)     // Catch:{ all -> 0x08f9 }
            goto L_0x06e0
        L_0x06ca:
            r8 = r24
            r3 = r25
            r3.add(r6)     // Catch:{ all -> 0x08f9 }
            java.util.List<java.lang.Integer> r2 = r1.mDownloadPluginsList     // Catch:{ all -> 0x08f9 }
            if (r2 == 0) goto L_0x06e0
            java.util.List<java.lang.Integer> r2 = r1.mDownloadPluginsList     // Catch:{ all -> 0x08f9 }
            int r5 = r6.key     // Catch:{ all -> 0x08f9 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x08f9 }
            r2.add(r5)     // Catch:{ all -> 0x08f9 }
        L_0x06e0:
            r7 = r3
            r6 = r8
            r10 = r22
            r11 = r23
            r5 = r26
            r9 = r28
            r2 = 1
            r3 = 0
            r8 = 3
            goto L_0x035c
        L_0x06ef:
            r26 = r5
            r8 = r6
            r3 = r7
            r28 = r9
            java.util.List<java.lang.Integer> r2 = e.c.f.f.d.f6941h     // Catch:{ all -> 0x08f9 }
            if (r2 == 0) goto L_0x06fe
            java.util.List<java.lang.Integer> r2 = e.c.f.f.d.f6941h     // Catch:{ all -> 0x08f9 }
            r2.clear()     // Catch:{ all -> 0x08f9 }
        L_0x06fe:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r2.<init>()     // Catch:{ all -> 0x08f9 }
            r5 = r26
            r2.append(r5)     // Catch:{ all -> 0x08f9 }
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x08f9 }
        L_0x0711:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x08f9 }
            if (r5 == 0) goto L_0x0740
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.core.ApkInfo r5 = (com.baidu.sofire.core.ApkInfo) r5     // Catch:{ all -> 0x08f9 }
            java.lang.String r6 = r5.packageName     // Catch:{ all -> 0x08f9 }
            r7 = r28
            boolean r6 = r7.contains(r6)     // Catch:{ all -> 0x08f9 }
            if (r6 != 0) goto L_0x073d
            java.util.List<java.lang.Integer> r6 = r1.mUnloadPluginsList     // Catch:{ all -> 0x08f9 }
            if (r6 == 0) goto L_0x0736
            java.util.List<java.lang.Integer> r6 = r1.mUnloadPluginsList     // Catch:{ all -> 0x08f9 }
            int r9 = r5.key     // Catch:{ all -> 0x08f9 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x08f9 }
            r6.add(r9)     // Catch:{ all -> 0x08f9 }
        L_0x0736:
            e.c.f.f.d r6 = r1.forHostAPP     // Catch:{ all -> 0x08f9 }
            java.lang.String r5 = r5.packageName     // Catch:{ all -> 0x08f9 }
            r6.a(r5)     // Catch:{ all -> 0x08f9 }
        L_0x073d:
            r28 = r7
            goto L_0x0711
        L_0x0740:
            android.content.Context r2 = r1.context     // Catch:{ all -> 0x08f9 }
            e.c.f.n.a.b(r2)     // Catch:{ all -> 0x08f9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r2.<init>()     // Catch:{ all -> 0x08f9 }
            r2.append(r8)     // Catch:{ all -> 0x08f9 }
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            android.content.Context r2 = r1.context     // Catch:{ all -> 0x08f9 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x08f9 }
            e.c.f.f.g r2 = e.c.f.f.g.a(r2)     // Catch:{ all -> 0x08f9 }
            e.c.f.i r5 = r1.preference     // Catch:{ all -> 0x08f9 }
            java.util.List r5 = r5.g()     // Catch:{ all -> 0x08f9 }
            e.c.f.i r6 = r1.preference     // Catch:{ all -> 0x08f9 }
            java.util.List r6 = r6.f()     // Catch:{ all -> 0x08f9 }
            r7 = 0
        L_0x0767:
            r9 = r6
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            int r10 = r9.size()     // Catch:{ all -> 0x08f9 }
            if (r7 >= r10) goto L_0x0787
            java.lang.Object r10 = r9.get(r7)     // Catch:{ all -> 0x08f9 }
            r11 = r5
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            boolean r10 = r11.contains(r10)     // Catch:{ all -> 0x08f9 }
            if (r10 != 0) goto L_0x0784
            java.lang.Object r9 = r9.get(r7)     // Catch:{ all -> 0x08f9 }
            r11.add(r9)     // Catch:{ all -> 0x08f9 }
        L_0x0784:
            int r7 = r7 + 1
            goto L_0x0767
        L_0x0787:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x08f9 }
            r6.<init>()     // Catch:{ all -> 0x08f9 }
            r6.addAll(r8)     // Catch:{ all -> 0x08f9 }
            r6.addAll(r3)     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.ac.U$1 r7 = new com.baidu.sofire.ac.U$1     // Catch:{ all -> 0x08f9 }
            r7.<init>(r5)     // Catch:{ all -> 0x08f9 }
            java.util.Collections.sort(r6, r7)     // Catch:{ all -> 0x08f9 }
            r5 = 0
        L_0x079b:
            int r7 = r6.size()     // Catch:{ all -> 0x08f9 }
            if (r5 >= r7) goto L_0x0891
            java.lang.Object r7 = r6.get(r5)     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.core.ApkInfo r7 = (com.baidu.sofire.core.ApkInfo) r7     // Catch:{ all -> 0x08f9 }
            boolean r9 = r8.contains(r7)     // Catch:{ all -> 0x08f9 }
            if (r9 == 0) goto L_0x087a
            java.lang.String r9 = r7.packageName     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.core.ApkInfo r9 = r2.c(r9)     // Catch:{ all -> 0x08f9 }
            if (r9 != 0) goto L_0x088d
            e.c.f.d.a r9 = r1.loadedPluginDB     // Catch:{ all -> 0x08f9 }
            int r10 = r7.key     // Catch:{ all -> 0x08f9 }
            int r9 = r9.g(r10)     // Catch:{ all -> 0x08f9 }
            r10 = 3
            if (r9 != r10) goto L_0x07c5
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            r9 = 0
            goto L_0x07c6
        L_0x07c5:
            r9 = 1
        L_0x07c6:
            e.c.f.i r10 = r1.preference     // Catch:{ all -> 0x08f9 }
            boolean r10 = r10.b()     // Catch:{ all -> 0x08f9 }
            if (r10 == 0) goto L_0x081b
            if (r9 == 0) goto L_0x081b
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x08f9 }
            android.content.Context r10 = r1.context     // Catch:{ all -> 0x08f9 }
            java.io.File r10 = r10.getFilesDir()     // Catch:{ all -> 0x08f9 }
            java.lang.String r11 = ".b"
            r9.<init>(r10, r11)     // Catch:{ all -> 0x08f9 }
            boolean r10 = r9.exists()     // Catch:{ all -> 0x08f9 }
            if (r10 != 0) goto L_0x07e6
            r9.mkdir()     // Catch:{ all -> 0x08f9 }
        L_0x07e6:
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x08f9 }
            java.lang.String r11 = r7.pkgPath     // Catch:{ all -> 0x08f9 }
            r10.<init>(r11)     // Catch:{ all -> 0x08f9 }
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x08f9 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r12.<init>()     // Catch:{ all -> 0x08f9 }
            int r13 = r7.key     // Catch:{ all -> 0x08f9 }
            r12.append(r13)     // Catch:{ all -> 0x08f9 }
            java.lang.String r13 = "-"
            r12.append(r13)     // Catch:{ all -> 0x08f9 }
            java.lang.String r13 = r7.versionName     // Catch:{ all -> 0x08f9 }
            r12.append(r13)     // Catch:{ all -> 0x08f9 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x08f9 }
            r11.<init>(r9, r12)     // Catch:{ all -> 0x08f9 }
            boolean r9 = e.c.f.n.a.a(r11)     // Catch:{ all -> 0x08f9 }
            if (r9 != 0) goto L_0x0813
            e.c.f.n.a.a(r10, r11)     // Catch:{ all -> 0x08f9 }
        L_0x0813:
            android.content.Context r9 = r1.context     // Catch:{ all -> 0x08f9 }
            int r12 = r7.key     // Catch:{ all -> 0x08f9 }
            e.c.f.e.a(r9, r12, r10, r11)     // Catch:{ all -> 0x08f9 }
            goto L_0x086f
        L_0x081b:
            java.io.File r9 = new java.io.File     // Catch:{ all -> 0x08f9 }
            android.content.Context r10 = r1.context     // Catch:{ all -> 0x08f9 }
            java.io.File r10 = r10.getFilesDir()     // Catch:{ all -> 0x08f9 }
            java.lang.String r11 = ".b"
            r9.<init>(r10, r11)     // Catch:{ all -> 0x08f9 }
            boolean r10 = r9.exists()     // Catch:{ all -> 0x08f9 }
            if (r10 == 0) goto L_0x086f
            java.io.File r10 = new java.io.File     // Catch:{ all -> 0x08f9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r11.<init>()     // Catch:{ all -> 0x08f9 }
            int r12 = r7.key     // Catch:{ all -> 0x08f9 }
            r11.append(r12)     // Catch:{ all -> 0x08f9 }
            java.lang.String r12 = "-"
            r11.append(r12)     // Catch:{ all -> 0x08f9 }
            java.lang.String r12 = r7.versionName     // Catch:{ all -> 0x08f9 }
            r11.append(r12)     // Catch:{ all -> 0x08f9 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x08f9 }
            r10.<init>(r9, r11)     // Catch:{ all -> 0x08f9 }
            boolean r9 = e.c.f.n.a.a(r10)     // Catch:{ all -> 0x08f9 }
            if (r9 == 0) goto L_0x086f
            e.c.f.e.a(r10)     // Catch:{ all -> 0x08f9 }
            boolean r9 = r10.delete()     // Catch:{ all -> 0x08f9 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x08f9 }
            r11.<init>()     // Catch:{ all -> 0x08f9 }
            java.lang.String r10 = r10.getAbsolutePath()     // Catch:{ all -> 0x08f9 }
            r11.append(r10)     // Catch:{ all -> 0x08f9 }
            java.lang.String r10 = " s="
            r11.append(r10)     // Catch:{ all -> 0x08f9 }
            r11.append(r9)     // Catch:{ all -> 0x08f9 }
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
        L_0x086f:
            e.c.f.f.d r9 = r1.forHostAPP     // Catch:{ all -> 0x08f9 }
            int r10 = r7.key     // Catch:{ all -> 0x08f9 }
            java.lang.String r7 = r7.versionName     // Catch:{ all -> 0x08f9 }
            r11 = 0
            r9.a(r10, r7, r11)     // Catch:{ all -> 0x08f9 }
            goto L_0x088d
        L_0x087a:
            boolean r9 = r3.contains(r7)     // Catch:{ all -> 0x08f9 }
            if (r9 == 0) goto L_0x088d
            e.c.f.d.a r9 = r1.loadedPluginDB     // Catch:{ all -> 0x08f9 }
            int r10 = r7.key     // Catch:{ all -> 0x08f9 }
            boolean r9 = r9.e(r10)     // Catch:{ all -> 0x08f9 }
            if (r9 != 0) goto L_0x088d
            r1.handlePluginUpgrade(r7)     // Catch:{ all -> 0x08f9 }
        L_0x088d:
            int r5 = r5 + 1
            goto L_0x079b
        L_0x0891:
            monitor-exit(r4)     // Catch:{ all -> 0x08f9 }
            int r2 = r1.mEndReason     // Catch:{ all -> 0x08fd }
            if (r2 != 0) goto L_0x0899
            r2 = 1
            r1.mEndReason = r2     // Catch:{ all -> 0x08fd }
        L_0x0899:
            r2 = 0
            r1.handleThreadEnd(r2)     // Catch:{ all -> 0x08fd }
            boolean r2 = r1.mOut     // Catch:{ all -> 0x08aa }
            if (r2 == 0) goto L_0x08a8
            boolean r2 = sOutGoing     // Catch:{ all -> 0x08aa }
            if (r2 == 0) goto L_0x08a8
            r2 = 0
            sOutGoing = r2     // Catch:{ all -> 0x08aa }
        L_0x08a8:
            monitor-exit(r29)
            return
        L_0x08aa:
            e.c.f.n.a.a()     // Catch:{ all -> 0x097d }
            monitor-exit(r29)
            return
        L_0x08af:
            int r2 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            r3 = 1
            if (r2 == r3) goto L_0x08be
            int r2 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            r3 = 2
            if (r2 == r3) goto L_0x08be
            int r2 = r1.mFrom     // Catch:{ all -> 0x08f9 }
            r3 = 3
            if (r2 != r3) goto L_0x08e0
        L_0x08be:
            e.c.f.c.a()     // Catch:{ all -> 0x08f9 }
            r2 = 1
            sMonitorNetworkWhenUpgradeNoNet = r2     // Catch:{ all -> 0x08f9 }
            android.content.IntentFilter r2 = new android.content.IntentFilter     // Catch:{ all -> 0x08f9 }
            java.lang.String r3 = "android.net.conn.CONNECTIVITY_CHANGE"
            r2.<init>(r3)     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.MyReceiver r3 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x08f9 }
            if (r3 != 0) goto L_0x08d9
            com.baidu.sofire.MyReceiver r3 = new com.baidu.sofire.MyReceiver     // Catch:{ all -> 0x08f9 }
            r3.<init>()     // Catch:{ all -> 0x08f9 }
            r3.a()     // Catch:{ all -> 0x08f9 }
            e.c.f.n.a.f7040e = r3     // Catch:{ all -> 0x08f9 }
        L_0x08d9:
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x08f9 }
            com.baidu.sofire.MyReceiver r6 = e.c.f.n.a.f7040e     // Catch:{ all -> 0x08f9 }
            e.c.f.n.a.a(r3, r6, r2)     // Catch:{ all -> 0x08f9 }
        L_0x08e0:
            int r2 = r1.mEndReason     // Catch:{ all -> 0x08f9 }
            if (r2 != 0) goto L_0x08e7
            r2 = 3
            r1.mEndReason = r2     // Catch:{ all -> 0x08f9 }
        L_0x08e7:
            if (r5 == 0) goto L_0x08f1
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x08f9 }
            java.lang.String r3 = "blocked by Huawei Input"
            r2.<init>(r3)     // Catch:{ all -> 0x08f9 }
            throw r2     // Catch:{ all -> 0x08f9 }
        L_0x08f1:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x08f9 }
            java.lang.String r3 = "no internet"
            r2.<init>(r3)     // Catch:{ all -> 0x08f9 }
            throw r2     // Catch:{ all -> 0x08f9 }
        L_0x08f9:
            r0 = move-exception
            r2 = r0
            monitor-exit(r4)     // Catch:{ all -> 0x08f9 }
            throw r2     // Catch:{ all -> 0x08fd }
        L_0x08fd:
            r0 = move-exception
            r2 = r0
            android.content.Context r3 = r1.context     // Catch:{ all -> 0x096b }
            boolean r3 = e.c.f.n.a.f(r3)     // Catch:{ all -> 0x096b }
            if (r3 == 0) goto L_0x0916
            boolean r3 = r2 instanceof java.lang.UnsupportedOperationException     // Catch:{ all -> 0x096b }
            if (r3 != 0) goto L_0x090c
            goto L_0x0916
        L_0x090c:
            java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x096b }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x096b }
            r3.<init>(r2)     // Catch:{ all -> 0x096b }
            throw r3     // Catch:{ all -> 0x096b }
        L_0x0916:
            e.c.f.c.a(r2)     // Catch:{ all -> 0x096b }
            e.c.f.c.b()     // Catch:{ all -> 0x096b }
            e.c.f.f.d r3 = r1.forHostAPP     // Catch:{ all -> 0x0922 }
            r3.b()     // Catch:{ all -> 0x0922 }
            goto L_0x0925
        L_0x0922:
            e.c.f.n.a.a()     // Catch:{ all -> 0x096b }
        L_0x0925:
            int r3 = r1.mEndReason     // Catch:{ all -> 0x0956 }
            if (r3 != 0) goto L_0x094e
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x0956 }
            java.lang.String r4 = "response is empty"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0956 }
            if (r3 == 0) goto L_0x0939
            r3 = 7
            r1.mEndReason = r3     // Catch:{ all -> 0x0956 }
            goto L_0x094e
        L_0x0939:
            java.lang.String r3 = r2.getMessage()     // Catch:{ all -> 0x0956 }
            java.lang.String r4 = "aes is fail"
            boolean r3 = r3.contains(r4)     // Catch:{ all -> 0x0956 }
            if (r3 == 0) goto L_0x094a
            r3 = 8
            r1.mEndReason = r3     // Catch:{ all -> 0x0956 }
            goto L_0x094e
        L_0x094a:
            r3 = 11
            r1.mEndReason = r3     // Catch:{ all -> 0x0956 }
        L_0x094e:
            java.lang.String r2 = e.c.f.c.a(r2)     // Catch:{ all -> 0x0956 }
            r1.handleThreadEnd(r2)     // Catch:{ all -> 0x0956 }
            goto L_0x0959
        L_0x0956:
            e.c.f.n.a.a()     // Catch:{ all -> 0x096b }
        L_0x0959:
            boolean r2 = r1.mOut     // Catch:{ all -> 0x0966 }
            if (r2 == 0) goto L_0x0964
            boolean r2 = sOutGoing     // Catch:{ all -> 0x0966 }
            if (r2 == 0) goto L_0x0964
            r2 = 0
            sOutGoing = r2     // Catch:{ all -> 0x0966 }
        L_0x0964:
            monitor-exit(r29)
            return
        L_0x0966:
            e.c.f.n.a.a()     // Catch:{ all -> 0x097d }
            monitor-exit(r29)
            return
        L_0x096b:
            r0 = move-exception
            r2 = r0
            boolean r3 = r1.mOut     // Catch:{ all -> 0x0979 }
            if (r3 == 0) goto L_0x097c
            boolean r3 = sOutGoing     // Catch:{ all -> 0x0979 }
            if (r3 == 0) goto L_0x097c
            r3 = 0
            sOutGoing = r3     // Catch:{ all -> 0x0979 }
            goto L_0x097c
        L_0x0979:
            e.c.f.n.a.a()     // Catch:{ all -> 0x097d }
        L_0x097c:
            throw r2     // Catch:{ all -> 0x097d }
        L_0x097d:
            r0 = move-exception
            r2 = r0
            monitor-exit(r29)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.ac.U.run():void");
    }

    public U(Context context2, int i2, boolean z, JSONObject jSONObject) {
        this.context = context2;
        this.loadedPluginDB = a.a(context2);
        this.preference = new i(context2);
        this.forHostAPP = d.a(context2);
        this.tmpDir = new File(context2.getFilesDir(), ".tmp");
        this.mFrom = i2;
        this.mOut = z;
        this.mWholeJson = jSONObject;
    }

    public U() {
    }
}
