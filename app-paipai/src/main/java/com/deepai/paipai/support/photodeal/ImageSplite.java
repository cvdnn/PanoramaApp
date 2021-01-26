package com.deepai.paipai.support.photodeal;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;

public class ImageSplite {
    public static List<ImagePiece> imageSplit(Bitmap bitmap, int xPiece, int yPiece) {
        List<ImagePiece> pieces = new ArrayList<>(xPiece * yPiece);
        int pieceWidth = bitmap.getWidth() / xPiece;
        int pieceHeight = bitmap.getHeight() / yPiece;
        for (int i = 0; i < yPiece; i++) {
            for (int j = 0; j < xPiece; j++) {
                ImagePiece piece = new ImagePiece();
                piece.index = (i * xPiece) + j;
                piece.bitmap = zoomImg(Bitmap.createBitmap(bitmap, j * pieceWidth, i * pieceHeight, pieceWidth, pieceHeight), 1024, 512);
                pieces.add(piece);
            }
        }
        return pieces;
    }

    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / ((float) width);
        float scaleHeight = ((float) newHeight) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
    }
}
