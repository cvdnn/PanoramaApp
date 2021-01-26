package com.arashivision.arvbmg.aieditor;

public enum SortType {
    score(1),
    shootingTime(2),
    duration(3);
    
    public int sort;

    /* access modifiers changed from: public */
    SortType(int i2) {
        this.sort = i2;
    }

    public int getSort() {
        return this.sort;
    }
}
