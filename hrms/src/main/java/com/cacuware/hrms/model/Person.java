package com.cacuware.hrms.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@Entity(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "middle_name")
    @NotNull
    private String middleName;

    @Column(name = "last_name")
    @NotNull
    private String lastName;

    @Column
    private String gender;

    @Column
    private String area;

    @Column
    private String city;

    @Column
    private String address;

    @Column(columnDefinition = "DATE")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate birthday;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Status status;

//
//    @Builder
//    public Person(String firstName, String middleName, String lastName, String gender, String address, String email) {
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.gender = gender;
//        this.address = address;
//    }
}
