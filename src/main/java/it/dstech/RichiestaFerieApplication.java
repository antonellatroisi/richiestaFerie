package it.dstech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages= {"it.dstech.*"})
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class })
public class RichiestaFerieApplication {

	public static void main(String[] args) {
		SpringApplication.run(RichiestaFerieApplication.class, args);
	}
}
