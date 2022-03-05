package com.desarrollo.web.proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class ProyectoApplication {

	Logger log = LoggerFactory.getLogger(getClass());
	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}

}