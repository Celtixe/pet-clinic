package com.petclinic.model.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.petclinic.model.Specialty;
import com.petclinic.model.services.SpecialtyService;

@Service
@Profile({"default","map"})
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	@Override
	public Set<Specialty> findAll(){
		return super.findAll();
	}
	
	@Override
	public Specialty findById(Long id) {
		return super.findById(id);
	}
	
	@Override
	public Specialty save(Specialty object) {
		return super.save(object);
	}
	
	@Override
	public void delete(Specialty object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
