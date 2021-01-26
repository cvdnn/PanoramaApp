package com.baidubce.services.bos;

import android.annotation.SuppressLint;
import com.arashivision.graphicpath.render.source.ExtraMetadataKey;
import com.baidubce.AbstractBceClient;
import com.baidubce.BceClientException;
import com.baidubce.BceConfig;
import com.baidubce.BceServiceException;
import com.baidubce.BceServiceException.ErrorType;
import com.baidubce.auth.BceV1Signer;
import com.baidubce.auth.SignOptions;
import com.baidubce.http.Headers;
import com.baidubce.http.HttpMethodName;
import com.baidubce.http.handler.BceErrorResponseHandler;
import com.baidubce.http.handler.BceJsonResponseHandler;
import com.baidubce.http.handler.BceMetadataResponseHandler;
import com.baidubce.http.handler.BosMetadataResponseHandler;
import com.baidubce.http.handler.HttpResponseHandler;
import com.baidubce.internal.InternalRequest;
import com.baidubce.internal.RestartableInputStream;
import com.baidubce.internal.RestartableNonResettableInputStream;
import com.baidubce.internal.RestartableResettableInputStream;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.model.User;
import com.baidubce.services.bos.callback.BosProgressCallback;
import com.baidubce.services.bos.common.utils.BosUtils;
import com.baidubce.services.bos.model.AbortMultipartUploadRequest;
import com.baidubce.services.bos.model.AppendObjectRequest;
import com.baidubce.services.bos.model.AppendObjectResponse;
import com.baidubce.services.bos.model.BosObject;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.BosResponse;
import com.baidubce.services.bos.model.CannedAccessControlList;
import com.baidubce.services.bos.model.CompleteMultipartUploadRequest;
import com.baidubce.services.bos.model.CompleteMultipartUploadResponse;
import com.baidubce.services.bos.model.CopyObjectRequest;
import com.baidubce.services.bos.model.CopyObjectResponse;
import com.baidubce.services.bos.model.CopyObjectResponseWithExceptionInfo;
import com.baidubce.services.bos.model.CreateBucketRequest;
import com.baidubce.services.bos.model.CreateBucketResponse;
import com.baidubce.services.bos.model.DeleteBucketRequest;
import com.baidubce.services.bos.model.DeleteObjectRequest;
import com.baidubce.services.bos.model.DoesBucketExistRequest;
import com.baidubce.services.bos.model.GeneratePresignedUrlRequest;
import com.baidubce.services.bos.model.GetBosAccountOwnerRequest;
import com.baidubce.services.bos.model.GetBucketAclRequest;
import com.baidubce.services.bos.model.GetBucketAclResponse;
import com.baidubce.services.bos.model.GetBucketLocationRequest;
import com.baidubce.services.bos.model.GetBucketLocationResponse;
import com.baidubce.services.bos.model.GetObjectMetadataRequest;
import com.baidubce.services.bos.model.GetObjectRequest;
import com.baidubce.services.bos.model.GetObjectResponse;
import com.baidubce.services.bos.model.InitiateMultipartUploadRequest;
import com.baidubce.services.bos.model.InitiateMultipartUploadResponse;
import com.baidubce.services.bos.model.ListBucketsRequest;
import com.baidubce.services.bos.model.ListBucketsResponse;
import com.baidubce.services.bos.model.ListMultipartUploadsRequest;
import com.baidubce.services.bos.model.ListMultipartUploadsResponse;
import com.baidubce.services.bos.model.ListObjectsRequest;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.ListPartsRequest;
import com.baidubce.services.bos.model.ListPartsResponse;
import com.baidubce.services.bos.model.ObjectMetadata;
import com.baidubce.services.bos.model.PartETag;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import com.baidubce.services.bos.model.ResponseHeaderOverrides;
import com.baidubce.services.bos.model.SetBucketAclRequest;
import com.baidubce.services.bos.model.UploadPartRequest;
import com.baidubce.services.bos.model.UploadPartResponse;
import com.baidubce.util.CheckUtils;
import com.baidubce.util.HttpUtils;
import com.baidubce.util.JsonUtils;
import e.a.a.a.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;

@SuppressLint({"NewApi"})
public class BosClient extends AbstractBceClient {
    public static final String STORAGE_CLASS_COLD = "COLD";
    public static final String STORAGE_CLASS_STANDARD = "STANDARD";
    public static final String STORAGE_CLASS_STANDARD_IA = "STANDARD_IA";
    public static final HttpResponseHandler[] bos_handlers = {new BceMetadataResponseHandler(), new BosMetadataResponseHandler(), new BceErrorResponseHandler(), new BosObjectResponseHandler(), new BceJsonResponseHandler()};

    public BosClient() {
        this(new BosClientConfiguration());
    }

    private void addResponseHeaderParameters(InternalRequest internalRequest, ResponseHeaderOverrides responseHeaderOverrides) {
        if (responseHeaderOverrides != null) {
            if (responseHeaderOverrides.getCacheControl() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CACHE_CONTROL, responseHeaderOverrides.getCacheControl());
            }
            if (responseHeaderOverrides.getContentDisposition() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_DISPOSITION, responseHeaderOverrides.getContentDisposition());
            }
            if (responseHeaderOverrides.getContentEncoding() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_ENCODING, responseHeaderOverrides.getContentEncoding());
            }
            if (responseHeaderOverrides.getContentLanguage() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_LANGUAGE, responseHeaderOverrides.getContentLanguage());
            }
            if (responseHeaderOverrides.getContentType() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_TYPE, responseHeaderOverrides.getContentType());
            }
            if (responseHeaderOverrides.getExpires() != null) {
                internalRequest.addParameter(ResponseHeaderOverrides.RESPONSE_HEADER_EXPIRES, responseHeaderOverrides.getExpires());
            }
        }
    }

    private void assertStringNotNullOrEmpty(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException(str2);
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException(str2);
        }
    }

    private URL convertRequestToUrl(InternalRequest<AbstractBceRequest> internalRequest) {
        String str;
        String str2;
        String str3;
        String str4;
        String normalizePath = HttpUtils.normalizePath(internalRequest.getUri().getPath());
        String str5 = BceConfig.BOS_DELIMITER;
        boolean z = true;
        if (normalizePath.startsWith(str5)) {
            normalizePath = normalizePath.substring(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(normalizePath);
        String replaceAll = sb.toString().replaceAll("(?<=/)/", "%2F");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getEndpoint());
        sb2.append(replaceAll);
        String sb3 = sb2.toString();
        Iterator it = internalRequest.getParameters().keySet().iterator();
        while (true) {
            str = "?";
            str2 = "&";
            if (!it.hasNext()) {
                break;
            }
            String str6 = (String) it.next();
            if (z) {
                str4 = a.a(sb3, str);
                z = false;
            } else {
                str4 = a.a(sb3, str2);
            }
            String str7 = (String) internalRequest.getParameters().get(str6);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str4);
            sb4.append(str6);
            sb4.append("=");
            sb4.append(HttpUtils.normalize(str7));
            sb3 = sb4.toString();
        }
        String str8 = (String) internalRequest.getHeaders().get(Headers.AUTHORIZATION);
        if (str8 != null) {
            if (z) {
                str3 = a.a(sb3, str);
            } else {
                str3 = a.a(sb3, str2);
            }
            StringBuilder b2 = a.b(str3, "authorization=");
            b2.append(HttpUtils.normalize(str8));
            sb3 = b2.toString();
        }
        try {
            return new URL(sb3);
        } catch (MalformedURLException e2) {
            StringBuilder a2 = a.a("Unable to convert request to well formed URL: ");
            a2.append(e2.getMessage());
            throw new BceClientException(a2.toString(), e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T extends com.baidubce.model.AbstractBceRequest> com.baidubce.internal.InternalRequest createRequest(T r8, com.baidubce.http.HttpMethodName r9) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.baidubce.services.bos.model.GenericBucketRequest
            r1 = 0
            if (r0 == 0) goto L_0x0029
            com.baidubce.BceClientConfiguration r0 = r7.config
            com.baidubce.services.bos.BosClientConfiguration r0 = (com.baidubce.services.bos.BosClientConfiguration) r0
            java.lang.Boolean r0 = r0.isCnameEnabled()
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            if (r0 == r2) goto L_0x0021
            if (r0 != 0) goto L_0x0029
            java.net.URI r0 = r7.getEndpoint()
            java.lang.String r0 = r0.getHost()
            boolean r0 = com.baidubce.services.bos.common.utils.BosUtils.isCnameLikeHost(r0)
            if (r0 != 0) goto L_0x0029
        L_0x0021:
            r0 = r8
            com.baidubce.services.bos.model.GenericBucketRequest r0 = (com.baidubce.services.bos.model.GenericBucketRequest) r0
            java.lang.String r0 = r0.getBucketName()
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            boolean r2 = r8 instanceof com.baidubce.services.bos.model.GenericObjectRequest
            if (r2 == 0) goto L_0x0035
            r1 = r8
            com.baidubce.services.bos.model.GenericObjectRequest r1 = (com.baidubce.services.bos.model.GenericObjectRequest) r1
            java.lang.String r1 = r1.getKey()
        L_0x0035:
            com.baidubce.internal.InternalRequest r2 = new com.baidubce.internal.InternalRequest
            java.net.URI r3 = r7.getEndpoint()
            r4 = 3
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "v1"
            r4[r5] = r6
            r5 = 1
            r4[r5] = r0
            r0 = 2
            r4[r0] = r1
            java.net.URI r0 = com.baidubce.util.HttpUtils.appendUri(r3, r4)
            r2.<init>(r9, r0)
            com.baidubce.auth.BceCredentials r9 = r8.getRequestCredentials()
            r2.setCredentials(r9)
            r2.setRequest(r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.createRequest(com.baidubce.model.AbstractBceRequest, com.baidubce.http.HttpMethodName):com.baidubce.internal.InternalRequest");
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r3v0, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v4, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v13, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: type inference failed for: r9v17, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* JADX WARNING: type inference failed for: r9v21 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r9v23 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v8
  assigns: []
  uses: []
  mth insns count: 111
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
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fa A[SYNTHETIC, Splitter:B:62:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 10 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void downloadObjectToFile(com.baidubce.services.bos.model.BosObject r9, java.io.File r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Couldn't get object content"
            java.lang.String r1 = "Couldn't close the output stream"
            java.io.File r2 = r10.getParentFile()
            if (r2 == 0) goto L_0x0013
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x0013
            r2.mkdirs()
        L_0x0013:
            r2 = 0
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00cd }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00cd }
            r4.<init>(r10)     // Catch:{ IOException -> 0x00cd }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00cd }
            int r4 = r8.getStreamBufferSize()     // Catch:{ IOException -> 0x00c8, all -> 0x00c6 }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x00c8, all -> 0x00c6 }
        L_0x0024:
            com.baidubce.services.bos.BosObjectInputStream r5 = r9.getObjectContent()     // Catch:{ IOException -> 0x00c8, all -> 0x00c6 }
            int r5 = r5.read(r4)     // Catch:{ IOException -> 0x00c8, all -> 0x00c6 }
            r6 = -1
            r7 = 0
            if (r5 <= r6) goto L_0x0034
            r3.write(r4, r7, r5)     // Catch:{ IOException -> 0x00c8, all -> 0x00c6 }
            goto L_0x0024
        L_0x0034:
            r3.close()     // Catch:{ Exception -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            r3 = move-exception
            java.lang.Throwable r3 = r3.getCause()
            com.baidubce.util.BLog.error(r1, r3)
        L_0x0040:
            com.baidubce.services.bos.BosObjectInputStream r1 = r9.getObjectContent()     // Catch:{ Exception -> 0x0048 }
            r1.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x0050
        L_0x0048:
            r1 = move-exception
            java.lang.Throwable r1 = r1.getCause()
            com.baidubce.util.BLog.error(r0, r1)
        L_0x0050:
            if (r11 == 0) goto L_0x00c5
            com.baidubce.services.bos.model.ObjectMetadata r9 = r9.getObjectMetadata()
            java.lang.String r11 = r9.getBceContentSha256()     // Catch:{ Exception -> 0x0094 }
            if (r11 == 0) goto L_0x0074
            java.lang.String r9 = r9.getBceContentSha256()     // Catch:{ Exception -> 0x0094 }
            char[] r9 = r9.toCharArray()     // Catch:{ Exception -> 0x0094 }
            byte[] r9 = com.baidubce.util.ConvertUtils.decodeHex(r9)     // Catch:{ Exception -> 0x0094 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0072 }
            byte[] r11 = com.baidubce.util.HashUtils.computeSha256Hash(r11)     // Catch:{ Exception -> 0x0072 }
            goto L_0x009d
        L_0x0072:
            r11 = move-exception
            goto L_0x0097
        L_0x0074:
            java.lang.String r11 = r9.getContentMd5()     // Catch:{ Exception -> 0x0094 }
            if (r11 == 0) goto L_0x0092
            java.lang.String r9 = r9.getContentMd5()     // Catch:{ Exception -> 0x0094 }
            java.lang.String r11 = "UTF-8"
            byte[] r9 = r9.getBytes(r11)     // Catch:{ Exception -> 0x0094 }
            byte[] r9 = android.util.Base64.decode(r9, r7)     // Catch:{ Exception -> 0x0094 }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0072 }
            byte[] r11 = com.baidubce.util.HashUtils.computeMd5Hash(r11)     // Catch:{ Exception -> 0x0072 }
            goto L_0x009d
        L_0x0092:
            r11 = r2
            goto L_0x009e
        L_0x0094:
            r9 = move-exception
            r11 = r9
            r9 = r2
        L_0x0097:
            java.lang.String r0 = "Unable to verify the integrity of the downloaded file"
            com.baidubce.util.BLog.error(r0, r11)
            r11 = r2
        L_0x009d:
            r2 = r9
        L_0x009e:
            if (r2 == 0) goto L_0x00c5
            if (r11 == 0) goto L_0x00c5
            boolean r9 = java.util.Arrays.equals(r11, r2)
            if (r9 == 0) goto L_0x00a9
            goto L_0x00c5
        L_0x00a9:
            com.baidubce.BceClientException r9 = new com.baidubce.BceClientException
            java.lang.String r11 = "Integrity verification failed! Client calculated content hash didn't match hash from server. The data stored in '"
            java.lang.StringBuilder r11 = e.a.a.a.a.a(r11)
            java.lang.String r10 = r10.getAbsolutePath()
            r11.append(r10)
            java.lang.String r10 = "' may be corrupt."
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x00c5:
            return
        L_0x00c6:
            r10 = move-exception
            goto L_0x00f8
        L_0x00c8:
            r10 = move-exception
            r2 = r3
            goto L_0x00ce
        L_0x00cb:
            r10 = move-exception
            goto L_0x00f7
        L_0x00cd:
            r10 = move-exception
        L_0x00ce:
            com.baidubce.services.bos.BosObjectInputStream r11 = r9.getObjectContent()     // Catch:{ IOException -> 0x00d6 }
            r11.close()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00dc
        L_0x00d6:
            r11 = move-exception
            java.lang.String r3 = "Couldn't abort stream"
            com.baidubce.util.BLog.error(r3, r11)     // Catch:{ all -> 0x00cb }
        L_0x00dc:
            com.baidubce.BceClientException r11 = new com.baidubce.BceClientException     // Catch:{ all -> 0x00cb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cb }
            r3.<init>()     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = "Unable to write to disk:"
            r3.append(r4)     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = r10.getMessage()     // Catch:{ all -> 0x00cb }
            r3.append(r4)     // Catch:{ all -> 0x00cb }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00cb }
            r11.<init>(r3, r10)     // Catch:{ all -> 0x00cb }
            throw r11     // Catch:{ all -> 0x00cb }
        L_0x00f7:
            r3 = r2
        L_0x00f8:
            if (r3 == 0) goto L_0x0106
            r3.close()     // Catch:{ Exception -> 0x00fe }
            goto L_0x0106
        L_0x00fe:
            r11 = move-exception
            java.lang.Throwable r11 = r11.getCause()
            com.baidubce.util.BLog.error(r1, r11)
        L_0x0106:
            com.baidubce.services.bos.BosObjectInputStream r9 = r9.getObjectContent()     // Catch:{ Exception -> 0x010e }
            r9.close()     // Catch:{ Exception -> 0x010e }
            goto L_0x0116
        L_0x010e:
            r9 = move-exception
            java.lang.Throwable r9 = r9.getCause()
            com.baidubce.util.BLog.error(r0, r9)
        L_0x0116:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.downloadObjectToFile(com.baidubce.services.bos.model.BosObject, java.io.File, boolean):void");
    }

    private int getStreamBufferSize() {
        return ((BosClientConfiguration) this.config).getStreamBufferSize();
    }

    public static void populateRequestMetadata(InternalRequest internalRequest, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentType() != null) {
            internalRequest.addHeader("Content-Type", objectMetadata.getContentType());
        }
        if (objectMetadata.getContentMd5() != null) {
            internalRequest.addHeader(Headers.CONTENT_MD5, objectMetadata.getContentMd5());
        }
        if (objectMetadata.getContentEncoding() != null) {
            internalRequest.addHeader(Headers.CONTENT_ENCODING, HttpUtils.normalize(objectMetadata.getContentEncoding()));
        }
        if (objectMetadata.getBceContentSha256() != null) {
            internalRequest.addHeader(Headers.BCE_CONTENT_SHA256, objectMetadata.getBceContentSha256());
        }
        if (objectMetadata.getContentDisposition() != null) {
            internalRequest.addHeader(Headers.CONTENT_DISPOSITION, HttpUtils.normalize(objectMetadata.getContentDisposition()));
        }
        if (objectMetadata.getETag() != null) {
            internalRequest.addHeader(Headers.ETAG, objectMetadata.getETag());
        }
        if (objectMetadata.getExpires() != null) {
            internalRequest.addHeader(Headers.EXPIRES, objectMetadata.getExpires());
        }
        if (objectMetadata.getCacheControl() != null) {
            internalRequest.addHeader(Headers.CACHE_CONTROL, objectMetadata.getCacheControl());
        }
        if (objectMetadata.getStorageClass() != null) {
            internalRequest.addHeader(Headers.BCE_STORAGE_CLASS, objectMetadata.getStorageClass());
        }
        if (objectMetadata.getCrc32() != null) {
            internalRequest.addHeader(Headers.BCE_CRC32, String.valueOf(objectMetadata.getCrc32()));
        }
        Map userMetadata = objectMetadata.getUserMetadata();
        if (userMetadata != null) {
            for (Entry entry : userMetadata.entrySet()) {
                String str = (String) entry.getKey();
                if (str != null) {
                    String str2 = (String) entry.getValue();
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (str2.length() + str.length() <= 32768) {
                        StringBuilder a2 = a.a(Headers.BCE_USER_METADATA_PREFIX);
                        a2.append(HttpUtils.normalize(str.trim()));
                        internalRequest.addHeader(a2.toString(), HttpUtils.normalize(str2));
                    } else {
                        throw new BceClientException("MetadataTooLarge");
                    }
                }
            }
        }
    }

    private List<byte[]> readAll(InputStream inputStream, ObjectMetadata objectMetadata) {
        ArrayList arrayList = new ArrayList();
        int streamBufferSize = getStreamBufferSize();
        long j2 = 0;
        while (true) {
            byte[] bArr = new byte[streamBufferSize];
            arrayList.add(bArr);
            int i2 = 0;
            while (true) {
                if (i2 < streamBufferSize) {
                    try {
                        int read = inputStream.read(bArr, i2, streamBufferSize - i2);
                        if (read < 0) {
                            objectMetadata.setContentLength(j2);
                            return arrayList;
                        }
                        j2 += (long) read;
                        i2 += read;
                    } catch (IOException e2) {
                        StringBuilder a2 = a.a("Fail to read data:");
                        a2.append(e2.getMessage());
                        throw new BceClientException(a2.toString(), e2);
                    }
                }
            }
        }
    }

    private void setZeroContentLength(InternalRequest internalRequest) {
        internalRequest.addHeader("Content-Length", String.valueOf(0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[SYNTHETIC, Splitter:B:31:0x0082] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidubce.services.bos.model.BosResponse uploadObject(com.baidubce.services.bos.model.PutObjectRequest r12, com.baidubce.internal.InternalRequest r13) {
        /*
            r11 = this;
            java.lang.String r0 = "The inputStream accured error"
            java.lang.String r1 = "Fail to close input stream"
            com.baidubce.services.bos.model.ObjectMetadata r2 = r12.getObjectMetadata()
            java.io.InputStream r3 = r12.getInputStream()
            java.io.File r4 = r12.getFile()
            r5 = 0
            if (r4 == 0) goto L_0x00b3
            java.io.File r3 = r12.getFile()
            long r7 = r3.length()
            r9 = 5368709120(0x140000000, double:2.6524947387E-314)
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 > 0) goto L_0x009c
            long r7 = r2.getContentLength()
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0034
            long r4 = r3.length()
            r2.setContentLength(r4)
        L_0x0034:
            java.lang.String r4 = r2.getContentType()
            if (r4 != 0) goto L_0x0045
            com.baidubce.util.Mimetypes r4 = com.baidubce.util.Mimetypes.getInstance()
            java.lang.String r4 = r4.getMimetype(r3)
            r2.setContentType(r4)
        L_0x0045:
            long r4 = r2.getContentLength()
            long r6 = r3.length()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x008a
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0077 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0077 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            byte[] r6 = com.baidubce.util.HashUtils.computeSha256Hash(r5)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            char[] r6 = com.baidubce.util.ConvertUtils.encodeHex(r6)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r2.setBceContentSha256(r4)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r5.close()     // Catch:{ Exception -> 0x006b }
            goto L_0x008a
        L_0x006b:
            com.baidubce.util.BLog.error(r0)
            goto L_0x008a
        L_0x006f:
            r12 = move-exception
            r4 = r5
            goto L_0x0080
        L_0x0072:
            r12 = move-exception
            r4 = r5
            goto L_0x0078
        L_0x0075:
            r12 = move-exception
            goto L_0x0080
        L_0x0077:
            r12 = move-exception
        L_0x0078:
            com.baidubce.BceClientException r13 = new com.baidubce.BceClientException     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = "Unable to calculate SHA-256 hash"
            r13.<init>(r1, r12)     // Catch:{ all -> 0x0075 }
            throw r13     // Catch:{ all -> 0x0075 }
        L_0x0080:
            if (r4 == 0) goto L_0x0089
            r4.close()     // Catch:{ Exception -> 0x0086 }
            goto L_0x0089
        L_0x0086:
            com.baidubce.util.BLog.error(r0)
        L_0x0089:
            throw r12
        L_0x008a:
            com.baidubce.internal.RestartableFileInputStream r0 = new com.baidubce.internal.RestartableFileInputStream     // Catch:{ FileNotFoundException -> 0x0093 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0093 }
            r13.setContent(r0)     // Catch:{ FileNotFoundException -> 0x0093 }
            goto L_0x00fc
        L_0x0093:
            r12 = move-exception
            com.baidubce.BceClientException r13 = new com.baidubce.BceClientException
            java.lang.String r0 = "Unable to find file to upload"
            r13.<init>(r0, r12)
            throw r13
        L_0x009c:
            com.baidubce.BceServiceException r12 = new com.baidubce.BceServiceException
            java.lang.String r13 = "Your proposed upload exceeds the maximum allowed object size."
            r12.<init>(r13)
            r13 = 400(0x190, float:5.6E-43)
            r12.setStatusCode(r13)
            java.lang.String r13 = "EntityTooLarge"
            r12.setErrorCode(r13)
            com.baidubce.BceServiceException$ErrorType r13 = com.baidubce.BceServiceException.ErrorType.Client
            r12.setErrorType(r13)
            throw r12
        L_0x00b3:
            java.lang.String r0 = "Either file or inputStream should be set."
            com.baidubce.util.CheckUtils.isNotNull(r3, r0)
            long r7 = r2.getContentLength()
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00d6
            java.lang.String r0 = "No content length specified for stream data. Trying to read them all into memory."
            com.baidubce.util.BLog.warn(r0)
            java.util.List r0 = r11.readAll(r3, r2)
            com.baidubce.internal.RestartableMultiByteArrayInputStream r3 = new com.baidubce.internal.RestartableMultiByteArrayInputStream
            long r4 = r2.getContentLength()
            r3.<init>(r0, r4)
            r13.setContent(r3)
            goto L_0x00e7
        L_0x00d6:
            boolean r0 = r3 instanceof com.baidubce.internal.RestartableInputStream
            if (r0 == 0) goto L_0x00e0
            com.baidubce.internal.RestartableInputStream r3 = (com.baidubce.internal.RestartableInputStream) r3
            r13.setContent(r3)
            goto L_0x00e7
        L_0x00e0:
            com.baidubce.internal.RestartableInputStream r0 = r11.wrapRestartableInputStream(r3)
            r13.setContent(r0)
        L_0x00e7:
            java.lang.String r0 = r2.getContentType()
            if (r0 != 0) goto L_0x00fc
            com.baidubce.util.Mimetypes r0 = com.baidubce.util.Mimetypes.getInstance()
            java.lang.String r3 = r12.getKey()
            java.lang.String r0 = r0.getMimetype(r3)
            r2.setContentType(r0)
        L_0x00fc:
            java.lang.String r0 = r12.getStorageClass()
            if (r0 == 0) goto L_0x0109
            java.lang.String r0 = r12.getStorageClass()
            r2.setStorageClass(r0)
        L_0x0109:
            long r3 = r2.getContentLength()
            java.lang.String r0 = java.lang.String.valueOf(r3)
            java.lang.String r3 = "Content-Length"
            r13.addHeader(r3, r0)
            populateRequestMetadata(r13, r2)
            java.lang.Class<com.baidubce.services.bos.model.BosResponse> r0 = com.baidubce.services.bos.model.BosResponse.class
            com.baidubce.services.bos.callback.BosProgressCallback r12 = r12.getProgressCallback()     // Catch:{ all -> 0x0132 }
            com.baidubce.model.AbstractBceResponse r12 = r11.invokeHttpClient(r13, r0, r12)     // Catch:{ all -> 0x0132 }
            com.baidubce.services.bos.model.BosResponse r12 = (com.baidubce.services.bos.model.BosResponse) r12     // Catch:{ all -> 0x0132 }
            com.baidubce.internal.RestartableInputStream r13 = r13.getContent()     // Catch:{ Exception -> 0x012d }
            r13.close()     // Catch:{ Exception -> 0x012d }
            goto L_0x0131
        L_0x012d:
            r13 = move-exception
            com.baidubce.util.BLog.error(r1, r13)
        L_0x0131:
            return r12
        L_0x0132:
            r12 = move-exception
            com.baidubce.internal.RestartableInputStream r13 = r13.getContent()     // Catch:{ Exception -> 0x013b }
            r13.close()     // Catch:{ Exception -> 0x013b }
            goto L_0x013f
        L_0x013b:
            r13 = move-exception
            com.baidubce.util.BLog.error(r1, r13)
        L_0x013f:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.uploadObject(com.baidubce.services.bos.model.PutObjectRequest, com.baidubce.internal.InternalRequest):com.baidubce.services.bos.model.BosResponse");
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream) {
        if (inputStream.markSupported()) {
            return new RestartableResettableInputStream(inputStream);
        }
        return new RestartableNonResettableInputStream(inputStream, getStreamBufferSize());
    }

    public void abortMultipartUpload(String str, String str2, String str3) {
        abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
    }

    public AppendObjectResponse appendObject(String str, String str2, File file) {
        return appendObject(new AppendObjectRequest(str, str2, file));
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list) throws JSONException {
        return completeMultipartUpload(new CompleteMultipartUploadRequest(str, str2, str3, list));
    }

    public CopyObjectResponse copyObject(String str, String str2, String str3, String str4) {
        return copyObject(new CopyObjectRequest(str, str2, str3, str4));
    }

    public CreateBucketResponse createBucket(String str) {
        return createBucket(new CreateBucketRequest(str));
    }

    public void deleteBucket(String str) {
        deleteBucket(new DeleteBucketRequest(str));
    }

    public void deleteObject(String str, String str2) {
        deleteObject(new DeleteObjectRequest(str, str2));
    }

    public boolean doesBucketExist(String str) {
        return doesBucketExist(new DoesBucketExistRequest(str));
    }

    public URL generatePresignedUrl(String str, String str2, int i2) {
        return generatePresignedUrl(str, str2, i2, HttpMethodName.GET);
    }

    public User getBosAccountOwner() {
        return getBosAccountOwner(new GetBosAccountOwnerRequest());
    }

    public GetBucketAclResponse getBucketAcl(String str) {
        return getBucketAcl(new GetBucketAclRequest(str));
    }

    public GetBucketLocationResponse getBucketLocation(String str) {
        return getBucketLocation(new GetBucketLocationRequest(str));
    }

    public BosObject getObject(String str, String str2) {
        return getObject(new GetObjectRequest(str, str2));
    }

    public byte[] getObjectContent(String str, String str2) {
        return getObjectContent(new GetObjectRequest(str, str2));
    }

    public ObjectMetadata getObjectMetadata(String str, String str2) {
        return getObjectMetadata(new GetObjectMetadataRequest(str, str2));
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(String str, String str2) {
        return initiateMultipartUpload(new InitiateMultipartUploadRequest(str, str2));
    }

    public ListBucketsResponse listBuckets() {
        return listBuckets(new ListBucketsRequest());
    }

    public ListMultipartUploadsResponse listMultipartUploads(String str) {
        return listMultipartUploads(new ListMultipartUploadsRequest(str));
    }

    public ListObjectsResponse listNextBatchOfObjects(ListObjectsResponse listObjectsResponse) {
        CheckUtils.isNotNull(listObjectsResponse, "previousResponse should not be null.");
        if (listObjectsResponse.isTruncated()) {
            return listObjects(new ListObjectsRequest(listObjectsResponse.getBucketName()).withPrefix(listObjectsResponse.getPrefix()).withMarker(listObjectsResponse.getNextMarker()).withDelimiter(listObjectsResponse.getDelimiter()).withMaxKeys(listObjectsResponse.getMaxKeys()));
        }
        ListObjectsResponse listObjectsResponse2 = new ListObjectsResponse();
        listObjectsResponse2.setBucketName(listObjectsResponse.getBucketName());
        listObjectsResponse2.setDelimiter(listObjectsResponse.getDelimiter());
        listObjectsResponse2.setMarker(listObjectsResponse.getNextMarker());
        listObjectsResponse2.setMaxKeys(listObjectsResponse.getMaxKeys());
        listObjectsResponse2.setPrefix(listObjectsResponse.getPrefix());
        listObjectsResponse2.setTruncated(false);
        return listObjectsResponse2;
    }

    public ListObjectsResponse listObjects(String str) {
        return listObjects(new ListObjectsRequest(str));
    }

    public ListPartsResponse listParts(String str, String str2, String str3) {
        return listParts(new ListPartsRequest(str, str2, str3));
    }

    public PutObjectResponse putObject(String str, String str2, File file) {
        return putObject(new PutObjectRequest(str, str2, file));
    }

    public void setBucketAcl(String str, CannedAccessControlList cannedAccessControlList) throws JSONException {
        setBucketAcl(new SetBucketAclRequest(str, cannedAccessControlList));
    }

    @Deprecated
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest, BosProgressCallback bosProgressCallback) {
        uploadPartRequest.setProgressCallback(bosProgressCallback);
        return uploadPart(uploadPartRequest);
    }

    public BosClient(BosClientConfiguration bosClientConfiguration) {
        super(bosClientConfiguration, bos_handlers);
    }

    public void abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        CheckUtils.isNotNull(abortMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(abortMultipartUploadRequest, HttpMethodName.DELETE);
        createRequest.addParameter("uploadId", abortMultipartUploadRequest.getUploadId());
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public AppendObjectResponse appendObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return appendObject(new AppendObjectRequest(str, str2, file, objectMetadata));
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(String str, String str2, String str3, List<PartETag> list, ObjectMetadata objectMetadata) throws JSONException {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, list, objectMetadata);
        return completeMultipartUpload(completeMultipartUploadRequest);
    }

    public CreateBucketResponse createBucket(CreateBucketRequest createBucketRequest) {
        CheckUtils.isNotNull(createBucketRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(createBucketRequest, HttpMethodName.PUT);
        setZeroContentLength(createRequest);
        BosResponse bosResponse = (BosResponse) invokeHttpClient(createRequest, BosResponse.class);
        CreateBucketResponse createBucketResponse = new CreateBucketResponse();
        createBucketResponse.setName(createBucketRequest.getBucketName());
        createBucketResponse.setLocation(bosResponse.getMetadata().getLocation());
        return createBucketResponse;
    }

    public void deleteBucket(DeleteBucketRequest deleteBucketRequest) {
        CheckUtils.isNotNull(deleteBucketRequest, "request should not be null.");
        invokeHttpClient(createRequest(deleteBucketRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public void deleteObject(DeleteObjectRequest deleteObjectRequest) {
        CheckUtils.isNotNull(deleteObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(deleteObjectRequest.getKey(), "object key should not be null or empty");
        invokeHttpClient(createRequest(deleteObjectRequest, HttpMethodName.DELETE), BosResponse.class);
    }

    public boolean doesBucketExist(DoesBucketExistRequest doesBucketExistRequest) {
        CheckUtils.isNotNull(doesBucketExistRequest, "request should not be null.");
        try {
            invokeHttpClient(createRequest(doesBucketExistRequest, HttpMethodName.HEAD), BosResponse.class);
            return true;
        } catch (BceServiceException e2) {
            if (e2.getStatusCode() == 403) {
                return true;
            }
            if (e2.getStatusCode() == 404) {
                return false;
            }
            throw e2;
        }
    }

    public URL generatePresignedUrl(String str, String str2, int i2, HttpMethodName httpMethodName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(str, str2, httpMethodName);
        generatePresignedUrlRequest.setExpiration(i2);
        return generatePresignedUrl(generatePresignedUrlRequest);
    }

    public User getBosAccountOwner(GetBosAccountOwnerRequest getBosAccountOwnerRequest) {
        CheckUtils.isNotNull(getBosAccountOwnerRequest, "request should not be null.");
        return ((ListBucketsResponse) invokeHttpClient(createRequest(getBosAccountOwnerRequest, HttpMethodName.GET), ListBucketsResponse.class)).getOwner();
    }

    public GetBucketAclResponse getBucketAcl(GetBucketAclRequest getBucketAclRequest) {
        CheckUtils.isNotNull(getBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketAclRequest, HttpMethodName.GET);
        createRequest.addParameter("acl", null);
        GetBucketAclResponse getBucketAclResponse = (GetBucketAclResponse) invokeHttpClient(createRequest, GetBucketAclResponse.class);
        if (getBucketAclResponse.getVersion() <= 1) {
            return getBucketAclResponse;
        }
        throw new BceClientException("Unsupported acl version.");
    }

    public GetBucketLocationResponse getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) {
        CheckUtils.isNotNull(getBucketLocationRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getBucketLocationRequest, HttpMethodName.GET);
        createRequest.addParameter("location", null);
        return (GetBucketLocationResponse) invokeHttpClient(createRequest, GetBucketLocationResponse.class);
    }

    public ObjectMetadata getObject(String str, String str2, File file) {
        return getObject(new GetObjectRequest(str, str2), file);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getObjectContent(com.baidubce.services.bos.model.GetObjectRequest r5) {
        /*
            r4 = this;
            com.baidubce.services.bos.model.BosObject r5 = r4.getObject(r5)
            com.baidubce.services.bos.BosObjectInputStream r5 = r5.getObjectContent()
            byte[] r0 = com.baidubce.util.ConvertUtils.inputStreamToByte(r5)     // Catch:{ IOException -> 0x0012 }
            r5.close()     // Catch:{ IOException -> 0x000f }
        L_0x000f:
            return r0
        L_0x0010:
            r0 = move-exception
            goto L_0x0031
        L_0x0012:
            r0 = move-exception
            r5.close()     // Catch:{ IOException -> 0x0016 }
        L_0x0016:
            com.baidubce.BceClientException r1 = new com.baidubce.BceClientException     // Catch:{ all -> 0x0010 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0010 }
            r2.<init>()     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = "Fail read object content:"
            r2.append(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x0010 }
            r2.append(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0010 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0010 }
            throw r1     // Catch:{ all -> 0x0010 }
        L_0x0031:
            r5.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.getObjectContent(com.baidubce.services.bos.model.GetObjectRequest):byte[]");
    }

    public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) {
        CheckUtils.isNotNull(getObjectMetadataRequest, "request should not be null.");
        return ((GetObjectResponse) invokeHttpClient(createRequest(getObjectMetadataRequest, HttpMethodName.HEAD), GetObjectResponse.class)).getObject().getObjectMetadata();
    }

    public InitiateMultipartUploadResponse initiateMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        CheckUtils.isNotNull(initiateMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(initiateMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploads", null);
        if (initiateMultipartUploadRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.BCE_STORAGE_CLASS, initiateMultipartUploadRequest.getStorageClass());
        }
        setZeroContentLength(createRequest);
        if (initiateMultipartUploadRequest.getObjectMetadata() != null) {
            populateRequestMetadata(createRequest, initiateMultipartUploadRequest.getObjectMetadata());
        }
        return (InitiateMultipartUploadResponse) invokeHttpClient(createRequest, InitiateMultipartUploadResponse.class);
    }

    public ListBucketsResponse listBuckets(ListBucketsRequest listBucketsRequest) {
        CheckUtils.isNotNull(listBucketsRequest, "request should not be null.");
        return (ListBucketsResponse) invokeHttpClient(createRequest(listBucketsRequest, HttpMethodName.GET), ListBucketsResponse.class);
    }

    public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) {
        CheckUtils.isNotNull(listMultipartUploadsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listMultipartUploadsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploads", null);
        String keyMarker = listMultipartUploadsRequest.getKeyMarker();
        if (keyMarker != null) {
            createRequest.addParameter("keyMarker", keyMarker);
        }
        int maxUploads = listMultipartUploadsRequest.getMaxUploads();
        if (maxUploads >= 0) {
            createRequest.addParameter("maxUploads", String.valueOf(maxUploads));
        }
        String delimiter = listMultipartUploadsRequest.getDelimiter();
        if (delimiter != null) {
            createRequest.addParameter("delimiter", delimiter);
        }
        String prefix = listMultipartUploadsRequest.getPrefix();
        if (prefix != null) {
            createRequest.addParameter("prefix", prefix);
        }
        ListMultipartUploadsResponse listMultipartUploadsResponse = (ListMultipartUploadsResponse) invokeHttpClient(createRequest, ListMultipartUploadsResponse.class);
        listMultipartUploadsResponse.setBucketName(listMultipartUploadsRequest.getBucketName());
        return listMultipartUploadsResponse;
    }

    public ListObjectsResponse listObjects(String str, String str2) {
        return listObjects(new ListObjectsRequest(str, str2));
    }

    public ListPartsResponse listParts(ListPartsRequest listPartsRequest) {
        CheckUtils.isNotNull(listPartsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listPartsRequest, HttpMethodName.GET);
        createRequest.addParameter("uploadId", listPartsRequest.getUploadId());
        int maxParts = listPartsRequest.getMaxParts();
        if (maxParts >= 0) {
            createRequest.addParameter("maxParts", String.valueOf(maxParts));
        }
        createRequest.addParameter("partNumberMarker", String.valueOf(listPartsRequest.getPartNumberMarker()));
        ListPartsResponse listPartsResponse = (ListPartsResponse) invokeHttpClient(createRequest, ListPartsResponse.class);
        listPartsResponse.setBucketName(listPartsRequest.getBucketName());
        return listPartsResponse;
    }

    public PutObjectResponse putObject(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return putObject(new PutObjectRequest(str, str2, file, objectMetadata));
    }

    public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws JSONException {
        CheckUtils.isNotNull(setBucketAclRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(setBucketAclRequest, HttpMethodName.PUT);
        createRequest.addParameter("acl", null);
        if (setBucketAclRequest.getCannedAcl() != null) {
            createRequest.addHeader(Headers.BCE_ACL, setBucketAclRequest.getCannedAcl().toString());
            setZeroContentLength(createRequest);
        } else if (setBucketAclRequest.getAccessControlList() != null) {
            try {
                byte[] bytes = JsonUtils.setAclJson(setBucketAclRequest.getAccessControlList()).getBytes("UTF-8");
                createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
                createRequest.addHeader("Content-Type", "application/json");
                createRequest.setContent(RestartableInputStream.wrap(bytes));
            } catch (UnsupportedEncodingException e2) {
                StringBuilder a2 = a.a("Fail to get UTF-8 bytes:");
                a2.append(e2.getMessage());
                throw new BceClientException(a2.toString(), e2);
            }
        } else {
            CheckUtils.isNotNull(null, "request.acl should not be null.");
        }
        invokeHttpClient(createRequest, BosResponse.class);
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e2) {
            throw new BceClientException("Fail to get bytes.", e2);
        }
    }

    public CompleteMultipartUploadResponse completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) throws JSONException {
        CheckUtils.isNotNull(completeMultipartUploadRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(completeMultipartUploadRequest, HttpMethodName.POST);
        createRequest.addParameter("uploadId", completeMultipartUploadRequest.getUploadId());
        ObjectMetadata objectMetadata = completeMultipartUploadRequest.getObjectMetadata();
        if (objectMetadata != null) {
            populateRequestMetadata(createRequest, objectMetadata);
        }
        try {
            byte[] bytes = JsonUtils.setPartETag(completeMultipartUploadRequest.getPartETags()).getBytes("UTF-8");
            createRequest.addHeader("Content-Length", String.valueOf(bytes.length));
            createRequest.addHeader("Content-Type", "application/json");
            createRequest.setContent(RestartableInputStream.wrap(bytes));
            CompleteMultipartUploadResponse completeMultipartUploadResponse = (CompleteMultipartUploadResponse) invokeHttpClient(createRequest, CompleteMultipartUploadResponse.class);
            completeMultipartUploadResponse.setBucketName(completeMultipartUploadRequest.getBucketName());
            completeMultipartUploadResponse.setCrc32(completeMultipartUploadResponse.getMetadata().getCrc32());
            return completeMultipartUploadResponse;
        } catch (UnsupportedEncodingException e2) {
            StringBuilder a2 = a.a("Fail to get UTF-8 bytes:");
            a2.append(e2.getMessage());
            throw new BceClientException(a2.toString(), e2);
        }
    }

    public CopyObjectResponse copyObject(CopyObjectRequest copyObjectRequest) {
        CheckUtils.isNotNull(copyObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(copyObjectRequest.getSourceKey(), "object key should not be null or empty");
        InternalRequest createRequest = createRequest(copyObjectRequest, HttpMethodName.PUT);
        String str = BceConfig.BOS_DELIMITER;
        StringBuilder a2 = a.a(str);
        a2.append(copyObjectRequest.getSourceBucketName());
        a2.append(str);
        a2.append(copyObjectRequest.getSourceKey());
        createRequest.addHeader(Headers.BCE_COPY_SOURCE, HttpUtils.normalizePath(a2.toString()));
        String str2 = "\"";
        if (copyObjectRequest.getETag() != null) {
            StringBuilder a3 = a.a(str2);
            a3.append(copyObjectRequest.getETag());
            a3.append(str2);
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_MATCH, a3.toString());
        }
        if (copyObjectRequest.getNoneMatchETagConstraint() != null) {
            StringBuilder a4 = a.a(str2);
            a4.append(copyObjectRequest.getNoneMatchETagConstraint());
            a4.append(str2);
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_NONE_MATCH, a4.toString());
        }
        if (copyObjectRequest.getUnmodifiedSinceConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_UNMODIFIED_SINCE, copyObjectRequest.getUnmodifiedSinceConstraint());
        }
        if (copyObjectRequest.getModifiedSinceConstraint() != null) {
            createRequest.addHeader(Headers.BCE_COPY_SOURCE_IF_MODIFIED_SINCE, copyObjectRequest.getModifiedSinceConstraint());
        }
        if (copyObjectRequest.getStorageClass() != null) {
            createRequest.addHeader(Headers.BCE_STORAGE_CLASS, copyObjectRequest.getStorageClass());
        }
        ObjectMetadata newObjectMetadata = copyObjectRequest.getNewObjectMetadata();
        String str3 = Headers.BCE_COPY_METADATA_DIRECTIVE;
        if (newObjectMetadata != null) {
            createRequest.addHeader(str3, "replace");
            populateRequestMetadata(createRequest, newObjectMetadata);
        } else {
            createRequest.addHeader(str3, "copy");
        }
        setZeroContentLength(createRequest);
        CopyObjectResponseWithExceptionInfo copyObjectResponseWithExceptionInfo = (CopyObjectResponseWithExceptionInfo) invokeHttpClient(createRequest, CopyObjectResponseWithExceptionInfo.class);
        if (copyObjectResponseWithExceptionInfo.getETag() != null || copyObjectResponseWithExceptionInfo.getLastModified() != null || copyObjectResponseWithExceptionInfo.getMessage() == null) {
            return copyObjectResponseWithExceptionInfo;
        }
        BceServiceException bceServiceException = new BceServiceException(copyObjectResponseWithExceptionInfo.getMessage());
        bceServiceException.setErrorCode(copyObjectResponseWithExceptionInfo.getCode());
        bceServiceException.setRequestId(copyObjectResponseWithExceptionInfo.getRequestId());
        if (bceServiceException.getErrorCode() == "InternalError") {
            bceServiceException.setErrorType(ErrorType.Service);
        } else {
            bceServiceException.setErrorType(ErrorType.Client);
        }
        bceServiceException.setStatusCode(500);
        throw bceServiceException;
    }

    public BosObject getObject(GetObjectRequest getObjectRequest) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(getObjectRequest, HttpMethodName.GET);
        long[] range = getObjectRequest.getRange();
        if (range != null) {
            StringBuilder a2 = a.a("bytes=");
            a2.append(range[0]);
            a2.append("-");
            a2.append(range[1]);
            createRequest.addHeader(Headers.RANGE, a2.toString());
        }
        BosObject object = ((GetObjectResponse) invokeHttpClient(createRequest, GetObjectResponse.class)).getObject();
        object.setBucketName(getObjectRequest.getBucketName());
        object.setKey(getObjectRequest.getKey());
        return object;
    }

    public ListObjectsResponse listObjects(ListObjectsRequest listObjectsRequest) {
        CheckUtils.isNotNull(listObjectsRequest, "request should not be null.");
        InternalRequest createRequest = createRequest(listObjectsRequest, HttpMethodName.GET);
        if (listObjectsRequest.getPrefix() != null) {
            createRequest.addParameter("prefix", listObjectsRequest.getPrefix());
        }
        if (listObjectsRequest.getMarker() != null) {
            createRequest.addParameter("marker", listObjectsRequest.getMarker());
        }
        if (listObjectsRequest.getDelimiter() != null) {
            createRequest.addParameter("delimiter", listObjectsRequest.getDelimiter());
        }
        if (listObjectsRequest.getMaxKeys() >= 0) {
            createRequest.addParameter("maxKeys", String.valueOf(listObjectsRequest.getMaxKeys()));
        }
        ListObjectsResponse listObjectsResponse = (ListObjectsResponse) invokeHttpClient(createRequest, ListObjectsResponse.class);
        listObjectsResponse.setBucketName(listObjectsRequest.getBucketName());
        for (BosObjectSummary bucketName : listObjectsResponse.getContents()) {
            bucketName.setBucketName(listObjectsRequest.getBucketName());
        }
        return listObjectsResponse;
    }

    public PutObjectResponse putObject(String str, String str2, String str3) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), new ObjectMetadata());
        } catch (UnsupportedEncodingException e2) {
            StringBuilder a2 = a.a("Fail to get bytes:");
            a2.append(e2.getMessage());
            throw new BceClientException(a2.toString(), e2);
        }
    }

    /* JADX WARNING: type inference failed for: r3v17, types: [com.baidubce.util.MD5DigestCalculatingInputStream] */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidubce.services.bos.model.UploadPartResponse uploadPart(com.baidubce.services.bos.model.UploadPartRequest r6) {
        /*
            r5 = this;
            java.lang.String r0 = "request should not be null."
            com.baidubce.util.CheckUtils.isNotNull(r6, r0)
            long r0 = r6.getPartSize()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.String r1 = "partSize should not be null"
            com.baidubce.util.CheckUtils.isNotNull(r0, r1)
            int r0 = r6.getPartNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "partNumber should not be null"
            com.baidubce.util.CheckUtils.isNotNull(r0, r1)
            long r0 = r6.getPartSize()
            r2 = 5368709120(0x140000000, double:2.6524947387E-314)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x010a
            com.baidubce.http.HttpMethodName r0 = com.baidubce.http.HttpMethodName.PUT
            com.baidubce.internal.InternalRequest r0 = r5.createRequest(r6, r0)
            java.lang.String r1 = r6.getUploadId()
            java.lang.String r2 = "uploadId"
            r0.addParameter(r2, r1)
            int r1 = r6.getPartNumber()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "partNumber"
            r0.addParameter(r2, r1)
            long r1 = r6.getPartSize()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "Content-Length"
            r0.addHeader(r2, r1)
            java.io.InputStream r1 = r6.getInputStream()
            r2 = 0
            java.lang.String r3 = r6.getMd5Digest()
            if (r3 != 0) goto L_0x006e
            com.baidubce.util.MD5DigestCalculatingInputStream r3 = new com.baidubce.util.MD5DigestCalculatingInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0068 }
            r3.<init>(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0068 }
            r1 = r3
            r2 = r1
            goto L_0x006e
        L_0x0068:
            r3 = move-exception
            java.lang.String r4 = "Unable to verify data integrity."
            com.baidubce.util.BLog.error(r4, r3)
        L_0x006e:
            java.lang.Long r3 = r6.getCrc32()
            if (r3 == 0) goto L_0x0081
            java.lang.Long r3 = r6.getCrc32()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "x-bce-content-crc32"
            r0.addHeader(r4, r3)
        L_0x0081:
            long r3 = r6.getPartSize()     // Catch:{ all -> 0x0103 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0103 }
            com.baidubce.internal.RestartableInputStream r3 = r5.wrapRestartableInputStream(r1, r3)     // Catch:{ all -> 0x0103 }
            r0.setContent(r3)     // Catch:{ all -> 0x0103 }
            java.lang.Class<com.baidubce.services.bos.model.BosResponse> r3 = com.baidubce.services.bos.model.BosResponse.class
            com.baidubce.services.bos.callback.BosProgressCallback r4 = r6.getProgressCallback()     // Catch:{ all -> 0x0103 }
            com.baidubce.model.AbstractBceResponse r0 = r5.invokeHttpClient(r0, r3, r4)     // Catch:{ all -> 0x0103 }
            com.baidubce.services.bos.model.BosResponse r0 = (com.baidubce.services.bos.model.BosResponse) r0     // Catch:{ all -> 0x0103 }
            if (r2 == 0) goto L_0x00dd
            byte[] r2 = r2.getMd5Digest()     // Catch:{ all -> 0x0103 }
            com.baidubce.services.bos.model.BosResponseMetadata r3 = r0.getMetadata()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r3 = r3.getETag()     // Catch:{ Exception -> 0x00c1 }
            char[] r3 = r3.toCharArray()     // Catch:{ Exception -> 0x00c1 }
            byte[] r3 = com.baidubce.util.ConvertUtils.decodeHex(r3)     // Catch:{ Exception -> 0x00c1 }
            boolean r2 = java.util.Arrays.equals(r2, r3)     // Catch:{ all -> 0x0103 }
            if (r2 == 0) goto L_0x00b9
            goto L_0x00dd
        L_0x00b9:
            com.baidubce.BceClientException r6 = new com.baidubce.BceClientException     // Catch:{ all -> 0x0103 }
            java.lang.String r0 = "Unable to verify integrity of data upload.  Client calculated content hash didn't match hash calculated by Baidu BOS.  You may need to delete the data stored in Baidu BOS."
            r6.<init>(r0)     // Catch:{ all -> 0x0103 }
            throw r6     // Catch:{ all -> 0x0103 }
        L_0x00c1:
            r6 = move-exception
            com.baidubce.BceClientException r0 = new com.baidubce.BceClientException     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r2.<init>()     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = "Unable to verify integrity of data upload:"
            r2.append(r3)     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = r6.getMessage()     // Catch:{ all -> 0x0103 }
            r2.append(r3)     // Catch:{ all -> 0x0103 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0103 }
            r0.<init>(r2, r6)     // Catch:{ all -> 0x0103 }
            throw r0     // Catch:{ all -> 0x0103 }
        L_0x00dd:
            com.baidubce.services.bos.model.UploadPartResponse r2 = new com.baidubce.services.bos.model.UploadPartResponse     // Catch:{ all -> 0x0103 }
            r2.<init>()     // Catch:{ all -> 0x0103 }
            com.baidubce.services.bos.model.BosResponseMetadata r3 = r0.getMetadata()     // Catch:{ all -> 0x0103 }
            java.lang.String r3 = r3.getETag()     // Catch:{ all -> 0x0103 }
            r2.setETag(r3)     // Catch:{ all -> 0x0103 }
            com.baidubce.services.bos.model.BosResponseMetadata r0 = r0.getMetadata()     // Catch:{ all -> 0x0103 }
            java.lang.Long r0 = r0.getCrc32()     // Catch:{ all -> 0x0103 }
            r2.setCrc32(r0)     // Catch:{ all -> 0x0103 }
            int r6 = r6.getPartNumber()     // Catch:{ all -> 0x0103 }
            r2.setPartNumber(r6)     // Catch:{ all -> 0x0103 }
            r1.close()     // Catch:{ Exception -> 0x0102 }
        L_0x0102:
            return r2
        L_0x0103:
            r6 = move-exception
            if (r1 == 0) goto L_0x0109
            r1.close()     // Catch:{ Exception -> 0x0109 }
        L_0x0109:
            throw r6
        L_0x010a:
            com.baidubce.BceClientException r0 = new com.baidubce.BceClientException
            java.lang.String r1 = "PartNumber "
            java.lang.StringBuilder r1 = e.a.a.a.a.a(r1)
            int r6 = r6.getPartNumber()
            r1.append(r6)
            java.lang.String r6 = " : Part Size should not be more than 5GB."
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.BosClient.uploadPart(com.baidubce.services.bos.model.UploadPartRequest):com.baidubce.services.bos.model.UploadPartResponse");
    }

    private RestartableInputStream wrapRestartableInputStream(InputStream inputStream, Long l) {
        if (inputStream.markSupported()) {
            return new RestartableResettableInputStream(inputStream);
        }
        return new RestartableNonResettableInputStream(inputStream, l.longValue() > ((long) getStreamBufferSize()) ? getStreamBufferSize() : l.intValue());
    }

    public AppendObjectResponse appendObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return appendObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e2) {
            throw new BceClientException("Fail to get bytes.", e2);
        }
    }

    public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        String str;
        String str2;
        CheckUtils.isNotNull(generatePresignedUrlRequest, "The request parameter must be specified when generating a pre-signed URL");
        HttpMethodName valueOf = HttpMethodName.valueOf(generatePresignedUrlRequest.getMethod().toString());
        Boolean isCnameEnabled = ((BosClientConfiguration) this.config).isCnameEnabled();
        if (isCnameEnabled == Boolean.FALSE || (isCnameEnabled == null && !BosUtils.isCnameLikeHost(getEndpoint().getHost()))) {
            str = generatePresignedUrlRequest.getBucketName();
        } else {
            str = null;
        }
        InternalRequest internalRequest = new InternalRequest(valueOf, HttpUtils.appendUri(getEndpoint(), AbstractBceClient.URL_PREFIX, str, generatePresignedUrlRequest.getKey()));
        internalRequest.setCredentials(generatePresignedUrlRequest.getRequestCredentials());
        SignOptions signOptions = new SignOptions();
        signOptions.setExpirationInSeconds(generatePresignedUrlRequest.getExpiration());
        Iterator it = generatePresignedUrlRequest.getRequestHeaders().entrySet().iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                break;
            }
            Entry entry = (Entry) it.next();
            if (entry.getValue() == null) {
                internalRequest.addHeader((String) entry.getKey(), str2);
            } else {
                internalRequest.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : generatePresignedUrlRequest.getRequestParameters().entrySet()) {
            if (entry2.getValue() == null) {
                internalRequest.addParameter((String) entry2.getKey(), str2);
            } else {
                internalRequest.addParameter((String) entry2.getKey(), (String) entry2.getValue());
            }
        }
        if (generatePresignedUrlRequest.getContentType() != null) {
            internalRequest.addHeader("Content-Type", generatePresignedUrlRequest.getContentType());
        }
        if (generatePresignedUrlRequest.getContentMd5() != null) {
            internalRequest.addHeader(Headers.CONTENT_MD5, generatePresignedUrlRequest.getContentMd5());
        }
        addResponseHeaderParameters(internalRequest, generatePresignedUrlRequest.getResponseHeaders());
        new BceV1Signer().sign(internalRequest, this.config.getCredentials(), signOptions);
        return convertRequestToUrl(internalRequest);
    }

    public PutObjectResponse putObject(String str, String str2, String str3, ObjectMetadata objectMetadata) {
        try {
            return putObject(str, str2, str3.getBytes("UTF-8"), objectMetadata);
        } catch (UnsupportedEncodingException e2) {
            StringBuilder a2 = a.a("Fail to get bytes:");
            a2.append(e2.getMessage());
            throw new BceClientException(a2.toString(), e2);
        }
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr) {
        return appendObject(str, str2, bArr, new ObjectMetadata());
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr) {
        return putObject(str, str2, bArr, new ObjectMetadata());
    }

    public AppendObjectResponse appendObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        CheckUtils.isNotNull(objectMetadata, "metadata should not be null.");
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength((long) bArr.length);
        }
        return appendObject(new AppendObjectRequest(str, str2, (InputStream) RestartableInputStream.wrap(bArr), objectMetadata));
    }

    public PutObjectResponse putObject(String str, String str2, byte[] bArr, ObjectMetadata objectMetadata) {
        if (objectMetadata.getContentLength() == -1) {
            objectMetadata.setContentLength((long) bArr.length);
        }
        return putObject(new PutObjectRequest(str, str2, (InputStream) RestartableInputStream.wrap(bArr), objectMetadata));
    }

    public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File file) {
        CheckUtils.isNotNull(getObjectRequest, "request should not be null.");
        CheckUtils.isNotNull(file, "destinationFile should not be null.");
        BosObject object = getObject(getObjectRequest);
        downloadObjectToFile(object, file, getObjectRequest.getRange() == null);
        return object.getObjectMetadata();
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream) {
        return putObject(new PutObjectRequest(str, str2, inputStream));
    }

    public PutObjectResponse putObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        return putObject(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public PutObjectResponse putObject(PutObjectRequest putObjectRequest) {
        CheckUtils.isNotNull(putObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(putObjectRequest.getKey(), "object key should not be null or empty");
        BosResponse uploadObject = uploadObject(putObjectRequest, createRequest(putObjectRequest, HttpMethodName.PUT));
        PutObjectResponse putObjectResponse = new PutObjectResponse();
        putObjectResponse.setETag(uploadObject.getMetadata().getETag());
        putObjectResponse.setCrc32(uploadObject.getMetadata().getCrc32());
        return putObjectResponse;
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream) {
        return appendObject(new AppendObjectRequest(str, str2, inputStream));
    }

    public AppendObjectResponse appendObject(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        return appendObject(new AppendObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public AppendObjectResponse appendObject(AppendObjectRequest appendObjectRequest) {
        CheckUtils.isNotNull(appendObjectRequest, "request should not be null.");
        assertStringNotNullOrEmpty(appendObjectRequest.getKey(), "object key should not be null or empty");
        InternalRequest createRequest = createRequest(appendObjectRequest, HttpMethodName.POST);
        createRequest.addParameter("append", null);
        if (appendObjectRequest.getOffset() != null) {
            createRequest.addParameter(ExtraMetadataKey.kOffset, appendObjectRequest.getOffset().toString());
        }
        BosResponse uploadObject = uploadObject(appendObjectRequest, createRequest);
        AppendObjectResponse appendObjectResponse = new AppendObjectResponse();
        appendObjectResponse.setNextAppendOffset(uploadObject.getMetadata().getNextAppendOffset());
        appendObjectResponse.setContentMd5(uploadObject.getMetadata().getContentMd5());
        appendObjectResponse.setETag(uploadObject.getMetadata().getETag());
        appendObjectResponse.setCrc32(uploadObject.getMetadata().getCrc32());
        appendObjectResponse.setNextAppendOffset(uploadObject.getMetadata().getNextAppendOffset());
        return appendObjectResponse;
    }

    @Deprecated
    public PutObjectResponse putObject(PutObjectRequest putObjectRequest, BosProgressCallback bosProgressCallback) {
        putObjectRequest.setProgressCallback(bosProgressCallback);
        return putObject(putObjectRequest);
    }
}
