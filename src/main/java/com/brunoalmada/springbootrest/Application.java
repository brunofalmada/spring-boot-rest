package com.brunoalmada.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * This application consists of a REST API and internal methods as required.
 *
 * @author Bruno Faria Almada
 * 
 */

@SpringBootApplication
@EntityScan(basePackages = { "com.brunoalmada.springbootrest.entity" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
