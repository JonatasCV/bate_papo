package br.com.batepapo.batepapouserssoapwebservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.batepapo.batepapouserssoapwebservices.entity.Usuario;

public interface UserRepository extends CrudRepository<Usuario, Long> {
	List<Usuario> findAllByOrderByIdAsc();
}
