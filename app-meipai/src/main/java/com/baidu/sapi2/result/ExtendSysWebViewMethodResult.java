package com.baidu.sapi2.result;

import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import java.util.HashMap;
import java.util.Map;

public class ExtendSysWebViewMethodResult extends SapiResult {
    public Map<String, Object> params = new HashMap();
    public PassFaceRecogResult recogResult;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r1 != null) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject getJsonResult() {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r1 = r5.recogResult
            if (r1 == 0) goto L_0x000e
            org.json.JSONObject r1 = r1.extraJson
            if (r1 == 0) goto L_0x000e
            goto L_0x0013
        L_0x000e:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
        L_0x0013:
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            if (r2 == 0) goto L_0x009a
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.authSid     // Catch:{ JSONException -> 0x00e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r3 = "authsid"
            if (r2 != 0) goto L_0x002a
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.authSid     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r3, r2)     // Catch:{ JSONException -> 0x00e1 }
        L_0x002a:
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.authSid     // Catch:{ JSONException -> 0x00e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00e1 }
            if (r2 != 0) goto L_0x003b
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.authSid     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r3, r2)     // Catch:{ JSONException -> 0x00e1 }
        L_0x003b:
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.video     // Catch:{ JSONException -> 0x00e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00e1 }
            if (r2 != 0) goto L_0x004e
            java.lang.String r2 = "video"
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r3 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r3 = r3.video     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x00e1 }
        L_0x004e:
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.callbackkey     // Catch:{ JSONException -> 0x00e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00e1 }
            if (r2 != 0) goto L_0x0061
            java.lang.String r2 = "callbackkey"
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r3 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r3 = r3.callbackkey     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x00e1 }
        L_0x0061:
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.faceimage     // Catch:{ JSONException -> 0x00e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00e1 }
            if (r2 != 0) goto L_0x0074
            java.lang.String r2 = "faceimage"
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r3 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r3 = r3.faceimage     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x00e1 }
        L_0x0074:
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.imgdigests     // Catch:{ JSONException -> 0x00e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00e1 }
            if (r2 != 0) goto L_0x0087
            java.lang.String r2 = "imgdigests"
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r3 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r3 = r3.imgdigests     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x00e1 }
        L_0x0087:
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.originalImage     // Catch:{ JSONException -> 0x00e1 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x00e1 }
            if (r2 != 0) goto L_0x009a
            java.lang.String r2 = "originimage"
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r3 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r3 = r3.originalImage     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x00e1 }
        L_0x009a:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r5.params     // Catch:{ JSONException -> 0x00e1 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ JSONException -> 0x00e1 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x00e1 }
        L_0x00a4:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x00e1 }
            if (r3 == 0) goto L_0x00c2
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x00e1 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ JSONException -> 0x00e1 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00e1 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x00e1 }
            r1.put(r4, r3)     // Catch:{ JSONException -> 0x00e1 }
            goto L_0x00a4
        L_0x00c2:
            java.lang.String r2 = "result"
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x00e1 }
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r1 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            if (r1 == 0) goto L_0x00e1
            java.lang.String r1 = "retCode"
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            int r2 = r2.getResultCode()     // Catch:{ JSONException -> 0x00e1 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r1 = "retMsg"
            com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult r2 = r5.recogResult     // Catch:{ JSONException -> 0x00e1 }
            java.lang.String r2 = r2.getResultMsg()     // Catch:{ JSONException -> 0x00e1 }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x00e1 }
        L_0x00e1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.result.ExtendSysWebViewMethodResult.getJsonResult():org.json.JSONObject");
    }
}
