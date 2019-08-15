package com.petclinic.model.services;

import java.util.Set;

import com.petclinic.model.Pet;

public interface PetService {


	Pet findById(long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
}
