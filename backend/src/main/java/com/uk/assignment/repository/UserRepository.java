package com.uk.assignment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uk.assignment.domain.Person;

public interface UserRepository extends CrudRepository<Person, Long> {

	List<Person> findByAge(int age);


}
