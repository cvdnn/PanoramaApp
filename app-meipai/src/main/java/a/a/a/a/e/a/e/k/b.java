package a.a.a.a.e.a.e.k;

import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;

public interface b {
    b clone();

    int getCameraFacing();

    Constraint getConstraint();

    int[] getConstraintRatio();

    FileType getFileType();

    int getFitMode();

    int getRotateDegree();

    int[] getScreenRatio();

    boolean isRotateEnabled();

    boolean isRotateScreenRatioEnabled();
}
