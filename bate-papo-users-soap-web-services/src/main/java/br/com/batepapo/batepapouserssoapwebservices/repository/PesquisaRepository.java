package br.com.batepapo.batepapouserssoapwebservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batepapo.batepapouserssoapwebservices.entity.Pesquisa;
import br.com.batepapo.batepapouserssoapwebservices.entity.PesquisaKey;

@Repository
public interface PesquisaRepository extends CrudRepository<Pesquisa, PesquisaKey>{
	
}
