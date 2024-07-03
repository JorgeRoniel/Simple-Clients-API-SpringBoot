package shr.company.api_client_cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiClientCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClientCepApplication.class, args);
	}

}
