package com.petclinic.model.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.petclinic.model.Owner;
import com.petclinic.model.repositories.OwnerRepository;
import com.petclinic.model.repositories.PetRepository;
import com.petclinic.model.repositories.PetTypeRepository;
import com.petclinic.model.services.OwnerService;

public class OwnerJpaSerivce implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	
	public OwnerJpaSerivce(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return  ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		 return ownerRepository.findByLastName(lastName);
	}

}
