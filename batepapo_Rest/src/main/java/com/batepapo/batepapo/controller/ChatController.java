package com.batepapo.batepapo.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.batepapo.batepapo.entidades.FiltroDatas;
import com.batepapo.batepapo.entidades.RespostaContadorChats;
import com.batepapo.batepapo.entidades.RetChat;
import com.batepapo.batepapo.repositorio.ChatRepository;


@RestController
public class ChatController {
	
	
	@Autowired
	ChatRepository Ch;
	
	@RequestMapping(value="/chats-realizados", method=RequestMethod.GET)
	public RespostaContadorChats consultaChat(){
		return new RespostaContadorChats(Ch.count());
	}
	
	@RequestMapping(value="/chats-realizados", method=RequestMethod.POST)
	public RespostaContadorChats consultaChatFiltrado(@RequestBody() FiltroDatas data){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(data.getDataInicial());
		Calendar c2 =  Calendar.getInstance();
		c2.setTime(data.getDataFinal());
		return new RespostaContadorChats(Ch.contador(c1,c2));
	}
	
	@RequestMapping(value="/chats-por-usuario", method=RequestMethod.GET)
	public List<RetChat> consultaChatU(){
		return Ch.chatsMaisAcessados();
	}
	
	@RequestMapping(value="/chats-por-usuario", method=RequestMethod.POST)
	public List<RetChat> consultaChatUFiltrado(@RequestBody() FiltroDatas data){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(data.getDataInicial());
		Calendar c2 =  Calendar.getInstance();
		c2.setTime(data.getDataFinal());
		return Ch.chatsMaisAcessadosFiltrado(c1, c2);
	}

}
