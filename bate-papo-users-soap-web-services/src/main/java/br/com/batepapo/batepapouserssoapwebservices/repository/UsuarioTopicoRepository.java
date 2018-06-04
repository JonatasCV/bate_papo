package br.com.batepapo.batepapouserssoapwebservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batepapo.batepapouserssoapwebservices.entity.UsuarioTopico;
import br.com.batepapo.batepapouserssoapwebservices.entity.UsuarioTopicoKey;

@Repository
public interface UsuarioTopicoRepository extends CrudRepository<UsuarioTopico, UsuarioTopicoKey> {
	
	
}
