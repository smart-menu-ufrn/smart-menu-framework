package br.edu.ufrn.drinkstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
	scanBasePackages = {"br.edu.ufrn.drinkstore", "br.edu.ufrn.smartmenu"}
)
@EntityScan(
	basePackages = {"br.edu.ufrn.drinkstore", "br.edu.ufrn.smartmenu"}
)
@EnableJpaRepositories(
	basePackages = {"br.edu.ufrn.drinkstore", "br.edu.ufrn.smartmenu"}
)
public class DrinkStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrinkStoreApplication.class, args);
	}

}
