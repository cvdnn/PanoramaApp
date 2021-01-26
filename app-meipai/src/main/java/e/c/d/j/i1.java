package e.c.d.j;

import com.baidu.picapture.model.net.BaseResponse;
import com.baidu.picapture.model.net.spin.NewSpinTaskResp;
import com.baidu.picapture.model.spin.SpinTaskInfo;
import e.c.d.f.b.b;
import e.c.d.l.b.a;
import g.e;

/* compiled from: SpinTaskManager */
public class i1 extends a<BaseResponse<NewSpinTaskResp>> {

    /* renamed from: a reason: collision with root package name */
    public final /* synthetic */ j1 f6276a;

    public i1(j1 j1Var) {
        this.f6276a = j1Var;
    }

    public void a(e eVar, Object obj, int i2) {
        this.f6276a.f6254a.execute(new w(this, eVar, i2, (BaseResponse) obj));
    }

    public /* synthetic */ void a(e eVar, int i2, BaseResponse baseResponse) {
        SpinTaskInfo spinTaskInfo = (SpinTaskInfo) this.f6276a.f6283f.remove(eVar);
        if (spinTaskInfo != null) {
            if (spinTaskInfo.getTask().f6077f == 998 || spinTaskInfo.getTask().f6077f == 999) {
                String str = spinTaskInfo.getTask().f6072a;
                return;
            }
            if (i2 != 0) {
                j1.a(this.f6276a, spinTaskInfo, -1);
            } else if (baseResponse.getError_code() == 0) {
                j1 j1Var = this.f6276a;
                if (j1Var != null) {
                    String str2 = spinTaskInfo.getTask().f6072a;
                    ((NewSpinTaskResp) baseResponse.getData()).getPackageId();
                    spinTaskInfo.getTask().f6073b = ((NewSpinTaskResp) baseResponse.getData()).getPackageId();
                    b.b().a(spinTaskInfo.getTask());
                    j1Var.e(spinTaskInfo);
                } else {
                    throw null;
                }
            } else {
                j1.a(this.f6276a, spinTaskInfo, baseResponse.getError_code());
            }
        }
    }
}
