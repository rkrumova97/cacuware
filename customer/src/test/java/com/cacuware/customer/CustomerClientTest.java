package com.cacuware.customer;

import java.util.Collections;

import com.cacuware.customer.model.Customer;
import org.junit.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

public class CustomerClientTest {

	@Test
	public void testClient() {
            ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
            resourceDetails.setUsername("admin");
            resourceDetails.setPassword("admin");
            resourceDetails.setAccessTokenUri("http://localhost:9999/oauth/token");
            resourceDetails.setClientId("customer-service");
            resourceDetails.setClientSecret("secret");
            resourceDetails.setGrantType("password");
            DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
            OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
            restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
            final Customer customer = restTemplate.getForObject("http://localhost:8083/{id}", Customer.class, 1);
            System.out.println(customer);
	}
	
}
