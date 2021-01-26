package com.arashivision.camera.strategy;

import android.util.Log;
import com.arashivision.onestream.OneStreamPipeline;
import com.arashivision.onestream.OneStreamPipeline.Callbacks;
import e.a.a.a.a;

public class OneStreamPipleImpl implements Callbacks {
    public static final String TAG = "com.arashivision.camera.strategy.OneStreamPipleImpl";

    public void onPipelineError(OneStreamPipeline oneStreamPipeline, int i2, int i3, String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPipelineError = ");
        sb.append(str);
        Log.d(str2, sb.toString());
    }

    public void onPipelineImageCaptured(OneStreamPipeline oneStreamPipeline, int i2, int i3, int i4, String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPipelineImageCaptured = ");
        sb.append(oneStreamPipeline);
        Log.d(str2, sb.toString());
    }

    public void onPipelineInfo(int i2, int i3, Object obj) {
        a.b("onPipelineInfo = ", i2, TAG);
    }

    public void onPipelineRecordComplete(OneStreamPipeline oneStreamPipeline) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onPipelineRecordComplete = ");
        sb.append(oneStreamPipeline);
        Log.d(str, sb.toString());
    }

    public void onPipelineRecordError(OneStreamPipeline oneStreamPipeline, int i2) {
        a.b("onPipelineRecordError = ", i2, TAG);
    }
}
