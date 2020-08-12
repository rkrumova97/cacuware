package com.cacuware.file;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class CustomerClientTest {

    @Test
    public void testClient() throws IOException {
        ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setUsername("admin");
        resourceDetails.setPassword("admin");
        resourceDetails.setAccessTokenUri("http://localhost:9999/oauth/token");
        resourceDetails.setClientId("file-service");
        resourceDetails.setClientSecret("secret");
        resourceDetails.setGrantType("password");
        resourceDetails.setScope(Collections.singletonList("read"));
        DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
        restTemplate.setMessageConverters(ImmutableList.of(new StringHttpMessageConverter(), new FormHttpMessageConverter()));
        Path path = Paths.get("C:\\Users\\rkrumova\\OneDrive\\Projects\\cacuware\\file\\src\\main\\resources\\test");
        byte[] bytes = Files.readAllBytes(path);
        String serverUrl = "http://localhost:8083//uploadFile";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "multipart/form-data");
        headers.set("Accept", "application/json");
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        ByteArrayResource file = new ByteArrayResource(bytes) {
            @Override
            public String getFilename() {
                return "test";
            }
        };
        form.add("file", file);
        form.add("type", "1");
        String result = restTemplate.postForObject(
                serverUrl,
                new HttpEntity<>(form, headers),
                String.class);
        System.out.println(result);
    }

}


