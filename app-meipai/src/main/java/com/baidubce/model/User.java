package com.baidubce.model;

import e.a.a.a.a;

public class User {
    public String displayName;
    public String id;

    public User() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        String str = this.displayName;
        if (str == null) {
            if (user.displayName != null) {
                return false;
            }
        } else if (!str.equals(user.displayName)) {
            return false;
        }
        String str2 = this.id;
        if (str2 == null) {
            if (user.id != null) {
                return false;
            }
        } else if (!str2.equals(user.id)) {
            return false;
        }
        return true;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        String str = this.displayName;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.id;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        StringBuilder a2 = a.a("User [id=");
        a2.append(this.id);
        a2.append(", displayName=");
        return a.a(a2, this.displayName, "]");
    }

    public User withDisplayName(String str) {
        setDisplayName(str);
        return this;
    }

    public User withId(String str) {
        setId(str);
        return this;
    }

    public User(String str, String str2) {
        setId(str);
        setDisplayName(str2);
    }
}
