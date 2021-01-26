package com.arashivision.insbase.arlog;

import android.util.Log;
import com.baidubce.http.Headers;
import com.facebook.stetho.websocket.WebSocketHandler;
import com.tencent.connect.common.Constants;
import e.a.a.a.a;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class MultipartUtility {
    public static final String CTRLF = "\r\n";
    public static final String TWO_HYPHENS = "--";
    public final String mBoundary = UUID.randomUUID().toString();
    public ArrayList<Part> mParts = new ArrayList<>();
    public final String mRequestUrl;

    public class FilePart implements Part {
        public byte[] end;
        public String fieldName;
        public long fieldSize;
        public File file;
        public long fileLength;
        public byte[] head;
        public final /* synthetic */ MultipartUtility this$0;

        public FilePart(MultipartUtility multipartUtility, String str, String str2) {
            String str3 = "UTF-8";
            this.this$0 = multipartUtility;
            this.fieldName = str;
            File file2 = new File(str2);
            this.file = file2;
            if (file2.isFile()) {
                this.fileLength = this.file.length();
                String name = this.file.getName();
                StringBuilder a2 = a.a(MultipartUtility.TWO_HYPHENS);
                a2.append(multipartUtility.mBoundary);
                String str4 = MultipartUtility.CTRLF;
                a2.append(str4);
                a2.append("Content-Disposition: form-data; name=\"");
                a2.append(str);
                a2.append("\";filename=\"");
                a.a(a2, name, "\"", str4, str4);
                try {
                    this.head = a2.toString().getBytes(str3);
                    byte[] bytes = str4.getBytes(str3);
                    this.end = bytes;
                    this.fieldSize = ((long) (this.head.length + bytes.length)) + this.fileLength;
                } catch (UnsupportedEncodingException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                throw new RuntimeException(a.a("file: ", str2, " is not a file"));
            }
        }

        public long getSize() {
            return this.fieldSize;
        }

        public PartType getType() {
            return PartType.FILE;
        }
    }

    public interface Part {
        long getSize();

        PartType getType();
    }

    public enum PartType {
        STRING,
        FILE
    }

    public class StringPart implements Part {
        public byte[] content;
        public String name;
        public String value;

        public StringPart(String str, String str2) {
            this.name = str;
            this.value = str2;
            StringBuilder a2 = a.a(MultipartUtility.TWO_HYPHENS);
            a2.append(MultipartUtility.this.mBoundary);
            String str3 = MultipartUtility.CTRLF;
            a2.append(str3);
            a2.append("Content-Disposition: form-data; name=\"");
            a2.append(str);
            a2.append("\"");
            a.a(a2, str3, "Content-Type: text/plain; charset=UTF-8\r\n", str3, str2);
            a2.append(str3);
            try {
                this.content = a2.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException(e2);
            }
        }

        public long getSize() {
            return (long) this.content.length;
        }

        public PartType getType() {
            return PartType.STRING;
        }
    }

    public MultipartUtility(String str) {
        this.mRequestUrl = str;
    }

    public MultipartUtility addFilePart(String str, String str2) {
        this.mParts.add(new FilePart(this, str, str2));
        return this;
    }

    public MultipartUtility addFormField(String str, String str2) {
        this.mParts.add(new StringPart(str, str2));
        return this;
    }

    public String commit() throws IOException {
        Iterator it = this.mParts.iterator();
        long j2 = 0;
        while (it.hasNext()) {
            j2 += ((Part) it.next()).getSize();
        }
        String str = TWO_HYPHENS;
        StringBuilder a2 = a.a(str);
        a2.append(this.mBoundary);
        a2.append(str);
        a2.append(CTRLF);
        byte[] bytes = a2.toString().getBytes("UTF-8");
        long length = j2 + ((long) bytes.length);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.mRequestUrl).openConnection();
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setFixedLengthStreamingMode((int) length);
        httpURLConnection.setRequestMethod(Constants.HTTP_POST);
        httpURLConnection.setRequestProperty(WebSocketHandler.HEADER_CONNECTION, "Keep-Alive");
        httpURLConnection.setRequestProperty(Headers.CACHE_CONTROL, "no-cache");
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data;boundary=");
        sb.append(this.mBoundary);
        httpURLConnection.setRequestProperty("Content-Type", sb.toString());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        Iterator it2 = this.mParts.iterator();
        while (it2.hasNext()) {
            Part part = (Part) it2.next();
            if (part.getType() == PartType.STRING) {
                dataOutputStream.write(((StringPart) part).content);
            } else if (part.getType() == PartType.FILE) {
                FilePart filePart = (FilePart) part;
                dataOutputStream.write(filePart.head);
                FileInputStream fileInputStream = new FileInputStream(filePart.file);
                byte[] bArr = new byte[16384];
                long j3 = 0;
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    j3 += (long) read;
                    dataOutputStream.write(bArr, 0, read);
                }
                if (j3 == filePart.fileLength) {
                    dataOutputStream.write(filePart.end);
                } else {
                    StringBuilder a3 = a.a("upload file's size changed: ");
                    a3.append(filePart.fileLength);
                    a3.append("->");
                    a3.append(j3);
                    throw new RuntimeException(a3.toString());
                }
            } else {
                continue;
            }
        }
        dataOutputStream.write(bytes);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpURLConnection.getResponseCode();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("response code: ");
        sb2.append(responseCode);
        Log.i("MultipartUtility", sb2.toString());
        if (responseCode < 400) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(httpURLConnection.getInputStream())));
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb3.append(readLine);
                    sb3.append("\n");
                } else {
                    bufferedReader.close();
                    String sb4 = sb3.toString();
                    httpURLConnection.disconnect();
                    return sb4;
                }
            }
        } else {
            throw new IOException(a.a("Server response: ", responseCode));
        }
    }
}
