package com.mbodji.testautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAutomationApplication.class, args);
	}
	@GetMapping
	public String direBonjour(){
		return "Bonjour MBODJI Ousseynou";
	}

}
