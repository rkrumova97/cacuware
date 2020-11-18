package com.cacuware.hrms.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public enum JobType {
    TINSMITH(72131002, "Tinsmith"),
    ELECTRICIAN(74122009, "Electrician"),
    LOCKSMITH_MECHANIC(72332032, "Locksmith mechanic"),
    WELDER(72121001, "Welder"),
    PRODUCTION_COORDINATOR(24216013, "Production coordinator"),
    OFFICE_MANAGER(33413003, "Office manager"),
    ASSEMBLER_METAL_STRUCTURES(72142007, "Assembler - metal structures"),
    CLEANER(91120004, "cleaner");

    private Integer jobId;
    private String text;

    JobType(int jobId, String text) {
        this.jobId = jobId;
        this.text = text;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    private static final Map<Integer, JobType> BY_LABEL = new HashMap<>();
    private static final Map<String, JobType> BY_NAME = new HashMap<>();

    static {
        for (JobType e : values()) {
            BY_LABEL.put(e.jobId, e);
            BY_NAME.put(e.text, e);
        }
    }

    public static JobType getByNumber(int label) {
        return BY_LABEL.get(label);
    }

    public static JobType getByText(String text) {
        return BY_NAME.get(text);
    }

    public static Map<Integer, JobType> getAll() {
        return BY_LABEL;
    }

    public int getValue() {
        return jobId;
    }

    public void setValue(int value) {
        this.jobId = value;
    }

    public static List<String> getAllNames() {
        return BY_LABEL.values().stream().map(JobType::getText).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "UserType{" +
                "value =" + jobId +
                "; name =" + name() + "}";
    }
}
