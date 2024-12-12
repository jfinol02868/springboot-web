package com.springboot.web;

import com.springboot.web.entities.Person;
import com.springboot.web.repositories.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootWebApplication implements CommandLineRunner {

	private final PersonRepository personRepository;

    public SpringbootWebApplication(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Person> people = personRepository.findAll();
		people.forEach(System.out::println);

	}
}
