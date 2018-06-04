package br.com.batepapo.batepapouserssoapwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BatePapoUsersSoapWebServiceApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BatePapoUsersSoapWebServiceApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BatePapoUsersSoapWebServiceApplication.class, args);
	}
}