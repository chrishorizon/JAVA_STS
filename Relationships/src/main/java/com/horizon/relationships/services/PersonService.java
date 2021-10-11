package com.horizon.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.horizon.relationships.models.Person;
import com.horizon.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository repo;
	public PersonService(PersonRepository r) {
		this.repo = r;
	}
	
    // return all
	public List<Person> allPersons(){
		return repo.findAll();
	}

    // retrive one
	public Person onePerson(Long id) {
		Optional<Person> optionalExp = repo.findById(id);
		if(optionalExp.isPresent()) {
			return optionalExp.get();
		} else return null;
	}

    // create
	public Person createPerson(Person p) {
		return repo.save(p);
	}

    // update one by ID
	public Person updatePerson(Person p) {
		return repo.save(p);
	}

    // delete one by ID
	public void deletePerson(Long id) {
		repo.deleteById(id);
	}

}
