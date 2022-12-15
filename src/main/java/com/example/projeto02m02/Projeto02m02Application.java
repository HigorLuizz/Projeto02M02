package com.example.projeto02m02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Projeto02m02Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto02m02Application.class, args);
	}

}
