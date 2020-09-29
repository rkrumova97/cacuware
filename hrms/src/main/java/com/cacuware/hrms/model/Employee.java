package com.cacuware.hrms.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
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
    @MapsId
    private Person person;

    @OneToOne
    @JoinColumn(name = "security_data_id")
    private SecurityData securityData;

//    @ManyToMany
//    @JoinTable(name = "employee_fieldid",
//            joinColumns = { @JoinColumn(name = "employee_id",nullable = false)},
//            inverseJoinColumns = { @JoinColumn(name = "file_id")})
//    private List<UUID> fileIDs;

    @Override
    public String toString() {
        return this.person.toString() +
                this.startDate + this.vacationDays
                + this.workingDays + this.workingHours;
    }

}
