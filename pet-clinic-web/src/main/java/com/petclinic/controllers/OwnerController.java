package com.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petclinic.services.OwnerService;

@Controller
@RequestMapping("owners")
public class OwnerController {

	private final OwnerService ownerService;
	
	@Autowired
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}


	@RequestMapping({"","/"})
	public String listOwners(Model m) {
		m.addAttribute("owners", ownerService.findAll() );
		return "owners/index";
	}
	
	@RequestMapping("find")
	public String findOwners() {
		return "notImplemented";
	}
}
