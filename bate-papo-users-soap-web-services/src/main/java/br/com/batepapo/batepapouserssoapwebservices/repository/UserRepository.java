package br.com.batepapo.batepapouserssoapwebservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batepapo.batepapouserssoapwebservices.entity.Usuario;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
	List<Usuario> findAllByOrderByCodUsuarioAsc();
}
