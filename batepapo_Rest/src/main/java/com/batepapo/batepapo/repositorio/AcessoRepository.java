package com.batepapo.batepapo.repositorio;

import java.util.Calendar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batepapo.batepapo.entidades.Acesso;
import com.batepapo.batepapo.entidades.AcessoPk;

@Repository
public interface AcessoRepository extends CrudRepository<Acesso, AcessoPk> {
	@Query("select count(*) from Acesso t where t.dataHora between ?1 and ?2")
	long contador(Calendar value1, Calendar value2);
	
}
