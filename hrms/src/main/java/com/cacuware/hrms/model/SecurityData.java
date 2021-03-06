package com.cacuware.hrms.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
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
    private Short egn;

    @Column
    private Short idNumber;

    @Column(columnDefinition = "DATE", name = "issued_date")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate issuedDate;

    @Column
    private String authority;

    @Column
    private Integer yearsOfLabour;

    @Column
    private Integer monthsOfLabour;

    @Column
    private Integer daysOfLabour;

    @Column
    private Integer professionalYearsOfLabour;

    @Column
    private Integer professionalMonthsOfLabour;

    @Column
    private Integer professionalDaysOfLabour;

    @Column
    private Float salary;

    @Column
    private String IBAN;

    @Column
//    @NotNull
    @Email
    private String email;
}
