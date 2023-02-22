package cs.ubb.microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableFeignClients
@EnableWebSecurity
@SpringBootApplication
public class ArtistsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtistsApplication.class, args);
	}

}
