package com.horizon.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.horizon.dojosandninjas.models.Ninja;
import com.horizon.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository repo;
	public NinjaService(NinjaRepository n) {
		this.repo = n;
	}
	
    // return all
	public List<Ninja> allNinjas() {
		return repo.findAll();
	}

    // retrive one
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optN = repo.findById(id);
		if(optN.isPresent()) {
			return optN.get();
		} else return null;
	}

    // create
	public Ninja createNinja(Ninja n) {
		return repo.save(n);
	}

    // update one by ID
	public Ninja UpdateNinja(Ninja n) {
		return repo.save(n);
	}

    // delete one by ID
	public void deleteNinja(Long id) {
		repo.deleteById(id);
	}

}
