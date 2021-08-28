package com.revature.imsApi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImsApiApplication {

	private static final Logger LOGGER = LogManager.getLogger(ImsApiApplication.class);

	public static void main(String[] args) {
		
		try {
			SpringApplication.run(ImsApiApplication.class, args);
			LOGGER.info("app running");
		} catch (Exception ex) {
			throw ex;
		}
	}

}
