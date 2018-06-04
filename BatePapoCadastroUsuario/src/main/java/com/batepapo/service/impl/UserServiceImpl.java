package com.batepapo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.batepapo.service.UserService;
import com.batepapo.ws.AlterarUsuarioRequest;
import com.batepapo.ws.AlterarUsuarioResponse;
import com.batepapo.ws.ExcluirUsuarioRequest;
import com.batepapo.ws.ExcluirUsuarioResponse;
import com.batepapo.ws.IncluirUsuarioRequest;
import com.batepapo.ws.IncluirUsuarioResponse;
import com.batepapo.ws.TodosUsuarioResponse;
import com.batepapo.ws.Usuario;
import com.batepapo.ws.UsuariosPort;
import com.batepapo.ws.UsuariosPortService;

@Service
public class UserServiceImpl implements UserService {
	
	// Instancia do serviço 
	UsuariosPortService service = new UsuariosPortService();
	UsuariosPort usuariosPortSoap11 = service.getUsuariosPortSoap11();

	@Override
	public Usuario save(Usuario entity) {
		IncluirUsuarioRequest incluirUsuarioRequest = new IncluirUsuarioRequest();
		// Seta o usuario no request
		incluirUsuarioRequest.setUsuario(entity);
		IncluirUsuarioResponse incluirUsuario = usuariosPortSoap11.incluirUsuario(incluirUsuarioRequest);
		return incluirUsuario.getUsuario();
	}

	@Override
	public Usuario update(Usuario entity) {
		AlterarUsuarioRequest request = new AlterarUsuarioRequest();
		request.setUsuario(entity);
		AlterarUsuarioResponse alterarUsuario = usuariosPortSoap11.alterarUsuario(request);
		return alterarUsuario.getUsuario();
	}

	@Override
	public Boolean delete(Long id) {
		ExcluirUsuarioRequest excluirUsuarioRequest = new ExcluirUsuarioRequest();
		excluirUsuarioRequest.setCodUsuario(id);
		ExcluirUsuarioResponse excluirUsuario = usuariosPortSoap11.excluirUsuario(excluirUsuarioRequest);
		return excluirUsuario.isStatus();
	}

	@Override
	public List<Usuario> findAll() {
		TodosUsuarioResponse todosUsuario = usuariosPortSoap11.todosUsuario(null);
		return todosUsuario.getUsuario();
	}
}
