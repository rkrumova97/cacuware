package com.cacuware.hrms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "employee")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(columnDefinition = "DATE", name = "start_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate startDate;

    @Column(columnDefinition = "DATE", name = "end_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate endDate;

    @Column(columnDefinition = "DATE", name = "leaving_notice_submission_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate leavingNoticeSubmissionDate;

    @Column(name = "vacation_days")
    private Integer vacationDays;

    @Column(name = "job_number")
    private JobType jobNumber;

    @Column(name = "working_hours")
    private Integer workingHours;

    @Column(name = "working_days")
    private Integer workingDays;

    @Column(name = "is_fired")
    private Boolean isFired;

    @Column(name = "education")
    @Enumerated(value = EnumType.STRING)
    private Education education;

    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @MapsId
    private Person person;

    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "security_data_id")
    private SecurityData securityData;

    @ElementCollection
    @CollectionTable(name = "employee_fileids", joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    @Column(name = "file_id")
    private List<UUID> fileIDs;

    @Override
    public String toString() {
        return this.person.toString() +
                this.startDate + this.vacationDays
                + this.workingDays + this.workingHours;
    }

}
