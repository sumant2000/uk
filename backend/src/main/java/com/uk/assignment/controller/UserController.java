package com.uk.assignment.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uk.assignment.domain.Person;
import com.uk.assignment.service.UserService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/list")
	public Iterable<Person> list() {
		return userService.list();
	}

	@PostMapping(value = "/persons/create")
	public Person postPerson(@RequestBody Person person) {

		Person _person = userService.save(new Person(person.getFirstName(), person.getAge(), null, null, null));
		return _person;
	}

	@DeleteMapping("/delete/persons/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable("id") long id) {
		System.out.println("Delete Person with ID = " + id + "...");

		userService.deleteById(id);

		return new ResponseEntity<>("Person has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/persons/deleteAll")
	public ResponseEntity<String> deleteAllPersons() {
		System.out.println("Delete All Persons...");

		userService.deleteAll();

		return new ResponseEntity<>("All persons have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "persons/age/{age}")
	public Person findByAge(@PathVariable String age) {

		Person person = userService.findByAge(age);
		return person;
	}

	@PutMapping("/update/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
		System.out.println("Update Person with ID = " + id + "...");

		Person personData = userService.findById(id);

		if (personData != null) {
			Person _person = personData;
			_person.setFirstName(person.getFirstName());
			_person.setAge(person.getAge());
			return new ResponseEntity<>(userService.save(_person), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
