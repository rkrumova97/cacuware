package com.cacuware.hrms.service;

import com.cacuware.hrms.api.dto.SecurityDataDto;
import com.cacuware.hrms.model.SecurityData;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface SecurityDataService {
    public SecurityData saveSecurityData(SecurityDataDto securityDataDto);

    SecurityData getOneById(UUID uuid);

    public void deleteSecurityData(UUID uuid);

    public List<SecurityData> findAllSecurityData(Sort sort);

    SecurityData updateSecurityData(SecurityDataDto securityDataDto);
}
