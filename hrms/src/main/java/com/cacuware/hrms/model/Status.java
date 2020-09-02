package com.cacuware.hrms.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Status {
    DECLINED(1),
    PENDING(2),
    HIRED(3);

    private int s;
    Status(int s) {
        this.s = s;
    }

    private static final Map<Integer, Status> BY_LABEL = new HashMap<>();

    static {
        for (Status e : values()) {
            BY_LABEL.put(e.s, e);
        }
    }

    public static Status getByValue(int label) {
        return BY_LABEL.get(label);
    }

    public static Map<Integer, Status> getAll() {
        return BY_LABEL;
    }

    public int getValue() {
        return s;
    }

    public void setValue(int value) {
        this.s = value;
    }

    public static List<String> getAllNames(){
        return BY_LABEL.values().stream().map(Status::name).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Status{" +
                "value =" + s +
                "; name =" + name() + "}";
    }
}
