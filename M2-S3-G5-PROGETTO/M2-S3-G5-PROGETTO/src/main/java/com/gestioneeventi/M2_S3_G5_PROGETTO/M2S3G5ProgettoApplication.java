package com.gestioneeventi.M2_S3_G5_PROGETTO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.gestioneeventi.M2_S3_G5_PROGETTO.datalayer.repositories")
public class M2S3G5ProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2S3G5ProgettoApplication.class, args);
	}
}
