package com.cacuware.email.api;

import java.util.Collections;

import com.cacuware.email.api.dto.EmailDto;
import org.junit.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

public class EmailTest {

    @Test
    public void testClient() {
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("admin");
        resourceDetails.setPassword("admin");
        resourceDetails.setAccessTokenUri("http://localhost:9999/oauth/token");
        resourceDetails.setClientId("mail-service");
        resourceDetails.setClientSecret("secret");
        resourceDetails.setGrantType("password");
        resourceDetails.setScope(Collections.singletonList("read"));
        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();

        EmailDto emailDto = EmailDto.builder()
                .email("rkrumova97@gmail.com")
                .subject("Blabla")
                .text("Aloha")
                .build();

        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        final EmailDto result = restTemplate.postForObject("http://localhost:8082/sendMail", emailDto, EmailDto.class);
        System.out.println(result);
    }

}
