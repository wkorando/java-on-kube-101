package com.ibm.developer.hellojavaonkube101service;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {

}
