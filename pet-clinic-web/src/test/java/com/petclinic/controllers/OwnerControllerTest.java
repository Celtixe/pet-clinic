package com.petclinic.controllers;

import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.petclinic.model.Owner;
import com.petclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {

	@Mock
	OwnerService ownerService;
	
	@InjectMocks
	OwnerController controller;
	
	Set<Owner> owners;
	
	MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		owners = new HashSet<>();
		Owner owner1 = new Owner();
		owner1.setId(1L);
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owners.add(owner1);
		owners.add(owner2);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	void listOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners")).andExpect(status().isOk())
			.andExpect(view().name("owners/index"))
			.andExpect(model().attribute("owners",hasSize(2)));
	}
	
	@Test
	void findOwners() throws Exception {
		mockMvc.perform(get("/owners/find"))
			.andExpect(status().isOk())
			.andExpect(view().name("notImplemented"));
		
		verifyZeroInteractions(ownerService);
	}
}
