package i.a.a.a;

/* compiled from: AlreadySelectedException */
public class a extends l {
    public a(j jVar, i iVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The option '");
        stringBuffer.append(iVar.a());
        stringBuffer.append("' was specified but an option from this group ");
        stringBuffer.append("has already been selected: '");
        stringBuffer.append(jVar.f9714b);
        stringBuffer.append("'");
        super(stringBuffer.toString());
    }
}
