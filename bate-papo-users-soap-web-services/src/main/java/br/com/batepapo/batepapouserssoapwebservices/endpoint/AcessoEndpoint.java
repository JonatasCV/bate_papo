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

import br.com.batepapo.batepapouserssoapwebservices.dto.InserirAcessoRequest;
import br.com.batepapo.batepapouserssoapwebservices.dto.InserirAcessoResponse;
import br.com.batepapo.batepapouserssoapwebservices.entity.Acesso;
import br.com.batepapo.batepapouserssoapwebservices.repository.AcessoRepository;

@Endpoint
public class AcessoEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.batepapo.com/xml/users";
	
	@Autowired
	private AcessoRepository repository;
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="inserirAcessoRequest")
	@ResponsePayload()
	public InserirAcessoResponse incluirAcesso(@RequestPayload InserirAcessoRequest request) throws DatatypeConfigurationException {
		InserirAcessoResponse response = new InserirAcessoResponse();
		repository.save(new Acesso(request.getCodUsuario(), Calendar.getInstance()));
		GregorianCalendar gregorian = new GregorianCalendar();
		gregorian.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);
		response.setDataHora(xmlDate);
		response.setCodUsuario(request.getCodUsuario());
		
		return response;
	}
}
