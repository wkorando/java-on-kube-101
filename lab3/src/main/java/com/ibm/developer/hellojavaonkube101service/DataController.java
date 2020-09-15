package com.ibm.developer.hellojavaonkube101service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

	private PersonRepo repo;

	public DataController(PersonRepo repo) {
		this.repo = repo;
	}

@GetMapping("/init")
public String init() {
	if (repo.count() > 0) {
		return "Database already initialized";
	} else {
		repo.save(new Person(1, "Billy", "Korando"));
		repo.save(new Person(2, "Patrick", "Mahomes"));
		repo.save(new Person(3, "Travis", "Kelce"));
		return "Database initialized";
	}
}

@GetMapping
public Iterable<Person> findAll() {
	return repo.findAll();
}
}
