package com.cacuware.hrms.api;

import com.cacuware.hrms.api.dto.SecurityDataDto;
import com.cacuware.hrms.model.SecurityData;
import com.cacuware.hrms.service.SecurityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api/hrms")
public class SecurityDataController {
    @Autowired
    private SecurityDataService securityDataService;

    @GetMapping("/securityData/{id}")
    public SecurityData findSecurityData(@PathVariable("id") UUID id) {
        return securityDataService.getOneById(id);
    }

    @GetMapping(value = "/securityData")
    public ResponseEntity<List<SecurityData>> getAllSecurityDatas(Pageable pageable) {
        List<SecurityData> securityData = securityDataService.findAllSecurityData(pageable.getSort());
        return ResponseEntity.ok().body(securityData);
    }

    @PostMapping("/securityData")
    public ResponseEntity<SecurityData> create(@RequestBody SecurityDataDto securityDataDto) throws URISyntaxException {
        SecurityData securityData = securityDataService.saveSecurityData(securityDataDto);
        return ResponseEntity.created(new URI("/api/" + securityData.getId()))
                .body(securityData);
    }

    @PutMapping("/securityData")
    public ResponseEntity<SecurityData> update(@RequestBody SecurityDataDto securityDataDto) {
        SecurityData securityData = securityDataService.updateSecurityData(securityDataDto);
        if (Objects.nonNull(securityData)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(securityData);
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping(value = "/securityData/{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        securityDataService.deleteSecurityData(uuid);
        return ResponseEntity.noContent().build();
    }
}

