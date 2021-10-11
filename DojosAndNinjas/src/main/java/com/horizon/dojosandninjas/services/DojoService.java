package com.horizon.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizon.dojosandninjas.models.Dojo;
import com.horizon.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository repo;
	
    // return all
	public List<Dojo> allDojos(){
		return repo.findAll();
	}

    // retrive one
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = repo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else return null;
	}

    // create
	public Dojo createDojo(Dojo d) {
		return repo.save(d);
	}

    // update one by ID
	public Dojo updateDojo(Dojo d) {
		return repo.save(d);
	}

    // delete one by ID
	public void deleteDojo(Long id) {
		repo.deleteById(id);
	}

}
