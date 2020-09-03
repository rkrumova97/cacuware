package com.cacuware.hrms.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private LocalDate startDate;

    @Column(columnDefinition = "DATE", name = "end_date")
    private LocalDate endDate;

    @Column(name = "vacation_days")
    private Integer vacationDays;

    @Column(name = "job_number")
    @NotNull
    private JobType jobNumber;

    @Column(name = "working_hours")
    @NotNull
    private Integer workingHours;

    @Column(name = "working_days")
    @NotNull
    private Integer workingDays;

    @Column(name = "is_fired")
    private Boolean isFired;

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
