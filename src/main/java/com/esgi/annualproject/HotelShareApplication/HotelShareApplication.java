package com.esgi.annualproject.HotelShareApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HotelShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelShareApplication.class, args);
	}

}
