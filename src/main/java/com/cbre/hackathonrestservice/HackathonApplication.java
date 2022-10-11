package com.cbre.hackathonrestservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HackathonApplication implements CommandLineRunner {	
	
	private static final Logger logger = LoggerFactory.getLogger(HackathonApplication.class);
	

    public static void main(String[] args) {
    	
  
		SpringApplication.run(HackathonApplication.class, args);
	}
    
    @Override
    public void run(String... args) throws Exception {
        
         
    }

}
