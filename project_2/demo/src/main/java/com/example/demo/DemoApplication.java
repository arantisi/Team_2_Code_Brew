package com.example.demo;

import com.example.demo.repositories.UserRepository;
import com.example.demo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
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
