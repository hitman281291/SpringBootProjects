package com.coding.hitesh.module1;

import com.coding.hitesh.module1.enums.Frost;
import com.coding.hitesh.module1.enums.Syrup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationAotProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import com.coding.hitesh.module1.bakery.CakeBaker;

@SpringBootApplication
public class Module1Application {

	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

	@Bean
	public CommandLineRunner cakeRunner(CakeBaker cakeBaker) {
		return args -> {
			cakeBaker.bakeCake(Frost.VanillaFrosting.name(), Syrup.VanillaSyrup.name());
//			cakeBaker.bakeCake("StrawberryFrosting", "ChocolateSyrup");
		};
	}
}
