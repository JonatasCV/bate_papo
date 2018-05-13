package br.com.batepapo.batepapouserssoapwebservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.batepapo.batepapouserssoapwebservices.entity.Chat;
import br.com.batepapo.batepapouserssoapwebservices.entity.ChatKey;

@Repository
public interface ChatRepository extends CrudRepository<Chat, ChatKey>{

}
