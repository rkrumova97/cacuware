package com.cacuware.hrms.model;

import java.util.Arrays;


public enum JobType {
    TINSMITH(72131002, "тенекеджия"),
    ELECTRICIAN(74122009, "електромонтьор"),
    LOCKSMITH_MECHANIC(72332032, "шлосер-монтьор"),
    WELDER(72121001, "заварчик"),
    PRODUCTION_COORDINATOR(24216013, "координатор производство"),
    OFFICE_MANAGER(33413003, "офис мениджър"),
    ASSEMBLER_METAL_STRUCTURES(72142007, "монтажник - метални конструкции"),
    CLEANER(91120004, "хигиенист");

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

    public static JobType findByJobId(int jobId) {
        return Arrays.stream(JobType.values())
                .filter(e -> e.getJobId().equals(jobId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", jobId)));
    }
}
