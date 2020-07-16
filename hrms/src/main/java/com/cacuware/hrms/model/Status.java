package com.cacuware.hrms.model;

public enum Status {
    DECLINED(1),
    PENDING(2),
    HIRED(3);

    private int s;
    Status(int s) {
        this.s = s;
    }
}
