package com.capgemini.bookmydoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication

public class BookmydoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmydoctorApplication.class, args);
	}

}
