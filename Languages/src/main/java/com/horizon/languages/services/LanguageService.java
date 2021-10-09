package com.horizon.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.horizon.languages.models.Language;
import com.horizon.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository repo;
	
	// retrieve all
	public List<Language> allLanguages(){
		return repo.findAll();
	}
	
	// retrieve one
	public Language oneLanguage(Long id) {
		Optional<Language> optionalLang = repo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else return null;
	}
	
	// create
	public Language createLanguage(Language l) {
		return repo.save(l);
	}
	
	// update by ID
	public Language updateLanguage(Language l) {
		return repo.save(l);
	}
	
	// delete by ID
	public void deleteLanguage(Long id) {
		repo.deleteById(id);
	}

}
