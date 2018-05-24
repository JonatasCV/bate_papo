package com.batepapo.batepapo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.ReactiveRepositoryInformation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batepapo.batepapo.entidades.RespostaContadorAcessos;
import com.batepapo.batepapo.repositorio.AcessoRepository;


@RestController
public class UserController {
	
	@Autowired
	AcessoRepository Ar;
	
		
	@RequestMapping(value="/usuarios-acessos-rede", method=RequestMethod.GET)
	public RespostaContadorAcessos consultaUser(){
		return new RespostaContadorAcessos(Ar.count());
	}
	
}
