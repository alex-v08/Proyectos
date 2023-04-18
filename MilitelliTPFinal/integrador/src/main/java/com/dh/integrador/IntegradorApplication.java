package com.dh.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;
@SpringBootApplication
public class IntegradorApplication {

	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");

		SpringApplication.run(IntegradorApplication.class, args);


	}

}
