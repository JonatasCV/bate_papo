package com.batepapo.batepapo.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batepapo.batepapo.entidades.FiltroDatas;
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
	
	@RequestMapping(value="/usuarios-acessos-rede", method=RequestMethod.POST)
	public RespostaContadorAcessos consultaUserFiltrado(@RequestBody() FiltroDatas data){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(data.getDataInicial());
		Calendar c2 =  Calendar.getInstance();
		c2.setTime(data.getDataFinal());
		return new RespostaContadorAcessos(Ar.contador(c1, c2));
	}
	
}
