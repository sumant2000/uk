package com.uk.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uk.assignment.domain.Person;
import com.uk.assignment.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Iterable<Person> list() {
		return userRepository.findAll();
	}

	public Person save(Person user) {
		return userRepository.save(user);
	}

	public void save(List<Person> users) {
		userRepository.save(users);
	}

	public void deleteById(long id) {
		userRepository.delete(id);

	}

	public void deleteAll() {
		userRepository.deleteAll();

	}

	public Person findByAge(String age) {
		Iterable<Person> findOne = userRepository.findAll();
		for (Person person : findOne) {
			Person type = (Person) person;
			if(type.getAge().equals(age)) {
				return type;
			}

		}

		return null;
	}

	public Person findById(long id) {
		Person findOne = userRepository.findOne((id));

		return findOne;
	}
}
