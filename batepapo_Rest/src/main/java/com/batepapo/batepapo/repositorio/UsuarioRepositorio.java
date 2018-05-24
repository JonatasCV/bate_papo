package com.batepapo.batepapo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.batepapo.batepapo.entidades.Usuario;
@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

}
