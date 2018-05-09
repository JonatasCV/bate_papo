package com.batepapo.batepapo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value="/consultar", method=RequestMethod.GET)
	public String consulta(){
		return "Teste";
		
	}
	
}
