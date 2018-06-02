package br.com.batepapo.batepapouserssoapwebservices.endpoint;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

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
import br.com.batepapo.batepapouserssoapwebservices.dto.LoginTopicosInteresseRequest;
import br.com.batepapo.batepapouserssoapwebservices.dto.LoginTopicosInteresseResponse;
import br.com.batepapo.batepapouserssoapwebservices.entity.Acesso;
import br.com.batepapo.batepapouserssoapwebservices.entity.Usuario;
import br.com.batepapo.batepapouserssoapwebservices.entity.UsuarioTopico;
import br.com.batepapo.batepapouserssoapwebservices.repository.AcessoRepository;
import br.com.batepapo.batepapouserssoapwebservices.repository.UserRepository;
import br.com.batepapo.batepapouserssoapwebservices.repository.UsuarioTopicoRepository;

@Endpoint
public class AcessoEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.batepapo.com/xml/users";
	
	@Autowired
	private AcessoRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UsuarioTopicoRepository userTopicoRepository;
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="inserirAcessoRequest")
	@ResponsePayload()
	public InserirAcessoResponse incluirAcesso(@RequestPayload InserirAcessoRequest request) throws DatatypeConfigurationException {
		InserirAcessoResponse response = new InserirAcessoResponse();
		Optional<Usuario> findById = userRepository.findById(request.getCodUsuario());
		repository.save(new Acesso(findById.get(), Calendar.getInstance()));
		GregorianCalendar gregorian = new GregorianCalendar();
		gregorian.setTimeInMillis(Calendar.getInstance().getTimeInMillis());
		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorian);
		response.setDataHora(xmlDate);
		response.setCodUsuario(request.getCodUsuario());
		
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="loginTopicosInteresseRequest")
	@ResponsePayload()
	public LoginTopicosInteresseResponse interesse(@RequestPayload LoginTopicosInteresseRequest request) {
		LoginTopicosInteresseResponse response = new LoginTopicosInteresseResponse();

			request.getTopicos().forEach(topico -> {
				UsuarioTopico ut = new UsuarioTopico();
				ut.setCodUsuario(request.getCodUsuario());
				ut.setIdTopico(topico);
				userTopicoRepository.save(ut);
			});
			response.setStatus(true);
		
		return response;
	}
}
