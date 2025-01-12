package br.edu.ufrn.drugstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	scanBasePackages = {"br.edu.ufrn.drugstore", "br.edu.ufrn.smartmenu"}
)
public class DrugStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugStoreApplication.class, args);
	}

}
