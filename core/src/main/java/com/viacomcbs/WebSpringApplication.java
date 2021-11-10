package main.java.com.viacomcbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class WebSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringApplication.class, args);
	}

}
