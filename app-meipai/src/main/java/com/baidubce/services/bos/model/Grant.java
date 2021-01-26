package com.baidubce.services.bos.model;

import e.a.a.a.a;
import java.util.List;

public class Grant {
    public List<Grantee> grantee;
    public List<Permission> permission;

    public Grant() {
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.Object>, for r4v0, types: [java.util.List, java.util.List<java.lang.Object>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean equalList(java.util.List<java.lang.Object> r4, java.util.List r5) {
        /*
            r3 = this;
            int r0 = r4.size()
            int r1 = r5.size()
            r2 = 0
            if (r0 == r1) goto L_0x000c
            return r2
        L_0x000c:
            java.util.Iterator r4 = r4.iterator()
        L_0x0010:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0021
            java.lang.Object r0 = r4.next()
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L_0x0010
            return r2
        L_0x0021:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidubce.services.bos.model.Grant.equalList(java.util.List, java.util.List):boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Grant.class != obj.getClass()) {
            return false;
        }
        Grant grant = (Grant) obj;
        List<Grantee> list = this.grantee;
        if (list == null) {
            if (grant.grantee != null) {
                return false;
            }
        } else if (!list.equals(grant.grantee)) {
            return false;
        }
        return equalList(this.permission, grant.permission);
    }

    public List<Grantee> getGrantee() {
        return this.grantee;
    }

    public List<Permission> getPermission() {
        return this.permission;
    }

    public int hashCode() {
        List<Grantee> list = this.grantee;
        int i2 = 0;
        int hashCode = ((list == null ? 0 : list.hashCode()) + 31) * 31;
        List<Permission> list2 = this.permission;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }

    public void setGrantee(List<Grantee> list) {
        this.grantee = list;
    }

    public void setPermission(List<Permission> list) {
        this.permission = list;
    }

    public String toString() {
        StringBuilder a2 = a.a("Grant [grantee=");
        a2.append(this.grantee);
        a2.append(", permission=");
        a2.append(this.permission);
        a2.append("]");
        return a2.toString();
    }

    public Grant withGrantee(List<Grantee> list) {
        setGrantee(list);
        return this;
    }

    public Grant withPermission(List<Permission> list) {
        setPermission(list);
        return this;
    }

    public Grant(List<Grantee> list, List<Permission> list2) {
        setGrantee(list);
        setPermission(list2);
    }
}
