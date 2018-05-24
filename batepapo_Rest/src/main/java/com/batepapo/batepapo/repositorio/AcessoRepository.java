package com.batepapo.batepapo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batepapo.batepapo.entidades.Acesso;
import com.batepapo.batepapo.entidades.AcessoPk;

@Repository
public interface AcessoRepository extends CrudRepository<Acesso, AcessoPk> {
	
	
}
