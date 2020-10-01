package com.cacuware.hrms.mapper;

import com.cacuware.hrms.api.dto.SecurityDataDto;
import com.cacuware.hrms.model.SecurityData;
import org.springframework.stereotype.Component;

@Component
public class SecurityDataMapper {
    public static SecurityData toEntity(SecurityDataDto securityDataDto) {
        return SecurityData.builder()
                .id(securityDataDto.getId())
                .egn(securityDataDto.getEgn())
                .authority(securityDataDto.getAuthority())
                .daysOfLabour(securityDataDto.getDaysOfLabour())
                .email(securityDataDto.getEmail())
                .IBAN(securityDataDto.getIBAN())
                .idNumber(securityDataDto.getIdNumber())
                .issuedDate(securityDataDto.getIssuedDate())
                .monthsOfLabour(securityDataDto.getMonthsOfLabour())
                .salary(securityDataDto.getSalary())
                .yearsOfLabour(securityDataDto.getYearsOfLabour())
                .professionalDaysOfLabour(securityDataDto.getProfessionDaysOfLabour())
                .professionalMonthsOfLabour(securityDataDto.getProfessionMonthsOfLabour())
                .professionalYearsOfLabour(securityDataDto.getProfessionYearsOfLabour())
                .build();
    }

    public static SecurityDataDto toDto(SecurityData securityData) {
        return SecurityDataDto.builder()
                .id(securityData.getId())
                .egn(securityData.getEgn())
                .authority(securityData.getAuthority())
                .daysOfLabour(securityData.getDaysOfLabour())
                .email(securityData.getEmail())
                .idNumber(securityData.getIdNumber())
                .issuedDate(securityData.getIssuedDate())
                .monthsOfLabour(securityData.getMonthsOfLabour())
                .salary(securityData.getSalary())
                .yearsOfLabour(securityData.getYearsOfLabour())
                .professionDaysOfLabour(securityData.getDaysOfLabour())
                .professionMonthsOfLabour(securityData.getMonthsOfLabour())
                .professionYearsOfLabour(securityData.getYearsOfLabour())
                .build();
    }
}
