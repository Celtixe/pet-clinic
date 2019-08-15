package com.petclinic.model.services;

import java.util.Set;

import com.petclinic.model.Vet;

public interface VetService {

	 Vet findById(long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}
