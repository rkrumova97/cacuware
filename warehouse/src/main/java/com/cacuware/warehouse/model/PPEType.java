package com.cacuware.warehouse.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum PPEType {
    SHIRT(1,"t-shirt"),
    PANTS(2,"pants"),
    SHOES(3,"shoes"),
    HELMET(4,"helmet");

    private Integer id;
    private String text;

    PPEType(int id, String text) {
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


    private static final Map<Integer, PPEType> BY_LABEL = new HashMap<>();
    private static final Map<String, PPEType> BY_NAME = new HashMap<>();

    static {
        for (PPEType e : values()) {
            BY_LABEL.put(e.id, e);
            BY_NAME.put(e.text, e);
        }
    }

    public static PPEType getByNumber(int label) {
        return BY_LABEL.get(label);
    }

    public static PPEType getByText(String text) {
        return BY_NAME.get(text);
    }

    public static Map<Integer, PPEType> getAll() {
        return BY_LABEL;
    }

    public int getValue() {
        return id;
    }

    public void setValue(int value) {
        this.id = value;
    }

    public static List<String> getAllNames() {
        return BY_LABEL.values().stream().map(PPEType::getText).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "UserType{" +
                "value =" + id +
                "; name =" + name() + "}";
    }
}
