package com.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
