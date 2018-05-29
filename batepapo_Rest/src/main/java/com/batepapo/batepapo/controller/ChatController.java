package com.batepapo.batepapo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
	

	@RequestMapping(value="/chats-por-usuario", method=RequestMethod.GET)
	public List<RetChat> consultaChatU(){
		return Ch.chatsMaisAcessados();
	}

}
