package com.example.demo;

import com.example.demo.repo.MyRepo;
import com.example.demo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
//import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	private MyService myService;

	@Autowired
	public DemoApplication(MyService myService) {
		this.myService = myService;
		System.out.println("Creating an instance of DemoApplication");
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
		    System.out.println("hello world");
/*			MyRepo myRepo = new MyRepo();
			MyService myService = new MyService(myRepo);*/
			myService.makeTheRepoDoSomething();
		};
	}
}
