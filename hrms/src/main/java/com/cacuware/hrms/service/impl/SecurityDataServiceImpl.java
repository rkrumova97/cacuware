package com.cacuware.hrms.service.impl;

import com.cacuware.hrms.api.dto.SecurityDataDto;
import com.cacuware.hrms.mapper.SecurityDataMapper;
import com.cacuware.hrms.model.SecurityData;
import com.cacuware.hrms.repository.SecurityDataRepository;
import com.cacuware.hrms.service.SecurityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SecurityDataServiceImpl implements SecurityDataService {
    @Autowired
    private SecurityDataRepository securityDataRepository;


    @Override
    public SecurityData saveSecurityData(SecurityDataDto securityDataDto) {
        return securityDataRepository.save(SecurityDataMapper.toEntity(securityDataDto));
    }

    @Override
    public SecurityData getOneById(UUID uuid) {
        return securityDataRepository.getOne(uuid);
    }

    @Override
    public void deleteSecurityData(UUID uuid) {
        securityDataRepository.delete(uuid);
    }

    @Override
    public List<SecurityData> findAllSecurityData(Sort sort) {
        return securityDataRepository.findAll();
    }

    @Override
    public SecurityData updateSecurityData(SecurityDataDto securityDataDto) {
        Optional<SecurityData> optionalSecurityData = securityDataRepository.findById(securityDataDto.getId());
        if (optionalSecurityData.isPresent()) {
            SecurityData securityData = optionalSecurityData.get();
            securityData.setAuthority(securityDataDto.getAuthority());
            securityData.setEmail(securityDataDto.getEmail());
            securityData.setDaysOfLabour(securityDataDto.getDaysOfLabour());
            securityData.setEgn(securityDataDto.getEgn());
            securityData.setIBAN(securityDataDto.getIBAN());
            securityData.setIdNumber(securityDataDto.getIdNumber());
            securityData.setIssuedDate(securityDataDto.getIssuedDate());
            securityData.setMonthsOfLabour(securityDataDto.getMonthsOfLabour());
            securityData.setSalary(securityDataDto.getSalary());
            securityData.setYearsOfLabour(securityDataDto.getYearsOfLabour());
            return securityDataRepository.save(securityData);
        } else return null;
    }
}
