package io.pivotal.bootbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class BootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBackendApplication.class, args);
	}


	@GetMapping("")
	public String getHost() throws UnknownHostException {
		return "Hello from : "+ InetAddress.getLocalHost().getHostName();
	}
}
