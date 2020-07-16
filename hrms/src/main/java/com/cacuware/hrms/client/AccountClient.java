package com.cacuware.hrms.client;

import com.cacuware.hrms.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "account-service", configuration = AccountClientConfiguration.class)
public interface AccountClient {

	@GetMapping("/")
	List<Account> findAccounts();
	
}
