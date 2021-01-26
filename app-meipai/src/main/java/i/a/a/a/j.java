package i.a.a.a;

import com.arashivision.insbase.arlog.MultipartUtility;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: OptionGroup */
public class j implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public Map f9713a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    public String f9714b;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.f9713a.values().iterator();
        stringBuffer.append("[");
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (iVar.f9707a != null) {
                stringBuffer.append("-");
                stringBuffer.append(iVar.f9707a);
            } else {
                stringBuffer.append(MultipartUtility.TWO_HYPHENS);
                stringBuffer.append(iVar.f9708b);
            }
            stringBuffer.append(" ");
            stringBuffer.append(iVar.f9710d);
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
