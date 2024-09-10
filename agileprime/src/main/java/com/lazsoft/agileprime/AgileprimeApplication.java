package com.lazsoft.agileprime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lazsoft.agileprime.*")
public class AgileprimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgileprimeApplication.class, args);
	}

}
