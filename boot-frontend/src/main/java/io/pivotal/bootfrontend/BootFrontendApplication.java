package io.pivotal.bootfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class BootFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootFrontendApplication.class, args);
	}

	@GetMapping
	public String helloWorld() throws UnknownHostException {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://boot-backend:8080";
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return "This is a <b>frontend</b> service. I am running on " + InetAddress.getLocalHost().getHostName() +
				" & my Ip Address is: " + InetAddress.getLocalHost().getHostAddress() +
				"Message from backend is: " + response.getBody();
	}

}
