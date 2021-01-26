package com.deepai.paipai.wechattakephoto.manager;

import android.os.Environment;
import java.io.File;
import java.io.FileFilter;
import org.apache.commons.httpclient.cookie.CookieSpec;

public enum TempManager {
    INSTANCE;
    
    private static final String DEF_TEMP_DIR_NAME = "JCTempDir";
    private static final String DEF_TEMP_FILE_EXTENSION = "jpg";
    private static final String DEF_TEMP_FILE_NAME = "JCTemp";
    private String mTempFileDir;
    private String mTempFileExtension;
    /* access modifiers changed from: private */
    public String mTempFileName;

    public void init(String tempFileDir, String tempFileName, String tempFileExtension) {
        if (tempFileDir != null) {
            this.mTempFileDir = tempFileDir;
        } else {
            this.mTempFileDir = Environment.getExternalStorageDirectory().getPath() + CookieSpec.PATH_DELIM + DEF_TEMP_DIR_NAME;
        }
        if (tempFileName != null) {
            this.mTempFileName = tempFileName;
        } else {
            this.mTempFileName = DEF_TEMP_FILE_NAME;
        }
        if (tempFileExtension != null) {
            this.mTempFileExtension = tempFileExtension;
        } else {
            this.mTempFileExtension = DEF_TEMP_FILE_EXTENSION;
        }
        File tempDir = new File(this.mTempFileDir);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
    }

    public File obtainFile() {
        return new File(this.mTempFileDir + CookieSpec.PATH_DELIM + this.mTempFileName + System.currentTimeMillis() + "." + this.mTempFileExtension);
    }

    public void clearTemp() {
        if (this.mTempFileDir != null) {
            File[] files = new File(this.mTempFileDir).listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return file.getName().startsWith(TempManager.this.mTempFileName);
                }
            });
            for (int i = 0; i < files.length; i++) {
                if (files[i].exists()) {
                    files[i].delete();
                }
            }
        }
    }
}
