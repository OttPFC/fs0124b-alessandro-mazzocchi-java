package com.progetto.M2_S3_G1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.progetto.M2_S3_G1.repositories")
@EntityScan(basePackages = "com.progetto.M2_S3_G1.entities")
public class M2S3G1Application {
	public static void main(String[] args) {
		SpringApplication.run(M2S3G1Application.class, args);
	}
}
