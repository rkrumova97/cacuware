package com.cacuware.hrms.model;

import java.util.Arrays;


public enum JobType {
    JAVA_SOFTWARE_DEVELOPER(1),
    HR(2),
    BENCH(3);

    private Integer jobId;

    JobType(int jobId) {
        this.jobId = jobId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public static JobType findByJobId(int jobId) {
        return Arrays.stream(JobType.values())
                .filter(e -> e.getJobId().equals(jobId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", jobId)));
    }
}
