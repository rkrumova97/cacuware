package com.cacuware.file;

import com.cacuware.file.service.FileStorageService;
import com.cacuware.file.service.GenerateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FileApplication {



	public static void main(String[] args) throws Exception {
		SpringApplication.run(FileApplication.class, args);
	}

}
