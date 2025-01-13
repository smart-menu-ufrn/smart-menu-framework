package br.edu.ufrn.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
	scanBasePackages = {"br.edu.ufrn.bookstore", "br.edu.ufrn.smartmenu"}
)
@EntityScan(
	basePackages = {"br.edu.ufrn.bookstore", "br.edu.ufrn.smartmenu"}
)
@EnableJpaRepositories(
	basePackages = {"br.edu.ufrn.bookstore", "br.edu.ufrn.smartmenu"}
)
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
