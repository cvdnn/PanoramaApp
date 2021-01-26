package com.arashivision.arvbmg.aieditor;

import com.arashivision.arvbmg.render.rendermodel.BMGNativeObjectRef;
import java.io.File;
import java.util.List;

public class AIEditor extends BMGNativeObjectRef {
    public static final String TAG = "com.arashivision.arvbmg.aieditor.AIEditor";
    public IAiEditorCallback mAiEditorCallback;
    public String mCachePath;

    public interface IAiEditorCallback {
        void onAiEditor(int i2, String str);

        void onFinishAllEditor(String str, MatchInfo matchInfo);

        void onPrepareFile(int i2, String str);
    }

    public AIEditor() {
        this(nativeCreate());
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    private native void nativeCancel();

    private native void nativeChangeBatch();

    private native void nativeConfigModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9);

    public static native long nativeCreate();

    private native void nativeFinish();

    private native void nativeFinishAll();

    private native void nativeFolderPath(String str);

    public static native String nativeGetVersion();

    private native int nativeLoad();

    private native void nativeLockVideo(List<VideoUniqueId> list, boolean z);

    private native void nativePrepare(String str, EditorVideoInfo editorVideoInfo);

    private native boolean nativeProcess(String str, long j2);

    private native void nativeProcessFaces(List<FaceInfo> list, long j2);

    private native void nativeQualitySort(float f2);

    private native void nativeReadJsonList(List<String> list);

    private native void nativeRelease();

    private native void nativeSemiAutoEdit(int i2);

    private native void nativeSetSortType(int i2);

    private native void nativeSetTemplate(String str);

    private native void nativeSetTemplateStr(String str);

    private native void nativeSetWalkStatus(int i2);

    private native void nativesetCallback();

    private native void nativveTestFinish();

    private void onEditorFinish(int i2, String str) {
        IAiEditorCallback iAiEditorCallback = this.mAiEditorCallback;
        if (iAiEditorCallback != null) {
            iAiEditorCallback.onAiEditor(i2, str);
        }
    }

    private void onFinishAll(String str, MatchInfo matchInfo) {
        IAiEditorCallback iAiEditorCallback = this.mAiEditorCallback;
        if (iAiEditorCallback != null) {
            iAiEditorCallback.onFinishAllEditor(str, matchInfo);
        }
    }

    private void onPrepare(int i2, String str) {
        IAiEditorCallback iAiEditorCallback = this.mAiEditorCallback;
        if (iAiEditorCallback != null) {
            iAiEditorCallback.onPrepareFile(i2, str);
        }
    }

    public void cancel() {
        nativeCancel();
    }

    public void changeBatch() {
        nativeChangeBatch();
    }

    public void config(String str) {
        this.mCachePath = str;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void configModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        nativeConfigModel(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public void finalize() throws Throwable {
        release();
        super.finalize();
    }

    public void finish() {
        nativveTestFinish();
    }

    public void finshVideo() {
        nativeFinish();
    }

    public void fullAutoEditor() {
        nativeFinishAll();
    }

    public int loadModel() {
        return nativeLoad();
    }

    public void lockVideo(List<VideoUniqueId> list, boolean z) {
        nativeLockVideo(list, z);
    }

    public void prepare(EditorVideoInfo editorVideoInfo) {
        nativePrepare(this.mCachePath, editorVideoInfo);
    }

    public void processFace(List<FaceInfo> list, long j2) {
        if (list != null) {
            nativeProcessFaces(list, j2);
        }
    }

    public boolean processFrame(String str, long j2) {
        return nativeProcess(str, j2);
    }

    public void processGyro() {
    }

    public void qualitySort(float f2) {
        nativeQualitySort(f2);
    }

    public void readFiles(String str) {
        nativeFolderPath(str);
    }

    public void readJsonStrList(List<String> list) {
        nativeReadJsonList(list);
    }

    public void release() {
        nativeRelease();
        free();
    }

    public void semiAutoEdit(int i2) {
        nativeSemiAutoEdit(i2);
    }

    public void setAiEditorCallback(IAiEditorCallback iAiEditorCallback) {
        this.mAiEditorCallback = iAiEditorCallback;
    }

    public void setSortType(SortType sortType) {
        nativeSetSortType(sortType.getSort());
    }

    public void setTemplateStr(String str) {
        nativeSetTemplateStr(str);
    }

    public void setWalkStatus(int i2) {
        nativeSetWalkStatus(i2);
    }

    public AIEditor(long j2) {
        super(j2, "AIEditor");
        nativesetCallback();
    }
}
