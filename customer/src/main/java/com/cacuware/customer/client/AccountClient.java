package com.cacuware.customer.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cacuware.customer.model.Account;

@FeignClient(name = "account-service", configuration = AccountClientConfiguration.class)
public interface AccountClient {

	@GetMapping("/")
	List<Account> findAccounts();
	
}
