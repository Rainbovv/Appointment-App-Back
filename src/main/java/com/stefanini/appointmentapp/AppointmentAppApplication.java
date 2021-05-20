package com.stefanini.appointmentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppointmentAppApplication {	
    public static void main(String[] args) {
        SpringApplication.run(AppointmentAppApplication.class, args);
    }
}
