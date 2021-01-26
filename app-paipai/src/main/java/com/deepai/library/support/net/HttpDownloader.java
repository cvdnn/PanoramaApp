package com.deepai.library.support.net;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpDownloader {
    private URL url = null;

    public class FileUtil {
        public FileUtil() {
        }

        public File createFile(String fileName) throws IOException {
            File file = new File(fileName);
            file.createNewFile();
            return file;
        }

        public File createDir(String fileName) throws IOException {
            File dir = new File(fileName);
            dir.mkdir();
            return dir;
        }

        public boolean isExist(String fileName) {
            return new File(fileName).exists();
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0035 A[SYNTHETIC, Splitter:B:14:0x0035] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.File writeToSDPATHFromInput(java.lang.String r8, java.lang.String r9, java.io.InputStream r10) {
            /*
                r7 = this;
                r2 = 0
                r3 = 0
                r7.createDir(r8)     // Catch:{ Exception -> 0x005a }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005a }
                r5.<init>()     // Catch:{ Exception -> 0x005a }
                java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ Exception -> 0x005a }
                java.lang.StringBuilder r5 = r5.append(r9)     // Catch:{ Exception -> 0x005a }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x005a }
                java.io.File r2 = r7.createFile(r5)     // Catch:{ Exception -> 0x005a }
                java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005a }
                r4.<init>(r2)     // Catch:{ Exception -> 0x005a }
                r5 = 1024(0x400, float:1.435E-42)
                byte[] r0 = new byte[r5]     // Catch:{ Exception -> 0x002e, all -> 0x0057 }
            L_0x0023:
                int r5 = r10.read(r0)     // Catch:{ Exception -> 0x002e, all -> 0x0057 }
                r6 = -1
                if (r5 == r6) goto L_0x0039
                r4.write(r0)     // Catch:{ Exception -> 0x002e, all -> 0x0057 }
                goto L_0x0023
            L_0x002e:
                r1 = move-exception
                r3 = r4
            L_0x0030:
                r1.printStackTrace()     // Catch:{ all -> 0x004b }
                if (r3 == 0) goto L_0x0038
                r3.close()     // Catch:{ IOException -> 0x0046 }
            L_0x0038:
                return r2
            L_0x0039:
                if (r4 == 0) goto L_0x003e
                r4.close()     // Catch:{ IOException -> 0x0040 }
            L_0x003e:
                r3 = r4
                goto L_0x0038
            L_0x0040:
                r1 = move-exception
                r1.printStackTrace()
                r3 = r4
                goto L_0x0038
            L_0x0046:
                r1 = move-exception
                r1.printStackTrace()
                goto L_0x0038
            L_0x004b:
                r5 = move-exception
            L_0x004c:
                if (r3 == 0) goto L_0x0051
                r3.close()     // Catch:{ IOException -> 0x0052 }
            L_0x0051:
                throw r5
            L_0x0052:
                r1 = move-exception
                r1.printStackTrace()
                goto L_0x0051
            L_0x0057:
                r5 = move-exception
                r3 = r4
                goto L_0x004c
            L_0x005a:
                r1 = move-exception
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deepai.library.support.net.HttpDownloader.FileUtil.writeToSDPATHFromInput(java.lang.String, java.lang.String, java.io.InputStream):java.io.File");
        }
    }

    public String download(String urlStr) {
        StringBuffer stringbuffer = new StringBuffer();
        try {
            this.url = new URL(urlStr);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(((HttpURLConnection) this.url.openConnection()).getInputStream()));
            while (true) {
                try {
                    String line = bufferReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringbuffer.append(line);
                } catch (Exception e) {
                    e = e;
                    BufferedReader bufferedReader = bufferReader;
                    e.printStackTrace();
                    return stringbuffer.toString();
                }
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return stringbuffer.toString();
        }
        return stringbuffer.toString();
    }

    public int download(String urlStr, String path, String fileName) {
        InputStream inputstream = null;
        FileUtil fileUtil = new FileUtil();
        try {
            inputstream = getFromUrl(urlStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileUtil.writeToSDPATHFromInput(path, fileName, inputstream) != null) {
            return 0;
        }
        return -1;
    }

    public InputStream getFromUrl(String urlStr) throws IOException {
        this.url = new URL(urlStr);
        return ((HttpURLConnection) this.url.openConnection()).getInputStream();
    }
}
