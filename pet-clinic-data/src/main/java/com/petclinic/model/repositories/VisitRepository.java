package com.petclinic.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
