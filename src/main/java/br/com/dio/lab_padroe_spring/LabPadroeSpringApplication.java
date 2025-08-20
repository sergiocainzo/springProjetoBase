package br.com.dio.lab_padroe_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.dio.lab_padroe_spring.service")
public class LabPadroeSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroeSpringApplication.class, args);
	}

}
