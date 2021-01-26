package com.arashivision.arvbmg.render.lottie.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import com.arashivision.arvbmg.render.lottie.data.FloatBezierData;
import com.arashivision.arvbmg.render.lottie.data.bezierdata.PathBezierData;
import com.arashivision.arvbmg.render.lottie.transform.LottieUpdateInfo.LottieMaskData;
import java.nio.ByteBuffer;
import java.util.List;

public class MaskPathUtils {
    public static void drawRect(Canvas canvas, Paint paint, PathBezierData pathBezierData) {
        Path path = new Path();
        List list = (List) pathBezierData.getPaths().get(0);
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (i2 < 0 || ((float[]) list.get(i2))[0] > ((float[]) list.get(i4))[0] || ((float[]) list.get(i2))[1] > ((float[]) list.get(i4))[1]) {
                i2 = i4;
            }
            if (i3 < 0 || ((float[]) list.get(i3))[0] < ((float[]) list.get(i4))[0] || ((float[]) list.get(i3))[1] < ((float[]) list.get(i4))[1]) {
                i3 = i4;
            }
        }
        float width = ((float[]) list.get(i2))[0] * ((float) canvas.getWidth());
        float height = ((float) canvas.getHeight()) * ((float[]) list.get(i2))[1];
        float width2 = ((float[]) list.get(i3))[0] * ((float) canvas.getWidth());
        float height2 = ((float[]) list.get(i3))[1] * ((float) canvas.getHeight());
        path.addRect(width, height, width2, height2, Direction.CW);
        canvas.drawPath(path, paint);
    }

    public static LottieMaskData getLottieMaskData(List<PathBezierData> list, List<FloatBezierData> list2, int i2, int i3) {
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Config.ARGB_8888);
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas(createBitmap);
        for (int i4 = 0; i4 < list.size(); i4++) {
            drawRect(canvas, paint, (PathBezierData) list.get(i4));
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(createBitmap.getByteCount());
        createBitmap.copyPixelsToBuffer(allocateDirect);
        LottieMaskData lottieMaskData = new LottieMaskData();
        lottieMaskData.width = canvas.getWidth();
        lottieMaskData.height = canvas.getHeight();
        lottieMaskData.data = allocateDirect;
        if (!createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
        return lottieMaskData;
    }
}
