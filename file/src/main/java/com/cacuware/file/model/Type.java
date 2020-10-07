package com.cacuware.file.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
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
    REQUEST_HIRE(10),
    LPS(11);

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

    public static Type getByName(String name){
        AtomicReference<Type> type = new AtomicReference<>();
        BY_LABEL.values().forEach(t -> {
             if(t.name().equals(name)) type.set(t);
         });
        return type.get();
    }

    @Override
    public String toString() {
        return "UserType{" +
                "value =" + value +
                "; name =" + name() + "}";
    }
}
