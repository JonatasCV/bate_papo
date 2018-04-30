package br.com.batepapo.batepapouserssoapwebservices.endpoint;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.batepapo.batepapouserssoapwebservices.dto.AlterarUsuarioRequest;
import br.com.batepapo.batepapouserssoapwebservices.dto.AlterarUsuarioResponse;
import br.com.batepapo.batepapouserssoapwebservices.dto.ExcluirUsuarioRequest;
import br.com.batepapo.batepapouserssoapwebservices.dto.ExcluirUsuarioResponse;
import br.com.batepapo.batepapouserssoapwebservices.dto.IncluirUsuarioRequest;
import br.com.batepapo.batepapouserssoapwebservices.dto.IncluirUsuarioResponse;
import br.com.batepapo.batepapouserssoapwebservices.dto.TodosUsuarioResponse;
import br.com.batepapo.batepapouserssoapwebservices.entity.Usuario;
import br.com.batepapo.batepapouserssoapwebservices.repository.UserRepository;

@Endpoint
public class UsuarioEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.batepapo.com/xml/users";
	
	@Autowired
	private UserRepository repository;
	
	// Implementar retorno de falha
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="incluirUsuarioRequest")
	@ResponsePayload
	public IncluirUsuarioResponse incluirUsuario(@RequestPayload IncluirUsuarioRequest request) {
		IncluirUsuarioResponse response = new IncluirUsuarioResponse();
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(request.getUsuario(), usuario, "codUsuario");
		if(repository.save(usuario)!=null) {
			request.getUsuario().setCodUsuario(usuario.getCodUsuario());
			response.setUsuario(request.getUsuario());
		}
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="alterarUsuarioRequest")
	@ResponsePayload
	public AlterarUsuarioResponse alterarUsuario(@RequestPayload AlterarUsuarioRequest request) {
		AlterarUsuarioResponse response = new AlterarUsuarioResponse();
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(request.getUsuario(), usuario);
		if(repository.save(usuario) != null) {
			response.setUsuario(request.getUsuario());
		}
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="excluirUsuarioRequest")
	@ResponsePayload
	public ExcluirUsuarioResponse excluirUsuario(@RequestPayload ExcluirUsuarioRequest request) {
		ExcluirUsuarioResponse response = new ExcluirUsuarioResponse();
		if(repository.findById(request.getUserid()).isPresent()) {
			repository.deleteById(request.getUserid());
			response.setStatus(true);
		} else {
			response.setStatus(false);
		}
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getTodosUsuariosRequest")
	@ResponsePayload
	public TodosUsuarioResponse getAll() {
		TodosUsuarioResponse response = new TodosUsuarioResponse();
		repository.findAllByOrderByCodUsuarioAsc().forEach(user -> {
			br.com.batepapo.batepapouserssoapwebservices.dto.Usuario dto = new br.com.batepapo.batepapouserssoapwebservices.dto.Usuario();
			BeanUtils.copyProperties(user, dto);
			response.getUsuario().add(dto);
		});
		return response;
	}
	
}
