package com.fabio.mockemailservice;

import com.fabio.mockemailservice.entities.Person;
import com.fabio.mockemailservice.repositories.PersonRepository;
import com.fabio.mockemailservice.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MockEmailserviceApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(MockEmailserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person person = new Person(null, "Maria Cristina", "maria@gmail.com");
		Person person1 = new Person(null, "Paula Moreira","paula@gmail.com");
		Person person2 = new Person(null, "Camila Moreira", "camila@moreira.com");

		List<Person> people = personRepository.saveAll(List.of(person,person1, person2));

		people.forEach(System.out::println);

		emailService.sendPersonConfirmationEmail(person);

	}
}
