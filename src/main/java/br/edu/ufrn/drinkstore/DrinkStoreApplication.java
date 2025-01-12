package br.edu.ufrn.drinkstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	scanBasePackages = {"br.edu.ufrn.drinkstore", "br.edu.ufrn.smartmenu"}
)
public class DrinkStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrinkStoreApplication.class, args);
	}

}
