package a.a.a.a.e.a.e.k;

import a.a.a.a.e.a.i.h;
import a.a.a.a.e.a.l.f.a;
import com.arashivision.insta360.basemedia.model.FileType;
import com.arashivision.insta360.basemedia.model.viewconstraint.Constraint;
import java.util.List;

public interface d {
    boolean containsRecordListData();

    Constraint getConstraint();

    FileType getFileType();

    a getRecordConverter();

    List<h> getRecordList();

    int[] getScreenRatio();

    double getSpeedFactor();

    double getTrimEnd();

    double getTrimStart();

    void setConstraint(Constraint constraint);

    void setRecordList(List<h> list);

    void setScreenRatio(int[] iArr);
}
