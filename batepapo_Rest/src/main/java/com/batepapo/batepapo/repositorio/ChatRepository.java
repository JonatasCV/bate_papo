package com.batepapo.batepapo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batepapo.batepapo.entidades.Chat;
import com.batepapo.batepapo.entidades.ChatKey;
import com.batepapo.batepapo.entidades.RetChat;


@Repository
public interface ChatRepository extends CrudRepository<Chat, ChatKey>{
	@Query("select NEW com.batepapo.batepapo.entidades.RetChat(( select count(t.codUsuario1) from Chat t where t.codUsuario1=u.codUsuario or t.codUsuario2=u.codUsuario), u.nome) from  Usuario u")
	List<RetChat> chatsMaisAcessados();
}
