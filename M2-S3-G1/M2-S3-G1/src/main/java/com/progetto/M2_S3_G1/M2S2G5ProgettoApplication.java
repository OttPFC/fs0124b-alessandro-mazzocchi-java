package com.progetto.M2_S3_G1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.progetto.M2_S2_G5_PROGETTO.repositories")
@EntityScan(basePackages = "com.progetto.M2_S2_G5_PROGETTO.entities")
public class M2S2G5ProgettoApplication {
	public static void main(String[] args) {
		SpringApplication.run(M2S2G5ProgettoApplication.class, args);
	}
}
