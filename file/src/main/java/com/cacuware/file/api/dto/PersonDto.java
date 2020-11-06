package com.cacuware.file.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class PersonDto {

    private UUID id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String gender;

    private String area;

    private String city;

    private String address;

    private LocalDate birthday;

    private int status;

}
