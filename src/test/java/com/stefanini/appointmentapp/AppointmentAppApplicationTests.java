package com.stefanini.appointmentapp;

import com.stefanini.appointmentapp.config.InMemoryDBConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { InMemoryDBConfig.class })
class AppointmentAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
