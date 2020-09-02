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
                .build();
    }

    public SecurityDataDto toDto(SecurityData securityData) {
        return SecurityDataDto.builder()
                .id(securityData.getId())
                .egn(securityData.getEgn())
                .authority(securityData.getAuthority())
                .daysOfLabour(securityData.getDaysOfLabour())
                .email(securityData.getEmail())
                .IBAN(securityData.getIBAN())
                .idNumber(securityData.getIdNumber())
                .issuedDate(securityData.getIssuedDate())
                .monthsOfLabour(securityData.getMonthsOfLabour())
                .salary(securityData.getSalary())
                .yearsOfLabour(securityData.getYearsOfLabour())
                .build();
    }
}
