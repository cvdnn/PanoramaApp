package e.c.d.d.a;

import android.text.TextUtils;
import com.baidu.picapture.common.bos.beans.UploadTask;
import com.baidu.picapture.model.net.AccountDetail;
import com.baidu.picapture.model.net.BaseResponse;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import e.c.b.e.Utils;
import g.e;
import g.y;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: UploadManager */
public class s {

    /* renamed from: d reason: collision with root package name */
    public static volatile s f5985d;

    /* renamed from: e reason: collision with root package name */
    public static final ExecutorService f5986e = Executors.newSingleThreadExecutor();

    /* renamed from: a reason: collision with root package name */
    public Map<String, UploadTask> f5987a = new ConcurrentHashMap();

    /* renamed from: b reason: collision with root package name */
    public Map<String, Long> f5988b = new ConcurrentHashMap();

    /* renamed from: c reason: collision with root package name */
    public p f5989c = new a();

    /* compiled from: UploadManager */
    public class a implements p {
        public a() {
        }

        public void a(String str) {
        }

        public void a(String str, float f2) {
        }

        public void a(String str, int i2) {
            s.f5986e.execute(new j(this, str));
        }

        public /* synthetic */ void b(String str) {
            s.a(s.this, str);
        }

        public /* synthetic */ void c(String str) {
            s.a(s.this, str);
        }

        public void a(String str, String str2) {
            s.f5986e.execute(new Utils(this, str));
        }
    }

    /* compiled from: UploadManager */
    public class b extends e.c.d.l.b.a<BaseResponse<AccountDetail>> {

        /* renamed from: a reason: collision with root package name */
        public final /* synthetic */ UploadTask f5991a;

        public b(UploadTask uploadTask) {
            this.f5991a = uploadTask;
        }

        public void a(e eVar, Object obj, int i2) {
            s.f5986e.execute(new k(this, i2, (BaseResponse) obj, this.f5991a));
        }

        public /* synthetic */ void a(int i2, BaseResponse baseResponse, UploadTask uploadTask) {
            if (i2 == 0 && baseResponse != null && baseResponse.getError_code() == 0 && baseResponse.getData() != null && ((AccountDetail) baseResponse.getData()).getQuota() != null && ((AccountDetail) baseResponse.getData()).getPrivileges() != null && ((AccountDetail) baseResponse.getData()).getPrivileges().getGlobal() != null) {
                long maxStorageGB = (((((long) ((AccountDetail) baseResponse.getData()).getPrivileges().getGlobal().getMaxStorageGB()) * AppSupportContentFlag.MMAPP_SUPPORT_XLS) * AppSupportContentFlag.MMAPP_SUPPORT_XLS) * AppSupportContentFlag.MMAPP_SUPPORT_XLS) - ((long) ((AccountDetail) baseResponse.getData()).getQuota().getUsedStorageBytes());
                long e2 = Utils.e(uploadTask.getFilePath());
                long j2 = 0;
                for (Entry value : s.this.f5988b.entrySet()) {
                    j2 += ((Long) value.getValue()).longValue();
                }
                if (maxStorageGB < j2 + e2) {
                    uploadTask.getUploadListener().a(uploadTask.getUploadId(), 5);
                    s.a(s.this, uploadTask.getUploadId());
                    return;
                }
                s.this.f5988b.put(uploadTask.getUploadId(), Long.valueOf(e2));
                s sVar = s.this;
                if (sVar != null) {
                    uploadTask.getFilePath();
                    e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
                    t tVar = new t(sVar, uploadTask);
                    if (a2 != null) {
                        y create = y.create(e.c.d.l.b.b.f6372b, "{\"type\": \"picapture\",\"privileges\": [\"WRITE\"],\"bucket\": \"repos3d/*\"}");
                        g.x.a aVar = new g.x.a();
                        aVar.a("http://vrstudio.baidu.com/common/api/v1/bce/bos/token/product/acquire");
                        aVar.a(Constants.HTTP_POST, create);
                        e a3 = a2.f6374a.a(aVar.a());
                        a3.a(tVar);
                        uploadTask.setStatus(3);
                        uploadTask.setBosKeyCall(a3);
                        return;
                    }
                    throw null;
                }
                throw null;
            } else if (i2 == 2) {
                uploadTask.getUploadListener().a(uploadTask.getUploadId(), 3);
                s.a(s.this, uploadTask.getUploadId());
            } else {
                uploadTask.getUploadListener().a(uploadTask.getUploadId(), 6);
                s.a(s.this, uploadTask.getUploadId());
            }
        }
    }

    public static s a() {
        if (f5985d == null) {
            synchronized (s.class) {
                if (f5985d == null) {
                    f5985d = new s();
                }
            }
        }
        return f5985d;
    }

    public String a(UploadTask uploadTask) {
        String str;
        uploadTask.getFilePath();
        String uploadId = uploadTask.getUploadId();
        if (!TextUtils.isEmpty(uploadId) && this.f5987a.containsKey(uploadId)) {
            uploadTask.getFilePath();
            return uploadTask.getUploadId();
        }
        if (TextUtils.isEmpty(uploadTask.getUploadId())) {
            str = Utils.k();
        } else {
            str = uploadTask.getUploadId();
        }
        e.c.d.l.b.b a2 = e.c.d.l.b.b.a();
        b bVar = new b(uploadTask);
        if (a2 != null) {
            g.x.a aVar = new g.x.a();
            aVar.a("https://vrstudio.baidu.com/vr/mkt/repos3d/api/v4/account/edition/detail");
            aVar.b();
            e a3 = a2.f6374a.a(aVar.a());
            a3.a(bVar);
            uploadTask.setUploadId(str);
            uploadTask.setStatus(2);
            uploadTask.setCheckStorageCall(a3);
            this.f5987a.put(str, uploadTask);
            return str;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        if (android.text.TextUtils.isEmpty(((e.c.d.f.d.g) r1.get(0)).f6090b) == false) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(e.c.d.d.a.r r11, com.baidu.picapture.common.bos.beans.UploadTask r12) {
        /*
            java.lang.String r12 = r12.getUploadId()
            r0 = 0
            if (r11 == 0) goto L_0x0227
            e.c.d.f.b.c r1 = e.c.d.f.b.c.b()
            com.baidu.picapture.db.tables.UploadInfoDao r1 = r1.a()
            if (r1 == 0) goto L_0x0226
            i.b.b.j.f r2 = new i.b.b.j.f
            r2.<init>(r1)
            i.b.b.f r1 = com.baidu.picapture.db.tables.UploadInfoDao.Properties.UploadId
            i.b.b.j.h r1 = r1.a(r12)
            r3 = 0
            i.b.b.j.h[] r4 = new i.b.b.j.h[r3]
            r2.a(r1, r4)
            java.util.List r1 = r2.a()
            if (r1 == 0) goto L_0x0045
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0045
            java.lang.Object r2 = r1.get(r3)
            e.c.d.f.d.g r2 = (e.c.d.f.d.g) r2
            r11.f5983d = r2
            java.lang.Object r1 = r1.get(r3)
            e.c.d.f.d.g r1 = (e.c.d.f.d.g) r1
            java.lang.String r1 = r1.f6090b
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0045
            goto L_0x008f
        L_0x0045:
            com.baidubce.services.bos.model.InitiateMultipartUploadRequest r1 = new com.baidubce.services.bos.model.InitiateMultipartUploadRequest
            e.c.d.d.a.o r2 = r11.f5982c
            java.lang.String r3 = r2.f5972b
            java.lang.String r2 = r2.f5973c
            r1.<init>(r3, r2)
            com.baidubce.services.bos.BosClient r2 = r11.f5980a     // Catch:{ BceServiceException -> 0x008b }
            com.baidubce.services.bos.model.InitiateMultipartUploadResponse r1 = r2.initiateMultipartUpload(r1)     // Catch:{ BceServiceException -> 0x008b }
            java.lang.String r1 = r1.getUploadId()     // Catch:{ BceServiceException -> 0x008b }
            e.c.d.f.d.g r2 = r11.f5983d     // Catch:{ BceServiceException -> 0x008b }
            r2.f6089a = r12     // Catch:{ BceServiceException -> 0x008b }
            e.c.d.f.d.g r12 = r11.f5983d     // Catch:{ BceServiceException -> 0x008b }
            r12.f6090b = r1     // Catch:{ BceServiceException -> 0x008b }
            e.c.d.f.d.g r12 = r11.f5983d     // Catch:{ BceServiceException -> 0x008b }
            e.c.d.d.a.o r1 = r11.f5982c     // Catch:{ BceServiceException -> 0x008b }
            java.lang.String r1 = r1.f5974d     // Catch:{ BceServiceException -> 0x008b }
            r12.f6091c = r1     // Catch:{ BceServiceException -> 0x008b }
            e.c.d.f.d.g r12 = r11.f5983d     // Catch:{ BceServiceException -> 0x008b }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ BceServiceException -> 0x008b }
            r1.<init>()     // Catch:{ BceServiceException -> 0x008b }
            r12.f6093e = r1     // Catch:{ BceServiceException -> 0x008b }
            e.c.d.f.b.c r12 = e.c.d.f.b.c.b()     // Catch:{ BceServiceException -> 0x008b }
            e.c.d.f.d.g r1 = r11.f5983d     // Catch:{ BceServiceException -> 0x008b }
            if (r12 == 0) goto L_0x008a
            java.util.Date r0 = new java.util.Date     // Catch:{ BceServiceException -> 0x008b }
            r0.<init>()     // Catch:{ BceServiceException -> 0x008b }
            r1.f6095g = r0     // Catch:{ BceServiceException -> 0x008b }
            com.baidu.picapture.db.tables.UploadInfoDao r12 = r12.a()     // Catch:{ BceServiceException -> 0x008b }
            r12.c(r1)     // Catch:{ BceServiceException -> 0x008b }
            goto L_0x008f
        L_0x008a:
            throw r0     // Catch:{ BceServiceException -> 0x008b }
        L_0x008b:
            r12 = move-exception
            r12.getMessage()
        L_0x008f:
            e.c.d.f.d.g r12 = r11.f5983d
            java.lang.String r12 = r12.f6089a
            boolean r12 = r11.f5984e
            if (r12 == 0) goto L_0x009c
            r11.a()
            goto L_0x0225
        L_0x009c:
            r12 = 1
            r11.a(r12)
            e.c.d.d.f.b<e.c.d.d.a.p> r0 = r11.f5981b
            e.c.d.d.a.e r1 = new e.c.d.d.a.e
            r1.<init>(r11)
            r0.a(r1)
            java.io.File r0 = new java.io.File
            e.c.d.f.d.g r1 = r11.f5983d
            java.lang.String r1 = r1.f6091c
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x00cd
            e.c.d.f.d.g r12 = r11.f5983d
            java.lang.String r12 = r12.f6091c
            r12 = 2
            r11.a(r12)
            e.c.d.d.f.b<e.c.d.d.a.p> r12 = r11.f5981b
            e.c.d.d.a.f r0 = new e.c.d.d.a.f
            r0.<init>(r11)
            r12.a(r0)
            goto L_0x0225
        L_0x00cd:
            r1 = 998(0x3e6, float:1.398E-42)
            e.c.d.f.d.g r2 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r2 = r2.f6089a     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r2 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r2 = r2.f6090b     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r2 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r2 = r2.f6091c     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r0.length()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            long r2 = r0.length()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r4 = 5242880(0x500000, double:2.590327E-317)
            long r2 = r2 / r4
            int r2 = (int) r2     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            long r6 = r0.length()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            long r6 = r6 % r4
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00f4
            int r2 = r2 + 1
        L_0x00f4:
            e.c.d.f.d.g r3 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r3 = r3.f6089a     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r3 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.util.List<com.baidubce.services.bos.model.PartETag> r3 = r3.f6093e     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            int r3 = r3.size()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
        L_0x0100:
            if (r3 >= r2) goto L_0x01a2
            e.c.d.f.d.g r6 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r6 = r6.f6089a     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            boolean r6 = r11.f5984e     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            if (r6 == 0) goto L_0x010f
            r11.a()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            goto L_0x0225
        L_0x010f:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r6.<init>(r0)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            long r7 = (long) r3     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            long r7 = r7 * r4
            r6.skip(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            long r9 = r0.length()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            long r9 = r9 - r7
            long r7 = java.lang.Math.min(r4, r9)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            com.baidubce.services.bos.model.UploadPartRequest r9 = new com.baidubce.services.bos.model.UploadPartRequest     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r9.<init>()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.d.a.o r10 = r11.f5982c     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r10 = r10.f5972b     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r9.setBucketName(r10)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.d.a.o r10 = r11.f5982c     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r10 = r10.f5973c     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r9.setKey(r10)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r10 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r10 = r10.f6090b     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r9.setUploadId(r10)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r9.setInputStream(r6)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r9.setPartSize(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            int r3 = r3 + 1
            r9.setPartNumber(r3)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.d.a.q r7 = new e.c.d.d.a.q     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r7.<init>(r11, r0)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r9.setProgressCallback(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            com.baidubce.services.bos.BosClient r7 = r11.f5980a     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            com.baidubce.services.bos.model.UploadPartResponse r7 = r7.uploadPart(r9)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r8 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.util.List<com.baidubce.services.bos.model.PartETag> r8 = r8.f6093e     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            com.baidubce.services.bos.model.PartETag r9 = r7.getPartETag()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r8.add(r9)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.b.c r8 = e.c.d.f.b.c.b()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r9 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            com.baidu.picapture.db.tables.UploadInfoDao r8 = r8.a()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r8.d(r9)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r6.close()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r6.<init>()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r8 = "[BosUploader][upload] PartETag:"
            r6.append(r8)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            com.baidubce.services.bos.model.PartETag r7 = r7.getPartETag()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r6.append(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r7 = ";size:"
            r6.append(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r7 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.util.List<com.baidubce.services.bos.model.PartETag> r7 = r7.f6093e     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            int r7 = r7.size()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r6.append(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r7 = "; uploadId:"
            r6.append(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            e.c.d.f.d.g r7 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r7 = r7.f6089a     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r6.append(r7)     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            r6.toString()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            goto L_0x0100
        L_0x01a2:
            e.c.d.f.d.g r0 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            java.lang.String r0 = r0.f6089a     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            boolean r0 = r11.f5984e     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            if (r0 == 0) goto L_0x01af
            r11.a()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            goto L_0x0225
        L_0x01af:
            e.c.d.f.d.g r0 = r11.f5983d     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            int r0 = r0.f6094f     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            if (r0 != r12) goto L_0x0225
            r11.b()     // Catch:{ BceServiceException -> 0x01d7, BceClientException -> 0x01bb, IOException -> 0x01b9 }
            goto L_0x0225
        L_0x01b9:
            r12 = move-exception
            goto L_0x01bc
        L_0x01bb:
            r12 = move-exception
        L_0x01bc:
            java.lang.Throwable r0 = r12.getCause()
            if (r0 == 0) goto L_0x01c9
            java.lang.Throwable r12 = r12.getCause()
            r12.getMessage()
        L_0x01c9:
            r11.a(r1)
            e.c.d.d.f.b<e.c.d.d.a.p> r12 = r11.f5981b
            e.c.d.d.a.h r0 = new e.c.d.d.a.h
            r0.<init>(r11)
            r12.a(r0)
            goto L_0x0225
        L_0x01d7:
            r12 = move-exception
            java.lang.String r0 = "[BosUploader][upload] Error ErrorCode: "
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            java.lang.String r2 = r12.getErrorCode()
            r0.append(r2)
            java.lang.String r2 = "\n[BosUploader][upload] Error RequestId: "
            r0.append(r2)
            java.lang.String r2 = r12.getRequestId()
            r0.append(r2)
            java.lang.String r2 = "\n[BosUploader][upload] Error StatusCode: "
            r0.append(r2)
            java.lang.String r2 = r12.getRequestId()
            r0.append(r2)
            java.lang.String r2 = "\n[BosUploader][upload] Error Message: "
            r0.append(r2)
            java.lang.String r2 = r12.getMessage()
            r0.append(r2)
            java.lang.String r2 = "\n[BosUploader][upload] Error ErrorType: "
            r0.append(r2)
            com.baidubce.BceServiceException$ErrorType r12 = r12.getErrorType()
            r0.append(r12)
            r0.toString()
            r11.a(r1)
            e.c.d.d.f.b<e.c.d.d.a.p> r12 = r11.f5981b
            e.c.d.d.a.d r0 = new e.c.d.d.a.d
            r0.<init>(r11)
            r12.a(r0)
        L_0x0225:
            return
        L_0x0226:
            throw r0
        L_0x0227:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.d.d.a.s.a(e.c.d.d.a.r, com.baidu.picapture.common.bos.beans.UploadTask):void");
    }

    public /* synthetic */ void a(String str) {
        UploadTask uploadTask = (UploadTask) this.f5987a.get(str);
        if (uploadTask != null) {
            if (((UploadTask) this.f5987a.remove(str)) != null) {
                this.f5988b.remove(str);
            }
            if (uploadTask.getStatus() == 2) {
                if (uploadTask.getCheckStorageCall() != null) {
                    uploadTask.getCheckStorageCall().cancel();
                }
            } else if (uploadTask.getStatus() == 3) {
                if (uploadTask.getBosKeyCall() != null) {
                    uploadTask.getBosKeyCall().cancel();
                }
            } else if (uploadTask.getBosUploader() != null) {
                uploadTask.getBosUploader().f5984e = true;
            }
        }
    }

    public static /* synthetic */ void a(s sVar, String str) {
        if (((UploadTask) sVar.f5987a.remove(str)) != null) {
            sVar.f5988b.remove(str);
        }
    }
}
