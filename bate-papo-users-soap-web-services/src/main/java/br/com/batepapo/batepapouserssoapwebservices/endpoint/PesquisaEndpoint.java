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

import br.com.batepapo.batepapouserssoapwebservices.dto.InserirPesquisaRequest;
import br.com.batepapo.batepapouserssoapwebservices.dto.InserirPesquisaResponse;
import br.com.batepapo.batepapouserssoapwebservices.entity.Pesquisa;
import br.com.batepapo.batepapouserssoapwebservices.repository.PesquisaRepository;

@Endpoint
public class PesquisaEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.batepapo.com/xml/users";
	
	@Autowired
	private PesquisaRepository repository;
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="inserirPesquisaRequest")
	@ResponsePayload()
	public InserirPesquisaResponse incluirPesquisa(@RequestPayload InserirPesquisaRequest request) throws DatatypeConfigurationException {
		InserirPesquisaResponse response = new InserirPesquisaResponse();
		repository.save(new Pesquisa(request.getTopico(), Calendar.getInstance()));
		GregorianCalendar gregorian = new GregorianCalendar();
		gregorian.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);
		response.setDataHora(xmlDate);
		response.setTopico(request.getTopico());
		
		return response;
	}
}
