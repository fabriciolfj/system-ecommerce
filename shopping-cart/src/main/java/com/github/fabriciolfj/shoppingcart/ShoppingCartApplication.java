package com.github.fabriciolfj.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.entity")
@EnableR2dbcRepositories(basePackages = {"com.github.fabriciolfj.shoppingcart.adatpter.out.persistence.repository"})
public class ShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}
