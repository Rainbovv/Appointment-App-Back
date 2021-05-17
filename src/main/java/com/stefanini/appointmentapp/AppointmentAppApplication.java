package com.stefanini.appointmentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AppointmentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentAppApplication.class, args);
	}

}
