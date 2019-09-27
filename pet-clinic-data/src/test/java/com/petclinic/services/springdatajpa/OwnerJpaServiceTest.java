package com.petclinic.services.springdatajpa;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.petclinic.model.Owner;
import com.petclinic.repositories.OwnerRepository;
import com.petclinic.repositories.PetRepository;
import com.petclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
public class OwnerJpaServiceTest {

	private static final String LAST_NAME = "Smith";
	
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerJpaService ownerJpaService;
	
	Owner returnOwner;
	
	@BeforeEach
	void setUp() {
		returnOwner = new Owner();
		returnOwner.setId(1L);
		returnOwner.setLastName(LAST_NAME);
	}
	
	@Test
	void findByLastName() {
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner smith = ownerJpaService.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME,smith.getLastName());
		verify(ownerRepository).findByLastName(any());
	}
	
	@Test
	void findAll() {
		Set<Owner> returnOwnerSet = new HashSet<>();
		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner2.setId(2L);
		returnOwnerSet.add(owner1);
		returnOwnerSet.add(owner2);

		when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
		
		Set<Owner> owners = ownerJpaService.findAll();
		
		assertNotNull(owners);
		assertEquals(2,owners.size());
	}
	
	@Test
	void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner owner = ownerJpaService.findById(1L);
		assertNotNull(owner);
	}
	
	@Test
	void findByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
		Owner owner = ownerJpaService.findById(1L);
		assertNull(owner);
	}
	
	@Test
	void save() {
		Owner ownerToSave = new Owner();
		ownerToSave.setId(2L);
		when(ownerRepository.save(any())).thenReturn(ownerToSave);
		Owner savedOwner = ownerJpaService.save(ownerToSave);
		assertNotNull(savedOwner);
	}
	
	@Test
	void delete() {
		ownerJpaService.delete(returnOwner);
		verify(ownerRepository).delete(any());
	}
	
	@Test
	void deleteById() {
		ownerJpaService.deleteById(1L);
		verify(ownerRepository).deleteById(any());
	}
}
