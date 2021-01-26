package com.baidubce.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Mimetypes {
    public static final String MIMETYPE_OCTET_STREAM = "application/octet-stream";
    public static Mimetypes mimetypes;
    public HashMap<String, String> extensionToMimetypeMap = new HashMap<>();

    public static synchronized Mimetypes getInstance() {
        String str;
        synchronized (Mimetypes.class) {
            if (mimetypes != null) {
                Mimetypes mimetypes2 = mimetypes;
                return mimetypes2;
            }
            Mimetypes mimetypes3 = new Mimetypes();
            mimetypes = mimetypes3;
            InputStream resourceAsStream = mimetypes3.getClass().getResourceAsStream("/mime.types");
            if (resourceAsStream != null) {
                BLog.debug("Loading mime types from file in the classpath: mime.types");
                try {
                    mimetypes.loadAndReplaceMimetypes(resourceAsStream);
                    try {
                        resourceAsStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        str = "";
                    }
                } catch (IOException e3) {
                    try {
                        BLog.error("Failed to load mime types from file in the classpath: mime.types", (Throwable) e3);
                        try {
                        } catch (IOException e4) {
                            e = e4;
                            str = "";
                        }
                    } finally {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e5) {
                            BLog.debug("", (Throwable) e5);
                        }
                    }
                }
            } else {
                BLog.warn("Unable to find 'mime.types' file in classpath");
            }
            Mimetypes mimetypes4 = mimetypes;
            return mimetypes4;
        }
        BLog.debug(str, (Throwable) e);
        Mimetypes mimetypes42 = mimetypes;
        return mimetypes42;
    }

    public String getMimetype(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        String str2 = "application/octet-stream";
        if (lastIndexOf > 0) {
            int i2 = lastIndexOf + 1;
            if (i2 < str.length()) {
                String lowerCase = str.substring(i2).toLowerCase();
                String str3 = "'";
                if (this.extensionToMimetypeMap.keySet().contains(lowerCase)) {
                    String str4 = (String) this.extensionToMimetypeMap.get(lowerCase);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Recognised extension '");
                    sb.append(lowerCase);
                    sb.append("', mimetype is: '");
                    sb.append(str4);
                    sb.append(str3);
                    BLog.debug(sb.toString());
                    return str4;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Extension '");
                sb2.append(lowerCase);
                sb2.append("' is unrecognized in mime type listing, using default mime type: '");
                sb2.append(str2);
                sb2.append(str3);
                BLog.debug(sb2.toString());
                return str2;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("File name has no extension, mime type cannot be recognised for: ");
        sb3.append(str);
        BLog.debug(sb3.toString());
        return str2;
    }

    public void loadAndReplaceMimetypes(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String trim = readLine.trim();
                if (!trim.startsWith("#") && trim.length() != 0) {
                    StringTokenizer stringTokenizer = new StringTokenizer(trim, " \t");
                    String str = "'";
                    if (stringTokenizer.countTokens() > 1) {
                        String nextToken = stringTokenizer.nextToken();
                        while (stringTokenizer.hasMoreTokens()) {
                            String nextToken2 = stringTokenizer.nextToken();
                            this.extensionToMimetypeMap.put(nextToken2.toLowerCase(), nextToken);
                            StringBuilder sb = new StringBuilder();
                            sb.append("Setting mime type for extension '");
                            sb.append(nextToken2.toLowerCase());
                            sb.append("' to '");
                            sb.append(nextToken);
                            sb.append(str);
                            BLog.debug(sb.toString());
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Ignoring mimetype with no associated file extensions: '");
                        sb2.append(trim);
                        sb2.append(str);
                        BLog.debug(sb2.toString());
                    }
                }
            } else {
                return;
            }
        }
    }

    public String getMimetype(File file) {
        return getMimetype(file.getName());
    }
}
