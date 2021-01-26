package com.baidubce.util;

import com.baidubce.BceErrorResponse;
import com.baidubce.http.BceHttpResponse;
import com.baidubce.model.AbstractBceResponse;
import com.baidubce.model.User;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.BucketSummary;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.CopyObjectResponse;
import com.baidubce.services.bos.model.CopyObjectResponseWithExceptionInfo;
import com.baidubce.services.bos.model.GetBucketAclResponse;
import com.baidubce.services.bos.model.GetBucketLocationResponse;
import com.baidubce.services.bos.model.Grant;
import com.baidubce.services.bos.model.Grantee;
import com.baidubce.services.bos.model.InitiateMultipartUploadResponse;
import com.baidubce.services.bos.model.ListBucketsResponse;
import com.baidubce.services.bos.model.ListMultipartUploadsResponse;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.ListPartsResponse;
import com.baidubce.services.bos.model.MultipartUploadSummary;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.bos.model.PartSummary;
import com.baidubce.services.bos.model.Permission;
import com.baidubce.services.sts.StsClient;
import com.baidubce.services.sts.model.GetSessionTokenResponse;
import e.a.a.a.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    /* renamed from: com.baidubce.util.JsonUtils$1 reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidubce$services$bos$model$Permission;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                com.baidubce.services.bos.model.Permission[] r0 = com.baidubce.services.bos.model.Permission.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidubce$services$bos$model$Permission = r0
                r1 = 1
                com.baidubce.services.bos.model.Permission r2 = com.baidubce.services.bos.model.Permission.FULL_CONTROL     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$baidubce$services$bos$model$Permission     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.baidubce.services.bos.model.Permission r3 = com.baidubce.services.bos.model.Permission.READ     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$com$baidubce$services$bos$model$Permission     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidubce.services.bos.model.Permission r2 = com.baidubce.services.bos.model.Permission.WRITE     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidubce.util.JsonUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public static void load(BceHttpResponse bceHttpResponse, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        load(bceHttpResponse.getContent(), abstractBceResponse);
    }

    public static BceErrorResponse loadError(InputStream inputStream) throws IOException, JSONException {
        BceErrorResponse bceErrorResponse = new BceErrorResponse();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            str = a.a(str, readLine);
        }
        if (str.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        bceErrorResponse.setCode(jSONObject.getString("code"));
        bceErrorResponse.setMessage(jSONObject.getString("message"));
        bceErrorResponse.setRequestId(jSONObject.getString("requestId"));
        return bceErrorResponse;
    }

    public static void loadFromString(String str, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        AbstractBceResponse abstractBceResponse2 = abstractBceResponse;
        Class<String> cls = String.class;
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "name";
        String str3 = "setOwner";
        String str4 = "displayName";
        String str5 = "owner";
        String str6 = "id";
        if (abstractBceResponse.getClass() == ListBucketsResponse.class) {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(str5));
            User user = new User();
            user.setDisplayName(jSONObject2.getString(str4));
            user.setId(jSONObject2.getString(str6));
            JSONArray jSONArray = jSONObject.getJSONArray("buckets");
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                BucketSummary bucketSummary = new BucketSummary();
                bucketSummary.setName(optJSONObject.getString(str2));
                bucketSummary.setLocation(optJSONObject.getString("location"));
                bucketSummary.setCreationDate(DateUtils.parseAlternateIso8601Date(optJSONObject.getString("creationDate")));
                arrayList.add(bucketSummary);
            }
            abstractBceResponse.getClass().getMethod(str3, new Class[]{User.class}).invoke(abstractBceResponse2, new Object[]{user});
            abstractBceResponse.getClass().getMethod("setBuckets", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList});
            return;
        }
        String str7 = "storageClass";
        String str8 = "isTruncated";
        String str9 = "setTruncated";
        String str10 = "commonPrefixes";
        String str11 = "delimiter";
        String str12 = "lastModified";
        String str13 = str3;
        String str14 = "key";
        String str15 = str4;
        String str16 = "eTag";
        String str17 = str6;
        String str18 = "prefix";
        String str19 = str5;
        String str20 = "setBucketName";
        if (abstractBceResponse.getClass() == ListObjectsResponse.class) {
            String str21 = str7;
            abstractBceResponse.getClass().getMethod(str20, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString(str2)});
            abstractBceResponse.getClass().getMethod("setMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString("marker")});
            if (jSONObject.has("nextMarker")) {
                abstractBceResponse.getClass().getMethod("setNextMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString("nextMarker")});
            }
            abstractBceResponse.getClass().getMethod("setMaxKeys", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{Integer.valueOf(jSONObject.getInt("maxKeys"))});
            if (jSONObject.has(str18)) {
                abstractBceResponse.getClass().getMethod("setPrefix", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString(str18)});
            }
            if (jSONObject.has(str11)) {
                abstractBceResponse.getClass().getMethod("setDelimiter", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.getString(str11)});
            }
            abstractBceResponse.getClass().getMethod(str9, new Class[]{Boolean.TYPE}).invoke(abstractBceResponse2, new Object[]{Boolean.valueOf(jSONObject.getBoolean(str8))});
            if (jSONObject.has(str10)) {
                Method method = abstractBceResponse.getClass().getMethod("setCommonPrefixes", new Class[]{List.class});
                JSONArray jSONArray2 = jSONObject.getJSONArray(str10);
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList2.add(jSONArray2.optJSONObject(i3).getString(str18));
                }
                method.invoke(abstractBceResponse2, new Object[]{arrayList2});
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("contents");
            if (jSONArray3.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    JSONObject optJSONObject2 = jSONArray3.optJSONObject(i4);
                    BosObjectSummary bosObjectSummary = new BosObjectSummary();
                    bosObjectSummary.setETag(optJSONObject2.getString(str16));
                    bosObjectSummary.setKey(optJSONObject2.getString(str14));
                    bosObjectSummary.setSize(optJSONObject2.getLong("size"));
                    bosObjectSummary.setLastModified(DateUtils.parseAlternateIso8601Date(optJSONObject2.getString(str12)));
                    bosObjectSummary.setStorageClass(optJSONObject2.getString(str21));
                    JSONObject jSONObject3 = optJSONObject2.getJSONObject(str19);
                    User user2 = new User();
                    user2.setId(jSONObject3.getString(str17));
                    user2.setDisplayName(jSONObject3.getString(str15));
                    bosObjectSummary.setOwner(user2);
                    arrayList3.add(bosObjectSummary);
                }
                abstractBceResponse.getClass().getMethod("setContents", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList3});
                return;
            }
            return;
        }
        String str22 = str17;
        String str23 = str19;
        String str24 = str7;
        if (abstractBceResponse.getClass() == GetBucketAclResponse.class) {
            JSONObject jSONObject4 = new JSONObject(jSONObject.getString(str23));
            Grantee grantee = new Grantee();
            grantee.setId(jSONObject4.getString(str22));
            abstractBceResponse.getClass().getMethod(str13, new Class[]{Grantee.class}).invoke(abstractBceResponse2, new Object[]{grantee});
            JSONArray jSONArray4 = jSONObject.getJSONArray("accessControlList");
            ArrayList arrayList4 = new ArrayList();
            for (int i5 = 0; i5 < jSONArray4.length(); i5++) {
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                JSONObject jSONObject5 = new JSONObject(jSONArray4.optJSONObject(i5).toString());
                JSONArray jSONArray5 = jSONObject5.getJSONArray("grantee");
                for (int i6 = 0; i6 < jSONArray5.length(); i6++) {
                    JSONObject optJSONObject3 = jSONArray5.optJSONObject(i6);
                    Grantee grantee2 = new Grantee();
                    grantee2.setId(optJSONObject3.getString(str22));
                    arrayList5.add(grantee2);
                }
                JSONArray jSONArray6 = jSONObject5.getJSONArray("permission");
                for (int i7 = 0; i7 < jSONArray6.length(); i7++) {
                    int ordinal = Permission.valueOf(jSONArray6.get(i7).toString()).ordinal();
                    if (ordinal == 0) {
                        arrayList6.add(Permission.FULL_CONTROL);
                    } else if (ordinal == 1) {
                        arrayList6.add(Permission.READ);
                    } else if (ordinal == 2) {
                        arrayList6.add(Permission.WRITE);
                    }
                }
                arrayList4.add(new Grant(arrayList5, arrayList6));
            }
            abstractBceResponse.getClass().getMethod("setAccessControlList", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList4});
            return;
        }
        String str25 = str13;
        String str26 = str22;
        String str27 = "setETag";
        if (abstractBceResponse.getClass() == CopyObjectResponse.class) {
            abstractBceResponse.getClass().getMethod("setLastModified", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(String.valueOf(jSONObject.get(str12)))});
            abstractBceResponse.getClass().getMethod(str27, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str16)});
        } else if (abstractBceResponse.getClass() == CopyObjectResponseWithExceptionInfo.class) {
            abstractBceResponse.getClass().getMethod("setLastModified", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(String.valueOf(jSONObject.get(str12)))});
            abstractBceResponse.getClass().getMethod(str27, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str16)});
        } else {
            String str28 = str12;
            String str29 = "uploadId";
            String str30 = str23;
            String str31 = "setKey";
            String str32 = str10;
            String str33 = "bucket";
            if (abstractBceResponse.getClass() == InitiateMultipartUploadResponse.class) {
                abstractBceResponse.getClass().getMethod(str20, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str33)});
                abstractBceResponse.getClass().getMethod(str31, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str14)});
                abstractBceResponse.getClass().getMethod("setUploadId", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str29)});
            } else if (abstractBceResponse.getClass() == CompleteMultipartUploadResponse.class) {
                abstractBceResponse.getClass().getMethod(str20, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str33)});
                abstractBceResponse.getClass().getMethod(str31, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str14)});
                abstractBceResponse.getClass().getMethod("setLocation", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("location")});
                abstractBceResponse.getClass().getMethod(str27, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str16)});
            } else if (abstractBceResponse.getClass() == ListMultipartUploadsResponse.class) {
                abstractBceResponse.getClass().getMethod(str20, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str33)});
                if (jSONObject.has("keyMarker")) {
                    abstractBceResponse.getClass().getMethod("setKeyMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("keyMarker")});
                }
                if (jSONObject.has("nextKeyMarker")) {
                    abstractBceResponse.getClass().getMethod("setNextKeyMarker", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("nextKeyMarker")});
                }
                abstractBceResponse.getClass().getMethod("setMaxUploads", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("maxUploads")});
                abstractBceResponse.getClass().getMethod("setPrefix", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str18)});
                if (jSONObject.has(str11)) {
                    abstractBceResponse.getClass().getMethod("setDelimiter", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str11)});
                }
                abstractBceResponse.getClass().getMethod(str9, new Class[]{Boolean.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str8)});
                String str34 = str32;
                if (jSONObject.has(str34)) {
                    Method method2 = abstractBceResponse.getClass().getMethod("setCommonPrefixes", new Class[]{List.class});
                    JSONArray jSONArray7 = jSONObject.getJSONArray(str34);
                    ArrayList arrayList7 = new ArrayList();
                    for (int i8 = 0; i8 < jSONArray7.length(); i8++) {
                        arrayList7.add(jSONArray7.optJSONObject(i8).getString(str18));
                    }
                    method2.invoke(abstractBceResponse2, new Object[]{arrayList7});
                }
                ArrayList arrayList8 = new ArrayList();
                JSONArray jSONArray8 = jSONObject.getJSONArray("uploads");
                for (int i9 = 0; i9 < jSONArray8.length(); i9++) {
                    JSONObject optJSONObject4 = jSONArray8.optJSONObject(i9);
                    MultipartUploadSummary multipartUploadSummary = new MultipartUploadSummary();
                    multipartUploadSummary.setUploadId(optJSONObject4.getString(str29));
                    multipartUploadSummary.setKey(optJSONObject4.getString(str14));
                    multipartUploadSummary.setInitiated(DateUtils.parseAlternateIso8601Date(optJSONObject4.getString("initiated")));
                    multipartUploadSummary.setStorageClass(optJSONObject4.getString(str24));
                    JSONObject jSONObject6 = optJSONObject4.getJSONObject(str30);
                    User user3 = new User();
                    user3.setId(jSONObject6.getString(str26));
                    user3.setDisplayName(jSONObject6.getString(str15));
                    multipartUploadSummary.setOwner(user3);
                    arrayList8.add(multipartUploadSummary);
                }
                abstractBceResponse.getClass().getMethod("setMultipartUploads", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList8});
            } else {
                String str35 = str15;
                String str36 = str26;
                String str37 = str24;
                String str38 = str30;
                String str39 = str16;
                if (abstractBceResponse.getClass() == ListPartsResponse.class) {
                    String str40 = str36;
                    abstractBceResponse.getClass().getMethod(str20, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str33)});
                    abstractBceResponse.getClass().getMethod(str31, new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str14)});
                    abstractBceResponse.getClass().getMethod("setUploadId", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str29)});
                    abstractBceResponse.getClass().getMethod("setInitiated", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(jSONObject.getString("initiated"))});
                    abstractBceResponse.getClass().getMethod("setStorageClass", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str37)});
                    abstractBceResponse.getClass().getMethod("setPartNumberMarker", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("partNumberMarker")});
                    abstractBceResponse.getClass().getMethod("setNextPartNumberMarker", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("nextPartNumberMarker")});
                    abstractBceResponse.getClass().getMethod("setMaxParts", new Class[]{Integer.TYPE}).invoke(abstractBceResponse2, new Object[]{Integer.valueOf(jSONObject.getInt("maxParts"))});
                    abstractBceResponse.getClass().getMethod(str9, new Class[]{Boolean.TYPE}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(str8)});
                    JSONObject jSONObject7 = new JSONObject(jSONObject.getString(str38));
                    User user4 = new User();
                    user4.setDisplayName(jSONObject7.getString(str35));
                    user4.setId(jSONObject7.getString(str40));
                    abstractBceResponse.getClass().getMethod(str25, new Class[]{User.class}).invoke(abstractBceResponse2, new Object[]{user4});
                    ArrayList arrayList9 = new ArrayList();
                    JSONArray jSONArray9 = jSONObject.getJSONArray("parts");
                    for (int i10 = 0; i10 < jSONArray9.length(); i10++) {
                        JSONObject optJSONObject5 = jSONArray9.optJSONObject(i10);
                        PartSummary partSummary = new PartSummary();
                        partSummary.setPartNumber(optJSONObject5.getInt("partNumber"));
                        partSummary.setETag(optJSONObject5.getString(str39));
                        partSummary.setSize((long) optJSONObject5.getInt("size"));
                        partSummary.setLastModified(DateUtils.parseAlternateIso8601Date(optJSONObject5.getString(str28)));
                        arrayList9.add(partSummary);
                    }
                    abstractBceResponse.getClass().getMethod("setParts", new Class[]{List.class}).invoke(abstractBceResponse2, new Object[]{arrayList9});
                } else if (abstractBceResponse.getClass() == GetSessionTokenResponse.class) {
                    abstractBceResponse.getClass().getMethod("setAccessKeyId", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("accessKeyId")});
                    abstractBceResponse.getClass().getMethod("setSecretAccessKey", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("secretAccessKey")});
                    abstractBceResponse.getClass().getMethod("setSessionToken", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get(StsClient.GET_SESSION_TOKEN_PATH)});
                    abstractBceResponse.getClass().getMethod("setExpiration", new Class[]{Date.class}).invoke(abstractBceResponse2, new Object[]{DateUtils.parseAlternateIso8601Date(jSONObject.getString("expiration"))});
                } else if (abstractBceResponse.getClass() == GetBucketLocationResponse.class) {
                    abstractBceResponse.getClass().getMethod("setLocationConstraint", new Class[]{cls}).invoke(abstractBceResponse2, new Object[]{jSONObject.get("locationConstraint")});
                }
            }
        }
    }

    public static String setAclJson(List<Grant> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (Grant grant : list) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (Permission permission : grant.getPermission()) {
                jSONArray2.put(permission.toString());
            }
            jSONObject2.put("permission", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (Grantee grantee : grant.getGrantee()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", grantee.getId());
                jSONArray3.put(jSONObject3);
            }
            jSONObject2.put("grantee", jSONArray3);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("accessControlList", jSONArray);
        return jSONObject.toString();
    }

    public static String setPartETag(List<PartETag> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        for (PartETag partETag : list) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("eTag", partETag.getETag());
            jSONObject2.put("partNumber", partETag.getPartNumber());
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("parts", jSONArray);
        return jSONObject.toString();
    }

    public static void load(InputStream inputStream, AbstractBceResponse abstractBceResponse) throws IOException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JSONException, ParseException {
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str = a.a(str, readLine);
                } else {
                    inputStream.close();
                    loadFromString(str, abstractBceResponse);
                    return;
                }
            }
        }
    }
}
