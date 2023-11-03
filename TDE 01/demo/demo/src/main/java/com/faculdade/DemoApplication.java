package com.faculdade;

import com.faculdade.modelo.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Está funcionando");

//		Produto produto = new Produto("44876", "Primeiro produto", 2.4 );
		Produto produto = new Produto();
		System.out.println(produto.getCodigo());

		List<Produto> listaProdutos = new ArrayList<>();
		listaProdutos.add(null);

		for(int i=0; i<= 9; i++) {
			Produto prod1 = new Produto();
			prod1.setCodigo(Long.valueOf(1+i));
		}
//		for(Produto prod: listaProdutos) {
//			System.out.println(prod.getDescricao());
//		}

		listaProdutos.forEach(item -> {
			if(item != null) {
				System.out.println(item.getDescricao());
			}
		});

	}

}
