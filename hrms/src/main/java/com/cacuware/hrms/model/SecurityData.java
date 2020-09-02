package com.cacuware.hrms.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "security_data")
public class SecurityData {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column
    @Max(value = 9)
    private Short egn;

    @Column
    @Max(value = 9)
    private Short idNumber;

    @Column(columnDefinition = "DATE", name = "issued_date")
    private LocalDate issuedDate;

    @Column
    private String authority;

    @Column
    @Max(value = 2)
    private Integer yearsOfLabour;

    @Column
    @Max(value = 2)
    private Integer monthsOfLabour;

    @Column
    private Integer daysOfLabour;

    @Column
    private Float salary;

    @Column
    private String IBAN;

    @Column
//    @NotNull
    @Email
    private String email;
}
