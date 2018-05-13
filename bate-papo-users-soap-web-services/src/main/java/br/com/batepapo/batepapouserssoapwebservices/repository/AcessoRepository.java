package br.com.batepapo.batepapouserssoapwebservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batepapo.batepapouserssoapwebservices.entity.Acesso;
import br.com.batepapo.batepapouserssoapwebservices.entity.AcessoKey;

@Repository
public interface AcessoRepository extends CrudRepository<Acesso, AcessoKey> {
	
	
}
