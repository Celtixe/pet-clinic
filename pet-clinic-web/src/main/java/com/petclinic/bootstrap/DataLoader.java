package com.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.model.Vet;
import com.petclinic.model.services.OwnerService;
import com.petclinic.model.services.PetTypeService;
import com.petclinic.model.services.VetService;


@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}






	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Dog");
		PetType savedCatPetType = petTypeService.save(cat);
		
		
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Fiona");
		owner1.setLastName("Gleanna");
		owner1.setAddress("henshaw street");
		owner1.setCity("London");
		owner1.setTelephone("9123409234");
		
		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner1);
		fionasPet.setName("Otto");
		fionasPet.setBirthDate(LocalDate.now());
		
		ownerService.save(owner1);
		
		
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Michael");
		owner2.setLastName("Westeros");
		owner2.setAddress("Dzikowska 42");
		owner2.setCity("Warszawa");
		owner2.setTelephone("492718234");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner2);
		mikesPet.setName("Rocco");
		mikesPet.setBirthDate(LocalDate.now());
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners...");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets...");

	}

}
