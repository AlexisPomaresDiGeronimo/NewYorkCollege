package com.alexis.MessagingWebSocket;

import com.alexis.MessagingWebSocket.Repositories.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class MessagingWebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingWebSocketApplication.class, args);
	}

}
