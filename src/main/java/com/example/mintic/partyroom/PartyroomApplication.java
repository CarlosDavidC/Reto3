package com.example.mintic.partyroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.example.mintic.partyroom.model"})
@SpringBootApplication
public class PartyroomApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyroomApplication.class, args);
	}
}
