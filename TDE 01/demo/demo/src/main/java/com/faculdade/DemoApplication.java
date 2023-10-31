package com.faculdade;

import modelo.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Está funcionando");

		Produto produto = new Produto("44876", "Primeiro produto", 2.4 );
	}

}
