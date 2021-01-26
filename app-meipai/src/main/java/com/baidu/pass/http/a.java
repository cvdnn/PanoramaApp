package com.baidu.pass.http;

import android.content.Context;
import android.text.TextUtils;
import com.arashivision.insbase.arlog.MultipartUtility;
import com.tencent.connect.common.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

/* compiled from: PassHttpClientRequest */
public class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    public static final String f1935a = "PassHttpClientRequest";

    /* renamed from: b reason: collision with root package name */
    public static final String f1936b = "Set-Cookie";

    /* renamed from: c reason: collision with root package name */
    public static final char[] f1937c = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: f reason: collision with root package name */
    public static final String f1938f = "User-Agent";

    /* renamed from: g reason: collision with root package name */
    public static final int f1939g = 15000;

    /* renamed from: d reason: collision with root package name */
    public String f1940d = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";

    /* renamed from: e reason: collision with root package name */
    public boolean f1941e = false;

    /* renamed from: h reason: collision with root package name */
    public Context f1942h;

    /* renamed from: i reason: collision with root package name */
    public HttpResponseHandler f1943i;

    /* renamed from: j reason: collision with root package name */
    public PassHttpParamDTO f1944j;
    public Method k;
    public HttpURLConnection l;
    public Thread m;
    public volatile boolean n = false;
    public volatile boolean o = false;

    /* renamed from: com.baidu.pass.http.a$1 reason: invalid class name */
    /* compiled from: PassHttpClientRequest */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a reason: collision with root package name */
        public static final /* synthetic */ int[] f1945a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.baidu.pass.http.Method[] r0 = com.baidu.pass.http.Method.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1945a = r0
                r1 = 1
                com.baidu.pass.http.Method r2 = com.baidu.pass.http.Method.GET     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = f1945a     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.baidu.pass.http.Method r2 = com.baidu.pass.http.Method.POST     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.http.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(Method method, Context context, PassHttpParamDTO passHttpParamDTO, HttpResponseHandler httpResponseHandler) {
        this.k = method;
        this.f1942h = context;
        this.f1944j = passHttpParamDTO;
        this.f1943i = httpResponseHandler;
        d();
    }

    private void c() throws IOException, InterruptedException, IllegalArgumentException {
        byte[] bArr;
        int i2 = AnonymousClass1.f1945a[this.k.ordinal()];
        if (i2 == 1) {
            String a2 = a(this.f1944j.paramsMap);
            if (!TextUtils.isEmpty(a2)) {
                PassHttpParamDTO passHttpParamDTO = this.f1944j;
                StringBuilder sb = new StringBuilder();
                sb.append(this.f1944j.url);
                sb.append("?");
                sb.append(a2);
                passHttpParamDTO.url = sb.toString();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1944j.url).openConnection();
            this.l = httpURLConnection;
            httpURLConnection.setRequestMethod(Constants.HTTP_GET);
            this.l.setUseCaches(false);
            bArr = null;
        } else if (i2 == 2) {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.f1944j.url).openConnection();
            this.l = httpURLConnection2;
            httpURLConnection2.setRequestMethod(Constants.HTTP_POST);
            this.l.setDoOutput(true);
            bArr = a(this.l, this.f1944j);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.k);
            sb2.append(" method not support");
            throw new IllegalArgumentException(sb2.toString());
        }
        a(this.l, this.f1944j.connectTimeout);
        a(this.l, this.f1944j.userAgent);
        a(this.l, this.f1944j.headers);
        b.a(this.f1942h, this.l, this.f1944j);
        if (bArr != null) {
            OutputStream outputStream = this.l.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
        }
        InputStream inputStream = this.l.getInputStream();
        int responseCode = this.l.getResponseCode();
        byte[] a3 = a(inputStream);
        if (a3 != null) {
            StringBuilder a4 = e.a.a.a.a.a("responseBody:");
            a4.append(new String(a3));
            c.a(f1935a, a4.toString());
        }
        HashMap a5 = a(this.l);
        b.b(this.f1942h, this.l, this.f1944j);
        HttpResponseHandler httpResponseHandler = this.f1943i;
        if (httpResponseHandler != null) {
            httpResponseHandler.c(responseCode, a5, a3);
        }
    }

    private void d() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = f1937c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f1940d = sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|26|23|8|7) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000a */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000a A[LOOP:0: B:7:0x000a->B:23:0x000a, LOOP_START, SYNTHETIC, Splitter:B:7:0x000a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a() {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            r3.o = r0     // Catch:{ all -> 0x0028 }
            java.lang.Thread r0 = r3.m     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x000a
            monitor-exit(r3)
            return
        L_0x000a:
            java.lang.Thread r0 = r3.m     // Catch:{ all -> 0x0028 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0023
            boolean r0 = r3.n     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0023
            java.lang.Thread r0 = r3.m     // Catch:{ all -> 0x0028 }
            r0.interrupt()     // Catch:{ all -> 0x0028 }
            java.lang.Thread r0 = r3.m     // Catch:{ InterruptedException -> 0x000a }
            r1 = 10
            r0.join(r1)     // Catch:{ InterruptedException -> 0x000a }
            goto L_0x000a
        L_0x0023:
            r0 = 0
            r3.m = r0     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return
        L_0x0028:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.http.a.a():void");
    }

    public HttpURLConnection b() {
        return this.l;
    }

    public void run() {
        this.m = Thread.currentThread();
        HttpResponseHandler httpResponseHandler = this.f1943i;
        if (httpResponseHandler != null) {
            httpResponseHandler.a();
        }
        try {
            c();
        } catch (Exception e2) {
            this.n = true;
            if (!this.o) {
                HttpResponseHandler httpResponseHandler2 = this.f1943i;
                if (httpResponseHandler2 != null) {
                    httpResponseHandler2.a(e2, e2.getMessage());
                }
            } else {
                return;
            }
        }
        HttpResponseHandler httpResponseHandler3 = this.f1943i;
        if (httpResponseHandler3 != null) {
            httpResponseHandler3.b();
        }
    }

    private byte[] a(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, read);
            } catch (IOException e2) {
                e2.printStackTrace();
                try {
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return null;
            } finally {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        }
        bufferedOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        try {
            bufferedInputStream.close();
            return byteArray;
        } catch (IOException e8) {
            e8.printStackTrace();
            return byteArray;
        }
    }

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap<String, String> hashMap = new HashMap<>();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i2 = 0; i2 < size; i2++) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
            String headerField = httpURLConnection.getHeaderField(i2);
            if ("Set-Cookie".equals(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                String str = "=";
                if (headerField.contains(str)) {
                    headerFieldKey = headerField.substring(0, headerField.indexOf(str));
                }
            }
            hashMap.put(headerFieldKey, headerField);
        }
        return hashMap;
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = f1937c;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        StringBuilder a2 = e.a.a.a.a.a("\r\n--");
        a2.append(this.f1940d);
        String str = MultipartUtility.CTRLF;
        a2.append(str);
        byte[] bytes = a2.toString().getBytes();
        if (!this.f1941e) {
            this.f1941e = true;
            StringBuilder a3 = e.a.a.a.a.a(MultipartUtility.TWO_HYPHENS);
            a3.append(this.f1940d);
            a3.append(str);
            byteArrayOutputStream.write(a3.toString().getBytes());
            return;
        }
        byteArrayOutputStream.write(bytes);
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2) throws IOException {
        a(byteArrayOutputStream);
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition: form-data; name=\"");
        sb.append(str);
        sb.append("\"\r\n\r\n");
        byteArrayOutputStream.write(sb.toString().getBytes());
        byteArrayOutputStream.write(str2.getBytes());
    }

    private ByteArrayOutputStream a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2, InputStream inputStream, String str3) throws IOException {
        try {
            a(byteArrayOutputStream);
            StringBuilder sb = new StringBuilder();
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(str);
            sb.append("\"; filename=\"");
            sb.append(str2);
            sb.append("\"\r\n");
            byteArrayOutputStream.write(sb.toString().getBytes());
            if (str3 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Content-Type: ");
                sb2.append(str3);
                sb2.append("\r\n\r\n");
                byteArrayOutputStream.write(sb2.toString().getBytes());
            } else {
                byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return byteArrayOutputStream;
        } catch (IOException e3) {
            throw e3;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    private String a(HttpHashMap httpHashMap) {
        String str = "UTF-8";
        StringBuilder sb = new StringBuilder();
        if (!(httpHashMap == null || httpHashMap.getMap() == null)) {
            for (Entry entry : httpHashMap.getMap().entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    try {
                        sb.append(URLEncoder.encode((String) entry.getKey(), str));
                        sb.append("=");
                        sb.append(URLEncoder.encode((String) entry.getValue(), str));
                        sb.append("&");
                    } catch (UnsupportedEncodingException e2) {
                        c.a(e2.getMessage());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(sb)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i2) {
        if (i2 != 0) {
            httpURLConnection.setConnectTimeout(i2);
            httpURLConnection.setReadTimeout(i2);
            return;
        }
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpHashMap httpHashMap = passHttpParamDTO.paramsMap;
        String str = "UTF-8";
        if (httpHashMap instanceof MultipartHashMap) {
            StringBuilder a2 = e.a.a.a.a.a("multipart/form-data;boundary=");
            a2.append(this.f1940d);
            httpURLConnection.setRequestProperty("Content-Type", a2.toString());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            HttpHashMap httpHashMap2 = passHttpParamDTO.paramsMap;
            if (httpHashMap2 != null) {
                for (Entry entry : httpHashMap2.getMap().entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        a(byteArrayOutputStream, URLEncoder.encode((String) entry.getKey(), str), URLEncoder.encode((String) entry.getValue(), str));
                    }
                }
            }
            com.baidu.pass.http.MultipartHashMap.a aVar = ((MultipartHashMap) passHttpParamDTO.paramsMap).fileWrapper;
            a(byteArrayOutputStream, aVar.f1926a, aVar.f1927b, aVar.f1929d, aVar.f1928c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (httpHashMap instanceof HttpHashMap) {
            return a(httpHashMap).getBytes(str);
        } else {
            return null;
        }
    }
}
