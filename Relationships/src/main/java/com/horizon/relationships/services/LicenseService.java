package com.horizon.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.horizon.relationships.models.License;
import com.horizon.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private final LicenseRepository repo;
	public LicenseService(LicenseRepository r) {
		this.repo = r;
	}
	
    // return all
	public List<License> allLicenses(){
		return repo.findAll();
	}

    // retrive one
	public License oneLicense(Long id) {
		Optional<License> optionalLic = repo.findById(id);
		if(optionalLic.isPresent()) {
			return optionalLic.get();
		} else return null;
	}

    // create
	public License createLicense(License l) {
		return repo.save(l);
	}

    // update one by ID
	public License updateLicense(License l) {
		return repo.save(l);
	}

    // delete one by ID
	public void deleteLicense(Long id) {
		repo.deleteById(id);
	}

}
