package com.example.pws;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwsApplication.class, args) ;
	}

}
