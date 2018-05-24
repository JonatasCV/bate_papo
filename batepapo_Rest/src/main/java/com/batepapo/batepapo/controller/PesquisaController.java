package com.batepapo.batepapo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batepapo.batepapo.entidades.RetTop;
import com.batepapo.batepapo.repositorio.PesquisaRepository;


@RestController
public class PesquisaController {
	
	@Autowired
	PesquisaRepository Ps;
	
	
	@RequestMapping(value="/topicos-mais-acessados", method=RequestMethod.GET)
	public List<RetTop> consultaUser(){
		return Ps.topicosMaisAcessados();
	}

}
