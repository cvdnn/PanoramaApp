package com.baidubce.services.bos.model;

import e.a.a.a.a;

public class Grantee {
    public String id;

    public Grantee() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Grantee.class != obj.getClass()) {
            return false;
        }
        Grantee grantee = (Grantee) obj;
        String str = this.id;
        if (str == null) {
            if (grantee.id != null) {
                return false;
            }
        } else if (!str.equals(grantee.id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.id;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        return a.a(a.a("Grantee [id="), this.id, "]");
    }

    public Grantee withId(String str) {
        setId(str);
        return this;
    }

    public Grantee(String str) {
        setId(str);
    }
}
