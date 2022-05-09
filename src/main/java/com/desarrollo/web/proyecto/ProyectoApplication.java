package com.desarrollo.web.proyecto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoApplication {

	Logger log = LoggerFactory.getLogger(getClass());   
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}