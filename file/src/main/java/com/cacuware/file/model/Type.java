package com.cacuware.file.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Type {
    PHOTO(1),
    CONTRACT(2),
    NOI(3),
    MEDICINE(4),
    INSTRUCTORS(5),
    JOB_DESCRIPTION(6),
    ID_CARD(7),
    CERTIFICATES(8),
    OTHERS(9),
    LPS(10);

    private int value;

    Type(int value) {
        this.value = value;
    }

    private static final Map<Integer, Type> BY_LABEL = new HashMap<>();

    static {
        for (Type e : values()) {
            BY_LABEL.put(e.value, e);
        }
    }

    public static Type getByValue(int label) {
        return BY_LABEL.get(label);
    }

    public static Map<Integer, Type> getAll() {
        return BY_LABEL;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static List<String> getAllNames(){
        return BY_LABEL.values().stream().map(Type::name).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "UserType{" +
                "value =" + value +
                "; name =" + name() + "}";
    }
}
