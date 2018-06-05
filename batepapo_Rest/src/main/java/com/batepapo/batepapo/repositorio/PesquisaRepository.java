package com.batepapo.batepapo.repositorio;


import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batepapo.batepapo.entidades.Pesquisa;
import com.batepapo.batepapo.entidades.PesquisaKey;
import com.batepapo.batepapo.entidades.RetTop;

@Repository
public interface PesquisaRepository extends CrudRepository<Pesquisa, PesquisaKey>{
	@Query("SELECT NEW com.batepapo.batepapo.entidades.RetTop(count(p.topico), t.nome) FROM Pesquisa p, Topico t WHERE t.id = p.topico GROUP BY p.topico, t.nome")
	List<RetTop>  topicosMaisAcessados();
	
	@Query("SELECT NEW com.batepapo.batepapo.entidades.RetTop(count(p.topico), t.nome) FROM Pesquisa p, Topico t WHERE t.id = p.topico and p.dataHora between ?1 and ?2 GROUP BY p.topico, t.nome")
	List<RetTop>  topicosMaisAcessadosFiltrado(Calendar value1, Calendar value2);
}
