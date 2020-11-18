package com.cacuware.hrms.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Education {
    PRIMARY(1, "primary"),
    SECONDARY(2, "secondary"),
    HIGH_SCHOOL(3, "high school"),
    POST_GRADUATE(4, "bachelor"),
    MASTER(5, "master");

    private Integer id;
    private String text;

    Education(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    private static final Map<Integer, Education> BY_LABEL = new HashMap<>();
    private static final Map<String, Education> BY_NAME = new HashMap<>();

    static {
        for (Education e : values()) {
            BY_LABEL.put(e.id, e);
            BY_NAME.put(e.text, e);
        }
    }

    public static Education getByNumber(int label) {
        return BY_LABEL.get(label);
    }

    public static Education getByText(String text) {
        return BY_NAME.get(text);
    }

    public static Map<Integer, Education> getAll() {
        return BY_LABEL;
    }

    public int getValue() {
        return id;
    }

    public void setValue(int value) {
        this.id = value;
    }

    public static List<String> getAllNames() {
        return BY_LABEL.values().stream().map(Education::getText).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "UserType{" +
                "value =" + id +
                "; name =" + name() + "}";
    }

}
