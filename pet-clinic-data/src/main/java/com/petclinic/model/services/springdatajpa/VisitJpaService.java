package com.petclinic.model.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import com.petclinic.model.Visit;
import com.petclinic.model.repositories.VisitRepository;
import com.petclinic.model.services.VisitService;

public class VisitJpaService implements VisitService {

	private final VisitRepository visitRepository;
	
	public VisitJpaService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
		
	}

}
