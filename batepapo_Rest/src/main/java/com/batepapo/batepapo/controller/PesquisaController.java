package com.batepapo.batepapo.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batepapo.batepapo.entidades.FiltroDatas;
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
	
	@RequestMapping(value="/topicos-mais-acessados", method=RequestMethod.POST)
	public List<RetTop> consultaUserFiltrado(@RequestBody() FiltroDatas data){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(data.getDataInicial());
		Calendar c2 =  Calendar.getInstance();
		c2.setTime(data.getDataFinal());
		return Ps.topicosMaisAcessadosFiltrado(c1, c2);
	}

}
