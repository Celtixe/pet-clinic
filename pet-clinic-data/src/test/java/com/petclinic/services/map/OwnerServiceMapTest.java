package com.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.petclinic.model.Owner;
import com.petclinic.services.map.OwnerServiceMap;
import com.petclinic.services.map.PetServiceMap;
import com.petclinic.services.map.PetTypeServiceMap;

public class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	final Long ownerId = 1L;
	final String lastName = "Smith";
	
	@BeforeEach
	void setUp() {
		Owner owner1 = new Owner();
		owner1.setId(ownerId);
		owner1.setLastName("Smith");
		
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
		ownerServiceMap.save(owner1);
	}
	
	@Test
	void findAll() {
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(1,ownerSet.size());
	}
	
	@Test
	void findById() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId,owner.getId());
		
	}
	
	@Test
	void saveExistingId() {
		Long id = 2L;
		Owner owner2 = new Owner();
		owner2.setId(id);
		Owner savedOwner = ownerServiceMap.save(owner2);
		assertEquals(id,savedOwner.getId());
		
	}
	
	@Test
	void saveNoId() {
		Owner owner2 = new Owner();
		Owner savedOwner = ownerServiceMap.save(owner2);
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void delete() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}
	
	@Test
	void deleteById() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}
	
	@Test
	void findByLastName() {
		Owner smith = ownerServiceMap.findByLastName(lastName);
		assertNotNull(smith);
		assertEquals(ownerId,smith.getId());
	}
	
	@Test
	void findByLastNameNotFound() {
		Owner smith = ownerServiceMap.findByLastName("foo");
		assertNull(smith);
		
	}
}
