package br.com.batepapo.batepapouserssoapwebservices.endpoint;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.batepapo.batepapouserssoapwebservices.dto.InserirChatRequest;
import br.com.batepapo.batepapouserssoapwebservices.dto.InserirChatResponse;
import br.com.batepapo.batepapouserssoapwebservices.entity.Chat;
import br.com.batepapo.batepapouserssoapwebservices.repository.ChatRepository;

@Endpoint
public class ChatEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.batepapo.com/xml/users";
	
	@Autowired
	private ChatRepository repository;
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="inserirChatRequest")
	@ResponsePayload()
	public InserirChatResponse incluirChat(@RequestPayload InserirChatRequest request) throws DatatypeConfigurationException {
		InserirChatResponse response = new InserirChatResponse();
		repository.save(new Chat(request.getCodUsuario1(), request.getCodUsuario1(), request.getTopico(), Calendar.getInstance()));
		GregorianCalendar gregorian = new GregorianCalendar();
		gregorian.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);
		
		response.setDataHora(xmlDate);
		response.setCodUsuario1(request.getCodUsuario1());
		response.setCodUsuario2(request.getCodUsuario2());
		response.setTopico(request.getTopico());
		
		return response;
	}
}

