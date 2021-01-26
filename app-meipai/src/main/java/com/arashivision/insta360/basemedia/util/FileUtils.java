package com.arashivision.insta360.basemedia.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.arashivision.insta360.basemedia.log.MediaLogger;
import com.baidubce.BceConfig;
import e.a.a.a.a;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Locale;

public class FileUtils {
    public static MediaLogger IL1Iii = MediaLogger.getLogger(FileUtils.class);

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long copy(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        FileChannel channel = fileInputStream.getChannel();
        return channel.transferTo(0, channel.size(), fileOutputStream.getChannel());
    }

    /* JADX INFO: finally extract failed */
    public static void copy(File file, File file2, boolean z) {
        if (!file.exists()) {
            throw new FileNotFoundException(a.a("File not exist: ", file));
        } else if (!file.isFile()) {
            throw new IOException(a.a("Not a file:", file));
        } else if (!equals(file, file2)) {
            if (file2.exists()) {
                if (file2.isDirectory()) {
                    file2 = new File(file2, file.getName());
                }
                if (file2.exists() && !z) {
                    throw new IOException(a.a("File already exist: ", file2));
                }
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                copy(fileInputStream, fileOutputStream);
                close(fileOutputStream);
                close(fileInputStream);
                if (file.length() != file2.length()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Copy file failed of '");
                    sb.append(file);
                    sb.append("' to '");
                    sb.append(file2);
                    sb.append("' due to different sizes");
                    throw new IOException(sb.toString());
                }
            } catch (Throwable th) {
                close(fileOutputStream);
                close(fileInputStream);
                throw th;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Files '");
            sb2.append(file);
            sb2.append("' and '");
            sb2.append(file2);
            sb2.append("' are equal");
            throw new IOException(sb2.toString());
        }
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r3v10, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r7v1 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0042, code lost:
        if (r3 == 0) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x007e, code lost:
        if (r3 == 0) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0081, code lost:
        r8.printStackTrace();
     */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v1
  assigns: []
  uses: []
  mth insns count: 81
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
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076 A[SYNTHETIC, Splitter:B:38:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a A[SYNTHETIC, Splitter:B:49:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0094 A[SYNTHETIC, Splitter:B:54:0x0094] */
    /* JADX WARNING: Unknown variable types count: 14 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyFile(java.io.File r8, java.lang.String r9) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r8.exists()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r2 == 0) goto L_0x0037
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            r2.<init>(r8)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            r3.<init>(r9)     // Catch:{ Exception -> 0x0031, all -> 0x002f }
            r0 = 1444(0x5a4, float:2.023E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
        L_0x0016:
            int r4 = r2.read(r0)     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r5 = -1
            if (r4 == r5) goto L_0x0021
            r3.write(r0, r1, r4)     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x0016
        L_0x0021:
            r2.close()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r1 = 1
            r0 = r2
            goto L_0x0038
        L_0x0027:
            r8 = move-exception
            goto L_0x0087
        L_0x002a:
            r0 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x004f
        L_0x002f:
            r8 = move-exception
            goto L_0x0088
        L_0x0031:
            r3 = move-exception
            r7 = r3
            r3 = r0
            r0 = r2
            r2 = r7
            goto L_0x004f
        L_0x0037:
            r3 = r0
        L_0x0038:
            if (r0 == 0) goto L_0x0042
            r0.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0042:
            if (r3 == 0) goto L_0x0084
        L_0x0044:
            r3.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x0084
        L_0x0048:
            r8 = move-exception
            goto L_0x0081
        L_0x004a:
            r8 = move-exception
            r3 = r0
            goto L_0x0086
        L_0x004d:
            r2 = move-exception
            r3 = r0
        L_0x004f:
            com.arashivision.insta360.basemedia.log.MediaLogger r4 = IL1Iii     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r5.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = "copyFile fail, oldPath: "
            r5.append(r6)     // Catch:{ all -> 0x0085 }
            java.lang.String r8 = r8.getAbsolutePath()     // Catch:{ all -> 0x0085 }
            r5.append(r8)     // Catch:{ all -> 0x0085 }
            java.lang.String r8 = "  newPath: "
            r5.append(r8)     // Catch:{ all -> 0x0085 }
            r5.append(r9)     // Catch:{ all -> 0x0085 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0085 }
            r4.e(r8)     // Catch:{ all -> 0x0085 }
            r2.printStackTrace()     // Catch:{ all -> 0x0085 }
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r8 = move-exception
            r8.printStackTrace()
        L_0x007e:
            if (r3 == 0) goto L_0x0084
            goto L_0x0044
        L_0x0081:
            r8.printStackTrace()
        L_0x0084:
            return r1
        L_0x0085:
            r8 = move-exception
        L_0x0086:
            r2 = r0
        L_0x0087:
            r0 = r3
        L_0x0088:
            if (r2 == 0) goto L_0x0092
            r2.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0092:
            if (r0 == 0) goto L_0x009c
            r0.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x009c
        L_0x0098:
            r9 = move-exception
            r9.printStackTrace()
        L_0x009c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.util.FileUtils.copyFile(java.io.File, java.lang.String):boolean");
    }

    public static void copyFileFromAsset(Context context, String str, String str2) {
        try {
            InputStream open = context.getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    open.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void copyFileFromAssets(Context context, String str, String str2) {
        String str3 = BceConfig.BOS_DELIMITER;
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                for (String str4 : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(str3);
                    sb.append(str4);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append(str3);
                    sb3.append(str4);
                    copyFileFromAssets(context, sb2, sb3.toString());
                }
                return;
            }
            copyFileFromAsset(context, str, str2);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String createDirectoryIfNeeded(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return str;
    }

    public static void createNoMediaFileIfNeeded(String str) {
        createDirectoryIfNeeded(str);
        File file = new File(a.a(a.a(str), File.separator, ".nomedia"));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean cutFilesTo(String[] strArr, String[] strArr2) {
        if (strArr.length != strArr2.length) {
            fullDeleteAllFiles(strArr);
            return false;
        }
        boolean z = true;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            z &= new File(strArr[i2]).renameTo(new File(strArr2[i2]));
        }
        fullDeleteAllFiles(strArr);
        return z;
    }

    public static boolean equals(File file, File file2) {
        try {
            return file.getCanonicalFile().equals(file2.getCanonicalFile());
        } catch (IOException unused) {
            return false;
        }
    }

    public static void fullDelete(File file) {
        if (file.exists()) {
            if (!file.isFile()) {
                for (File fullDelete : file.listFiles()) {
                    fullDelete(fullDelete);
                }
            }
            file.delete();
        }
    }

    public static boolean fullDeleteAllFiles(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        boolean z = true;
        for (String file : strArr) {
            z &= new File(file).delete();
        }
        return z;
    }

    public static String getFileExtension(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? "" : str.substring(lastIndexOf + 1, str.length()).toLowerCase(Locale.getDefault());
    }

    public static long getFileSize(File file) {
        long j2 = 0;
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File fileSize : listFiles) {
                j2 += getFileSize(fileSize);
            }
        }
        return j2;
    }

    public static String getFileUrlName(String str) {
        String[] split = str.split(BceConfig.BOS_DELIMITER);
        if (split.length != 0) {
            String[] split2 = split[split.length - 1].split("\\.");
            if (split2.length != 0) {
                return split2[0];
            }
        }
        return "";
    }

    public static boolean isExist(String str) {
        return new File(str).exists();
    }

    public static void move(File file, File file2, boolean z) {
        String str = "File already exist: ";
        if (file.exists()) {
            if (file2.exists()) {
                if (z) {
                    file2.delete();
                } else {
                    throw new IOException(a.a(str, file2));
                }
            }
            if (!file.isDirectory() || !file2.isFile()) {
                if (file.isFile() && file2.isDirectory()) {
                    file2 = new File(file2, file.getName());
                }
                if (!file.renameTo(file2)) {
                    try {
                        copy(file, file2, z);
                        file.delete();
                    } catch (Exception e2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Move ");
                        sb.append(file);
                        sb.append(" to ");
                        sb.append(file2);
                        sb.append(" failed!");
                        throw new IOException(sb.toString(), e2);
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can not move directory ");
                sb2.append(file);
                sb2.append(" to file ");
                sb2.append(file2);
                throw new IOException(sb2.toString());
            }
        } else {
            throw new FileNotFoundException(a.a(str, file));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[SYNTHETIC, Splitter:B:20:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088 A[SYNTHETIC, Splitter:B:28:0x0088] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readFromFile(java.io.File r6) {
        /*
            java.lang.String r0 = "readFromFile fail2, "
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            java.lang.String r6 = ""
        L_0x000f:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0042 }
            if (r3 == 0) goto L_0x0025
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0042 }
            r4.<init>()     // Catch:{ Exception -> 0x0042 }
            r4.append(r6)     // Catch:{ Exception -> 0x0042 }
            r4.append(r3)     // Catch:{ Exception -> 0x0042 }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x0042 }
            goto L_0x000f
        L_0x0025:
            r2.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x0041
        L_0x0029:
            r1 = move-exception
            r1.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r2 = IL1Iii
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            java.lang.String r1 = r1.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.e(r0)
        L_0x0041:
            return r6
        L_0x0042:
            r6 = move-exception
            goto L_0x0048
        L_0x0044:
            r6 = move-exception
            goto L_0x0086
        L_0x0046:
            r6 = move-exception
            r2 = r1
        L_0x0048:
            r6.printStackTrace()     // Catch:{ all -> 0x0084 }
            com.arashivision.insta360.basemedia.log.MediaLogger r3 = IL1Iii     // Catch:{ all -> 0x0084 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r4.<init>()     // Catch:{ all -> 0x0084 }
            java.lang.String r5 = "readFromFile fail1, "
            r4.append(r5)     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0084 }
            r4.append(r6)     // Catch:{ all -> 0x0084 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0084 }
            r3.e(r6)     // Catch:{ all -> 0x0084 }
            if (r2 == 0) goto L_0x0083
            r2.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0083
        L_0x006b:
            r6 = move-exception
            r6.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r2 = IL1Iii
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r2.e(r6)
        L_0x0083:
            return r1
        L_0x0084:
            r6 = move-exception
            r1 = r2
        L_0x0086:
            if (r1 == 0) goto L_0x00a4
            r1.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x00a4
        L_0x008c:
            r1 = move-exception
            r1.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r2 = IL1Iii
            java.lang.StringBuilder r0 = e.a.a.a.a.a(r0)
            java.lang.String r1 = r1.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.e(r0)
        L_0x00a4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.util.FileUtils.readFromFile(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053 A[SYNTHETIC, Splitter:B:22:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065 A[SYNTHETIC, Splitter:B:30:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.arashivision.insbase.nativeref.NativeBuffer readNativeBufferFromFile(java.io.File r13) {
        /*
            java.lang.String r0 = "close file exception!"
            r1 = 0
            long r2 = r13.length()     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            com.arashivision.insbase.nativeref.NativeBuffer r2 = com.arashivision.insbase.nativeref.NativeBuffer.createEmptyBuffer(r2)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r3.<init>(r13)     // Catch:{ IOException -> 0x0045, all -> 0x0043 }
            r4 = 1048576(0x100000, float:1.469368E-39)
            r5 = 0
            long r7 = r13.length()     // Catch:{ IOException -> 0x0041 }
        L_0x0018:
            int r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r13 >= 0) goto L_0x0033
            long r9 = (long) r4     // Catch:{ IOException -> 0x0041 }
            long r11 = r7 - r5
            long r9 = java.lang.Math.min(r9, r11)     // Catch:{ IOException -> 0x0041 }
            int r13 = (int) r9     // Catch:{ IOException -> 0x0041 }
            byte[] r9 = new byte[r13]     // Catch:{ IOException -> 0x0041 }
            r3.read(r9)     // Catch:{ IOException -> 0x0041 }
            int r10 = (int) r5     // Catch:{ IOException -> 0x0041 }
            int r11 = r10 + r13
            r12 = 0
            r2.set(r10, r11, r9, r12)     // Catch:{ IOException -> 0x0041 }
            long r9 = (long) r13
            long r5 = r5 + r9
            goto L_0x0018
        L_0x0033:
            r3.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x0040
        L_0x0037:
            r13 = move-exception
            r13.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r13 = IL1Iii
            r13.e(r0)
        L_0x0040:
            return r2
        L_0x0041:
            r13 = move-exception
            goto L_0x0047
        L_0x0043:
            r13 = move-exception
            goto L_0x0063
        L_0x0045:
            r13 = move-exception
            r3 = r1
        L_0x0047:
            r13.printStackTrace()     // Catch:{ all -> 0x0061 }
            com.arashivision.insta360.basemedia.log.MediaLogger r13 = IL1Iii     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = "open or read file exception!"
            r13.e(r2)     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x0060
            r3.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x0060
        L_0x0057:
            r13 = move-exception
            r13.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r13 = IL1Iii
            r13.e(r0)
        L_0x0060:
            return r1
        L_0x0061:
            r13 = move-exception
            r1 = r3
        L_0x0063:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x0072
        L_0x0069:
            r1 = move-exception
            r1.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r1 = IL1Iii
            r1.e(r0)
        L_0x0072:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.util.FileUtils.readNativeBufferFromFile(java.io.File):com.arashivision.insbase.nativeref.NativeBuffer");
    }

    public static String removeFileExtension(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public static String replaceFileExtension(String str, String str2) {
        String str3 = ".";
        int lastIndexOf = str.lastIndexOf(str3);
        if (lastIndexOf == -1) {
            return "";
        }
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        if (!str2.startsWith(str3)) {
            str2 = a.a(str3, str2);
        }
        return a.a(str, str2);
    }

    public static Bitmap saleImage(int i2, Bitmap bitmap) {
        float width = ((float) i2) / ((float) bitmap.getWidth());
        Matrix matrix = new Matrix();
        matrix.postScale(width, width);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050 A[SYNTHETIC, Splitter:B:23:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059 A[SYNTHETIC, Splitter:B:26:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveNativeBufferToFile(java.io.File r11, com.arashivision.insbase.nativeref.NativeBuffer r12) {
        /*
            java.lang.String r0 = "flush or close file error!"
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0043 }
            r2.<init>(r11)     // Catch:{ IOException -> 0x0043 }
            r11 = 1048576(0x100000, float:1.469368E-39)
            r3 = 0
            long r5 = r12.size()     // Catch:{ IOException -> 0x003e, all -> 0x003b }
        L_0x0010:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x002a
            long r7 = (long) r11     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            long r9 = r5 - r3
            long r7 = java.lang.Math.min(r7, r9)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            int r1 = (int) r7     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            int r7 = (int) r3     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            byte[] r8 = new byte[r1]     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r9 = 0
            byte[] r7 = r12.get(r7, r1, r8, r9)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            r2.write(r7)     // Catch:{ IOException -> 0x003e, all -> 0x003b }
            long r7 = (long) r1
            long r3 = r3 + r7
            goto L_0x0010
        L_0x002a:
            r2.flush()     // Catch:{ IOException -> 0x0031 }
            r2.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0056
        L_0x0031:
            r11 = move-exception
            r11.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r11 = IL1Iii
            r11.e(r0)
            goto L_0x0056
        L_0x003b:
            r11 = move-exception
            r1 = r2
            goto L_0x0057
        L_0x003e:
            r11 = move-exception
            r1 = r2
            goto L_0x0044
        L_0x0041:
            r11 = move-exception
            goto L_0x0057
        L_0x0043:
            r11 = move-exception
        L_0x0044:
            r11.printStackTrace()     // Catch:{ all -> 0x0041 }
            com.arashivision.insta360.basemedia.log.MediaLogger r11 = IL1Iii     // Catch:{ all -> 0x0041 }
            java.lang.String r12 = "open or write file error!"
            r11.e(r12)     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0056
            r1.flush()     // Catch:{ IOException -> 0x0031 }
            r1.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0056:
            return
        L_0x0057:
            if (r1 == 0) goto L_0x0069
            r1.flush()     // Catch:{ IOException -> 0x0060 }
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0069
        L_0x0060:
            r12 = move-exception
            r12.printStackTrace()
            com.arashivision.insta360.basemedia.log.MediaLogger r12 = IL1Iii
            r12.e(r0)
        L_0x0069:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.util.FileUtils.saveNativeBufferToFile(java.io.File, com.arashivision.insbase.nativeref.NativeBuffer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveToFile(java.io.File r3, java.lang.String r4) {
        /*
            r0 = 0
            java.io.File r1 = r3.getParentFile()     // Catch:{ IOException -> 0x0028 }
            r1.mkdirs()     // Catch:{ IOException -> 0x0028 }
            boolean r1 = r3.exists()     // Catch:{ IOException -> 0x0028 }
            if (r1 == 0) goto L_0x0011
            r3.delete()     // Catch:{ IOException -> 0x0028 }
        L_0x0011:
            r3.createNewFile()     // Catch:{ IOException -> 0x0028 }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0028 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0028 }
            r1.print(r4)     // Catch:{ IOException -> 0x0023, all -> 0x0020 }
            r1.close()
            goto L_0x004b
        L_0x0020:
            r3 = move-exception
            r0 = r1
            goto L_0x004c
        L_0x0023:
            r3 = move-exception
            r0 = r1
            goto L_0x0029
        L_0x0026:
            r3 = move-exception
            goto L_0x004c
        L_0x0028:
            r3 = move-exception
        L_0x0029:
            r3.printStackTrace()     // Catch:{ all -> 0x0026 }
            com.arashivision.insta360.basemedia.log.MediaLogger r4 = IL1Iii     // Catch:{ all -> 0x0026 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r1.<init>()     // Catch:{ all -> 0x0026 }
            java.lang.String r2 = "saveToFile(String) fail, "
            r1.append(r2)     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0026 }
            r1.append(r3)     // Catch:{ all -> 0x0026 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0026 }
            r4.e(r3)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x004b
            r0.close()
        L_0x004b:
            return
        L_0x004c:
            if (r0 == 0) goto L_0x0051
            r0.close()
        L_0x0051:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.util.FileUtils.saveToFile(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
        if (r1 == null) goto L_0x006f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[SYNTHETIC, Splitter:B:28:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0072 A[SYNTHETIC, Splitter:B:39:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007c A[SYNTHETIC, Splitter:B:44:0x007c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveToFile(java.io.File r4, byte[] r5) {
        /*
            r0 = 0
            java.io.File r1 = r4.getParentFile()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r1.mkdirs()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            boolean r1 = r4.exists()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            if (r1 == 0) goto L_0x0011
            r4.delete()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
        L_0x0011:
            r4.createNewFile()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0036 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0036 }
            r2.write(r5)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            boolean r4 = r4.exists()     // Catch:{ Exception -> 0x0031, all -> 0x002e }
            r2.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x0067
        L_0x0029:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0067
        L_0x002e:
            r4 = move-exception
            r0 = r2
            goto L_0x0070
        L_0x0031:
            r4 = move-exception
            r0 = r2
            goto L_0x003d
        L_0x0034:
            r4 = move-exception
            goto L_0x0070
        L_0x0036:
            r4 = move-exception
            goto L_0x003d
        L_0x0038:
            r4 = move-exception
            r1 = r0
            goto L_0x0070
        L_0x003b:
            r4 = move-exception
            r1 = r0
        L_0x003d:
            r4.printStackTrace()     // Catch:{ all -> 0x0034 }
            com.arashivision.insta360.basemedia.log.MediaLogger r5 = IL1Iii     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "saveToFile(byte[]) fail, "
            r2.append(r3)     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0034 }
            r2.append(r4)     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0034 }
            r5.e(r4)     // Catch:{ all -> 0x0034 }
            r4 = 0
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0065:
            if (r1 == 0) goto L_0x006f
        L_0x0067:
            r1.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x006f:
            return r4
        L_0x0070:
            if (r0 == 0) goto L_0x007a
            r0.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x007a
        L_0x0076:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007a:
            if (r1 == 0) goto L_0x0084
            r1.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0084:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arashivision.insta360.basemedia.util.FileUtils.saveToFile(java.io.File, byte[]):boolean");
    }
}
