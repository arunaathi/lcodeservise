package com.lcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


   

/**
 * 
 * @author Arunmugesh J
 * 
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
public class DataRetriveApp {
	
	public static void main(String[] args) {
		SpringApplication.run(DataRetriveApp.class, args);

	}
	
	 

}
